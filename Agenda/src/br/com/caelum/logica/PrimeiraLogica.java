package br.com.caelum.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Iniciando nossa primeira Logica");

		return "primeira-logica.jsp";
	}

}
