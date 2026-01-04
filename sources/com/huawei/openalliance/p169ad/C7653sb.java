package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;

/* renamed from: com.huawei.openalliance.ad.sb */
/* loaded from: classes8.dex */
public class C7653sb {

    /* renamed from: a */
    private String f35642a;

    /* renamed from: c */
    private String f35644c;

    /* renamed from: d */
    private String f35645d;

    /* renamed from: j */
    private Long f35651j;

    /* renamed from: k */
    private ContentRecord f35652k;

    /* renamed from: l */
    private HttpConnection f35653l;

    /* renamed from: m */
    private long f35654m;

    /* renamed from: n */
    private Long f35655n;

    /* renamed from: o */
    private String f35656o;

    /* renamed from: s */
    private Integer f35660s;

    /* renamed from: t */
    private String f35661t;

    /* renamed from: u */
    private Integer f35662u;

    /* renamed from: b */
    private long f35643b = 52428800;

    /* renamed from: e */
    private int f35646e = 10000;

    /* renamed from: f */
    private int f35647f = 10000;

    /* renamed from: g */
    private boolean f35648g = true;

    /* renamed from: h */
    private boolean f35649h = false;

    /* renamed from: i */
    private boolean f35650i = false;

    /* renamed from: p */
    private String f35657p = Constants.NORMAL_CACHE;

    /* renamed from: q */
    private boolean f35658q = false;

    /* renamed from: r */
    private boolean f35659r = false;

    /* renamed from: a */
    public void m47166a(int i10) {
        this.f35646e = i10;
    }

    /* renamed from: b */
    public Integer m47175b() {
        return this.f35662u;
    }

    /* renamed from: c */
    public String m47182c() {
        return this.f35661t;
    }

    /* renamed from: d */
    public String m47186d() {
        return this.f35644c;
    }

    /* renamed from: e */
    public String m47189e() {
        return this.f35645d;
    }

    /* renamed from: f */
    public int m47191f() {
        return this.f35646e;
    }

    /* renamed from: g */
    public int m47192g() {
        return this.f35647f;
    }

    /* renamed from: h */
    public long m47193h() {
        return this.f35643b;
    }

    /* renamed from: i */
    public String m47194i() {
        return this.f35642a;
    }

    /* renamed from: j */
    public boolean m47195j() {
        return this.f35648g;
    }

    /* renamed from: k */
    public Long m47196k() {
        return this.f35651j;
    }

    /* renamed from: l */
    public ContentRecord m47197l() {
        return this.f35652k;
    }

    /* renamed from: m */
    public boolean m47198m() {
        return this.f35649h;
    }

    /* renamed from: n */
    public HttpConnection m47199n() {
        return this.f35653l;
    }

    /* renamed from: o */
    public long m47200o() {
        return this.f35654m;
    }

    /* renamed from: p */
    public Long m47201p() {
        return this.f35655n;
    }

    /* renamed from: q */
    public String m47202q() {
        return this.f35656o;
    }

    /* renamed from: r */
    public String m47203r() {
        return this.f35657p;
    }

    /* renamed from: s */
    public boolean m47204s() {
        return this.f35658q;
    }

    /* renamed from: t */
    public boolean m47205t() {
        return this.f35659r;
    }

    /* renamed from: u */
    public Integer m47206u() {
        return this.f35660s;
    }

    /* renamed from: a */
    public void m47167a(long j10) {
        this.f35643b = j10;
    }

    /* renamed from: b */
    public void m47176b(int i10) {
        this.f35647f = i10;
    }

    /* renamed from: c */
    public void m47183c(int i10) {
        this.f35643b = i10 * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
    }

    /* renamed from: d */
    public void m47187d(String str) {
        this.f35642a = str;
    }

    /* renamed from: e */
    public void m47190e(String str) {
        this.f35657p = str;
    }

    /* renamed from: a */
    public void m47168a(HttpConnection httpConnection) {
        this.f35653l = httpConnection;
    }

    /* renamed from: b */
    public void m47177b(long j10) {
        this.f35654m = j10;
    }

    /* renamed from: c */
    public void m47184c(String str) {
        this.f35645d = str;
    }

    /* renamed from: d */
    public void m47188d(boolean z10) {
        this.f35659r = z10;
    }

    /* renamed from: a */
    public void m47169a(ContentRecord contentRecord) {
        this.f35652k = contentRecord;
    }

    /* renamed from: b */
    public void m47178b(Integer num) {
        this.f35660s = num;
    }

    /* renamed from: c */
    public void m47185c(boolean z10) {
        this.f35649h = z10;
    }

    /* renamed from: a */
    public void m47170a(Integer num) {
        this.f35662u = num;
    }

    /* renamed from: b */
    public void m47179b(Long l10) {
        this.f35655n = l10;
    }

    /* renamed from: a */
    public void m47171a(Long l10) {
        this.f35651j = l10;
    }

    /* renamed from: b */
    public void m47180b(String str) {
        this.f35644c = str;
    }

    /* renamed from: a */
    public void m47172a(String str) {
        this.f35661t = str;
    }

    /* renamed from: b */
    public void m47181b(boolean z10) {
        this.f35648g = z10;
    }

    /* renamed from: a */
    public void m47173a(boolean z10) {
        this.f35650i = z10;
    }

    /* renamed from: a */
    public boolean m47174a() {
        return this.f35650i;
    }
}
