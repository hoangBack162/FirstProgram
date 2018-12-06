/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diviser;

/**
 *
 * @author Quyle
 */
public class GCDTest {
    public static void main (String[]ags){
        Diviser d = new Diviser();
        System.out.println(d.gcd1(18, 12));
        System.out.println(d.gcd2(18, 12));
        
        System.out.println(d.gcd2(11, 9));
        System.out.println(d.gcd2(132, 121));
        System.out.println(d.gcd2(132, 49));
        System.out.println(d.gcd2(76, 36));
    
        System.out.println(gcdd(132, 49));
    }

    static int gcdd(int a, int b) {
        int c,d,e,f,g,h;
        c=a%b;  System.err.print("1>");
        if (c==0) return b;
        d=b%c;  System.err.print("2>");
        if (d==0) return c;
        e=c%d;  System.err.print("3>");
        if (e==0) return d;
        f=d%e;  System.err.print("4>");
        if (f==0) return e;
        g=e%f;  System.err.print("5>");
        if (g==0) return f;
        h=f%g;  System.err.print("6>");
        if (h==0) return g;
        e=c%d;  System.err.print("わからない");
        return 1;
    }
    
}
