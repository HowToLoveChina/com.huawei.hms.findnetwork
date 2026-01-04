package com.huawei.hicloud.cloudbackup.store.database.report;

import android.text.TextUtils;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus;

/* loaded from: classes6.dex */
public class CloudBackupReport extends BackupStatus {

    /* renamed from: B */
    public long f22332B;

    /* renamed from: C */
    public long f22333C;

    /* renamed from: D */
    public long f22334D;

    /* renamed from: E */
    public int f22335E;

    /* renamed from: F */
    public long f22336F;

    /* renamed from: G */
    public long f22337G;

    /* renamed from: H */
    public long f22338H;

    /* renamed from: z */
    public String f22344z = "";

    /* renamed from: A */
    public String f22331A = "";

    /* renamed from: I */
    public String f22339I = "";

    /* renamed from: J */
    public String f22340J = "";

    /* renamed from: K */
    public String f22341K = "";

    /* renamed from: L */
    public String f22342L = "";

    /* renamed from: M */
    public String f22343M = "";

    /* renamed from: D0 */
    public String m29290D0() {
        return TextUtils.isEmpty(this.f22331A) ? "1" : this.f22331A;
    }

    /* renamed from: E0 */
    public String m29291E0() {
        return TextUtils.isEmpty(this.f22344z) ? "v1" : this.f22344z;
    }

    /* renamed from: F0 */
    public String m29292F0() {
        return this.f22339I;
    }

    /* renamed from: G0 */
    public String m29293G0() {
        return this.f22340J;
    }

    /* renamed from: H0 */
    public String m29294H0() {
        return this.f22341K;
    }

    /* renamed from: I0 */
    public String m29295I0() {
        return this.f22342L;
    }

    /* renamed from: J0 */
    public String m29296J0() {
        return this.f22343M;
    }

    /* renamed from: K0 */
    public long m29297K0() {
        return this.f22334D;
    }

    /* renamed from: L0 */
    public long m29298L0() {
        return this.f22337G;
    }

    /* renamed from: M0 */
    public long m29299M0() {
        return this.f22338H;
    }

    /* renamed from: N0 */
    public long m29300N0() {
        return this.f22336F;
    }

    /* renamed from: O0 */
    public int m29301O0() {
        return this.f22335E;
    }

    /* renamed from: P0 */
    public long m29302P0() {
        return this.f22332B;
    }

    /* renamed from: Q0 */
    public long m29303Q0() {
        return this.f22333C;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29308V(long j10) {
        return (CloudBackupReport) super.mo29308V(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29310W(int i10) {
        return (CloudBackupReport) super.mo29310W(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29313Y(String str) {
        return (CloudBackupReport) super.mo29313Y(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29316a0(String str) {
        return (CloudBackupReport) super.mo29316a0(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29318b0(int i10) {
        return (CloudBackupReport) super.mo29318b0(i10);
    }

    /* renamed from: W0 */
    public CloudBackupReport m29311W0(String str) {
        this.f22331A = str;
        return this;
    }

    /* renamed from: X0 */
    public CloudBackupReport m29312X0(String str) {
        this.f22344z = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29321d0(long j10) {
        return (CloudBackupReport) super.mo29321d0(j10);
    }

    /* renamed from: Z0 */
    public CloudBackupReport m29315Z0(String str) {
        this.f22339I = str;
        return this;
    }

    /* renamed from: a1 */
    public CloudBackupReport m29317a1(String str) {
        this.f22340J = str;
        return this;
    }

    /* renamed from: b1 */
    public CloudBackupReport m29319b1(String str) {
        this.f22341K = str;
        return this;
    }

    /* renamed from: c1 */
    public CloudBackupReport m29320c1(String str) {
        this.f22342L = str;
        return this;
    }

    /* renamed from: d1 */
    public CloudBackupReport m29322d1(String str) {
        this.f22343M = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29323e0(long j10) {
        return (CloudBackupReport) super.mo29323e0(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f1 */
    public CloudBackupReport m29326f1(long j10) {
        this.f22334D = j10;
        return this;
    }

    /* renamed from: g1 */
    public CloudBackupReport m29328g1(long j10) {
        this.f22337G = j10;
        return this;
    }

    /* renamed from: h1 */
    public CloudBackupReport m29329h1(long j10) {
        this.f22338H = j10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i1 */
    public CloudBackupReport m29330i1(long j10) {
        this.f22336F = j10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29325f0(int i10) {
        return (CloudBackupReport) super.mo29325f0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29327g0(int i10) {
        return (CloudBackupReport) super.mo29327g0(i10);
    }

    /* renamed from: l1 */
    public CloudBackupReport m29333l1(int i10) {
        this.f22335E = i10;
        return this;
    }

    /* renamed from: m1 */
    public CloudBackupReport m29334m1(long j10) {
        this.f22332B = j10;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29338z0(int i10) {
        return (CloudBackupReport) super.mo29338z0(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport mo29289A0(int i10) {
        return (CloudBackupReport) super.mo29289A0(i10);
    }

    /* renamed from: p1 */
    public CloudBackupReport m29337p1(long j10) {
        this.f22333C = j10;
        return this;
    }
}
