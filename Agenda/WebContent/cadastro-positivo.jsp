<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<title>Sucesso</title>
</head>
<body>


	<h1>Cadastro efetuado com sucesso</h1>

	<hr />

	<jsp:useBean id="contatos" class="br.com.caelum.dao.AgendaDAO" />
	<table border="1">
		<c:forEach var="contato" items="${contatos.listaContatos }"
			varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? '#e4f1fe' : '#2e3131' }">
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td><c:if test="${empty contato.dataNascimento }">
						<c:out value="Favor, cadastrar um contato" />
					</c:if> <c:if test="${not empty contato.dataNascimento}">

						<!-- 						SE O VALO NO BANCO FOSSE DATE,FUNCIONARIA -->
						<%--<fmt:formatDate var="dataFormatada" value="contato.dataNascimento" pattern="dd/MM/yyy"/> --%>
						<c:out value="${contato.dataNascimento}" />
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
	
	<fmt:formatDate value=""/>

</body>
</html>