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
        console.log(bno)
        const resp = await fetch('/comment/' + bno + '/' + page);
        const result = await resp.json();
        return result

    } catch (err) {
        console.log(err);
    }


}

function getCommentList(bno, page = 1) {

    spreadCommentFormServer(bno, page).then(result => {
        console.log(result);
        if (result.cmtList.length > 0) {
            const ul = document.getElementById('cmtListArea');
            if (page == 1) {
                ul.innerText = "";
            }

            for (let cvo of result.cmtList) {
                let li = `<li class="list-group-item" data-cno="${cvo.cno}" data-writer="${cvo.writer}">`;
                li += `<div class="mb-3">`;
                li += `<div class="fw-bold">${cvo.writer}</div>`;
                li += `${cvo.content}`;
                li += `</div>`;
                li += `<span class="badge rounded-pill text-bg-dark">${cvo.modAt}</span>`;
                li += `<button type="button" class="btn btn-outline-danger mod" data-bs-toggle="modal" data-bs-target="#myModal">e</button>`;
                li += `<button type="button" class="btn btn-outline-warning del">x</button>`;
                li += `</li>`;
                ul.innerHTML += li;


            }

            let moreBtn = document.getElementById('moreBtn');
            console.log(moreBtn);

            if (result.pgvo.page < result.endPage) {
                moreBtn.style.visibility = 'visible';
                moreBtn.dataset.page = page + 1;

            } else {
                moreBtn.style.visibility = 'hidden';
            }

        } else {

            let li = `<li class="list-group-item">Comment List Empty</li>`;
            innerHTML = li;
        }
    }
    );

}



