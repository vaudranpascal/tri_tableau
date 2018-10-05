
/**
 * Décrivez votre classe test ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.lang.Math;
public class test
{
    
    public static final int VALEUR_ABSENTE=-1;
   public static void main (String [] args)
   {
    int l=24;
    int reponse;
    
    
    int[]tab= {7,12,56,25,1,2,3,7,8,9,125,55,43};
    int [] tabtribull= new int [13];
    reponse = Math.round((0 + 23) / 2);
    
    System.out.println(reponse);
tabtribull=triBulle(tab);

for (int element: tabtribull )
{ 
 System.out.print(element + " ");
}
    
    
    
    
    }
    
    // fouille binaire
    public static int fouille(int[] unTablo, int valeur){

		// Fouille dichotomique dans le tableau.
		// Au debut, l'espace de recherche va de 1 a tab.length.
		int debut = 0;
		int fin = unTablo.length -1;
		int milieu = 0;


		boolean trouvee = false;

		// Tant que les indices ne se sont pas croisés.
		while (!trouvee && debut <= fin){

			// On trouve le milieu de l'espace de recherche.
			milieu = Math.round((debut + fin) / 2);

			// On conserve la moitie de droite ou de gauche de l'espace de
			// recherche en déplaçant les indice de début ou de fin.
			if (valeur < unTablo[milieu])
				fin = milieu - 1;

			else if (valeur > unTablo[milieu])
				debut = milieu + 1;

			else
				trouvee = true;
		}

		// On vérifie si la valeur n'a été trouvée.
		// On doit mettre la valeur négative.
		if(!trouvee)
			milieu = VALEUR_ABSENTE;

		// On retourne la position.
		return milieu;
	}
	
	
	/*******************************************************
	 * Implémentation de l'algorithme du tri à bulles tel que
	 * décrit à : http://fr.wikipedia.org/wiki/Tri_a_bulles.
	 *
	 * @param unTablo Tableau dans lequel sera effectué le tri.
	 */
	public static int[] triBulle(int[] unTablo)
	{

		// Pour toutes les cases du début à l'avant dernier (dernier inutile).
		for(int i = 0; i < unTablo.length - 1;i++){


			// Pour toutes les cases de la fin vers le début - 1(important).
			for(int j = unTablo.length-1; j > i; j--){

				// Si la case de droite est plus petite que celle de gauche.
				if(unTablo[j] < unTablo[j-1]){

					// On les échange.
					echange(unTablo,j,j-1);
				}
			}
	

}
return  unTablo;
	}
	
	
	/*******************************************************
	 * Permet l'échange entre deux valeurs du tableau
	 * @param unTablo Le tableau dans le quel il faut effectuer l'échange
	 * @param pos1 L'indice d'une des cases à échanger le contenu
	 * @param pos2 L'indice de l'autre case à échanger le contenu
	 */
	public  static void echange(int[] unTablo, int pos1, int pos2){

		//Variable temporaire nécessaire pour intervertir deux valeurs en mémoire
		int tmp;

		//Intervertit le contenu des deux cases (Échange à trois)
		tmp = unTablo[pos1];
		unTablo[pos1] = unTablo[pos2];
		unTablo[pos2] = tmp;
	}
	
	
	
	
	/*******************************************************
	 * Trouve et retourne l'indice de la case où la valeur fournie
	 * doit se retrouver dans le tableau à partir de la position de
	 * départ en se déplaçant vers la gauche (début du tableau).
	 *
	 * @param unTablo Tableau dans lequel sera effectué la recherche.
	 * @param positionDepart L'indice de la case d'où doit commencer la recherche.
	 * @param valeur La valeur dont on cherche la position dans un tableau partiellement trié.
	 */
	public static int trouvePosition(int[] unTablo, int positionDepart,int valeur){

		// Tant qu'il y aura des éléments du tableau plus grand
		// que la valeur cherchée, on déplace la position de départ vers la gauche.
		// À moins que la valeur soit la plus petite.
		while (positionDepart >= 0 && unTablo[positionDepart] > valeur){

			positionDepart--;
		}

		// Il faut replacer k sur la bonne case  avant de le retourner.
		return ++positionDepart;
	}
	
	
	/*******************************************************
	 * DEPLACER CASES VERS LA DROITE
	 * *****************************************************
	 * Procédure qui décale les éléments d'un tableau entre deux positions.
	 *
	 * @param unTablo Tableau dans lequel sera effectué le décalage.
	 * @param positionDepart Position de départ du décalage.
	 * @param positionFin Position de fin du décalage.
	 */
	public static void deplacerCasesVersLaDroite(int[] unTablo,
			int positionDepart,
			int positionFin){

		// On déplace les valeurs du tableau d'une case vers la droite
		// à partir la position de départ jusqu'à la position de fin.
		for (int j = positionDepart; j >= positionFin; j--) {

			// On décale vers la droite.
			unTablo[j+1] = unTablo[j];
		}
	}
	
	
	/*******************************************************
	 * TRI INSERTION
	 * *****************************************************
	 * Implémentation de l'algorithme du tri par insertion tel que
	 * décrit à : http://fr.wikipedia.org/wiki/Tri_par_insertion.
	 *
	 * @param unTablo Tableau dans lequel sera effectué le tri.
	 */
	public static void triInsertion(int[] unTablo){


		/*STRATÉGIE : C'est la meilleure version du tri par insertion
		 *            car elle décale et non échange les valeurs.
		 */


		// Indice permettant de trouver l'emplacement de la valeur à insérer.
		int positionInsertion;
		int positionDepart;

		// Sert à retenir la valeur à insérer.
		int valeur;

		// Pour toutes les cases du tableau sauf la pemière (déjà triée).
		for (int i = 1; i < unTablo.length; i++){

			positionDepart = i-1;

			// On retient la ième valeur du tableau.
			valeur = unTablo[i];

			// On trouve la position où il faut insérer.
			positionInsertion = trouvePosition(unTablo,positionDepart,valeur);

			//On fait le décalage pour libérer la case à la position d'insertion
			deplacerCasesVersLaDroite(unTablo, positionDepart, positionInsertion);


			// On insère la valeur.
			unTablo[positionInsertion] = valeur;
		}
}

