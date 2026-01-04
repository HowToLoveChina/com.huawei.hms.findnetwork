package bt;

import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsIon;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsIon;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsNav;
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

/* renamed from: bt.d */
/* loaded from: classes8.dex */
public final class C1287d {

    /* renamed from: b */
    public static long f5754b = 0;

    /* renamed from: c */
    public static boolean f5755c = false;

    /* renamed from: d */
    public static long f5756d;

    /* renamed from: a */
    public C1285b f5757a = new C1285b();

    /* renamed from: a */
    public static JSONArray m7628a(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getBdsNav()).getJSONArray("ephList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphProvider", "getBdsNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: b */
    public static long m7629b() {
        if (f5754b <= 0) {
            f5754b = new C9549n("ephemeris_expire_time").m59623a("ephemeris_expire_time");
        }
        C1016d.m6186f("EphProvider", "getExpireTime = " + f5754b);
        return f5754b;
    }

    /* renamed from: g */
    public static JSONArray m7630g(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGalNav()).getJSONArray("ephList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphProvider", "getGalNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: i */
    public static JSONArray m7631i(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGpsNav()).getJSONArray("ephList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphProvider", "getGpsNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: l */
    public static JSONArray m7632l(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGloNav()).getJSONArray("gloNavItemList");
        } catch (JSONException e10) {
            C1016d.m6183c("EphProvider", "getGloNavs JSONException:" + e10.getMessage());
            return new JSONArray();
        }
    }

    /* renamed from: c */
    public final GalileoEphemeris m7633c(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        C1285b c1285b = this.f5757a;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGalTim());
        c1285b.getClass();
        GalileoTim galileoTimBuild = GalileoTim.Builder.aGalileoTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withT0(jSONObject.optLong("t0", 0L)).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGalNav());
        C1285b c1285b2 = this.f5757a;
        JSONArray jSONArray = jSONObject2.getJSONArray("ephList");
        c1285b2.getClass();
        GalileoNav[] galileoNavArrM7625c = C1285b.m7625c(jSONArray);
        C13850f.m83120a(new StringBuilder("galNavArray size = "), galileoNavArrM7625c.length, "EphProvider");
        int iOptInt = jSONObject2.optInt("satNumber", 0);
        return GalileoEphemeris.Builder.aGalileoEphemeris().withSatNumber(iOptInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGalileoNavs(galileoNavArrM7625c).withGalileoTim(galileoTimBuild).build();
    }

