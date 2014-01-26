<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<ul id="myTab" class="nav nav-tabs">
    <li><a href="<c:url value='/pages/admin/concept/add'/>" >Agregar</a></li>
    <li class="active"><a href="<c:url value='/pages/admin/concept'/>" >Consultar</a></li>
</ul>
<div id="tabContenido" class="tab-content">
    <div class="tab-pane fade active in" id="new">
    <div class="modal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h3>Consultar Concepto</h3>
        </div>
        <div class="modal-body">
            <!--
            <div class="alert alert-success">
                <button type="button" class="close" data-dismiss="alert">&times;</button>                
            </div>-->        
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                        <th>codigo</th>
                        <th>Nombre</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="concept" items="${list}">
                    <tr >
                        <td>${concept.id}</td>
                        <td>${concept.name}</td>
                        <td>
                            <a href="<c:url value='/pages/admin/concept/edit?id=${concept.id}'/>" title="Editar">
                                editar </a>
                            <a href="<c:url value='/pages/admin/concept/delete?id=${concept.id}'/>" title="Eliminar">
                                eliminar </a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
            <div class="modal-footer">
                <a href="#" class="btn">Cerrar</a>
            </div>            
        </div>
    </div>
</div>