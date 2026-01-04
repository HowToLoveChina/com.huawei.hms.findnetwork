package p009a8;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.LruCache;
import ck.C1443a;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.drive.cloudphoto.model.FileRetryList;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hms.network.embedded.C5863b6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0213f;
import p015ak.C0214f0;
import p031b7.C1120a;
import p292fn.C9733f;
import p523oi.C11903a;

/* renamed from: a8.e */
/* loaded from: classes2.dex */
public class C0067e {

    /* renamed from: a */
    public final List<Integer> f215a;

    /* renamed from: b */
    public final LruCache<String, Long> f216b;

    /* renamed from: c */
    public long f217c;

    /* renamed from: d */
    public boolean f218d;

    /* renamed from: e */
    public boolean f219e;

    /* renamed from: a8.e$b */
    public static class b {

        /* renamed from: a */
        public static final C0067e f220a = new C0067e();
    }

    /* renamed from: e */
    public static C0067e m443e() {
        return b.f220a;
    }

    /* renamed from: a */
    public void m444a(FileInfo fileInfo, int i10, int i11) {
        if (fileInfo == null) {
            return;
        }
        m448f();
        try {
            if (this.f215a.contains(Integer.valueOf(i11))) {
                String strM446c = m446c(fileInfo, i10);
                if (TextUtils.isEmpty(strM446c)) {
                    return;
                }
                this.f216b.put(strM446c, Long.valueOf(System.currentTimeMillis()));
                this.f219e = true;
                C1120a.m6678w("PhotoFileRetryManager", "addFailOver = " + strM446c + ", errorCode = " + i11);
            }
        } catch (Exception e10) {
            C1120a.m6676e("PhotoFileRetryManager", "addFailOver catch exception : " + e10);
        }
    }

