package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class DiscriminatedUnion(
    override val name: String,
    val discriminator: String,
    block: DiscriminatedUnion.() -> Unit
) : Type, Named, Describable by Describable.Impl() {
    private val _structList: MutableList<Pair<String, Struct>> = mutableListOf()
    val structList: List<Pair<String, Struct>>
        get() = _structList

    var structInnerKey: String? = null
        private set

    init {
        block()
    }

    fun structPlacedInto(key: String) {
        structInnerKey = key
    }

    fun struct(type: String, block: Struct.() -> Unit) {
        val struct = Struct("struct", block)
        _structList.add(type to struct)
    }

    fun struct(type: String, name: String, block: Struct.() -> Unit) {
        val struct = Struct(name, block)
        _structList.add(type to struct)
    }

    fun struct(type: String, struct: Struct) {
        _structList.add(type to struct)
    }
}