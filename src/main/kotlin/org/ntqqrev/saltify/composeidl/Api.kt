package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class Api(override val name: String, block: Api.() -> Unit) : Named, Describable by Describable.Impl() {
    var inputStruct: Struct? = null
        private set
    var outputStruct: Struct? = null
        private set

    fun input(block: Struct.() -> Unit) {
        inputStruct = Struct { block() }
    }

    fun input(struct: Struct) {
        inputStruct = struct
    }

    fun output(block: Struct.() -> Unit) {
        outputStruct = Struct { block() }
    }

    fun output(struct: Struct) {
        outputStruct = struct
    }
}