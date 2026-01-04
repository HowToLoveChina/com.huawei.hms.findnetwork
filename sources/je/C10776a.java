package je;

import android.content.Context;
import ca.C1400c;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.cloud.pay.model.AdAppInfo;
import com.huawei.cloud.pay.model.AdImageInfo;
import com.huawei.cloud.pay.model.AdVideoInfo;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p429kk.C11060c;
import p514o9.C11839m;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: je.a */
/* loaded from: classes3.dex */
public class C10776a {
    /* renamed from: a */
    public static AdAppInfo m65605a(AppInfo appInfo, String str) {
        AdAppInfo adAppInfo = new AdAppInfo();
        adAppInfo.setAppDesc(appInfo.getAppDesc());
        adAppInfo.setAppName(appInfo.getAppName());
        adAppInfo.setDownloadUrl(appInfo.getDownloadUrl());
        adAppInfo.setIconUrl(appInfo.getIconUrl());
        adAppInfo.setPackageName(appInfo.getPackageName());
        adAppInfo.setVersionCode(appInfo.getVersionCode());
        adAppInfo.setSafeDownloadUrl(appInfo.getDownloadUrl());
        adAppInfo.setFileSize(appInfo.getFileSize());
        adAppInfo.setSha256(appInfo.getSha256());
        adAppInfo.setIntentUri(appInfo.getIntentUri());
        adAppInfo.setUniqueId(appInfo.getUniqueId());
        adAppInfo.setChannel(str);
        adAppInfo.setDeveloperName(appInfo.getDeveloperName());
        adAppInfo.setVersionName(appInfo.getVersionName());
        adAppInfo.setAppDetailUrl(appInfo.getAppDetailUrl());
        adAppInfo.setPermissionUrl(appInfo.getPermissionUrl());
        adAppInfo.setPrivacyLink(appInfo.getPrivacyLink());
        return adAppInfo;
    }

    /* renamed from: b */
    public static HiCloudNativeAd m65606b(AdInfo adInfo, String str) {
        HiCloudNativeAd hiCloudNativeAd = new HiCloudNativeAd();
        com.huawei.android.hicloud.agd.ads.AdAppInfo appInfo = adInfo.getMaterial().getAppInfo();
        AdAppInfo adAppInfo = new AdAppInfo();
        adAppInfo.setAppName(appInfo.getAppName());
        adAppInfo.setAppDesc(appInfo.getDescription());
        adAppInfo.setUniqueId(appInfo.getAppId());
        adAppInfo.setPackageName(appInfo.getPackageName());
        adAppInfo.setFileSize(appInfo.getSize());
        adAppInfo.setIconUrl(appInfo.getIcon());
        adAppInfo.setDeveloperName(appInfo.getDeveloperName());
        adAppInfo.setVersionName(appInfo.getVersionName());
        adAppInfo.setChannel(str);
        hiCloudNativeAd.setAppInfo(adAppInfo);
        hiCloudNativeAd.setUniqueId(appInfo.getAppId());
        hiCloudNativeAd.setDescription(appInfo.getDescription());
        ArrayList arrayList = new ArrayList();
        AdImageInfo adImageInfo = new AdImageInfo();
        adImageInfo.setUrl(appInfo.getIcon());
        arrayList.add(adImageInfo);
        hiCloudNativeAd.setImageInfos(arrayList);
        return hiCloudNativeAd;
    }

