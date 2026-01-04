package com.huawei.hms.network.embedded;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;

/* renamed from: com.huawei.hms.network.embedded.u3 */
/* loaded from: classes8.dex */
public class C6110u3 {

    /* renamed from: d */
    public static final String f28479d = "SceneHelper";

    /* renamed from: e */
    public static final int f28480e = 0;

    /* renamed from: f */
    public static final int f28481f = 1;

    /* renamed from: g */
    public static final int f28482g = 2;

    /* renamed from: h */
    public static final int f28483h = 3;

    /* renamed from: i */
    public static final String f28484i = "metro";

    /* renamed from: j */
    public static final String f28485j = "railway";

    /* renamed from: k */
    public static final String f28486k = "airport";

    /* renamed from: l */
    public static final String f28487l = "RegisterScene";

    /* renamed from: m */
    public static final String f28488m = "pid";

    /* renamed from: n */
    public static final String f28489n = "uid";

    /* renamed from: o */
    public static final String f28490o = "packageName";

    /* renamed from: p */
    public static final String f28491p = "hms_cp_bundle_key";

    /* renamed from: q */
    public static final String f28492q = "content://com.huawei.hms.contentprovider/com.huawei.hms.wireless/qoe";

    /* renamed from: r */
    public static final Uri f28493r = Uri.parse("content://com.huawei.hms.contentprovider/com.huawei.hms.wireless/observe_metro");

    /* renamed from: s */
    public static final Uri f28494s = Uri.parse(C6073r5.f28047i);

    /* renamed from: t */
    public static final String f28495t = "RegisterWeakSignal";

    /* renamed from: u */
    public static final String f28496u = "QueryMetroInfo";

    /* renamed from: v */
    public static volatile C6110u3 f28497v;

    /* renamed from: a */
    public Context f28498a;

    /* renamed from: b */
    public a f28499b = null;

    /* renamed from: c */
    public String f28500c;

    /* renamed from: com.huawei.hms.network.embedded.u3$a */
    public class a extends ContentObserver {

        /* renamed from: a */
        public Context f28501a;

        public a(Handler handler, Context context) {
            super(handler);
            this.f28501a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            Logger.m32143v(C6110u3.f28479d, "scenne change");
            C6110u3.this.m35499a(this.f28501a);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.u3$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString(C6110u3.f28491p, C6110u3.f28492q);
            try {
                Bundle bundleCall = C6110u3.this.f28498a.getContentResolver().call(C6110u3.f28494s, C6110u3.f28495t, C6110u3.this.f28498a.getPackageName(), bundle);
                if (bundleCall == null) {
                    Logger.m32141i(C6110u3.f28479d, "register scene bundle is null");
                } else {
                    Logger.m32143v(C6110u3.f28479d, "register scene bundle not null");
                    for (String str : bundleCall.keySet()) {
                        Logger.m32143v(C6110u3.f28479d, "key:" + str + " value:" + bundleCall.getInt(str));
                    }
                }
                C6110u3 c6110u3 = C6110u3.this;
                c6110u3.f28499b = c6110u3.new a(null, c6110u3.f28498a);
                C6110u3.this.f28498a.getContentResolver().registerContentObserver(C6110u3.f28493r, true, C6110u3.this.f28499b);
                Logger.m32141i(C6110u3.f28479d, "register scene callback success");
                C6110u3 c6110u32 = C6110u3.this;
                c6110u32.m35499a(c6110u32.f28498a);
            } catch (Exception e10) {
                Logger.m32141i(C6110u3.f28479d, "register scene callback fail");
                Logger.m32143v(C6110u3.f28479d, "register scene callback fail:" + e10.getMessage());
            }
        }
    }

    public static C6110u3 getInstance() {
        if (f28497v == null) {
            synchronized (C6110u3.class) {
                try {
                    if (f28497v == null) {
                        f28497v = new C6110u3();
                    }
                } finally {
                }
            }
        }
        return f28497v;
    }

    public String getScene() {
        return this.f28500c;
    }

    public void registerSceneChangeListener(Context context) {
        this.f28498a = context;
        ExecutorsUtils.newThread(new b(), f28487l).start();
    }

    /* renamed from: a */
    private String m35497a(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : f28486k : f28485j : f28484i;
    }

    /* renamed from: a */
    private String m35498a(Bundle bundle) throws NumberFormatException {
        if (bundle == null) {
            Logger.m32141i(f28479d, "update scene bundle is null");
            return "";
        }
        Object obj = bundle.get("Scene");
        if (obj == null) {
            return "";
        }
        int i10 = Integer.parseInt(obj.toString());
        Logger.m32143v(f28479d, "getSceneFromBundle scene:" + i10);
        return m35497a(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m35499a(Context context) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(f28491p, f28492q);
            bundle.putInt(f28488m, Process.myPid());
            bundle.putInt("uid", Process.myUid());
            bundle.putString("packageName", this.f28498a.getPackageName());
            this.f28500c = m35498a(context.getContentResolver().call(f28494s, f28496u, this.f28498a.getPackageName(), bundle));
        } catch (Exception unused) {
            Logger.m32138e(f28479d, "providerCallToGetScene meet exception");
            this.f28500c = null;
        }
        Logger.m32141i(f28479d, "scene: " + this.f28500c);
    }
}
