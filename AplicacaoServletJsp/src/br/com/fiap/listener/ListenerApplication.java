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
		gerarLog("Sessão Criado");
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		gerarLog("Atributo removido da requisição");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		gerarLog("Atributo removido da Sessão");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		String s = (String) arg0.getServletRequest().getAttribute("msg");
		if(s != null){
			gerarLog("Atributo '" +s+"' adicionado na requisição");
		}
		else{
			gerarLog("Atributo adicionado na requisição");
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		gerarLog("Aplicação Finalizada");
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		gerarLog("Atributo Alterada na requisição");
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo adicionado na Sessão");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo removido na Sessão");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo aualizado na Sessão");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		gerarLog("Aplicação inicializada");
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