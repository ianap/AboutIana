package com.inc.iana.aboutiana.utils

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.util.regex.Pattern


class HTMLUtils{
    fun getImage(input:String):List<String>{
        val ptrn = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>")
        val match = ptrn.matcher(input)
        val tokens = mutableListOf<String>()

        while (match.find()){
            val token = match.group(1)
            tokens.add(token)
        }
        return  tokens
    }

    fun jsoupUtilText(input:String):String = Jsoup.parse(input).text()

    fun jsoupUtilImage(input:String):Elements = Jsoup.parse(input).select("img")
}
