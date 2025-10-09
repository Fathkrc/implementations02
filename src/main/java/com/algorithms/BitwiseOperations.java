package com.algorithms;

public class BitwiseOperations {

    public static void main(String[] args) {
        System.out.println(isEven(4)); //true
        System.out.println(isEven(5)); // false

        System.out.println(mod4(23)); // 3
        System.out.println(mod8(23)); // 7
    }
//     (n & 1) == 0; even
//     mod2 = n & 1;         // % 2^1    001
//     mod4 = n & 3;         // % 2^2    011
//     mod8 = n & 7;         // % 2^3    111


    static boolean isEven(int i){
        return (i & 1) == 0;
    }

    static int mod4(int i){
        return (i & 3) ;
    }
    static int mod8(int i){
        return (i & 7) ;
    }
}
