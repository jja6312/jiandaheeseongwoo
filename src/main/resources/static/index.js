
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

	alert(specialtyCode);
	const requestData = {
		name,
		age,
		specialtyCode,
		experienceYears
	};

	
	try {
		const response = await axios.post(
			"http://localhost:8080/api/doctor",
			requestData
		);
		console.log("등록이 완료되었습니다.");
		location.href="list.html";
	} catch (e) {
		console.log("등록이 완료되지 않았습니다.");
	}
};


registForm.addEventListener("click", handOnSubmitRegistForm);
