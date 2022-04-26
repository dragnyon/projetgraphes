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
    getdegre(getadj(url),comptesommetmax(getadj(url)));
    }

    static public int[][] getadj(String url) throws FileNotFoundException
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
            int tab [][]= new int [cptligneadj][2];
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

            }
            scan2.close();
            return tab;
        }


    static public int comptesommetmax(int tab[][])
    {
        int cpt=0;
        int sommetmax=0;
        if(tab[cpt][1]>sommetmax)
        {
            sommetmax =tab[cpt][1];
        }
        cpt++;
        System.out.println(sommetmax);
        return sommetmax;
    }
    static public int[][] getdegre(int tab[][],int sommetmax)
        {
        //Tableau de la taille du sommet maximum
        int degre[][] = new int [sommetmax+1][2];
        System.out.println("Sommet max : " + sommetmax);



        //Remplissage du tableau de degré par N°Sommet / 0
        for(int i = 0;i<=sommetmax;i++)
        {
            degre[i][0] = i;
            //degre[i][1] = 0;
        }
        int cptligneadj = tab.length;
        System.out.println(cptligneadj);
        //remplissage des degré de chaque sommet
        for(int i = 0;i<cptligneadj;i++)
        {
            for(int j = 0 ; j<2 ; j++)
            {
                degre[tab[i][j]][1]++;
            }
        }
        //Affichage du tableau des degrés
        for(int i=0;i<sommetmax+1;i++)
        {
            System.out.println("Sommet : "+degre[i][0]+" Degré : "+degre[i][1]);
        }
        return degre;
        }

    static public int comptesommet(int tab[][])
        {
            int cpt = 0;
            for(int i=0; i<tab.length;i++ )
            {
                if(tab[i][1]>0)
                {
                    cpt++;
                }
            }
            return cpt;
        }

    static public int degen(int tab [][])
    {
        int k=0;
        while(comptesommet(tab)>0)
        {
            for(int i=0; i<tab.length;i++ )
            {
                if(tab[i][1]<=k)
                {
                    tab[i][1]=0;
                    //+baisser le degres edes sommet adj
                }
            }
            k++;
        }
        //k correspond a la degen
        return k;
    }

}