package br.com.caelum.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author Douglas de Moura Bezerra
 *
 */
public interface Logica {

	String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
