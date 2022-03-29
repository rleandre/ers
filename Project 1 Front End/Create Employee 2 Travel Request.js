const url = "http://localhost:3000/";


console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("createRequestMenuButton").addEventListener("click", requestMenuPageRedirect);
console.log("=================================================================================================")

console.log("==========================================================(Create Reimbursement Request Listener)")
document.getElementById("submitRequestButton").addEventListener("click", submitRequest);
console.log("=================================================================================================")







console.log("================================================================================(HTML Navigation)")
async function requestMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Employee%20Request%20Menu.html";
  }   
console.log("=================================================================================================")

console.log("===================================================================(Create Reimbursement Request)")
async function submitRequest(){
    let employee_id = document.getElementById("employee_id").value;
    let travel_cost = document.getElementById("travel_cost").value;
    let travel_info = document.getElementById("travel_info").value;
    let user = {
        e_id: employee_id,
        travel_cost: travel_cost,
        travel_info: travel_info
    }
    let response = await fetch (url + "travel", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    })
    console.log(response.status)
    if(response.status === 201){
        document.getElementById("loginRow").innerText="Sucess!";
        setTimeout(() => {  requestMenuPageRedirect(); }, 2000);
    }
    else{
        document.getElementById("loginRow").innerText="Submission Failed. Please Refreash and Try again";
    }
}
console.log("=================================================================================================")