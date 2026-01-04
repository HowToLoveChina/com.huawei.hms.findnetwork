package com.huawei.android.remotecontrol.track;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.track.i */
/* loaded from: classes4.dex */
public class C4447i implements LocationListener {

    /* renamed from: a */
    public GoogleLocateTrack f20395a;

    public C4447i(GoogleLocateTrack googleLocateTrack) {
        C13981a.m83989i("MyG_LocateTackLocationListener", "new listener");
        this.f20395a = googleLocateTrack;
    }

    /* renamed from: a */
    public final void m26994a(Location location) {
        if (location != null) {
            C13981a.m83989i("MyG_LocateTackLocationListener", "update G_Locate:" + location.getAccuracy() + "," + location.getTime());
        } else {
            C13981a.m83988e("MyG_LocateTackLocationListener", "updateG_Locate->location return null.");
        }
        this.f20395a.m26883A(location);
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location == null) {
            C13981a.m83988e("MyG_LocateTackLocationListener", "onLocationChanged,location is null");
        } else {
            m26994a(location);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        C13981a.m83987d("MyG_LocateTackLocationListener", "onProviderDisabled:" + str);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        C13981a.m83987d("MyG_LocateTackLocationListener", "onProviderEnabled: " + str);
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i10, Bundle bundle) {
        C13981a.m83987d("MyG_LocateTackLocationListener", "onStatusChanged " + str + ":" + i10);
    }
}
