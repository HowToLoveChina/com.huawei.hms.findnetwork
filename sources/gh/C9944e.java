package gh;

import android.os.Parcel;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import gh.C9943d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p290fh.C9692a;
import p290fh.C9693b;
import p290fh.C9694c;
import p290fh.C9695d;
import p290fh.C9696e;
import p290fh.C9697f;
import p290fh.C9698g;
import p290fh.C9699h;
import p290fh.C9700i;
import p290fh.C9701j;
import p290fh.C9702k;
import p290fh.C9703l;
import p290fh.C9704m;
import p290fh.C9705n;
import p290fh.C9706o;
import p290fh.C9707p;
import p290fh.C9708q;

/* renamed from: gh.e */
/* loaded from: classes4.dex */
public final class C9944e {

    /* renamed from: a */
    public static final Map<EnumC9940a, InterfaceC9942c> f48707a;

    /* renamed from: gh.e$a */
    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th2) {
            super(str, th2);
        }
    }

    static {
        HashMap map = new HashMap();
        f48707a = map;
        map.put(EnumC9940a.BINDER, new C9692a());
        map.put(EnumC9940a.BOOLEAN, new C9693b());
        map.put(EnumC9940a.BUNDLE, new C9694c());
        map.put(EnumC9940a.BYTE_ARRAY, new C9695d());
        map.put(EnumC9940a.DOUBLE, new C9696e());
        map.put(EnumC9940a.FLOAT, new C9697f());
        map.put(EnumC9940a.HASH_MAP, new C9698g());
        map.put(EnumC9940a.INT_ARRAY, new C9699h());
        map.put(EnumC9940a.INTEGER, new C9700i());
        map.put(EnumC9940a.INTERFACE, new C9701j());
        map.put(EnumC9940a.LIST, new C9702k());
        map.put(EnumC9940a.LONG, new C9703l());
        map.put(EnumC9940a.PARCELABLE_ARRAY, new C9704m());
        map.put(EnumC9940a.PARCELABLE, new C9705n());
        map.put(EnumC9940a.STRING_ARRAY, new C9706o());
        map.put(EnumC9940a.STRING_LIST, new C9707p());
        map.put(EnumC9940a.STRING, new C9708q());
    }

    /* renamed from: a */
    public static <T extends AutoParcelable> T m61617a(Class<T> cls, Parcel parcel) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            boolean zIsAccessible = declaredConstructor.isAccessible();
            declaredConstructor.setAccessible(true);
            try {
                try {
                    T tNewInstance = declaredConstructor.newInstance(new Object[0]);
                    try {
                        m61620d(tNewInstance, parcel);
                    } catch (Exception e10) {
                        C9941b.f48706a.m61608b("SafeParcel", "can not readObject", e10);
                    }
                    return tNewInstance;
                } catch (IllegalAccessException e11) {
                    throw new a("newInstance failed", e11);
                } catch (InstantiationException e12) {
                    throw new a("newInstance failed", e12);
                } catch (InvocationTargetException e13) {
                    throw new a("newInstance failed", e13);
                }
            } finally {
                declaredConstructor.setAccessible(zIsAccessible);
            }
        } catch (NoSuchMethodException e14) {
            throw new a("createObject() requires a default constructor", e14);
        } catch (SecurityException e15) {
            throw new a("createObject() requires a public constructor", e15);
        }
    }

    /* renamed from: b */
    public static ClassLoader m61618b(Class cls) {
        return cls == null ? ClassLoader.getSystemClassLoader() : cls.getClassLoader();
    }

    /* renamed from: c */
    public static Map<String, String> m61619c(Parcel parcel) {
        HashMap map = new HashMap();
        String[] strArrM60554d = C9706o.m60554d(parcel, parcel.readInt());
        if (strArrM60554d != null) {
            for (String str : strArrM60554d) {
                if (!TextUtils.isEmpty(str)) {
                    String[] strArrSplit = str.split("\\|");
                    if (strArrSplit.length == 2) {
                        map.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
            }
        }
        return map;
    }

    /* renamed from: d */
    public static void m61620d(AutoParcelable autoParcelable, Parcel parcel) throws SecurityException {
        SparseArray sparseArray = new SparseArray();
        for (Class<?> superclass = autoParcelable.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if (field.isAnnotationPresent(EnableAutoParcel.class)) {
                    int iValue = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).value();
                    if (sparseArray.get(iValue) != null) {
                        throw new a("Field number " + iValue + " is used twice in " + superclass.getName() + " for fields " + field.getName() + " and " + ((Field) sparseArray.get(iValue)).getName());
                    }
                    sparseArray.put(iValue, field);
                }
            }
        }
        Class<?> cls = autoParcelable.getClass();
        int iM61612b = C9943d.m61612b(parcel);
        Map<String, String> mapM61619c = m61619c(parcel);
        while (parcel.dataPosition() < iM61612b) {
            int i10 = parcel.readInt();
            int iM61611a = C9943d.m61611a(i10);
            Field field2 = (Field) sparseArray.get(iM61611a);
            if (field2 == null) {
                C9941b.f48706a.m61607a("SafeParcel", "Unknown field num " + iM61611a + " in " + cls.getName() + ", skipping.");
            } else {
                try {
                    m61624h(autoParcelable, parcel, field2, i10, mapM61619c);
                } catch (C9943d.a e10) {
                    C9943d.m61615e(parcel, i10);
                    C9941b.f48706a.m61610d("SafeParcel", "Error reading field: " + iM61611a + " in " + cls.getName() + ", skipping." + e10.getMessage());
                }
            }
            C9943d.m61616f(parcel, i10);
        }
        if (parcel.dataPosition() <= iM61612b) {
            return;
        }
        throw new a("Overread allowed size end=" + iM61612b + "-" + parcel.dataPosition());
    }

    /* renamed from: e */
    public static void m61621e(AutoParcelable autoParcelable, Parcel parcel, int i10) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Class<?> superclass = autoParcelable.getClass();
        int iM61627c = C9945f.m61627c(parcel, 20293);
        m61622f(autoParcelable, parcel, superclass);
        while (superclass != null) {
            for (Field field : superclass.getDeclaredFields()) {
                if (field.isAnnotationPresent(EnableAutoParcel.class)) {
                    try {
                        m61623g(autoParcelable, parcel, field, i10);
                    } catch (Exception e10) {
                        C9941b.f48706a.m61610d("SafeParcel", "Error writing field: " + e10);
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
        C9945f.m61625a(parcel, iM61627c);
    }

    /* renamed from: f */
    public static void m61622f(AutoParcelable autoParcelable, Parcel parcel, Class cls) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        TypeVariable<Class<?>>[] typeParameters = autoParcelable.getClass().getTypeParameters();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            if (!TextUtils.isEmpty(typeVariable.getName())) {
                arrayList2.add(typeVariable.getName());
            }
        }
        if (!arrayList2.isEmpty()) {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            for (int i10 = 0; i10 < length; i10++) {
                Field field = declaredFields[i10];
                if (field.isAnnotationPresent(EnableAutoParcel.class) && arrayList2.contains(field.getGenericType().toString())) {
                    boolean zIsAccessible = field.isAccessible();
                    field.setAccessible(true);
                    String name = field.getName();
                    try {
                        try {
                            Object obj = field.get(autoParcelable);
                            if (obj != null) {
                                arrayList.add(name + "|" + obj.getClass().getCanonicalName());
                            }
                        } catch (IllegalAccessException unused) {
                            C9941b.f48706a.m61609c("SafeParcel", "can not get the value of the field:" + name);
                        }
                    } finally {
                        field.setAccessible(zIsAccessible);
                    }
                }
            }
        }
        new C9706o().mo60520a(parcel, null, 0, (String[]) arrayList.toArray(new String[typeParameters.length]), 0, false);
    }

    /* renamed from: g */
    public static void m61623g(AutoParcelable autoParcelable, Parcel parcel, Field field, int i10) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        int iValue = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).value();
        boolean zMayNull = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).mayNull();
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        InterfaceC9942c interfaceC9942c = f48707a.get(EnumC9940a.m61604e(field));
        if (interfaceC9942c == null) {
            C9941b.f48706a.m61609c("SafeParcel", "can not find process to write:" + field.getName());
        } else {
            interfaceC9942c.mo60520a(parcel, field, iValue, field.get(autoParcelable), i10, zMayNull);
        }
        field.setAccessible(zIsAccessible);
    }

    /* renamed from: h */
    public static void m61624h(AutoParcelable autoParcelable, Parcel parcel, Field field, int i10, Map<String, String> map) throws SecurityException {
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        try {
            try {
                InterfaceC9942c interfaceC9942c = f48707a.get(EnumC9940a.m61604e(field));
                if (interfaceC9942c == null) {
                    C9941b.f48706a.m61609c("SafeParcel", "can not find process to read:" + field.getName());
                } else {
                    interfaceC9942c.mo60521b(autoParcelable, field, parcel, i10, map);
                }
            } catch (IllegalAccessException unused) {
                C9941b.f48706a.m61610d("SafeParcel", "can not set field value");
            }
            field.setAccessible(zIsAccessible);
        } catch (Throwable th2) {
            field.setAccessible(zIsAccessible);
            throw th2;
        }
    }
}
