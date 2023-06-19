package com.employee;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.employee.DbConnection.DbConnection;
import com.employee.Model.Employee;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class LogInController implements Initializable{


    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbWorker;

    @FXML
    private TextField LogInEmail;

    @FXML
    private TextField LogInPwd;

    @FXML
    private Button login;

    @FXML
    private Button reset;


    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Employee employee = null;



    @FXML
    void Reset() {
        System.out.println("wlll");
        System.out.println(rbAdmin.getText());

    }

    @FXML
    private void logIn() throws IOException {
        // Employee newEmployee = new Employee(0, query, query, query, 0, query)

        if (rbAdmin.isSelected()) {
            try {
                connection = DbConnection.getConnect();
                query = "SELECT * FROM employee WHERE name =? AND password = ? AND category= ? " ;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, LogInEmail.getText());
                preparedStatement.setString(2, LogInPwd.getText());
                preparedStatement.setString(3, rbAdmin.getText());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    App.setRoot("AddEmployee");
                    
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING,"Login Error", ButtonType.OK);
                    alert.show();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
            
        } else {
            String category = "Worker";
            System.out.println(category);
        }
        


    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Reset();
    }

}



