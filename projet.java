import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

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
            String line = scan.nextLine();
            //Motif a chercher dans la chaîne
            Pattern p = Pattern.compile(" ");
            //Recherche dans la chaine
            Matcher pos_espace = p.matcher(line);
            int trouve=0;
            if(pos_espace.find())
            {
                //Donne l'endroit ou est trouvé le Pattern p
                trouve=pos_espace.start();    
            }
            //Récupère la partie int avant l'espace
            int partie1int = Integer.parseInt(line.substring(0,trouve));
            //Récupère la partie int après l'espace
            int partie2int = Integer.parseInt(line.substring(trouve+1,line.length()));
            System.out.println(partie1int);
            System.out.println(partie2int);
        }
        
        
     
    }   

}