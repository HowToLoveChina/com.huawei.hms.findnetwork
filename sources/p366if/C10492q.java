package p366if;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.http.C4347e;
import p366if.AbstractC10476a;
import p774xg.C13811a;
import p774xg.C13812b;
import p809yg.C13981a;

/* renamed from: if.q */
/* loaded from: classes4.dex */
public class C10492q extends AbstractC10476a {

    /* renamed from: k */
    public String f50635k;

    /* renamed from: l */
    public String f50636l;

    /* renamed from: m */
    public Location f50637m;

    /* renamed from: n */
    public long f50638n;

    /* renamed from: o */
    public long f50639o;

    /* renamed from: p */
    public long f50640p;

    /* renamed from: q */
    public long f50641q;

    /* renamed from: r */
    public Location f50642r;

    /* renamed from: s */
    public int f50643s = 5000;

    /* renamed from: t */
    public int f50644t = 2000;

    /* renamed from: u */
    public long f50645u = 600000;

    public C10492q(InterfaceC10483h interfaceC10483h, Context context, String str) {
        this.f50635k = "NormalLocationPolicy";
        this.f50636l = "NormalLocationAbilityProxy";
        this.f50492d = interfaceC10483h;
        this.f50489a = context;
        this.f50490b = new AbstractC10476a.a(this);
        this.f50635k = str + "-" + this.f50635k;
        this.f50636l = str + "-" + this.f50636l;
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: a */
    public void mo64385a() {
        C13981a.m83989i(this.f50635k, "doLocate,last " + this.f50638n + " ms");
        this.f50641q = 0L;
        boolean zM64566n = m64566n("gps");
        boolean zM64566n2 = m64566n("network");
        if (!zM64566n && !zM64566n2) {
            m64563k(m64564l("gps"), m64564l("network"));
            return;
        }
        Handler handler = this.f50490b;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(3, this.f50640p);
        }
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: b */
    public void mo64386b() {
        C13981a.m83989i(this.f50635k, "getLastLocation");
        if (this.f50637m != null) {
            C13981a.m83989i(this.f50635k, "currentBestLocation not null");
        } else if (m64563k(m64564l("gps"), m64564l("network"))) {
            this.f50641q = System.currentTimeMillis();
        } else {
            this.f50641q = 0L;
        }
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: c */
    public void mo64387c() {
        super.mo64387c();
        this.f50493e = 30000L;
        this.f50638n = ParamConfig.getInstance().getLocationInterval();
        this.f50639o = ParamConfig.getInstance().getLocationReportInterval();
        this.f50640p = ParamConfig.getInstance().getLastLocationDelayTime();
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: d */
    public void mo64388d() {
        C13981a.m83989i(this.f50635k, "locateAgain");
        this.f50492d.mo64424e(this.f50637m);
        long j10 = this.f50638n;
        long j11 = this.f50493e;
        if (j10 <= j11) {
            Handler handler = this.f50490b;
            if (handler != null) {
                handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        Handler handler2 = this.f50490b;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(2, j10 - j11);
        }
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: e */
    public void mo64389e(int i10) {
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: g */
    public void mo64391g() {
        C13981a.m83989i(this.f50635k, "startLocate");
        mo64387c();
        m64390f();
        this.f50498j = new C10495t(this);
        Handler handler = this.f50490b;
        if (handler == null) {
            C13981a.m83988e(this.f50635k, "mHandler is null");
        } else {
            handler.sendEmptyMessageDelayed(0, 500L);
            this.f50490b.sendEmptyMessageDelayed(1, this.f50493e);
        }
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: h */
    public void mo64392h() {
        C13981a.m83989i(this.f50635k, "stopLocation");
        Handler handler = this.f50490b;
        if (handler != null) {
            if (handler.hasMessages(3)) {
                this.f50490b.removeMessages(3);
            }
            if (this.f50490b.hasMessages(4)) {
                this.f50490b.removeMessages(4);
            }
        }
        m64390f();
        this.f50492d.mo64422b();
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: i */
    public boolean mo64393i(Location location) {
        if (location == null || this.f50492d == null) {
            C13981a.m83989i(this.f50635k, "location or hook is null");
            return false;
        }
        if (this.f50642r != null && "".equals(C13812b.m82831b(location)) && location.getTime() - this.f50642r.getTime() < this.f50643s) {
            C13981a.m83989i(this.f50635k, "hd location been reported.");
            return false;
        }
        if (!C13811a.m82824u(location, this.f50637m)) {
            C13981a.m83989i(this.f50635k, "new location is not better than currentBestLocation");
            return false;
        }
        this.f50637m = location;
        if (C13812b.m82844o(location)) {
            this.f50639o = this.f50644t;
        } else {
            this.f50639o = ParamConfig.getInstance().getLocationReportInterval();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f50641q;
        long j10 = this.f50639o;
        if (jCurrentTimeMillis >= j10) {
            m64565m(location);
        } else {
            Handler handler = this.f50490b;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(4, j10 - jCurrentTimeMillis);
            }
        }
        this.f50641q = System.currentTimeMillis();
        return true;
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: j */
    public boolean mo64394j() {
        C13981a.m83989i(this.f50635k, "updateLocationDelay");
        m64565m(this.f50637m);
        return true;
    }

    /* renamed from: k */
    public final boolean m64563k(Location location, Location location2) {
        C13981a.m83989i(this.f50635k, "compareLocation");
        if (location != null && location2 != null) {
            C13981a.m83989i(this.f50635k, "get cache gpsLocation and networkLocation");
            if (location.getTime() < location2.getTime()) {
                location2 = location;
                location = location2;
            }
            return C13811a.m82824u(location, location2) ? mo64393i(location) : mo64393i(location2);
        }
        if (location != null) {
            C13981a.m83989i(this.f50635k, "get cache gpsLocation");
            return mo64393i(location);
        }
        if (location2 == null) {
            return false;
        }
        C13981a.m83989i(this.f50635k, "get cache networkLocation");
        return mo64393i(location2);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: l */
    public final Location m64564l(String str) {
        Location location = null;
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e(this.f50635k, "provider is empty");
            return null;
        }
        if (this.f50491c == null) {
            this.f50491c = new C10485j(this.f50489a, this.f50636l);
        }
        Location locationM64527t = this.f50491c.m64527t(str);
        if (locationM64527t == null) {
            C13981a.m83989i(this.f50635k, "lastLocation is null, provider =" + str);
            return locationM64527t;
        }
        C13981a.m83989i(this.f50635k, "last known location time:" + locationM64527t.getTime());
        if (System.currentTimeMillis() - locationM64527t.getTime() > this.f50645u) {
            C13981a.m83990w(this.f50635k, "last known location time offset:" + this.f50645u);
        } else {
            C13981a.m83989i(this.f50635k, "Report last known location");
            location = locationM64527t;
        }
        return location;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: m */
    public final void m64565m(Location location) {
        C13981a.m83989i(this.f50635k, "report location");
        if (location == null) {
            C13981a.m83988e(this.f50635k, "location null");
            return;
        }
        if (!"".equals(C13812b.m82831b(location))) {
            C13981a.m83989i(this.f50635k, "cache hd location: " + location.getExtras());
            this.f50642r = location;
        }
        C13981a.m83989i(this.f50635k, "reportLocationResult,type:" + location.getProvider());
        C10488m c10488m = new C10488m(location);
        if (this.f50491c == null) {
            this.f50491c = new C10485j(this.f50489a, this.f50636l);
        }
        GpsStatus gpsStatusM64525r = this.f50491c.m64525r();
        if (gpsStatusM64525r != null) {
            c10488m.m64551c(C4347e.m26230a(gpsStatusM64525r.getSatellites().iterator()));
        }
        this.f50492d.mo64423d(c10488m);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: n */
    public final boolean m64566n(String str) {
        C13981a.m83989i(this.f50635k, "requestUpdatesFromProvider=" + str);
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e(this.f50635k, "provider is empty");
            return false;
        }
        if (this.f50491c == null) {
            this.f50491c = new C10485j(this.f50489a, this.f50636l);
        }
        return "gps".equals(str) ? this.f50491c.m64515T(this.f50498j, (int) this.f50494f, this.f50495g) : this.f50491c.m64518W(this.f50498j, (int) this.f50496h, this.f50497i);
    }
}
