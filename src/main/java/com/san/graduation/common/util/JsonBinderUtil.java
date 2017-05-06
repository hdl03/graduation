package com.san.graduation.common.util;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.san.graduation.common.constants.DateConstant;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;


/**
 * JSON与JAVA对象之间转换的工具类
 * <p>
 * ClassName: JsonBinderUtil <br/>
 * Function: ADD FUNCTION. <br/>
 * Reason: ADD REASON(可选). <br/>
 * date: 2016年11月30日 上午10:37:39 <br/>
 *
 * @author huangdongliang
 * @since JDK 1.8
 */
public final class JsonBinderUtil {

    /**
     * @Fields instance: 创建输出值不为空的属性到Json字符串的Binder
     */
    @SuppressWarnings("unused")
    private static JsonBinderUtil instance = new JsonBinderUtil(Include.NON_EMPTY);

    private static ObjectMapper mapper;

    private JsonBinderUtil(Include include) {
        mapper = new ObjectMapper();
        // 设置输出时包含属性的风格
        mapper.setSerializationInclusion(include);
        // 序列化时，忽略空的bean(即沒有任何Field)
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 序列化时，忽略在JSON字符串中存在但Java对象实际没有的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

    }

    /**
     * @param object
     * @return
     * @Description 对象转换成json字符串。Object可以是POJO，也可以是Collection或数组。 如果对象为Null,
     * 返回"null"。如果集合为空集合, 返回"[]"
     * <p>
     * TODO 异常抛出
     */
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            Logger.error(JsonBinderUtil.class, "JsonProcessingException exception", e);
            return null;
        }
    }


    /**
     * 将JSON字符串转换成对象T
     *
     * @param <T>
     * @param jsonString
     * @param clazz
     * @return TODO 异常抛出
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (jsonString == null || "".equals(jsonString.trim())) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            Logger.error(JsonBinderUtil.class, "IOException exception", e);
            return null;
        }
    }

    /**
     * 获取JavaType对象
     * <p>
     * getCollectionType:(这里用一句话描述这个方法的作用). <br/>
     * (这里描述这个方法适用条件 – 可选).<br/>
     * (这里描述这个方法的执行流程 – 可选).<br/>
     * (这里描述这个方法的使用方法 – 可选).<br/>
     * (这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @param collectionClass
     * @param elementClasses
     * @return
     * @author zengxinyan
     * @since JDK 1.8
     */
    @SuppressWarnings("deprecation")
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 根据JAVATYPE去转换JSON字符串为LIST对象
     * <p>
     * fromJsonToListByType:(这里用一句话描述这个方法的作用). <br/>
     * (这里描述这个方法适用条件 – 可选).<br/>
     * (这里描述这个方法的执行流程 – 可选).<br/>
     * (这里描述这个方法的使用方法 – 可选).<br/>
     * (这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @param jsonString
     * @param clazz
     * @return
     * @author zengxinyan
     * @since JDK 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> fromJsonToListByType(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        //如果是ArrayList<YourBean>那么使用ObjectMapper 的getTypeFactory().constructParametricType(collectionClass, elementClasses);
        //如果是HashMap<String,YourBean>那么 ObjectMapper 的getTypeFactory().constructParametricType(HashMap.class,String.class, YourBean.class);

        try {
            return (List<T>) mapper.readValue(jsonString, getCollectionType(Collection.class, clazz));
        } catch (IOException e) {
            Logger.error(JsonBinderUtil.class, "IOException exception", e);
            return null;
        }

    }

    /**
     * 利用com.alibaba.fastjson.JSONArray包将json字符串转为list对象
     * <p>
     * fromJsonToListByParseArray:(这里用一句话描述这个方法的作用). <br/>
     * (这里描述这个方法适用条件 – 可选).<br/>
     * (这里描述这个方法的执行流程 – 可选).<br/>
     * (这里描述这个方法的使用方法 – 可选).<br/>
     * (这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @param jsonString
     * @param clazz
     * @return
     * @author zengxinyan
     * @since JDK 1.8
     */
    public static <T> List<T> fromJsonToListByParseArray(String jsonString, Class<T> clazz) {
        return JSONArray.parseArray(jsonString, clazz);
    }

    /**
     * 将json字符串转换为java的list对象
     * <p>
     * fromJsontolist:(这里用一句话描述这个方法的作用). <br/>
     * (这里描述这个方法适用条件 – 可选).<br/>
     * (这里描述这个方法的执行流程 – 可选).<br/>
     * (这里描述这个方法的使用方法 – 可选).<br/>
     * (这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @param jsonString
     * @param typeReference
     * @return
     * @author zengxinyan
     * @since JDK 1.8
     */
    public static <T> T fromJsontolist(String jsonString, TypeReference<T> typeReference) {
        if (jsonString == null || "".equals(jsonString.trim())) {
            return null;
        }

        try {
            //这个比较单一，前台换一种日期格式就出错了
            mapper.setDateFormat(new SimpleDateFormat(DateConstant.DATE_PATTERN));
            return mapper.readValue(jsonString, typeReference);
        } catch (IOException e) {
            e.printStackTrace();

            try {
                mapper.setDateFormat(new SimpleDateFormat(DateConstant.DATE_PATTERN_YMD));
                return mapper.readValue(jsonString, typeReference);
            } catch (IOException ee) {
                Logger.error(JsonBinderUtil.class, "IOException exception", e);
                return null;
            }

        }
    }

}
