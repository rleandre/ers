const url = "http://localhost:3000/";

console.log("===========================================================================(Variable Declaration)")
var save_id;
console.log("=================================================================================================")


console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("returnRequestReviewButton").addEventListener("click", requestReviewMenuPageRedirect);
console.log("=================================================================================================")



console.log("====================================================(Get Single Reimbursement Requests Listeners)")
document.getElementById("foodSingleButton").addEventListener("click", getSingleFood);
console.log("=================================================================================================")



console.log("===========================================================(Put Reimbursement Requests Listeners)")
document.getElementById("approveFoodButton").addEventListener("click", approveFood);
document.getElementById("denyFoodButton").addEventListener("click", denyFood);
console.log("=================================================================================================")





console.log("===============================================================================(HTML Navigation )")
async function requestReviewMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Approve%20or%20Deny%20Menu.html";
  }   
  async function refreshPage() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Review%20Food%20Requests.html";
  }   
console.log("=================================================================================================")


console.log("===============================================================(Get Single Reimbursement Requests)")
async function getSingleFood() {
    let response = await fetch(url + "food_status");

    if(response.status === 200){
        let data = await response.json();
        
        for(let food of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = food.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = food.food_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = food.food_info;
            row.appendChild(cell3);
            
            let cell4 = document.createElement("td");
            cell4.innerHTML = food.food_id;
            save_id = food.food_id;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = food.status;
            row.appendChild(cell5);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
console.log("=================================================================================================")



console.log("===================================================================================(Put Requests)")
async function approveFood(){
    const approved = 1;
    console.log(save_id)
    let user = {
        status: approved,
        food_id: save_id
    }
    let response = await fetch (url + "food", {
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
async function denyFood(){
    const denied = 2;
    let user = {
        status: denied,
        food_id: save_id
    }
    let response = await fetch (url + "food", {
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

