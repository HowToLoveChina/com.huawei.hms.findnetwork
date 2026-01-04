package com.huawei.android.remotecontrol.track;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p366if.C10487l;
import p521og.C11870c;
import p521og.C11881n;
import p664u0.C13108a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: com.huawei.android.remotecontrol.track.c */
/* loaded from: classes4.dex */
public class C4441c {

    /* renamed from: d */
    public static volatile C4441c f20365d;

    /* renamed from: a */
    public Context f20366a;

    /* renamed from: b */
    public Handler f20367b;

    /* renamed from: c */
    public String f20368c = null;

    /* renamed from: com.huawei.android.remotecontrol.track.c$a */
    public class a extends Handler {

        /* renamed from: com.huawei.android.remotecontrol.track.c$a$a */
        public class RunnableC14426a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ LocateTrackEvent f20370a;

            public RunnableC14426a(LocateTrackEvent locateTrackEvent) {
                this.f20370a = locateTrackEvent;
            }

            @Override // java.lang.Runnable
            public void run() {
                LocateTrackEvent locateTrackEvent = this.f20370a;
                if (locateTrackEvent == null) {
                    C13981a.m83988e("LocateTrackReportManager", "LocateTrackEvent unexpacted throw null when runnable run");
                } else {
                    C4441c.this.m26972x(locateTrackEvent);
                }
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            super.handleMessage(message);
            int i10 = message.what;
            C13981a.m83989i("LocateTrackReportManager", "initWorkerHandler receive handleMessage,what:" + i10);
            if (i10 == 0) {
                C4441c.this.m26950A((LocateTrackEvent) message.obj);
                return;
            }
            if (i10 == 1) {
                C4441c.this.m26954E();
            } else {
                if (i10 != 3) {
                    return;
                }
                C4441c.this.m26954E();
                postDelayed(new RunnableC14426a((LocateTrackEvent) message.obj), 1000L);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.track.c$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f20372a;

        /* renamed from: b */
        public final /* synthetic */ boolean f20373b;

        /* renamed from: c */
        public final /* synthetic */ long f20374c;

        /* renamed from: d */
        public final /* synthetic */ long f20375d;

        public b(String str, boolean z10, long j10, long j11) {
            this.f20372a = str;
            this.f20373b = z10;
            this.f20374c = j10;
            this.f20375d = j11;
        }

        /* renamed from: c */
        public final /* synthetic */ boolean m26976c(boolean z10, long j10, long j11, Message message) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("LocateTrackReportManager", "uploadTrackEventsToServer result:" + iM1685c);
            C12797b c12797b = new C12797b();
            if (200 != iM1685c) {
                c12797b.m76784j(C4441c.this.f20366a, "LocateTrackReportManager", "007_" + iM1685c, "trajectory report failed", null, "01015", C4441c.this.f20368c, "trackLocate", false);
                C13981a.m83987d("LocateTrackReportManager", "uploadTrackEventsToServer->report error");
                return true;
            }
            int iM26964p = C4441c.this.m26964p(message.getData().getString("response_info"));
            C13981a.m83989i("LocateTrackReportManager", "uploadTrackEventsToServer->resultCode =" + iM26964p);
            if (iM26964p == 0) {
                if (!z10) {
                    C4441c.this.m26960k(j10, j11);
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("isOnline", String.valueOf(z10));
                c12797b.m76785k(C4441c.this.f20366a, "LocateTrackReportManager", "0", "trajectory report success", null, "01015", C4441c.this.f20368c, "trackLocate", false, linkedHashMap);
                return true;
            }
            if (7 == iM26964p) {
                C4443e.m26985i(C4441c.this.f20366a);
                Intent intent = new Intent();
                intent.setAction("com.huawei.android.remotecontrol.PHONEFINDER_DEVICE_DELETE");
                C13108a.m78878b(C4441c.this.f20366a).m78881d(intent);
            }
            c12797b.m76784j(C4441c.this.f20366a, "LocateTrackReportManager", "007_" + iM26964p, "trajectory report failed", null, "01015", C4441c.this.f20368c, "trackLocate", false);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            C13981a.m83989i("LocateTrackReportManager", "httpsUploadReport");
            RequestModeConfig.getInstance().setMode(3072, false);
            String str = this.f20372a;
            final boolean z10 = this.f20373b;
            final long j10 = this.f20374c;
            final long j11 = this.f20375d;
            C4346d.m26225d(3072, str, new Handler.Callback() { // from class: com.huawei.android.remotecontrol.track.d
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f20382a.m26976c(z10, j10, j11, message);
                }
            }, C4441c.this.f20366a);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.track.c$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ long f20377a;

        /* renamed from: b */
        public final /* synthetic */ long f20378b;

        public c(long j10, long j11) {
            this.f20377a = j10;
            this.f20378b = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            LocateTrackDbHelper.m26900e(C4441c.this.f20366a, this.f20377a, this.f20378b);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.track.c$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LocateTrackDbHelper.m26901f(C4441c.this.f20366a, 86400000L);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.track.c$e */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!LocateTrackDbHelper.m26898c(C4441c.this.f20366a)) {
                C13981a.m83988e("LocateTrackReportManager", "track report stop but delete db failed!!!");
            }
            C4441c.this.m26961l();
        }
    }

