const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("createLodgingButton").addEventListener("click", reviewLodgingPageRedirect);
document.getElementById("createTravelButton").addEventListener("click", reviewTravelPageRedirect);
document.getElementById("createFoodButton").addEventListener("click", reviewFoodPageRedirect);
document.getElementById("createMiscellaneousButton").addEventListener("click", reviewMiscellaneousPageRedirect);
document.getElementById("adminMenuButton").addEventListener("click", adminMenuPageRedirect);
console.log("=================================================================================================")




console.log("===============================================================================(HTML Navigation )")
async function reviewLodgingPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Admin%201%20Lodging%20Request.html";
}
async function reviewTravelPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Admin%202%20Travel%20Request.html";
}
async function reviewFoodPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Admin%203%20Food%20Request.html";
} 
async function reviewMiscellaneousPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Create%20Admin%204%20Miscellaneous%20Request.html";
} 
async function adminMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Menu.html";
  }   
console.log("=================================================================================================")



