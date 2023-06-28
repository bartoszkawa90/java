public class Notes {

    public int solution(int N) {
        int Nsum = 0, sum = 0, count = 2;

        while(true){
            for(String s : Integer.toString(N).split("")){
                Nsum += Integer.parseInt(s);
            }
            System.out.println("Nsum " + Nsum);
            for(String s : Integer.toString(count).split("")){
                sum += Integer.parseInt(s);
            }
            System.out.println("sum " + sum);
            if( count > N && sum == 2*Nsum){
                break;
            }
            System.out.println("count " + count);
            count ++;
            Nsum = 0;
            sum = 0;
        }
        return count;
    }
    public static void main(String[] args) {

        Notes notes = new Notes();
        System.out.println(notes.solution(2));
    }

}
