package com.cdut.entity;

public class Emp {
    private Integer empId;
    private String empName;
    private String idCard;
    private String password;
    private String dept;
    private String gender;
    private Integer age;
    private String phone;

    public Emp(Integer empId, String empName, String idCard, String password, String dept, String gender, Integer age, String phone) {
        this.empId = empId;
        this.empName = empName;
        this.idCard = idCard;
        this.password = password;
        this.dept = dept;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", password='" + password + '\'' +
                ", dept='" + dept + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
