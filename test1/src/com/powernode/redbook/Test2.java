package com.powernode.redbook;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("hello")
                .thenApply(s -> s + "world")
                .thenApply(s -> s + "bbbb");
        System.out.println(future.get());

        CompletableFuture<String> future1 = future.thenApply(s -> s + "aaa");
        System.out.println(future.get());
        System.out.println(future1.get());

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello!!");
            return "hello!";
        });
        System.out.println(future2.get());
    }
}
