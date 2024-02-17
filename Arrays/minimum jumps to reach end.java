import java.io.*; 
import java.util.*; 

//recursion
class Solution {
	static int minJumps(int arr[], int l, int h) 
	{ 
		if (h == l) 
			return 0; 
		if (arr[l] == 0) 
			return Integer.MAX_VALUE; 
		int min = Integer.MAX_VALUE; 
		for (int i = l + 1; i <= h && i <= l + arr[l]; 
			i++) { 
			int jumps = minJumps(arr, i, h); 
			if (jumps != Integer.MAX_VALUE 
				&& jumps + 1 < min) 
				min = jumps + 1; 
		} 
		return min; 
	} 
} 


import java.util.Arrays; 
  
public class Solution { 
    private static int jump(int[] nums, int idx, int end, int[] memo) { 
        if (idx == end) 
            return 0; 
  
        if (memo[idx] != -1) 
            return memo[idx]; 
  
        int min_jumps = Integer.MAX_VALUE - 1; 
        for (int j = nums[idx]; j >= 1; --j) { 
            if (idx + j <= end) { 
                min_jumps = Math.min(min_jumps, 1 + jump(nums, idx + j, end, memo)); 
            } 
        } 
  
        return memo[idx] = min_jumps; 
    } 
}

