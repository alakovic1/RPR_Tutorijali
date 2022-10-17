package ba.unsa.etf.rpr.tutorijal1;

import java.util.Scanner;

public class Main {

    public static int sumaCifara(int n){
        int suma=0;
        while(n!=0){
            suma+=n%10;
            n/=10;
        }
        return suma;
    };

    public static void main(String[] args) {
        System.out.println("Unesite n: ");
        Scanner ulaz=new Scanner(System.in);
        int n=ulaz.nextInt();
        int i=0;
        for(i=1;i<=n;i++){
            if(i%sumaCifara(i)==0) System.out.println(i);
        }
    }
}
