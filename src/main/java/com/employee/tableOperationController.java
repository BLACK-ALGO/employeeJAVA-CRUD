package com.employee;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.employee.DbConnection.DbConnection;
import com.employee.Model.Employee;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class tableOperationController implements Initializable {
    @FXML
    private Button button;
    @FXML
    private TableView <Employee> employeeTable;
    
    @FXML
    private TableColumn <Employee , Integer> idCol;

    @FXML
    private TableColumn <Employee , String> nameCol;

    @FXML
    private TableColumn <Employee , String> AddressCol;
    @FXML
    private TableColumn <Employee , Double> SalaryCol;
    private TableColumn <Employee , String> ActionCol;
    // variables
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Employee employee = null;
    List<Employee> EmployeeList = new ArrayList<>();


    // form method
    @FXML
    private void close(MouseEvent event) {
        
    }

    @FXML
    private void getAddView(MouseEvent event) {
       
        
    }

    @FXML
     void refreshTable() {
        System.out.println("refresh");
        
        try {
            EmployeeList.clear();
            query = "SELECT * FROM `employee`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmployeeList.add(new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),  
                    resultSet.getString("password"), 
                    resultSet.getDouble("salary"),
                    resultSet.getString("category") ));
                    employeeTable.getItems().addAll(EmployeeList);
            }
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
        

        
    }
    @FXML
    private void printList(MouseEvent event) {
        
    }

    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loadData();
        
    }


    private void loadData() {

        try {
            connection = DbConnection.getConnect();
            refreshTable();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
         
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        AddressCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        SalaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        // Callback<TableColumn<Employee,String>, TableCell<Employee,String>> callFoctory = (TableColumn<Employee, String> param )->{
        //     final  TableCell<Employee, String> cell = new TableCell<Employee, String>(){
        //         public void upda

        //     };
    }
    @FXML
    private void getAddViews() throws IOException {
        App.setRoot("LogIn");
    }


}
