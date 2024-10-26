<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="addBuildingURL" value="/admin/building-save" />
<c:url var="updateBuildingUrl" value="/admin/building-update" />
<c:url var="deleteBuildingURL" value="/admin/building-delete" />
<c:url var="assignBuilding" value="/admin/assign-building" />
<!-- PAGE CONTENT BEGINS -->
<div class="row">
	<div class="col-xs-12">
		<div class="clearfix">
			<div class="pull-right tableTools-container">
				<div class="btn-group btn-overlap">
					<div class="ColVis btn-group" title=""
						data-original-title="Show/hide columns">
						<a href="${addBuildingURL }"
							class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold">
							<span><i class="glyphicon-plus"></i></span>
						</a>
					</div>
					<button class="DTTT_button btn btn-white btn-primary  btn-bold"
						title="" tabindex="0" aria-controls="dynamic-table"
						data-original-title="Print view" id="btnDeleteBuilding">
						<span><i class="ace-icon fa fa-trash-o"></i></span>
					</button>
				</div>
			</div>
		</div>
		<table id="simple-table"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center"><label class="pos-rel"> <input
							type="checkbox" class="ace" /> <span class="lbl"></span>
					</label></th>
					<th>Ngày</th>
					<th>Tên</th>
					<th>Địa chỉ</th>
					<th>Tên quản lý</th>
					<th>Số điện thoại</th>
					<th>D.T sàn</th>
					<th>D.T trống</th>
					<th>Giá thuê</th>
					<th>Phí dịch vụ</th>
					<th>Phí môi giới</th>
					<th>Thao tác</th>
				</tr>
			</thead>

			<tbody>

				<form:form action="${deleteBuildingURL}" method="post"
					id="formIdsBuilding">
					<c:forEach items="${buildings}" var="building">
						<tr>
							<td class="center"><label class="pos-rel"> <input
									type="checkbox" class="ace" name="ids" value="${building.id}" />
									<span class="lbl"></span>
							</label></td>
							<td>${building.createdDate }</td>
							<td>${building.name }</td>
							<td>${building.address }</td>
							<td>${building.managerName }</td>
							<td>${building.managerPhone }</td>
							<td>${building.floorArea }</td>
							<td>${building.rentAreaDescription }</td>
							<td>${building.rentPrice }</td>
							<td>${building.serviceFee }</td>
							<td>${building.brokerageFee }</td>
							<td>
								<div class="hidden-sm hidden-xs btn-group">

									<security:authorize access="hasRole('MANAGER')">
										<button href="#my-modal" role="button"
											class="btn btn-xs btn-success btnStaffList"
											data-toggle="modal" type="button" value="${building.id}">
											<i class="ace-icon fa fa-check bigger-120"></i>
										</button>
									</security:authorize>

									<a class="btn btn-xs btn-info"
										href="${updateBuildingUrl}?id=${building.id }"> <i
										class="ace-icon fa fa-pencil bigger-120"></i>
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</form:form>
			</tbody>
		</table>
	</div>
	<!-- /.span -->
</div>

<!-- /.row -->
<form action="${assignBuilding}" method="post">
	<input type="hidden" name="buildingId" id="buildingId" value="" />
	<div id="my-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">
						<b>Danh sách nhân viên giao toà nhà quản lý</b>
					</h3>
				</div>

				<div class="modal-body">
					<table id="simple-table"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center">Tên nhân viên</th>
								<th class="text-center">Giao toà nhà</th>
							</tr>
						</thead>
						<tbody id="staffList">
						</tbody>
					</table>
				</div>

				<div class="modal-footer">
					<button class="btn btn-sm btn-success pull-right" type="submit"
						id="assignBuilding">
						<b>Lưu thay đổi</b>
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</form>