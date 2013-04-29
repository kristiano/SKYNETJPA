package br.gov.to.secad.skynet.model;


import br.gov.to.secad.skynet.util.BaseEntity;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries ({
    @NamedQuery (name="Pessoa.findAll", query="SELECT a FROM Pessoa a"),
    @NamedQuery (name="Pessoa.getById", query="SELECT a FROM Pessoa a WHERE a.id = :id")
})

@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa  implements Serializable,BaseEntity{

    @Id
    @GeneratedValue    
    protected Long id;
    protected String nome;
    
    /**
     *
     */
    @Email
    @NotEmpty(message="Digite um e-mail")
    protected String email;
  
    public Pessoa() {
        
    }

     @Override
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    /**
     * Método setEmail Utilize-o definir um email.
     *
     * @param email 
     * @author Glaubos Climaco
     * @since 1.0
     * @version 1.0
@sigd.com.br
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    

    
    
    

    
   
}
