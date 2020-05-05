package com.company;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserDataPostgreSQL implements UserDataDriver {

    private Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CoolerTEST",
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
    public void createAccount(UserData user) throws SQLException {
        System.out.println("account has been created...");
        //String sql= "INSERT INTO  \"Urun\" (\"urunNo\",\"adi\",\"birimFiyati\",\"stokMiktari\") VALUES("+urun.getUrunNo()+",\'"+urun.getAdi()+"\',"+urun.getBirimFiyati()+","+urun.getStokMiktari()+")";

        //String sql= "INSERT INTO  public.\"UserData\" (userName,userPassword,userAccesType)"+" VALUES "+"("+user.getUserName()+","+user.getUserPassword()+","+user.getUserAccesType()+")" ;
        //System.out.println(sql);
        Connection conn=this.connect();
        PreparedStatement st = conn.prepareStatement("INSERT INTO public.\"UserData\" (\"userName\",\"userPassword\",\"userAccesType\") VALUES (?, ?, ?)");
        st.setString(1, user.getUserName());
        st.setString(2, user.getUserPassword());
        st.setString(3, user.getUserAccesType());


        try
        {

            st.executeUpdate();
            st.close();
            /**
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();*/
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
