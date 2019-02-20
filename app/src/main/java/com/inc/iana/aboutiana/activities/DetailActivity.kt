package com.inc.iana.aboutiana.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.inc.iana.aboutiana.R
import org.jetbrains.anko.toast
import android.graphics.Bitmap

class DetailActivity : AppCompatActivity() {

    private lateinit var progressBar : ProgressBar
   // private lateinit var toolBar : Toolbar
    private lateinit var webView : WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        progressBar = findViewById(R.id.progressBar)
       // toolBar = findViewById(R.id.toolbar)
        webView = findViewById(R.id.detailView)

       // setSupportActionBar(toolBar)
        webView.visibility= View.INVISIBLE
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient= WebChromeClient()
        webView.webViewClient = object: WebViewClient(){
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?){

            }

            override fun onPageFinished(view: WebView, url: String) {
                progressBar.visibility = View.GONE
                webView.visibility = View.VISIBLE

            }
        }
        webView.loadUrl(intent.getStringExtra("url"))


        //toast(intent.getStringExtra("url"))
    }
}
