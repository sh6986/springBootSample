$(document).ready(function() {

    setEventListener();

});

function setEventListener() {

    // 로그인 버튼 클릭
    $('#btnLogin').click(function(){
        login();
    });
}

function login() {

    const id = $('#id').val();
    const password = $('#password').val()
    const url = '/login';

    let data = {
        id: id,
        password: password
    };

    data = JSON.stringify(data);

    common.ajax(contextPath + url, data, 'POST', ()=>{console.log('success')}, ()=>{console.log('error')});
}