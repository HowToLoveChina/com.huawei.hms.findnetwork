package com.huawei.hicloud.cloudbackup.store.database.status;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus;

/* loaded from: classes6.dex */
public class CloudBackupStatus extends BackupStatus {

    /* renamed from: B */
    public int f22346B;

    /* renamed from: C */
    public int f22347C;

    /* renamed from: D */
    public int f22348D;

    /* renamed from: E */
    public int f22349E;

    /* renamed from: F */
    public long f22350F;

    /* renamed from: G */
    public long f22351G;

    /* renamed from: H */
    public long f22352H;

    /* renamed from: I */
    public long f22353I;

    /* renamed from: J */
    public String f22354J;

    /* renamed from: K */
    public int f22355K;

    /* renamed from: L */
    public int f22356L;

    /* renamed from: Y */
    public int f22369Y;

    /* renamed from: z */
    public String f22376z = "";

    /* renamed from: A */
    public String f22345A = "";

    /* renamed from: M */
    public String f22357M = "";

    /* renamed from: N */
    public String f22358N = "";

    /* renamed from: O */
    public String f22359O = "";

    /* renamed from: P */
    public String f22360P = "";

    /* renamed from: Q */
    public String f22361Q = "";

    /* renamed from: R */
    public String f22362R = "";

    /* renamed from: S */
    public String f22363S = "";

    /* renamed from: T */
    public String f22364T = "";

    /* renamed from: U */
    public String f22365U = "";

    /* renamed from: V */
    public String f22366V = "";

    /* renamed from: W */
    public String f22367W = "";

    /* renamed from: X */
    public String f22368X = "";

    /* renamed from: Z */
    public String f22370Z = "";

    /* renamed from: a0 */
    public String f22371a0 = "";

    /* renamed from: b0 */
    public String f22372b0 = "";

    /* renamed from: c0 */
    public String f22373c0 = "";

    /* renamed from: d0 */
    public String f22374d0 = "";

    /* renamed from: e0 */
    public String f22375e0 = "";

    /* renamed from: A1 */
    public CloudBackupStatus m29339A1(boolean z10) {
        return m29454z1(z10 ? 1 : 0);
    }

    /* renamed from: B1 */
    public CloudBackupStatus m29341B1(int i10) {
        this.f22349E = i10;
        return this;
    }

    /* renamed from: C1 */
    public CloudBackupStatus m29342C1(long j10) {
        this.f22353I = j10;
        return this;
    }

