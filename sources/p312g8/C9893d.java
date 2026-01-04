package p312g8;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import p031b7.C1120a;

/* renamed from: g8.d */
/* loaded from: classes2.dex */
public class C9893d {
    /* renamed from: a */
    public static String m61374a(Bundle bundle, String str) throws JSONException {
        if (bundle == null || str == null) {
            C1120a.m6676e("JSONHelper", "bundleToJsonString input params invalid!");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof Collection) {
                    Iterator it = ((Collection) obj).iterator();
                    if (it.hasNext()) {
                        jSONObject.put(str2 + str, it.next().getClass().getName());
                    }
                }
                jSONObject.put(str2, m61397x(obj));
            }
        } catch (JSONException unused) {
            C1120a.m6676e("JSONHelper", "Serialize bundle to JSON error");
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    public static boolean m61375b(String str, Object obj) {
        return ("String".equals(str) && obj == null) || ("int".equals(str) && ((Integer) obj).intValue() == 0) || (("long".equals(str) && ((Long) obj).longValue() == 0) || ("double".equals(str) && ((Double) obj).doubleValue() == 0.0d));
    }

    /* renamed from: c */
    public static ArrayList<Field> m61376c(Class<?> cls) {
        ArrayList<Field> arrayList = new ArrayList<>();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    /* renamed from: d */
    public static boolean m61377d(Method[] methodArr, String str) {
        for (Method method : methodArr) {
            if (str.equals(method.getName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m61378e(Class<?> cls) {
        return cls != null && cls.isArray();
    }

    /* renamed from: f */
    public static boolean m61379f(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String);
    }

    /* renamed from: g */
    public static boolean m61380g(Class<?> cls) {
        return cls != null && (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls));
    }

    /* renamed from: h */
    public static boolean m61381h(Class<?> cls) {
        return cls != null && Collection.class.isAssignableFrom(cls);
    }

    /* renamed from: i */
    public static boolean m61382i(Class<?> cls) {
        return cls != null && Map.class.isAssignableFrom(cls);
    }

    /* renamed from: j */
    public static boolean m61383j(Object obj) {
        return obj instanceof JSONObject ? JSONObject.NULL.equals(obj) : obj == null;
    }

    /* renamed from: k */
    public static boolean m61384k(Class<?> cls) {
        return cls != null && (Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls));
    }

    /* renamed from: l */
    public static boolean m61385l(Class<?> cls) {
        return (cls == null || m61386m(cls) || m61378e(cls) || m61381h(cls) || m61382i(cls)) ? false : true;
    }

    /* renamed from: m */
    public static boolean m61386m(Class<?> cls) {
        return m61380g(cls) || m61384k(cls) || m61387n(cls);
    }

    /* renamed from: n */
    public static boolean m61387n(Class<?> cls) {
        return cls != null && (String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls));
    }

    /* renamed from: o */
    public static String m61388o(String str, String str2) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return str2 + str.substring(0, 1).toUpperCase(Locale.US) + str.substring(1);
    }

    /* renamed from: p */
    public static void m61389p(JSONStringer jSONStringer, Object obj) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!m61383j(obj)) {
            m61394u(jSONStringer, obj);
            return;
        }
        try {
            jSONStringer.value((Object) null);
        } catch (JSONException unused) {
            C1120a.m6676e("JSONHelper", "JSON serialize error: serialize");
        }
    }

    /* renamed from: q */
    public static void m61390q(JSONStringer jSONStringer, Object obj) throws JSONException {
        try {
            jSONStringer.array();
            for (int i10 = 0; i10 < Array.getLength(obj); i10++) {
                m61389p(jSONStringer, Array.get(obj, i10));
            }
            jSONStringer.endArray();
        } catch (Exception unused) {
            C1120a.m6676e("JSONHelper", "JSON serializeArray error: ");
        }
    }

    /* renamed from: r */
    public static void m61391r(JSONStringer jSONStringer, Collection<?> collection) throws JSONException {
        try {
            jSONStringer.array();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                m61389p(jSONStringer, it.next());
            }
            jSONStringer.endArray();
        } catch (Exception unused) {
            C1120a.m6676e("JSONHelper", "JSON serializeCollect error: ");
        }
    }

    /* renamed from: s */
    public static void m61392s(JSONStringer jSONStringer, Map<?, ?> map) throws JSONException {
        try {
            jSONStringer.object();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                jSONStringer.key((String) entry.getKey());
                m61389p(jSONStringer, entry.getValue());
            }
            jSONStringer.endObject();
        } catch (Exception unused) {
            C1120a.m6676e("JSONHelper", "JSON serializeMap error: ");
        }
    }

    /* renamed from: t */
    public static void m61393t(JSONStringer jSONStringer, Object obj) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            jSONStringer.object();
            Class<?> cls = obj.getClass();
            Method[] methods = cls.getMethods();
            Iterator<Field> it = m61376c(cls).iterator();
            while (it.hasNext()) {
                Field next = it.next();
                try {
                    String simpleName = next.getType().getSimpleName();
                    String strM61388o = m61388o(next.getName(), "get");
                    if (!TextUtils.isEmpty(strM61388o) && m61377d(methods, strM61388o)) {
                        Object objInvoke = cls.getMethod(strM61388o, new Class[0]).invoke(obj, new Object[0]);
                        if ("Date".equals(simpleName)) {
                            objInvoke = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format((Date) objInvoke);
                        }
                        if (!m61375b(simpleName, objInvoke)) {
                            jSONStringer.key(next.getName());
                            m61389p(jSONStringer, objInvoke);
                        }
                    }
                } catch (Exception unused) {
                    C1120a.m6676e("JSONHelper", "JSON serializeObject error: ");
                }
            }
            jSONStringer.endObject();
        } catch (Exception unused2) {
            C1120a.m6676e("JSONHelper", "JSON serializeObject error: ");
        }
    }

    /* renamed from: u */
    public static void m61394u(JSONStringer jSONStringer, Object obj) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = obj.getClass();
        if (m61385l(cls)) {
            m61393t(jSONStringer, obj);
            return;
        }
        if (m61378e(cls)) {
            m61390q(jSONStringer, obj);
            return;
        }
        if (m61381h(cls)) {
            m61391r(jSONStringer, (Collection) obj);
        } else {
            if (m61382i(cls)) {
                m61392s(jSONStringer, (HashMap) obj);
                return;
            }
            try {
                jSONStringer.value(obj);
            } catch (JSONException unused) {
                C1120a.m6676e("JSONHelper", "JSON serialize error: serialize");
            }
        }
    }

    /* renamed from: v */
    public static JSONArray m61395v(Object obj) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (!obj.getClass().isArray()) {
            throw new JSONException("Not a primitive array: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            jSONArray.put(m61397x(Array.get(obj, i10)));
        }
        return jSONArray;
    }

    /* renamed from: w */
    public static JSONObject m61396w(Object obj) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        JSONStringer jSONStringer = new JSONStringer();
        m61389p(jSONStringer, obj);
        try {
            return new JSONObject(jSONStringer.toString());
        } catch (JSONException unused) {
            C1120a.m6676e("JSONHelper", "JSON toJSONObject error: toJSONString");
            return null;
        }
    }

    /* renamed from: x */
    public static Object m61397x(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
        } catch (Exception unused) {
            C1120a.m6676e("JSONHelper", "JSON error：wrap");
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(m61397x(it.next()));
            }
            return jSONArray;
        }
        if (obj.getClass().isArray()) {
            return m61395v(obj);
        }
        if (m61379f(obj)) {
            return obj;
        }
        if (obj instanceof Parcelable) {
            return m61396w(obj);
        }
        return null;
    }
}
