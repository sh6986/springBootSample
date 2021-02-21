$(document).ready(function() {

    initPage();
    setEventListener();
});

/**
 * 화면 초기화
 */
function initPage() {

    // 파일 리스트
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

        const fileNo = $(this).closest('tr').attr('fileNo');
        fileDetail(fileNo);
    });

    /**
     * 다운로드 클릭
     */
    $('.fileModal').click(function () {

        const fileNo = $('.fileModal').attr('fileNo');
        location.href = '/view/file/' + fileNo;
    });

    /**
     * 페이지 번호 클릭
     */
    $(document).on('click', 'a[class="page-link"]', function () {
        const page = $(this).text();
        getFileList(page);
    });
}

/**
 * 파일 리스트
 */
function getFileList(page) {

    const param = {
        page: page
    };

    const option = {
        'url': contextPath + '/file/list',
        'method': 'GET',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': param,
        'success': (res) => {
            addItem(res);
            paging(res);
        }
    };

    common.sampleAjax(option, true);
}

/**
 * 파일 리스트 출력
 */
function addItem(res) {

    $('.fileList').empty();

    $.each(res.data.list, function (index, item) {

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
            $('.fileModal').attr('fileNo', fileNo);
            $('.fileModal .originName').text(res.data.originName);
            $('.fileModal .fileDesc').text(res.data.fileDesc);
            $('.fileModal').modal();
        }
    };

    common.sampleAjax(option, true);

}

/**
 * 페이징
 */
function paging(res) {

    console.log(res);
    const totalPage = res.data.cnt;
    const pageRange = 10;
    const pageNum = (totalPage / pageRange) + 1;

    let innerPageNum =
        `<li class="page-item disabled">
                <a class="page-link" href="#">«</a>
         </li>`;

    for (let i = 1; i <= pageNum; i++) {

        innerPageNum +=
            `<li class="page-item ${i == res.data.page ? 'active' : ''}">
                <a class="page-link" href="#">${i}</a>
             </li>`;

    }

    innerPageNum +=
        `<li class="page-item disabled">
                <a class="page-link" href="#">»</a>
         </li>`;

    $('.filePaging').empty();
    $('.filePaging').append(innerPageNum);
}


