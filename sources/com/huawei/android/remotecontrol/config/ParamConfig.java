package com.huawei.android.remotecontrol.config;

import af.C0188a;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.hms.network.inner.api.NetworkService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0241z;
import p227dg.C9097b;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p664u0.C13108a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* loaded from: classes4.dex */
public class ParamConfig {
    private static final String DEFAULT_APP_ID = "qZEAFUT7EkBLvUoW9ABSvorUSk8Ro4bZ";
    private static final String JSON_KEY_APP_ID = "baiduKey";
    private static final String JSON_KEY_BT_LOCATION_INTERVAL = "BTlocationInterval";
    private static final String JSON_KEY_BT_LOC_AGL_INTERVAL = "BTLocAglInterval";
    private static final String JSON_KEY_BT_LOC_DIS_INTERVAL = "BTLocDisInterval";
    private static final String JSON_KEY_BT_TIME_OFFSET = "BTTimeOffset";
    private static final String JSON_KEY_GPS_LOC_ACC_INTERVAL = "gpsLocAccInterval";
    private static final String JSON_KEY_GPS_LOC_DIS_INTERVAL = "gpsLocDisInterval";
    private static final String JSON_KEY_GPS_LOC_TIME_INTERVAL = "gpsLocTimeInterval";
    private static final String JSON_KEY_GPS_TIME_OFFSET = "gpsTimeOffset";
    private static final String JSON_KEY_LAST_LOC_REMAINED = "lastLocRemained";
    private static final String JSON_KEY_LOCATE_DURATION = "locateDuring";
    private static final String JSON_KEY_LOCATE_TIMES = "locateTimes";
    private static final String JSON_KEY_LOW_REPORT = "lastlocationReport";
    private static final String JSON_KEY_NETWORK_LOC_ACC_INTERVAL = "networkLocAccInterval";
    private static final String JSON_KEY_NETWORK_LOC_DIS_INTERVAL = "networkLocDisInterval";
    private static final String JSON_KEY_NETWORK_LOC_TIME_INTERVAL = "networkLocTimeInterval";
    private static final String JSON_KEY_NETWORK_TIME_OFFSET = "networkTimeOffset";
    private static final String JSON_KEY_OLD_TIME = "oldTime";
    private static final String JSON_KEY_PUSH_PK = "oldPublicKey";
    private static final String JSON_KEY_PUSH_PK11 = "newPublicKey";
    private static final String JSON_KEY_SYSTEM_LOCATION_INTERVAL = "locationInterval";
    private static final String KEY_DISCONNECT_REQUEST_DURING = "disconnectRequestDuring";
    private static final String KEY_GPS_MAX_PASSIVE_TIMES = "gpsMaxPassiveTimes";
    private static final String KEY_GPS_TRACK_ACC_INTERVAL = "gpsTrackAccInterval";
    private static final String KEY_LOCATE_GET_LAST_DELAY_TIME = "getLastLocationDelayTime";
    private static final String KEY_LOCATE_REPORT_INTERVAL = "locationReportInterval";
    private static final String KEY_NETWORK_MAX_PASSIVE_TIMES = "networkMaxPassiveTimes";
    private static final String KEY_NETWORK_TRACK_ACC_INTERVAL = "networkTrackAccInterval";
    private static final long LOCATE_DURATION_DEFAULT = 60;
    private static final int LOCATE_TIMES_DEFAULT = 1;
    private static final int LOW_REPORT_DEFAULT_1 = 5;
    private static final int LOW_REPORT_DEFAULT_2 = 10;
    public static final long QUERY_INTERVAL = 60000;
    public static final String TAG = "ParamConfig";
    private static final long VALUE_DURATION = 604800000;
    private static final long VALUE_DURATION_30_M = 1800000;
    private int btLocAglInterval;
    private int btLocDisInterval;
    private int btLocationInterval;
    private int btTimeOffset;
    private List<BtwlDevcieInfo> btwl;
    private int disconnectRequestDuring;
    private long getLastLocationDelayTime;
    private int gpsLocAccInterval;
    private int gpsLocDisInterval;
    private long gpsLocTimeInterval;
    private int gpsMaxPassiveTimes;
    private long gpsTimeOffset;
    private int gpsTrackAccInterval;
    private long lastLocRemained;
    private long locationInterval;
    private long locationReportInterval;
    private int locationRouter;
    private String mAppId;
    private long mLastQueryTime;
    private long mLocateDuration;
    private int mLocateTimes;
    private ArrayList<Integer> mLowPowerReport;
    private long mOldTime;
    private int networkLocAccInterval;
    private int networkLocDisInterval;
    private long networkLocTimeInterval;
    private int networkMaxPassiveTimes;
    private long networkTimeOffset;
    private int networkTrackAccInterval;
    private long offlineSetKeyCheckTime;
    private long offlineSetKeyTime;
    private long queryFindNetworkListTime;

