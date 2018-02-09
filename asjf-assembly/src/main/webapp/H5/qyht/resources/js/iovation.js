setTimeout(iovation, 3000);

function iovation() {
	try {
		var fp_blackbox_info = fpGetBlackbox();
		var io_blackbox_info = ioGetBlackbox();
		send(fp_blackbox_info, io_blackbox_info);
	} catch (e) {
		console.log(e);
	}
}

function send(fp_blackbox_info, io_blackbox_info) {
	if (fp_blackbox_info.finished && io_blackbox_info.finished) {
		var fpBlackBox = fp_blackbox_info.blackbox;
		var ioBlackBox = io_blackbox_info.blackbox;
		var beginblackbox = fpBlackBox + ";" + ioBlackBox;
		
		var io_loan_number = document.getElementById("loanNumber").value;
		var io_order_no = document.getElementById("orderNo").value;
		var io_product_no = document.getElementById("productNo").value;
		var io_accept_id = document.getElementById("acceptId");
		if(io_accept_id){
			io_accept_id = io_accept_id.value;
		}else{
			io_accept_id = "";
		}

		$.ajax({
			url: "/businessapi/ops/iovation/checkTransactionDetails",
			type: "post",
			data: {
				"beginblackbox" : beginblackbox,
				"page" : "step6",
				"loanNumber" : io_loan_number,
				"orderNo" : io_order_no,
				"productNo" : io_product_no,
				"acceptId" : io_accept_id
			},
			dataType: "text",
			success: function (data) {
				console.log(data);
			}
		});
	} else {
		setTimeout(send(fp_blackbox_info, io_blackbox_info), 2000);
	}
}
