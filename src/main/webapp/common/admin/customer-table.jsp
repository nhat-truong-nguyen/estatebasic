<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="addCustomerURL" value="/admin/customer-save" />
<c:url var="updateCustomerURl" value="/admin/customer-update" />
<c:url var="deleteCustomerURL" value="/admin/customer-delete" />
<c:url var="assignCustomerURl" value="/admin/assign-customer" />
<!-- PAGE CONTENT BEGINS -->
<div class="row">
	<div class="col-xs-12">
		<div class="clearfix">
			<div class="pull-right tableTools-container">
				<div class="btn-group btn-overlap">
					<div class="ColVis btn-group" title=""
						data-original-title="Show/hide columns">
						<a href="${addCustomerURL }"
							class="ColVis_Button ColVis_MasterButton btn btn-white btn-info btn-bold">
							<span><i class="glyphicon-plus"></i></span>
						</a>
					</div>
					<button class="DTTT_button btn btn-white btn-primary  btn-bold"
						title="" tabindex="0" aria-controls="dynamic-table"
						data-original-title="Print view" id="btnDeleteCustomer">
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
					<th>Tên</th>
					<th>Nhân viên quản lý</th>
					<th>Di động</th>
					<th>Email</th>
					<th>Nhu cầu</th>
					<th>Người nhập</th>
					<th>Ngày nhập</th>
					<th>Tình trạng</th>
					<th>Thao tác</th>
				</tr>
			</thead>

			<tbody>

				<form:form action="${deleteCustomerURL}" method="post"
					id="formIdsCustomer">
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td class="center"><label class="pos-rel"> <input
									type="checkbox" class="ace" name="ids" value="${customer.id}" />
									<span class="lbl"></span>
							</label></td>
							<td>${customer.fullName }</td>
							<td>${customer.managerStaffs }</td>
							<td>${customer.phone }</td>
							<td>${customer.email }</td>
							<td>${customer.demand }</td>
							<td>${customer.modifiedBy }</td>
							<td>${customer.modifiedDate }</td>
							<td>${customer.status }</td>
							<td>
								<div class="hidden-sm hidden-xs btn-group">
									<security:authorize access="hasRole('MANAGER')">
										<button href="#my-modal" role="button"
											class="btn btn-xs btn-success btnStaffList"
											data-toggle="modal" type="button" value="${customer.id}">
											<i class="ace-icon fa fa-check bigger-120"></i>
										</button>
									</security:authorize>

									<a class="btn btn-xs btn-info"
										href="${updateCustomerURl}?id=${customer.id }"> <i
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
<form action="${assignCustomerURl}" method="post">
	<input type="hidden" name="customerId" id="customerId" value="" />
	<div id="my-modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="smaller lighter blue no-margin">
						<b>Danh sách nhân viên giao khách hàng quản lý</b>
					</h3>
				</div>

				<div class="modal-body">
					<table id="simple-table"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center">Tên nhân viên</th>
								<th class="text-center">Giao khách hàng</th>
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