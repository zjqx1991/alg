package com.raven.alg.s4stack;

import java.util.List;
import java.util.Scanner;

public class StackDemo {

    public static void main(String[] args) {
        // "(123+456)*567-6678"
        List<String> list = PolandNotation.parsePoland("(3+4)*5-6");
        System.out.println("args = " + list.toString());
        Integer res = PolandNotation.calculatorPoland(list);
        System.out.println("args = " + res);

//        stackLinkedTest();
    }


    /**
     * 链表构成的栈
     */
    public static void stackLinkedTest() {
        StackLinked stack = new StackLinked();
        Scanner scanner = new Scanner(System.in);
        Boolean loop = true;
        while (loop) {
            System.out.println("输入 push 入栈");
            System.out.println("输入 pop 出栈");
            System.out.println("输入 list 打印栈");
            System.out.println("输入 exit 退出控制台");
            String next = scanner.next();
            switch (next) {
                case "push": {
                    System.out.println("请输入入栈数据");
                    stack.push(Integer.parseInt(scanner.next()));
                }
                break;
                case "pop": {
                    System.out.println("出栈数据：" + stack.pop());
                }
                break;
                case "list": {
                    stack.list();
                }
                break;
                case "exit": {
                    scanner.close();
                    loop = false;
                }
                break;
                default:
                    break;
            }
        }

    }


    /**
     * 数组构成的栈
     */
    public static void stackArrayTest() {
        StackArray stack = new StackArray(6);
        Scanner scanner = new Scanner(System.in);
        Boolean loop = true;
        while (loop) {
            System.out.println("输入 push 入栈");
            System.out.println("输入 pop 出栈");
            System.out.println("输入 list 打印栈");
            System.out.println("输入 exit 退出控制台");
            String next = scanner.next();
            switch (next) {
                case "push": {
                    System.out.println("请输入入栈数据");
                    stack.push(Integer.parseInt(scanner.next()));
                }
                break;
                case "pop": {
                    System.out.println("出栈数据：" + stack.pop());
                }
                break;
                case "list": {
                    stack.list();
                }
                break;
                case "exit": {
                    scanner.close();
                    loop = false;
                }
                break;
                default:
                    break;
            }
        }

    }

}
