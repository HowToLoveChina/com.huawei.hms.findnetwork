package p450le;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeForSpaceShareActivity;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0213f;
import p054cj.C1442a;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13227f;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: le.a */
/* loaded from: classes3.dex */
public class C11272a {
    /* renamed from: a */
    public static void m67641a(Intent intent, ActivityEntry activityEntry) {
        if (activityEntry == null || activityEntry.getCampaignInfo() == null) {
            C1442a.m8289e("CloudPayLauncher", "activityEntry is null");
            return;
        }
        AdParametersExt adParametersExt = activityEntry.getCampaignInfo().getAdParametersExt();
        if (adParametersExt == null) {
            C1442a.m8290i("CloudPayLauncher", "adParameters is null");
            return;
        }
        intent.putExtra("agd_resource_enable", adParametersExt.getEnabled());
        intent.putExtra("agd_resource_slot_id", adParametersExt.getAgdAdid());
        intent.putExtra("pps_threshold", adParametersExt.getThreshold());
    }

    /* renamed from: b */
    public static void m67642b(Bundle bundle, Intent intent) {
        if (intent == null || bundle == null) {
            return;
        }
        boolean z10 = bundle.getBoolean(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY);
        boolean z11 = bundle.getBoolean(HNConstants.C4906BI.FROM_NOTIFY);
        if (z10 && z11) {
            intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, z10);
            intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, z11);
            intent.putExtra("notify_id", bundle.getString(HNConstants.C4906BI.DATA_TYPE_ID));
            intent.putExtra(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, bundle.getInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE));
            intent.putExtra(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID, bundle.getString(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID));
            intent.putExtra(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, bundle.getString(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE));
            intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, bundle.getFloat(HNConstants.C4906BI.BI_PERCENTAGE));
            intent.putExtra("user_tags_key", C13622a.m81963i());
        }
        if (z11) {
            try {
                intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
                String string = bundle.getString(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY);
                if (TextUtils.isEmpty(string) || !string.contains("recommend_card_notification")) {
                    return;
                }
                intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, string);
                intent.putExtra("recommend_card_activity_id", bundle.getString("recommend_card_activity_id"));
                intent.putExtra("recommend_card_activity_type", bundle.getString("recommend_card_activity_type"));
                intent.putExtra("recommend_card_entrance", bundle.getString("recommend_card_entrance"));
                new C13149f().m79065c(C0213f.m1377a(), intent, "5");
            } catch (Exception e10) {
                C1442a.m8289e("CloudPayLauncher", "report exception: " + e10.toString());
            }
        }
    }

    /* renamed from: c */
    public static void m67643c(Bundle bundle, Intent intent) {
        if (bundle == null) {
            C1442a.m8289e("CloudPayLauncher", "setRecommendInfo bundles is null.");
            return;
        }
        boolean z10 = bundle.getBoolean(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY);
        if (z10) {
            intent.putExtra(HNConstants.PayIntentKey.IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY, z10);
            intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY, bundle.getString(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY));
            intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY, bundle.getLong(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY));
            intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY, bundle.getString(HNConstants.PayIntentKey.RECOMMEND_PACKAGE_ID_KEY));
        }
    }

    /* renamed from: d */
    public static void m67644d(Context context, int i10, Bundle bundle, boolean z10, int i11) {
        String str;
        String str2;
        String str3;
        int i12;
        boolean z11;
        int i13;
        int i14;
        boolean z12;
        String str4;
        String str5;
        String string;
        Intent intent;
        String str6;
        String str7;
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        try {
            Intent intent2 = new Intent(context, (Class<?>) CloudSpaceUpgradeActivity.class);
            m67642b(bundle, intent2);
            if (bundle != null) {
                String string2 = bundle.getString("channel_refer");
                boolean z13 = bundle.getBoolean("family_share", false);
                if (z13) {
                    str6 = "user_operation_text";
                    intent = new Intent(context, (Class<?>) CloudSpaceUpgradeForSpaceShareActivity.class);
                } else {
                    str6 = "user_operation_text";
                    intent = intent2;
                }
                intent.putExtras(bundle);
                intent.putExtra("family_share", z13);
                int i15 = bundle.getInt("from_where");
                String string3 = bundle.getString("srcChannel");
                String string4 = bundle.getString("package_id");
                String string5 = bundle.getString("salChannel");
                string = bundle.getString("activityCode");
                String string6 = bundle.getString("pkg_name");
                String string7 = bundle.getString("startupSource");
                str = "package_id";
                String string8 = bundle.getString("startupSourceId");
                str3 = "from_where";
                String string9 = bundle.getString("cfgId");
                String string10 = bundle.getString("forOtherPage");
                String str8 = str6;
                String string11 = bundle.getString(str8, "");
                String string12 = bundle.getString("user_operation_type", "");
                if (TextUtils.isEmpty(string3)) {
                    str7 = string3;
                } else {
                    str7 = string3;
                    intent.putExtra("srcChannel", bundle.getString("srcChannel"));
                }
                if (!TextUtils.isEmpty(string4)) {
                    intent.putExtra("packageId", string4);
                }
                if (!TextUtils.isEmpty(string5)) {
                    intent.putExtra("salChannel", bundle.getString("salChannel"));
                }
                if (!TextUtils.isEmpty(string)) {
                    intent.putExtra("activityCode", bundle.getString("activityCode"));
                }
                if (!TextUtils.isEmpty(string6)) {
                    intent.putExtra("pkg_name", string6);
                }
                if (!TextUtils.isEmpty(string7)) {
                    intent.putExtra("startupSource", string7);
                }
                if (!TextUtils.isEmpty(string8)) {
                    intent.putExtra("startupSourceId", string8);
                }
                if (!TextUtils.isEmpty(string9)) {
                    intent.putExtra("cfgId", string9);
                }
                if (!TextUtils.isEmpty(string11)) {
                    intent.putExtra(str8, string11);
                    intent.putExtra("user_operation_type", string12);
                }
                if (!TextUtils.isEmpty(string10)) {
                    intent.putExtra("forOtherPage", string10);
                }
                z11 = z10;
                i12 = 0;
                intent.putExtra("is_finish_for_result", z11);
                intent.putExtra("need_extra_space", bundle.getLong("need_extra_space", 0L));
                i13 = i10;
                str4 = string5;
                str5 = str7;
                str2 = string2;
                z12 = z13;
                i14 = i15;
            } else {
                str = "package_id";
                str2 = "";
                str3 = "from_where";
                i12 = 0;
                z11 = z10;
                i13 = i10;
                i14 = 0;
                z12 = false;
                str4 = str2;
                str5 = str4;
                string = str5;
                intent = intent2;
            }
            if (i13 != 0) {
                intent.addFlags(i13);
            }
            if ("0".equals(str2) || "5".equals(str2)) {
                intent.putExtra("is_activity_need_back_to_main", true);
            }
            if (i14 == 1) {
                intent.putExtra(str3, 1);
                String str9 = str;
                intent.putExtra(str9, bundle.getString(str9));
                intent.putExtra(Inviter.INVITE_CODE, bundle.getString(Inviter.INVITE_CODE));
                intent.putExtra("tranUrlSuccess", bundle.getString("tranUrlSuccess"));
                intent.putExtra("tranUrlFail", bundle.getString("tranUrlFail"));
                intent.putExtra("verifyIsAutoPay", bundle.getString("verifyIsAutoPay"));
            }
            intent.putExtra("payResultType", bundle.getString("payResultType"));
            intent.putExtra("payResultUrl", bundle.getString("payResultUrl"));
            intent.putExtra("activityId", bundle.getString("activityId"));
            intent.putExtra(Constants.CONTENT_SERVER_REALM, bundle.getString(Constants.CONTENT_SERVER_REALM));
            intent.putExtra("specified_pkg_id_key", bundle.getString("specified_pkg_id_key"));
            m67643c(bundle, intent);
            C13222a.m79472n(intent, bundle);
            C13227f.m79492i1().m79493f1("CLOUDPAY_ACCESS_BUY_STORAGE", "1", C13452e.m80781L().m80971t0(), str2, str4, str5, string);
            UBAAnalyze.m29961V("PVC", "CLOUDPAY_ACCESS_BUY_STORAGE", "1", "31", "1", str2, str4, str5, string);
            if (!(context instanceof Activity)) {
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                context.startActivity(intent);
                return;
            }
            if (!z11) {
                ((Activity) context).startActivity(intent);
                return;
            }
            C1442a.m8289e("CloudPayLauncher", "context " + context + "start FinishForResult:  requestCode" + i11 + " isFromShare " + z12);
            intent.removeFlags(i12);
            intent.setFlags(536870912);
            ((Activity) context).startActivityForResult(intent, i11);
        } catch (Exception e10) {
            C1442a.m8289e("CloudPayLauncher", "start error: " + e10.toString());
        }
    }

    /* renamed from: e */
    public static void m67645e(Context context, Bundle bundle) {
        m67644d(context, 0, bundle, false, 0);
    }
}
