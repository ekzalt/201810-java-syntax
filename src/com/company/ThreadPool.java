package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

// ForkJoinPool

public class ThreadPool {
    // ExecutorService es = new ThreadPoolExecutor();
    // ExecutorService es = Executors.newFixedThreadPool(4);

    public void run() {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> ints = lists.parallelStream()
                .map(list -> list.get(0))
                .collect(Collectors.toList());

        System.out.println(ints); // 1, 4, 7
    }
}
