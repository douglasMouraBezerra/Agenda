package br.com.caelum.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
		String dataNascimento = (String) request.getParameter("datanascimento");

		
		// instanciando bean
		Agenda agenda = new Agenda();
		agenda.setNome(nome);
		agenda.setEmail(email);
		agenda.setEndereco(endereco);
		agenda.setDataNascimento(dataNascimento);
		
		// instanciando o DAO
		AgendaDAO dao = new AgendaDAO();
		dao.inserir(agenda);

		// instanciando objeto requestDispatcher para mostrar resposta em outro pagina
		RequestDispatcher dispatcher = request.getRequestDispatcher("contato-adicionado.jsp");
		dispatcher.forward(request, response);

	}

}
