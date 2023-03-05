package crimson.store.backend.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class EvenOdd {
    public static void main(String[] args) {
        Integer a[]={8,1,0,5,2,6,1,0,7,8};
        int index =0;
        int newArr[] = new int[15];

        Collections.sort(Arrays.asList(a), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i=0;i<a.length;i++){
            if(a[i]%2!=0){
                System.out.print(a[i]+",");
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
                System.out.print(a[i]+", ");
            }
        }

    }
}
