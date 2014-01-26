<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<ul id="myTab" class="nav nav-tabs">
    <li class="active"><a href="<c:url value='/pages/admin/concept/add'/>" >Agregar</a></li>
    <li class=""><a href="<c:url value='/pages/admin/concept'/>" >Consultar</a></li>
</ul>
<div id="tabContenido" class="tab-content">
    <div class="tab-pane fade active in" id="new">                
    <form:form action="" method="post" commandName="concept">
    <div class="modal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h3>Registrar Concepto</h3>
        </div>
        <div class="modal-body">
            <div class="row-fluid">
                <div class="span1">
                    <label class="control-label" for="nombre">Nombre:</label>
                </div>
                <div class="span3">
                    <form:errors path="name" cssstyle="color:red"></form:errors>
                    <form:input path="name" ></form:input>
                </div>                
            </div>
        </div>
            <div class="modal-footer">               
                <input name="" value="Guardar" type="submit" class="btn btn-primary">
                <a href="#" class="btn">Cerrar</a>
            </div>            
        </div>
        </form:form>
    </div>
</div>