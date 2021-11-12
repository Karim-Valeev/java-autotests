package ru.kpfu.itis.valeev.generators;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResearchGroupDataGenerator {

    public static JSONObject generateJSONArray(int count) throws InterruptedException {
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<count;i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic",  RandomStringUtils.randomAlphanumeric(10));
            jsonObject.put("description", RandomStringUtils.randomAlphanumeric(30));
//            Эти поля могут быть только в единственном виде, тк в БД сайта просто нет других значений :)
            jsonObject.put("project", "Без проекта");
            jsonObject.put("words", "name");
            jsonArray.put(jsonObject);
        }
        JSONObject researchGroupsData = new JSONObject();
        researchGroupsData.put("groups", jsonArray);
        return researchGroupsData;
    }

    public static void writeToFile(JSONObject jsonObject){
        try {
            FileWriter fw = new FileWriter("/src/resources/groups.json");
            fw.write(jsonObject.toString(4));
            fw.close();
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        System.out.println("Success");
    }

    public static void main(String[] args) throws InterruptedException {
        writeToFile(generateJSONArray(1));
    }

}
