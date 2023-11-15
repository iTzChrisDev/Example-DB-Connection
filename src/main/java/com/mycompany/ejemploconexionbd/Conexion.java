package com.mycompany.ejemploconexionbd;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conection = null;
    String user = "root";
    String password = "pass";
    String database = "world";
    String ip = "127.0.0.1";
    String puerto = "3306";

    String dir = "jdbc:mysql://" + ip + ":" + puerto + "/" + database;

    public Connection setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection(dir, user, password);
            JOptionPane.showMessageDialog(null, "Se ha conectado la BD", "Conexion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return conection;
    }

    public void closeConnection() {
        try {
            if (conection != null) {
                conection.close();
            }
        } catch (SQLException e) {
        }
    }
}
