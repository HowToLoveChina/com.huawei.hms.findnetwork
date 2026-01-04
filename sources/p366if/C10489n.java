package p366if;

import android.location.Location;
import com.huawei.android.remotecontrol.config.ParamConfig;
import p774xg.C13811a;

/* renamed from: if.n */
/* loaded from: classes4.dex */
public class C10489n {

    /* renamed from: c */
    public static final C10489n f50627c = new C10489n();

    /* renamed from: b */
    public Location f50629b = null;

    /* renamed from: a */
    public String f50628a = "";

    /* renamed from: d */
    public static C10489n m64552d() {
        return f50627c;
    }

    /* renamed from: a */
    public void m64553a(Location location) {
        if (C13811a.m82824u(location, this.f50629b)) {
            Location location2 = new Location(location);
            this.f50629b = location2;
            location2.setTime(System.currentTimeMillis());
        }
    }

    /* renamed from: b */
    public Location m64554b(Long l10) {
        if (this.f50629b != null && System.currentTimeMillis() - this.f50629b.getTime() <= l10.longValue()) {
            return new Location(this.f50629b);
        }
        return null;
    }

    /* renamed from: c */
    public Location m64555c() {
        if (this.f50629b == null) {
            return null;
        }
        if (System.currentTimeMillis() - this.f50629b.getTime() > ParamConfig.getInstance().getLocationInterval()) {
            this.f50629b = null;
        }
        return this.f50629b;
    }

    /* renamed from: e */
    public void m64556e(String str) {
        this.f50628a = str;
    }
}
