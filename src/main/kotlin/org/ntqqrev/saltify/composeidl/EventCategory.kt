package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class EventCategory(override val name: String, block: EventCategory.() -> Unit) :
    Named, Describable by Describable.Impl() {
    private val _eventStructList: MutableList<Struct> = mutableListOf()
    val eventStructList: List<Struct>
        get() = _eventStructList

    init {
        block()
    }

    fun event(name: String, block: Struct.() -> Unit) {
        val eventStruct = Struct(name, block)
        _eventStructList.add(eventStruct)
    }

    fun event(eventStruct: Struct) {
        _eventStructList.add(eventStruct)
    }
}