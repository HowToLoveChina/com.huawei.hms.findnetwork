package p801y7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.callable.CallableBuilder;
import com.huawei.android.hicloud.album.service.logic.callable.OkHttpDownloadTaskCallable;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.SerialTaskCallable;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1123d;
import p031b7.C1136q;
import p312g8.C9894e;
import p429kk.C11058a;
import p429kk.C11060c;
import p572qb.C12297a;
import p616rk.C12515a;
import p709vj.C13452e;
import p746wn.C13622a;

@SuppressLint({"DefaultLocale"})
/* renamed from: y7.b */
/* loaded from: classes2.dex */
public class C13914b extends DownloadPhotoBase {

    /* renamed from: f */
    public static int f62271f;

    /* renamed from: g */
    public static final Map<String, Map<String, Object>> f62272g = DownloadPhotoBase.f10973c;

    /* renamed from: h */
    public static final Object f62273h = new Object();

    /* renamed from: e */
    public CallbackHandler f62274e;

    /* renamed from: y7.b$a */
    public class a extends AbstractC2324e {

        /* renamed from: a */
        public final /* synthetic */ FileInfo f62275a;

        /* renamed from: b */
        public final /* synthetic */ int f62276b;

        /* renamed from: c */
        public final /* synthetic */ boolean f62277c;

        /* renamed from: d */
        public final /* synthetic */ boolean f62278d;

        /* renamed from: e */
        public final /* synthetic */ String f62279e;

        /* renamed from: f */
        public final /* synthetic */ int f62280f;

        /* renamed from: g */
        public final /* synthetic */ String f62281g;

        /* renamed from: h */
        public final /* synthetic */ String f62282h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, FileInfo fileInfo, int i10, boolean z10, boolean z11, String str, int i11, String str2, String str3) {
            super(obj);
            this.f62275a = fileInfo;
            this.f62276b = i10;
            this.f62277c = z10;
            this.f62278d = z11;
            this.f62279e = str;
            this.f62280f = i11;
            this.f62281g = str2;
            this.f62282h = str3;
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
        public void handle(Object obj) {
            HashMap<String, Object> map;
            if (obj != null) {
                try {
                    C1120a.m6675d("SDKDownloadPhoto", "HandleCallable addDownloadCallableTask fileName: " + C1122c.m6818p0(this.f62275a.getFileName()) + ", thumbType is: " + this.f62276b + ", download result: " + obj.toString());
                    if (obj instanceof HashMap) {
                        map = (HashMap) obj;
                    } else {
                        map = new HashMap<>();
                        map.put("code", "1");
                    }
                    C13914b.this.m83376x(map, this.f62275a, this.f62276b, this.f62277c, this.f62278d, this.f62279e, this.f62280f, this.f62281g);
                } catch (Exception e10) {
                    C1120a.m6676e("SDKDownloadPhoto", "addDownloadCallableTask exception: " + e10.toString());
                }
            }
            C13914b.m83362u(C13914b.this.f62274e, this.f62280f, this.f62282h, 2, null, this.f62278d);
        }
    }

    /* renamed from: y7.b$b */
    public static class b extends AbstractC2324e {

        /* renamed from: a */
        public int f62284a;

        /* renamed from: b */
        public String f62285b;

        /* renamed from: c */
        public int f62286c;

        public b(int i10, String str, int i11) {
            super("");
            this.f62284a = i10;
            this.f62285b = str;
            this.f62286c = i11;
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
        public void handle(Object obj) {
            if (obj == null) {
                return;
            }
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0) {
                return;
            }
            C1120a.m6678w("SDKDownloadPhoto", "HandleCallable addOkHttpClientDownloadTask retry:" + this.f62284a + " fileName: " + this.f62285b + ", thumbType is: " + this.f62286c + ", download result: " + obj.toString());
        }
    }

    public C13914b(Context context, CallbackHandler callbackHandler) {
        super(context);
        this.f62274e = callbackHandler;
    }

    /* renamed from: A */
    public static void m83347A(String str, Map<String, Object> map) {
        if (str.endsWith("_2_") || str.endsWith("_1_")) {
            f62272g.put(str, map);
        }
        if (str.endsWith("_0_")) {
            DownloadPhotoBase.f10974d.put(str, map);
        }
    }

