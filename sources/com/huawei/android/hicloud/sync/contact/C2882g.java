package com.huawei.android.hicloud.sync.contact;

import android.content.ContentProviderOperation;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.contact.g */
/* loaded from: classes3.dex */
public class C2882g implements Comparable<C2882g> {

    /* renamed from: A */
    public ArrayList<String> f12839A;

    /* renamed from: B */
    public ArrayList<String> f12840B;

    /* renamed from: C */
    public ArrayList<String> f12841C;

    /* renamed from: D */
    public ArrayList<String[]> f12842D;

    /* renamed from: E */
    public String f12843E;

    /* renamed from: F */
    public String f12844F;

    /* renamed from: G */
    public ArrayList<String[]> f12845G;

    /* renamed from: H */
    public ArrayList<String[]> f12846H;

    /* renamed from: I */
    public ArrayList<String[]> f12847I;

    /* renamed from: J */
    public ArrayList<Map<String, String[]>> f12848J;

    /* renamed from: K */
    public String f12849K;

    /* renamed from: L */
    public ArrayList<String> f12850L;

    /* renamed from: M */
    public ArrayList<String> f12851M;

    /* renamed from: N */
    public ArrayList<String> f12852N;

    /* renamed from: O */
    public ArrayList<String> f12853O;

    /* renamed from: P */
    public ArrayList<String> f12854P;

    /* renamed from: Q */
    public ArrayList<String> f12855Q;

    /* renamed from: R */
    public ArrayList<String> f12856R;

    /* renamed from: S */
    public ArrayList<String> f12857S;

    /* renamed from: T */
    public ArrayList<String> f12858T;

    /* renamed from: U */
    public ArrayList<String> f12859U;

    /* renamed from: V */
    public ArrayList<String> f12860V;

    /* renamed from: W */
    public ArrayList<String[]> f12861W;

    /* renamed from: X */
    public String f12862X;

    /* renamed from: Y */
    public String f12863Y;

    /* renamed from: Z */
    public ArrayList<String> f12864Z;

    /* renamed from: a */
    public String f12865a;

    /* renamed from: a0 */
    public ArrayList<String> f12866a0;

    /* renamed from: b */
    public String f12867b;

    /* renamed from: b0 */
    public ArrayList<String[]> f12868b0;

    /* renamed from: c */
    public String f12869c;

    /* renamed from: c0 */
    public byte[] f12870c0;

    /* renamed from: d */
    public String f12871d;

    /* renamed from: d0 */
    public String f12872d0;

    /* renamed from: e */
    public String f12873e;

    /* renamed from: e0 */
    public int f12874e0;

    /* renamed from: f */
    public String f12875f;

    /* renamed from: f0 */
    public boolean f12876f0;

    /* renamed from: g */
    public String f12877g;

    /* renamed from: g0 */
    public boolean f12878g0;

    /* renamed from: h */
    public String f12879h;

    /* renamed from: h0 */
    public boolean f12880h0;

    /* renamed from: i */
    public String f12881i;

    /* renamed from: i0 */
    public ArrayList<String> f12882i0;

    /* renamed from: j */
    public String f12883j;

    /* renamed from: j0 */
    public ArrayList<String> f12884j0;

    /* renamed from: k */
    public String f12885k;

    /* renamed from: k0 */
    public ArrayList<String> f12886k0;

    /* renamed from: l */
    public ArrayList<String> f12887l;

    /* renamed from: l0 */
    public ArrayList<String> f12888l0;

    /* renamed from: m */
    public ArrayList<String> f12889m;

    /* renamed from: m0 */
    public ArrayList<String> f12890m0;

    /* renamed from: n */
    public ArrayList<String> f12891n;

    /* renamed from: n0 */
    public ArrayList<String> f12892n0;

    /* renamed from: o */
    public ArrayList<String> f12893o;

    /* renamed from: o0 */
    public ArrayList<String> f12894o0;

    /* renamed from: p */
    public ArrayList<String> f12895p;

    /* renamed from: p0 */
    public ArrayList<String> f12896p0;

    /* renamed from: q */
    public ArrayList<String[]> f12897q;

    /* renamed from: q0 */
    public ArrayList<String> f12898q0;

    /* renamed from: r */
    public ArrayList<String> f12899r;

    /* renamed from: r0 */
    public ArrayList<String> f12900r0;

    /* renamed from: s */
    public ArrayList<String> f12901s;

    /* renamed from: s0 */
    public ArrayList<String> f12902s0;

    /* renamed from: t */
    public ArrayList<String> f12903t;

    /* renamed from: t0 */
    public ArrayList<String> f12904t0;

    /* renamed from: u */
    public ArrayList<String> f12905u;

    /* renamed from: u0 */
    public ArrayList<String> f12906u0;

