package com.example.heroesofearth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyWebViewClient extends WebViewClient {

    private String sourceName;
    private ProgressBar progressBar;
    private Activity activity;

    private boolean isErrorDisplayed;

    public MyWebViewClient(Activity activity, String sourceName, ProgressBar progressBar) {
        this.sourceName = sourceName;
        this.progressBar = progressBar;
        this.activity = activity;

        isErrorDisplayed = false;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();
        // removing spaces from url
        url = url.replaceAll(" ", "");
        url = url.toLowerCase();
        if (url.contains(sourceName)) {
            return false;
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        progressBar.setVisibility(View.GONE);
        super.onPageFinished(view, url);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        if (!isErrorDisplayed) {
            Toast.makeText(activity, error.getDescription().toString(), Toast.LENGTH_LONG).show();
            isErrorDisplayed = true;
        }
    }

}
