package com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean;

import com.huawei.hms.network.embedded.C6010m7;
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
import p708vh.AbstractC13445a;
import th.C13012a;

/* loaded from: classes4.dex */
public abstract class JsonBean {

    /* renamed from: com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean$a */
    public static class C4572a implements PrivilegedAction<Field> {

        /* renamed from: a */
        public Field f21009a;

        /* renamed from: b */
        public boolean f21010b;

        public C4572a(Field field, boolean z10) {
            this.f21009a = field;
            this.f21010b = z10;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a */
        public Field run() throws SecurityException {
            this.f21009a.setAccessible(this.f21010b);
            return this.f21009a;
        }
    }

    public static String arrayToJson(Array array) {
        int length = Array.getLength(array);
        if (length <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (int i10 = 0; i10 < length; i10++) {
            String strM28062d = m28062d(Array.get(array, i10));
            if (strM28062d != null) {
                sb2.append(strM28062d);
                sb2.append(',');
            }
        }
        m28063f(sb2);
        sb2.append("]");
        return sb2.toString();
    }

    /* renamed from: d */
    public static String m28062d(Object obj) {
        if (obj == null) {
            return "\"null\"";
        }
        if (obj instanceof String) {
            return "\"" + obj.toString() + "\"";
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Short)) {
            return String.valueOf(obj);
        }
        if (obj instanceof JsonBean) {
            return ((JsonBean) obj).toJson();
        }
        if (obj instanceof List) {
            return listToJson((List) obj);
        }
        if (obj instanceof Map) {
            return mapToJson((Map) obj);
        }
        if (obj.getClass().isArray()) {
            return arrayToJson((Array) obj);
        }
        return null;
    }

    /* renamed from: f */
    public static void m28063f(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }

    public static String listToJson(List list) {
        if (list.size() <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (int i10 = 0; i10 < list.size(); i10++) {
            String strM28062d = m28062d(list.get(i10));
            if (strM28062d != null) {
                sb2.append(strM28062d);
                sb2.append(',');
            }
        }
        m28063f(sb2);
        sb2.append("]");
        return sb2.toString();
    }

    public static String mapToJson(Map map) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        Iterator it = map.entrySet().iterator();
        while (true) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            String strM28062d = m28062d(entry.getValue());
            if (strM28062d != null) {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                sb2.append(strM28062d);
            }
            if (!it.hasNext()) {
                sb2.append("}");
                return sb2.toString();
            }
            if (strM28062d != null) {
                sb2.append(',');
            }
        }
    }

