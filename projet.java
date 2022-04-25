import java.io.*;
import java.util.*;


public class projet
{
    
    public static void main (String [] args) throws Exception
    {
        int tab [][]= new int [100][100];
        //File doc = new File("C:/Users/Dylan/Desktop/Semestre 6/Graphes/projet/testgraphe.txt");
        File doc = new File("D:/Informatique/projetgraphes/graphes.txt"); 
        Scanner scan = new Scanner(doc);
        while(scan.hasNextLine())
        {
            //lit le fichier
            String line = scan.nextLine();
            String[] decoupage = line.split(" ");
            for (int i = 0; i < decoupage.length; i++) {
                System.out.println(decoupage[i]);
            }
        }
        scan.close();
     
    }   

}