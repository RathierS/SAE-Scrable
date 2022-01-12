public class Scrabble {
        // gère le déroulement d'une partie
        // objet Plteau qui contiennt une matrice de Case

        private Joueur[] joueurs;
        private int numJoueur; // joueur courant (entre 0 et joueurs.length-1)
        private Plateau plateau;
        private MEE sac;
        private static int[] nbPointsJeton = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 10, 1, 2, 1, 1, 3, 8, 1, 1, 1, 1, 4, 10,
                        10, 10, 10 };

        // Le constructeur de cette classe prend comme paramètre un tableau de chaînes
        // de caractères
        // indiquant les noms de tous les joueurs. Il permet d’initialiser toutes les
        // structures du jeu. Dans
        // cette version de base, le numéro du joueur qui commence est choisi
        // aléatoirement.
        public Scrabble(String[] nomJoueurs) {
                int[] FrequenceLettre = { 9, 2, 2, 3, 15, 2, 2, 2, 8, 1, 1, 5, 3, 6, 6, 2, 1, 6, 6, 6, 6, 2, 1, 1, 1,
                                1 };
                this.plateau = new Plateau();
                this.sac = new MEE(FrequenceLettre);
                for (int i = 0; i < nomJoueurs.length; i++) {
                        this.joueurs[i] = new Joueur(nomJoueurs[i]);
                        this.numJoueur = i++;
                }

        }

        // La méthode toString permet d’afficher à chaque tour de jeu l’état du plateau
        // et le joueur qui a
        // la main.
        public String toString() {
                plateau.toString();

        }

        // méthode partie orchestre une partie de Scrabble

        public void partie() {

                for (int i = 0; i < this.joueurs.length; i++) {
                        for (int j = 0; j < 7; j++) {
                                this.joueurs[i].prendJetons(this.sac, 1);
                        }
                }

                int res = 0;
                int joueurSuivant = 0;
                while (!sac.estVide() && joueurSuivant < joueurs.length) {
                        res = joueurs[this.numJoueur].joue(this.plateau, this.sac, this.nbPointsJeton);
                        if (res == -1) {
                                joueurSuivant++;
                                if (joueurSuivant == joueurs.length) {
                                        joueurSuivant = 0;
                                }
                        }
                        // if(res == 1 ){
                        // remplir le chevalet -> dans la méthode joue
                        // }
                        if (res == 0) {
                                joueurs[joueurSuivant].joueMot(this.plateau, this.sac, this.nbPointsJeton);
                        }
                        joueurSuivant++;

                }
                for (int i = 0; i < this.numJoueur; i++) {
                        if (res == -1) {
                                Ut.afficher("Partie terminée");

                        }

                }
                Ut.afficher("Partie terminée");
                
        }

}
