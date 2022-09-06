'use strict';
const customerURL = "http://localhost:8090/customer";


const bookingURL = "http://localhost:8090/booking";
const _booking_customer_id = document.querySelector("#booking_customer_id");
const _booking_vet_id = document.querySelector("#booking_viewing_id");
const _booking_pet_id = document.querySelector("#booking_date_id");


const addCustomer = () => {
	const _first_name = document.querySelector("#first_name");
	const _last_name = document.querySelector("#last_name");
	const _email = document.querySelector("#email");
	const _dob = document.querySelector("#dob");
	const _mobile = document.querySelector("#mobile");
    const customerFirstName  = _first_name.value;
    const customerLastName  = _last_name.value;
    const customerEmail = _dob.value;
    const customerDob  = _first_name.value;
    const customerMobile  = _mobile.value;
    
    let data = { 
        "firstName": customerFirstName, 
        "lastName": customerLastName, 
        "email": customerEmail,
        "dob": customerDob,
        "mobile": customerMobile 
    } 
    

    fetch(`${customerURL}/add`, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model);
            allFromCustomer();
        })
        .catch(err => console.error(`error ${err}`));
};


const updateCustomer = () => {
	const _customer_id = document.querySelector("#id");
	const _first_name = document.querySelector("#first_name");
	const _last_name = document.querySelector("#last_name");
	const _email = document.querySelector("#email");
	const _dob = document.querySelector("#dob");
	const _mobile = document.querySelector("#mobile");
	const customerID = _customer_id.value;
    const customerFirstName  = _first_name.value;
    const customerLastName  = _last_name.value;
    const customerDob = _dob.value;
    const customerMobile  = _mobile.value;
    const customerEmail = _email.value;
    	
    let data = { 
		"id": customerID,
        "firstName": customerFirstName, 
        "lastName": customerLastName, 
        "email": customerEmail,
        "dob": customerDob,
        "mobile": customerMobile 
    } 
    
	fetch(`${customerURL}/update/${data.id}`, {
	        method: "PUT",
	        body: JSON.stringify(data),
	        headers: {
	            "Content-Type": "application/json"
	        }
	    })
	        .then(response => response.json())
	        .then(model => {
	            console.log(model);
	            allFromCustomer();
	        })
	        .catch(err => console.error(`error ${err}`));
	    
 };