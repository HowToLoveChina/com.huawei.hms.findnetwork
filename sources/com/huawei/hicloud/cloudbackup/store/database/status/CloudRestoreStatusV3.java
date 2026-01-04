package com.huawei.hicloud.cloudbackup.store.database.status;

import android.text.TextUtils;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import p015ak.C0241z;

/* loaded from: classes6.dex */
public class CloudRestoreStatusV3 extends RestoreStatus {

    /* renamed from: a */
    public String f22377a;

    /* renamed from: b */
    public int f22378b;

    /* renamed from: c */
    public int f22379c;

    /* renamed from: d */
    public int f22380d;

    /* renamed from: e */
    public String f22381e;

    /* renamed from: f */
    public int f22382f;

    /* renamed from: g */
    public int f22383g;

    /* renamed from: h */
    public String f22384h;

    /* renamed from: i */
    public int f22385i;

    /* renamed from: j */
    public String f22386j;

    /* renamed from: k */
    public String f22387k;

    /* renamed from: l */
    public String f22388l;

    /* renamed from: m */
    public String f22389m;

    /* renamed from: n */
    public String f22390n;

    /* renamed from: o */
    public String f22391o;

    /* renamed from: p */
    public String f22392p;

    /* renamed from: q */
    public String f22393q = "";

    /* renamed from: A */
    public int m29455A() {
        return this.f22385i;
    }

    /* renamed from: A0 */
    public CloudRestoreStatusV3 m29456A0(String str) {
        this.f22389m = str;
        if (!TextUtils.isEmpty(str)) {
            super.setProgressShowType(C0241z.m1685c(str));
        }
        return this;
    }

    /* renamed from: B0 */
    public CloudRestoreStatusV3 m29457B0(String str) {
        this.f22390n = str;
        return this;
    }

    /* renamed from: C0 */
    public CloudRestoreStatusV3 m29458C0(String str) {
        this.f22391o = str;
        return this;
    }

    /* renamed from: D0 */
    public CloudRestoreStatusV3 m29459D0(String str) {
        this.f22392p = str;
        return this;
    }

