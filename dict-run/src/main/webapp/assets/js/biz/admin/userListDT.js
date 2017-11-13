require(['jquery', 'bootstrap', 'dataTable', 'underscore', 'layer', 'dataTablePush', 'utils'], function () {
	var webRoot = G_WEB_ROOT;
	var urls = {
		findAll: webRoot + '/user/findAll.do',	//查询所有员工
		operateUser: webRoot + '/user/operateUser.do', // 操作
		queryPerms: webRoot + '/user/queryPerms.do',	// 查询权限
		findRoleOfUser: webRoot + '/user/findRoleOfUser',	// 根据用户信息查询角色
		addUserRoles: webRoot + '/user/addUserRoles'	// 根据用户信息查询角色
	}
	var style = {
		btnColor: "btn-default",
		iconColor: "glyphiconColor"
	}

	// //////////////////////////////////////////////////////
	// table1
	// //////////////////////////////////////////////////////
	var dtSetting = {
		tableId: "#example",
		showTool: true,
		showNum: true,
		showCheckBox: true,
		ajax: {
			url: urls.findAll,
			type: 'POST',
		},
		"serverSide": true,
		"ordering": false,
		"columns": [{
			"data": null
		}, // checkbox
		{
			"data": null
		}, // 添加序号
		{
			"data": "userKey"
		}, {
			"data": "userNameCh"
		}, {
			"data": "note"
		}, {
			"data": "createTime"
		}, {
			"data": "modifyTime"
		}],
		"columnDefs": [{
			"targets": 0,
			"render": function (a, b, c, d) {
				return '<input type="checkbox" name=' + c.userId + ' value=' + c.userId + ' />'
			}
		}, {
			"targets": 7,
			"render": function (data, type, row, meta) {
				var role = '<button type="button" class="btn '
					+ style.btnColor
					+ ' btn-sm _role" data-id='
					+ row.userId
					+ ' data-name='
					+ row.userNameCh
					+ '  ">配置角色  <span class="glyphicon glyphicon-th-list '
					+ style.iconColor + '" /></button>';
				return role;
			}
		}],
	}
	var table = $("#example").dataTablePush(dtSetting);
	// 添加序号
	// 不管是排序，还是分页，还是搜索最后都会重画，这里监听draw事件即可
	table.on('draw.dt', function () { initEvents(); }).draw();

	// 初始化事件
	function initEvents() {
		$("#save").unbind().bind('click', function () {
			add();
		});
		$("#delBatch").unbind().bind('click', function () {
			var checkIds = $("input[name=checkIds]").val();
			if (checkIds.length == 0) {
				layer.msg('最少选一个删除。。', {
					icon: 5
				});
			} else {
				layer.msg('您确定要删除？', {
					time: 0, // 不自动关闭
					btn: ['必须啊', '想想好了'],
					yes: function (index) {
						del(checkIds);
					},
					icon: 5
				});
			}
		});
		$('._role').unbind().bind('click', function (e) {
			var _this = $(this);
			var userObj = {
				userId: _this.attr('data-id'),
				userNameCh: _this.attr('data-name')
			}
			configRoleEvent(userObj, e);
		});
		$('#confirmRoleBtn').click(function () {  //弹出层点击事件
			confirmRoleEvent();
		});
	}
	function add() {
		var inputs = $("#addModal .modal-body input");
		var items = [];
		$.each(inputs, function (i, o) {
			var txt = $(o).val();
			items.push(txt);
		});
		var param = {
			"userDto": {
				"userKey": items[0],
				"userNameCh": items[1],
				"note": items[2]
			},
			"oper": "add"
		}
		ajax(urls.operateUser, JSON.stringify(param), 1);
	}
	function del(ids) {
		var param = {
			"userDto": { "userId": ids }, "oper": "del"
		};
		ajax(urls.operateUser, JSON.stringify(param), 1);
	}

	function confirmRoleEvent() {
		var userId = $('#roleUserId').val();
		var roleIds = [];
		var selectItems = $('#isSelectPanel').children();
		$.each(selectItems, function (i, item) {
			roleIds.push($(item).attr('data-id'));
		});
		ajax(urls.addUserRoles, { 'userId': userId, 'roleIds': roleIds }, 0);
	}


	function configRoleEvent(obj, e) {
		var userId = obj.userId;
		var label = '(' + obj.userNameCh + ')';
		$('#roleUserId').val(userId);
		$('#userRoleModalLabel small').text(label);

		Tc.ajax({
			url: urls.findRoleOfUser,
			data: { 'userId': userId },
			success: function (rs) {
				var notSelect = '', isSelect = '';
				$.each(rs, function (i, obj) {
					var selected = obj.isSelect;
					var _link = '<a href="javascript:void(0)" data-id="'
						+ obj.roleId + '" data-select="' + selected
						+ '" class="list-group-item">' + obj.roleName
						+ '</a>';
					if (selected) {
						isSelect += _link;
					} else {
						notSelect += _link;
					}
				});
				$('#notSelectPanel').html(notSelect);
				$('#isSelectPanel').html(isSelect);
				$('#modalPanel .list-group-item').unbind().bind('click', function (e) {
					selectItemEvent(this);
				});
				$('#userRoleModal').modal('show');
			}
		});
	}
	function selectItemEvent(obj) {
		var _this = $(obj);
		var newObj = obj;
		var isSelect = _this.attr('data-select');
		var _parentPanel = isSelect == 0 ? $('#isSelectPanel') : $('#notSelectPanel');
		$(newObj).attr('data-select', isSelect == 0 ? 1 : 0);
		_this.remove();
		_parentPanel.append(newObj);
		$('#modalPanel .list-group-item').unbind().bind('click', function (e) {
			selectItemEvent(this);
		});
	}



	function ajax(url, param, _contentType) {
		_contentType = _contentType == 1 ? 'application/json;charset=utf-8' : 'application/x-www-form-urlencoded; charset=UTF-8';
		Tc.ajax({
			url: url,
			data: param,
			contentType: _contentType,
			success: function (rs) {
				table.ajax.reload();
				infoTable.ajax.reload();
				$(".modal").modal("hide");
				if (rs) {
					layer.msg('亲，操作已完成...', { icon: 6 });
				}
			}
		});
	}
	// //////////////////////////////////////////////////////
	// table2
	// //////////////////////////////////////////////////////
	var infoTable = {
		tableId: "#infoTable",
		showCheckBox: false,
		autoWidth: true,
		ajax: {
			url: urls.queryPerms,
			type: 'POST',
		},
		"serverSide": true,
		"ordering": false,
		//				"scrollX" : true,
		"columns": [{
			"data": "userKey"
		}, {
			"data": "userNameCh"
		}, {
			"data": "roleRank"
		}, {
			"data": "funRank"
		}/*, {
					"data" : "organRank",
					"width" : "100px",
				}*/ ]
	}
	var infoTable = $("#infoTable").dataTablePush(infoTable);
});