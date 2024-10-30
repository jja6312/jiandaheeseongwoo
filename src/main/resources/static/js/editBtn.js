$(document).on("click",".editBtn", function() {
	const id = $(this).closest(".doctorRow").find(".id").text();
	const name = $(this).closest(".doctorRow").find(".name").text();
	const age = $(this).closest(".doctorRow").find(".age").text();
	const specialtyCode = $(this).closest(".doctorRow").find(".specialtyCode").text();
	const specialtyName = $(this).closest(".doctorRow").find(".specialtyName").text();
    const experienceYears = $(this).closest(".doctorRow").find(".experienceYears").text();
    $(this).closest(".doctorRow").find(".id").html(`<input class="editInput id" value="${id}" readOnly style="background-color:rgb(198, 198, 198)">`);
    $(this).closest(".doctorRow").find(".name").html(`<input class="editInput name" value="${name}">`);
    $(this).closest(".doctorRow").find(".age").html(`<input class="editInput age" value="${age}">`);
    $(this).closest(".doctorRow").find(".specialtyCode").html(`<input class="editInput specialtyCode" value="${specialtyCode}">`);
    $(this).closest(".doctorRow").find(".specialtyName").html(`<input class="editInput specialtyName" value="${specialtyName}" readOnly style="background-color:rgb(198, 198, 198)">`);
    $(this).closest(".doctorRow").find(".experienceYears").html(`<input class="editInput experienceYears" value="${experienceYears}">`);
    
    $(this).closest(".doctorRow").find(".btnContainer").html(`
        <button class="btn editCompleteBtn">수정완료</button>
        <button class="btn cancleBtn">취소</button>`);

});