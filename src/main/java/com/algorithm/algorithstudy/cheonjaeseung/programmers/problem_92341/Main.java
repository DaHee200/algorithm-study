package com.algorithm.algorithstudy.cheonjaeseung.programmers.problem_92341;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    int[] fees = {180, 5000, 10, 600};
    String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
    int[] answer = new Solution().solution(fees, records);
    System.out.println(Arrays.toString(answer));
  }
}
