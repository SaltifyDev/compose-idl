package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class DiscriminatedUnion(
    override val name: String,
    val discriminator: String,
    block: DiscriminatedUnion.() -> Unit
) : Type, Named, Describable by Describable.Impl() {
    private val _structMap: MutableMap<String, Struct> = mutableMapOf()
    val structMap: Map<String, Struct>
        get() = _structMap

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
        _structMap[type] = struct
    }

    fun struct(type: String, name: String, block: Struct.() -> Unit) {
        val struct = Struct(name, block)
        _structMap[type] = struct
    }

    fun struct(type: String, struct: Struct) {
        _structMap[type] = struct
    }
}