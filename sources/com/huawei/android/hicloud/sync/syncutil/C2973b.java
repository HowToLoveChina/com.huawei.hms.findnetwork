package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.hicloud.sync.bean.CloudSyncRetryInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.RetryPolicy;
import com.huawei.hicloud.bean.SyncFailRetryPolicy;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0214f0;
import p292fn.C9733f;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.b */
/* loaded from: classes3.dex */
public class C2973b {

    /* renamed from: a */
    public static final HashMap<String, Boolean> f12997a = new HashMap<>();

    /* renamed from: a */
    public static void m17813a(Context context, String str) {
        C11839m.m70688i("CloudSyncRetryUtil", "appTriggeringSyncToSp");
        if (m17819g(context, str)) {
            return;
        }
        HashMap<String, Boolean> map = f12997a;
        if (map == null || map.isEmpty()) {
            C11839m.m70686d("CloudSyncRetryUtil", "no syncRetryMap, syncType enable empty");
            m17822j(context, str);
            return;
        }
        Boolean bool = map.get(str);
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        C11839m.m70688i("CloudSyncRetryUtil", "appTriggeringSyncToSp syncType :" + str + ",isCloudRetry :" + zBooleanValue);
        if (zBooleanValue) {
            return;
        }
        m17822j(context, str);
    }

    /* renamed from: b */
    public static void m17814b(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b;
        if (m17819g(context, str) || (sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0)) == null) {
            return;
        }
        C11839m.m70686d("CloudSyncRetryUtil", "closeButtonRefreshSyncToSp :" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m17815c(str, sharedPreferencesM1382b);
        m17827o(str, sharedPreferencesM1382b);
    }

