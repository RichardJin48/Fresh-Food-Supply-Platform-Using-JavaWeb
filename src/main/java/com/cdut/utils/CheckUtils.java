package com.cdut.utils;

public class CheckUtils {
    public static Boolean isPhone(String phone) {
        if(!phone.equals("")) {
            String regex = "[1][34578][0-9]{9}";
            if (phone.matches(regex)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static Boolean isIdCard(String id) {
//        if(!id.equals("")) {
//            if (id.length()==18) {
//                int arr[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
//                int arrCheck[] = {1, 0, 88, 9, 8, 7, 6, 5, 4, 3, 2};
//                int sum = 0;
//                for (int i = 0; i < arr.length; i++) {
//                    char c = id.charAt(i);
//                    int a = c - 48;
//                    sum += a * arr[i];
//                }
//                if (id.charAt(17) == 88) {
//                    if (arrCheck[sum % 11] == 88)
//                        return true;
//                    else
//                        return false;
//                }
//                else {
//                    char c = id.charAt(17);
//                    if (arrCheck[sum % 11] == c - 48)
//                        return true;
//                    else
//                        return false;
//                }
//            }
//            return false;
//        }
        return true;
    }

    public static String checkPassword(String password){
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[0-9a-zA-Z]{8,16}$";
        if(password.equals("")){
            return "Password is not filled!";
        }
        else if(password.matches(regex)){
            return "correct";
        }
        else {
            return "Password format is wrong! It should be 8-16 digits and contain numbers, lowercase and uppercase letters";
        }
    }

    public static String checkValid(String id,String phone){
        String inf;
        if (isPhone(phone)&&!isIdCard(id)){
            inf = "ID number format is wrong!";
        }
        else if (!isPhone(phone)&&isIdCard(id)){
            inf = "Phone number format is wrong!";
        }
        else if (!isPhone(phone)&&!isIdCard(id)){
            inf = "ID and phone number format is wrong!";
        }
        else{
            inf = "correct";
        }
        return inf;
    }

    public static String checkExist(String name,String id){
        String inf;
        if (name.equals("")&&!id.equals("")){
            inf = "Name is not filled!";
        }
        else if (!name.equals("")&&id.equals("")){
            inf = "ID number is not filled!";
        }
        else if (name.equals("")&&id.equals("")){
            inf = "name and ID number is not filled!";
        }
        else{
            inf = "filled";
        }
        return inf;
    }

    public static String checkEmp(String name,String id,String phone){
        String inf = checkExist(name,id);
        if(!inf.equals("filled")){
            return inf;
        }
        inf = checkValid(id,phone);
        return inf;
    }

    public static String checkCustomer(String name,String password,String phone){
        String inf = checkExist(name,"0");
        if(!inf.equals("filled")){
            return inf;
        }
        inf = checkPassword(password);
        if(!inf.equals("correct")){
            return inf;
        }
        inf = checkValid("",phone);
        return inf;
    }

    public static String checkCustomer2(String name,String password,String phone){
        String inf = checkExist(name,"0");
        if(!inf.equals("filled")){
            return inf;
        }
        inf = checkPassword(password);
        if(!inf.equals("correct") && !inf.equals("Password is not filled!")){
            return inf;
        }
        inf = checkValid("",phone);
        return inf;
    }

    public static void main(String[] args) {
//        String check = checkEmp("qwerty","123456","123456");
        String check = checkCustomer("qwerty","123456","123456");
        System.out.println(check);
    }
}
