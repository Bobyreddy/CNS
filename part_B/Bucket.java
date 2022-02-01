import java.util.*;

public class Bucket{
public static void solution(int pktsize, int op){
int bktsize = 512;
if(pktsize > bktsize){
System.out.println("Bucket overflow!!");
} else {
while(pktsize > op){
System.out.println(op + " Bytes output");
pktsize -= op;
}
if(pktsize > 0){
System.out.println(pktsize + " Bucket Output");
}
}
}

public static void main(String [] args){
int pktsize, op, n;
Scanner sc = new Scanner(System.in);
Random rand = new Random();
System.out.println("Enter the output rate : ");
op = sc.nextInt();
System.out.println("Enter the no. of pkts: ");
n = sc.nextInt();
for(int i=0; i<n; i++){
pktsize = rand.nextInt(1000);
System.out.println("pkt no. " + (i+1)+ " pkt size " + pktsize);
solution(pktsize, op);
} 
} 
}
