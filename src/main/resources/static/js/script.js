'use strict';
const customerURL = "http://localhost:8090/customer";


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
 
const readCustomers = () => {
	 let html = " ";
	fetch(`${customerURL}/all`)
     .then((response) => {
         if (response.status !== 200) {
             console.log(`Looks like there was a problem.Status Code: ${ response.status }`);
             return;
         }
     response.json()
     .then(customers => customers.forEach(customer => {
		 html = html + `
        <li class="row">
                <p>
                   First Name: ${customer.firstName}
                   Last Name: ${customer.lastName}
                   ID: ${customer.id}
                </p>
        </li>
        `
        document.getElementById("displayCustomers").innerHTML = html;
}))
     .catch(err => console.error(`Fetch Error :-S ${err}`));
     });
}
readCustomers();

const deleteCustomer= () => {
	const _customer_id = document.querySelector("#id");

	const customerID = _customer_id.value;
    	
    let data = { 
		"id": customerID,
    } 
    
	fetch(`${customerURL}/delete/${data.id}`, {
	        method: "DELETE",
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
}