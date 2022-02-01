import java.util.*;
import java.io.*;

public class CRC{
char divd[] = new char[200];
char cs[] = new char[200];
char div[] = new char[200];
int a, e, c;

void xor(){
for(int i=1; i<17; i++) cs[i] = ((cs[i] == div[i]) ? '0' : '1');
}

void crc(){
for(e=0; e<17; e++) cs[e] = divd[e];
do{ 
if(cs[0] == '1') xor();
for(c=0; c<16; c++) cs[c] = cs[c+1];
cs[c] = divd[e++];
} while(e<= a+16);
}

void operation(){
Scanner sc = new Scanner(System.in);
String msg;

String gs = "10001000000100001";

for(int i=0; i<gs.length(); i++) div[i] = gs.charAt(i);

System.out.println("enter the polynomial");
msg = sc.next();

for(int i=0; i<msg.length(); i++) divd[i] = msg.charAt(i);

System.out.println("generating polynomial is = ");
for(int i=0; i<gs.length(); i++) System.out.print(div[i]);

a = msg.length();

for(e=a; e<a+16; e++) divd[e] = '0';

System.out.println("\nModified Message is = ");
for(int i=0; i<msg.length()+16; i++) System.out.print(divd[i]);

crc();
System.out.println("\nChecksum is: ");
for(int i=0; i<16; i++) System.out.print(cs[i]);

for(e=a; e<a+16; e++) divd[e] = cs[e-a];

System.out.println("\nfinal codeword is: ");
for(int i=0; i<a+16; i++) System.out.print(divd[i]);

System.out.println("\nTest error detection 0(yes) / 1(no):");
e = sc.nextInt();

if(e==0){
System.out.println("\nenter the position where error is to be inserted:");
e = sc.nextInt();

divd[e] = (divd[e] == '0') ? '1':'0';

System.out.println("Errornous data: ");
for(int i=0; i<a+16; i++) System.out.print(divd[i]);
}

crc();

for(e=0; (e<16) && (cs[e]!= '1'); e++);
if(e<16) System.out.println("Error detected");
else System.out.println("no Error detected");
}

public static void main(String[] args){
CRC ob = new CRC();
ob.operation();
}
}