    /* renamed from: a */
    public final Object m28064a(Class cls, Class cls2, Object obj) {
        if (cls.isPrimitive() || String.class.toString().equals(cls.toString())) {
            return ("float".equals(cls.getName()) && (obj instanceof Double)) ? Float.valueOf(((Double) obj).floatValue()) : obj;
        }
        if (List.class.isAssignableFrom(cls)) {
            return m28065c(cls2, obj);
        }
        if (JsonBean.class.isAssignableFrom(cls)) {
            if (!cls.toString().equals(JsonBean.class.toString())) {
                return m28069i(cls, obj);
            }
            throw new IllegalArgumentException("error type, type:" + cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return m28068h(cls2, obj);
        }
        throw new IllegalArgumentException("unsupport type, Type:" + cls);
    }

    /* renamed from: c */
    public Object m28065c(Class cls, Object obj) {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONArray)) {
            throw new IllegalArgumentException("jsonobject is not JSONArray, jsonValue:" + obj);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) obj;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object objM28064a = m28064a(cls, null, jSONArray.get(i10));
            if (objM28064a != null) {
                if (objM28064a.getClass().toString().equals(cls.toString())) {
                    arrayList.add(objM28064a);
                } else {
                    C13012a.m78317c("JsonBean", "listFromJson error, memberClass:" + cls + ", valueClass:" + objM28064a.getClass());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public final Field m28066e(Field field, boolean z10) {
        return (Field) AccessController.doPrivileged(new C4572a(field, z10));
    }

    public void fromJson(JSONObject jSONObject) throws JSONException, IllegalAccessException, IllegalArgumentException {
        StringBuilder sb2;
        String str;
        Field[] fieldArrM80776c = AbstractC13445a.m80776c(getClass());
        Object objM28064a = null;
        for (int i10 = 0; i10 < fieldArrM80776c.length; i10++) {
            Field field = fieldArrM80776c[i10];
            String name = field.getName();
            if (fieldArrM80776c[i10].isAnnotationPresent(InstallerNetTransmission.class) && jSONObject.has(name)) {
                Object obj = jSONObject.get(name);
                if (!JSONObject.NULL.equals(obj)) {
                    boolean zIsAccessible = field.isAccessible();
                    Field fieldM28066e = m28066e(field, true);
                    try {
                        objM28064a = m28064a(fieldM28066e.getType(), AbstractC13445a.m80774a(fieldM28066e), obj);
                        fieldArrM80776c[i10].set(this, objM28064a);
                    } catch (ClassNotFoundException e10) {
                        e = e10;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error ClassNotFoundException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        C13012a.m78316b("JsonBean", sb2.toString(), e);
                        m28067g(fieldM28066e, objM28064a);
                        m28066e(fieldM28066e, zIsAccessible);
                    } catch (IllegalAccessException e11) {
                        e = e11;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error IllegalAccessException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        C13012a.m78316b("JsonBean", sb2.toString(), e);
                        m28067g(fieldM28066e, objM28064a);
                        m28066e(fieldM28066e, zIsAccessible);
                    } catch (IllegalArgumentException e12) {
                        e = e12;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error IllegalArgumentException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        C13012a.m78316b("JsonBean", sb2.toString(), e);
                        m28067g(fieldM28066e, objM28064a);
                        m28066e(fieldM28066e, zIsAccessible);
                    } catch (InstantiationException e13) {
                        e = e13;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error InstantiationException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        C13012a.m78316b("JsonBean", sb2.toString(), e);
                        m28067g(fieldM28066e, objM28064a);
                        m28066e(fieldM28066e, zIsAccessible);
                    } catch (JSONException unused) {
                        C13012a.m78317c("JsonBean", getClass().getName() + ".fromJson error JSONException, fieldName:" + name + " :JSONException");
                        m28067g(fieldM28066e, objM28064a);
                        m28066e(fieldM28066e, zIsAccessible);
                    }
                    m28066e(fieldM28066e, zIsAccessible);
                }
            }
        }
    }

    /* renamed from: g */
    public final void m28067g(Field field, Object obj) {
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
            } catch (Throwable unused) {
                C13012a.m78317c("JsonBean", "processValueError error!");
            }
        }
    }

    /* renamed from: h */
    public Object m28068h(Class cls, Object obj) {
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
            Object objM28064a = m28064a(cls, null, jSONObject.get(next));
            if (objM28064a != null) {
                if (objM28064a.getClass().toString().equals(cls.toString())) {
                    linkedHashMap.put(next, objM28064a);
                } else {
                    C13012a.m78317c("JsonBean", "mapFromJson error, memberClass:" + cls + ", valueClass:" + objM28064a.getClass());
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: i */
    public final Object m28069i(Class cls, Object obj) throws JSONException, IllegalAccessException, IllegalArgumentException {
        JsonBean jsonBean = (JsonBean) cls.newInstance();
        jsonBean.fromJson((JSONObject) obj);
        return jsonBean;
    }

    public String toJson() {
        Object obj;
        Field[] fieldArrM80776c = AbstractC13445a.m80776c(getClass());
        if (fieldArrM80776c.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        for (int i10 = 0; i10 < fieldArrM80776c.length; i10++) {
            Field field = fieldArrM80776c[i10];
            String name = field.getName();
            if (field.isAnnotationPresent(InstallerNetTransmission.class)) {
                boolean zIsAccessible = field.isAccessible();
                Field fieldM28066e = m28066e(field, true);
                try {
                    try {
                        obj = fieldM28066e.get(this);
                    } catch (IllegalAccessException unused) {
                        C13012a.m78317c("JsonBean", "can not access");
                        m28066e(fieldM28066e, zIsAccessible);
                        obj = null;
                    }
                    String strM28062d = m28062d(obj);
                    if (strM28062d != null) {
                        sb2.append("\"");
                        sb2.append(name);
                        sb2.append("\":");
                        sb2.append(strM28062d);
                        sb2.append(',');
                    } else {
                        C13012a.m78317c("JsonBean", "valueToJson error, field:" + fieldArrM80776c[i10]);
                    }
                } finally {
                    m28066e(fieldM28066e, zIsAccessible);
                }
            }
        }
        m28063f(sb2);
        sb2.append("}");
        return sb2.toString();
    }
}
