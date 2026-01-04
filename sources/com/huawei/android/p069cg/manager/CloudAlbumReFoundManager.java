package com.huawei.android.p069cg.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import java.util.HashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p292fn.C9733f;
import p547p7.C12116d;
import p547p7.C12119g;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class CloudAlbumReFoundManager {

    /* renamed from: a */
    public ReFoundReceiver f11009a;

    /* renamed from: b */
    public C12116d f11010b;

    /* renamed from: c */
    public C12119g f11011c;

    /* renamed from: d */
    public final HashMap<Integer, String> f11012d;

    public class ReFoundReceiver extends BroadcastReceiver {
        public ReFoundReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            try {
                String action = safeIntent.getAction();
                C1120a.m6677i("CloudAlbumReFoundManager", "onReceive action: " + action);
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    int iM1225Y = C0209d.m1225Y(context);
                    C1120a.m6677i("CloudAlbumReFoundManager", "net work change type: " + iM1225Y);
                    if (C0209d.m1254f2(context)) {
                        return;
                    }
                    CloudAlbumReFoundManager.this.m14516a(107, "networkType: " + iM1225Y);
                    return;
                }
                if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                    C1120a.m6678w("CloudAlbumReFoundManager", "not support action: " + action);
                    return;
                }
                int intExtra = safeIntent.getIntExtra("plugged", -1);
                C1136q.b.m7109w1(context, intExtra);
                int intExtra2 = safeIntent.getIntExtra(FaqConstants.FAQ_LEVEL, 100);
                C1136q.b.m7103u1(context, intExtra2);
                int intExtra3 = safeIntent.getIntExtra("status", 1);
                C1136q.b.m7106v1(context, intExtra3);
                String str = "battery change chargePlug: " + intExtra + ", batteryLevel: " + intExtra2 + ", batteryStatus: " + intExtra3;
                C1120a.m6677i("CloudAlbumReFoundManager", str);
                if (C1122c.m6791i1(intExtra3)) {
                    return;
                }
                CloudAlbumReFoundManager.this.m14516a(108, str);
            } catch (Exception e10) {
                C1120a.m6676e("CloudAlbumReFoundManager", "onReceive getAction error: " + e10);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.manager.CloudAlbumReFoundManager$a */
    public class C2307a extends HashMap<Integer, String> {
        public C2307a() {
            put(102, "task end");
            put(103, "login off");
            put(104, "album switch off");
            put(107, "wifi disconnect");
            put(108, "batter no plugged");
        }
    }

    /* renamed from: com.huawei.android.cg.manager.CloudAlbumReFoundManager$b */
    public static class C2308b {

        /* renamed from: a */
        public static final CloudAlbumReFoundManager f11015a = new CloudAlbumReFoundManager(null);
    }

    /* renamed from: com.huawei.android.cg.manager.CloudAlbumReFoundManager$c */
    public static class C2309c extends AbstractC12367d {

        /* renamed from: a */
        public final String f11016a;

        /* renamed from: b */
        public final String f11017b;

        /* renamed from: c */
        public final int f11018c;

        /* renamed from: d */
        public final String f11019d;

        public C2309c(String str, String str2, int i10, String str3) {
            this.f11016a = str;
            this.f11017b = str2;
            this.f11018c = i10;
            this.f11019d = str3;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            new CommonOpsReport(C0213f.m1377a()).m15209C(this.f11016a, this.f11017b, this.f11018c, this.f11019d);
        }
    }

    public /* synthetic */ CloudAlbumReFoundManager(C2307a c2307a) {
        this();
    }

    /* renamed from: b */
    public static CloudAlbumReFoundManager m14515b() {
        return C2308b.f11015a;
    }

    /* renamed from: a */
    public synchronized void m14516a(int i10, String str) {
        String str2;
        C12515a c12515aM75110o;
        C2309c c2309c;
        C12515a c12515aM75110o2;
        C2309c c2309c2;
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = this.f11012d.get(Integer.valueOf(i10));
            } else {
                str2 = this.f11012d.get(Integer.valueOf(i10)) + ", " + str;
            }
            C1120a.m6677i("CloudAlbumReFoundManager", "cancelTask: " + i10 + ", reportMsg: " + str2);
            try {
                if (this.f11010b != null) {
                    try {
                        C1120a.m6677i("CloudAlbumReFoundManager", "AlbumLostRefundTask canceled");
                        this.f11010b.m72596m();
                        this.f11010b = null;
                        m14525k();
                        c12515aM75110o = C12515a.m75110o();
                        c2309c = new C2309c(C1122c.m6755Z0("04021"), "album_re_found_task_end", i10, str2);
                    } catch (Exception e10) {
                        C1120a.m6676e("CloudAlbumReFoundManager", "AlbumLostRefundTask canceled error: " + e10);
                        c12515aM75110o = C12515a.m75110o();
                        c2309c = new C2309c(C1122c.m6755Z0("04021"), "album_re_found_task_end", i10, str2);
                    }
                    c12515aM75110o.m75172d(c2309c);
                }
                if (this.f11011c != null) {
                    try {
                        try {
                            C1120a.m6677i("CloudAlbumReFoundManager", "ThumbFixTask canceled");
                            this.f11011c.m72655j(str2);
                            this.f11011c = null;
                            m14525k();
                            c12515aM75110o2 = C12515a.m75110o();
                            c2309c2 = new C2309c(C1122c.m6755Z0("04021"), "album_thumb_fix_task_end", i10, str2);
                        } catch (Throwable th2) {
                            C12515a.m75110o().m75172d(new C2309c(C1122c.m6755Z0("04021"), "album_thumb_fix_task_end", i10, str2));
                            throw th2;
                        }
                    } catch (Exception e11) {
                        C1120a.m6676e("CloudAlbumReFoundManager", "ThumbFixTask canceled error: " + e11);
                        c12515aM75110o2 = C12515a.m75110o();
                        c2309c2 = new C2309c(C1122c.m6755Z0("04021"), "album_thumb_fix_task_end", i10, str2);
                    }
                    c12515aM75110o2.m75172d(c2309c2);
                }
            } catch (Throwable th3) {
                C12515a.m75110o().m75172d(new C2309c(C1122c.m6755Z0("04021"), "album_re_found_task_end", i10, str2));
                throw th3;
            }
        } catch (Throwable th4) {
            throw th4;
        }
    }

    /* renamed from: c */
    public final void m14517c() {
        C1120a.m6677i("CloudAlbumReFoundManager", "initReceiver mReceiver: " + this.f11009a);
        if (this.f11009a == null) {
            this.f11009a = new ReFoundReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            C0213f.m1377a().registerReceiver(this.f11009a, intentFilter);
        }
    }

    /* renamed from: d */
    public final boolean m14518d(Context context, String str) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                C1120a.m6678w("CloudAlbumReFoundManager", str + " intent is null.");
                return false;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("status", 1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
            int intExtra3 = intentRegisterReceiver.getIntExtra(FaqConstants.FAQ_LEVEL, 100);
            boolean zM1254f2 = C0209d.m1254f2(context);
            boolean zM6783g1 = C1122c.m6783g1(intExtra, intExtra3, intExtra2);
            C1120a.m6677i("CloudAlbumReFoundManager", str + " wifiActive: " + zM1254f2 + ", charging: " + zM6783g1 + "(batteryStatus: " + intExtra + ", batteryLevel: " + intExtra3 + ", chargePlug: " + intExtra2 + ")");
            return zM1254f2 && zM6783g1;
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumReFoundManager", str + " exception: " + e10);
            return false;
        }
    }

    /* renamed from: e */
    public boolean m14519e() {
        return C9733f.m60705z().m60720O("enableCloudPhotoAssetRefundReplace");
    }

    /* renamed from: f */
    public final boolean m14520f() {
        Context contextM1377a = C0213f.m1377a();
        if (!C1136q.e.m7166d(contextM1377a)) {
            C1120a.m6677i("CloudAlbumReFoundManager", "isLostReFoundConditionAllow switch off");
            return false;
        }
        long jM6967h = C1136q.m6967h();
        C1120a.m6677i("CloudAlbumReFoundManager", "isLostReFoundConditionAllow latestReFoundTime: " + jM6967h + ", cloudPhotoAssetRefundPeriod: " + C1122c.m6770d0());
        if (System.currentTimeMillis() - jM6967h < r1 * 86400 * 1000) {
            C1120a.m6677i("CloudAlbumReFoundManager", "isLostReFoundConditionAllow in period");
            return false;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumReFoundManager", "isLostReFoundConditionAllow userId changed");
            return false;
        }
        boolean zM14521g = m14521g();
        boolean zM14376l = CloudAlbumSettings.m14363h().m14376l();
        C1120a.m6677i("CloudAlbumReFoundManager", "isLostReFoundConditionAllow isReFoundOpen: " + zM14521g + ", dataMigrated: " + zM14376l);
        return zM14521g && zM14376l && m14518d(contextM1377a, "isLostReFoundConditionAllow");
    }

    /* renamed from: g */
    public final boolean m14521g() {
        return C9733f.m60705z().m60720O("enableCloudPhotoAssetRefund");
    }

    /* renamed from: h */
    public final boolean m14522h() {
        Context contextM1377a = C0213f.m1377a();
        if (!C1136q.e.m7166d(contextM1377a)) {
            C1120a.m6677i("CloudAlbumReFoundManager", "isThumbFixConditionAllow switch off");
            return false;
        }
        long jM6970k = C1136q.m6970k();
        if (System.currentTimeMillis() - jM6970k < 86400000) {
            C1120a.m6677i("CloudAlbumReFoundManager", "isThumbFixConditionAllow in period, latestThumbFixTime: " + jM6970k);
            return false;
        }
        if (C13195l.m79272J().m79309Y()) {
            C1120a.m6678w("CloudAlbumReFoundManager", "isThumbFixConditionAllow userId changed");
            return false;
        }
        if (!C13452e.m80781L().m80791C0()) {
            return m14518d(contextM1377a, "isThumbFixConditionAllow");
        }
        C1120a.m6678w("CloudAlbumReFoundManager", "isThumbFixConditionAllow basic business");
        return false;
    }

    /* renamed from: i */
    public synchronized void m14523i() {
        try {
            C1120a.m6677i("CloudAlbumReFoundManager", "startTask: " + this.f11010b + ", " + this.f11011c);
            if (m14520f() && this.f11011c == null) {
                m14517c();
                if (this.f11010b == null) {
                    C1120a.m6677i("CloudAlbumReFoundManager", "AlbumLostRefundTask add");
                    this.f11010b = new C12116d();
                    C12515a.m75110o().m75175e(this.f11010b, true);
                } else {
                    C1120a.m6677i("CloudAlbumReFoundManager", "AlbumLostRefundTask is running");
                }
            } else if (m14522h() && this.f11010b == null) {
                m14517c();
                if (this.f11011c == null) {
                    C1120a.m6677i("CloudAlbumReFoundManager", "ThumbFixTask add");
                    this.f11011c = new C12119g();
                    C12515a.m75110o().m75175e(this.f11011c, true);
                } else {
                    C1120a.m6677i("CloudAlbumReFoundManager", "ThumbFixTask is running");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: j */
    public void m14524j(String str) {
        C1120a.m6677i("CloudAlbumReFoundManager", "taskEnd");
        m14516a(102, str);
    }

    /* renamed from: k */
    public final void m14525k() {
        C1120a.m6677i("CloudAlbumReFoundManager", "unRegisterReceiver");
        try {
            if (this.f11009a != null) {
                C0213f.m1377a().unregisterReceiver(this.f11009a);
                this.f11009a = null;
            }
        } catch (Exception e10) {
            C1120a.m6676e("CloudAlbumReFoundManager", "unRegisterReceiver error: " + e10);
        }
    }

    public CloudAlbumReFoundManager() {
        this.f11012d = new C2307a();
    }
}
