package p687uq;

import java.lang.reflect.InvocationTargetException;
import p640sq.C12836o;

/* renamed from: uq.d */
/* loaded from: classes8.dex */
public class C13239d implements InterfaceC13237b {

    /* renamed from: a */
    public static C13239d f59918a;

    /* renamed from: c */
    public static synchronized C13239d m79621c() {
        try {
            if (f59918a == null) {
                f59918a = new C13239d();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f59918a;
    }

    /* renamed from: d */
    public static Object m79622d() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e10) {
            C12836o.m77096a("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + e10.getClass().getSimpleName(), true);
            return null;
        }
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: a */
    public int mo79611a() {
        try {
            Object objM79622d = m79622d();
            if (objM79622d != null) {
                return ((Integer) objM79622d.getClass().getMethod("getDefaultSubscription", new Class[0]).invoke(objM79622d, new Object[0])).intValue();
            }
            return 0;
        } catch (IllegalArgumentException e10) {
            C12836o.m77099d("MutiCardHwImpl", " IllegalArgumentException wrong " + e10.getClass().getSimpleName(), true);
            return -1;
        } catch (NoSuchMethodException e11) {
            C12836o.m77099d("MutiCardHwImpl", " NoSuchMethodException wrong " + e11.getClass().getSimpleName(), true);
            return -1;
        } catch (NullPointerException e12) {
            C12836o.m77099d("MutiCardHwImpl", " NullPointerException wrong " + e12.getClass().getSimpleName(), true);
            return -1;
        } catch (InvocationTargetException e13) {
            C12836o.m77099d("MutiCardHwImpl", " InvocationTargetException wrong " + e13.getClass().getSimpleName(), true);
            return -1;
        } catch (Exception e14) {
            C12836o.m77099d("MutiCardHwImpl", " Exception wrong " + e14.getClass().getSimpleName(), true);
            return -1;
        }
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: b */
    public int mo79613b(int i10) {
        int i11 = i10 == -1 ? 5 : 0;
        Class<?>[] clsArr = {Integer.TYPE};
        Object[] objArr = {Integer.valueOf(i10)};
        try {
            Object objM79622d = m79622d();
            return objM79622d != null ? ((Integer) objM79622d.getClass().getDeclaredMethod("getSimState", clsArr).invoke(objM79622d, objArr)).intValue() : i11;
        } catch (IllegalAccessException e10) {
            C12836o.m77099d("MutiCardHwImpl", " IllegalAccessException wrong " + e10.getClass().getSimpleName(), true);
            return i11;
        } catch (IllegalArgumentException e11) {
            C12836o.m77099d("MutiCardHwImpl", " IllegalArgumentException wrong " + e11.getClass().getSimpleName(), true);
            return i11;
        } catch (NoSuchMethodException e12) {
            C12836o.m77099d("MutiCardHwImpl", " NoSuchMethodException wrong " + e12.getClass().getSimpleName(), true);
            return i11;
        } catch (NullPointerException e13) {
            C12836o.m77099d("MutiCardHwImpl", " NullPointerException wrong " + e13.getClass().getSimpleName(), true);
            return i11;
        } catch (Throwable th2) {
            C12836o.m77099d("MutiCardHwImpl", " getSimState wrong " + th2.getClass().getSimpleName(), true);
            return i11;
        }
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: c */
    public String mo79614c(int i10) {
        Object objM79622d;
        Class<?>[] clsArr = {Integer.TYPE};
        Object[] objArr = {Integer.valueOf(i10)};
        try {
            objM79622d = m79622d();
        } catch (IllegalAccessException e10) {
            C12836o.m77099d("MutiCardHwImpl", "getSimOperator exception:" + e10.getClass().getSimpleName(), true);
        } catch (IllegalArgumentException e11) {
            C12836o.m77099d("MutiCardHwImpl", "getSimOperator exception:" + e11.getClass().getSimpleName(), true);
        } catch (NoSuchMethodException e12) {
            C12836o.m77099d("MutiCardHwImpl", "getSimOperator exception:" + e12.getClass().getSimpleName(), true);
        } catch (NullPointerException e13) {
            C12836o.m77099d("MutiCardHwImpl", "getSimOperator exception:" + e13.getClass().getSimpleName(), true);
        } catch (InvocationTargetException e14) {
            C12836o.m77099d("MutiCardHwImpl", "getSimOperator exception:" + e14.getClass().getSimpleName(), true);
        } catch (Exception e15) {
            C12836o.m77099d("MutiCardHwImpl", "getSimOperator exception:" + e15.getClass().getSimpleName(), true);
        }
        String str = objM79622d != null ? (String) objM79622d.getClass().getMethod("getSimOperator", clsArr).invoke(objM79622d, objArr) : "";
        return str == null ? "" : str;
    }

    @Override // p687uq.InterfaceC13237b
    /* renamed from: a */
    public String mo79612a(int i10) {
        Object objM79622d;
        Class<?>[] clsArr = {Integer.TYPE};
        Object[] objArr = {Integer.valueOf(i10)};
        try {
            objM79622d = m79622d();
        } catch (IllegalArgumentException e10) {
            C12836o.m77099d("MutiCardHwImpl", "getSubscriberId exception:" + e10.getClass().getSimpleName(), true);
        } catch (NoSuchMethodException e11) {
            C12836o.m77099d("MutiCardHwImpl", "getSubscriberId exception:" + e11.getClass().getSimpleName(), true);
        } catch (NullPointerException e12) {
            C12836o.m77099d("MutiCardHwImpl", "getSubscriberId exception:" + e12.getClass().getSimpleName(), true);
        } catch (InvocationTargetException e13) {
            C12836o.m77099d("MutiCardHwImpl", "getSubscriberId exception:" + e13.getClass().getSimpleName(), true);
        } catch (Exception e14) {
            C12836o.m77099d("MutiCardHwImpl", "getSubscriberId exception:" + e14.getClass().getSimpleName(), true);
        }
        String str = objM79622d != null ? (String) objM79622d.getClass().getMethod("getSubscriberId", clsArr).invoke(objM79622d, objArr) : "";
        return str == null ? "" : str;
    }
}
