
/**
 * 确认签署 原版
 *
 * funObj  原来的签署方法
 *
 * thisParam 原来签署方法中有this的改为这个参数传this
 * 
 * 原来
 *onclick="confirmSign(this);"
 *onclick="confirmSign();"
 *
 * 现在
 *onclick="submit_Sign_original('confirmSign',this);"
 *onclick="submit_Sign_original('confirmSign');"
 *
 */

// function submit_Sign_original(funObj, thisParam){
// 	var boo_ss = 0;
// 	var boo_ss_msg = "";
//
// 	// if(0 == boo_ss){
// 	// 	if (!$("input[type ='checkbox']")[0].checked){
// 	// 		boo_ss++;
// 	// 		boo_ss_msg = "请先勾选仔细阅读。";
// 	// 	}
// 	// }
// 	if(0 == boo_ss){
// 		if (!$("input[type ='checkbox']")[1].checked){
// 			boo_ss++;
// 			boo_ss_msg = "请先勾选同意签署。";
// 		}
// 	}
// 	//验证码
// 	if(0 == boo_ss){
// 		var smsCode = document.getElementById("sms_code").value;
// 		if(6 > smsCode.length){
// 			boo_ss++;
// 			boo_ss_msg = "请输入正确验证码。";
// 		}
// 	}
//
// 	if(0 == boo_ss){
// 		if (productNo && (productNo=='9F' || productNo=='11F')){
// 			var res = checkAjaxCODE();
// 			if (res!=null){
// 				boo_ss++;
// 				boo_ss_msg = res;
// 			}
// 		}
// 	}
//
//
// 	//签署
// 	if(0 == boo_ss){
// 		if (funObj) {
// 			var config_sign_elem = $("#config_sign");
// 			var onclick_function = config_sign_elem.attr("onclick");
// 			//禁用按钮
// 			config_sign_elem.removeAttr("onclick");
// 			//弹出 【个人信用报告查询与上报授权书】 页面
// 			$("#contract_show").html(contract_data("credit_report"));
// 			$("#contract_div").show();
// 			//默认3秒
// 			var curCount = 3;
// 			document.getElementById("text_msg").innerHTML = "剩余"+ curCount +"秒关闭";
// 			//启动计时器，1秒执行一次
// 			var InterValObj = window.setInterval(function() {
// 				if (0 == curCount) {
// 					//停止计时器
// 					window.clearInterval(InterValObj);
// 					$("#contract_div").hide();
// 					//启用按钮
// 					config_sign_elem.attr("onclick", onclick_function);
// 					//触发原来的确认函数
// 					if(thisParam){
// 						window[funObj](thisParam);
// 					}else{
// 						window[funObj]();
// 					}
// 				} else {
// 					//当前剩余秒数
// 					document.getElementById("text_msg").innerHTML = "剩余"+  --curCount  +"秒关闭";
// 				}
// 			}, 1000);
// 		}
// 	}else{
// 		alert(boo_ss_msg);
// 	}
// }



/**
 * 确认签署 现在版
 *
 * funObj  原来的签署方法
 *
 * thisParam 原来签署方法中有this的改为这个参数传this
 * 
 * 原来
 *onclick="confirmSign(this);"
 *onclick="confirmSign();"
 *
 * 现在
 *onclick="submit_Sign('confirmSign',this);"
 *onclick="submit_Sign('confirmSign');"
 *
 */
function submit_Sign(funObj, thisParam){
	var boo_ss = 0;
	var boo_ss_msg = "";

	if(0 == boo_ss){
		if (!$("input[type ='checkbox']")[1].checked){
			boo_ss++;
			boo_ss_msg = "请先勾选同意签署。";
		}
	}
	//验证码
	if(0 == boo_ss){
		var smsCode = document.getElementById("sms_code").value;
		if(4!= smsCode.length){
			boo_ss++;
			boo_ss_msg = "请输入正确验证码。";
		}
	}

	if(0 == boo_ss){
		if (productNo && (productNo=='9F' || productNo=='11F')){
			var res = checkAjaxCODE();
			if (res!=null){
				boo_ss++;
				boo_ss_msg = res;
			}
		}
	}

	//签署
	if(0 == boo_ss){
		if (funObj) {
			//触发原来的确认函数
			if(thisParam){
				window[funObj](thisParam); 
			}else{
				window[funObj]();
			}
		}
	}else{
		alert(boo_ss_msg);
	}
}

//强制阅读弹出框
var mustRead='<div style=" margin:0 auto"><h2 style="text-align: center">授权及协议须知</h2><br><p>申请使用“和分期服务”，您需要同意本须知中的所有内容：</p><p style="text-indent: 24px">1.您使用“和分期服务”，须分别与重庆小雨点小额贷款有限公司、霍尔果斯爱尚企业咨询管理有限公司（本须知中统称“服务商”）签订《借款合同》、《和分期服务协议》，并授权服务商查询包括但不限于：您的信用信息、个人身份信息、运营商通话信息、等，用于评估服务商与您的交易条件和控制服务中的风险，有效期至服务商对您使用“和分期服务”申请审核不通过日止（和分期服务未获批的情形下），或者您使用的“和分期服务”终止日止（和分期服务获批的情形下）。</p><p style="text-indent: 24px">2.为了能让您在和分期处的信用信息及时被服务商查询，如果您还不是和分期的用户，您应该同意并签订本须知所附的《和分期服务协议》成为和分期用户。如果您已经是和分期用户，您无需重复签订本须知所附的《和分期服务协议》。</p><p style="text-indent: 24px">3.《和分期服务协议》、《和分期用户服务说明》被放置在同一文档中进行签约的目的在于尽可能减少协议展示所占用的系统空间，这种协议展现形式并不影响您签约后根据不同协议所享有的权利及需要履行的义务，您对此不持异议。</p></div>'
/**
 * 页面加载完成自动弹出显示
 */
function showContract(){
	//弹出 【个人信用报告查询与上报授权书】 页面
	$("#contract_show").html(mustRead);
	$("#contract_div").show();
	//默认3秒
	var curCount = 2;
	document.getElementById("text_msg").innerHTML = "剩余"+ curCount +"秒关闭";
	//启动计时器，1秒执行一次
	var InterValObj = window.setInterval(function() {
		if (0 == curCount) {
			//停止计时器
			window.clearInterval(InterValObj);
			$("#contract_div").hide();
		} else {
			//当前剩余秒数
			document.getElementById("text_msg").innerHTML = "剩余"+  --curCount  +"秒关闭";
		}
	}, 1000);
}


//动态添加确认签约时弹出的页面
$(function(){
	//默认样式
	var defaultButtonStyle = "width:90%;margin:0px auto;text-align:center;";
	defaultButtonStyle += "height:30px;line-height:30px;border:none;";
	defaultButtonStyle += "border-radius:5px;color:#fff;background:#1379d8;";
	defaultButtonStyle += "font-size:15px;font-weight:700;";
	//buttonStyleId的input中自己定义样式，不指定使用默认样式
	var buttonStyle = $("#buttonStyleId").val();

	var msg_div_info = "<div class='box' id='contract_div' style='display:none'>";
	msg_div_info += "<div id='contract_show' style='height:91%;overflow:auto;'></div>";
	msg_div_info += "<div id='text_msg' style='";
	msg_div_info += buttonStyle ? buttonStyle : defaultButtonStyle;
	msg_div_info += "'></div>";
	msg_div_info += "</div>";
	$("#main").after(msg_div_info);

	//页面加载完成自动弹出显示
	showContract();
});
