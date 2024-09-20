public class BitManipulation {

    //Check odd or even
    public static void oddOReven(int n) {
        int bitmask = 1;
        if((n & bitmask)==0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }

    // Get ith bit
    public static void getithBit(int n, int i) {
        int bitmask = 1<<i;
        if ((n & bitmask) == 0) System.out.println("0");
        else System.out.println("1");
    }
    //Set ith Bit
    public static void setithBit(int n, int i) {
        int bitmask = 1<<i;

        System.out.println(n | bitmask);
    }

    // Clear ith Bit
    public static void clearithBit(int n, int i) {
        int bitmask = ~(1<<i);
        System.out.println(n & bitmask);
    }

    // Update Bit
    public static void updateithBit(int n, int i, int newbit) {

        if (newbit == 0) clearithBit(n,i);
        else setithBit(n,i);

//        n = clearithBit(n,i);
//        int bitmask = newbit<<i;
//        return (n | bitmask)
    }
    // Clear last ith bit
    public static void clearLastithBit(int n, int i) {
        int bitmask = (-1)<<i;
        System.out.println(n & bitmask);
    }

    //clear a range of bit
    public static void cleariRangeBit(int n, int i, int j) {
        int a = (-1)<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a|b;
        System.out.println(n & bitmask);
    }

    // check number is power of 2 or not
    public static boolean checkpowerof2 (int n) {
        return (n&(n-1)) == 0;
    }

    // count setbits
    public static void countsetbits (int n) {
        int count = 0;
        while(n>0) {
            if((n & 1) != 0 ) count++;
            n=n>>1;
        }
        System.out.println(count);
    }

    //Fast Exponentiation
    public static void fastExpo(int a, int n) {
        int ans = 1;
        while(n>0){
            if ((n & 1) != 0) { //check LSB
                ans = ans * a;
            }
            a = a*a;
            n = n >> 1;
        }
        System.out.println(ans);
    }

    // Swap without extra space
    public static void swap(int x,int y) {
        System.out.println("Before x,y =" + x + ","+ y);
        x = x^y;
        y = x^y;
        x = x^y;
        System.out.println("After x,y =" + x + ","+ y);

    }

    //Add one to any num using bit
    public static void add1(int x) {
        // -x = ~x + 1   //negative nums are stored in 2's complement
        // -~x = x + 1   (replace x with ~x)

        System.out.println(x + "+" + 1 + "=" + -~x);
    }
    public static void main(String[] args) {
//        System.out.println(5&6); //4
//        System.out.println(5|6); //7
//        System.out.println(5^6); //3
//
//        System.out.println(~5);  //-6 => (5 -- 00000101)-----(~5 -- 11111010) (MSB -- 1 negative num) (2's complement of 11111010 -- 00000101 -- 00000110 == 6 ==> (-6) //
//
//        System.out.println(5<<2); //20 (a<<b) ==> a*2^b
//        System.out.println(6>>1); //3  (a>>b) ==> a/2^b
//
//        oddOReven(3);

//        getithBit(10,2);
//        setithBit(10,2);
//        clearithBit(10,1);
//        updateithBit(10,3,0);
//        clearLastithBit(15,2);
//        cleariRangeBit(10,2,4);

//        checkpowerof2(15);
//        countsetbits(10);
//        countsetbits(15);

//        fastExpo(5,3);
//        fastExpo(3,5);

//        swap(3,4);

        add1(6);
        add1(-4);
    }
}
