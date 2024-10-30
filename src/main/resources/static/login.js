const loginId = document.querySelector("#login_id");
const loginPw = document.querySelector("#login_pw");
const loginImage = document.querySelector("#login_form_image");

const loginIdValidation = document.querySelector("#login_id_validation");
const loginPwValidation = document.querySelector("#login_pw_validation");

const validateLogin = (e) => {
    const idRegex = /^[a-zA-Z0-9]{3,20}$/;
    const pwRegex =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,20}$/;

    if (e.target.id === "login_id") {
        if (!idRegex.test(loginId.value)) {
            loginIdValidation.innerText =
                "😡 로그인 ID는 3~20자의 영문자 또는 숫자여야 합니다.";
            loginImage.src = "/image/login/doctor1.png";
        } else {
            loginIdValidation.innerText = "";
            loginImage.src = "/image/login/doctor3.png";
        }
    }

    if (e.target.id === "login_pw") {
        if (!pwRegex.test(loginPw.value)) {
            loginPwValidation.innerText =
                "😡 비밀번호는 6~20자여야 하며, 대문자, 소문자, 숫자, 특수문자를 포함해야 합니다.";
            loginImage.src = "/image/login/doctor1.png";
        } else {
            loginPwValidation.innerText = "";
            loginImage.src = "/image/login/doctor3.png";
        }
    }
};

loginId.addEventListener("input", validateLogin);
loginPw.addEventListener("input", validateLogin);
