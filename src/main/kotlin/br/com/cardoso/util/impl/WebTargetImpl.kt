package br.com.cardoso.util.impl

import br.com.cardoso.util.WebTarget
import javax.inject.Singleton
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.Response

@Singleton
class WebTargetImpl : WebTarget {

    override fun get(target: String, path: String): Response {
        return ClientBuilder.newClient().target(target).path(path).request().get()
    }
}