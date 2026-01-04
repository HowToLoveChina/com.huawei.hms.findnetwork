package com.huawei.android.remotecontrol.track;

import android.location.Location;
import p366if.C10487l;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.track.h */
/* loaded from: classes4.dex */
public class C4446h implements C10487l.b {

    /* renamed from: a */
    public BaiduLocateTrack f20393a;

    /* renamed from: b */
    public boolean f20394b = false;

    public C4446h(BaiduLocateTrack baiduLocateTrack) {
        this.f20393a = baiduLocateTrack;
    }

    @Override // p366if.C10487l.b
    /* renamed from: a */
    public void mo26992a(Location location) {
        C13981a.m83989i("MyBaiduLocationListener", "track location success");
        C13981a.m83987d("MyBaiduLocationListener", "provider:" + location.getProvider() + ", utc:" + location.getTime());
        this.f20393a.m26871m(location);
        this.f20393a.m26875q();
    }

    @Override // p366if.C10487l.b
    /* renamed from: b */
    public void mo26993b() {
        if (this.f20394b) {
            C13981a.m83989i("MyBaiduLocationListener", "track location == null");
            this.f20393a.m26870l(8);
            this.f20393a.m26875q();
        } else {
            this.f20394b = true;
            C13981a.m83989i("MyBaiduLocationListener", "track location failed,retry");
            this.f20393a.m26873o();
        }
    }
}
