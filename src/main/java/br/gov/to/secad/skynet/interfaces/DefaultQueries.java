/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.interfaces;

import java.util.List;

/**
 *
 * @param <Class> 
 * @param <T> 
 * @author marceloclaudios
 */
public interface DefaultQueries<Class, T> {
    
    /**
     *
     * @param id
     * @return
     */
    public Class getById(T id);
    /**
     *
     * @return
     */
    public List<Class> getListOfElements();    
    
}
