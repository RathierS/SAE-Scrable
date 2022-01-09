import javax.swing.text.StyledEditorKit.BoldAction;

public class Joueur {
    private String nom;
    private MEE chevalet;
    private int score;

    // Un constructeur
    public Joueur(String unNom) {
        this.nom = unNom;
        this.chevalet = new MEE(26);
        this.score = 0; // ?
    }

    // méthode permettant l'affichage
    public String toString() {
        return "Le joueur " + this.nom + " a un score de : " + this.score;
    }

    // un accesseur en lecteur de l'attribut score
    public int getscore() {
        return score;
    }

    // méthode permettant d'augmenter le score de nb points
    public void ajouteScore(int nb) { // A verifier
        this.score += nb;
    }

    /**
     * pré-requis : nbPointsJet indique le nombre de points rapportés par
     * chaque jeton/lettre
     * résultat : le nombre de points total sur le chevalet de ce joueur
     * suggestion : bien relire la classe MEE !
     */
    public int nbPointsChevalet(int[] nbPointsJet) {
        int pointTotal = this.chevalet.sommeValeurs(nbPointsJet);
        return pointTotal;
    }

    /**
     * pré-requis : les éléments de s sont inférieurs à 26
     * action : simule la prise de nbJetons jetons par this dans le sac s,
     * dans la limite de son contenu.
     */
    public void prendJetons(MEE s, int nbJetons) {
        s.transfereAleat(this.chevalet, nbJetons);
    }

    /**
     * pré-requis : les éléments de s sont inférieurs à 26
     * et nbPointsJet.length >= 26
     * action : simule le coup de this : this choisit de passer son tour,
     * d’échanger des jetons ou de placer un mot
     * résultat : -1 si this a passé son tour, 1 si son chevalet est vide,
     * et 0 sinon
     */
    public int joue(Plateau p, MEE s, int[] nbPointsJet) {
        int res = 0;
        Ut.afficher("Voulez vous Passer (P), Echanger vos jetons (E), ou Jouer un mot (J) ?");
        char choix = Ut.saisirCaractere();

        if (choix == 'P') {
            res = -1;
        } else if (choix == 'E') {
            Ut.afficher("Combien de jetons voulez-vous échanger ?");
            int nbJetonEchanger = Ut.saisirEntier();
            this.chevalet.retire(nbJetonEchanger);
            s.ajoute(nbJetonEchanger);
            // s.echangeJetons res = 0;
        } else if (this.chevalet.estVide()) {
            this.chevalet.transfere(s, 7);
            res = 1;
        } else if (choix == 'J') {
            res = 0;

        } else {
            res = 0;
        }

        return res;

    }

    /**
     * pré-requis : les éléments de s sont inférieurs à 26
     * et nbPointsJet.length >= 26
     * action : simule le placement d’un mot de this :
     * a) le mot, sa position sur le plateau et sa direction, sont saisis
     * au clavier
     * b) vérifie si le mot est valide
     * c) si le coup est valide, le mot est placé sur le plateau
     * résultat : vrai ssi ce coup est valide, c’est-à-dire accepté par
     * CapeloDico et satisfaisant les règles détaillées plus haut
     * stratégie : utilise la méthode joueMotAux
     */
    public boolean joueMot(Plateau p, MEE s, int[] nbPointsJet) {
        boolean res = false;
        Ut.afficher("Etrez le mot, le numéro de la ligne, le numérao de la colonne et la direction ('h'ou 'v') ");
        String mot = Ut.saisirChaine();
        int ligne = Ut.saisirEntier();
        int colonne = Ut.saisirEntier();
        char direction = Ut.saisirCaractere();
        if (p.placementValide(mot, ligne, colonne, direction, s)) {
            joueMotAux(p, s, nbPointsJet, mot, ligne, colonne, direction);
            res = true;
        }
        return res;
    }

    /**
     * pré-requis : cf. joueMot et le placement de mot à partir de la case
     * (numLig, numCol) dans le sens donné par sens est valide
     * action : simule le placement d’un mot de this
     */
    public void joueMotAux(Plateau p, MEE s, int[] nbPointsJet, String mot,
            int numLig, int numCol, char sens) {
        p.place(mot, numLig, numCol, sens, this.chevalet);// A l'aide des jetons du chevalet
        for (int i = this.chevalet.getnbTotEx(); i < 7; i++) {
            this.prendJetons(s, i);

        }
        if (mot.length() == 7) {
            this.ajouteScore(50);
        }
    }

    /**
     * pré-requis : sac peut contenir des entiers de 0 à 25
     * action : simule l’échange de jetons de ce joueur :
     * - saisie de la suite de lettres du chevalet à échanger
     * en vérifiant que la suite soit correcte
     * - échange de jetons entre le chevalet du joueur et le sac
     * stratégie : appelle les méthodes estCorrectPourEchange et echangeJetonsAux
     */
    public void echangeJetons(MEE sac) {
        Ut.afficher("Entrez les lettres à échanger");
        String motSaisis = Ut.saisirChaine();
        if (this.estCorrectPourEchange(motSaisis)) {
            echangeJetonsAux(sac, motSaisis);
        } else {
            while (!this.estCorrectPourEchange(motSaisis)) {
                Ut.afficher("Invalide \n Entrez les lettres à échanger");
                motSaisis = Ut.saisirChaine();
            }
        }
    }

    /**
     * résultat : vrai ssi les caractères de mot correspondent tous à des
     * lettres majuscules et l’ensemble de ces caractères est un
     * sous-ensemble des jetons du chevalet de this
     */
    public boolean estCorrectPourEchange(String mot) {
        boolean res = false;
        int[] tab = new int[mot.length()]; 
        MEE EnsembleMot = new MEE(tab);
        for(int i = 0; i<mot.length();i++){
        if(!Ut.estUneMajuscule(mot.charAt(i)) && tab[]){
            
            
        }
        }
    }

    /**
     * pré-requis : sac peut contenir des entiers de 0 à 25 et ensJetons
     * est un ensemble de jetons correct pour l’échange
     * action : simule l’échange de jetons de ensJetons avec des
     * jetons du sac tirés aléatoirement.
     */
    public void echangeJetonsAux(MEE sac, String ensJetons) {
        for (int i = 0; i < ensJetons.length(); i++) {
            int caractères = Ut.majToIndex(ensJetons.charAt(i));
            this.chevalet.transfere(sac, caractères);
            sac.transfereAleat(this.chevalet, i);
        }
    }

}