    public C4441c(Context context) {
        if (context != null) {
            this.f20366a = context.getApplicationContext();
        }
        m26967s();
    }

    /* renamed from: o */
    public static C4441c m26949o(Context context) {
        if (f20365d == null) {
            synchronized (C4441c.class) {
                try {
                    if (f20365d == null) {
                        f20365d = new C4441c(context);
                    }
                } finally {
                }
            }
        }
        return f20365d;
    }

    /* renamed from: A */
    public final void m26950A(LocateTrackEvent locateTrackEvent) {
        boolean zM26969u = m26969u(locateTrackEvent);
        if (!zM26969u) {
            C13981a.m83989i("LocateTrackReportManager", "saveEvent track:locate track not match distance config");
        }
        locateTrackEvent.setUpdate(!zM26969u);
        ContentValues contentValues = new ContentValues();
        locateTrackEvent.cap2ContentValues(this.f20366a, contentValues);
        long jM26897b = LocateTrackDbHelper.m26897b(this.f20366a, contentValues, zM26969u);
        C4450l.m27019o(this.f20366a, locateTrackEvent);
        if (jM26897b < 0) {
            C13981a.m83989i("LocateTrackReportManager", "saveEvent to database failed!");
        } else {
            C13981a.m83989i("LocateTrackReportManager", "saveEvent to database success!");
        }
    }

    /* renamed from: B */
    public void m26951B(String str) {
        this.f20368c = str;
    }

    /* renamed from: C */
    public final void m26952C(String str) {
        C13981a.m83989i("LocateTrackReportManager", "tryUploadTrackEvents:" + str);
        if (!C0209d.m1333z1(this.f20366a)) {
            C13981a.m83989i("LocateTrackReportManager", "tryUploadTrackEvents but isNetWorkConnected false");
            return;
        }
        Handler handlerM26965q = m26965q();
        if (handlerM26965q.hasMessages(1)) {
            return;
        }
        if ("Hisync-phonefinder upload track event init.".equals(str)) {
            handlerM26965q.sendEmptyMessage(1);
        } else {
            if ("Locate track events null.".equals(str)) {
                return;
            }
            handlerM26965q.sendEmptyMessage(1);
        }
    }

    /* renamed from: D */
    public final void m26953D(ArrayList<JSONObject> arrayList, long j10, long j11) {
        int size = arrayList.size();
        if (size <= 0) {
            C13981a.m83989i("LocateTrackReportManager", "uploadToServer db data but get null");
            m26952C("Locate track events null.");
            return;
        }
        try {
            C13981a.m83989i("LocateTrackReportManager", "uploadToServer offline data:" + size);
            m26955F(arrayList, j10, j11);
        } catch (JSONException unused) {
            C13981a.m83988e("LocateTrackReportManager", "uploadToServer exception: ");
        }
    }

    /* renamed from: E */
    public final void m26954E() throws JSONException {
        C13981a.m83989i("LocateTrackReportManager", "uploadTrackEventsImpl");
        LocateTrackDbHelper.m26901f(this.f20366a, 86400000L);
        long jM27024d = C4452n.m27024d();
        ArrayList<JSONObject> arrayListM26899d = LocateTrackDbHelper.m26899d(this.f20366a, jM27024d);
        long jM1688f = 0;
        if (arrayListM26899d == null) {
            arrayListM26899d = new ArrayList<>();
        } else if (!arrayListM26899d.isEmpty()) {
            try {
                if (AbstractC12139d.m72769h(this.f20366a)) {
                    jM1688f = arrayListM26899d.get(arrayListM26899d.size() - 1).getLong("createTime");
                } else {
                    JSONObject jSONObject = arrayListM26899d.get(arrayListM26899d.size() - 1).getJSONObject("coordinateInfo");
                    String string = jSONObject != null ? jSONObject.getString("time") : null;
                    C13981a.m83987d("LocateTrackReportManager", "collectEndTimeString is: " + string);
                    if (!TextUtils.isEmpty(string)) {
                        jM1688f = C0241z.m1688f(string.split("GMT")[0]);
                    }
                }
            } catch (JSONException unused) {
                C13981a.m83988e("LocateTrackReportManager", "uploadTrackEventsImpl--get collectEndTime JSONException");
            }
        }
        m26953D(arrayListM26899d, jM27024d, jM1688f);
    }