    /* renamed from: com.huawei.android.remotecontrol.config.ParamConfig$b */
    public static class C4339b {

        /* renamed from: a */
        public static ParamConfig f19782a = new ParamConfig();
    }

    public /* synthetic */ ParamConfig(C4338a c4338a) {
        this();
    }

    private void checkDataValuable() {
        init();
        if (!C1175a.m7389k(C12347f.m74285n().m74301m())) {
            C13981a.m83988e(TAG, "phone finder off");
            return;
        }
        if (isNeedSetKeyToNearby() && isNeedCheckNearby()) {
            C13981a.m83989i(TAG, "need set key to nearby");
            this.offlineSetKeyCheckTime = System.currentTimeMillis();
            C4375j.m26397K(C12347f.m74285n().m74301m());
        }
        if (isNeedQueryFindNetworkList()) {
            C13981a.m83989i(TAG, "need query find network white list");
            this.queryFindNetworkListTime = System.currentTimeMillis();
            C4375j.m26420v();
        }
        if (idDataValuable() || isRedundantQuery()) {
            return;
        }
        C11866p.m71109h();
        this.mLastQueryTime = System.currentTimeMillis();
    }

    public static ParamConfig getInstance() {
        ParamConfig paramConfig = C4339b.f19782a;
        paramConfig.checkDataValuable();
        return paramConfig;
    }

