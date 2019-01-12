package br.com.caelum.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.AgendaDAO;
import br.com.caelum.model.Agenda;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nome = (String) request.getParameter("nome");
		String email = (String) request.getParameter("email");
		String endereco = (String) request.getParameter("endereco");
		String dataNascimento = (String) request.getParameter("datanascimento");

		Agenda agenda = new Agenda();
		agenda.setNome(nome);
		agenda.setEmail(email);
		agenda.setEndereco(endereco);
		agenda.setDataNascimento(dataNascimento);

		AgendaDAO dao = new AgendaDAO();
		dao.inserir(agenda);

		// valor diferente
		// caelum?logica=AdicionaContatoLogic&id=${contato.id}
		return "contato-adicionado.jsp";
	}

}
