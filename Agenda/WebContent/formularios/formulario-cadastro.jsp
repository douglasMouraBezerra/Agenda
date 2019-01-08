<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<title>Cadastro</title>
</head>
<body>

	<%-- 	${pageContext.request.contextPath}/AgendaServlet --%>
	<form action="${pageContext.request.contextPath}/AgendaServlet" method="post">
		<fieldset>
			<legend>Cadastrar Contato</legend>
			<div class="form-group col-md-3">
				<label for="nome">Nome</label> <input type="text"
					class="form-control" name="nome" id="nome" tabindex="1">
			</div>
			<div class="form-group col-md-3">
				<label for="email">Email</label> <input type="email"
					class="form-control" tabindex="2" name="email" id="email">
			</div>
			<div class="form-group col-md-3">
				<label for="endereco">Endereço</label> <input type="text"
					class="form-control" name="endereco" id="endereco">
			</div>
			<div class="form-group col-md-3">
				<label for="datanascimento">Data Nascimento</label> <input
					type="date" class="form-control" id="datanascimento"
					name="datanascimento" required pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}">
			</div>
			<input type="submit" class="btn btn-light" value="GRAVAR">
		</fieldset>
	</form>

</body>
</html>