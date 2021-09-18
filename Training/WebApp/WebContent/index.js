function updateName() {
  var ele = document.getElementsByName("card");

  for (i = 0; i < ele.length; i++) {
    if (ele[i].checked) {
      document.getElementById("bal").innerHTML = "Limit";
      document.getElementById("val").value = 1000;
      document.getElementById("val").readOnly = true;
      break;
    } else {
      document.getElementById("bal").innerHTML = "Balance";
      document.getElementById("val").value = "";
      document.getElementById("val").readOnly = false;
      break;
    }
  }
}
function checkPass() {
  var password = document.getElementById("password").value,
    errors = [],
    disp = [];
  var username = document.getElementById("username").value;
  var balance = document.getElementById("val").value;

  if (username === "") {
    disp.push("Username");
  }
  if (password === "") {
    disp.push("Password");
  }
  if (balance === "") {
    disp.push("Balance");
  }
  if (disp.length > 0) {
    document.getElementById("errors").innerHTML = disp.join();
    document.querySelector("#errors").style.visibility = "visible";
    document.querySelector("#missing").style.visibility = "visible";
    document.querySelector("#mandatory").style.visibility = "visible";
    
    return false;
  } else {
    document.querySelector("#errors").style.visibility = "hidden";
    document.querySelector("#missing").style.visibility = "hidden";
    document.querySelector("#mandatory").style.visibility = "hidden";
    if (password.length < 6) {
      errors.push("Your password must be at least 6 characters");
    }
    if (password.search(/[a-z]/g) < 0) {
      errors.push("Your password must contain at least one lowercase letter.");
    }
    if (password.search(/[A-Z]/g) < 0) {
      errors.push("Your password must contain at least one Uppercase letter.");
    }
    if (password.search(/[@]/g) < 0) {
      errors.push("Your password must contain at least one @ letter.");
    }
    if (password.search(/[0-9]/) < 0) {
      errors.push("Your password must contain at least one digit.");
    }
    if (errors.length > 0) {
      alert(errors.join("\n"));
      return false;
    } else {
      return true;
    }
  }
}
function reset() {
  document.querySelector("#errors").style.visibility = "hidden";
  document.querySelector("#missing").style.visibility = "hidden";
  document.querySelector("#mandatory").style.visibility = "hidden";

  document.getElementById("password").value = "";

  document.getElementById("username").value = "";
  document.getElementById("val").value = "";
  document.getElementById("debit").checked = true;
  updateName();
}

