<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="staffList" value="/api/staffs-list" />
<c:url var="buildingStaffList" value="/api/building-staffs?buildingId=" />
<c:url var="buildingSearchUrl" value="/admin/building-search" />

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
									<b>Tìm kiếm</b>
								</h4>
							</div>

							<form:form modelAttribute="searchModel"
								action="${buildingSearchUrl }" method="get"
								id="formSearchBuilding" class="widget-body">
								<div class="widget-main">
									<div class="row">
										<div class="col-sm-6">
											<label for="name" class="form-label"><b>Tên sản
													phẩm</b></label>
											<form:input type="text" class="form-control" id="name"
												name="name" path="name" />
										</div>
										<div class="col-sm-6">
											<label for="floorArea" class="form-label"><b>Diện
													tích sàn</b></label>
											<form:input type="text" class="form-control" id="floorArea"
												path="floorArea" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-4">
											<label for="district" class="form-label"><b>Quận
													hiện có</b></label><br>
											<form:select name="district" id="district" path="district">
												<option value="">--- Chọn quận ---</option>
												<c:forEach items="${districts}" var="district">
													<form:option value="${district}">${district.name }</form:option>
												</c:forEach>
											</form:select>
										</div>
										<div class="col-sm-4">
											<label for="ward" class="form-label"><b>Phường</b></label>
											<form:input type="text" class="form-control" id="ward"
												path="ward" />
										</div>
										<div class="col-sm-4">
											<label for="street" class="form-label"><b>Đường</b></label>
											<form:input type="text" class="form-control" id="street"
												path="street" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-4">
											<label for="numberOfBasement" class="form-label"><b>Số
													tầng hầm</b></label>
											<form:input type="text" class="form-control"
												id="numberOfBasement" path="numberOfBasement" />
										</div>
										<div class="col-sm-2">
											<label for="direction" class="form-label"><b>Hướng</b></label>
											<form:input type="text" class="form-control" id="direction"
												path="direction" />
										</div>
										<div class="col-sm-2">
											<label for="level" class="form-label"><b>Hạng</b></label>
											<form:input type="text" class="form-control" id="level"
												path="level" />
										</div>

										<div class="col-sm-4">
											<label for="rentType" class="form-label"><b>Loại
													toà nhà</b></label><br>
											<div class="form-group">
												<select id="rentType" class="multiselect"
													multiple="multiple" name="rentType">
													<c:forEach items="${rentTypes}" var="rentType">
														<option value="${rentType}">${rentType.value }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-3">
											<label for="rentAreaFrom" class="form-label"><b>Diện
													tích từ</b></label>
											<form:input type="text" class="form-control"
												id="rentAreaFrom" path="rentAreaFrom" />
										</div>
										<div class="col-sm-3">
											<label for="rentAreaTo" class="form-label"><b>Diện
													tích đến</b></label>
											<form:input type="text" class="form-control" id="rentAreaTo"
												path="rentAreaTo" />
										</div>
										<div class="col-sm-3">
											<label for="rentPriceFrom" class="form-label"><b>Giá
													thuê từ</b></label>
											<form:input type="text" class="form-control"
												id="rentPriceFrom" path="rentPriceFrom" />
										</div>
										<div class="col-sm-3">
											<label for="rentPriceTo" class="form-label"><b>Giá
													thuê đến</b></label>
											<form:input type="text" class="form-control" id="rentPriceTo"
												path="rentPriceTo" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-4">
											<label for="managerName" class="form-label"><b>Tên
													quản lý</b></label>
											<form:input type="text" class="form-control" id="managerName"
												path="managerName" />
										</div>
										<div class="col-sm-4">
											<label for="managerPhone" class="form-label"><b>Điện
													thoại quản lý</b></label>
											<form:input type="text" class="form-control"
												id="managerPhone" path="managerPhone" />
										</div>
										<security:authorize access="hasRole('MANAGER')">
											<div class="col-sm-4">
												<label for="staffId" class="form-label"><b>Chọn
														nhân viên phụ trách</b></label><br>
												<form:select path="staffId" id="staffId">

													<option value="">--- Chọn nhân viên phụ trách ---</option>

													<c:forEach items="${staffs}" var="staff">
														<form:option value="${staff.id }">${staff.fullName }</form:option>
													</c:forEach>
												</form:select>
											</div>
										</security:authorize>
									</div>
								</div>
								<br>
								<button class="btn btn-success" type="button"
									id="btnSearchBuilding">
									<b>Tìm kiếm</b><i
										class="ace-icon fa fa-arrow-right icon-on-right"></i>
								</button>
							</form:form>
						</div>

					</div>
				</div>

				<%@ include file="/common/admin/building-table.jsp"%>
				<!-- /.widget-main -->
			</div>
			<!-- /.widget-body -->
		</div>

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

						<button class="btn btn-success btn-sm btn-next" data-last="Finish">
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

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="assets/js/jquery.2.1.1.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->
<!-- inline scripts related to this page -->
<script type="text/javascript">
			jQuery(function ($) {
				var demo1 = $('select[name="duallistbox_demo1[]"]')
					.bootstrapDualListbox(
						{
							infoTextFiltered: '<span class="label label-purple label-lg">Filtered</span>'
						});
				var container1 = demo1.bootstrapDualListbox('getContainer');
				container1.find('.btn').addClass('btn-white btn-info btn-bold');

				/**var setRatingColors = function() {
					$(this).find('.star-on-png,.star-half-png').addClass('orange2').removeClass('grey');
					$(this).find('.star-off-png').removeClass('orange2').addClass('grey');
				}*/
				$('.rating').raty({
					'cancel': true,
					'half': true,
					'starType': 'i'
					/**,
					
					'click': function() {
						setRatingColors.call(this);
					},
					'mouseover': function() {
						setRatingColors.call(this);
					},
					'mouseout': function() {
						setRatingColors.call(this);
					}*/
				})//.find('i:not(.star-raty)').addClass('grey');

				//////////////////
				//select2
				$('.select2').css('width', '200px').select2({
					allowClear: true
				})
				$('#select2-multiple-style .btn').on('click', function (e) {
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					if (which == 2)
						$('.select2').addClass('tag-input-style');
					else
						$('.select2').removeClass('tag-input-style');
				});

				//////////////////
				$('.multiselect')
					.multiselect(
						{
							enableFiltering: true,
							buttonClass: 'btn btn-white btn-primary',
							templates: {
								button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"></button>',
								ul: '<ul class="multiselect-container dropdown-menu"></ul>',
								filter: '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
								filterClearBtn: '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
								li: '<li><a href="javascript:void(0);"><label></label></a></li>',
								divider: '<li class="multiselect-item divider"></li>',
								liGroup: '<li class="multiselect-item group"><label class="multiselect-group"></label></li>'
							}
						});

				///////////////////

				//typeahead.js
				//example taken from plugin's page at: https://twitter.github.io/typeahead.js/examples/
				var substringMatcher = function (strs) {
					return function findMatches(q, cb) {
						var matches, substringRegex;

						// an array that will be populated with substring matches
						matches = [];

						// regex used to determine if a string contains the substring `q`
						substrRegex = new RegExp(q, 'i');

						// iterate through the pool of strings and for any string that
						// contains the substring `q`, add it to the `matches` array
						$.each(strs, function (i, str) {
							if (substrRegex.test(str)) {
								// the typeahead jQuery plugin expects suggestions to a
								// JavaScript object, refer to typeahead docs for more info
								matches.push({
									value: str
								});
							}
						});

						cb(matches);
					}
				}

				$('input.typeahead').typeahead({
					hint: true,
					highlight: true,
					minLength: 1
				}, {
					name: 'states',
					displayKey: 'value',
					source: substringMatcher(ace.vars['US_STATES'])
				});

				///////////////

				//in ajax mode, remove remaining elements before leaving page
				$(document).one(
					'ajaxloadstart.page',
					function (e) {
						$('[class*=select2]').remove();
						$('select[name="duallistbox_demo1[]"]')
							.bootstrapDualListbox('destroy');
						$('.rating').raty('destroy');
						$('.multiselect').multiselect('destroy');
					});

			});

			$('#btnSearchBuilding').click(function (e) {
				e.preventDefault();
				$("#formSearchBuilding").submit();
			});

			$('#btnDeleteBuilding').click(function (e) {
				e.preventDefault();
				$("#formIdsBuilding").submit();
			});

			let staffList = document.querySelector("#staffList");
			let buildingId = document.querySelector("#buildingId");
			let buildingStaffs;
			$('.btnStaffList').click(function (e) {
				e.preventDefault();

				buildingId.value = this.value;
				
				console.log('${buildingStaffList}' + this.value);

				$.ajax({
					url: '${buildingStaffList}' + this.value,
					type: 'GET',
					contentType: 'application/json',
					dataType: 'json',
					success: function (result) {
						buildingStaffs = result;
						console.log(buildingStaffs);
					},
					error: function (error) {
						console.log(error);
					}
				})

				$.ajax({
					url: '${staffList}',
					type: 'GET',
					contentType: 'application/json',
					dataType: 'json',
					success: function (result) {
						let row = "";
						console.log(123);
						result.forEach(item => {
							row += '<tr><td class="text-center">' + item.fullName + '</td>';
							row += '<td class="text-center"><label class="pos-rel"><input type="checkbox" name="staffIds" value="' + item.id + '" class="ace"';

							if (buildingStaffs.find((staff) => staff.id === item.id)) {
								row += "checked";
							};

							row += '/> <span class="lbl"></span></label ></td></tr>';
						});

						staffList.innerHTML = row;
					},
					error: function (error) {
						console.log(error);
					}
				})

			});

		</script>