package p434kt;

import android.os.Build;
import android.text.TextUtils;

/* renamed from: kt.b */
/* loaded from: classes2.dex */
public class C11148b {
    /* renamed from: a */
    public static String m67059a() {
        String strM67076b = AbstractC11154h.m67076b("ro.product.model");
        return TextUtils.isEmpty(strM67076b) ? Build.MODEL : strM67076b;
    }
}
