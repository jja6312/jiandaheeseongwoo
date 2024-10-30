
document.querySelector("#check_item").addEventListener("click",()=>{
	location.href="list.html";
});


const registForm = document.querySelector("#regist_btn");


const handOnSubmitRegistForm = async (e) => {
	e.preventDefault();

	const name = document.querySelector("#doctor_name").value;
	const age = document.querySelector("#doctor_age").value;
	const specialtyCode = document.querySelector("#doctor_specialty_code").value;
	const experienceYears = document.querySelector("#doctor_experience_years").value;
	const doctorProfileImage = document.querySelector("#doctor_profile_image").files[0];

	// FormData 생성 및 데이터 추가
	const formData = new FormData();
	formData.append("name", name);
	formData.append("age", age);
	formData.append("specialtyCode", specialtyCode);
	formData.append("experienceYears", experienceYears);
	formData.append("image", doctorProfileImage);

	alert(doctorProfileImage);
	console.log(doctorProfileImage);

	
	try {
		const response = await axios.post(
			"http://localhost:8080/api/doctor",
			formData
		);
		console.log("등록이 완료되었습니다.");
		location.href="list.html";
	} catch (e) {
		console.log("등록이 완료되지 않았습니다.");
	}
};


registForm.addEventListener("click", handOnSubmitRegistForm);
