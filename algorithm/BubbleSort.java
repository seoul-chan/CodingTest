package Algorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10,1,30,40,53,22,65,70,90};
        int temp;

        for (int i=0;i<arr.length;i++) {
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }  
        }
        System.out.println(Arrays.toString(arr));
    }
}
