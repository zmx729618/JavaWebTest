package org.zwc.enumtest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by zhangwenchao on 2017/10/30.
 */
public class StringToGoodsConverter implements Converter<String, GoodsPromoteEnum> {
    public GoodsPromoteEnum convert(String value) {
        if (StringUtils.isBlank(value)) {
                 return null;
        }
        return GoodsPromoteEnum.get(value);

    }
}
