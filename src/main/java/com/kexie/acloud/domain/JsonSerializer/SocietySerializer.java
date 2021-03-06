package com.kexie.acloud.domain.JsonSerializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.kexie.acloud.domain.Society;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created : wen
 * DateTime : 2017/4/28 20:56
 * Description :
 */
public class SocietySerializer implements ObjectSerializer{

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        Society value = (Society) object;
        if (value == null)
            return;
        out.writeString(String.valueOf(value.getId()));
        out.writeFieldValue(',', "society_name", value.getName());
    }
}
