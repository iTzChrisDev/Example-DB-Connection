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

            for (String s : data) {
                System.out.println(s);
            }
        } catch (SQLException e) {
        }
        //obC.closeConnection();
    }

    public void insertData() {
        Conexion obC = new Conexion();
        try {
            //SELECT
            String query = "SELECT ID,Name FROM city WHERE ID BETWEEN 5 AND 10;";

            // INSERT
            String name = "México", countryCode = "MEX", district = "CDMX";
            int population = 596203;
            String query2 = "INSERT INTO city(Name,CountryCode,District,Population) VALUES (" + name + "," + countryCode + "," + district + "," + population + ");";

            // DELETE
            int id = 4080;
            String query3 = "DELETE FROM city WHERE ID = " + id + ";";

            //UPDATE
            String nameUpdate = "España", countryCodeUpdate = "ESP", districtUpdate = "Madrid";
            int populationUpdate = 453621, idUpdate = 1;
            String query4 = "UPDATE city SET Name = " + nameUpdate + ", CountryCode = " + countryCodeUpdate + ", District = " + districtUpdate + ", Population = " + populationUpdate + " WHERE ID = " + id + ";";

            //EJECUTAR LA CONSULTA
            PreparedStatement pstm = obC.setConnection().prepareStatement(query);
            ResultSet output = pstm.executeQuery();

            while (output.next()) {
                data.add(output.getString(1) + " - " + output.getString(2));
            }

        } catch (SQLException e) {
        }
    }
}
