package com.huawei.android.backup.service.utils;

import android.content.ContentValues;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.BackupConstant;
import java.lang.reflect.Field;
import p006a5.AbstractC0048c;
import p248e5.C9409b;

/* loaded from: classes.dex */
public class InfoXmlUtils {

    /* renamed from: a */
    public static boolean f9762a = false;

    /* renamed from: b */
    public static boolean f9763b = false;

    /* renamed from: c */
    public static boolean f9764c = false;

    /* renamed from: d */
    public static boolean f9765d = false;

    /* renamed from: e */
    public static boolean f9766e = false;

    /* renamed from: f */
    public static int f9767f;

    public static class BackupFilePhoneInfo {
        public static final String PRODUCT_MODEL = BackupConstant.LocalPhoneInfo.PRODUCT_MODEL;
        public static final String PRODUCT_BRAND = BackupConstant.LocalPhoneInfo.PRODUCT_BRAND;
        public static final String PRODUCT_MANUFACTURER = BackupConstant.LocalPhoneInfo.PRODUCT_MANUFACTURER;
        public static final String BOARD_PLATFORM = BackupConstant.LocalPhoneInfo.BORAD_PLATFORM;
        public static final int VERSION_SDK = BackupConstant.LocalPhoneInfo.VERSION_SDK;
        public static final String VERSION_RELEASE = BackupConstant.LocalPhoneInfo.VERSION_RELEASE;
    }

    public static class BackupFileVersionInfo {
        public static int dbVersion;
        public static int softVersion;
    }

    /* renamed from: a */
    public static void m13153a() {
        f9762a = false;
        f9763b = false;
        f9764c = false;
        f9765d = false;
        f9766e = false;
    }

    /* renamed from: b */
    public static Object[] m13154b(AbstractC0048c abstractC0048c, Class<?> cls) {
        return (abstractC0048c == null || cls == null) ? new Object[0] : m13155c(abstractC0048c, cls, cls.getSimpleName());
    }

