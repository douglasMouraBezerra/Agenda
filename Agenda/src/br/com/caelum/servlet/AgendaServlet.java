package br.com.caelum.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.dao.AgendaDAO;
import br.com.caelum.model.Agenda;

@WebServlet("/AgendaServlet")
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = (String) request.getParameter("nome");
		String email = (String) request.getParameter("email");
		String endereco = (String) request.getParameter("endereco");

		String datanascimento = (String) request.getParameter("datanascimento");
		Agenda agenda = new Agenda();
		agenda.setNome(nome);
		agenda.setEmail(email);
		agenda.setEndereco(endereco);
		agenda.setDataNascimento(datanascimento);

		AgendaDAO dao = new AgendaDAO();
		dao.inserir(agenda);

		response.sendRedirect("cadastro-positivo.jsp");

	}

}
