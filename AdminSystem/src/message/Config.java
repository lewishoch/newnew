package message;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.omg.CORBA.portable.InputStream;

import jms.consumer.JMSConsumer;
import jms.consumer.impl.PtpConsumer;

@WebListener
public class Config implements ServletContextListener {
	public static int detecterForRefresh = 0;
	
    public void contextInitialized(ServletContextEvent event) {
        // Do your thing during webapp's startup.
//    	System.out.println("hahaha");
    	
    	
		JMSConsumer cons = new PtpConsumer();
		try {
//			cons.sendMsg();
			cons.receiveMsg();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		URL gwtServlet = null;
//		try {
//		    gwtServlet = new URL("http://localhost:8080/AdminSystem/listPendingMerchant");
//		    HttpURLConnection servletConnection = (HttpURLConnection) gwtServlet.openConnection();
//		    InputStream response = (InputStream) servletConnection.getInputStream();
//		
//		} catch (MalformedURLException e) {
//		    // TODO Auto-generated catch block
//		    e.printStackTrace();
//		} catch (IOException e) {
//		    // TODO Auto-generated catch block
//		    e.printStackTrace();
//		}
    }
    public void contextDestroyed(ServletContextEvent event) {
        // Do your thing during webapp's shutdown.
    }
}