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

        const fileNo = $(this).closest('tr').attr('fileNo');
        fileDetail(fileNo);
    });

    /**
     * 다운로드 버튼 클릭
     */
    $('.fileModal .download').click(function () {

        const fileNo = $('.fileModal').attr('fileNo');
        location.href = '/view/file/' + fileNo;
    });

    /**
     * 페이지 번호 클릭
     */
    $(document).on('click', 'a[class="page-link"]', function () {

        const pageNum = $(this).attr('pageNum');
        $('.filePaging').attr('pageNum', pageNum);

        getFileList();
    });

    /**
     * 검색버튼 클릭
     */
    $('.searchBtn').click(function () {
        getFileList();
    });
}

/**
 * 파일 리스트
 */
function getFileList() {

    const page = $('.filePaging').attr('pageNum');
    const searchType = $('#fileSearch option:selected').val();
    const searchWord = $('.searchWord').val();

    const param = {
        page,
        pageRange: 5,
        searchType,
        searchWord
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

    const totalPage = res.data.cnt; // 총 파일 개수
    const pageRange = res.data.pageRange;  // 페이지당 출력할 파일 개수
    const pageNum = Math.ceil(totalPage / pageRange);  // 페이지 개수
    const currentPage = res.data.page;  // 현재 페이지 번호

    let startPage = 1;
    let endPage = pageNum;

    if (5 < pageNum) {

        startPage = (currentPage - 2) <= 0 ? 1 : currentPage - 2;
        endPage = (startPage + 4) > pageNum ? pageNum : startPage + 4;

        startPage = (startPage + 4) > pageNum ? startPage - ((startPage + 4) - pageNum) : startPage;
    }

    let innerPageNum =
        `<li class="page-item ${1 == startPage ? 'disabled' : ''}">
                <a class="page-link" href="#" pageNum="1">«</a>
         </li>`;

    for (let i = startPage; i <= endPage; i++) {

        innerPageNum +=
            `<li class="page-item ${i == currentPage ? 'active' : ''}">
                <a class="page-link" href="#" pageNum="${i}">${i}</a>
             </li>`;
    }

    innerPageNum +=
        `<li class="page-item ${pageNum == endPage ? 'disabled' : ''}">
                <a class="page-link" href="#" pageNum="${pageNum}">»</a>
         </li>`;

    $('.filePaging').empty();
    $('.filePaging').append(innerPageNum);
}


