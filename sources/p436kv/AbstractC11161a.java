package p436kv;

import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.LinkedHashMap;

/* renamed from: kv.a */
/* loaded from: classes9.dex */
public abstract class AbstractLinkHashMap implements interfaceLinkHashMap {

    /* renamed from: a */
    public long f52501a;

    /* renamed from: b */
    public long f52502b;

    /* renamed from: c */
    public int f52503c = 6;

    /* renamed from: d */
    public LinkedHashMap<String, String> hashmap = new LinkedHashMap<>();

    /* renamed from: b */
    public AbstractLinkHashMap putApiName(String str) {
        this.hashmap.put("apiName", str);
        return this;
    }

    @Override // p436kv.interfaceLinkHashMap
    public LinkedHashMap<String, String> build() {
        return this.hashmap;
    }

    /* renamed from: c */
    public AbstractLinkHashMap putAppId(String str) {
        this.hashmap.put("appId", str);
        return this;
    }

    /* renamed from: d */
    public AbstractLinkHashMap putCallTime() {
        long jNanoTime = System.nanoTime();
        this.f52501a = jNanoTime;
        this.f52502b = jNanoTime;
        this.hashmap.put("callTime", String.valueOf(System.currentTimeMillis()));
        return this;
    }

    /* renamed from: e */
    public AbstractLinkHashMap putUnionCostTime() {
        this.hashmap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf((System.nanoTime() - this.f52501a) / 1000000));
        return this;
    }

    /* renamed from: f */
    public AbstractLinkHashMap putErrorMessageInfo(String str) {
        this.hashmap.put(C2126b.ERROR_MESSAGE_INFO, str);
        return this;
    }

    /* renamed from: g */
    public AbstractLinkHashMap putPackageName(String str) {
        this.hashmap.put("packageName", str);
        return this;
    }

    /* renamed from: h */
    public AbstractLinkHashMap putStatusCode(int i10) {
        this.hashmap.put("statusCode", String.valueOf(i10));
        return this;
    }

    /* renamed from: i */
    public AbstractLinkHashMap putTransId(String str) {
        this.hashmap.put("transId", str);
        return this;
    }

    /* renamed from: j */
    public AbstractLinkHashMap putVersion(String str) {
        this.hashmap.put("version", str);
        return this;
    }
}
