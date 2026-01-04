package p371ik;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import p399jk.AbstractC10896a;

/* renamed from: ik.a */
/* loaded from: classes6.dex */
public class C10527a {

    /* renamed from: ik.a$a */
    public class a implements ParameterizedType {

        /* renamed from: a */
        public final /* synthetic */ Class f50717a;

        public a(Class cls) {
            this.f50717a = cls;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return new Type[]{this.f50717a};
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return ArrayList.class;
        }
    }

    /* renamed from: a */
    public static GsonBuilder m64623a() {
        return new GsonBuilder().serializeNulls();
    }

    /* renamed from: b */
    public static String m64624b() {
        return new Gson().toJson(new Object());
    }

    /* renamed from: c */
    public static <T> Type m64625c(Class<T> cls) {
        return new a(cls);
    }

    /* renamed from: d */
    public static <T> List<T> m64626d(String str, Class<T> cls) {
        List<T> list = (List) m64627e(str, m64625c(cls), m64623a());
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: e */
    public static <T> T m64627e(String str, Type type, GsonBuilder gsonBuilder) {
        try {
            return (T) m64628f(str, type, gsonBuilder);
        } catch (JsonSyntaxException e10) {
            AbstractC10896a.m65886e("GsonWrapper", "parseComplexObject: JsonSyntaxException occurred!");
            AbstractC10896a.m65885d("GsonWrapper", "Details: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public static <T> T m64628f(String str, Type type, GsonBuilder gsonBuilder) throws JsonSyntaxException {
        if (type == null) {
            return null;
        }
        try {
            return (T) gsonBuilder.create().fromJson(str, type);
        } catch (JsonSyntaxException e10) {
            AbstractC10896a.m65886e("GsonWrapper", "parseComplexObjectThrowsExp, JsonSyntaxException Details: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public static <T> T m64629g(String str, Class<T> cls) {
        try {
            return (T) m64631i(str, cls);
        } catch (JsonSyntaxException e10) {
            AbstractC10896a.m65886e("GsonWrapper", "parseObject: JsonSyntaxException occurred!");
            AbstractC10896a.m65885d("GsonWrapper", "Details: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public static <T> T m64630h(String str, Class<T> cls, T t10) {
        T t11 = (T) m64629g(str, cls);
        return t11 == null ? t10 : t11;
    }

    /* renamed from: i */
    public static <T> T m64631i(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) m64632j(str, cls, m64623a());
    }

    /* renamed from: j */
    public static <T> T m64632j(String str, Class<T> cls, GsonBuilder gsonBuilder) throws JsonSyntaxException {
        if (cls == null) {
            return null;
        }
        try {
            return (T) gsonBuilder.create().fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            AbstractC10896a.m65886e("GsonWrapper", "parseObjectThrowsExp, JsonSyntaxException Details: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    public static String m64633k(Object obj) {
        return obj == null ? m64624b() : m64634l(obj, m64623a());
    }

    /* renamed from: l */
    public static String m64634l(Object obj, GsonBuilder gsonBuilder) {
        return gsonBuilder.create().toJson(obj);
    }
}
