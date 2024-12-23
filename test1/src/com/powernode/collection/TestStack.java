package com.powernode.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: TestStack
 * @Date: 2024/11/17 18:21
 */
public class TestStack {
    @Test
    public void testStack() {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        String pop = stack.pop();
        String peek = stack.peek();

        System.out.println(pop);
        System.out.println(peek);
    }

    @Test
    public void testArrayDeque() {
        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        String pop = stack.pop();
        String peek = stack.peek();

        System.out.println(pop);
        System.out.println(peek);

    }

    @Test
    public void testLinkedList() {
        LinkedList<String> stack = new LinkedList<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        String pop = stack.pop();
        String peek = stack.peek();

        System.out.println(pop);
        System.out.println(peek);

    }


}
