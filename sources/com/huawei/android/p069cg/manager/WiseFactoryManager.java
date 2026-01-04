package com.huawei.android.p069cg.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.videokit.player.InitFactoryCallback;
import com.huawei.hms.videokit.player.WisePlayerFactory;
import com.huawei.hms.videokit.player.WisePlayerFactoryOptionsExt;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0213f;
import p031b7.C1120a;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class WiseFactoryManager {

    /* renamed from: d */
    public static WiseFactoryManager f11020d = null;

    /* renamed from: e */
    public static boolean f11021e = false;

    /* renamed from: a */
    public WisePlayerFactory f11022a;

    /* renamed from: b */
    public List<String> f11023b = new ArrayList();

    /* renamed from: c */
    public Context f11024c;

    /* renamed from: com.huawei.android.cg.manager.WiseFactoryManager$a */
    public class C2310a implements InitFactoryCallback {
        public C2310a() {
        }

        @Override // com.huawei.hms.videokit.player.InitFactoryCallback
        public void onFailure(int i10, String str) {
            C1120a.m6677i("WiseFactoryManager", "initPlayerFactory fail, errorCode: " + i10);
        }

        @Override // com.huawei.hms.videokit.player.InitFactoryCallback
        public void onSuccess(WisePlayerFactory wisePlayerFactory) {
            C1120a.m6677i("WiseFactoryManager", "initPlayerFactory success");
            WiseFactoryManager.m14530d(WiseFactoryManager.this.f11024c).m14536j(WiseFactoryManager.this.f11022a);
            WiseFactoryManager.m14532i(true);
        }
    }

    public WiseFactoryManager(Context context) {
        this.f11024c = context;
    }

    /* renamed from: c */
    public static boolean m14529c() {
        return f11021e;
    }

    /* renamed from: d */
    public static WiseFactoryManager m14530d(Context context) {
        if (f11020d == null) {
            f11020d = new WiseFactoryManager(context);
        }
        return f11020d;
    }

    /* renamed from: f */
    public static String m14531f(Context context, int i10) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("activity");
        if (!(systemService instanceof ActivityManager) || (runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i10) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: i */
    public static void m14532i(boolean z10) {
        f11021e = z10;
    }

    /* renamed from: e */
    public WisePlayerFactory m14533e() {
        return this.f11022a;
    }

    /* renamed from: g */
    public final void m14534g() {
        C1120a.m6677i("WiseFactoryManager", "initPlayFactory");
        String strM80954p = C13452e.m80781L().m80954p();
        WisePlayerFactory.initFactory(C0213f.m1377a(), new WisePlayerFactoryOptionsExt.Builder().setDeviceId(strM80954p).setServeCountry(C13452e.m80781L().m80942m()).build(), new C2310a());
    }

    /* renamed from: h */
    public void m14535h() {
        String strM14531f = m14531f(this.f11024c, Process.myPid());
        if (TextUtils.isEmpty(strM14531f) || !strM14531f.endsWith(":player")) {
            return;
        }
        m14534g();
    }

    /* renamed from: j */
    public void m14536j(WisePlayerFactory wisePlayerFactory) {
        this.f11022a = wisePlayerFactory;
    }
}
