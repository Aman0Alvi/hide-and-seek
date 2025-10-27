package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class AppTest {

  @Test
  void linearSearch_findsGold_inSortedList() {
    FuzzyListGenerator gen = new FuzzyListGenerator(); 
    ArrayList<Fuzzy> sorted = gen.sortedRainbowFuzzies();

    FuzzyFinder finder = new FuzzyFinder();
    int idx = finder.linearSearch(sorted);

    assertTrue(idx >= 0, "Linear search should find gold in sorted list");
    assertEquals("gold", sorted.get(idx).color);
  }

  @Test
  void binarySearch_findsGold_inSortedList() {
    FuzzyListGenerator gen = new FuzzyListGenerator();
    ArrayList<Fuzzy> sorted = gen.sortedRainbowFuzzies();

    FuzzyFinder finder = new FuzzyFinder();
    int idx = finder.binarySearch(sorted);

    assertTrue(idx >= 0, "Binary search should find gold in sorted list");
    assertEquals("gold", sorted.get(idx).color);
  }

  @Test
  void linearSearch_findsGold_inRandomList() {
    FuzzyListGenerator gen = new FuzzyListGenerator();
    ArrayList<Fuzzy> random = gen.randomizedRainbowFuzzies();

    FuzzyFinder finder = new FuzzyFinder();
    int idx = finder.linearSearch(random);

    assertTrue(idx >= 0, "Linear search should find gold in random list");
    assertEquals("gold", random.get(idx).color);
  }

  @Test
  void binarySearch_onRandomList_isNotReliable_butSafe() {
    FuzzyListGenerator gen = new FuzzyListGenerator();
    ArrayList<Fuzzy> random = gen.randomizedRainbowFuzzies();

    FuzzyFinder finder = new FuzzyFinder();
    int idx = finder.binarySearch(random);

    if (idx >= 0) {
      assertEquals("gold", random.get(idx).color, "If binarySearch returns an index on a random list, it must point to gold.");
    } else {
      assertEquals(-1, idx, "On an unsorted list, binary search is allowed to fail.");
    }
  }
}
