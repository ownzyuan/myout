package com.zy.leet.top001两数之和Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VarietyQuestion001 {
    /**
     * 题目描述：
     *
     * 设计一个两数之和的数据结构，
     * 要求可以通过一个目标值 target，在该数组中找出和为目标值的那两个整数，并返回他们的数组下标，
     * 你可以假设只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 2，7
     */

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 8, 11, 15};
        int target = 9;
        TowSum towSum = new TowSum();
        for (int i = 0; i < nums.length; i++) {
            towSum.addNumber(nums[i]);
        }
        String result = towSum.find(target);
        System.out.println(result);
    }

}

class TowSum {

    // 存储元素使用的集合
    private List<Integer> storageList;

    // 查询元素使用的map
    private Map<Integer, Integer> findMap;

    TowSum() {
        storageList = new ArrayList<>();
        findMap = new HashMap<>();
    }

    public void addNumber(Integer number) {
        storageList.add(number);
    }

    public String find(int target) {
        return find(this.storageList, target);
    }

    private String find(List<Integer> storageList, int target) {
        for (int i = 0; i < storageList.size(); i++) {
            int num = storageList.get(i);
            if (findMap.containsKey(num)) {
                Integer left = findMap.get(num);
                return "[" + left + "," + i + "]";
            } else {
                findMap.put(target - num, i);
            }
        }
        return "没有满足条件的";
    }
}
