package p459lp;

import android.os.Build;
import android.text.TextUtils;
import p015ak.C0209d;

/* renamed from: lp.h */
/* loaded from: classes7.dex */
public class C11330h {

    /* renamed from: a */
    public static final String[] f53021a = {"NTH-AN00", "RNA-TN00", "RNA-AN00", "JLH-AN00", "NTN-AN20", "CHL-AN00", "CHL-AL00", "HJC-AN90", "NEW-AN90", "HJC-LX9", "KOZ-AL00", "KOZ-AL40", "NZA-AL00", "YOK-AN10", "ALA-AN70", "ELZ-AN00", "ELZ-AN10", "ELZ-AN20", "TFY-AN00", "KKG-AN70", "TFY-AN40", "AGM-W09HN", "AGM3-W09HN", "AGM3-AL09HN", "KJR-W09", "KRJ-AN00", "KRJ-W09", "KOB2-W09HN", "KOB2-AL00HN", "KRJ2-W09", "KRJ2-AN00", "BRT-W09", "BRT-AN09"};

    /* renamed from: a */
    public static boolean m68077a() {
        if (!C0209d.m1269j1()) {
            return true;
        }
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (String str2 : f53021a) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
