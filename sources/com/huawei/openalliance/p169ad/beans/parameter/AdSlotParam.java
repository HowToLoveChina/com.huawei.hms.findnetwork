package com.huawei.openalliance.p169ad.beans.parameter;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7556oq;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.LocationSwitches;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.metadata.Video;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@OuterVisible
/* loaded from: classes8.dex */
public class AdSlotParam {
    private static final String TAG = "AdSlotParam";
    private Integer adHeight;
    private List<String> adIds;
    private int adType;
    private Integer adWidth;
    private Integer allowMobileTraffic;
    private App appInfo;
    private Integer bannerRefFlag;
    private String contentBundle;

    @InterfaceC6934f
    private Map<String, String> contentBundleMap;
    private List<String> detailedCreativeTypeList;
    private int deviceType;
    private Integer endMode;
    private Map<String, Integer> fcFlagMap;
    private int grpIdCode;
    private int height;
    private boolean isPreload;
    private Integer isSmart;
    private Boolean isTrackLimited;
    private String jssdkVersion;
    private Integer linkedMode;
    private Location location;
    private LocationSwitches locationSwitches;
    private int maxCount;
    private String oaid;
    private int orientation;
    private String requestId;
    private RequestOptions requestOptions;
    private String requestSequence;
    private Integer requestType;
    private Integer splashStartMode;
    private Integer splashType;
    private boolean supportTptAd;
    private boolean test;
    private int totalDuration;
    private String uiEngineVer;
    private Map<String, Integer> unsupportedTags;
    private Video video;
    private int width;
    private Integer wlacStatus;

    @OuterVisible
    public static final class Builder {
        private Integer adHeight;
        private int adType;
        private Integer adWidth;
        private Integer allowMobileTraffic;
        private Integer bannerRefFlag;
        private String contentBundle;
        private Map<String, String> contentBundleMap;
        private List<String> detailedCreativeTypeList;
        private Integer endMode;
        private Integer isSmart;
        private Boolean isTrackLimited;
        private String jssdkVersion;
        private Integer linkedMode;
        private android.location.Location location;
        private int maxCount;
        private String oaid;
        private String requestId;
        private RequestOptions requestOptions;
        private String requestSequence;
        private Integer requestType;
        private String searchTerm;
        private int totalDuration;
        private Map<String, Integer> unsupportedTags;
        private Video video;
        private List<String> adIds = new ArrayList(0);
        private int orientation = 1;
        private boolean test = false;
        private int deviceType = 4;
        private int width = 0;
        private int height = 0;
        private boolean isPreload = false;
        private boolean supportTptAd = false;

        /* renamed from: a */
        public Location m40704a() {
            android.location.Location location = this.location;
            if (location == null) {
                return null;
            }
            return new Location(Double.valueOf(location.getLongitude()), Double.valueOf(this.location.getLatitude()));
        }

        @OuterVisible
        public AdSlotParam build() {
            return new AdSlotParam(this);
        }

        /* renamed from: c */
        public void m40710c(Integer num) {
            this.requestType = num;
        }

        @OuterVisible
        public Builder setAdHeight(Integer num) {
            this.adHeight = num;
            return this;
        }

        @OuterVisible
        public Builder setAdIds(List<String> list) {
            this.adIds = list;
            return this;
        }

        @OuterVisible
        public Builder setAdWidth(Integer num) {
            this.adWidth = num;
            return this;
        }

        @OuterVisible
        public Builder setContentBundle(String str) {
            Map<String, String> map = (Map) AbstractC7758be.m47739b(str, Map.class, new Class[0]);
            if (C7765bl.m47802a(map)) {
                AbstractC7185ho.m43823c(AdSlotParam.TAG, "contentBundle info is empty or not json string");
            } else {
                String strM40616c = AdSlotParam.m40616c(map);
                this.contentBundleMap = map;
                this.contentBundle = strM40616c;
            }
            return this;
        }

        @OuterVisible
        public Builder setDetailedCreativeTypeList(List<Integer> list) {
            if (list == null) {
                return this;
            }
            if (list.size() > 100) {
                list = list.subList(0, 100);
            }
            this.detailedCreativeTypeList = new ArrayList(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                this.detailedCreativeTypeList.add(Integer.toString(it.next().intValue()));
            }
            return this;
        }

        @OuterVisible
        public Builder setDeviceType(int i10) {
            this.deviceType = i10;
            return this;
        }

        @OuterVisible
        public Builder setEndMode(Integer num) {
            this.endMode = num;
            return this;
        }

