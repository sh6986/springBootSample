$(document).ready(function () {

    setEventListenerSingUp();
});

function setEventListenerSingUp() {

    /**
     * sign up 버튼 클릭
     */
    $('.signUpBtn').click(function () {
        signUp();
    });

    /**
     * id focusout
     */
    $('#IptMemId').focusout(function () {
        idDupCheck();
    });

    /**
     * id keydown
     */
    $('#IptMemId').keydown(function () {
        $('.dupText').hide();
        $('.notIdText').hide();
    });

    /**
     * pwd keydown
     */
    $('#IptMemPwd').keydown(function () {
        $('.notPwdText').hide();
    });

    /**
     * 패스워드 keydown
     */
    $('#IptMemPwd').keydown(function (key) {

        if (13 === key.keyCode) {
            signUp();
        }
    });
}

/**
 * 아이디 중복 검사
 */
function idDupCheck() {

    const memId = $('#IptMemId').val();

    if (!common.isEmpty(memId)) {

        const option = {
            'url': contextPath + '/member/check/id/' + memId,
            'method': 'GET',
            'dataType': 'json',
            'contentType': 'application/json',
            'data': null,
            'success': function () {
                $('.dupText').hide();
            },
            'error': function () {
                $('.dupText').show();
            }
        };

        common.sampleAjax(option, true);
    } else {

    }
}

/**
 * 회원 가입
 */
function signUp() {

    const memId = $('#IptMemId').val();
    const memPwd = $('#IptMemPwd').val();
    const member = {
        memId,
        memPwd
    };

    if (signUpValidation(member)) {

        const option = {
            'url': contextPath + '/member/reg',
            'method': 'POST',
            'dataType': 'json',
            'contentType': 'application/json',
            'data': JSON.stringify(member),
            'success': function () {
                location.href = '/';
            },
            'error': function () {
            }
        };

        common.sampleAjax(option, true);
    }
}

/**
 * 유효성 검사
 */
function signUpValidation(member) {

    let result = true;
    const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;

    if (common.isEmpty(member.memId)) {

        $('.notIdText').show();
        result = false;
    }

    if (common.isEmpty(member.memPwd) || !regExp.test(member.memPwd)) {

        $('.notPwdText').show();
        result = false;
    }

    return result;
}