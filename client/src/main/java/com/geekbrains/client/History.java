package com.geekbrains.client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class History {
    

    static void saveHistory(String msg) throws IOException {
        try {
            File history = new File("History.txt");
            if (!history.exists()) {
                history.createNewFile();
            }
            PrintWriter fileWriter = new PrintWriter(new FileWriter(history, true));

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(msg);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String loadHistory() throws IOException {
        int posts = 100;
        File history = new File("History.txt");
        List<String> msgList = new ArrayList<>();
        FileInputStream in = new FileInputStream(history);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            msgList.add(temp);
        }
StringBuilder msg = new StringBuilder();
            for (int i = 0; i < posts; i++) {
              msg.append(msgList.get(i)).append(System.lineSeparator());
            }
        return msg.toString();
    }
    }


