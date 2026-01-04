package ug;

import com.huawei.android.os.AntiTheftManagerEx;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0213f;
import p521og.C11877j;
import p809yg.C13981a;

/* renamed from: ug.a */
/* loaded from: classes4.dex */
public final class C13171a {

    /* renamed from: a */
    public static volatile boolean f59693a = false;

    /* renamed from: b */
    public static volatile boolean f59694b = false;

    /* renamed from: c */
    public static volatile boolean f59695c = true;

    /* renamed from: d */
    public static volatile boolean f59696d = false;

    /* renamed from: e */
    public static final Object f59697e = new Object();

    /* renamed from: a */
    public static boolean m79195a() {
        boolean z10;
        synchronized (f59697e) {
            try {
                if (!f59696d) {
                    f59695c = m79196b();
                    f59696d = true;
                    C13981a.m83989i("AntiTheftInf", "AntiTheftManagerEx getEnable = " + f59695c + " from Anti");
                }
                z10 = f59695c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    /* renamed from: b */
    public static boolean m79196b() {
        int i10 = 0;
        while (true) {
            if (i10 >= 4) {
                break;
            }
            try {
                if (AntiTheftManagerEx.getEnable()) {
                    return true;
                }
            } catch (Exception e10) {
                C13981a.m83988e("AntiTheftInf", "getEnable Exception: " + e10.getMessage());
                C13981a.m83989i("AntiTheftInf", "getEnable error:" + i10);
                i10++;
            }
        }
        return C11877j.m71302s(C0213f.m1377a());
    }

    /* renamed from: c */
    public static boolean m79197c() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("huawei.android.os.HwAntiTheftManager");
            return ((Boolean) cls.getMethod("getAntiTheftOldEnabled", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), new Object[0])).booleanValue();
        } catch (ClassNotFoundException e10) {
            C13981a.m83988e("AntiTheftInf", "getOldEnable ClassNotFoundException: " + e10.getMessage());
            return true;
        } catch (IllegalAccessException e11) {
            C13981a.m83988e("AntiTheftInf", "getOldEnable IllegalAccessException: " + e11.getMessage());
            return true;
        } catch (NoSuchMethodException e12) {
            C13981a.m83988e("AntiTheftInf", "getOldEnable NoSuchMethodException: " + e12.getMessage());
            return true;
        } catch (InvocationTargetException e13) {
            C13981a.m83988e("AntiTheftInf", "getOldEnable InvocationTargetException: " + e13.getMessage());
            return true;
        } catch (Exception e14) {
            C13981a.m83988e("AntiTheftInf", "getOldEnable Exception: " + e14.getMessage());
            return true;
        }
    }

    /* renamed from: d */
    public static boolean m79198d() {
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                f59693a = AntiTheftManagerEx.isAntiTheftSupported();
                C13981a.m83989i("AntiTheftInf", "isAntiTheftSupported  = " + f59693a);
                break;
            } catch (Exception e10) {
                C13981a.m83987d("AntiTheftInf", "Exception" + e10.getMessage());
                C13981a.m83989i("AntiTheftInf", "is AntiTheftSupported error:" + i10);
            } catch (NoClassDefFoundError e11) {
                C13981a.m83988e("AntiTheftInf", "NoClassDefFoundErrorError" + e11.getMessage());
                C13981a.m83989i("AntiTheftInf", "is AntiTheftSupported error:" + i10);
            }
        }
        return f59693a;
    }

    /* renamed from: e */
    public static boolean m79199e() {
        if (!f59694b) {
            synchronized (f59697e) {
                try {
                    if (!f59694b) {
                        m79198d();
                        f59694b = true;
                    }
                } finally {
                }
            }
        }
        return f59693a;
    }

    /* renamed from: f */
    public static byte[] m79200f() {
        byte[] bArr;
        synchronized (f59697e) {
            bArr = null;
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    bArr = AntiTheftManagerEx.read();
                } catch (Exception e10) {
                    C13981a.m83988e("AntiTheftInf", "read Exception: " + e10.getMessage());
                }
                if (bArr != null) {
                    break;
                }
                C13981a.m83990w("AntiTheftInf", "AntiTheftManagerEx read null data");
                C13981a.m83990w("AntiTheftInf", "AntiTheftManagerEx read null data");
            }
        }
        return bArr;
    }

    /* renamed from: g */
    public static void m79201g() {
        f59694b = false;
        f59696d = false;
    }

    /* renamed from: h */
    public static void m79202h(boolean z10) {
        synchronized (f59697e) {
            f59695c = z10;
            f59696d = true;
            int enable = -1;
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    enable = AntiTheftManagerEx.setEnable(z10);
                } catch (Exception e10) {
                    C13981a.m83988e("AntiTheftInf", "set Enable Exception: " + e10.getMessage());
                }
                C13981a.m83989i("AntiTheftInf", "AntiTheftManagerEx setEnable = " + z10 + " returnValue = " + enable + ",time:" + i10);
                boolean enable2 = AntiTheftManagerEx.getEnable();
                if (enable2 == z10) {
                    break;
                }
                C13981a.m83988e("AntiTheftInf", "AntiTheftManagerEx verifyEnable = " + enable2 + " not equal to setEnable = " + z10);
            }
        }
    }

    /* renamed from: i */
    public static int m79203i() {
        int iWipe;
        synchronized (f59697e) {
            iWipe = -1;
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    f59695c = false;
                    iWipe = AntiTheftManagerEx.wipe();
                    C13981a.m83989i("AntiTheftInf", "AntiTheftManagerEx wipe return value = " + iWipe);
                } catch (Exception e10) {
                    C13981a.m83988e("AntiTheftInf", "wipe Exception: " + e10.getMessage());
                }
                if (iWipe != -1) {
                    break;
                }
                C13981a.m83989i("AntiTheftInf", "AntiTheftManagerEx wipe:" + i10);
            }
        }
        return iWipe;
    }

    /* renamed from: j */
    public static int m79204j(byte[] bArr) {
        synchronized (f59697e) {
            if (bArr == null) {
                C13981a.m83988e("AntiTheftInf", "AntiTheftManagerEx write data null data");
                return 0;
            }
            int iWrite = 0;
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    if (bArr.length > AntiTheftManagerEx.getDataBlockSize()) {
                        C13981a.m83990w("AntiTheftInf", "AntiTheftManagerEx write data too big");
                    } else {
                        iWrite = AntiTheftManagerEx.write(bArr);
                        C13981a.m83989i("AntiTheftInf", "write data return value = " + iWrite);
                    }
                } catch (Exception e10) {
                    C13981a.m83988e("AntiTheftInf", "write Exception: " + e10.getMessage());
                }
                if (iWrite > 0) {
                    break;
                }
                C13981a.m83989i("AntiTheftInf", "write time:" + i10);
            }
            return iWrite;
        }
    }
}
