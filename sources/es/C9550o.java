package es;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: es.o */
/* loaded from: classes8.dex */
public class C9550o {

    /* renamed from: a */
    public static AtomicBoolean f47457a;

    /* renamed from: b */
    public static AtomicBoolean f47458b;

    /* renamed from: c */
    public static AtomicInteger f47459c;

    /* renamed from: d */
    public static AtomicInteger f47460d;

    /* renamed from: e */
    public static AtomicBoolean f47461e;

    /* renamed from: a */
    public static String m59628a() {
        String strM59649d = C9554s.m59649d();
        C1016d.m6181a("ROMUtil", "Emui version name: " + strM59649d);
        return strM59649d;
    }

    /* renamed from: b */
    public static int m59629b() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        AtomicInteger atomicInteger = f47460d;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        int iM59631d = m59631d(0);
        if (iM59631d <= 0) {
            try {
                iM59631d = Integer.parseInt(C9554s.m59646a("ro.build.hw_emui_api_level", "0"));
            } catch (NumberFormatException unused) {
                C1016d.m6183c("ROMUtil", "NumberFormatException: get hw_emui_api_level failed");
            }
        }
        C1016d.m6181a("ROMUtil", "EMUI_VERSION_CODE: " + iM59631d);
        AtomicInteger atomicInteger2 = new AtomicInteger(iM59631d);
        f47460d = atomicInteger2;
        return atomicInteger2.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m59630c() throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            java.util.concurrent.atomic.AtomicInteger r0 = es.C9550o.f47459c
            if (r0 == 0) goto L9
            int r0 = r0.get()
            return r0
        L9:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            int r1 = m59629b()
            r0.getClass()
            java.lang.String r2 = "HONOR"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L38
            java.lang.String r2 = "HUAWEI"
            boolean r0 = r0.equals(r2)
            r2 = 27
            if (r0 != 0) goto L31
            if (r1 >= r2) goto L27
            goto L49
        L27:
            boolean r0 = m59636i()
            if (r0 == 0) goto L2f
            r0 = 4
            goto L4c
        L2f:
            r0 = 5
            goto L4c
        L31:
            if (r1 < r2) goto L35
            r0 = 3
            goto L4c
        L35:
            if (r1 <= 0) goto L49
            goto L3e
        L38:
            if (r1 <= 0) goto L40
            r0 = 25
            if (r1 > r0) goto L40
        L3e:
            r0 = 1
            goto L4c
        L40:
            r0 = 26
            if (r1 == r0) goto L4b
            r0 = 29
            if (r1 < r0) goto L49
            goto L4b
        L49:
            r0 = -1
            goto L4c
        L4b:
            r0 = 2
        L4c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Rom type is "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ROMUtil"
            as.C1016d.m6181a(r2, r1)
            java.util.concurrent.atomic.AtomicInteger r1 = new java.util.concurrent.atomic.AtomicInteger
            r1.<init>(r0)
            es.C9550o.f47459c = r1
            int r0 = r1.get()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: es.C9550o.m59630c():int");
    }

    /* renamed from: d */
    public static int m59631d(int i10) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        String str;
        try {
            Class<?> cls = Class.forName(EmuiUtil.BUILDEX_VERSION);
            Field field = cls.getField(EmuiUtil.EMUI_SDK_INT);
            AccessibleObject.setAccessible(new Field[]{field}, true);
            Object obj = field.get(cls);
            return (obj == null || !(obj instanceof Integer)) ? i10 : ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            str = "getVersionCodeFromBuild ClassCastException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (ClassNotFoundException unused2) {
            i10 = m59632e(i10);
            str = "getVersionCodeFromBuild ClassNotFoundException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (IllegalAccessException unused3) {
            str = "getVersionCodeFromBuild IllegalAccessException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (NoSuchFieldException unused4) {
            str = "getVersionCodeFromBuild NoSuchFieldException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (Exception unused5) {
            str = "getVersionCodeFromBuild unknown exception";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        }
    }

    /* renamed from: e */
    public static int m59632e(int i10) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        String str;
        try {
            Class<?> cls = Class.forName("com.hihonor.android.os.Build$VERSION");
            Field field = cls.getField(EmuiUtil.EMUI_SDK_INT);
            AccessibleObject.setAccessible(new Field[]{field}, true);
            Object obj = field.get(cls);
            return (obj == null || !(obj instanceof Integer)) ? i10 : ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            str = "getVersionCodeFromHonorBuild ClassCastException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (ClassNotFoundException unused2) {
            str = "getVersionCodeFromHonorBuild ClassNotFoundException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (IllegalAccessException unused3) {
            str = "getVersionCodeFromHonorBuild IllegalAccessException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (NoSuchFieldException unused4) {
            str = "getVersionCodeFromHonorBuild NoSuchFieldException";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        } catch (Exception unused5) {
            str = "getVersionCodeFromHonorBuild unknown exception";
            C1016d.m6183c("ROMUtil", str);
            return i10;
        }
    }

    /* renamed from: f */
    public static boolean m59633f() {
        AtomicBoolean atomicBoolean = f47457a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean zEqualsIgnoreCase = "CN".equalsIgnoreCase(C9554s.m59652g());
        C1016d.m6181a("ROMUtil", "isChineseRom is " + zEqualsIgnoreCase);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(zEqualsIgnoreCase);
        f47457a = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* renamed from: g */
    public static boolean m59634g() {
        AtomicBoolean atomicBoolean = f47458b;
        if (atomicBoolean != null) {
            atomicBoolean.get();
        }
        String strM59646a = C9554s.m59646a("ro.com.google.gmsversion", "");
        C1016d.m6181a("ROMUtil", "isGmsVersion is " + strM59646a);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(TextUtils.isEmpty(strM59646a) ^ true);
        f47458b = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* renamed from: h */
    public static boolean m59635h() {
        if (f47461e != null) {
            C1016d.m6181a("ROMUtil", "is huawei device:" + f47461e.get());
            return f47461e.get();
        }
        boolean z10 = m59630c() != -1;
        C1016d.m6181a("ROMUtil", "is huawei device:" + z10);
        AtomicBoolean atomicBoolean = new AtomicBoolean(z10);
        f47461e = atomicBoolean;
        return atomicBoolean.get();
    }

    /* renamed from: i */
    public static boolean m59636i() {
        return TextUtils.equals(C9554s.m59646a("hw_sc.product.useBrandCust", ""), FaqConstants.DISABLE_HA_REPORT);
    }
}
