
import java.util.Scanner;
public class Main{
    public static void main(String[]a){
        Scanner sc=new Scanner(System.in);

        int suma =0;

        System.out.print("Ingrese el ultimo numero hasta el cual se realizara la suma");
        int Limite=sc.nextInt();


        for(int i=1;i<=Limite;i++)
        {suma +=i;}
        System.out.println("El resultado es :"+ suma);
    }}