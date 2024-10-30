$(document).on("click", ".editCompleteBtn", function () {
    const id = $(this).closest(".doctorRow").find(".id").find("input").val();
	const name = $(this).closest(".doctorRow").find(".name").find("input").val();
	const age = $(this).closest(".doctorRow").find(".age").find("input").val();
	const specialtyCode = $(this).closest(".doctorRow").find(".specialtyCode").find("input").val();
	const specialtyName = $(this).closest(".doctorRow").find(".specialtyName").find("input").val();
	const experienceYears = $(this).closest(".doctorRow").find(".experienceYears").find("input").val();
    let doctor = {
        doctorId: id,
        name,
        age,
        specialtyCode,
        specialtyName,
        experienceYears   
    }

    axios.put(`/api/doctor/${id}`, doctor)
        .then(res => {
            console.log(res.data);
            location.reload();
        }).catch(e => {
            console.log(e);
        });
});