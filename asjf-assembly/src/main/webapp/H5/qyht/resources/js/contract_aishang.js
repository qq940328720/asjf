/**
 *  弹出层
 */
$('.close').click(function () {
    $(this).parent().hide("normal")
})
$('.show-box01').click(function () {
    var id = $('.b1').children("div").attr('id')
    $('#' + id).html(contract_data(id))
    $('.b1').show()
})
// $('.show-box02').click(function () {
//     var id = $('.b2').children("div").attr('id')
//     $('#' + id).html(contract_data(id))
//     $('.b2').show()
// })
$('.show-box03').click(function () {
    var id = $('.b3').children("div").attr('id')
    $('#' + id).html(contract_data(id))
    $('.b3').show()
})
$('.show-box04').click(function () {
    debugger
    var id = $('.b4').children("div").attr('id')
    $('#' + id).html(contract_data(id))
    $('.b4').show()
})
$('.show-box05').click(function () {
    var id = $('.b5').children("div").attr('id')
    $('#' + id).html(contract_data(id))
    $('.b5').show()
})

/**
 * 查看合同
 * @type {any}
 */

var ctx = $('#ctx').val()
var orderNo = $('#orderNo').val()
var productNo = $('#productNo').val()
var sourceSites = $('#sourceSites').val()
var name = $('#name').val()
var nationalId = $('#nationalId').val()
var phone = $('#phone').val()
var loanNumber = $('#loanNumber').val()
var accountId = $('#accountId').val()
var redirectURL = $('#redirectURL').val()


function contract_data(id) {
    var data
    var post_options = {
        url: ctx + '/businessapi/ops/esign/contract/' + productNo + "/" + orderNo + "/" + accountId + "/" + loanNumber + "/" + id,
        type: 'get',
        async: false,
        success: function (request) {
            data = request
        }
    }
    $.post(post_options)
    return data
}

/**
 * 获取合同验证码
 * @param obj
 */



function sendSMS(obj) {
    var array = new Array()
    var id = obj.id
    sendLoading(id) //改变页面状态

    $('.text').each(function () {
        var type = $(this).attr('id')
        array.push(type)
    })
    var post_options = {
        url: "/cust/sig/sms/v1",
        type: "GET",
        async: true,
        traditional: true,
        beforeSend: function () {
            $('.box2').html('正在获取验证码......')
            $('.maskbox').removeClass('none')
        },
        success: function (request) {
            console.log(request)
            var code = request.code;
            if (code == 100) {
                sendMessage(id)
                $('.maskbox').addClass('none')
                if(request.message){
                    alert(request.message)
                }
            } else {
                alert('获取短信失败');
                $('.maskbox').addClass('none')
                loading(id)
            }
        }
    }
    $.get(post_options)
}


function sendLoading(id) {

    $("#" + id).removeAttr("onclick");// 禁用按钮
    $("#" + id).removeAttr("href");// 禁用按钮
    $("#" + id).text("正在获取");
}

function loading(id) {
    $("#" + id).attr("onclick", "javascript:sendSMS(this)");// 启用按钮
    $("#" + id).attr("href", "javascript:void(0)");// 启用按钮
    $("#" + id).text("");
    $("#" + id).text("获取验证码");
}


// 验证码
var InterValObj; // timer变量，控制时间
var count = 60; // 间隔函数，1秒执行
var curCount;// 当前剩余秒数
function sendMessage(id) {
    curCount = count;
    // 设置button效果，开始计时
    // $("#btnSendCode").attr("disabled", "true");
    // $("#btnSendCode").removeAttr("href");// 禁用按钮
    $("#sms_code").removeAttr("readonly")
    $("#" + id).text("");
    $("#" + id).text("还剩" + curCount + "秒");
    InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次
}

// timer处理函数
function SetRemainTime() {
    if (curCount == 0) {
        window.clearInterval(InterValObj);// 停止计时器
        $("#send_sms").attr("onclick", "javascript:sendSMS(this)");// 启用按钮
        $("#send_sms").attr("href", "javascript:void(0)");// 启用按钮
        $("#send_sms").text("重新发送");
    } else {
        curCount--;
        $("#send_sms").text("还剩" + curCount + "秒");
    }
}


/**
 * 确认签署合同
 */

function confirmSign(obj) {
    if (checkBox() && checkCODE()) {
        loadingConfirm(obj.id)
        confirm(obj.id)
    } else {
        $('.maskbox').hide()
        alert(errMsg)
    }
}

function loadingConfirm(id) {
    $("#" + id).removeAttr("onclick"); // 禁用按钮
    $("#" + id).text("正在签署");
}

function freeConfirm(id) {
    $("#" + id).attr("onclick", 'confirmSign(this)'); // 启用按钮
    $("#" + id).text("确认签署");
}


// 1.验证码是否正确
var errMsg = ''
function checkCODE() {
    var flag = false
    var code = $('#sms_code').val()
    if (code == null || code == "" || code.length != 6) {
        errMsg = '请输入6位短信验证码'
        return flag
    }
    var post_options = {
        url: ctx + "/businessapi/ops/esign/esignSMSCheck",
        type: "POST",
        data: {
            code: code,
            productNo: productNo
        },
        async: false,
        traditional: true,
        success: function (request) {
            var code = (request.code)
            console.log(code)
            if (code == 0) {
                flag = true
            } else {
                errMsg = request.message
            }
        }
    }
    $.ajax(post_options)
    return flag
}
//2.检查是否勾选 同意签署按钮
function checkBox() {
    if ($("input[type = 'checkbox']")[0].checked && $("input[type = 'checkbox']")[1].checked) {
        return true
    }
    if (!$("input[type = 'checkbox']")[0].checked){
        errMsg = '请先勾选仔细阅读'
    }
    if (!$("input[type = 'checkbox']")[1].checked){
        errMsg = '请先勾选同意签署'
    }
    return false
}


//3.正式处理签署合同

function confirm(id) {
    var array = new Array()
    $(".text").each(function () {
        var type = $(this).attr('id')
        array.push(type)
    })
    var post_options = {
        url: ctx + "/businessapi/ops/esign/esignConfirm",
        type: "POST",
        data: {
            order_no: orderNo,
            loan_number: loanNumber,
            product_no: productNo,
            account_id: accountId,
            contract_types: array
        },
        async: true,
        traditional: true,
        beforeSend: function () {
            console.log(1)
            $('.box2').html('正在签署合同......')
            $('.maskbox').removeClass('none')
        },
        success: function (request) {
            var code = (request.code)
            if (code == 0) {
                if (redirectURL != null && redirectURL != '' && redirectURL != 'null') {
                    $('.box2').html('签署合同成功,3秒后跳转......')
                    console.log('即将跳转到 ' + redirectURL)
                    setTimeout(window.location.href=redirectURL, 3000)
                } else {
                    $('.box2').html('签署合同成功......')
                    return false
                }
            } else {
                if (code == '3005') {
                    window.location.reload()
                }
                freeConfirm(id)
                errMsg = request.message
                $('.box2').html(errMsg)
                // $('.maskbox').addClass('none')
                return false
            }
        }
    }
    $.ajax(post_options)
}



