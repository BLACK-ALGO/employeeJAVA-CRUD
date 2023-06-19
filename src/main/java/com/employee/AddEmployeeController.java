package com.employee;
// import java.io.IOException;
// import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employee.DbConnection.DbConnection;
import com.employee.Model.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AddEmployeeController {
    @FXML
    private Button backList;
    @FXML
    private TextField empCPassword;
    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbWorker;

    @FXML
    private ToggleGroup empCat;

    @FXML
    private TextField empEmail;
    @FXML
    private TextField empName;
    @FXML
    private TextField empPassword;
    @FXML
    private TextField empSalary;
    // cate
    String category;

    // connectio variables
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Employee employee = null;
    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void backTOList(ActionEvent event) throws IOException {
        App.setRoot("TableView");
    }



    @FXML
    public void save() throws SQLException, IOException{
        if (rbAdmin.isSelected()) {
            category = "Admin";
            System.out.println(category);
        } else {
            category = "Worker";
            System.out.println(category);
        }
        
        System.out.println(empCPassword.getText());
        connection = DbConnection.getConnect();


        String name = empName.getText();
        String email = empEmail.getText();
        String password = empPassword.getText();
        String cpassword = empCPassword.getText();
        String salary = empSalary.getText();
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || cpassword.isEmpty() || salary.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please Fill All Fiel");
                alert.showAndWait();
            
        }else{
            if (password.equals(cpassword) && password.length() > 5) {
                double sala = Double.parseDouble(salary);
                if (Double.class.isInstance(sala)) {
                    // creating Employee
                    Employee newEmployee = new Employee(0, empName.getText(), 
                    empEmail.getText(), empPassword.getText(), Double.parseDouble(salary), category);
                
                   query = "INSERT INTO `employee`( `name`, `email`, `password`, `salary`, `category`) VALUES (?,?,?,?,?)";
                   preparedStatement = connection.prepareStatement(query);
                    //setting value
                    preparedStatement.setString(1, newEmployee.getName());
                    preparedStatement.setString(2, newEmployee.getEmail());
                    preparedStatement.setString(3, newEmployee.getPassword());
                    preparedStatement.setDouble(4, newEmployee.getSalary());
                    preparedStatement.setString(5, newEmployee.getCategory());
                    preparedStatement.executeUpdate();
                    clean();
                     App.setRoot("TableView");

                    

                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Salaray take only Integer or Flaot Number");
                    alert.showAndWait();
                }
               


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Password Not Matching Or Password length should be greater than 5");
                alert.showAndWait();
            }
        }

    }
    
    // private void getQuery() {
    //     query = "INSERT INTO `employee`(`id`, `name`, `email`, `password`, `salary`, `category`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]')";
    // }



    // private void insert() throws SQLException {
    //     preparedStatement = connection.prepareStatement(query);
    //     preparedStatement.setString(0, query);
    //     preparedStatement.setString(1, empName.getText());
    //     preparedStatement.setString(2, empEmail.getText());
    //     preparedStatement.setString(3, empPassword.getText());
    //     preparedStatement.setDouble(4, Double.parseDouble(empSalary.getText()));
    //     preparedStatement.setString(5, empCateroty.getText());


    // }



    @FXML
    public void clean(){
        
    
        empName.clear();
        empEmail.clear();
        empCPassword.clear();
        empPassword.clear();
        empSalary.clear();
        
    }

    

    
}
