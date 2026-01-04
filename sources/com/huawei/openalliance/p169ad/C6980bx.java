package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.p169ad.activity.DomesticDsaActivity;
import com.huawei.openalliance.p169ad.activity.LandingDetailsActivity;
import com.huawei.openalliance.p169ad.activity.OpenPrivacyPerActivity;
import com.huawei.openalliance.p169ad.activity.PPSInterstitialAdActivity;
import com.huawei.openalliance.p169ad.activity.PPSRewardActivity;
import com.huawei.openalliance.p169ad.activity.PPSShareActivity;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapNameConstants;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7730ad;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: com.huawei.openalliance.ad.bx */
/* loaded from: classes8.dex */
public class C6980bx {

    /* renamed from: a */
    private static long f32089a;

    /* renamed from: a */
    public static void m41131a(Context context, View view, ContentRecord contentRecord) {
        AbstractC7185ho.m43820b("ActivityStarter", "start domestic dsa activity");
        if (view == null) {
            return;
        }
        if (contentRecord == null || !contentRecord.m41517bd() || AbstractC7806cz.m48165b(contentRecord.m41516bc())) {
            AbstractC7185ho.m43820b("ActivityStarter", "start domestic dsa activity failed, switch close or empty url.");
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        AbstractC7185ho.m43821b("ActivityStarter", "startDomesticDsaActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        m41132a(context, view, contentRecord, iArr);
    }

    /* renamed from: b */
    private static Class m41145b() {
        return LandingDetailsActivity.class;
    }

    /* renamed from: a */
    private static void m41132a(Context context, View view, ContentRecord contentRecord, int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC7177hg(view, context, iArr2));
        int[] iArr3 = {view.getMeasuredWidth(), view.getMeasuredHeight()};
        SafeIntent safeIntent = new SafeIntent(new Intent(context, (Class<?>) DomesticDsaActivity.class));
        safeIntent.putExtra(MapKeyNames.DSA_URL, contentRecord.m41516bc());
        safeIntent.putExtra(MapKeyNames.ANCHOR_LOCATION, iArr);
        safeIntent.putExtra(MapKeyNames.ANCHOR_SIZE, iArr3);
        safeIntent.setFlags(65536);
        if (!(context instanceof Activity)) {
            safeIntent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        safeIntent.setClipData(Constants.CLIP_DATA);
        AbstractC7811dd.m48294a(context, safeIntent);
    }

    /* renamed from: a */
    public static void m41133a(Context context, View view, int[] iArr, ContentRecord contentRecord) {
        String str;
        AbstractC7185ho.m43820b("ActivityStarter", "start domestic dsa activity");
        if (view == null) {
            return;
        }
        if (contentRecord == null || !contentRecord.m41517bd() || AbstractC7806cz.m48165b(contentRecord.m41516bc())) {
            str = "start domestic dsa activity failed, switch close or empty url.";
        } else {
            if (iArr != null && iArr.length == 2) {
                m41132a(context, view, contentRecord, iArr);
                return;
            }
            str = "invalid location array.";
        }
        AbstractC7185ho.m43820b("ActivityStarter", str);
    }

    /* renamed from: a */
    private static void m41134a(Context context, SafeIntent safeIntent) {
        try {
            safeIntent.setFlags(65536);
            if (!(context instanceof Activity)) {
                safeIntent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            AbstractC7811dd.m48294a(context, safeIntent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("ActivityStarter", "start landing detail Activity error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m41135a(Context context, AdLandingPageData adLandingPageData, C7169gz c7169gz, ContentRecord contentRecord) {
        try {
            Intent intent = new Intent();
            intent.setClassName(context, "com.huawei.openalliance.ad.activity.PPSActivity");
            intent.putExtra(MapNameConstants.AD_LANDING_PAGE_DATA, adLandingPageData);
            m41140a(intent, c7169gz);
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            intent.setClipData(Constants.CLIP_DATA);
            context.startActivity(intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43815a(3, th2);
            AbstractC7185ho.m43821b("ActivityStarter", "startAdActivity error, %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m41136a(Context context, AdLandingPageData adLandingPageData, MaterialClickInfo materialClickInfo) {
        AbstractC7185ho.m43820b("ActivityStarter", "start landing detail activity internal jump start.");
        if (adLandingPageData == null || adLandingPageData.getAppInfo() == null || TextUtils.isEmpty(adLandingPageData.getAppInfo().getAppDetailUrl())) {
            AbstractC7185ho.m43820b("ActivityStarter", "start landing detail activity landingPageData detail url is empty.");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(new Intent(context, (Class<?>) m41145b()));
        safeIntent.putExtra(MapKeyNames.APP_DETAIL_DATA, adLandingPageData);
        if (materialClickInfo != null && AbstractC7806cz.m48187p(materialClickInfo.m44508c()) && materialClickInfo.m44501a() != null) {
            safeIntent.putExtra("click_info", AbstractC7758be.m47742b(materialClickInfo));
        }
        m41134a(context, safeIntent);
    }

    /* renamed from: a */
    public static void m41137a(Context context, IAd iAd, MaterialClickInfo materialClickInfo) {
        AbstractC7185ho.m43820b("ActivityStarter", "start landing detail activity external jump start.");
        if (iAd == null || iAd.getAppInfo() == null || TextUtils.isEmpty(iAd.getAppInfo().getAppDetailUrl())) {
            AbstractC7185ho.m43820b("ActivityStarter", "start landing detail activity native detail url is empty.");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(new Intent(context, (Class<?>) m41145b()));
        if (iAd instanceof C7301d) {
            AbstractC7014dc.m41870a((C7301d) iAd);
        } else {
            safeIntent.putExtra(MapKeyNames.APP_DETAIL_DATA, iAd);
        }
        if (materialClickInfo != null && AbstractC7806cz.m48187p(materialClickInfo.m44508c()) && materialClickInfo.m44501a() != null) {
            safeIntent.putExtra("click_info", AbstractC7758be.m47742b(materialClickInfo));
        }
        m41134a(context, safeIntent);
    }

    /* renamed from: a */
    public static void m41138a(Context context, C7302e c7302e, ContentRecord contentRecord) {
        ImageInfo imageInfo;
        AbstractC7185ho.m43817a("ActivityStarter", "startComplianceActivity");
        if (m41144a(c7302e)) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) PPSShareActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            intent.putExtra("title", c7302e.getTitle());
            intent.putExtra("description", c7302e.getDescription());
            if (c7302e.getImageInfos() != null && !c7302e.getImageInfos().isEmpty() && (imageInfo = c7302e.getImageInfos().get(0)) != null) {
                intent.putExtra("imageUrl", imageInfo.getUrl());
            }
            intent.putExtra(MapKeyNames.CONTENT_RECORD, AbstractC7758be.m47742b(contentRecord));
            intent.putExtra(JsbMapKeyNames.H5_CSHARE_URL, c7302e.m44829ay());
            AbstractC7811dd.m48294a(context, intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ActivityStarter", "start Activity error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static void m41139a(Context context, String str) {
        if (m41141a()) {
            AbstractC7185ho.m43820b("ActivityStarter", "start privacy or permission, fast click.");
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) OpenPrivacyPerActivity.class);
            intent.putExtra("url", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            AbstractC7811dd.m48294a(context, intent);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ActivityStarter", "start PriPer err, %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private static void m41140a(Intent intent, C7169gz c7169gz) {
        if (intent == null || c7169gz == null) {
            return;
        }
        AbstractC7185ho.m43820b("ActivityStarter", "parseLinkedAdConfig.");
        intent.putExtra(MapKeyNames.LINKED_AD_DATA, AbstractC7758be.m47742b(c7169gz));
    }

    /* renamed from: a */
    private static boolean m41141a() {
        if (System.currentTimeMillis() - f32089a < 500) {
            return true;
        }
        f32089a = System.currentTimeMillis();
        return false;
    }

    /* renamed from: a */
    public static boolean m41142a(Context context, C7301d c7301d) {
        if (context != null && c7301d != null) {
            try {
                Intent intent = new Intent();
                intent.setClassName(context, Constants.INTERSTITIAL_ACTIVITY_NAME);
                PPSInterstitialAdActivity.m38734a(c7301d.getUniqueId(), c7301d.m44728ad());
                AbstractC7014dc.m41878b(c7301d);
                if (!(context instanceof Activity)) {
                    intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                }
                intent.setClipData(Constants.CLIP_DATA);
                context.startActivity(intent);
                return true;
            } catch (Throwable th2) {
                AbstractC7185ho.m43815a(3, th2);
                AbstractC7185ho.m43821b("ActivityStarter", "startInterstitialActivity error, %s", th2.getClass().getSimpleName());
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m41143a(Context context, C7305h c7305h) {
        if (context != null && c7305h != null) {
            try {
                Intent intent = new Intent();
                intent.setClassName(context, Constants.REWARD_ACTIVITY_NAME);
                String uniqueId = c7305h.getUniqueId();
                PPSRewardActivity.m38747a(uniqueId, c7305h.m44940Z());
                PPSRewardActivity.m38746a(uniqueId, c7305h.m44938X());
                AbstractC7014dc.m41872a(c7305h);
                if (!(context instanceof Activity)) {
                    intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                }
                intent.setClipData(Constants.CLIP_DATA);
                context.startActivity(intent);
                return true;
            } catch (Throwable th2) {
                AbstractC7185ho.m43815a(3, th2);
                AbstractC7185ho.m43821b("ActivityStarter", "startRewardActivty error, %s", th2.getClass().getSimpleName());
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m41144a(C7302e c7302e) {
        String str;
        if (C7730ad.m47434a()) {
            str = "repeat click too fast";
        } else {
            if (c7302e != null) {
                return false;
            }
            str = "nativeAd is null";
        }
        AbstractC7185ho.m43817a("ActivityStarter", str);
        return true;
    }
}
