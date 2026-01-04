package ir;

import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.huawei.location.ephemeris.net.EphemerisResponse;
import com.huawei.riemann.location.bean.eph.BdsEphemeris;
import com.huawei.riemann.location.bean.eph.BdsIon;
import com.huawei.riemann.location.bean.eph.BdsNav;
import com.huawei.riemann.location.bean.eph.BdsTim;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.eph.GalileoEphemeris;
import com.huawei.riemann.location.bean.eph.GalileoNav;
import com.huawei.riemann.location.bean.eph.GalileoTim;
import com.huawei.riemann.location.bean.eph.GlonassEphemeris;
import com.huawei.riemann.location.bean.eph.GlonassNav;
import com.huawei.riemann.location.bean.eph.GlonassTim;
import com.huawei.riemann.location.bean.eph.GpsEphemeris;
import com.huawei.riemann.location.bean.eph.GpsIon;
import com.huawei.riemann.location.bean.eph.GpsNav;
import es.C9542g;
import es.C9549n;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p235ds.C9302c;
import p531or.C11991a;
import p784xq.C13850f;
import p854zs.C14372a;

/* renamed from: ir.b */
/* loaded from: classes8.dex */
public final class C10603b {

    /* renamed from: b */
    public static long f50980b = 0;

    /* renamed from: c */
    public static boolean f50981c = false;

    /* renamed from: d */
    public static long f50982d;

    /* renamed from: a */
    public C14372a f50983a = new C14372a();

    /* renamed from: a */
    public static JSONArray m65006a(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGalNav()).getJSONArray("ephList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphModule", "getGalNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: b */
    public static long m65007b() {
        if (f50980b <= 0) {
            f50980b = new C9549n("ephemeris_expire_time").m59623a("ephemeris_expire_time");
        }
        C1016d.m6186f("EphModule", "getExpireTime = " + f50980b);
        return f50980b;
    }

    /* renamed from: g */
    public static JSONArray m65008g(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGloNav()).getJSONArray("gloNavItemList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphModule", "getGloNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: h */
    public static JSONArray m65009h(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getBdsNav()).getJSONArray("ephList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphModule", "getBdsNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: k */
    public static JSONArray m65010k(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGpsNav()).getJSONArray("ephList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphModule", "getGpsNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: c */
    public final GlonassEphemeris m65011c(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        C14372a c14372a = this.f50983a;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGloTim());
        c14372a.getClass();
        GlonassTim glonassTimBuild = GlonassTim.Builder.aGlonassTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withA2((jSONObject.optDouble("a2", 0.0d) / 1.152921504606847E18d) / 256.0d).withGnssToId(jSONObject.optInt("gnssToId", 0)).withWeekNumber(jSONObject.optInt("weekNumber", 0)).withWeekSecond(jSONObject.optInt("weekSecond", 0) * 16).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGloNav());
        C14372a c14372a2 = this.f50983a;
        JSONArray jSONArray = jSONObject2.getJSONArray("gloNavItemList");
        c14372a2.getClass();
        GlonassNav[] glonassNavArrM85569a = C14372a.m85569a(jSONArray);
        C13850f.m83120a(new StringBuilder("GlonassNav size = "), glonassNavArrM85569a.length, "EphModule");
        int iOptInt = jSONObject2.optInt("satNumber", 0);
        return GlonassEphemeris.Builder.aGlonassEphemeris().withSatNumber(iOptInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGlonassNavs(glonassNavArrM85569a).withGlonassTim(glonassTimBuild).build();
    }

    /* renamed from: d */
    public final GpsEphemeris m65012d(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        C14372a c14372a = this.f50983a;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGpsIon());
        c14372a.getClass();
        GpsIon gpsIonBuild = GpsIon.Builder.aGpsIon().withA0(jSONObject.optDouble("a0", 0.0d) / 1.073741824E9d).withA1(jSONObject.optDouble("a1", 0.0d) / 1.34217728E8d).withA2(jSONObject.optDouble("a2", 0.0d) / 1.6777216E7d).withA3(jSONObject.optDouble("a3", 0.0d) / 1.6777216E7d).withB0(jSONObject.optInt("b0", 0) * 2048).withB1(jSONObject.optInt("b1", 0) * 16384).withB2(jSONObject.optInt("b2", 0) * 65536).withB3(jSONObject.optInt("b3", 0) * 65536).withValid(jSONObject.optBoolean("valid")).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGpsNav());
        C14372a c14372a2 = this.f50983a;
        JSONArray jSONArray = jSONObject2.getJSONArray("ephList");
        c14372a2.getClass();
        GpsNav[] gpsNavArrM85570b = C14372a.m85570b(jSONArray);
        C13850f.m83120a(new StringBuilder("GpsNav size = "), gpsNavArrM85570b.length, "EphModule");
        return GpsEphemeris.Builder.aGpsEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withGpsNavs(gpsNavArrM85570b).withGpsIon(gpsIonBuild).build();
    }

    /* renamed from: e */
    public final Ephemeris m65013e() {
        String string;
        try {
            FileInputStream fileInputStreamOpenFileInput = C11991a.m72145a().openFileInput("ephData");
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    int i10 = fileInputStreamOpenFileInput.read(bArr);
                    if (i10 <= 0) {
                        break;
                    }
                    sb2.append(new String(bArr, 0, i10, StandardCharsets.UTF_8));
                }
                string = sb2.toString();
                fileInputStreamOpenFileInput.close();
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("FileUtil", "read from file failed");
            string = null;
        }
        if (string == null) {
            C1016d.m6186f("EphModule", "read Ephemeris From Json is null");
            return null;
        }
        C9302c c9302c = new C9302c(3);
        String[] strArrSplit = string.split("\n");
        StringBuffer stringBuffer = new StringBuffer();
        if (strArrSplit.length == 1) {
            stringBuffer.append(c9302c.mo38472a(string, "LOCATION_LITE_SDK"));
        } else {
            for (String str : strArrSplit) {
                stringBuffer.append(c9302c.mo38472a(str, "LOCATION_LITE_SDK"));
            }
        }
        try {
            EphemerisResponse ephemerisResponse = (EphemerisResponse) C9542g.m59588a().fromJson(stringBuffer.toString().trim(), EphemerisResponse.class);
            if (ephemerisResponse == null) {
                return null;
            }
            try {
                if (this.f50983a == null) {
                    this.f50983a = new C14372a();
                }
                GpsEphemeris gpsEphemerisM65012d = m65012d(ephemerisResponse);
                return Ephemeris.Builder.anEphemeris().withGpsEphemeris(gpsEphemerisM65012d).withBdsEphemeris(m65015i(ephemerisResponse)).withGalileoEphemeris(m65014f(ephemerisResponse)).withGlonassEphemeris(m65011c(ephemerisResponse)).build();
            } catch (JsonSyntaxException unused2) {
                C1016d.m6183c("EphModule", "json syntax error");
                return null;
            } catch (JSONException e10) {
                C1016d.m6183c("EphModule", "jsonException:" + e10.getMessage());
                return null;
            }
        } catch (JsonSyntaxException unused3) {
            C1016d.m6183c("EphModule", "json syntax error");
            return null;
        }
    }

