package org.java.designpattern;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {
    public static void main(String[] args) {
        String jsonString ="{\"dept\": {\n" +
                "                              \"id\": \"tech\",\n" +
                "                              \"value\": \"IT\",\n" +
                "                              \"location\": {\n" +
                "                                \"count\":3,\n" +
                "                                \"addresses\": [\n" +
                "                                  {\"state\": \"CA\"},\n" +
                "                                  {\"state\": \"FL\"},\n" +
                "                                  {\"state\": \"OH\"}\n" +
                "                                ]\n" +
                "                              }\n" +
                "                            }}";
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject);
        JSONObject dept = jsonObject.getJSONObject("dept");
        System.out.println("dept is "+dept);
        String id = dept.getString("id");
        System.out.println("id is "+id);
        int count = dept.getJSONObject("location").getInt("count");
        System.out.println("count is "+count);
        JSONArray jsonArray = dept.getJSONObject("location").getJSONArray("addresses");
        System.out.println("addresses is "+jsonArray);
        for(int i = 0; i<jsonArray.length();i++){
            JSONObject address = jsonArray.getJSONObject(i);
            System.out.println("address is "+address);
            String state = address.getString("state");
            System.out.println("state is "+state);
        }
        String secondState = jsonArray.getJSONObject(1).getString("state");
        System.out.println("second state is "+secondState );
    }
}
