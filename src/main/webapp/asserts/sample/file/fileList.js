$(document).ready(function() {

    initPage();
    setEventListener();
});

/**
 * 화면 초기화
 */
function initPage() {
    getFileList();
}

/**
 * 이벤트 리스너
 */
function setEventListener() {

    /**
     * 파일명 클릭
     */
    $(document).on('click', 'td[class="fileName"]', function() {
        const fileNo = $(this).closest('tr').attr('fileNo')
        fileDetail(fileNo);
    });

}

/**
 * 파일 리스트
 */
function getFileList() {

    const param = {

    };

    const option = {
        'url': contextPath + '/file/list',
        'method': 'GET',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': param,
        'success': (res) => {
            addItem(res.data.list);
        }
    };

    common.sampleAjax(option, true);
}

/**
 * 파일 리스트 출력
 */
function addItem(fileList) {

    $.each(fileList, function (index, item) {

        const innerHTML =
            `<tr class="table-light" fileNo="${item.fileNo}">
                    <th scope="row">${item.fileNo}</th>
                    <td class="fileName">${item.originName}</td>
                    <td>${item.regDate}</td>
                    <td>${item.memId}</td>
            </tr>`;

        $('.fileList').append(innerHTML);
    });
}

/**
 * 파일 상세
 */
function fileDetail(fileNo) {

    // 파일 단건 조회
    const option = {
        'url': contextPath + '/file/' + fileNo,
        'method': 'GET',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': null,
        'success': (res) => {
            $('.fileModal .originName').text(res.data.originName);
            $('.fileModal .fileDesc').text(res.data.fileDesc);
            $('.fileModal').modal();
        }
    };

    common.sampleAjax(option, true);

}