    /* renamed from: b */
    public synchronized void m445b() {
        SharedPreferences sharedPreferencesM1382b;
        C1120a.m6677i("PhotoFileRetryManager", "clear");
        try {
            try {
                sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "PhotoFileRetrySp", 0);
            } catch (Exception e10) {
                C1120a.m6676e("PhotoFileRetryManager", "clear localRetryFileList catch exception : " + e10);
            }
            if (sharedPreferencesM1382b == null) {
                C1120a.m6676e("PhotoFileRetryManager", "clear sharedPreferences is null");
            } else {
                sharedPreferencesM1382b.edit().clear().commit();
                C1120a.m6677i("PhotoFileRetryManager", "clear finish");
            }
        } finally {
            this.f218d = false;
        }
    }

    /* renamed from: c */
    public String m446c(FileInfo fileInfo, int i10) {
        String uniqueId;
        if (TextUtils.isEmpty(fileInfo.getShareId())) {
            if (TextUtils.isEmpty(fileInfo.getUniqueId())) {
                return null;
            }
            uniqueId = fileInfo.getUniqueId();
        } else {
            if (TextUtils.isEmpty(fileInfo.getHash())) {
                return null;
            }
            uniqueId = fileInfo.getShareId() + "_" + fileInfo.getHash();
        }
        return uniqueId + "_" + i10;
    }

    /* renamed from: d */
    public String m447d(FileData fileData, int i10, boolean z10) {
        String uniqueId;
        if (z10) {
            if (TextUtils.isEmpty(fileData.getAlbumId()) || TextUtils.isEmpty(fileData.getHash())) {
                return null;
            }
            uniqueId = fileData.getAlbumId() + "_" + fileData.getHash();
        } else {
            if (TextUtils.isEmpty(fileData.getUniqueId())) {
                return null;
            }
            uniqueId = fileData.getUniqueId();
        }
        return uniqueId + "_" + i10;
    }

    /* renamed from: f */
    public final synchronized void m448f() {
        if (this.f218d) {
            return;
        }
        C1120a.m6677i("PhotoFileRetryManager", "init");
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        m449g(hiCloudSysParamMapM60757p);
        m451i(hiCloudSysParamMapM60757p);
        m450h();
        this.f218d = true;
        C1120a.m6677i("PhotoFileRetryManager", "init finish");
    }

    /* renamed from: g */
    public final void m449g(HiCloudSysParamMap hiCloudSysParamMap) {
        String cloudPhotoFileRetryErrorCode;
        this.f215a.clear();
        if (hiCloudSysParamMap == null || TextUtils.isEmpty(hiCloudSysParamMap.getCloudPhotoFileRetryErrorCode())) {
            C1120a.m6678w("PhotoFileRetryManager", "initRetryCodeList, hiCloudSysParamMap is null or retryErrorCodeString is null");
            cloudPhotoFileRetryErrorCode = "[404]";
        } else {
            cloudPhotoFileRetryErrorCode = hiCloudSysParamMap.getCloudPhotoFileRetryErrorCode();
        }
        try {
            C1120a.m6677i("PhotoFileRetryManager", "retryErrorCodeString = " + cloudPhotoFileRetryErrorCode);
            JSONArray jSONArray = new JSONArray(cloudPhotoFileRetryErrorCode);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                this.f215a.add(Integer.valueOf(jSONArray.getInt(i10)));
            }
            C1120a.m6677i("PhotoFileRetryManager", "initRetryCodeList finish size = " + this.f215a.size());
        } catch (JSONException unused) {
            C1120a.m6676e("PhotoFileRetryManager", "initRetryCodeList catch JSONException");
        } catch (Exception e10) {
            C1120a.m6676e("PhotoFileRetryManager", "initRetryCodeList catch exception : " + e10);
        }
    }

    /* renamed from: h */
    public final void m450h() {
        this.f216b.evictAll();
        this.f219e = false;
        try {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "PhotoFileRetrySp", 0);
            if (sharedPreferencesM1382b == null) {
                C1120a.m6676e("PhotoFileRetryManager", "initRetryFileList sharedPreferences is null");
                return;
            }
            String string = sharedPreferencesM1382b.getString("fileRetryList", "");
            if (TextUtils.isEmpty(string)) {
                C1120a.m6678w("PhotoFileRetryManager", "localRetryFileListString is empty");
                return;
            }
            FileRetryList fileRetryList = (FileRetryList) C11903a.m71435l().mo69832e(string).m69886u(FileRetryList.class);
            if (fileRetryList != null && fileRetryList.getFileRetryList() != null && !fileRetryList.getFileRetryList().isEmpty()) {
                for (FileRetryList.FileRetry fileRetry : fileRetryList.getFileRetryList()) {
                    String fileKey = fileRetry.getFileKey();
                    Long lastTime = fileRetry.getLastTime();
                    long jLongValue = lastTime.longValue();
                    if (!TextUtils.isEmpty(fileKey)) {
                        if (C1443a.f6214b.booleanValue()) {
                            C1120a.m6675d("PhotoFileRetryManager", "init put: " + fileKey + ", " + jLongValue);
                        }
                        this.f216b.put(fileKey, lastTime);
                    }
                }
                C1120a.m6677i("PhotoFileRetryManager", "initRetryFileList finish size = " + this.f216b.size());
                return;
            }
            C1120a.m6678w("PhotoFileRetryManager", "localRetryFileList is empty");
        } catch (Exception e10) {
            C1120a.m6676e("PhotoFileRetryManager", "initRetryFileList catch exception : " + e10);
        }
    }

    /* renamed from: i */
    public final void m451i(HiCloudSysParamMap hiCloudSysParamMap) {
        if (hiCloudSysParamMap == null) {
            C1120a.m6676e("PhotoFileRetryManager", "initRetryInterval, hiCloudSysParamMap is null");
            this.f217c = 86400000L;
            return;
        }
        int cloudPhotoFileRetryInterval = hiCloudSysParamMap.getCloudPhotoFileRetryInterval();
        C1120a.m6677i("PhotoFileRetryManager", "cloudRetryInterval = " + cloudPhotoFileRetryInterval);
        this.f217c = ((long) cloudPhotoFileRetryInterval) * C5863b6.g.f26453g;
    }

    /* renamed from: j */
    public boolean m452j(FileInfo fileInfo, int i10) {
        if (fileInfo == null) {
            return false;
        }
        m448f();
        try {
            return m454l(m446c(fileInfo, i10));
        } catch (Exception e10) {
            C1120a.m6676e("PhotoFileRetryManager", "isFailOver catch exception : " + e10);
            return false;
        }
    }

    /* renamed from: k */
    public boolean m453k(FileData fileData, int i10, boolean z10) {
        if (fileData == null) {
            return false;
        }
        m448f();
        try {
            return m454l(m447d(fileData, i10, z10));
        } catch (Exception e10) {
            C1120a.m6676e("PhotoFileRetryManager", "isFailOver catch exception : " + e10);
            return false;
        }
    }

    /* renamed from: l */
    public final boolean m454l(String str) {
        Long l10;
        if (TextUtils.isEmpty(str) || (l10 = this.f216b.get(str)) == null) {
            return false;
        }
        this.f219e = true;
        if (System.currentTimeMillis() - l10.longValue() > this.f217c) {
            this.f216b.remove(str);
            return false;
        }
        C1120a.m6678w("PhotoFileRetryManager", "isFailOver = " + str + ", lastTime = " + l10);
        return true;
    }

    /* renamed from: m */
    public synchronized void m455m() {
        SharedPreferences sharedPreferencesM1382b;
        C1120a.m6677i("PhotoFileRetryManager", "refresh = " + this.f219e);
        if (this.f219e) {
            try {
                try {
                    sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "PhotoFileRetrySp", 0);
                } catch (Exception e10) {
                    C1120a.m6676e("PhotoFileRetryManager", "refresh localRetryFileList catch exception : " + e10);
                }
                if (sharedPreferencesM1382b == null) {
                    C1120a.m6676e("PhotoFileRetryManager", "refresh sharedPreferences is null");
                    return;
                }
                SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
                editorEdit.clear();
                ArrayList<Map.Entry> arrayList = new ArrayList(this.f216b.snapshot().entrySet());
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry entry : arrayList) {
                    String str = (String) entry.getKey();
                    Long l10 = (Long) entry.getValue();
                    long jLongValue = l10.longValue();
                    if (System.currentTimeMillis() - jLongValue <= this.f217c) {
                        if (C1443a.f6214b.booleanValue()) {
                            C1120a.m6675d("PhotoFileRetryManager", "refresh put: " + str + ", " + jLongValue);
                        }
                        FileRetryList.FileRetry fileRetry = new FileRetryList.FileRetry();
                        fileRetry.setFileKey(str).setLastTime(l10);
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
                C1120a.m6677i("PhotoFileRetryManager", "refresh finish size = " + arrayList2.size());
            } finally {
                this.f218d = false;
            }
        }
    }

    public C0067e() {
        this.f215a = new ArrayList();
        this.f216b = new LruCache<>(1000);
        this.f218d = false;
        this.f219e = false;
    }
}
