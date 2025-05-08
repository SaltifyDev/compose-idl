package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class StructCategory(override val name: String, block: StructCategory.() -> Unit) :
    Named, Describable by Describable.Impl() {
    private val _structList: MutableList<Struct> = mutableListOf()
    val structList: List<Struct>
        get() = _structList

    init {
        block()
    }

    fun struct(name: String, block: Struct.() -> Unit) {
        val eventStruct = Struct(name, block)
        _structList.add(eventStruct)
    }

    fun struct(eventStruct: Struct) {
        _structList.add(eventStruct)
    }
}