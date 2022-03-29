const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("adminMenuButton").addEventListener("click", adminMenuPageRedirect);
console.log("=================================================================================================")

console.log("==========================================~~~~~~~~~~~~~================(Create Employee Listener)")
document.getElementById("submitEmployeeButton").addEventListener("click", submitEmployee);
console.log("=================================================================================================")




console.log("================================================================================(HTML Navigation)")
async function adminMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Menu.html";
  }   
console.log("=================================================================================================")


console.log("==========================================~~~~~~~~~~~~~=========================(Create Employee)")
async function submitEmployee(){
  let company_email = document.getElementById("company_email").value;
  let f_name = document.getElementById("f_name").value;
  let l_name = document.getElementById("l_name").value;
  let employee_username = document.getElementById("employee_username").value;
  let employee_password = document.getElementById("employee_password").value;
  let role_id = document.getElementById("role_id").value;
  let user = {
      company_email: company_email,
      f_name: f_name,
      l_name: l_name,
      employee_username: employee_username,
      employee_password: employee_password,
      role_id: role_id
  }
  let response = await fetch (url + "employee", {
      method: "POST",
      body: JSON.stringify(user),
      credentials: "include"
  })
  console.log(response.status)
  if(response.status === 201){
      document.getElementById("loginRow").innerText="Sucess!";
      setTimeout(() => {  adminMenuPageRedirect(); }, 2000);
  }
  else{
      document.getElementById("loginRow").innerText="Submission Failed. Please Refreash and Try again";
  }
}
console.log("=================================================================================================")

