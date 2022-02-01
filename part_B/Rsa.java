import java.util.*;
import java.io.*;
public class Rsa{
public static int mul(int x, int y, int n){
int k=1 , j;
for(j=1; j<=y; j++) k = (k*x) % n;
return k;
}

public static void main(String[] args){
String msg;
int pt[] = new int[100];
int ct[] = new int[100];
int p, q, n, e, d, i;
Scanner sc = new Scanner(System.in);
System.out.println("Enter the message to encrypt " );
msg = sc.next();
for(i=0; i<msg.length(); i++) pt[i] = msg.charAt(i);
n = 253 ; e = 13 ; d = 17;
System.out.println("Cipher Text is : ");
for(i=0; i<msg.length(); i++) {
ct[i] = mul(pt[i], e, n);
System.out.println(" " + ct[i]); 
pt[i] = mul(ct[i], d, n); 
}
System.out.println("Decrypted msg ");
for(i=0; i<msg.length(); i++) System.out.println(" "+(char) pt[i]);
}
}
