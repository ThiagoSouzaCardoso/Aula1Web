package br.com.fiap.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerApplication implements HttpSessionListener, HttpSessionAttributeListener,ServletRequestAttributeListener, ServletContextListener {

	public ListenerApplication() {
	
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		gerarLog("Sess�o Criado");
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		gerarLog("Atributo removido da requisi��o");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		gerarLog("Atributo removido da Sess�o");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		String s = (String) arg0.getServletRequest().getAttribute("msg");
		if(s != null){
			gerarLog("Atributo '" +s+"' adicionado na requisi��o");
		}
		else{
			gerarLog("Atributo adicionado na requisi��o");
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		gerarLog("Aplica��o Finalizada");
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		gerarLog("Atributo Alterada na requisi��o");
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo adicionado na Sess�o");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo removido na Sess�o");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo aualizado na Sess�o");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		gerarLog("Aplica��o inicializada");
	}

	public void gerarLog(String texto){
		try {
			File file = new File("D:\\workAluno2\\log.xhtml");
			FileWriter arquivo = new FileWriter(file,true);
			arquivo.write("["+ new Date()+"] - " + texto +"\r\n");
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}