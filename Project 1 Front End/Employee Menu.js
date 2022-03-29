const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("getEmployeeRequestsButton").addEventListener("click", getEmployeeRequestsPageRedirect);
document.getElementById("submitRequestButton").addEventListener("click", submitRequestPageRedirect);
document.getElementById("logoutEmployeeButton").addEventListener("click", logoutPageRedirect);
console.log("=================================================================================================")




console.log("===============================================================================(HTML Navigation )")
async function getEmployeeRequestsPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Get%20Employee%20Requests.html";
} 
async function submitRequestPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Employee%20Request%20Menu.html";
}    
async function logoutPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Login.html";
  }   
console.log("=================================================================================================")
