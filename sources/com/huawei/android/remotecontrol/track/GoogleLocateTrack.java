package com.huawei.android.remotecontrol.track;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p366if.C10485j;
import p366if.C10487l;
import p774xg.C13811a;
import p774xg.C13812b;
import p809yg.C13981a;
import pg.AbstractC12139d;
import re.C12492a;
import sg.C12797b;
import ug.C13172b;

/* loaded from: classes4.dex */
public class GoogleLocateTrack extends LocateTrackObject {

    /* renamed from: d */
    public String f20327d;

    /* renamed from: e */
    public C10485j f20328e;

    /* renamed from: f */
    public C4447i f20329f;

    /* renamed from: g */
    public Location f20330g;

    /* renamed from: h */
    public Handler f20331h;

    /* renamed from: i */
    public Timer f20332i;

    /* renamed from: j */
    public long f20333j;

    /* renamed from: com.huawei.android.remotecontrol.track.GoogleLocateTrack$a */
    public class C4433a extends TimerTask {
        public C4433a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83989i("G_LocateTrack", "G_Locate track report " + GoogleLocateTrack.this.f20333j + " result...");
            GoogleLocateTrack.this.m26888r();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.track.GoogleLocateTrack$b */
    public class RunnableC4434b implements Runnable {
        public RunnableC4434b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GoogleLocateTrack.this.m26894x();
        }
    }

    public GoogleLocateTrack(Context context) {
        super(context);
        this.f20327d = "GLTKLocationAbilityProxy";
        this.f20331h = new Handler(Looper.getMainLooper());
    }

    /* renamed from: A */
    public void m26883A(Location location) {
        if (!C13811a.m82824u(location, this.f20330g)) {
            C13981a.m83989i("G_LocateTrack", "updateG_Locate's location is not better than last locCache");
            return;
        }
        C13981a.m83989i("G_LocateTrack", "updateG_Locate's location is better than last loccache.");
        this.f20330g = location;
        if (C13811a.m82827x(location)) {
            m26888r();
            C13981a.m83989i("G_LocateTrack", "reportG_LocateResult:loc match gps suggest accuracy,release locate source.");
            return;
        }
        C10485j c10485j = this.f20328e;
        if (c10485j == null || !c10485j.m64532z(location)) {
            return;
        }
        m26888r();
    }

    @Override // com.huawei.android.remotecontrol.track.LocateTrackObject
    /* renamed from: f */
    public void mo26868f() throws JSONException {
        C13981a.m83989i("G_LocateTrack", "G_LocateTrack handleLocateTrackCmd begin");
        if (!C4347e.m26238i(this.f20348c)) {
            C13981a.m83989i("G_LocateTrack", "G_LocateTrack hasPermissions = false");
            m26893w(66);
            new C12797b().m76782h(this.f20348c, "G_LocateTrack", "001_2001", 66, "G_LocateTrack hasPermissions fail", null, "01015", null, "local_handleResponse", false);
        } else if (C13172b.m79211g(this.f20348c)) {
            m26892v(C13172b.m79205a(this.f20348c));
        } else {
            m26896z();
        }
    }

