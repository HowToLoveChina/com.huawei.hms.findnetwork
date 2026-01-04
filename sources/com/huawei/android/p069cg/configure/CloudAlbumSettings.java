package com.huawei.android.p069cg.configure;

import android.content.Context;
import android.os.Bundle;
import ck.C1444b;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import gp.C10028c;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p281f8.C9665b;
import p292fn.C9733f;
import p336he.C10155f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p850zo.InterfaceC14351b;

/* loaded from: classes2.dex */
public class CloudAlbumSettings {

    /* renamed from: j */
    public static CloudAlbumSettings f10936j;

    /* renamed from: a */
    public Context f10937a;

    /* renamed from: d */
    public boolean f10940d;

    /* renamed from: e */
    public int f10941e;

    /* renamed from: f */
    public boolean f10942f;

    /* renamed from: b */
    public boolean f10938b = false;

    /* renamed from: c */
    public boolean f10939c = false;

    /* renamed from: g */
    public int f10943g = 0;

    /* renamed from: h */
    public int f10944h = 0;

    /* renamed from: i */
    public final Object f10945i = new Object();

    public static class CheckStatusTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f10946a;

        public CheckStatusTask(Context context) {
            this.f10946a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1122c.m6712L(this.f10946a);
            CloudAlbumSettings.m14363h().m14367D(C1122c.m6714L1(this.f10946a, C1122c.f5351e, new String[]{"is_mobile_switch_on"}));
            C1122c.m6816o2(1500L);
            C9665b.m60347d(2, 121);
        }
    }

    /* renamed from: com.huawei.android.cg.configure.CloudAlbumSettings$a */
    public class C2270a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC14351b f10947a;

        public C2270a(InterfaceC14351b interfaceC14351b) {
            this.f10947a = interfaceC14351b;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            CloudAlbumSettings cloudAlbumSettings = CloudAlbumSettings.this;
            cloudAlbumSettings.f10940d = C1122c.m6693E1(cloudAlbumSettings.f10937a);
            C1120a.m6677i("CloudAlbumSettings", "isSupportDisableAndResume:" + CloudAlbumSettings.this.f10940d);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSupportDisableAndResume", CloudAlbumSettings.this.f10940d);
            this.f10947a.onResult(bundle);
        }
    }

    /* renamed from: com.huawei.android.cg.configure.CloudAlbumSettings$b */
    public class C2271b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f10949a;

        public C2271b(Context context) {
            this.f10949a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            CloudAlbumSettings.this.f10940d = C1122c.m6693E1(this.f10949a);
        }
    }

    /* renamed from: h */
    public static synchronized CloudAlbumSettings m14363h() {
        try {
            if (f10936j == null) {
                f10936j = new CloudAlbumSettings();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f10936j;
    }

    /* renamed from: A */
    public void m14364A(InterfaceC14351b interfaceC14351b) {
        C12515a.m75110o().m75175e(new C2270a(interfaceC14351b), false);
    }

    /* renamed from: B */
    public void m14365B(boolean z10) {
        this.f10939c = z10;
    }

    /* renamed from: C */
    public void m14366C(int i10) {
        this.f10941e = i10;
    }

    /* renamed from: D */
    public void m14367D(boolean z10) {
        this.f10938b = z10;
    }

    /* renamed from: E */
    public void m14368E(boolean z10) {
        this.f10942f = z10;
    }

    /* renamed from: d */
    public void m14369d(Context context) {
        C1120a.m6677i("CloudAlbumSettings", "checkServiceStatus, isServiceConnected=" + this.f10942f);
        if (!C1136q.e.m7166d(context) || this.f10942f) {
            return;
        }
        C12515a.m75110o().m75175e(new CheckStatusTask(context), true);
    }

    /* renamed from: e */
    public int m14370e() {
        return this.f10941e;
    }

    /* renamed from: f */
    public void m14371f(Context context) {
        this.f10937a = context;
        boolean z10 = false;
        this.f10940d = false;
        m14372g(context);
        if (C9733f.m60705z().m60720O("enableCPULoadReductionPlus") || (C9733f.m60705z().m60720O("enableCPULoadReductionPlusForBeta") && C0209d.m1193N0())) {
            z10 = true;
        }
        C1120a.m6677i("CloudAlbumSettings", "isEnableCPULoadReductionPlus " + z10);
        C1444b.m8318x(z10);
    }

    /* renamed from: g */
    public void m14372g(Context context) {
        C12515a.m75110o().m75175e(new C2271b(context), false);
    }

    /* renamed from: i */
    public boolean m14373i() {
        return C9733f.m60705z().m60720O("isChildCodeOpen");
    }

    /* renamed from: j */
    public boolean m14374j() {
        return false;
    }

    /* renamed from: k */
    public boolean m14375k() {
        C1120a.m6675d("CloudAlbumSettings", "isCompressOpen ignore");
        return false;
    }

    /* renamed from: l */
    public boolean m14376l() {
        return "V2.0".equalsIgnoreCase(C1136q.d.m7144h()) && 1 == C1136q.d.m7156t();
    }

    /* renamed from: m */
    public boolean m14377m() {
        return !C10028c.m62182c0().m62420y1();
    }

    /* renamed from: n */
    public boolean m14378n() {
        return !C10028c.m62182c0().m62420y1();
    }

    /* renamed from: o */
    public boolean m14379o() {
        return m14386v() && this.f10939c;
    }

    /* renamed from: p */
    public boolean m14380p() {
        return this.f10938b;
    }

    /* renamed from: q */
    public boolean m14381q() {
        return this.f10942f;
    }

    /* renamed from: r */
    public boolean m14382r() {
        return C10155f.m63299w();
    }

    /* renamed from: s */
    public boolean m14383s() {
        return C10155f.m63300x();
    }

    /* renamed from: t */
    public boolean m14384t() {
        return C9733f.m60705z().m60720O("isShowUploadMidPage");
    }

    /* renamed from: u */
    public boolean m14385u() {
        return this.f10940d;
    }

    /* renamed from: v */
    public boolean m14386v() {
        HiCloudSysParamMap hiCloudSysParamMapM6839v0 = C1122c.m6839v0();
        if (hiCloudSysParamMapM6839v0 == null) {
            C1120a.m6678w("CloudAlbumSettings", "isSupportGalleryNetworkSwitch hiCloudSysParamMap is null");
            return false;
        }
        int enableForcedDownloadThumbnail = hiCloudSysParamMapM6839v0.getEnableForcedDownloadThumbnail();
        C1120a.m6675d("CloudAlbumSettings", "isSupportGalleryNetworkSwitch: " + enableForcedDownloadThumbnail);
        return enableForcedDownloadThumbnail == 1;
    }

    /* renamed from: w */
    public boolean m14387w() {
        C1120a.m6675d("CloudAlbumSettings", "isSyncing syncingState: " + this.f10944h + ", syncMark: 3");
        return this.f10943g != (this.f10944h & 3);
    }

    /* renamed from: x */
    public boolean m14388x() {
        return C9733f.m60705z().m60720O("isUseSelfDevPhotoPicker");
    }

    /* renamed from: y */
    public void m14389y(int i10) {
        synchronized (this.f10945i) {
            this.f10944h = (~i10) & this.f10944h;
            C1120a.m6675d("CloudAlbumSettings", "markSyncComplete: " + this.f10944h);
        }
    }

    /* renamed from: z */
    public void m14390z(int i10) {
        synchronized (this.f10945i) {
            this.f10944h = i10 | this.f10944h;
            C1120a.m6675d("CloudAlbumSettings", "markSyncing: " + this.f10944h);
        }
    }
}
