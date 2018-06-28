package com.com.stackoverflow;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetNameWithoutPOJOClass {
  /*public static void main(String[] args) {
    String yourJson = "{\n" +
            "  \"fullname\": \"Tùng Dương\",\n" +
            "  \"age\": \"25\",\n" +
            "  \"listsubjects\": [\n" +
            "    {\n" +
            "      \"subjects\": \"Math\",\n" +
            "      \"scores\": \"8.0\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"subjects\": \"English\",\n" +
            "      \"scores\": \"7.0\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"subjects\": \"Physical\",\n" +
            "      \"scores\": \"7.5\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    JSONObject jsonObject = new JSONObject(yourJson);
    System.out.println("Fullname: " + jsonObject.get("fullname"));
    System.out.println("Age: " + jsonObject.get("age"));
    System.out.println("--------");
    JSONArray jSONArray = (JSONArray) jsonObject.get("listsubjects");
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject object = (JSONObject) jSONArray.get(i);
      System.out.println(object.getString("subjects") + " - " + object.getString("scores"));
    }
  }*/

  /*public static void main(String[] args) {
    String yourJson = "[  \n" +
            "  {  \n" +
            "    \"id\":\"0\",\n" +
            "    \"name\":\"Bob\",\n" +
            "    \"place\":\"Colorado\",\n" +
            "  },\n" +
            "  {  \n" +
            "    \"id\":\"1\",\n" +
            "    \"name\":\"John\",\n" +
            "    \"place\":\"Chicago\",\n" +
            "  },\n" +
            "  {  \n" +
            "    \"id\":\"2\",\n" +
            "    \"name\":\"Marry\",\n" +
            "    \"place\":\"Miami\",\n" +
            "  }\n" +
            "]";

    JSONArray jSONArray = new JSONArray(yourJson);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < jSONArray.length(); i++) {
      JSONObject object = (JSONObject) jSONArray.get(i);
      String value = object.getString("name");
      System.out.println(value);
      list.add(value);
    }
  }*/

}
