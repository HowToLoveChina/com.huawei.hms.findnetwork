package com.huawei.ads.adsrec;

import android.content.Context;
import android.util.SparseArray;
import java.util.Arrays;
import p216d4.C9027o0;
import p216d4.InterfaceC9026o;
import p357i4.C10438c;
import p405jt.AbstractC10915a;

/* renamed from: com.huawei.ads.adsrec.u0 */
/* loaded from: classes.dex */
public class C2098u0 {

    /* renamed from: c */
    public static final SparseArray<String> f9502c = new SparseArray<>();

    /* renamed from: a */
    public Context f9503a;

    /* renamed from: b */
    public C9027o0 f9504b;

    public C2098u0(Context context) {
        SparseArray<String> sparseArray = f9502c;
        String str = InterfaceC9026o.f45668d;
        sparseArray.put(0, str);
        sparseArray.put(1, str);
        String str2 = InterfaceC9026o.f45669e;
        sparseArray.put(2, str2);
        sparseArray.put(3, str2);
        sparseArray.put(4, InterfaceC9026o.f45670f);
        sparseArray.put(5, InterfaceC9026o.f45671g);
        sparseArray.put(6, InterfaceC9026o.f45672h);
        Context applicationContext = context.getApplicationContext();
        this.f9503a = applicationContext;
        this.f9504b = C9027o0.m56955b(applicationContext);
    }

    /* renamed from: a */
    public C10438c m12557a(String str, String str2) {
        String strValueOf;
        int iM56962h = this.f9504b.m56962h(str2);
        AbstractC10915a.m65973e("REC_STR_SEL", "pkg: %s slotId: %s, selected strategy: %d", str, str2, Integer.valueOf(iM56962h));
        String str3 = f9502c.get(iM56962h);
        String[] strArr = null;
        if (str3 == null) {
            AbstractC10915a.m65979k("REC_STR_SEL", "strategy %d not found", Integer.valueOf(iM56962h));
            return null;
        }
        C10438c c10438c = new C10438c();
        c10438c.m64201g(str3);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf2 = String.valueOf(jCurrentTimeMillis);
        int iM56957a = this.f9504b.m56957a(str2);
        long jM56963i = jCurrentTimeMillis - (this.f9504b.m56963i(str2) * 60000);
        switch (iM56962h) {
            case 0:
            case 2:
                strValueOf = String.valueOf(0);
                strArr = new String[]{str, str2, strValueOf2, strValueOf2, strValueOf, String.valueOf(iM56957a), String.valueOf(jM56963i)};
                break;
            case 1:
            case 3:
                strValueOf = String.valueOf(1);
                strArr = new String[]{str, str2, strValueOf2, strValueOf2, strValueOf, String.valueOf(iM56957a), String.valueOf(jM56963i)};
                break;
            case 4:
            case 5:
            case 6:
                strArr = new String[]{str, str2, strValueOf2, strValueOf2, String.valueOf(iM56957a), String.valueOf(jM56963i)};
                break;
        }
        Arrays.toString(strArr);
        c10438c.m64202h(strArr);
        return c10438c;
    }
}
