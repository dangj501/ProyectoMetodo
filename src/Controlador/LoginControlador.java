/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Modelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author juanl
 */
public class LoginControlador implements Initializable {

    @FXML
    private Button botonInicio;
    @FXML
    private TextField UsuarioTXT;
    @FXML
    private TextField contrasenaTxt;
    private Modelo modelo = new Modelo();
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(ActionEvent event) {
        if(modelo.verificarUsuario(UsuarioTXT.getText(), contrasenaTxt.getText())){
            System.out.println("Welcome!!!");
        }else{
            System.out.println("Error Usuario O Contraseña incorrecta");
        }
    }
    
}
