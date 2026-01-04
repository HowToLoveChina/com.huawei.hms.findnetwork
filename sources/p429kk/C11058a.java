package p429kk;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Random;

/* renamed from: kk.a */
/* loaded from: classes6.dex */
public class C11058a {
    /* renamed from: a */
    public static C11060c m66626a(String str, String str2, String str3) {
        if (str == null || str.isEmpty()) {
            str = m66627b("00000");
        }
        C11060c c11060c = new C11060c();
        c11060c.m66664t(str2);
        c11060c.m66644J(str3);
        c11060c.m66643I(str);
        String str4 = str.split("_")[0];
        if (C11059b.m66633f().contains(str4)) {
            c11060c.m66637C("com.huawei.hidisk\u0001_notepadsync");
            c11060c.m66670z("2.0");
        } else if (C11059b.m66628a().contains(str4)) {
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudbackup");
            c11060c.m66670z("5.0");
        } else if (C11059b.m66631d().contains(str4)) {
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudalbum");
            c11060c.m66670z("4.0");
        } else if (C11059b.m66630c().contains(str4)) {
            c11060c.m66637C("com.huawei.hidisk\u0001_clouddrive");
            c11060c.m66670z("2.0");
        } else if (C11059b.m66629b().contains(str4)) {
            c11060c.m66637C("com.huawei.hidisk\u0001_cloud");
            c11060c.m66670z("1.0");
        } else if (C11059b.m66632e().contains(str4)) {
            c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
            c11060c.m66670z("2.0");
        }
        c11060c.m66636B(str4);
        return c11060c;
    }

    /* renamed from: b */
    public static String m66627b(String str) {
        if (str == null || str.isEmpty()) {
            str = "00000";
        }
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder(8);
        Random random = new Random();
        for (int i10 = 0; i10 < 8; i10++) {
            sb3.append(random.nextInt(10));
        }
        sb2.append(str);
        sb2.append("_");
        sb2.append(HiAnalyticsConstant.KeyAndValue.NUMBER_01);
        sb2.append("_");
        sb2.append(System.currentTimeMillis() / 1000);
        sb2.append("_");
        sb2.append((CharSequence) sb3);
        return sb2.toString();
    }
}
