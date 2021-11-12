package ru.kpfu.itis.valeev.generators;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

public class AccountDataGenerator {
    public static JSONObject generateJSONArray(int count){
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<count;i++){
            JSONObject jsonObject = new JSONObject()
                    .put("email",  RandomStringUtils.randomAlphanumeric(10))
                    .put("password", RandomStringUtils.randomAlphanumeric(8));
            jsonArray.put(jsonObject);
        }
        JSONObject usersData = new JSONObject();
        usersData.put("accounts", jsonArray);
        return usersData;
    }

    public static void writeToFile(JSONObject jsonObject){
        try {
            FileWriter fw = new FileWriter("src/resources/accounts.json");
            fw.write(jsonObject.toString(4));
            fw.close();
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        System.out.println("Success");
    }

    public static void main(String[] args) {
        writeToFile(generateJSONArray(1));
    }
}
