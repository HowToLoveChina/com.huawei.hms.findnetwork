package com.huawei.android.hicloud.complexutil;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.SyncFlowControlPolicyExtInfo;
import com.huawei.hicloud.bean.SyncFlowControlTime;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import je.C10812z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p292fn.C9733f;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.complexutil.g */
/* loaded from: classes3.dex */
public class C2786g {

    /* renamed from: a */
    public static final ConcurrentHashMap<String, b> f12097a = new ConcurrentHashMap<>();

    /* renamed from: com.huawei.android.hicloud.complexutil.g$b */
    public static class b {

        /* renamed from: a */
        public String f12098a;

        /* renamed from: b */
        public boolean f12099b;

        /* renamed from: c */
        public int f12100c;

        public b() {
            this.f12099b = false;
            this.f12100c = 0;
        }

        /* renamed from: b */
        public int m16226b() {
            return this.f12100c;
        }

        /* renamed from: c */
        public boolean m16227c() {
            return this.f12099b;
        }

        /* renamed from: d */
        public void m16228d(boolean z10) {
            this.f12099b = z10;
        }

        /* renamed from: e */
        public void m16229e(String str) {
            this.f12098a = str;
        }

        /* renamed from: f */
        public void m16230f(int i10) {
            this.f12100c = i10;
        }

        public String toString() {
            return new Gson().toJson(this);
        }
    }

    /* renamed from: a */
    public static void m16212a(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = f12097a;
        b bVar = concurrentHashMap.get(str);
        if (bVar == null) {
            bVar = new b();
        }
        bVar.m16229e(str);
        bVar.m16228d(true);
        bVar.m16230f(bVar.m16226b() + 1);
        concurrentHashMap.put(str, bVar);
        C11839m.m70688i("SyncSuppressUtil", "addFlowControlInfo syncType: " + str + ", times: " + concurrentHashMap.get(str));
    }

    /* renamed from: b */
    public static void m16213b() {
        C11839m.m70688i("SyncSuppressUtil", "clearFlowControlInfoMap");
        f12097a.clear();
    }

