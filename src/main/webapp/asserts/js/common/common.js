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
    }
}