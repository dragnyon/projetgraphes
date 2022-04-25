import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class projet
{
    
    public static void main (String [] args) throws Exception
    {
        
        //File doc = new File("C:/Users/Dylan/Desktop/Semestre 6/Graphes/projet/testgraphe.txt");
        File doc = new File("D:/Informatique/projetgraphes/testgraphe.txt"); 
        Scanner scan = new Scanner(doc);
        int cptligne = 0;

        //Premier scan pour compter le nombre de ligne
        while(scan.hasNextLine())
        {
            cptligne++;
        }
        scan.close();


        Scanner scan2 = new Scanner(doc);
        int cpt = 0;
        int sommetmax = 0;
        int tab [][]= new int [cptligne][2];
        while(scan2.hasNextLine())
        {
            String line = scan2.nextLine();
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
            //Stock dans le tableau
            tab[cpt][0] = Integer.parseInt(line.substring(0,trouve));
            tab[cpt][1] = Integer.parseInt(line.substring(trouve+1,line.length()));
            if(tab[cpt][1]>sommetmax)
            {
                sommetmax =tab[cpt][1];
            }
            //Affiche le tableau a chaque ligne d'éxecution
            System.out.println(tab[cpt][0] + "-" + tab[cpt][1]);
            cpt++;
        }
        scan2.close();

        //Tableau de la taille du sommet maximum
        int degre[][] = new int [sommetmax+1][2];
        System.out.println("Sommet max : " + sommetmax);



        //Remplissage du tableau de degré par N°Sommet / 0
        for(int i = 0;i<=sommetmax;i++)
        {
        degre[i][0] = i;
        degre[i][1] = 0;
        System.out.println(degre[i][0] + "|" + degre[i][1]);
        }
    }   

}