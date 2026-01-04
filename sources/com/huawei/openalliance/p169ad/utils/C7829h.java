package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RewardKeys;

/* renamed from: com.huawei.openalliance.ad.utils.h */
/* loaded from: classes2.dex */
public class C7829h {
    /* renamed from: a */
    public static void m48406a(Context context, String str, String str2, String str3, String str4) {
        AbstractC7185ho.m43818a("AnalyticsKitUtils", "ana_tag_kit broadcastEvent sourcePkg = %s", str);
        Intent intent = new Intent("com.huawei.hms.analytics.pps.event");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString(MapKeyNames.PACKAGE_NAME, str);
        bundle.putString(RewardKeys.EVENT_TYPE, str2);
        bundle.putString("slot_id", str3);
        if (str4 == null) {
            bundle.putString("activity_name", "");
        } else {
            bundle.putString("activity_name", str4);
        }
        intent.putExtra("event_detail", bundle);
        context.sendBroadcast(intent);
        AbstractC7185ho.m43817a("AnalyticsKitUtils", "ana_tag sendBroadcast successfully!");
    }

    /* renamed from: a */
    public static void m48407a(Context context, String str, String str2, String str3, String str4, String str5) {
        AbstractC7185ho.m43818a("AnalyticsKitUtils", "ana_tag_kit broadcastEvent sourcePkg = %s", str);
        Intent intent = new Intent("com.huawei.hms.analytics.pps.event");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString(MapKeyNames.PACKAGE_NAME, str);
        bundle.putString(RewardKeys.EVENT_TYPE, str2);
        bundle.putString("sub_type", str3);
        bundle.putString("slot_id", str4);
        if (str5 == null) {
            bundle.putString("activity_name", "");
        } else {
            bundle.putString("activity_name", str5);
        }
        intent.putExtra("event_detail", bundle);
        context.sendBroadcast(intent);
        AbstractC7185ho.m43817a("AnalyticsKitUtils", "ana_tag sendBroadcast successfully!");
    }
}
