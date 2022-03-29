const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("createLodgingButton").addEventListener("click", reviewLodgingPageRedirect);
document.getElementById("createTravelButton").addEventListener("click", reviewTravelPageRedirect);
document.getElementById("createFoodButton").addEventListener("click", reviewFoodPageRedirect);
document.getElementById("createMiscellaneousButton").addEventListener("click", reviewMiscellaneousPageRedirect);
document.getElementById("employeeMenuButton").addEventListener("click", employeeMenuPageRedirect);
console.log("=================================================================================================")




console.log("===============================================================================(HTML Navigation )")
async function reviewLodgingPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Employee%201%20Lodging%20Request.html";
}
async function reviewTravelPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Employee%202%20Travel%20Request.html";
}
async function reviewFoodPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Employee%203%20Food%20Request.html";
} 
async function reviewMiscellaneousPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Employee%204%20Miscellaneous%20Request.html";
} 
async function employeeMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Employee%20Menu.html";
  }   
console.log("=================================================================================================")



