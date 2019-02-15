package com.inc.iana.aboutiana.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.inc.iana.aboutiana.R
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        toast(intent.getStringExtra("url"))
    }
}
