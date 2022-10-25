package com.algorithm.algorithstudy.cheonjaeseung.programmers.problem_92341;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int[] solution(int[] fees, String[] records) {
    int[] answer;

    Map<String, Integer> timeMap = new HashMap<>();
    Map<String, Integer> parkingMap = new HashMap<>();

    for (int i = 0; i < records.length; i++) {
      String[] record = records[i].split(" ");
      String time = record[0];
      String number = record[1];
      String inOrOut = record[2];

      if (inOrOut.equals("IN")) {
        parkingMap.put(number, getTimeToInteger(time));
        if(!timeMap.containsKey(number)){
          timeMap.put(number, 0);
        }
      } else {
        timeMap.put(number, timeMap.get(number) + getTimeToInteger(time) - parkingMap.get(number));
        parkingMap.remove(number);
      }
    }

    for(String key:parkingMap.keySet()){
      int t= 23*60+59-parkingMap.get(key);
      timeMap.put(key, timeMap.get(key)+ t);
    }

    List<String> carNumberList=new ArrayList<>(timeMap.keySet());
    carNumberList.sort((s1,s2) -> s1.compareTo(s2));
    answer=new int[carNumberList.size()];
    for(int i=0; i<carNumberList.size();i++){

      answer[i]=fees[1];
      int time= timeMap.get(carNumberList.get(i))-fees[0];
      if(time>0)
        answer[i]+=(Math.ceil(time/(fees[2]*1.0))*fees[3]);
    }



    return answer;
  }

  Integer getTimeToInteger(String time) {
    String[] t = time.split(":");
    return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
  }
}
