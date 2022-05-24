package com.exam;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        byte n = 4;
        byte m = 6;
        int[] mas1 = new int[n];
        int[] mas2 = new int[m];

        if(mas2.length < mas1.length){
            int[]temp=mas1;
            mas1=mas2;
            mas2=temp;
        }
        fillMas(mas1);
        fillMas(mas2);



        int[] sum = findSumOfArrays(mas1, mas2);
        System.out.println(Arrays.toString(mas1));
        System.out.println(Arrays.toString(mas2));
        System.out.println(Arrays.toString(sum));


    }




    public static int[] findSumOfArrays(int[] first, int[] second) {
        Stack<Integer> stack = new Stack<>();             //LIFO
        Queue<Integer> q = new LinkedList<>();          //FIFO
        int j=first.length-1;
        for (int i = second.length-1; i >= 0; i--) {
            if (j>=0) {
                int toPush = second[i] + first[j]+ (q.isEmpty()?0:q.poll());
                if (toPush >= 10) {
                    stack.push(toPush % 10);
                    toPush = toPush / 10 % 10;
                    q.offer(toPush);
                }
                else {
                    stack.push(toPush);
                }
                j--;
            }
            else {
                stack.push(q.isEmpty()?second[i]:second[i]+q.poll());
            }


        }


        int[] sum = new int[stack.size()];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = stack.pop();
        }
        return sum;
    }


    public static void fillMas(int[] mas) {
        for (byte i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 10);
        }

    }
}
