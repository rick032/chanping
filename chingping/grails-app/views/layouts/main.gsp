<!DOCTYPE html>
<html lang="cht">
<head>
<meta charset="utf-8">
<title>釺品股份有限公司</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Rick">

<!-- Le styles -->
<!-- Fav and touch icons -->
<link rel="shortcut icon"
	href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
<link rel="stylesheet"
	href="${resource(dir:'css/bootstrap',file:'bootstrap.css')}"
	media="screen" />
<link rel="stylesheet"
	href="${resource(dir:'css/bootstrap',file:'bootstrap-responsive.css')}" />
<link rel="stylesheet"
	href="${resource(dir:'css/bootstrap',file:'bootswatch.css')}"
	media="screen" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${resource(dir:'css/fancybox',file:'jquery.fancybox.css')}" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${resource(dir:'css/fullcalendar',file:'fullcalendar.css')}" />
<link rel="stylesheet" type="text/css" media='print'
	href="${resource(dir:'css/fullcalendar',file:'fullcalendar.print.css')}" />	
<script type="text/javascript"
	src="${resource(dir:'js/jquery',file:'jquery-2.0.3.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/validate',file:'jquery.validate.min.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/validate',file:'messages_zh_TW.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/jqgrid/i18n',file:'grid.locale-tw.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/jqgrid',file:'jquery.jqGrid.min.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/fullcalendar',file:'moment.min.js')}"></script>	
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/fullcalendar',file:'fullcalendar.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/fullcalendar/lang',file:'zh-tw.js')}"></script>	
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/fullcalendar',file:'gcal.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js/jquery/plugin/fancybox',file:'jquery.fancybox.pack.js')}"></script>
<script type="text/javascript"
	src="${resource(dir:'js',file:'base.js')}"></script>
<style type="text/css">
</style>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    	<script src="${resource(dir:'js/bootstrap',file:'html5shiv.js')}"></script>
    <![endif]-->
</head>

<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="../" class="navbar-brand">釺品</a>
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav">
					<!-- <li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" id="themes">行事曆 <span
							class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="themes">
							<li><a href="${request.contextPath}/main/">訂購單</a></li>
							<li class="divider"></li>
							<li><a href="${request.contextPath}/main/opitem">銷貨單</a></li>							
						</ul>
					</li>-->					
					<li><a href="${request.contextPath}">訂購單</a></li>
					<li><a href="${request.contextPath}/main/opitem">銷貨單</a></li>
					<!--  
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" id="download">Download <span
							class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="download">
							<li><a href="./bootstrap.min.css">bootstrap.min.css</a></li>
							<li><a href="./bootstrap.css">bootstrap.css</a></li>
							<li class="divider"></li>
							<li><a href="./variables.less">variables.less</a></li>
							<li><a href="./bootswatch.less">bootswatch.less</a></li>
						</ul></li>-->
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<!-- <li><a href="#" target="_blank">Built
							With Bootstrap</a></li>
					<li><a href="#"
						target="_blank">WrapBootstrap</a></li>-->
				</ul>

			</div>
		</div>
	</div>
	<section>
		<g:layoutBody />			
	</section>
	<hr>
    <div class="footer">
        <p class="text-center">&copy; 釺品股份有限公司 </p>
    </div>

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="${resource(dir:'js/bootstrap',file:'bootstrap.min.js')}"></script>
	<script type="text/javascript">
    	var contextRoot = "${request.contextPath}";
	</script>
	<script type="text/javascript"
		src="${resource(dir:'js/pagejs/main',file:'main.js')}"></script>
</body>
</html>

