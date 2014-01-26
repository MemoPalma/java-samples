<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Inicio</a>
            <div class="nav-collapse collapse navbar-responsive-collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Concepto <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value='/pages/admin/concept/add'/>">Nueva Concepto</a></li>
                            <li><a href="<c:url value='/pages/admin/concept'/>">Consultar Concepto</a></li>
                        </ul>
                    </li>
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Persona <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="">Nueva Persona</a></li>
                            <li><a href="">Consultar Persona</a></li>
                        </ul>
                    </li>
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Multa <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="">Nueva Multa</a></li>
                            <li><a href="">Consultar Multa</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav pull-right">
                    <li><a href="#" data-toggle="tooltip" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="" data-original-title="Popover on bottom">Acerca de</a></li>
                    <li class="divider-vertical"></li>
                    <li><a href="#">Manual</a></li>
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="">Cerrar sesión</a></li>
                            <li><a href="#">Cambiar contraseña</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.nav-collapse -->
        </div>
    </div><!-- /navbar-inner -->
</div>
