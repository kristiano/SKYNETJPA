/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.dao;
import java.sql.Connection;

public class ConnectionDataBase {
    protected Connection con;

    public ConnectionDataBase() {
        this.con = new ConnectionFactory().getConnection();
    }
}
