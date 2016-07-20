<%@ include file="../includes/head.jsp" %>

<h1>Planetas</h1>



<table>
	<thead>
		<tr>
			<th>Imagen</th>
			<th>Nombre</th>
			<th>Ver</th>
			<th>Eliminar</th>
		</tr>
	</thead>	
	
	<tbody>	
		<c:forEach var="p" items="${requestScope.list}">
			<tr>
				<td><img src="${p.imagen}" alt="${p.nombre}"/></td>
				<td>${p.nombre}</td>
				<td><i class="fa fa-eye" aria-hidden="true"></i></td>
				<td><i class="fa fa-trash" aria-hidden="true"></i></td>
			</tr>
		</c:forEach>		
	</tbody>
</table>


<%@ include file="../includes/footer.jsp" %>