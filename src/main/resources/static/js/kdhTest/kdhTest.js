$(function() {

    $('#chkUserId').click(function() {

        let userId = $('input[name="userId"]').val();

        let kdhTestInPayload = {
            kdhTestInDto : {userId : userId}
        };

        $.ajax({
            method   : 'POST',
            url      : '/test/chkId',
            dataType : 'json',
            data     : JSON.stringify(kdhTestInPayload),
            headers : {
                "Content-Type" : "application/json",
                "X-HTTP-Method-Override" : "POST"
            },
            success  : function(result) {   // 호출 성공 시 후 처리

                if(typeof result.kdhTestOutDto != 'undefined' && result.kdhTestOutDto != null) {
                    let alertMsg = '';

                    let ds = result.kdhTestOutDto;

                    console.log('result.kdhTestOutDto.resultMsg : ' + ds.resultMsg);
                    console.log('result.kdhTestOutDto.resultMsg : ' + ds.userId);
                    console.log('result.kdhTestOutDto.resultMsg : ' + ds.userName);

                    // id가 없으면
                    if(ds.userId == '' || ds.userId == null) {
                        alertMsg = ds.resultMsg;
                    } else {
                        alertMsg = ds.resultMsg + '[' + ds.userId + ']';
                    }

                    alert(alertMsg);
                }
            },
            error    : function(request, status, error) {       // 호출 실패 시 처리
                console.log('ajax Call Error : ' + error);
            }
        });

    });

});
