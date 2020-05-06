package com.company;

import java.sql.*;

public abstract class UserDataPostgreSQL implements UserDataDriver {

    private int setFlag = 0;

    public int getSetFlag() {
        return setFlag;
    }

    public void setSetFlag(int setFlag) {
        this.setFlag = setFlag;
    }



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
        PreparedStatement st = conn.prepareStatement("INSERT INTO public.\"UserData\" (\"username\",\"userpassword\",\"useraccestype\") VALUES (?, ?, ?)");
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
    @Override
    public void checkAccount(String userName, String userPassword) throws SQLException {
        Connection conn=this.connect();
        //String sql = "SELECT *  FROM  public.\"UserData\" WHERE \"UserData\".username = \'"+userName+"\' and \"UserData\".userpassword = \'"+userPassword+"\'" ;
        String sql = "SELECT *  FROM  public.\"UserData\"";
        //System.out.println(sql);
        //PreparedStatement st = conn.prepareStatement("SELECT *  FROM  public.\"UserData\" WHERE \"UserData\".username = \'" + userName +"\' and \"UserData\".userpassword = \'" +userPassword +"\'");
        //st.setString(1, userName);
        //st.setString(2, userPassword);

        try
        {
            Statement st = conn.createStatement();
            //st.executeUpdate(sql);**/
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){

                if (!(userName == rs.getString("username") && userPassword == rs.getString("userpassword"))){

                    System.out.println("This account registered in the system ");
                    setSetFlag(1);
                    break;
                }
            }
            st.close();
            if (getSetFlag() == 1) {
                System.out.println("Welcome "+userName+"");
            }
            else {
                System.out.println("user is not registered in the system"+userName);
            }

        } catch (Exception e) {
            System.out.println("\n\n!!Username or password is incorrect, please enter again!!\n\n");
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
