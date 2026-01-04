package com.huawei.hicloud.cloudbackup.p104v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import java.util.Objects;

/* loaded from: classes6.dex */
public class BackupStatus implements Parcelable {
    public static final Parcelable.Creator<BackupStatus> CREATOR = new C4885a();

    /* renamed from: a */
    public int f22556a;

    /* renamed from: b */
    public String f22557b;

    /* renamed from: c */
    public String f22558c;

    /* renamed from: d */
    public int f22559d;

    /* renamed from: e */
    public int f22560e;

    /* renamed from: f */
    public int f22561f;

    /* renamed from: g */
    public int f22562g;

    /* renamed from: h */
    public int f22563h;

    /* renamed from: i */
    public int f22564i;

    /* renamed from: j */
    public long f22565j;

    /* renamed from: k */
    public long f22566k;

    /* renamed from: l */
    public long f22567l;

    /* renamed from: m */
    public long f22568m;

    /* renamed from: n */
    public long f22569n;

    /* renamed from: o */
    public long f22570o;

    /* renamed from: p */
    public long f22571p;

    /* renamed from: q */
    public long f22572q;

    /* renamed from: r */
    public long f22573r;

    /* renamed from: s */
    public long f22574s;

    /* renamed from: v */
    public int f22577v;

    /* renamed from: w */
    public int f22578w;

    /* renamed from: t */
    public long f22575t = 0;

    /* renamed from: u */
    public long f22576u = 0;

    /* renamed from: x */
    public String f22579x = "";

    /* renamed from: y */
    public String f22580y = "";

    /* renamed from: com.huawei.hicloud.cloudbackup.v3.model.BackupStatus$a */
    public class C4885a implements Parcelable.Creator<BackupStatus> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackupStatus createFromParcel(Parcel parcel) {
            BackupStatus backupStatus = new BackupStatus();
            backupStatus.mo29340B0(parcel.readInt());
            backupStatus.mo29313Y(parcel.readString());
            backupStatus.mo29316a0(parcel.readString());
            backupStatus.mo29318b0(parcel.readInt());
            backupStatus.mo29338z0(parcel.readInt());
            backupStatus.mo29289A0(parcel.readInt());
            backupStatus.mo29310W(parcel.readInt());
            backupStatus.mo29325f0(parcel.readInt());
            backupStatus.mo29327g0(parcel.readInt());
            backupStatus.mo29308V(parcel.readLong());
            backupStatus.mo29395c0(parcel.readLong());
            backupStatus.mo29323e0(parcel.readLong());
            backupStatus.mo29321d0(parcel.readLong());
            backupStatus.mo29434s0(parcel.readLong());
            backupStatus.mo29427p0(parcel.readLong());
            backupStatus.mo29440u0(parcel.readLong());
            backupStatus.mo29437t0(parcel.readLong());
            backupStatus.mo29446w0(parcel.readLong());
            backupStatus.mo29443v0(parcel.readLong());
            backupStatus.mo29416l0(parcel.readLong());
            backupStatus.mo29424o0(parcel.readLong());
            backupStatus.mo29449x0(parcel.readInt());
            backupStatus.mo29406h0(parcel.readInt());
            backupStatus.mo29413k0(parcel.readString());
            backupStatus.mo29452y0(parcel.readString());
            return backupStatus;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackupStatus[] newArray(int i10) {
            return new BackupStatus[i10];
        }
    }

    /* renamed from: A */
    public long m29856A() {
        return this.f22573r;
    }

    /* renamed from: A0 */
    public BackupStatus mo29289A0(int i10) {
        this.f22561f = i10;
        return this;
    }

    /* renamed from: B0 */
    public BackupStatus mo29340B0(int i10) {
        this.f22556a = i10;
        return this;
    }

    /* renamed from: C0 */
    public void m29857C0(BackupStatus backupStatus) {
        String str = this.f22557b;
        if (str != null && str.equals(backupStatus.f22557b)) {
            this.f22560e = backupStatus.f22560e;
            this.f22561f = backupStatus.f22561f;
            this.f22562g = backupStatus.f22562g;
            this.f22563h = backupStatus.f22563h;
            this.f22564i = backupStatus.f22564i;
            this.f22565j = backupStatus.f22565j;
            this.f22566k = backupStatus.f22566k;
            this.f22567l = backupStatus.f22567l;
            this.f22568m = backupStatus.f22568m;
            this.f22556a = backupStatus.f22556a;
            this.f22569n = backupStatus.f22569n;
            this.f22570o = backupStatus.f22570o;
            this.f22571p = backupStatus.f22571p;
            this.f22572q = backupStatus.f22572q;
            this.f22573r = backupStatus.f22573r;
            this.f22574s = backupStatus.f22574s;
            this.f22575t = backupStatus.f22575t;
            this.f22576u = backupStatus.f22576u;
            this.f22577v = backupStatus.f22577v;
            this.f22578w = backupStatus.f22578w;
            this.f22579x = backupStatus.f22579x;
            this.f22580y = backupStatus.f22580y;
        }
    }

