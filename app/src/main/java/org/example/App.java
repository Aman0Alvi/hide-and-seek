package org.example;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    FuzzyListGenerator generator = new FuzzyListGenerator(); // lots of fuzziess
    FuzzyFinder finder = new FuzzyFinder();

    ArrayList<Fuzzy> sorted = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> random = generator.randomizedRainbowFuzzies();

    int testOne = finder.linearSearch(sorted);
    int testTwo = finder.binarySearch(sorted);
    int testThree = finder.linearSearch(random);
    int testFour = finder.binarySearch(random);

    System.out.println("linear(sorted): " + testOne);
    System.out.println("binary(sorted): " + testTwo);
    System.out.println("linear(random): " + testThree);
    System.out.println("binary(random): " + testFour + " (may be -1 or wrong)");
  }
}
