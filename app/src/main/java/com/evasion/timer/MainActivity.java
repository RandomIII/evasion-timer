package com.evasion.timer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Une seule Activity qui affiche la page embarquée en plein écran.
 * Pas d'AppCompat, pas d'AndroidX : l'app n'a aucune dépendance externe.
 */
public class MainActivity extends Activity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Un compte à rebours se regarde : l'écran ne doit pas s'éteindre.
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        web = new WebView(this);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);                       // toute l'app est en JS
        s.setDomStorageEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false);       // les bips peuvent sonner sans clic
        web.setBackgroundColor(0xFF04050A);                 // même vide que la page, pas de flash blanc

        setContentView(web);
        web.loadUrl("file:///android_asset/index.html");    // chargé localement, fonctionne hors ligne
        hideSystemBars();
    }

    /** Plein écran immersif : ni barre d'état, ni barre de navigation. */
    private void hideSystemBars() {
        web.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) hideSystemBars();   // les barres reviennent après un swipe, on les recache
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (web != null) web.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (web != null) web.onResume();
    }
}
