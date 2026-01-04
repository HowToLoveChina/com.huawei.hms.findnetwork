package p767x9;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hms.hquic.HQUICManager;
import com.huawei.hms.network.file.api.Callback;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.FileUploadCallback;
import com.huawei.hms.network.file.upload.api.PutRequest;
import com.huawei.hms.network.file.upload.api.UploadManager;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0213f;
import p292fn.C9733f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p652t9.EnumC12999a;

/* renamed from: x9.d */
/* loaded from: classes3.dex */
public class C13735d {

    /* renamed from: b */
    public static final C13735d f61738b = new C13735d();

    /* renamed from: c */
    public static final Map<EnumC12999a, UploadManager> f61739c = new HashMap();

    /* renamed from: d */
    public static final Map<EnumC12999a, DownloadManager> f61740d = new HashMap();

    /* renamed from: a */
    public final Object f61741a = new Object();

    /* renamed from: x9.d$a */
    public class a implements HQUICManager.HQUICInitCallback {
        public a() {
        }

        @Override // com.huawei.hms.hquic.HQUICManager.HQUICInitCallback
        public void onFail(Exception exc) {
            C11839m.m70688i("UpDownManager", "load quic apk fail");
        }

        @Override // com.huawei.hms.hquic.HQUICManager.HQUICInitCallback
        public void onSuccess() {
            C11839m.m70688i("UpDownManager", "load quic apk success");
        }
    }

    /* renamed from: x9.d$b */
    public class b extends AbstractC12367d {
        public b() {
        }

        /* renamed from: c */
        public final boolean m82553c(File file) {
            File[] fileArrM63440f;
            if (file == null || !file.exists()) {
                return true;
            }
            if (file.isDirectory() && (fileArrM63440f = C10278a.m63440f(file)) != null) {
                for (File file2 : fileArrM63440f) {
                    m82553c(file2);
                }
            }
            return file.delete();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            for (EnumC12999a enumC12999a : EnumC12999a.values()) {
                if (enumC12999a.m78145f() >= 1) {
                    UploadManager uploadManager = (UploadManager) C13735d.f61739c.get(enumC12999a);
                    if (uploadManager != null) {
                        uploadManager.destoryRequests();
                    }
                    DownloadManager downloadManager = (DownloadManager) C13735d.f61740d.get(enumC12999a);
                    if (downloadManager != null) {
                        downloadManager.destoryRequests();
                    }
                }
            }
            m82553c(C13735d.this.m82547q().getExternalCacheDir());
            m82553c(C13735d.this.m82547q().getCacheDir());
            m82553c(C10278a.m63442h("/data/data/com.huawei.hidisk/cache/"));
        }
    }

    /* renamed from: e */
    public static RequestConfig m82528e() {
        return RequestManager.newRequestConfigBuilder().connectTimeoutMillis(50000L).readTimeoutMillis(50000L).writeTimeoutMillis(50000L).pingIntervalMillis(50000L).retryTimes(3).build();
    }

    /* renamed from: f */
    public static RequestConfig m82529f(String str) {
        return RequestManager.newRequestConfigBuilder().connectTimeoutMillis(50000L).readTimeoutMillis(50000L).writeTimeoutMillis(50000L).pingIntervalMillis(50000L).retryTimes(3).options(str).build();
    }

