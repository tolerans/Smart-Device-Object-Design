package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDataPostgreSQL implements UserDataDriver {

    private Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UserData",
                    "postgres", "111111");
            if (conn != null)
                System.out.println("Database connection Succesfully!");
            else
                System.out.println("Error occured database is not connect !");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void createAccount(UserData user){
        System.out.println("account has been created...");
        //String sql= "INSERT INTO  \"Urun\" (\"urunNo\",\"adi\",\"birimFiyati\",\"stokMiktari\") VALUES("+urun.getUrunNo()+",\'"+urun.getAdi()+"\',"+urun.getBirimFiyati()+","+urun.getStokMiktari()+")";

        String sql= "INSERT INTO  \"UserData\" (\"userName\",\"userPassword\") VALUES(\'"+user.getUserName()+"\',"+user.getUserPassword()+")";

        Connection conn=this.connect();

        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/**
    public void deleteAccount(int urunNumarasi){
        System.out.println("ürün siliniyor...");

        String sql= "DELETE FROM \"Urun\" WHERE \"urunNo\"="+urunNumarasi;

        Connection conn=this.baglan();
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }**/
}
