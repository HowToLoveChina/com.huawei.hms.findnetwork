package com.huawei.openalliance.p169ad.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.huawei.openalliance.ad.utils.p */
/* loaded from: classes2.dex */
public abstract class AbstractC7837p implements InterfaceC7769bp {

    /* renamed from: a */
    private static final String f36137a = "p";

    /* renamed from: b */
    private Integer m48496b(Object obj, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        Object objM48057a = AbstractC7791ck.m48057a(obj, "getNetworkType", clsArr, objArr);
        if (objM48057a == null || !(objM48057a instanceof Integer)) {
            return 0;
        }
        return (Integer) objM48057a;
    }

    @Override // com.huawei.openalliance.p169ad.utils.InterfaceC7769bp
    /* renamed from: a */
    public int mo47811a() throws NoSuchMethodException, SecurityException {
        Object objMo47818b = mo47818b();
        if (objMo47818b == null) {
            return 0;
        }
        Object objM48057a = AbstractC7791ck.m48057a(objMo47818b, "getPreferredDataSubscription", (Class<?>[]) null, (Object[]) null);
        if (objM48057a == null || !(objM48057a instanceof Integer)) {
            return -1;
        }
        return ((Integer) objM48057a).intValue();
    }

    /* renamed from: b */
    public abstract Object mo47818b();

    @Override // com.huawei.openalliance.p169ad.utils.InterfaceC7769bp
    /* renamed from: a */
    public Pair<Integer, Pair<String, String>> mo47812a(int i10) throws NoSuchMethodException, SecurityException {
        Object objMo47818b = mo47818b();
        if (objMo47818b == null) {
            return null;
        }
        Class<?>[] clsArr = {Integer.TYPE};
        Object[] objArr = {Integer.valueOf(i10)};
        Pair<String, String> pairM48494a = m48494a(objMo47818b, clsArr, objArr);
        Integer numM48496b = m48496b(objMo47818b, clsArr, objArr);
        if (pairM48494a != null) {
            return new Pair<>(numM48496b, pairM48494a);
        }
        return null;
    }

    /* renamed from: a */
    private Pair<String, String> m48494a(Object obj, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        String strSubstring;
        String strSubstring2;
        Object objM48057a = AbstractC7791ck.m48057a(obj, "getNetworkOperator", clsArr, objArr);
        String str = (objM48057a == null || !(objM48057a instanceof String)) ? null : (String) objM48057a;
        if (str == null || "null".equalsIgnoreCase(str) || str.length() <= 3) {
            strSubstring = null;
            strSubstring2 = null;
        } else {
            strSubstring2 = str.substring(0, 3);
            strSubstring = str.substring(3);
        }
        if (strSubstring2 == null || strSubstring == null) {
            return null;
        }
        return new Pair<>(strSubstring2, strSubstring);
    }

    /* renamed from: a */
    public static Object m48495a(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (ClassNotFoundException unused) {
            str2 = f36137a;
            str3 = "getDefaultTelephoneManager ClassNotFoundException";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        } catch (IllegalAccessException unused2) {
            str2 = f36137a;
            str3 = "getDefaultTelephoneManager IllegalAccessException";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        } catch (IllegalArgumentException unused3) {
            str2 = f36137a;
            str3 = "getDefaultTelephoneManager IllegalArgumentException";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        } catch (NoSuchMethodException unused4) {
            str2 = f36137a;
            str3 = "getDefaultTelephoneManager NoSuchMethodException";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        } catch (SecurityException unused5) {
            str2 = f36137a;
            str3 = "getDefaultTelephoneManager SecurityException";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        } catch (InvocationTargetException unused6) {
            str2 = f36137a;
            str3 = "getDefaultTelephoneManager InvocationTargetException";
            AbstractC7185ho.m43823c(str2, str3);
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(f36137a, "getDefaultTelephoneManager error: " + th2.getClass().getSimpleName());
            return null;
        }
    }
}
