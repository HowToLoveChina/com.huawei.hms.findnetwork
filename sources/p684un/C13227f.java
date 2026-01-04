package p684un;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import java.util.LinkedHashMap;
import p399jk.AbstractC10896a;

/* renamed from: un.f */
/* loaded from: classes6.dex */
public class C13227f extends C13230i {

    /* renamed from: r */
    public static final C13227f f59871r = new C13227f();

    /* renamed from: i1 */
    public static C13227f m79492i1() {
        return f59871r;
    }

    @Override // p684un.C13230i
    /* renamed from: G */
    public synchronized HiAnalyticsInstance mo79488G() throws C9721b {
        return m79555H(mo79489J());
    }

    @Override // p684un.C13230i
    /* renamed from: J */
    public String mo79489J() {
        return "clouddrive_common";
    }

    /* renamed from: f1 */
    public void m79493f1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("HiAnalyticsCommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        if (!TextUtils.isEmpty(str5)) {
            linkedHashMap.put("salChannel", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            linkedHashMap.put("srcChannel", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            linkedHashMap.put("activityCode", str7);
        }
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, str3);
        linkedHashMap.put("phone_type", Build.MODEL);
        m79571T(linkedHashMap);
    }

    /* renamed from: g1 */
    public void m79494g1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("HiAnalyticsCommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        if (!TextUtils.isEmpty(str5)) {
            linkedHashMap.put("salChannel", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            linkedHashMap.put("srcChannel", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            linkedHashMap.put("activityCode", str7);
        }
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, str3);
        linkedHashMap.put("phone_type", Build.MODEL);
        m79571T(linkedHashMap);
    }

    /* renamed from: h1 */
    public void m79495h1(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("HiAnalyticsCommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        if (!TextUtils.isEmpty(str5)) {
            linkedHashMap.put("salChannel", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            linkedHashMap.put("srcChannel", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            linkedHashMap.put("activityCode", str7);
        }
        if (!TextUtils.isEmpty(str9)) {
            linkedHashMap.put("pkg_name", str9);
        }
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
        linkedHashMap.put("uid", str3);
        linkedHashMap.put("enterType", str8);
        linkedHashMap.put("phone_type", Build.MODEL);
        m79571T(linkedHashMap);
    }
}
