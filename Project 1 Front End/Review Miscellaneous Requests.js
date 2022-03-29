const url = "http://localhost:3000/";

console.log("===========================================================================(Variable Declaration)")
var save_id;
console.log("=================================================================================================")


console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("returnRequestReviewButton").addEventListener("click", requestReviewMenuPageRedirect);
console.log("=================================================================================================")


console.log("====================================================(Get Single Reimbursement Requests Listeners)")
document.getElementById("miscellaneousSingleButton").addEventListener("click", getSingleMiscellaneous);
console.log("=================================================================================================")



console.log("===========================================================(Put Reimbursement Requests Listeners)")
document.getElementById("approveMiscellaneousButton").addEventListener("click", approveMiscellaneous);
document.getElementById("denyMiscellaneousButton").addEventListener("click", denyMiscellaneous);
console.log("=================================================================================================")





console.log("===============================================================================(HTML Navigation )")
async function requestReviewMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Approve%20or%20Deny%20Menu.html";
  }   
  async function refreshPage() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Review%20Miscellaneous%20Requests.html";
  }   
console.log("=================================================================================================")



console.log("===============================================================(Get Single Reimbursement Requests)")
async function getSingleMiscellaneous() {
    let response = await fetch(url + "miscellaneous_status");

    if(response.status === 200){
        let data = await response.json();
        console.log(data)
        for(let misc of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = misc.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = misc.misc_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = misc.misc_info;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = misc.misc_id;
            save_id = misc.misc_id;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = misc.status;
            row.appendChild(cell5);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
console.log("=================================================================================================")




console.log("===================================================================================(Put Requests)")
async function approveMiscellaneous(){
    const approved = 1;
    console.log(save_id)
    let user = {
        status: approved,
        misc_id: save_id
    }
    let response = await fetch (url + "miscellaneous", {
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
async function denyMiscellaneous(){
    const denied = 2;
    let user = {
        status: denied,
        misc_id: save_id
    }
    let response = await fetch (url + "miscellaneous", {
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
