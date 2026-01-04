package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0214f0;
import p514o9.C11839m;
import p684un.C13226e;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.d */
/* loaded from: classes3.dex */
public class C2975d {
    /* renamed from: a */
    public static void m17837a(Context context, String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", "HW_HISYNC");
        linkedHashMap.put("value", str);
        C13226e.m79491f1().m79571T(linkedHashMap);
        UBAAnalyze.m29949J("CKC", "HW_HISYNC", "value", str);
    }

    /* renamed from: b */
    public static void m17838b(Context context, int i10, int i11, int i12, int i13, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hwid", C13452e.m80781L().m80982w());
            jSONObject.put("lcn", i10);
            jSONObject.put("ccn", i11);
            jSONObject.put("occ", i12);
            jSONObject.put("type", i13);
            jSONObject.put("uuid", str);
        } catch (JSONException e10) {
            C11839m.m70688i("ContactSyncBIUtil", "reportBeginSync JSONException : " + e10.toString());
        }
        m17837a(context, jSONObject.toString());
    }

    /* renamed from: c */
    public static void m17839c(Context context, int i10, int i11, int i12, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hwid", C13452e.m80781L().m80982w());
            jSONObject.put(SyncProtocol.Constant.ADD, i10);
            jSONObject.put("del", i11);
            jSONObject.put(CloudBackupConstant.Command.PMS_OPTION_DIR, i12);
            jSONObject.put("type", 8);
            jSONObject.put("uuid", str);
        } catch (JSONException e10) {
            C11839m.m70688i("ContactSyncBIUtil", "reportDirtyNumBeforeSync JSONException : " + e10.toString());
        }
        m17837a(context, jSONObject.toString());
    }

    /* renamed from: d */
    public static void m17840d(Context context, int i10, int i11, int i12, int i13, String str, String str2) throws JSONException {
        int i14;
        int i15;
        int i16;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hwid", C13452e.m80781L().m80982w());
            jSONObject.put("lcn", i10);
            jSONObject.put("ccn", i11);
            jSONObject.put("occ", i12);
            jSONObject.put("rcode", i13);
            if (!"".equals(str)) {
                jSONObject.put("rmesg", str);
            }
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "sync_contact_spfile", 0);
            int i17 = sharedPreferencesM1382b.getInt("sync_localContactadd", 0);
            int i18 = sharedPreferencesM1382b.getInt("sync_localContactdelete", 0);
            int i19 = sharedPreferencesM1382b.getInt("sync_localContactreplace", 0);
            if (i13 == 200) {
                i14 = sharedPreferencesM1382b.getInt("sync_cloudContactadd", 0);
                i16 = sharedPreferencesM1382b.getInt("sync_cloudContactdelete", 0);
                i15 = sharedPreferencesM1382b.getInt("sync_cloudContactreplace", 0);
            } else {
                i14 = -1;
                i15 = -1;
                i16 = -1;
            }
            jSONObject.put("loc_add", i17);
            jSONObject.put("loc_del", i18);
            jSONObject.put("loc_upd", i19);
            jSONObject.put("cld_add", i14);
            jSONObject.put("cld_del", i16);
            jSONObject.put("cld_upd", i15);
            jSONObject.put("type", 12);
            jSONObject.put("uuid", str2);
        } catch (JSONException e10) {
            C11839m.m70688i("ContactSyncBIUtil", "reportEndSyncResult JSONException : " + e10.toString());
        }
        m17837a(context, jSONObject.toString());
    }
}
