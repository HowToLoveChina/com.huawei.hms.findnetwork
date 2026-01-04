package com.huawei.openalliance.p169ad.beans.parameter;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEXs;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@OuterVisible
/* loaded from: classes8.dex */
public class RequestOptions {

    @OuterVisible
    public static final String AD_CONTENT_CLASSIFICATION_A = "A";

    @OuterVisible
    public static final String AD_CONTENT_CLASSIFICATION_J = "J";

    @OuterVisible
    public static final String AD_CONTENT_CLASSIFICATION_PI = "PI";

    @OuterVisible
    public static final String AD_CONTENT_CLASSIFICATION_UNSPECIFIED = "";

    @OuterVisible
    public static final String AD_CONTENT_CLASSIFICATION_W = "W";
    private static final String TAG = "RequestOptions";

    @OuterVisible
    public static final int TAG_FOR_CHILD_PROTECTION_FALSE = 0;

    @OuterVisible
    public static final int TAG_FOR_CHILD_PROTECTION_TRUE = 1;

    @OuterVisible
    public static final int TAG_FOR_CHILD_PROTECTION_UNSPECIFIED = -1;

    @OuterVisible
    public static final int TAG_FOR_UNDER_AGE_OF_PROMISE_FALSE = 0;

    @OuterVisible
    public static final int TAG_FOR_UNDER_AGE_OF_PROMISE_TRUE = 1;

    @OuterVisible
    public static final int TAG_FOR_UNDER_AGE_OF_PROMISE_UNSPECIFIED = -1;
    private String adContentClassification;
    private App app;
    private String appCountry;
    private String appLang;
    private Map<String, BiddingParam> biddingParamMap;
    private String consent;
    private List<String> cur;

    @InterfaceC6934f
    private Map<String, Bundle> extras;
    private Integer hwNonPersonalizedAd;
    private Map<String, ImpEXs> impEXs;
    private Integer isQueryUseEnabled;
    private Integer nonPersonalizedAd;
    private Boolean requestLocation;
    private SearchInfo searchInfo;
    private String searchTerm;
    private Boolean supportFa;
    private Integer tMax;
    private Integer tagForChildProtection;
    private Integer tagForUnderAgeOfPromise;
    private Integer thirdNonPersonalizedAd;
    private boolean useConsentNpa;

    @OuterVisible
    public static class Builder {
        private App app;
        private String appCountry;
        private String appLang;
        private String consent;
        private List<String> cur;
        private Map<String, Bundle> extras;
        private Boolean requestLocation;
        private SearchInfo searchInfo;
        private String searchTerm;
        private Boolean supportFa;
        private Integer tMax;
        private Integer tagForChildProtection;
        private Integer tagForUnderAgeOfPromise;
        private String adContentClassification = null;
        private Integer nonPersonalizedAd = null;
        private Integer isQueryUseEnabled = null;
        private Integer hwNonPersonalizedAd = null;
        private Integer thirdNonPersonalizedAd = null;
        private Map<String, BiddingParam> biddingParamMap = new HashMap();
        private boolean useConsentNpa = true;

        @OuterVisible
        public Builder() {
        }

        @OuterVisible
        public Builder addBiddingParamMap(String str, BiddingParam biddingParam) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.biddingParamMap.put(str, biddingParam);
            return this;
        }

        @OuterVisible
        public RequestOptions build() {
            return new RequestOptions(this);
        }

        @OuterVisible
        public Builder setAdContentClassification(String str) {
            if (str != null && !"".equals(str)) {
                if (!"W".equals(str) && !RequestOptions.AD_CONTENT_CLASSIFICATION_PI.equals(str) && !RequestOptions.AD_CONTENT_CLASSIFICATION_J.equals(str) && !"A".equals(str)) {
                    AbstractC7185ho.m43818a(RequestOptions.TAG, "Invalid value for setAdContentClassification: %s", str);
                }
                return this;
            }
            str = null;
            this.adContentClassification = str;
            return this;
        }

        @OuterVisible
        public Builder setApp(App app) {
            this.app = app;
            return this;
        }

        @OuterVisible
        public Builder setAppCountry(String str) {
            if (TextUtils.isEmpty(str)) {
                AbstractC7185ho.m43826d(RequestOptions.TAG, "Invalid value setAppLang");
            } else {
                this.appCountry = str;
            }
            return this;
        }

        @OuterVisible
        public Builder setAppLang(String str) {
            if (TextUtils.isEmpty(str)) {
                AbstractC7185ho.m43826d(RequestOptions.TAG, "Invalid value setAppLang");
            } else {
                this.appLang = str;
            }
            return this;
        }

