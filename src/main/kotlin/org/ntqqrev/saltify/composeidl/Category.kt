package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class Category(override val name: String, block: Category.() -> Unit) :
    Named, Describable by Describable.Impl() {
    private val _apiList: MutableList<Api> = mutableListOf()
    val apiList: List<Api>
        get() = _apiList

    init {
        block()
    }

    fun api(name: String, block: Api.() -> Unit) {
        val api = Api(name, block)
        _apiList.add(api)
    }

    fun api(api: Api) {
        _apiList.add(api)
    }
}