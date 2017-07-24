require(
		[ 'jquery', 'bootstrap', 'dataTable', 'underscore', 'layer',
				'dataTablePush' ],
		function() {
			var webRoot = G_WEB_ROOT;
			var urls = {
				findAll : webRoot + '/user/findAll.do',
				operateUser : webRoot + '/user/operateUser.do',
				queryPerms : webRoot + '/user/queryPerms.do'
			}
			var style = {
				btnColor : "btn-default",
				iconColor : "glyphiconColor"
			}

			// //////////////////
			// table1
			// //////////////////
			var dtSetting = {
				tableId : "#example",
				showTool : true,
				showNum : true,
				ajax : {
					url : urls.findAll,
					type : 'POST',
				},
				"serverSide" : true,
				"ordering" : false,
				"columns" : [ {
					"data" : null
				}, // checkbox
				{
					"data" : null
				}, // 添加序号
				{
					"data" : "userKey"
				}, {
					"data" : "userNameCh"
				}, {
					"data" : "note"
				}, {
					"data" : "createTime"
				}, {
					"data" : "modifyTime"
				} ],
				"columnDefs" : [
						{
							"targets" : 0,
							"render" : function(a, b, c, d) {
								return '<input type="checkbox" name='
										+ c.roleId + ' value=' + c.roleId
										+ ' />'
							}
						},
						{
							"targets" : 7,
							"render" : function(data, type, row, meta) {
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
						} ],

			}
			var table = $("#example").dataTablePush(dtSetting);
			// 添加序号
			// 不管是排序，还是分页，还是搜索最后都会重画，这里监听draw事件即可
			table.on('draw.dt', function() {
				initEvents();
			}).draw();

			/**
			 * 初始化事件
			 */
			function initEvents() {
				$('._role').unbind().bind('click', function(e) {
					var _this = $(this);
					var userObj = {
						userId : _this.attr('data-id'),
						userNameCh : _this.attr('data-name')
					}
					clickLinkEvent(userObj, e);
				});
			}

			function clickLinkEvent(obj, e) {
				var userId = obj.userId;
				var label = '(' + obj.userNameCh + ')';
				$('#roleUserId').val(userId);
				$('#userRoleModalLabel small').text(label);

				$.post(webRoot + '/user/findRoleOfUser', {
					'userId' : userId
				}, function(rs) {
					var notSelect = '', isSelect = '';
					$.each(rs, function(i, obj) {
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
					$('#modalPanel .list-group-item').unbind().bind('click',
							function(e) {
								selectItemEvent(this);
							});
					$('#userRoleModal').modal('show');
				});
			}

			function ajax(obj) {
				var url = urls.operateRole;
				$.ajax({
					url : url,
					type : 'POST',
					data : JSON.stringify(obj),
					dataType : 'json',
					contentType : 'application/json;charset=utf-8',
					success : function(data) {
						table.ajax.reload();
						$(".modal").modal("hide");
						$("#myModalLabel").text("新增");
						clear();
						layer.msg('亲，操作已完成...', {
							icon : 6
						});
					}
				});
			}

			// //////////////////
			// table2
			// //////////////////
			var infoTable = {
				tableId : "#infoTable",
				autoWidth:true,
				ajax : {
					url : urls.queryPerms,
					type : 'POST',
				},
				"serverSide" : true,
				"ordering" : false,
//				"scrollX" : true,
				"columns" : [ {
					"data" : "userKey"
				}, {
					"data" : "userNameCh"
				}, {
					"data" : "roleRank"
				}, {
					"data" : "funRank"
				}/*, {
					"data" : "organRank",
					"width" : "100px",
				}*/ ]
			}
			$("#infoTable").dataTablePush(infoTable);
		});