    /* renamed from: F */
    public final void m26955F(ArrayList<JSONObject> arrayList, long j10, long j11) throws JSONException {
        String strM26962m = m26962m(arrayList);
        if (strM26962m == null) {
            C13981a.m83988e("LocateTrackReportManager", "tryUploadTrackEvents interrupt by formatedEvents's null");
            return;
        }
        C13981a.m83987d("LocateTrackReportManager", "Report to server datas offline：" + strM26962m);
        m26966r(strM26962m, j10, j11, false);
    }

    /* renamed from: G */
    public final void m26956G(String str, long j10, long j11) {
        if (str == null) {
            return;
        }
        C13981a.m83987d("LocateTrackReportManager", "Report to server datas online");
        m26966r(str, j10, j11, true);
    }

    /* renamed from: h */
    public void m26957h(LocateTrackEvent locateTrackEvent) {
        C13981a.m83989i("LocateTrackReportManager", "addTrackEvent start");
        if (locateTrackEvent == null) {
            C13981a.m83988e("LocateTrackReportManager", "locateTrackEvent is null");
            return;
        }
        if (C0209d.m1333z1(this.f20366a)) {
            m26971w(locateTrackEvent);
        } else if (C4452n.m27028h(this.f20366a)) {
            C13981a.m83989i("LocateTrackReportManager", "locate track(IMME) data not saved because network/na.");
        } else {
            m26974z(locateTrackEvent);
        }
    }

    /* renamed from: i */
    public void m26958i() {
        m26965q().post(new e());
    }

    /* renamed from: j */
    public final void m26959j() {
        m26965q().post(new d());
    }

    /* renamed from: k */
    public final void m26960k(long j10, long j11) {
        m26965q().post(new c(j10, j11));
    }

    /* renamed from: l */
    public void m26961l() {
        Handler handler = this.f20367b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20367b = null;
        }
        C4445g.m26987b().m26988a();
        C13981a.m83987d("LocateTrackReportManager", "exitReportTask.......");
    }

