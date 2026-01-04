package com.huawei.updatesdk.p177a.p186b.p189c.p190c;

import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8785g;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.updatesdk.a.b.c.c.b */
/* loaded from: classes9.dex */
public abstract class AbstractC8799b {
    private static final char COMMA = ',';
    private static final String END_FLAG = "_";
    private static final String TAG = "b";

    /* renamed from: com.huawei.updatesdk.a.b.c.c.b$a */
    public static class a implements PrivilegedAction {

        /* renamed from: a */
        private Field f45111a;

        public a(Field field) {
            this.f45111a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f45111a.setAccessible(true);
            return null;
        }
    }

    private String arrayToJson(Object obj) {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (int i10 = 0; i10 < length; i10++) {
            String strValueToJson = valueToJson(Array.get(obj, i10));
            if (strValueToJson != null) {
                sb2.append(strValueToJson);
                sb2.append(COMMA);
            }
        }
        formatJsonStr(sb2);
        sb2.append("]");
        return sb2.toString();
    }

    private void formatJsonStr(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }

    private boolean isBooleanOrFloat(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Float);
    }

    private boolean isByteOrCharacter(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Character);
    }

    private boolean isByteOrCharacterOrDoubleOrShort(Object obj) {
        return isByteOrCharacter(obj) || isDoubleOrShort(obj);
    }

    private boolean isDoubleOrShort(Object obj) {
        return (obj instanceof Double) || (obj instanceof Short);
    }

    private boolean isIntegerOrLong(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long);
    }

    private boolean isIntegerOrLongOrBooleanOrFloat(Object obj) {
        return isIntegerOrLong(obj) || isBooleanOrFloat(obj);
    }

    private boolean isPrimitiveObj(Object obj) {
        return isIntegerOrLongOrBooleanOrFloat(obj) || isByteOrCharacterOrDoubleOrShort(obj);
    }

    private Object jsonBeanFromJson(Class cls, Object obj) throws JSONException, IllegalAccessException, IllegalArgumentException {
        AbstractC8799b abstractC8799b = (AbstractC8799b) cls.newInstance();
        abstractC8799b.fromJson((JSONObject) obj);
        return abstractC8799b;
    }

    private Object listFromJson(Class cls, Object obj) {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONArray)) {
            throw new IllegalArgumentException("jsonobject is not JSONArray, jsonValue:" + obj);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) obj;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object objValueFromJson = valueFromJson(cls, null, jSONArray.get(i10));
            if (objValueFromJson != null) {
                if (cls.equals(objValueFromJson.getClass())) {
                    arrayList.add(objValueFromJson);
                } else {
                    C8777a.m56028b(TAG, "listFromJson error, memberClass:" + cls + ", valueClass:" + objValueFromJson.getClass());
                }
            }
        }
        return arrayList;
    }

    private Object mapFromJson(Class cls, Object obj) {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONObject)) {
            throw new IllegalArgumentException("jsonobject is not JSONObject, jsonValue:" + obj);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objValueFromJson = valueFromJson(cls, null, jSONObject.get(next));
            if (objValueFromJson != null) {
                if (cls.equals(objValueFromJson.getClass())) {
                    linkedHashMap.put(next, objValueFromJson);
                } else {
                    C8777a.m56028b(TAG, "mapFromJson error, memberClass:" + cls + ", valueClass:" + objValueFromJson.getClass());
                }
            }
        }
        return linkedHashMap;
    }

    private String mapToJson(Map map) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        Iterator it = map.entrySet().iterator();
        while (true) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            String strValueToJson = valueToJson(entry.getValue());
            if (strValueToJson != null) {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                sb2.append(strValueToJson);
            }
            if (!it.hasNext()) {
                sb2.append("}");
                return sb2.toString();
            }
            if (strValueToJson != null) {
                sb2.append(COMMA);
            }
        }
    }

    private void processValueError(Field field, Object obj) throws IllegalAccessException, IllegalArgumentException {
        Object objValueOf;
        if (obj instanceof String) {
            try {
                Class<?> type = field.getType();
                if (type.isPrimitive()) {
                    String name = type.getName();
                    if ("int".equals(name)) {
                        objValueOf = Integer.valueOf(Integer.parseInt((String) obj));
                    } else if ("float".equals(name)) {
                        objValueOf = Float.valueOf(Float.parseFloat((String) obj));
                    } else if ("long".equals(name)) {
                        objValueOf = Long.valueOf(Long.parseLong((String) obj));
                    } else if ("boolean".equals(name)) {
                        objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) obj));
                    } else if ("double".equals(name)) {
                        objValueOf = Double.valueOf(Double.parseDouble((String) obj));
                    } else if ("short".equals(name)) {
                        objValueOf = Short.valueOf(Short.parseShort((String) obj));
                    } else if ("byte".equals(name)) {
                        objValueOf = Byte.valueOf(Byte.parseByte((String) obj));
                    } else if (!"char".equals(name)) {
                        return;
                    } else {
                        objValueOf = Character.valueOf(((String) obj).charAt(0));
                    }
                    field.set(this, objValueOf);
                }
            } catch (IllegalAccessException e10) {
                C8777a.m56028b(TAG, "processValueError Throwable:" + e10.getMessage());
            }
        }
    }

    private Object valueFromJson(Class cls, Class cls2, Object obj) {
        if (cls.isPrimitive() || cls.equals(String.class)) {
            return ("float".equals(cls.getName()) && (obj instanceof Double)) ? Float.valueOf(((Double) obj).floatValue()) : obj;
        }
        if (List.class.isAssignableFrom(cls)) {
            return listFromJson(cls2, obj);
        }
        if (AbstractC8799b.class.isAssignableFrom(cls)) {
            if (!cls.equals(AbstractC8799b.class)) {
                return jsonBeanFromJson(cls, obj);
            }
            throw new IllegalArgumentException("error type, type:" + cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return mapFromJson(cls2, obj);
        }
        throw new IllegalArgumentException("unsupport type, Type:" + cls);
    }

    private String valueToJson(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return JSONObject.quote(obj.toString());
        }
        if (isPrimitiveObj(obj)) {
            return String.valueOf(obj);
        }
        if (obj instanceof AbstractC8799b) {
            return ((AbstractC8799b) obj).toJson();
        }
        if (obj instanceof List) {
            return listToJson((List) obj);
        }
        if (obj instanceof Map) {
            return mapToJson((Map) obj);
        }
        if (obj.getClass().isArray()) {
            return arrayToJson(obj);
        }
        return null;
    }

    public void fromJson(JSONObject jSONObject) throws JSONException, IllegalAccessException, IllegalArgumentException {
        Field[] fieldArrM56063a = AbstractC8785g.m56063a(getClass());
        Object objValueFromJson = null;
        for (int i10 = 0; i10 < fieldArrM56063a.length; i10++) {
            AccessController.doPrivileged(new a(fieldArrM56063a[i10]));
            String name = fieldArrM56063a[i10].getName();
            if (fieldArrM56063a[i10].isAnnotationPresent(SDKNetTransmission.class) || name.endsWith("_")) {
                if (name.endsWith("_")) {
                    name = name.substring(0, name.length() - 1);
                }
                if (jSONObject.has(name)) {
                    Object obj = jSONObject.get(name);
                    if (!JSONObject.NULL.equals(obj)) {
                        try {
                            objValueFromJson = valueFromJson(fieldArrM56063a[i10].getType(), AbstractC8785g.m56060a(fieldArrM56063a[i10]), obj);
                            fieldArrM56063a[i10].set(this, objValueFromJson);
                        } catch (Exception e10) {
                            C8774a.m56008a(TAG, getClass().getName() + ".fromJson error, fieldName:" + name + e10.getMessage());
                            processValueError(fieldArrM56063a[i10], objValueFromJson);
                        }
                    }
                }
            }
        }
    }

    public String listToJson(List list) {
        if (list.size() <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (int i10 = 0; i10 < list.size(); i10++) {
            String strValueToJson = valueToJson(list.get(i10));
            if (strValueToJson != null) {
                sb2.append(strValueToJson);
                sb2.append(COMMA);
            }
        }
        formatJsonStr(sb2);
        sb2.append("]");
        return sb2.toString();
    }

    public String toJson() {
        Field[] fieldArrM56063a = AbstractC8785g.m56063a(getClass());
        if (fieldArrM56063a.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        for (int i10 = 0; i10 < fieldArrM56063a.length; i10++) {
            AccessController.doPrivileged(new a(fieldArrM56063a[i10]));
            String name = fieldArrM56063a[i10].getName();
            if (fieldArrM56063a[i10].isAnnotationPresent(SDKNetTransmission.class) || (name != null && name.endsWith("_"))) {
                if (name.endsWith("_")) {
                    name = name.substring(0, name.length() - 1);
                }
                String strValueToJson = valueToJson(fieldArrM56063a[i10].get(this));
                if (strValueToJson != null) {
                    sb2.append("\"");
                    sb2.append(name);
                    sb2.append("\":");
                    sb2.append(strValueToJson);
                    sb2.append(COMMA);
                }
            }
        }
        formatJsonStr(sb2);
        sb2.append("}");
        return sb2.toString();
    }
}
