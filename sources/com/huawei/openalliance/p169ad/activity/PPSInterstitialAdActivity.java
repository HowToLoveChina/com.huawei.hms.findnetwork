package com.huawei.openalliance.p169ad.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.C8148r;
import com.huawei.openalliance.p169ad.views.PPSInterstitialView;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class PPSInterstitialAdActivity extends AbstractActivityC6905e implements PPSInterstitialView.InterfaceC7956b {

    /* renamed from: a */
    private static final byte[] f31745a = new byte[0];

    /* renamed from: b */
    private static final ConcurrentHashMap<String, InterfaceC7311a> f31746b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private C7301d f31747c;

    /* renamed from: d */
    private String f31748d;

    /* renamed from: e */
    private C8148r f31749e;

    /* renamed from: f */
    private String f31750f;

    /* renamed from: g */
    private int f31751g;

    /* renamed from: com.huawei.openalliance.ad.activity.PPSInterstitialAdActivity$a */
    public class C6888a implements InterfaceC7311a {
        private C6888a() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: a */
        public void mo38577a() {
            InterfaceC7311a interfaceC7311a = (InterfaceC7311a) PPSInterstitialAdActivity.f31746b.get(PPSInterstitialAdActivity.this.f31750f);
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38577a();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: b */
        public void mo38579b() {
            InterfaceC7311a interfaceC7311a = (InterfaceC7311a) PPSInterstitialAdActivity.f31746b.get(PPSInterstitialAdActivity.this.f31750f);
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38579b();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: c */
        public void mo38580c() {
            InterfaceC7311a interfaceC7311a = (InterfaceC7311a) PPSInterstitialAdActivity.f31746b.get(PPSInterstitialAdActivity.this.f31750f);
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38580c();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: d */
        public void mo38581d() {
            InterfaceC7311a interfaceC7311a = (InterfaceC7311a) PPSInterstitialAdActivity.f31746b.get(PPSInterstitialAdActivity.this.f31750f);
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38581d();
            }
            PPSInterstitialAdActivity.this.finish();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: e */
        public void mo38582e() {
            InterfaceC7311a interfaceC7311a = (InterfaceC7311a) PPSInterstitialAdActivity.f31746b.get(PPSInterstitialAdActivity.this.f31750f);
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38582e();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: f */
        public void mo38583f() {
            InterfaceC7311a interfaceC7311a = (InterfaceC7311a) PPSInterstitialAdActivity.f31746b.get(PPSInterstitialAdActivity.this.f31750f);
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38583f();
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: a */
        public void mo38578a(int i10, int i11) {
            InterfaceC7311a interfaceC7311a = (InterfaceC7311a) PPSInterstitialAdActivity.f31746b.get(PPSInterstitialAdActivity.this.f31750f);
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38578a(i10, i11);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSInterstitialView.InterfaceC7956b
    /* renamed from: b */
    public void mo38736b() {
        finish();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        InterfaceC7311a interfaceC7311a = f31746b.get(this.f31750f);
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38581d();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AbstractC7185ho.m43820b("PPSInterstitialAdActivity", "onCreate");
        try {
            this.f31748d = getIntent().getStringExtra("sdk_version");
            C7301d c7301dM41879c = AbstractC7014dc.m41879c();
            this.f31747c = c7301dM41879c;
            if (c7301dM41879c == null) {
                finish();
                return;
            }
            this.f31750f = c7301dM41879c.getUniqueId();
            AbstractC7811dd.m48290a(this, AbstractC7811dd.m48335k(this));
            this.f31749e.setOnCloseListener(this);
            this.f31749e.m50472a(new C6888a());
            this.f31749e.m50471a(this.f31747c, getResources().getConfiguration().orientation, this.f31748d);
        } catch (IllegalStateException e10) {
            AbstractC7185ho.m43823c("PPSInterstitialAdActivity", "init interstitial ad " + e10.getClass().getSimpleName());
        } catch (Throwable th2) {
            AbstractC7185ho.m43820b("PPSInterstitialAdActivity", "init interstitial ad fail " + th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C8148r c8148r = this.f31749e;
        if (c8148r != null) {
            c8148r.m50468a();
            this.f31749e.destroyView();
            this.f31749e = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onPause() {
        AbstractC7185ho.m43820b("PPSInterstitialAdActivity", "onPause");
        C8148r c8148r = this.f31749e;
        if (c8148r != null) {
            c8148r.pauseView();
        }
        super.onPause();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        AbstractC7185ho.m43820b("PPSInterstitialAdActivity", "onResume");
        C8148r c8148r = this.f31749e;
        if (c8148r != null) {
            c8148r.resumeVideoView();
        }
        super.onResume();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        int iMo43390bQ = C7124fh.m43316b(this).mo43390bQ();
        this.f31751g = iMo43390bQ;
        if (iMo43390bQ != 1 && iMo43390bQ != 0) {
            this.f31751g = C6982bz.m41148a(this).mo41175d() ? 1 : 0;
        }
        AbstractC7185ho.m43818a("PPSInterstitialAdActivity", "iteAdFs %d", Integer.valueOf(this.f31751g));
        C8148r c8148r = new C8148r(this);
        this.f31749e = c8148r;
        setContentView(c8148r);
        Window window = getWindow();
        try {
            if (this.f31751g == 1) {
                window.getDecorView().setBackground(getResources().getDrawable(C6849R.color.hiad_80_percent_white));
            } else {
                window.getDecorView().setBackground(getResources().getDrawable(C6849R.color.hiad_black));
                window.getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-17));
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        } catch (Throwable th2) {
            AbstractC7185ho.m43820b("PPSInterstitialAdActivity", "interstitial adapterONotch error " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m38734a(String str, InterfaceC7311a interfaceC7311a) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str2 = "PPSInterstitialAdActivity";
            str3 = "registerInterstitialAdStatusListener key is null";
        } else {
            if (interfaceC7311a != null) {
                synchronized (f31745a) {
                    f31746b.put(str, interfaceC7311a);
                }
                return;
            }
            str2 = "PPSInterstitialAdActivity";
            str3 = "registerInterstitialAdStatusListener listner is null";
        }
        AbstractC7185ho.m43823c(str2, str3);
    }
}
