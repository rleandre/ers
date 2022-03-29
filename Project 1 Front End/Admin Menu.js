const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("reviewMenuRequestsButton").addEventListener("click", reviewMenuRequestsPageRedirect);
document.getElementById("viewReimbursementRequestsButton").addEventListener("click", viewRequestsPageRedirect);
document.getElementById("adminGetEmployeeRequestsButton").addEventListener("click", getEmployeeRequestsPageRedirect);
document.getElementById("submitEmployeeButton").addEventListener("click", submitEmployeePageRedirect);
document.getElementById("submitRequestButton").addEventListener("click", submitRequestPageRedirect);
document.getElementById("logoutAdminButton").addEventListener("click", logoutPageRedirect);
console.log("=================================================================================================")




console.log("===============================================================================(HTML Navigation )")
async function reviewMenuRequestsPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Approve%20or%20Deny%20Menu.html";
}
async function viewRequestsPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/View%20Reimbursement%20Requests.html";
}
async function getEmployeeRequestsPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Get%20Employee%20Requests.html";
} 
async function submitEmployeePageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Employee.html";
}
async function submitRequestPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Admin%20Request%20Menu.html";
}    
async function logoutPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Login.html";
  }   
console.log("=================================================================================================")
