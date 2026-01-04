package p546p6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadCheckCallable;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadHeadPicCallable;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadUrlCallable;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadProgress;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.PictureMetaData;
import com.huawei.android.hicloud.drive.cloudphoto.model.VideoMetaData;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import hk.C10278a;
import hu.C10343b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p312g8.C9894e;
import p471m6.C11421g;
import p514o9.C11842p;
import p568q6.C12288a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p649t6.C12947g;

/* renamed from: p6.i */
/* loaded from: classes2.dex */
public class C12096i {

    /* renamed from: a */
    public ExecutorService f56094a;

    /* renamed from: b */
    public ExecutorService f56095b;

    /* renamed from: c */
    public ExecutorService f56096c;

    /* renamed from: d */
    public ExecutorService f56097d;

    /* renamed from: e */
    public ExecutorService f56098e;

    /* renamed from: f */
    public ExecutorService f56099f;

    /* renamed from: g */
    public ExecutorService f56100g;

    /* renamed from: h */
    public ConcurrentHashMap<String, Media> f56101h;

    /* renamed from: i */
    public HashMap<String, FileDownloadProgress> f56102i;

    /* renamed from: j */
    public volatile C11421g f56103j;

    /* renamed from: k */
    public FileDownloadProgress f56104k;

    /* renamed from: l */
    public final d f56105l;

    /* renamed from: m */
    public g f56106m;

    /* renamed from: n */
    public ArrayList<Handler> f56107n;

