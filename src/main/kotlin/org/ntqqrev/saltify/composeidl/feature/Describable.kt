package org.ntqqrev.saltify.composeidl.feature

interface Describable {
    val description: String?
    val deprecated: Boolean
    val deprecationMessage: String

    fun describe(description: String?)
    fun deprecate(message: String)

    class Impl : Describable {
        override var description: String? = null
            private set
        override var deprecated: Boolean = false
            private set
        override var deprecationMessage: String = ""
            private set

        override fun describe(description: String?) {
            this.description = description
        }

        override fun deprecate(message: String) {
            this.deprecated = true
            this.deprecationMessage = message
        }
    }
}