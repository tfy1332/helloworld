
<%@page import="com.ipartek.formacion.Constantes"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

	<!-- fontawesome -->
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

	<!-- Enlaces a las hojas de Estilos propia -->
	<link rel="stylesheet" href="css/styles.css?v=2.0">

 	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<%
	String msg = (String)request.getAttribute("msg");
	if (msg!=null){
		out.print(msg);
	}
%>

<!--  <form method="post" action="<%=Constantes.WEB_HOME%>login">
	<h1>Identifiquese para continuar</h1><br />
	<label for="usuario">Usuario:</label> 
	<input type="text" name="usuario" required><br /><br />
	
	<label for="password">Contrase�a:</label> 
	<input type="text" name="password" required><br /><br />
	
	<input type="submit" value="Enviar" />
</form> -->

<div class="wrapper">
    <form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>login">       
      <h2 class="form-signin-heading">Identifiquese para continuar</h2>
      <input type="text" class="form-control" name=usuario placeholder="Nombre" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Contrase�a" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Recuerdame
      </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit" value="">Enviar</button>   
    </form>
  </div>