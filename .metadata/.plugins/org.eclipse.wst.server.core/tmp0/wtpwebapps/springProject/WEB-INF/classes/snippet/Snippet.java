package snippet;

public class Snippet {
	console.log(bnoVal+" / " +sesId);
	async function postCommentToServer(cmtData){
	    try{
	        const url = "/comment/post";
	        const config={
	            method:"post",
	            headers:{
	                'content-type':'application/json; charset=utf-8'
	            },
	            body:JSON.stringify(cmtData)
	        };
	
	        const resp = await fetch(url, config);
	        const result = await resp.text(); //isOk
	        return result;
	    }catch(err){
	        console.log(err);
	    }
	}
	
	document.getElementById('cmtPostBtn').addEventListener('click',()=>{
	    const cmtText = document.getElementById('cmtText').value;
	    const cmtWriter = document.getElementById('cmtWriter').innerText;
	    if(cmtText =="" || cmtText == null){
	        alert("댓글을 입력해주세요.");
	        document.getElementById('cmtText').focus();
	        return false;
	    }else {
	        let cmtData={
	            bno : bnoVal,
	            writer : cmtWriter,
	            content : cmtText
	        };
	        console.log(cmtData);
	        postCommentToServer(cmtData).then(result => {
	            console.log(result);
	            //isOk 확인
	            if(result == 1){
	                alert('댓글등록 성공~!!');
	                // 화면에 뿌리기
	                getCommentList(bnoVal);
	            }
	        })
	    }
	})
	
	async function spreadCommentListFromServer(bno){
	    try{
	        const resp = await fetch('/comment/'+bno);
	        const result = await resp.json();
	        return result;
	    }catch(err){
	        console.log(err);
	    }
	}
	
	function getCommentList(bno){
	    spreadCommentListFromServer(bno).then(result =>{
	        console.log(result);
	        const ul = document.getElementById('cmtListArea');
	        if(result.length > 0){
	            ul.innerHTML="";
	            for(let cvo of result){
	                let li = `<li data-cno="${cvo.cno}" data-writer=${cvo.writer}><div>`;
	                li+= `<div>${cvo.writer}</div>`;
	                li+= `<input type="text" id="cmtTextMod" value="${cvo.content}"></div>`;
	                li+= `<span>${cvo.reg_date}</span>`;
	                li+= `<button type="button" class="modBtn">%</button>`;
	                li+= `<button type="button" class="delBtn">X</button>`;
	                // if(cvo.writer == sesId){
	                // }
	                li+=`</li>`;
	                ul.innerHTML += li;
	            }
	        }else{
	            let li = `<li>Comment List Empty</li>`;
	            ul.innerHTML = li;
	        }       
	    })
	}
	
	async function editCommentToServer(cmtModData){
	    try{
	        const url = '/comment/'+cmtModData.cno;
	        const config={
	            method:'put',
	            headers:{
	                'content-type':'application/json; charset=utf-8'
	            },
	            body:JSON.stringify(cmtModData)
	        };
	        const resp = await fetch(url, config);
	        const result = await resp.text();
	        return result;
	    }catch(err){
	        console.log(err);
	    }
	}
	

	


