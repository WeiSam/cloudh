package io.sam;

import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    static class Ugly{
        public Integer [] result = new Integer[1690];
        public Ugly() {
            PriorityQueue<Long> uglyQueue = new PriorityQueue<>();
            HashSet<Long> set = new HashSet<>();
            uglyQueue.add(1L);
            set.add(1L);
            int[] primes = new int[]{2, 3, 5};

            long currentUgly,newUgly;
            for (int i = 0; i < result.length; i++) {
                currentUgly = uglyQueue.poll();
                Integer a = (int) currentUgly;
                result[i] = (int) currentUgly;
                for (int prime : primes) {
                    newUgly = currentUgly * prime;
                    if (!set.contains(newUgly)) {
                        uglyQueue.add(newUgly);
                        set.add(newUgly);
                    }
                }
            }
        }
    }

    static Ugly ugly = new Ugly();
    public static int nthUglyNumber(int n) {
        return ugly.result[n-1];
    }

    public static void main(String[] args) {
//        Integer a = 268435456;
//        Integer b = 268435456*5;
//        long c = 268435456*5;
//        System.out.println(b+"\n"+c);
        System.out.println(nthUglyNumber(1407));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}