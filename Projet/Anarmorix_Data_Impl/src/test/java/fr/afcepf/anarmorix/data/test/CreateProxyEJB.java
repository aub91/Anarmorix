package fr.afcepf.anarmorix.data.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
/**
 * Classe de création de proxy.
 * @author Aubin
 *
 */
public final class CreateProxyEJB {
    /**
     * Méthode pour retourner un proxy.
     * @param JNDI chemin JNDI
     * @return null
     */
    public static Object getProxy(String JNDI) {
        Properties props = new Properties();
        props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:18080");
        props.put(Context.SECURITY_PRINCIPAL, "ai101");
        props.put(Context.SECURITY_CREDENTIALS, "afcepf");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put("jboss.naming.client.ejb.context", true);
            try {
                Context ctx = new InitialContext(props);
                Object proxy = ctx.lookup(JNDI);
                System.out.println(proxy);
                return proxy;
            } catch (Exception e) {
                e.printStackTrace();
            }
         return null;
    }
}
