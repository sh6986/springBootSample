$(document).ready(function () {

    initPage();
    setEventListener();
});

function initPage() {
    $('#fileListLi').addClass('active');
}

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
        $('.valFileSize').hide();
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
    const size = $('#file')[0].files[0].size;

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

    if (100000000 < size) {  // 100MB

        $('.valFileSize').show();
        result = false;
    }

    return result;
}
