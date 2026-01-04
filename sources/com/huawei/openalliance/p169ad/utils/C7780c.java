package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.uiengine.InterfaceC5110e;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7129fm;
import com.huawei.openalliance.p169ad.C7483mr;
import com.huawei.openalliance.p169ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.p169ad.beans.metadata.DefaultTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.utils.c */
/* loaded from: classes2.dex */
public class C7780c {
    /* renamed from: a */
    public static Pair<String, String> m47852a(Context context, String str, String str2) {
        CallResult callResultM45853a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put("cacheType", str2);
            callResultM45853a = C7483mr.m45852a(context).m45853a(RTCMethods.QUERY_FILE_PATH, jSONObject.toString(), String.class);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AdDataUtil", "getFilePathFromKit err: %s", th2.getClass().getSimpleName());
        }
        if (200 != callResultM45853a.getCode()) {
            AbstractC7185ho.m43820b("AdDataUtil", "getFilePathFromKit fail");
            return null;
        }
        AbstractC7185ho.m43820b("AdDataUtil", "getFilePathFromKit success");
        JSONObject jSONObject2 = new JSONObject((String) callResultM45853a.getData());
        return new Pair<>(jSONObject2.optString("filePath"), jSONObject2.optString(MapKeyNames.CONTENT_DOWN_METHOD));
    }

    /* renamed from: b */
    private static String m47869b(Context context, int i10) {
        return context.getResources().getString(i10, context.getResources().getString(C6849R.string.hiad_appGallery));
    }

    /* renamed from: a */
    public static String m47853a(Context context, int i10) {
        int i11;
        String strM47869b = m47869b(context, C6849R.string.hiad_click_card_to_open);
        if (context == null) {
            return strM47869b;
        }
        if (i10 == 7 || i10 == 8) {
            i11 = C6849R.string.hiad_click_open_to;
        } else {
            if (i10 != 12) {
                return strM47869b;
            }
            i11 = C6849R.string.hiad_click_material_open;
        }
        return m47869b(context, i11);
    }

    /* renamed from: b */
    private static String m47870b(Context context, PromoteInfo promoteInfo, boolean z10) {
        if (promoteInfo == null || promoteInfo.getType() != 2 || TextUtils.isEmpty(promoteInfo.getName())) {
            return z10 ? context.getResources().getString(C6849R.string.hiad_click_to_open_wechat_mini_spec) : context.getResources().getString(C6849R.string.hiad_click_material_open, context.getResources().getString(C6849R.string.hiad_wechat_mini_spec, ""));
        }
        Resources resources = context.getResources();
        return z10 ? resources.getString(C6849R.string.hiad_click_open_to, promoteInfo.getName()) : resources.getString(C6849R.string.hiad_click_material_open, promoteInfo.getName());
    }

    /* renamed from: a */
    private static String m47854a(Context context, PromoteInfo promoteInfo, boolean z10) {
        if (TextUtils.isEmpty(promoteInfo.getName())) {
            return z10 ? context.getResources().getString(C6849R.string.hiad_click_to_open_quick_app) : context.getResources().getString(C6849R.string.hiad_click_material_open, context.getResources().getString(C6849R.string.hiad_fast_app_spec, ""));
        }
        Resources resources = context.getResources();
        return z10 ? resources.getString(C6849R.string.hiad_click_open_to, promoteInfo.getName()) : resources.getString(C6849R.string.hiad_click_material_open, promoteInfo.getName());
    }

    /* renamed from: b */
    private static String m47871b(Context context, ContentRecord contentRecord) throws Resources.NotFoundException {
        String name;
        int iM41388C = contentRecord.m41388C();
        if (iM41388C == 0) {
            return null;
        }
        PromoteInfo promoteInfoM41485ag = contentRecord.m41485ag();
        if (iM41388C == 10) {
            if (promoteInfoM41485ag != null && promoteInfoM41485ag.getType() == 2 && !TextUtils.isEmpty(promoteInfoM41485ag.getName())) {
                return context.getResources().getString(C6849R.string.hiad_wechat_mini_spec, promoteInfoM41485ag.getName());
            }
            String string = context.getResources().getString(C6849R.string.hiad_wechat_mini_spec, "");
            if (string == null) {
                return null;
            }
            return string.trim();
        }
        if (iM41388C == 11) {
            return context.getResources().getString(C6849R.string.hiad_share_wx);
        }
        if (iM41388C == 8) {
            return context.getResources().getString(C6849R.string.hiad_appGallery);
        }
        if (promoteInfoM41485ag != null) {
            name = promoteInfoM41485ag.getName();
            if (promoteInfoM41485ag.getType() == 1) {
                boolean zIsEmpty = TextUtils.isEmpty(name);
                Resources resources = context.getResources();
                if (!zIsEmpty) {
                    return resources.getString(C6849R.string.hiad_fast_app_spec, name);
                }
                String string2 = resources.getString(C6849R.string.hiad_fast_app_spec, "");
                if (string2 == null) {
                    return null;
                }
                return string2.trim();
            }
        } else {
            name = null;
        }
        if (!TextUtils.isEmpty(name)) {
            return name;
        }
        AppInfo appInfoM41484af = contentRecord.m41484af();
        if (appInfoM41484af == null) {
            return null;
        }
        return (TextUtils.isEmpty(appInfoM41484af.getAppName()) || !C7830i.m48419a(context, appInfoM41484af.getPackageName())) ? name : appInfoM41484af.getAppName();
    }

    /* renamed from: a */
    public static String m47855a(Context context, ContentRecord contentRecord) {
        List<String> listM40276M;
        if (contentRecord != null && contentRecord.m41568i() != null) {
            MetaData metaDataM41568i = contentRecord.m41568i();
            if (2 == contentRecord.m41392E()) {
                listM40276M = metaDataM41568i.m40277N();
            } else {
                listM40276M = (9 == contentRecord.m41392E() || 12 == contentRecord.m41392E()) ? metaDataM41568i.m40276M() : null;
            }
            if (!AbstractC7760bg.m47767a(listM40276M)) {
                return C7752az.m47696b(context, listM40276M.get(0));
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m47872b(Integer num) {
        return num != null && num.intValue() == 7;
    }

    /* renamed from: a */
    public static String m47856a(Context context, ContentRecord contentRecord, int i10) throws Resources.NotFoundException {
        if (context == null || contentRecord == null) {
            return null;
        }
        String strM47871b = m47871b(context, contentRecord);
        if (TextUtils.isEmpty(strM47871b)) {
            return null;
        }
        Resources resources = context.getResources();
        return i10 == 0 ? resources.getString(C6849R.string.hiad_touch_jump_to, strM47871b) : resources.getString(C6849R.string.hiad_jump_to, strM47871b);
    }

    /* renamed from: a */
    private static String m47857a(Context context, String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return z10 ? context.getResources().getString(C6849R.string.hiad_click_to_open_harmony_service) : context.getResources().getString(C6849R.string.hiad_click_material_open, context.getResources().getString(C6849R.string.hiad_harmony_service_spec, ""));
        }
        Resources resources = context.getResources();
        return z10 ? resources.getString(C6849R.string.hiad_click_open_to, str) : resources.getString(C6849R.string.hiad_click_material_open, str);
    }

    /* renamed from: a */
    private static String m47858a(Context context, boolean z10) {
        return context.getResources().getString(z10 ? C6849R.string.hiad_click_open_to : C6849R.string.hiad_click_material_open, context.getResources().getString(C6849R.string.hiad_share_wx));
    }

    /* renamed from: a */
    public static String m47859a(ContentRecord contentRecord, Context context, boolean z10) {
        int iM41388C;
        PPSAbilityDataContent pPSAbilityDataContent;
        if (contentRecord == null || (iM41388C = contentRecord.m41388C()) == 0 || iM41388C == 1 || iM41388C == 2) {
            return null;
        }
        if (iM41388C == 8) {
            return m47853a(context, contentRecord.m41552f());
        }
        if (iM41388C == 9 && (pPSAbilityDataContent = (PPSAbilityDataContent) AbstractC7758be.m47739b(contentRecord.m41466aR(), PPSAbilityDataContent.class, new Class[0])) != null) {
            return m47857a(context, pPSAbilityDataContent.m43190a(), z10);
        }
        PromoteInfo promoteInfoM41485ag = contentRecord.m41485ag();
        if (iM41388C == 10) {
            return m47870b(context, promoteInfoM41485ag, z10);
        }
        if (iM41388C == 11) {
            return m47858a(context, z10);
        }
        if (promoteInfoM41485ag != null && promoteInfoM41485ag.getType() == 1) {
            return m47854a(context, promoteInfoM41485ag, z10);
        }
        AppInfo appInfoM41484af = contentRecord.m41484af();
        if (appInfoM41484af == null) {
            Resources resources = context.getResources();
            return z10 ? resources.getString(C6849R.string.hiad_click_to_learn_more) : resources.getString(C6849R.string.hiad_click_material, context.getResources().getString(C6849R.string.hiad_learn_more));
        }
        if (!C7830i.m48419a(context, appInfoM41484af.getPackageName())) {
            return null;
        }
        if (TextUtils.isEmpty(appInfoM41484af.getAppName()) || !C7830i.m48419a(context, appInfoM41484af.getPackageName())) {
            Resources resources2 = context.getResources();
            return z10 ? resources2.getString(C6849R.string.hiad_click_to_learn_more) : resources2.getString(C6849R.string.hiad_click_material, context.getResources().getString(C6849R.string.hiad_learn_more));
        }
        Resources resources3 = context.getResources();
        return z10 ? resources3.getString(C6849R.string.hiad_click_open_to, appInfoM41484af.getAppName()) : resources3.getString(C6849R.string.hiad_click_material_open, appInfoM41484af.getAppName());
    }

    /* renamed from: a */
    public static void m47860a(Map<String, List<INativeAd>> map, String str, List<INativeAd> list) {
        if (map == null || TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        List<INativeAd> list2 = map.get(str);
        if (list2 != null) {
            list2.addAll(list);
        } else {
            map.put(str, list);
        }
    }

    /* renamed from: a */
    public static boolean m47861a() {
        String strM42836a = C7084e.m42836a();
        return !TextUtils.isEmpty(strM42836a) && 30461200 <= Integer.parseInt(strM42836a);
    }

    /* renamed from: a */
    private static boolean m47862a(int i10, String str) {
        InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
        if (interfaceC5110eM42838b == null) {
            return false;
        }
        try {
            return interfaceC5110eM42838b.mo30525a(str, i10, null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("AdDataUtil", "check valid err: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m47863a(Context context, DefaultTemplate defaultTemplate, String str, int i10) {
        String str2;
        if (context == null) {
            return false;
        }
        String strM42836a = C7084e.m42836a();
        if (TextUtils.isEmpty(strM42836a) || 30459301 > Integer.parseInt(strM42836a)) {
            str2 = "uiengine not support";
        } else if (defaultTemplate == null || !defaultTemplate.m40018c()) {
            str2 = "data is invalid";
        } else {
            if (m47862a(i10, defaultTemplate.m40014a())) {
                if (defaultTemplate.m40017b() == null) {
                    AbstractC7185ho.m43820b("AdDataUtil", "isShowV2Tpt, no fcCtl");
                    return true;
                }
                Integer numM40017b = defaultTemplate.m40017b();
                int iIntValue = numM40017b.intValue();
                int iMo43541a = C7129fm.m43536a(context).mo43541a(str);
                AbstractC7185ho.m43821b("AdDataUtil", "isShowV2Tpt, tptFcCtl = %s, showTimes = %s", numM40017b, Integer.valueOf(iMo43541a));
                return iIntValue > iMo43541a;
            }
            str2 = "templateId is invalid";
        }
        AbstractC7185ho.m43820b("AdDataUtil", str2);
        return false;
    }

    /* renamed from: a */
    public static boolean m47864a(Context context, ContentRecord contentRecord, String str) {
        Pair<String, String> pairM47852a = m47852a(context, str, Constants.NORMAL_CACHE);
        if (pairM47852a == null || TextUtils.isEmpty((CharSequence) pairM47852a.first) || TextUtils.isEmpty((CharSequence) pairM47852a.second)) {
            return false;
        }
        if (contentRecord == null) {
            return true;
        }
        contentRecord.m41571i((String) pairM47852a.first);
        contentRecord.m41599q((String) pairM47852a.second);
        return true;
    }

    /* renamed from: a */
    public static boolean m47865a(Context context, ContentRecord contentRecord, String str, Asset asset) {
        try {
            Pair<String, String> pairM47852a = m47852a(context, str, Constants.TPLATE_CACHE);
            if (pairM47852a == null || TextUtils.isEmpty((CharSequence) pairM47852a.first) || TextUtils.isEmpty((CharSequence) pairM47852a.second)) {
                return false;
            }
            if (asset != null) {
                asset.m40513b((String) pairM47852a.first);
            }
            if (contentRecord != null) {
                contentRecord.m41599q((String) pairM47852a.second);
            }
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("AdDataUtil", "get path err: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m47866a(CtrlExt ctrlExt) {
        if (ctrlExt == null) {
            return false;
        }
        return "1".equals(ctrlExt.m40013a());
    }

    /* renamed from: a */
    public static boolean m47867a(CtrlExt ctrlExt, Integer num) {
        return m47866a(ctrlExt) && m47868a(num);
    }

    /* renamed from: a */
    public static boolean m47868a(Integer num) {
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        if (iIntValue != 1 && iIntValue != 2 && iIntValue != 6) {
            switch (iIntValue) {
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
