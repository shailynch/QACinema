 	
 	let id = window.location.search.slice(1);
    let thread = threads.find(t => t.id == id);
    
    let today = new Date();
	let currentTime = today.getHours() + ":" + today.getMinutes();
	let currentDate = today.getDate()+ '-' + (today.getMonth()+1)+'-'+today.getFullYear();
	let dateTime = currentDate+' '+currentTime;
		
		
    let header = document.querySelector('.header');
    let headerHtml = `
        <h4 class="title">
            ${thread.title}
        </h4>
        <div class="bottom">
            <p class="timestamp">
                ${new Date(thread.date).toLocaleString()}
            </p>
            <p class="comment-count">
                ${thread.comments.length} comments
            </p>
        </div>
    `
    header.insertAdjacentHTML('beforeend', headerHtml)

    function addComment(comment) {
        let commentHtml = `
            <div class="comment">
                <div class="top-comment">
                    <p class="user">
                        ${comment.author}
                    </p>
                    <p class="comment-ts">
                        ${new Date(comment.date).toLocaleString()}
                    </p>
                </div>
                <div class="comment-content">
                    ${comment.content}
                </div>
            </div>
        `
        comments.insertAdjacentHTML('beforeend', commentHtml);
    }

    let comments = document.querySelector('.comments');
    for (let comment of thread.comments) {
        addComment(comment);
    }

    let btn = document.querySelector('button');
    btn.addEventListener('click', function() {
        let txt = document.querySelector('textarea');
        let comment = {
            content: txt.value,
            date: Date.now(),
            author: 'Anonymous User'
        }
        addComment(comment);
        addNewComment(comment);
        dbRefresh();
        txt.value = '';
        thread.comments.push(comment);
        localStorage.setItem('threads', JSON.stringify(threads));
    })
    
   // creating the create function to add a new comment to the comments database table. 
    function addNewComment(){
		
		let threadLoc = "http://localhost:8090";
		let commentTxt = document.querySelector('textarea');
		let newComment = {
			commentContent: commentTxt.value,
			commentCreateTime: dateTime,
			commentAuthor: 'Anonymouse User',
			topicId: id
		}
		fetch(`${threadLoc}/comments/add` , {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(newComment)
	
	})
	.then(res => res.json())
	.then(data => console.log(data))
	.catch(err => console.err(err))
	}
	
	// creating the read function to retireve all past comments from the comments database table
	function readDbComments(){
		let threadLoc = "http://localhost:8090";
		fetch(`${threadLoc}/comments/all${id}`)
		.then((response) => {
			response.json()
			console.log(response);
			
			if(response.status !==200){
				console.error(`status: ${response.status}`);
				return;		
			}
			
		// bug with printing out other comments from db, will fix later if time permits.	
		//	for (let dbCom of response){
		//	addComment(dbCom);
		//	}
			//.then(data => console.log(data))
			
			
		}).catch((err) => console.error(`${err}`));
		

	}
	
	function dbRefresh(){
		readDbComments();
		setTimeout(dbRefresh, 25000);
	}
	
	dbRefresh();
		