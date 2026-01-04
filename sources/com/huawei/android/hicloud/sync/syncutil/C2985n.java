package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import java.util.Iterator;
import java.util.Map;
import p292fn.C9733f;
import p514o9.C11839m;
import tc.C13007b;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.n */
/* loaded from: classes3.dex */
public class C2985n {
    /* renamed from: a */
    public static String m17931a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str.startsWith(str2) && str.endsWith(str3)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length >= 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String[] m17932b() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70689w("SyncRefundUtil", "getOMAssetRefundStatus configMap is null");
            return new String[]{String.valueOf(2)};
        }
        String assetRefundStatus = hiCloudSysParamMapM60757p.getAssetRefundStatus();
        C11839m.m70686d("SyncRefundUtil", "getOMAssetRefundStatus: " + assetRefundStatus);
        return TextUtils.isEmpty(assetRefundStatus) ? new String[]{String.valueOf(2)} : assetRefundStatus.split(",");
    }

    /* renamed from: c */
    public static String[] m17933c() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70689w("SyncRefundUtil", "getOMSyncAssertRefundIds configMap is null");
            return null;
        }
        String syncAssetRefundIds = hiCloudSysParamMapM60757p.getSyncAssetRefundIds();
        C11839m.m70686d("SyncRefundUtil", "getOMAssetRefundStatus: " + syncAssetRefundIds);
        if (TextUtils.isEmpty(syncAssetRefundIds)) {
            return null;
        }
        return syncAssetRefundIds.split(",");
    }

    /* renamed from: d */
    public static boolean m17934d(String str, long j10) {
        boolean zM17936f = m17936f();
        boolean zM17938h = m17938h(str);
        boolean zM17939i = m17939i(System.currentTimeMillis(), j10);
        C11839m.m70688i("SyncRefundUtil", "isCanGetSyncLost: isRefundEnable = " + zM17936f + ", isRefundIds = " + zM17938h + ", isRefundPeriod = " + zM17939i);
        return zM17936f && zM17938h && zM17939i;
    }

    /* renamed from: e */
    public static boolean m17935e(String str) {
        boolean zM17936f = m17936f();
        boolean zM17938h = m17938h(str);
        C11839m.m70688i("SyncRefundUtil", "isCanProcessLost: isRefundEnable = " + zM17936f + ", isRefundIds = " + zM17938h);
        return zM17936f && zM17938h;
    }

    /* renamed from: f */
    public static boolean m17936f() {
        return C9733f.m60705z().m60720O("enableSyncAssetRefund");
    }

    /* renamed from: g */
    public static boolean m17937g(int i10) {
        for (String str : m17932b()) {
            if (TextUtils.equals(str, String.valueOf(i10))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m17938h(String str) {
        String[] strArrM17933c;
        try {
            strArrM17933c = m17933c();
        } catch (Exception e10) {
            C11839m.m70689w("SyncRefundUtil", "isSyncAssertRefundIds get databaseId error " + e10.getMessage());
        }
        if (strArrM17933c == null) {
            return false;
        }
        for (String str2 : strArrM17933c) {
            if (TextUtils.equals(str2, DriveSyncUtil.m17959D(str))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m17939i(long j10, long j11) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return j10 - j11 >= ((long) hiCloudSysParamMapM60757p.getSyncAssetRefundPeriod()) * 86400000;
        }
        C11839m.m70689w("SyncRefundUtil", "isSyncAssertRefundPeriod configMap is null");
        return j10 - j11 >= 604800000;
    }

    /* renamed from: j */
    public static void m17940j(Context context, String str) {
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        Map<String, ?> mapM78284s = c13007bM78205Y.m78284s();
        if (mapM78284s != null) {
            for (String str2 : mapM78284s.keySet()) {
                String strM17931a = m17931a(str2, str, "_local_lost_cursor");
                if (!TextUtils.isEmpty(strM17931a)) {
                    c13007bM78205Y.m78257e0(str, strM17931a);
                }
                String strM17931a2 = m17931a(str2, str, "_server_lost_cursor");
                if (!TextUtils.isEmpty(strM17931a2)) {
                    c13007bM78205Y.m78259f0(str, strM17931a2);
                }
            }
        }
    }

    /* renamed from: k */
    public static void m17941k(Context context, String str) {
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        Map<String, ?> mapM78284s = c13007bM78205Y.m78284s();
        if (mapM78284s != null) {
            Iterator<String> it = mapM78284s.keySet().iterator();
            while (it.hasNext()) {
                String strM17931a = m17931a(it.next(), str, "_refund_update_time");
                if (!TextUtils.isEmpty(strM17931a)) {
                    c13007bM78205Y.m78261g0(str, strM17931a);
                }
            }
        }
    }

    /* renamed from: l */
    public static void m17942l(Context context, String str, String str2) {
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        c13007bM78205Y.m78207A0(str, str2, c13007bM78205Y.m78232N(str, str2));
    }

    /* renamed from: m */
    public static void m17943m(Context context, String str, String str2) {
        C13007b.m78205Y(context).m78235O0(str, str2, System.currentTimeMillis());
    }
}
