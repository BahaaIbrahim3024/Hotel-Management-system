/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmanage.Controller;

import hmanage.View.HManage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static hmanage.View.HManage.*;
import hmanage.model.Staff;
import hmanage.model.Visitor;

/**
 *
 * @author ibaha
 */
public class DBManager {

    Connection conn;
    Statement stat;
    ResultSet rs;

    public Connection openConnection() throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldbsys", "root", "root");
            System.out.println("Connection stablished....");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    //Staff Methods 
    public boolean insert(Staff s) throws SQLException {
        try {
            stat = openConnection().createStatement();
            String sql = "INSERT INTO `staff` (`username`, `password`, `fname`, `lname`,`age`,`phone`,`address`) VALUES ('"
                    + s.getUsername() + "', '" + s.getPassword() + "', '" + s.getFname() + "', '" + s.getLname() + "', '" + s.getAge() + "', '" + s.getPhone() + "', '" + s.getAddress() + "')";
            return stat.execute(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void getAllStaff() throws SQLException {
        HManage.staff.clear();
        try {
            String sql = " SELECT * FROM `staff` ";
            stat = openConnection().createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Staff st = new Staff();
                st.setId(rs.getInt(1));
                st.setUsername(rs.getString(2));
                st.setPassword(rs.getString(3));
                st.setFname(rs.getString(4));
                st.setLname(rs.getString(5));
                st.setAge(rs.getInt(6));
                st.setPhone(rs.getString(7));
                st.setAddress(rs.getString(8));

                System.out.println(st.toString());
                HManage.staff.add(st);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id){
        try {
            stat = openConnection().createStatement();
            String sql = "DELETE FROM `staff` WHERE `staff`.`id` = \'" + id+"\';";
            stat.execute(sql);
            getAllStaff();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Staff st) throws SQLException {
        try {
            stat = openConnection().createStatement();
            String sql = "UPDATE `staff` SET `username` = '" + st.getUsername() + "' , `password` = '" + st.getPassword() + "' , `fname` = '" + st.getFname() + "' , `lname` = '" + st.getLname() + "' , `age` = '" + st.getAge() + "' , `phone` = '" + st.getPhone() + "' , `address` = '" + st.getAddress() + "' WHERE `staff`.`id` = " + st.getId() + ";";;
            stat.execute(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Visitors Methods
    public boolean insertV(Visitor v) throws SQLException {
        try {
            stat = openConnection().createStatement();
            String sql = "INSERT INTO `visitor` ( `fname`, `lname`,`age`,`gender`,`phone`,`address`, `country`,`nationalId`, `companions`) VALUES ('"
                    + v.getfName() + "', '" + v.getlName() + "', '" + v.getAge() + "', '" + v.getGender() + "', '" + v.getPhone() + "', '" + v.getAddress() + "', '" + v.getCountry() + "', '" + v.getNationalID() + "', '" + v.getCompany() + "')";
            return stat.execute(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void getAllVisitors() throws SQLException {
        HManage.visitor.clear();
        try {
            String sql = " SELECT * FROM `visitor` ";
            stat = openConnection().createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Visitor vis = new Visitor();
                vis.setfName(rs.getString(1));
                vis.setlName(rs.getString(2));
                vis.setAge(rs.getInt(3));
                vis.setGender(rs.getString(4));
                vis.setPhone(rs.getString(5));
                vis.setAddress(rs.getString(6));
                vis.setCountry(rs.getString(7));
                vis.setNationalID(rs.getString(8));
                vis.setCompany(9);
                HManage.visitor.add(vis);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteV(String name) throws SQLException {
        try {
            stat = openConnection().createStatement();
            String sql = "DELETE FROM `visitor` WHERE `visitor`.`fname` = " + name;
            stat.execute(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateV(Visitor vi) throws SQLException {
        try {
            stat = openConnection().createStatement();
            String sql = "UPDATE `visitor` SET `fname` = '" + vi.getfName() + "' , `lname` = '" + vi.getlName() + "' , `age` = '" + vi.getAge() + "' , `gender` = '" + vi.getGender() + "' , `phone` = '" + vi.getPhone() + "' , `address` = '" + vi.getAddress() + "' , `country` = '" + vi.getCountry() + "' , `nationalId` = '" + vi.getNationalID() + "' , `companions` = '" + vi.getCompany() + "' WHERE `visitor`.`fname` = " + vi.getfName() + ";";
            stat.execute(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
