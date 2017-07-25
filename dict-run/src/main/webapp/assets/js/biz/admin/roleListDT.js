require(['jquery', 'bootstrap', 'dataTable', 'underscore', 'layer'], function () {
	var webRoot = G_WEB_ROOT;
	var urls = {
		operateRole: webRoot + '/role/operateRole.do',
		findAll: webRoot + '/role/findAll.do',
	}
	layer.config({
		path: webRoot + '/assets/plugin/layer-v3.0.3/layer/' //layer.js所在的目录，可以是绝对目录，也可以是相对目录
	});
	var style = {
		btnColor: "btn-default",
		iconColor: "glyphiconColor"
	}

	var dtSetting = {
		ajax: {
			url: urls.findAll,
			type: 'POST',
			//	            success:function(rs){
			//	            	console.log(rs);
			//	            	table.on( 'xhr', function () {
			//	                var json = table.ajax.json();
			//	                alert( json.data.length +' row(s) were loaded' );
			//	            } );
			//	            }
		},
		//	        "order": [[1, 'asc']],// dt默认是第一列升序排列 这里第一列为序号列，所以设置为不排序，并把默认的排序列设置到后面
		"serverSide": true,
		"ordering": false,
		"columns": [
			{ "data": null },	// checkbox
			{ "data": null },	// 添加序号
			{ "data": "roleKey" },
			{ "data": "roleName" },
			{ "data": "note" },
			{ "data": "createTime" },
			{ "data": "modifyTime" }
		],
		"columnDefs": [{
			"targets": 0,
			"render": function (a, b, c, d) { return '<input type="checkbox" name=' + c.roleId + ' value=' + c.roleId + ' />' }
		}, {
			"targets": 7,
			"render": function (data, type, row, meta) {
				var fun = '<button type="button" class="btn ' + style.btnColor + ' btn-sm _fun" data-index=' + row.roleId + '  ">配置功能  <span class="glyphicon glyphicon-th-list '+style.iconColor+'" /></button>';
				var org = '<button type="button" class="btn ' + style.btnColor + ' btn-sm _org" data-index=' + row.roleId + '  ">配置数据  <span class=" glyphicon glyphicon-list-alt '+style.iconColor+'" /></button>';
				var edit = '<button type="button" class="btn ' + style.btnColor + ' btn-sm _edit" data-id=' + row.roleId + ' data-key=' + row.roleKey + ' data-name=' + row.roleName + ' data-note=' + row.note + ' data-toggle="modal" data-target="#myModal" >修改  <span class="glyphicon glyphicon-wrench '+style.iconColor+'"></span></button>';
				var del = '<button type="button" class="btn ' + style.btnColor + ' btn-sm _del" data-index=' + row.roleId + ' data-toggle="modal" data-target="#delModal">删除  <span class="glyphicon glyphicon-remove '+style.iconColor+'"></span></button>';
				return fun + "&nbsp&nbsp" + org + "&nbsp&nbsp" + edit + "&nbsp&nbsp" + del + "&nbsp&nbsp";
			}
		}],
		"language": {
			"lengthMenu": '显示 <select>' +
			'	<option value="10">10</option>' +
			'	<option value="20">20</option>' +
			'	<option value="30">30</option>' +
			'	<option value="-1">所有</option>' +
			'</select> 记录',
			"zeroRecords": "没有找到记录",
			"info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
			"infoEmpty": "显示第 0 至 0 项结果，共 0 项",
			"search": "搜索：",
			"infoFiltered": "(从 _MAX_ 条记录过滤)",
			"paginate": {
				"previous": "上一页", "next": "下一页"
			}
		},
		"dom": "<'row'<'col-xs-2'l><'#mytool.col-xs-4'><'col-xs-6'f>r>" +
		"t" +
		"<'row'<'col-xs-6'i><'col-xs-6'p>>",
		"initComplete": function () {
			$("#mytool").append('<button id="delBatch" type="button" class="btn '+ style.btnColor+' btn-sm">批量删除   <span class="glyphicon glyphicon-remove '+style.iconColor+'"></span></button>&nbsp');
			$("#mytool").append('<button id="addRole" type="button" class="btn '+ style.btnColor+' btn-sm" data-toggle="modal" data-target="#myModal">添加  <span class="glyphicon glyphicon-plus '+style.iconColor+'"></span></button>');
		}
	}
	var table = $("#example").DataTable(dtSetting);
	var editFlag = false;
	//添加序号
	//不管是排序，还是分页，还是搜索最后都会重画，这里监听draw事件即可
	table.on('draw.dt', function () {
		table.column(1, {
			search: 'applied',
			order: 'applied'
		}).nodes().each(function (cell, i) {
			//i 从0开始，所以这里先加1
			i = i + 1;
			//服务器模式下获取分页信息
			var page = table.page.info();
			//当前第几页，从0开始
			var pageno = page.page;
			//每页数据
			var length = page.length;
			//行号等于 页数*每页数据长度+行号
			var columnIndex = (i + pageno * length);
			cell.innerHTML = columnIndex;
		});
		initEvents();
	}).draw();


	/**
	 * 初始化事件
	 */
	function initEvents() {
		$("._fun").unbind().bind('click', function () {
			var _this = $(this);
			var id = _this.attr('data-index');
			window.location.href = webRoot + '/role/roleFunction?roleId=' + id;
		});
		$("._org").unbind().bind('click', function () {
			var _this = $(this);
			var id = _this.attr('data-index');
			window.location.href = webRoot + '/role/roleOrgan?roleId=' + id;
		});
		$("#save").unbind().bind('click', function () {
			if (!editFlag) {
				add();
			} else {
				edit();
			}
		});
		$("._edit").unbind().bind('click', function () {
			editFlag = true;
			var _this = $(this);
			var roleId = _this.attr('data-id');
			var roleKey = _this.attr('data-key');
			var roleName = _this.attr('data-name');
			var note = _this.attr('data-note');
			$("#roleId").val(roleId);
			$("#roleKey").val(roleKey);
			$("#roleName").val(roleName);
			$("#note").val(note);
			$("#myModalLabel").text("修改");
		});
		$("._del").unbind().bind('click', function () {
			var _this = $(this);
			var id = _this.attr('data-index');
			$("#roleId").val(id);
		});
		$("#del").unbind().bind('click', function () {
			del($("#roleId").val());
		});
		$("#delBatch").unbind().bind('click', function () {
			var checkIds = $("input[name=checkIds]").val();
			if (checkIds.length == 0) {
				layer.msg('最少选 一个删除。。', { icon: 5 });
			} else {
				layer.msg('您确定要删除？', {
					time: 0 //不自动关闭
					, btn: ['必须啊', '想想好了']
					, yes: function (index) {
						del(checkIds);
					},
					icon: 5
				});
			}
		});
	}

	/**
	 * 添加数据
	 */
	function add() {
		var param = {
			"roleDto": {
				"roleKey": $("#roleKey").val(),
				"roleName": $("#roleName").val(),
				"note": $("#note").val(),
			},
			"oper": "add"
		};
		ajax(param);
	}
	/**
	 *编辑方法
	 **/
	function edit() {
		var param = {
			"roleDto": {
				"roleId": $("#roleId").val(),
				"roleKey": $("#roleKey").val(),
				"roleName": $("#roleName").val(),
				"note": $("#note").val(),
			},
			"oper": "edit"
		};
		ajax(param);
	}
	/**
	 * 删除数据
	 * 
	 * @param name
	 */
	function del(ids) {
		var param = {
			"roleDto": {
				"roleId": ids
			},
			"oper": "del"
		};
		ajax(param);
	}
	/**
	 * 清除
	 */
	function clear() {
		$("#roleKey").val("").attr("disabled", false);
		$("#roleName").val("");
		$("#note").val("");
		editFlag = false;	// 将窗口改回新增
	}
	function ajax(obj) {
		var url = urls.operateRole;
		$.ajax({
			url: url,
			type: 'POST',
			data: JSON.stringify(obj),
			dataType: 'json',
			contentType: 'application/json;charset=utf-8',
			success: function (data) {
				if(data){
					table.ajax.reload();
					layer.msg('亲，操作已完成...', { icon: 6 });
				}else{
					layer.msg('亲，操作失败（角色有用户在使用）...', { icon: 5 });
				}
				$(".modal").modal("hide");
				$("#myModalLabel").text("新增");
				clear();
			}
		});
	}

	/**
	 * 多选选中和取消选中,同时选中第一个单元格单选框,并联动全选单选框
	 */
	$('#example tbody').on('click', 'tr', function (event) {
		var allChecked = $('input[name=allChecked]')[0];//关联全选单选框
		$($(this).children()[0]).children().each(function () {
			if (this.type == "checkbox" && (!$(event.target).is(":checkbox") && $(":checkbox", this).trigger("click"))) {
				if (!this.checked) {
					this.checked = true;
					addValue(this);
					var selected = table.rows('.selected').data().length;//被选中的行数
					//全选单选框的状态处理
					//    					var recordsDisplay=table.page.info().recordsDisplay;//搜索条件过滤后的总行数
					//    					var iDisplayStart=table.page.info().start;// 起始行数
					//    					if(selected === table.page.len()||selected === recordsDisplay||selected === (recordsDisplay - iDisplayStart)){
					//    						allChecked.checked = true;
					//    					}
				} else {
					this.checked = false;
					cancelValue(this);
					//    					allChecked.checked = false;
				}
			}
		});
		$(this).toggleClass('selected');//放在最后处理，以便给checkbox做检测
	});

	/**
	 * 全选按钮被点击事件
	 */
	$('input[name=allChecked]').click(function () {
		if (this.checked) {
			$('#example tbody tr').each(function () {
				if (!$(this).hasClass('selected')) {
					$(this).click();
				}
			});
		} else {
			$('#example tbody tr').click();
		}
	});

	/**
	 * 单选框被选中时将它的value放入隐藏域
	 */
	function addValue(para) {
		var checkIds = $("input[name=checkIds]");
		if (checkIds.val() === "") {
			checkIds.val($(para).val());
		} else {
			checkIds.val(checkIds.val() + "," + $(para).val());
		}

	}

	/**
	 * 单选框取消选中时将它的value移除隐藏域
	 */
	function cancelValue(para) {
		//取消选中checkbox要做的操作
		var checkIds = $("input[name=checkIds]").val();
		var delVal = $(para).val();
		var array = checkIds.split(",");
		var tmp = [];
		for (var i = 0; i < array.length; i++) {
			if (array[i] === delVal) {
				continue;
			} else {
				tmp.push(array[i]);
			}
		}
		$("input[name=checkIds]").val(tmp.join(","));
	}
});
