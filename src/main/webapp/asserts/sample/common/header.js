/**
 * 로그아웃
 */
function logout() {

    const option = {
        'url': contextPath + '/member/logout',
        'method': 'GET',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': null,
        'success': function() {location.href = "/";}
    };

    common.sampleAjax(option, true);
}


/**
 * 회원 탈퇴
 */
function memberRemove(memId) {

    const option = {
        'url': contextPath + '/member/remove/' + memId,
        'method': 'DELETE',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': null,
        'success': function() {
            alert('회원탈퇴가 완료되었습니다.');
            logout();
            location.href = "/";
        }
    };

    common.sampleAjax(option, true);


}
