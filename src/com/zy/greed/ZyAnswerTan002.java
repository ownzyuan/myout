package com.zy.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ZyAnswerTan002 {
    public static void main(String[] args) {
//        onlyOneData();
        manyData();
    }

    /**
     * 只有单个数据的输入输出
     */
    private static void onlyOneData() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] nums = new int[t];
        for (int i = 0; i < t; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(test01(nums));
    }

    private static int test01(int[] nums) {
        int aA, bB, pP, qQ, pqResult;
        aA = nums[0];
        bB = nums[1];
        pP = nums[2];
        qQ = nums[3];
        int result = 0;
        while (aA < bB) {
            pqResult = pP * qQ;
            if ((aA + pqResult) > bB) {
                aA += pP;
                result++;
                break;
            }
            if (pP < pqResult) {
                pP = pqResult;
                result++;
            }
        }
        return result;
    }

    /**
     * 有多个数据行输入时
     */
    private static void manyData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            while (((str = bufferedReader.readLine()) != null)) {
                String[] datas = str.split(" ");
                int result = test02(datas);
                if (result < 0) {
                    System.out.println("不存在");
                } else {
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int test02(String[] datas) {
        int aA = Integer.parseInt(datas[0]);
        int bB = Integer.parseInt(datas[1]);
        int pP = Integer.parseInt(datas[2]);
        int qQ = Integer.parseInt(datas[3]);
        int pqResult, result = 0;
        while (aA < bB) {
            pqResult = pP * qQ;
            if ((aA + pqResult) > bB) {
                aA += pP;
                result++;
                break;
            }
            if (pP < pqResult) {
                pP = pqResult;
                result++;
            } else {
                return -1;
            }
        }
        return result;
    }

}
