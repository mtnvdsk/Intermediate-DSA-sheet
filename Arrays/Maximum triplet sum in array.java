  
// Java code to find maximum triplet sum
import java.io.*;
import java.util.*;
 
 
class Solution {
    static int maxTripletSum(int arr[], int n)
    {
        Arrays.sort(arr);
        return arr[n - 1] + arr[n - 2] + arr[n - 3];
    } 
    public static void main(String args[])
    {
        int arr[] = { 1, 0, 8, 6, 4, 2 };
        int n = arr.length;
        System.out.println(maxTripletSum(arr, n));
    }
}


//solution2
class Solution {
    static int maxTripletSum(int arr[], int n)
    {
        int maxA = -100000000, maxB = -100000000;
        int maxC = -100000000;
     
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxA) 
            {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            }
            else if (arr[i] > maxB) 
            {
                maxC = maxB;
                maxB = arr[i];
            }
            else if (arr[i] > maxC)
                maxC = arr[i];
        }
     
        return (maxA + maxB + maxC);
    }
    public static void main(String args[])
    {
        int arr[] = { 1, 0, 8, 6, 4, 2 };
        int n = arr.length;
        System.out.println(maxTripletSum(arr, n));
    }
}