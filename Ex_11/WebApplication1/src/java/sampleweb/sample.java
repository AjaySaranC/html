/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampleweb;

import java.io.*;
import java.util.*;

import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "sample")
public class sample {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "read")
    public java.lang.String[] read() {
        //TODO write your implementation code here:
        String[] str= new String[6];
        try{   
            for(int i=0;i<6;i++)
            {
                str[i]="0";
            }
            Connection conn = null;
            Statement stmt = null;
             Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "");

                String sql;
                // display 
                stmt = conn.createStatement();
                sql = "SELECT * FROM product";
                ResultSet rs = stmt.executeQuery(sql);
                int i = 0;
                while (rs.next()) {
                String title = rs.getString("name");
                str[i] = title;
                i++;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return str;
    }

    /**
     * This is a sample web service operation
     */
    
   
}
