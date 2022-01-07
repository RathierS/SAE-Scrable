public class Plateau {
    private Case[][] g; // g pour grille

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

    }
    public String toString(){
    for (int i = 0; i < g.length; i++) {
        plateauCourant += (" " + col + " |");
        for (int j = 0; j < g[0].length; j++) {
            if (g[i][j].getCouleur() == 1) {
            if (g[i][j].getCouleur() == 1 && !g[i][j].estRecouverte()) {
                plateauCourant += "   |";
            } else {
                plateauCourant += " " + g[i][j].toString() + " |";
            }

    /**
     * résultat : chaîne décrivant ce Plateau
     */

    // public String toString() {
    // }

    // permet d'afficher la grille avec les num qui correspond au code couleur
    // des cases et laissa vide sur la casse est grise cad si le code coleur est de
    // 1
    // Indique les indices des lignes mais pas des colonnes.
    // il manque à mettre les indices des colonnes, mettre
    // la lettre majuscule quana la lettre est recouverte
    
    // public static void affichage(int[][] mat) {
    //     for (int i = 0; i < 15; i++) {
    //         if (i < 9) {
    //             Ut.afficher(" " + "0" + (i + 1) + "  :  ");
    //         } else {

    //             Ut.afficher(" " + (i + 1) + "  :  ");
    //         }

    //         for (int j = 0; j < 15; j++) {

    //             if (mat[i][j] != 1) {
    //                 Ut.afficher(mat[i][j] + "_|");
    //                 // Ut.afficher(mat);
    //             } else {
    //                 Ut.afficher(" " + "_|");
    //             }
    //         }
    //         System.out.println("");

    //     }
    // }

    // Autres méthodes permettant de placer un mot proposé pat un joueur.
    // le mot est un String
    // coordonées de la case contenant la première lettre
    // le sens du mot (vertical v ou hrizontal h )

    /**
     * pré-requis : mot est un mot accepté par CapeloDico,
     * 0 <= numLig <= 14, 0 <= numCol <= 14, sens est un élément
     * de {’h’,’v’} et l’entier maximum prévu pour e est au moins 25
     * résultat : retourne vrai ssi le placement de mot sur this à partir
     * de la case (numLig, numCol) dans le sens donné par sens à l’aide
     * des jetons de e est valide.
     */

    /*
     * public boolean placementValide(String mot, int numLig, int numCol,char sens,
     * MEE e) {
     * boolean res = true;
     * if (mot == ){
     * }
     * }
     */

    // Méthode de comptabilité des points

    /**
     * pré-requis : le placement de mot sur this à partir de la case
     * (numLig, numCol) dans le sens donné par sens est valide
     * résultat : retourne le nombre de points rapportés par ce placement, le
     * nombre de points de chaque jeton étant donné par le tableau nbPointsJet.
     */
    // public int nbPointsPlacement(String mot, int numLig, int numCol,char sens,
    // int[] nbPointsJet) {

    // }

    /**
     * pré-requis : le placement de mot sur this à partir de la case
     * (numLig, numCol) dans le sens donné par sens à l’aide des
     * jetons de e est valide.
     * action/résultat : effectue ce placement et retourne le
     * nombre de jetons retirés de e.
     */
    // public int place(String mot, int numLig, int numCol, char sens, MEE e){}

    public static void main(String[] args) {

        // prblème avec int[][] plateau;
    }

}
