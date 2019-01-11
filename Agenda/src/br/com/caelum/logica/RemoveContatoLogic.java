package br.com.caelum.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.AgendaDAO;
import br.com.caelum.model.Agenda;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));// fazemos parse por que aqui os valores vem como string

		Agenda agenda = new Agenda();
		agenda.setId(id);

		AgendaDAO dao = new AgendaDAO();
		dao.delete(id);

		System.out.println("Exluindo contato"); // simulando logs

		return "lista-contatos.jsp";
	}

}
