package lab4;

import java.sql.*;
import java.util.Scanner;

public class controller {
    String url = "jdbc:mysql://localhost:3306/ebookstore";
    String use = "root";
    String pass = "";
    public void top10new(){
        try(
                Connection conn = DriverManager.getConnection(url,use,pass);
                Statement stmt = conn.createStatement()
        ) {
            System.out.println("The 10 newest books:");
            String sqlSelect = "select * from books order by years limit 10";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            ResultSetMetaData rSetMD = rSet.getMetaData();
            int numColumn = rSetMD.getColumnCount();
            for (int i = 1; i <= numColumn; ++i){
                System.out.printf("%-30s",rSetMD.getColumnName(i));
            }
            System.out.println();
            while (rSet.next()){
                for (int i = 1; i <= numColumn; ++i){
                    System.out.printf("%-30s",rSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void topSale(){
        try(
                Connection conn = DriverManager.getConnection(url,use,pass);
                Statement stmt = conn.createStatement()
        ) {
            String sqlSelect =  "select books.bookID,books.title,author,years,genre,books.status,qty,books.price,sum(orderdetail.amount) " +
                    "as soldAmount from books " +
                    "inner join orderdetail on books.bookID = orderdetail.bookID " +
                    "inner join orders on orders.orderID = orderdetail.orderID" +
                    " where orders.status != 0 group by books.bookID,books.title,author,years,genre,books.status,qty,books.price order by soldAmount DESC limit 10";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            ResultSetMetaData rSetMD = rSet.getMetaData();
            int numColumn = rSetMD.getColumnCount();
            for (int i = 1; i <= numColumn; ++i){
                System.out.printf("%-30s",rSetMD.getColumnName(i));
            }
            System.out.println();
            while (rSet.next()){
                for (int i = 1; i <= numColumn; ++i){
                    System.out.printf("%-30s",rSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void FindByCategory() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter category(1-Detective ,2-Poem,3-Literature");
        int category = input.nextInt();
        try (
                Connection conn = DriverManager.getConnection(url, use, pass);
                Statement stmt = conn.createStatement();
        ){
            String sqlState = "SELECT bookID,title,author,years,books.genre,status,qty,price FROM books " +
                    "inner join category on category.genre = books.genre where books.genre =" + category;
            ResultSet rSet = stmt.executeQuery(sqlState);
            ResultSetMetaData rSetMD = rSet.getMetaData();
            int numColumn = rSetMD.getColumnCount();
            for (int i = 1; i <= numColumn; ++i) {
                System.out.printf("%-30s", rSetMD.getColumnName(i));
            }
            System.out.println();
            while (rSet.next()) {
                for (int i = 1; i <= numColumn; ++i) {
                    System.out.printf("%-30s", rSet.getString(i));
                }
                System.out.println();
            }
            } catch(SQLException throwables){
                throwables.printStackTrace();
            }
    }
    public void FindByAuthor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter writer");
        String author = input.nextLine();
        try (
                Connection conn = DriverManager.getConnection(url, use, pass);
                Statement stmt = conn.createStatement();
        ){
            String sqlState =  "SELECT bookID,title,author,years,books.genre,status,qty,price FROM books where author like \'%" + author + "%\'";
            ResultSet rSet = stmt.executeQuery(sqlState);
            ResultSetMetaData rSetMD = rSet.getMetaData();
            int numColumn = rSetMD.getColumnCount();
            for (int i = 1; i <= numColumn; ++i) {
                System.out.printf("%-30s", rSetMD.getColumnName(i));
            }
            System.out.println();
            while (rSet.next()) {
                for (int i = 1; i <= numColumn; ++i) {
                    System.out.printf("%-30s", rSet.getString(i));
                }
                System.out.println();
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void FindByID(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter writer");
        int bkID = input.nextInt();
        try (
                Connection conn = DriverManager.getConnection(url, use, pass);
                Statement stmt = conn.createStatement();
        ){
            String sqlState =  "SELECT *FROM books where bookID =  " + bkID;
            ResultSet rSet = stmt.executeQuery(sqlState);
            ResultSetMetaData rSetMD = rSet.getMetaData();
            int numColumn = rSetMD.getColumnCount();
            for (int i = 1; i <= numColumn; ++i) {
                System.out.printf("%-30s", rSetMD.getColumnName(i));
            }
            System.out.println();
            while (rSet.next()) {
                for (int i = 1; i <= numColumn; ++i) {
                    System.out.printf("%-30s", rSet.getString(i));
                }
                System.out.println();
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