    /* renamed from: c */
    public static Object[] m13155c(AbstractC0048c abstractC0048c, Class<?> cls, String str) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Object[] objArr = new Object[0];
        if (abstractC0048c != null && cls != null) {
            Field[] declaredFields = cls.getDeclaredFields();
            ContentValues[] contentValuesArrM199r = abstractC0048c.m199r(str);
            if (contentValuesArrM199r != null && contentValuesArrM199r.length != 0) {
                Object[] objArr2 = new Object[contentValuesArrM199r.length];
                for (int i10 = 0; i10 < contentValuesArrM199r.length; i10++) {
                    try {
                        objArr2[i10] = cls.newInstance();
                        for (Field field : declaredFields) {
                            String name = field.getName();
                            if (contentValuesArrM199r[i10].containsKey(name)) {
                                Object obj = contentValuesArrM199r[i10].get(name);
                                field.setAccessible(true);
                                field.set(objArr2[i10], obj);
                                field.setAccessible(false);
                            }
                        }
                    } catch (IllegalAccessException | InstantiationException unused) {
                        C2111d.m12648d("InfoXmlUtils", "readDynamicInfo error.");
                        return objArr;
                    }
                }
                return objArr2;
            }
        }
        return objArr;
    }

    /* renamed from: d */
    public static boolean m13156d(AbstractC0048c abstractC0048c) {
        if (f9763b) {
            return true;
        }
        if (!m13157e(abstractC0048c, BackupFilePhoneInfo.class)) {
            return false;
        }
        f9763b = true;
        return true;
    }

    /* renamed from: e */
    public static boolean m13157e(AbstractC0048c abstractC0048c, Class<?> cls) throws IllegalAccessException, IllegalArgumentException {
        if (abstractC0048c != null && cls != null) {
            Field[] declaredFields = cls.getDeclaredFields();
            ContentValues[] contentValuesArrM199r = abstractC0048c.m199r(cls.getSimpleName());
            if (contentValuesArrM199r != null && contentValuesArrM199r.length != 0) {
                for (ContentValues contentValues : contentValuesArrM199r) {
                    for (Field field : declaredFields) {
                        String name = field.getName();
                        if (contentValues.containsKey(name)) {
                            Object obj = contentValues.get(name);
                            try {
                                if (field.isAccessible()) {
                                    field.set(null, obj);
                                }
                            } catch (IllegalAccessException unused) {
                                C2111d.m12648d("InfoXmlUtils", "readStaticInfo IllegalAccessException");
                            } catch (IllegalArgumentException unused2) {
                                C2111d.m12648d("InfoXmlUtils", "readStaticInfo IllegalArgumentException");
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m13158f(AbstractC0048c abstractC0048c) {
        if (f9765d) {
            return true;
        }
        if (!m13157e(abstractC0048c, BackupFileVersionInfo.class)) {
            return false;
        }
        f9765d = true;
        return true;
    }

    /* renamed from: g */
    public static void m13159g(int i10) {
        f9767f = i10;
    }

    /* renamed from: h */
    public static void m13160h(ContentValues contentValues, String str, Object obj) {
        if (contentValues == null) {
            return;
        }
        if (obj == null) {
            contentValues.putNull(str);
            return;
        }
        if (obj instanceof String) {
            contentValues.put(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
            return;
        }
        if (obj instanceof Integer) {
            contentValues.put(str, (Integer) obj);
            return;
        }
        if (obj instanceof Short) {
            contentValues.put(str, (Short) obj);
            return;
        }
        if (obj instanceof Byte) {
            contentValues.put(str, (Byte) obj);
            return;
        }
        if (obj instanceof Boolean) {
            contentValues.put(str, (Boolean) obj);
            return;
        }
        if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
            return;
        }
        if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else if (obj instanceof byte[]) {
            contentValues.put(str, (byte[]) obj);
        } else {
            contentValues.putNull(str);
        }
    }

    /* renamed from: i */
    public static int m13161i(AbstractC0048c abstractC0048c) {
        if (f9766e) {
            return 1;
        }
        if (abstractC0048c == null) {
            return 2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type_attch", Integer.valueOf(C9409b.m59023d()));
        contentValues.put("type", (Integer) 0);
        contentValues.put("checkMsg", "");
        contentValues.put("promptMsg", C9409b.m59022c());
        int iM185A = abstractC0048c.m185A("BackupFilesTypeInfo", contentValues);
        if (iM185A == 1) {
            f9766e = true;
        }
        return iM185A;
    }

    /* renamed from: j */
    public static int m13162j(AbstractC0048c abstractC0048c, Class<?> cls, Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Object obj2;
        if (abstractC0048c == null) {
            return 2;
        }
        ContentValues contentValues = new ContentValues();
        if (cls == null) {
            if (obj == null) {
                return 2;
            }
            cls = obj.getClass();
        }
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            try {
                field.setAccessible(true);
                obj2 = field.get(obj);
                field.setAccessible(false);
            } catch (IllegalAccessException | IllegalArgumentException unused) {
                obj2 = null;
            }
            if (name != null) {
                m13160h(contentValues, name, obj2);
            }
        }
        return abstractC0048c.m185A(cls.getSimpleName(), contentValues);
    }

    /* renamed from: k */
    public static int m13163k(AbstractC0048c abstractC0048c) {
        if (f9762a) {
            return 1;
        }
        int iM13164l = m13164l(abstractC0048c, BackupFilePhoneInfo.class);
        if (iM13164l == 1) {
            f9762a = true;
        }
        return iM13164l;
    }

    /* renamed from: l */
    public static int m13164l(AbstractC0048c abstractC0048c, Class<?> cls) {
        return m13162j(abstractC0048c, cls, null);
    }

    /* renamed from: m */
    public static int m13165m(AbstractC0048c abstractC0048c) {
        if (f9764c) {
            return 1;
        }
        BackupFileVersionInfo.dbVersion = 1;
        BackupFileVersionInfo.softVersion = f9767f;
        int iM13164l = m13164l(abstractC0048c, BackupFileVersionInfo.class);
        if (iM13164l == 1) {
            f9764c = true;
        }
        return iM13164l;
    }
}
