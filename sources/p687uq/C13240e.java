package p687uq;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p640sq.C12836o;

/* renamed from: uq.e */
/* loaded from: classes8.dex */
public final class C13240e implements InterfaceC13237b {

    /* renamed from: a */
    public static C13240e f59919a;

    /* renamed from: c */
    public static synchronized C13240e m79623c() {
        try {
            if (f59919a == null) {
                f59919a = new C13240e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f59919a;
    }

    /* renamed from: d */
    public static int m79624d() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.telephony.TelephonyManager");
            Method declaredMethod = cls.getDeclaredMethod("getDefaultSim", null);
            Object objInvoke = cls.getDeclaredMethod("getDefault", null).invoke(null, null);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(objInvoke, null)).intValue();
        } catch (Error e10) {
            C12836o.m77096a("mutiCardMTKImpl", "" + e10.getClass().getSimpleName(), true);
            return -1;
        } catch (Exception e11) {
            C12836o.m77096a("mutiCardMTKImpl", "" + e11.getClass().getSimpleName(), true);
            return -1;
        }
    }

    /* renamed from: e */
    public static Object m79625e() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e10) {
            C12836o.m77096a("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + e10.getClass().getSimpleName(), true);
            return null;
        }
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: a */
    public int mo79611a() {
        return m79624d();
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: b */
    public int mo79613b(int i10) {
        Class<?>[] clsArr = {Integer.TYPE};
        Object[] objArr = {Integer.valueOf(i10)};
        try {
            Object objM79625e = m79625e();
            if (objM79625e != null) {
                return ((Integer) objM79625e.getClass().getDeclaredMethod("getSimState", clsArr).invoke(objM79625e, objArr)).intValue();
            }
            return 0;
        } catch (IllegalArgumentException e10) {
            C12836o.m77099d("mutiCardMTKImpl", " getSimState wrong " + e10.getClass().getSimpleName(), true);
            return 0;
        } catch (NoSuchMethodException e11) {
            C12836o.m77099d("mutiCardMTKImpl", " getSimState wrong " + e11.getClass().getSimpleName(), true);
            return 0;
        } catch (InvocationTargetException e12) {
            C12836o.m77099d("mutiCardMTKImpl", " getSimState wrong " + e12.getClass().getSimpleName(), true);
            return 0;
        } catch (Throwable th2) {
            C12836o.m77099d("mutiCardMTKImpl", " getSimState wrong " + th2.getClass().getSimpleName(), true);
            return 0;
        }
    }

    /* renamed from: f */
    public final String m79626f(int i10) {
        C12836o.m77097b("mutiCardMTKImpl", "getMTKPlmn", true);
        Class<?>[] clsArr = {Integer.TYPE};
        try {
            Integer num = (Integer) Class.forName("android.telephony.SubscriptionManager").getMethod("getSlotId", clsArr).invoke(null, Integer.valueOf(i10));
            if (num.intValue() == -1) {
                return null;
            }
            Object objM79625e = m79625e();
            return (String) objM79625e.getClass().getMethod("getSimOperator", clsArr).invoke(objM79625e, num);
        } catch (ClassNotFoundException unused) {
            C12836o.m77099d("mutiCardMTKImpl", "ClassNotFoundException", true);
            return null;
        } catch (IllegalAccessException unused2) {
            C12836o.m77099d("mutiCardMTKImpl", "IllegalAccessException", true);
            return null;
        } catch (NoSuchMethodException unused3) {
            C12836o.m77099d("mutiCardMTKImpl", "NoSuchMethodException", true);
            return null;
        } catch (InvocationTargetException unused4) {
            C12836o.m77099d("mutiCardMTKImpl", "InvocationTargetException", true);
            return null;
        }
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: a */
    public String mo79612a(int i10) {
        Object objM79625e;
        Class<?>[] clsArr = {Integer.TYPE};
        Object[] objArr = {Integer.valueOf(i10)};
        try {
            objM79625e = m79625e();
        } catch (IllegalAccessException e10) {
            C12836o.m77099d("mutiCardMTKImpl", "getSubscriberId exception:" + e10.getClass().getSimpleName(), true);
        } catch (IllegalArgumentException e11) {
            C12836o.m77099d("mutiCardMTKImpl", "getSubscriberId exception:" + e11.getClass().getSimpleName(), true);
        } catch (NoSuchMethodException e12) {
            C12836o.m77099d("mutiCardMTKImpl", "getSubscriberId exception:" + e12.getClass().getSimpleName(), true);
        } catch (Exception e13) {
            C12836o.m77099d("mutiCardMTKImpl", "getSubscriberId exception:" + e13.getClass().getSimpleName(), true);
        }
        String strM79626f = objM79625e != null ? (String) objM79625e.getClass().getMethod("getSubscriberId", clsArr).invoke(objM79625e, objArr) : "";
        if (TextUtils.isEmpty(strM79626f)) {
            strM79626f = m79626f(i10);
        }
        return strM79626f == null ? "" : strM79626f;
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: c */
    public String mo79614c(int i10) {
        return "";
    }
}
