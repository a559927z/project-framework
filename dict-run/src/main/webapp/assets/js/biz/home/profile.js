require(['jquery', 'utils', 'ajaxUpload', 'editable'], function ($) {

	var webRoot = G_WEB_ROOT;
	var urls = {
		findUserExpInfo: webRoot + "/home/findUserExpInfo",
		savePhotoUser : webRoot +'/home/savePhotoUser',
		importPicFile: webRoot + "/home/fileUpload"
	};
	var lastTimeDeil = '';

	// $.fn.editable.defaults.mode = 'inline';
	// $('#abc').editable({
	// 	type: 'text',
	// 	pk: "1",
	// 	url: "",
	// 	tpl: '<img class="pull-left" src="../../../assets/avatars/avatar5.png">',
	// 	title: "enter username"
	// });

	Tc.ajax({
		url: urls.findUserExpInfo,
		success: function (rs) {
			$('#userKey').text(rs.userKey);

			$('#username').text(rs.userNameCh);
			$('#age').text(rs.age);
			$('#signup').text(rs.joinedDate);
			$('#login').text(rs.lastTime);
			$('#about').text(rs.note);
			if(rs.avatar == null){
				$("#avatar").attr("src",webRoot+"/assets/img/avatars/profile-pic.jpg");
			}else{
				$("#avatar").attr("src",webRoot+rs.avatar);
			}
			lastTimeDeil = rs.lastTime;
		}
	});
	setInterval("lastTime2deil()", 3000)
	window.lastTime2deil = function () {
		var diff = Tc.dateTimeDiff(lastTimeDeil, new Date());
		$('#login').text(diff);
	}

	// 上传头像事件
	function uploadAvatarEvent() {
		// 显示编辑区
		$("#avatar").click(function () {
			$("#changAvatar").show();
			$("#avatar").hide();
		});

		// 模拟点击<input type = file/>
		$("#popupFiledielog").click(function () {
			// 模拟点击<input type = file/>
			$('#myBlogImage').click();
			// 在弹框里点确认，发送后台保存
			$('#myBlogImage').on('change',function(){
				ajaxFileUpload();
			});
		});

		// 确认
		$("#ajaxFileUploadBtn").click(function () {
			$("#changAvatar").hide();
			$("#avatar").show();
			$("#avatar").attr("src",successFilePath).attr("photoId", photoId);
			savePhoto(photoId);
		});

		// 取消
		$("#cancelBtn").click(function () {
			// $("img[id='uploadImage']").hide();
			// $(".file-label").show();
			$("#changAvatar").hide();
			$("#avatar").show();
		});

	}
	uploadAvatarEvent();

	function savePhotoUser(photoId){
		Tc.ajax({
			url: urls.savePhotoUser,
			data: {"photoId":photoId},
			success: function (rs) {
				console.log(rs);
			}
		})
	}

	var successFilePath = webRoot+'';
	var photoId = '';
	function ajaxFileUpload() {
		$.ajaxFileUpload({
			//处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
			url: urls.importPicFile + '?uname=jxzhang',
			secureuri: false,                           //是否启用安全提交,默认为false 
			fileElementId: 'myBlogImage',               //文件选择框的id属性
			dataType: 'text',                           //服务器返回的格式,可以是json或xml等
			success: function (data, status) {            //服务器响应成功时的处理函数
				data = data.replace(/<pre.*?>/g, '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀
				data = data.replace(/<PRE.*?>/g, '');
				data = data.replace("<PRE>", '');
				data = data.replace("</PRE>", '');
				data = data.replace("<pre>", '');
				data = data.replace("</pre>", '');     //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]
				console.log(data);
				var rsArr =  data.split("|");
				if (rsArr[0] == 0) {         //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
					$(".file-label").hide();
					successFilePath = webRoot + rsArr[1];
					photoId = rsArr[2];
					$("img[id='uploadImage']").attr("src", successFilePath).attr("photoId", photoId);
					$("img[id='uploadImage']").width(190);
					$("img[id='uploadImage']").height(200);
					$('#result').html("图片上传成功<br/>");
				} else {
					$('#result').html('图片上传失败，请重试！！');
				}
			},
			error: function (data, status, e) { //服务器响应失败时的处理函数
				$('#result').html('图片上传失败，请重试！！');
			}
		});
	}



});