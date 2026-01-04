package com.huawei.hianalytics.kit;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hianalytics.C4785j;
import com.huawei.hianalytics.C4808u0;
import com.huawei.hianalytics.C4810v0;
import com.huawei.hianalytics.C4812w0;
import com.huawei.hianalytics.C4814x0;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.data.IAesKeyGetter;
import com.huawei.hianalytics.framework.data.WorkKeyHandler;
import com.huawei.hianalytics.kit.AesKeyGetterImpl;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hmf.tasks.Task;
import eu.C9560a;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.InterfaceC8937e;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes5.dex */
public class AesKeyGetterImpl implements IAesKeyGetter {
    public static final String TAG = "AesKeyGetterImpl";

    private void handleQoesRespons(String str, IAesKeyGetter.Callback callback) {
        String str2;
        if (callback == null) {
            str2 = "request aes key without callback";
        } else {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("status") != 200) {
                        HiLog.m28809i(TAG, "request aes key status code 500");
                        return;
                    }
                    long jOptLong = jSONObject.optLong("key_timestamp");
                    long jOptLong2 = jSONObject.optLong("key_ttl_timestamp");
                    if (jOptLong == 0) {
                        long jOptLong3 = jSONObject.optLong("key_time");
                        long jOptLong4 = jSONObject.optLong("key_ttl");
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        jOptLong = jCurrentTimeMillis - (jElapsedRealtime - jOptLong3);
                        jOptLong2 = jCurrentTimeMillis - (jElapsedRealtime - jOptLong4);
                    }
                    long j10 = jOptLong;
                    long j11 = jOptLong2;
                    String strOptString = jSONObject.optString("key");
                    String strOptString2 = jSONObject.optString("chifer");
                    String strOptString3 = jSONObject.optString("version");
                    WorkKeyHandler.WorkKeyBean workKeyBean = new WorkKeyHandler.WorkKeyBean();
                    workKeyBean.setEncrypted(strOptString2);
                    workKeyBean.setWorkKey(strOptString);
                    workKeyBean.setUploadTime(j10);
                    workKeyBean.setKeyTtlTime(j11);
                    workKeyBean.setPubKeyVer(strOptString3);
                    workKeyBean.setSource(1);
                    callback.onResult(workKeyBean);
                    refreshWorkKeyToSP(strOptString2, strOptString3, strOptString, j10, j11, 1);
                    HiLog.m28809i(TAG, "request aes key success");
                    return;
                } catch (JSONException unused) {
                    HiLog.m28808e(TAG, "request aes key error");
                    return;
                }
            }
            str2 = "request aes key failed, rsp is empty";
        }
        HiLog.m28809i(TAG, str2);
    }

    private void refreshWorkKeyToSP(String str, String str2, String str3, long j10, long j11, int i10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ha_aes_key_encrypted", str);
            jSONObject.put("ha_aes_key_encrypted_version", str2);
            jSONObject.put("ha_aes_key", C9560a.m59680i("HiAnalytics_Ha_Aes_Sp_Key", str3));
            jSONObject.put("ha_aes_key_timestamp", j10);
            jSONObject.put("ha_aes_key_ttl_timestamp", j11);
            jSONObject.put("ha_aes_key_source", i10);
            C4785j.m28918a("Privacy_MY", "ha_aes_key_json", jSONObject.toString());
        } catch (JSONException unused) {
            HiLog.m28808e(TAG, "put report aes key sp");
        }
    }

    private void reportRequest(int i10) {
        String str;
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
        if (instanceByTag == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("$code", String.valueOf(i10));
        switch (i10) {
            case 401:
                str = "QoES request failed because device is not Huawei device";
                break;
            case 402:
                str = "QoES request failed because hms base is not exist";
                break;
            case 403:
                str = "QoES request failed because context is null";
                break;
            default:
                instanceByTag.onEvent(1, "$request_key", linkedHashMap);
        }
        linkedHashMap.put("$message", str);
        instanceByTag.onEvent(1, "$request_key", linkedHashMap);
    }

    @Override // com.huawei.hianalytics.framework.data.IAesKeyGetter
    public WorkKeyHandler.WorkKeyBean getWorkKeyBeanFromDisk() {
        String str;
        int i10;
        String str2;
        String strM28908a = C4785j.m28908a("Privacy_MY", "ha_aes_key_json", "");
        if (TextUtils.isEmpty(strM28908a)) {
            return new WorkKeyHandler.WorkKeyBean();
        }
        try {
            JSONObject jSONObject = new JSONObject(strM28908a);
            long jOptLong = jSONObject.optLong("ha_aes_key_timestamp");
            long jOptLong2 = jSONObject.optLong("ha_aes_key_ttl_timestamp");
            String strOptString = jSONObject.optString("ha_aes_key_encrypted");
            String strOptString2 = jSONObject.optString("ha_aes_key_encrypted_version");
            String strM59677f = C9560a.m59677f("HiAnalytics_Ha_Aes_Sp_Key", jSONObject.optString("ha_aes_key"));
            int iOptInt = jSONObject.optInt("ha_aes_key_source", 0);
            if (jOptLong == 0) {
                long jOptLong3 = jSONObject.optLong("ha_aes_key_time");
                long jOptLong4 = jSONObject.optLong("ha_aes_key_ttl_time");
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (jOptLong3 >= jElapsedRealtime || jElapsedRealtime >= jOptLong4) {
                    str = strM59677f;
                    i10 = iOptInt;
                    str2 = strOptString2;
                    C4785j.m28918a("Privacy_MY", "ha_aes_key_json", "");
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    jOptLong = jCurrentTimeMillis - (jElapsedRealtime - jOptLong3);
                    jOptLong2 = jCurrentTimeMillis - (jElapsedRealtime - jOptLong4);
                    str = strM59677f;
                    refreshWorkKeyToSP(strOptString, strOptString2, strM59677f, jOptLong, jOptLong2, iOptInt);
                    i10 = iOptInt;
                    str2 = strOptString2;
                }
            } else {
                str = strM59677f;
                i10 = iOptInt;
                str2 = strOptString2;
            }
            WorkKeyHandler.WorkKeyBean workKeyBean = new WorkKeyHandler.WorkKeyBean();
            workKeyBean.setEncrypted(strOptString);
            workKeyBean.setWorkKey(str);
            workKeyBean.setUploadTime(jOptLong);
            workKeyBean.setKeyTtlTime(jOptLong2);
            workKeyBean.setPubKeyVer(str2);
            workKeyBean.setSource(i10);
            return workKeyBean;
        } catch (JSONException unused) {
            HiLog.m28808e(TAG, "obtain report aes key");
            return new WorkKeyHandler.WorkKeyBean();
        }
    }

    @Override // com.huawei.hianalytics.framework.data.IAesKeyGetter
    public void requestAesKey(String str, final IAesKeyGetter.Callback callback) {
        if (!C4785j.m28949f()) {
            reportRequest(401);
            return;
        }
        if (!C4814x0.m29057a(true)) {
            reportRequest(402);
            return;
        }
        if (EnvUtils.getAppContext() == null) {
            reportRequest(403);
            return;
        }
        HiAnalyticsClientImpl hiAnalyticsClientImpl = new HiAnalyticsClientImpl(EnvUtils.getAppContext(), new C4810v0());
        hiAnalyticsClientImpl.setApiLevel(1);
        hiAnalyticsClientImpl.setKitSdkVersion(302130500);
        hiAnalyticsClientImpl.getAesKey(new C4808u0("get_key", C4785j.m28939c(), str, C4785j.m28946e())).addOnFailureListener(new InterfaceC8938f() { // from class: sj.a
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                HiLog.m28812w(AesKeyGetterImpl.TAG, "request aes key failed");
            }
        }).addOnSuccessListener(new InterfaceC8939g() { // from class: sj.b
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f58504a.m28958a(callback, (C4812w0) obj);
            }
        }).addOnCompleteListener(new InterfaceC8937e() { // from class: sj.c
            @Override // p208cq.InterfaceC8937e
            public final void onComplete(Task task) throws JSONException {
                this.f58506a.m28960a(task);
            }
        });
    }

    @Override // com.huawei.hianalytics.framework.data.IAesKeyGetter
    public void saveWorkKeyBeanToDisk(WorkKeyHandler.WorkKeyBean workKeyBean) throws JSONException {
        if (workKeyBean == null) {
            return;
        }
        refreshWorkKeyToSP(workKeyBean.getEncrypted(), workKeyBean.getPubKeyVer(), workKeyBean.getWorkKey(), workKeyBean.getUploadTime(), workKeyBean.getKeyTtlTime(), workKeyBean.getSource());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28958a(IAesKeyGetter.Callback callback, C4812w0 c4812w0) {
        handleQoesRespons(c4812w0.f21973a, callback);
    }

    private void reportRequest(JSONObject jSONObject) {
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
        if (instanceByTag == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (TextUtils.isEmpty(jSONObject.optString("message"))) {
            linkedHashMap.put("$code", jSONObject.optString("status"));
        } else {
            linkedHashMap.put("$code", String.valueOf(jSONObject.optInt("status")));
            linkedHashMap.put("$message", jSONObject.optString("message"));
            linkedHashMap.put("$version", jSONObject.optString("version"));
            linkedHashMap.put("$type", jSONObject.optString("key_type"));
        }
        instanceByTag.onEvent(1, "$request_key", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28960a(Task task) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (task.isSuccessful()) {
                jSONObject = new JSONObject(((C4812w0) task.getResult()).f21973a);
            } else {
                jSONObject.put("status", task.getException().getMessage());
            }
        } catch (JSONException unused) {
            HiLog.m28808e(TAG, "report request aes key");
        }
        reportRequest(jSONObject);
    }
}
