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

    $('#fileListLi').addClass('active');
}

function setEventListener() {

    /**
     * 수정버튼 클릭
     */
    $('.modifyBtn').click(function () {

        const fileNo = $('#fileNo').val();
        const fileName = $('#fileName').val();
        const originName = fileName + '.' + $('#fileExt').val();

        const param = {
            originName
        };

        if (validation(fileName)) {

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
        }
    });

    /**
     * id keydown
     */
    $('#fileName').keydown(function () {
        $('.empFileName').hide();
    });
}

/**
 * 유효성 검사
 */
function validation(fileName) {

    let result = true;

    if (common.isEmpty(fileName)) {

        $('.empFileName').show();
        result = false;
    }

    return result;
}