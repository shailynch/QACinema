document.querySelector('#search').addEventListener("click", getFilmByTitle);

function getFilmByTitle(e){
    const id = document.querySelector("#filmSearch").value;
    fetch(`http://localhost:8090/movie/${title}`)
    .then(res => res.json())
    .then((data) => {
        document.querySelector(".films").innerHTML = `
<div class="filmInfo">
    <h1>${data.title}</h1>
    <p>Runtime: ${data.runtime}</p>
    <p>Cast: ${data.cast}</p>
    <p>Release Date: ${data.releaseDate}</p>
    <p>Age Rating : ${data.ageRating}</p>
    <p>Description: ${data.description}</p>
    <p><img src=${data.posterUrl}></p>
    </div>
    `;
    }).catch((err) => {
        console.log('Film not found', err);
    });
    e.preventDefault();
}
