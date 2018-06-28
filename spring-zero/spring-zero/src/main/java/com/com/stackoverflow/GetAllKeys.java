package com.com.stackoverflow;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;
import java.util.Set;

public class GetAllKeys {
  public static void main(String[] args){
    String yourJson = "{\n" +
            "  \"The Object I already know\": {\n" +
            "    \"key1\": \"value1\",\n" +
            "    \"key2\": \"value2\",\n" +
            "    \"AnotherObject\": {\n" +
            "      \"anotherKey1\": \"anotherValue1\",\n" +
            "      \"anotherKey2\": \"anotherValue2\"\n" +
            "    }\n" +
            "  }\n" +
            "}";
    JsonParser parser = new JsonParser();
    JsonElement element = parser.parse(yourJson);
    JsonObject obj = element.getAsJsonObject(); //since you know it's a JsonObject
    Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
    for (Map.Entry<String, JsonElement> entry: entries) {
      JsonObject obj2 = obj.getAsJsonObject(entry.getKey());
      Set<Map.Entry<String, JsonElement>> entries2 = obj.entrySet();
      for (Map.Entry<String, JsonElement> entry2: entries2){
        System.out.println(entry2.getKey());
      }
      //System.out.println(entry.getKey());
    }
  }
}
