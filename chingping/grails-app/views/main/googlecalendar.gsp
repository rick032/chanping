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
					<h1>釺品行事曆</h1>
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
	</div>
	<!-- /container -->
	<script type='text/javascript'
		src="${resource(dir:'js/pagejs/main',file:'googlecalendar.js')}"></script>

</body>
</html>
