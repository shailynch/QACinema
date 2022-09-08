'use strict';
const viewingURL = "http://18.132.36.167:8080/viewing";


const addViewing = () => {
	const _movie_id = document.querySelector("#newViewingMovieID");
	const _screen_id = document.querySelector("#newViewingScreenID");
	const _start_time = document.querySelector("#newViewingStartTime");
    const viewingMovieId  = _movie_id.value;
    const viewingSceenId  = _screen_id.value;
	const viewingStartTime  = _start_time.value;
    
    let data = { 
        "screenID": viewingMovieId,
	    "movieID": viewingSceenId,
	    "startTime":viewingStartTime,
    } 
    

    fetch(`${viewingURL}/add`, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model);
            allFromViewing();
        })
        .catch(err => console.error(`error ${err}`));
};


const updateViewing = () => {
	const _viewing_id= document.querySelector("#existingViewingId");
	const _movie_id = document.querySelector("#existingViewingMovieID");
	const _screen_id = document.querySelector("#existingViewingScreenID");
	const _start_time = document.querySelector("#existingViewingStartTime");
	const existingViewingId = _viewing_id.value;
    const viewingMovieId  = _movie_id.value;
    const viewingSceenId  = _screen_id.value;
	const viewingStartTime  = _start_time.value;
    
    let data = { 
		"id": existingViewingId,
        "screenID": viewingMovieId,
	    "movieID": viewingSceenId,
	    "startTime":viewingStartTime,
    } 
 window.alert(data.id);
	fetch(`${viewingURL}/update/${data.id}`, {
	        method: "PUT",
	        body: JSON.stringify(data),
	        headers: {
	            "Content-Type": "application/json"
	        }
	    })
	        .then(response => response.json())
	        .then(model => {
	            console.log(model);
	            allFromViewing();
	        })
	        .catch(err => console.error(`error ${err}`));
	    
 };
 
const readViewings = () => {
	 let html = " ";
	fetch(`${viewingURL}/all`)
     .then((response) => {
         if (response.status !== 200) {
             console.log(`Looks like there was a problem.Status Code: ${ response.status }`);
             return;
         }
     response.json()
     .then(viewings => viewings.forEach(viewing => {
		 html = html + `
        <li class="row">
                <p>
                   viewing ID: ${viewing.id}
                    Movie ID: ${viewing.movieID}
                   Screen : ${viewing.screenID}
                   Start Time : ${viewing.startTime}
                   
                </p>
        </li>
        `
        document.getElementById("displayViewings").innerHTML = html;
}))
     .catch(err => console.error(`Fetch Error :-S ${err}`));
     });
}
readViewings();

const deleteViewing= () => {
	const _viewing_id = document.querySelector("#id");

	const viewingID = _viewing_id.value;
    	
    let data = { 
		"id": viewingID,
    } 
    
	fetch(`${viewingURL}/delete/${data.id}`, {
	        method: "DELETE",
	        body: JSON.stringify(data),
	        headers: {
	            "Content-Type": "application/json"
	        }
	    })
	        .then(response => response.json())
	        .then(model => {
	            console.log(model);
	            allFromViewing();
	        })
	        .catch(err => console.error(`error ${err}`));
}