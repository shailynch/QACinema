document.querySelector('#search').addEventListener("click", getFilmByTitle);
// small bug getting this function to work with title, will implement bug fix at a later date
function getFilmByTitle(e){
    const id = document.querySelector("#filmSearch").value;

    fetch(`http://18.132.36.167:8080/movie/${id}`)
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
