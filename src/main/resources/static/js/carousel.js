const loadCarousel = () => {
		const filmURL = "http://18.132.36.167:8080/movie";
	 let html = " ";
	fetch(`${filmURL}/all`)
     .then((response) => {
         if (response.status !== 200) {
             console.log(`Looks like there was a problem.Status Code: ${ response.status }`);
             return;
         }
     response.json()
     .then(movies => movies.forEach(movie => {
		if(movie.new_release == true ){
			html = html + ` 
	          
	              <div class="carousel-item">
	                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" /></svg>
	        
	                <div class="container">
	                  <div class="carousel-caption text-start">
	                    <h1>${movie.title}.</h1>
	                    <p>${movie.description}</p>
	                    <p><a class="btn btn-lg btn-primary" href="./individualFilm.html?${e.id}">
                                <img class="img" src=${e.posterUrl} />
                            </a></p>
	                  </div>
	                </div>
	              </div>
	            
	`	
		}
 
 
        document.getElementById("newReleases").innerHTML = html;
}))
     .catch(err => console.error(`Fetch Error :-S ${err}`));
     });
}
	   readFilms();
