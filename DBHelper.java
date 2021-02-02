package com.geekbrains.server;

import java.sql.*;

public class DBHelper implements AutoCloseable {
    private static DBHelper instance;
    private static Connection connection;

    private static PreparedStatement findLoginAndPass;
    private static PreparedStatement changeNick;

    public static DBHelper getInstance() throws SQLException {
        if (instance == null){
            loadDriverAndOpenConnection();
            createPreparedStatements();

            instance = new DBHelper();
        }

        return instance;
    }

    private static void createPreparedStatements() throws SQLException {
        findLoginAndPass = connection.prepareStatement("SELECT * FROM participant WHERE LOWER(login)=LOWER(?) AND password=?");
        try {
            changeNick = connection.prepareStatement("UPDATE participant SET nickname=? WHERE nickname=?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void loadDriverAndOpenConnection() {
        try {
            Class.forName("org.sqLite.JDBC");
            connection = DriverManager.getConnection("jdbc^sqLite:chat.db");
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения с базой");
        }
    }

    public String findLoginAndPass(String login, String pass){
        ResultSet resultSet = null;
        try {
            findLoginAndPass.setString(1, login);
            findLoginAndPass.setString(2, pass);

            resultSet = findLoginAndPass.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("nickname");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            close(resultSet);
        }
        return null;
    }

    private void close(ResultSet resultSet) {
        if (resultSet!=null){
            try{
                resultSet.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public int updateNickname(String oldNick, String newNick){
        try{
            changeNick.setString(1,newNick);
            changeNick.setString(2,oldNick);
            return changeNick.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void close()  {
        try{
            findLoginAndPass.close();
            changeNick.close();
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}