package com.huawei.openalliance.p169ad.net.http;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;

@DataKeep
@OuterVisible
/* loaded from: classes2.dex */
public class Response<DATA> {
    private static final String TAG = "Response";
    private long contentLength;
    private DATA data;
    private long dataConverterCost;
    private long hmsRecEngineCost;

    @InterfaceC6934f
    private HttpConnection httpConnection;
    private long infoCost;
    private long netDuration1;
    private long netDuration2;
    private long netEndTS;
    private long netStartTS;
    private String origData;
    private long recEngineCost;
    private boolean reqBodyGzipped;

    @InterfaceC6934f
    private Throwable throwable;
    private int useHuaweiDNS;
    private int httpCode = -1;
    private String exception = "";
    private String exception1 = "";
    private boolean dnserror = false;
    private int requestType = 0;
    private int resultAdReqType = 0;

    /* renamed from: a */
    public int m45977a() {
        return this.httpCode;
    }

    /* renamed from: b */
    public DATA m45987b() {
        return this.data;
    }

    /* renamed from: c */
    public long m45992c() {
        return this.contentLength;
    }

    /* renamed from: d */
    public String m45995d() {
        return this.exception;
    }

    /* renamed from: e */
    public void m45998e(long j10) {
        this.recEngineCost = j10;
    }

    /* renamed from: f */
    public long m46000f() {
        return this.netDuration1;
    }

    /* renamed from: g */
    public long m46002g() {
        return this.netDuration2;
    }

    /* renamed from: h */
    public int m46003h() {
        return this.requestType;
    }

    /* renamed from: i */
    public int m46004i() {
        return this.useHuaweiDNS;
    }

    /* renamed from: j */
    public String m46005j() {
        return this.exception1;
    }

    /* renamed from: k */
    public long m46006k() {
        return this.infoCost;
    }

    /* renamed from: l */
    public long m46007l() {
        return this.dataConverterCost;
    }

    /* renamed from: m */
    public HttpConnection m46008m() {
        return this.httpConnection;
    }

    /* renamed from: n */
    public Throwable m46009n() {
        return this.throwable;
    }

    /* renamed from: o */
    public boolean m46010o() {
        return this.reqBodyGzipped;
    }

    /* renamed from: p */
    public long m46011p() {
        return this.netStartTS;
    }

    /* renamed from: q */
    public long m46012q() {
        return this.netEndTS;
    }

    /* renamed from: r */
    public long m46013r() {
        return this.recEngineCost;
    }

    /* renamed from: s */
    public long m46014s() {
        return this.hmsRecEngineCost;
    }

    /* renamed from: t */
    public int m46015t() {
        return this.resultAdReqType;
    }

    /* renamed from: a */
    public void m45978a(int i10) {
        this.httpCode = i10;
    }

    /* renamed from: b */
    public void m45988b(int i10) {
        this.requestType = i10;
    }

    /* renamed from: c */
    public void m45993c(int i10) {
        this.useHuaweiDNS = i10;
    }

    /* renamed from: d */
    public void m45996d(int i10) {
        this.resultAdReqType = i10;
    }

    /* renamed from: e */
    public boolean m45999e() {
        return this.dnserror;
    }

    /* renamed from: f */
    public void m46001f(long j10) {
        this.hmsRecEngineCost = j10;
    }

    /* renamed from: a */
    public void m45979a(long j10) {
        this.contentLength = j10;
    }

    /* renamed from: b */
    public void m45989b(long j10) {
        if (j10 < 0) {
            return;
        }
        this.netDuration2 = j10;
        AbstractC7185ho.m43820b(TAG, "setNetDuration2 " + j10);
    }

    /* renamed from: c */
    public void m45994c(long j10) {
        if (j10 < 0) {
            return;
        }
        this.infoCost = j10;
        AbstractC7185ho.m43820b(TAG, "setInfoCost " + j10);
    }

    /* renamed from: d */
    public void m45997d(long j10) {
        if (j10 < 0) {
            return;
        }
        this.dataConverterCost = j10;
        AbstractC7185ho.m43820b(TAG, "setDataConverterCost " + j10);
    }

    /* renamed from: a */
    public void m45980a(long j10, long j11) {
        if (j10 <= 0 || j10 >= j11) {
            return;
        }
        this.netStartTS = j10;
        this.netEndTS = j11;
        this.netDuration1 = j11 - j10;
        AbstractC7185ho.m43820b(TAG, "setNetDuration1 " + this.netDuration1);
    }

    /* renamed from: b */
    public void m45990b(String str) {
        this.origData = str;
    }

    /* renamed from: a */
    public void m45981a(HttpConnection httpConnection) {
        this.httpConnection = httpConnection;
    }

    /* renamed from: b */
    public void m45991b(boolean z10) {
        this.reqBodyGzipped = z10;
    }

    /* renamed from: a */
    public void m45982a(Response response) {
        if (response == null) {
            return;
        }
        this.contentLength = response.contentLength;
        this.dataConverterCost = response.dataConverterCost;
        this.dnserror = response.dnserror;
        this.exception = response.exception;
        this.exception1 = response.exception1;
        this.httpCode = response.httpCode;
        this.httpConnection = response.httpConnection;
        this.infoCost = response.infoCost;
        this.netDuration1 = response.netDuration1;
        this.netDuration2 = response.netDuration2;
        this.netEndTS = response.netEndTS;
        this.netStartTS = response.netStartTS;
        this.reqBodyGzipped = response.reqBodyGzipped;
        this.requestType = response.requestType;
        this.throwable = response.throwable;
        this.useHuaweiDNS = response.useHuaweiDNS;
        this.recEngineCost = response.recEngineCost;
        this.hmsRecEngineCost = response.hmsRecEngineCost;
    }

    /* renamed from: a */
    public void m45983a(DATA data) {
        this.data = data;
    }

    /* renamed from: a */
    public void m45984a(String str) {
        this.exception1 = str;
    }

    /* renamed from: a */
    public void m45985a(Throwable th2) {
        if (th2 == null) {
            return;
        }
        this.exception = th2.getClass().getSimpleName() + ":" + th2.getMessage();
        this.throwable = th2;
    }

    /* renamed from: a */
    public void m45986a(boolean z10) {
        this.dnserror = z10;
    }
}
