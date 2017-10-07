package com.study.www.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
//对象和redis存储二进制得转化
public class RedisObjectSerializer implements RedisSerializer<Object> {
    private Converter<Object,byte[]> serializer=new SerializingConverter();//序列化
    private Converter<byte[], Object> deserializer = new DeserializingConverter();//反序列化
    static final byte[] EMPTY_APPAY=new byte[0];

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)){
            return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            throw  new SerializationException("Cannot deserialize", e);
        }
    }

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o==null){
            return  EMPTY_APPAY;
        }
        try {
            return serializer.convert(o);
        } catch (Exception e) {
           return EMPTY_APPAY;
        }
    }
    boolean isEmpty(byte[] data){
        return (data==null||data.length==0);
    }

}