    /* renamed from: c */
    public static void m16214c(Context context, String str, String str2) throws JSONException, InterruptedException {
        int iM1260h0;
        try {
            String strM16217f = m16217f();
            if (TextUtils.isEmpty(strM16217f)) {
                C11839m.m70689w("SyncSuppressUtil", "syncSuppressionPolicy null");
                return;
            }
            JSONArray jSONArray = new JSONArray(strM16217f);
            if (jSONArray.length() == 0) {
                C11839m.m70688i("SyncSuppressUtil", "no syncSuppressionPolicy");
                return;
            }
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= jSONArray.length()) {
                    iM1260h0 = 0;
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                String string = jSONObject.getString("syncType");
                if (!TextUtils.isEmpty(string) && str2.equals(string)) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("timePeriodList");
                    if (jSONArray2.length() == 0) {
                        C11839m.m70689w("SyncSuppressUtil", "timePeriodList is null");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i10 < jSONArray2.length()) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i10);
                        if (jSONObject2 == null) {
                            C11839m.m70689w("SyncSuppressUtil", "no timePeriod");
                            return;
                        }
                        String string2 = jSONObject2.getString("begin");
                        String string3 = jSONObject2.getString("end");
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                            arrayList.add(string2);
                            arrayList2.add(string3);
                            i10++;
                        }
                        C11839m.m70689w("SyncSuppressUtil", "no begin or end time");
                        return;
                    }
                    if (!arrayList.isEmpty() && !arrayList2.isEmpty()) {
                        int i12 = jSONObject.has("maxSleepTime") ? jSONObject.getInt("maxSleepTime") : 120;
                        if (!C0209d.m1289o1((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]))) {
                            C11839m.m70689w("SyncSuppressUtil", "timePeriod not match");
                            return;
                        } else {
                            i10 = 1;
                            iM1260h0 = C0209d.m1260h0(1, i12);
                        }
                    }
                    C11839m.m70689w("SyncSuppressUtil", "startList or endList is Empty");
                    return;
                }
                i11++;
            }
            if (i10 == 0 || iM1260h0 <= 0) {
                return;
            }
            C11839m.m70688i("SyncSuppressUtil", "checkSyncDelay: " + str2 + ", delay: " + iM1260h0);
            try {
                Thread.sleep(iM1260h0 * 1000);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("control_time", String.valueOf(iM1260h0));
                C10812z.m65846o(context, str2, 0, "", "03001", "flow_control", str, linkedHashMap, false);
            } catch (InterruptedException unused) {
                C11839m.m70687e("SyncSuppressUtil", "checkSyncDelay InterruptedException");
            }
        } catch (Exception e10) {
            C11839m.m70687e("SyncSuppressUtil", "checkSyncDelay syncSuppressionPolicy error: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public static void m16215d(Context context, String str, String str2) throws InterruptedException {
        try {
            if (m16218g(str2) && m16216e(str2) != 0) {
                HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
                if (hiCloudSysParamMapM60757p == null) {
                    C11839m.m70689w("SyncSuppressUtil", "doSyncBackoffStrategy, hiCloudSysParamMap null");
                    return;
                }
                String syncFlowControlRetryPolicy = hiCloudSysParamMapM60757p.getSyncFlowControlRetryPolicy();
                if (TextUtils.isEmpty(syncFlowControlRetryPolicy)) {
                    C11839m.m70689w("SyncSuppressUtil", "doSyncBackoffStrategy, syncFlowControlRetryPolicy is null");
                    return;
                }
                JSONObject jSONObject = new JSONObject(syncFlowControlRetryPolicy);
                int i10 = jSONObject.has("firstRetryInterval") ? jSONObject.getInt("firstRetryInterval") : 10;
                int i11 = jSONObject.has("retrySleepTime") ? jSONObject.getInt("retrySleepTime") : 30;
                int iM16216e = m16216e(str2);
                int iPow = (((int) Math.pow(2.0d, iM16216e - 1)) * i10) + C0209d.m1260h0(1, i11);
                try {
                    C11839m.m70689w("SyncSuppressUtil", "doSyncBackoffStrategy, sleep time = " + iPow);
                    Thread.sleep(((long) iPow) * 1000);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("control_time", String.valueOf(iPow));
                    linkedHashMap.put("control_times_count", String.valueOf(iM16216e));
                    C10812z.m65846o(context, str2, 0, "", "03001", "server_flow_control_retry", str, linkedHashMap, false);
                    return;
                } catch (Exception e10) {
                    C11839m.m70687e("SyncSuppressUtil", "doSyncBackoffStrategy exception " + e10.getMessage());
                    return;
                }
            }
            C11839m.m70689w("SyncSuppressUtil", "doSyncBackoffStrategy, never flow control");
        } catch (Exception e11) {
            C11839m.m70687e("SyncSuppressUtil", "doSyncBackoffStrategy error: " + e11.getMessage());
        }
    }

    /* renamed from: e */
    public static int m16216e(String str) {
        b bVar;
        if (TextUtils.isEmpty(str) || (bVar = f12097a.get(str)) == null || !bVar.f12099b) {
            return 0;
        }
        int iM16226b = bVar.m16226b();
        C11839m.m70688i("SyncSuppressUtil", "getFlowControlInfoOfTimes syncType: " + str + ", times: " + iM16226b);
        return iM16226b;
    }

    /* renamed from: f */
    public static String m16217f() {
        String syncSuppressionPolicy = HiCloudSysParamMapCache.getSyncSuppressionPolicy();
        if (!TextUtils.isEmpty(syncSuppressionPolicy)) {
            C11839m.m70686d("SyncSuppressUtil", "syncSuppressionPolicy from cache");
            return syncSuppressionPolicy;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return hiCloudSysParamMapM60757p.getSyncSuppressionPolicy();
        }
        C11839m.m70689w("SyncSuppressUtil", "hiCloudSysParamMap null");
        return null;
    }

    /* renamed from: g */
    public static boolean m16218g(String str) {
        b bVar;
        if (TextUtils.isEmpty(str) || (bVar = f12097a.get(str)) == null) {
            return false;
        }
        boolean zM16227c = bVar.m16227c();
        C11839m.m70688i("SyncSuppressUtil", "hasFlowControlInfo effect");
        return zM16227c;
    }

    /* renamed from: h */
    public static boolean m16219h(Context context, String str, String str2) {
        try {
        } catch (Exception e10) {
            C11839m.m70687e("SyncSuppressUtil", "syncFlowControl error " + e10.getMessage());
        }
        if (CloudSyncUtil.m15955I(context, str)) {
            C11839m.m70689w("SyncSuppressUtil", "isSyncFlowControlEffect first sync switch open");
            return false;
        }
        if (!C9733f.m60705z().m60727V()) {
            C11839m.m70689w("SyncSuppressUtil", "isSyncFlowControlEffect switch off");
            return false;
        }
        List<SyncFlowControlPolicyExtInfo> listM60711F = C9733f.m60705z().m60711F();
        if (listM60711F != null && !listM60711F.isEmpty()) {
            for (SyncFlowControlPolicyExtInfo syncFlowControlPolicyExtInfo : listM60711F) {
                if (syncFlowControlPolicyExtInfo != null) {
                    String syncType = syncFlowControlPolicyExtInfo.getSyncType();
                    if (!TextUtils.isEmpty(syncType) && TextUtils.equals(syncType, str)) {
                        String thirdAppVers = syncFlowControlPolicyExtInfo.getThirdAppVers();
                        if (!TextUtils.isEmpty(thirdAppVers) && !Pattern.compile(thirdAppVers).matcher(str2).matches()) {
                            C11839m.m70689w("SyncSuppressUtil", "isSyncFlowControlEffect 3rdApp not match, cur appVer = " + str2);
                            return false;
                        }
                        List<SyncFlowControlTime> timePeriodList = syncFlowControlPolicyExtInfo.getTimePeriodList();
                        if (timePeriodList != null && !timePeriodList.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            for (SyncFlowControlTime syncFlowControlTime : timePeriodList) {
                                if (syncFlowControlTime != null) {
                                    String begin = syncFlowControlTime.getBegin();
                                    String end = syncFlowControlTime.getEnd();
                                    if (!TextUtils.isEmpty(begin) && !TextUtils.isEmpty(end)) {
                                        arrayList.add(begin);
                                        arrayList2.add(end);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty() && !arrayList2.isEmpty() && C0209d.m1289o1((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]))) {
                                if (new SecureRandom().nextFloat() < syncFlowControlPolicyExtInfo.getRandomFactor()) {
                                    C11839m.m70689w("SyncSuppressUtil", "isSyncFlowControlEffect randomFactor not match");
                                    return false;
                                }
                                C11839m.m70689w("SyncSuppressUtil", "syncFlowControl all conditions are met, effective = true, syncType = " + str);
                                return true;
                            }
                            C11839m.m70689w("SyncSuppressUtil", "isSyncFlowControlEffect timePeriod not match");
                            return false;
                        }
                        C11839m.m70689w("SyncSuppressUtil", "isSyncFlowControlEffect timePeriod is empty");
                        return false;
                    }
                }
            }
            return false;
        }
        C11839m.m70689w("SyncSuppressUtil", "isSyncFlowControlEffect parameter is null");
        return false;
    }

    /* renamed from: i */
    public static void m16220i(String str, SharedPreferences sharedPreferences, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        if (sharedPreferences == null || concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        if (sharedPreferences.getInt(str + "sync_retcode", -1) != Integer.parseInt("4293")) {
            concurrentHashMap.put(str, Boolean.FALSE);
            m16221j(str);
        }
    }

    /* renamed from: j */
    public static void m16221j(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = f12097a;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        concurrentHashMap.remove(str);
        C11839m.m70688i("SyncSuppressUtil", "removeFlowControlInfo: " + str + ", size: " + concurrentHashMap.size());
    }

    /* renamed from: k */
    public static void m16222k(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        concurrentHashMap.putIfAbsent(str, bool);
        if (bool.equals(concurrentHashMap.get(str))) {
            C11839m.m70688i("SyncSuppressUtil", "syncV2 saveFlowControlTimesToMemory, add count");
            m16212a(str);
        }
    }

    /* renamed from: l */
    public static void m16223l(Context context, String str, String str2, ConcurrentHashMap<String, Boolean> concurrentHashMap) throws InterruptedException {
        if (!CloudSyncUtil.m15955I(context, str2)) {
            m16215d(context, str, str2);
            return;
        }
        m16221j(str2);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str2, Boolean.FALSE);
        }
    }

    /* renamed from: m */
    public static void m16224m(Context context, String str, String str2) throws JSONException, InterruptedException {
        if (CloudSyncUtil.m15955I(context, str2)) {
            return;
        }
        m16214c(context, str, str2);
    }
}
