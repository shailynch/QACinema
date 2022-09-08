const movieURL = "http://localhost:8080";
const main = document.getElementById('main');

const readAllMovies = () => {
    fetch(`${movieURL}/movie/all`)
       .then(response => response.json())
       .then(model => model.forEach(e => {

        function ageRating() {
            let ageRate = e.ageRating.toUpperCase();
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
        
            <div class="col">
                <div class="card shadow-sm">
                    <section class="movie-details">
                        <div class="movie-img" id="image-section">
                            <a href="./individualFilm.html?${e.id}">
                                <img class="img" src=${e.posterUrl} />
                            </a>
                        </div>

                        <div class="movie-info" id="film-title">
                            <span class="movie-name">${e.title}</span>
                            <br />
                            <img class="age-rating-logo" src=${ageRating()} />
                                <div class="about-movie post-line text-capitilsed">
                                    ${e.runtime} Mins | ${e.genre} | Released: ${e.releaseDate}
                                </div>       
                                <div class="post-line text-capitilsed">
                                    <span>Cast: </span>${e.cast} <br/>  
                                </div>
                                <div class="post-line">
                                    <p class="movie-desc">${e.description}</p>
                                </div>
                                <div class="about-movie show-times">
                                    <br/>
                                    <span><strong>Show Times: </strong></span><br/>
                                    <p>
                                    Monday:
                                    <br/>
                                    Tuesday:
                                    <br/>
                                    Wednesday:
                                    <br/>
                                    Thursday:
                                    <br/>
                                    Friday:
                                    <br/>
                                    Saturday:
                                    <br/>
                                    Sunday:
                                    </p>
                                </div>
                        </div>
                    </section>
                </div>
            </div>
            <br />
            `
        main.appendChild(movieEl);

       }))
       .catch(err => 
        console.error(`error ${err}`));
    };

    readAllMovies();