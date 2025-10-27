package org.example;

import java.util.ArrayList;

public class FuzzyFinder {
  public static final String TARGET_COLOR = "gold";

  public int linearSearch(ArrayList<Fuzzy> list) {
    if (list == null) return -1;
    for (int i = 0; i < list.size(); i++) {
      Fuzzy f = list.get(i);
      if (f != null && TARGET_COLOR.equals(f.color)) {
        return i;
      }
    }
    return -1;
  }

  public int binarySearch(ArrayList<Fuzzy> sortedList) {
    if (sortedList == null || sortedList.isEmpty()) return -1;

    int lo = 0, hi = sortedList.size() - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo)/2;
      Fuzzy midF = sortedList.get(mid);
      String c = (midF == null) ? null : midF.color;

      if (c == null) { 
        lo = mid + 1;
        continue;
      }
      int cmp = c.compareTo(TARGET_COLOR);
      if (cmp == 0) 
        return mid;
      if (cmp < 0)  
        lo = mid + 1;
      else          
        hi = mid - 1;
    }
    return -1;
  }
}