console.log("댓글 관련 js");


console.log(bnoVal);

getCommentList(bnoVal);


async function postCommentToSesrver(cmtDate) {
    try {
        const url = '/comment/post';
        const config = {
            method: 'post',
            headers: {

                'Content-Type': 'application/json; charset=utf-8'
            },

            body: JSON.stringify(cmtDate)

        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;



    } catch (err) {
        console.log(err);
    }

}
document.getElementById("cmtPostBtn").addEventListener('click', () => {
    const cmtText = document.getElementById('cmtText');
    if (cmtText.value == null || cmtText.value == '') {
        alert('댓글을 입력하세요');
        cmtText.focus();
        return false;
    } else {
        let cmtDate = {
            bno: bnoVal,
            writer: document.getElementById('cmtWriter').innerText,
            content: cmtText.value
        };

        postCommentToSesrver(cmtDate).then(result => {
            if (parseInt(result)) {
                alert("댓글 작성 완료");
                //댓글 비워주기
                document.getElementById('cmtText').value = '';

            }

            getCommentList(cmtDate.bno);


        });
    }
});

async function spreadCommentFormServer(bno, page) {
    try {

        const resp = await fetch('/comment/' + bno + '/' + page);
        const result = await resp.json();
        return result;


    } catch (err) {
        console.log(err);
    }


}

// getCommentList 함수 내에서 ul 변수 정의
function getCommentList(bno, page = 1) {
    const ul = document.getElementById('cmtListArea');
    spreadCommentFormServer(bno, page).then(result => {
        if (result.cmtList.length > 0) {
            if (page == 1) {
                ul.innerHTML = "";
            }

            for (let cvo of result.cmtList) {
                let li = `<li class="list-group-item" data-cno="${cvo.cno}" data-writer="${cvo.writer}">`;
                li += `<div class="mb-3">`;
                li += `<div class="fw-bold">${cvo.writer}</div>`;
                li += `${cvo.content}`;
                li += `</div>`;
                if (cvo.modAt == cvo.regAt) {
                    li += `<span class="badge rounded-pill text-bg-dark">${cvo.modAt}</span>`;

                } else {
                    li += `<span class="badge rounded-pill text-bg-dark">(수정됨)${cvo.modAt}</span>`;
                }
                if(cvo.writer==authEmail){
                li += `<button type="button" class="btn btn-outline-danger mod" data-bs-toggle="modal" data-bs-target="#myModal">e</button>`;
                li += `<button type="button" class="btn btn-outline-warning del">x</button>`;}
                li += `</li>`;
                ul.innerHTML += li;
            }

            let moreBtn = document.getElementById('moreBtn');
            if (result.pgvo.pageNo < result.endPage) {
                moreBtn.style.visibility = 'visible';
                moreBtn.dataset.page = page + 1;

            } else {
                moreBtn.style.visibility = 'hidden';
            }
        } else {
            ul.innerHTML = `<li class="list-group-item">Comment List Empty</li>`;
        }
    })
}

// eraseCommentAtServer 함수 (삭제 버튼을 클릭할 때 실행)
async function eraseCommentAtServer(cno, writer) {
    try {
        const url = '/comment/del/' + cno + '/' + writer;
        const config = {
            method: 'delete'
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (err) {
        console.log(err);
    }
}



document.addEventListener('click', (e) => {
    if (e.target.classList.contains('del')) {
        let li = e.target.closest('li');
        let cnoVal = li.dataset.cno;
        let writerVal = li.dataset.writer;
        console.log(writerVal);
        eraseCommentAtServer(cnoVal, writerVal).then(result => {
            if (result == 1) {
                alert('댓글삭제완료~!!');
                getCommentList(bnoVal);
            } else if (result == 0) {
                alert('작성자가 일치하지 않습니다.');
            }
        })
    } else if (e.target.classList.contains('mod')) {
        let li = e.target.closest('li');
        //nextSibling() : 같은 부모의 다음 형제 객체를 반환
        let cmtText = li.querySelector('.fw-bold').nextSibling;

        //기존내용 모달창에 반영 (수정하기 편하게...)
        document.getElementById('cmtTextMod').value = cmtText.nodeValue;
        //cmtModBtn에 data-cno 달기
        document.getElementById('cmtModBtn').setAttribute('data-cno', li.dataset.cno);
        document.getElementById('cmtTextMod').value = cmtText.textContent;
    } else if (e.target.id == 'cmtModBtn') {
        let cmtDataMod = {
            cno: e.target.dataset.cno,
            content: document.getElementById('cmtTextMod').value
        };
        console.log(cmtDataMod);
        editCommentToServer(cmtDataMod).then(result => {
            if (parseInt(result)) {
                // 모달창 닫기=
                document.querySelector('.btn-close').click();
            }
            getCommentList(bnoVal);
        })
    } else if (e.target.id == 'moreBtn') {
        getCommentList(bnoVal, parseInt(e.target.dataset.page));
    }

})

// editCommentToServere 함수 (댓글 수정 버튼을 클릭할 때 실행)
async function editCommentToServer(cmtDataMod) {
    try {
        const url = '/comment/' + cmtDataMod.cno;
        const config = {
            method: 'put',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtDataMod)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (err) {
        console.log(err);
    }
}
