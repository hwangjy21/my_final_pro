console.log("boardRegister.js in~!!!!!!");
document.getElementById('trigger').addEventListener('click', () => {
  document.getElementById('files').click();
});

const regExp = new RegExp("\.(exe|sh|bat|js|msi|dll)$");
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif)$");

const maxSize = 1023 * 1024 * 20;

function fileValidation(fileName, fileSize) {
    if (regExp.test(fileName)) { // 실행 파일이면...
    
         console.log("들어옴1");
        return 0;
   
    } else if (fileSize > maxSize) {
         console.log("들어2");
        return 0;
    
        
     } else if (regExpImg.test(fileName)) { // 이미지 파일이면...
        console.log("들어31");
        return 1;
    } else { 
         console.log("실패");
        return 1;
    }
}


document.addEventListener('change', (e) => {
  if (e.target.id == 'files') {
    document.getElementById('regBtn').disabled = false;
    const fileObj = document.getElementById('files').files;
    console.log(fileObj);

    let div = document.getElementById('fileZone');
    div.innerHTML = "";

    let isOk = 1;
    let ul = `<ul class="list-group list-group-flush">`;
    for (let file of fileObj) {
      let validResult = fileValidation(file.name, file.size); // 수정: 오타 수정
      isOk *= validResult;
      ul += `<li class="list-group-item d-flex justify-content-between align-items-start">`;
      ul += `<div class="ms-2 me-auto">`;
      ul += `${validResult ? '<div class="fw-bold">업로드 가능</div>' : '<div class="fw-bold text-danger">업로드 불가능</div>'}`;
      ul += `${file.name}</div>`;
      ul += `<span class="badge rounded-pill text-bg-${validResult ? 'success' : 'danger'}">${file.size}Bytes</span></li>`; // 수정: 변수명 수정
    }
    ul += `</ul>`;
    div.innerHTML = ul;

    if (isOk == 0) {
      document.getElementById('regBtn').disabled = true;
    }
  }
});
