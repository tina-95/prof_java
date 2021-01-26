package com.geekbrains.server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
     private final DBHelper dbHelper = DBHelper.getInstance();

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return dbHelper.findLoginAndPass(login,password);
    }

    @Override
    public boolean updateNick(String oldNick,String newNick){
        int result = dbHelper.updateNickname(oldNick,newNick);

        return result !=0;
}
}
