package com.inc.iana.aboutiana.utils

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
}