    /* renamed from: v */
    public ArrayList<String> f12907v;

    /* renamed from: v0 */
    public ArrayList<String> f12908v0;

    /* renamed from: w */
    public ArrayList<String> f12909w;

    /* renamed from: w0 */
    public ArrayList<String[]> f12910w0;

    /* renamed from: x */
    public ArrayList<String> f12911x;

    /* renamed from: x0 */
    public int f12912x0;

    /* renamed from: y */
    public ArrayList<String> f12913y;

    /* renamed from: y0 */
    public int f12914y0;

    /* renamed from: z */
    public ArrayList<String> f12915z;

    public C2882g() {
        this.f12867b = "";
        this.f12869c = "";
        this.f12871d = "";
        this.f12873e = "";
        this.f12875f = "";
        this.f12877g = "";
        this.f12879h = "";
        this.f12881i = "";
        this.f12883j = "";
        this.f12885k = "";
        this.f12843E = "";
        this.f12844F = "";
        this.f12849K = "";
        this.f12862X = "";
        this.f12863Y = "";
        this.f12876f0 = true;
        this.f12878g0 = false;
        this.f12880h0 = false;
        this.f12912x0 = 0;
        this.f12914y0 = 0;
    }

    /* renamed from: A */
    public ArrayList<String[]> m17384A() {
        return this.f12868b0;
    }

    /* renamed from: A0 */
    public ArrayList<String> m17385A0() {
        return this.f12887l;
    }

    /* renamed from: A1 */
    public void m17386A1(String str) {
        if (this.f12839A == null) {
            this.f12839A = new ArrayList<>();
        }
        this.f12839A.add(str);
    }

    /* renamed from: B */
    public ArrayList<String[]> m17387B() {
        return this.f12861W;
    }

    /* renamed from: B0 */
    public String m17388B0() {
        return this.f12875f;
    }

    /* renamed from: B1 */
    public void m17389B1(String str) {
        if (this.f12909w == null) {
            this.f12909w = new ArrayList<>();
        }
        this.f12909w.add(str);
    }

    /* renamed from: C */
    public ArrayList<String[]> m17390C() {
        return this.f12897q;
    }

    /* renamed from: C0 */
    public ArrayList<String> m17391C0() {
        return this.f12915z;
    }

    /* renamed from: C1 */
    public void m17392C1(String str) {
        if (this.f12903t == null) {
            this.f12903t = new ArrayList<>();
        }
        this.f12903t.add(str);
    }

    /* renamed from: D */
    public ArrayList<String[]> m17393D() {
        return this.f12910w0;
    }

    /* renamed from: D0 */
    public ArrayList<String> m17394D0() {
        return this.f12858T;
    }

    /* renamed from: D1 */
    public void m17395D1(String str) {
        if (this.f12891n == null) {
            this.f12891n = new ArrayList<>();
        }
        this.f12891n.add(str);
    }

    /* renamed from: E */
    public ArrayList<String[]> m17396E() {
        return this.f12842D;
    }

    /* renamed from: E0 */
    public ArrayList<String> m17397E0() {
        return this.f12906u0;
    }

    /* renamed from: E1 */
    public void m17398E1(String str) {
        if (this.f12851M == null) {
            this.f12851M = new ArrayList<>();
        }
        this.f12851M.add(str);
    }