        @OuterVisible
        public Builder setBiddingParamMap(Map<String, BiddingParam> map) {
            if (map == null) {
                return null;
            }
            this.biddingParamMap = map;
            return this;
        }

        @OuterVisible
        public Builder setConsent(String str) {
            this.consent = str;
            return this;
        }

        @OuterVisible
        public Builder setCur(List<String> list) {
            if (!AbstractC7760bg.m47767a(list)) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC7806cz.m48170d(it.next()));
                }
                this.cur = arrayList;
            }
            return this;
        }

        @OuterVisible
        public Builder setExtras(Map<String, Bundle> map) {
            this.extras = map;
            return this;
        }

        @OuterVisible
        public Builder setHwNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.hwNonPersonalizedAd = num;
            } else {
                AbstractC7185ho.m43826d(RequestOptions.TAG, "Invalid value passed to setHwNonPersonalizedAd: " + num);
            }
            return this;
        }

        @OuterVisible
        public Builder setIsQueryUseEnabled(Integer num) {
            if (num == null || num.intValue() == 0 || 1 == num.intValue()) {
                this.isQueryUseEnabled = num;
            } else {
                AbstractC7185ho.m43826d(RequestOptions.TAG, "Invalid value passed to setIsQueryUseEnabled: " + num);
            }
            return this;
        }

        @OuterVisible
        public Builder setNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.nonPersonalizedAd = num;
            } else {
                AbstractC7185ho.m43826d(RequestOptions.TAG, "Invalid value passed to setNonPersonalizedAd: " + num);
            }
            return this;
        }

        @OuterVisible
        public Builder setRequestLocation(Boolean bool) {
            this.requestLocation = bool;
            return this;
        }

        @OuterVisible
        public Builder setSearchInfo(SearchInfo searchInfo) {
            this.searchInfo = searchInfo;
            return this;
        }

        @OuterVisible
        public Builder setSearchTerm(String str) {
            if (TextUtils.isEmpty(str)) {
                AbstractC7185ho.m43826d(RequestOptions.TAG, "Invalid value setSearchTerm");
            } else {
                this.searchTerm = str;
            }
            return this;
        }

        @OuterVisible
        public Builder setSupportFa(Boolean bool) {
            this.supportFa = bool;
            return this;
        }

        @OuterVisible
        public Builder setTMax(Integer num) {
            this.tMax = num;
            return this;
        }

        @OuterVisible
        public Builder setTagForChildProtection(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.tagForChildProtection = num;
            } else {
                AbstractC7185ho.m43818a(RequestOptions.TAG, "Invalid value for setTagForChildProtection: %d", num);
            }
            return this;
        }

        @OuterVisible
        public Builder setTagForUnderAgeOfPromise(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.tagForUnderAgeOfPromise = num;
            } else {
                AbstractC7185ho.m43818a(RequestOptions.TAG, "Invalid value for setTagForUnderAgeOfPromise: %d", num);
            }
            return this;
        }

        @OuterVisible
        public Builder setThirdNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.thirdNonPersonalizedAd = num;
            } else {
                AbstractC7185ho.m43826d(RequestOptions.TAG, "Invalid value passed to setThirdNonPersonalizedAd: " + num);
            }
            return this;
        }

        @OuterVisible
        public Builder setUseConsentNpa(boolean z10) {
            this.useConsentNpa = z10;
            return this;
        }
    }

    public RequestOptions() {
        this.nonPersonalizedAd = null;
        this.isQueryUseEnabled = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
        this.biddingParamMap = new HashMap();
        this.useConsentNpa = true;
    }

    /* renamed from: a */
    public String m40721a() {
        return this.adContentClassification;
    }

    /* renamed from: b */
    public Integer m40722b() {
        return this.hwNonPersonalizedAd;
    }

    /* renamed from: c */
    public Integer m40723c() {
        return this.thirdNonPersonalizedAd;
    }

    /* renamed from: d */
    public Boolean m40724d() {
        return this.requestLocation;
    }

    /* renamed from: e */
    public List<String> m40725e() {
        return this.cur;
    }

    /* renamed from: f */
    public SearchInfo m40726f() {
        return this.searchInfo;
    }

    /* renamed from: g */
    public Boolean m40727g() {
        return this.supportFa;
    }

    @OuterVisible
    public String getAdContentClassification() {
        String str = this.adContentClassification;
        return str == null ? "" : str;
    }

    @OuterVisible
    public App getApp() {
        return this.app;
    }

    @OuterVisible
    public String getAppCountry() {
        return this.appCountry;
    }

    @OuterVisible
    public String getAppLang() {
        return this.appLang;
    }

    @OuterVisible
    public BiddingParam getBiddingParam(String str) {
        if (this.biddingParamMap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.biddingParamMap.get(str);
    }

    @OuterVisible
    public String getConsent() {
        return this.consent;
    }

    @OuterVisible
    public Map<String, Bundle> getExtras() {
        return this.extras;
    }

    @OuterVisible
    public Integer getIsQueryUseEnabled() {
        return this.isQueryUseEnabled;
    }

    @OuterVisible
    public Integer getNonPersonalizedAd() {
        return this.nonPersonalizedAd;
    }

    @OuterVisible
    public String getSearchTerm() {
        return this.searchTerm;
    }

    @OuterVisible
    public Integer getTMax() {
        return this.tMax;
    }

    @OuterVisible
    public Integer getTagForChildProtection() {
        return this.tagForChildProtection;
    }

    @OuterVisible
    public Integer getTagForUnderAgeOfPromise() {
        return this.tagForUnderAgeOfPromise;
    }

    /* renamed from: h */
    public boolean m40728h() {
        return this.useConsentNpa;
    }

    @OuterVisible
    public boolean isRequestLocation() {
        Boolean bool = this.requestLocation;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @OuterVisible
    public Builder toBuilder() {
        return new Builder().setTagForChildProtection(this.tagForChildProtection).setTagForUnderAgeOfPromise(this.tagForUnderAgeOfPromise).setAdContentClassification(this.adContentClassification).setAppLang(this.appLang).setAppCountry(this.appCountry).setNonPersonalizedAd(this.nonPersonalizedAd).setHwNonPersonalizedAd(this.hwNonPersonalizedAd).setThirdNonPersonalizedAd(this.thirdNonPersonalizedAd).setIsQueryUseEnabled(this.isQueryUseEnabled).setRequestLocation(this.requestLocation).setSearchTerm(this.searchTerm).setExtras(this.extras).setConsent(this.consent).setApp(this.app).setBiddingParamMap(this.biddingParamMap).setTMax(this.tMax).setSearchInfo(this.searchInfo).setSupportFa(this.supportFa).setUseConsentNpa(this.useConsentNpa).setCur(this.cur);
    }

    private RequestOptions(Builder builder) {
        this.nonPersonalizedAd = null;
        this.isQueryUseEnabled = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
        this.biddingParamMap = new HashMap();
        this.useConsentNpa = true;
        this.tagForChildProtection = builder.tagForChildProtection;
        this.tagForUnderAgeOfPromise = builder.tagForUnderAgeOfPromise;
        this.adContentClassification = builder.adContentClassification;
        this.isQueryUseEnabled = builder.isQueryUseEnabled;
        this.nonPersonalizedAd = builder.nonPersonalizedAd;
        this.hwNonPersonalizedAd = builder.hwNonPersonalizedAd;
        this.thirdNonPersonalizedAd = builder.thirdNonPersonalizedAd;
        this.appLang = builder.appLang;
        this.appCountry = builder.appCountry;
        this.requestLocation = builder.requestLocation;
        this.searchTerm = builder.searchTerm;
        Map<String, Bundle> map = builder.extras;
        this.extras = map;
        this.impEXs = m40719a(map);
        this.consent = builder.consent;
        this.app = builder.app;
        this.biddingParamMap = builder.biddingParamMap;
        this.tMax = builder.tMax;
        this.cur = builder.cur;
        this.searchInfo = builder.searchInfo;
        this.supportFa = builder.supportFa;
        this.useConsentNpa = builder.useConsentNpa;
    }

    /* renamed from: a */
    private Map<String, ImpEXs> m40719a(Map<String, Bundle> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap map2 = new HashMap();
        try {
            for (Map.Entry<String, Bundle> entry : map.entrySet()) {
                String key = entry.getKey();
                Bundle value = entry.getValue();
                if (value != null) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : value.keySet()) {
                        arrayList.add(new ImpEX(str, AbstractC7806cz.m48170d(value.getString(str))));
                    }
                    map2.put(key, new ImpEXs(arrayList));
                }
            }
            return map2;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(TAG, "toImpEXs err: %s", th2.getClass().getSimpleName());
            return map2;
        }
    }

    public /* synthetic */ RequestOptions(Builder builder, C69601 c69601) {
        this(builder);
    }
}
