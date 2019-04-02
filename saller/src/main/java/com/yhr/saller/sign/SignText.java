package com.yhr.saller.sign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yhr.util.JsonUtil;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.sign
 * @Author: yang
 * @CreateTime: 2019-03-28 14:46
 * @Description: 签名明文
 */


/**
 * 一般约定加密的对象时 要对非空属性进行排序后再加密
 * 如果属性前后不同 验证不通过
 * 如果为空 或者空字符串 验证也不通过
 * 所以要进行约定而加以下两个注解
 */

@JsonInclude(JsonInclude.Include.NON_NULL) //不显示null
@JsonPropertyOrder(alphabetic = true)
/**
 *作用在类上，被用来指明当序列化时需要对属性做排序，它有2个属性
 * 一个是alphabetic：布尔类型，表示是否采用字母拼音顺序排序，默认是为false，即不排序
 */
public interface SignText {

    default String toText(){
        return JsonUtil.toJson(this);
    }
}

