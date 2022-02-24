import java.util.*;

/**
 * merge sorted arrays:
 *
 *[1,3,4,7] and [3,5,6,8]       [1,5,10,30]   [3,7,8,9,11]
 *
 * merge two input arrays, and keep the Unique elements in a new sorted array;
 *
 * */

public class MergeSortedArray {

//    public static ArrayList<Integer> mergeArraySolution1(int[] arr1, int[] arr2){
////        int[] output = new int[arr1.length+arr2.length];
//        Set<Integer> numberSet = new HashSet<>();
//        for(int i = 0; i<arr1.length;i++){
//            numberSet.add(arr1[i]);
//        }
//        for(int j = 0; j<arr2.length;j++){
//            numberSet.add(arr2[j]);
//        }
//        Iterator<Integer> it = numberSet.iterator();
//        // Iterate HashSet with the help of hasNext() and
//        // next() method
//        ArrayList<Integer> output = new ArrayList<>();
//        for(Integer set: numberSet){
//            output.add(set);
//        }
//        Collections.sort(output);
//        return output;
//    }


    /**
     * [1,5,10,30]   [3,7,8,9,11]
     * */
    public static ArrayList<Integer> mergeArraySolution2(int[] arr1, int[] arr2){
//        int[] output = new int[arr1.length+arr2.length];
        ArrayList<Integer> output = new ArrayList<>();
        int length1 = arr1.length;
        int length2 = arr2.length;
        int greaterLength;

        if (length1>=length2){
            greaterLength = length1;
        }else {
            greaterLength = length2;
        }

        for(int i= 0; i<greaterLength;i++){
            int currentLast;
            if(output.size() == 0){
                currentLast = 0;
            }else {
                currentLast = output.get(output.size()-1); // last element in the target list
            }

            if(i>length1-1){   // array1 out of boundary  [1,99], [2,5,7,10]
                if(currentLast > arr2[i]){ //compare the current last with the arr2[i]
                    output.remove(output.size()-1);
                    output.add(arr2[i]);
                    output.add(currentLast);
                }else if(currentLast < arr2[i]){
                    output.add(arr2[i]);
                }
            }else if(i>length2-1){
                if(currentLast > arr1[i]){ //compare the current last with the arr2[i]
                    output.remove(output.size()-1);
                    output.add(arr1[i]);
                    output.add(currentLast);
                }else if(currentLast < arr1[i]){
                    output.add(arr1[i]);
                }
            }else{//both arrays are fine with the index
                // currentlast, arr1[i], arr2[i] which one is bigger
                if(arr1[i]>arr2[i]){ //if arr1[i] is bigger
                    if(arr1[i] > currentLast){
                        if(currentLast > arr2[i]){ // the smaller array2[1] is greater than the current Last element
                            output.remove(output.size()-1);
                            output.add(arr2[i]);
                            output.add(currentLast);
                        }else if(currentLast < arr2[i]){
                            output.add(arr2[i]);
                        }
                        output.add(arr1[i]);
                    }else if(arr1[i] == currentLast){ //arr1[i] == currentLast, so just add arr2[i]
                        System.out.println("Condition 2 MET!!!!!");
                        output.add(arr2[i]);
                    }
                }else if(arr1[i] < arr2[i]){// if arr2[i] is bigger
                    if(arr2[i] > currentLast){ // currentLast is from array 1 previously
                        if(currentLast > arr1[i]){ // the smaller one arr1[i] is smaller than the last element in the output
                            output.remove(output.size()-1);
                            output.add(arr1[i]);
                            output.add(currentLast);
                        }else if(currentLast < arr1[i]){
                            output.add(arr1[i]);  // array1[i] is smaller for sure
                        }
                        output.add(arr2[i]);
                    }else if (arr2[i]==currentLast){ //arr2[i] == currentLast, so just add arr1[i]
                        System.out.println("Condition 4 MET!!!!!");
                        output.add(arr1[i]);
                    }
                }else {
                    if(currentLast!=arr1[i]){
                        output.add(arr1[i]); // add element in array1 directly, cuz they're the same
                    }
                }
            }
        }
        return output;
    }


    public static void main(String[] args){
//        int[] array1 = new int[]{1,3,4,7};
//        int[] array2 = new int[]{3,5,6,8};
//        int[] array1 = new int[]{1,5,10,30}; //[1,5,10,30]   [3,7,8,9,11]
//        int[] array2 = new int[]{3,7,8,9,11};

        //[1,99], [2,5,7,10]
        int[] array1 = new int[]{1,5,10,11,13,14,15,99};
        int[] array2 = new int[]{2,5,7,13,15,17};
        ArrayList<Integer> result = mergeArraySolution2(array1, array2);
        System.out.println(result);

    }
}
