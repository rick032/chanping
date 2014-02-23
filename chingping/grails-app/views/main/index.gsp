<!DOCTYPE html>
<html>
<head>
<title>首頁</title>
<meta name="layout" content="inner" />
</head>
<body>
	<div class="container">
		<div class="page-header">
			<div class="row">
				<div class="col-lg-6">
					<h1>阡品行事曆</h1>
				</div>
			</div>
			<div class="row">
				<oauth:connect provider="google">Connect to google</oauth:connect>
			</div>
			<div class="row">
				<div style="padding: 15px 15px 0 15px;" class="col-lg-11">
					<div class="well" style="background-color: #fafafa;">
						<div id="calendar"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- dialog -->
		<div class="hide">
			<div id="eventdialog" class="dialog" style="width: 400px;">
				<div class="control-group">
					<label class="control-label" for="TRADENO">訂單單號：</label>
					<div class="controls">
						<label id="TRADENO"></label>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="title">客戶名稱：</label>
					<div class="controls">
						<label id="title"></label>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="start">預定交期：</label>
					<div class="controls">
						<label id="start"></label>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="goods">交附貨品：</label>
					<div class="bs-example table-responsive">
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>#</th>
									<th>貨品代號</th>
									<th>貨品名稱</th>
									<th>訂單數量</th>
								</tr>
							</thead>
							<tbody>
								<g:each var="opitem" in="${opitems}">
									<g:if test="${opitem.sn%2==0}">
										<tr>
									</g:if>
									<g:else>
										<tr class="success">
									</g:else>
									<td>
										${opitem.sn}
									</td>
									<td>
										${opitem.GOODNO}
									</td>
									<td>
										${opitem.GOODNAME}
									</td>
									<td>
										${opitem.TRADEQTY}
									</td>
									</tr>
								</g:each>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script type='text/javascript'
		src="${resource(dir:'js/pagejs/main',file:'calendar.js')}"></script>

</body>
</html>
