package com.huawei.openalliance.p169ad.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.ca */
/* loaded from: classes2.dex */
public class C7781ca {

    /* renamed from: a */
    private final PackageManager f35971a;

    public C7781ca(Context context) {
        this.f35971a = context.getPackageManager();
    }

    /* renamed from: b */
    private boolean m47873b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f35971a.getPreferredActivities(arrayList, arrayList2, str);
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            AbstractC7185ho.m43818a("PackageManagerHelper", " preferredCompents pkg: %s", ((ComponentName) arrayList2.get(i10)).getPackageName());
        }
        return arrayList2.size() > 0;
    }

    /* renamed from: a */
    public String m47874a(Intent intent) {
        if (intent == null) {
            return null;
        }
        List<ResolveInfo> listQueryIntentActivities = this.f35971a.queryIntentActivities(intent, 0);
        int size = listQueryIntentActivities.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = listQueryIntentActivities.get(i10).activityInfo.packageName;
            if (m47873b(str)) {
                return str;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m47875a(java.lang.String r4) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r3 = this;
            java.lang.String r0 = "PackageManagerHelper"
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            android.content.pm.PackageManager r3 = r3.f35971a     // Catch: java.lang.Exception -> L11 android.content.pm.PackageManager.NameNotFoundException -> L2f
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r4, r2)     // Catch: java.lang.Exception -> L11 android.content.pm.PackageManager.NameNotFoundException -> L2f
            goto L39
        L11:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "getApplicationInfo "
            r4.append(r1)
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r0, r3)
            goto L38
        L2f:
            java.lang.String r3 = "isAppInstalledStatusEnable package not find! package:%s"
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r0, r3, r4)
        L38:
            r3 = 0
        L39:
            if (r3 == 0) goto L3e
            boolean r3 = r3.enabled
            return r3
        L3e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.C7781ca.m47875a(java.lang.String):boolean");
    }
}