    /* renamed from: d */
    public final GlonassEphemeris m7634d(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        C1285b c1285b = this.f5757a;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGloTim());
        c1285b.getClass();
        GlonassTim glonassTimBuild = GlonassTim.Builder.aGlonassTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withA2((jSONObject.optDouble("a2", 0.0d) / 1.152921504606847E18d) / 256.0d).withGnssToId(jSONObject.optInt("gnssToId", 0)).withWeekNumber(jSONObject.optInt("weekNumber", 0)).withWeekSecond(jSONObject.optInt("weekSecond", 0) * 16).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGloNav());
        C1285b c1285b2 = this.f5757a;
        JSONArray jSONArray = jSONObject2.getJSONArray("gloNavItemList");
        c1285b2.getClass();
        GlonassNav[] glonassNavArrM7623a = C1285b.m7623a(jSONArray);
        C13850f.m83120a(new StringBuilder("GlonassNav size = "), glonassNavArrM7623a.length, "EphProvider");
        int iOptInt = jSONObject2.optInt("satNumber", 0);
        return GlonassEphemeris.Builder.aGlonassEphemeris().withSatNumber(iOptInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGlonassNavs(glonassNavArrM7623a).withGlonassTim(glonassTimBuild).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:246:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x03e0  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris m7635e() throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bt.C1287d.m7635e():com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris");
    }

    /* renamed from: f */
    public final Ephemeris m7636f(EphemerisResponse ephemerisResponse) {
        String str;
        if (ephemerisResponse == null) {
            return null;
        }
        try {
            if (this.f5757a == null) {
                this.f5757a = new C1285b();
            }
            GpsEphemeris gpsEphemerisM7637h = m7637h(ephemerisResponse);
            BdsEphemeris bdsEphemerisM7638j = m7638j(ephemerisResponse);
            return Ephemeris.Builder.anEphemeris().withGpsEphemeris(gpsEphemerisM7637h).withBdsEphemeris(bdsEphemerisM7638j).withGalileoEphemeris(m7633c(ephemerisResponse)).withGlonassEphemeris(m7634d(ephemerisResponse)).build();
        } catch (JsonSyntaxException unused) {
            str = "json syntax error";
            C1016d.m6183c("EphProvider", str);
            return null;
        } catch (JSONException e10) {
            str = "jsonException:" + e10.getMessage();
            C1016d.m6183c("EphProvider", str);
            return null;
        }
    }

    /* renamed from: h */
    public final GpsEphemeris m7637h(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        C1285b c1285b = this.f5757a;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGpsIon());
        c1285b.getClass();
        GpsIon gpsIonBuild = GpsIon.Builder.aGpsIon().withA0(jSONObject.optDouble("a0", 0.0d) / 1.073741824E9d).withA1(jSONObject.optDouble("a1", 0.0d) / 1.34217728E8d).withA2(jSONObject.optDouble("a2", 0.0d) / 1.6777216E7d).withA3(jSONObject.optDouble("a3", 0.0d) / 1.6777216E7d).withB0(jSONObject.optInt("b0", 0) * 2048).withB1(jSONObject.optInt("b1", 0) * 16384).withB2(jSONObject.optInt("b2", 0) * 65536).withB3(jSONObject.optInt("b3", 0) * 65536).withValid(jSONObject.optBoolean("valid")).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGpsNav());
        C1285b c1285b2 = this.f5757a;
        JSONArray jSONArray = jSONObject2.getJSONArray("ephList");
        c1285b2.getClass();
        GpsNav[] gpsNavArrM7624b = C1285b.m7624b(jSONArray);
        C13850f.m83120a(new StringBuilder("GpsNav size = "), gpsNavArrM7624b.length, "EphProvider");
        return GpsEphemeris.Builder.aGpsEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withGpsNavs(gpsNavArrM7624b).withGpsIon(gpsIonBuild).build();
    }

    /* renamed from: j */
    public final BdsEphemeris m7638j(EphemerisResponse ephemerisResponse) throws JSONException {
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getBdsNav());
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getBdsIon());
        JSONObject jSONObject3 = new JSONObject(ephemerisResponse.getBdsTim());
        C1285b c1285b = this.f5757a;
        JSONArray jSONArray = jSONObject.getJSONArray("ephList");
        c1285b.getClass();
        BdsNav[] bdsNavArrM7626d = C1285b.m7626d(jSONArray);
        C1285b c1285b2 = this.f5757a;
        JSONArray jSONArray2 = jSONObject2.getJSONArray("ionList");
        c1285b2.getClass();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i10);
            arrayList.add(BdsIon.Builder.aBdsIon().withA0(jSONObjectOptJSONObject.optDouble("a0", 0.0d) / 1.073741824E9d).withA1(jSONObjectOptJSONObject.optDouble("a1", 0.0d) / 1.34217728E8d).withA2(jSONObjectOptJSONObject.optDouble("a2", 0.0d) / 1.6777216E7d).withA3(jSONObjectOptJSONObject.optDouble("a3", 0.0d) / 1.6777216E7d).withB0(jSONObjectOptJSONObject.optInt("b0", 0) * 2048).withB1(jSONObjectOptJSONObject.optInt("b1", 0) * 16384).withB2(jSONObjectOptJSONObject.optInt("b2", 0) * 65536).withB3(jSONObjectOptJSONObject.optInt("b3", 0) * 65536).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).withToe(jSONObjectOptJSONObject.optInt("toe", 0) * 8).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).build());
        }
        BdsIon[] bdsIonArr = new BdsIon[arrayList.size()];
        arrayList.toArray(bdsIonArr);
        C1285b c1285b3 = this.f5757a;
        JSONArray jSONArray3 = jSONObject3.getJSONArray("timList");
        c1285b3.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(i11);
            arrayList2.add(BdsTim.Builder.aBdsTim().withA0(jSONObjectOptJSONObject2.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObjectOptJSONObject2.optDouble("a1", 0.0d) / 2.251799813685248E15d).withA2((jSONObjectOptJSONObject2.optDouble("a2", 0.0d) / 1.152921504606847E18d) / 256.0d).withDeltaT(jSONObjectOptJSONObject2.optInt("deltaT", 0)).withGnssToId(jSONObjectOptJSONObject2.optInt("gnssToId", 0)).withWeekNumber(jSONObjectOptJSONObject2.optInt("weekNumber", 0)).withWeekSecond(jSONObjectOptJSONObject2.optInt("weekSecond", 0) * 16).build());
        }
        BdsTim[] bdsTimArr = new BdsTim[arrayList2.size()];
        arrayList2.toArray(bdsTimArr);
        C13850f.m83120a(new StringBuilder("BdsNav size = "), bdsNavArrM7626d.length, "EphProvider");
        int iOptInt = jSONObject.optInt("satNumber", 0);
        return BdsEphemeris.Builder.aBdsEphemeris().withSatNumber(iOptInt).withNonBroadcastInd(jSONObject.optInt("nonBroadcastInd", 0)).withBdsNavs(bdsNavArrM7626d).withBdsIons(bdsIonArr).withBdsTims(bdsTimArr).build();
    }

    /* renamed from: k */
    public final Ephemeris m7639k() throws IOException {
        String string;
        C1284a c1284a = new C1284a(System.currentTimeMillis());
        long jM7619c = c1284a.m7619c();
        C1016d.m6186f("EphProvider", "gpsTime = " + c1284a.m7619c());
        if (jM7619c > m7629b()) {
            return m7635e();
        }
        C1016d.m6186f("EphProvider", "try to get local Ephemeris here");
        try {
            FileInputStream fileInputStreamOpenFileInput = C11991a.m72145a().openFileInput("ephData");
            try {
                if (fileInputStreamOpenFileInput.available() < 0 || fileInputStreamOpenFileInput.available() > 20971520) {
                    C1016d.m6183c("FileUtil", "FileInputStream length is illegal");
                    string = null;
                } else {
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
                }
                fileInputStreamOpenFileInput.close();
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("FileUtil", "read from file failed");
            string = null;
        }
        if (string == null) {
            C1016d.m6186f("EphProvider", "read Ephemeris From Json is null");
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
            return m7636f((EphemerisResponse) C9542g.m59588a().fromJson(stringBuffer.toString().trim(), EphemerisResponse.class));
        } catch (JsonSyntaxException unused2) {
            C1016d.m6183c("EphProvider", "json syntax error");
            return null;
        }
    }
}
