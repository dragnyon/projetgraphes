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
            //Decoupe la chaine de 0 a l'espace
            String partie1 = line.substring(0,trouve);
            //Decoupe la chaine de l'espace a la fin
            String partie2 = line.substring(trouve+1,line.length());
            //Récupère les int de la string
            int partie1int = Integer.parseInt(partie1);
            int partie2int = Integer.parseInt(partie2);
            System.out.println(partie1int);
            System.out.println(partie2int);
        }
        
        
     
    }   

}