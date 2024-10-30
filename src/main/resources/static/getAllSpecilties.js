let specialties = {};
axios.get("/api/specialty")
.then(res=>{
	specialties = res.data;
	console.log(specialties);
	specialties.forEach(specialty =>{

		$("#doctor_specialty_code").append(`<option id="${specialty.specialtyCode}" value="${specialty.specialtyCode}">${specialty.specialtyName}</option>`)
	})
})
.catch(e=>{
	console.log(e);
})