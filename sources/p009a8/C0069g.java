package p009a8;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.callable.PhotoUploadCallable;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.AlbumBatchId;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import fk.C9721b;
import hu.C10343b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p050c8.C1395a;
import p281f8.C9674k;
import p283fa.C9678a;
import p546p6.C12088a;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p649t6.C12941a;
import p649t6.C12947g;
import p649t6.C12950j;
import p804ya.C13924a;

/* renamed from: a8.g */
/* loaded from: classes2.dex */
public class C0069g {

    /* renamed from: a */
    public ConcurrentHashMap<String, List<MediaFileBean>> f232a;

    /* renamed from: b */
    public ConcurrentHashMap<String, C1395a> f233b;

    /* renamed from: c */
    public CopyOnWriteArrayList<c> f234c;

    /* renamed from: d */
    public f f235d;

    /* renamed from: e */
    public C12947g f236e;

    /* renamed from: f */
    public volatile boolean f237f;

    /* renamed from: a8.g$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public String f238a;

        /* renamed from: b */
        public String f239b;

        public b(String str, String str2) {
            this.f238a = str;
            this.f239b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C1120a.m6675d("PhotoUploadManager", "getLastUploadTime albumId:" + this.f238a);
            try {
                C12469b.m74746l().m74754h(this.f238a, this.f239b);
            } catch (Exception e10) {
                C1120a.m6676e("PhotoUploadManager", "getAlbum Exception " + e10.getMessage());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: a8.g$c */
    public static class c extends Handler {
        /* renamed from: a */
        public boolean mo519a() {
            return true;
        }
    }

    /* renamed from: a8.g$d */
    public static class d extends TimerTask {
        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C12088a.m72266c().m72275j(C12088a.c.SHARE_PHOTO_UPLOAD_GET_BATCH);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: a8.g$e */
    public static class e {

        /* renamed from: a */
        public static final C0069g f240a = new C0069g();
    }

    /* renamed from: a8.g$f */
    public class f implements CallbackHandler {
        public f() {
        }

        @Override // com.huawei.android.hicloud.album.service.CallbackHandler
        public boolean canStartDownloading(boolean z10, int i10) {
            return false;
        }

        @Override // com.huawei.android.hicloud.album.service.CallbackHandler
        public C9674k getSyncStrategy() {
            return null;
        }

        @Override // com.huawei.android.hicloud.album.service.CallbackHandler
        public boolean invokeEvent(int i10, Bundle bundle) {
            return false;
        }

        @Override // com.huawei.android.hicloud.album.service.CallbackHandler
        public void sendMessage(int i10, Bundle bundle) throws SQLException {
            if (i10 != 200) {
                return;
            }
            C10343b c10343b = new C10343b(bundle);
            String strM63694p = c10343b.m63694p("ALBUM_ID");
            if (C0069g.this.m485F(strM63694p) == 3) {
                C1120a.m6675d("PhotoUploadManager", "receive progress, upload task already paused");
                return;
            }
            String strM63694p2 = c10343b.m63694p("FILE_UNIQUE");
            long jM63688j = c10343b.m63688j("UPLOAD_PROGRESS");
            long j10 = bundle.getLong("UPLOAD_SPEED");
            C1120a.m6675d("PhotoUploadManager", "receive progress, uploadSpeed=" + j10);
            C1395a c1395a = (C1395a) C0069g.this.f233b.get(strM63694p);
            if (c1395a != null && j10 != 0) {
                c1395a.m7985r(j10);
                C0069g.this.m490K(c1395a);
            }
            List list = (List) C0069g.this.f232a.get(strM63694p);
            if (list != null) {
                MediaFileBean mediaFileBean = new MediaFileBean();
                mediaFileBean.m14354u0(strM63694p2);
                int iIndexOf = list.indexOf(mediaFileBean);
                if (iIndexOf != -1) {
                    MediaFileBean mediaFileBean2 = (MediaFileBean) list.get(iIndexOf);
                    if (mediaFileBean2.m14308K() == 3) {
                        C1120a.m6675d("PhotoUploadManager", "receive progress, item upload task already paused");
                        return;
                    }
                    long jM14307I = mediaFileBean2.m14307I();
                    mediaFileBean2.m14356v0(jM63688j);
                    int iM14308K = mediaFileBean2.m14308K();
                    mediaFileBean2.m14357w0(2);
                    list.set(iIndexOf, mediaFileBean2);
                    C0069g.this.f232a.putIfAbsent(strM63694p, list);
                    C0069g.this.m492M(jM14307I, iM14308K, mediaFileBean2);
                }
            }
        }

        @Override // com.huawei.android.hicloud.album.service.CallbackHandler
        public void stInvalid(boolean z10) {
        }

        public /* synthetic */ f(C0069g c0069g, a aVar) {
            this();
        }
    }

    /* renamed from: a8.g$g */
    public class g extends AbstractC2324e {

        /* renamed from: a */
        public MediaFileBean f242a;

        /* renamed from: b */
        public FileInfo f243b;

        public g(Object obj) {
            super(obj);
            MediaFileBean mediaFileBean = (MediaFileBean) obj;
            this.f242a = mediaFileBean;
            this.f243b = mediaFileBean.m14329e();
        }

        /* renamed from: a */
        public final void m521a(int i10) throws SQLException {
            if (i10 == 0) {
                C0069g.this.m499T(this.f242a, 6, i10);
                return;
            }
            if (i10 == 1001) {
                C0069g.this.m499T(this.f242a, 3, i10);
                return;
            }
            if (i10 == 1002) {
                C0069g.this.m499T(this.f242a, 5, i10);
                return;
            }
            if (i10 == 122) {
                C0069g.this.m499T(this.f242a, 4, 1003);
            } else if (C0209d.m1333z1(C0213f.m1377a())) {
                C0069g.this.m499T(this.f242a, 4, i10);
            } else {
                C0069g.this.m499T(this.f242a, 3, FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST);
            }
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
        public void handle(Object obj) throws NumberFormatException, SQLException {
            int iIntValue;
            if (obj instanceof Integer) {
                iIntValue = ((Integer) obj).intValue();
            } else if (obj instanceof HashMap) {
                HashMap map = (HashMap) obj;
                int i10 = "11".equals(map.get("code")) ? 115 : 101;
                try {
                    iIntValue = Integer.parseInt((String) map.get("DownloadFailReason"));
                } catch (Exception e10) {
                    C1120a.m6676e("PhotoUploadManager", e10.getMessage());
                    iIntValue = i10;
                }
            } else {
                iIntValue = 101;
            }
            C1120a.m6677i("PhotoUploadManager", "HandleCallable upload, ret: " + iIntValue + ", fileName: " + C1122c.m6818p0(this.f243b.getFileName()));
            m521a(iIntValue);
            C0069g.this.m512s(this.f243b.getAlbumId(), iIntValue);
        }
    }

    public /* synthetic */ C0069g(a aVar) {
        this();
    }

    /* renamed from: y */
    public static C0069g m479y() {
        return e.f240a;
    }

    /* renamed from: A */
    public String m480A(Media media) {
        if (media == null || !media.containsKey("albumId") || !media.containsKey(ContentResource.FILE_NAME) || !media.containsKey("hashId") || !media.containsKey("size")) {
            return null;
        }
        String albumId = media.getAlbumId();
        String fileName = media.getFileName();
        String hashId = media.getHashId();
        long jLongValue = media.getSize().longValue();
        if (TextUtils.isEmpty(albumId) || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(hashId)) {
            return null;
        }
        return albumId + "_" + fileName + "_" + hashId + "_" + jLongValue;
    }

    /* renamed from: B */
    public Map<String, Integer> m481B(String str) {
        List<MediaFileBean> list;
        C1120a.m6675d("PhotoUploadManager", "getItemUploadStatusMap: albumId=" + str);
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str) || (list = this.f232a.get(str)) == null) {
            return map;
        }
        for (MediaFileBean mediaFileBean : list) {
            map.put(mediaFileBean.m14306A(), Integer.valueOf(mediaFileBean.m14308K()));
        }
        C1120a.m6675d("PhotoUploadManager", "getItemUploadStatusMap: albumId=" + str + ",size=" + map.size());
        return map;
    }

    /* renamed from: C */
    public String m482C(MediaFileBean mediaFileBean) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        if (mediaFileBean == null || TextUtils.isEmpty(mediaFileBean.m14350s()) || mediaFileBean.m14348q() == 0) {
            return strValueOf;
        }
        return mediaFileBean.m14327d() + "_" + mediaFileBean.m14338j() + "_" + mediaFileBean.m14348q() + "_" + mediaFileBean.m14335h() + "_" + mediaFileBean.m14349r();
    }

    /* renamed from: D */
    public List<MediaFileBean> m483D(String str) {
        List<MediaFileBean> list;
        C1120a.m6675d("PhotoUploadManager", "getUploadList: albumId=" + str);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || (list = this.f232a.get(str)) == null) {
            return arrayList;
        }
        for (MediaFileBean mediaFileBean : list) {
            Media mediaM77810W = this.f236e.m77810W(str, mediaFileBean.m14329e().getFileName());
            if (mediaM77810W != null) {
                mediaFileBean.m14332f0(mediaM77810W);
            }
            C12091d.m72280a0().m72376p1(mediaFileBean, mediaFileBean);
        }
        C1120a.m6675d("PhotoUploadManager", "getUploadList: albumId=" + str + ",size=" + list.size());
        return list;
    }

