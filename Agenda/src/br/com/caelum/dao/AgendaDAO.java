package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.connection.SingleConnection;
import br.com.caelum.model.Agenda;

public class AgendaDAO {

	private Connection connection = null;

	public AgendaDAO() {
		connection = SingleConnection.getConnection();
	}

	public void inserir(Agenda agenda) {
		String sql = "insert into contatos(nome, email, endereco, datanascimento) values ( ?, ?, ?, ? )";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, agenda.getNome());
			statement.setString(2, agenda.getEmail());
			statement.setString(3, agenda.getEndereco());
			statement.setString(4, agenda.getDataNascimento());

			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	public List<Agenda> getListaContatos() {
		List<Agenda> contatos = new ArrayList<>();
		String sql = "select * from contatos";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {

				// montando o contato
				Agenda agenda = new Agenda();
				agenda.setId(resultSet.getLong("id"));
				agenda.setNome(resultSet.getString("nome"));
				agenda.setEmail(resultSet.getString("email"));
				agenda.setEndereco(resultSet.getString("endereco"));
				agenda.setDataNascimento(resultSet.getString("datanascimento"));
				// montando a data

				contatos.add(agenda);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return contatos;

	}

	public void delete(Long id) {
		String sql = "delete from contatos where id = " + id;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {

				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void atualiza(Agenda agenda, Long id) {
		String sql = "UPDATE contatos set nome = ?, email = ?, endereco = ?, datanascimento = ? where id = "
				+ id;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, agenda.getNome());
			stmt.setString(2, agenda.getEmail());
			stmt.setString(3, agenda.getEndereco());
			stmt.setString(4, agenda.getDataNascimento());
			stmt.execute();
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	// private boolean existe(Long id) {

}
