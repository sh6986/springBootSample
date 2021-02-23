$(document).ready(function () {

    setEventListener();
});

function setEventListener() {

    /**
     * 입력버튼 클릭
     */
    $('.uploadBtn').click(function () {

        if (validation()) {

            const option = {
                'url': contextPath + '/file/upload',
                'method': 'POST',
                'processData': false,
                'contentType': false,
                'data': new FormData($('#uploadForm')[0]),
                'success': () => {
                    location.href = '/view/file/list';
                },
                'error': function () {
                    console.log('aaa');
                }
            };

            common.sampleAjax(option, true);
        }
    });

    /**
     * 파일설명 keydown
     */
    $('#fileDesc').keydown(function () {
        $('.empFileDesc').hide();
    });

    /**
     * 파일선택 클릭
     */
    $('#file').click(function () {

        $('.empFile').hide();
        $('.valFileName').hide();
    });
}

/**
 * 유효성 검사
 */
function validation() {

    let result = true;
    const fileDesc = $('#fileDesc').val();
    const file = $('#file').val();
    const filePath = $('#file').val();
    const fileName = filePath.substring(filePath.lastIndexOf('\\') + 1, filePath.lastIndexOf('.'));

    if (common.isEmpty(file)) {

        $('.empFile').show();
        result = false;

    } else if (20 < fileName.length) {

        $('.valFileName').show();
        result = false;
    }

    if (common.isEmpty(fileDesc)) {

        $('.empFileDesc').show();
        result = false;
    }

    return result;
}
