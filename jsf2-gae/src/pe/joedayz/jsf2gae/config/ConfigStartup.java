package pe.joedayz.jsf2gae.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pe.joedayz.jsf2gae.model.Mercadoria;


import com.googlecode.objectify.ObjectifyService;


public class ConfigStartup implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Mercadoria.class);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}
	
}
