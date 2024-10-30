$(document).on("click", ".deleteBtn", function () {
    if(confirm("정말 삭제하시겠습니까?")){
        const id = $(this).closest(".doctorRow").find(".id").text();
        axios.delete(`/api/doctor/${id}`)
            .then(res => {
            console.log(res.data);
			location.reload();
            }).catch(e => {
                console.log(e);
        })
    }
    
    
})