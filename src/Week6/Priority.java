package Week6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Priority {

    PriorityQueue<Student> tmp = new PriorityQueue<>(Comparator.reverseOrder());
    private class Student implements Comparable{
        int id;
        String name;
        double cgpa;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure {@link Integer#signum
         * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * x.compareTo(y)} must throw an exception if and only if {@code
         * y.compareTo(x)} throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
         * {@code x.compareTo(z) > 0}.
         *
         * <p>Finally, the implementor must ensure that {@code
         * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
         * == signum(y.compareTo(z))}, for all {@code z}.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         * @apiNote It is strongly recommended, but <i>not</i> strictly required that
         * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
         * class that implements the {@code Comparable} interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         */
        @Override
        public int compareTo(Object o) {
            Student s = (Student) o;
            if(this.getCgpa()!=s.getCgpa()){
                return (this.getCgpa()<s.getCgpa())? -1:1;
            }
            if(!this.getName().equals(s.getName())){
                return -(this.getName().compareTo(s.getName()));
            }
            return this.getId() - s.getId();
        }
    }
    public void solve(){
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        for(int i = 0; i < q; i++){
            String type = input.next();
            if(type.equals("ENTER")){
                String name = input.next();
                double cgpa = input.nextDouble();
                int id = input.nextInt();
                Student s= new Student(id,name,cgpa);
                tmp.add(s);
            }
            else{
                tmp.poll();
            }
        }
        if(tmp.isEmpty()){
            System.out.println("EMPTY");
            return;
        }
        while(!tmp.isEmpty()){
            System.out.println(tmp.poll().getName());
        }
    }
    public static void main(String[] args){
        Priority tmp = new Priority();
        tmp.solve();
    }
}
