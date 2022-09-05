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

const addBooking = () => {
    const petID = _booking_pet_id.value;
    const customerID = _booking_customer_id.value;
    const vetID = _booking_vet_id.value;
    
    let data = { 
        "petID": petID, 
        "vetID": vetID, 
        "customerID": customerID 
    } 

    fetch(`${bookingURL}/add`, {
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
	 window.alert(`${customerURL}/update/${_update_customer_id.value}`);
	    
	const _update_first_name = document.querySelector("#new_first_name");
	const _update_last_name = document.querySelector("#new_last_name");
	const _update_email = document.querySelector("#new_email");
	const _update_customer_id= document.querySelector("#new_id");
   const updateCustomerFirstName  = _update_first_name.value;
    const updateCustomerLastName  = _update_last_name.value;
    const updateCustomerEmail = _update_email.value;
    const updateCustomerID = _update_customer_id.value;

	

    let data = { 
		"id":  updateCustomerID,
        "firstName": updateCustomerFirstName , 
        "lastName": updateCustomerLastName, 
        "email": updateCustomerEmail  
    } 
    


   fetch(`${customerURL}/update/${updateCustomerID}`, {
     method: 'PUT',
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
        .catch(err => console.error(`error ${err}`))
        console.log("fail");
        };
 