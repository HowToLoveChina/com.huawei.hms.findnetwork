package tl;

import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import p015ak.C0241z;

/* renamed from: tl.k */
/* loaded from: classes6.dex */
public class C13032k {

    /* renamed from: a */
    public int f59326a;

    /* renamed from: b */
    public int f59327b;

    /* renamed from: c */
    public float f59328c;

    /* renamed from: d */
    public long f59329d;

    /* renamed from: e */
    public long f59330e;

    /* renamed from: f */
    public long f59331f;

    /* renamed from: g */
    public int f59332g;

    /* renamed from: h */
    public String f59333h;

    /* renamed from: i */
    public String f59334i;

    /* renamed from: j */
    public String f59335j;

    /* renamed from: k */
    public String f59336k;

    /* renamed from: l */
    public String f59337l;

    /* renamed from: m */
    public int f59338m = 0;

    /* renamed from: n */
    public String f59339n = String.valueOf(0);

    /* renamed from: o */
    public String f59340o;

    /* renamed from: p */
    public String f59341p;

    /* renamed from: q */
    public String f59342q;

    /* renamed from: r */
    public String f59343r;

    /* renamed from: A */
    public void m78504A(String str) {
        this.f59342q = str;
    }

    /* renamed from: B */
    public void m78505B(String str) {
        this.f59343r = str;
    }

    /* renamed from: C */
    public void m78506C(String str) {
        this.f59333h = str;
    }

    /* renamed from: D */
    public void m78507D(long j10) {
        this.f59331f = j10;
    }

    /* renamed from: E */
    public void m78508E(int i10) {
        this.f59339n = String.valueOf(i10 | C0241z.m1685c(this.f59339n));
    }

    /* renamed from: F */
    public void m78509F(int i10) {
        this.f59326a = i10;
    }

    /* renamed from: G */
    public void m78510G(int i10) {
        this.f59338m = i10;
    }

    /* renamed from: H */
    public void m78511H(float f10) {
        this.f59328c = f10;
    }

    /* renamed from: I */
    public void m78512I(int i10) {
        this.f59332g = i10;
    }

    /* renamed from: J */
    public void m78513J(long j10) {
        this.f59329d = j10;
    }

    /* renamed from: K */
    public void m78514K(int i10) {
        this.f59327b = i10;
    }

    /* renamed from: L */
    public void m78515L(long j10) {
        this.f59330e = j10;
    }

    /* renamed from: M */
    public void m78516M(String str) {
        this.f59335j = str;
    }

    /* renamed from: a */
    public String m78517a() {
        String str = this.f59334i;
        return str == null ? "" : str;
    }

    /* renamed from: b */
    public String m78518b() {
        String str = this.f59336k;
        return str == null ? "" : str;
    }

    /* renamed from: c */
    public String m78519c() {
        String str = this.f59337l;
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public String m78520d() {
        String str = this.f59339n;
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public String m78521e() {
        return this.f59340o == null ? "" : this.f59339n;
    }

    /* renamed from: f */
    public String m78522f() {
        String str = this.f59341p;
        return str == null ? "" : str;
    }

    /* renamed from: g */
    public String m78523g() {
        String str = this.f59342q;
        return str == null ? "" : str;
    }

    /* renamed from: h */
    public String m78524h() {
        String str = this.f59343r;
        return str == null ? "" : str;
    }

    /* renamed from: i */
    public String m78525i() {
        String str = this.f59333h;
        return str == null ? "" : str;
    }

    /* renamed from: j */
    public long m78526j() {
        return this.f59331f;
    }

    /* renamed from: k */
    public int m78527k() {
        return this.f59326a;
    }

    /* renamed from: l */
    public int m78528l() {
        return (int) this.f59328c;
    }

    /* renamed from: m */
    public float m78529m() {
        return this.f59328c;
    }

    /* renamed from: n */
    public int m78530n() {
        return this.f59332g;
    }

    /* renamed from: o */
    public long m78531o() {
        return this.f59329d;
    }

    /* renamed from: p */
    public int m78532p() {
        return this.f59327b;
    }

    /* renamed from: q */
    public long m78533q() {
        return this.f59330e;
    }

    /* renamed from: r */
    public String m78534r() {
        String str = this.f59335j;
        return str == null ? "" : str;
    }

    /* renamed from: s */
    public int m78535s() {
        return this.f59338m;
    }

    /* renamed from: t */
    public void m78536t(CloudBackupState cloudBackupState) {
        cloudBackupState.setReturnCode(this.f59332g);
        cloudBackupState.setState(this.f59327b);
        cloudBackupState.setId(this.f59326a);
        cloudBackupState.setUpdateTime(this.f59330e);
        cloudBackupState.setVersion(this.f59335j);
        cloudBackupState.setProgress(this.f59328c);
        cloudBackupState.setCurrentMoudle(this.f59337l);
        cloudBackupState.setSpacialStatus(this.f59339n);
        cloudBackupState.setIsNextShow(this.f59338m);
        cloudBackupState.setStartTime(this.f59329d);
        cloudBackupState.setStatusInPrepare(this.f59342q);
        cloudBackupState.setUid(C0241z.m1685c(this.f59341p));
    }

    /* renamed from: u */
    public void m78537u(String str) {
        this.f59334i = str;
    }

    /* renamed from: v */
    public void m78538v(String str) {
        this.f59336k = str;
    }

    /* renamed from: w */
    public void m78539w(String str) {
        this.f59337l = str;
    }

    /* renamed from: x */
    public void m78540x(String str) {
        this.f59339n = str;
    }

    /* renamed from: y */
    public void m78541y(String str) {
        this.f59340o = str;
    }

    /* renamed from: z */
    public void m78542z(String str) {
        this.f59341p = str;
    }
}
