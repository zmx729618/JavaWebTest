package org.zwc.ssm.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * Created by zhangwenchao on 2017/11/6.
 */
public class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {


    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnum(targetType);
    }




    private class StringToEnum<T extends Enum> implements Converter<String, T> {

        private final Class<T> enumType;

        public StringToEnum(Class<T> enumType) {
            this.enumType = enumType;
        }

        public T convert(String source) {
            if (source.length() == 0) {
                return null;
            }
            return (T) Enum.valueOf(this.enumType, source.trim());
        }
    }




}
