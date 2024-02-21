/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author wiler
 */
public class persona {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    
    private int ID;
    private String Nombre;
    private int Edad;
    
        public persona(int ID, String Nombre, int Edad) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Edad = Edad;
    }
        public persona(){}
        
    public void guardar(persona p){
        
    }   
}
