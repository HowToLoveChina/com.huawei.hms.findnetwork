package com.huawei.openalliance.p169ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.android.SystemUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.cc */
/* loaded from: classes8.dex */
public class C6986cc implements InterfaceC6998co {

    /* renamed from: a */
    protected Context f32106a;

    /* renamed from: b */
    protected C7787cg f32107b;

    /* renamed from: c */
    private boolean f32108c;

    /* renamed from: d */
    private BroadcastReceiver f32109d = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.cc.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.cc.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent2 = intent;
                        if (intent2 != null && intent2.getExtras() != null) {
                            if (intent.getExtras().getBoolean(Constants.USB_STATE_CONNECTED)) {
                                C6986cc.this.f32108c = true;
                                AbstractC7014dc.m41892o();
                            } else {
                                C6986cc.this.f32108c = false;
                            }
                        }
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43823c("BaseDeviceImpl", "onReceive error:" + th2.getClass().getSimpleName());
                    }
                }
            });
        }
    };

    public C6986cc(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f32106a = applicationContext;
        this.f32107b = C7787cg.m47900a(applicationContext);
        m41168s();
    }

    /* renamed from: s */
    private void m41168s() {
        AbstractC7185ho.m43817a("BaseDeviceImpl", "registerUSBObserver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.ACTION_USB_STATE);
        AbstractC7741ao.m47536a(this.f32106a, this.f32109d, intentFilter);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public int mo41169a(View view) {
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: b */
    public String mo41173b() {
        String strM48289a = AbstractC7811dd.m48289a("ro.product.model");
        return TextUtils.isEmpty(strM48289a) ? Build.MODEL : strM48289a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: c */
    public String mo41174c() {
        String strM48289a = AbstractC7811dd.m48289a("ro.build.huawei.display.id");
        return TextUtils.isEmpty(strM48289a) ? Build.DISPLAY : strM48289a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: d */
    public boolean mo41175d() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: e */
    public String mo41176e() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: f */
    public String mo41177f() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: g */
    public boolean mo41178g() {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: h */
    public Integer mo41179h() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: i */
    public String mo41180i() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: j */
    public String mo41181j() {
        String strM48289a = AbstractC7811dd.m48289a("ro.product.manufacturer");
        if (TextUtils.isEmpty(strM48289a)) {
            strM48289a = Build.MANUFACTURER;
        }
        return strM48289a.toUpperCase(Locale.ENGLISH);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: k */
    public String mo41182k() {
        String strM48289a = AbstractC7811dd.m48289a(SystemUtils.PRODUCT_BRAND);
        if (TextUtils.isEmpty(strM48289a)) {
            strM48289a = Build.BOARD;
        }
        return strM48289a.toUpperCase(Locale.ENGLISH);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: l */
    public boolean mo41183l() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: m */
    public boolean mo41184m() {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: n */
    public boolean mo41185n() {
        return this.f32108c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: o */
    public String mo41186o() {
        boolean zMo41184m = mo41184m();
        Context context = this.f32106a;
        return AbstractC7806cz.m48183l(zMo41184m ? C7124fh.m43316b(context).mo43382bI() : C6984ca.m41165a(context).mo41217a());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: p */
    public String mo41187p() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: q */
    public String mo41188q() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: r */
    public boolean mo41189r() {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41170a() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41171a(Context context) {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41172a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("BaseDeviceImpl", "check widget available error");
            return false;
        }
    }
}
