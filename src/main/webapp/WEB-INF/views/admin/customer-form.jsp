<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:choose>
	<c:when test="${building == null }">
		<c:url var="customerCRUD" value="/admin/customer-save" />
	</c:when>
	<c:otherwise>
		<c:url var="customerCRUD" value="/admin/customer-update" />
	</c:otherwise>
</c:choose>

<c:url var="transactionAddURL" value="/admin/transaction-add" />

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="main-content">
		<div class="main-content-inner">
			<%@ include file="/common/admin/breadcrumbs.jsp"%>
			<div class="page-content">
				<div class="ace-settings-container" id="ace-settings-container">
					<div class="ace-settings-box clearfix" id="ace-settings-box">
						<div class="pull-left width-50">
							<div class="ace-settings-item">
								<div class="pull-left">
									<select id="skin-colorpicker" class="hide">
										<option data-skin="no-skin" value="#438EB9">#438EB9</option>
										<option data-skin="skin-1" value="#222A2D">#222A2D</option>
										<option data-skin="skin-2" value="#C6487E">#C6487E</option>
										<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
									</select>
								</div>
								<span>&nbsp; Choose Skin</span>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-navbar" /> <label class="lbl"
									for="ace-settings-navbar"> Fixed Navbar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-sidebar" /> <label class="lbl"
									for="ace-settings-sidebar"> Fixed Sidebar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-breadcrumbs" /> <label class="lbl"
									for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-rtl" /> <label class="lbl"
									for="ace-settings-rtl"> Right To Left (rtl)</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-add-container" /> <label class="lbl"
									for="ace-settings-add-container"> Inside <b>.container</b>
								</label>
							</div>
						</div>
						<!-- /.pull-left -->

						<div class="pull-left width-50">
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-hover" /> <label class="lbl"
									for="ace-settings-hover"> Submenu on Hover</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-compact" /> <label class="lbl"
									for="ace-settings-compact"> Compact Sidebar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-highlight" /> <label class="lbl"
									for="ace-settings-highlight"> Alt. Active Item</label>
							</div>
						</div>
						<!-- /.pull-left -->
					</div>
					<!-- /.ace-settings-box -->
				</div>
				<!-- /.ace-settings-container -->

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->

						<div class="widget-box">
							<div class="widget-header widget-header-blue widget-header-flat">
								<h4 class="widget-title lighter">
									<b>Thông tin khách hàng</b>
								</h4>
							</div>

							<form:form action="${customerCRUD }" modelAttribute="model"
								method="post" id="customerFormCRUD" class="widget-body">
								<div class="widget-main">
									<input type="hidden" class="form-control" name="id"
										value="${customer.id }">
									<div class="row">
										<div class="col-sm-2">
											<label for="fullName" class="form-label"><b>Tên
													khách hàng</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="fullName"
												name="fullName" value="${customer.fullName }" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="phone" class="form-label"><b>Số điện
													thoại</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="phone"
												name="phone" value="${customer.phone }" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="email" class="form-label"><b>Email</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="email"
												name="email" value="${customer.email }" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="email" class="form-label"><b>Tên công
													ty</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="companyName"
												name="companyName" value="${customer.companyName }" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="demand" class="form-label"><b>Nhu cầu</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="demand"
												name="demand" value="${customer.demand }" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="note" class="form-label"><b>Ghi chú</b></label>
										</div>

										<div class="col-sm-10">
											<textarea rows="3" style="width: 100%;" name="note">${customer.note }</textarea>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-10">
											<button class="btn btn-success" type="button"
												id="btnCustomerCRUD">
												<b>${customer == null ? 'Thêm khách hàng' : 'Cập nhật thông tin' }</b><i
													class="ace-icon fa fa-arrow-right icon-on-right"></i>
											</button>
										</div>
									</div>
								</div>
								<br>
							</form:form>
						</div>
					</div>
				</div>

				<c:forEach items="${transactions}" var="transaction">
					<br>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="widget-box">
								<div class="widget-header widget-header-blue widget-header-flat">
									<h4 class="widget-title lighter">
										<b>${transaction.value }</b>
									</h4>
								</div>

								<table id="simple-table widget-body"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Ngày tạo</th>
											<th>Ghi chú</th>
										</tr>
									</thead>

									<tbody>
										<c:set var="transtationItems"
											value="${customerService.findTransactionsByTypeAndCustomer_Id(transaction.toString(), customer.id) }" />
										<c:forEach items="${transtationItems }" var="item">
											<tr>
												<td>${item.createdDate }</td>
												<td>${item.note }</td>
											</tr>
										</c:forEach>
										<tr>
											<td></td>
											<td><form:form modelAttribute="model"
													action="${transactionAddURL}" method="post"
													id="transactionForm">
													<div class="row">
														<div class="col-sm-11">
															<input type="hidden" class="form-control"
																name="customerId" value="${customer.id}" /> <input
																type="hidden" class="form-control" name="type"
																value="${transaction}" /> <input type="text"
																class="form-control" name="note" />
														</div>
														<div class="col-sm-1">
															<div class="dt-buttons btn-overlap btn-group">
																<button id="btnAddTransaction"
																	class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
																	type="submit">
																	<span> <i
																		class="fa fa-plus-circle bigger-110 purple"></i>
																	</span>
																</button>
															</div>
														</div>
												</form:form>
												</div></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</c:forEach>

				<div id="modal-wizard" class="modal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div id="modal-wizard-container">
								<div class="modal-header">
									<ul class="steps">
										<li data-step="1" class="active"><span class="step">1</span>
											<span class="title">Validation states</span></li>

										<li data-step="2"><span class="step">2</span> <span
											class="title">Alerts</span></li>

										<li data-step="3"><span class="step">3</span> <span
											class="title">Payment Info</span></li>

										<li data-step="4"><span class="step">4</span> <span
											class="title">Other Info</span></li>
									</ul>
								</div>

								<div class="modal-body step-content">
									<div class="step-pane active" data-step="1">
										<div class="center">
											<h4 class="blue">Step 1</h4>
										</div>
									</div>

									<div class="step-pane" data-step="2">
										<div class="center">
											<h4 class="blue">Step 2</h4>
										</div>
									</div>

									<div class="step-pane" data-step="3">
										<div class="center">
											<h4 class="blue">Step 3</h4>
										</div>
									</div>

									<div class="step-pane" data-step="4">
										<div class="center">
											<h4 class="blue">Step 4</h4>
										</div>
									</div>
								</div>
							</div>

							<div class="modal-footer wizard-actions">
								<button class="btn btn-sm btn-prev">
									<i class="ace-icon fa fa-arrow-left"></i> Prev
								</button>

								<button class="btn btn-success btn-sm btn-next"
									data-last="Finish">
									Next <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
								</button>

								<button class="btn btn-danger btn-sm pull-left"
									data-dismiss="modal">
									<i class="ace-icon fa fa-times"></i> Cancel
								</button>
							</div>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.page-content -->
</div>
</div>
<!-- /.main-content -->

<a href="#" id="btn-scroll-up"
	class="btn-scroll-up btn btn-sm btn-inverse"> <i
	class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
</div>
<!-- /.main-container -->

<script src="assets/js/jquery.2.1.1.min.js"></script>

<script>
	$('#btnCustomerCRUD').click(function(e) {
		e.preventDefault();
		$("#customerFormCRUD").submit();
	});
</script>