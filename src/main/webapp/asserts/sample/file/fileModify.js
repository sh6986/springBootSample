$(document).ready(function () {

    initPage();
    setEventListener();
});

function initPage() {

    const fileNo = $('#fileNo').val();

    const option = {
        'url': contextPath + '/file/' + fileNo,
        'method': 'GET',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': null,
        'success': (res) => {
            const originName = res.data.originName.split('.');

            $('#originName').val(originName[0]);
            $('#fileExt').val(originName[1]);
        }
    };

    common.sampleAjax(option, true);

}

function setEventListener() {

    /**
     * 수정버튼 클릭
     */
    $('.modifyBtn').click(function () {

        const fileNo = $('#fileNo').val();
        const originName = $('#originName').val() + '.' + $('#fileExt').val();

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