import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class projet
{
    
    public static void main (String [] args) throws Exception
    {
        int tab [][]= new int [88234][2];
        //File doc = new File("C:/Users/Dylan/Desktop/Semestre 6/Graphes/projet/testgraphe.txt");
        File doc = new File("D:/Informatique/projetgraphes/graphes.txt"); 
        Scanner scan = new Scanner(doc);
        int cpt = 0;
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
            tab[cpt][0] = Integer.parseInt(line.substring(0,trouve));
            tab[cpt][1] = Integer.parseInt(line.substring(trouve+1,line.length()));
            System.out.println(tab[cpt][0] + "-" + tab[cpt][1]);
        }
    }   

}