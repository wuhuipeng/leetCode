package cn.hereyou.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, permutation, used, results);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, permutation, used, results);
            used[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations perm = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = perm.permute(nums);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
