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
    const password = $('#password').val();
    const url = '/member/login';

    let data = {
        memId: id,
        memPwd: password
    };

    data = JSON.stringify(data);

    const option = {
        'url': contextPath + '/member/login',
        'method': 'POST',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': data,
        'success': function() {console.log('success')}
    }
    common.sampleAjax(option, true);

}