    /* renamed from: f */
    public final GalileoEphemeris m65014f(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        C14372a c14372a = this.f50983a;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGalTim());
        c14372a.getClass();
        GalileoTim galileoTimBuild = GalileoTim.Builder.aGalileoTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withT0(jSONObject.optLong("t0", 0L)).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGalNav());
        C14372a c14372a2 = this.f50983a;
        JSONArray jSONArray = jSONObject2.getJSONArray("ephList");
        c14372a2.getClass();
        GalileoNav[] galileoNavArrM85571c = C14372a.m85571c(jSONArray);
        C13850f.m83120a(new StringBuilder("galNavArray size = "), galileoNavArrM85571c.length, "EphModule");
        int iOptInt = jSONObject2.optInt("satNumber", 0);
        return GalileoEphemeris.Builder.aGalileoEphemeris().withSatNumber(iOptInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGalileoNavs(galileoNavArrM85571c).withGalileoTim(galileoTimBuild).build();
    }

    /* renamed from: i */
    public final BdsEphemeris m65015i(EphemerisResponse ephemerisResponse) throws JSONException {
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getBdsNav());
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getBdsIon());
        JSONObject jSONObject3 = new JSONObject(ephemerisResponse.getBdsTim());
        C14372a c14372a = this.f50983a;
        JSONArray jSONArray = jSONObject.getJSONArray("ephList");
        c14372a.getClass();
        BdsNav[] bdsNavArrM85572d = C14372a.m85572d(jSONArray);
        C14372a c14372a2 = this.f50983a;
        JSONArray jSONArray2 = jSONObject2.getJSONArray("ionList");
        c14372a2.getClass();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i10);
            arrayList.add(BdsIon.Builder.aBdsIon().withA0(jSONObjectOptJSONObject.optDouble("a0", 0.0d) / 1.073741824E9d).withA1(jSONObjectOptJSONObject.optDouble("a1", 0.0d) / 1.34217728E8d).withA2(jSONObjectOptJSONObject.optDouble("a2", 0.0d) / 1.6777216E7d).withA3(jSONObjectOptJSONObject.optDouble("a3", 0.0d) / 1.6777216E7d).withB0(jSONObjectOptJSONObject.optInt("b0", 0) * 2048).withB1(jSONObjectOptJSONObject.optInt("b1", 0) * 16384).withB2(jSONObjectOptJSONObject.optInt("b2", 0) * 65536).withB3(jSONObjectOptJSONObject.optInt("b3", 0) * 65536).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).withToe(jSONObjectOptJSONObject.optInt("toe", 0) * 8).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).build());
        }
        BdsIon[] bdsIonArr = new BdsIon[arrayList.size()];
        arrayList.toArray(bdsIonArr);
        C14372a c14372a3 = this.f50983a;
        JSONArray jSONArray3 = jSONObject3.getJSONArray("timList");
        c14372a3.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(i11);
            arrayList2.add(BdsTim.Builder.aBdsTim().withA0(jSONObjectOptJSONObject2.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObjectOptJSONObject2.optDouble("a1", 0.0d) / 2.251799813685248E15d).withA2((jSONObjectOptJSONObject2.optDouble("a2", 0.0d) / 1.152921504606847E18d) / 256.0d).withDeltaT(jSONObjectOptJSONObject2.optInt("deltaT", 0)).withGnssToId(jSONObjectOptJSONObject2.optInt("gnssToId", 0)).withWeekNumber(jSONObjectOptJSONObject2.optInt("weekNumber", 0)).withWeekSecond(jSONObjectOptJSONObject2.optInt("weekSecond", 0) * 16).build());
        }
        BdsTim[] bdsTimArr = new BdsTim[arrayList2.size()];
        arrayList2.toArray(bdsTimArr);
        C13850f.m83120a(new StringBuilder("BdsNav size = "), bdsNavArrM85572d.length, "EphModule");
        int iOptInt = jSONObject.optInt("satNumber", 0);
        return BdsEphemeris.Builder.aBdsEphemeris().withSatNumber(iOptInt).withNonBroadcastInd(jSONObject.optInt("nonBroadcastInd", 0)).withBdsNavs(bdsNavArrM85572d).withBdsIons(bdsIonArr).withBdsTims(bdsTimArr).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0148  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m65016j() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.C10603b.m65016j():boolean");
    }
}
