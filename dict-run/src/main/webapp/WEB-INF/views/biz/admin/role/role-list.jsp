<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/include/top.jsp"%>
<title>角色管理</title>
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
	<input type="hidden" id="roleId" /><!-- 更新用 -->
	<input type="hidden" name="checkIds" /><!-- 	批量删除  -->
	<div class="rightBody">
		<div class="SetUpBody">
			<div class="index-common-title bottom-title">
				<div class="index-common-title-left bottom-left"></div>
				<div class="index-common-title-text bottom-text">角色管理</div>
			</div>

			<div class="bottom-div bottom-div2 clearfix">
				<div class="col-sm-12 ct-col1">
					<table id="example" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><input type="checkbox" name="allChecked" /></th>
								<th>序号</th>
								<th>角色编码</th>
								<th>角色名称</th>
								<th>角色描述</th>
								<th>创建时间</th>
								<th>修改时间</th>
								<th>操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

<!-- 			<div class="bottom-div bottom-div2 clearfix"> -->
<!-- 				<div class="col-sm-12 ct-col1"> -->
<!-- 					<table id="grid-table"></table> -->
<!-- 					<div id="grid-pager"></div> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
	</div>
	

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input type="text" class="form-control" id="roleKey"
							placeholder="角色编码">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="roleName"
							placeholder="角色名称">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="note"
							placeholder="角色描述">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="delModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >删除角色</h4>
				</div>
				<div class="modal-body">
					<div class="alert alert-warning">
						<strong>确认删除角色！</strong>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-danger" id="del">确认</button>
				</div>
			</div>
		</div>
	</div>
	
<%-- 	<script src="${ctx}/assets/js/biz/admin/roleListJQ.js"></script> --%>
	<script src="${ctx}/assets/js/biz/admin/roleListDT.js"></script>
</body>
</html>