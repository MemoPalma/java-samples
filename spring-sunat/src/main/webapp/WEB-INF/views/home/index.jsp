<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1 class="pull-left">Consulta de Multas</h1>    
    <div class="clear"></div>
    <br><br><br><br>
    <div class="row pull-right">
        <form:form action="" method="get" commandName="criterioBusqueda" cssClass="form-search">
            <form:input path="nombre" size="10" cssClass="input-xlarge search-query"></form:input>
            <input type="submit" value="Buscar" class="btn"/>
        </form:form>
    </div>        
    <br/>
    <table class="table table-striped">
        <tr>            
            <th>Concepto</th>
            <th>Ruc</th>
            <th>Periodo</th>
            <th>Tributo</th>
            <th>Resolucion</th>
            <th>Monto</th>
        </tr>
        <c:forEach var="multa" items="${multas}">
            <tr>
                <td>${multa.concept}</td>
                <td>${multa.person}</td>
                <td>${multa.period}</td>
                <td>${multa.taxcode}</td>
                <td>${multa.resolutionNumber}</td>
                <td>${multa.amount}</td>
            </tr>
        </c:forEach>
    </table>
</div>
