package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7005cv;
import com.huawei.openalliance.p169ad.InterfaceC7006cw;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6935g;
import com.huawei.openalliance.p169ad.annotations.SecretField;
import java.lang.annotation.Annotation;
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

/* renamed from: com.huawei.openalliance.ad.utils.be */
/* loaded from: classes2.dex */
public abstract class AbstractC7758be {

    /* renamed from: a */
    private static final Class[] f35917a = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Character.class, Boolean.class};

    /* renamed from: b */
    private static final Class[] f35918b = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Boolean.class};

    /* renamed from: c */
    private static final String f35919c = AbstractC7758be.class.getSimpleName();

    /* renamed from: d */
    private static final Map<Class, h> f35920d;

    /* renamed from: com.huawei.openalliance.ad.utils.be$a */
    public static class a implements h<Boolean, Object> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7758be.h
        /* renamed from: a */
        public Boolean mo47755b(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
            return null;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.be$b */
    public static class b implements h<Byte, Number> {
        private b() {
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7758be.h
        /* renamed from: a */
        public Byte mo47755b(Number number) {
            return Byte.valueOf(number.byteValue());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.be$c */
    public static class c implements h<Double, Number> {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7758be.h
        /* renamed from: a */
        public Double mo47755b(Number number) {
            return Double.valueOf(number.doubleValue());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.be$d */
    public static class d implements h<Float, Number> {
        private d() {
        }

        public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7758be.h
        /* renamed from: a */
        public Float mo47755b(Number number) {
            return Float.valueOf(number.floatValue());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.be$e */
    public static class e implements h<Integer, Number> {
        private e() {
        }

        public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7758be.h
        /* renamed from: a */
        public Integer mo47755b(Number number) {
            return Integer.valueOf(number.intValue());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.be$f */
    public static class f implements h<Long, Number> {
        private f() {
        }

        public /* synthetic */ f(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7758be.h
        /* renamed from: a */
        public Long mo47755b(Number number) {
            return Long.valueOf(number.longValue());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.be$g */
    public static class g implements h<Short, Number> {
        private g() {
        }

        public /* synthetic */ g(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.utils.AbstractC7758be.h
        /* renamed from: a */
        public Short mo47755b(Number number) {
            return Short.valueOf(number.shortValue());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.be$h */
    public interface h<D, S> {
        /* renamed from: b */
        D mo47755b(S s10);
    }

    static {
        HashMap map = new HashMap();
        f35920d = map;
        e eVar = new e();
        map.put(Integer.TYPE, eVar);
        map.put(Integer.class, eVar);
        f fVar = new f();
        map.put(Long.TYPE, fVar);
        map.put(Long.class, fVar);
        d dVar = new d();
        map.put(Float.TYPE, dVar);
        map.put(Float.class, dVar);
        c cVar = new c();
        map.put(Double.TYPE, cVar);
        map.put(Double.class, cVar);
        g gVar = new g();
        map.put(Short.TYPE, gVar);
        map.put(Short.class, gVar);
        b bVar = new b();
        map.put(Byte.TYPE, bVar);
        map.put(Byte.class, bVar);
        a aVar = new a();
        map.put(Boolean.TYPE, aVar);
        map.put(Boolean.class, aVar);
    }

    /* renamed from: a */
    private static Object m47716a(Context context, Class cls, Class cls2, Object obj) throws JSONException {
        if (m47744b(cls)) {
            return m47721a(cls, obj);
        }
        if (List.class.isAssignableFrom(cls)) {
            return m47751c(context, cls, cls2, obj);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return m47743b(context, cls, cls2, obj);
        }
        if (obj instanceof JSONObject) {
            return m47747c(context, (JSONObject) obj, cls, new Class[]{cls2});
        }
        if (obj instanceof JSONArray) {
            return m47718a(context, (JSONArray) obj, cls, new Class[]{cls2});
        }
        throw m47730a("value from json error, field class: %s", cls);
    }

    /* renamed from: b */
    public static <T> T m47737b(Context context, String str, Class<T> cls, Class... clsArr) {
        String str2;
        String str3;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (T) m47717a(context, str, cls, clsArr);
        } catch (JSONException unused) {
            str2 = f35919c;
            str3 = "toObject JSONException";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        } catch (Exception unused2) {
            str2 = f35919c;
            str3 = "toObject error";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        }
    }

    /* renamed from: c */
    private static <T> T m47746c(Context context, String str, Class<T> cls, Class[] clsArr) throws JSONException {
        try {
            try {
                return (T) m47747c(context, new JSONObject(str), cls, clsArr);
            } catch (JSONException unused) {
                return (T) m47718a(context, new JSONArray(str), cls, clsArr);
            }
        } catch (JSONException unused2) {
            throw m47730a("Input string is not valid json string!", new Object[0]);
        }
    }

    /* renamed from: d */
    private static String m47752d(Context context, Object obj, boolean z10) {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < length; i10++) {
            String strM47749c = m47749c(context, Array.get(obj, i10), z10);
            if (strM47749c != null) {
                sb2.append(strM47749c);
                sb2.append(',');
            }
        }
        m47736a(sb2);
        sb2.append(']');
        return sb2.toString();
    }

    /* renamed from: a */
    public static <T> T m47717a(Context context, String str, Class<T> cls, Class... clsArr) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            throw m47731a(false, "Input json string cannot be empty!", new Object[0]);
        }
        m47733a((Class) cls);
        return (T) m47746c(context, str, cls, clsArr);
    }

    /* renamed from: b */
    public static <T> T m47738b(Context context, JSONObject jSONObject, Class<T> cls, Class... clsArr) throws JSONException {
        if (jSONObject == null) {
            throw m47731a(false, "Input json obj cannot be null!", new Object[0]);
        }
        m47733a((Class) cls);
        return (T) m47747c(context, jSONObject, cls, clsArr);
    }

    /* renamed from: c */
    private static <T> T m47747c(Context context, JSONObject jSONObject, Class<T> cls, Class[] clsArr) throws JSONException {
        if (Collection.class.isAssignableFrom(cls)) {
            throw m47730a("Obj class %s is Collection type which mismatches with JsonObject", cls);
        }
        if (cls.isArray()) {
            throw m47730a("Obj class %s is array type which mismatches with JsonObject", cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return (T) m47743b(context, cls, (clsArr == null || clsArr.length <= 0) ? null : clsArr[0], jSONObject);
        }
        try {
            return (T) m47720a(context, jSONObject, cls.getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (IllegalAccessException unused) {
            throw m47730a("New instance failed for %s", cls);
        } catch (InstantiationException unused2) {
            throw m47730a("New instance failed for %s", cls);
        } catch (NoSuchMethodException unused3) {
            throw m47730a("No default constructor for class %s", cls);
        } catch (InvocationTargetException unused4) {
            throw m47730a("New instance failed for %s", cls);
        }
    }

    /* renamed from: d */
    private static boolean m47753d(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Double) || (obj instanceof Short);
    }

    /* renamed from: a */
    private static <T> T m47718a(Context context, JSONArray jSONArray, Class<T> cls, Class[] clsArr) throws JSONException {
        if (List.class.isAssignableFrom(cls)) {
            return (T) m47751c(context, cls, (clsArr == null || clsArr.length <= 0) ? null : clsArr[0], jSONArray);
        }
        throw m47730a("Obj class (%s) is not List type", cls);
    }

    /* renamed from: b */
    public static <T> T m47739b(String str, Class<T> cls, Class... clsArr) {
        return (T) m47737b((Context) null, str, cls, clsArr);
    }

    /* renamed from: c */
    public static String m47748c(Context context, Object obj) {
        String str;
        String str2;
        try {
            return m47724a(context, obj, true);
        } catch (IllegalAccessException unused) {
            str = f35919c;
            str2 = "toAnonymousJson IllegalAccessException";
            AbstractC7185ho.m43823c(str, str2);
            return "";
        } catch (JSONException unused2) {
            str = f35919c;
            str2 = "toAnonymousJson JSONException";
            AbstractC7185ho.m43823c(str, str2);
            return "";
        }
    }

    /* renamed from: a */
    public static <T> T m47719a(Context context, JSONObject jSONObject, Class<T> cls, Class... clsArr) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return (T) m47738b(context, jSONObject, cls, clsArr);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c(f35919c, "toObject error");
            return null;
        }
    }

    /* renamed from: b */
    public static String m47740b(Context context, Object obj) {
        try {
            return m47723a(context, obj);
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c(f35919c, "toJson JSONException");
            return "";
        }
    }

    /* renamed from: c */
    private static String m47749c(Context context, Object obj, boolean z10) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof String) && !(obj instanceof Character)) {
            return m47753d(obj) ? obj.toString() : obj instanceof List ? m47725a(context, (List) obj, z10) : obj instanceof Map ? m47726a(context, (Map) obj, z10) : obj.getClass().isArray() ? m47752d(context, obj, z10) : m47724a(context, obj, z10);
        }
        if (AbstractC7806cz.m48165b(obj.toString())) {
            return null;
        }
        return "\"" + AbstractC7806cz.m48172e(obj.toString()) + "\"";
    }

    /* renamed from: a */
    private static <T> T m47720a(Context context, JSONObject jSONObject, T t10) throws SecurityException {
        Object objOpt;
        Field[] fieldArrM48068a = AbstractC7791ck.m48068a((Class) t10.getClass());
        int length = fieldArrM48068a.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field fieldM48058a = AbstractC7791ck.m48058a(fieldArrM48068a[i10], true);
            if (m47745b(fieldM48058a) && (objOpt = jSONObject.opt(m47728a(fieldM48058a))) != null && JSONObject.NULL != objOpt) {
                if (context != null && fieldArrM48068a[i10].isAnnotationPresent(SecretField.class)) {
                    objOpt = AbstractC7827f.m48400b((String) objOpt, AbstractC7796cp.m48089b(context));
                }
                m47732a(context, t10, fieldM48058a, objOpt);
            }
        }
        return t10;
    }

    /* renamed from: b */
    private static String m47741b(Context context, Object obj, boolean z10) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Field[] fieldArrM48068a = AbstractC7791ck.m48068a((Class) obj.getClass());
        if (fieldArrM48068a.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        int length = fieldArrM48068a.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field fieldM48058a = AbstractC7791ck.m48058a(fieldArrM48068a[i10], true);
            fieldArrM48068a[i10] = fieldM48058a;
            if (m47745b(fieldM48058a)) {
                String strM47728a = m47728a(fieldArrM48068a[i10]);
                Object obj2 = fieldArrM48068a[i10].get(obj);
                if (!(obj2 instanceof String) || !TextUtils.isEmpty((String) obj2)) {
                    String strM47749c = null;
                    if (z10 && fieldArrM48068a[i10].isAnnotationPresent(InterfaceC6929a.class)) {
                        if (obj2 != null) {
                            strM47749c = "\"******\"";
                        }
                    } else if (z10 && fieldArrM48068a[i10].isAnnotationPresent(InterfaceC6935g.class)) {
                        if (obj2 != null) {
                            strM47749c = "\"" + AbstractC7806cz.m48176g((String) obj2) + "\"";
                        }
                    } else if (context == null || !fieldArrM48068a[i10].isAnnotationPresent(SecretField.class)) {
                        strM47749c = m47749c(context, obj2, z10);
                    } else {
                        byte[] bArrM48089b = AbstractC7796cp.m48089b(context);
                        if (obj2 != null) {
                            strM47749c = AbstractC7827f.m48394a((String) obj2, bArrM48089b);
                        }
                    }
                    if (strM47749c != null) {
                        sb2.append('\"');
                        sb2.append(strM47728a);
                        sb2.append("\":");
                        sb2.append(strM47749c);
                        if (i10 < length - 1) {
                            sb2.append(',');
                        }
                    }
                }
            }
        }
        m47736a(sb2);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: c */
    public static String m47750c(Object obj) {
        return m47748c(null, obj);
    }

    /* renamed from: a */
    private static Object m47721a(Class cls, Object obj) {
        h hVar;
        if (String.class == cls) {
            return AbstractC7806cz.m48153a(obj);
        }
        if ((cls.isPrimitive() || Number.class.isAssignableFrom(cls)) && (obj instanceof Number)) {
            obj = (Number) obj;
            hVar = f35920d.get(cls);
            if (hVar == null) {
                AbstractC7185ho.m43824c(f35919c, "cannot find value reader for: %s", cls);
                return null;
            }
            return hVar.mo47755b(obj);
        }
        if (cls != Boolean.class) {
            return obj;
        }
        hVar = f35920d.get(cls);
        if (hVar == null) {
            AbstractC7185ho.m43824c(f35919c, "cannot find value reader for: %s", cls);
            return null;
        }
        return hVar.mo47755b(obj);
    }

    /* renamed from: b */
    public static String m47742b(Object obj) {
        return m47740b(null, obj);
    }

    /* renamed from: c */
    private static List m47751c(Context context, Class cls, Class cls2, Object obj) throws JSONException {
        List arrayList;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (!(obj instanceof JSONArray)) {
            throw m47730a("jsonobject is not JSONArray", new Object[0]);
        }
        if (cls == List.class) {
            arrayList = new ArrayList();
        } else {
            if (!List.class.isAssignableFrom(cls)) {
                throw m47730a("%s is not List type", cls);
            }
            try {
                arrayList = (List) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw m47730a("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw m47730a("Fail to initiate %s", cls);
            }
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object objM47716a = m47716a(context, cls2, (Class) null, jSONArray.get(i10));
            if (objM47716a != null) {
                if (cls2.isAssignableFrom(objM47716a.getClass())) {
                    arrayList.add(objM47716a);
                } else {
                    AbstractC7185ho.m43826d(f35919c, "listFromJson error, memberClass:" + cls2 + ", valueClass:" + objM47716a.getClass());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <T> T m47722a(String str, Class<T> cls, Class... clsArr) {
        return (T) m47717a((Context) null, str, cls, clsArr);
    }

    /* renamed from: b */
    private static Map m47743b(Context context, Class cls, Class cls2, Object obj) throws JSONException {
        Map linkedHashMap;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (!(obj instanceof JSONObject)) {
            throw m47730a("jsonValue is not JSONObject", new Object[0]);
        }
        if (Map.class == cls) {
            linkedHashMap = new LinkedHashMap();
        } else {
            if (!Map.class.isAssignableFrom(cls)) {
                throw m47730a("%s is not Map type", cls);
            }
            try {
                linkedHashMap = (Map) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw m47730a("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw m47730a("Fail to initiate %s", cls);
            }
        }
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objM47716a = m47716a(context, cls2, (Class) null, jSONObject.get(next));
            if (objM47716a != null) {
                if (cls2.isAssignableFrom(objM47716a.getClass())) {
                    linkedHashMap.put(next, objM47716a);
                } else {
                    AbstractC7185ho.m43826d(f35919c, "mapFromJson error, memberClass:" + cls2 + ", valueClass:" + objM47716a.getClass());
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static String m47723a(Context context, Object obj) throws JSONException {
        try {
            return m47724a(context, obj, false);
        } catch (IllegalAccessException unused) {
            throw m47730a("toJson error", new Object[0]);
        }
    }

    /* renamed from: b */
    private static boolean m47744b(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        int length = f35918b.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (cls == f35918b[i10]) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m47724a(Context context, Object obj, boolean z10) throws JSONException {
        if (obj == null) {
            return "";
        }
        m47733a((Class) obj.getClass());
        return obj instanceof List ? m47725a(context, (List) obj, z10) : obj instanceof Map ? m47726a(context, (Map) obj, z10) : m47741b(context, obj, z10);
    }

    /* renamed from: b */
    private static boolean m47745b(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || field.isAnnotationPresent(InterfaceC6934f.class)) ? false : true;
    }

    /* renamed from: a */
    private static String m47725a(Context context, List list, boolean z10) {
        if (list.size() <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        try {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strM47749c = m47749c(context, list.get(i10), z10);
                if (strM47749c != null) {
                    sb2.append(strM47749c);
                    sb2.append(',');
                }
            }
            m47736a(sb2);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(f35919c, "list2Json exception: %", th2.getClass().getSimpleName());
        }
        sb2.append(']');
        return sb2.toString();
    }

    /* renamed from: a */
    private static String m47726a(Context context, Map map, boolean z10) {
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
            String strM47749c = m47749c(context, entry.getValue(), z10);
            if (strM47749c != null) {
                sb2.append('\"');
                sb2.append(str);
                sb2.append("\":");
                sb2.append(strM47749c);
            }
            if (i10 < size && strM47749c != null) {
                sb2.append(',');
            }
        }
        m47736a(sb2);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m47727a(Object obj) {
        return m47723a((Context) null, obj);
    }

    /* renamed from: a */
    private static String m47728a(Field field) {
        InterfaceC6932d interfaceC6932d = (InterfaceC6932d) field.getAnnotation(InterfaceC6932d.class);
        if (interfaceC6932d != null && !TextUtils.isEmpty(interfaceC6932d.m39225a())) {
            return interfaceC6932d.m39225a();
        }
        String name = field.getName();
        return name.endsWith("__") ? name.substring(0, name.length() - 2) : name;
    }

    /* renamed from: a */
    public static Map<String, String> m47729a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(strTrim);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next).toString().trim());
            }
            return map;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static JSONException m47730a(String str, Object... objArr) {
        return m47731a(true, str, objArr);
    }

    /* renamed from: a */
    private static JSONException m47731a(boolean z10, String str, Object... objArr) {
        String str2 = String.format(Locale.ENGLISH, str, objArr);
        if (z10) {
            AbstractC7185ho.m43823c(f35919c, str2);
        }
        return new JSONException(str2);
    }

    /* renamed from: a */
    private static void m47732a(Context context, Object obj, Field field, Object obj2) {
        Object objM47716a = null;
        try {
            try {
                objM47716a = m47716a(context, field.getType(), AbstractC7791ck.m48054a(field), obj2);
                field.set(obj, objM47716a);
            } catch (RuntimeException unused) {
                AbstractC7185ho.m43823c(f35919c, obj.getClass().getName() + ".fromJson runtime exception, fieldName: " + field.getName() + ", field: " + field);
            } catch (Exception unused2) {
                AbstractC7185ho.m43823c(f35919c, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + field);
                m47735a(obj, field, objM47716a);
            }
        } finally {
            m47734a(obj, field);
        }
    }

    /* renamed from: a */
    private static void m47733a(Class cls) throws JSONException {
        if (cls.isPrimitive()) {
            throw m47730a("Root obj class (%s) cannot be primitive type!", cls);
        }
        int length = f35917a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (cls == f35917a[i10]) {
                throw m47730a("Root obj class (%s) is invalid in conversion", cls);
            }
        }
    }

    /* renamed from: a */
    private static void m47734a(Object obj, Field field) {
        try {
            Annotation[] annotations = field.getAnnotations();
            if (annotations != null) {
                int length = annotations.length;
                for (int i10 = 0; i10 < length; i10++) {
                    InterfaceC7006cw interfaceC7006cwM41232a = C7005cv.m41232a(annotations[i10]);
                    if (interfaceC7006cwM41232a != null) {
                        interfaceC7006cwM41232a.mo41233a(obj, field, annotations[i10]);
                    }
                }
            }
        } catch (IllegalAccessException unused) {
            AbstractC7185ho.m43823c(f35919c, obj.getClass().getName() + "postProcessFieldAnnotation exception, fieldName: " + field.getName() + ", field: " + field);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(f35919c, obj.getClass().getName() + "postProcessFieldAnnotation " + th2.getClass().getSimpleName() + ", fieldName: " + field.getName() + ", field: " + field);
        }
    }

    /* renamed from: a */
    private static void m47735a(Object obj, Field field, Object obj2) {
        Object objValueOf;
        if (obj2 == null || !(obj2 instanceof String)) {
            return;
        }
        try {
            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                if (Integer.TYPE == type) {
                    objValueOf = Integer.valueOf(Integer.parseInt((String) obj2));
                } else if (Float.TYPE == type) {
                    objValueOf = Float.valueOf(Float.parseFloat((String) obj2));
                } else if (Long.TYPE == type) {
                    objValueOf = Long.valueOf(Long.parseLong((String) obj2));
                } else if (Boolean.TYPE == type) {
                    objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) obj2));
                } else if (Double.TYPE == type) {
                    objValueOf = Double.valueOf(Double.parseDouble((String) obj2));
                } else if (Short.TYPE == type) {
                    objValueOf = Short.valueOf(Short.parseShort((String) obj2));
                } else if (Byte.TYPE == type) {
                    objValueOf = Byte.valueOf(Byte.parseByte((String) obj2));
                } else if (Character.TYPE != type) {
                    return;
                } else {
                    objValueOf = Character.valueOf(((String) obj2).charAt(0));
                }
                field.set(obj, objValueOf);
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d(f35919c, "processValueError");
        }
    }

    /* renamed from: a */
    private static void m47736a(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }
}