    /* renamed from: c */
    public static HiCloudNativeAd m65607c(INativeAd iNativeAd, String str) {
        if (iNativeAd == null) {
            return null;
        }
        HiCloudNativeAd hiCloudNativeAd = new HiCloudNativeAd();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("AdsUtil", "context null");
            hiCloudNativeAd.setValid(false);
        } else {
            hiCloudNativeAd.setValid(iNativeAd.isValid(contextM1377a));
        }
        hiCloudNativeAd.setExpired(iNativeAd.isExpired());
        hiCloudNativeAd.setCreativeType(iNativeAd.getCreativeType());
        hiCloudNativeAd.setTitle(iNativeAd.getTitle());
        hiCloudNativeAd.setIcon(m65608d(iNativeAd.getIcon()));
        hiCloudNativeAd.setDescription(iNativeAd.getDescription());
        hiCloudNativeAd.setLabel(iNativeAd.getLabel());
        hiCloudNativeAd.setVideoAd(iNativeAd.isVideoAd());
        hiCloudNativeAd.setClicked(iNativeAd.isClicked());
        hiCloudNativeAd.setUniqueId(iNativeAd.getUniqueId());
        hiCloudNativeAd.setAdSign(iNativeAd.getAdSign());
        ArrayList arrayList = new ArrayList();
        Iterator<ImageInfo> it = iNativeAd.getImageInfos().iterator();
        while (it.hasNext()) {
            AdImageInfo adImageInfoM65608d = m65608d(it.next());
            if (adImageInfoM65608d != null) {
                arrayList.add(adImageInfoM65608d);
            }
        }
        hiCloudNativeAd.setImageInfos(arrayList);
        hiCloudNativeAd.setVideoInfo(m65609e(iNativeAd.getVideoInfo()));
        hiCloudNativeAd.setAppInfo(m65605a(iNativeAd.getAppInfo(), str));
        return hiCloudNativeAd;
    }

    /* renamed from: d */
    public static AdImageInfo m65608d(ImageInfo imageInfo) {
        if (imageInfo == null) {
            return null;
        }
        AdImageInfo adImageInfo = new AdImageInfo();
        adImageInfo.setUrl(imageInfo.getUrl());
        adImageInfo.setHeight(imageInfo.getHeight());
        adImageInfo.setImageType(imageInfo.getImageType());
        adImageInfo.setWidth(imageInfo.getWidth());
        adImageInfo.setSha256(imageInfo.getSha256());
        return adImageInfo;
    }

    /* renamed from: e */
    public static AdVideoInfo m65609e(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return null;
        }
        AdVideoInfo adVideoInfo = new AdVideoInfo();
        adVideoInfo.setVideoDownloadUrl(videoInfo.getVideoDownloadUrl());
        adVideoInfo.setVideoDuration(videoInfo.getVideoDuration());
        adVideoInfo.setvideoFileSize(videoInfo.getVideoFileSize());
        adVideoInfo.setSha256(videoInfo.getSha256());
        return adVideoInfo;
    }

    /* renamed from: f */
    public static void m65610f(C11060c c11060c, String str, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("load_ad_error_code", c11060c.m66647c());
        linkedHashMapM79497A.put("load_ad_error_msg", c11060c.m66652h());
        linkedHashMapM79497A.put("load_ad_channel", str);
        linkedHashMapM79497A.put("request_agd_ads_count_key", String.valueOf(i10));
        linkedHashMapM79497A.put("sce_request_agd_ads_key", "sce_request_agd_ads_show");
        C13622a.m81969o(C0213f.m1377a(), c11060c, linkedHashMapM79497A);
        C13225d.m79490f1().m79567R("load_ag_ads_event_fail", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "load_ag_ads_event_fail", linkedHashMapM79497A);
    }

    /* renamed from: g */
    public static void m65611g(C11060c c11060c, int i10, int i11, int i12, String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("load_ad_num", String.valueOf(i11));
        linkedHashMapM79497A.put("request_agd_ads_count_key", String.valueOf(i10));
        linkedHashMapM79497A.put("filter_agd_ads_count_key", String.valueOf(i12));
        linkedHashMapM79497A.put("sce_request_agd_ads_key", "sce_request_agd_ads_show");
        linkedHashMapM79497A.put("load_ad_channel", str);
        C13622a.m81969o(C0213f.m1377a(), c11060c, linkedHashMapM79497A);
        C13225d.m79490f1().m79567R("load_ag_ads_event_success", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "load_ag_ads_event_success", linkedHashMapM79497A);
    }

    /* renamed from: h */
    public static void m65612h(C11060c c11060c, int i10, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("load_request_ad_num", String.valueOf(i10));
        linkedHashMap.put("load_ad_error_code", c11060c.m66647c());
        linkedHashMap.put("load_ad_error_msg", c11060c.m66652h());
        linkedHashMap.put("load_ad_channel", str);
        C13622a.m81969o(C0213f.m1377a(), c11060c, linkedHashMap);
        C1400c.m8060g("JS_LOAD_APP_NUM_FAIL", linkedHashMap);
    }

    /* renamed from: i */
    public static void m65613i(C11060c c11060c, int i10, int i11, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("load_request_ad_num", String.valueOf(i10));
        linkedHashMap.put("load_ad_num", String.valueOf(i11));
        linkedHashMap.put("load_ad_channel", str);
        C13622a.m81969o(C0213f.m1377a(), c11060c, linkedHashMap);
        C1400c.m8060g("JS_LOAD_APP_NUM_SUCCESS", linkedHashMap);
    }
}
