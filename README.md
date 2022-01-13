# SAE-Scrabble

## Notre objectif :

Pour cette SAE, les consignes étaient de programmer une partie du jeu de Scrabble entre humains. Pour cela, il nous était demandé de créer plusieurs classes permettant l'exécution de la partie. Une version de base, était demandée mais des extensions étaient aussi proposées afin d'améliorer ou de compléter le projet.
Notre objectif était donc de créer des classes avec les méthodes demandées afin que l'on puisse lancer une partie.

## Notre SAE :

Nous n'avons malheureusement pas pu fini notre Scrabble et quelques méthodes manquent à nos classes.
Ainsi, nous avons fait les classes MEE et Case entièrement (compléter la classe Ut aussi), mais les méthodes suivantes sont absentes : 
* placementValide (pour la classe plateau) 
* estCorrectPourEchange (de la classe Joueur) 
* toString ( de la classe Scrabble) 
* La classe MainScrabble

## Tester nos classes : 

Même si le jeu de scrabble ne fonctionne pas dû à certaines classes manquantes, il est tout de même possible de tester nos classes. Mais pour cela il vous faudra créer un main (public static void main(String[] args)) en appelant les méthodes que vous voulez exécuter. Par exemple, vous pouvez écrire ceci dans un main pour exécuter la méthode nbPointsPlacement.

Plateau plateau = new Plateau();
int[] nbPointsJet = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 10, 1, 2, 1, 1, 3, 8, 1, 1, 1, 1, 4, 10, 10, 10, 10 };
Ut.afficher(plateau.nbPointsPlacement("ABCDEFGH", 4, 1, 'v', nbPointsJet));

Il vous faudra aussi **télécharger** nos classes et les mettre dans un même dossier. Ensuite, à partir de votre terminal, vous devez entrer dans votre dossier (commande cd <cible>) puis taper la commande **javac** suivi de nom de a classe puis appuyer sur Enter. Une fois fait, entrer la commande **java** suivi du nom de la même classe précédemment entrer. Appuyer ensuite sur Entrer et vous devriez avoir le résulat que propose la méthode. 
  
Dans certain cas il est aussi possible d'aller dans son dossier et de taper **cmd** à la place de la barre indiquant le répertoire afin d'ouvrir le terminal directement en étant dans notre dossier.

## Notre nouvel objectif :
  
Même si nous n'avons pas réussi à finir toutes les méthodes dans les temps, notre objectif est maintenant de continuer et de réussir à finir notre jeu de Scrabble afin de nous améliorer.
  
> La chute n'est pas un échec. L'échec, c'est de rester là où on est tombé. (Socrate de Constantinople).