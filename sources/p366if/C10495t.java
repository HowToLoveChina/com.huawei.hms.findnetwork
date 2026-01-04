package p366if;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import p809yg.C13981a;

/* renamed from: if.t */
/* loaded from: classes4.dex */
public class C10495t implements LocationListener {

    /* renamed from: a */
    public final AbstractC10476a f50661a;

    public C10495t(AbstractC10476a abstractC10476a) {
        this.f50661a = abstractC10476a;
    }

    /* renamed from: a */
    public final void m64584a(Location location) {
        if (location != null) {
            C13981a.m83989i("SystemLocationListener", "update system loc time=" + location.getTime() + ", acc=" + location.getAccuracy());
        } else {
            C13981a.m83990w("SystemLocationListener", "updateSystemLocation->location return null.");
        }
        this.f50661a.mo64393i(location);
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location == null) {
            C13981a.m83988e("SystemLocationListener", "onLocationChanged,location is null");
        } else {
            m64584a(location);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        C13981a.m83989i("SystemLocationListener", "onProviderDisabled:" + str);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        C13981a.m83989i("SystemLocationListener", "onProviderEnabled: " + str);
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i10, Bundle bundle) {
        C13981a.m83989i("SystemLocationListener", "onStatusChanged " + str + ":" + i10);
    }
}
