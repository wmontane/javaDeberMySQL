/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author wiler
 */
public class modeloDatos {


        public List<persona> cargar(int opcion, int ID, String nombre, int edad)
        {
            MySQLConnection connection = MySQLConnection.getInstance();
            List<persona> datosList = connection.cargar(opcion,ID, nombre, edad);
            return datosList;
        }
        
}
