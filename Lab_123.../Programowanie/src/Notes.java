//import java.util.ArrayList;
//import java.util.List;
import  java.util.Arrays;


public class Notes {

    public static int solution(int[] A){
//        List<Integer> sums = new ArrayList<>();
        int [] sums = new int[1];
        int N = A.length;
        int i=0,j=0,sum_id=0;
        int inc;
        if (A.length % 2 ==0){
            inc = 2;
        }
        else {
            inc = 1;
        }
        for(;j<N-1;j++) {
            for (i+=j; i < N - 1; i+=inc) {
                int sum = A[i] + A[i + 1];
//                sums.add(sum);
                sums[sum_id] = sum;
                sums = Arrays.copyOf(sums,sums.length+1);
                sum_id ++;
            }

        }
//        j=0;
//        int max = 1;
//        int count = 1;
//        for(;j<sums.size();j++) {
//            i=0;
//            for (;i<sums.size();i++){
//                if(i != j && sums.toArray()[i] == sums.toArray()[j]){
//                    count ++;
//                }
//            }
//            if (count > max){
//                max = count;
//            }
//            System.out.print(sums.toArray()[j] + " ");
//            System.out.println(count);
//            count = 0;
//
//        }
//        return max;
        j=0;
        int max = 1;
        int count = 1;
        for(;j<sums.length-1;j++) {
            i=0;
            for (;i<sums.length-1;i++){
                if(i != j && sums[i] == sums[j]){
                    count ++;
                }
            }
            if (count > max){
                max = count;
            }
            System.out.print(sums[j] + " ");
            System.out.println(count);
            count = 0;

        }
        return max;
    }

    public static void main(String[] args) {

//        int[] A =  {10,1,3,1,2,2,1,0,4};
//        int[] A =  { 5,3,1,3,2,3};
        int[] A =  {9,9,9,9,9};

        int result = solution(A);
        System.out.println("wynik " + result);

    }

}
