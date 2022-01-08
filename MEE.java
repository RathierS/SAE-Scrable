//gère des ensembles de jetons présents sur les chevalets ou les sac de jetons
public class MEE {

    private int[] tabFreq; // tabFreq[i] est le nombre d'exemplaires, (fréquence de l'élément i)

    private int nbTotEx; // nombre total d'exemplaire

    public int getnbTotEx() {
        return this.nbTotEx;
    }

    /**
     * pré-requis : max >= 0*
     * action : crée un multi-ensemble vide dont les éléments seront
     * inférieurs à max
     */

    public MEE(int max) {
        this.tabFreq = new int[max];
        this.nbTotEx = 0;
    }

    /**
     * pré-requis : les éléments de tab sont positifs ou nuls
     * action : crée un multi-ensemble dont le tableau de fréquences est
     * une copie de tab
     */

    public MEE(int[] tab) {
        this.tabFreq = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            this.tabFreq[i] = tab[i];
            this.nbTotEx++;
        }
    }

    /**
     * constructeur par copie
     */

    public MEE(MEE e) {
        this.tabFreq = e.tabFreq;
        this.nbTotEx = e.nbTotEx;
    }

    /**
     * résultat : vrai ssi cet ensemble est vide
     */

    public boolean estVide() {
        return this.nbTotEx == 0;
    }

    /**
     * pré-requis : 0 <= i < tabFreq.length
     * action : ajoute un exemplaire de i à this
     */

    public void ajoute(int i) {
        if (i < tabFreq.length) {
            this.tabFreq[i] += 1;
        }

    }

    /**
     * affiche le tableau sous la forme :
     * {4, 7, 9, ....}
     */
    public String toString() {
        String res = "{";
        for (int j = 0; j < nbTotEx; j++) {
            res = res + this.tabFreq[j] + " ";
        }
        res += this.tabFreq[this.nbTotEx - 1] + " }";
        return res;
    }

    /**
     * pré-requis : 0 <= i < tabFreq.length
     * action/résultat : retire un exemplaire de i de this s’il en existe,
     * et retourne vrai ssi cette action a pu être effectuée
     */

    public boolean retire(int i) {
        boolean res = false;
        for (int j = 0; j < this.nbTotEx; j++) {
            if (this.tabFreq[j] == i) {
                this.tabFreq[j] -= 1;
                this.nbTotEx -= 1;
                res = true;
            }
        }
        return res;
    }

    /**
     * pré-requis : this est non vide
     * action/résultat : retire de this un exemplaire choisi aléatoirement
     * et le retourne
     */

    public int retireAleat() {
        int i = Ut.randomMinMax(0, this.tabFreq.length - 1);
        retire(i);
        return this.tabFreq[i];
    }

    /**
     * pré-requis : 0 <= i < tabFreq.length
     * action/résultat : transfère un exemplaire de i de this vers e s’il
     * en existe, et retourne vrai ssi cette action a pu être effectuée
     */

    public boolean transfere(MEE e, int i) {
        boolean res = false;
        for (int j = 0; j < tabFreq.length; j++) {
            if (this.tabFreq[j] == i) {
                this.retire(i);
                e.ajoute(i);
                res = true;
            }
        }
        return res;

    }

    /**
     * pré-requis : k >= 0
     * action : tranfère k exemplaires choisis aléatoirement de this vers e
     * dans la limite du contenu de this
     * résultat : le nombre d’exemplaires effectivement transférés
     */

    public int transfereAleat(MEE e, int k) {
        int nb_exmplaire = 0;
        int random = Ut.randomMinMax(0, this.tabFreq.length - 1);
        for (int i = 0; i < k; i++) {
            if (retire(random) == true) {
                transfere(e, random);
                nb_exmplaire++;
            }
        }
        return nb_exmplaire;
    }

    /**
     * pré-requis : tabFreq.length <= v.length
     * résultat : retourne la somme des valeurs des exemplaires des
     * éléments de this, la valeur d’un exemplaire d’un élément i
     * de this étant égale à v[i]
     */

    public int sommeValeurs(int[] v) {
        int sommes = 0;
        for (int i = 0; i < this.tabFreq.length; i++) {
            sommes = v[i] * tabFreq[i] + sommes;
        }
        return sommes;

    }

}