    /* renamed from: m */
    public final String m26962m(ArrayList<JSONObject> arrayList) throws JSONException {
        if (arrayList != null && arrayList.size() > 0) {
            String deviceID = AbstractC12139d.m72766e(this.f20366a).getDeviceID();
            if (TextUtils.isEmpty(deviceID)) {
                C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents->deviceID is null");
                return null;
            }
            String deviceType = AbstractC12139d.m72766e(this.f20366a).getDeviceType();
            if (TextUtils.isEmpty(deviceType)) {
                C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents->deviceType is null");
                return null;
            }
            String serviceToken = AbstractC12139d.m72766e(this.f20366a).getServiceToken();
            String deviceTicket = AbstractC12139d.m72766e(this.f20366a).getDeviceTicket();
            if (TextUtils.isEmpty(deviceTicket)) {
                C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents->deviceTicket is null");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Object string = arrayList.get(0).getString("isUpdate");
            try {
                jSONObject.put("sessionID", C4450l.m27008d(this.f20366a));
                jSONObject.put("deviceID", deviceID);
                jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, deviceType);
                jSONObject.put("serviceToken", C11870c.m71155c(serviceToken));
                jSONObject.put("deviceTicket", C11870c.m71153a(deviceTicket));
                jSONObject.put("isUpdate", string);
                Context context = this.f20366a;
                if (context == null || "com.huawei.hidisk".equals(context.getPackageName())) {
                    jSONObject.put("appType", 2);
                } else if ("com.huawei.android.ds".equals(this.f20366a.getPackageName())) {
                    jSONObject.put("appType", 0);
                } else {
                    jSONObject.put("appType", 1);
                }
                Iterator<JSONObject> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject next = it.next();
                    next.remove("isUpdate");
                    jSONArray.put(next);
                }
                jSONObject.put("tracks", jSONArray);
                return jSONObject.toString();
            } catch (JSONException unused) {
                C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents failed! JSONException");
            }
        }
        return null;
    }

    /* renamed from: n */
    public final String m26963n(LocateTrackEvent locateTrackEvent) throws JSONException {
        if (locateTrackEvent == null) {
            return null;
        }
        String deviceID = AbstractC12139d.m72766e(this.f20366a).getDeviceID();
        if (TextUtils.isEmpty(deviceID)) {
            C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents->deviceID is null");
            return null;
        }
        String serviceToken = AbstractC12139d.m72766e(this.f20366a).getServiceToken();
        String deviceType = AbstractC12139d.m72766e(this.f20366a).getDeviceType();
        if (TextUtils.isEmpty(deviceType)) {
            C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents->deviceType is null");
            return null;
        }
        String deviceTicket = AbstractC12139d.m72766e(this.f20366a).getDeviceTicket();
        if (TextUtils.isEmpty(deviceTicket)) {
            C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents->deviceTicket is null");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sessionID", C4450l.m27008d(this.f20366a));
            jSONObject.put("deviceID", deviceID);
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, deviceType);
            jSONObject.put("serviceToken", C11870c.m71155c(serviceToken));
            jSONObject.put("deviceTicket", C11870c.m71153a(deviceTicket));
            jSONObject.put("isUpdate", locateTrackEvent.isUpdate());
            Context context = this.f20366a;
            if (context == null) {
                jSONObject.put("appType", 2);
            } else if ("com.huawei.android.ds".equals(context.getPackageName())) {
                jSONObject.put("appType", 0);
            } else if ("com.huawei.hidisk".equals(this.f20366a.getPackageName())) {
                jSONObject.put("appType", 2);
            } else {
                jSONObject.put("appType", 1);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("simSn", "");
                jSONObject2.put("isLockScreen", locateTrackEvent.getTrackCapabilityIslockscreen());
                jSONObject2.put("floor", locateTrackEvent.getFloor());
                jSONObject2.put("locationRouter", locateTrackEvent.getLocationRouter());
                jSONObject2.put("locationTime", locateTrackEvent.getLocationTime());
                jSONObject2.put("locCpTransId", locateTrackEvent.getLocCpTransId());
                jSONObject2.put("locSessionId", locateTrackEvent.getLocSessionId());
                jSONObject2.put("locFenceTime", locateTrackEvent.getLocFenceTime());
                if (AbstractC12139d.m72769h(this.f20366a)) {
                    jSONObject2.put(JsbMapKeyNames.H5_LOC_LON, locateTrackEvent.getTrackLongtitude());
                    jSONObject2.put(JsbMapKeyNames.H5_LOC_LAT, locateTrackEvent.getTrackLatitude());
                    jSONObject2.put("longitude_WGS", locateTrackEvent.getTrackLongtitudeWGS());
                    jSONObject2.put("latitude_WGS", locateTrackEvent.getTrackLatitudeWGS());
                    jSONObject2.put("accuracy", locateTrackEvent.getTrackAccuracy());
                    jSONObject2.put("maptype", locateTrackEvent.getTrackMaptype());
                    jSONObject2.put("type", locateTrackEvent.getTrackLocateType());
                    jSONObject2.put("createTime", locateTrackEvent.getTrackUTC());
                } else {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", locateTrackEvent.getTrackLocateType());
                    jSONObject3.put("sysType", 1);
                    jSONObject3.put(JsbMapKeyNames.H5_LOC_LON, LocateTrackDbHelper.m26902h(locateTrackEvent.getTrackLongtitudeWGS(), this.f20366a));
                    jSONObject3.put(JsbMapKeyNames.H5_LOC_LAT, LocateTrackDbHelper.m26902h(locateTrackEvent.getTrackLatitudeWGS(), this.f20366a));
                    jSONObject3.put("accuracy", locateTrackEvent.getTrackAccuracy());
                    jSONObject3.put("time", locateTrackEvent.getTrackUTC() + C11881n.m71358h());
                    jSONObject2.put("coordinateInfo", jSONObject3);
                }
            } catch (JSONException unused) {
                C13981a.m83988e("LocateTrackReportManager", "formatUploadEventsOnline exception:");
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("tracks", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused2) {
            C13981a.m83988e("LocateTrackReportManager", "formatUploadEvents failed! JSONException");
            return null;
        }
    }

    /* renamed from: p */
    public final int m26964p(String str) throws JSONException {
        C13981a.m83987d("LocateTrackReportManager", "uploadTrackEventsToServer responseInfo:" + str);
        int i10 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
            } else {
                C13981a.m83987d("LocateTrackReportManager", "uploadTrackEventsToServer getResultCode->json has no resultCode");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("LocateTrackReportManager", "uploadTrackEventsToServer getResultCode JSONException");
        }
        return i10;
    }

    /* renamed from: q */
    public final Handler m26965q() {
        if (this.f20367b == null) {
            m26967s();
        }
        return this.f20367b;
    }

    /* renamed from: r */
    public final void m26966r(String str, long j10, long j11, boolean z10) {
        C4445g.m26987b().m26990d(new b(str, z10, j10, j11));
    }

    /* renamed from: s */
    public final void m26967s() {
        this.f20367b = new a(C4445g.m26987b().m26989c().getLooper());
    }

    /* renamed from: t */
    public void m26968t() {
        m26958i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [double] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [double] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v6, types: [double] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m26969u(com.huawei.android.remotecontrol.track.LocateTrackEvent r18) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.track.C4441c.m26969u(com.huawei.android.remotecontrol.track.LocateTrackEvent):boolean");
    }

    /* renamed from: v */
    public void m26970v() {
        C13981a.m83987d("LocateTrackReportManager", "onReportTaskStart.......");
        m26959j();
        m26952C("Hisync-phonefinder upload track event init.");
    }

    /* renamed from: w */
    public final void m26971w(LocateTrackEvent locateTrackEvent) {
        C13981a.m83989i("LocateTrackReportManager", "preUploadTrackEvents start");
        if (m26965q().hasMessages(3)) {
            C13981a.m83988e("LocateTrackReportManager", "hasUploadMsg is false");
            return;
        }
        if (locateTrackEvent == null) {
            C13981a.m83988e("LocateTrackReportManager", "locateTrackEvent is null, upload fail");
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.obj = locateTrackEvent;
        m26965q().sendMessage(message);
    }

    /* renamed from: x */
    public final void m26972x(LocateTrackEvent locateTrackEvent) {
        C13981a.m83989i("LocateTrackReportManager", "preUploadTracksOnline");
        boolean zM26969u = m26969u(locateTrackEvent);
        locateTrackEvent.setUpdate(!zM26969u);
        if (!zM26969u) {
            C13981a.m83989i("LocateTrackReportManager", "track point does not match mindistance...");
        }
        try {
            long jM27024d = C4452n.m27024d();
            m26956G(m26963n(locateTrackEvent), jM27024d, jM27024d);
            C4450l.m27019o(this.f20366a, locateTrackEvent);
            m26973y(locateTrackEvent);
        } catch (JSONException unused) {
            C13981a.m83988e("LocateTrackReportManager", "preUploadTracksOnline exception:");
        }
    }

    /* renamed from: y */
    public final void m26973y(LocateTrackEvent locateTrackEvent) {
        C13981a.m83989i("LocateTrackReportManager", "reportLocationMsg");
        C12797b c12797b = new C12797b();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("floor", locateTrackEvent.getFloor());
        linkedHashMap.put("floorAccuracy", locateTrackEvent.getFloorAcc());
        linkedHashMap.put("locationDelayTime", String.valueOf(locateTrackEvent.getLocationTime()));
        linkedHashMap.put("locationRouter", String.valueOf(locateTrackEvent.getLocationRouter()));
        linkedHashMap.put("locCpTransId", locateTrackEvent.getLocCpTransId());
        linkedHashMap.put("locSessionId", locateTrackEvent.getLocSessionId());
        linkedHashMap.put("locFenceTime", locateTrackEvent.getLocFenceTime());
        c12797b.m76785k(this.f20366a, "LocateTrackReportManager", "0", "REPORT_LOCATIO, uuid:" + C10487l.m64536b().m64547d(), null, "01015", null, "location_report", true, linkedHashMap);
    }

    /* renamed from: z */
    public final void m26974z(LocateTrackEvent locateTrackEvent) {
        if (!C4450l.m27010f(this.f20366a)) {
            C13981a.m83988e("LocateTrackReportManager", "saveEvent but trackSwitcher disabled!!!");
            return;
        }
        C13981a.m83989i("LocateTrackReportManager", "save offline loc tracks...");
        if (locateTrackEvent != null) {
            C13981a.m83989i("LocateTrackReportManager", "save offline loc tracks success");
            Message message = new Message();
            message.what = 0;
            message.obj = locateTrackEvent;
            m26965q().sendMessage(message);
        }
    }
}
