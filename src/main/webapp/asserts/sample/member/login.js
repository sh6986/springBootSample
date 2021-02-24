$(document).ready(function() {

    initPage();
    setEventListenerLogin();
});

function initPage() {
    $('#loginLi').addClass('active');
}

function setEventListenerLogin() {

    /**
     * 로그인 버튼 클릭
     */
    $('#btnLogin').click(function(){
        login();
    });

    /**
     * id keydown
     */
    $('#id').keydown(function () {
        $('.emptyId').hide();
        $('.notLogin').hide();
    });

    /**
     * pwd keydown
     */
    $('#password').keydown(function () {
        $('.emptyPwd').hide();
        $('.notLogin').hide();
    });

    /**
     * 패스워드 keydown
     */
    $('#password').keydown(function (key) {

        if (13 === key.keyCode) {
            login();
        }
    });

}

function login() {

    const id = $('#id').val();
    const password = $('#password').val();
    const member = {
        memId: id,
        memPwd: password
    };

    if (loginValidation(member)) {

        const option = {
            'url': contextPath + '/member/login',
            'method': 'POST',
            'dataType': 'json',
            'contentType': 'application/json',
            'data': JSON.stringify(member),
            'success': function() {location.href = "/";},
            'error': function () {
                $('.notLogin').show();
            }
        };

        common.sampleAjax(option, true);
    }
}

/**
 * 유효성 검사
 */
function loginValidation(member) {

    let result = true;
    const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;

    if (common.isEmpty(member.memId)) {

        $('.emptyId').show();
        result = false;
    }

    if (common.isEmpty(member.memPwd) || !regExp.test(member.memPwd)) {

        $('.emptyPwd').show();
        result = false;
    }

    return result;
}