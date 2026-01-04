package p436kv;

import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.LinkedHashMap;

/* renamed from: kv.a */
/* loaded from: classes9.dex */
public abstract class AbstractC11161a implements InterfaceC11162b {

    /* renamed from: a */
    public long f52501a;

    /* renamed from: b */
    public long f52502b;

    /* renamed from: c */
    public int f52503c = 6;

    /* renamed from: d */
    public LinkedHashMap<String, String> f52504d = new LinkedHashMap<>();

    /* renamed from: b */
    public AbstractC11161a m67097b(String str) {
        this.f52504d.put("apiName", str);
        return this;
    }

    @Override // p436kv.InterfaceC11162b
    public LinkedHashMap<String, String> build() {
        return this.f52504d;
    }

    /* renamed from: c */
    public AbstractC11161a m67098c(String str) {
        this.f52504d.put("appId", str);
        return this;
    }

    /* renamed from: d */
    public AbstractC11161a m67099d() {
        long jNanoTime = System.nanoTime();
        this.f52501a = jNanoTime;
        this.f52502b = jNanoTime;
        this.f52504d.put("callTime", String.valueOf(System.currentTimeMillis()));
        return this;
    }

    /* renamed from: e */
    public AbstractC11161a m67100e() {
        this.f52504d.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf((System.nanoTime() - this.f52501a) / 1000000));
        return this;
    }

    /* renamed from: f */
    public AbstractC11161a m67101f(String str) {
        this.f52504d.put(C2126b.ERROR_MESSAGE_INFO, str);
        return this;
    }

    /* renamed from: g */
    public AbstractC11161a m67102g(String str) {
        this.f52504d.put("packageName", str);
        return this;
    }

    /* renamed from: h */
    public AbstractC11161a m67103h(int i10) {
        this.f52504d.put("statusCode", String.valueOf(i10));
        return this;
    }

    /* renamed from: i */
    public AbstractC11161a m67104i(String str) {
        this.f52504d.put("transId", str);
        return this;
    }

    /* renamed from: j */
    public AbstractC11161a m67105j(String str) {
        this.f52504d.put("version", str);
        return this;
    }
}
