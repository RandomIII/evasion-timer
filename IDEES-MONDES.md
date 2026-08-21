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

### 🌊 Abysses — **✅ CONSTRUIT (Monde 2)**
Réalisé : décor de base seul au départ (eau, sable, bulles), puis tout s'achète —
plongeur, herbier, trésor, poissons, bateau, et les profondeurs (−80/−200/−600/−1800 m)
qui font démarrer la plongée plus bas. Pas de ms/µs (pas futuriste) : à la place un
**profondimètre** (mètres) et un **manomètre** (bar, pression réelle = 1 + prof/10).

Notes de conception d'origine :
- Le timer devient l'**air restant** d'un plongeur qui **remonte** vers la
  surface au fil de la journée.
- Climax : il **crève la surface** = LIBRE.
- Upgrades : **+ de poissons**, bancs, méduses bioluminescentes, une baleine qui
  traverse l'écran.
- Monnaie locale : bulles d'air.
- Caméra verticale qui suit le plongeur (remontée = progression de la journée).
- Palette d'alerte → **profondeur / lumière** : plus on remonte, plus l'eau
  s'éclaircit (noir abyssal → bleu profond → turquoise → surface scintillante).
- Pause midi : le plongeur fait un **palier de décompression**.

### 🌱 L'Arbre — **✅ CONSTRUIT (Monde 3)**
Réalisé : pousse le matin, ciel, nuages, espace, survol de la Lune, trou noir
à la fin. Feuillage saisonnier sur la vraie date. En LIBRE, l'arbre devient un
astre et le système solaire lui tourne autour.

Notes de conception d'origine :
- La **croissance verticale est la barre de progression** : la caméra suit la
  cime, on monte avec l'arbre toute la journée.
- Étapes : graine dans la terre (08:30) → germination → tige et feuilles →
  le tronc dépasse les nuages → stratosphère, les étoiles apparaissent →
  il perce l'atmosphère.
- Climax : **IL FLEURIT** — explosion de fleurs, pétales en apesanteur.
- Pause midi : la **pluie tombe**, l'arbre boit (équivalent du hamburger).
- Palette d'alerte → **le ciel** : jaune = lumière dorée, orange = crépuscule,
  rouge = dernières braises du couchant, violet = nuit stratosphérique,
  RAINBOW = **aurore boréale**.
- Monnaie locale : la **sève**.
- Upgrades : racines visibles sous terre, feuillage plus dense, oiseaux qui
  nichent, lucioles au crépuscule, fruits, satellites croisés en altitude,
  vent dans les branches, floraison finale plus spectaculaire.
- ⚠️ Chevauche un peu le monde Japon (pétales/floraison). À trancher : fusionner
  (l'arbre final est un cerisier géant) ou différencier — l'Arbre = voyage
  **vertical et cosmique**, le Japon = scène **horizontale et zen**.

### 🌸 Japon / cerisiers
- Pétales qui tombent, ambiance zen.
- Climax : bourrasque de fleurs, torii, coucher de soleil.
- Monnaie locale : pétales.

### 🍂 Saisons
- Le temps qui passe **à travers les 4 saisons** (printemps → été → automne →
  hiver), le décor évolue au fil de la journée.
- Climax : à confirmer (transition de saison finale ? tempête de neige ?).

### 🏘️ Village évolutif — **✅ CONSTRUIT (Monde 4)**
Réalisé : caméra fixe, six époques par tranches de 20 % de la journée, chaque
parcelle bascule à son propre seuil. Instrument propre : la chronique (année,
époque, population). Climax : le décollage de la cité.

Notes de conception d'origine :
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

## Ordre de construction

1. **🌊 Abysses** — choisi comme Monde 2, premier à construire. Sert aussi de
   test pour l'architecture modulaire (caméra verticale, monnaie locale, arbre
   propre, climax).
2. 🌱 l'Arbre (Monde 3), puis 🏘️ le Village (Monde 4).
3. Restent : 🌋 le Volcan et 🌸 le Japon. Les 🍂 Saisons sont absorbées par
   l'Arbre, qui change déjà de feuillage selon la vraie date.

## Questions encore ouvertes

- Climax du monde **Saisons** (transition finale ? tempête de neige ?).
- Monnaie du monde **Village** (ressources ? habitants ?).
- Fusionner ou non **l'Arbre** et le **Japon** (chevauchement floraison).
