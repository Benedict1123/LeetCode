import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Counting Triangles
 * Given a list of N triangles with integer side lengths, determine how many different triangles there are. Two triangles are considered to be the same if they can both be placed on the plane such that their vertices occupy exactly the same three points.
 * Signature
 * int countDistinctTriangles(ArrayList<Sides> arr)
 * or
 * int countDistinctTrianges(int[][] arr)
 * Input
 * In some languages, arr is an Nx3 array where arr[i] is a length-3 array that contains the side lengths of the ith triangle. In other languages, arr is a list of structs/objects that each represent a single triangle with side lengths a, b, and c.
 * It's guaranteed that all triplets of side lengths represent real triangles.
 * All side lengths are in the range [1, 1,000,000,000]
 * 1 <= N <= 1,000,000
 * Output
 * Return the number of distinct triangles in the list.
 * Example 1
 * arr = [[2, 2, 3], [3, 2, 2], [2, 5, 6]]
 * output = 2
 * The first two triangles are the same, so there are only 2 distinct triangles.
 * Example 2
 * arr = [[8, 4, 6], [100, 101, 102], [84, 93, 173]]
 * output = 3
 * All of these triangles are distinct.
 * Example 3
 * arr = [[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]
 * output = 1
 * All of these triangles are the same.
 *
 * */
public class SortingTriangle {
    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        Sides sortSide(){
            int a = this.a;
            int b = this.b;
            int c = this.c;
            int[] sortedArray = new int[]{a,b,c};
            Arrays.sort(sortedArray);
            Sides newObj = new Sides(sortedArray[0],sortedArray[1],sortedArray[2]);
            return newObj;
        }
    }

    static int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        Set<Integer> firstSide = new HashSet<>();
        Set<Integer> secondSide = new HashSet<>();
        Set<Integer> thirdSide = new HashSet<>();
        for(Sides eachEle: arr){
            eachEle = eachEle.sortSide();
            firstSide.add(eachEle.a);
            secondSide.add(eachEle.b);
            thirdSide.add(eachEle.c);
        }
        int[] sortedCount = new int[]{firstSide.size(),secondSide.size(),thirdSide.size()};
        Arrays.sort(sortedCount);
        return sortedCount[2];
    }


    public static void main(String[]args){
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        int output = countDistinctTriangles(arr_1);
        System.out.println(output);
    }

}