    /* renamed from: p6.i$b */
    public static class b extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e10) {
                C1120a.m6676e("DownloadManager", "CheckNetworkTask error" + e10.toString());
            }
            boolean zM1333z1 = C0209d.m1333z1(C0213f.m1377a());
            C1120a.m6675d("DownloadManager", "netWorkConnected=" + zM1333z1);
            if (zM1333z1) {
                return;
            }
            C12096i.m72418I().m72469s(1003);
            C12096i.m72418I().m72466p(1003);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: p6.i$c */
    public static class c extends Handler {

        /* renamed from: a */
        public CountDownLatch f56108a;

        /* renamed from: b */
        public ArrayList<Media> f56109b;

        public c(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m72477a(CountDownLatch countDownLatch) {
            this.f56108a = countDownLatch;
        }

        /* renamed from: b */
        public void m72478b(ArrayList<Media> arrayList) {
            this.f56109b = arrayList;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            C1120a.m6675d("DownloadManager", "CoverCallback obj: " + obj);
            if (obj instanceof FileInfo) {
                FileInfo fileInfo = (FileInfo) obj;
                CountDownLatch countDownLatch = this.f56108a;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                ArrayList<Media> arrayList = this.f56109b;
                if (arrayList != null) {
                    arrayList.add(C12096i.m72424e0(fileInfo));
                }
            }
        }
    }

    /* renamed from: p6.i$d */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1120a.m6675d("DownloadManager", "handleMessage detail: " + C12096i.this.m72440J(message));
            int i10 = message.what;
            C10343b c10343b = new C10343b((Bundle) message.obj);
            C1120a.m6675d("DownloadManager", "handleMessage : msg=" + i10);
            long fileLoadSizeByte = 0;
            if (i10 != 9042) {
                if (i10 != 9043) {
                    if (i10 != 9052) {
                        if (i10 != 9053) {
                            if (i10 == 9143 || i10 == 9153) {
                                FileInfo fileInfoM72439H = C12096i.this.m72439H(c10343b);
                                int iM63686h = c10343b.m63686h("ResolutionType");
                                HttpResult httpResult = (HttpResult) c10343b.m63690l("HttpResult");
                                if (iM63686h == 0) {
                                    int code = httpResult.getCode();
                                    C1120a.m6675d("DownloadManager", "download fail errorCode=" + code);
                                    FileDownloadProgress fileDownloadProgressM72438G = C12096i.this.m72438G(fileInfoM72439H);
                                    if (code == 1001) {
                                        fileDownloadProgressM72438G.setState(code);
                                        C12096i.this.f56103j.m68431p(C12096i.this.f56103j.m68420e() + 1);
                                        C12096i.this.f56103j.m68429n(1001);
                                    } else if (code == 1002) {
                                        fileDownloadProgressM72438G.setState(code);
                                        C12096i.this.f56103j.m68433r(C12096i.this.f56103j.m68422g() - 1);
                                        C12096i.this.f56103j.m68429n(1002);
                                    } else {
                                        fileDownloadProgressM72438G.setState(1003);
                                        C12096i.this.f56103j.m68430o(C12096i.this.f56103j.m68419d() + 1);
                                        C12096i.this.f56103j.m68429n(1003);
                                    }
                                    C12096i.this.f56102i.put(fileInfoM72439H.getUniqueId(), fileDownloadProgressM72438G);
                                    C12096i c12096i = C12096i.this;
                                    c12096i.m72458b0(c12096i.f56103j);
                                    return;
                                }
                                return;
                            }
                            switch (i10) {
                                case 200:
                                    FileInfo fileInfoM72439H2 = C12096i.this.m72439H(c10343b);
                                    int iM63686h2 = c10343b.m63686h("ResolutionType");
                                    if (iM63686h2 == 0) {
                                        if (C12096i.this.f56104k == null) {
                                            C12096i.this.f56104k = new FileDownloadProgress();
                                            C12096i.this.f56104k.setUniqueId(fileInfoM72439H2.getUniqueId());
                                            C12096i.this.f56104k.setFileId(fileInfoM72439H2.getFileId());
                                            C12096i.this.f56104k.setFileSizeByte(fileInfoM72439H2.getSize());
                                            C12096i.this.f56104k.setFileLoadSizeByte(fileInfoM72439H2.getSize());
                                            C12096i.this.f56104k.setResolutionType(iM63686h2);
                                        }
                                        C12096i.this.f56104k.setState(1000);
                                        C12096i.this.f56104k.setLocalRealPath(fileInfoM72439H2.getLocalRealPath());
                                        C12096i c12096i2 = C12096i.this;
                                        c12096i2.m72459c0(c12096i2.f56104k);
                                    }
                                    C1120a.m6675d("DownloadManager", "" + fileInfoM72439H2.toString());
                                    break;
                                case 201:
                                    FileInfo fileInfoM72439H3 = C12096i.this.m72439H(c10343b);
                                    int iM63686h3 = c10343b.m63686h("ResolutionType");
                                    HttpResult httpResult2 = (HttpResult) c10343b.m63690l("HttpResult");
                                    if (iM63686h3 == 0) {
                                        if (C12096i.this.f56104k == null) {
                                            C12096i.this.f56104k = new FileDownloadProgress();
                                            C12096i.this.f56104k.setUniqueId(fileInfoM72439H3.getUniqueId());
                                            C12096i.this.f56104k.setFileId(fileInfoM72439H3.getFileId());
                                            C12096i.this.f56104k.setFileSizeByte(fileInfoM72439H3.getSize());
                                            C12096i.this.f56104k.setFileLoadSizeByte(0L);
                                            C12096i.this.f56104k.setResolutionType(iM63686h3);
                                        }
                                        int code2 = httpResult2.getCode();
                                        if (code2 == 1001 || code2 == 1002) {
                                            C12096i.this.f56104k.setState(code2);
                                        } else {
                                            C12096i.this.f56104k.setState(1003);
                                        }
                                        C12096i c12096i3 = C12096i.this;
                                        c12096i3.m72459c0(c12096i3.f56104k);
                                        break;
                                    }
                                    break;
                                case 202:
                                    C12096i.this.f56104k = (FileDownloadProgress) c10343b.m63690l("FileLoadProgress");
                                    if (C12096i.this.f56104k.getResolutionType() == 0) {
                                        C12096i.this.f56104k.setState(1004);
                                        C12096i c12096i4 = C12096i.this;
                                        c12096i4.m72459c0(c12096i4.f56104k);
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                }
                FileInfo fileInfoM72439H4 = C12096i.this.m72439H(c10343b);
                if (c10343b.m63686h("ResolutionType") == 0) {
                    C1120a.m6675d("DownloadManager", "download succeed");
                    FileDownloadProgress fileDownloadProgressM72438G2 = C12096i.this.m72438G(fileInfoM72439H4);
                    fileDownloadProgressM72438G2.setState(1000);
                    fileDownloadProgressM72438G2.setLocalRealPath(fileInfoM72439H4.getLocalRealPath());
                    C12096i.this.f56102i.put(fileInfoM72439H4.getUniqueId(), fileDownloadProgressM72438G2);
                    C12096i.this.f56103j.m68432q(C12096i.this.f56103j.m68421f() + 1);
                    if (C12096i.this.f56103j.m68420e() != 0) {
                        C12096i.this.f56103j.m68429n(1001);
                    } else {
                        C12096i.this.f56103j.m68429n(1000);
                    }
                    C12096i.this.f56101h.remove(fileInfoM72439H4.getUniqueId());
                    C12096i c12096i5 = C12096i.this;
                    c12096i5.m72458b0(c12096i5.f56103j);
                }
                C1120a.m6675d("DownloadManager", "" + fileInfoM72439H4.toString());
                return;
            }
            FileDownloadProgress fileDownloadProgress = (FileDownloadProgress) c10343b.m63690l("FileLoadProgress");
            if (fileDownloadProgress.getResolutionType() == 0) {
                FileDownloadProgress fileDownloadProgress2 = (FileDownloadProgress) C12096i.this.f56102i.get(fileDownloadProgress.getUniqueId());
                if (fileDownloadProgress2 == null || fileDownloadProgress2.getProgress() <= fileDownloadProgress.getProgress()) {
                    C12096i.this.f56102i.put(fileDownloadProgress.getUniqueId(), fileDownloadProgress);
                }
                Iterator it = C12096i.this.f56102i.values().iterator();
                while (it.hasNext()) {
                    fileLoadSizeByte += ((FileDownloadProgress) it.next()).getFileLoadSizeByte();
                }
                C12096i.this.f56103j.m68427l(fileLoadSizeByte);
                C12096i.this.f56103j.m68428m(1004);
                C12096i c12096i6 = C12096i.this;
                c12096i6.m72458b0(c12096i6.f56103j);
            }
        }
    }

    /* renamed from: p6.i$e */
    public enum e {
        NORMAL,
        HIGH
    }

    /* renamed from: p6.i$f */
    public static class f {

        /* renamed from: a */
        public static final C12096i f56114a = new C12096i();
    }

    /* renamed from: p6.i$g */
    public static class g extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6678w("DownloadManager", "intent is null.");
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                C12515a.m75110o().m75175e(new b(), true);
            }
        }
    }

    public /* synthetic */ C12096i(a aVar) {
        this();
    }

    /* renamed from: I */
    public static C12096i m72418I() {
        return f.f56114a;
    }

    /* renamed from: e0 */
    public static Media m72424e0(FileInfo fileInfo) {
        Media media = new Media();
        media.setId(fileInfo.getUniqueId());
        media.setAlbumId(fileInfo.getAlbumId());
        media.setHashId(fileInfo.getHash());
        media.setFileName(fileInfo.getFileName());
        media.setAlbumVersion(fileInfo.getDataVersion());
        media.setLocalBigThumbPath(fileInfo.getLocalBigThumbPath());
        media.setLocalThumbPath(fileInfo.getLocalThumbPath());
        media.setLocalRealPath(fileInfo.getLocalRealPath());
        media.setSize(Long.valueOf(fileInfo.getSize()));
        media.setMediaOwnerId(fileInfo.getUserID());
        media.setCreatedTime(new C4644l(fileInfo.getCreateTime()));
        media.setFileType(Integer.valueOf(fileInfo.getFileType()));
        media.setOpType(fileInfo.getOtype());
        media.setRotation(fileInfo.getOrientation());
        media.setVideoThumbId(fileInfo.getVideoThumbId());
        media.setThumbFileId(fileInfo.getThumbFileId());
        media.setLcdFileId(fileInfo.getLcdFileId());
        return media;
    }

    /* renamed from: A */
    public void m72432A(List<Media> list) {
        C1120a.m6675d("DownloadManager", "downloadLCD list ");
        m72444N();
        ArrayList arrayList = new ArrayList();
        Iterator<Media> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m72460d0(it.next()));
        }
        try {
            if (this.f56095b.submit(new CloudAlbumDownloadCheckCallable(C0213f.m1377a(), 1, (List<FileInfo>) arrayList, (Handler) this.f56105l, false)) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadLCD error: " + e10.toString());
        }
    }

    /* renamed from: B */
    public void m72433B(Media media) {
        if (media == null || TextUtils.isEmpty(media.getId())) {
            return;
        }
        if (m72448R() && this.f56103j.m68425j()) {
            this.f56101h.clear();
            this.f56102i.clear();
            this.f56103j.m68426k();
        }
        if (this.f56101h.get(media.getId()) == null) {
            m72456Z();
            this.f56101h.put(media.getId(), media);
            m72463m(media, true);
        } else {
            if (!m72449S(media)) {
                C1120a.m6677i("DownloadManager", "downloadOriginal media already exist");
                return;
            }
            C1120a.m6677i("DownloadManager", "downloadOriginal media resume exist task");
            m72456Z();
            m72463m(media, false);
        }
    }

    /* renamed from: C */
    public void m72434C(Media media) {
        if (media == null || TextUtils.isEmpty(media.getId())) {
            return;
        }
        C1120a.m6677i("DownloadManager", "addOriginalTask");
        m72446P();
        m72456Z();
        ArrayList arrayList = new ArrayList();
        arrayList.add(m72460d0(media));
        try {
            if (this.f56100g.submit(new CloudAlbumDownloadCheckCallable(C0213f.m1377a(), 0, (List<FileInfo>) arrayList, (Handler) this.f56105l, true)) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadOriginal error: " + e10.toString());
        }
    }

    /* renamed from: D */
    public void m72435D(List<Media> list) {
        C1120a.m6675d("DownloadManager", "downloadThumb list ");
        m72441K();
        ArrayList arrayList = new ArrayList();
        Iterator<Media> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m72460d0(it.next()));
        }
        try {
            if (this.f56094a.submit(new CloudAlbumDownloadCheckCallable(C0213f.m1377a(), 2, (List<FileInfo>) arrayList, (Handler) this.f56105l, false)) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadThumb error: " + e10.toString());
        }
    }

    /* renamed from: E */
    public void m72436E(Media media, ImageView imageView) {
        if (media == null) {
            C1120a.m6675d("DownloadManager", "downloadThumbPriority media is null");
            return;
        }
        C1120a.m6675d("DownloadManager", "downloadThumbPriority media: " + media.toString());
        m72447Q();
        ArrayList arrayList = new ArrayList();
        arrayList.add(m72460d0(media));
        try {
            C1120a.m6675d("DownloadManager", "submit: " + this.f56098e.submit(new CloudAlbumDownloadCheckCallable(C0213f.m1377a(), 2, arrayList, this.f56105l, imageView)));
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadThumbPriority error: " + e10.toString());
        }
    }

    /* renamed from: F */
    public void m72437F(String str, ImageView imageView) {
        C1120a.m6675d("DownloadManager", "downloadUrl ");
        m72442L();
        try {
            if (this.f56097d.submit(new CloudAlbumDownloadUrlCallable(C0213f.m1377a(), str, imageView)) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadUrl error: " + e10.toString());
        }
    }

    /* renamed from: G */
    public final FileDownloadProgress m72438G(FileInfo fileInfo) {
        FileDownloadProgress fileDownloadProgress = this.f56102i.get(fileInfo.getUniqueId());
        if (fileDownloadProgress != null) {
            return fileDownloadProgress;
        }
        FileDownloadProgress fileDownloadProgress2 = new FileDownloadProgress();
        fileDownloadProgress2.setUniqueId(fileInfo.getUniqueId());
        fileDownloadProgress2.setFileId(fileInfo.getFileId());
        fileDownloadProgress2.setFileSizeByte(fileInfo.getSize());
        return fileDownloadProgress2;
    }

    /* renamed from: H */
    public final FileInfo m72439H(C10343b c10343b) {
        Parcelable parcelableM63690l = c10343b.m63690l("FileInfo");
        return parcelableM63690l instanceof FileData ? C9894e.m61400c((FileData) parcelableM63690l) : (FileInfo) parcelableM63690l;
    }

    /* renamed from: J */
    public final String m72440J(Message message) {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("msg.what=");
        sb2.append(message.what);
        sb2.append(", bundle=");
        Object obj = message.obj;
        if (obj != null) {
            Bundle bundle = (Bundle) obj;
            for (String str : bundle.keySet()) {
                sb2.append(str);
                sb2.append("=");
                sb2.append(bundle.get(str));
                sb2.append(";");
            }
        }
        return sb2.toString();
    }

    /* renamed from: K */
    public final synchronized void m72441K() {
        try {
            ExecutorService executorService = this.f56094a;
            if (executorService == null || executorService.isShutdown()) {
                this.f56094a = Executors.newFixedThreadPool(6);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: L */
    public final synchronized void m72442L() {
        try {
            ExecutorService executorService = this.f56097d;
            if (executorService == null || executorService.isShutdown()) {
                this.f56097d = Executors.newFixedThreadPool(6);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: M */
    public final synchronized void m72443M() {
        try {
            ExecutorService executorService = this.f56099f;
            if (executorService == null || executorService.isShutdown()) {
                this.f56099f = new ThreadPoolExecutor(10, 12, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(C11842p.m70762R0() ? 50 : 30), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: N */
    public final synchronized void m72444N() {
        try {
            ExecutorService executorService = this.f56095b;
            if (executorService == null || executorService.isShutdown()) {
                this.f56095b = Executors.newFixedThreadPool(6);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: O */
    public final synchronized void m72445O() {
        try {
            ExecutorService executorService = this.f56096c;
            if (executorService == null || executorService.isShutdown()) {
                this.f56096c = Executors.newFixedThreadPool(6);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: P */
    public final synchronized void m72446P() {
        try {
            ExecutorService executorService = this.f56100g;
            if (executorService == null || executorService.isShutdown()) {
                this.f56100g = Executors.newFixedThreadPool(6);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: Q */
    public final synchronized void m72447Q() {
        try {
            ExecutorService executorService = this.f56098e;
            if (executorService == null || executorService.isShutdown()) {
                this.f56098e = new ThreadPoolExecutor(10, 12, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(C11842p.m70762R0() ? 50 : 30), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: R */
    public final boolean m72448R() {
        return C2332m.m14608s().m14657w().isEmpty() && C2332m.m14608s().m14656v().isEmpty();
    }

    /* renamed from: S */
    public final boolean m72449S(Media media) {
        FileDownloadProgress fileDownloadProgress = this.f56102i.get(media.getId());
        if (fileDownloadProgress == null) {
            return true;
        }
        int state = fileDownloadProgress.getState();
        if (state == 1001) {
            this.f56103j.m68431p(this.f56103j.m68420e() - 1);
            return true;
        }
        if (state != 1003) {
            return false;
        }
        this.f56103j.m68430o(this.f56103j.m68419d() - 1);
        return true;
    }

    /* renamed from: T */
    public final boolean m72450T() {
        return C2332m.m14608s().m14659y().isEmpty() && C2332m.m14608s().m14658x().isEmpty();
    }

    /* renamed from: U */
    public void m72451U() {
        C1120a.m6677i("DownloadManager", "logout cancel all");
        ExecutorService executorService = this.f56094a;
        if (executorService != null && !executorService.isShutdown()) {
            this.f56094a.shutdownNow();
        }
        ExecutorService executorService2 = this.f56095b;
        if (executorService2 != null && !executorService2.isShutdown()) {
            this.f56095b.shutdownNow();
        }
        ExecutorService executorService3 = this.f56096c;
        if (executorService3 != null && !executorService3.isShutdown()) {
            this.f56096c.shutdownNow();
        }
        ExecutorService executorService4 = this.f56097d;
        if (executorService4 != null && !executorService4.isShutdown()) {
            this.f56097d.shutdownNow();
        }
        ExecutorService executorService5 = this.f56098e;
        if (executorService5 != null && !executorService5.isShutdown()) {
            this.f56098e.shutdownNow();
        }
        ExecutorService executorService6 = this.f56099f;
        if (executorService6 != null && !executorService6.isShutdown()) {
            this.f56099f.shutdownNow();
        }
        ExecutorService executorService7 = this.f56100g;
        if (executorService7 != null && !executorService7.isShutdown()) {
            this.f56100g.shutdownNow();
        }
        m72468r();
        m72464n();
        C12105r.m72501e().m72503b();
        C12111x.m72537e().m72539b();
    }

    /* renamed from: V */
    public int m72452V() {
        C1120a.m6677i("DownloadManager", "pauseAllTask");
        return m72466p(1001);
    }

    /* renamed from: W */
    public String m72453W(Media media) {
        Media mediaM77802O;
        if (media == null || TextUtils.isEmpty(media.getId()) || (mediaM77802O = new C12947g().m77802O(media.getId())) == null) {
            return null;
        }
        if (!TextUtils.isEmpty(mediaM77802O.getLocalRealPath()) && C10278a.m63442h(mediaM77802O.getLocalRealPath()).exists()) {
            return mediaM77802O.getLocalRealPath();
        }
        String strM6864h = C1124e.m6864h(C0213f.m1377a(), m72460d0(media), 0);
        if (TextUtils.isEmpty(strM6864h) || !C10278a.m63442h(strM6864h).exists()) {
            return null;
        }
        return strM6864h;
    }

    /* renamed from: X */
    public boolean m72454X(Media media) {
        return m72453W(media) != null;
    }

    /* renamed from: Y */
    public synchronized void m72455Y(Handler handler) {
        if (handler == null) {
            C1120a.m6676e("DownloadManager", "registerCallback handler is null");
            return;
        }
        this.f56107n.add(handler);
        C1120a.m6675d("DownloadManager", "registerCallback size: " + this.f56107n.size());
    }

    /* renamed from: Z */
    public final synchronized void m72456Z() {
        if (this.f56106m == null) {
            C1120a.m6675d("DownloadManager", "registerNetWorkReceiver");
            this.f56106m = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            C0213f.m1377a().registerReceiver(this.f56106m, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        }
    }

    /* renamed from: a0 */
    public void m72457a0() {
        C1120a.m6677i("DownloadManager", "resumeAllTask");
        if (this.f56101h.isEmpty()) {
            return;
        }
        this.f56103j.m68431p(0);
        this.f56103j.m68430o(0);
        m72456Z();
        Iterator<Media> it = this.f56101h.values().iterator();
        while (it.hasNext()) {
            m72463m(it.next(), false);
        }
    }

    /* renamed from: b0 */
    public final void m72458b0(C11421g c11421g) {
        C1120a.m6675d("DownloadManager", "sendDownloadAll: bean=" + c11421g.toString());
        if (c11421g.m68418c() != 1004 && m72448R() && m72450T()) {
            m72462g0();
        }
        if (c11421g.m68418c() == 1002) {
            this.f56102i.clear();
            this.f56101h.clear();
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 101;
        messageObtain.obj = c11421g;
        m72470t(messageObtain);
        m72471u(c11421g);
    }

    /* renamed from: c0 */
    public final void m72459c0(FileDownloadProgress fileDownloadProgress) {
        C1120a.m6675d("DownloadManager", "sendDownloadSingle: progress=" + fileDownloadProgress.toString());
        if (fileDownloadProgress.getState() != 1004 && m72448R() && m72450T()) {
            m72462g0();
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 102;
        messageObtain.obj = fileDownloadProgress;
        m72470t(messageObtain);
    }

    /* renamed from: d0 */
    public final FileInfo m72460d0(Media media) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUniqueId(media.getId());
        fileInfo.setFileId(media.getId());
        String albumId = media.getAlbumId();
        fileInfo.setAlbumId(albumId);
        fileInfo.setShareId(albumId);
        fileInfo.setHash(media.getHashId());
        fileInfo.setFileName(media.getFileName());
        String albumVersion = media.getAlbumVersion();
        fileInfo.setDataVersion(albumVersion);
        fileInfo.setLocalBigThumbPath(media.getLocalBigThumbPath());
        fileInfo.setLocalThumbPath(media.getLocalThumbPath());
        fileInfo.setLocalRealPath(media.getLocalRealPath());
        fileInfo.setSize(media.getSize().longValue());
        fileInfo.setUserID(media.getMediaOwnerId());
        fileInfo.setCreateTime(media.getCreatedTime().m28458c());
        fileInfo.setFileType(media.getFileType().intValue());
        fileInfo.setOtype(media.getOpType());
        fileInfo.setVideoThumbId(media.getVideoThumbId());
        fileInfo.setThumbFileId(media.getThumbFileId());
        fileInfo.setLcdFileId(media.getLcdFileId());
        if ("1.0".equals(albumVersion) && !albumId.startsWith("default-album-")) {
            fileInfo.setUniqueId("");
        }
        int iIntValue = media.getFileType().intValue();
        if (media.getRotation() != 1) {
            fileInfo.setOrientation(media.getRotation());
        } else if (iIntValue == 4) {
            VideoMetaData videoMetaData = media.getVideoMetaData();
            if (videoMetaData != null && videoMetaData.containsKey("rotation")) {
                fileInfo.setOrientation(videoMetaData.getRotation().intValue());
            }
        } else {
            PictureMetaData pictureMetaData = media.getPictureMetaData();
            if (pictureMetaData != null && pictureMetaData.containsKey("rotation")) {
                fileInfo.setOrientation(pictureMetaData.getRotation().intValue());
            }
        }
        return fileInfo;
    }

    /* renamed from: f0 */
    public synchronized void m72461f0(Handler handler) {
        if (handler == null) {
            C1120a.m6676e("DownloadManager", "registerCallback handler is null");
            return;
        }
        this.f56107n.remove(handler);
        C1120a.m6675d("DownloadManager", "unRegisterCallback size: " + this.f56107n.size());
    }

    /* renamed from: g0 */
    public final synchronized void m72462g0() {
        if (this.f56106m != null) {
            C1120a.m6675d("DownloadManager", "unRegisterNetWorkReceiver");
            C0213f.m1377a().unregisterReceiver(this.f56106m);
            this.f56106m = null;
        }
    }

    /* renamed from: m */
    public final void m72463m(Media media, boolean z10) {
        C1120a.m6677i("DownloadManager", "addOriginalTask isNewTask=" + z10);
        m72446P();
        ArrayList arrayList = new ArrayList();
        FileInfo fileInfoM72460d0 = m72460d0(media);
        arrayList.add(fileInfoM72460d0);
        if (z10) {
            int iM68422g = this.f56103j.m68422g() + 1;
            long jM68424i = this.f56103j.m68424i() + fileInfoM72460d0.getSize();
            this.f56103j.m68433r(iM68422g);
            this.f56103j.m68434s(jM68424i);
        }
        try {
            FileDownloadProgress fileDownloadProgressM72438G = m72438G(fileInfoM72460d0);
            fileDownloadProgressM72438G.setState(1004);
            this.f56102i.put(fileInfoM72460d0.getUniqueId(), fileDownloadProgressM72438G);
            if (this.f56100g.submit(new CloudAlbumDownloadCheckCallable(C0213f.m1377a(), 0, (List<FileInfo>) arrayList, (Handler) this.f56105l, false)) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadOriginal error: " + e10.toString());
        }
    }

    /* renamed from: n */
    public int m72464n() {
        C1120a.m6677i("DownloadManager", "cancelAllTask");
        if (!m72448R()) {
            return m72466p(1002);
        }
        this.f56103j.m68426k();
        this.f56103j.m68428m(1002);
        m72458b0(this.f56103j);
        return 0;
    }

    /* renamed from: o */
    public final int m72465o(int i10, Vector<Map<String, Object>> vector, Vector<Map<String, Object>> vector2, boolean z10) {
        FileInfo fileInfo;
        if (vector != null) {
            if (!z10) {
                try {
                    m72467q(i10, vector);
                } catch (Exception e10) {
                    C1120a.m6676e("DownloadManager", "cancelDownloadTaskAll error,error message:" + e10.toString());
                    return 1;
                }
            }
            vector.clear();
        }
        if (vector2 == null) {
            return 0;
        }
        for (int i11 = 0; i11 < vector2.size(); i11++) {
            DownloadTaskBaseCallable downloadTaskBaseCallable = (DownloadTaskBaseCallable) vector2.get(i11).get("FIXED_BASECALLABLE_KEY");
            if (downloadTaskBaseCallable != null && (fileInfo = (FileInfo) downloadTaskBaseCallable.getCallParam()) != null) {
                downloadTaskBaseCallable.cancel(i10);
                C1120a.m6677i("DownloadManager", "cancelDownloadTaskAll type:" + fileInfo.getFileType() + ";fileName:" + C1122c.m6818p0(fileInfo.getFileName()));
            }
        }
        return 0;
    }

    /* renamed from: p */
    public final int m72466p(int i10) {
        return m72465o(i10, C2332m.m14608s().m14657w(), C2332m.m14608s().m14656v(), false);
    }

    /* renamed from: q */
    public final void m72467q(int i10, Vector<Map<String, Object>> vector) {
        FileInfo fileInfo;
        if (i10 == 1002) {
            this.f56103j.m68433r(this.f56103j.m68422g() - vector.size());
        } else if (i10 == 1001) {
            this.f56103j.m68431p(this.f56103j.m68420e() + vector.size());
        } else if (i10 == 1003) {
            this.f56103j.m68430o(this.f56103j.m68419d() + vector.size());
        }
        this.f56103j.m68429n(i10);
        for (int i11 = 0; i11 < vector.size(); i11++) {
            DownloadTaskBaseCallable downloadTaskBaseCallable = (DownloadTaskBaseCallable) vector.get(i11).get("FIXED_BASECALLABLE_KEY");
            if (downloadTaskBaseCallable != null && (fileInfo = (FileInfo) downloadTaskBaseCallable.getCallParam()) != null) {
                FileDownloadProgress fileDownloadProgressM72438G = m72438G(fileInfo);
                fileDownloadProgressM72438G.setState(i10);
                this.f56102i.put(fileInfo.getUniqueId(), fileDownloadProgressM72438G);
            }
        }
    }

    /* renamed from: r */
    public int m72468r() {
        C1120a.m6677i("DownloadManager", "cancelTask");
        return m72469s(1002);
    }

    /* renamed from: s */
    public final int m72469s(int i10) {
        return m72465o(i10, C2332m.m14608s().m14659y(), C2332m.m14608s().m14658x(), true);
    }

    /* renamed from: t */
    public final synchronized void m72470t(Message message) {
        C1120a.m6675d("DownloadManager", "dispatchMessage size=" + this.f56107n.size());
        Iterator<Handler> it = this.f56107n.iterator();
        while (it.hasNext()) {
            Handler next = it.next();
            Message messageObtain = Message.obtain();
            messageObtain.what = message.what;
            messageObtain.obj = message.obj;
            next.sendMessage(messageObtain);
        }
    }

    /* renamed from: u */
    public final synchronized void m72471u(C11421g c11421g) {
        int i10;
        try {
            C1120a.m6677i("DownloadManager", "downloadAllNotificationTransact start");
            Context contextM1377a = C0213f.m1377a();
            int iM68423h = (int) c11421g.m68423h();
            int iM68421f = c11421g.m68421f();
            int iM68422g = c11421g.m68422g();
            long jM68417b = c11421g.m68417b();
            long jM68424i = c11421g.m68424i();
            int iM68418c = c11421g.m68418c();
            C1120a.m6675d("DownloadManager", "progress: " + iM68423h + " beanDownloadState: " + iM68418c);
            if (iM68418c == 1000) {
                C1120a.m6677i("DownloadManager", "DOWNLOAD_ALL SUCCEED");
                i10 = 3;
            } else if (iM68418c == 1001) {
                C1120a.m6677i("DownloadManager", "DOWNLOAD_ALL ERROR_PAUSE");
                C12288a.m73827d().m73833g(2, iM68423h, iM68421f, iM68422g, contextM1377a.getString(R$string.main_space_display_divider, C1122c.m6718N(contextM1377a, jM68417b), C1122c.m6718N(contextM1377a, jM68424i)));
                return;
            } else if (iM68418c == 1002) {
                C1120a.m6677i("DownloadManager", "DOWNLOAD_ALL ERROR_CANCEL");
                C12288a.m73827d().m73830c();
                return;
            } else if (iM68418c == 1003) {
                C1120a.m6677i("DownloadManager", "DOWNLOAD_ALL ERROR_FAILED");
                i10 = !C0209d.m1208S0(contextM1377a) ? 4 : 5;
            } else {
                C1120a.m6675d("DownloadManager", "DOWNLOAD_ALL DOWNLOADING");
                i10 = 1;
            }
            C12288a.m73827d().m73833g(i10, iM68423h, iM68421f, iM68422g, contextM1377a.getString(R$string.main_space_display_divider, C1122c.m6718N(contextM1377a, jM68417b), C1122c.m6718N(contextM1377a, jM68424i)));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: v */
    public void m72472v(String str, ImageView imageView, Media media, String str2) {
        C1120a.m6675d("DownloadManager", "downloadBabyHeadPic albumId: " + str);
        m72442L();
        imageView.setTag(str);
        try {
            if (this.f56097d.submit(new CloudAlbumDownloadBabyHeadPicCallable(C0213f.m1377a(), str, imageView, media, str2)) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadBabyHeadPic error: " + e10.toString());
        }
    }

    /* renamed from: w */
    public void m72473w(String str, ImageView imageView) {
        C1120a.m6675d("DownloadManager", "downloadHeadPic ");
        String str2 = C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb/headPic/" + (C11476b.m68626h(str) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT);
        if (C1122c.m6837u1(str2)) {
            C1120a.m6675d("DownloadManager", "head pic exist");
            imageView.setImageBitmap(C0209d.m1311u(str2));
            return;
        }
        m72442L();
        try {
            if (this.f56097d.submit(new CloudAlbumDownloadHeadPicCallable(C0213f.m1377a(), str, imageView)) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadHeadPic error: " + e10.toString());
        }
    }

    /* renamed from: x */
    public void m72474x(Media media, ImageView imageView) {
        m72475y(media, imageView, -1);
    }

    /* renamed from: y */
    public void m72475y(Media media, ImageView imageView, int i10) {
        if (media == null) {
            C1120a.m6675d("DownloadManager", "downloadLCD media is null");
            return;
        }
        C1120a.m6675d("DownloadManager", "downloadLCD media: " + media.toString());
        m72443M();
        ArrayList arrayList = new ArrayList();
        arrayList.add(m72460d0(media));
        try {
            CloudAlbumDownloadCheckCallable cloudAlbumDownloadCheckCallable = new CloudAlbumDownloadCheckCallable(C0213f.m1377a(), 1, arrayList, this.f56105l, imageView, i10);
            cloudAlbumDownloadCheckCallable.setPriority(e.HIGH);
            if (this.f56099f.submit(cloudAlbumDownloadCheckCallable) == null) {
                C1120a.m6675d("DownloadManager", "submit is null");
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadLCD error: " + e10.toString());
        }
    }

    /* renamed from: z */
    public ArrayList<Media> m72476z(List<Media> list) {
        if (list == null) {
            C1120a.m6676e("DownloadManager", "downloadLCDList mediaList is null");
            return null;
        }
        C1120a.m6677i("DownloadManager", "downloadLCDList size: " + list.size());
        m72445O();
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        ArrayList<Media> arrayList = new ArrayList<>();
        c cVar = new c(Looper.getMainLooper());
        cVar.m72477a(countDownLatch);
        cVar.m72478b(arrayList);
        try {
            for (Media media : list) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(m72460d0(media));
                CloudAlbumDownloadCheckCallable cloudAlbumDownloadCheckCallable = new CloudAlbumDownloadCheckCallable(C0213f.m1377a(), 1, arrayList2, this.f56105l, (ImageView) null, cVar);
                cloudAlbumDownloadCheckCallable.setPriority(e.HIGH);
                if (this.f56096c.submit(cloudAlbumDownloadCheckCallable) == null) {
                    C1120a.m6675d("DownloadManager", "submit is null");
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("DownloadManager", "downloadLCDList error: " + e10.toString());
        }
        try {
            C1120a.m6675d("DownloadManager", "downloadLCDList await: " + countDownLatch.await(list.size() * 20, TimeUnit.SECONDS));
        } catch (InterruptedException e11) {
            C1120a.m6676e("DownloadManager", "downloadLCDList countDownLatch error: " + e11.toString());
        }
        C1120a.m6675d("DownloadManager", "downloadLCDList return: " + arrayList.size());
        return arrayList;
    }

    public C12096i() {
        this.f56107n = new ArrayList<>();
        HandlerThread handlerThread = new HandlerThread("DownloadManager");
        handlerThread.start();
        this.f56105l = new d(handlerThread.getLooper());
        this.f56101h = new ConcurrentHashMap<>();
        this.f56102i = new HashMap<>();
        this.f56103j = new C11421g();
    }
}
