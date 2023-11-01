console.log("boardRegister.js in!!!");

// 트리거 버튼 처리
document.getElementById('trigger').addEventListener('click', () => {
    document.getElementById('files').click();
});

// 실행 파일, 이미지 파일에 대한 정규표현식 작성
const regExp = new RegExp("\\.(exe|sh|bat|js|msi|dll)$"); // 실행 파일 막기
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif)$"); // 이미지 파일만
const maxSize = 1024 * 1024 * 20;

function fileValidation(fileName, fileSize) {
    if (!regExpImg.test(fileName)) {
        return 0;
    } else if (regExp.test(fileName)) {
        return 0;
    } else if (fileSize > maxSize) {
        return 0;
    } else {
        return 1;
    }
}

document.addEventListener('change', (e) => {
    if (e.target.id == 'files') {
        // input file element에 저장된 file의 정보를 가져오는 property
        const fileObject = document.getElementById('files').files; // 여러 개의 파일이 배열로 들어옴
        console.log(fileObject);

        s // 한 번 true로 변경되면 다시 돌아오지 않음.
        // 첨부 파일에 대한 정보를 fileZone에 기록
        let div = document.getElementById('fileZone');
        // 기존 값이 있다면 삭제
        div.innerHTML = '';
        // ul => li로 첨부 파일 추가
        let ul = `<ul class="list-group list-group-flush">`;

        let isOk = 1; // fileValidation 함수의 리턴 여부를 *로 체크 // 여러 개 파일을 모두 검증에 통과해야하기 때문에 *로 각 파일마다 통과 여부 확인
        for (let file of fileObject) {
            let validResult = fileValidation(file.name, file.size); // 0 또는 1로 리턴
            isOk *= validResult; // 모든 파일이 누적되어 *

            ul += `<li class="list-group-item">`;
            // 업로드 가능 여부 표시
            ul += `<div class="mb-3">`
            ul += `${validResult ? '<div class="fw-bold">업로드 가능</div>' : '<div class="fw-bold">업로드 불가능</div>'}</div>`;
            ul += `${file.name}`;
            ul += `<span class="badge rounded-pill bg-${validResult ? 'success' : 'danger'}">${file.size}Byte</span></li>`;
        }
        ul += `</ul>`;
        div.innerHTML = ul;
        if (isOk == 0) { // 첨부 불가능한 파일이 있다는 것을 의미
            document.getElementById('regBtn').disabled = true; // 버튼 비활성화
        }
    }
});
