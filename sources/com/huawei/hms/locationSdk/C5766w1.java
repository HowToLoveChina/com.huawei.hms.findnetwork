package com.huawei.hms.locationSdk;

import com.huawei.hms.locationSdk.AbstractC5763v1;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.locationSdk.w1 */
/* loaded from: classes8.dex */
public class C5766w1<T extends AbstractC5763v1> {

    /* renamed from: a */
    private List<T> f25595a = new ArrayList(10);

    /* renamed from: a */
    public void m33192a(T t10) {
        if (t10 == null) {
            return;
        }
        if (this.f25595a == null) {
            this.f25595a = new ArrayList();
        }
        HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "list to add size is:" + this.f25595a.size());
        if (m33193b(t10) != null) {
            HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "this request is included");
        } else {
            HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "add request");
            this.f25595a.add(t10);
        }
    }

    /* renamed from: b */
    public T m33193b(T t10) {
        if (t10 != null && !CollectionsUtil.isEmpty(this.f25595a)) {
            HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "list to find size is:" + this.f25595a.size());
            for (int i10 = 0; i10 < this.f25595a.size(); i10++) {
                T t11 = this.f25595a.get(i10);
                if (t11 != null && t11.equals(t10)) {
                    HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "find tid in list, tid:" + t11.m33186a());
                    return t11;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public boolean mo33194c(T t10) {
        if (t10 != null && !CollectionsUtil.isEmpty(this.f25595a)) {
            for (T t11 : this.f25595a) {
                if (t11.equals(t10)) {
                    HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "remove request from list");
                    this.f25595a.remove(t11);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public void mo33195d(T t10) {
        if (t10 == null) {
            return;
        }
        if (this.f25595a.isEmpty()) {
            HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "replaceRequestCache add Request");
            this.f25595a.add(t10);
            return;
        }
        HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "list to replace size is:" + this.f25595a.size());
        for (int i10 = 0; i10 < this.f25595a.size(); i10++) {
            T t11 = this.f25595a.get(i10);
            if (t11 != null && t11.equals(t10)) {
                HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "replace old tid is " + t11.m33186a() + ". new tid is " + t10.m33186a());
                this.f25595a.set(i10, t10);
                return;
            }
        }
        this.f25595a.add(t10);
        HMSLocationLog.m36662i("TidCacheManager", t10.m33186a(), "replaceRequestCache add Request.");
    }

    /* renamed from: a */
    public List<T> m33191a() {
        return this.f25595a;
    }
}
