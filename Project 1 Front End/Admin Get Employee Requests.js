const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("adminMenuButton").addEventListener("click", adminMenuPageRedirect);
document.getElementById("refreshButton").addEventListener("click", refreshPage);
console.log("=================================================================================================") 


console.log("=============================================(Get Reimbursement Requests By Employee ID Listener)")
document.getElementById("getAdminEmployeeRequestsButton").addEventListener("click", getEmployeeLodgingRequests);
document.getElementById("getAdminEmployeeRequestsButton").addEventListener("click", getEmployeeTravelRequests);
document.getElementById("getAdminEmployeeRequestsButton").addEventListener("click", getEmployeeFoodRequests);
document.getElementById("getAdminEmployeeRequestsButton").addEventListener("click", getEmployeeMiscellaneousRequests);
console.log("=================================================================================================")







console.log("================================================================================(HTML Navigation)")
async function adminMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Menu.html";
  }  
  async function refreshPage() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Get%20Employee%20Requests.html";
  }    
console.log("=================================================================================================")


console.log("=======================================================(Get Reimbursement Requests By Employee ID)")
async function getEmployeeLodgingRequests(){
    let userInput = document.getElementById("employee_id").value;

    let response = await fetch(url + "lodging/" + userInput); 

    if(response.status === 200){
        let data = await response.json();
        
        for(let lodging of data){
           //ask ben how to do this :)
            let row = document.createElement("tr");
          
            let cell2 = document.createElement("td");
            cell2.innerHTML = lodging.lodging_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = lodging.lodging_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = lodging.status;
            row.appendChild(cell5);

            document.getElementById("lodgingBody").appendChild(row);
        }
    }  
};
async function getEmployeeTravelRequests(){
    let userInput = document.getElementById("employee_id").value;

    let response = await fetch(url + "travel/" + userInput); 

    if(response.status === 200){
        let data = await response.json();
        
        for(let travel of data){
           //ask ben how to do this :)
            let row = document.createElement("tr");
          
            let cell2 = document.createElement("td");
            cell2.innerHTML = travel.travel_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = travel.travel_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = travel.status;
            row.appendChild(cell5);

            document.getElementById("travelBody").appendChild(row);
        }
    }  
};
async function getEmployeeFoodRequests(){
    let userInput = document.getElementById("employee_id").value;

    let response = await fetch(url + "food/" + userInput); 

    if(response.status === 200){
        let data = await response.json();
        
        for(let food of data){
           //ask ben how to do this :)
            let row = document.createElement("tr");
          
            let cell2 = document.createElement("td");
            cell2.innerHTML = food.food_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = food.food_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = food.status;
            row.appendChild(cell5);

            document.getElementById("foodBody").appendChild(row);
        }
    }  
};
async function getEmployeeMiscellaneousRequests(){
    let userInput = document.getElementById("employee_id").value;

    let response = await fetch(url + "miscellaneous/" + userInput); 

    if(response.status === 200){
        let data = await response.json();
        
        for(let miscellaneous of data){
           //ask ben how to do this :)
            let row = document.createElement("tr");
        
            let cell2 = document.createElement("td");
            cell2.innerHTML = miscellaneous.misc_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = miscellaneous.misc_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = miscellaneous.status;
            row.appendChild(cell5);

            document.getElementById("miscBody").appendChild(row);
        }
    }  
};
console.log("=================================================================================================")