    /* renamed from: E0 */
    public CloudRestoreStatusV3 m29460E0(int i10) {
        this.f22379c = i10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: F0 */
    public CloudRestoreStatusV3 setHarmonyNext(boolean z10) {
        return (CloudRestoreStatusV3) super.setHarmonyNext(z10);
    }

    /* renamed from: G0 */
    public CloudRestoreStatusV3 m29462G0(String str) {
        this.f22384h = str;
        return this;
    }

    /* renamed from: H0 */
    public CloudRestoreStatusV3 m29463H0(String str) {
        this.f22377a = str;
        return this;
    }

    /* renamed from: I0 */
    public CloudRestoreStatusV3 m29464I0(int i10) {
        this.f22385i = i10;
        return this;
    }

    /* renamed from: J0 */
    public CloudRestoreStatusV3 m29465J0(int i10) {
        this.f22383g = i10;
        return this;
    }

    /* renamed from: K */
    public int m29466K() {
        return this.f22383g;
    }

    /* renamed from: K0 */
    public CloudRestoreStatusV3 m29467K0(String str) {
        this.f22387k = str;
        return this;
    }

    /* renamed from: L */
    public String m29468L() {
        return getAppId() + getUid();
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: L0 */
    public CloudRestoreStatusV3 setOriBackupAppName(String str) {
        return (CloudRestoreStatusV3) super.setOriBackupAppName(str);
    }

    /* renamed from: M */
    public String m29470M() {
        return !isTwinApp() ? getAppId() : super.getOriBackupAppName();
    }

    /* renamed from: M0 */
    public CloudRestoreStatusV3 m29471M0(String str) {
        this.f22393q = str;
        return this;
    }

    /* renamed from: N */
    public String m29472N() {
        return TextUtils.isEmpty(this.f22393q) ? "" : this.f22393q;
    }

    /* renamed from: N0 */
    public CloudRestoreStatusV3 m29473N0(String str) {
        this.f22386j = str;
        return this;
    }

    /* renamed from: O */
    public String m29474O() {
        String str = this.f22386j;
        return str == null ? "" : str;
    }

    /* renamed from: O0 */
    public CloudRestoreStatusV3 m29475O0(int i10) {
        this.f22378b = i10;
        return this;
    }

    /* renamed from: P */
    public int m29476P() {
        return this.f22378b;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: P0 */
    public CloudRestoreStatusV3 setSize(long j10) {
        return (CloudRestoreStatusV3) super.setSize(j10);
    }

    /* renamed from: Q */
    public boolean m29478Q() {
        return this.f22385i == 1;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: Q0 */
    public CloudRestoreStatusV3 setSplitApkType(String str) {
        return (CloudRestoreStatusV3) super.setSplitApkType(str);
    }

    /* renamed from: R */
    public boolean m29480R() {
        return getAppType() == 6;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: R0 */
    public CloudRestoreStatusV3 setStatus(int i10) {
        return (CloudRestoreStatusV3) super.setStatus(i10);
    }

    /* renamed from: S */
    public boolean m29482S() {
        return getAppType() == 7;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: S0 */
    public CloudRestoreStatusV3 setType(int i10) {
        return (CloudRestoreStatusV3) super.setType(i10);
    }

    /* renamed from: T */
    public boolean m29484T() {
        if (isHarmonyNext()) {
            return false;
        }
        return "com.huawei.meetime".equals(getAppId()) ? this.f22382f > this.f22383g : this.f22382f >= this.f22383g;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: T0 */
    public CloudRestoreStatusV3 setUid(int i10) {
        return (CloudRestoreStatusV3) super.setUid(i10);
    }

    /* renamed from: U */
    public boolean m29486U() {
        return getAppType() == 5;
    }

    /* renamed from: U0 */
    public CloudRestoreStatusV3 m29487U0(int i10) {
        this.f22382f = i10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: V */
    public CloudRestoreStatusV3 setAction(int i10) {
        return (CloudRestoreStatusV3) super.setAction(i10);
    }

    /* renamed from: V0 */
    public CloudRestoreStatusV3 m29489V0(String str) {
        this.f22381e = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: W */
    public CloudRestoreStatusV3 setAggVirtualAppId(String str) {
        return (CloudRestoreStatusV3) super.setAggVirtualAppId(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: Y */
    public CloudRestoreStatusV3 setAppId(String str) {
        return (CloudRestoreStatusV3) super.setAppId(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public int m29492f() {
        return this.f22380d;
    }

    public String getData1() {
        String str = this.f22388l;
        return str == null ? "" : str;
    }

    public String getMessage() {
        String str = this.f22387k;
        return str == null ? "" : str;
    }

    public int getVersionCode() {
        return this.f22382f;
    }

    public String getVersionName() {
        String str = this.f22381e;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public String m29493i() {
        String str = this.f22389m;
        return str == null ? "" : str;
    }

    /* renamed from: p */
    public String m29494p() {
        String str = this.f22390n;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: p0 */
    public CloudRestoreStatusV3 setAppName(String str) {
        return (CloudRestoreStatusV3) super.setAppName(str);
    }

    /* renamed from: q */
    public String m29496q() {
        String str = this.f22391o;
        return str == null ? "" : str;
    }

    /* renamed from: r */
    public String m29497r() {
        String str = this.f22392p;
        return str == null ? "" : str;
    }

    /* renamed from: s */
    public int m29498s() {
        return this.f22379c;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: s0 */
    public CloudRestoreStatusV3 setAppShowType(int i10) {
        return (CloudRestoreStatusV3) super.setAppShowType(i10);
    }

    /* renamed from: t */
    public String m29500t() {
        String str = this.f22384h;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: t0 */
    public CloudRestoreStatusV3 setAppType(int i10) {
        return (CloudRestoreStatusV3) super.setAppType(i10);
    }

    public String toString() {
        return "CloudRestoreStatusV3{id='" + this.f22377a + "', appId=" + getAppId() + ", uid" + getUid() + ", status" + getStatus() + ", type" + getType() + '}';
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: u0 */
    public CloudRestoreStatusV3 setAsize(long j10) {
        return (CloudRestoreStatusV3) super.setAsize(j10);
    }

    /* renamed from: v */
    public String m29503v() {
        String str = this.f22377a;
        return str == null ? "" : str;
    }

    /* renamed from: v0 */
    public CloudRestoreStatusV3 m29504v0(int i10) {
        this.f22380d = i10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: w0 */
    public CloudRestoreStatusV3 setCompatible(boolean z10) {
        return (CloudRestoreStatusV3) super.setCompatible(z10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: x0 */
    public CloudRestoreStatusV3 setCount(int i10) {
        return (CloudRestoreStatusV3) super.setCount(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: y0 */
    public CloudRestoreStatusV3 setCurrent(int i10) {
        return (CloudRestoreStatusV3) super.setCurrent(i10);
    }

    /* renamed from: z0 */
    public CloudRestoreStatusV3 m29508z0(String str) {
        this.f22388l = str;
        return this;
    }
}