    /* renamed from: F */
    public final void m17399F(ArrayList<ContentProviderOperation> arrayList, int i10, String str, int i11) {
        if (C2983l.m17910g(str)) {
            return;
        }
        arrayList.add(ContentProviderOperation.newInsert(C2879d.f12833a).withValueBackReference("raw_contact_id", i11).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", str).withValue("data2", Integer.valueOf(i10)).build());
    }

    /* renamed from: F0 */
    public ArrayList<String> m17400F0() {
        return this.f12859U;
    }

    /* renamed from: F1 */
    public void m17401F1(String str) {
        if (this.f12854P == null) {
            this.f12854P = new ArrayList<>();
        }
        this.f12854P.add(str);
    }

    /* renamed from: G */
    public ArrayList<String> m17402G() {
        return this.f12904t0;
    }

    /* renamed from: G0 */
    public ArrayList<String> m17403G0() {
        return this.f12908v0;
    }

    /* renamed from: G1 */
    public void m17404G1(String str) {
        if (this.f12902s0 == null) {
            this.f12902s0 = new ArrayList<>();
        }
        this.f12902s0.add(str);
    }

    /* renamed from: H */
    public String m17405H() {
        return this.f12869c;
    }

    /* renamed from: H0 */
    public int m17406H0() {
        return this.f12912x0;
    }

    /* renamed from: H1 */
    public void m17407H1(int i10) {
        this.f12914y0 = i10;
    }

    /* renamed from: I */
    public ArrayList<String> m17408I() {
        return this.f12890m0;
    }

    /* renamed from: I0 */
    public String m17409I0() {
        return this.f12877g;
    }

    /* renamed from: I1 */
    public void m17410I1(String str) {
        if (this.f12855Q == null) {
            this.f12855Q = new ArrayList<>();
        }
        this.f12855Q.add(str);
    }

    /* renamed from: J */
    public ArrayList<String> m17411J() {
        return this.f12907v;
    }

    /* renamed from: J0 */
    public ArrayList<String> m17412J0() {
        return this.f12913y;
    }

    /* renamed from: J1 */
    public void m17413J1(String str) {
        if (this.f12894o0 == null) {
            this.f12894o0 = new ArrayList<>();
        }
        this.f12894o0.add(str);
    }

    /* renamed from: K */
    public ArrayList<String> m17414K() {
        return this.f12892n0;
    }

    /* renamed from: K0 */
    public String m17415K0() {
        return this.f12844F;
    }

    /* renamed from: K1 */
    public void m17416K1(String str) {
        this.f12873e = str;
    }

    /* renamed from: L */
    public String m17417L() {
        return this.f12871d;
    }

    /* renamed from: L0 */
    public String m17418L0() {
        return this.f12872d0;
    }

    /* renamed from: L1 */
    public void m17419L1(String str) {
        if (this.f12901s == null) {
            this.f12901s = new ArrayList<>();
        }
        this.f12901s.add(str);
    }

    /* renamed from: M */
    public ArrayList<String> m17420M() {
        return this.f12860V;
    }

    /* renamed from: M0 */
    public ArrayList<String> m17421M0() {
        return this.f12889m;
    }

    /* renamed from: M1 */
    public void m17422M1(String str) {
        if (this.f12896p0 == null) {
            this.f12896p0 = new ArrayList<>();
        }
        this.f12896p0.add(str);
    }

    /* renamed from: N */
    public final int m17423N(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: N0 */
    public ArrayList<String> m17424N0() {
        return this.f12850L;
    }

    /* renamed from: N1 */
    public void m17425N1(String str) {
        if (this.f12899r == null) {
            this.f12899r = new ArrayList<>();
        }
        this.f12899r.add(str);
    }

    /* renamed from: O */
    public ArrayList<String[]> m17426O() {
        return this.f12845G;
    }

    /* renamed from: O0 */
    public ArrayList<String[]> m17427O0() {
        return this.f12846H;
    }

    /* renamed from: O1 */
    public void m17428O1(String str) {
        if (this.f12856R == null) {
            this.f12856R = new ArrayList<>();
        }
        this.f12856R.add(str);
    }

    /* renamed from: P */
    public ArrayList<String> m17429P() {
        return this.f12839A;
    }

    /* renamed from: P0 */
    public ArrayList<String> m17430P0() {
        return this.f12840B;
    }

    /* renamed from: P1 */
    public void m17431P1(String str) {
        this.f12879h = str;
    }

    /* renamed from: Q */
    public ArrayList<String> m17432Q() {
        return this.f12909w;
    }

    /* renamed from: Q0 */
    public ArrayList<String> m17433Q0() {
        return this.f12911x;
    }

    /* renamed from: Q1 */
    public void m17434Q1(String str) {
        this.f12849K = str;
    }

    /* renamed from: R */
    public ArrayList<String> m17435R() {
        return this.f12903t;
    }

    /* renamed from: R0 */
    public ArrayList<String> m17436R0() {
        return this.f12905u;
    }

    /* renamed from: R1 */
    public void m17437R1(String[] strArr) {
        if (this.f12847I == null) {
            this.f12847I = new ArrayList<>();
        }
        this.f12847I.add(strArr);
    }

    /* renamed from: S */
    public ArrayList<String> m17438S() {
        return this.f12891n;
    }

    /* renamed from: S0 */
    public ArrayList<String> m17439S0() {
        return this.f12893o;
    }

    /* renamed from: S1 */
    public void m17440S1(String str) {
        if (this.f12866a0 == null) {
            this.f12866a0 = new ArrayList<>();
        }
        this.f12866a0.add(str);
    }

    /* renamed from: T */
    public ArrayList<String> m17441T() {
        return this.f12851M;
    }

    /* renamed from: T0 */
    public ArrayList<String> m17442T0() {
        return this.f12895p;
    }

    /* renamed from: T1 */
    public void m17443T1(String str) {
        if (this.f12841C == null) {
            this.f12841C = new ArrayList<>();
        }
        this.f12841C.add(str);
    }

    /* renamed from: U */
    public ArrayList<String> m17444U() {
        return this.f12854P;
    }

    /* renamed from: U0 */
    public ArrayList<String> m17445U0() {
        return this.f12852N;
    }

    /* renamed from: U1 */
    public void m17446U1(String str) {
        if (this.f12898q0 == null) {
            this.f12898q0 = new ArrayList<>();
        }
        this.f12898q0.add(str);
    }

    /* renamed from: V */
    public ArrayList<String> m17447V() {
        return this.f12902s0;
    }

    /* renamed from: V0 */
    public ArrayList<String> m17448V0() {
        return this.f12857S;
    }

    /* renamed from: V1 */
    public void m17449V1(String str) {
        this.f12881i = str;
    }

    /* renamed from: W */
    public int m17450W() {
        return this.f12914y0;
    }

    /* renamed from: W0 */
    public String m17451W0() {
        return this.f12863Y;
    }

    /* renamed from: W1 */
    public void m17452W1(String str) {
        this.f12885k = str;
    }

    /* renamed from: X */
    public ArrayList<String> m17453X() {
        return this.f12855Q;
    }

    /* renamed from: X0 */
    public boolean m17454X0() {
        return this.f12874e0 != 0;
    }

    /* renamed from: X1 */
    public void m17455X1(String str) {
        this.f12883j = str;
    }

    /* renamed from: Y */
    public ArrayList<String> m17456Y() {
        return this.f12894o0;
    }

    /* renamed from: Y0 */
    public boolean m17457Y0() {
        return this.f12880h0;
    }

    /* renamed from: Y1 */
    public void m17458Y1(byte[] bArr) {
        this.f12870c0 = (byte[]) bArr.clone();
    }

    /* renamed from: Z */
    public final String m17459Z(ArrayList<Map<String, String[]>> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<Map<String, String[]>> it = arrayList.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, String[]> entry : it.next().entrySet()) {
                Arrays.sort(entry.getValue());
                sb2.append(Arrays.toString(entry.getValue()));
            }
        }
        return sb2.toString();
    }

