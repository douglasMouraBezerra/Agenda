<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<title>Contatos</title>
</head>
<body>

	<table border="1">
		<jsp:useBean id="dao" class="br.com.caelum.dao.AgendaDAO" />
		<c:forEach var="contato" items="${dao.listaContatos }">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereco</th>
				<th>Data de Nascimento</th>
				<th>Remover</th>
			</tr>
			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td><c:if test="${not empty contato.email }">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if> <c:if test="${empty contato.email }">
						<c:out value="Cadastrar um email" />
					</c:if></td>
				<td>${contato.endereco}</td>
				<td><c:if test="${empty contato.dataNascimento }">
						<c:out value="Inseir uma data de nascimento" />
					</c:if> <c:if test="${not empty contato.dataNascimento }">
						<%-- <fmt:formatDate value="${contato.dataNascimento }" pattern="dd-mm-yyyy" var="dataFormatada"/> --%>
						<c:out value="${contato.dataNascimento }" />
					</c:if></td>
				<td>
					<a href="sistema?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>