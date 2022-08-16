let errorList = [];

function usernameValidation() {
    var input = document.data.username;
    if (input.value.trim().length == 0) {
        event.preventDefault();
        input.parentElement.parentElement.style.borderBottomColor = '#ff5252';
        errorList.push("Username cannot be blank.")
    } else {
        input.parentElement.parentElement.style.borderBottomColor = '#00c853';
    }
}

function passwordValidation() {
    var input = document.data.password;
    pattern = /\S{6,20}/;
    if (input.value.trim().length == 0) {
        event.preventDefault();
        input.parentElement.parentElement.style.borderBottomColor = '#ff5252';
        errorList.push("Password cannot be blank.")
    } else if (!pattern.test(input.value.trim())) {
        event.preventDefault();
        input.parentElement.parentElement.style.borderBottomColor = '#ff5252';
        errorList.push("Password must be between 6-20 characters in length (no spaces).")
    } else {
        input.parentElement.parentElement.style.borderBottomColor = '#00c853';
    }
}

function emailValidation() {
    var input = document.data.email;
    pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (input.value.trim().length == 0) {
        event.preventDefault();
        input.parentElement.parentElement.style.borderBottomColor = '#ff5252';
        errorList.push("Email cannot be blank.")
    } else if (!pattern.test(input.value.trim())) {
        event.preventDefault();
        input.parentElement.parentElement.style.borderBottomColor = '#ff5252';
        errorList.push("Email is incorrect.")
    } else {
        input.parentElement.parentElement.style.borderBottomColor = '#00c853';
    }
}

function phoneNumberValidation() {
    var input = document.data.phone_number;
    if (input.value.trim().length == 0) {
        event.preventDefault();
        input.parentElement.parentElement.style.borderBottomColor = '#ff5252';
        errorList.push("Phone number cannot be blank.")
    } else {
        input.parentElement.parentElement.style.borderBottomColor = '#00c853';
    }
}

function addressValidation() {
    var input = document.data.address;
    if (input.value.trim().length == 0) {
        event.preventDefault();
        input.parentElement.parentElement.style.borderBottomColor = '#ff5252';
        errorList.push("Address cannot be blank.")
    } else {
        input.parentElement.parentElement.style.borderBottomColor = '#00c853';
    }
}

function forgotPasswordValidate() {
    usernameValidation();
    showError();
    errorList = [];
}

function loginValidate() {
    usernameValidation();
    passwordValidation();
    showError();
    errorList = [];
}

function signupValidate() {
    usernameValidation();
    passwordValidation();
    emailValidation();
    phoneNumberValidation();
    addressValidation();
    showError();
    errorList = [];
}

function showError() {
    if (errorList.length != 0) {
        let element = document.getElementById("validation-list");
        element.style.display = 'block';
        element.innerHTML = "Something is wrong:";
        element.innerHTML += "<ul>"
        for (i of errorList) {
            element.innerHTML += "<li>" + i + "</li>";
        }
        element.innerHTML += "</ul>"
    }
}