        @OuterVisible
        public Builder setHeight(int i10) {
            this.height = i10;
            return this;
        }

        @OuterVisible
        public Builder setIsPreload(Boolean bool) {
            this.isPreload = bool.booleanValue();
            return this;
        }

        @OuterVisible
        public Builder setLinkedMode(Integer num) {
            this.linkedMode = num;
            return this;
        }

        @OuterVisible
        public Builder setLocation(android.location.Location location) {
            this.location = location;
            return this;
        }

        @OuterVisible
        public Builder setMaxCount(int i10) {
            this.maxCount = i10;
            return this;
        }

        @OuterVisible
        public Builder setOaid(String str) {
            this.oaid = str;
            return this;
        }

        @OuterVisible
        public Builder setOrientation(int i10) {
            this.orientation = i10;
            return this;
        }

        @OuterVisible
        public Builder setRequestOptions(RequestOptions requestOptions) {
            this.requestOptions = requestOptions;
            return this;
        }

        @OuterVisible
        public Builder setRequestSequence(String str) {
            this.requestSequence = str;
            return this;
        }

        @OuterVisible
        public Builder setSearchTerm(String str) {
            this.searchTerm = str;
            return this;
        }

        @OuterVisible
        public Builder setTest(boolean z10) {
            this.test = z10;
            return this;
        }

        @OuterVisible
        public Builder setTotalDuration(int i10) {
            this.totalDuration = i10;
            return this;
        }

        @OuterVisible
        public Builder setTrackLimited(Boolean bool) {
            this.isTrackLimited = bool;
            return this;
        }

        @OuterVisible
        public Builder setUnsupportedTags(Map<String, Integer> map) {
            this.unsupportedTags = map;
            return this;
        }

        @OuterVisible
        public Builder setWidth(int i10) {
            this.width = i10;
            return this;
        }

        /* renamed from: a */
        public Builder m40705a(Integer num) {
            this.bannerRefFlag = num;
            return this;
        }

        /* renamed from: b */
        public Builder m40709b(Integer num) {
            this.isSmart = num;
            return this;
        }

        /* renamed from: a */
        public Builder m40706a(String str) {
            this.jssdkVersion = str;
            return this;
        }

        /* renamed from: a */
        public Builder m40707a(boolean z10) {
            this.supportTptAd = z10;
            return this;
        }

        /* renamed from: a */
        public void m40708a(Video video) {
            this.video = video;
        }
    }

    @OuterVisible
    public AdSlotParam() {
        this.isPreload = false;
        this.supportTptAd = false;
    }

