package com.huawei.hicloud.cloudbackup.store.database.tags;

import android.text.TextUtils;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import p015ak.C0241z;

/* loaded from: classes6.dex */
public class CloudRestoreStatus extends RestoreStatus {

    /* renamed from: a */
    public String f22394a;

    /* renamed from: b */
    public String f22395b;

    /* renamed from: c */
    public int f22396c;

    /* renamed from: d */
    public int f22397d;

    /* renamed from: e */
    public int f22398e;

    /* renamed from: f */
    public String f22399f;

    /* renamed from: g */
    public String f22400g;

    /* renamed from: h */
    public String f22401h;

    /* renamed from: i */
    public String f22402i;

    /* renamed from: j */
    public String f22403j;

    /* renamed from: k */
    public String f22404k;

    /* renamed from: l */
    public int f22405l;

    /* renamed from: m */
    public String f22406m;

    /* renamed from: n */
    public String f22407n;

    /* renamed from: o */
    public String f22408o;

    /* renamed from: p */
    public String f22409p;

    /* renamed from: q */
    public String f22410q;

    /* renamed from: A */
    public String m29509A() {
        String str = this.f22403j;
        return str == null ? "" : str;
    }

    /* renamed from: A0 */
    public CloudRestoreStatus m29510A0(String str) {
        this.f22409p = str;
        return this;
    }

    /* renamed from: B0 */
    public CloudRestoreStatus m29511B0(String str) {
        this.f22410q = str;
        return this;
    }

    /* renamed from: C0 */
    public CloudRestoreStatus m29512C0(int i10) {
        this.f22398e = i10;
        return this;
    }

    /* renamed from: D0 */
    public CloudRestoreStatus m29513D0(String str) {
        this.f22403j = str;
        return this;
    }

    /* renamed from: E0 */
    public CloudRestoreStatus m29514E0(String str) {
        this.f22404k = str;
        return this;
    }

    /* renamed from: F0 */
    public CloudRestoreStatus m29515F0(String str) {
        this.f22401h = str;
        return this;
    }

    /* renamed from: G0 */
    public CloudRestoreStatus m29516G0(String str) {
        this.f22402i = str;
        return this;
    }

    /* renamed from: H0 */
    public CloudRestoreStatus m29517H0(int i10) {
        this.f22405l = i10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: I0 */
    public CloudRestoreStatus setSize(long j10) {
        return (CloudRestoreStatus) super.setSize(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: J0 */
    public CloudRestoreStatus setStatus(int i10) {
        return (CloudRestoreStatus) super.setStatus(i10);
    }

    /* renamed from: K */
    public String m29520K() {
        String str = this.f22404k;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: K0 */
    public CloudRestoreStatus setType(int i10) {
        return (CloudRestoreStatus) super.setType(i10);
    }

    /* renamed from: L */
    public String m29522L() {
        String str = this.f22401h;
        return str == null ? "" : str;
    }

    /* renamed from: L0 */
    public CloudRestoreStatus m29523L0(int i10) {
        this.f22397d = i10;
        return this;
    }

    /* renamed from: M */
    public String m29524M() {
        String str = this.f22402i;
        return str == null ? "" : str;
    }

    /* renamed from: M0 */
    public CloudRestoreStatus m29525M0(int i10) {
        this.f22396c = i10;
        return this;
    }

    /* renamed from: N */
    public int m29526N() {
        return this.f22405l;
    }

    /* renamed from: N0 */
    public CloudRestoreStatus m29527N0(String str) {
        this.f22395b = str;
        return this;
    }

    /* renamed from: O */
    public boolean m29528O() {
        return this.f22405l == 1;
    }

    /* renamed from: P */
    public boolean m29529P() {
        return is3rdAppType() && C0241z.m1686d(this.f22408o, 0) == 1;
    }

    /* renamed from: Q */
    public boolean m29530Q() {
        return TextUtils.equals(this.f22409p, String.valueOf(1));
    }

    /* renamed from: R */
    public boolean m29531R() {
        return is3rdAppType() && C0241z.m1686d(this.f22408o, 0) == 2;
    }

    /* renamed from: S */
    public boolean m29532S() {
        return this.f22396c >= this.f22397d;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: T */
    public CloudRestoreStatus setAction(int i10) {
        return (CloudRestoreStatus) super.setAction(i10);
    }

    /* renamed from: U */
    public CloudRestoreStatus m29534U(String str) {
        this.f22394a = str;
        return this;
    }

    /* renamed from: V */
    public CloudRestoreStatus m29535V(String str) {
        this.f22399f = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: W */
    public CloudRestoreStatus setAppId(String str) {
        return (CloudRestoreStatus) super.setAppId(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: Y */
    public CloudRestoreStatus setAppName(String str) {
        return (CloudRestoreStatus) super.setAppName(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public String m29538f() {
        String str = this.f22394a;
        return str == null ? "" : str;
    }

    public String getData1() {
        String str = this.f22406m;
        return str == null ? "" : str;
    }

    public int getVersion() {
        return this.f22397d;
    }

    public int getVersionCode() {
        return this.f22396c;
    }

    public String getVersionName() {
        String str = this.f22395b;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public String m29539i() {
        String str = this.f22399f;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public boolean isVirtual() {
        return !is3rdAppType() && C0241z.m1686d(this.f22408o, 0) == 1;
    }

    /* renamed from: p */
    public String m29540p() {
        String str = this.f22400g;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: p0 */
    public CloudRestoreStatus setAppType(int i10) {
        return (CloudRestoreStatus) super.setAppType(i10);
    }

    /* renamed from: q */
    public String m29542q() {
        String str = this.f22407n;
        return str == null ? "" : str;
    }

    /* renamed from: r */
    public String m29543r() {
        String str = this.f22408o;
        return str == null ? "" : str;
    }

    /* renamed from: s */
    public String m29544s() {
        String str = this.f22409p;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: s0 */
    public CloudRestoreStatus setAsize(long j10) {
        return (CloudRestoreStatus) super.setAsize(j10);
    }

    /* renamed from: t */
    public String m29546t() {
        String str = this.f22410q;
        return str == null ? "" : str;
    }

    /* renamed from: t0 */
    public CloudRestoreStatus m29547t0(String str) {
        this.f22400g = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: u0 */
    public CloudRestoreStatus setBmAppDataType(int i10) {
        return (CloudRestoreStatus) super.setBmAppDataType(i10);
    }

    /* renamed from: v */
    public int m29549v() {
        return this.f22398e;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: v0 */
    public CloudRestoreStatus setCount(int i10) {
        return (CloudRestoreStatus) super.setCount(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    /* renamed from: w0 */
    public CloudRestoreStatus setCurrent(int i10) {
        return (CloudRestoreStatus) super.setCurrent(i10);
    }

    /* renamed from: x0 */
    public CloudRestoreStatus m29552x0(String str) {
        this.f22406m = str;
        if (!TextUtils.isEmpty(str)) {
            super.setProgressShowType(C0241z.m1685c(str));
        }
        return this;
    }

    /* renamed from: y0 */
    public CloudRestoreStatus m29553y0(String str) {
        this.f22407n = str;
        return this;
    }

    /* renamed from: z0 */
    public CloudRestoreStatus m29554z0(String str) {
        this.f22408o = str;
        return this;
    }
}
