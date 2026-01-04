package p629s1;

import com.huawei.hianalytics.core.storage.Event;
import com.huawei.openalliance.p169ad.constant.VastTag;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import p541p1.C12069a;
import p541p1.C12070b;
import p541p1.C12072d;
import p541p1.C12073e;
import p541p1.InterfaceC12071c;
import p563q1.C12272a;
import p563q1.C12273b;
import p598r1.C12455a;
import p598r1.C12456b;
import p598r1.C12457c;
import p629s1.C12665d;
import p644t1.C12916d;

/* renamed from: s1.b */
/* loaded from: classes.dex */
public class C12663b {

    /* renamed from: s1.b$a */
    public class a implements Comparator<C12073e> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C12073e c12073e, C12073e c12073e2) {
            return c12073e.f55891a.f55884b - c12073e2.f55891a.f55884b;
        }
    }

    /* renamed from: a */
    public static int m76214a(int i10) {
        if (i10 <= 50 || i10 >= 100) {
            return i10 > 100 ? i10 - 50 : i10;
        }
        return 50;
    }

    /* renamed from: b */
    public static String m76215b(String str) {
        C12272a c12272aM76227n;
        ArrayList<C12073e> arrayList;
        try {
            c12272aM76227n = m76227n(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            c12272aM76227n = null;
        }
        if (c12272aM76227n == null || (arrayList = c12272aM76227n.f56911b) == null || arrayList.size() == 0) {
            C12665d.a.m76245d("HEFileUtils", " , convertHe10ToHe20, invalid HE1.0 string!");
            return "";
        }
        C12455a c12455a = new C12455a();
        c12455a.f57379a = new C12456b();
        c12455a.f57380b = new ArrayList<>();
        C12457c c12457c = new C12457c();
        c12457c.f57385b = c12272aM76227n.f56911b;
        c12457c.f57384a = 0;
        c12455a.f57380b.add(c12457c);
        return m76219f(c12455a);
    }

    /* renamed from: c */
    public static String m76216c(String str, int i10, int i11, int i12) throws JSONException {
        int i13;
        double d10;
        double d11;
        double d12;
        int i14;
        String str2;
        C12665d.a.m76242a("HEFileUtils", "overwriteBaseFrequencyAndIntensityOfHe20String, deltaFreq:" + i11 + ", deltaIntensity:" + i10 + ", majorCoreVersion:" + i12);
        if (i11 == 0 && (255 == i10 || 256 == i10)) {
            str2 = "overwriteBaseFrequencyAndIntensityOfHe20String, do nothing!";
        } else {
            double d13 = 0.0d;
            double d14 = (255 == i10 || 256 == i10) ? 0.0d : (i10 - 255.5d) / 255.5d;
            double d15 = i11 / 100.0d;
            C12665d.a.m76242a("HEFileUtils", "overwriteBaseFrequencyAndIntensityOfHe20String, freqRatio:" + d15 + ", intensityRatio:" + d14);
            C12455a c12455aM76229p = m76229p(str);
            if (C12916d.m77553d(c12455aM76229p)) {
                Iterator<C12457c> it = c12455aM76229p.f57380b.iterator();
                while (it.hasNext()) {
                    Iterator<C12073e> it2 = it.next().f57385b.iterator();
                    while (it2.hasNext()) {
                        C12073e next = it2.next();
                        if ("transient".equals(next.f55891a.f55883a)) {
                            C12072d c12072d = next.f55891a.f55887e;
                            int i15 = c12072d.f55889b;
                            if (i15 == 0 && c12072d.f55888a == 0) {
                                C12665d.a.m76242a("HEFileUtils", "overwriteBaseFrequencyAndIntensityOfHe20String, ignore placeholder event!");
                            } else {
                                if (i12 >= 24) {
                                    i14 = (int) (d15 >= d13 ? i15 + ((150 - i15) * d15) : i15 + ((i15 + 50) * d15));
                                } else {
                                    double d16 = i15;
                                    if (d15 >= d13) {
                                        i15 = 100 - i15;
                                    }
                                    i14 = (int) (d16 + (i15 * d15));
                                }
                                c12072d.f55889b = i14;
                            }
                        } else if ("continuous".equals(next.f55891a.f55883a)) {
                            C12072d c12072d2 = next.f55891a.f55887e;
                            if (d15 >= 0.0d) {
                                int i16 = c12072d2.f55889b;
                                d10 = i16;
                                i13 = 100 - i16;
                            } else {
                                i13 = c12072d2.f55889b;
                                d10 = i13;
                            }
                            c12072d2.f55889b = (int) (d10 + (i13 * d15));
                        }
                        C12072d c12072d3 = next.f55891a.f55887e;
                        if (d14 >= 0.0d) {
                            d12 = c12072d3.f55888a;
                            d11 = (100 - r7) * d14;
                        } else {
                            int i17 = c12072d3.f55888a;
                            d11 = i17;
                            d12 = i17 * d14;
                        }
                        c12072d3.f55888a = (int) (d12 + d11);
                        d13 = 0.0d;
                    }
                }
                String strM76219f = m76219f(c12455aM76229p);
                C12665d.a.m76242a("HEFileUtils", "overwriteBaseFrequencyAndIntensityOfHe20String, result:" + strM76219f);
                return strM76219f;
            }
            str2 = "overwriteBaseFrequencyAndIntensityOfHe20String, do nothing as invalid he20String";
        }
        C12665d.a.m76242a("HEFileUtils", str2);
        return str;
    }

    /* renamed from: d */
    public static String m76217d(String str, boolean z10) throws Throwable {
        String str2;
        if (z10) {
            str = m76232s(str);
        }
        String strM76234u = m76234u(str);
        if (strM76234u == null || strM76234u.length() == 0) {
            str2 = "convertHE20ToHE10, null after trim";
        } else {
            C12455a c12455aM76229p = m76229p(strM76234u);
            if (InterfaceC12071c.m72222a(c12455aM76229p)) {
                Iterator<C12073e> it = c12455aM76229p.f57380b.get(0).f57385b.iterator();
                while (it.hasNext()) {
                    it.next().f55891a.f55884b += c12455aM76229p.f57380b.get(0).f57384a;
                }
                C12272a c12272a = new C12272a();
                c12272a.f56910a = new C12273b();
                ArrayList<C12073e> arrayList = c12455aM76229p.f57380b.get(0).f57385b;
                c12272a.f56911b = arrayList;
                Iterator<C12073e> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    C12073e next = it2.next();
                    C12070b c12070b = next.f55891a;
                    if (c12070b != null && "continuous".equals(c12070b.f55883a)) {
                        C12072d c12072d = next.f55891a.f55887e;
                        if (-1 == c12072d.f55889b) {
                            c12072d.f55889b = 56;
                            Iterator<C12069a> it3 = c12072d.f55890c.iterator();
                            while (it3.hasNext()) {
                                it3.next().f55882c = 0;
                            }
                        }
                    }
                }
                String strM76218e = m76218e(c12272a);
                C12665d.a.m76242a("HEFileUtils", "convertHE20ToHE10 result:" + strM76218e);
                return strM76218e;
            }
            str2 = "convertHE20ToHE10, empty HeRoot";
        }
        C12665d.a.m76243b("HEFileUtils", str2);
        return null;
    }

    /* renamed from: e */
    public static String m76218e(C12272a c12272a) throws JSONException {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.object();
            jSONStringer.key("Metadata").object().key("Created").value(c12272a.f56910a.f56913b).key(VastTag.DESCRIPTION).value(c12272a.f56910a.f56914c).key("Version").value(c12272a.f56910a.f56912a).endObject();
            jSONStringer.key("Pattern").array();
            Iterator<C12073e> it = c12272a.f56911b.iterator();
            while (it.hasNext()) {
                C12073e next = it.next();
                jSONStringer.object();
                jSONStringer.key(Event.TAG).object().key(FaqConstants.FAQ_UPLOAD_FLAG).value(next.f55891a.f55883a).key("RelativeTime").value(next.f55891a.f55884b);
                if ("continuous".equals(next.f55891a.f55883a)) {
                    jSONStringer.key(VastTag.DURATION).value(next.f55891a.f55885c);
                }
                jSONStringer.key("Parameters").object().key("Frequency").value(next.f55891a.f55887e.f55889b).key("Intensity").value(next.f55891a.f55887e.f55888a);
                if ("continuous".equals(next.f55891a.f55883a)) {
                    jSONStringer.key("Curve").array();
                    Iterator<C12069a> it2 = next.f55891a.f55887e.f55890c.iterator();
                    while (it2.hasNext()) {
                        jSONStringer.object().key("Frequency").value(r5.f55882c).key("Intensity").value(it2.next().f55881b).key("Time").value(r5.f55880a).endObject();
                    }
                    jSONStringer.endArray();
                }
                jSONStringer.endObject().endObject().endObject();
            }
            jSONStringer.endArray().endObject();
            return jSONStringer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public static String m76219f(C12455a c12455a) throws JSONException {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.object();
            jSONStringer.key("Metadata").object().key("Created").value(c12455a.f57379a.f57382b).key(VastTag.DESCRIPTION).value(c12455a.f57379a.f57383c).key("Version").value(c12455a.f57379a.f57381a).endObject();
            jSONStringer.key("PatternList").array();
            Iterator<C12457c> it = c12455a.f57380b.iterator();
            while (it.hasNext()) {
                C12457c next = it.next();
                jSONStringer.object().key("AbsoluteTime").value(next.f57384a).key("Pattern").array();
                Iterator<C12073e> it2 = next.f57385b.iterator();
                while (it2.hasNext()) {
                    C12073e next2 = it2.next();
                    jSONStringer.object();
                    jSONStringer.key(Event.TAG).object().key("Index").value(next2.f55891a.f55886d).key("RelativeTime").value(next2.f55891a.f55884b).key(FaqConstants.FAQ_UPLOAD_FLAG).value(next2.f55891a.f55883a);
                    if ("continuous".equals(next2.f55891a.f55883a)) {
                        jSONStringer.key(VastTag.DURATION).value(next2.f55891a.f55885c);
                    }
                    jSONStringer.key("Parameters").object().key("Frequency").value(next2.f55891a.f55887e.f55889b).key("Intensity").value(next2.f55891a.f55887e.f55888a);
                    if ("continuous".equals(next2.f55891a.f55883a)) {
                        jSONStringer.key("Curve").array();
                        Iterator<C12069a> it3 = next2.f55891a.f55887e.f55890c.iterator();
                        while (it3.hasNext()) {
                            jSONStringer.object().key("Frequency").value(r6.f55882c).key("Intensity").value(it3.next().f55881b).key("Time").value(r6.f55880a).endObject();
                        }
                        jSONStringer.endArray();
                    }
                    jSONStringer.endObject().endObject().endObject();
                }
                jSONStringer.endArray().endObject();
            }
            jSONStringer.endArray().endObject();
            return jSONStringer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    public static String m76220g(C12457c c12457c, boolean z10) {
        C12455a c12455a = new C12455a();
        c12455a.f57379a = new C12456b();
        ArrayList<C12457c> arrayList = new ArrayList<>();
        c12455a.f57380b = arrayList;
        if (z10) {
            C12457c c12457c2 = new C12457c();
            c12457c2.f57384a = 0;
            c12457c2.f57385b = c12457c.f57385b;
            c12455a.f57380b.add(c12457c2);
        } else {
            arrayList.add(c12457c);
        }
        return m76219f(c12455a);
    }

    /* renamed from: h */
    public static ArrayList<C12069a> m76221h(ArrayList<C12069a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        int size = arrayList.size();
        C12665d.a.m76242a("HEFileUtils", "trimTo4p size:" + size);
        if (size > 0 && size <= 4) {
            return arrayList;
        }
        C12069a c12069a = new C12069a();
        int i10 = size - 2;
        int i11 = i10 / 2;
        for (int i12 = 1; i12 <= i11; i12++) {
            c12069a.f55880a += arrayList.get(i12).f55880a;
            c12069a.f55881b += arrayList.get(i12).f55881b;
            c12069a.f55882c += arrayList.get(i12).f55882c;
        }
        c12069a.f55880a /= i11;
        c12069a.f55881b = c12069a.f55881b / i11;
        c12069a.f55881b = Math.round(r7 * 10.0d) / 10.0d;
        c12069a.f55882c /= i11;
        C12069a c12069a2 = new C12069a();
        for (int i13 = i11 + 1; i13 <= i10; i13++) {
            c12069a2.f55880a += arrayList.get(i13).f55880a;
            c12069a2.f55881b += arrayList.get(i13).f55881b;
            c12069a2.f55882c += arrayList.get(i13).f55882c;
        }
        int i14 = i10 - i11;
        c12069a2.f55880a /= i14;
        c12069a2.f55881b = c12069a2.f55881b / i14;
        c12069a2.f55881b = Math.round(r11 * 10.0d) / 10.0d;
        c12069a2.f55882c /= i14;
        C12665d.a.m76242a("HEFileUtils", "trimTo4p size:" + arrayList.size());
        arrayList.subList(1, size - 1).clear();
        arrayList.add(1, c12069a);
        arrayList.add(2, c12069a2);
        return arrayList;
    }

    /* renamed from: i */
    public static void m76222i(String str, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        C12070b c12070b;
        int iM76224k;
        if (str == null || str.length() == 0 || arrayList == null || arrayList2 == null) {
            C12665d.a.m76243b("HEFileUtils", "convertHE10StringToWaveformParams(), invalid parameters.");
            return;
        }
        InterfaceC12071c interfaceC12071cM76231r = m76231r(str, 1);
        if (!InterfaceC12071c.m72222a(interfaceC12071cM76231r)) {
            C12665d.a.m76245d("HEFileUtils", "convertHE10StringToGoogleWaveform, invalid heRoot!");
            return;
        }
        if (1 != interfaceC12071cM76231r.mo72223a()) {
            C12665d.a.m76245d("HEFileUtils", "convertHE10StringToGoogleWaveform, invalid HE version:" + interfaceC12071cM76231r.mo72223a());
            return;
        }
        arrayList.clear();
        arrayList2.clear();
        long jLongValue = 0;
        arrayList.add(new Long(0L));
        arrayList2.add(0);
        Iterator<C12073e> it = ((C12272a) interfaceC12071cM76231r).f56911b.iterator();
        while (it.hasNext()) {
            C12073e next = it.next();
            if (next != null && (c12070b = next.f55891a) != null && c12070b.f55887e != null) {
                if ("transient".equals(c12070b.f55883a)) {
                    int i10 = next.f55891a.f55884b;
                    if (i10 > jLongValue) {
                        arrayList.add(Long.valueOf(new Long(i10).longValue() - jLongValue));
                        arrayList2.add(0);
                        jLongValue += arrayList.get(arrayList.size() - 1).longValue();
                    }
                    C12072d c12072d = next.f55891a.f55887e;
                    arrayList.add(new Long(m76225l(c12072d.f55888a, c12072d.f55889b)));
                    iM76224k = next.f55891a.f55887e.f55888a;
                } else if ("continuous".equals(next.f55891a.f55883a)) {
                    ArrayList<C12069a> arrayList3 = next.f55891a.f55887e.f55890c;
                    if (arrayList3 != null && 4 == arrayList3.size()) {
                        int i11 = next.f55891a.f55884b;
                        if (i11 > jLongValue) {
                            arrayList.add(Long.valueOf(new Long(i11).longValue() - jLongValue));
                            arrayList2.add(0);
                            jLongValue += arrayList.get(arrayList.size() - 1).longValue();
                        }
                        arrayList.add(new Long(m76214a(next.f55891a.f55885c)));
                        C12072d c12072d2 = next.f55891a.f55887e;
                        iM76224k = m76224k(c12072d2.f55888a, c12072d2.f55889b);
                    }
                } else {
                    C12665d.a.m76243b("HEFileUtils", "unknown type!");
                }
                arrayList2.add(Integer.valueOf((int) (((iM76224k * 1.0d) / 100.0d) * 255.0d)));
                jLongValue += arrayList.get(arrayList.size() - 1).longValue();
            }
        }
        if (C12665d.m76241c()) {
            Iterator<Long> it2 = arrayList.iterator();
            String str2 = "";
            String str3 = "";
            while (it2.hasNext()) {
                str3 = str3 + it2.next().toString() + ",";
            }
            Iterator<Integer> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                str2 = str2 + it3.next().toString() + ",";
            }
            C12665d.a.m76242a("HEFileUtils", "timings size:" + arrayList.size() + ",amplitudes size:" + arrayList2.size() + "\n timings:" + str3 + "\n amplitudes:" + str2);
        }
    }

    /* renamed from: j */
    public static int[] m76223j(String str, int i10, int i11, int i12, int i13, int i14, boolean z10) {
        String str2;
        C12272a c12272a;
        String str3;
        Integer num;
        char c10;
        Integer num2;
        Iterator<C12457c> it;
        Integer num3;
        String str4;
        StringBuilder sb2;
        Integer numValueOf;
        int i15 = i11;
        ArrayList arrayList = new ArrayList();
        Integer num4 = 4096;
        String str5 = "continuous";
        Integer num5 = 4097;
        String str6 = "transient";
        int i16 = 24;
        int i17 = 1;
        try {
            if (i10 != 1) {
                if (i10 != 2 || 24 > i15) {
                    return null;
                }
                C12455a c12455aM76229p = m76229p(str);
                ArrayList<C12457c> arrayList2 = c12455aM76229p.f57380b;
                if (arrayList2 != null && arrayList2.size() > 0 && c12455aM76229p.f57380b.get(0).f57385b != null && c12455aM76229p.f57380b.get(0).f57385b.size() > 0) {
                    int size = c12455aM76229p.f57380b.size();
                    if (size > 4) {
                        C12665d.a.m76245d("HEFileUtils", "convertHEStringToIntArray, HE20 with more than 4 pattern!");
                    }
                    arrayList.add(2);
                    arrayList.add(2);
                    arrayList.add(Integer.valueOf(i13));
                    arrayList.add(Integer.valueOf(i14));
                    arrayList.add(Integer.valueOf((65535 & size) | ((size << 16) & (-65536))));
                    Iterator<C12457c> it2 = c12455aM76229p.f57380b.iterator();
                    int i18 = 0;
                    while (it2.hasNext()) {
                        C12457c next = it2.next();
                        int i19 = i18 + 1;
                        arrayList.add(Integer.valueOf(i18));
                        arrayList.add(Integer.valueOf(next.f57384a));
                        int size2 = next.f57385b.size() <= 16 ? next.f57385b.size() : 16;
                        arrayList.add(Integer.valueOf(size2));
                        int i20 = 0;
                        while (i20 < size2) {
                            C12073e c12073e = next.f57385b.get(i20);
                            if ("transient".equals(c12073e.f55891a.f55883a)) {
                                arrayList.add(num5);
                                arrayList.add(5);
                                int i21 = c12073e.f55891a.f55886d;
                                if (z10) {
                                    i21 = i21 == 0 ? 0 : i17 == i21 ? 2 : i17;
                                }
                                arrayList.add(Integer.valueOf(i21));
                                arrayList.add(Integer.valueOf(c12073e.f55891a.f55884b));
                                arrayList.add(Integer.valueOf(c12073e.f55891a.f55887e.f55888a));
                                arrayList.add(Integer.valueOf(c12073e.f55891a.f55887e.f55889b));
                                arrayList.add(Integer.valueOf(c12073e.f55891a.f55885c));
                                it = it2;
                            } else {
                                if (str5.equals(c12073e.f55891a.f55883a)) {
                                    int size3 = c12073e.f55891a.f55887e.f55890c.size();
                                    if (4 > size3 || 16 < size3) {
                                        it = it2;
                                        num3 = num4;
                                        str4 = str5;
                                        sb2 = new StringBuilder();
                                        sb2.append("convertHEStringToIntArray, curvePointCount:");
                                        sb2.append(size3);
                                    } else {
                                        arrayList.add(num4);
                                        arrayList.add(Integer.valueOf((size3 * 3) + 6));
                                        int i22 = c12073e.f55891a.f55886d;
                                        it = it2;
                                        if (z10) {
                                            i22 = i22 == 0 ? 0 : 1 == i22 ? 2 : 1;
                                        }
                                        arrayList.add(Integer.valueOf(i22));
                                        arrayList.add(Integer.valueOf(c12073e.f55891a.f55884b));
                                        arrayList.add(Integer.valueOf(c12073e.f55891a.f55887e.f55888a));
                                        if (i15 > 32 || i12 > 16) {
                                            numValueOf = Integer.valueOf(c12073e.f55891a.f55887e.f55889b);
                                        } else {
                                            int i23 = c12073e.f55891a.f55887e.f55889b;
                                            if (-1 == i23) {
                                                i23 = 56;
                                            }
                                            numValueOf = Integer.valueOf(i23);
                                        }
                                        arrayList.add(numValueOf);
                                        arrayList.add(Integer.valueOf(c12073e.f55891a.f55885c));
                                        arrayList.add(Integer.valueOf(size3));
                                        Iterator<C12069a> it3 = c12073e.f55891a.f55887e.f55890c.iterator();
                                        while (it3.hasNext()) {
                                            C12069a next2 = it3.next();
                                            arrayList.add(Integer.valueOf(next2.f55880a));
                                            Integer num6 = num4;
                                            String str7 = str5;
                                            arrayList.add(Integer.valueOf((int) (next2.f55881b * 100.0d)));
                                            int i24 = (i15 > 32 || i12 > 16 || -1 != c12073e.f55891a.f55887e.f55889b) ? next2.f55882c : 0;
                                            arrayList.add(Integer.valueOf(i24));
                                            num4 = num6;
                                            str5 = str7;
                                        }
                                    }
                                } else {
                                    it = it2;
                                    num3 = num4;
                                    str4 = str5;
                                    sb2 = new StringBuilder();
                                    sb2.append("convertHEStringToIntArray, skip unknown type:");
                                    sb2.append(c12073e.f55891a.f55883a);
                                }
                                C12665d.a.m76245d("HEFileUtils", sb2.toString());
                                i20++;
                                it2 = it;
                                num4 = num3;
                                str5 = str4;
                                i17 = 1;
                            }
                            num3 = num4;
                            str4 = str5;
                            i20++;
                            it2 = it;
                            num4 = num3;
                            str5 = str4;
                            i17 = 1;
                        }
                        i18 = i19;
                    }
                }
                C12665d.a.m76245d("HEFileUtils", "convertHEStringToIntArray, empty HE20!");
                return null;
            }
            Integer num7 = num4;
            String str8 = "continuous";
            C12272a c12272aM76227n = m76227n(str);
            ArrayList<C12073e> arrayList3 = c12272aM76227n.f56911b;
            if (arrayList3 == null && arrayList3.size() <= 0) {
                C12665d.a.m76245d("HEFileUtils", "convertHEStringToIntArray, empty HE10!");
                return null;
            }
            char c11 = 3;
            arrayList.add(24 > i15 ? 1 : 3);
            int size4 = c12272aM76227n.f56911b.size() <= 16 ? c12272aM76227n.f56911b.size() : 16;
            int i25 = 0;
            while (i25 < size4) {
                C12073e c12073e2 = c12272aM76227n.f56911b.get(i25);
                if (str6.equals(c12073e2.f55891a.f55883a)) {
                    arrayList.add(num5);
                    arrayList.add(Integer.valueOf(c12073e2.f55891a.f55884b));
                    arrayList.add(Integer.valueOf(c12073e2.f55891a.f55887e.f55888a));
                    arrayList.add(Integer.valueOf(c12073e2.f55891a.f55887e.f55889b));
                    arrayList.add(Integer.valueOf(c12073e2.f55891a.f55885c));
                    if (i16 > i15) {
                        for (int i26 = 0; i26 < 12; i26++) {
                            arrayList.add(0);
                        }
                    } else {
                        arrayList.add(0);
                        arrayList.add(0);
                        for (int i27 = 0; i27 < 48; i27++) {
                            arrayList.add(0);
                        }
                    }
                    c12272a = c12272aM76227n;
                    str3 = str6;
                    num = num7;
                    str2 = str8;
                } else {
                    str2 = str8;
                    if (str2.equals(c12073e2.f55891a.f55883a)) {
                        int size5 = c12073e2.f55891a.f55887e.f55890c.size();
                        if (i16 <= i15 || 4 == size5) {
                            if (i16 > i15 || (4 <= size5 && 16 >= size5)) {
                                num = num7;
                                arrayList.add(num);
                                arrayList.add(Integer.valueOf(c12073e2.f55891a.f55884b));
                                arrayList.add(Integer.valueOf(c12073e2.f55891a.f55887e.f55888a));
                                int i28 = c12073e2.f55891a.f55887e.f55889b;
                                if (-1 == i28) {
                                    i28 = 56;
                                }
                                arrayList.add(Integer.valueOf(i28));
                                arrayList.add(Integer.valueOf(c12073e2.f55891a.f55885c));
                                if (24 > i15) {
                                    Iterator<C12069a> it4 = c12073e2.f55891a.f55887e.f55890c.iterator();
                                    while (it4.hasNext()) {
                                        C12069a next3 = it4.next();
                                        arrayList.add(Integer.valueOf(next3.f55880a));
                                        C12272a c12272a2 = c12272aM76227n;
                                        arrayList.add(Integer.valueOf((int) (next3.f55881b * 100.0d)));
                                        arrayList.add(Integer.valueOf(-1 == c12073e2.f55891a.f55887e.f55889b ? 0 : next3.f55882c));
                                        c12272aM76227n = c12272a2;
                                    }
                                    c12272a = c12272aM76227n;
                                    num2 = num5;
                                    str3 = str6;
                                    c10 = 3;
                                } else {
                                    c12272a = c12272aM76227n;
                                    arrayList.add(Integer.valueOf(size5));
                                    Iterator<C12069a> it5 = c12073e2.f55891a.f55887e.f55890c.iterator();
                                    while (it5.hasNext()) {
                                        C12069a next4 = it5.next();
                                        arrayList.add(Integer.valueOf(next4.f55880a));
                                        Integer num8 = num5;
                                        String str9 = str6;
                                        arrayList.add(Integer.valueOf((int) (next4.f55881b * 100.0d)));
                                        arrayList.add(Integer.valueOf(-1 == c12073e2.f55891a.f55887e.f55889b ? 0 : next4.f55882c));
                                        num5 = num8;
                                        str6 = str9;
                                    }
                                    num2 = num5;
                                    str3 = str6;
                                    int i29 = 0;
                                    while (true) {
                                        c10 = 3;
                                        if (i29 < (16 - size5) * 3) {
                                            arrayList.add(0);
                                            i29++;
                                        }
                                    }
                                }
                            }
                        }
                        c12272a = c12272aM76227n;
                        str3 = str6;
                        num = num7;
                    } else {
                        c12272a = c12272aM76227n;
                        str3 = str6;
                        num = num7;
                        Integer num9 = num5;
                        c10 = c11;
                        num2 = num9;
                        C12665d.a.m76245d("HEFileUtils", "convertHEStringToIntArray, skip unknown type:" + c12073e2.f55891a.f55883a);
                    }
                    i25++;
                    c12272aM76227n = c12272a;
                    i15 = i11;
                    str8 = str2;
                    num7 = num;
                    str6 = str3;
                    i16 = 24;
                    char c12 = c10;
                    num5 = num2;
                    c11 = c12;
                }
                Integer num10 = num5;
                c10 = c11;
                num2 = num10;
                i25++;
                c12272aM76227n = c12272a;
                i15 = i11;
                str8 = str2;
                num7 = num;
                str6 = str3;
                i16 = 24;
                char c122 = c10;
                num5 = num2;
                c11 = c122;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (arrayList.size() == 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i30 = 0; i30 < arrayList.size(); i30++) {
            iArr[i30] = ((Integer) arrayList.get(i30)).intValue();
        }
        return iArr;
    }

    /* renamed from: k */
    public static int m76224k(int i10, int i11) {
        if (-1 != i11) {
            if (30 > i11) {
                return 0;
            }
            if (100 >= i11) {
                return i10;
            }
        }
        return 100;
    }

    /* renamed from: l */
    public static int m76225l(int i10, int i11) {
        if (i11 < 41 || i11 > 68) {
            if (i10 <= 0 || i10 >= 50) {
                return (i10 < 50 || i10 > 100) ? 0 : 15;
            }
            return 10;
        }
        if (i10 > 0 && i10 < 50) {
            return 15;
        }
        if (i10 < 50 || i10 >= 75) {
            return (i10 < 75 || i10 > 100) ? 0 : 30;
        }
        return 20;
    }

    /* renamed from: m */
    public static String m76226m(String str, int i10) {
        C12455a c12455aM76229p;
        ArrayList<C12457c> arrayList;
        int iIndexOf;
        int iIndexOf2;
        if (i10 == 0) {
            return str;
        }
        try {
            c12455aM76229p = m76229p(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            c12455aM76229p = null;
        }
        if (c12455aM76229p == null || (arrayList = c12455aM76229p.f57380b) == null || arrayList.size() == 0) {
            C12665d.a.m76245d("HEFileUtils", "  generatePartialHe20String, source HE invalid!");
            return "";
        }
        Iterator<C12457c> it = c12455aM76229p.f57380b.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                iIndexOf = -1;
                iIndexOf2 = -1;
                break;
            }
            C12457c next = it.next();
            ArrayList<C12073e> arrayList2 = next.f57385b;
            if (arrayList2 != null) {
                Iterator<C12073e> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    C12073e next2 = it2.next();
                    C12070b c12070b = next2.f55891a;
                    if (c12070b != null && c12070b.f55884b + next.f57384a >= i10) {
                        iIndexOf = next.f57385b.indexOf(next2);
                        iIndexOf2 = c12455aM76229p.f57380b.indexOf(next);
                        break loop0;
                    }
                }
            }
        }
        if (iIndexOf2 < 0 || iIndexOf < 0) {
            return "";
        }
        c12455aM76229p.f57380b.subList(0, iIndexOf2).clear();
        c12455aM76229p.f57380b.get(0).f57385b.subList(0, iIndexOf).clear();
        C12665d.a.m76242a("HEFileUtils", "  generatePartialHe20String, targetPatternListItemIndex:" + iIndexOf2 + ",targetPatterItemIndex:" + iIndexOf + ", PatternList size:" + c12455aM76229p.f57380b.size() + ",Pattern size:" + c12455aM76229p.f57380b.get(0).f57385b.size());
        Iterator<C12457c> it3 = c12455aM76229p.f57380b.iterator();
        while (it3.hasNext()) {
            C12457c next3 = it3.next();
            ArrayList<C12073e> arrayList3 = next3.f57385b;
            if (arrayList3 != null) {
                int i11 = next3.f57384a;
                if (i11 < i10) {
                    Iterator<C12073e> it4 = arrayList3.iterator();
                    while (it4.hasNext()) {
                        C12070b c12070b2 = it4.next().f55891a;
                        if (c12070b2 != null) {
                            c12070b2.f55884b = (c12070b2.f55884b + next3.f57384a) - i10;
                        }
                    }
                    next3.f57384a = 0;
                } else {
                    next3.f57384a = i11 - i10;
                }
            }
        }
        if (iIndexOf == 0 && c12455aM76229p.f57380b.get(0).f57384a != 0) {
            C12457c c12457c = new C12457c();
            c12457c.f57384a = 0;
            c12457c.f57385b = new ArrayList<>();
            C12070b c12070b3 = new C12070b();
            C12072d c12072d = new C12072d();
            c12070b3.f55887e = c12072d;
            c12072d.f55888a = 0;
            c12072d.f55889b = 0;
            c12070b3.f55883a = "transient";
            C12073e c12073e = new C12073e();
            c12073e.f55891a = c12070b3;
            c12457c.f57385b.add(c12073e);
            c12455aM76229p.f57380b.add(0, c12457c);
        }
        return m76219f(c12455aM76229p);
    }

    /* renamed from: n */
    public static C12272a m76227n(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            C12272a c12272a = new C12272a();
            c12272a.f56910a = new C12273b();
            c12272a.f56911b = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("Pattern");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
                C12073e c12073e = new C12073e();
                c12073e.f55891a = new C12070b();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(Event.TAG);
                c12073e.f55891a.f55883a = jSONObject3.getString(FaqConstants.FAQ_UPLOAD_FLAG);
                if ("continuous".equals(c12073e.f55891a.f55883a)) {
                    c12073e.f55891a.f55885c = jSONObject3.getInt(VastTag.DURATION);
                }
                c12073e.f55891a.f55884b = jSONObject3.getInt("RelativeTime");
                JSONObject jSONObject4 = jSONObject3.getJSONObject("Parameters");
                c12073e.f55891a.f55887e = new C12072d();
                c12073e.f55891a.f55887e.f55889b = jSONObject4.getInt("Frequency");
                c12073e.f55891a.f55887e.f55888a = jSONObject4.getInt("Intensity");
                c12073e.f55891a.f55887e.f55890c = new ArrayList<>();
                if ("continuous".equals(c12073e.f55891a.f55883a)) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray("Curve");
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        JSONObject jSONObject5 = (JSONObject) jSONArray2.get(i11);
                        C12069a c12069a = new C12069a();
                        c12069a.f55882c = jSONObject5.getInt("Frequency");
                        c12069a.f55881b = jSONObject5.getDouble("Intensity");
                        c12069a.f55880a = jSONObject5.getInt("Time");
                        c12073e.f55891a.f55887e.f55890c.add(c12069a);
                    }
                }
                c12272a.f56911b.add(c12073e);
            }
            return c12272a;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* renamed from: o */
    public static int m76228o(String str, int i10) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        InterfaceC12071c interfaceC12071cM76231r = m76231r(str, i10);
        if (C12916d.m77553d(interfaceC12071cM76231r)) {
            return interfaceC12071cM76231r.getDuration();
        }
        return 0;
    }

    /* renamed from: p */
    public static C12455a m76229p(String str) throws JSONException {
        if (2 != m76230q(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C12455a c12455a = new C12455a();
            c12455a.f57379a = new C12456b();
            c12455a.f57380b = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("PatternList");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
                C12457c c12457c = new C12457c();
                c12457c.f57384a = jSONObject2.getInt("AbsoluteTime");
                c12457c.f57385b = new ArrayList<>();
                JSONArray jSONArray2 = jSONObject2.getJSONArray("Pattern");
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray2.get(i11);
                    C12073e c12073e = new C12073e();
                    c12073e.f55891a = new C12070b();
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(Event.TAG);
                    c12073e.f55891a.f55883a = jSONObject4.getString(FaqConstants.FAQ_UPLOAD_FLAG);
                    if ("continuous".equals(c12073e.f55891a.f55883a)) {
                        c12073e.f55891a.f55885c = jSONObject4.getInt(VastTag.DURATION);
                    } else if ("transient".equals(c12073e.f55891a.f55883a)) {
                        c12073e.f55891a.f55885c = 48;
                    }
                    c12073e.f55891a.f55884b = jSONObject4.getInt("RelativeTime");
                    c12073e.f55891a.f55886d = jSONObject4.getInt("Index");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject("Parameters");
                    c12073e.f55891a.f55887e = new C12072d();
                    c12073e.f55891a.f55887e.f55889b = jSONObject5.getInt("Frequency");
                    c12073e.f55891a.f55887e.f55888a = jSONObject5.getInt("Intensity");
                    c12073e.f55891a.f55887e.f55890c = new ArrayList<>();
                    if ("continuous".equals(c12073e.f55891a.f55883a)) {
                        JSONArray jSONArray3 = jSONObject5.getJSONArray("Curve");
                        for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                            JSONObject jSONObject6 = (JSONObject) jSONArray3.get(i12);
                            C12069a c12069a = new C12069a();
                            c12069a.f55882c = jSONObject6.getInt("Frequency");
                            c12069a.f55881b = jSONObject6.getDouble("Intensity");
                            c12069a.f55880a = jSONObject6.getInt("Time");
                            c12073e.f55891a.f55887e.f55890c.add(c12069a);
                        }
                    }
                    c12457c.f57385b.add(c12073e);
                }
                c12455a.f57380b.add(c12457c);
            }
            return c12455a;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* renamed from: q */
    public static int m76230q(String str) {
        try {
            return new JSONObject(str).getJSONObject("Metadata").getInt("Version");
        } catch (Exception e10) {
            C12665d.a.m76243b("HEFileUtils", "getHeVersion ERROR, heString:" + str);
            e10.printStackTrace();
            return 0;
        }
    }

    /* renamed from: r */
    public static InterfaceC12071c m76231r(String str, int i10) {
        C12665d.a.m76242a("HEFileUtils", "getHeRootFromHeString, HE version:" + i10);
        if (i10 == 1) {
            try {
                return m76227n(str);
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
        if (i10 != 2) {
            return null;
        }
        try {
            return m76229p(str);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    /* renamed from: s */
    public static String m76232s(String str) {
        C12455a c12455aM76229p;
        try {
            c12455aM76229p = m76229p(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            c12455aM76229p = null;
        }
        if (!C12916d.m77553d(c12455aM76229p)) {
            C12665d.a.m76245d("HEFileUtils", " , trim16pTo4p, invalid HE2.0 string!");
            return "";
        }
        Iterator<C12457c> it = c12455aM76229p.f57380b.iterator();
        while (it.hasNext()) {
            Iterator<C12073e> it2 = it.next().f57385b.iterator();
            while (it2.hasNext()) {
                C12073e next = it2.next();
                C12072d c12072d = next.f55891a.f55887e;
                c12072d.f55890c = m76221h(c12072d.f55890c);
                if (next.f55891a.f55883a.equals("transient")) {
                    C12072d c12072d2 = next.f55891a.f55887e;
                    int i10 = c12072d2.f55889b;
                    if (i10 < 0) {
                        c12072d2.f55889b = 0;
                    } else if (i10 > 100) {
                        c12072d2.f55889b = 100;
                    }
                }
            }
        }
        return m76219f(c12455aM76229p);
    }

    /* renamed from: t */
    public static String m76233t(String str, int i10) {
        try {
            C12455a c12455aM76229p = m76229p(str);
            for (int i11 = 0; i11 < c12455aM76229p.f57380b.size(); i11++) {
                for (int i12 = 0; i12 < c12455aM76229p.f57380b.get(i11).f57385b.size(); i12++) {
                    if (c12455aM76229p.f57380b.get(i11).f57384a <= i10 && c12455aM76229p.f57380b.get(i11).f57384a + c12455aM76229p.f57380b.get(i11).f57385b.get(i12).f55891a.f55884b >= i10) {
                        C12455a c12455a = new C12455a();
                        c12455a.f57379a = new C12456b();
                        c12455a.f57380b = new ArrayList<>();
                        C12457c c12457c = new C12457c();
                        c12457c.f57384a = 0;
                        ArrayList<C12073e> arrayList = new ArrayList<>();
                        c12457c.f57385b = arrayList;
                        arrayList.addAll(c12455aM76229p.f57380b.get(i11).f57385b.subList(i12, c12455aM76229p.f57380b.get(i11).f57385b.size()));
                        Iterator<C12073e> it = c12457c.f57385b.iterator();
                        while (it.hasNext()) {
                            C12070b c12070b = it.next().f55891a;
                            c12070b.f55884b = (c12070b.f55884b + c12455aM76229p.f57380b.get(i11).f57384a) - i10;
                        }
                        c12455a.f57380b.add(c12457c);
                        return m76219f(c12455a);
                    }
                    if (c12455aM76229p.f57380b.get(i11).f57384a > i10) {
                        C12455a c12455a2 = new C12455a();
                        c12455a2.f57379a = new C12456b();
                        c12455a2.f57380b = new ArrayList<>();
                        C12457c c12457c2 = new C12457c();
                        c12457c2.f57384a = 0;
                        c12457c2.f57385b = new ArrayList<>();
                        C12070b c12070b2 = new C12070b();
                        C12072d c12072d = new C12072d();
                        c12070b2.f55887e = c12072d;
                        c12072d.f55888a = 0;
                        c12072d.f55889b = 0;
                        c12070b2.f55883a = "transient";
                        C12073e c12073e = new C12073e();
                        c12073e.f55891a = c12070b2;
                        c12457c2.f57385b.add(c12073e);
                        c12455a2.f57380b.add(c12457c2);
                        return m76219f(c12455a2);
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    /* renamed from: u */
    public static String m76234u(String str) throws Throwable {
        char c10;
        char c11;
        int i10;
        int i11;
        int i12;
        C12665d.m76239a("trimOverlapEvent_in.he", str);
        C12455a c12455aM76229p = m76229p(str);
        if (!C12916d.m77553d(c12455aM76229p)) {
            return str;
        }
        try {
            Iterator<C12457c> it = c12455aM76229p.f57380b.iterator();
            while (it.hasNext()) {
                C12457c next = it.next();
                ArrayList<C12073e> arrayList = next.f57385b;
                if (arrayList != null) {
                    Iterator<C12073e> it2 = arrayList.iterator();
                    while (true) {
                        c10 = 2;
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (2 == it2.next().f55891a.f55886d) {
                            it2.remove();
                        }
                    }
                    if (1 != next.f57385b.size()) {
                        Collections.sort(next.f57385b, new a());
                        int i13 = 0;
                        int i14 = 0;
                        int i15 = 1;
                        for (int i16 = 1; i14 <= next.f57385b.size() - i16 && i15 <= next.f57385b.size() - i16; i16 = 1) {
                            C12070b c12070b = next.f57385b.get(i14).f55891a;
                            C12070b c12070b2 = next.f57385b.get(i15).f55891a;
                            int i17 = "transient".equals(c12070b.f55883a) ? 48 : c12070b.f55885c;
                            int i18 = "transient".equals(c12070b2.f55883a) ? 48 : c12070b2.f55885c;
                            if (c12070b2.f55884b < c12070b.f55884b + i17) {
                                if (!"continuous".equals(c12070b2.f55883a) || (i10 = c12070b2.f55884b + i18) <= (i11 = c12070b.f55884b + i17) || (i12 = i10 - i11) <= 48) {
                                    c11 = c10;
                                    c12070b2.f55886d = -1;
                                } else {
                                    ArrayList<C12069a> arrayList2 = new ArrayList<>();
                                    C12069a c12069a = new C12069a();
                                    c12069a.f55880a = i13;
                                    c12069a.f55881b = 0.0d;
                                    c12069a.f55882c = i13;
                                    C12069a c12069a2 = new C12069a();
                                    c12069a2.f55880a = i12 / 3;
                                    c12069a2.f55881b = 1.0d;
                                    c12069a2.f55882c = i13;
                                    C12069a c12069a3 = new C12069a();
                                    c11 = 2;
                                    c12069a3.f55880a = (i12 / 3) * 2;
                                    c12069a3.f55881b = 1.0d;
                                    c12069a3.f55882c = 0;
                                    C12069a c12069a4 = new C12069a();
                                    c12069a4.f55880a = i12;
                                    c12069a4.f55881b = 0.0d;
                                    i13 = 0;
                                    c12069a4.f55882c = 0;
                                    arrayList2.add(c12069a);
                                    arrayList2.add(c12069a2);
                                    arrayList2.add(c12069a3);
                                    arrayList2.add(c12069a4);
                                    c12070b2.f55885c = i12;
                                    c12070b2.f55884b = c12070b.f55884b + i17;
                                    c12070b2.f55887e.f55890c = arrayList2;
                                    i14 = i15;
                                }
                                i15++;
                                c10 = c11;
                            } else {
                                i14 = i15;
                                i15++;
                            }
                        }
                        Iterator<C12073e> it3 = next.f57385b.iterator();
                        while (it3.hasNext()) {
                            if (it3.next().f55891a.f55886d < 0) {
                                it3.remove();
                            }
                        }
                    }
                }
            }
            String strM76219f = m76219f(c12455aM76229p);
            C12665d.m76239a("trimOverlapEvent_out.he", strM76219f);
            return strM76219f;
        } catch (Throwable th2) {
            C12665d.a.m76243b("HEFileUtils", "trimOverlapEvent " + th2.toString());
            return str;
        }
    }
}
