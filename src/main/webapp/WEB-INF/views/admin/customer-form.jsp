<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:choose>
	<c:when test="${building == null }">
		<c:url var="buildingCRUDUrl" value="/admin/building-save" />
	</c:when>
	<c:otherwise>
		<c:url var="buildingCRUDUrl" value="/admin/building-update" />
	</c:otherwise>
</c:choose>

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

							<form action="${customerSearchURL }" method="get"
								id="formSearchBuilding" class="widget-body">
								<div class="widget-main">
									<div class="row">
										<div class="col-sm-2">
											<label for="fullName" class="form-label"><b>Tên
													khách hàng</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="fullName"
												name="fullName" />
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
												name="phone" value="" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="email" class="form-label"><b>Email</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="email"
												name="email" value="" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="email" class="form-label"><b>Tên công
													ty</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="email"
												name="email" value="" />
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="email" class="form-label"><b>Nhu cầu</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="email"
												name="email" value="" />
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

									<div class="row">
										<div class="col-sm-2"></div>

										<div class="col-sm-10">
											<button class="btn btn-success" type="button"
												id="btnSearchBuilding">
												<b>Thêm khách hàng</b><i
													class="ace-icon fa fa-arrow-right icon-on-right"></i>
											</button>
										</div>
									</div>
								</div>
								<br>
							</form>
						</div>
					</div>
				</div>

				<br>
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->

						<div class="widget-box">
							<div class="widget-header widget-header-blue widget-header-flat">
								<h4 class="widget-title lighter">
									<b>Quá trình chăm sóc khách hàng</b>
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
									<tr>
										<td></td>
										<td>
											<div class="row">
												<div class="col-sm-11">
													<form:form action="${deleteBuildingURL}" method="post"
														id="formIdsBuilding">
														<input type="text" class="form-control" id="email"
															name="email" value="" />
													</form:form>
												</div>
												<div class="col-sm-1">
													<div class="dt-buttons btn-overlap btn-group">
														<a flag="info"
															class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
															data-toggle="tooltip" title="Thêm người dùng"
															href="/spring-boot/admin/user-edit"> <span> <i
																class="fa fa-plus-circle bigger-110 purple"></i>
														</span>
														</a>
													</div>
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
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

<!-- <![endif]-->

<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->
<!-- inline scripts related to this page -->
<script type="text/javascript">
	jQuery(function($) {
		var demo1 = $('select[name="
													duallistbox_demo1[]"]')
				.bootstrapDualListbox(
						{
							infoTextFiltered
													: '<span class="label label-purple label-lg">Filtered</span>'
						});
		var
													container1=demo1.bootstrapDualListbox(
													'getContainer');
		container1.find('.btn').addClass('btn-white
													btn-info btn-bold');

		/**var setRatingColors=function()
													{
			$(this).find('.star-on-png,.star-half-png').addClass('orange2').removeClass('grey');
			$(this).find('.star-off-png').removeClass('orange2').addClass('grey');
		}*/
		$('.rating').raty({
			'cancel' :
													true,
			'half' :
													true,
			'starType' : 'i'
		/**,
		
		'click':
													function() {
			setRatingColors.call(this);
		},
		'mouseover':
													function() {
			setRatingColors.call(this);
		},
		'mouseout':
													function() {
			setRatingColors.call(this);
		}*/
		})//.find('i:not(.star-raty)').addClass('grey');

		//////////////////
		//select2
		$('.select2').css('width', '200px').select2({
			allowClear
													:
													true
		})
		$('#select2-multiple-style .btn').on('click', function(e) {
			var
													target=$(this).find( 'input[type=radio] ');
			var
													which=parseInt(target.val()); if (which==
													2)
				$('.select2').addClass('tag-input-style');
			else
				$('.select2').removeClass('tag-input-style');
		});

		//////////////////
		$('.multiselect')
				.multiselect(
						{
							enableFiltering
													: true,
							buttonClass : 'btn btn-white
													btn-primary',
							templates : {
								button
													: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"></button>',
								ul
													: '<ul class="multiselect-container dropdown-menu"></ul>',
								filter
													: '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
								filterClearBtn
													: '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
								li
													: '<li><a href="javascript:void(0);"><label></label></a></li>',
								divider
													: '<li class="multiselect-item divider"></li>',
								liGroup
													: '<li class="multiselect-item group"><label class="multiselect-group"></label></li>'
							}
						});

		///////////////////

		//typeahead.js
		//example
													taken from plugin's page at:
													https://twitter.github.io/typeahead.js/examples/
		var
													substringMatcher=function(strs) {
			return function
													findMatches(q, cb) {
				var
													matches, substringRegex;

				// an array that will be
													populated with substring matches matches=[]; // regex used
													to determine if a string contains the
													substring `q`
				substrRegex=new
													RegExp(q, 'i');

				// iterate through the pool of
													strings and for any string that
				// contains the
													substring `q`, add it to
													the `matches` array
				$.each(strs, function(i, str) {
					if (substrRegex.test(str)) {
						// the
													typeahead jQuery plugin expects suggestions to
													a
						// JavaScript object, refer to typeahead docs for
													more info matches.push({
							value :
													str
						});
					}
				});

				cb(matches);
			}
		}

		$('input.typeahead').typeahead({
			hint
													: true,
			highlight : true,
			minLength
													: 1
		}, {
			name : 'states',
			displayKey
													: 'value',
			source :
													substringMatcher(ace.vars['US_STATES'])
		});

		///////////////

		//in
													ajax mode, remove remaining elements before leaving
													page
		$(document).one(
				'ajaxloadstart.page',
				function(e) {
					$('[class*=select2]
													').remove();
					$('select[name="duallistbox_demo1[]"]')
							.bootstrapDualListbox('destroy');
					$('.rating').raty('destroy');
					$('.multiselect').multiselect('destroy');
				});

	});

	$('#buildingCRUD').click(function(e) {
		e.preventDefault();
		$("#formFieldBuilding").submit();

	});

													
													</script>