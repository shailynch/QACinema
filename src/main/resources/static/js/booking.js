	
	
	
	function padTo2Digits(num) {
  return num.toString().padStart(2, '0');
}
	
	function formatDate(date) {
  return [
    date.getFullYear(),
    padTo2Digits(date.getMonth() + 1),
    padTo2Digits(date.getDate()),
  ].join('-');
}

	const availibleDates = () => {
		let today = formatDate(new Date());
		return today;
	}
	const makeBooking = () => {
		document.getElementById("bookingForm").innerHTML= `
		 <label for="films" class="col-2">Choose a Film</label>
                <label for="id" class="col-2">Enter customer ID</label>
                <label for="adultSeats" class="col-2">How many adult seats £7.50</label>
                <label for="childSeats" class="col-2">How many child seats £2.50</label>
                <label for="date" class="col-2">What date</label>
				<label for="time" class="col-2">What Time?</label>                
                <select id="films" name="films" onload="readFilms()"onchange="readViewings();" class="col-2">
                	
				  </select>
               	 <input type="text" class="col-2" id="id">
               	 <input type="number" class="col-2" id="adultSeats" >
               	 <input type="number" class="col-2" id="childSeats" 	>	
               	 <input type="date" id="bookingDate" name="bokingDate"value="${availibleDates()}" min="${availibleDates()}" max="${availibleDates()+30}" class="col-2">		
                <select id="displayViewings" onload="readViewings()" class="col-2">
				  </select>
                <button type="submit" class="btn btn-primary" onclick="bookViewing()" >Book</button>
		`
		availibleDates();
	}
	
	makeBooking();
	   
	   const readFilms = () => {
		const filmURL = "http://18.132.36.167:8080/movie";
	 let html = "  <option disabled selected value> -- select an option -- </option>";
	fetch(`${filmURL}/all`)
     .then((response) => {
         if (response.status !== 200) {
             console.log(`Looks like there was a problem.Status Code: ${ response.status }`);
             return;
         }
     response.json()
     .then(movies => movies.forEach(movie => {
		 html = html + `
        <option value= ${movie.id} >${movie.title} </option>
 
        `
        document.getElementById("films").innerHTML = html;
}))
     .catch(err => console.error(`Fetch Error :-S ${err}`));
     });
}
	   readFilms();

const readViewings = () => {
	const viewingURL = "http://18.132.36.167:8080/viewing";
	const films = document.getElementById("films");
	let selectedFilm = films.options[films.selectedIndex].value;
	 let html = `<option>Pick a time</option>`;
	fetch(`${viewingURL}/all`)
     .then((response) => {
         if (response.status !== 200) {
             console.log(`Looks like there was a problem.Status Code: ${ response.status }`);
             return;
         }
     response.json()
     .then(viewings => viewings.forEach(viewing => {
		 if(viewing.movieID == selectedFilm){
			html = html + `
        <option value= ${viewing.id} >${viewing.startTime} </option>
        `
        document.getElementById("displayViewings").innerHTML = html;
		}
        
}))
     .catch(err => console.error(`Fetch Error :-S ${err}`));
     });
}
readViewings();
