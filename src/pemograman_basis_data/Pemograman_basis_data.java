/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemograman_basis_data;
import java.sql.*;


/**
 *
 * @author user
 */
public class Pemograman_basis_data {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL_DB = "jdbc:mysql://localhost/pertemuan_satu";
    static final String username_db = "root";
    static final String pass_db="";
    
    static Connection con;
    static ResultSet rs;
    static Statement st;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        koneksi();
        tampildata();
    }
    static void koneksi(){
    try{
        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(URL_DB,username_db,pass_db);
        st = con.createStatement();
        
    } catch (Exception e) {
        e.getMessage();
        System.out.print("koneksi gagal");
        }
    } 
    static void tampildata(){
        try {
            String sql = "select * from anggota";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getString("id"));
                System.out.print(rs.getString("nama"));
                System.out.print(rs.getString("email"));
                System.out.print(rs.getString("alamat"));
                System.out.print(rs.getString("tanggal_lahir"));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
