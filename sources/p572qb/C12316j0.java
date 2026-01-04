package p572qb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.LruCache;
import ck.C1443a;
import com.huawei.android.hicloud.sync.bean.FileRetryList;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hms.network.embedded.C5863b6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0213f;
import p015ak.C0214f0;
import p292fn.C9733f;
import p514o9.C11839m;
import p523oi.C11903a;

/* renamed from: qb.j0 */
/* loaded from: classes3.dex */
public class C12316j0 {

    /* renamed from: a */
    public final List<Integer> f57040a;

    /* renamed from: b */
    public final LruCache<String, Long[]> f57041b;

    /* renamed from: c */
    public long f57042c;

    /* renamed from: d */
    public long f57043d;

    /* renamed from: e */
    public boolean f57044e;

    /* renamed from: f */
    public boolean f57045f;

    /* renamed from: qb.j0$b */
    public static class b {

        /* renamed from: a */
        public static final C12316j0 f57046a = new C12316j0();
    }

    /* renamed from: d */
    public static C12316j0 m74076d() {
        return b.f57046a;
    }

    /* renamed from: a */
    public void m74077a(String str, String str2, String str3, int i10) {
        if (str3 == null) {
            return;
        }
        m74080e();
        try {
            if (this.f57040a.contains(Integer.valueOf(i10))) {
                String strM74079c = m74079c(str, str2, str3);
                if (TextUtils.isEmpty(strM74079c)) {
                    return;
                }
                Long[] lArr = this.f57041b.get(strM74079c);
                if (lArr == null) {
                    lArr = new Long[]{1L, Long.valueOf(System.currentTimeMillis())};
                } else {
                    lArr[0] = Long.valueOf(lArr[0].longValue() + 1);
                    lArr[1] = Long.valueOf(System.currentTimeMillis());
                }
                this.f57041b.put(strM74079c, lArr);
                this.f57045f = true;
                C11839m.m70689w("SyncFileRetryManager", "addFailOver = " + strM74079c + ", errorCode = " + i10);
            }
        } catch (Exception e10) {
            C11839m.m70687e("SyncFileRetryManager", "addFailOver catch exception : " + e10);
        }
    }

