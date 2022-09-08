const movieURL = "http://18.132.36.167:8080/";

let id = window.location.search.slice(1);
let main = document.querySelector('#main');

const readOneMovie = () => {
    fetch(`${movieURL}/movie/${id}`)
       .then(response => response.json())
       .then(model =>  {

        function ageRating() {
            let ageRate = model.ageRating.toUpperCase();
            if(ageRate === "U"){
                return "./images/Classification-Logos/U-class-dark.jpg";
            } else if (ageRate === "PG"){
                return "./images/Classification-Logos/PG-class-dark.jpg";
            } else if (ageRate === "12"){
                return "./images/Classification-Logos/12A-class-dark.jpg";
            } else if (ageRate === "12A"){
                return "./images/Classification-Logos/12A-class-dark.jpg";
            } else if (ageRate === "15"){
                return "./images/Classification-Logos/15-class-dark.jpg";
            } else if (ageRate === "18"){
                return "./images/Classification-Logos/18-class-dark.jpg";
            } else {
                return "./images/Classification-Logos/R18-class-dark.jpg";
            };
        }

        let movieEl = document.createElement('div');
        movieEl.classList.add('movie');
        movieEl.innerHTML = `
        <section class="py-5 text-center container">
            <div class="row py-lg-5">
                <div class="col-lg-6 col-md-8 mx-auto">
                <div class="movie-info" id="film-title">
                <span class="movie-name">${model.title}</span>
                <br />
                <br />
                <img class="age-rating-logo" src=${ageRating()} />
                </div>
                </div>
            </div>
        </section>

        <div class="container">
            <div class="panel">
                <div class="panel-body">
                    <div class="panel-left">
                        <img class="img" src=${model.posterUrl} />
                        <button class="fw-7" onclick="location.href='booking.html';"><strong>BOOK</strong></button>
                    </div>
                    <div class="panel-right">
                        <h3>Show Times: </h3>
                        <br />
                        <br />
                        <div class="panel-text">
                            <p>Monday: </p>
                            <p>Tuesday: </p>
                            <p>Wednesday: </p>
                            <p>Thursday: </p>
                            <p>Friday: </p>
                            <p>Saturday: </p>
                            <p>Sunday: </p>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <div class="movie-info" id="film-title">	
                        <p class="about-movie post-line text-capitilsed"><strong>Runtime: </strong>${model.runtime} | <strong>Genre: </strong>${model.genre} | <strong>Released: </strong>${model.releaseDate}</p>
                        <br />
                            <p class="movie-desc">Plot: ${model.description}</p>
                        <br />
                        <br />
                        <div class="extra-img-container">
                            <img class="additional-img" src=${model.filmImg1} />
                            <img class="additional-img" src=${model.filmImg2} />
                            <img class="additional-img" src=${model.filmImg3} />
                        </div>
                    </div>
                </div>
		    </div>
        </div>
            `
        main.appendChild(movieEl);

       })
       .catch(err => 
        console.error(`error ${err}`));
    };

    readOneMovie();