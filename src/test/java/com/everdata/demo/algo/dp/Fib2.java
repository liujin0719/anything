package com.everdata.demo.algo.dp;

/**
 * Fib2
 * 带备忘录，记录已经执行过的结果，减少重复计算
 *
 * @author liujin
 * @date 2023/9/25
 */
public class Fib2 {

    public static void main(String[] args) {
        System.out.println(fib2(10));
    }

    private static int fib2(int n) {
        int[] memory = new int[n + 1];
        return dp(memory, n);
    }

    private static int dp(int[] memory, int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = dp(memory, n - 1) + dp(memory, n - 2);
//        System.out.println("开始计算节点:" + n);
        return memory[n];
    }

}