    /* renamed from: B */
    public static void m83348B(int i10) {
        C1120a.m6677i("SDKDownloadPhoto", "removeFileKeyAndList: " + i10);
        try {
            DownloadPhotoBase.m14413h(i10);
            if (i10 == 0) {
                m83360s();
            } else {
                f62272g.clear();
            }
        } catch (Exception e10) {
            C1120a.m6676e("SDKDownloadPhoto", "removeFileKeyAndList error: " + e10.toString());
        }
    }

    /* renamed from: C */
    public static void m83349C(String str) {
        if (str.endsWith("_2_") || str.endsWith("_1_")) {
            f62271f++;
            C1120a.m6675d("SDKDownloadPhoto", "downloadSuccess number: " + f62271f);
            f62272g.remove(str);
        }
        if (str.endsWith("_0_")) {
            DownloadPhotoBase.f10974d.remove(str);
        }
    }

    /* renamed from: D */
    public static void m83350D() {
        Map<String, Map<String, Long>> mapM15189m = SyncSessionManager.m15153t().m15189m();
        mapM15189m.forEach(new BiConsumer() { // from class: y7.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                C13914b.m83363z((String) obj, (Map) obj2);
            }
        });
        mapM15189m.clear();
    }

    /* renamed from: G */
    public static void m83351G(CallbackHandler callbackHandler, FileInfo fileInfo, int i10, int i11, int i12, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putInt("ResolutionType", i10);
        bundle.putParcelable("HttpResult", new HttpResult(i11, i12, null));
        callbackHandler.sendMessage(z10 ? 9153 : 9143, bundle);
    }

    /* renamed from: H */
    public static void m83352H(CallbackHandler callbackHandler, FileInfo fileInfo, int i10, int i11, boolean z10) {
        m83351G(callbackHandler, fileInfo, i10, 200, i11, z10);
    }

    /* renamed from: J */
    public static void m83353J(CallbackHandler callbackHandler, FileInfo fileInfo, String str, int i10, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putInt("ResolutionType", i10);
        callbackHandler.sendMessage(z10 ? 9053 : 9043, bundle);
    }

    /* renamed from: K */
    public static void m83354K(CallbackHandler callbackHandler, int i10, boolean z10) {
        C1120a.m6675d("SDKDownloadPhoto", "sendDownloadComplete");
        Bundle bundle = new Bundle();
        bundle.putInt("ThumbType", i10);
        callbackHandler.sendMessage(z10 ? 9054 : 9044, bundle);
    }

    /* renamed from: p */
    public static synchronized void m83357p(CallbackHandler callbackHandler, int i10, Boolean bool) {
        Map<String, Map<String, Object>> map = DownloadPhotoBase.f10972b;
        if (map == null) {
            C1120a.m6676e("SDKDownloadPhoto", "DOWNLOAD_FILELIST is null");
        } else {
            if (map.isEmpty()) {
                m83354K(callbackHandler, i10, bool.booleanValue());
            }
        }
    }

    /* renamed from: q */
    public static void m83358q(CallbackHandler callbackHandler, int i10, Boolean bool) {
        if (DownloadPhotoBase.f10972b.isEmpty()) {
            m83350D();
            m83354K(callbackHandler, i10, bool.booleanValue());
            return;
        }
        if (f62272g.size() == 100 && i10 != 0) {
            C1120a.m6675d("SDKDownloadPhoto", "thumb download fileList size 100");
            m83354K(callbackHandler, i10, bool.booleanValue());
        }
        Map<String, Map<String, Object>> map = DownloadPhotoBase.f10974d;
        if (map.isEmpty() && i10 == 0) {
            m83354K(callbackHandler, i10, bool.booleanValue());
        }
        if (map.size() == 10 && i10 == 0) {
            C1120a.m6675d("SDKDownloadPhoto", "original download fileList size 10");
            m83354K(callbackHandler, i10, bool.booleanValue());
        }
    }

    /* renamed from: r */
    public static void m83359r(CallbackHandler callbackHandler, String str, Boolean bool) {
        Map<String, Map<String, Object>> map = DownloadPhotoBase.f10972b;
        if (map == null || TextUtils.isEmpty(str)) {
            C1120a.m6676e("SDKDownloadPhoto", "checkDownloadStatus input params invalid!");
            return;
        }
        int i10 = str.endsWith("_0_") ? 0 : str.endsWith("_1_") ? 1 : 2;
        m83358q(callbackHandler, i10, bool);
        if (map.isEmpty()) {
            return;
        }
        String str2 = "_" + i10 + "_";
        for (String str3 : map.keySet()) {
            if (!TextUtils.isEmpty(str3) && str3.endsWith(str2) && (!bool.booleanValue()) == str3.startsWith("default-album-")) {
                return;
            }
        }
        m83354K(callbackHandler, i10, bool.booleanValue());
    }

    /* renamed from: s */
    public static void m83360s() {
        DownloadPhotoBase.f10974d.clear();
        if (C0219i.f814b) {
            C12297a.m73908c().m73915h("user-download_apply");
        }
    }

    /* renamed from: t */
    public static void m83361t() {
        try {
            DownloadPhotoBase.f10972b.clear();
            f62272g.clear();
            DownloadPhotoBase.f10974d.clear();
        } catch (UnsupportedOperationException e10) {
            C1120a.m6676e("SDKDownloadPhoto", "clear list exception: " + e10.toString());
        }
        C12515a.m75110o().m75175e(new SerialTaskCallable(SerialTaskCallable.OKHTTP_CANCEL_ALL), false);
    }

    /* renamed from: u */
    public static synchronized void m83362u(CallbackHandler callbackHandler, int i10, String str, int i11, Map<String, Object> map, boolean z10) {
        try {
            if (i11 == 1) {
                DownloadPhotoBase.f10972b.put(str, map);
                m83347A(str, map);
            } else if (i11 == 2) {
                Map<String, Map<String, Object>> map2 = DownloadPhotoBase.f10972b;
                if (map2.containsKey(str) || DownloadPhotoBase.f10974d.containsKey(str) || f62272g.containsKey(str)) {
                    map2.remove(str);
                    m83349C(str);
                    C1120a.m6675d("SDKDownloadPhoto", "DOWNLOAD_FILELIST remove file: " + str + ", size: " + map2.size());
                    m83359r(callbackHandler, str, Boolean.valueOf(z10));
                }
                if (!DownloadPhotoBase.m14411f() && str.endsWith("_0_") && C0219i.f814b) {
                    C1120a.m6677i("SDKDownloadPhoto", "remove downloadApply applyType");
                    C12297a.m73908c().m73915h("user-download_apply");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: z */
    public static /* synthetic */ void m83363z(String str, Map map) {
        try {
            C1120a.m6677i("SDKDownloadPhoto", "reportBatchDownloadRate,traceId:" + str);
            long jLongValue = ((Long) map.get("downloadStartTime")).longValue();
            long jLongValue2 = ((Long) map.get("downloadBatchSize")).longValue();
            long jLongValue3 = ((Long) map.get("downloadEndTime")).longValue();
            long j10 = jLongValue3 - jLongValue;
            long j11 = jLongValue2 / j10;
            C1120a.m6677i("SDKDownloadPhoto", "download rate, traceId:" + str + ",downloadStartTime:" + jLongValue + ",downloadBatchSize:" + jLongValue2 + ",downloadEndTime:" + jLongValue3 + ",batchDownloadRate:" + j11);
            HashMap map2 = new HashMap();
            map2.put("traceId", str);
            map2.put("downloadStartTime", String.valueOf(jLongValue));
            map2.put("downloadBatchSize", String.valueOf(jLongValue2));
            map2.put("downloadEndTime", String.valueOf(jLongValue3));
            map2.put("batchDownloadRate", String.valueOf(j11));
            C11060c c11060cM66626a = C11058a.m66626a(str, "batchDownload", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0:1");
            c11060cM66626a.m66640F(String.valueOf(jLongValue2));
            c11060cM66626a.m66642H(String.valueOf(j10));
            c11060cM66626a.m66635A("downloadStartTime: " + String.valueOf(jLongValue) + ", downloadEndTime: " + String.valueOf(jLongValue3));
            if (j11 > 0) {
                C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map2);
            }
        } catch (Exception e10) {
            C1120a.m6676e("SDKDownloadPhoto", "this download batch fail,traceId:" + str + ",errMsg:" + e10.getMessage());
        }
    }

    /* renamed from: E */
    public void m83364E(FileInfo fileInfo, int i10, boolean z10, int i11) {
        C1120a.m6675d("SDKDownloadPhoto", "fileName " + fileInfo.getFileName() + " thumbType " + i10 + " fileStatus " + i11);
        Bundle bundle = new Bundle();
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putInt("ResolutionType", i10);
        bundle.putInt("DownloadFileStatus", i11);
        this.f62274e.sendMessage(z10 ? 9055 : 9040, bundle);
    }

    /* renamed from: F */
    public void m83365F(FileInfo fileInfo, int i10, int i11, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putInt("ResolutionType", i10);
        bundle.putParcelable("HttpResult", new HttpResult(200, i11, null));
        this.f62274e.sendMessage(z10 ? 9153 : 9143, bundle);
    }

    /* renamed from: I */
    public void m83366I(FileInfo fileInfo, String str, int i10, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putInt("ResolutionType", i10);
        this.f62274e.sendMessage(z10 ? 9053 : 9043, bundle);
    }

    /* renamed from: L */
    public void m83367L(FileInfo fileInfo, int i10) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("FileInfo", C9894e.m61406i(fileInfo));
        bundle.putInt("ResolutionType", i10);
        this.f62274e.sendMessage(9032, bundle);
    }

    /* renamed from: M */
    public void m83368M(FileInfo fileInfo, int i10, int i11) {
        C1120a.m6677i("SDKDownloadPhoto", "updateFileInfoStatus name: " + C1122c.m6818p0(fileInfo.getFileName()) + ", fileStatus: " + i11);
    }

    /* renamed from: N */
    public void m83369N(ArrayList<FileInfo> arrayList, int i10, boolean z10) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            String localRealPath = i10 == 0 ? next.getLocalRealPath() : next.getLocalBigThumbPath();
            if (i10 == 0) {
                StringBuilder sb2 = new StringBuilder(next.getAlbumId());
                sb2.append("_");
                sb2.append(!z10 ? next.getUniqueId() : next.getHash());
                sb2.append("_");
                sb2.append(i10);
                sb2.append("_");
                m83362u(this.f62274e, -1, sb2.toString(), 2, null, z10);
            }
            m83366I(next, localRealPath, i10, z10);
        }
    }

    /* renamed from: l */
    public final void m83370l(FileInfo fileInfo, int i10, boolean z10, boolean z11, boolean z12, int i11, String str, String str2, String str3, String str4, int i12, boolean z13, String str5) {
        FileInfo fileInfo2;
        boolean z14;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fileInfo.getAlbumId());
        sb2.append("_");
        sb2.append(!z12 ? fileInfo.getUniqueId() : fileInfo.getHash());
        sb2.append("_");
        sb2.append(i10);
        sb2.append("_");
        String string = sb2.toString();
        AbstractCallableC2320a<Object> abstractCallableC2320aBuildDownloadCallable = CallableBuilder.getInstance().buildDownloadCallable(this.f10975a, this.f62274e, str, str3, true, fileInfo, str2, z11, i10, str4, i12, i11, z13, str5, false);
        a aVar = new a("", fileInfo, i10, z11, z12, str, i12, str5, string);
        HashMap map = new HashMap();
        synchronized (f62273h) {
            if (i10 == 0) {
                try {
                    fileInfo2 = fileInfo;
                    z14 = z12;
                    if (DownloadPhotoBase.m14410e(this.f10975a, fileInfo2, i10, z14, true)) {
                        C1120a.m6678w("SDKDownloadPhoto", "download repeat: " + C1122c.m6818p0(fileInfo.getFileName()));
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                fileInfo2 = fileInfo;
                z14 = z12;
            }
            m83362u(this.f62274e, i12, string, 1, map, z12);
            if (i10 == 2 || (i10 == 1 && !z10)) {
                if (i12 == 2) {
                    C2332m.m14608s().m14627T(abstractCallableC2320aBuildDownloadCallable, aVar, z10);
                } else {
                    C2332m.m14608s().m14636b0(abstractCallableC2320aBuildDownloadCallable, aVar, z10, fileInfo.getAddTime());
                }
            } else if (i10 == 0) {
                m83368M(fileInfo2, i10, 2);
                if (Version.isDropDownloadFileInfo()) {
                    m83364E(fileInfo2, i10, z14, 2);
                }
                C2332m.m14608s().m14629V(abstractCallableC2320aBuildDownloadCallable, aVar, z10);
            } else {
                C2332m.m14608s().m14633Z(abstractCallableC2320aBuildDownloadCallable, aVar, z10);
            }
        }
    }

    /* renamed from: m */
    public void m83371m(FileInfo fileInfo, int i10, boolean z10, boolean z11, boolean z12, int i11, int i12, boolean z13, String str) {
        String localBigThumbPath;
        String localThumbPath;
        String thumbUrl;
        if (fileInfo != null && !TextUtils.isEmpty(fileInfo.getAlbumId())) {
            if (!TextUtils.isEmpty(!z12 ? fileInfo.getUniqueId() : fileInfo.getHash()) && !TextUtils.isEmpty(fileInfo.getFileName())) {
                if (i10 == 1) {
                    String localBigThumbPath2 = fileInfo.getLocalBigThumbPath();
                    String thumbUrl2 = fileInfo.getThumbUrl();
                    localBigThumbPath = fileInfo.getLocalBigThumbPath();
                    localThumbPath = localBigThumbPath2;
                    thumbUrl = thumbUrl2;
                } else if (i10 == 0) {
                    String fileUrl = fileInfo.getFileUrl();
                    String localRealPath = fileInfo.getLocalRealPath();
                    thumbUrl = fileUrl;
                    localThumbPath = m83377y(fileInfo);
                    localBigThumbPath = localRealPath;
                } else if (i10 == 2) {
                    String localThumbPath2 = fileInfo.getLocalThumbPath();
                    thumbUrl = fileInfo.getThumbUrl();
                    localThumbPath = fileInfo.getLocalThumbPath();
                    localBigThumbPath = localThumbPath2;
                } else {
                    localBigThumbPath = null;
                    localThumbPath = null;
                    thumbUrl = null;
                }
                if (!TextUtils.isEmpty(localBigThumbPath) && !TextUtils.isEmpty(localThumbPath)) {
                    m83370l(fileInfo, i10, z10, z11, z12, i11, localBigThumbPath, localThumbPath, thumbUrl, z12 ? fileInfo.getResource() : PowerKitApplyUtil.GROUP_ALBUM, (CloudAlbumSettings.m14363h().m14378n() && i10 == 1 && !z10) ? 3 : i12, z13, str);
                    return;
                }
                C1120a.m6675d("SDKDownloadPhoto", "saveGetPath: " + localBigThumbPath + " saveCachePath: " + localThumbPath);
                m83365F(fileInfo, i10, 124, z12);
                return;
            }
        }
        C1120a.m6676e("SDKDownloadPhoto", "addDownloadPhotoThreadTask albumId or hash is null");
    }

    /* renamed from: n */
    public final void m83372n(FileInfo fileInfo, int i10, boolean z10, boolean z11, String str, String str2, String str3, int i11, String str4, int i12, boolean z12, boolean z13) {
        boolean z14;
        StringBuilder sb2 = new StringBuilder(fileInfo.getAlbumId());
        sb2.append("_");
        sb2.append(!z11 ? fileInfo.getUniqueId() : fileInfo.getHash());
        sb2.append("_");
        sb2.append(i10);
        sb2.append("_");
        String string = sb2.toString();
        C1120a.m6675d("SDKDownloadPhoto", "addOkHttpClientDownloadTask thumbType:" + i10 + " isPriority:" + z10 + " savePath" + str);
        OkHttpDownloadTaskCallable okHttpDownloadTaskCallable = new OkHttpDownloadTaskCallable(this.f10975a, this.f62274e, str, str3, fileInfo, str2, i10, i11, z11, string, str4, i12, z12, z10, z13);
        m83362u(this.f62274e, i11, string, 1, new HashMap(), z11);
        b bVar = new b(i12, fileInfo.getFileName(), i10);
        if (i10 != 2) {
            if (i10 == 1) {
                z14 = z10;
                if (!z14) {
                }
            } else {
                z14 = z10;
            }
            if (i10 != 0) {
                C2332m.m14608s().m14633Z(okHttpDownloadTaskCallable, bVar, z14);
                return;
            } else {
                m83368M(fileInfo, i10, 2);
                C2332m.m14608s().m14629V(okHttpDownloadTaskCallable, bVar, z14);
                return;
            }
        }
        C2332m.m14608s().m14636b0(okHttpDownloadTaskCallable, bVar, z10, fileInfo.getAddTime());
    }

    /* renamed from: o */
    public void m83373o(FileInfo fileInfo, int i10, boolean z10, boolean z11, int i11, String str, int i12, boolean z12, boolean z13) {
        String localThumbPath;
        String localBigThumbPath;
        String thumbUrl;
        if (fileInfo != null && !TextUtils.isEmpty(fileInfo.getAlbumId())) {
            if (!TextUtils.isEmpty(!z11 ? fileInfo.getUniqueId() : fileInfo.getHash()) && !TextUtils.isEmpty(fileInfo.getFileName())) {
                if (i10 == 0) {
                    String localRealPath = fileInfo.getLocalRealPath();
                    String strM83377y = m83377y(fileInfo);
                    thumbUrl = fileInfo.getFileUrl();
                    localBigThumbPath = strM83377y;
                    localThumbPath = localRealPath;
                } else if (i10 == 1) {
                    String thumbUrl2 = fileInfo.getThumbUrl();
                    localThumbPath = fileInfo.getLocalBigThumbPath();
                    localBigThumbPath = fileInfo.getLocalBigThumbPath();
                    thumbUrl = thumbUrl2;
                } else if (i10 == 2) {
                    String localThumbPath2 = fileInfo.getLocalThumbPath();
                    thumbUrl = fileInfo.getThumbUrl();
                    localThumbPath = fileInfo.getLocalThumbPath();
                    localBigThumbPath = localThumbPath2;
                } else {
                    localThumbPath = null;
                    localBigThumbPath = null;
                    thumbUrl = null;
                }
                if (!TextUtils.isEmpty(localThumbPath) && !TextUtils.isEmpty(localBigThumbPath)) {
                    m83372n(fileInfo, i10, z10, z11, localThumbPath, localBigThumbPath, thumbUrl, i11, str, i12, z12, z13);
                    return;
                }
                C1120a.m6678w("SDKDownloadPhoto", "saveGetPath or saveCachePath is empty, file name:" + C1122c.m6818p0(fileInfo.getFileName()));
                m83365F(fileInfo, i10, 124, z11);
                return;
            }
        }
        C1120a.m6676e("SDKDownloadPhoto", "addOkHttpDownloadPhotoThreadTask albumId or hash is null");
    }

    /* renamed from: v */
    public void m83374v(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String str) {
        AbstractCallableC2320a abstractCallableC2320aBuildDownloadCheckCallable = CallableBuilder.getInstance().buildDownloadCheckCallable(this.f10975a, this.f62274e, arrayList, i10, z10, z11, z12, z13, i10 == 2 ? 1 : -1, z14, str, true);
        if (i10 == 0) {
            C2332m.m14608s().m14625R(abstractCallableC2320aBuildDownloadCheckCallable, null, z10);
            return;
        }
        if (i10 == 1 && z10) {
            C2332m.m14608s().m14624Q(abstractCallableC2320aBuildDownloadCheckCallable, null, z10);
        } else if (i10 == 2 && z10) {
            C2332m.m14608s().m14628U(abstractCallableC2320aBuildDownloadCheckCallable, null, z10);
        } else {
            C2332m.m14608s().m14623P(abstractCallableC2320aBuildDownloadCheckCallable, null, z10);
        }
    }

    /* renamed from: w */
    public void m83375w(ArrayList<FileInfo> arrayList, boolean z10, boolean z11, String str, boolean z12) {
        C2332m.m14608s().m14625R(CallableBuilder.getInstance().buildDownloadCheckCallable(this.f10975a, this.f62274e, arrayList, 0, z10, z11, false, false, -1, z12, str, false), null, z10);
    }

    /* renamed from: x */
    public void m83376x(HashMap<String, Object> map, FileInfo fileInfo, int i10, boolean z10, boolean z11, String str, int i11, String str2) {
        boolean zBooleanValue;
        int iM1685c;
        boolean zBooleanValue2 = map.containsKey("NeedCallback") ? ((Boolean) map.get("NeedCallback")).booleanValue() : true;
        if (map.containsKey("isForceDownload")) {
            zBooleanValue = ((Boolean) map.get("isForceDownload")).booleanValue();
            C1120a.m6677i("SDKDownloadPhoto", "res containsKey isForceDownload:" + zBooleanValue);
        } else {
            zBooleanValue = false;
        }
        if (String.valueOf(0).equals(map.get("code"))) {
            if (i10 == 0) {
                m83368M(fileInfo, i10, 16);
            }
            if (zBooleanValue2) {
                m83366I(fileInfo, str, i10, z11);
                return;
            }
            return;
        }
        if ("11".equals(map.get("code"))) {
            m83368M(fileInfo, i10, 8);
            if (map.containsKey("DownloadFailReason")) {
                String str3 = (String) map.get("DownloadFailReason");
                C1120a.m6677i("SDKDownloadPhoto", "start get failCode is:" + str3);
                iM1685c = C0241z.m1685c(str3);
            } else {
                iM1685c = 115;
            }
            if (zBooleanValue2) {
                m83365F(fileInfo, i10, iM1685c, z11);
                return;
            }
            return;
        }
        if ("7".equals(map.get("code"))) {
            C1120a.m6676e("SDKDownloadPhoto", "download retry: " + C1122c.m6818p0(fileInfo.getFileName()) + ", thumbType: " + i10);
            m83371m(fileInfo, i10, true, z10, z11, 1, i11, false, str2);
            return;
        }
        int iIntValue = map.containsKey("DownloadFailReason") ? ((Integer) map.get("DownloadFailReason")).intValue() : 101;
        if (C1136q.b.m7057f0(this.f10975a)) {
            iIntValue = 105;
        }
        if (i10 == 0) {
            int iM6855a = C1123d.m6855a(this.f10975a);
            if ("10".equals(map.get("code")) || iM6855a == 0 || (!(zBooleanValue || iM6855a == 4) || C1136q.b.m7057f0(this.f10975a) || 107 == iIntValue || 109 == iIntValue)) {
                if (iIntValue == 126) {
                    m83368M(fileInfo, i10, 32);
                } else if ("10".equals(map.get("code"))) {
                    m83368M(fileInfo, i10, 4);
                    iIntValue = SyncType.WLAN_CHANGE;
                } else {
                    m83368M(fileInfo, i10, 4);
                    iIntValue = 107;
                }
            } else if (iIntValue == 106) {
                m83368M(fileInfo, i10, 8);
            } else {
                m83368M(fileInfo, i10, 32);
            }
            if (C13452e.m80781L().m80932j1()) {
                iIntValue = 114;
            }
        }
        C1120a.m6676e("SDKDownloadPhoto", "download failed: " + C1122c.m6818p0(fileInfo.getFileName()) + ", type: " + i10 + ", DownloadFailReason: " + iIntValue + ", ret: " + map.get("code") + ", needCallback: " + zBooleanValue2);
        if (zBooleanValue2) {
            m83365F(fileInfo, i10, iIntValue, z11);
        }
    }

    /* renamed from: y */
    public final String m83377y(FileInfo fileInfo) {
        String localRealPath = fileInfo.getLocalRealPath();
        String lpath = fileInfo.getLpath();
        if (TextUtils.isEmpty(localRealPath)) {
            C1120a.m6676e("SDKDownloadPhoto", "org save path is null:" + C1122c.m6818p0(fileInfo.getFileName()));
            return null;
        }
        try {
            if (!TextUtils.isEmpty(lpath) && !"/".equals(lpath)) {
                int iIndexOf = localRealPath.indexOf(lpath);
                if (iIndexOf < 0) {
                    return null;
                }
                String str = localRealPath.substring(0, iIndexOf) + "/Pictures/hiddenAlbum/.tmp/" + fileInfo.getAlbumId() + "/" + fileInfo.getFileName();
                C1120a.m6675d("SDKDownloadPhoto", "cachePath:" + str);
                return str;
            }
            int iIndexOf2 = localRealPath.indexOf(fileInfo.getFileName());
            if (iIndexOf2 < 0) {
                return null;
            }
            return localRealPath.substring(0, iIndexOf2 - 1) + "/Pictures/hiddenAlbum/.tmp/" + fileInfo.getAlbumId() + "/" + fileInfo.getFileName();
        } catch (Exception e10) {
            C1120a.m6676e("SDKDownloadPhoto", "get org cache error:" + e10.getMessage());
            return null;
        }
    }
}
