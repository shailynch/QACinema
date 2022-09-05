const movieURL = "http://localhost:8080"

const readAllMovies = () => {
    fetch(`${movieURL}/movie/all`)
       .then(response => response.json())
       .then(model => model.forEach(e => {
        console.log(e);
       }))
       .catch(err => 
        console.error(`error ${err}`));
    };

    readAllMovies();