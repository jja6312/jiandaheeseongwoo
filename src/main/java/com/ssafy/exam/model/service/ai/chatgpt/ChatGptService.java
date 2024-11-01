package com.ssafy.exam.model.service.ai.chatgpt;

import com.ssafy.exam.config.ai.chatgpt.AiChatGptConfig;
import jakarta.annotation.PostConstruct;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Service
public class ChatGptService {
    @Autowired
    private AiChatGptConfig aiConfig;
    public String summary;

    @Value("${openai.api.api-key}")
    private String OPENAI_API_KEY;

    @Value("${openai.api.gpt.end-point}")
    private String GPT_API_ENDPOINT;

    // OkHttpClient에 타임아웃 설정 추가
    private OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();


    public String createChat(String message) throws IOException {
        if (OPENAI_API_KEY == null || OPENAI_API_KEY.isEmpty()) {
            throw new IllegalStateException("API key is not set.");
        }

        String prompt = message;

        // JSON 객체를 생성하여 안전하게 JSON 문자열을 구성합니다.
        JSONObject json = new JSONObject();
        json.put("model", "gpt-3.5-turbo");  // 또는 사용하려는 다른 모델 이름
        json.put("messages", new JSONArray()
                .put(new JSONObject()
                        .put("role", "system")
                        .put("content", aiConfig.getConsultationPrompt()))
                .put(new JSONObject()
                        .put("role", "user")
                        .put("content", prompt))
        );
        json.put("max_tokens", 300);
        json.put("temperature", 0.7);

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                json.toString()
        );

        Request request = new Request.Builder()
                .url(GPT_API_ENDPOINT)  // 하드코딩된 URL 대신 GPT_API_ENDPOINT 사용
                .addHeader("Authorization", "Bearer " + OPENAI_API_KEY.trim())
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            if (!response.isSuccessful()) {
                System.err.println("Summary API request failed with response: " + response);
                System.err.println("Response body: " + responseBody);  // 추가된 디버깅 정보 출력
                throw new IOException("Unexpected code " + response);
            }

            return extractMessageFromChatResponse(responseBody);
        }
    }

    private String extractMessageFromChatResponse(String responseBody) {
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray choices = jsonResponse.optJSONArray("choices");

        if (choices != null && choices.length() > 0) {
            JSONObject messageObject = choices.getJSONObject(0).optJSONObject("message");
            if (messageObject != null) {
                summary =messageObject.optString("content", "No content");
                return summary;
            }
        }

        return "No content available";
    }





    public boolean getMedicationStatus() {
        return summary.contains("true");
    }
}