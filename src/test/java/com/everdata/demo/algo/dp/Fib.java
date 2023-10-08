package com.everdata.demo.algo.dp;

/**
 * Fib
 *
 * @author liujin
 * @date 2023/9/25
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        System.out.println("开始计算节点:" + n);
        return fib(n - 1) + fib(n - 2);
    }
}
