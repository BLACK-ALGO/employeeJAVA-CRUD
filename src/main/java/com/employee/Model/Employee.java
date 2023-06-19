package com.employee.Model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String password;
    private double salary;
    private String category;

    public Employee(int id,String name, String email,String password,  double salary, String category) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.salary = salary;
        this.category = category;

    }
    
    // id getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // name getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// salary getter and setter
    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    // getter and setter of email

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // getter and setter for category

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // getter and setter of password
    public String getPassword() {
        return category;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Name: " + name + "\nPassword: " + password + "\nSalary: " + salary + "\nEmail: " + email + "\nCategory: " + category;
    }


}