    /* renamed from: I */
    public int m29858I() {
        return this.f22577v;
    }

    /* renamed from: K */
    public String mo29357K() {
        String str = this.f22580y;
        return str == null ? "" : str;
    }

    /* renamed from: L */
    public int m29859L() {
        return this.f22560e;
    }

    /* renamed from: M */
    public int m29860M() {
        return this.f22561f;
    }

    /* renamed from: N */
    public int m29861N() {
        return this.f22556a;
    }

    /* renamed from: O */
    public boolean m29862O() {
        return m29863P() && this.f22567l > 0;
    }

    /* renamed from: P */
    public boolean m29863P() {
        int i10 = this.f22559d;
        return (i10 == 0 || i10 == 2) ? false : true;
    }

    /* renamed from: Q */
    public boolean mo29370Q() {
        if (SplitAppUtil.hasSplitAppSuffix(this.f22557b)) {
            this.f22580y = SplitAppUtil.getSplitAppType(this.f22557b);
            this.f22579x = SplitAppUtil.getSplitOriAppId(this.f22557b);
        }
        return SplitAppUtil.isSplitApp(mo29357K());
    }

    /* renamed from: R */
    public boolean m29864R() {
        String str = this.f22557b;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "sysdata":
            case "baseData":
            case "thirdAppData":
                return true;
            case "thirdApp":
            default:
                return false;
        }
    }

    /* renamed from: S */
    public boolean m29865S() {
        String str = this.f22557b;
        if (str == null) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "sysdata":
            case "baseData":
            case "thirdAppData":
            case "thirdApp":
                return true;
            default:
                return false;
        }
    }

    /* renamed from: T */
    public boolean m29866T() {
        return this.f22559d == 0;
    }

    /* renamed from: U */
    public boolean m29867U() {
        return this.f22559d == 2;
    }

    /* renamed from: V */
    public BackupStatus mo29308V(long j10) {
        this.f22565j = j10;
        return this;
    }

    /* renamed from: W */
    public BackupStatus mo29310W(int i10) {
        this.f22562g = Math.max(i10, 0);
        return this;
    }

    /* renamed from: Y */
    public BackupStatus mo29313Y(String str) {
        this.f22557b = str;
        return this;
    }

    /* renamed from: a */
    public long m29868a() {
        return this.f22565j;
    }

    /* renamed from: a0 */
    public BackupStatus mo29316a0(String str) {
        this.f22558c = str;
        return this;
    }

    /* renamed from: b0 */
    public BackupStatus mo29318b0(int i10) {
        this.f22559d = i10;
        return this;
    }

    /* renamed from: c */
    public int m29869c() {
        return this.f22562g;
    }

    /* renamed from: c0 */
    public BackupStatus mo29395c0(long j10) {
        this.f22566k = j10;
        return this;
    }

    /* renamed from: d */
    public String m29870d() {
        return this.f22557b;
    }

    /* renamed from: d0 */
    public BackupStatus mo29321d0(long j10) {
        this.f22568m = j10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m29871e() {
        String str = this.f22558c;
        return str == null ? "" : str;
    }

    /* renamed from: e0 */
    public BackupStatus mo29323e0(long j10) {
        this.f22567l = j10;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BackupStatus backupStatus = (BackupStatus) obj;
        return this.f22559d == backupStatus.f22559d && Objects.equals(this.f22557b, backupStatus.f22557b) && this.f22556a == backupStatus.f22556a && Objects.equals(this.f22558c, backupStatus.f22558c);
    }

    /* renamed from: f */
    public int m29872f() {
        return this.f22559d;
    }

    /* renamed from: f0 */
    public BackupStatus mo29325f0(int i10) {
        this.f22563h = i10;
        return this;
    }

    /* renamed from: g */
    public long m29873g() {
        return this.f22566k;
    }

    /* renamed from: g0 */
    public BackupStatus mo29327g0(int i10) {
        this.f22564i = i10;
        return this;
    }

    /* renamed from: h */
    public long m29874h() {
        return this.f22568m;
    }

    /* renamed from: h0 */
    public BackupStatus mo29406h0(int i10) {
        this.f22578w = i10;
        return this;
    }

    public int hashCode() {
        return Objects.hash(this.f22557b, Integer.valueOf(this.f22556a), this.f22558c, Integer.valueOf(this.f22559d));
    }

    /* renamed from: i */
    public long m29875i() {
        return this.f22567l;
    }

    /* renamed from: j */
    public int m29876j() {
        return this.f22563h;
    }

    /* renamed from: k0 */
    public BackupStatus mo29413k0(String str) {
        this.f22579x = str;
        return this;
    }

    /* renamed from: l */
    public int m29877l() {
        return this.f22564i;
    }

    /* renamed from: l0 */
    public BackupStatus mo29416l0(long j10) {
        this.f22575t = j10;
        return this;
    }

    /* renamed from: m */
    public int m29878m() {
        return this.f22578w;
    }

    /* renamed from: n */
    public String mo29421n() {
        if (!mo29370Q()) {
            return m29870d();
        }
        String str = this.f22579x;
        return str == null ? "" : str;
    }

    /* renamed from: o */
    public long m29879o() {
        return this.f22575t;
    }

    /* renamed from: o0 */
    public BackupStatus mo29424o0(long j10) {
        this.f22576u = j10;
        return this;
    }

    /* renamed from: p */
    public long m29880p() {
        return this.f22576u;
    }

    /* renamed from: p0 */
    public BackupStatus mo29427p0(long j10) {
        this.f22570o = j10;
        return this;
    }

    /* renamed from: q */
    public long m29881q() {
        return this.f22569n;
    }

    /* renamed from: r */
    public long m29882r() {
        return this.f22570o;
    }

    /* renamed from: s */
    public long m29883s() {
        return this.f22572q;
    }

    /* renamed from: s0 */
    public BackupStatus mo29434s0(long j10) {
        this.f22569n = j10;
        return this;
    }

    /* renamed from: t */
    public long m29884t() {
        return this.f22571p;
    }

    /* renamed from: t0 */
    public BackupStatus mo29437t0(long j10) {
        this.f22572q = j10;
        return this;
    }

    public String toString() {
        return "BackupStatus{appId='" + this.f22557b + "', appName='" + this.f22558c + "', appType=" + this.f22559d + ", status=" + this.f22560e + ", type=" + this.f22561f + ", alreadyCount=" + this.f22562g + ", itemCount=" + this.f22563h + ", itemTotal=" + this.f22564i + ", alreadyBytes=" + this.f22565j + ", attachBytes=" + this.f22566k + ", dataBytes=" + this.f22567l + ", codeBytes=" + this.f22568m + ", uid=" + this.f22556a + ", prerareAlreadyBytes=" + this.f22570o + ", prerareBytes=" + this.f22569n + ", scanDataAlreadyBytes=" + this.f22572q + ", scanDataBytes=" + this.f22571p + ", scanSdcardAlreadyBytes=" + this.f22574s + ", scanSdcardBytes=" + this.f22573r + "} | " + super.toString();
    }

    /* renamed from: u0 */
    public BackupStatus mo29440u0(long j10) {
        this.f22571p = j10;
        return this;
    }

    /* renamed from: v */
    public long m29885v() {
        return this.f22574s;
    }

    /* renamed from: v0 */
    public BackupStatus mo29443v0(long j10) {
        this.f22574s = j10;
        return this;
    }

    /* renamed from: w0 */
    public BackupStatus mo29446w0(long j10) {
        this.f22573r = j10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22556a);
        parcel.writeString(this.f22557b);
        parcel.writeString(this.f22558c);
        parcel.writeInt(this.f22559d);
        parcel.writeInt(this.f22560e);
        parcel.writeInt(this.f22561f);
        parcel.writeInt(this.f22562g);
        parcel.writeInt(this.f22563h);
        parcel.writeInt(this.f22564i);
        parcel.writeLong(this.f22565j);
        parcel.writeLong(this.f22566k);
        parcel.writeLong(this.f22567l);
        parcel.writeLong(this.f22568m);
        parcel.writeLong(this.f22569n);
        parcel.writeLong(this.f22570o);
        parcel.writeLong(this.f22571p);
        parcel.writeLong(this.f22572q);
        parcel.writeLong(this.f22573r);
        parcel.writeLong(this.f22574s);
        parcel.writeLong(this.f22575t);
        parcel.writeLong(this.f22576u);
        parcel.writeInt(this.f22577v);
        parcel.writeInt(this.f22578w);
        parcel.writeString(this.f22579x);
        parcel.writeString(this.f22580y);
    }

    /* renamed from: x0 */
    public BackupStatus mo29449x0(int i10) {
        this.f22577v = i10;
        return this;
    }

    /* renamed from: y0 */
    public BackupStatus mo29452y0(String str) {
        this.f22580y = str;
        return this;
    }

    /* renamed from: z0 */
    public BackupStatus mo29338z0(int i10) {
        this.f22560e = i10;
        return this;
    }
}
