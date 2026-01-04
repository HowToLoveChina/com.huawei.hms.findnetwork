package com.huawei.hianalytics.framework.utils;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.C4755b;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class JsonUtils {

    /* renamed from: a */
    public static final Class[] f21818a = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Character.class, Boolean.class};

    /* renamed from: b */
    public static final Class[] f21819b = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Boolean.class};

    /* renamed from: c */
    public static final Map<Class, InterfaceC4775h> f21820c;

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$a */
    public static class C4768a implements InterfaceC4775h<Boolean, Object> {
        @Override // com.huawei.hianalytics.framework.utils.JsonUtils.InterfaceC4775h
        /* renamed from: a */
        public Boolean mo28885a(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
            return null;
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$b */
    public static class C4769b implements InterfaceC4775h<Byte, Number> {
        @Override // com.huawei.hianalytics.framework.utils.JsonUtils.InterfaceC4775h
        /* renamed from: a */
        public Byte mo28885a(Number number) {
            return Byte.valueOf(number.byteValue());
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$c */
    public static class C4770c implements InterfaceC4775h<Double, Number> {
        @Override // com.huawei.hianalytics.framework.utils.JsonUtils.InterfaceC4775h
        /* renamed from: a */
        public Double mo28885a(Number number) {
            return Double.valueOf(number.doubleValue());
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$d */
    public static class C4771d implements InterfaceC4775h<Float, Number> {
        @Override // com.huawei.hianalytics.framework.utils.JsonUtils.InterfaceC4775h
        /* renamed from: a */
        public Float mo28885a(Number number) {
            return Float.valueOf(number.floatValue());
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$e */
    public static class C4772e implements InterfaceC4775h<Integer, Number> {
        @Override // com.huawei.hianalytics.framework.utils.JsonUtils.InterfaceC4775h
        /* renamed from: a */
        public Integer mo28885a(Number number) {
            return Integer.valueOf(number.intValue());
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$f */
    public static class C4773f implements InterfaceC4775h<Long, Number> {
        @Override // com.huawei.hianalytics.framework.utils.JsonUtils.InterfaceC4775h
        /* renamed from: a */
        public Long mo28885a(Number number) {
            return Long.valueOf(number.longValue());
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$g */
    public static class C4774g implements InterfaceC4775h<Short, Number> {
        @Override // com.huawei.hianalytics.framework.utils.JsonUtils.InterfaceC4775h
        /* renamed from: a */
        public Short mo28885a(Number number) {
            return Short.valueOf(number.shortValue());
        }
    }

    /* renamed from: com.huawei.hianalytics.framework.utils.JsonUtils$h */
    public interface InterfaceC4775h<D, S> {
        /* renamed from: a */
        D mo28885a(S s10);
    }

    static {
        HashMap map = new HashMap();
        f21820c = map;
        C4772e c4772e = new C4772e();
        map.put(Integer.TYPE, c4772e);
        map.put(Integer.class, c4772e);
        C4773f c4773f = new C4773f();
        map.put(Long.TYPE, c4773f);
        map.put(Long.class, c4773f);
        C4771d c4771d = new C4771d();
        map.put(Float.TYPE, c4771d);
        map.put(Float.class, c4771d);
        C4770c c4770c = new C4770c();
        map.put(Double.TYPE, c4770c);
        map.put(Double.class, c4770c);
        C4774g c4774g = new C4774g();
        map.put(Short.TYPE, c4774g);
        map.put(Short.class, c4774g);
        C4769b c4769b = new C4769b();
        map.put(Byte.TYPE, c4769b);
        map.put(Byte.class, c4769b);
        C4768a c4768a = new C4768a();
        map.put(Boolean.TYPE, c4768a);
        map.put(Boolean.class, c4768a);
    }

    /* renamed from: a */
    public static <T> T m28870a(JSONArray jSONArray, Class<T> cls, Class[] clsArr) throws JSONException {
        if (List.class.isAssignableFrom(cls)) {
            return (T) m28876a(cls, (clsArr == null || clsArr.length <= 0) ? null : clsArr[0], jSONArray);
        }
        throw m28878a("obj class (%s) is not List type", cls);
    }

    /* renamed from: b */
    public static String m28883b(Object obj) throws JSONException, SecurityException {
        if (obj == null) {
            return "";
        }
        m28879a((Class) obj.getClass());
        if (obj instanceof List) {
            return m28874a((List) obj);
        }
        if (obj instanceof Map) {
            return m28875a((Map) obj);
        }
        Field[] fieldArrM28842a = C4755b.m28842a(obj.getClass());
        if (fieldArrM28842a.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        int length = fieldArrM28842a.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field field = fieldArrM28842a[i10];
            field.setAccessible(true);
            fieldArrM28842a[i10] = field;
            if (m28881a(field)) {
                String name = fieldArrM28842a[i10].getName();
                String strM28884c = m28884c(fieldArrM28842a[i10].get(obj));
                if (strM28884c != null) {
                    sb2.append('\"');
                    sb2.append(name);
                    sb2.append("\":");
                    sb2.append(strM28884c);
                    if (i10 < length - 1) {
                        sb2.append(',');
                    }
                }
            }
        }
        m28880a(sb2);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: c */
    public static String m28884c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof String) && !(obj instanceof Character)) {
            return ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Double) || (obj instanceof Short)) ? obj.toString() : obj instanceof List ? m28874a((List) obj) : obj instanceof Map ? m28875a((Map) obj) : obj.getClass().isArray() ? m28873a(obj) : m28883b(obj);
        }
        String string = obj.toString();
        if (string == null || string.trim().isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\"");
        String string2 = obj.toString();
        sb2.append(string2 != null ? string2.replace("\"", "\\\"") : null);
        sb2.append("\"");
        return sb2.toString();
    }

    public static String createABReqDefaultJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JsbMapKeyNames.H5_USER_ID, "");
            jSONObject.put("userAttribute", new JSONObject());
        } catch (Exception unused) {
            HiLog.m28808e("JsonUtils", "json exception");
        }
        return jSONObject.toString();
    }

    public static JSONObject put(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
            HiLog.m28808e("JsonUtils", "putJson exception");
        }
        return jSONObject;
    }

    public static String toJsonNoException(Object obj) throws JSONException {
        try {
            try {
                try {
                    return m28883b(obj);
                } catch (JSONException e10) {
                    throw e10;
                }
            } catch (IllegalAccessException unused) {
                throw m28878a("toJson error", new Object[0]);
            }
        } catch (JSONException unused2) {
            HiLog.m28812w("JsonUtils", "toJson error");
            return "";
        }
    }

    public static <T> T toObjectNoException(String str, Class<T> cls, Class... clsArr) {
        try {
            return (T) m28869a(str, cls, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m28871a(JSONObject jSONObject, Class<T> cls, Class[] clsArr) throws JSONException {
        if (Collection.class.isAssignableFrom(cls)) {
            throw m28878a("class %s is Collection type which mismatches with JsonObject", cls);
        }
        if (cls.isArray()) {
            throw m28878a("obj class %s is array type which mismatches with JsonObject", cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return (T) m28877a(cls, clsArr, jSONObject);
        }
        try {
            return (T) m28872a(jSONObject, cls.getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            throw m28878a("new instance failed for %s", cls);
        } catch (NoSuchMethodException unused2) {
            throw m28878a("no default constructor for class %s", cls);
        }
    }

    /* renamed from: a */
    public static String m28873a(Object obj) {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < length; i10++) {
            String strM28884c = m28884c(Array.get(obj, i10));
            if (strM28884c != null) {
                sb2.append(strM28884c);
                sb2.append(',');
            }
        }
        m28880a(sb2);
        sb2.append(']');
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m28874a(List list) {
        if (list.size() <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strM28884c = m28884c(list.get(i10));
            if (strM28884c != null) {
                sb2.append(strM28884c);
                sb2.append(',');
            }
        }
        m28880a(sb2);
        sb2.append(']');
        return sb2.toString();
    }

    /* renamed from: b */
    public static Object m28882b(Class cls, Class cls2, Object obj) throws JSONException {
        InterfaceC4775h interfaceC4775h;
        StringBuilder sb2;
        if (!cls.isPrimitive()) {
            for (Class cls3 : f21819b) {
                if (cls != cls3) {
                }
            }
            if (List.class.isAssignableFrom(cls)) {
                return m28876a(cls, cls2, obj);
            }
            if (Map.class.isAssignableFrom(cls)) {
                return m28877a(cls, new Class[]{cls2}, obj);
            }
            if (obj instanceof JSONObject) {
                return m28871a((JSONObject) obj, cls, new Class[]{cls2});
            }
            if (obj instanceof JSONArray) {
                return m28870a((JSONArray) obj, cls, new Class[]{cls2});
            }
            throw m28878a("value from json error, field class: %s", cls);
        }
        if (cls == String.class) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj != null) {
                return String.valueOf(obj);
            }
        } else {
            if ((cls.isPrimitive() || Number.class.isAssignableFrom(cls)) && (obj instanceof Number)) {
                obj = (Number) obj;
                interfaceC4775h = f21820c.get(cls);
                if (interfaceC4775h == null) {
                    sb2 = new StringBuilder();
                    sb2.append("cannot find value reader for: %s");
                    sb2.append(cls);
                    HiLog.m28812w("JsonUtils", sb2.toString());
                }
                return interfaceC4775h.mo28885a(obj);
            }
            if (cls != Boolean.class) {
                return obj;
            }
            interfaceC4775h = f21820c.get(cls);
            if (interfaceC4775h == null) {
                sb2 = new StringBuilder();
                sb2.append("cannot find value reader for: %s");
                sb2.append(cls);
                HiLog.m28812w("JsonUtils", sb2.toString());
            }
            return interfaceC4775h.mo28885a(obj);
        }
        return null;
    }

    /* renamed from: a */
    public static String m28875a(Map map) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        Set<Map.Entry> setEntrySet = map.entrySet();
        int size = setEntrySet.size();
        int i10 = 0;
        for (Map.Entry entry : setEntrySet) {
            i10++;
            String str = (String) entry.getKey();
            String strM28884c = m28884c(entry.getValue());
            if (strM28884c != null) {
                sb2.append('\"');
                sb2.append(str);
                sb2.append("\":");
                sb2.append(strM28884c);
            }
            if (i10 < size && strM28884c != null) {
                sb2.append(',');
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: a */
    public static List m28876a(Class cls, Class cls2, Object obj) throws JSONException {
        List arrayList;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (!(obj instanceof JSONArray)) {
            throw m28878a("jsonobject is not JSONArray", new Object[0]);
        }
        if (cls == List.class) {
            arrayList = new ArrayList();
        } else {
            if (!List.class.isAssignableFrom(cls)) {
                throw m28878a("%s is not List type", cls);
            }
            try {
                arrayList = (List) cls.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
                throw m28878a("fail to initiate %s", cls);
            }
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object objM28882b = m28882b(cls2, null, jSONArray.get(i10));
            if (objM28882b != null) {
                if (cls2.isAssignableFrom(objM28882b.getClass())) {
                    arrayList.add(objM28882b);
                } else {
                    HiLog.m28808e("JsonUtils", "listFromJson error, memberClass:" + cls2 + ", valueClass:" + objM28882b.getClass());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map m28877a(Class cls, Class[] clsArr, Object obj) throws JSONException {
        Map linkedHashMap;
        if (clsArr == null) {
            clsArr = new Class[]{String.class};
        }
        if (!(obj instanceof JSONObject)) {
            throw m28878a("jsonValue is not JSONObject", new Object[0]);
        }
        if (cls == Map.class) {
            linkedHashMap = new LinkedHashMap();
        } else {
            if (!Map.class.isAssignableFrom(cls)) {
                throw m28878a("%s is not Map type", cls);
            }
            try {
                linkedHashMap = (Map) cls.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
                throw m28878a("fail to initiate %s", cls);
            }
        }
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objM28882b = clsArr.length == 1 ? m28882b(clsArr[0], null, jSONObject.get(next)) : m28882b(clsArr[0], clsArr[1], jSONObject.get(next));
            if (objM28882b != null) {
                if (clsArr[0].isAssignableFrom(objM28882b.getClass())) {
                    linkedHashMap.put(next, objM28882b);
                } else {
                    HiLog.m28808e("JsonUtils", "mapFromJson error, memberClass:" + clsArr + ", valueClass:" + objM28882b.getClass());
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static void m28879a(Class cls) throws JSONException {
        if (cls.isPrimitive()) {
            throw m28878a("obj class (%s) cannot be primitive type", cls);
        }
        for (Class cls2 : f21818a) {
            if (cls == cls2) {
                throw m28878a("obj class (%s) is invalid in conversion", cls);
            }
        }
    }

    /* renamed from: a */
    public static void m28880a(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }

    /* renamed from: a */
    public static boolean m28881a(Field field) {
        if (field != null) {
            return (Modifier.isStatic(field.getModifiers()) || field.getName().contains("$")) ? false : true;
        }
        return false;
    }

    /* renamed from: a */
    public static <T> T m28872a(JSONObject jSONObject, T t10) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Object objOpt;
        Object objM28882b;
        Object objValueOf;
        for (Field field : C4755b.m28842a(t10.getClass())) {
            field.setAccessible(true);
            if (m28881a(field) && (objOpt = jSONObject.opt(field.getName())) != null && objOpt != JSONObject.NULL) {
                try {
                    try {
                        objM28882b = m28882b(field.getType(), C4755b.m28834a(field), objOpt);
                    } catch (RuntimeException unused) {
                        HiLog.m28812w("JsonUtils", t10.getClass().getName() + ".fromJson runtime exception, fieldName: " + field.getName() + ", field: " + field);
                    }
                } catch (Exception unused2) {
                    objM28882b = null;
                }
                try {
                    field.set(t10, objM28882b);
                } catch (Exception unused3) {
                    HiLog.m28812w("JsonUtils", t10.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + field);
                    if (objM28882b != null && (objM28882b instanceof String)) {
                        try {
                            Class<?> type = field.getType();
                            if (type.isPrimitive()) {
                                if (type == Integer.TYPE) {
                                    objValueOf = Integer.valueOf(Integer.parseInt((String) objM28882b));
                                } else if (type == Float.TYPE) {
                                    objValueOf = Float.valueOf(Float.parseFloat((String) objM28882b));
                                } else if (type == Long.TYPE) {
                                    objValueOf = Long.valueOf(Long.parseLong((String) objM28882b));
                                } else if (type == Boolean.TYPE) {
                                    objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) objM28882b));
                                } else if (type == Double.TYPE) {
                                    objValueOf = Double.valueOf(Double.parseDouble((String) objM28882b));
                                } else if (type == Short.TYPE) {
                                    objValueOf = Short.valueOf(Short.parseShort((String) objM28882b));
                                } else if (type == Byte.TYPE) {
                                    objValueOf = Byte.valueOf(Byte.parseByte((String) objM28882b));
                                } else if (type == Character.TYPE) {
                                    objValueOf = Character.valueOf(((String) objM28882b).charAt(0));
                                }
                                field.set(t10, objValueOf);
                            }
                        } catch (Throwable unused4) {
                            HiLog.m28808e("JsonUtils", "processValueError");
                        }
                    }
                }
            }
        }
        return t10;
    }

    /* renamed from: a */
    public static JSONException m28878a(String str, Object... objArr) {
        String str2 = String.format(Locale.ENGLISH, str, objArr);
        HiLog.m28812w("JsonUtils", str2);
        return new JSONException(str2);
    }

    /* renamed from: a */
    public static <T> T m28869a(String str, Class<T> cls, Class... clsArr) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            m28879a((Class) cls);
            try {
                try {
                    return (T) m28871a(new JSONObject(str), cls, clsArr);
                } catch (JSONException unused) {
                    throw m28878a("string cannot be empty", new Object[0]);
                }
            } catch (JSONException unused2) {
                return (T) m28870a(new JSONArray(str), cls, clsArr);
            }
        }
        throw new JSONException(String.format(Locale.ENGLISH, "string cannot be empty", new Object[0]));
    }
}
