import org.ntqqrev.saltify.composeidl.Api
import org.ntqqrev.saltify.composeidl.LongType
import org.ntqqrev.saltify.composeidl.StringType
import org.ntqqrev.saltify.composeidl.Struct

val OneBotGroupActionBase = Struct {
    describe("群操作共用参数")

    field("group_id", LongType) {
        // 描述字段，也可以在 field 函数的第三个参数中传入
        describe("群号")
    }
}

val OneBotGroupMemberActionBase = Struct {
    describe("群成员操作共用参数")

    // use 和 extend 都是用来扩展结构体的，二者效果相同
    use(OneBotGroupActionBase)

    field("user_id", LongType, "群成员 QQ 号")
}

val OneBotSetGroupSpecialTitleAction = Api("set_group_special_title") {
    describe("设置群成员专属称号")

    input {
        use(OneBotGroupMemberActionBase)
        field("special_title", StringType, "专属称号")
        field("duration", LongType, "专属称号有效期") {
            optional()
            deprecate("此参数似乎在 QQ 中无效")
        }
    }
}