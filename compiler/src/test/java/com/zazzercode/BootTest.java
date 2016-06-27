package com.zazzercode;

import com.zazzercode.merge.MergeSort;
import com.zazzercode.selection.SelectionSort;
import com.zazzercode.quick.QuickSort;
import com.zazzercode.heap.HeapSort;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class BootTest {

  private static Logger LOGGER = Logger.getLogger("BootTest");

  private int[] numbers;
  private final static int SIZE = 5;
  private final static int MAX  = 20;

  @Before
  public void setUp() throws Exception {
    numbers = new int[SIZE];
    Random generator = new Random();
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = generator.nextInt(MAX);
    }
  }

  @Test
  public void tesHeapSort() {
        final int[] paidAmounts = { 28, 10, 89, 6, 8, 90 };
	HeapSort sorter = new HeapSort();
        LOGGER.info("Before => "  + Arrays.toString(paidAmounts));
        LOGGER.info("After  => "  + Arrays.toString(sorter.sort(paidAmounts)));
  }

//  @Test
  public void testSelectionSort() {
        final int[] paidAmounts = { 28, 10, 89, 6, 8, 90 };
	SelectionSort sorter = new SelectionSort();
        LOGGER.info("Before => "  + Arrays.toString(paidAmounts));
        LOGGER.info("After  => "  + Arrays.toString(sorter.sort(paidAmounts, "ascending")));
  }

  @Test
  public void testMergeSort() {
    long startTime = System.currentTimeMillis();

    LOGGER.info("Before => " + Arrays.toString(numbers));

    MergeSort sorter = new MergeSort();
    sorter.sort(numbers);

    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    LOGGER.info("Mergesort time complexity (ms) => " + elapsedTime);

    LOGGER.info("After => " + Arrays.toString(numbers));

    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] > numbers[i + 1]) {
        fail("Should not happen");
      }
    }
    assertTrue(true);

  }

  //@Test
  public void itWorksRepeatably() {
    for (int i = 0; i < 200; i++) {
      numbers = new int[SIZE];
      Random generator = new Random();
      for (int a = 0; a < numbers.length; a++) {
        numbers[a] = generator.nextInt(MAX);
      }
      MergeSort sorter = new MergeSort();
      sorter.sort(numbers);
      for (int j = 0; j < numbers.length - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          fail("Should not happen");
        }
      }
      assertTrue(true);
    }
  }

  @Test
  public void testQuickSort() {
    long startTime = System.currentTimeMillis();

    LOGGER.info("Before quick sort => " + Arrays.toString(numbers));

    QuickSort sorter = new QuickSort();
    sorter.sort( numbers );

    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    LOGGER.info("Quicksort time complexity (ms) => " + elapsedTime);

    LOGGER.info("After quick sort => " + Arrays.toString(numbers));

    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] > numbers[i + 1]) {
        fail("Should not happen");
      }
    }
    assertTrue(true);

  }

  //@Test
  public void testStandardSort() {
    long startTime = System.currentTimeMillis();
    Arrays.sort(numbers);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    LOGGER.info("Standard Java sort time complexity => " + elapsedTime);

    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] > numbers[i + 1]) {
        fail("Should not happen");
      }
    }
    assertTrue(true);
  }

} 
