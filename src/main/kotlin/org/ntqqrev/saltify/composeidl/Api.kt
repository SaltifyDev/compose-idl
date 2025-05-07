package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class Api(override val name: String, block: Api.() -> Unit) : Named, Describable by Describable.Impl() {
    var inputStruct: Struct? = null
        private set
    var outputType: Type? = null
        private set

    init {
        block()
    }

    fun input(block: Struct.() -> Unit) {
        inputStruct = Struct { block() }
    }

    fun input(struct: Struct) {
        inputStruct = struct
    }

    fun output(block: Struct.() -> Unit) {
        outputType = Struct { block() }
    }

    fun output(struct: Struct) {
        outputType = struct
    }

    fun outputArray(elementBlock: Struct.() -> Unit) {
        val elementStruct = Struct { elementBlock() }
        outputType = Array(elementStruct)
    }

    fun outputArray(type: Type) {
        outputType = Array(type)
    }
}