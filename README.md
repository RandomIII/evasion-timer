# Compte à rebours d'évasion — APK Android

Application Android minimale qui affiche le compte à rebours de journée
(08:30 → 16:30, pause 12:00 → 13:00) en plein écran, **hors ligne**.

C'est une `WebView` qui charge `app/src/main/assets/index.html`. Aucune
dépendance, aucune permission, aucun accès réseau.

## Récupérer l'APK

L'APK est compilé automatiquement par GitHub Actions à chaque push.

1. Onglet **Actions** du dépôt → dernier run **Build APK**.
2. En bas, section **Artifacts** → télécharger `evasion-apk`.
3. Décompresser le `.zip` : il contient `app-debug.apk`.
4. Copier ce fichier sur le téléphone et l'ouvrir pour l'installer
   (autoriser « installer depuis cette source » si Android le demande).

C'est un APK de *debug*, signé avec la clé de debug standard : parfait pour
un usage personnel, mais non publiable sur le Play Store en l'état.

## Modifier l'application

Tout le visuel est dans `app/src/main/assets/index.html`. Les horaires se
changent en tête du `<script>` (`const JOUR` et `const SEUILS`). Un push
suffit à relancer le build.
