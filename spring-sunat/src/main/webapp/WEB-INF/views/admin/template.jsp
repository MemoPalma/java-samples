<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Herald Olivares">
        <title>Sitio Administrativo</title>        
        <link rel="stylesheet" href="<c:url value='/stylesheets/bootstrap.css'/>" />
        <link rel="stylesheet" href="<c:url value='/stylesheets/bootstrap-responsive.min.css'/>" />
        <style type="text/css">
        body {
          padding-top: 20px;
          padding-bottom: 60px;
        }

        .container {
          margin: 0 auto;
          max-width: 1000px;
        }

        .jumbotron {
          margin: 40px 0;          
        }
      </style>
        
    </head>
    <body>        
        <div class="container">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="menu" />
            <div class="jumbotron"><tiles:insertAttribute name="body" /></div>
            <tiles:insertAttribute name="footer" />
        </div><!-- /container -->
        <script src="<c:url value='/javascript/jquery-1.8.1.min.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/javascript/bootstrap.min.js'/>"></script>        
    </body>
</html>