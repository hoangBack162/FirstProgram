/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diviser;

/**
 *
 * @author QuyLe
 */
public class Diviser {

    /**
     * @param args the command line arguments
     */
    
        int gcd1(int a, int b){
        int c;
        c=a%b;
        if (c==0) return b;
        int x;
        x=gcd1(b,c);
        return x;
    }
        int gcd2(int a, int b){
        int c;
        while (true){
            System.out.println(a+" ,"+b);
            c=a%b;
            if (c==0) return b;
            a=b; b=c;
        }
    }
        int gcd3( int a, int b){
        int c;
        while (true){
            c=a%b;
            if (c==0) return b;
            a = b%c;
            if (a==0) return c;
            b=c%a;
            if (b==0) return a;
        }
    }
        int gcd4 (int a, int b){
        int c;
        while (b>0){
            c=a%b;
            if (c==0) return b;
            a = b%c;
            if(a==0) return c;
            b=c%a;
            //if (b==0) return a;
        }
        return a;
    }
    }

