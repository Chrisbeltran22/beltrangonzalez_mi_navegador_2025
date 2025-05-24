package sv.edu.ufg.fis.pdm.beltrangonzalez_mi_navegador

import android.app.Activity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Permite que se ejecute el formato HTTP
        val minavegador: WebView = findViewById(R.id.navegador)

        //Hacer que ejecute sitios web
        minavegador.settings.javaScriptEnabled = true

        val actividad: Activity = this
        minavegador.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

                if (url != null){
                    view?.loadUrl(url)
                }
                return true
                //return super.shouldOverrideUrlLoading(view, request)
            }
        }

        minavegador.loadUrl("https://www.ufg.edu.sv")


    }
}