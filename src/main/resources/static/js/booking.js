
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
                <label for="adultSeats" class="col-2">How many adult seats</label>
                <label for="childSeats" class="col-2">How many child seats</label>
                <label for="date" class="col-2">What date</label>
				<label for="time" class="col-2">What Time?</label>                
                <select id="films" name="films" onchange="checkFilm();" class="col-2">
				    <option value="1">Volvo</option>
				    <option value="2">Saab</option>
				    <option value="3">Fiat</option>
				    <option value="4">Audi</option>
				  </select>
               	 <input type="text" class="col-2" id="id">
               	 <input type="number" class="col-2" id="adultSeats" >
               	 <input type="number" class="col-2" id="childSeats" 	>	
               	 <input type="date" id="bookingDate" name="bokingDate"value="${availibleDates()}" min="${availibleDates()}" max="${availibleDates()+30}" class="col-2">		
                <!-- <button type="submit" class="btn btn-primary" onclick="addCustomer()" >Submit</button> -->
		`
		availibleDates();
	}
	
	makeBooking();
	
	const  checkFilm = () => {
	    const films = document.getElementById("films");
	    
	    let selectedFilm = films.options[films.selectedIndex].value;
	    window.alert(selectedFilm);
	   
	   }
	   

