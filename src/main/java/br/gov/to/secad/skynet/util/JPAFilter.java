package br.gov.to.secad.skynet.util;


import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author marceloclaudios
 */
@WebFilter(servletNames={"Faces Servlet"})
public class JPAFilter implements Filter {
    
    static private EntityManagerFactory factory;
    
          /**
     * @return the factory
     */
    public static EntityManagerFactory getFactory() {
        return factory;
    }

    /**
     * @param aFactory the factory to set
     */
    public static void setFactory(EntityManagerFactory aFactory) {
        factory = aFactory;
    }

    /**
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        JPAFilter.factory = Persistence.createEntityManagerFactory("skynet");
    }

    /**
     *
     */
    @Override
    public void destroy() {
        JPAFilter.factory.close();
    }
    
    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        
        EntityManager entityManager = JPAFilter.factory.createEntityManager();
        request.setAttribute("entityManager" , entityManager);
        //getTransaction(): Recupera a transação associada a um EntityManager
        //begin(); Uma vez que a transação foi recuperada, ela é ativada por esse metadado
        entityManager.getTransaction().begin();
                          
        chain.doFilter(request, response);        
        try {
            //commit(): Confirma uma transação, quando é invocado, ocorre uma sicronização com o banco de dados e a transação é finalizada
            entityManager.getTransaction().commit();
            //entityManager.clear();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}