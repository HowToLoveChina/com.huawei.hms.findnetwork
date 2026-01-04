package p384j4;

import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6010m7;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p308g4.AbstractC9881e;
import p308g4.C9877a;
import p308g4.InterfaceC9879c;
import p326h4.InterfaceC10091a;
import p326h4.InterfaceC10094d;
import p326h4.InterfaceC10096f;
import p405jt.AbstractC10915a;

/* renamed from: j4.d */
/* loaded from: classes.dex */
public abstract class AbstractC10705d {

    /* renamed from: a */
    public static final Class[] f51353a = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Character.class, Boolean.class};

    /* renamed from: b */
    public static final Class[] f51354b = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Boolean.class};

    /* renamed from: c */
    public static final String f51355c = "JsonUtil";

    /* renamed from: d */
    public static final Map<Class, i> f51356d;

    /* renamed from: j4.d$b */
    public static class b implements i<Boolean, Object> {
        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
        
            r1 = null;
         */
        @Override // p384j4.AbstractC10705d.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Boolean mo65366a(java.lang.Object r1) {
            /*
                r0 = this;
                boolean r0 = r1 instanceof java.lang.Boolean     // Catch: java.lang.Throwable -> L16
                if (r0 == 0) goto L7
                java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L16
                goto L20
            L7:
                boolean r0 = r1 instanceof java.lang.String     // Catch: java.lang.Throwable -> L16
                if (r0 == 0) goto L1f
                java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L16
                boolean r0 = java.lang.Boolean.parseBoolean(r1)     // Catch: java.lang.Throwable -> L16
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L16
                goto L20
            L16:
                java.lang.String r0 = p384j4.AbstractC10705d.m65344e()
                java.lang.String r1 = "read boolean - unKnow srcValue class"
                p405jt.AbstractC10915a.m65978j(r0, r1)
            L1f:
                r1 = 0
            L20:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p384j4.AbstractC10705d.b.mo65366a(java.lang.Object):java.lang.Boolean");
        }
    }

    /* renamed from: j4.d$c */
    public static class c implements i<Byte, Object> {
        public c() {
        }

        @Override // p384j4.AbstractC10705d.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte mo65366a(Object obj) {
            if (obj instanceof Number) {
                return Byte.valueOf(((Number) obj).byteValue());
            }
            if (obj instanceof String) {
                return AbstractC10707f.m65381f((String) obj);
            }
            return null;
        }
    }

    /* renamed from: j4.d$d */
    public static class d implements i<Double, Object> {
        public d() {
        }

        @Override // p384j4.AbstractC10705d.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double mo65366a(Object obj) {
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (obj instanceof String) {
                return AbstractC10707f.m65382g((String) obj);
            }
            return null;
        }
    }

    /* renamed from: j4.d$e */
    public static class e implements i<Float, Object> {
        public e() {
        }

        @Override // p384j4.AbstractC10705d.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float mo65366a(Object obj) {
            if (obj instanceof Number) {
                return Float.valueOf(((Number) obj).floatValue());
            }
            if (obj instanceof String) {
                return AbstractC10707f.m65383h((String) obj);
            }
            return null;
        }
    }

    /* renamed from: j4.d$f */
    public static class f implements i<Integer, Object> {
        public f() {
        }

        @Override // p384j4.AbstractC10705d.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer mo65366a(Object obj) {
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            if (obj instanceof String) {
                return AbstractC10707f.m65384i((String) obj);
            }
            return null;
        }
    }

    /* renamed from: j4.d$g */
    public static class g implements i<Long, Object> {
        public g() {
        }

        @Override // p384j4.AbstractC10705d.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long mo65366a(Object obj) {
            if (obj instanceof Number) {
                return Long.valueOf(((Number) obj).longValue());
            }
            if (obj instanceof String) {
                return AbstractC10707f.m65385j((String) obj);
            }
            return null;
        }
    }

    /* renamed from: j4.d$h */
    public static class h implements i<Short, Object> {
        public h() {
        }

        @Override // p384j4.AbstractC10705d.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short mo65366a(Object obj) {
            if (obj instanceof Number) {
                return Short.valueOf(((Number) obj).shortValue());
            }
            if (obj instanceof String) {
                return AbstractC10707f.m65386k((String) obj);
            }
            return null;
        }
    }

    /* renamed from: j4.d$i */
    public interface i<D, S> {
        /* renamed from: a */
        D mo65366a(S s10);
    }

    static {
        HashMap map = new HashMap();
        f51356d = map;
        f fVar = new f();
        map.put(Integer.TYPE, fVar);
        map.put(Integer.class, fVar);
        g gVar = new g();
        map.put(Long.TYPE, gVar);
        map.put(Long.class, gVar);
        e eVar = new e();
        map.put(Float.TYPE, eVar);
        map.put(Float.class, eVar);
        d dVar = new d();
        map.put(Double.TYPE, dVar);
        map.put(Double.class, dVar);
        h hVar = new h();
        map.put(Short.TYPE, hVar);
        map.put(Short.class, hVar);
        c cVar = new c();
        map.put(Byte.TYPE, cVar);
        map.put(Byte.class, cVar);
        b bVar = new b();
        map.put(Boolean.TYPE, bVar);
        map.put(Boolean.class, bVar);
    }

    /* renamed from: A */
    public static <T> T m65335A(JSONObject jSONObject, T t10) {
        Object objOpt;
        for (Field field : AbstractC9881e.m61332d(t10.getClass())) {
            Field fieldM61331c = AbstractC9881e.m61331c(field, true);
            if (m65361v(fieldM61331c) && (objOpt = jSONObject.opt(m65346g(fieldM61331c))) != null && JSONObject.NULL != objOpt) {
                m65354o(t10, fieldM61331c, objOpt);
            }
        }
        return t10;
    }

    /* renamed from: B */
    public static Map<String, String> m65336B(String str) {
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

    /* renamed from: C */
    public static String m65337C(Object obj) throws JSONException {
        try {
            return m65363x(obj, false);
        } catch (IllegalAccessException unused) {
            throw m65350k("toJson error", new Object[0]);
        }
    }

    /* renamed from: D */
    public static String m65338D(Object obj) {
        try {
            return m65337C(obj);
        } catch (JSONException unused) {
            AbstractC10915a.m65978j(f51355c, "toJson JSONException");
            return "";
        }
    }

    /* renamed from: E */
    public static <T> T m65339E(String str, Class<T> cls, Class... clsArr) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            throw m65351l(false, "Input json string cannot be empty!", new Object[0]);
        }
        m65352m(cls);
        return (T) m65341b(str, cls, clsArr);
    }

    /* renamed from: a */
    public static Object m65340a(Class cls, Object obj) {
        i iVar;
        if (String.class == cls) {
            return AbstractC10707f.m65376a(obj);
        }
        if ((cls.isPrimitive() || Number.class.isAssignableFrom(cls)) && ((obj instanceof Number) || (obj instanceof String))) {
            iVar = f51356d.get(cls);
            if (iVar == null) {
                AbstractC10915a.m65979k(f51355c, "cannot find value reader for: %s", cls);
                return null;
            }
            return iVar.mo65366a(obj);
        }
        if (cls != Boolean.class) {
            return obj;
        }
        iVar = f51356d.get(cls);
        if (iVar == null) {
            AbstractC10915a.m65979k(f51355c, "cannot find value reader for: %s", cls);
            return null;
        }
        return iVar.mo65366a(obj);
    }

    /* renamed from: b */
    public static <T> T m65341b(String str, Class<T> cls, Class[] clsArr) throws JSONException {
        try {
            try {
                return (T) m65343d(new JSONObject(str), cls, clsArr);
            } catch (JSONException unused) {
                return (T) m65342c(new JSONArray(str), cls, clsArr);
            }
        } catch (JSONException unused2) {
            throw m65350k("Input string is not valid json string!", new Object[0]);
        }
    }

    /* renamed from: c */
    public static <T> T m65342c(JSONArray jSONArray, Class<T> cls, Class[] clsArr) throws JSONException {
        if (List.class.isAssignableFrom(cls)) {
            return (T) m65349j(cls, (clsArr == null || clsArr.length <= 0) ? null : clsArr[0], jSONArray);
        }
        throw m65350k("Obj class (%s) is not List type", cls);
    }

    /* renamed from: d */
    public static <T> T m65343d(JSONObject jSONObject, Class<T> cls, Class[] clsArr) throws JSONException {
        if (Collection.class.isAssignableFrom(cls)) {
            throw m65350k("Obj class %s is Collection type which mismatches with JsonObject", cls);
        }
        if (cls.isArray()) {
            throw m65350k("Obj class %s is array type which mismatches with JsonObject", cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return (T) m65358s(cls, (clsArr == null || clsArr.length <= 0) ? null : clsArr[0], jSONObject);
        }
        try {
            return (T) m65335A(jSONObject, cls.getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (NoSuchMethodException unused) {
            throw m65350k("No default constructor for class %s", cls);
        }
    }

    /* renamed from: f */
    public static String m65345f(Object obj, boolean z10) {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < length; i10++) {
            String strM65365z = m65365z(Array.get(obj, i10), z10);
            if (strM65365z != null) {
                sb2.append(strM65365z);
                sb2.append(',');
            }
        }
        m65355p(sb2);
        sb2.append(']');
        return sb2.toString();
    }

    /* renamed from: g */
    public static String m65346g(Field field) {
        InterfaceC10094d interfaceC10094d = (InterfaceC10094d) field.getAnnotation(InterfaceC10094d.class);
        if (interfaceC10094d != null && !TextUtils.isEmpty(interfaceC10094d.value())) {
            return interfaceC10094d.value();
        }
        String name = field.getName();
        return name.endsWith("__") ? name.substring(0, name.length() - 2) : name;
    }

    /* renamed from: h */
    public static String m65347h(List list, boolean z10) {
        if (list.size() <= 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strM65365z = m65365z(list.get(i10), z10);
            if (strM65365z != null) {
                sb2.append(strM65365z);
                sb2.append(',');
            }
        }
        m65355p(sb2);
        sb2.append(']');
        return sb2.toString();
    }

    /* renamed from: i */
    public static String m65348i(Map map, boolean z10) {
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
            String strM65365z = m65365z(entry.getValue(), z10);
            if (strM65365z != null) {
                sb2.append('\"');
                sb2.append(str);
                sb2.append("\":");
                sb2.append(strM65365z);
            }
            if (i10 < size && strM65365z != null) {
                sb2.append(',');
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: j */
    public static List m65349j(Class cls, Class cls2, Object obj) throws JSONException {
        List arrayList;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (!(obj instanceof JSONArray)) {
            throw m65350k("jsonobject is not JSONArray", new Object[0]);
        }
        if (cls == List.class) {
            arrayList = new ArrayList();
        } else {
            if (!List.class.isAssignableFrom(cls)) {
                throw m65350k("%s is not List type", cls);
            }
            try {
                arrayList = (List) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw m65350k("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw m65350k("Fail to initiate %s", cls);
            }
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object objM65362w = m65362w(cls2, null, jSONArray.get(i10));
            if (objM65362w != null) {
                if (cls2.isAssignableFrom(objM65362w.getClass())) {
                    arrayList.add(objM65362w);
                } else {
                    AbstractC10915a.m65970b(f51355c, "listFromJson error, memberClass:" + cls2 + ", valueClass:" + objM65362w.getClass());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public static JSONException m65350k(String str, Object... objArr) {
        return m65351l(true, str, objArr);
    }

    /* renamed from: l */
    public static JSONException m65351l(boolean z10, String str, Object... objArr) {
        String strM65378c = AbstractC10707f.m65378c(str, objArr);
        if (z10) {
            AbstractC10915a.m65978j(f51355c, strM65378c);
        }
        return new JSONException(strM65378c);
    }

    /* renamed from: m */
    public static void m65352m(Class cls) throws JSONException {
        if (cls.isPrimitive()) {
            throw m65350k("Root obj class (%s) cannot be primitive type!", cls);
        }
        int length = f51353a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (cls == f51353a[i10]) {
                throw m65350k("Root obj class (%s) is invalid in conversion", cls);
            }
        }
    }

    /* renamed from: n */
    public static void m65353n(Object obj, Field field) {
        try {
            Annotation[] annotations = field.getAnnotations();
            if (annotations != null) {
                int length = annotations.length;
                for (int i10 = 0; i10 < length; i10++) {
                    InterfaceC9879c interfaceC9879cM61327a = C9877a.m61327a(annotations[i10]);
                    if (interfaceC9879cM61327a != null) {
                        interfaceC9879cM61327a.mo61328a(obj, field, annotations[i10]);
                    }
                }
            }
        } catch (IllegalAccessException unused) {
            AbstractC10915a.m65978j(f51355c, obj.getClass().getName() + "postProcessFieldAnnotation exception, fieldName: " + field.getName() + ", field: " + field);
        } catch (Throwable th2) {
            AbstractC10915a.m65978j(f51355c, obj.getClass().getName() + "postProcessFieldAnnotation " + th2.getClass().getSimpleName() + ", fieldName: " + field.getName() + ", field: " + field);
        }
    }

    /* renamed from: o */
    public static void m65354o(Object obj, Field field, Object obj2) {
        Object objM65362w;
        try {
            try {
                try {
                    objM65362w = m65362w(field.getType(), AbstractC9881e.m61329a(field), obj2);
                } catch (Exception unused) {
                    objM65362w = null;
                }
                try {
                    field.set(obj, objM65362w);
                } catch (Exception unused2) {
                    AbstractC10915a.m65978j(f51355c, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + field);
                    m65359t(obj, field, objM65362w);
                }
            } catch (RuntimeException unused3) {
                AbstractC10915a.m65978j(f51355c, obj.getClass().getName() + ".fromJson runtime exception, fieldName: " + field.getName() + ", field: " + field);
            }
        } finally {
            m65353n(obj, field);
        }
    }

    /* renamed from: p */
    public static void m65355p(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }

    /* renamed from: q */
    public static boolean m65356q(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Double) || (obj instanceof Short);
    }

    /* renamed from: r */
    public static String m65357r(Object obj, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        Field[] fieldArrM61332d = AbstractC9881e.m61332d(obj.getClass());
        if (fieldArrM61332d.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        int length = fieldArrM61332d.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field fieldM61331c = AbstractC9881e.m61331c(fieldArrM61332d[i10], true);
            fieldArrM61332d[i10] = fieldM61331c;
            if (m65361v(fieldM61331c)) {
                String strM65346g = m65346g(fieldArrM61332d[i10]);
                Object obj2 = fieldArrM61332d[i10].get(obj);
                String strM65365z = (z10 && fieldArrM61332d[i10].isAnnotationPresent(InterfaceC10091a.class)) ? obj2 != null ? "\"******\"" : null : m65365z(obj2, z10);
                if (strM65365z != null) {
                    sb2.append('\"');
                    sb2.append(strM65346g);
                    sb2.append("\":");
                    sb2.append(strM65365z);
                    if (i10 < length - 1) {
                        sb2.append(',');
                    }
                }
            }
        }
        m65355p(sb2);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: s */
    public static Map m65358s(Class cls, Class cls2, Object obj) throws JSONException {
        Map linkedHashMap;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (!(obj instanceof JSONObject)) {
            throw m65350k("jsonValue is not JSONObject", new Object[0]);
        }
        if (Map.class == cls) {
            linkedHashMap = new LinkedHashMap();
        } else {
            if (!Map.class.isAssignableFrom(cls)) {
                throw m65350k("%s is not Map type", cls);
            }
            try {
                linkedHashMap = (Map) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw m65350k("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw m65350k("Fail to initiate %s", cls);
            }
        }
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objM65362w = m65362w(cls2, null, jSONObject.get(next));
            if (objM65362w != null) {
                if (cls2.isAssignableFrom(objM65362w.getClass())) {
                    linkedHashMap.put(next, objM65362w);
                } else {
                    AbstractC10915a.m65970b(f51355c, "mapFromJson error, memberClass:" + cls2 + ", valueClass:" + objM65362w.getClass());
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: t */
    public static void m65359t(Object obj, Field field, Object obj2) {
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
            AbstractC10915a.m65970b(f51355c, "processValueError");
        }
    }

    /* renamed from: u */
    public static boolean m65360u(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        int length = f51354b.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (cls == f51354b[i10]) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: v */
    public static boolean m65361v(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || field.isAnnotationPresent(InterfaceC10096f.class)) ? false : true;
    }

    /* renamed from: w */
    public static Object m65362w(Class cls, Class cls2, Object obj) throws JSONException {
        if (m65360u(cls)) {
            return m65340a(cls, obj);
        }
        if (List.class.isAssignableFrom(cls)) {
            return m65349j(cls, cls2, obj);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return m65358s(cls, cls2, obj);
        }
        if (obj instanceof JSONObject) {
            return m65343d((JSONObject) obj, cls, new Class[]{cls2});
        }
        if (obj instanceof JSONArray) {
            return m65342c((JSONArray) obj, cls, new Class[]{cls2});
        }
        throw m65350k("value from json error, field class: %s", cls);
    }

    /* renamed from: x */
    public static String m65363x(Object obj, boolean z10) throws JSONException {
        if (obj == null) {
            return "";
        }
        m65352m(obj.getClass());
        return obj instanceof List ? m65347h((List) obj, z10) : obj instanceof Map ? m65348i((Map) obj, z10) : m65357r(obj, z10);
    }

    /* renamed from: y */
    public static JSONObject m65364y(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            AbstractC10915a.m65978j(f51355c, "create json obj err");
            return null;
        }
    }

    /* renamed from: z */
    public static String m65365z(Object obj, boolean z10) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof String) && !(obj instanceof Character)) {
            return m65356q(obj) ? obj.toString() : obj instanceof List ? m65347h((List) obj, z10) : obj instanceof Map ? m65348i((Map) obj, z10) : obj.getClass().isArray() ? m65345f(obj, z10) : m65363x(obj, z10);
        }
        if (AbstractC10707f.m65379d(obj.toString())) {
            return null;
        }
        return "\"" + AbstractC10707f.m65377b(obj.toString()) + "\"";
    }
}
