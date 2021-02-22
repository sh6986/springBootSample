$(document).ready(function () {

    setEventListener();
});

function setEventListener() {

    /**
     * sign up 버튼 클릭
     */
    $('.signUpBtn').click(function () {
        signUp();
    });
}

function signUp() {

    const memId = $('#IptMemId').val();
    const memPwd = $('#IptMemPwd').val();

    const member = {
        memId,
        memPwd
    };

    const option = {
        'url': contextPath + '/member/reg',
        'method': 'POST',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': JSON.stringify(member),
        'success': (res) => {
            console.log(res);
        }
    };

    common.sampleAjax(option, true);

}
