package com.com.stackoverflow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.*;

public class GetAllTopKeys {

  public static String jsonArray = "{\n" +
          "    \"results\": [{\n" +
          "\n" +
          "            \"geo_position\": {\n" +
          "                \"Field1\": 11,\n" +
          "                \"Filed2\": 12\n" +
          "            },\n" +
          "            \"Field3\": 13,\n" +
          "            \"Filed4\": 14,\n" +
          "            \"Field5\": 15\n" +
          "        },\n" +
          "\n" +
          "        {\n" +
          "            \"geo_position\": {\n" +
          "                \"Field1\": 21,\n" +
          "                \"Filed2\": 22\n" +
          "            },\n" +
          "            \"Field3\": 23,\n" +
          "            \"Filed4\": 24,\n" +
          "            \"Filed5\": 25\n" +
          "        }\n" +
          "    ]\n" +
          "}";

  public static void main(String[] args) {
    JSONObject jsonObj = new JSONObject(jsonArray);
    JSONArray docs = jsonObj.getJSONArray("results");
    File file = new File("D:/fromJSON2.csv");
    String csv = getDocs(docs);
    System.out.println(csv);
    //FileUtils.writeStringToFile(file, csv);
  }

  public static String getDocs(JSONArray ja) throws JSONException {
    String result = "";
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < ja.length(); i++) {
      JSONObject jo = ja.optJSONObject(i);
      if (jo != null) {
        getAllTopKeyAndValue(jo, map);
        if (i == 0) {
          result += keyOfMap2String(map) + "\n";
        }
        result += valueOfMap2String(map) + "\n";
      }
    }
    return result;
  }


  public static void getAllTopKeyAndValue(JSONObject jo, Map<String, Integer> map) {
    if (jo != null) {
      JSONArray names = jo.names();
      String string = "";
      List integers = new ArrayList<>();
      if (names != null) {
        for (int i = 0; i < names.length(); i++) {
          String name = names.getString(i);
          JSONObject object = jo.optJSONObject(name);
          if (object != null) {
            getAllTopKeyAndValue(object, map);
          } else {
            map.put(name, (Integer) jo.get(name));
          }
        }
      }
    }
  }

  public static String keyOfMap2String(Map<String, Integer> map) {
    String result = "";
    Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Integer> entry = iter.next();
      result += entry.getKey();
      if (iter.hasNext()) {
        result += ",";
      }
    }
    return result;
  }

  public static String valueOfMap2String(Map<String, Integer> map) {
    String result = "";
    Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Integer> entry = iter.next();
      result += entry.getValue();
      if (iter.hasNext()) {
        result += ",";
      }
    }
    return result;
  }
}
