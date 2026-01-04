package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import android.os.Looper;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import java.util.Objects;

/* renamed from: com.huawei.hms.locationSdk.l1 */
/* loaded from: classes8.dex */
public class C5733l1 extends AbstractC5763v1 {

    /* renamed from: b */
    private LocationRequest f25535b;

    /* renamed from: c */
    private PendingIntent f25536c;

    /* renamed from: d */
    private LocationCallback f25537d;

    /* renamed from: e */
    private int f25538e;

    /* renamed from: f */
    private String f25539f;

    /* renamed from: g */
    private Looper f25540g;

    /* renamed from: h */
    private String f25541h;

    public C5733l1(LocationRequest locationRequest, PendingIntent pendingIntent, LocationCallback locationCallback, Looper looper, String str, String str2) {
        this.f25538e = 0;
        this.f25535b = locationRequest;
        this.f25536c = pendingIntent;
        if (locationRequest != null) {
            this.f25538e = locationRequest.getNumUpdates();
        }
        this.f25537d = locationCallback;
        this.f25540g = looper;
        if (locationCallback != null) {
            this.f25539f = str;
        } else {
            this.f25539f = null;
        }
        this.f25541h = str2;
        m33187a(str);
    }

    /* renamed from: a */
    public boolean m33118a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f25537d, ((C5733l1) obj).f25537d);
    }

    /* renamed from: b */
    public boolean m33120b(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f25536c, ((C5733l1) obj).f25536c);
    }

    /* renamed from: c */
    public LocationCallback m33121c() {
        return this.f25537d;
    }

    /* renamed from: d */
    public LocationRequest m33122d() {
        return this.f25535b;
    }

    /* renamed from: e */
    public Looper m33123e() {
        return this.f25540g;
    }

    @Override // com.huawei.hms.locationSdk.AbstractC5763v1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            if (m33121c() != null) {
                return m33118a(obj);
            }
            if (m33119b() != null) {
                return m33120b(obj);
            }
        }
        return false;
    }

    /* renamed from: f */
    public String m33124f() {
        return this.f25541h;
    }

    /* renamed from: g */
    public int m33125g() {
        return this.f25538e;
    }

    /* renamed from: h */
    public String m33126h() {
        return this.f25539f;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public void m33117a(int i10) {
        this.f25538e = i10;
    }

    /* renamed from: b */
    public PendingIntent m33119b() {
        return this.f25536c;
    }
}