    /* renamed from: E */
    public C1395a m484E(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f233b.get(str);
        }
        C1120a.m6678w("PhotoUploadManager", "getUploadProgress albumId is null");
        return null;
    }

    /* renamed from: F */
    public int m485F(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6678w("PhotoUploadManager", "getUploadStatus albumId is null");
            return 0;
        }
        C1395a c1395a = this.f233b.get(str);
        if (c1395a == null) {
            return 0;
        }
        return c1395a.m7978k();
    }

    /* renamed from: G */
    public void m486G() throws SQLException {
        Album albumM14322a;
        if (this.f237f) {
            C1120a.m6675d("PhotoUploadManager", "initLocalTask already executed");
            return;
        }
        this.f237f = true;
        Iterator<MediaFileBean> it = new C12950j().m77858n().iterator();
        while (it.hasNext()) {
            MediaFileBean next = it.next();
            FileInfo fileInfoM14329e = next.m14329e();
            String albumId = fileInfoM14329e.getAlbumId();
            if (this.f232a.get(albumId) == null) {
                this.f232a.putIfAbsent(albumId, new ArrayList());
                albumM14322a = new C12941a().m77726A(albumId, false);
            } else {
                albumM14322a = this.f232a.get(albumId).get(0).m14322a();
            }
            next.m14312O(albumM14322a);
            Media mediaM77810W = this.f236e.m77810W(albumId, fileInfoM14329e.getFileName());
            if (mediaM77810W != null) {
                next.m14332f0(mediaM77810W);
            }
            next.m14354u0(m518z(next));
            this.f232a.get(albumId).add(next);
            if (this.f233b.get(albumId) == null) {
                this.f233b.putIfAbsent(albumId, new C1395a());
            }
            this.f233b.get(albumId).m7971d(1);
            this.f233b.get(albumId).m7984q(albumId);
            int iM14308K = next.m14308K();
            if (iM14308K == 6) {
                this.f233b.get(albumId).m7970c(1);
            } else if (iM14308K == 3) {
                this.f233b.get(albumId).m7969b(1);
            } else if (iM14308K == 4) {
                this.f233b.get(albumId).m7968a(1);
            }
        }
        for (C1395a c1395a : this.f233b.values()) {
            if (c1395a.m7976i() == c1395a.m7975h()) {
                c1395a.m7986s(6);
            } else if (c1395a.m7976i() > c1395a.m7975h() + c1395a.m7973f() + c1395a.m7974g()) {
                c1395a.m7986s(2);
                m497R(c1395a.m7972e());
            } else if (c1395a.m7974g() > 0) {
                c1395a.m7986s(3);
            } else {
                c1395a.m7986s(4);
            }
            C1120a.m6677i("PhotoUploadManager", "initLocalTask UploadProgress=" + c1395a.toString());
        }
    }

    /* renamed from: H */
    public final void m487H(MediaFileBean mediaFileBean) throws SQLException {
        new C12950j().m77857m(mediaFileBean);
    }

    /* renamed from: I */
    public final boolean m488I(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* renamed from: J */
    public final boolean m489J(FileInfo fileInfo, Vector<Map<String, Object>> vector) {
        return fileInfo == null || vector == null || vector.size() < 1;
    }

    /* renamed from: K */
    public final void m490K(C1395a c1395a) {
        C1120a.m6675d("PhotoUploadManager", "notifyAlbumUploadState: progress=" + c1395a.toString());
        Iterator<c> it = this.f234c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            Message messageObtainMessage = next.obtainMessage();
            messageObtainMessage.what = 101;
            messageObtainMessage.obj = c1395a;
            next.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: L */
    public final void m491L(MediaFileBean mediaFileBean) throws SQLException {
        C1120a.m6675d("PhotoUploadManager", "notifyUploadTaskChanged: " + mediaFileBean.m14306A() + ", uploadState=" + mediaFileBean.m14308K());
        Iterator<c> it = this.f234c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            Message messageObtainMessage = next.obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.obj = mediaFileBean;
            next.sendMessage(messageObtainMessage);
        }
        m510q(mediaFileBean.m14322a());
    }

    /* renamed from: M */
    public final void m492M(long j10, int i10, MediaFileBean mediaFileBean) throws SQLException {
        C1120a.m6675d("PhotoUploadManager", "notifyUploadTaskChanged: " + mediaFileBean.m14306A() + ", lastUpdateProgress=" + j10 + ", lastUpdateState=" + i10 + ", uploadState=" + mediaFileBean.m14308K());
        Iterator<c> it = this.f234c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.mo519a() || i10 != 2) {
                if (j10 == mediaFileBean.m14307I() && i10 == 2) {
                    break;
                }
                Message messageObtainMessage = next.obtainMessage();
                messageObtainMessage.what = 100;
                messageObtainMessage.obj = mediaFileBean;
                next.sendMessage(messageObtainMessage);
            }
        }
        m510q(mediaFileBean.m14322a());
    }

    /* renamed from: N */
    public final void m493N(MediaFileBean mediaFileBean, int i10) throws SQLException {
        Iterator<c> it = this.f234c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            Message messageObtainMessage = next.obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.obj = mediaFileBean;
            messageObtainMessage.arg1 = mediaFileBean.m14308K();
            messageObtainMessage.arg2 = i10;
            next.sendMessage(messageObtainMessage);
        }
        C1120a.m6677i("PhotoUploadManager", "update db upload file status:" + mediaFileBean.m14308K() + ", resultCode:" + i10);
        new C12950j().m77862r(mediaFileBean);
        m491L(mediaFileBean);
    }

    /* renamed from: O */
    public int m494O(String str) {
        C1120a.m6677i("PhotoUploadManager", "pauseAllTask");
        int iM506m = m506m(1001, str);
        C1395a c1395a = this.f233b.get(str);
        if (c1395a == null) {
            return 1;
        }
        c1395a.m7986s(3);
        this.f233b.put(str, c1395a);
        return iM506m;
    }

    /* renamed from: P */
    public int m495P(MediaFileBean mediaFileBean) {
        C1120a.m6677i("PhotoUploadManager", "pauseTask");
        return m509p(mediaFileBean, 1001);
    }

    /* renamed from: Q */
    public void m496Q(c cVar) {
        C1120a.m6677i("PhotoUploadManager", "removeUploadListener");
        this.f234c.remove(cVar);
    }

    /* renamed from: R */
    public int m497R(String str) throws SQLException {
        C1120a.m6677i("PhotoUploadManager", "resumeAllTask");
        List<MediaFileBean> list = this.f232a.get(str);
        C1395a c1395a = this.f233b.get(str);
        if (list == null || c1395a == null) {
            return 1;
        }
        c1395a.m7986s(2);
        c1395a.m7983p();
        this.f233b.put(str, c1395a);
        m490K(c1395a);
        for (MediaFileBean mediaFileBean : list) {
            if (mediaFileBean.m14308K() != 6) {
                mediaFileBean.m14357w0(1);
                m491L(mediaFileBean);
                m502i(mediaFileBean);
            }
        }
        this.f232a.put(str, list);
        return 0;
    }

    /* renamed from: S */
    public void m498S(MediaFileBean mediaFileBean) throws SQLException {
        C1120a.m6677i("PhotoUploadManager", "resumeTask");
        String id2 = mediaFileBean.m14322a().getId();
        List<MediaFileBean> list = this.f232a.get(id2);
        C1395a c1395a = this.f233b.get(id2);
        if (list == null || list.isEmpty() || c1395a == null) {
            C1120a.m6677i("PhotoUploadManager", "resumeTask no task");
            return;
        }
        int iIndexOf = list.indexOf(mediaFileBean);
        if (iIndexOf != -1) {
            MediaFileBean mediaFileBean2 = list.get(iIndexOf);
            if (mediaFileBean2.m14308K() == 4) {
                c1395a.m7968a(-1);
            } else if (mediaFileBean2.m14308K() == 3) {
                c1395a.m7969b(-1);
            }
            c1395a.m7986s(2);
            this.f233b.put(id2, c1395a);
            m490K(c1395a);
            mediaFileBean2.m14357w0(1);
            m491L(mediaFileBean2);
            m502i(mediaFileBean2);
        }
    }

    /* renamed from: T */
    public final void m499T(MediaFileBean mediaFileBean, int i10, int i11) throws SQLException {
        if (TextUtils.isEmpty(m518z(mediaFileBean))) {
            return;
        }
        String id2 = mediaFileBean.m14322a().getId();
        if (TextUtils.isEmpty(id2)) {
            return;
        }
        List<MediaFileBean> list = this.f232a.get(id2);
        C1395a c1395a = this.f233b.get(id2);
        if (i10 == 6) {
            mediaFileBean.m14356v0(100L);
            c1395a.m7970c(1);
        } else if (i10 == 4) {
            c1395a.m7968a(1);
        } else if (i10 == 3) {
            c1395a.m7969b(1);
        } else if (i10 == 5 && list.remove(mediaFileBean)) {
            c1395a.m7981n(1);
            if (mediaFileBean.m14308K() == 4) {
                c1395a.m7968a(-1);
            } else if (mediaFileBean.m14308K() == 3) {
                c1395a.m7969b(-1);
            }
            this.f236e.m77829q(id2, mediaFileBean.m14329e().getHash());
        }
        mediaFileBean.m14357w0(i10);
        if (i10 == 6 || i10 == 4 || i10 == 3) {
            Media mediaM77810W = this.f236e.m77810W(id2, mediaFileBean.m14329e().getFileName());
            if (mediaM77810W != null) {
                mediaFileBean.m14332f0(mediaM77810W);
            }
        }
        this.f232a.put(id2, list);
        this.f233b.put(id2, c1395a);
        m493N(mediaFileBean, i11);
        if (i10 != 2) {
            m490K(c1395a);
        }
    }

    /* renamed from: g */
    public final void m500g(AlbumBatchId albumBatchId, long j10, FileInfo fileInfo) throws JSONException {
        fileInfo.setLocalBatchId(j10);
        if (albumBatchId == null || albumBatchId.getId() == null || albumBatchId.getBatchTime() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fileInfo.getExpand());
            jSONObject.put("batchId", albumBatchId.getId());
            jSONObject.put("batchCtime", albumBatchId.getBatchTime().m28458c());
            C1122c.m6780f2(fileInfo, jSONObject.toString());
        } catch (Exception unused) {
            C1120a.m6676e("PhotoUploadManager", "addUploadTask: expand put error");
        }
    }

    /* renamed from: h */
    public int m501h(List<MediaFileBean> list) throws Exception {
        C1120a.m6677i("PhotoUploadManager", "addTask");
        m513t();
        return m516w(list);
    }

    /* renamed from: i */
    public final void m502i(MediaFileBean mediaFileBean) {
        C2332m.m14608s().m14637c0(new PhotoUploadCallable(m517x(), mediaFileBean, C1122c.m6755Z0("04019"), this.f235d), new g(mediaFileBean), false);
    }

    /* renamed from: j */
    public void m503j(c cVar) {
        C1120a.m6677i("PhotoUploadManager", "addUploadListener");
        this.f234c.add(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* renamed from: k */
    public final int m504k(List<MediaFileBean> list, AlbumBatchId albumBatchId) throws JSONException, SQLException {
        boolean z10 = true;
        if (list == null || list.isEmpty()) {
            return 1;
        }
        int i10 = 0;
        String id2 = list.get(0).m14322a().getId();
        List<MediaFileBean> arrayList = this.f232a.get(id2);
        C1395a c1395a = this.f233b.get(id2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (c1395a == null) {
            c1395a = new C1395a();
            c1395a.m7984q(id2);
        }
        c1395a.m7971d(list.size());
        c1395a.m7986s(2);
        if (this.f233b.putIfAbsent(id2, c1395a) == null) {
            C1120a.m6675d("PhotoUploadManager", "addUploadTask: uploadProgressMap put new progress");
        }
        m490K(c1395a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (MediaFileBean mediaFileBean : list) {
            mediaFileBean.m14354u0(m518z(mediaFileBean));
            FileInfo fileInfoM14329e = mediaFileBean.m14329e();
            Media mediaM77809V = this.f236e.m77809V(id2, fileInfoM14329e.getHash());
            if (mediaM77809V == null) {
                if (this.f236e.m77810W(id2, fileInfoM14329e.getFileName()) != null) {
                    fileInfoM14329e.setRename(z10);
                    String fileName = fileInfoM14329e.getFileName();
                    String strM6826r0 = C1122c.m6826r0(fileName);
                    String strM6810n0 = C1122c.m6810n0(fileName);
                    StringBuilder sb2 = new StringBuilder();
                    int i11 = i10;
                    ?? r22 = z10;
                    while (true) {
                        i11 += r22;
                        sb2.delete(i10, sb2.length());
                        sb2.append(strM6826r0);
                        sb2.append("_");
                        sb2.append(i11);
                        sb2.append(".");
                        sb2.append(strM6810n0);
                        if (this.f236e.m77810W(id2, sb2.toString()) == null) {
                            break;
                        }
                        r22 = 1;
                        i10 = 0;
                    }
                    fileInfoM14329e.setFileName(sb2.toString());
                    C1120a.m6675d("PhotoUploadManager", "addUploadTask: uploadItem need rename");
                }
                m500g(albumBatchId, jCurrentTimeMillis, fileInfoM14329e);
                this.f236e.m77837z(fileInfoM14329e, mediaFileBean.m14322a());
                mediaFileBean.m14357w0(1);
                arrayList.add(mediaFileBean);
                m487H(mediaFileBean);
                m491L(mediaFileBean);
                m502i(mediaFileBean);
                z10 = true;
                i10 = 0;
            } else if (mediaM77809V.getOpType() == z10) {
                C1120a.m6675d("PhotoUploadManager", "addUploadTask: uploadItem already uploading");
                c1395a.m7981n(z10 ? 1 : 0);
                int iIndexOf = arrayList.indexOf(mediaFileBean);
                if (iIndexOf != -1) {
                    MediaFileBean mediaFileBean2 = arrayList.get(iIndexOf);
                    if (mediaFileBean2.m14308K() == 3) {
                        c1395a.m7969b(-1);
                        mediaFileBean2.m14357w0(z10 ? 1 : 0);
                        m502i(mediaFileBean2);
                    } else if (mediaFileBean2.m14308K() == 4) {
                        c1395a.m7968a(-1);
                        mediaFileBean2.m14357w0(z10 ? 1 : 0);
                        m502i(mediaFileBean2);
                    }
                }
            } else {
                mediaFileBean.m14357w0(6);
                mediaFileBean.m14356v0(100L);
                mediaFileBean.m14332f0(mediaM77809V);
                arrayList.add(mediaFileBean);
                c1395a.m7970c(z10 ? 1 : 0);
                m491L(mediaFileBean);
                C1120a.m6675d("PhotoUploadManager", "addUploadTask: uploadItem already uploaded");
            }
        }
        this.f232a.putIfAbsent(id2, arrayList);
        m490K(c1395a);
        return 0;
    }

    /* renamed from: l */
    public int m505l(String str) {
        C1120a.m6677i("PhotoUploadManager", "cancelAllTask");
        return m506m(1002, str);
    }

    /* renamed from: m */
    public final int m506m(int i10, String str) {
        MediaFileBean mediaFileBean;
        try {
            Vector<Map<String, Object>> vectorM14609A = C2332m.m14608s().m14609A();
            if (vectorM14609A != null && vectorM14609A.size() > 0) {
                Iterator<Map<String, Object>> it = vectorM14609A.iterator();
                while (it.hasNext()) {
                    AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) it.next().get("FIXED_BASECALLABLE_KEY");
                    if (abstractCallableC2320a != null) {
                        it.remove();
                        MediaFileBean mediaFileBean2 = (MediaFileBean) abstractCallableC2320a.getCallParam();
                        if (str.equals(mediaFileBean2.m14329e().getAlbumId())) {
                            if (i10 == 1001) {
                                m499T(mediaFileBean2, 3, i10);
                            } else if (i10 == 1002) {
                                m499T(mediaFileBean2, 5, i10);
                            }
                        }
                    }
                }
            }
            Vector<Map<String, Object>> vectorM14660z = C2332m.m14608s().m14660z();
            if (vectorM14660z != null) {
                for (int i11 = 0; i11 < vectorM14660z.size(); i11++) {
                    AbstractCallableC2320a abstractCallableC2320a2 = (AbstractCallableC2320a) vectorM14660z.get(i11).get("FIXED_BASECALLABLE_KEY");
                    if (abstractCallableC2320a2 != null && (mediaFileBean = (MediaFileBean) abstractCallableC2320a2.getCallParam()) != null && str.equals(mediaFileBean.m14329e().getAlbumId())) {
                        C1120a.m6675d("PhotoUploadManager", "cancelUploadTask type:" + mediaFileBean.m14338j() + ";fileName:" + mediaFileBean.m14331f());
                        abstractCallableC2320a2.cancel(i10);
                    }
                }
            }
            if (1002 == i10) {
                new C12950j().m77853i(str);
                this.f236e.m77828p(str);
                this.f232a.remove(str);
                C1395a c1395aRemove = this.f233b.remove(str);
                c1395aRemove.m7982o();
                c1395aRemove.m7986s(5);
                m490K(c1395aRemove);
            }
            return 0;
        } catch (Exception e10) {
            C1120a.m6676e("PhotoUploadManager", "cancelUploadTaskAll error:" + e10.toString());
            return 1;
        }
    }

    /* renamed from: n */
    public int m507n(MediaFileBean mediaFileBean) {
        C1120a.m6677i("PhotoUploadManager", "cancelTask");
        return m509p(mediaFileBean, 1002);
    }

    /* renamed from: o */
    public final boolean m508o(AbstractCallableC2320a abstractCallableC2320a, FileInfo fileInfo, int i10) {
        return fileInfo != null && abstractCallableC2320a.cancel(i10);
    }

    /* renamed from: p */
    public final int m509p(MediaFileBean mediaFileBean, int i10) throws SQLException {
        if (m514u(mediaFileBean, C2332m.m14608s().m14609A(), false, i10) || m514u(mediaFileBean, C2332m.m14608s().m14660z(), true, i10)) {
            return 0;
        }
        if (i10 != 1002) {
            return 1;
        }
        m499T(mediaFileBean, 5, i10);
        return 0;
    }

    /* renamed from: q */
    public final void m510q(Album album) throws SQLException {
        if (album == null) {
            C1120a.m6678w("PhotoUploadManager", "checkAlbumUploadState album is null");
            return;
        }
        C1395a c1395a = this.f233b.get(album.getId());
        if (c1395a.m7979l()) {
            C12515a.m75110o().m75175e(new b(album.getId(), album.getAlbumOwnerId()), false);
            if (c1395a.m7974g() != 0) {
                c1395a.m7986s(3);
            } else if (c1395a.m7973f() != 0) {
                c1395a.m7986s(4);
            } else {
                c1395a.m7986s(6);
                new C12950j().m77853i(album.getId());
            }
            c1395a.m7985r(0L);
            m490K(c1395a);
        }
        this.f233b.put(album.getId(), c1395a);
    }

    /* renamed from: r */
    public void m511r() {
        if (C2332m.m14608s().m14609A().isEmpty() && C2332m.m14608s().m14660z().isEmpty()) {
            C12088a.m72266c().m72275j(C12088a.c.SHARE_PHOTO_UPLOAD);
        }
    }

    /* renamed from: s */
    public final void m512s(String str, int i10) {
        if (i10 == 1003 || i10 == 1004 || i10 == 1007 || i10 == 1006 || i10 == 1008 || i10 == 4946) {
            m494O(str);
        }
        m511r();
    }

    /* renamed from: t */
    public final void m513t() throws SQLException {
        Iterator<C1395a> it = this.f233b.values().iterator();
        while (it.hasNext()) {
            C1395a next = it.next();
            if (next.m7980m()) {
                it.remove();
                String strM7972e = next.m7972e();
                if (!TextUtils.isEmpty(strM7972e)) {
                    this.f232a.remove(strM7972e);
                    new C12950j().m77853i(strM7972e);
                }
            }
        }
    }

    /* renamed from: u */
    public final boolean m514u(MediaFileBean mediaFileBean, Vector<Map<String, Object>> vector, boolean z10, int i10) throws SQLException {
        AbstractCallableC2320a abstractCallableC2320a;
        MediaFileBean mediaFileBean2;
        FileInfo fileInfoM14329e = mediaFileBean.m14329e();
        if (m489J(fileInfoM14329e, vector)) {
            return false;
        }
        String shareId = fileInfoM14329e.getShareId();
        String hash = fileInfoM14329e.getHash();
        if (m488I(shareId, hash)) {
            return false;
        }
        Iterator<Map<String, Object>> it = vector.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map<String, Object> next = it.next();
            if (next != null && (abstractCallableC2320a = (AbstractCallableC2320a) next.get("FIXED_BASECALLABLE_KEY")) != null && abstractCallableC2320a.getCallParam() != null && (mediaFileBean2 = (MediaFileBean) abstractCallableC2320a.getCallParam()) != null) {
                FileInfo fileInfoM14329e2 = mediaFileBean2.m14329e();
                if (shareId.equals(fileInfoM14329e2.getAlbumId()) && hash.equals(fileInfoM14329e2.getHash())) {
                    C1120a.m6677i("PhotoUploadManager", "uploadTaskDeal the file albumId is: " + C1122c.m6740U0(shareId) + ", fileName is: " + C1122c.m6818p0(fileInfoM14329e2.getFileName()));
                    if (z10) {
                        return m508o(abstractCallableC2320a, fileInfoM14329e2, i10);
                    }
                    it.remove();
                    if (i10 == 1001) {
                        m499T(mediaFileBean, 3, i10);
                    } else if (i10 == 1002) {
                        m499T(mediaFileBean, 5, i10);
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: v */
    public final AlbumBatchId m515v(String str, String str2) throws Exception {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("PhotoUploadManager", "getBatch cloudPhoto is null ");
            return null;
        }
        try {
            Albums.BatchIds header = c13924aM60445d.m83547d().batchIds().setAlbumId(str).setHeader("x-hw-lock", C12088a.m72266c().m72270e(C12088a.c.SHARE_PHOTO_UPLOAD_GET_BATCH, false).getSessionId()).setHeader("x-hw-album-owner-Id", str2);
            header.setAlbumClientHeader(C1122c.m6755Z0("04019"));
            AlbumBatchId albumBatchIdExecute = header.execute();
            C1120a.m6675d("PhotoUploadManager", "AlbumBatchId: " + albumBatchIdExecute.toString());
            return albumBatchIdExecute;
        } finally {
            new Timer().schedule(new d(), 10000L);
        }
    }

    /* renamed from: w */
    public final int m516w(List<MediaFileBean> list) throws Exception {
        if (list != null && !list.isEmpty()) {
            MediaFileBean mediaFileBean = list.get(0);
            String id2 = mediaFileBean.m14322a().getId();
            String albumOwnerId = mediaFileBean.m14322a().getAlbumOwnerId();
            if (!TextUtils.isEmpty(id2) && !TextUtils.isEmpty(albumOwnerId)) {
                C1120a.m6677i("PhotoUploadManager", "getBatchIdAndUpload: addUploadTask=" + m504k(list, m515v(id2, albumOwnerId)));
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: x */
    public final Context m517x() {
        return C0213f.m1377a();
    }

    /* renamed from: z */
    public String m518z(MediaFileBean mediaFileBean) {
        FileInfo fileInfoM14329e;
        if (mediaFileBean == null || (fileInfoM14329e = mediaFileBean.m14329e()) == null) {
            return null;
        }
        String albumId = fileInfoM14329e.getAlbumId();
        String fileName = fileInfoM14329e.getFileName();
        String hash = fileInfoM14329e.getHash();
        long size = fileInfoM14329e.getSize();
        if (TextUtils.isEmpty(albumId) || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(hash)) {
            return null;
        }
        return albumId + "_" + fileName + "_" + hash + "_" + size;
    }

    public C0069g() {
        this.f234c = new CopyOnWriteArrayList<>();
        this.f235d = new f();
        this.f236e = new C12947g();
        this.f232a = new ConcurrentHashMap<>();
        this.f233b = new ConcurrentHashMap<>();
    }
}
