package com.huawei.openalliance.p169ad.beans.inner;

import com.huawei.openalliance.p169ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import java.util.List;

/* loaded from: classes8.dex */
public class AdRequestParam {
    private AdSlotParam adSlotParam;
    private int adType;
    private List<String> cachedContentIds;
    private List<String> cachedSloganIds;
    private List<String> cachedTemplateIds;
    private List<String> removedContentIds;
    private String requestId;
    private long requestTime;
    private AdTimeStatistics timeStatistics;

    public static class Builder {
        private AdSlotParam adSlotParam;
        private int adType;
        private List<String> cachedContentIds;
        private List<String> cachedSloganIds;
        private List<String> cachedTemplateIds;
        private List<String> removedContentIds;
        private String requestId;
        private long requestTime;
        private AdTimeStatistics timeStatistics;

        /* renamed from: a */
        public Builder m39345a(int i10) {
            this.adType = i10;
            return this;
        }

        /* renamed from: b */
        public Builder m39350b(List<String> list) {
            this.cachedSloganIds = list;
            return this;
        }

        /* renamed from: c */
        public Builder m39351c(List<String> list) {
            this.cachedTemplateIds = list;
            return this;
        }

        /* renamed from: d */
        public Builder m39352d(List<String> list) {
            this.removedContentIds = list;
            return this;
        }

        /* renamed from: a */
        public Builder m39346a(AdSlotParam adSlotParam) {
            this.adSlotParam = adSlotParam;
            return this;
        }

        /* renamed from: a */
        public Builder m39347a(String str) {
            this.requestId = str;
            return this;
        }

        /* renamed from: a */
        public Builder m39348a(List<String> list) {
            this.cachedContentIds = list;
            return this;
        }

        /* renamed from: a */
        public AdRequestParam m39349a() {
            AdRequestParam adRequestParam = new AdRequestParam();
            adRequestParam.adType = this.adType;
            adRequestParam.adSlotParam = this.adSlotParam;
            adRequestParam.cachedContentIds = this.cachedContentIds;
            adRequestParam.cachedSloganIds = this.cachedSloganIds;
            adRequestParam.cachedTemplateIds = this.cachedTemplateIds;
            adRequestParam.removedContentIds = this.removedContentIds;
            adRequestParam.requestId = this.requestId;
            adRequestParam.requestTime = this.requestTime;
            adRequestParam.timeStatistics = this.timeStatistics;
            return adRequestParam;
        }
    }

    private AdRequestParam() {
    }

    /* renamed from: a */
    public int m39333a() {
        return this.adType;
    }

    /* renamed from: b */
    public AdSlotParam m39337b() {
        return this.adSlotParam;
    }

    /* renamed from: c */
    public List<String> m39338c() {
        return this.cachedContentIds;
    }

    /* renamed from: d */
    public List<String> m39339d() {
        return this.cachedSloganIds;
    }

    /* renamed from: e */
    public List<String> m39340e() {
        return this.cachedTemplateIds;
    }

    /* renamed from: f */
    public List<String> m39341f() {
        return this.removedContentIds;
    }

    /* renamed from: g */
    public String m39342g() {
        return this.requestId;
    }

    /* renamed from: h */
    public long m39343h() {
        return this.requestTime;
    }

    /* renamed from: i */
    public AdTimeStatistics m39344i() {
        return this.timeStatistics;
    }

    /* renamed from: a */
    public void m39334a(long j10) {
        this.requestTime = j10;
    }

    /* renamed from: a */
    public void m39335a(AdTimeStatistics adTimeStatistics) {
        this.timeStatistics = adTimeStatistics;
    }

    /* renamed from: a */
    public void m39336a(String str) {
        this.requestId = str;
    }
}
