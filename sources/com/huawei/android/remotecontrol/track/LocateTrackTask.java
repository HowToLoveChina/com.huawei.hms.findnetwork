package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* loaded from: classes4.dex */
public class LocateTrackTask implements Runnable {

    /* renamed from: a */
    public Context f20357a;

    /* renamed from: b */
    public Handler f20358b;

    /* renamed from: c */
    public LocateTrackObject f20359c;

    /* renamed from: d */
    public TrackEventBroadcastReceiver f20360d;

    public LocateTrackTask(Context context) {
        this.f20357a = context.getApplicationContext();
        m26925e();
    }

    /* renamed from: c */
    public void m26923c() {
        long jM27026f = C4452n.m27026f(this.f20357a);
        if (jM27026f > 0) {
            this.f20358b.removeCallbacks(this);
            AlarmReceiver.m26865b(this.f20357a, jM27026f);
        }
    }

    /* renamed from: d */
    public void m26924d() {
        long jM27026f = C4452n.m27026f(this.f20357a);
        C13981a.m83989i("LocateTrackTask", "LocateTrackTask track period:" + jM27026f);
        if (jM27026f > 0) {
            C13981a.m83989i("LocateTrackTask", "LocateTrackTask start immediately...");
            AlarmReceiver.m26865b(this.f20357a, jM27026f);
            this.f20358b.removeCallbacks(this);
            this.f20358b.post(this);
        }
    }

    /* renamed from: e */
    public final void m26925e() {
        if (this.f20360d == null) {
            this.f20360d = new TrackEventBroadcastReceiver();
        }
        if (this.f20358b == null) {
            this.f20358b = new Handler(Looper.getMainLooper());
        }
        m26929i();
    }

    /* renamed from: f */
    public final /* synthetic */ void m26926f() {
        this.f20359c.mo26868f();
    }

    /* renamed from: g */
    public void m26927g() {
        if (this.f20358b != null) {
            AlarmReceiver.m26864a(this.f20357a);
            this.f20358b.removeCallbacks(this);
        }
        LocateTrackObject locateTrackObject = this.f20359c;
        if (locateTrackObject != null) {
            locateTrackObject.mo26869i();
        }
        C13981a.m83989i("LocateTrackTask", "LocateTrackTask pause...");
    }

    /* renamed from: h */
    public void m26928h() {
        if (this.f20358b != null) {
            AlarmReceiver.m26864a(this.f20357a);
            this.f20358b.removeCallbacks(this);
            this.f20358b = null;
        }
        LocateTrackObject locateTrackObject = this.f20359c;
        if (locateTrackObject != null) {
            locateTrackObject.mo26869i();
        }
        m26930j();
        C13981a.m83989i("LocateTrackTask", "LocateTrackTask quit...");
    }

    /* renamed from: i */
    public final void m26929i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
        intentFilter.addAction("com.huawei.android.remotecontrol.intent.STOP_TRACK");
        this.f20357a.registerReceiver(this.f20360d, intentFilter, "com.huawei.remotocontrol.permission.REMOTECALL", null);
    }

    /* renamed from: j */
    public final void m26930j() {
        TrackEventBroadcastReceiver trackEventBroadcastReceiver = this.f20360d;
        if (trackEventBroadcastReceiver != null) {
            this.f20357a.unregisterReceiver(trackEventBroadcastReceiver);
            this.f20360d = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() throws NumberFormatException {
        int i10;
        C13981a.m83989i("LocateTrackTask", "LocateTrackTask run...");
        try {
            i10 = Integer.parseInt(AbstractC12139d.m72766e(this.f20357a).getSiteID());
        } catch (NumberFormatException e10) {
            C13981a.m83988e("LocateTrackTask", "startLocateTrackTask NumberFormatException" + e10.getMessage());
            i10 = -1;
        }
        this.f20359c = C4440b.m26935e(i10, this.f20357a);
        new Handler().postDelayed(new Runnable() { // from class: com.huawei.android.remotecontrol.track.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f20389a.m26926f();
            }
        }, 3000L);
    }
}
