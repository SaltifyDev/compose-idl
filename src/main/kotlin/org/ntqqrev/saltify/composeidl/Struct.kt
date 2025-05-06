package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable

class Struct(val name: String = "struct", block: Struct.() -> Unit) : Type, Describable by Describable.Impl() {
    private val _fields = mutableListOf<Field>()
    val fields: List<Field>
        get() = _fields

    init {
        block()
    }

    fun field(name: String, type: Type, block: Field.() -> Unit) {
        val field = Field(name, type)
        field.block()
        _fields.add(field)
    }

    fun field(name: String, type: Type): Field {
        val field = Field(name, type)
        _fields.add(field)
        return field
    }

    fun field(name: String, type: Type, description: String) {
        val field = Field(name, type)
        field.describe(description)
        _fields.add(field)
    }

    fun field(name: String, type: Type, description: String, block: Field.() -> Unit) {
        val field = Field(name, type)
        field.describe(description)
        field.block()
        _fields.add(field)
    }

    fun extend(block: Struct.() -> Unit) : Struct {
        val struct = Struct {}
        _fields.addAll(struct.fields)
        struct.block()
        return struct
    }

    fun use(struct: Struct) {
        _fields.addAll(struct.fields)
    }
}