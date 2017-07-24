<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/include/top.jsp"%>
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${ctxAssets}plugin/datatables/css/jquery.dataTables.css">
</head>
<style>
.glyphiconColor {
	color: #0099cc
}
.dataTables_wrapper .row:first-child {
	background-color: #fff;
}
</style>
<body>
	<div class="rightBody">
		<div class="SetUpBody">
			<div class="index-common-title bottom-title">
				<div class="index-common-title-left bottom-left"></div>
				<div class="index-common-title-text bottom-text">用户配置</div>
			</div>
			<div class="bottom-div bottom-div2 clearfix">
				<div class="col-sm-12 ct-col1">
					<table id="example" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><input type="checkbox" name="allChecked" /></th>
								<th>序号</th>
								<th>用户编码</th>
								<th>用户名称</th>
								<th>角色描述</th>
								<th>创建时间</th>
								<th>修改时间</th>
								<th>操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div class="index-common-title bottom-title">
				<div class="index-common-title-left bottom-left"></div>
				<div class="index-common-title-text bottom-text">用户信息</div>
			</div>
			<div class="bottom-div bottom-div2 clearfix">
				<div class="col-sm-12 ct-col1">
					<table id="infoTable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>用户编码</th>
								<th>用户名称</th>
								<th>角色范围</th>
								<th>功能权限范围</th>
								<!-- 								<th>数据权限范围</th> -->
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- 功能(Modal) -->
	<div class="modal fade" id="userRoleModal" tabindex="-1" role="dialog"
		aria-labelledby="userRoleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<input type="hidden" id="roleUserId" name="userId">
					<h3 class="modal-title" id="userRoleModalLabel">
						用户角色配置 <small>&nbsp;</small>
					</h3>
				</div>
				<div class="modal-body">
					<div class="row" style="margin: 0;" id="modalPanel">
						<div class="col-xs-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">未选角色</h3>
								</div>
								<div class="panel-body">
									<div class="list-group" id="notSelectPanel"></div>
								</div>
							</div>
						</div>
						<div class=" col-xs-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">已选角色</h3>
								</div>
								<div class="panel-body">
									<div class="list-group" id="isSelectPanel"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="confirmRoleBtn">提交</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- 搜索弹出框 -->
	<div id="searchModal" class="modal fade" data-backdrop="static"
		tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<input type="hidden" id="searchUserId">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title">绑定员工</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-7">
							<div class="input-group">
								<input type="text" class="form-control search-query"
									id="searchTxt" placeholder="请输入员工ID/姓名" /> <span
									class="input-group-btn">
									<button type="button" class="btn btn-white" id="searchBtn">
										查询 <i class="icon-search icon-on-right bigger-110"></i>
									</button>
								</span>
							</div>
						</div>
						<div class="col-xs-5">
							<label>* 姓名支持模糊查询</label>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 column" id="searchEmpTable">
							<table id="searchEmpGrid"></table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<script src="${ctx}/assets/js/biz/admin/userListDT.js"></script>
</body>
</html>