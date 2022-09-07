const movieURL = "http://localhost:8080"

const releaseDateEl = document.querySelector('#releaseDate');
const runtimeEl = document.querySelector('#runtime');
const filmTitleEl = document.querySelector('#title');
const castEl = document.querySelector('#cast');
const genreEl = document.querySelector('#genre');
const descriptionEl = document.querySelector('#description')
const ageRatingEl = document.querySelector('#ageRating');
const posterEl = document.querySelector('#posterUrl')


//Read All Films in Database
const readAllFilms = () => {
    fetch(`${movieURL}/movie/all`)
       .then(response => response.json())
       .then(model => model.forEach(e => {
    function addRow(tableID) {
    
        let tableRef = document.getElementById(tableID);
        let newRow = tableRef.insertRow(-1);
    
        let newCell0 = newRow.insertCell(0);
        let newCell1 = newRow.insertCell(1);
        let newCell2 = newRow.insertCell(2);
        let newCell3 = newRow.insertCell(3);
        let newCell4 = newRow.insertCell(4);
        let newCell5 = newRow.insertCell(5);
        let newCell6 = newRow.insertCell(6);
        let newCell7 = newRow.insertCell(7);
        let newCell8 = newRow.insertCell(8);
        let newCell9 = newRow.insertCell(9);

        let newText = document.createTextNode(e.title);
        let newText2 = document.createTextNode(e.ageRating);
        let newText3 = document.createTextNode(e.releaseDate);
        let newText4 = document.createTextNode(e.genre);
        let newText5 = document.createTextNode(e.cast);
        let newText6 = document.createTextNode(e.runtime);
        let newText7 = document.createTextNode(e.description);
        let checkbox = document.createElement("input");
        checkbox.className = "newReleaseCheckbox";
        checkbox.type = "button";
    
        //Delete A Film from Database
        let deleteButton = document.createElement("button");
        deleteButton.type = "button";
        deleteButton.className = "deleteButton";
        const deleteFilm = () => {
            fetch(`${movieURL}/movie/delete/${e.id}`, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => console.log(response))
            .then(model => {
                document.location.reload(true)
                console.log(model);
            })
            .catch(err => console.error(`error ${err}`))
        }
    
        deleteButton.addEventListener("click", deleteFilm);


        //Edit a Film
        // const updateFilm = () => {
        //     let title = filmTitleEl.value;
        //     let cast = castEl.value;
        //     let releaseDate = releaseDateEl.value;
        //     let genre = genreEl.value;
        //     let posterUrl = posterEl.value;
        //     let ageRating = ageRatingEl.value;
        //     let runtime = runtimeEl.value;
        //     let description = descriptionEl.value;

        //     const film = {
        //         'title' : title,
        //         'cast' : cast,
        //         'releaseDate' : releaseDate,
        //         'genre' : genre,
        //         'posterUrl' : posterUrl,
        //         'ageRating' : ageRating,
        //         'runtime' : runtime,
        //         'description' : description,
        //         }
        //         console.log(e)
        //     fetch(`${movieURL}/movie/update/${e.id}`, {
        //         method: "PUT",
        //         body: JSON.stringify(film),
        //         headers: {
        //             "Content-Type": "application/json"
        //         }
        //     }).then(response => response.json())
        //     .then(model => {
        //         // document.location.reload(true)
        //         console.log(model);
        //     })
        //     .catch(err => console.error(`error ${err}`))
        // }

        // const editButton = document.createElement("button");
        // editButton.type = "button";
        // editButton.className = "editButton";
        // editButton.addEventListener("click", updateFilm);

        //Add Film to New Releases
        
        const addToNewReleases = () => {
            if (e.newRelease === false){



            const film = {
                'newRelease' : true,
            };
                console.log(e.newRelease)
            fetch(`${movieURL}/movie/update/${e.id}/newRelease`, {
                method: "PATCH",
                body: JSON.stringify(film),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => response.json())
            .then(model => {
                document.location.reload(true)
                console.log(model);
            })
            .catch(err => console.error(`error ${err}`))
        } else {
            const film = {
                'newRelease' : false,
            }
            fetch(`${movieURL}/movie/update/${e.id}/newRelease`, {
                method: "PATCH",
                body: JSON.stringify(film),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => response.json())
            .then(model => {
                document.location.reload(true)
                console.log(model);
            })
            .catch(err => console.error(`error ${err}`))
        }
        }
        
        checkbox.addEventListener("click", addToNewReleases);

        if (e.newRelease === true) {
            // checkbox.style.backgroundColor = 'green';
            checkbox.className = 'isNew';
        } else {
            checkbox.className = 'isNotNew';
        }
        
        const posterThumbnail = document.createElement("img");
        posterThumbnail.className = "poster-thumbnail";
        posterThumbnail.src = e.posterUrl;
        
        
    
        newCell0.appendChild(newText);
        newCell1.appendChild(posterThumbnail);
        newCell2.appendChild(newText2);
        newCell3.appendChild(newText3);
        newCell4.appendChild(newText4);
        newCell5.appendChild(newText5);
        newCell6.appendChild(newText6);
        newCell7.appendChild(newText7);
        newCell8.appendChild(checkbox);
        newCell9.appendChild(deleteButton);
    
        
      }
      addRow('film-database');
     } ))
        .catch(err => 
        console.error(`error ${err}`));
    };


const createFilm = () => {
    let title = filmTitleEl.value;
    let cast = castEl.value;
    let releaseDate = releaseDateEl.value;
    let genre = genreEl.value;
    let posterUrl = posterEl.value;
    let ageRating = ageRatingEl.value;
    let runtime = runtimeEl.value;
    let description = descriptionEl.value;

    const film = {
        'title' : title,
        'cast' : cast,
        'releaseDate' : releaseDate,
        'genre' : genre,
        'posterUrl' : posterUrl,
        'ageRating' : ageRating,
        'runtime' : runtime,
        'description' : description,
        }
        fetch(`${movieURL}/movie/add`, {
            method: "POST",
            body: JSON.stringify(film),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(response => response.json())
        .then(model => {
            document.location.reload(true)
            console.log(model);
            
        })
        .catch(err => console.error(`error ${err}`));
}


readAllFilms();