    @Override // com.huawei.android.remotecontrol.track.LocateTrackObject
    /* renamed from: i */
    public void mo26869i() {
        m26889s();
        m26891u();
        m26890t();
        Handler handler = this.f20331h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20331h = null;
        }
    }

    /* renamed from: n */
    public void m26884n(int i10) {
        if (!AbstractC12139d.m72768g(this.f20348c)) {
            C13981a.m83988e("G_LocateTrack", "accountInfo not exist");
            return;
        }
        if (this.f20330g == null) {
            C13981a.m83988e("G_LocateTrack", "doReport--currentBestLocation is null");
            return;
        }
        LocateTrackEvent locateTrackEvent = new LocateTrackEvent();
        int i11 = !this.f20330g.getProvider().equals("network") ? 1 : 0;
        C13981a.m83989i("G_LocateTrack", "doReport start,locateType:" + i11 + ";isLockScreen:" + i10);
        locateTrackEvent.setTrackLocateType(String.valueOf(i11));
        if (AbstractC12139d.m72769h(this.f20348c)) {
            Location locationM64543j = C10487l.m64543j(this.f20330g);
            if (locationM64543j == null) {
                C13981a.m83988e("G_LocateTrack", "bd location is null");
            } else {
                locateTrackEvent.setTrackLongtitude(String.valueOf(locationM64543j.getLongitude()));
                locateTrackEvent.setTrackLatitude(String.valueOf(locationM64543j.getLatitude()));
                locateTrackEvent.setTrackLatitudeWGS(String.valueOf(this.f20330g.getLatitude()));
                locateTrackEvent.setTrackLongtitudeWGS(String.valueOf(this.f20330g.getLongitude()));
            }
        } else {
            locateTrackEvent.setTrackLongtitudeWGS(String.valueOf(this.f20330g.getLongitude()));
            locateTrackEvent.setTrackLatitudeWGS(String.valueOf(this.f20330g.getLatitude()));
        }
        locateTrackEvent.setFloor(C13812b.m82831b(this.f20330g));
        locateTrackEvent.setFloorAcc(C13812b.m82832c(this.f20330g));
        locateTrackEvent.setLocationTime(C13812b.m82837h(this.f20330g));
        locateTrackEvent.setLocationRouter(C13812b.m82836g(this.f20330g));
        locateTrackEvent.setLocCpTransId(C13812b.m82833d(this.f20330g));
        locateTrackEvent.setLocSessionId(C13812b.m82835f(this.f20330g));
        locateTrackEvent.setLocFenceTime(C13812b.m82834e(this.f20330g));
        locateTrackEvent.setTrackAccuracy(String.valueOf(this.f20330g.getAccuracy()));
        locateTrackEvent.setTrackMaptype(String.valueOf(2));
        locateTrackEvent.setTrackCapabilityIslockscreen(String.valueOf(i10));
        locateTrackEvent.setTrackUTC(this.f20330g.getTime());
        m26916b(locateTrackEvent);
        mo26869i();
    }

    /* renamed from: o */
    public final int m26885o(String str) throws JSONException {
        int i10 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
            } else {
                C13981a.m83987d("G_LocateTrack", "getResultCode->json has no resultCode");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("G_LocateTrack", "getResultCode JSONException");
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* renamed from: p */
    public final boolean m26886p(Message message, int i10) throws JSONException {
        boolean z10;
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("G_LocateTrack", "G_LocateTrack result:" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            m26893w(1);
            c12797b.m76784j(this.f20348c, "G_LocateTrack", "001_3003", "G_LocateTrack handleCapabilityReportCallback fail, result:" + iM1685c, null, "01015", null, "capability_reported", false);
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(message.getData().getString("response_info"));
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                int i11 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
                C13981a.m83989i("G_LocateTrack", "G_LocateTrack resultCode: " + i11);
                if (i11 != 0) {
                    z10 = 401;
                    try {
                        if (401 == i11) {
                            C4443e.m26983g(this.f20348c);
                            m26893w(1);
                            z10 = 1;
                            c12797b.m76782h(this.f20348c, "G_LocateTrack", "001_3004", i11, "G_LocateTrack handleCapabilityReportCallback fail, resultCode:" + i11, null, "01015", null, "capability_reported", false);
                        } else {
                            z10 = 1;
                            m26893w(1);
                            c12797b.m76782h(this.f20348c, "G_LocateTrack", "001_3004", i11, "G_LocateTrack handleCapabilityReportCallback fail, resultCode:" + i11, null, "01015", null, "capability_reported", false);
                        }
                        return z10;
                    } catch (JSONException unused) {
                        C13981a.m83988e("G_LocateTrack", "handleClientCapabilityReport JSONException");
                        return z10;
                    }
                }
                C13172b.m79213i(this.f20348c, i10);
                C4443e.m26983g(this.f20348c);
                C13981a.m83989i("G_LocateTrack", "G_LocateTrack handleCapabilityReportCallback success, AppEventLogParam report");
                c12797b.m76784j(this.f20348c, "G_LocateTrack", "0", "G_LocateTrack handleCapabilityReportCallback success", null, "01015", null, "capability_reported", false);
            }
            return true;
        } catch (JSONException unused2) {
            z10 = 1;
        }
    }

    /* renamed from: q */
    public final void m26887q(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("G_LocateTrack", "handleReportG_LocateFailCallback result:" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            C13981a.m83989i("G_LocateTrack", "handleReportG_LocateFailCallback->report error");
            c12797b.m76784j(this.f20348c, "G_LocateTrack", "001_3003", "G_LocateTrack handleReportG_LocateFailCallback fail, result:" + iM1685c, null, "01015", null, "trackLocate", true);
            return;
        }
        int iM26885o = m26885o(message.getData().getString("response_info"));
        C13981a.m83989i("G_LocateTrack", "handleReportG_LocateFailCallback->resultCode =" + iM26885o);
        if (iM26885o == 0) {
            C13981a.m83989i("G_LocateTrack", "G_Locate handleReportG_LocateFailCallback success");
            c12797b.m76784j(this.f20348c, "G_LocateTrack", "0", "G_LocateTrack handleReportG_LocateFailCallback success", null, "01015", null, "trackLocate", true);
            return;
        }
        c12797b.m76782h(this.f20348c, "G_LocateTrack", "001_3004", iM26885o, "G_LocateTrack handleReportG_LocateFailCallback fail, resultCode:" + iM26885o, null, "01015", null, "trackLocate", true);
    }

    /* renamed from: r */
    public final void m26888r() {
        C13981a.m83989i("G_LocateTrack", "postFinalResult begin");
        Handler handler = this.f20331h;
        if (handler == null) {
            C13981a.m83988e("G_LocateTrack", "mReportHandler is null");
        } else {
            handler.post(new RunnableC4434b());
        }
    }

    /* renamed from: s */
    public final void m26889s() {
        C4447i c4447i;
        C10485j c10485j = this.f20328e;
        if (c10485j == null || (c4447i = this.f20329f) == null) {
            return;
        }
        c10485j.m64508M(c4447i);
        this.f20328e.m64511P(this.f20329f);
    }

    /* renamed from: t */
    public final void m26890t() {
        C4440b.m26939i(this.f20348c, this);
    }

    /* renamed from: u */
    public final void m26891u() {
        Timer timer = this.f20332i;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* renamed from: v */
    public final void m26892v(int i10) {
        C13981a.m83989i("G_LocateTrack", "G_LocateTrack reportClientCapability: " + i10);
        Context context = this.f20348c;
        if (context == null) {
            C13981a.m83988e("G_LocateTrack", "reportClientCapability context is null");
            return;
        }
        String deviceID = AbstractC12139d.m72766e(context).getDeviceID();
        if (TextUtils.isEmpty(deviceID)) {
            C13981a.m83988e("G_LocateTrack", "reportClientCapability id is empty");
            return;
        }
        String deviceType = AbstractC12139d.m72766e(this.f20348c).getDeviceType();
        if (TextUtils.isEmpty(deviceType)) {
            C13981a.m83988e("G_LocateTrack", "reportClientCapability type is empty");
        } else {
            new C12492a(deviceID, C0241z.m1685c(deviceType), AbstractC12139d.m72766e(this.f20348c).getServiceToken(), new C4435c(SNSCode.Status.ADD_FRIEND_FAILED, i10), this.f20348c, i10, null).m74985e();
        }
    }

    /* renamed from: w */
    public void m26893w(int i10) throws JSONException {
        C4440b.m26939i(this.f20348c, this);
        if (!C1175a.m7389k(this.f20348c)) {
            m26920g();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject.put(JsbMapKeyNames.H5_LOC_LON, 0.0d);
            jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, 0.0d);
            jSONObject.put("longitude_WGS", 0.0d);
            jSONObject.put("latitude_WGS", 0.0d);
            jSONObject.put("accuracy", 0.0d);
            jSONObject.put("maptype", 2);
            jSONObject.put("simSn", "");
            this.f20346a = 1;
            this.f20347b = jSONObject;
            m26918d(new C4435c(3026));
        } catch (JSONException unused) {
            C13981a.m83988e("G_LocateTrack", "reportG_LocateFailResult JSONException");
        }
    }

    /* renamed from: x */
    public void m26894x() {
        Location location = this.f20330g;
        if (location == null) {
            C13981a.m83988e("G_LocateTrack", "currentBestLocation is null");
            mo26869i();
            return;
        }
        if (!C4452n.m27029i(this.f20348c, location)) {
            mo26869i();
            return;
        }
        long time = this.f20330g.getTime();
        C13981a.m83989i("G_LocateTrack", "report G_Locate-track loc's time:" + time);
        if (time > 0 && Math.abs(System.currentTimeMillis() - time) > 1800000) {
            C13981a.m83988e("G_LocateTrack", "currentBestLocation is overdue,report break...");
        } else if (C1175a.m7389k(this.f20348c)) {
            m26884n(C13811a.m82820q(this.f20348c));
        } else {
            C13981a.m83988e("G_LocateTrack", "reportG_LocateResult->switcher of phoneFinder is off");
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: y */
    public final void m26895y() {
        C13981a.m83989i("G_LocateTrack", "G_Locate track requestUpdatesFromProvider");
        if (this.f20328e == null) {
            this.f20328e = new C10485j(this.f20348c, this.f20327d);
        }
        C13981a.m83989i("G_LocateTrack", "G_Locate track requestUpdatesFromProvider,LocationManager.GPS_PROVIDER begin");
        this.f20328e.m64515T(this.f20329f, 10000L, 10);
        C13981a.m83989i("G_LocateTrack", "G_Locate track requestUpdatesFromProvider,LocationManager.NETWORK_PROVIDER begin");
        this.f20328e.m64518W(this.f20329f, 10000L, 10);
    }

    /* renamed from: z */
    public final void m26896z() {
        C13981a.m83989i("G_LocateTrack", "startG_Locate begin");
        m26889s();
        m26891u();
        this.f20329f = new C4447i(this);
        this.f20328e = new C10485j(this.f20348c, this.f20327d);
        this.f20332i = new Timer("CheckGLocateTimer");
        C4433a c4433a = new C4433a();
        long jM27025e = C4452n.m27025e(this.f20348c);
        this.f20333j = jM27025e;
        this.f20332i.schedule(c4433a, jM27025e);
        m26895y();
    }

    /* renamed from: com.huawei.android.remotecontrol.track.GoogleLocateTrack$c */
    public class C4435c implements Handler.Callback {

        /* renamed from: a */
        public int f20336a;

        /* renamed from: b */
        public int f20337b;

        public C4435c(int i10) {
            this.f20337b = i10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            int i10 = this.f20337b;
            if (3011 == i10) {
                return GoogleLocateTrack.this.m26886p(message, this.f20336a);
            }
            if (3026 != i10) {
                return false;
            }
            GoogleLocateTrack.this.m26887q(message);
            return false;
        }

        public C4435c(int i10, int i11) {
            this.f20336a = i11;
            this.f20337b = i10;
        }
    }
}
