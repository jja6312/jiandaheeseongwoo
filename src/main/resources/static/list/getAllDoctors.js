let doctors = [];

axios.get("/api/doctor")
    .then(res => {
        console.log(res.data)
        doctors = res.data;
        doctors.forEach(doctor => {
            
        // doctors를 순회하며, td추가
        var doctorTableRow = `
        <tr class="doctorRow">
        <td class="id">${doctor.doctorId}</td>
        <td class="profileImageUrl"><img src="${doctor.profileImageUrl}" class="profileImage"></td>
        <td  class="name">${doctor.name}</td>
        <td  class="age">${doctor.age}</td>
        <td  class="specialtyCode">${doctor.specialtyCode}</td>
        <td  class="specialtyName">${doctor.specialtyName}</td>
        <td  class="experienceYears">${doctor.experienceYears}</td>
        <td class="btnContainer">
            <button class="btn editBtn">수정</button>
            <button class="btn deleteBtn">삭제</button>
        </td>
        </tr>
        `;
        $(".tbody").append(doctorTableRow);

        });
    }).catch(e => {
        console.log(e);
    })

