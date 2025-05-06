package org.ntqqrev.saltify.composeidl

sealed class Primitive : Type {
    abstract fun toKotlinType(): String
    abstract fun toCSharpType(): String
    abstract fun toJavaScriptType(): String
}

object IntType : Primitive() {
    override fun toKotlinType(): String = "Int"
    override fun toCSharpType(): String = "int"
    override fun toJavaScriptType(): String = "number"
}

object LongType : Primitive() {
    override fun toKotlinType(): String = "Long"
    override fun toCSharpType(): String = "long"
    override fun toJavaScriptType(): String = "bigint"
}

object StringType : Primitive() {
    override fun toKotlinType(): String = "String"
    override fun toCSharpType(): String = "string"
    override fun toJavaScriptType(): String = "string"
}

object BooleanType : Primitive() {
    override fun toKotlinType(): String = "Boolean"
    override fun toCSharpType(): String = "bool"
    override fun toJavaScriptType(): String = "boolean"
}