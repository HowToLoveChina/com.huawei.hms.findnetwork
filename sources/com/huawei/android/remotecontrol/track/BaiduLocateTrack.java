package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.baidu.location.LocationClient;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p366if.C10487l;
import p774xg.C13811a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import re.C12492a;
import sg.C12797b;
import ug.C13172b;

/* loaded from: classes4.dex */
public class BaiduLocateTrack extends LocateTrackObject {

    /* renamed from: d */
    public LocationClient f20317d;

    /* renamed from: e */
    public String f20318e;

    /* renamed from: f */
    public C4446h f20319f;

    /* renamed from: g */
    public Timer f20320g;

    /* renamed from: h */
    public boolean f20321h;

    /* renamed from: i */
    public boolean f20322i;

    /* renamed from: com.huawei.android.remotecontrol.track.BaiduLocateTrack$c */
    public class C4432c extends TimerTask {
        public C4432c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83989i("BaiduLocateTrack", "TimeOut-->stopBaiduLocate-->");
            if (!BaiduLocateTrack.this.f20321h) {
                C13981a.m83988e("BaiduLocateTrack", "reported by network failed");
            }
            if (!BaiduLocateTrack.this.f20322i) {
                C13981a.m83988e("BaiduLocateTrack", "reported locate time out");
                BaiduLocateTrack.this.m26870l(7);
            }
            BaiduLocateTrack.this.m26875q();
        }
    }

    public BaiduLocateTrack(Context context) {
        super(context);
        this.f20321h = false;
    }

    @Override // com.huawei.android.remotecontrol.track.LocateTrackObject
    /* renamed from: f */
    public void mo26868f() {
        C13981a.m83989i("BaiduLocateTrack", "BaiduLocateTrack handleLocateTrackCmd begin");
        if (!C4347e.m26238i(this.f20348c)) {
            C13981a.m83988e("BaiduLocateTrack", "BaiduLocate hasPermissions = false");
            m26870l(66);
        } else if (C13172b.m79211g(this.f20348c)) {
            m26872n(C13172b.m79205a(this.f20348c));
        } else {
            m26874p();
        }
    }

    @Override // com.huawei.android.remotecontrol.track.LocateTrackObject
    /* renamed from: i */
    public void mo26869i() {
        m26875q();
    }

    /* renamed from: l */
    public void m26870l(int i10) {
        C13981a.m83989i("BaiduLocateTrack", "baiduLocateTrack reportBaiduFailResult fail");
        C4440b.m26939i(this.f20348c, this);
        this.f20322i = true;
        C12797b c12797b = new C12797b();
        if (!C1175a.m7389k(this.f20348c)) {
            C13981a.m83989i("BaiduLocateTrack", "baiduLocateTrack reportBaiduFailResult fail, switch is off");
            m26920g();
            c12797b.m76784j(this.f20348c, "BaiduLocateTrack", "001_1003", "baiduLocateTrack reportBaiduFailResult fail, switch is off", null, "01015", null, "trackLocate", true);
            return;
        }
        c12797b.m76782h(this.f20348c, "BaiduLocateTrack", "001_2001", i10, "baiduLocateTrack reportBaiduFailResult fail, result:" + i10, null, "01015", null, "trackLocate", false);
        this.f20346a = i10;
        this.f20347b = null;
        m26918d(new C4431b(3024));
    }

    /* renamed from: m */
    public void m26871m(Location location) {
        this.f20322i = true;
        int iM82820q = C13811a.m82820q(this.f20348c);
        C13981a.m83989i("BaiduLocateTrack", "reportBaiduResult isLockScreen:" + iM82820q);
        if (!C4450l.m27010f(this.f20348c)) {
            m26920g();
            C13981a.m83988e("BaiduLocateTrack", "reportBaiduResult->switcher of phonefinder is off");
            return;
        }
        if (location != null) {
            long time = location.getTime();
            C13981a.m83989i("BaiduLocateTrack", "Math.abs(System.currentTimeMillis() - locTime):" + Math.abs(System.currentTimeMillis() - time));
            if (time > 0 && Math.abs(System.currentTimeMillis() - time) > 1800000) {
                C13981a.m83989i("BaiduLocateTrack", "currentBestLocation is overdue,report break...");
                return;
            }
            LocateTrackEvent locateTrackEvent = new LocateTrackEvent();
            String provider = location.getProvider();
            locateTrackEvent.setTrackLocateType(String.valueOf("network".equals(provider) ? 0 : "gps".equals(provider) ? 1 : 2));
            Location locationM64543j = C10487l.m64543j(location);
            if (locationM64543j == null) {
                C13981a.m83988e("BaiduLocateTrack", "new location is null");
            } else {
                locateTrackEvent.setTrackLatitude(String.valueOf(locationM64543j.getLatitude()));
                locateTrackEvent.setTrackLongtitude(String.valueOf(locationM64543j.getLongitude()));
            }
            locateTrackEvent.setTrackLatitudeWGS(String.valueOf(location.getLatitude()));
            locateTrackEvent.setTrackLongtitudeWGS(String.valueOf(location.getLongitude()));
            locateTrackEvent.setTrackAccuracy(String.valueOf(location.getAccuracy()));
            locateTrackEvent.setTrackMaptype(String.valueOf(1));
            locateTrackEvent.setTrackCapabilityIslockscreen(String.valueOf(iM82820q));
            locateTrackEvent.setTrackUTC(location.getTime());
            m26916b(locateTrackEvent);
        }
    }

    /* renamed from: n */
    public final boolean m26872n(int i10) {
        C13981a.m83989i("BaiduLocateTrack", "BaiduLocate reportClientCapability capability:" + i10);
        Context context = this.f20348c;
        if (context == null) {
            return false;
        }
        String deviceID = AbstractC12139d.m72766e(context).getDeviceID();
        if (TextUtils.isEmpty(deviceID)) {
            C13981a.m83988e("BaiduLocateTrack", "reportClientCapability->deviceID is null");
            return false;
        }
        String deviceType = AbstractC12139d.m72766e(this.f20348c).getDeviceType();
        if (TextUtils.isEmpty(deviceType)) {
            C13981a.m83988e("BaiduLocateTrack", "reportClientCapability->deviceType is null");
            return false;
        }
        new C12492a(deviceID, C0241z.m1685c(deviceType), AbstractC12139d.m72766e(this.f20348c).getServiceToken(), new C4431b(SNSCode.Status.ADD_FRIEND_FAILED, i10), this.f20348c, i10, null).m74985e();
        return true;
    }

    /* renamed from: o */
    public void m26873o() {
        if (this.f20317d != null) {
            C13981a.m83987d("BaiduLocateTrack", JsbMapKeyNames.H5_REQUESTLOCATION);
            C10487l.m64538e(this.f20317d, new Location(this.f20318e), this.f20319f);
        }
    }

    /* renamed from: p */
    public final void m26874p() {
        C13981a.m83989i("BaiduLocateTrack", "LocateTrackFactory startBaiduLocation");
        if (this.f20317d == null) {
            this.f20317d = C10487l.m64536b().m64546a();
        }
        if (this.f20319f == null) {
            this.f20319f = new C4446h(this);
        }
        this.f20318e = "network";
        C10487l.m64538e(this.f20317d, new Location(this.f20318e), this.f20319f);
        Timer timer = this.f20320g;
        if (timer != null) {
            timer.cancel();
        }
        this.f20320g = new Timer("CheckBaiduLocateTimer");
        this.f20320g.schedule(new C4432c(), C4452n.m27025e(this.f20348c));
    }

    /* renamed from: q */
    public void m26875q() {
        C13981a.m83989i("BaiduLocateTrack", "onReceiveLocation location is null, stopBaiduLocation");
        Timer timer = this.f20320g;
        if (timer != null) {
            timer.cancel();
            this.f20320g = null;
        }
        LocationClient locationClient = this.f20317d;
        if (locationClient != null) {
            locationClient.destroy();
            this.f20317d = null;
        }
        C4440b.m26939i(this.f20348c, this);
    }

    /* renamed from: com.huawei.android.remotecontrol.track.BaiduLocateTrack$b */
    public class C4431b implements Handler.Callback {

        /* renamed from: a */
        public int f20323a;

        /* renamed from: b */
        public int f20324b;

        public C4431b(int i10) {
            this.f20323a = i10;
        }

        /* renamed from: a */
        public final int m26876a(String str) throws JSONException {
            C13981a.m83987d("BaiduLocateTrack", "responseInfo:" + str);
            int i10 = 1;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                    i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
                } else {
                    C13981a.m83989i("BaiduLocateTrack", "getResultCode->json has no resultCode");
                }
            } catch (JSONException unused) {
                C13981a.m83988e("BaiduLocateTrack", "getResultCode JSONException");
            }
            return i10;
        }

        /* renamed from: b */
        public final void m26877b(Message message) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("BaiduLocateTrack", "handleCapabilityReportCallback result:" + iM1685c);
            C12797b c12797b = new C12797b();
            if (200 != iM1685c) {
                BaiduLocateTrack.this.m26870l(1);
                c12797b.m76784j(BaiduLocateTrack.this.f20348c, "BaiduLocateTrack", "001_3003", "baidulocatetrack handleCapabilityReportCallback fail, result:" + iM1685c, null, "01015", null, "capability_reported", false);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(message.getData().getString("response_info"));
                if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                    int i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
                    C13981a.m83989i("BaiduLocateTrack", "handleCapabilityReportCallback resultCode:= " + i10);
                    if (i10 == 0) {
                        C13172b.m79213i(BaiduLocateTrack.this.f20348c, this.f20324b);
                        C4443e.m26983g(BaiduLocateTrack.this.f20348c);
                        C13981a.m83989i("BaiduLocateTrack", "baidulocatetrack handleCapabilityReportCallback success,AppEventLogParam report");
                        c12797b.m76784j(BaiduLocateTrack.this.f20348c, "BaiduLocateTrack", "0", "baidulocatetrack handleCapabilityReportCallback success", null, "01015", null, "capability_reported", false);
                    } else if (401 == i10) {
                        C13172b.m79213i(BaiduLocateTrack.this.f20348c, this.f20324b);
                        C4443e.m26983g(BaiduLocateTrack.this.f20348c);
                        c12797b.m76782h(BaiduLocateTrack.this.f20348c, "BaiduLocateTrack", "001_3004", i10, "baidulocatetrack handleCapabilityReportCallback fail, resultCode:" + i10, null, "01015", null, "capability_reported", false);
                    } else {
                        BaiduLocateTrack.this.m26870l(1);
                        c12797b.m76782h(BaiduLocateTrack.this.f20348c, "BaiduLocateTrack", "001_3004", i10, "baidulocatetrack handleCapabilityReportCallback fail, resultCode:" + i10, null, "01015", null, "capability_reported", false);
                    }
                }
            } catch (JSONException unused) {
                C13981a.m83988e("BaiduLocateTrack", "handleClientCapabilityReport JSONException");
            }
        }

        /* renamed from: c */
        public final void m26878c(Message message) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("BaiduLocateTrack", "handleReportBaiduLocateFailCallback result:" + iM1685c);
            C12797b c12797b = new C12797b();
            if (200 != iM1685c) {
                C13981a.m83989i("BaiduLocateTrack", "handleReportBaiduLocateFailCallback->report error");
                c12797b.m76784j(BaiduLocateTrack.this.f20348c, "BaiduLocateTrack", "001_3003", "baidulocatetrack handleReportBaiduLocateFailCallback fail, result:" + iM1685c, null, "01015", null, "trackLocate", true);
                return;
            }
            int iM26876a = m26876a(message.getData().getString("response_info"));
            C13981a.m83987d("BaiduLocateTrack", "handleReportBaiduLocateFailCallback->resultCode =" + iM26876a);
            if (iM26876a == 0) {
                C13981a.m83989i("BaiduLocateTrack", "baidulocatetrack handleReportBaiduLocateFailCallback success,AppEventLogParam report");
                c12797b.m76784j(BaiduLocateTrack.this.f20348c, "BaiduLocateTrack", "0", "baidulocatetrack handleReportBaiduLocateFailCallback success", null, "01015", null, "trackLocate", true);
                return;
            }
            c12797b.m76782h(BaiduLocateTrack.this.f20348c, "BaiduLocateTrack", "001_3004", iM26876a, "baidulocatetrack handleReportBaiduLocateFailCallback fail, resultCode:" + iM26876a, null, "01015", null, "trackLocate", true);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            C13981a.m83989i("BaiduLocateTrack", "HttpCallback->handleMessage, mWhat:" + this.f20323a);
            int i10 = this.f20323a;
            if (3011 == i10) {
                m26877b(message);
                return true;
            }
            if (3024 != i10) {
                return true;
            }
            m26878c(message);
            return true;
        }

        public C4431b(int i10, int i11) {
            this.f20323a = i10;
            this.f20324b = i11;
        }
    }
}
