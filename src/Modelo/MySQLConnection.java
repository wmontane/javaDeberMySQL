/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author wiler
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection {
    // Instancia única de la conexión
    private static MySQLConnection instance = null;
    
    // Datos de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://186.3.139.231:3306/db_appweb";
    private static final String USERNAME = "userJP";
    private static final String PASSWORD = "J4p0n2024";

    // Conexión a la base de datos
    private Connection connection;

    // Constructor privado para evitar instanciación externa
    private MySQLConnection() {
        try {
            // Se carga el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Se establece la conexión
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método estático para obtener la instancia única
    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
    
    
     public List<persona> cargar(int opcion, int ID, String Nombre, int edad) {
        ResultSet resultSet = null;
        
        List<persona> lista= new ArrayList<>();
        
        try {
            
            // Preparar la llamada al stored procedure
            String callStatement = "{call " + "CRUD_Datos" + "(?, ?,?,?)}";
            CallableStatement stmt = connection.prepareCall(callStatement);
            // Establecer los parámetros
            stmt.setInt(1, opcion);
            stmt.setInt(2, ID);
            stmt.setString(3, Nombre);
            stmt.setInt(4, edad);
            // Ejecutar el stored procedure y obtener el resultado
            stmt.execute();
            resultSet = stmt.getResultSet();
            if(opcion==0)
            {
                while (resultSet.next()) {
                   int _id = resultSet.getInt("id");
                   String _nombre = resultSet.getString("nombre");
                   int _edad = resultSet.getInt("edad");
                   persona datos = new persona(_id, _nombre,_edad);
                   lista.add(datos);
               }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}