package br.com.cardoso.util

import javax.ws.rs.core.Response

interface WebTarget {

    fun get(target: String, path:String): Response
}