    /* renamed from: b */
    public synchronized void m74078b() {
        SharedPreferences sharedPreferencesM1382b;
        C11839m.m70688i("SyncFileRetryManager", "clear");
        try {
            try {
                sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "sync_file_retry_sp", 0);
            } catch (Exception e10) {
                C11839m.m70687e("SyncFileRetryManager", "clear localRetryFileList catch exception : " + e10);
            }
            if (sharedPreferencesM1382b == null) {
                C11839m.m70687e("SyncFileRetryManager", "clear sharedPreferences is null");
            } else {
                sharedPreferencesM1382b.edit().clear().commit();
                C11839m.m70688i("SyncFileRetryManager", "clear finish");
            }
        } finally {
            this.f57044e = false;
        }
    }

    /* renamed from: c */
    public String m74079c(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    /* renamed from: e */
    public final synchronized void m74080e() {
        if (this.f57044e) {
            return;
        }
        C11839m.m70688i("SyncFileRetryManager", "init");
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        m74081f(hiCloudSysParamMapM60757p);
        m74084i(hiCloudSysParamMapM60757p);
        m74082g(hiCloudSysParamMapM60757p);
        m74083h();
        this.f57044e = true;
        C11839m.m70688i("SyncFileRetryManager", "init finish");
    }

    /* renamed from: f */
    public final void m74081f(HiCloudSysParamMap hiCloudSysParamMap) {
        String cloudSyncFileRetryErrorCode;
        this.f57040a.clear();
        if (hiCloudSysParamMap == null || TextUtils.isEmpty(hiCloudSysParamMap.getCloudSyncFileRetryErrorCode())) {
            C11839m.m70689w("SyncFileRetryManager", "initRetryCodeList, hiCloudSysParamMap is null or retryErrorCodeString is null");
            cloudSyncFileRetryErrorCode = "[404]";
        } else {
            cloudSyncFileRetryErrorCode = hiCloudSysParamMap.getCloudSyncFileRetryErrorCode();
        }
        try {
            C11839m.m70688i("SyncFileRetryManager", "initRetryCodeList retryErrorCodeString = " + cloudSyncFileRetryErrorCode);
            JSONArray jSONArray = new JSONArray(cloudSyncFileRetryErrorCode);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                this.f57040a.add(Integer.valueOf(jSONArray.getInt(i10)));
            }
            C11839m.m70688i("SyncFileRetryManager", "initRetryCodeList finish size = " + this.f57040a.size());
        } catch (JSONException unused) {
            C11839m.m70687e("SyncFileRetryManager", "initRetryCodeList catch JSONException");
        } catch (Exception e10) {
            C11839m.m70687e("SyncFileRetryManager", "initRetryCodeList catch exception : " + e10);
        }
    }

    /* renamed from: g */
    public final void m74082g(HiCloudSysParamMap hiCloudSysParamMap) {
        if (hiCloudSysParamMap == null) {
            C11839m.m70687e("SyncFileRetryManager", "initRetryCount, hiCloudSysParamMap is null");
            this.f57043d = 10L;
            return;
        }
        this.f57043d = hiCloudSysParamMap.getCloudSyncFileRetryCount();
        C11839m.m70688i("SyncFileRetryManager", "initRetryCount retryCount = " + this.f57043d);
    }

    /* renamed from: h */
    public final void m74083h() {
        this.f57041b.evictAll();
        this.f57045f = false;
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "sync_file_retry_sp", 0);
            if (sharedPreferencesM1382b == null) {
                C11839m.m70687e("SyncFileRetryManager", "initRetryFileList sharedPreferences is null");
                return;
            }
            String string = sharedPreferencesM1382b.getString("fileRetryList", "");
            if (TextUtils.isEmpty(string)) {
                C11839m.m70689w("SyncFileRetryManager", "localRetryFileListString is empty");
                return;
            }
            FileRetryList fileRetryList = (FileRetryList) C11903a.m71435l().mo69832e(string).m69886u(FileRetryList.class);
            if (fileRetryList != null && fileRetryList.getFileRetryList() != null && !fileRetryList.getFileRetryList().isEmpty()) {
                for (FileRetryList.FileRetry fileRetry : fileRetryList.getFileRetryList()) {
                    String fileKey = fileRetry.getFileKey();
                    if (!TextUtils.isEmpty(fileKey)) {
                        Long lastTime = fileRetry.getLastTime();
                        long jLongValue = lastTime.longValue();
                        Long requestCount = fileRetry.getRequestCount();
                        C11839m.m70686d("SyncFileRetryManager", "init put: " + fileKey + ", " + jLongValue + ", " + requestCount.longValue());
                        this.f57041b.put(fileKey, new Long[]{requestCount, lastTime});
                    }
                }
                C11839m.m70688i("SyncFileRetryManager", "initRetryFileList finish size = " + this.f57041b.size());
                return;
            }
            C11839m.m70689w("SyncFileRetryManager", "localRetryFileList is empty");
        } catch (Exception e10) {
            C11839m.m70687e("SyncFileRetryManager", "initRetryFileList catch exception : " + e10);
        }
    }

    /* renamed from: i */
    public final void m74084i(HiCloudSysParamMap hiCloudSysParamMap) {
        if (hiCloudSysParamMap == null) {
            C11839m.m70687e("SyncFileRetryManager", "initRetryInterval, hiCloudSysParamMap is null");
            this.f57042c = 86400000L;
            return;
        }
        int cloudSyncFileRetryInterval = hiCloudSysParamMap.getCloudSyncFileRetryInterval();
        C11839m.m70688i("SyncFileRetryManager", "initRetryInterval cloudRetryInterval = " + cloudSyncFileRetryInterval);
        this.f57042c = ((long) cloudSyncFileRetryInterval) * C5863b6.g.f26453g;
    }

    /* renamed from: j */
    public final boolean m74085j(String str) {
        Long[] lArr;
        if (TextUtils.isEmpty(str) || (lArr = this.f57041b.get(str)) == null || lArr.length <= 1) {
            return false;
        }
        this.f57045f = true;
        long jLongValue = lArr[1].longValue();
        long jLongValue2 = lArr[0].longValue();
        if (System.currentTimeMillis() - jLongValue > this.f57042c) {
            C11839m.m70689w("SyncFileRetryManager", "isFailOver remove = " + str);
            this.f57041b.remove(str);
            return false;
        }
        C11839m.m70689w("SyncFileRetryManager", "isFailOver = " + str + ", lastTime = " + jLongValue + ", count = " + jLongValue2);
        return jLongValue2 >= this.f57043d;
    }

    /* renamed from: k */
    public boolean m74086k(String str, String str2, String str3) {
        if (str3 == null) {
            return false;
        }
        m74080e();
        try {
            return m74085j(m74079c(str, str2, str3));
        } catch (Exception e10) {
            C11839m.m70687e("SyncFileRetryManager", "isFailOver catch exception : " + e10);
            return false;
        }
    }

    /* renamed from: l */
    public synchronized void m74087l() {
        SharedPreferences sharedPreferencesM1382b;
        C11839m.m70688i("SyncFileRetryManager", "refresh = " + this.f57045f);
        if (this.f57045f) {
            try {
                try {
                    sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "sync_file_retry_sp", 0);
                } catch (Exception e10) {
                    C11839m.m70687e("SyncFileRetryManager", "refresh localRetryFileList catch exception : " + e10);
                }
                if (sharedPreferencesM1382b == null) {
                    C11839m.m70687e("SyncFileRetryManager", "refresh sharedPreferences is null");
                    return;
                }
                SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
                editorEdit.clear();
                ArrayList<Map.Entry> arrayList = new ArrayList(this.f57041b.snapshot().entrySet());
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry entry : arrayList) {
                    String str = (String) entry.getKey();
                    Long[] lArr = (Long[]) entry.getValue();
                    if (lArr.length > 1 && System.currentTimeMillis() - lArr[1].longValue() <= this.f57042c) {
                        if (C1443a.f6214b.booleanValue()) {
                            C11839m.m70686d("SyncFileRetryManager", "refresh put: " + str + ", " + lArr[1]);
                        }
                        FileRetryList.FileRetry fileRetry = new FileRetryList.FileRetry();
                        fileRetry.setFileKey(str).setLastTime(lArr[1]).setRequestCount(lArr[0]);
                        arrayList2.add(fileRetry);
                    }
                }
                if (arrayList2.isEmpty()) {
                    editorEdit.putString("fileRetryList", "");
                } else {
                    FileRetryList fileRetryList = new FileRetryList();
                    fileRetryList.setFileRetryList(arrayList2);
                    editorEdit.putString("fileRetryList", fileRetryList.toString());
                }
                editorEdit.commit();
                C11839m.m70688i("SyncFileRetryManager", "refresh finish size = " + arrayList2.size());
            } finally {
                this.f57044e = false;
            }
        }
    }

    public C12316j0() {
        this.f57040a = new ArrayList();
        this.f57041b = new LruCache<>(500);
        this.f57044e = false;
        this.f57045f = false;
    }
}
