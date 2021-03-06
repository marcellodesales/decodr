<html lang="en">
<head>
    <g:if test="${pageProperty(name:'page.title')}">
        <g:set var="pageHeader">DecodR: RSA Algorithm Explained - <g:pageProperty name="page.title" /></g:set>
    </g:if>
    <title><g:layoutTitle default="DecodR: RSA Algorithm Explained ${pageHeader ?: ''}" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Decodr: RSA Algorithm Explained...">
    <meta name="author" content="Marcello de Sales (marcello.desales@gmail.com)">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
    <r:layoutResources/>
    <g:layoutHead />
</head>
<body>
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>

          <a class="brand" href="#">DecodR</a>

          <div class="btn-group pull-right">
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="icon-user"></i> Username
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">Profile</a></li>
              <li class="divider"></li>
              <li><a href="#">Sign Out</a></li>
            </ul>
          </div>

          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">

        <div class="span3">

          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">RSA Keys</li>
              <li ${controllerName == "key" && actionName == "index" ? 'class="active"' : ''}>
                  <g:link controller="key" action="index">Introduction</g:link></li>
              <li ${controllerName == "key" && actionName == "random" ? 'class="active"' : ''}>
                 <g:link controller="key" action="random">Generate Keys</g:link></li>

              <li class="nav-header">Encode Messages</li>
              <li ${controllerName == "encoder" && actionName == "index" ? 'class="active"' : ''}>
                  <g:link controller="encoder" action="index">Encode Message</g:link></li>

              <li class="nav-header">Decode Messages</li>
              <li ${controllerName == "decoder" && actionName == "index" ? 'class="active"' : ''}>
                 <g:link controller="decoder" action="index">Decode Message</g:link></li>

              <li class="divider"></li>
              <li><a href="#">Options</a></li>
              
            </ul>
          </div><!--/.well -->

        </div><!--/span-->

        <div class="span9">

            <g:layoutBody />

        </div><!--/span9-->

      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; DecodR 2012 - By Marcello de Sales</p>
      </footer>

    </div><!--/.fluid-container-->

    <g:javascript library="application" />
    <r:layoutResources />
</body>
</html>