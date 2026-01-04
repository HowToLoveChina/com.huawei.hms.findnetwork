package bt;

import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsNav;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import p854zs.C14376e;

/* renamed from: bt.b */
/* loaded from: classes8.dex */
public final class C1285b {
    /* renamed from: a */
    public static GlonassNav[] m7623a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            arrayList.add(GlonassNav.Builder.aGlonassNav().withDeltaTau(jSONObjectOptJSONObject.optDouble("deltaTaun", 0.0d) / 1.073741824E9d).withEn(jSONObjectOptJSONObject.optInt(FaqConstants.DEFAULT_ISO_LANGUAGE, 0)).withGamma(jSONObjectOptJSONObject.optDouble("gamma", 0.0d) / 1.099511627776E12d).withHealth(jSONObjectOptJSONObject.optInt("health", 0)).withIod(jSONObjectOptJSONObject.optInt("iod", 0)).withM(jSONObjectOptJSONObject.optInt("m", 0)).withP1(jSONObjectOptJSONObject.optInt("p1", 0)).withP2(jSONObjectOptJSONObject.optInt("p2", 0)).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).withTaun(jSONObjectOptJSONObject.optDouble("taun", 0.0d) / 1.073741824E9d).withX(jSONObjectOptJSONObject.optDouble(Constants.MULTIPLE_SIGN, 0.0d) / 2048.0d).withXDot(jSONObjectOptJSONObject.optDouble("xDot", 0.0d) / 1048576.0d).withXDotDot(jSONObjectOptJSONObject.optDouble("xDotDot", 0.0d) / 1.073741824E9d).withY(jSONObjectOptJSONObject.optDouble("y", 0.0d) / 2048.0d).withYDot(jSONObjectOptJSONObject.optDouble("yDot", 0.0d) / 1048576.0d).withYDotDot(jSONObjectOptJSONObject.optDouble("yDotDot", 0.0d) / 1.073741824E9d).withZ(jSONObjectOptJSONObject.optDouble("z", 0.0d) / 2048.0d).withZDot(jSONObjectOptJSONObject.optDouble("zDot", 0.0d) / 1048576.0d).withZDotDot(jSONObjectOptJSONObject.optDouble("zDotDot", 0.0d) / 1.073741824E9d).build());
        }
        GlonassNav[] glonassNavArr = new GlonassNav[arrayList.size()];
        arrayList.toArray(glonassNavArr);
        return glonassNavArr;
    }

    /* renamed from: b */
    public static GpsNav[] m7624b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i11 < jSONArray.length()) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
            arrayList.add(GpsNav.Builder.aGpsNav().withAcc(jSONObjectOptJSONObject.optInt("acc", i10)).withAf0(jSONObjectOptJSONObject.optDouble("af0", 0.0d) / 2.147483648E9d).withAf1(jSONObjectOptJSONObject.optDouble("af1", 0.0d) / 8.796093022208E12d).withAf2(jSONObjectOptJSONObject.optDouble("af2", 0.0d) / 3.602879701896397E16d).withAodo(jSONObjectOptJSONObject.optInt("aodo", i10)).withCic(jSONObjectOptJSONObject.optDouble("cic", 0.0d) / 5.36870912E8d).withCis(jSONObjectOptJSONObject.optDouble("cis", 0.0d) / 5.36870912E8d).withCrs(jSONObjectOptJSONObject.optDouble("crs", 0.0d) / 32.0d).withCrc(jSONObjectOptJSONObject.optDouble("crc", 0.0d) / 32.0d).withCuc(jSONObjectOptJSONObject.optDouble("cuc", 0.0d) / 5.36870912E8d).withCus(jSONObjectOptJSONObject.optDouble("cus", 0.0d) / 5.36870912E8d).withDeltaN(C14376e.m85595a(jSONObjectOptJSONObject, "deltaN", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withEcc(jSONObjectOptJSONObject.optDouble("ecc", 0.0d) / 8.589934592E9d).withGpsTow23b((jSONObjectOptJSONObject.optDouble("gpsTow23b", 0.0d) * 4.0d) / 50.0d).withGroupDelay(jSONObjectOptJSONObject.optDouble("groupDelay", 0.0d) / 2.147483648E9d).withHealth(jSONObjectOptJSONObject.optInt("health", 0)).withI0(C14376e.m85595a(jSONObjectOptJSONObject, "i0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withIdot(C14376e.m85595a(jSONObjectOptJSONObject, "idot", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withIodc(jSONObjectOptJSONObject.optInt("iodc", 0)).withIode(jSONObjectOptJSONObject.optInt("iode", 0)).withM0(C14376e.m85595a(jSONObjectOptJSONObject, "m0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmega(C14376e.m85595a(jSONObjectOptJSONObject, "omega", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmega0(C14376e.m85595a(jSONObjectOptJSONObject, "omega0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmegaDot(C14376e.m85595a(jSONObjectOptJSONObject, "omegaDot", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withSqrtA(jSONObjectOptJSONObject.optDouble("sqrtA", 0.0d) / 524288.0d).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).withToc(jSONObjectOptJSONObject.optInt("toc", 0) * 16).withToe(jSONObjectOptJSONObject.optInt("toe", 0) * 16).withWeekNumber(jSONObjectOptJSONObject.optInt("weekNumber", 0)).build());
            i11++;
            i10 = 0;
        }
        GpsNav[] gpsNavArr = new GpsNav[arrayList.size()];
        arrayList.toArray(gpsNavArr);
        return gpsNavArr;
    }

    /* renamed from: c */
    public static GalileoNav[] m7625c(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            arrayList.add(GalileoNav.Builder.aGalileoNav().withAf0(jSONObjectOptJSONObject.optDouble("af0", 0.0d) / 1.7179869184E10d).withAf1(jSONObjectOptJSONObject.optDouble("af1", 0.0d) / 7.0368744177664E13d).withAf2(jSONObjectOptJSONObject.optDouble("af2", 0.0d) / 5.764607523034235E17d).withCic(jSONObjectOptJSONObject.optDouble("cic", 0.0d) / 5.36870912E8d).withCis(jSONObjectOptJSONObject.optDouble("cis", 0.0d) / 5.36870912E8d).withCrc(jSONObjectOptJSONObject.optDouble("crc", 0.0d) / 32.0d).withCrs(jSONObjectOptJSONObject.optDouble("crs", 0.0d) / 32.0d).withCuc(jSONObjectOptJSONObject.optDouble("cuc", 0.0d) / 5.36870912E8d).withCus(jSONObjectOptJSONObject.optDouble("cus", 0.0d) / 5.36870912E8d).withDeltaN(C14376e.m85595a(jSONObjectOptJSONObject, "deltaN", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withEcc(jSONObjectOptJSONObject.optDouble("ecc", 0.0d) / 8.589934592E9d).withGroupDelay(jSONObjectOptJSONObject.optDouble("groupDelay", 0.0d) / 4.294967296E9d).withHealth(jSONObjectOptJSONObject.optInt("health", 0)).withI0(C14376e.m85595a(jSONObjectOptJSONObject, "i0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withIDot(C14376e.m85595a(jSONObjectOptJSONObject, "inclinationDot", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withIodc(jSONObjectOptJSONObject.optInt("iodc", 0)).withIode(jSONObjectOptJSONObject.optInt("iode", 0)).withM0(C14376e.m85595a(jSONObjectOptJSONObject, "m0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmega(C14376e.m85595a(jSONObjectOptJSONObject, "omega", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmega0(C14376e.m85595a(jSONObjectOptJSONObject, "omega0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmegaDot(C14376e.m85595a(jSONObjectOptJSONObject, "omegaDot", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withSqrtA(jSONObjectOptJSONObject.optDouble("sqrtA", 0.0d) / 524288.0d).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).withToc(jSONObjectOptJSONObject.optInt("toc", 0) * 60).withToe(jSONObjectOptJSONObject.optInt("toe", 0) * 60).withNumClockModel(jSONObjectOptJSONObject.optInt("numClockModel", 0)).withClockModelId(jSONObjectOptJSONObject.optInt("clockModelID", 0)).build());
        }
        GalileoNav[] galileoNavArr = new GalileoNav[arrayList.size()];
        arrayList.toArray(galileoNavArr);
        return galileoNavArr;
    }

    /* renamed from: d */
    public static BdsNav[] m7626d(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i11 < jSONArray.length()) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
            arrayList.add(BdsNav.Builder.aBdsNav().withAcc(jSONObjectOptJSONObject.optInt("acc", i10)).withAf0(jSONObjectOptJSONObject.optDouble("af0", 0.0d) / 8.589934592E9d).withAf1(jSONObjectOptJSONObject.optDouble("af1", 0.0d) / 1.125899906842624E15d).withAf2((jSONObjectOptJSONObject.optDouble("af2", 0.0d) / 1.152921504606847E18d) / 64.0d).withAodc(jSONObjectOptJSONObject.optInt("aodc", i10)).withAode(jSONObjectOptJSONObject.optInt("aode", i10)).withCic(jSONObjectOptJSONObject.optDouble("cic", 0.0d) / 2.147483648E9d).withCis(jSONObjectOptJSONObject.optDouble("cis", 0.0d) / 2.147483648E9d).withCrs(jSONObjectOptJSONObject.optDouble("crs", 0.0d) / 64.0d).withCrc(jSONObjectOptJSONObject.optDouble("crc", 0.0d) / 64.0d).withCuc(jSONObjectOptJSONObject.optDouble("cuc", 0.0d) / 2.147483648E9d).withCus(jSONObjectOptJSONObject.optDouble("cus", 0.0d) / 2.147483648E9d).withDeltaN(C14376e.m85595a(jSONObjectOptJSONObject, "deltaN", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withEcc(jSONObjectOptJSONObject.optDouble("ecc", 0.0d) / 8.589934592E9d).withGroupDelay(jSONObjectOptJSONObject.optInt("groupDelay", 0) / Math.pow(10.0d, 10.0d)).withHealth(jSONObjectOptJSONObject.optInt("health", 0)).withI0(C14376e.m85595a(jSONObjectOptJSONObject, "i0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withIDot(C14376e.m85595a(jSONObjectOptJSONObject, "inclinationDot", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withM0(C14376e.m85595a(jSONObjectOptJSONObject, "m0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmega(C14376e.m85595a(jSONObjectOptJSONObject, "omega", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmega0(C14376e.m85595a(jSONObjectOptJSONObject, "omega0", 0.0d, 2.147483648E9d, 3.141592653589793d)).withOmegaDot(C14376e.m85595a(jSONObjectOptJSONObject, "omegaDot", 0.0d, 8.796093022208E12d, 3.141592653589793d)).withSqrtA(jSONObjectOptJSONObject.optDouble("sqrtA", 0.0d) / 524288.0d).withSvid(jSONObjectOptJSONObject.optInt("svid", 0) + 1).withToc(jSONObjectOptJSONObject.optInt("toc", 0) * 8).withToe(jSONObjectOptJSONObject.optInt("toe", 0) * 8).build());
            i11++;
            i10 = 0;
        }
        BdsNav[] bdsNavArr = new BdsNav[arrayList.size()];
        arrayList.toArray(bdsNavArr);
        return bdsNavArr;
    }
}
