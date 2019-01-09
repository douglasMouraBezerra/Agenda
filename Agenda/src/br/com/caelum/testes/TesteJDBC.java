package br.com.caelum.testes;

import java.util.List;

import org.junit.Test;

import br.com.caelum.dao.AgendaDAO;
import br.com.caelum.model.Agenda;

public class TesteJDBC {

	@Test
	public void initInserir() {
		Agenda agenda = new Agenda();
		agenda.setNome("Dr Joel");
		agenda.setEmail("drJoel@gmail.com");
		agenda.setEndereco("Avenida 17 de Agosto 4031, Casa Forte,Recife-PE");
		// agenda.setDataNascimento(new Date(Calendar.getInstance().getTime()));

		AgendaDAO dao = new AgendaDAO();
		dao.inserir(agenda);
	}

	@Test
	public void initAtualizar() {
		Agenda agenda = new Agenda();
		agenda.setNome("douglas de moura bezerra".toUpperCase());
		agenda.setEmail("douglasmourab91@gmail.com".toUpperCase());
		agenda.setEndereco("Rua Marrocos 87 Casa A, Pau Amarelo,Paulista-PE");
		// agenda.setDataNascimento("14/06/1991");

		AgendaDAO dao = new AgendaDAO();
		dao.atualiza(agenda, 1L);

	}

	@Test
	public void initListar() {
		AgendaDAO dao = new AgendaDAO();
		List<Agenda> contatos = dao.getListaContatos();
		for (Agenda agenda : contatos) {
			System.out.println(agenda.toString());
		}
	}

	@Test
	public void initDeletar() {
		AgendaDAO dao = new AgendaDAO();
		dao.delete(3L);
	}

}