    /* renamed from: c */
    public static void m17815c(String str, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str + "_retry_taskId");
        editorEdit.remove(str + "_retry_syncType");
        editorEdit.remove(str + "_retry_syncTime");
        editorEdit.remove(str + "_retry_syncStatus");
        editorEdit.remove(str + "_retry_retryTime");
        editorEdit.remove(str + "_retry_retryTimes");
        editorEdit.remove(str + "_retry_isRetry");
        editorEdit.commit();
    }

    /* renamed from: d */
    public static Map<String, RetryPolicy> m17816d() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        HashMap map = new HashMap();
        if (hiCloudSysParamMapM60757p != null) {
            String syncFailRetryPolicy = hiCloudSysParamMapM60757p.getSyncFailRetryPolicy();
            if (TextUtils.isEmpty(syncFailRetryPolicy)) {
                return null;
            }
            try {
                List<RetryPolicy> retryPolicyList = ((SyncFailRetryPolicy) new Gson().fromJson(syncFailRetryPolicy, SyncFailRetryPolicy.class)).getRetryPolicyList();
                if (retryPolicyList != null && retryPolicyList.size() > 0) {
                    for (RetryPolicy retryPolicy : retryPolicyList) {
                        C11839m.m70686d("CloudSyncRetryUtil", "retry " + retryPolicy.toString());
                        map.put(retryPolicy.getSyncType(), retryPolicy);
                    }
                }
            } catch (JsonSyntaxException e10) {
                C11839m.m70686d("CloudSyncRetryUtil", "getOMRetryParam JsonSyntaxEx " + e10.getMessage());
                return map;
            }
        }
        return map;
    }

    /* renamed from: e */
    public static CloudSyncRetryInfo m17817e(Context context, String str) {
        if (context == null) {
            C11839m.m70689w("CloudSyncRetryUtil", "getSyncResultFromSp mContext is null");
            return null;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70687e("CloudSyncRetryUtil", "CloudSyncRetryInfo is null");
            return null;
        }
        CloudSyncRetryInfo cloudSyncRetryInfo = new CloudSyncRetryInfo(sharedPreferencesM1382b.getInt(str + "_retry_" + ContentRecord.TASK_ID, 0), str, sharedPreferencesM1382b.getLong(str + "_retry_" + CalendarConfigTable.CalendarTable.Events.TIME, 0L), sharedPreferencesM1382b.getInt(str + "_retry_syncStatus", 0), sharedPreferencesM1382b.getLong(str + "_retry_retryTime", 0L), sharedPreferencesM1382b.getInt(str + "_retry_retryTimes", 0), sharedPreferencesM1382b.getBoolean(str + "_retry_isRetry", false));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CloudSyncRetryInfo ");
        sb2.append(cloudSyncRetryInfo.toString());
        C11839m.m70686d("CloudSyncRetryUtil", sb2.toString());
        return cloudSyncRetryInfo;
    }

    /* renamed from: f */
    public static String[] m17818f(Context context) {
        if (context == null) {
            C11839m.m70689w("CloudSyncRetryUtil", "getSyncTypesFromSp mContext is null");
            return null;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70687e("CloudSyncRetryUtil", "getSyncTypesFromSp CloudSyncRetryInfo is null");
            return null;
        }
        String string = sharedPreferencesM1382b.getString("retrySyncTypes", "");
        if (!TextUtils.isEmpty(string)) {
            return string.split(",");
        }
        C11839m.m70689w("CloudSyncRetryUtil", "getSyncTypesFromSp syncTypesSp is null");
        return null;
    }

    /* renamed from: g */
    public static boolean m17819g(Context context, String str) {
        if (context == null) {
            C11839m.m70689w("CloudSyncRetryUtil", "mContext is null");
            return true;
        }
        if (!"wlan".equals(str) && !"atlas".equals(str)) {
            return false;
        }
        C11839m.m70689w("CloudSyncRetryUtil", str + "not support OM retry");
        return true;
    }

    /* renamed from: h */
    public static void m17820h(String str, SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("retrySyncTypes", "");
        if (TextUtils.isEmpty(string)) {
            sharedPreferences.edit().putString("retrySyncTypes", str).commit();
            return;
        }
        sharedPreferences.edit().putString("retrySyncTypes", string + "," + str).commit();
    }

    /* renamed from: i */
    public static void m17821i(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b;
        if (m17819g(context, str) || (sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0)) == null) {
            return;
        }
        C11839m.m70686d("CloudSyncRetryUtil", "refreshStartSyncTaskToSp syncType :" + str);
        String string = sharedPreferencesM1382b.getString(str + "_retry_syncType", "");
        if (TextUtils.isEmpty(string)) {
            C11839m.m70686d("CloudSyncRetryUtil", "refreshStartSyncTaskToSp add syncTypeSp :" + string);
            m17820h(str, sharedPreferencesM1382b);
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.putInt(str + "_retry_taskId", 1);
            editorEdit.putString(str + "_retry_syncType", str);
            editorEdit.putLong(str + "_retry_syncTime", System.currentTimeMillis());
            editorEdit.putInt(str + "_retry_syncStatus", 1);
            editorEdit.putLong(str + "_retry_retryTime", 0L);
            editorEdit.putInt(str + "_retry_retryTimes", 0);
            editorEdit.putBoolean(str + "_retry_isRetry", false);
            editorEdit.commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m17822j(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.syncutil.C2973b.m17822j(android.content.Context, java.lang.String):void");
    }

    /* renamed from: k */
    public static void m17823k(Context context, int i10, String str, int i11, long j10, int i12, boolean z10) {
        if (context == null) {
            C11839m.m70689w("CloudSyncRetryUtil", "refreshSyncResultToSp mContext is null");
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0);
        if (sharedPreferencesM1382b != null) {
            C11839m.m70686d("CloudSyncRetryUtil", "refreshSyncResultToSp");
            sharedPreferencesM1382b.edit().putInt(str + "_retry_" + ContentRecord.TASK_ID, i10).commit();
            sharedPreferencesM1382b.edit().putString(str + "_retry_syncType", str).commit();
            sharedPreferencesM1382b.edit().putLong(str + "_retry_" + CalendarConfigTable.CalendarTable.Events.TIME, System.currentTimeMillis()).commit();
            sharedPreferencesM1382b.edit().putInt(str + "_retry_syncStatus", i11).commit();
            sharedPreferencesM1382b.edit().putLong(str + "_retry_retryTime", j10).commit();
            sharedPreferencesM1382b.edit().putInt(str + "_retry_retryTimes", i12).commit();
            sharedPreferencesM1382b.edit().putBoolean(str + "_retry_isRetry", z10).commit();
        }
    }

    /* renamed from: l */
    public static void m17824l(Context context, String str) {
        if (context == null) {
            C11839m.m70689w("CloudSyncRetryUtil", "refreshSyncRetryToSp mContext is null");
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0);
        if (sharedPreferencesM1382b != null) {
            int i10 = sharedPreferencesM1382b.getInt(str + "_retry_retryTimes", 0) + 1;
            C11839m.m70686d("CloudSyncRetryUtil", "refreshSyncRetryToSp syncType :" + str + ",retryTimes :" + i10);
            sharedPreferencesM1382b.edit().putLong(str + "_retry_retryTime", System.currentTimeMillis()).commit();
            sharedPreferencesM1382b.edit().putInt(str + "_retry_retryTimes", i10).commit();
        }
    }

    /* renamed from: m */
    public static void m17825m(Context context, String str, int i10, long j10, int i11, boolean z10) {
        if (context == null) {
            C11839m.m70689w("CloudSyncRetryUtil", "saveSyncResultToSp mContext is null");
            return;
        }
        if (!C10028c.m62182c0().m62388s(str)) {
            C11839m.m70689w("CloudSyncRetryUtil", "saveSyncResultToSp " + str + " the switch is not turned on.");
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70689w("CloudSyncRetryUtil", "saveSyncResultToSp syncSharedPre is null");
            return;
        }
        String string = sharedPreferencesM1382b.getString(str + "_retry_syncType", "");
        if (TextUtils.isEmpty(string)) {
            C11839m.m70686d("CloudSyncRetryUtil", "saveSyncResultToSp add syncTypeSp :" + string);
            m17823k(context, 1, str, i10, j10, i11, z10);
            m17820h(str, sharedPreferencesM1382b);
            return;
        }
        if (string.equals(str)) {
            C11839m.m70686d("CloudSyncRetryUtil", "saveSyncResultToSp refresh syncTypeSp :" + string);
            int i12 = sharedPreferencesM1382b.getInt(str + "_retry_" + ContentRecord.TASK_ID, 0);
            int i13 = sharedPreferencesM1382b.getInt(str + "_retry_retryTimes", 0);
            long j11 = sharedPreferencesM1382b.getLong(str + "_retry_retryTime", 0L);
            C11839m.m70686d("CloudSyncRetryUtil", "saveSyncResultToSp refresh retryTimesSp :" + i13 + ",retryTimeSp:" + j11);
            if (i10 == 0) {
                m17823k(context, i12, str, i10, 0L, 0, z10);
            } else {
                m17823k(context, i12, str, i10, j11, i13, z10);
            }
        }
    }

    /* renamed from: n */
    public static void m17826n(String str, Boolean bool) {
        f12997a.put(str, bool);
    }

    /* renamed from: o */
    public static void m17827o(String str, SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("retrySyncTypes", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(string.split(",")));
        arrayList.remove(str);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(",");
        }
        if (stringBuffer.length() <= 0) {
            sharedPreferences.edit().putString("retrySyncTypes", "").commit();
        } else {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            sharedPreferences.edit().putString("retrySyncTypes", stringBuffer.toString()).commit();
        }
    }
}
