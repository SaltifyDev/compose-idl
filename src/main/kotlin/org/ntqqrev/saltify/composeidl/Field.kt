package org.ntqqrev.saltify.composeidl

import org.ntqqrev.saltify.composeidl.feature.Describable
import org.ntqqrev.saltify.composeidl.feature.Named

class Field(override val name: String, val type: Type) : Named, Describable by Describable.Impl() {
    var defaultValue: String? = null
        private set
    var sample: String? = null
        private set
    var isOptional: Boolean = false
        private set

    fun default(value: String) {
        defaultValue = value
    }

    fun sample(value: String) {
        sample = value
    }

    fun optional() {
        isOptional = true
    }
}