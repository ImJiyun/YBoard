const headers = {"Content-Type" : "application/json"};

$(document).on("click", "#loginBtn", async function () {
    const email = $("#email").val();
    const password = $("#password").val();
    alert(email, password);

    console.log(email, password);

    let data = {email,password};
    data = JSON.stringify(data);

    data = await fetch("/user/login", {method:"post", headers, body:data});

    data = await data.json();

    if (data.error) {
        alert(data.error);
    } else {
        sessionStorage.setItem("name", data.name);
        let boardPage = `<h3>${data.name}님 환영합니다.</h3>
                                <hr>
                                <div id="boardDiv">
                                    <button id="boardList">글 목록</button>
                                    <button id="boardWrite">글 등록</button>
                                </div>`;
        $("#loginDiv").html(boardPage);
    }
})

$(document).on("click", "#signupBtn", function () {
    let signupForm = `email <input type="text" id="email1"> <br>
            password <input type="text" id="password1">  <br>
            name <input type="text" id="name1">  <br>
            <button id="signup">signup</button>`;
    $("#loginDiv").html(signupForm);

});

$(document).on("click", "#signup", async function () {
    const email = $("#email1").val();
    const password = $("#password1").val();
    const name = $("#name1").val();

    let data = {email, password, name};
    data = JSON.stringify(data);
    data = await fetch("user/signup",{method : "post", headers, body : data});
    data = await data.json();
    if (data.success) {
        alert(data.success);
        location.reload();
    } else if (data.fail) {
        alert(data.fail);
    } else {
        alert(data.message);
    }
});