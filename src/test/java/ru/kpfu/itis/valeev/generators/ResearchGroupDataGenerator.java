package ru.kpfu.itis.valeev.generators;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

public class ResearchGroupDataGenerator {

    public static JSONObject generateJSONArray(int count){
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<count;i++){
            JSONObject jo1 = new JSONObject()
                    .put("topic",  RandomStringUtils.random(10))
                    .put("description", "Hello my World!")
                    .put("project", new JSONObject().put("key1", "value1"))
                    .put("words", new JSONObject().put("key1", "value1"));
            jsonArray.put(jo1);
        }
        JSONObject researchGroupData = new JSONObject();
        researchGroupData.put("groups", jsonArray);
        return researchGroupData;
    }

    public static void writeToFile(JSONObject jsonObject){
        try {
            FileWriter fw = new FileWriter("/home/pain/Desktop/other_repos/Java/java-autotests/src/resources/groups.json");
            fw.write(jsonObject.toString(4));
            fw.close();
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
        System.out.println("Success");
    }

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.randomAscii(10));
//        writeToFile(generateJSONArray(3));
    }

}
