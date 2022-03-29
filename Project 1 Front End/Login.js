const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")

console.log("=================================================================================================")


console.log("=======================================================================(Login Requests Listeners)")
document.getElementById("loginButton").addEventListener("click", loginRequest);
console.log("=================================================================================================")






console.log("===============================================================================(HTML Navigation )")
async function adminMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Menu.html";
  }      
async function employeeMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Employee%20Menu.html";
  }    
async function refreshPage() {
   window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Login.html";
  }     
console.log("=================================================================================================")


console.log("==================================================================================(Login Request)")
async function loginRequest(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    let user = {
        employee_username: usern,
        employee_password: userp
    }
    let response = await fetch (url + "login", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    })
    console.log(response.status)
    if(response.status === 202){
        adminMenuPageRedirect();
    }
    else if(response.status  === 201){
        employeeMenuPageRedirect();
    }
    else{
        setTimeout(() => {  refreshPage(); }, 2000);
    }
}
console.log("=================================================================================================")



