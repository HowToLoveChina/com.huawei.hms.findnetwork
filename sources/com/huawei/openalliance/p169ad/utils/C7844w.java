package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.HashSet;

/* renamed from: com.huawei.openalliance.ad.utils.w */
/* loaded from: classes2.dex */
public class C7844w {

    /* renamed from: a */
    private static C7844w f36155a;

    /* renamed from: b */
    private static final byte[] f36156b = new byte[0];

    /* renamed from: c */
    private Context f36157c;

    /* renamed from: d */
    private String f36158d = "0";

    private C7844w(Context context) {
        this.f36157c = context.getApplicationContext();
        m48515d();
    }

    /* renamed from: a */
    public static C7844w m48512a(Context context) {
        return m48514b(context);
    }

    /* renamed from: b */
    private static C7844w m48514b(Context context) {
        C7844w c7844w;
        synchronized (f36156b) {
            try {
                if (f36155a == null) {
                    f36155a = new C7844w(context);
                }
                c7844w = f36155a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7844w;
    }

    /* renamed from: d */
    private void m48515d() {
        HashSet hashSet;
        String str;
        PackageManager packageManager = this.f36157c.getPackageManager();
        if (packageManager == null) {
            AbstractC7185ho.m43826d("DeviceTypeUtil", "packageManager is null.");
            return;
        }
        try {
            FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
            hashSet = new HashSet();
            if (systemAvailableFeatures != null) {
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    if (!TextUtils.isEmpty(featureInfo.name)) {
                        AbstractC7185ho.m43817a("DeviceTypeUtil", "add feature:" + featureInfo.name);
                        hashSet.add(featureInfo.name);
                    }
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("DeviceTypeUtil", "get device type error:" + th2.getClass().getSimpleName());
        }
        if (hashSet.contains("com.huawei.software.features.handset") || hashSet.contains("com.hihonor.software.features.handset")) {
            str = "0";
        } else if (hashSet.contains("com.huawei.software.features.pad") || hashSet.contains("com.hihonor.software.features.pad")) {
            str = "1";
        } else if (hashSet.contains("com.huawei.software.features.mobiletv") || hashSet.contains("com.hihonor.software.features.mobiletv")) {
            str = "5";
        } else if (hashSet.contains("com.huawei.software.features.tv") || hashSet.contains("com.hihonor.software.features.tv")) {
            str = "4";
        } else if (hashSet.contains("com.huawei.software.features.kidwatch") || hashSet.contains("com.hihonor.software.features.kidwatch")) {
            str = "3";
        } else {
            if (!hashSet.contains("com.huawei.software.features.watch") && !hashSet.contains("com.hihonor.software.features.watch")) {
                String strM48289a = AbstractC7811dd.m48289a("ro.build.characteristics");
                AbstractC7185ho.m43820b("DeviceTypeUtil", "characteristics:" + strM48289a);
                m48513a(strM48289a);
                AbstractC7185ho.m43820b("DeviceTypeUtil", "type is:" + this.f36158d);
            }
            str = "2";
        }
        this.f36158d = str;
        AbstractC7185ho.m43820b("DeviceTypeUtil", "type is:" + this.f36158d);
    }

    /* renamed from: c */
    public int m48518c() {
        if ("4".equalsIgnoreCase(this.f36158d)) {
            return 8;
        }
        return "1".equalsIgnoreCase(this.f36158d) ? 5 : 4;
    }

    /* renamed from: a */
    public String m48516a() {
        return this.f36158d;
    }

    /* renamed from: b */
    public boolean m48517b() {
        return "4".equalsIgnoreCase(m48512a(this.f36157c).m48516a());
    }

    /* renamed from: a */
    private void m48513a(String str) {
        String str2;
        if (str.equals("default")) {
            str2 = "0";
        } else if (str.equals("tablet")) {
            str2 = "1";
        } else if (!str.equals("tv")) {
            return;
        } else {
            str2 = "4";
        }
        this.f36158d = str2;
    }
}
