/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            System.out.println("Conectndo...");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/juntamedica","postgres","12345");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
