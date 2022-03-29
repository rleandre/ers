const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("reviewLodgingButton").addEventListener("click", reviewLodgingPageRedirect);
document.getElementById("reviewTravelButton").addEventListener("click", reviewTravelPageRedirect);
document.getElementById("reviewFoodButton").addEventListener("click", reviewFoodPageRedirect);
document.getElementById("reviewMiscellaneousButton").addEventListener("click", reviewMiscellaneousPageRedirect);
document.getElementById("adminMenuButton").addEventListener("click", adminMenuPageRedirect);
console.log("=================================================================================================")




console.log("===============================================================================(HTML Navigation )")
async function reviewLodgingPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Review%201%20Lodging%20Requests.html";
}
async function reviewTravelPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Review%202%20Travel%20Requests.html";
}
async function reviewFoodPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Review%20Food%20Requests.html";
} 
async function reviewMiscellaneousPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Review%20Miscellaneous%20Requests.html";
} 
async function adminMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Menu.html";
  }   
console.log("=================================================================================================")