    /* renamed from: D0 */
    public void m29343D0() {
        mo29416l0(1L);
        mo29424o0(1L);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29321d0(long j10) {
        return (CloudBackupStatus) super.mo29321d0(j10);
    }

    /* renamed from: E0 */
    public String m29345E0() {
        String str = this.f22362R;
        return str == null ? "" : str;
    }

    /* renamed from: E1 */
    public CloudBackupStatus m29346E1(String str) {
        this.f22363S = str;
        return this;
    }

    /* renamed from: F0 */
    public String m29347F0() {
        return TextUtils.isEmpty(this.f22357M) ? "" : this.f22357M;
    }

    /* renamed from: F1 */
    public CloudBackupStatus m29348F1(String str) {
        this.f22373c0 = str;
        return this;
    }

    /* renamed from: G0 */
    public String m29349G0() {
        return TextUtils.isEmpty(this.f22376z) ? "v1" : this.f22376z;
    }

    /* renamed from: G1 */
    public CloudBackupStatus m29350G1(String str) {
        this.f22374d0 = str;
        return this;
    }

    /* renamed from: H0 */
    public int m29351H0() {
        return this.f22347C;
    }

    /* renamed from: H1 */
    public CloudBackupStatus m29352H1(String str) {
        this.f22375e0 = str;
        return this;
    }

    /* renamed from: I0 */
    public int m29353I0() {
        return this.f22346B;
    }

    /* renamed from: I1 */
    public CloudBackupStatus m29354I1(String str) {
        this.f22364T = str;
        return this;
    }

    /* renamed from: J0 */
    public int m29355J0() {
        return this.f22349E;
    }

    /* renamed from: J1 */
    public CloudBackupStatus m29356J1(String str) {
        this.f22365U = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: K */
    public String mo29357K() {
        if (TextUtils.isEmpty(this.f22361Q)) {
            return "0";
        }
        String str = this.f22361Q;
        return str == null ? "" : str;
    }

    /* renamed from: K0 */
    public long m29358K0() {
        return this.f22353I;
    }

    /* renamed from: K1 */
    public CloudBackupStatus m29359K1(String str) {
        this.f22366V = str;
        return this;
    }

    /* renamed from: L0 */
    public String m29360L0() {
        return TextUtils.isEmpty(this.f22363S) ? "" : this.f22363S;
    }

    /* renamed from: L1 */
    public CloudBackupStatus m29361L1(String str) {
        this.f22367W = str;
        return this;
    }

    /* renamed from: M0 */
    public String m29362M0() {
        return TextUtils.isEmpty(this.f22373c0) ? "" : this.f22373c0;
    }

    /* renamed from: M1 */
    public CloudBackupStatus m29363M1(String str) {
        this.f22368X = str;
        return this;
    }

    /* renamed from: N0 */
    public String m29364N0() {
        return TextUtils.isEmpty(this.f22374d0) ? "" : this.f22374d0;
    }

    /* renamed from: N1 */
    public CloudBackupStatus m29365N1(String str) {
        this.f22370Z = str;
        return this;
    }

    /* renamed from: O0 */
    public String m29366O0() {
        return TextUtils.isEmpty(this.f22375e0) ? "" : this.f22375e0;
    }

    /* renamed from: O1 */
    public CloudBackupStatus m29367O1(String str) {
        this.f22371a0 = str;
        return this;
    }

    /* renamed from: P0 */
    public String m29368P0() {
        return TextUtils.isEmpty(this.f22364T) ? "" : this.f22364T;
    }

    /* renamed from: P1 */
    public CloudBackupStatus m29369P1(String str) {
        this.f22372b0 = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: Q */
    public boolean mo29370Q() {
        return (m29872f() == 0 || m29872f() == 2 || !SplitAppUtil.isSplitApp(mo29357K())) ? false : true;
    }

    /* renamed from: Q0 */
    public String m29371Q0() {
        return TextUtils.isEmpty(this.f22365U) ? "" : this.f22365U;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29323e0(long j10) {
        return (CloudBackupStatus) super.mo29323e0(j10);
    }

    /* renamed from: R0 */
    public String m29373R0() {
        return TextUtils.isEmpty(this.f22366V) ? "" : this.f22366V;
    }

    /* renamed from: R1 */
    public CloudBackupStatus m29374R1(long j10) {
        this.f22352H = j10;
        return this;
    }

    /* renamed from: S0 */
    public String m29375S0() {
        return TextUtils.isEmpty(this.f22367W) ? "" : this.f22367W;
    }

    /* renamed from: S1 */
    public CloudBackupStatus m29376S1(String str) {
        this.f22358N = str;
        return this;
    }

    /* renamed from: T0 */
    public String m29377T0() {
        return TextUtils.isEmpty(this.f22368X) ? "" : this.f22368X;
    }

    /* renamed from: T1 */
    public CloudBackupStatus m29378T1(int i10) {
        this.f22348D = i10;
        return this;
    }

    /* renamed from: U0 */
    public String m29379U0() {
        return TextUtils.isEmpty(this.f22370Z) ? "" : this.f22370Z;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29325f0(int i10) {
        return (CloudBackupStatus) super.mo29325f0(i10);
    }

    /* renamed from: V0 */
    public String m29381V0() {
        return TextUtils.isEmpty(this.f22371a0) ? "" : this.f22371a0;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: V1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29327g0(int i10) {
        return (CloudBackupStatus) super.mo29327g0(i10);
    }

    /* renamed from: W0 */
    public String m29383W0() {
        return TextUtils.isEmpty(this.f22372b0) ? "" : this.f22372b0;
    }

    /* renamed from: W1 */
    public void m29384W1(boolean z10) {
        m29348F1(z10 ? "1" : "0");
    }

    /* renamed from: X0 */
    public long m29385X0() {
        return this.f22352H;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29406h0(int i10) {
        return (CloudBackupStatus) super.mo29406h0(i10);
    }

    /* renamed from: Y0 */
    public String m29387Y0() {
        return TextUtils.isEmpty(this.f22358N) ? "" : this.f22358N;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29413k0(String str) {
        this.f22360P = str;
        return this;
    }

    /* renamed from: Z0 */
    public int m29389Z0() {
        return this.f22348D;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29416l0(long j10) {
        return (CloudBackupStatus) super.mo29416l0(j10);
    }

    /* renamed from: a1 */
    public int m29391a1() {
        return this.f22369Y;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: a2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29424o0(long j10) {
        return (CloudBackupStatus) super.mo29424o0(j10);
    }

    /* renamed from: b1 */
    public String m29393b1() {
        return TextUtils.isEmpty(this.f22359O) ? "" : this.f22359O;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: b2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29427p0(long j10) {
        return (CloudBackupStatus) super.mo29427p0(j10);
    }

    /* renamed from: c1 */
    public int m29396c1() {
        return this.f22355K;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: c2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29434s0(long j10) {
        return (CloudBackupStatus) super.mo29434s0(j10);
    }

    /* renamed from: d1 */
    public String m29398d1() {
        return TextUtils.isEmpty(this.f22354J) ? "" : this.f22354J;
    }

    /* renamed from: d2 */
    public CloudBackupStatus m29399d2(int i10) {
        this.f22369Y = i10;
        return this;
    }

    /* renamed from: e1 */
    public int m29400e1() {
        return this.f22356L;
    }

    /* renamed from: e2 */
    public CloudBackupStatus m29401e2(String str) {
        this.f22359O = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f1 */
    public long m29402f1() {
        return this.f22351G;
    }

    /* renamed from: f2 */
    public CloudBackupStatus m29403f2(int i10) {
        this.f22355K = i10;
        return this;
    }

    /* renamed from: g1 */
    public long m29404g1() {
        return this.f22350F;
    }

    /* renamed from: g2 */
    public CloudBackupStatus m29405g2(String str) {
        this.f22354J = str;
        return this;
    }

    /* renamed from: h1 */
    public String m29407h1() {
        return TextUtils.isEmpty(this.f22345A) ? "1" : this.f22345A;
    }

    /* renamed from: h2 */
    public CloudBackupStatus m29408h2(int i10) {
        this.f22356L = i10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i1 */
    public boolean m29409i1() {
        return m29425o1() && m29419m1() && m29875i() == 0;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: i2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29437t0(long j10) {
        return (CloudBackupStatus) super.mo29437t0(j10);
    }

    /* renamed from: j1 */
    public boolean m29411j1() {
        return !m29425o1() && m29419m1();
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: j2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29440u0(long j10) {
        return (CloudBackupStatus) super.mo29440u0(j10);
    }

    /* renamed from: k1 */
    public boolean m29414k1() {
        return 1 == m29355J0();
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: k2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29443v0(long j10) {
        return (CloudBackupStatus) super.mo29443v0(j10);
    }

    /* renamed from: l1 */
    public boolean m29417l1() {
        return TextUtils.equals(this.f22373c0, "1");
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: l2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29446w0(long j10) {
        return (CloudBackupStatus) super.mo29446w0(j10);
    }

    /* renamed from: m1 */
    public boolean m29419m1() {
        return this.f22347C == 1;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29449x0(int i10) {
        return (CloudBackupStatus) super.mo29449x0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: n */
    public String mo29421n() {
        if (!mo29370Q()) {
            return m29870d();
        }
        String str = this.f22360P;
        return str == null ? "" : str;
    }

    /* renamed from: n1 */
    public boolean m29422n1() {
        if ("music".equals(m29870d())) {
            return false;
        }
        return m29867U() || m29863P();
    }

    /* renamed from: n2 */
    public CloudBackupStatus m29423n2(long j10) {
        this.f22351G = j10;
        return this;
    }

    /* renamed from: o1 */
    public boolean m29425o1() {
        return this.f22346B == 1;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: o2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29452y0(String str) {
        this.f22361Q = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29308V(long j10) {
        return (CloudBackupStatus) super.mo29308V(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: p2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29338z0(int i10) {
        return (CloudBackupStatus) super.mo29338z0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29310W(int i10) {
        return (CloudBackupStatus) super.mo29310W(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: q2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29289A0(int i10) {
        return (CloudBackupStatus) super.mo29289A0(i10);
    }

    /* renamed from: r1 */
    public CloudBackupStatus m29432r1(String str) {
        this.f22362R = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29340B0(int i10) {
        return (CloudBackupStatus) super.mo29340B0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29313Y(String str) {
        return (CloudBackupStatus) super.mo29313Y(str);
    }

    /* renamed from: s2 */
    public CloudBackupStatus m29436s2(long j10) {
        this.f22350F = j10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29316a0(String str) {
        return (CloudBackupStatus) super.mo29316a0(str);
    }

    /* renamed from: t2 */
    public CloudBackupStatus m29439t2(String str) {
        this.f22345A = str;
        return this;
    }

    /* renamed from: u1 */
    public CloudBackupStatus m29441u1(String str) {
        this.f22357M = str;
        return this;
    }

    /* renamed from: u2 */
    public void m29442u2() {
        mo29427p0(1L);
        mo29434s0(1L);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29318b0(int i10) {
        return (CloudBackupStatus) super.mo29318b0(i10);
    }

    /* renamed from: v2 */
    public void m29445v2() {
        mo29437t0(1L);
        mo29440u0(1L);
    }

    /* renamed from: w1 */
    public CloudBackupStatus m29447w1(String str) {
        this.f22376z = str;
        return this;
    }

    /* renamed from: w2 */
    public void m29448w2() {
        if (m29858I() == 3 || m29858I() == 2) {
            m29442u2();
            m29445v2();
            m29343D0();
        }
        if (m29858I() == 3) {
            m29451x2();
        }
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus mo29395c0(long j10) {
        return (CloudBackupStatus) super.mo29395c0(j10);
    }

    /* renamed from: x2 */
    public void m29451x2() {
        mo29443v0(1L);
        mo29446w0(1L);
    }

    /* renamed from: y1 */
    public CloudBackupStatus m29453y1(int i10) {
        this.f22347C = i10;
        return this;
    }

    /* renamed from: z1 */
    public CloudBackupStatus m29454z1(int i10) {
        this.f22346B = i10;
        return this;
    }
}
