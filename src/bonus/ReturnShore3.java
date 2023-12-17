package bonus;

import java.util.*;

public class ReturnShore3 {

    public class data{
        int pos;
        long val;

        public data(int pos, long val) {
            this.pos = pos;
            this.val = val;
        }
    }
    public class MyComparator implements Comparator<data> {

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@code sgn(compare(x, y)) ==
         * -sgn(compare(y, x))} for all {@code x} and {@code y}.  (This
         * implies that {@code compare(x, y)} must throw an exception if and only
         * if {@code compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x, y)==0}
         * implies that {@code sgn(compare(x, z))==sgn(compare(y, z))} for all
         * {@code z}.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."<p>
         * <p>
         * In the foregoing description, the notation
         * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(data o1, data o2) {
            return (int)(o1.val-o2.val);
        }
    }

    PriorityQueue<data> arr = new PriorityQueue<>(new MyComparator());
    public void solution() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n - 1; i++) {
            long j = input.nextLong();
            if (j == 1) {
                long q = input.nextLong();
                arr.add(new data(i+1,q));
            } else {
                long k = input.nextLong();
                while (arr.size() >= k) {
                    arr.poll();
                }
            }
        }
        int a = input.nextInt();
        int b = input.nextInt();
        if(arr.size()<b){
            System.out.println(-1);
        }
        else{
            long sum = 0;
            for(data i: arr){
                sum+=i.val;
            }
            System.out.println(sum);
            List<Integer> myList = new ArrayList<>();
            for(data i:arr){

                myList.add(i.pos);
            }
            Collections.sort(myList);
            for(int i: myList){
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args){
        ReturnShore3 tmp = new ReturnShore3();
        tmp.solution();
    }
}
