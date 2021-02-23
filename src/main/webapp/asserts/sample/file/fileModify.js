$(document).ready(function () {

    initPage();
    setEventListener();
});

/**
 * 화면 초기화
 */
function initPage() {

    const originName = $('#originName').val().split('.');

    $('#fileName').val(originName[0]);
    $('#fileExt').val(originName[1]);
}

function setEventListener() {

    /**
     * 수정버튼 클릭
     */
    $('.modifyBtn').click(function () {

        const fileNo = $('#fileNo').val();
        const originName = $('#fileName').val() + '.' + $('#fileExt').val();

        const param = {
            originName
        };

        const option = {
            'url': contextPath + '/file/' + fileNo,
            'method': 'PUT',
            'dataType': 'json',
            'contentType': 'application/json',
            'data': JSON.stringify(param),
            'success': (res) => {
                location.href = '/view/file/list';
            }
        };

        common.sampleAjax(option, true);
    });
}