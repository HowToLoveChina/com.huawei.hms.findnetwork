package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class JsonUtil {
    protected static final int VAL_BYTE = 2;
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_MAP = 3;
    protected static final int VAL_NULL = -1;
    protected static final String VAL_TYPE = "_val_type_";

    /* renamed from: a */
    private static String m37053a(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> superclass = iMessageEntity.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean zIsAccessible = field.isAccessible();
                    m37059a(field, true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    m37059a(field, zIsAccessible);
                    m37060a(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    private static Object m37062b(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object objM37052a = m37052a(field.getName(), jSONObject);
        if (objM37052a != null) {
            try {
                if (field.getType().getName().startsWith("com.huawei") && (field.getType().newInstance() instanceof IMessageEntity)) {
                    return jsonToEntity((String) objM37052a, (IMessageEntity) field.getType().newInstance());
                }
                if (!(objM37052a instanceof JSONObject) || !((JSONObject) objM37052a).has(VAL_TYPE)) {
                    return objM37052a;
                }
                int i10 = ((JSONObject) objM37052a).getInt(VAL_TYPE);
                if (i10 != 1 && i10 != 0) {
                    if (i10 == 2) {
                        return m37061a((JSONObject) objM37052a);
                    }
                    if (i10 == 3) {
                        return m37063b(field.getGenericType(), (JSONObject) objM37052a);
                    }
                    HMSLog.m36986e("JsonUtil", "cannot support type : " + i10);
                }
                return m37054a(field.getGenericType(), (JSONObject) objM37052a);
            } catch (InstantiationException unused) {
                HMSLog.m36986e("JsonUtil", "InstantiationException  ");
            }
        }
        return null;
    }

    @Deprecated
    public static String createJsonString(IMessageEntity iMessageEntity) {
        if (iMessageEntity == null) {
            HMSLog.m36986e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        try {
            return m37053a(iMessageEntity);
        } catch (IllegalAccessException e10) {
            HMSLog.m36986e("JsonUtil", "catch IllegalAccessException " + e10.getMessage());
            return "";
        } catch (JSONException e11) {
            HMSLog.m36986e("JsonUtil", "catch JSONException " + e11.getMessage());
            return "";
        }
    }

    public static Object getInfoFromJsonobject(String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(str2)) {
                    return null;
                }
                Object obj = jSONObject.get(str2);
                if (obj instanceof String) {
                    return obj;
                }
            } catch (JSONException unused) {
                HMSLog.m36986e("JsonUtil", "getInfoFromJsonobject:parser json error :" + str2);
            }
        }
        return null;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return -1;
        }
        return jSONObject.getInt(str);
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    @Deprecated
    public static IMessageEntity jsonToEntity(String str, IMessageEntity iMessageEntity) throws IllegalArgumentException {
        Class<? super Object> superclass;
        if (iMessageEntity == null) {
            return null;
        }
        try {
            Class<?> cls = iMessageEntity.getClass();
            JSONObject jSONObject = new JSONObject(str);
            while (cls != null) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields == null) {
                    superclass = cls.getSuperclass();
                } else {
                    for (Field field : declaredFields) {
                        if (field.isAnnotationPresent(Packed.class)) {
                            try {
                                m37055a(iMessageEntity, field, jSONObject);
                            } catch (IllegalAccessException unused) {
                                HMSLog.m36986e("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + field.getName());
                            }
                        }
                    }
                    superclass = cls.getSuperclass();
                }
                cls = superclass;
            }
        } catch (JSONException e10) {
            HMSLog.m36986e("JsonUtil", "catch JSONException when parse jsonString" + e10.getMessage());
        }
        return iMessageEntity;
    }

    /* renamed from: a */
    private static void m37059a(final Field field, final boolean z10) {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.utils.JsonUtil.1
            @Override // java.security.PrivilegedAction
            public Object run() throws SecurityException {
                field.setAccessible(z10);
                return null;
            }
        });
    }

    /* renamed from: b */
    private static Map m37063b(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException, IllegalArgumentException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < jSONArray.length(); i10 += 2) {
            if (cls.newInstance() instanceof IMessageEntity) {
                map.put(jSONArray.get(i10), jsonToEntity(jSONArray.getString(i10 + 1), (IMessageEntity) cls.newInstance()));
            } else {
                map.put(jSONArray.get(i10), jSONArray.get(i10 + 1));
            }
        }
        return map;
    }

    /* renamed from: a */
    private static boolean m37060a(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        if (obj instanceof String) {
            jSONObject.put(str, (String) obj);
            return true;
        }
        if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Short) {
            jSONObject.put(str, (Short) obj);
            return true;
        }
        if (obj instanceof Long) {
            jSONObject.put(str, (Long) obj);
            return true;
        }
        if (obj instanceof Float) {
            jSONObject.put(str, (Float) obj);
            return true;
        }
        if (obj instanceof Double) {
            jSONObject.put(str, (Double) obj);
            return true;
        }
        if (obj instanceof Boolean) {
            jSONObject.put(str, (Boolean) obj);
            return true;
        }
        if (obj instanceof JSONObject) {
            jSONObject.put(str, (JSONObject) obj);
            return true;
        }
        if (obj instanceof byte[]) {
            m37058a(str, (byte[]) obj, jSONObject);
            return true;
        }
        if (obj instanceof List) {
            m37056a(str, (List<?>) obj, jSONObject);
            return true;
        }
        if (obj instanceof Map) {
            m37057a(str, (Map) obj, jSONObject);
            return true;
        }
        if (obj instanceof IMessageEntity) {
            try {
                jSONObject.put(str, m37053a((IMessageEntity) obj));
                return true;
            } catch (IllegalAccessException e10) {
                HMSLog.m36986e("JsonUtil", "IllegalAccessException , " + e10);
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m37057a(String str, Map map, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof IMessageEntity) {
                jSONArray.put(m37053a((IMessageEntity) key));
            } else {
                jSONArray.put(key);
            }
            if (value instanceof IMessageEntity) {
                jSONArray.put(m37053a((IMessageEntity) value));
            } else {
                jSONArray.put(value);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 3);
        jSONObject2.put("_map_", jSONArray.toString());
        jSONObject.put(str, jSONObject2);
    }

    /* renamed from: a */
    private static void m37058a(String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 2);
        try {
            jSONObject2.put("_byte_", Base64.encode(bArr));
        } catch (IllegalArgumentException e10) {
            HMSLog.m36986e("JsonUtil", "writeByte failed : " + e10.getMessage());
        }
        jSONObject.put(str, jSONObject2);
    }

    /* renamed from: a */
    private static void m37056a(String str, List<?> list, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 1);
        jSONObject2.put("_list_size_", list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            m37060a("_list_item_" + i10, list.get(i10), jSONObject2);
            if (list.get(i10) instanceof IMessageEntity) {
                jSONObject2.put(VAL_TYPE, 0);
            }
        }
        jSONObject.put(str, jSONObject2);
    }

    /* renamed from: a */
    private static void m37055a(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException, IllegalArgumentException {
        Object objM37062b = m37062b(iMessageEntity, field, jSONObject);
        if (objM37062b != null) {
            boolean zIsAccessible = field.isAccessible();
            m37059a(field, true);
            field.set(iMessageEntity, objM37062b);
            m37059a(field, zIsAccessible);
        }
    }

    /* renamed from: a */
    private static Object m37052a(String str, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
            return jSONObject.getJSONObject("header").get(str);
        }
        if (jSONObject.has("body") && jSONObject.getJSONObject("body").has(str)) {
            return jSONObject.getJSONObject("body").get(str);
        }
        return null;
    }

    /* renamed from: a */
    private static List<Object> m37054a(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i10 = jSONObject.getInt("_list_size_");
        int i11 = jSONObject.getInt(VAL_TYPE);
        ArrayList arrayList = new ArrayList(i10);
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = jSONObject.get("_list_item_" + i12);
            if (i11 == 0) {
                arrayList.add(jsonToEntity((String) obj, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else if (i11 == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static byte[] m37061a(JSONObject jSONObject) throws JSONException {
        try {
            return Base64.decode(jSONObject.getString("_byte_"));
        } catch (IllegalArgumentException e10) {
            HMSLog.m36986e("JsonUtil", "readByte failed : " + e10.getMessage());
            return null;
        }
    }
}
