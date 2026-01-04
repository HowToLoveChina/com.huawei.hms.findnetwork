package com.huawei.openalliance.p169ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.mc */
/* loaded from: classes8.dex */
public class C7421mc {

    /* renamed from: a */
    private b f34482a;

    /* renamed from: b */
    private a f34483b;

    /* renamed from: c */
    private Context f34484c;

    /* renamed from: d */
    private AudioManager f34485d;

    /* renamed from: e */
    private boolean f34486e = false;

    /* renamed from: com.huawei.openalliance.ad.mc$a */
    public static class a extends BroadcastReceiver {

        /* renamed from: a */
        private WeakReference<C7421mc> f34487a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b bVarM45674b;
            try {
                if (!Constants.VOLUME_CHANGED_ACTION.equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0) != 3) {
                    if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0) != 1) {
                        return;
                    }
                }
                C7421mc c7421mc = this.f34487a.get();
                if (c7421mc == null || (bVarM45674b = c7421mc.m45674b()) == null) {
                    return;
                }
                bVarM45674b.mo45652a();
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("VolumeChangeObserver", "onReceive error:" + th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mc$b */
    public interface b {
        /* renamed from: a */
        void mo45652a();
    }

    public C7421mc(Context context) {
        this.f34484c = context;
        this.f34485d = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public b m45674b() {
        return this.f34482a;
    }

    /* renamed from: a */
    public float m45675a(boolean z10) {
        AudioManager audioManager = this.f34485d;
        if (audioManager != null) {
            return C7422md.m45678a(audioManager, z10);
        }
        return 0.0f;
    }

    /* renamed from: a */
    public void m45676a() {
        if (this.f34486e) {
            try {
                this.f34484c.unregisterReceiver(this.f34483b);
            } catch (Exception e10) {
                AbstractC7185ho.m43820b("VolumeChangeObserver", "unregisterReceiver, " + e10.getClass().getSimpleName());
            }
            this.f34482a = null;
            this.f34486e = false;
        }
    }

    /* renamed from: a */
    public void m45677a(b bVar) {
        this.f34482a = bVar;
    }
}
