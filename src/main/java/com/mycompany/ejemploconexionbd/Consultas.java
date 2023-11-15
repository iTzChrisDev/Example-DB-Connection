package com.mycompany.ejemploconexionbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas {

    ArrayList<String> data = new ArrayList<>();
    public void getData() {
        Conexion obC = new Conexion();

        try {
            String query = "SELECT ID,Name FROM city WHERE ID BETWEEN 5 AND 10 ";

            PreparedStatement pstm = obC.setConnection().prepareStatement(query);
            ResultSet output = pstm.executeQuery();

            while (output.next()) {
                data.add(output.getString(1) + " - " + output.getString(2));
            }
            
            for(String s : data)
            {
                System.out.println(s);
            }
        } catch (SQLException e) {
        }
        //obC.closeConnection();
    }
}
