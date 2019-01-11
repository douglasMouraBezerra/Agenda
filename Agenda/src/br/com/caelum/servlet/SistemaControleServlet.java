package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.logica.Logica;

@SuppressWarnings("rawtypes")
@WebServlet("/sistema")
public class SistemaControleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.logica." + parametro;

		try {
			Class classe = Class.forName(nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);

			request.getRequestDispatcher(pagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("Não foi possivel excutar lógica");
		}

	}

}
