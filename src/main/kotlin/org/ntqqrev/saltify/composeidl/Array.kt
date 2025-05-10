package org.ntqqrev.saltify.composeidl

class Array(val elementType: Type) : Type {
    override fun toString(): String {
        return "array"
    }
}