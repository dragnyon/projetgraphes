import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class projet
{
public static void main (String [] args) throws Exception
{
    String url = "D:/Informatique/projetgraphes/testgraphe.txt";
    //String url = "C:/Users/Dylan/Desktop/Semestre 6/Graphes/projet/testgraphe.txt";
    int tabadjacent[][] = rempliTabAdj(url);
    int tabdeg[][] = rempliTabDegre(tabadjacent);
    int tabvoisin[][];
}

public static int[][] rempliTabAdj(String url)throws FileNotFoundException
{
    File doc = new File(url); 
    Scanner scan;
    scan = new Scanner(doc);
    int cptligneadj = 0;
    //Premier scan pour compter le nombre de ligne
    while(scan.hasNextLine())
    {
        cptligneadj++;
        scan.nextLine();
    }      
    scan.close();
    Scanner scan2 = new Scanner(doc);
    int cpt = 0;
    int tab[][] = new int [cptligneadj+1][2];
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
        cpt++;
    }
        scan2.close();
        return tab;
}

public static int[][] rempliTabDegre(int[][] tabadjacent)
{
    int tailletabdegre = getSommetMax(tabadjacent);
    int degre[][] = new int [tailletabdegre+1][2];
    for(int i = 0;i<tailletabdegre+1;i++)
        {
            degre[i][0] = i;
        }
    
    int tailleAdj = tabadjacent.length;
    //remplissage des degré de chaque sommet
    int cpt=0;
    for(int i = 0;i<tailleAdj-1;i++)
    {
        for(int j = 0 ; j<2 ; j++)
        {
            degre[tabadjacent[i][j]][1]++;
        }
    }
    return degre;
    
}

public static int getSommetMax(int[][] tab)
{
    int sommetmax=0;
    for(int i=0;i<tab.length;i++)
    {
        if(tab[i][1]>sommetmax)
        {
            sommetmax=tab[i][1];
        }
    }
    return sommetmax;
}

public static void afficheTab2D(int[][] tab)
{
    for(int i = 0;i<tab.length;i++)
    {
        System.out.println(tab[i][0]+"/"+tab[i][1]);
    }
}

public static void rempliTabVoisins(int[][] tabadjacent)
{
    
}

}