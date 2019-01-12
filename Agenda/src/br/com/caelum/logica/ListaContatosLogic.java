package br.com.caelum.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.AgendaDAO;
import br.com.caelum.model.Agenda;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Agenda> contatos = new AgendaDAO().getListaContatos();

		request.setAttribute("contatos", contatos);

		return "lista-contatos.jsp";

	}

}