    private String getLowReportString() {
        ArrayList<Integer> arrayList = this.mLowPowerReport;
        if (arrayList == null || arrayList.size() == 0) {
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            this.mLowPowerReport = arrayList2;
            arrayList2.add(5);
            this.mLowPowerReport.add(10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\"");
        Iterator<Integer> it = this.mLowPowerReport.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().intValue());
            sb2.append(",");
        }
        if (sb2.length() > 1) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append("\"");
        return sb2.toString();
    }

    private boolean idDataValuable() {
        return Math.abs(System.currentTimeMillis() - this.mOldTime) < 604800000;
    }

    private boolean isNeedCheckNearby() {
        return Math.abs(System.currentTimeMillis() - this.offlineSetKeyCheckTime) > 1800000;
    }

    private boolean isNeedQueryFindNetworkList() {
        return Math.abs(System.currentTimeMillis() - this.queryFindNetworkListTime) > 604800000 && AbstractC12139d.m72769h(C12347f.m74285n().m74301m());
    }

    private boolean isNeedSetKeyToNearby() {
        return C4375j.m26424z(C12347f.m74285n().m74301m()) && Math.abs(System.currentTimeMillis() - this.offlineSetKeyTime) > 604800000;
    }

    private boolean isRedundantQuery() {
        return Math.abs(System.currentTimeMillis() - this.mLastQueryTime) < 60000;
    }

    private void parseLowReport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 0) {
            this.mLowPowerReport.clear();
            for (String str2 : strArrSplit) {
                this.mLowPowerReport.add(Integer.valueOf(C0241z.m1685c(str2)));
            }
        }
    }

    private void readFromSp(Context context) {
        String strM71214J = C11877j.m71214J(context);
        if (TextUtils.isEmpty(strM71214J)) {
            strM71214J = C11877j.m71230R(context);
        }
        this.btwl = C0188a.m1067d(strM71214J);
        this.offlineSetKeyTime = C11877j.m71264f0(context);
        this.queryFindNetworkListTime = C11877j.m71311v(context);
        String strM71249a0 = C11877j.m71249a0(context);
        this.locationRouter = C11877j.m71228Q(context);
        if (TextUtils.isEmpty(strM71249a0)) {
            return;
        }
        try {
            updateFromJson(new JSONObject(strM71249a0), true);
        } catch (JSONException unused) {
            C13981a.m83988e(TAG, "readFromSp error");
        }
    }

    private void savePushPK(Context context, JSONObject jSONObject) {
        try {
            String strM71362l = C11881n.m71362l(jSONObject, JSON_KEY_PUSH_PK);
            if (!TextUtils.isEmpty(strM71362l)) {
                C11877j.m71205E0(context, strM71362l);
            }
            String strM71362l2 = C11881n.m71362l(jSONObject, JSON_KEY_PUSH_PK11);
            if (TextUtils.isEmpty(strM71362l2)) {
                return;
            }
            C11877j.m71207F0(context, strM71362l2);
        } catch (Exception unused) {
            C13981a.m83989i(TAG, "savePushPK err");
        }
    }

    private void updateFromJson(JSONObject jSONObject, boolean z10) {
        String strM71362l = C11881n.m71362l(jSONObject, JSON_KEY_LOW_REPORT);
        String strM71362l2 = C11881n.m71362l(jSONObject, JSON_KEY_APP_ID);
        this.mLocateDuration = C0241z.m1689g(C11881n.m71362l(jSONObject, JSON_KEY_LOCATE_DURATION), this.mLocateDuration);
        this.mLocateTimes = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_LOCATE_TIMES), this.mLocateTimes);
        if (TextUtils.isEmpty(strM71362l2)) {
            strM71362l2 = this.mAppId;
        }
        this.mAppId = strM71362l2;
        parseLowReport(strM71362l);
        if (z10) {
            String strM71362l3 = C11881n.m71362l(jSONObject, JSON_KEY_OLD_TIME);
            this.mOldTime = TextUtils.isEmpty(strM71362l3) ? Long.MIN_VALUE : C0241z.m1688f(strM71362l3);
        } else {
            this.mOldTime = System.currentTimeMillis();
        }
        this.gpsLocTimeInterval = C0241z.m1689g(C11881n.m71362l(jSONObject, JSON_KEY_GPS_LOC_TIME_INTERVAL), this.gpsLocTimeInterval);
        this.gpsLocAccInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_GPS_LOC_ACC_INTERVAL), this.gpsLocAccInterval);
        this.gpsLocDisInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_GPS_LOC_DIS_INTERVAL), this.gpsLocDisInterval);
        this.networkLocTimeInterval = C0241z.m1689g(C11881n.m71362l(jSONObject, JSON_KEY_NETWORK_LOC_TIME_INTERVAL), this.networkLocTimeInterval);
        this.networkLocAccInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_NETWORK_LOC_ACC_INTERVAL), this.networkLocAccInterval);
        this.networkLocDisInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_NETWORK_LOC_DIS_INTERVAL), this.networkLocDisInterval);
        this.gpsTimeOffset = C0241z.m1689g(C11881n.m71362l(jSONObject, JSON_KEY_GPS_TIME_OFFSET), this.gpsTimeOffset);
        this.networkTimeOffset = C0241z.m1689g(C11881n.m71362l(jSONObject, JSON_KEY_NETWORK_TIME_OFFSET), this.networkTimeOffset);
        this.locationInterval = C0241z.m1689g(C11881n.m71362l(jSONObject, JSON_KEY_SYSTEM_LOCATION_INTERVAL), this.locationInterval);
        this.networkTrackAccInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, KEY_NETWORK_TRACK_ACC_INTERVAL), this.networkTrackAccInterval);
        this.gpsTrackAccInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, KEY_GPS_TRACK_ACC_INTERVAL), this.gpsTrackAccInterval);
        this.lastLocRemained = C0241z.m1689g(C11881n.m71362l(jSONObject, JSON_KEY_LAST_LOC_REMAINED), this.lastLocRemained);
        this.btLocationInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_BT_LOCATION_INTERVAL), this.btLocationInterval);
        this.btLocDisInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_BT_LOC_DIS_INTERVAL), this.btLocDisInterval);
        this.btTimeOffset = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_BT_TIME_OFFSET), this.btTimeOffset);
        this.btLocAglInterval = C0241z.m1686d(C11881n.m71362l(jSONObject, JSON_KEY_BT_LOC_AGL_INTERVAL), this.btLocAglInterval);
        this.gpsMaxPassiveTimes = C0241z.m1686d(C11881n.m71362l(jSONObject, KEY_GPS_MAX_PASSIVE_TIMES), this.gpsMaxPassiveTimes);
        this.networkMaxPassiveTimes = C0241z.m1686d(C11881n.m71362l(jSONObject, KEY_NETWORK_MAX_PASSIVE_TIMES), this.networkMaxPassiveTimes);
        this.disconnectRequestDuring = C0241z.m1686d(C11881n.m71362l(jSONObject, KEY_DISCONNECT_REQUEST_DURING), this.disconnectRequestDuring);
        this.locationReportInterval = C0241z.m1689g(C11881n.m71362l(jSONObject, KEY_LOCATE_REPORT_INTERVAL), this.locationReportInterval);
        this.getLastLocationDelayTime = C0241z.m1689g(C11881n.m71362l(jSONObject, KEY_LOCATE_GET_LAST_DELAY_TIME), this.getLastLocationDelayTime);
        C13981a.m83989i(TAG, "updateFromJson:isFromSp=" + z10 + "--toString=" + toString());
    }

    private void writeToSp(Context context) {
        C11877j.m71268g1(context, "{" + JSON_KEY_OLD_TIME + ":" + this.mOldTime + "," + JSON_KEY_LOCATE_DURATION + ":" + this.mLocateDuration + "," + JSON_KEY_LOCATE_TIMES + ":" + this.mLocateTimes + "," + JSON_KEY_LOW_REPORT + ":" + getLowReportString() + "," + JSON_KEY_APP_ID + ":" + this.mAppId + "," + JSON_KEY_GPS_LOC_TIME_INTERVAL + ":" + this.gpsLocTimeInterval + "," + JSON_KEY_GPS_LOC_ACC_INTERVAL + ":" + this.gpsLocAccInterval + "," + JSON_KEY_GPS_LOC_DIS_INTERVAL + ":" + this.gpsLocDisInterval + "," + JSON_KEY_NETWORK_LOC_TIME_INTERVAL + ":" + this.networkLocTimeInterval + "," + JSON_KEY_NETWORK_LOC_ACC_INTERVAL + ":" + this.networkLocAccInterval + "," + JSON_KEY_NETWORK_LOC_DIS_INTERVAL + ":" + this.networkLocDisInterval + "," + JSON_KEY_GPS_TIME_OFFSET + ":" + this.gpsTimeOffset + "," + JSON_KEY_NETWORK_TIME_OFFSET + ":" + this.networkTimeOffset + "," + JSON_KEY_SYSTEM_LOCATION_INTERVAL + ":" + this.locationInterval + "," + KEY_NETWORK_TRACK_ACC_INTERVAL + ":" + this.networkTrackAccInterval + "," + KEY_GPS_TRACK_ACC_INTERVAL + ":" + this.gpsTrackAccInterval + "," + JSON_KEY_BT_LOCATION_INTERVAL + ":" + this.btLocationInterval + "," + JSON_KEY_BT_LOC_DIS_INTERVAL + ":" + this.btLocDisInterval + "," + JSON_KEY_BT_TIME_OFFSET + ":" + this.btTimeOffset + "," + KEY_GPS_MAX_PASSIVE_TIMES + ":" + this.gpsMaxPassiveTimes + "," + KEY_NETWORK_MAX_PASSIVE_TIMES + ":" + this.networkMaxPassiveTimes + "," + KEY_DISCONNECT_REQUEST_DURING + ":" + this.disconnectRequestDuring + "," + JSON_KEY_BT_LOC_AGL_INTERVAL + ":" + this.btLocAglInterval + "," + KEY_LOCATE_REPORT_INTERVAL + ":" + this.locationReportInterval + "," + KEY_LOCATE_GET_LAST_DELAY_TIME + ":" + this.getLastLocationDelayTime + "}");
    }

    public int getBtLocAglInterval() {
        return this.btLocAglInterval;
    }

    public int getBtLocDisInterval() {
        return this.btLocDisInterval;
    }

    public long getBtLocationInterval() {
        return this.btLocationInterval * 1000;
    }

    public long getBtTimeOffset() {
        return this.btTimeOffset * 1000;
    }

    public List<BtwlDevcieInfo> getBtwl() {
        return this.btwl;
    }

    public long getDisconnectRequestDuring() {
        return this.disconnectRequestDuring * 1000;
    }

    public int getGpsLocAccInterval() {
        return this.gpsLocAccInterval;
    }

    public int getGpsLocDisInterval() {
        return this.gpsLocDisInterval;
    }

    public long getGpsLocTimeInterval() {
        return this.gpsLocTimeInterval * 1000;
    }

    public int getGpsMaxPassiveTimes() {
        return this.gpsMaxPassiveTimes;
    }

    public long getGpsTimeOffset() {
        return this.gpsTimeOffset * 1000;
    }

    public int getGpsTrackAccInterval() {
        return this.gpsTrackAccInterval;
    }

    public long getLastLocRemained() {
        return this.lastLocRemained * 1000;
    }

    public long getLastLocationDelayTime() {
        return this.getLastLocationDelayTime * 1000;
    }

    public long getLocateDuration() {
        return this.mLocateDuration * 1000;
    }

    public int getLocateTimes() {
        return this.mLocateTimes;
    }

    public long getLocationInterval() {
        return this.locationInterval * 1000;
    }

    public long getLocationReportInterval() {
        return this.locationReportInterval * 1000;
    }

    public int getLocationRouter() {
        return this.locationRouter;
    }

    public int getNetworkLocAccInterval() {
        return this.networkLocAccInterval;
    }

    public int getNetworkLocDisInterval() {
        return this.networkLocDisInterval;
    }

    public long getNetworkLocTimeInterval() {
        return this.networkLocTimeInterval * 1000;
    }

    public int getNetworkMaxPassiveTimes() {
        return this.networkMaxPassiveTimes;
    }

    public long getNetworkTimeOffset() {
        return this.networkTimeOffset * 1000;
    }

    public int getNetworkTrackAccInterval() {
        return this.networkTrackAccInterval;
    }

    public String getmAppId() {
        return this.mAppId;
    }

    public void init() {
        if (Long.MIN_VALUE == this.mOldTime) {
            readFromSp(C12347f.m74285n().m74301m());
        }
    }

    public boolean needLowPowerReport(int i10) {
        Iterator<Integer> it = this.mLowPowerReport.iterator();
        while (it.hasNext()) {
            if (i10 == it.next().intValue()) {
                return true;
            }
        }
        return false;
    }

    public void setLastLocRemained(long j10) {
        this.lastLocRemained = j10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("ParamConfig [mLocateDuration=");
        sb2.append(this.mLocateDuration);
        sb2.append(", mLocateTimes=");
        sb2.append(this.mLocateTimes);
        sb2.append("]");
        return sb2.toString();
    }

    public void upDateParam(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(NetworkService.Constants.CONFIG_SERVICE)) {
            C13981a.m83988e(TAG, "upDateParam:get error from server");
            return;
        }
        try {
            updateFromJson((JSONObject) jSONObject.get(NetworkService.Constants.CONFIG_SERVICE), false);
            this.mLastQueryTime = Long.MIN_VALUE;
            writeToSp(C12347f.m74285n().m74301m());
            if (jSONObject.has("publicKey")) {
                savePushPK(C0213f.m1377a(), (JSONObject) jSONObject.get("publicKey"));
            }
            if (jSONObject.has("locationRouter")) {
                this.locationRouter = jSONObject.getInt("locationRouter");
            } else {
                this.locationRouter = 0;
            }
            C11877j.m71241W0(C12347f.m74285n().m74301m(), this.locationRouter);
            if (jSONObject.has("offlineStatus")) {
                C11877j.m71262e1(C12347f.m74285n().m74301m(), jSONObject.getInt("offlineStatus"));
            }
            if (jSONObject.has("cmacKey")) {
                String string = jSONObject.getString("cmacKey");
                if (!TextUtils.isEmpty(string)) {
                    C11877j.m71256c1(C12347f.m74285n().m74301m(), string);
                }
            }
            if (jSONObject.has("LocationShareStatus")) {
                boolean z10 = 1 == jSONObject.getInt("LocationShareStatus");
                C11877j.m71295p1(C12347f.m74285n().m74301m(), z10);
                C11860j.m71064j1(z10);
            }
            if (jSONObject.has("perDeviceList")) {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("perDeviceList");
                this.btwl = C0188a.m1067d(jSONObject2.toString());
                C11877j.m71225O0(C12347f.m74285n().m74301m(), jSONObject2.toString());
                if (!AncillaryDeviceManager.m26080y().m26085E()) {
                    C13108a.m78878b(C12347f.m74285n().m74301m()).m78881d(new Intent("com.huawei.hidisk.phone.finder.ANCILLARY_DEVICE_ACTION"));
                }
                if (jSONObject2.has("nearby")) {
                    C9097b.m57312v(jSONObject2.getString("nearby"));
                }
            }
        } catch (Exception e10) {
            C13981a.m83988e(TAG, "upDateParam error:" + e10.getMessage());
        }
    }

    private ParamConfig() {
        this.mOldTime = Long.MIN_VALUE;
        this.mLastQueryTime = Long.MIN_VALUE;
        this.mLocateDuration = 60L;
        this.mLocateTimes = 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.mLowPowerReport = arrayList;
        arrayList.add(5);
        this.mLowPowerReport.add(10);
        this.mAppId = DEFAULT_APP_ID;
        this.locationRouter = 0;
        this.gpsLocTimeInterval = 30L;
        this.gpsLocAccInterval = 50;
        this.gpsLocDisInterval = 10;
        this.networkLocTimeInterval = 30L;
        this.networkLocAccInterval = 500;
        this.networkLocDisInterval = 10;
        this.gpsTimeOffset = 5L;
        this.networkTimeOffset = 5L;
        this.locationInterval = 90L;
        this.locationReportInterval = 10L;
        this.getLastLocationDelayTime = 3L;
        this.networkTrackAccInterval = 500;
        this.gpsTrackAccInterval = 100;
        this.lastLocRemained = 60L;
        this.btLocationInterval = 20;
        this.btLocDisInterval = 2;
        this.btTimeOffset = 1;
        this.btLocAglInterval = 10;
        this.gpsMaxPassiveTimes = 7;
        this.networkMaxPassiveTimes = 3;
        this.disconnectRequestDuring = 30;
        if (C12347f.m74285n().m74301m() == null) {
            C13981a.m83988e(TAG, "applicationContext is null");
            return;
        }
        String strM71214J = C11877j.m71214J(C12347f.m74285n().m74301m());
        if (TextUtils.isEmpty(strM71214J)) {
            strM71214J = C11877j.m71230R(C12347f.m74285n().m74301m());
            AncillaryDeviceManager.m26080y().m26092P();
        }
        this.btwl = C0188a.m1067d(strM71214J);
    }
}
