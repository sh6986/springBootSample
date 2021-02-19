$(document).ready(function() {

    initPage();
    setEventListener();

    console.log($('.hi').text());
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
    $('.fileName').on('click', function () {
        console.log('aaa');

    });

    $(document).on('click', '')

    console.log($('.hi').text());

    $('.fileName').on('click', function () {
        console.log('aaa');

    });

}

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
            `<tr class="table-light">
                    <th scope="row">${item.fileNo}</th>
                    <td class="fileName">${item.originName}</td>
                    <td>${item.regDate}</td>
                    <td>${item.memId}</td>
            </tr>`;

        $('.fileList').append(innerHTML);
    });
}

