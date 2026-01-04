package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.a */
/* loaded from: classes8.dex */
public abstract class AbstractC5096a {

    /* renamed from: a */
    protected Context f23281a;

    /* renamed from: b */
    protected int f23282b;

    /* renamed from: c */
    protected WeakReference<AppDownloadButton> f23283c;

    /* renamed from: d */
    private BroadcastReceiver f23284d;

    /* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.a$a */
    public static class a extends BroadcastReceiver {

        /* renamed from: a */
        Context f23285a;

        /* renamed from: b */
        AbstractC5096a f23286b;

        public a(Context context, AbstractC5096a abstractC5096a) {
            this.f23285a = context.getApplicationContext();
            this.f23286b = abstractC5096a;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                AbstractC7185ho.m43820b("BaseDwnButtonStyle", "on Receive");
                AbstractC5096a abstractC5096a = this.f23286b;
                if (abstractC5096a != null) {
                    abstractC5096a.f23282b = C7124fh.m43316b(this.f23285a).mo43436cg();
                    this.f23286b.mo30450a();
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("BaseDwnButtonStyle", "ui mode receiver err, %s", th2.getClass().getSimpleName());
            }
        }
    }

    public AbstractC5096a(Context context, AppDownloadButton appDownloadButton) {
        Context applicationContext = context.getApplicationContext();
        this.f23281a = applicationContext;
        this.f23282b = C7124fh.m43316b(applicationContext).mo43436cg();
        this.f23283c = new WeakReference<>(appDownloadButton);
    }

    /* renamed from: c */
    private void m30449c() {
        this.f23284d = new a(this.f23281a, this);
        AbstractC7741ao.m47536a(this.f23281a.getApplicationContext(), this.f23284d, new IntentFilter(Constants.UI_CHANGE_ACTION));
    }

    /* renamed from: a */
    public abstract void mo30450a();

    /* renamed from: a */
    public void m30451a(Context context) {
        mo30453b(context);
        mo30450a();
        m30449c();
    }

    /* renamed from: b */
    public void m30452b() {
        if (this.f23284d != null) {
            this.f23281a.getApplicationContext().unregisterReceiver(this.f23284d);
            this.f23284d = null;
        }
    }

    /* renamed from: b */
    public abstract void mo30453b(Context context);
}
