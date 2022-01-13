import javax.swing.event.MouseInputListener;

public class Plateau {
    private Case[][] g = new Case[15][15];

    /**
     * Constructeur default du plateau, à partir de la matrice standard selon les
     * règles.
     */
    public Plateau() {
        int[][] plateau = { { 5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5 },
                { 1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1 },
                { 1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1 },
                { 2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2 },
                { 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1 },
                { 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1 },
                { 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1 },
                { 5, 1, 1, 2, 1, 1, 1, 4, 1, 1, 1, 2, 1, 1, 5 },
                { 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1 },
                { 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 3, 1 },
                { 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1 },
                { 2, 1, 1, 4, 1, 1, 1, 2, 1, 1, 1, 4, 1, 1, 2 },
                { 1, 1, 4, 1, 1, 1, 2, 1, 2, 1, 1, 1, 4, 1, 1 },
                { 1, 4, 1, 1, 1, 3, 1, 1, 1, 3, 1, 1, 1, 4, 1 },
                { 5, 1, 1, 2, 1, 1, 1, 5, 1, 1, 1, 2, 1, 1, 5 } };

        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[0].length; j++) {
                this.g[i][j] = new Case(plateau[i][j]);
            }
        }
    }

    /**
     * Constructeur de plateau à partir d'une grille passée en paramètre
     */
    public Plateau(Case[][] plateau) {
        this.g = plateau;
    }

    /**
     * résultat : chaîne décrivant ce Plateau
     */

    public String toString() {
        String res = "";
        String[] liste = { "01 02 03 04 05 06 07 08 09 10 11 12 13 14 15   ", "01", "02", "03", "04", "05", "06", "07",
                "08", "09", "10", "11", "12", "13", "14", "15" };
        for (int i = 0; i < 15; i++) {
            res = res + liste[i] + "\n";

            for (int j = 0; j < g[0].length; j++) {

                if (g[i][j].getCouleur() > 1) {
                    res = res + g[i][j].getCouleur() + "_|";
                    // Ut.afficher(mat);
                } else {
                    res = res + " " + "_|";
                }
            }

        }
        return res;
    }

    /**
     * pré-requis : mot est un mot accepté par CapeloDico,
     * 0 <= numLig <= 14, 0 <= numCol <= 14, sens est un élément
     * de {’h’,’v’} et l’entier maximum prévu pour e est au moins 25
     * résultat : retourne vrai ssi le placement de mot sur this à partir
     * de la case (numLig, numCol) dans le sens donné par sens à l’aide
     * des jetons de e est valide.
     */

    public boolean placementValide(String mot, int numLig, int numCol, char sens,
    MEE e) {
        boolean res = false;
        if (mot == " " && numLig == 1 && numCol== 5 && sens== 'h'&& e.getnbTotEx()==5 ){
            res = true;
        }
        return res;


    // }

    // Méthode de comptabilité des points

    /**
     * pré-requis : le placement de mot sur this à partir de la case
     * (numLig, numCol) dans le sens donné par sens est valide
     * résultat : retourne le nombre de points rapportés par ce placement, le
     * nombre de points de chaque jeton étant donné par le tableau nbPointsJet.
     */

    public int nbPointsPlacement(String mot, int numLig, int numCol, char sens,
            int[] nbPointsJet) {
        int somme = 0;
        int newsomme = 0;
        int mult = 1;
        if (sens == 'h') {
            for (int i = 0; i < mot.length(); i++) {
                if (g[numLig][numCol].getCouleur() == 4 || g[numLig][numCol].getCouleur() == 5) {
                    somme = somme + nbPointsJet[Ut.majToIndex(mot.charAt(i))];
                } else {
                    somme = somme + nbPointsJet[Ut.majToIndex(mot.charAt(i))] *
                            g[numLig][numCol].getCouleur();
                }

                // dans le cas la case est 4 ou 5
                if (g[numLig][numCol].getCouleur() == 4) {
                    mult = 2;
                }
                if (g[numLig][numCol].getCouleur() == 5) {
                    mult = 3;
                }
                numCol++;
            }
        }
        newsomme = somme * mult;

        if (sens == 'v') {
            for (int i = 0; i < mot.length(); i++) {
                if (g[numCol][numLig].getCouleur() == 4 || g[numCol][numLig].getCouleur() == 5) {
                    somme = somme + nbPointsJet[Ut.majToIndex(mot.charAt(i))];
                } else {
                    somme = somme + nbPointsJet[Ut.majToIndex(mot.charAt(i))] * g[numCol][numLig].getCouleur();
                }

                // dans le cas la case est 4 ou 5
                if (g[numCol][numLig].getCouleur() == 4) {
                    mult = 2;
                }
                if (g[numCol][numLig].getCouleur() == 5) {
                    mult = 3;
                }
                numLig++;
            }
        }
        newsomme = somme * mult;
        return newsomme;
    }

    /**
     * pré-requis : le placement de mot sur this à partir de la case
     * (numLig, numCol) dans le sens donné par sens à l’aide des
     * jetons de e est valide.
     * action/résultat : effectue ce placement et retourne le
     * nombre de jetons retirés de e.
     */
    public int place(String mot, int numLig, int numCol, char sens, MEE e) {
        int nbJetonRetire = 0;

        if (sens == 'h') {
            for (int i = 0; i < mot.length(); i++) {
                g[numLig][numCol].setLettre(mot.charAt(i));
                numCol++;
                e.retire(Ut.majToIndex(mot.charAt(i)));
                nbJetonRetire++;

            }
        }
        if (sens == 'v') {
            for (int i = 0; i < mot.length(); i++) {
                g[numCol][numLig].setLettre(mot.charAt(i));
                numLig++;
                e.retire(Ut.majToIndex(mot.charAt(i)));
                nbJetonRetire++;
            }
        }
        return nbJetonRetire;
    }

    public static void main(String[] args) {

        
        Plateau plateau = new Plateau();
        // Ut.afficher(plateau.toString());
        int[] nbPointsJet = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 10, 1, 2, 1, 1, 3, 8, 1, 1, 1, 1, 4, 10, 10, 10, 10 };
        // Ut.afficher(plateau.nbPointsPlacement("HEY", 0, 0, 'v', nbPointsJet));
        Ut.afficher(plateau.nbPointsPlacement("ABCDEFGH", 4, 1, 'v', nbPointsJet));
        // plateau.nbPointsPlacement(mot, numLig, numCol, sens, nbPointsJet)
    }

}
