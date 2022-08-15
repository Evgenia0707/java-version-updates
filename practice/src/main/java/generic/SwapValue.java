package generic;

import java.util.Arrays;

public class SwapValue {

    public static void main(String[] args) {

        Integer[] a = {1,2,3,4};

        swap(a,0,2);

        System.out.println(Arrays.toString(a));//[3, 2, 1, 4]

    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
/*
Write a generic method to exchange the positions of two different elements in
array.
Integer[] a = {1,2,3,4};
swap(a,0,2);
System.out.println(Arrays.toString(a)); //[3,2,1,4]
Sample output:
 */
