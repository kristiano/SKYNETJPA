package br.gov.to.secad.skynet.util;


import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import br.gov.to.secad.skynet.model.Pessoa;
import br.gov.to.secad.skynet.repository.UsuarioRepository;

/**
 *
 * @author marceloclaudios
 */
public abstract class ApplicationUtilies {

    /**
     *
     * @return
     */
    public static EntityManager catchEntityManager() {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        EntityManager entityManager = (EntityManager) FacesContext.getCurrentInstance().
                getApplication().getELResolver().getValue(elContext, null, "entityManager");
        return entityManager;
    }

    /**
     *
     * @return
     */
    public static Object getAuthenticadedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>(authentication.getAuthorities());
        //String role = roles.get(0).getAuthority();
        String username = authentication.getName();
        UsuarioRepository aRepository = new UsuarioRepository(catchEntityManager());
        return aRepository.loadLoggedUser(username);
    }

    /**
     *
     * @return
     */
    public static boolean isLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null || authentication.isAuthenticated()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @return
     */
    public static String loggedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    /**
     *
     * @param acentuada
     * @return
     */
    public static String trocaAcentuacao(String acentuada) {
        char[] acentuados = new char[]{'ç', 'á', 'à', 'ã', 'â', 'ä', 'é', 'è', 'ê', 'ë', 'í', 'ì', 'î', 'ï', 'ó', 'ò', 'õ', 'ô', 'ö', 'ú', 'ù', 'û', 'ü'};

        char[] naoAcentuados = new char[]{'c', 'a', 'a', 'a', 'a', 'a', 'e', 'e', 'e', 'e', 'i', 'i', 'i', 'i', 'o', 'o', 'o', 'o', 'o', 'u', 'u', 'u', 'u'};

        for (int i = 0; i < acentuados.length; i++) {
            acentuada = acentuada.replace(acentuados[i], naoAcentuados[i]);
            acentuada = acentuada.replace(Character.toUpperCase(acentuados[i]), Character.toUpperCase(naoAcentuados[i]));
        }

        acentuada = acentuada.toLowerCase().replaceAll(" ", "-");

        return acentuada;
    }

    /**
     *
     * @return
     */
    public static Pessoa getUsuarioLogado() {
        Authentication anAuthentication = SecurityContextHolder.getContext().getAuthentication();
        Pessoa anUser = null;
        if (anAuthentication.getPrincipal() instanceof Pessoa) {
            anUser = (Pessoa) anAuthentication.getPrincipal();
        }
        return anUser;
    }
}
