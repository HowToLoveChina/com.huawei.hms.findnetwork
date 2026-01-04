package com.huawei.hms.locationSdk;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.locationSdk.q */
/* loaded from: classes8.dex */
public class C5746q {

    /* renamed from: a */
    @SerializedName("TopCnOSvCount")
    private int f25556a;

    /* renamed from: b */
    @SerializedName("StatusCacheTime")
    private int f25557b;

    /* renamed from: c */
    @SerializedName("GnssExceptionInterval")
    private int f25558c;

    /* renamed from: d */
    @SerializedName("MaxGnssExceptionCount")
    private int f25559d;

    /* renamed from: e */
    @SerializedName("GnssExceptionTimeOut")
    private int f25560e;

    /* renamed from: f */
    @SerializedName("GnssExceptionReportType")
    private int f25561f;

    /* renamed from: g */
    @SerializedName("GnssExceptionReportPkg")
    private List<String> f25562g;

    /* renamed from: a */
    public int m33143a() {
        return this.f25558c;
    }

    /* renamed from: b */
    public List<String> m33144b() {
        return this.f25562g;
    }

    /* renamed from: c */
    public int m33145c() {
        return this.f25561f;
    }

    /* renamed from: d */
    public int m33146d() {
        return this.f25560e;
    }

    /* renamed from: e */
    public int m33147e() {
        return this.f25559d;
    }

    /* renamed from: f */
    public int m33148f() {
        return this.f25557b;
    }

    /* renamed from: g */
    public int m33149g() {
        return this.f25556a;
    }

    /* renamed from: h */
    public void m33150h() {
        this.f25556a = 10;
        this.f25557b = 30;
        this.f25558c = 60;
        this.f25559d = 5;
        this.f25560e = 5;
        this.f25561f = 1;
        ArrayList arrayList = new ArrayList();
        this.f25562g = arrayList;
        arrayList.add(LocationRequestHelper.PETAL_MAPS_PACKAGE_NAME);
        this.f25562g.add(LocationRequestHelper.PETAL_MAPS_CAR_PACKAGE_NAME);
        this.f25562g.add("com.huawei.Locationsample6");
    }

    public String toString() {
        return "GnssExceptionConfigBean{topCnOSvCount=" + this.f25556a + ", statusCacheTime=" + this.f25557b + ", gnssExceptionInterval=" + this.f25558c + ", maxGnssExceptionCount=" + this.f25559d + ", gnssExceptionTimeOut=" + this.f25560e + ", gnssExceptionReportType=" + this.f25561f + ", gnssExceptionReportPkg=" + this.f25562g + '}';
    }
}