    /* renamed from: c */
    public static String m40616c(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new ImpEX(entry.getKey(), AbstractC7806cz.m48170d(entry.getValue())));
        }
        HashMap map2 = new HashMap();
        map2.put("contentBundle", arrayList);
        return AbstractC7758be.m47742b(map2);
    }

    /* renamed from: A */
    public boolean m40617A() {
        return this.supportTptAd;
    }

    /* renamed from: B */
    public String m40618B() {
        return this.jssdkVersion;
    }

    /* renamed from: C */
    public Integer m40619C() {
        return this.requestType;
    }

    /* renamed from: D */
    public int m40620D() {
        return this.adType;
    }

    /* renamed from: E */
    public int m40621E() {
        return this.grpIdCode;
    }

    /* renamed from: F */
    public Integer m40622F() {
        return this.endMode;
    }

    /* renamed from: G */
    public Map<String, Integer> m40623G() {
        return this.unsupportedTags;
    }

    /* renamed from: H */
    public Map<String, Integer> m40624H() {
        Map<String, Integer> map = this.fcFlagMap;
        return map != null ? map : new HashMap();
    }

    /* renamed from: I */
    public AdSlotParam m40625I() {
        AdSlotParam adSlotParam = new AdSlotParam();
        adSlotParam.adIds = this.adIds;
        adSlotParam.orientation = this.orientation;
        adSlotParam.test = this.test;
        adSlotParam.deviceType = this.deviceType;
        adSlotParam.width = this.width;
        adSlotParam.height = this.height;
        adSlotParam.requestSequence = this.requestSequence;
        adSlotParam.oaid = this.oaid;
        adSlotParam.isTrackLimited = this.isTrackLimited;
        adSlotParam.appInfo = this.appInfo;
        adSlotParam.video = this.video;
        adSlotParam.isPreload = this.isPreload;
        adSlotParam.requestOptions = this.requestOptions;
        adSlotParam.location = this.location;
        adSlotParam.maxCount = this.maxCount;
        adSlotParam.allowMobileTraffic = this.allowMobileTraffic;
        adSlotParam.linkedMode = this.linkedMode;
        adSlotParam.totalDuration = this.totalDuration;
        adSlotParam.splashType = this.splashType;
        adSlotParam.splashStartMode = this.splashStartMode;
        adSlotParam.locationSwitches = this.locationSwitches;
        adSlotParam.bannerRefFlag = this.bannerRefFlag;
        adSlotParam.detailedCreativeTypeList = this.detailedCreativeTypeList;
        adSlotParam.isSmart = this.isSmart;
        adSlotParam.adWidth = this.adWidth;
        adSlotParam.adHeight = this.adHeight;
        adSlotParam.adType = this.adType;
        adSlotParam.requestType = this.requestType;
        adSlotParam.contentBundle = this.contentBundle;
        adSlotParam.contentBundleMap = this.contentBundleMap;
        adSlotParam.endMode = this.endMode;
        adSlotParam.unsupportedTags = this.unsupportedTags;
        adSlotParam.supportTptAd = this.supportTptAd;
        adSlotParam.uiEngineVer = this.uiEngineVer;
        adSlotParam.jssdkVersion = this.jssdkVersion;
        return adSlotParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public String m40626a(Context context, int i10) {
        Map<String, String> map;
        if (C7124fh.m43316b(context).mo43054ab() && i10 != 1 && i10 != 18) {
            String strM46408a = C7556oq.m46397a(context).m46408a();
            Map map2 = (Map) AbstractC7758be.m47739b(strM46408a, Map.class, new Class[0]);
            if (!C7765bl.m47802a(map2) && !C7765bl.m47802a(this.contentBundleMap)) {
                AbstractC7185ho.m43820b(TAG, "merge auto content Bundle");
                for (Map.Entry entry : map2.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (!this.contentBundleMap.containsKey(str) && !AbstractC7806cz.m48165b(str2)) {
                        this.contentBundleMap.put(str, map2.get(str));
                    }
                }
                if (this.contentBundleMap.containsKey("content") && this.contentBundleMap.containsKey(Constants.AUTOCONTENT_CONTENT_AUTO)) {
                    this.contentBundleMap.remove(Constants.AUTOCONTENT_CONTENT_AUTO);
                }
                map = this.contentBundleMap;
            } else if (!C7765bl.m47802a(map2)) {
                AbstractC7185ho.m43820b(TAG, "set auto content Bundle");
                map = (Map) AbstractC7758be.m47739b(strM46408a, Map.class, new Class[0]);
                if (C7765bl.m47802a(map)) {
                    AbstractC7185ho.m43823c(TAG, "auto contentBundle info is empty or not json string");
                }
            }
            this.contentBundle = m40616c(map);
        }
        return this.contentBundle;
    }

    /* renamed from: b */
    public int m40639b() {
        return this.orientation;
    }

    /* renamed from: d */
    public int m40647d() {
        return this.deviceType;
    }

    /* renamed from: e */
    public int m40650e() {
        return this.width;
    }

    /* renamed from: f */
    public int m40653f() {
        return this.height;
    }

    /* renamed from: g */
    public String m40654g() {
        return this.oaid;
    }

    /* renamed from: h */
    public Boolean m40655h() {
        return this.isTrackLimited;
    }

    /* renamed from: i */
    public App m40656i() {
        return this.appInfo;
    }

    /* renamed from: j */
    public boolean m40657j() {
        return this.isPreload;
    }

    /* renamed from: k */
    public Location m40658k() {
        return this.location;
    }

    /* renamed from: l */
    public RequestOptions m40659l() {
        return this.requestOptions;
    }

    /* renamed from: m */
    public int m40660m() {
        return this.maxCount;
    }

    /* renamed from: n */
    public int m40661n() {
        return this.totalDuration;
    }

    /* renamed from: o */
    public Integer m40662o() {
        return this.allowMobileTraffic;
    }

    /* renamed from: p */
    public Integer m40663p() {
        return this.linkedMode;
    }

    /* renamed from: q */
    public Integer m40664q() {
        return this.splashType;
    }

    /* renamed from: r */
    public Integer m40665r() {
        return this.splashStartMode;
    }

    /* renamed from: s */
    public String m40666s() {
        return this.requestId;
    }

    /* renamed from: t */
    public Integer m40667t() {
        return this.bannerRefFlag;
    }

    /* renamed from: u */
    public LocationSwitches m40668u() {
        return this.locationSwitches;
    }

    /* renamed from: v */
    public List<String> m40669v() {
        return this.detailedCreativeTypeList;
    }

    /* renamed from: w */
    public Integer m40670w() {
        return this.wlacStatus;
    }

    /* renamed from: x */
    public Integer m40671x() {
        return this.isSmart;
    }

    /* renamed from: y */
    public Integer m40672y() {
        return this.adWidth;
    }

    /* renamed from: z */
    public Integer m40673z() {
        return this.adHeight;
    }

    @OuterVisible
    private AdSlotParam(Builder builder) {
        this.isPreload = false;
        this.supportTptAd = false;
        this.adIds = builder.adIds;
        this.orientation = builder.orientation;
        this.test = builder.test;
        this.deviceType = builder.deviceType;
        this.width = builder.width;
        this.height = builder.height;
        this.requestSequence = builder.requestSequence;
        this.oaid = builder.oaid;
        this.isTrackLimited = builder.isTrackLimited;
        this.video = builder.video;
        this.isPreload = builder.isPreload;
        this.requestOptions = builder.requestOptions;
        this.location = builder.m40704a();
        this.maxCount = builder.maxCount;
        this.allowMobileTraffic = builder.allowMobileTraffic;
        this.linkedMode = builder.linkedMode;
        this.totalDuration = builder.totalDuration;
        this.requestId = builder.requestId;
        this.bannerRefFlag = builder.bannerRefFlag;
        this.detailedCreativeTypeList = builder.detailedCreativeTypeList;
        this.isSmart = builder.isSmart;
        this.adWidth = builder.adWidth;
        this.adHeight = builder.adHeight;
        this.requestType = builder.requestType;
        this.contentBundle = builder.contentBundle;
        this.contentBundleMap = builder.contentBundleMap;
        this.adType = builder.adType;
        this.endMode = builder.endMode;
        this.unsupportedTags = builder.unsupportedTags;
        this.supportTptAd = builder.supportTptAd;
        this.jssdkVersion = builder.jssdkVersion;
    }

    /* renamed from: a */
    public List<String> m40627a() {
        return this.adIds;
    }

    /* renamed from: c */
    public void m40643c(int i10) {
        this.height = i10;
    }

    /* renamed from: d */
    public void m40648d(int i10) {
        this.adType = i10;
    }

    /* renamed from: e */
    public void m40651e(int i10) {
        this.grpIdCode = i10;
    }

    public /* synthetic */ AdSlotParam(Builder builder, C69591 c69591) {
        this(builder);
    }

    /* renamed from: a */
    public void m40628a(int i10) {
        this.deviceType = i10;
    }

    /* renamed from: b */
    public void m40640b(int i10) {
        this.width = i10;
    }

    /* renamed from: c */
    public void m40644c(Integer num) {
        this.splashType = num;
    }

    /* renamed from: d */
    public void m40649d(Integer num) {
        this.splashStartMode = num;
    }

    /* renamed from: e */
    public void m40652e(Integer num) {
        this.wlacStatus = num;
    }

    /* renamed from: a */
    public void m40629a(LocationSwitches locationSwitches) {
        this.locationSwitches = locationSwitches;
    }

    /* renamed from: b */
    public void m40641b(Integer num) {
        this.linkedMode = num;
    }

    /* renamed from: c */
    public void m40645c(String str) {
        this.uiEngineVer = str;
    }

    /* renamed from: a */
    public void m40630a(App app) {
        this.appInfo = app;
    }

    /* renamed from: b */
    public void m40642b(String str) {
        this.requestId = str;
    }

    /* renamed from: c */
    public boolean m40646c() {
        return this.test;
    }

    /* renamed from: a */
    public void m40631a(Location location) {
        this.location = location;
    }

    /* renamed from: a */
    public void m40632a(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }

    /* renamed from: a */
    public void m40633a(Boolean bool) {
        this.isTrackLimited = bool;
    }

    /* renamed from: a */
    public void m40634a(Integer num) {
        this.allowMobileTraffic = num;
    }

    /* renamed from: a */
    public void m40635a(String str) {
        this.oaid = str;
    }

    /* renamed from: a */
    public void m40636a(List<String> list) {
        this.adIds = list;
    }

    /* renamed from: a */
    public void m40637a(Map<String, Integer> map) {
        this.fcFlagMap = map;
    }

    /* renamed from: a */
    public void m40638a(boolean z10) {
        this.isPreload = z10;
    }
}
