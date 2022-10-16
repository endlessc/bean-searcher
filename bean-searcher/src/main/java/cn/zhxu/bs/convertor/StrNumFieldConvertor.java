package cn.zhxu.bs.convertor;

import cn.zhxu.bs.implement.DefaultBeanReflector;
import cn.zhxu.bs.FieldConvertor;
import cn.zhxu.bs.FieldMeta;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * [字符串 to 数字] 字段转换器
 * 与 {@link DefaultBeanReflector } 配合使用
 * @author Troy.Zhou @ 2021-11-01
 * @since v3.0.0（v3.8.0 之前在 com.ejlchina.searcher.implement 包下）
 */
public class StrNumFieldConvertor implements FieldConvertor.BFieldConvertor {

    @Override
    public boolean supports(FieldMeta meta, Class<?> valueType) {
        if (valueType == String.class) {
            Class<?> targetType = meta.getType();
            return (
                    targetType == int.class || targetType == Integer.class ||
                    targetType == long.class || targetType == Long.class ||
                    targetType == float.class || targetType == Float.class ||
                    targetType == double.class || targetType == Double.class ||
                    targetType == short.class || targetType == Short.class ||
                    targetType == byte.class || targetType == Byte.class ||
                    targetType == BigDecimal.class || targetType == BigInteger.class
            );
        }
        return false;
    }

    @Override
    public Object convert(FieldMeta meta, Object value) {
        String number = (String) value;
        Class<?> targetType = meta.getType();
        if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(number);
        }
        if (targetType == long.class || targetType == Long.class) {
            return Long.parseLong(number);
        }
        if (targetType == float.class || targetType == Float.class) {
            return Float.parseFloat(number);
        }
        if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(number);
        }
        if (targetType == short.class || targetType == Short.class) {
            return Short.parseShort(number);
        }
        if (targetType == byte.class || targetType == Byte.class) {
            return Byte.parseByte(number);
        }
        if (targetType == BigDecimal.class) {
            return new BigDecimal(number);
        }
        if (targetType == BigInteger.class) {
            return new BigInteger(number);
        }
        throw new IllegalStateException("Unsupported targetType: " + targetType);
    }

}
