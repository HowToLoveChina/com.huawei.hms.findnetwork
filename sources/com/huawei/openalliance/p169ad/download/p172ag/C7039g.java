package com.huawei.openalliance.p169ad.download.p172ag;

import android.content.Context;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.huawei.openalliance.ad.download.ag.g */
/* loaded from: classes2.dex */
public class C7039g {

    /* renamed from: a */
    private AppDownloadTask f32328a;

    /* renamed from: b */
    private Timer f32329b;

    /* renamed from: c */
    private Context f32330c;

    /* renamed from: com.huawei.openalliance.ad.download.ag.g$a */
    public static class a extends TimerTask {

        /* renamed from: a */
        private AppDownloadTask f32331a;

        /* renamed from: b */
        private Context f32332b;

        public a(Context context, AppDownloadTask appDownloadTask) {
            this.f32331a = appDownloadTask;
            this.f32332b = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f32332b != null) {
                AbstractC7185ho.m43817a("TaskDelTimer", "del task");
                C7036d.m42166a(this.f32332b).m42111b((C7036d) this.f32331a);
            }
        }
    }

    public C7039g(Context context, AppDownloadTask appDownloadTask) {
        this.f32328a = appDownloadTask;
        this.f32330c = context.getApplicationContext();
    }

    /* renamed from: a */
    public void m42213a() {
        if (this.f32329b == null) {
            this.f32329b = new Timer();
        }
        AbstractC7185ho.m43817a("TaskDelTimer", "start timer");
        this.f32329b.schedule(new a(this.f32330c, this.f32328a), RippleView.SINGLE_RIPPLE_TIME);
    }
}