    /* renamed from: r */
    public static ArrayList<String> m82530r() throws JSONException {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70687e("UpDownManager", "getEnableQuicDomainList, hiCloudSysParamMap is null");
            return new ArrayList<>();
        }
        String enableQuicDomainList = hiCloudSysParamMapM60757p.getEnableQuicDomainList();
        if (TextUtils.isEmpty(enableQuicDomainList)) {
            C11839m.m70687e("UpDownManager", "getEnableQuicDomainList, domainList is null");
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(enableQuicDomainList);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                    C11839m.m70686d("UpDownManager", "quic domain: " + string);
                }
            }
            C11839m.m70688i("UpDownManager", "getEnableQuicDomainList, domainList size = " + arrayList.size());
            return arrayList;
        } catch (Exception e10) {
            C11839m.m70687e("UpDownManager", "getEnableQuicDomainList catch exception: " + e10);
            return new ArrayList<>();
        }
    }

    /* renamed from: s */
    public static C13735d m82531s() {
        return f61738b;
    }

    /* renamed from: u */
    public static GetRequest.Builder m82532u() {
        return DownloadManager.newGetRequestBuilder().url("https://temp");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: v */
    public static PutRequest.Builder m82533v() {
        return (PutRequest.Builder) UploadManager.newPutRequestBuilder().url("https://temp");
    }

    /* renamed from: A */
    public void m82534A(EnumC12999a enumC12999a, List<Long> list) {
        m82535B(enumC12999a, list, null);
    }

    /* renamed from: B */
    public void m82535B(EnumC12999a enumC12999a, List<Long> list, String str) {
        synchronized (list) {
            try {
                C11839m.m70686d("UpDownManager", "pauseTasks:" + list);
                Iterator<Long> it = list.iterator();
                while (it.hasNext()) {
                    m82536d(enumC12999a, str).pauseRequest(it.next().longValue());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public DownloadManager m82536d(EnumC12999a enumC12999a, String str) {
        synchronized (this.f61741a) {
            try {
                Map<EnumC12999a, DownloadManager> map = f61740d;
                DownloadManager downloadManager = map.get(enumC12999a);
                if (downloadManager != null) {
                    return downloadManager;
                }
                GlobalRequestConfig.Builder builderWriteTimeoutMillis = RequestManager.newGlobalRequestConfigBuilder().threadPoolSize(enumC12999a.m78145f()).connectTimeoutMillis(50000L).readTimeoutMillis(50000L).writeTimeoutMillis(50000L);
                C11839m.m70688i("UpDownManager", "buildDownloadManager id = " + enumC12999a + " " + enumC12999a.m78145f());
                if (EnumC12999a.m78141h().contains(enumC12999a)) {
                    m82548t(C0213f.m1377a());
                    ArrayList<String> arrayListM82530r = m82530r();
                    if (!arrayListM82530r.isEmpty()) {
                        C11839m.m70688i("UpDownManager", "download quicHints success");
                        builderWriteTimeoutMillis.quicHints(arrayListM82530r);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    builderWriteTimeoutMillis.options(str);
                }
                DownloadManager downloadManagerBuild = new DownloadManager.Builder(enumC12999a.name()).commonConfig(builderWriteTimeoutMillis.build()).build(m82547q());
                map.put(enumC12999a, downloadManagerBuild);
                return downloadManagerBuild;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public final UploadManager m82537g(EnumC12999a enumC12999a) {
        UploadManager uploadManagerBuild;
        synchronized (this.f61741a) {
            try {
                Map<EnumC12999a, UploadManager> map = f61739c;
                uploadManagerBuild = map.get(enumC12999a);
                if (uploadManagerBuild == null) {
                    GlobalRequestConfig.Builder builderPingIntervalMillis = RequestManager.newGlobalRequestConfigBuilder().threadPoolSize(enumC12999a.m78145f()).connectTimeoutMillis(50000L).readTimeoutMillis(50000L).writeTimeoutMillis(50000L).pingIntervalMillis(50000L);
                    C11839m.m70688i("UpDownManager", "buildUploadManager id = " + enumC12999a + " " + enumC12999a.m78145f());
                    if (EnumC12999a.m78142k().contains(enumC12999a)) {
                        m82548t(C0213f.m1377a());
                        ArrayList<String> arrayListM82530r = m82530r();
                        if (!arrayListM82530r.isEmpty()) {
                            C11839m.m70688i("UpDownManager", "upload quicHints success");
                            builderPingIntervalMillis.quicHints(arrayListM82530r);
                        }
                    }
                    uploadManagerBuild = new UploadManager.Builder(enumC12999a.name()).commonConfig(builderPingIntervalMillis.build()).build(m82547q());
                    map.put(enumC12999a, uploadManagerBuild);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return uploadManagerBuild;
    }

    /* renamed from: h */
    public void m82538h(EnumC12999a enumC12999a, List<Long> list) {
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            m82537g(enumC12999a).cancelRequest(((Long) it.next()).longValue());
        }
    }

    /* renamed from: i */
    public void m82539i() {
        C12515a.m75110o().m75175e(new b(), false);
    }

    /* renamed from: j */
    public final GetRequest m82540j(EnumC12999a enumC12999a, GetRequest.Builder builder, FileRequestCallback fileRequestCallback, String str) throws C9721b {
        GetRequest getRequestBuild = builder.build();
        Result resultStart = m82536d(enumC12999a, str).start(getRequestBuild, (Callback) fileRequestCallback);
        if (resultStart == null || resultStart.getCode() != Result.SUCCESS) {
            throw new C9721b(4002, resultStart == null ? "result is null" : resultStart.toString(), "createDownloadTask");
        }
        C11839m.m70686d("UpDownManager", "getRequest success " + getRequestBuild.getId() + ":" + getRequestBuild.getOffset() + "/" + getRequestBuild.getFileSize());
        return getRequestBuild;
    }

    /* renamed from: k */
    public GetRequest m82541k(EnumC12999a enumC12999a, GetRequest.Builder builder, long j10, FileRequestCallback fileRequestCallback) throws C9721b {
        return m82542l(enumC12999a, builder, j10, fileRequestCallback, null);
    }

    /* renamed from: l */
    public GetRequest m82542l(EnumC12999a enumC12999a, GetRequest.Builder builder, long j10, FileRequestCallback fileRequestCallback, String str) throws C9721b {
        GetRequest request;
        DownloadManager downloadManagerM82536d = m82536d(enumC12999a, str);
        if (j10 >= 0 && (request = downloadManagerM82536d.getRequest(j10)) != null) {
            if (downloadManagerM82536d.getRequestStatus(j10) != Result.STATUS.PAUSE) {
                C11839m.m70686d("UpDownManager", "resumeRequest not PAUSE " + request.getId());
                return m82540j(enumC12999a, builder, fileRequestCallback, str);
            }
            if (downloadManagerM82536d.resumeRequest(request, (Callback) fileRequestCallback).getCode() != Result.SUCCESS) {
                C11839m.m70686d("UpDownManager", "resumeRequest error " + request.getId());
                m82544n(enumC12999a, j10, str);
                return m82540j(enumC12999a, builder, fileRequestCallback, str);
            }
            C11839m.m70686d("UpDownManager", "resumeRequest success " + request.getId() + ":" + request.getOffset() + "/" + request.getFileSize());
            return request;
        }
        return m82540j(enumC12999a, builder, fileRequestCallback, str);
    }

    /* renamed from: m */
    public void m82543m(EnumC12999a enumC12999a, PutRequest putRequest, List<Long> list, FileUploadCallback fileUploadCallback) throws C9721b {
        UploadManager uploadManagerM82537g = m82537g(enumC12999a);
        Result resultStart = uploadManagerM82537g.start((BodyRequest) putRequest, (Callback) fileUploadCallback);
        long id2 = putRequest.getId();
        list.add(Long.valueOf(id2));
        if (resultStart == null || resultStart.getCode() != Result.SUCCESS) {
            uploadManagerM82537g.cancelRequest(id2);
            throw new C9721b(4002, resultStart == null ? "result is null" : resultStart.toString(), "createUploadTask");
        }
    }

    /* renamed from: n */
    public void m82544n(EnumC12999a enumC12999a, long j10, String str) {
        m82536d(enumC12999a, str).cancelRequest(j10);
    }

    /* renamed from: o */
    public void m82545o(EnumC12999a enumC12999a, List<Long> list) {
        m82546p(enumC12999a, list, null);
    }

    /* renamed from: p */
    public void m82546p(EnumC12999a enumC12999a, List<Long> list, String str) {
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            m82536d(enumC12999a, str).cancelRequest(it.next().longValue());
        }
    }

    /* renamed from: q */
    public final Context m82547q() {
        return C0213f.m1377a();
    }

    /* renamed from: t */
    public final void m82548t(Context context) {
        if (context == null) {
            return;
        }
        HQUICManager.asyncInit(context, "huawei_module_quic_pro", new a());
    }

    /* renamed from: w */
    public void m82549w(EnumC12999a enumC12999a, long j10) {
        m82550x(enumC12999a, j10, null);
    }

    /* renamed from: x */
    public void m82550x(EnumC12999a enumC12999a, long j10, String str) {
        m82536d(enumC12999a, str).pauseRequest(j10);
    }

    /* renamed from: y */
    public void m82551y(EnumC12999a enumC12999a, GetRequest getRequest) {
        m82552z(enumC12999a, getRequest, null);
    }

    /* renamed from: z */
    public void m82552z(EnumC12999a enumC12999a, GetRequest getRequest, String str) {
        if (getRequest != null) {
            m82536d(enumC12999a, str).pauseRequest(getRequest.getId());
        }
    }
}
