package br.gov.to.secad.skynet.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe referente as informações de um Estado que pode possuir vários
 * Municípios
 *
 * @author Kristiano
 */
@Entity
@NamedQueries ({
    @NamedQuery (name="Pais.findAll", query="SELECT a FROM Pais a"),
    @NamedQuery (name="Pais.getById", query="SELECT a FROM Pais a WHERE a.id = :id")
})
public class Pais implements Serializable {

    @Id
    @GeneratedValue    
    private Long id;
    private String nome;

    /**
     * Método contrutor Utilize-o para inicializar um objeto do tipo Estado.
     *
     * @author Kristiano Fernandes
     * @since 1.0
     * @version 1.0
     */
    public Pais() {
    }

    /**
     * Método getId Utilize-o para retornar uma id.
     *
     * @author Kristiano Fernandes
     * @since 1.0
     * @version 1.0
     * @return id. ex.: 1
     */
    public long getId() {
        return id;
    }

    /**
     * Método getNome Utilize-o para retornar um nome .
     *
     * @author Kristiano Fernandes
     * @since 1.0
     * @version 1.0
     * @return nome. ex.: Glaubos
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método setNome Utilize-o para definir um nome .
     *
     * @author Kristiano Fernandes
     * @since 1.0
     * @version 1.0
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método getSigla Utilize-o para retornar uma sigla.
     *
     * @author Kristiano Fernandes
     * @since 1.0
     * @version 1.0
     * @return sigla. ex.: MA
     */
    
}
