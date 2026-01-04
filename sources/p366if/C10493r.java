package p366if;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.locate.PassiveLocateParam;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import p366if.AbstractC10476a;
import p616rk.C12515a;
import p774xg.C13812b;
import p783xp.C13843a;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: if.r */
/* loaded from: classes4.dex */
public class C10493r extends AbstractC10476a {

    /* renamed from: k */
    public String f50646k;

    /* renamed from: m */
    public PassiveLocateParam f50648m;

    /* renamed from: n */
    public boolean f50649n;

    /* renamed from: o */
    public boolean f50650o;

    /* renamed from: p */
    public Location f50651p;

    /* renamed from: q */
    public Location f50652q;

    /* renamed from: r */
    public Location f50653r;

    /* renamed from: t */
    public long f50655t;

    /* renamed from: u */
    public C10488m f50656u;

    /* renamed from: l */
    public String f50647l = "OffLineLocationAbilityProxy";

    /* renamed from: s */
    public int f50654s = 1000;

    /* renamed from: if.r$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Location f50657a;

        /* renamed from: b */
        public final /* synthetic */ boolean f50658b;

        public a(Location location, boolean z10) {
            this.f50657a = location;
            this.f50658b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12797b c12797b = new C12797b();
            C13981a.m83989i(C10493r.this.f50646k, "reportDisLocationBi");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            Location location = this.f50657a;
            if (location != null) {
                linkedHashMap.put("provider", location.getProvider());
                linkedHashMap.put("time", String.valueOf(this.f50657a.getTime()));
                linkedHashMap.put("accuracy", String.valueOf(this.f50657a.getAccuracy()));
            }
            C10493r c10493r = C10493r.this;
            c12797b.m76785k(c10493r.f50489a, c10493r.f50646k, "0", "get disconnect location success, is cache location:" + this.f50658b, null, "offlineLocation", null, "location_report", true, linkedHashMap);
        }
    }

    public C10493r(InterfaceC10483h interfaceC10483h, Context context, String str, PassiveLocateParam passiveLocateParam) {
        this.f50646k = "OffLineLocationPolicy";
        this.f50492d = interfaceC10483h;
        this.f50489a = context;
        this.f50490b = new AbstractC10476a.a(this);
        this.f50646k = str + "-" + this.f50646k;
        this.f50648m = passiveLocateParam;
        this.f50491c = new C10485j(context, str + "-" + this.f50647l);
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: a */
    public void mo64385a() {
        C13981a.m83989i(this.f50646k, "doLocate");
        if (this.f50492d == null) {
            C13981a.m83989i(this.f50646k, "mLocateHook is null");
            return;
        }
        Location locationM64571o = m64571o("gps");
        if (locationM64571o != null) {
            this.f50656u = new C10488m(locationM64571o);
            C10488m c10488m = new C10488m(locationM64571o);
            C13981a.m83989i(this.f50646k, "get gps cache location,locate terminal");
            this.f50492d.mo64423d(c10488m);
            return;
        }
        Handler handler = this.f50490b;
        if (handler == null) {
            C13981a.m83988e(this.f50646k, "mHandler is null");
        } else {
            handler.sendEmptyMessageDelayed(1, this.f50649n ? 0L : this.f50493e);
        }
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: b */
    public void mo64386b() {
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: c */
    public void mo64387c() {
        super.mo64387c();
        this.f50655t = ParamConfig.getInstance().getLastLocRemained();
        this.f50493e = ParamConfig.getInstance().getLocateDuration();
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: d */
    public void mo64388d() {
        C13981a.m83989i(this.f50646k, "locateAgain");
        if (this.f50492d == null) {
            C13981a.m83989i(this.f50646k, "mLocateHook is null");
            return;
        }
        this.f50491c.m64507L(1, this.f50498j);
        Location locationM64571o = m64571o("network");
        if (locationM64571o == null) {
            this.f50490b.sendEmptyMessageDelayed(2, this.f50650o ? 0L : this.f50493e);
            return;
        }
        this.f50656u = new C10488m(locationM64571o);
        C13981a.m83989i(this.f50646k, "get network cache location,locate terminal");
        this.f50492d.mo64423d(this.f50656u);
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: e */
    public void mo64389e(int i10) throws InterruptedException {
        if (this.f50491c == null || this.f50492d == null || this.f50490b == null) {
            C13981a.m83988e(this.f50646k, "position process not ready.");
        } else if (i10 == 5) {
            m64569m();
        } else if (i10 == 6) {
            m64574r();
        }
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: g */
    public void mo64391g() {
        C13981a.m83989i(this.f50646k, "startLocate");
        mo64387c();
        this.f50491c.m64507L(3, this.f50498j);
        this.f50498j = new C10495t(this);
        Handler handler = this.f50490b;
        if (handler == null) {
            C13981a.m83988e(this.f50646k, "mHandler is null");
        } else {
            handler.sendEmptyMessageDelayed(5, 500L);
        }
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: h */
    public void mo64392h() {
        C13981a.m83989i(this.f50646k, "stopLocation");
        this.f50491c.m64507L(3, this.f50498j);
        InterfaceC10483h interfaceC10483h = this.f50492d;
        if (interfaceC10483h == null) {
            C13981a.m83988e(this.f50646k, "mLocateHook is null");
            return;
        }
        Location location = this.f50651p;
        if (location == null) {
            location = this.f50652q;
        }
        if (location == null) {
            interfaceC10483h.mo64422b();
            return;
        }
        long time = location.getTime();
        if (time <= 0 || System.currentTimeMillis() - time > this.f50655t) {
            return;
        }
        C13981a.m83989i(this.f50646k, "lastKnowLocation was effective，use lastKnowLocation");
        C10488m c10488m = new C10488m(location);
        this.f50656u = c10488m;
        this.f50492d.mo64423d(c10488m);
        m64570n(location, true);
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: i */
    public boolean mo64393i(Location location) {
        if (this.f50492d == null || location == null || this.f50490b == null) {
            C13981a.m83988e(this.f50646k, "hook or location is null");
            return false;
        }
        C13981a.m83989i(this.f50646k, "updateLocation:" + location.getProvider());
        C13981a.m83989i(this.f50646k, location.getProvider() + " location update,remove messages");
        this.f50490b.removeMessages(0);
        this.f50490b.removeMessages(1);
        this.f50490b.removeMessages(2);
        this.f50491c.m64507L(3, this.f50498j);
        C10488m c10488m = new C10488m(location);
        this.f50656u = c10488m;
        this.f50492d.mo64423d(c10488m);
        m64570n(location, false);
        return true;
    }

    @Override // p366if.AbstractC10476a
    /* renamed from: j */
    public boolean mo64394j() {
        return false;
    }

    /* renamed from: l */
    public final boolean m64568l(String str) {
        if (this.f50648m == null) {
            C13981a.m83988e(this.f50646k, "mPassiveLocateParam is null");
            return false;
        }
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("gps".equals(str)) {
            if (!C13843a.m83072X(this.f50648m.getGpsLastTime(), jCurrentTimeMillis, timeZone)) {
                this.f50648m.setGpsCount(ParamConfig.getInstance().getGpsMaxPassiveTimes() - 1);
                this.f50648m.setGpsLastTime(jCurrentTimeMillis);
                return false;
            }
            int gpsCount = this.f50648m.getGpsCount();
            int i10 = gpsCount > 0 ? gpsCount - 1 : -1;
            this.f50648m.setGpsCount(i10);
            C13981a.m83989i(this.f50646k, "gpsCount:" + i10);
            this.f50648m.setGpsLastTime(jCurrentTimeMillis);
            return i10 == -1;
        }
        if ("network".equals(str)) {
            if (C13843a.m83072X(this.f50648m.getNetworkLastTime(), jCurrentTimeMillis, timeZone)) {
                int networkCount = this.f50648m.getNetworkCount();
                int i11 = networkCount > 0 ? networkCount - 1 : -1;
                this.f50648m.setNetworkCount(i11);
                C13981a.m83989i(this.f50646k, "networkCount:" + i11);
                this.f50648m.setNetworkLastTime(jCurrentTimeMillis);
                return i11 == -1;
            }
            this.f50648m.setNetworkCount(ParamConfig.getInstance().getNetworkMaxPassiveTimes() - 1);
            this.f50648m.setNetworkLastTime(jCurrentTimeMillis);
        }
        return false;
    }

    /* renamed from: m */
    public final void m64569m() throws InterruptedException {
        Location locationM64554b = C10489n.m64552d().m64554b(Long.valueOf(this.f50655t));
        this.f50653r = locationM64554b;
        if (locationM64554b == null) {
            Location locationM64527t = this.f50491c.m64527t("gps");
            this.f50653r = locationM64527t;
            if (locationM64527t == null || System.currentTimeMillis() - this.f50653r.getTime() > this.f50655t) {
                C13981a.m83989i(this.f50646k, "cacheLocation is null or expired");
                Location locationM64527t2 = this.f50491c.m64527t("network");
                this.f50653r = locationM64527t2;
                if (locationM64527t2 == null || System.currentTimeMillis() - this.f50653r.getTime() > this.f50655t) {
                    C13981a.m83989i(this.f50646k, "cacheLocation network is null or expired");
                    this.f50490b.sendEmptyMessage(0);
                    return;
                }
            }
        }
        if (C13812b.m82844o(this.f50653r)) {
            C13981a.m83989i(this.f50646k, "getBestLocationDisconnect is indoor");
            this.f50491c.m64507L(3, this.f50498j);
            m64570n(this.f50653r, true);
            C10488m c10488m = new C10488m(this.f50653r);
            this.f50656u = c10488m;
            this.f50492d.mo64423d(c10488m);
            return;
        }
        boolean zM64529w = this.f50491c.m64529w();
        C13981a.m83989i(this.f50646k, "hasFence : " + zM64529w);
        if (zM64529w) {
            m64574r();
        } else {
            this.f50491c.m64524q(this.f50653r);
            this.f50490b.sendEmptyMessageDelayed(6, this.f50654s);
        }
    }

    /* renamed from: n */
    public final void m64570n(Location location, boolean z10) {
        C12515a.m75110o().m75175e(new a(location, z10), false);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: o */
    public final Location m64571o(String str) {
        C10485j c10485j = this.f50491c;
        if (c10485j == null) {
            C13981a.m83988e(this.f50646k, "requestUpdatesFromProvider mLocationAbilityProxy is null");
            return null;
        }
        if (!c10485j.m64499D(str)) {
            C13981a.m83990w(this.f50646k, str + " provider not enabled");
            return null;
        }
        Location locationM64527t = this.f50491c.m64527t(str);
        if (locationM64527t != null) {
            m64572p(str, locationM64527t);
            long time = locationM64527t.getTime();
            if (time > 0 && System.currentTimeMillis() - time <= this.f50655t) {
                C13981a.m83989i(this.f50646k, "lastKnowLocation was effective");
                m64570n(locationM64527t, true);
                return locationM64527t;
            }
            C13981a.m83989i(this.f50646k, "lastKnowLocation was expired");
            locationM64527t = null;
        } else {
            C13981a.m83987d(this.f50646k, "lastKnowLocation is null:" + str);
        }
        if (!m64568l(str)) {
            if (str.equals("gps")) {
                this.f50491c.m64515T(this.f50498j, this.f50494f, this.f50495g);
            } else {
                this.f50491c.m64518W(this.f50498j, this.f50496h, this.f50497i);
            }
            return locationM64527t;
        }
        C13981a.m83989i(this.f50646k, "meet location time limit: " + str);
        m64573q(str);
        return null;
    }

    /* renamed from: p */
    public final void m64572p(String str, Location location) {
        if ("gps".equals(str)) {
            this.f50651p = location;
        } else {
            this.f50652q = location;
        }
    }

    /* renamed from: q */
    public final void m64573q(String str) {
        if ("gps".equals(str)) {
            this.f50649n = true;
        } else {
            this.f50650o = true;
        }
    }

    /* renamed from: r */
    public final void m64574r() throws InterruptedException {
        boolean zM64498C = this.f50491c.m64498C(this.f50653r);
        C13981a.m83989i(this.f50646k, "cacheLocation inHdArea " + zM64498C);
        if (!zM64498C) {
            this.f50490b.sendEmptyMessage(0);
        } else if (m64568l("gps")) {
            this.f50490b.sendEmptyMessage(0);
        } else {
            this.f50491c.m64518W(this.f50498j, this.f50496h, this.f50497i);
            this.f50490b.sendEmptyMessageDelayed(0, this.f50493e);
        }
    }
}
