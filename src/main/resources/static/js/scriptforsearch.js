document.querySelector('#search').addEventListener("click", getFilmByTitle);

function getFilmByTitle(e){
    const id = document.querySelector("#filmSearch").value;
    fetch(`http://localhost:8080/movie/${title}`)
    .then(res => res.json())
    .then((data) => {
        document.querySelector(".films").innerHTML = `
<div class="filmInfo">
    <h1>${data.title}</h1>
    <p>Runtime: ${data.runtime}</p>
    <p>Cast: ${data.cast}</p>
    <p>Release Date: ${data.release_date}</p>
    <p>Age Rating : ${data.age_rating}</p>
    <p>Description: ${data.description}</p>
    <p>Poster: ${data.poster_url}</p>
    </div>
    `;
    }).catch((err) => {
        console.log('Film not found', err);
    });
    e.preventDefault();
}
