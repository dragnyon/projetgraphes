import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class projet
{
public static void main (String [] args) throws Exception
{
   // String url = "D:/Informatique/projetgraphes-main/graphes.txt";
    String url = "C:/Users/Dylan/Desktop/Semestre 6/Graphes/prj/projetgraphes/graphes.txt";
    int nbadj=getNbAdj(url);
    int tabadjacent[][] = rempliTabAdj(url);
    int tabdeg[][] = rempliTabDegre(tabadjacent);
    int tabvoisin[][] = rempliTabVoisins(tabadjacent,tabdeg, nbadj);
  //  System.out.println("Tableau d'adj");
   // afficheTab2D(tabadjacent);
  //  System.out.println();
  //  System.out.println("Tableau des degres de chaque sommet");
  //  afficheTab2D(tabdeg);
  //  System.out.println();
   
  //  System.out.println();
    System.out.println("Degen : ");
    System.out.println(degen(tabadjacent, tabdeg, tabvoisin));
}


public static int getNbAdj(String url) throws FileNotFoundException
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
    return cptligneadj;

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
   
    for(int i = 0;i<tailleAdj-1;i++)
    {
        for(int j = 0 ; j<2 ; j++)
        {
            degre[tabadjacent[i][j]][1]++;
        }
    }
    return degre;
    
}

public static int[][] rempliTabVoisins(int[][] tabadjacent,int[][] tabdegre, int nbadj)
{
    int sommetmax = getSommetMax(tabadjacent);
    int degremax = getDegreMax(tabdegre);
    int voisin[][] = new int [sommetmax+1][degremax+1];
  
    //Remplissage des noms
    for(int i = 0; i<=sommetmax;i++)
    {
        voisin[i][0]=i;
    }


    //Remplissage des voisins
    for(int i = 0 ; i<nbadj ; i++)
    {
        int cpt=1;
        while(voisin[tabadjacent[i][0]][cpt]!=0)
        {
            cpt++;
        }        
        voisin[tabadjacent[i][0]][cpt]=tabadjacent[i][1];
    }
    
    //Affichage tableau voisins
  /*  System.out.println("Tableaux des voisin dans la fonction :");
  for(int i =0 ;i<=sommetmax;i++)
    {
        System.out.println();
        for(int j = 0; j<=degremax ; j++)
        {
            System.out.print(voisin[i][j]+"|");
        }
        System.out.println();
    }
    System.out.println();*/
    return voisin;
}

public static void afficheVoisin(int[][] tabadjacent,int[][] tabdegre,int [][]voisin)
{
    int sommetmax = getSommetMax(tabadjacent);
    int degremax = getDegreMax(tabdegre);
    for(int i =0 ;i<=sommetmax;i++)
    {
        System.out.println();
        for(int j = 0; j<=degremax ; j++)
        {
            System.out.print(voisin[i][j]+"|");
        }
        System.out.println();
    }
    System.out.println();
}


public static int getSommetMax(int[][] tab)
{
    int sommetmax=0;
    for(int i=0;i<tab.length;i++)
    {
        for(int j=0;j<2;j++)
        {
         if(tab[i][j]>sommetmax)
         {
             sommetmax=tab[i][j];
          }
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
    System.out.println();
}

public static int getDegreMax(int[][] tab)
{
    int tailletabdegre = getSommetMax(tab);
   
    int degremax = 0;
    for(int i =0;i<=tailletabdegre;i++)
    {
        if(degremax<tab[i][1])
        {
            degremax = tab[i][1];
        }
    }
    return degremax;
}



static public int degen(int tabadj [][], int tabdeg [][],int tabvoisin[][])
{
    int t=tabdeg.length;
    
    int nb=getDegreMax(tabdeg)+1;
    int n= getDegreMax(tabdeg);
  //  System.out.println(n);
    int k=1;
    
    while(nb>0)
    {
        for(int i=0; i<t;i++ )
        {
            if(tabdeg[i][1]<=k)
            {
                tabdeg[i][1]=0;
                for(int x=0;x<t;x++)
                {
                     for(int j=1;j<getDegreMax(tabdeg);j++)
                     {
                         //+baisser le degres edes sommet adj
                         if(tabdeg[i][0]==tabvoisin[x][j])
                          {
                              tabvoisin[x][j]=-1;
                            tabdeg[i][1]=tabdeg[i][1]-1;
                            System.out.println("pour k ="+k);
                           // afficheVoisin(tabadj, tabdeg, tabvoisin);
                          // afficheTab2D(tabdeg);
                            x=0;
                          }

                     }
                       
                    }  
                    nb--;    
            }
            
        }
        k++;
    }
    //k correspond a la degen
    return k-1;
}
    
}