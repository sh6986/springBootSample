$(document).ready(function () {

    setEventListener();
});

function setEventListener() {

    /**
     * 입력버튼 클릭
     */
    $('.uploadBtn').click(function () {

        const option = {
            'url': contextPath + '/file/upload',
            'method': 'POST',
            'processData': false,
            'contentType': false,
            'data': new FormData($('#uploadForm')[0]),
            'success': () => {
                location.href = '/view/file/list';
            }
        };

        common.sampleAjax(option, true);
    });


}
