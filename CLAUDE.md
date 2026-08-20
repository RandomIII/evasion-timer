# Règles de travail du compte à rebours d'évasion

Fichier lu automatiquement à chaque session. Il ne décrit pas le code (voir
`README.md` et `IDEES-MONDES.md`) mais la façon de travailler dessus. Écrit
après une session où les mêmes reproches sont revenus plusieurs fois : ce qui
suit, c'est ce que j'ai eu du mal à tenir tout seul.

## 0. Repères

- L'appli est **un seul fichier HTML autonome** : `app/src/main/assets/index.html`.
  Canvas 2D uniquement, aucun asset externe (l'APK doit tourner hors ligne et la
  CSP des artifacts bloque tout hôte tiers).
- Une copie part dans `Documents/EvasionTimer/index.html` pour le raccourci PC.
- `.github/workflows/build.yml` construit l'APK, `pages.yml` publie le site.
  Pousser sur `main` suffit, il n'y a rien à lancer à la main.
- Les mondes se débloquent par prestige, dans l'ordre `neon`, `abysses`, `arbre`.

## 1. Dimensionner relatif, jamais en pixels absolus

C'est le défaut qui revient le plus. Une constante géométrique se rapporte
toujours à ce qu'elle habille (hauteur du tronc, rayon de l'astre, largeur du
sprite), jamais à l'écran ni à un nombre en dur.

Déjà vu casser : des branches de 170 px sur un tronc de 72, une couronne de
soleil calée sur la diagonale de l'écran, des nuages de 1 900 px de large, une
galaxie agrandie au point que ses étoiles deviennent des taches, une texture
d'univers réduite au point que les siennes disparaissent.

**Vérifier aux deux extrêmes**, minuscule et plein écran, pas seulement à la
taille où on développe.

## 2. Des assets structurés, pas des formes schématiques

Le réflexe par défaut (cercle, trait, boule festonnée) ne passe pas. Ce qui
marche, c'est de partir de la structure réelle : ramification récursive,
feuilles dessinées une à une, cylindre éclairé par une vraie loi de Lambert,
ordre optique correct pour un trou noir.

Si la version livrée pourrait passer pour un placeholder, elle n'est pas finie.
Ne pas attendre qu'on demande une deuxième puis une troisième passe.

**Trancher soi-même sur le design.** « Détermine toi un peu plus » est un retour
qui a déjà été donné : proposer un parti pris net vaut mieux qu'un compromis mou.

## 3. Chaque monde reste étanche

Chaque monde a ses mécaniques : le manomètre appartient à l'eau, les
millisecondes au néon, les saisons à l'arbre.

- Tout effet visuel est scopé `body.monde-<id>` **dès l'écriture**, pas après
  coup quand la fuite se voit.
- Une compétence absente du monde actif doit être **verrouillée**, pas seulement
  absente : parcourir l'union de tous les identifiants, sinon un id inconnu
  n'est jamais masqué.

## 4. Viser haut en densité et en intensité

Le projet est volontairement overkill. En cas de doute sur une quantité,
doubler. La sobriété n'est pas une qualité ici, et le retour reçu est
systématiquement « plus », jamais « moins ».

## 5. Tester l'espace des réglages, pas le chemin nominal

Les bugs trouvés en usage réel venaient tous d'une configuration jamais testée :
une heure de départ placée avant le déjeuner, 30 minutes restantes avec
seulement les heures débloquées, l'état d'après le départ.

Avant de livrer, dérouler au moins : départ **avant** / **pendant** / **après**
la pause, pause désactivée, aucune compétence achetée, et l'après-départ.

**Reproduire le bug avant de le corriger**, et vérifier que le contrôle échoue
bien sur le code d'avant. Sinon il ne prouve rien.

## 6. Stabilité d'une frame à l'autre

La graine d'une entité vient de son **identité** (indice de récursion, index dans
un tableau), jamais de sa position ni de l'horloge : une position dérive avec le
balancement et la texture se met à clignoter.

Quand une vitesse d'animation varie, **intégrer le temps** (`phase += dt * k`)
plutôt que multiplier l'horloge (`t * k`), sinon le moindre changement de facteur
fait sauter l'animation d'un bout à l'autre de son cycle.

## 7. Une mesure se prouve avant d'être citée

Ne jamais annoncer un chiffre de performance sans avoir vérifié que l'instrument
a mesuré quelque chose. Un chiffre inventé de bonne foi est pire qu'aucun
chiffre.

Pièges connus du navigateur sans interface :

- **`requestAnimationFrame` gèle après deux frames.** Le remplacer par
  `setTimeout` avant de charger l'appli, sinon on mesure le démarrage.
- **Les animations CSS se figent en cours de route** sous
  `--virtual-time-budget` : une lettre à demi tombée sur une capture est un
  artefact, pas un bug.
- Pour truquer l'heure, remplacer `window.Date` avant le script de l'appli.

## 8. Style et git

- Commentaires en français, identifiants en anglais, trois lignes maximum, et
  seulement pour expliquer le **pourquoi** quand il n'est pas évident.
- Pas de tirets longs dans les textes en français.
- Message de commit : gitmoji + message en anglais, **10 mots grand maximum**,
  pas de corps. Il dit ce que ça change, pas la mécanique employée.
- Jamais de mention d'IA dans le code ou les commits.

## 9. Fin de tour

- Ne pas laisser l'appli tourner dans le volet navigateur : le canvas anime en
  continu pour rien. Fermer l'onglet avant de rendre la main.
- Terminer par une ligne explicite indiquant que c'est fini, sinon on ne sait
  pas quand reprendre.
