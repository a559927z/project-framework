  require(['jgGrid', 'messenger'], function () {
        var webRoot = G_WEB_ROOT;
        var urls = {
            findRoleAll: webRoot + '/role/findRoleAll.do',
            operateRole: webRoot + '/role/operateRole.do',
            delRole: webRoot + '/role/delRole.do'
        }
        
	//////////////////////////////////////        
	/// jqGrid        
	//////////////////////////////////////        
        var gridSelector = "#grid-table";
        var pagerSelector = "#grid-pager";
        var template = 
        	"<form class='container' style='width : 300px'> " +
			"	<div class='row form-group'> " +
			"		<label class='col-xs-4 text-right'>角色编号：</label> " +
			"		<span class='col-xs-8'>{roleKey}</span> " +
			"	</div> " +
			"	<div class='row form-group'> " +
			"		<label class='col-xs-4 text-right'>角色名称：</label> " +
			"		<span class='col-xs-8'>{roleName}</span> " +
			"	</div> " +
			"	<div class='row form-group'> " +
			"		<label class='col-xs-4 text-right'>描述：</label> " +
			"		<span class='col-xs-8'>{note}</span> " +
			"	</div> " +
			"	<div class='row form-group' align='center'> {sData} {cData}</div>" +
			"</form>";
        jQuery(gridSelector).jqGrid({
            url: urls.findRoleAll,
            datatype: 'json',
            mtype: 'POST',
            autowidth: true,
            height: 350,
            colNames: ['id', '角色编码', '角色名称', '角色描述', '创建时间', '操作'],
            colModel: [
                {name: 'id', index: 'id', hidedlg: true, hidden: true, width: 60},
                {name:'roleKey',width:60,editable:true,editoptions:{maxlength:"20"},editrules:{required:true}},
                {name:'roleName',width:100,editable:true,editoptions:{size:"20",maxlength:"20"},editrules:{required:true}},
                {name:'note',width:150,editable:true,editoptions:{size:"20",maxlength:"32"},editrules:{required:true}},
                {name:'createTime',width:100,editable:true,align:'center',sorttype:"date"},
                {
                    name: 'myac', width: 200, fixed: true, sortable: false, resize: false, title: false
                    //				formatter:'actions',
                    //				formatoptions:{
                    //					keys:true,
                    //					delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback}
                    //				}
                }
            ],
            viewrecords: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            pager: pagerSelector,
            altRows: true,
            multiselect: true,
            multiboxonly: true,
            rowHeight: 36,
            styleUI: 'Bootstrap',
            loadComplete: function (xhr) {
                var rows = xhr.rows;
                var ids = $(gridSelector).jqGrid('getDataIDs');
                for (var i = 0; i < ids.length; i++) {
                    var col = ids[i];
                    var html = '<shiro:hasPermission name="XiTongGuanLi_JueSeGuanLi:configFunction"><a href="javascript:void(0)" data-index="' + i + '" class="role_col1" style="margin:0 10px;">配置功能</a></shiro:hasPermission>'
                            + '<shiro:hasPermission name="XiTongGuanLi_JueSeGuanLi:configData"><a href="javascript:void(0)" data-index="' + i + '" class="role_col2" >配置数据</a></shiro:hasPermission>';
                    $(gridSelector).jqGrid('setRowData', col, {myac: html});
                }
                $('.role_col1').unbind().bind('click', function () {
                    var _this = $(this);
                    var idx = _this.attr('data-index');
                    var roleObj = rows[idx];
                    window.location.href = webRoot + '/role/roleFunction?roleId=' + roleObj.roleId;
                });
                $('.role_col2').unbind().bind('click', function () {
                    var _this = $(this);
                    var idx = _this.attr('data-index');
                    var roleObj = rows[idx];
                    //异步
                    // 				window.location.href = webRoot + '/role/roleOrganAsync?roleId='+roleObj.roleId;
                    //同步
                    window.location.href = webRoot + '/role/roleOrgan?roleId=' + roleObj.roleId;
                });
                var table = this;
            },
            editurl: urls.operateRole
        });
        //navButtons
        jQuery(gridSelector).jqGrid('navGrid', pagerSelector,{
        });

        function notifyInfo(msg, type) {
            Messenger().post({
                type: type,
                message: msg
            });
        }
     
    });