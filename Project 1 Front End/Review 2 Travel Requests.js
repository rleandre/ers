const url = "http://localhost:3000/";

console.log("===========================================================================(Variable Declaration)")
var save_id;
console.log("=================================================================================================")


console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("returnRequestReviewButton").addEventListener("click", requestReviewMenuPageRedirect);
console.log("=================================================================================================")


console.log("====================================================(Get Single Reimbursement Requests Listeners)")
document.getElementById("travelSingleButton").addEventListener("click", getSingleTravel);
console.log("=================================================================================================")



console.log("===========================================================(Put Reimbursement Requests Listeners)")
document.getElementById("approveTravelButton").addEventListener("click", approveTravel);
document.getElementById("denyTravelButton").addEventListener("click", denyTravel);
console.log("=================================================================================================")



console.log("===============================================================================(HTML Navigation )")
async function requestReviewMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Approve%20or%20Deny%20Menu.html";
  }  
  async function refreshPage() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Review%202%20Travel%20Requests.html";
  }     
console.log("=================================================================================================")



console.log("===============================================================(Get Single Reimbursement Requests)")
async function getSingleTravel() {
    let response = await fetch(url + "travel_status");

    if(response.status === 200){
        let data = await response.json();
        
        for(let travel of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = travel.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = travel.travel_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = travel.travel_info;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = travel.travel_id;
            save_id = travel.travel_id;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = travel.status;
            row.appendChild(cell5);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
console.log("=================================================================================================")




console.log("===================================================================================(Put Requests)")
async function approveTravel(){
    const approved = 1;
    console.log(save_id)
    let user = {
        status: approved,
        travel_id: save_id
    }
    let response = await fetch (url + "travel", {
        method: "PUT",
        body: JSON.stringify(user),
        credentials: "include"
    })
    console.log(response.status)
    if(response.status === 200){
        document.getElementById("loginRow").innerText="Sucess!";
        setTimeout(() => {  refreshPage(); }, 2000);
    }
    else{
        document.getElementById("loginRow").innerText="Submission Failed. Please Try again";
        setTimeout(() => {  refreshPage(); }, 2000);
    }
}
async function denyTravel(){
    const denied = 2;
    let user = {
        status: denied,
        travel_id: save_id
    }
    let response = await fetch (url + "travel", {
        method: "PUT",
        body: JSON.stringify(user),
        credentials: "include"
    })
    console.log(response.status)
    if(response.status === 200){
        document.getElementById("loginRow").innerText="Sucess!";
        setTimeout(() => {  refreshPage(); }, 2000);
    }
    else{
        document.getElementById("loginRow").innerText="Submission Failed. Please Try again";
        setTimeout(() => {  refreshPage(); }, 2000);
    }
}
console.log("=================================================================================================")






