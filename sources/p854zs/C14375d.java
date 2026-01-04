package p854zs;

import as.C1016d;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.locationavailability.GetLocationAvailabilityResponse;
import com.huawei.secure.android.common.util.SafeBase64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: zs.d */
/* loaded from: classes8.dex */
public final class C14375d {
    /* renamed from: a */
    public static HashMap m85588a(Type type, JSONObject jSONObject) throws IllegalAccessException, JSONException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < jSONArray.length(); i10 += 2) {
            Object objNewInstance = cls.newInstance();
            if (objNewInstance instanceof IMessageEntity) {
                map.put(jSONArray.get(i10), m85589b(jSONArray.getString(i10 + 1), (IMessageEntity) objNewInstance));
            } else {
                map.put(jSONArray.get(i10), jSONArray.get(i10 + 1));
            }
        }
        return map;
    }

    /* renamed from: b */
    public static IMessageEntity m85589b(String str, IMessageEntity iMessageEntity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (Class<?> superclass = iMessageEntity.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            m85593f(iMessageEntity, field, jSONObject);
                        } catch (IllegalAccessException unused) {
                            C1016d.m6183c("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
        } catch (Exception unused2) {
            C1016d.m6183c("JsonUtil", "catch Exception when parse jsonString");
        }
        return iMessageEntity;
    }

    /* renamed from: c */
    public static String m85590c(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> superclass = iMessageEntity.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean zIsAccessible = field.isAccessible();
                    field.setAccessible(true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    field.setAccessible(zIsAccessible);
                    m85594g(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: d */
    public static String m85591d(GetLocationAvailabilityResponse getLocationAvailabilityResponse) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        String str;
        JSONObject jSONObject = new JSONObject();
        for (Class<?> superclass = getLocationAvailabilityResponse.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                for (Field field : superclass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        boolean zIsAccessible = field.isAccessible();
                        field.setAccessible(true);
                        String name = field.getName();
                        Object obj = field.get(getLocationAvailabilityResponse);
                        field.setAccessible(zIsAccessible);
                        m85594g(name, obj, jSONObject);
                    }
                }
            } catch (IllegalAccessException unused) {
                str = "catch IllegalAccessException";
                C1016d.m6183c("JsonUtil", str);
                return jSONObject.toString();
            } catch (SecurityException unused2) {
                str = "catch SecurityException";
                C1016d.m6183c("JsonUtil", str);
                return jSONObject.toString();
            } catch (JSONException unused3) {
                str = "catch JSONException";
                C1016d.m6183c("JsonUtil", str);
                return jSONObject.toString();
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: e */
    public static ArrayList m85592e(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i10 = jSONObject.getInt("_list_size_");
        int i11 = jSONObject.getInt("_val_type_");
        ArrayList arrayList = new ArrayList(i10);
        for (int i12 = 0; i12 < i10; i12++) {
            Object objM85589b = jSONObject.get("_list_item_" + i12);
            if (i11 == 0 && (type instanceof ParameterizedType)) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    Object objNewInstance = ((Class) type2).newInstance();
                    if ((objNewInstance instanceof IMessageEntity) && (objM85589b instanceof String)) {
                        objM85589b = m85589b((String) objM85589b, (IMessageEntity) objNewInstance);
                        arrayList.add(objM85589b);
                    }
                }
            } else if (i11 == 1) {
                arrayList.add(objM85589b);
            } else {
                C1016d.m6181a("JsonUtil", "readList");
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static void m85593f(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException {
        Object obj;
        String name = field.getName();
        Object objM85592e = null;
        if (jSONObject.has(name)) {
            obj = jSONObject.get(name);
        } else {
            String str = "header";
            if (!jSONObject.has("header") || !jSONObject.getJSONObject("header").has(name)) {
                str = "body";
                if (!jSONObject.has("body") || !jSONObject.getJSONObject("body").has(name)) {
                    obj = null;
                }
            }
            jSONObject = jSONObject.getJSONObject(str);
            obj = jSONObject.get(name);
        }
        if (obj != null) {
            try {
                if (field.getType().getName().startsWith("com.huawei") && (field.getType().newInstance() instanceof IMessageEntity) && (obj instanceof String)) {
                    objM85592e = m85589b((String) obj, (IMessageEntity) field.getType().newInstance());
                } else if ((obj instanceof JSONObject) && ((JSONObject) obj).has("_val_type_")) {
                    int i10 = ((JSONObject) obj).getInt("_val_type_");
                    if (i10 == 1 || i10 == 0) {
                        objM85592e = m85592e(field.getGenericType(), (JSONObject) obj);
                    } else if (i10 == 2) {
                        objM85592e = SafeBase64.decode(((JSONObject) obj).getString("_byte_"), 2);
                    } else if (i10 == 3) {
                        objM85592e = m85588a(field.getGenericType(), (JSONObject) obj);
                    } else {
                        C1016d.m6183c("JsonUtil", "cannot support type : " + i10);
                    }
                } else {
                    objM85592e = obj;
                }
            } catch (InstantiationException unused) {
                C1016d.m6183c("JsonUtil", "catch InstantiationException");
            }
        }
        if (objM85592e != null) {
            boolean zIsAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, objM85592e);
            field.setAccessible(zIsAccessible);
        }
    }

    /* renamed from: g */
    public static void m85594g(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException {
        if (!(obj instanceof String)) {
            if (obj instanceof Integer) {
                jSONObject.put(str, ((Integer) obj).intValue());
                return;
            }
            if (!(obj instanceof Short) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Boolean) && !(obj instanceof JSONObject)) {
                if (obj instanceof byte[]) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("_val_type_", 2);
                    jSONObject2.put("_byte_", SafeBase64.encode((byte[]) obj, 2));
                    jSONObject.put(str, jSONObject2);
                    return;
                }
                if (obj instanceof List) {
                    List list = (List) obj;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("_val_type_", 1);
                    jSONObject3.put("_list_size_", list.size());
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        m85594g("_list_item_" + i10, list.get(i10), jSONObject3);
                        if (list.get(i10) instanceof IMessageEntity) {
                            jSONObject3.put("_val_type_", 0);
                        }
                    }
                    jSONObject.put(str, jSONObject3);
                    return;
                }
                if (!(obj instanceof Map)) {
                    if (obj instanceof IMessageEntity) {
                        try {
                            jSONObject.put(str, m85590c((IMessageEntity) obj));
                            return;
                        } catch (IllegalAccessException unused) {
                            C1016d.m6183c("JsonUtil", "IllegalAccessException ");
                            return;
                        }
                    }
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Object obj2 : ((Map) obj).entrySet()) {
                    if (obj2 instanceof Map.Entry) {
                        Object key = ((Map.Entry) obj2).getKey();
                        if (key instanceof IMessageEntity) {
                            key = m85590c((IMessageEntity) key);
                        }
                        jSONArray.put(key);
                    }
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("_val_type_", 3);
                jSONObject4.put("_map_", jSONArray.toString());
                jSONObject.put(str, jSONObject4);
                return;
            }
        }
        jSONObject.put(str, obj);
    }
}