    /* renamed from: Z0 */
    public boolean m17460Z0() {
        return this.f12878g0;
    }

    /* renamed from: Z1 */
    public void m17461Z1(String str) {
        if (this.f12887l == null) {
            this.f12887l = new ArrayList<>();
        }
        this.f12887l.add(str);
    }

    /* renamed from: a */
    public final void m17462a(ArrayList<String> arrayList, int i10, ArrayList<ContentProviderOperation> arrayList2, int i11) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            m17399F(arrayList2, i10, it.next(), i11);
        }
    }

    /* renamed from: a1 */
    public void m17463a1(String str) {
        if (this.f12853O == null) {
            this.f12853O = new ArrayList<>();
        }
        this.f12853O.add(str);
    }

    /* renamed from: a2 */
    public void m17464a2(String str) {
        this.f12875f = str;
    }

    /* renamed from: b */
    public void m17465b(ArrayList<ContentProviderOperation> arrayList, int i10) {
        m17462a(this.f12839A, 1, arrayList, i10);
    }

    /* renamed from: b1 */
    public void m17466b1(String str) {
        if (this.f12864Z == null) {
            this.f12864Z = new ArrayList<>();
        }
        this.f12864Z.add(str);
    }

    /* renamed from: b2 */
    public void m17467b2(String str) {
        if (this.f12915z == null) {
            this.f12915z = new ArrayList<>();
        }
        this.f12915z.add(str);
    }

    /* renamed from: c1 */
    public void m17468c1(String str) {
        if (this.f12882i0 == null) {
            this.f12882i0 = new ArrayList<>();
        }
        this.f12882i0.add(str);
    }

    /* renamed from: c2 */
    public void m17469c2(String str) {
        if (this.f12858T == null) {
            this.f12858T = new ArrayList<>();
        }
        this.f12858T.add(str);
    }

    /* renamed from: d1 */
    public void m17470d1(String str) {
        this.f12862X = str;
    }

    /* renamed from: d2 */
    public void m17471d2(String str) {
        if (this.f12906u0 == null) {
            this.f12906u0 = new ArrayList<>();
        }
        this.f12906u0.add(str);
    }

    /* renamed from: e */
    public void m17472e(ArrayList<ContentProviderOperation> arrayList, int i10) {
        m17462a(this.f12841C, 3, arrayList, i10);
    }

    /* renamed from: e1 */
    public void m17473e1(String str) {
        if (this.f12884j0 == null) {
            this.f12884j0 = new ArrayList<>();
        }
        this.f12884j0.add(str);
    }

    /* renamed from: e2 */
    public void m17474e2(String str) {
        if (this.f12859U == null) {
            this.f12859U = new ArrayList<>();
        }
        this.f12859U.add(str);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C2882g) && compareTo((C2882g) obj) == 0;
    }

    /* renamed from: f */
    public void m17475f(ArrayList<ContentProviderOperation> arrayList, int i10) {
        m17462a(this.f12915z, 3, arrayList, i10);
    }

    /* renamed from: f1 */
    public void m17476f1(String str) {
        if (this.f12886k0 == null) {
            this.f12886k0 = new ArrayList<>();
        }
        this.f12886k0.add(str);
    }

    /* renamed from: f2 */
    public void m17477f2(String str) {
        if (this.f12908v0 == null) {
            this.f12908v0 = new ArrayList<>();
        }
        this.f12908v0.add(str);
    }

    /* renamed from: g1 */
    public void m17478g1(String str) {
        if (this.f12888l0 == null) {
            this.f12888l0 = new ArrayList<>();
        }
        this.f12888l0.add(str);
    }

    /* renamed from: g2 */
    public void m17479g2(int i10) {
        this.f12912x0 = i10;
    }

    /* renamed from: h */
    public void m17480h(ArrayList<ContentProviderOperation> arrayList, int i10) {
        m17462a(this.f12840B, 2, arrayList, i10);
    }

    /* renamed from: h1 */
    public void m17481h1(String str) {
        if (this.f12900r0 == null) {
            this.f12900r0 = new ArrayList<>();
        }
        this.f12900r0.add(str);
    }

    /* renamed from: h2 */
    public void m17482h2(String str) {
        this.f12877g = str;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((m17423N(this.f12853O) + 31) * 31) + m17423N(this.f12864Z)) * 31) + m17423N(this.f12882i0)) * 31) + m17423N(this.f12863Y)) * 31) + m17423N(this.f12862X)) * 31) + m17423N(this.f12884j0)) * 31) + m17423N(this.f12886k0)) * 31) + m17423N(this.f12888l0)) * 31) + m17423N(this.f12900r0)) * 31) + m17423N(this.f12843E)) * 31) + m17423N(this.f12848J)) * 31) + m17423N(this.f12868b0)) * 31) + m17423N(this.f12861W)) * 31) + m17423N(this.f12897q)) * 31) + m17423N(this.f12910w0)) * 31) + m17423N(this.f12842D)) * 31) + m17423N(this.f12867b)) * 31) + m17423N(this.f12904t0)) * 31) + m17423N(this.f12869c)) * 31) + m17423N(this.f12890m0)) * 31) + m17423N(this.f12907v)) * 31) + (this.f12880h0 ? 1231 : 1237)) * 31) + (this.f12878g0 ? 1231 : 1237)) * 31) + m17423N(this.f12892n0)) * 31) + m17423N(this.f12871d)) * 31) + m17423N(this.f12860V)) * 31) + m17423N(this.f12845G)) * 31) + m17423N(this.f12839A)) * 31) + m17423N(this.f12909w)) * 31) + m17423N(this.f12903t)) * 31) + m17423N(this.f12891n)) * 31) + m17423N(this.f12851M)) * 31) + m17423N(this.f12854P)) * 31) + m17423N(this.f12865a)) * 31) + m17423N(this.f12902s0)) * 31) + (this.f12876f0 ? 1231 : 1237)) * 31) + this.f12914y0) * 31) + m17423N(this.f12855Q)) * 31) + m17423N(this.f12894o0)) * 31) + m17423N(this.f12873e)) * 31) + m17423N(this.f12899r)) * 31) + m17423N(this.f12901s)) * 31) + m17423N(this.f12896p0)) * 31) + m17423N(this.f12856R)) * 31) + m17423N(this.f12879h)) * 31) + m17423N(this.f12849K)) * 31) + m17423N(this.f12847I)) * 31) + m17423N(this.f12866a0)) * 31) + m17423N(this.f12841C)) * 31) + m17423N(this.f12898q0)) * 31) + m17423N(this.f12881i)) * 31) + m17423N(this.f12885k)) * 31) + m17423N(this.f12883j)) * 31) + m17423N(this.f12887l)) * 31) + m17423N(this.f12875f)) * 31) + m17423N(this.f12915z)) * 31) + m17423N(this.f12858T)) * 31) + m17423N(this.f12906u0)) * 31) + m17423N(this.f12859U)) * 31) + m17423N(this.f12908v0)) * 31) + this.f12912x0) * 31) + m17423N(this.f12877g)) * 31) + m17423N(this.f12913y)) * 31) + m17423N(this.f12844F)) * 31) + m17423N(this.f12889m)) * 31) + m17423N(this.f12850L)) * 31) + m17423N(this.f12846H)) * 31) + m17423N(this.f12840B)) * 31) + m17423N(this.f12911x)) * 31) + m17423N(this.f12905u)) * 31) + m17423N(this.f12893o)) * 31) + m17423N(this.f12895p)) * 31) + m17423N(this.f12852N)) * 31) + m17423N(this.f12857S);
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(C2882g c2882g) {
        int iCompareTo = (this.f12869c + this.f12871d + this.f12873e + this.f12875f + this.f12877g).trim().compareTo((c2882g.f12869c + c2882g.f12871d + c2882g.f12873e + c2882g.f12875f + c2882g.f12877g).trim());
        if (iCompareTo == 0) {
            iCompareTo = this.f12879h.trim().compareTo(c2882g.f12879h.trim());
        }
        if (iCompareTo == 0) {
            iCompareTo = C2983l.m17904a(m17511r(this.f12901s) + m17511r(this.f12891n) + m17511r(this.f12889m) + m17511r(this.f12893o) + m17511r(this.f12903t) + m17511r(this.f12887l) + m17511r(this.f12895p) + m17507q(this.f12897q) + m17511r(this.f12899r) + m17511r(this.f12903t) + m17511r(this.f12905u)).compareTo(C2983l.m17904a(m17511r(c2882g.f12901s) + m17511r(c2882g.f12891n) + m17511r(c2882g.f12889m) + m17511r(c2882g.f12893o) + m17511r(c2882g.f12903t) + m17511r(c2882g.f12887l) + m17511r(c2882g.f12895p) + m17507q(c2882g.f12897q) + m17511r(c2882g.f12899r) + m17511r(c2882g.f12903t) + m17511r(c2882g.f12905u)));
        }
        if (iCompareTo == 0) {
            iCompareTo = (m17511r(this.f12907v) + m17511r(this.f12909w) + m17511r(this.f12911x) + m17511r(this.f12913y)).compareTo(m17511r(c2882g.f12907v) + m17511r(c2882g.f12909w) + m17511r(c2882g.f12911x) + m17511r(c2882g.f12913y));
        }
        if (iCompareTo == 0) {
            iCompareTo = (m17511r(this.f12915z) + m17511r(this.f12839A) + m17511r(this.f12840B) + m17511r(this.f12841C) + m17507q(this.f12868b0)).compareTo(m17511r(c2882g.f12915z) + m17511r(c2882g.f12839A) + m17511r(c2882g.f12840B) + m17511r(c2882g.f12841C) + m17507q(c2882g.f12868b0));
        }
        if (iCompareTo == 0) {
            iCompareTo = (m17507q(this.f12845G) + m17507q(this.f12846H) + m17507q(this.f12847I) + m17459Z(this.f12848J)).compareTo(m17507q(c2882g.f12845G) + m17507q(c2882g.f12846H) + m17507q(c2882g.f12847I) + m17459Z(c2882g.f12848J));
        }
        if (iCompareTo == 0) {
            iCompareTo = (m17511r(this.f12850L) + m17511r(this.f12851M) + m17511r(this.f12852N)).compareTo(m17511r(c2882g.f12850L) + m17511r(c2882g.f12851M) + m17511r(c2882g.f12852N));
        }
        if (iCompareTo == 0) {
            iCompareTo = (m17511r(this.f12853O) + m17511r(this.f12854P) + m17511r(this.f12855Q) + m17511r(this.f12856R) + m17511r(this.f12857S) + m17511r(this.f12858T) + m17511r(this.f12859U) + m17511r(this.f12860V) + m17507q(this.f12861W)).compareTo(m17511r(c2882g.f12853O) + m17511r(c2882g.f12854P) + m17511r(c2882g.f12855Q) + m17511r(c2882g.f12856R) + m17511r(c2882g.f12857S) + m17511r(c2882g.f12858T) + m17511r(c2882g.f12859U) + m17511r(c2882g.f12860V) + m17507q(c2882g.f12861W));
        }
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        return (this.f12881i + this.f12885k + this.f12883j + this.f12843E + this.f12844F + this.f12849K + this.f12862X + this.f12863Y).compareTo(c2882g.f12881i + c2882g.f12885k + c2882g.f12883j + c2882g.f12843E + c2882g.f12844F + c2882g.f12849K + c2882g.f12862X + c2882g.f12863Y);
    }

    /* renamed from: i0 */
    public String m17484i0() {
        return this.f12873e;
    }

    /* renamed from: i1 */
    public void m17485i1(String str) {
        this.f12843E = str;
    }

    /* renamed from: i2 */
    public void m17486i2(String str) {
        if (this.f12913y == null) {
            this.f12913y = new ArrayList<>();
        }
        this.f12913y.add(str);
    }

    /* renamed from: j0 */
    public ArrayList<String> m17487j0() {
        return this.f12901s;
    }

    /* renamed from: j1 */
    public void m17488j1(String str, String[] strArr) {
        if (this.f12848J == null) {
            this.f12848J = new ArrayList<>();
        }
        HashMap map = new HashMap();
        map.put(str, strArr);
        this.f12848J.add(map);
    }

    /* renamed from: j2 */
    public void m17489j2(String str) {
        this.f12844F = str;
    }

    /* renamed from: k */
    public ArrayList<String> m17490k() {
        return this.f12853O;
    }

    /* renamed from: k1 */
    public void m17491k1(String str, String str2) {
        if (this.f12868b0 == null) {
            this.f12868b0 = new ArrayList<>();
        }
        this.f12868b0.add(new String[]{str, str2});
    }

    /* renamed from: k2 */
    public void m17492k2(String str) {
        this.f12872d0 = str;
    }

    /* renamed from: l1 */
    public void m17493l1(String str, String str2) {
        if (this.f12861W == null) {
            this.f12861W = new ArrayList<>();
        }
        this.f12861W.add(new String[]{str, str2});
    }

    /* renamed from: l2 */
    public void m17494l2(String str) {
        if (this.f12889m == null) {
            this.f12889m = new ArrayList<>();
        }
        this.f12889m.add(str);
    }

    /* renamed from: m0 */
    public ArrayList<String> m17495m0() {
        return this.f12896p0;
    }

    /* renamed from: m1 */
    public void m17496m1(String str, String str2) {
        if (this.f12897q == null) {
            this.f12897q = new ArrayList<>();
        }
        this.f12897q.add(new String[]{str, str2});
    }

    /* renamed from: m2 */
    public void m17497m2(String str) {
        if (this.f12850L == null) {
            this.f12850L = new ArrayList<>();
        }
        this.f12850L.add(str);
    }

    /* renamed from: n0 */
    public ArrayList<String> m17498n0() {
        return this.f12899r;
    }

    /* renamed from: n1 */
    public void m17499n1(String str, String str2) {
        if (this.f12910w0 == null) {
            this.f12910w0 = new ArrayList<>();
        }
        this.f12910w0.add(new String[]{str, str2});
    }

    /* renamed from: n2 */
    public void m17500n2(String[] strArr) {
        if (this.f12846H == null) {
            this.f12846H = new ArrayList<>();
        }
        this.f12846H.add(strArr);
    }

    /* renamed from: o1 */
    public void m17501o1(String str, String str2) {
        if (this.f12842D == null) {
            this.f12842D = new ArrayList<>();
        }
        this.f12842D.add(new String[]{str, str2});
    }

    /* renamed from: o2 */
    public void m17502o2(String str) {
        if (this.f12840B == null) {
            this.f12840B = new ArrayList<>();
        }
        this.f12840B.add(str);
    }

    /* renamed from: p */
    public ArrayList<String> m17503p() {
        return this.f12864Z;
    }

    /* renamed from: p0 */
    public ArrayList<String> m17504p0() {
        return this.f12856R;
    }

    /* renamed from: p1 */
    public void m17505p1(boolean z10) {
        this.f12876f0 = z10;
    }

    /* renamed from: p2 */
    public void m17506p2(String str) {
        if (this.f12911x == null) {
            this.f12911x = new ArrayList<>();
        }
        this.f12911x.add(str);
    }

    /* renamed from: q */
    public final String m17507q(ArrayList<String[]> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String[]> it = arrayList.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            Arrays.sort(next);
            sb2.append(Arrays.toString(next));
        }
        return sb2.toString();
    }

    /* renamed from: q0 */
    public String m17508q0() {
        return this.f12879h;
    }

    /* renamed from: q1 */
    public void m17509q1(String str) {
        if (this.f12904t0 == null) {
            this.f12904t0 = new ArrayList<>();
        }
        this.f12904t0.add(str);
    }

    /* renamed from: q2 */
    public void m17510q2(String str) {
        if (this.f12905u == null) {
            this.f12905u = new ArrayList<>();
        }
        this.f12905u.add(str);
    }

    /* renamed from: r */
    public final String m17511r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        Collections.sort(arrayList);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
        }
        return sb2.toString();
    }

    /* renamed from: r0 */
    public String m17512r0() {
        return this.f12849K;
    }

    /* renamed from: r1 */
    public void m17513r1(String str) {
        this.f12869c = str;
    }

    /* renamed from: r2 */
    public void m17514r2(String str) {
        if (this.f12893o == null) {
            this.f12893o = new ArrayList<>();
        }
        this.f12893o.add(str);
    }

    /* renamed from: s */
    public ArrayList<String> m17515s() {
        return this.f12882i0;
    }

    /* renamed from: s0 */
    public ArrayList<String[]> m17516s0() {
        return this.f12847I;
    }

    /* renamed from: s1 */
    public void m17517s1(String str) {
        if (this.f12890m0 == null) {
            this.f12890m0 = new ArrayList<>();
        }
        this.f12890m0.add(str);
    }

    /* renamed from: s2 */
    public void m17518s2(String str) {
        if (this.f12895p == null) {
            this.f12895p = new ArrayList<>();
        }
        this.f12895p.add(str);
    }

    /* renamed from: t */
    public String m17519t() {
        return this.f12862X;
    }

    /* renamed from: t0 */
    public ArrayList<String> m17520t0() {
        return this.f12866a0;
    }

    /* renamed from: t1 */
    public void m17521t1(String str) {
        if (this.f12907v == null) {
            this.f12907v = new ArrayList<>();
        }
        this.f12907v.add(str);
    }

    /* renamed from: t2 */
    public void m17522t2(String str) {
        if (this.f12852N == null) {
            this.f12852N = new ArrayList<>();
        }
        this.f12852N.add(str);
    }

    /* renamed from: u */
    public ArrayList<String> m17523u() {
        return this.f12884j0;
    }

    /* renamed from: u0 */
    public ArrayList<String> m17524u0() {
        return this.f12841C;
    }

    /* renamed from: u1 */
    public void m17525u1(boolean z10) {
        this.f12880h0 = z10;
    }

    /* renamed from: u2 */
    public void m17526u2(String str) {
        if (this.f12857S == null) {
            this.f12857S = new ArrayList<>();
        }
        this.f12857S.add(str);
    }

    /* renamed from: v */
    public ArrayList<String> m17527v() {
        return this.f12886k0;
    }

    /* renamed from: v0 */
    public ArrayList<String> m17528v0() {
        return this.f12898q0;
    }

    /* renamed from: v1 */
    public void m17529v1(boolean z10) {
        this.f12878g0 = z10;
    }

    /* renamed from: v2 */
    public void m17530v2(String str) {
        this.f12863Y = str;
    }

    /* renamed from: w */
    public ArrayList<String> m17531w() {
        return this.f12888l0;
    }

    /* renamed from: w0 */
    public String m17532w0() {
        return this.f12881i;
    }

    /* renamed from: w1 */
    public void m17533w1(String str) {
        if (this.f12892n0 == null) {
            this.f12892n0 = new ArrayList<>();
        }
        this.f12892n0.add(str);
    }

    /* renamed from: x */
    public ArrayList<String> m17534x() {
        return this.f12900r0;
    }

    /* renamed from: x0 */
    public String m17535x0() {
        return this.f12885k;
    }

    /* renamed from: x1 */
    public void m17536x1(String str) {
        this.f12871d = str;
    }

    /* renamed from: y */
    public String m17537y() {
        return this.f12843E;
    }

    /* renamed from: y0 */
    public String m17538y0() {
        return this.f12883j;
    }

    /* renamed from: y1 */
    public void m17539y1(String str) {
        if (this.f12860V == null) {
            this.f12860V = new ArrayList<>();
        }
        this.f12860V.add(str);
    }

    /* renamed from: z */
    public ArrayList<Map<String, String[]>> m17540z() {
        return this.f12848J;
    }

    /* renamed from: z0 */
    public byte[] m17541z0() {
        byte[] bArr = this.f12870c0;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        C11839m.m70689w("ContactFields", "photo is null");
        return new byte[0];
    }

    /* renamed from: z1 */
    public void m17542z1(String[] strArr) {
        if (this.f12845G == null) {
            this.f12845G = new ArrayList<>();
        }
        this.f12845G.add(strArr);
    }

    public C2882g(String str, String str2, String str3, int i10) {
        this.f12869c = "";
        this.f12871d = "";
        this.f12873e = "";
        this.f12875f = "";
        this.f12877g = "";
        this.f12879h = "";
        this.f12881i = "";
        this.f12883j = "";
        this.f12885k = "";
        this.f12843E = "";
        this.f12844F = "";
        this.f12849K = "";
        this.f12862X = "";
        this.f12863Y = "";
        this.f12876f0 = true;
        this.f12878g0 = false;
        this.f12880h0 = false;
        this.f12912x0 = 0;
        this.f12914y0 = 0;
        this.f12865a = str;
        this.f12867b = str2;
        this.f12872d0 = str3;
        this.f12874e0 = i10;
    }

    public C2882g(String str, String str2, String str3, int i10, int i11) {
        this.f12869c = "";
        this.f12871d = "";
        this.f12873e = "";
        this.f12875f = "";
        this.f12877g = "";
        this.f12879h = "";
        this.f12881i = "";
        this.f12883j = "";
        this.f12885k = "";
        this.f12843E = "";
        this.f12844F = "";
        this.f12849K = "";
        this.f12862X = "";
        this.f12863Y = "";
        this.f12876f0 = true;
        this.f12878g0 = false;
        this.f12880h0 = false;
        this.f12865a = str;
        this.f12867b = str2;
        this.f12872d0 = str3;
        this.f12912x0 = i10;
        this.f12914y0 = i11;
    }
}
