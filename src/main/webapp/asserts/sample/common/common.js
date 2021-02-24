/**
 * 배열로부터 지정된 아이템을 삭제
 *
 * @param item 삭제할 아이템
 * @returns 삭제된 아이템
 */
Array.prototype.removeItem = function( item ) {
    var idx = this.indexOf( item );
    if( idx < 0 ) {
        return null;
    }
    this.splice( idx, 1 );
};

const common = {

    ajax : function(url, data, type, successFn, errorFn) {

        $.ajax({
            url: url,
            data: data,
            type: type,
            contentType : 'application/json; charset=UTF-8',
            dataType : 'json',
            success : successFn,
            error : errorFn,
        })
    },

    loadingstart : function(){
        //TODO : 로딩바시작

    },


    loadingEnd : function(){
    //TODO : 로딩바제거
    },

    removeItem : function(list,item) {
        var idx = list.indexOf( item );
        if( idx < 0 ) {
            return null;
        }
        list.splice( idx, 1 );
    },

    SUCCESS_COMMON_CODE_LIST : ['1'],
    ajaxHistory : [],
    URLS : {
        loginPageUrl : '/view/member/login',
        loginProcessUrl : '/member/login',
        logOutUrl : '/member/logout'

    },
    ajaxCount : 0,
    contextPath : '/',
    sampleAjax : function (options, showLoader) {
        if (!(common.SUCCESS_COMMON_CODE_LIST.indexOf(options.url) > -1) && common.contextPath != '/' ) {
            options.url = this.contextPath+options.url;
        }
        //기존 요청 재요청 불가
        if (common.ajaxHistory.indexOf(options.url) > -1) {
            return false;
        }

        common.ajaxHistory.push(options.url);


        var _options = {
            'url'      : '',
            'method'   : 'GET', // GET, POST, PUT, DELETE
            'dataType' : 'json', // xml, html, script, json, jsonp, text
            'data'     : {}
        };
        $.extend(_options, options);

        $.extend(_options, {
            'beforeSend' : function(xhr, settings) {
                if (showLoader && common.ajaxCount++ == 0) {
                    //로딩바 시작
                    common.loadingstart();
                }
                if(typeof options.beforeSend == 'function') {
                    options.beforeSend(xhr, settings);
                }
            },
            'success' : function(result, status, xhr) {
                if (xhr.status == 200 && common.SUCCESS_COMMON_CODE_LIST.indexOf(result.code) > -1) {
                    if (typeof options.success == 'function') {
                        options.success(result, status, xhr);
                    }
                }
                else if (typeof result != 'undefined' && result.hasOwnProperty('application')) {
                    if (application.result
                        && application.result == 'success'
                        && typeof options.success == 'function') {
                        options.success(result, status, xhr);
                    }
                    else if(typeof options.error == 'function') {
                        options.error(xhr, status, result);
                    }
                }
                else {
                    options.error(xhr, status, result);
                }
            },
            'error' : function(xhr, status, error) {
                var statusCode = xhr.status;
                var errorMessage = xhr.responseJSON && xhr.responseJSON.msg ? xhr.responseJSON.msg  : '일시적인 오류가 발생하였습니다. 잠시 후에 다시 이용해주시기 바랍니다.';
                var errorCode = xhr.responseJSON && xhr.responseJSON.code ? xhr.responseJSON.code : '' ;

                if (statusCode == 401  ){ // 비로그인상태
                    if ( options.url != this.URLS.loginProcessUrl) {
                        alert('로그인후 가능하십니다.');
                        location.href = this.URLS.loginPageUrl;
                        return;
                    }
                } else if ( statusCode == 400 ){  //bad request
                    alert(errorMessage)
                } else if ( statusCode == 204 ){  //데이터 없음.
                    //options.error(xhr, status, error);
                } else if (typeof options.error == 'function'){
                    alert('일시적인 오류가 발생하였습니다. 잠시 후에 다시 이용해주시기 바랍니다.');
                }

                if(typeof options.error == 'function') {
                    options.error(xhr, status, error);
                }

            },
            'complete' : function(xhr, status) {
                if(typeof options.complete == 'function') {
                    options.complete(xhr, status);
                }
                if(showLoader && --common.ajaxCount == 0) {
                    common.loadingEnd();
                }
                //common.removeItem(common.ajaxHistory,options.url);
                common.ajaxHistory.removeItem(options.url);
            }


        });

        $.ajax(_options);
    },

    /**
     * 빈칸체크
     * @param value
     * @returns {boolean}
     */
    isEmpty: function (value) {

        if (null === value || undefined === value || 'undefined' === value || '' === value) {
            return true;
        }
        
        return false;
    }
}