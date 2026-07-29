# Feuille de route — Mondes (skins thématiques)

Idées pour une évolution majeure du compte à rebours d'évasion : des **mondes**
achetables avec les tokens. Chaque monde reskine entièrement le timer, change
l'ambiance de fond, et déclenche un **climax propre au thème** à la libération.

**On ne le fait pas tout de suite.** Ce fichier sert à ne rien perdre de la vision.

## Principe

- Le monde actuel (néon / salle de contrôle arcade RGB) devient le **Monde 1**.
- Chaque monde a **sa propre monnaie locale** (gagnée quand ce monde est actif)
  et **son propre arbre d'upgrades**.
- Chaque monde définit : palette, rendu de fond (dessin canvas), style
  d'afficheur, animation de fin, monnaie, arbre d'upgrades.

## Progression : rebirth / prestige (modèle retenu)

- On débloque les mondes par **prestige**, pas par achat libre.
- Quand **toutes les upgrades d'un monde sont achetées**, un bouton **PRESTIGE**
  (en **violet**) apparaît. Tant qu'il n'est pas disponible, il est **invisible**.
- Cliquer PRESTIGE donne accès au **monde suivant**.
- **Bouton planète** : sous le bouton menu ☰, un bouton planète permet de
  **changer de monde** (naviguer entre les mondes débloqués). Il n'apparaît
  **qu'après le 1er prestige** (avant, il n'y a qu'un monde, donc inutile).
- Une fois débloqués, on **switche librement** entre les mondes via la planète —
  chacun garde sa progression. (Le prestige gate l'accès ; il ne force pas à
  abandonner son monde préféré.)

## Mondes envisagés

### 🎛️ Néon / salle de contrôle (actuel — Monde 1)
- Afficheur 7 segments, champ d'étoiles, paliers de couleur, RAINBOW final.
- C'est la base déjà en place.

### 🌋 Volcan
- Le fond chauffe à mesure qu'on approche du départ.
- Climax : **éruption** à 0.
- Upgrades : lave plus intense, **pluie de météorites**, coulées qui débordent
  de l'écran.
- Monnaie locale : cendres / obsidienne.

### 🌊 Abysses
- Le timer devient l'**air restant** d'un plongeur qui **remonte** vers la
  surface au fil de la journée.
- Climax : il **crève la surface** = LIBRE.
- Upgrades : **+ de poissons**, bancs, méduses bioluminescentes, une baleine qui
  traverse l'écran.
- Monnaie locale : bulles d'air.

### 🌸 Japon / cerisiers
- Pétales qui tombent, ambiance zen.
- Climax : bourrasque de fleurs, torii, coucher de soleil.
- Monnaie locale : pétales.

### 🍂 Saisons
- Le temps qui passe **à travers les 4 saisons** (printemps → été → automne →
  hiver), le décor évolue au fil de la journée.
- Climax : à confirmer (transition de saison finale ? tempête de neige ?).

### 🏘️ Village évolutif
- Le temps qui passe dans un village : **de la tribu préhistorique à la
  civilisation futuriste**. Plus la journée avance, plus le village évolue
  (huttes → maisons → gratte-ciels → cité futuriste).
- Climax : la cité atteint son apogée / décollage.

## Étape technique préalable (avant d'ajouter des mondes)

Aujourd'hui le thème est **codé en dur** (palette cyan, afficheur 7 segments,
champ d'étoiles, un seul arbre, une seule monnaie). Avant d'ajouter des mondes,
il faudra **transformer un « monde » en module** exposant :

- sa palette / ses tokens de couleur,
- son rendu de fond (fonction de dessin canvas),
- son style d'afficheur,
- son animation de fin (climax),
- sa monnaie,
- son arbre d'upgrades.

Plus un **écran de sélection de mondes** (bouton planète), une **sauvegarde par
monde** (localStorage segmenté) et l'**état de prestige** (mondes débloqués,
monde actif).

Une fois cette ossature posée, ajouter un volcan ou des abysses = brancher un
nouveau module.

## Ordre suggéré pour démarrer

Commencer par un monde très visuel pour valider l'architecture :
**Abysses** ou **Volcan** en premier.