/******************************************************
	 * Retourne la position dans le tableau de la plus
	 * petite valeur à partir de la position de départ.
	 *
	 * @param unTablo Le tableau dans le quel il faut trouver la plus petite valeur
	 * @param positionDepart L'indice de la case de départ pour la recherche
	 *
	 */
	private static int positionValeurMinimum(int[] unTablo, int positionDepart){

		//Retient l'indice de départ comme étant celle de la case contenant le
		//la plus petite valeur vue à date
		int posMinJusquaMaintenant = positionDepart;

		// À la recherche d'une case dont le contenu est plus petit que celle
		//pointée par l'indice de la valeur la plus petite jusqu'à maintenant.

		//Pour toutes les case du tableau à partir de la position de départ
		for(int position = positionDepart;position <unTablo.length;position++){

			//Si la case pointée par position est plus petite que celle jusqu'à maintenant
			if(unTablo[posMinJusquaMaintenant] > unTablo[position])

				//On retient cette position comme étant celle contenant la valeur la plus petite
				//jusqu'à maintenant
				posMinJusquaMaintenant = position;

		}
		//On retourne l'indice trouvée
		return posMinJusquaMaintenant;

	}
	
	
	/*******************************************************
	 * LES FONCTIONS DE TRI
	 * *****************************************************

	/*******************************************************
	 * Implémentation de l'algorithme du tri par sélection tel que
	 * décrit à : http://fr.wikipedia.org/wiki/Tri_par_selection.
	 *
	 * @param unTablo Tableau dans lequel sera effectué le tri
	 */
	public static void triSelection(int[] unTablo){


		// Pour toutes les cases du tableau à l'exception de la dernière(inutile).
		for(int i = 0; i < unTablo.length - 1;i++){


			/* On minimise le nombre de lignes de code en utilisant la fonction
			 * comme paramètre effectif.  Autrement, on aurait écrit :
			 *
			 * int indice = positionValeurMinimum(unTablo,i);
			 * echange(unTablo,i,indice);
			 *
			 */
			echange(unTablo,i,positionValeurMinimum(unTablo,i));
		}
	}
}
