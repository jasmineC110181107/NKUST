public class prime {
    public static void main(String[] args) {
        int a = 0;
        int k = 0;
        for(int i = 2; i <= 100; i++){
            for(int j = 2; j <= i; j++){
                a = i % j;
                if(a == 0){
                    k = k + 1;
                }
            }
        if(k == 1){
                System.out.println(i);
            }
           k = 0;
        }
    }
}