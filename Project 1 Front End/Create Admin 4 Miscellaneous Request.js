const url = "http://localhost:3000/";


console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("createRequestMenuButton").addEventListener("click", requestMenuPageRedirect);
console.log("=================================================================================================")

console.log("==========================================================(Create Reimbursement Request Listener)")
document.getElementById("submitRequestButton").addEventListener("click", submitRequest);
console.log("=================================================================================================")







console.log("================================================================================(HTML Navigation)")
async function requestMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Admin%20Request%20Menu.html";
  }   
console.log("=================================================================================================")

console.log("===================================================================(Create Reimbursement Request)")
async function submitRequest(){
    let employee_id = document.getElementById("employee_id").value;
    let misc_cost = document.getElementById("miscellaneous_cost").value;
    let misc_info = document.getElementById("miscellaneous_info").value;
    let user = {
        e_id: employee_id,
        misc_cost: misc_cost,
        misc_info: misc_info
    }
    let response = await fetch (url + "miscellaneous", {
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