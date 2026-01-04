package p604r7;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.album.client.sync.SyncTaskObserver;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileDeleteResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileQueryResponse;
import com.huawei.android.hicloud.album.service.logic.callable.ReportRisksCallable;
import com.huawei.android.hicloud.album.service.logic.callable.ThumbnailPreloadTask;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.AlbumsList;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cursor;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaList;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.hicloud.drive.cloudphoto.request.Changes;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.android.hicloud.drive.user.request.Users;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hicloud.base.drive.user.model.UserList;
import com.huawei.hicloud.base.drive.user.model.UsersListRequest;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import p009a8.C0069g;
import p009a8.C0073k;
import p012ab.C0086a;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p496nn.C11737b;
import p512o7.C11824a;
import p514o9.C11829c;
import p546p6.C12088a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p635s7.C12731f0;
import p635s7.C12733g0;
import p635s7.C12735h0;
import p649t6.C12941a;
import p649t6.C12947g;
import p664u0.C13108a;
import p671u7.C13129a;
import p671u7.C13130b;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p804ya.AbstractC13926c;
import p804ya.C13924a;

/* renamed from: r7.e */
/* loaded from: classes2.dex */
public class C12472e {

    /* renamed from: t */
    public static final Pattern f57404t = Pattern.compile("([^/]*)_BURST(\\d{3})_COVER.JPG$");

    /* renamed from: u */
    public static final Pattern f57405u = Pattern.compile("(([^/]*)_BURST)(\\d{3}).JPG$");

    /* renamed from: a */
    public Handler f57406a;

    /* renamed from: b */
    public boolean f57407b;

    /* renamed from: d */
    public String f57409d;

    /* renamed from: e */
    public C13924a f57410e;

    /* renamed from: f */
    public C0086a f57411f;

    /* renamed from: g */
    public C12470c f57412g;

    /* renamed from: h */
    public SyncTaskObserver f57413h;

    /* renamed from: i */
    public int f57414i;

    /* renamed from: j */
    public String f57415j;

    /* renamed from: k */
    public Context f57416k;

    /* renamed from: l */
    public CommonOpsReport f57417l;

    /* renamed from: m */
    public C12941a f57418m;

    /* renamed from: n */
    public C12947g f57419n;

    /* renamed from: s */
    public volatile Exception f57424s;

    /* renamed from: c */
    public AtomicBoolean f57408c = new AtomicBoolean(false);

    /* renamed from: o */
    public int f57420o = 0;

    /* renamed from: p */
    public boolean f57421p = false;

    /* renamed from: q */
    public Map<String, Long> f57422q = new HashMap();

    /* renamed from: r */
    public Map<String, String> f57423r = new HashMap();

    /* renamed from: r7.e$b */
    public static class b extends AbstractC13926c<Void> {

        /* renamed from: a */
        public Album f57425a;

        /* renamed from: b */
        public C12941a f57426b;

        public b(Album album, C12941a c12941a) {
            this.f57425a = album;
            this.f57426b = c12941a;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            String description;
            Integer code = -1;
            if (error == null) {
                description = "error is null";
            } else {
                code = error.getCode();
                description = error.getDescription();
            }
            C1120a.m6676e("AlbumClientSyncHandler", "album.delete onFailure: " + code + ", info: " + description);
            if (404 == code.intValue()) {
                ArrayList<Album> arrayList = new ArrayList<>();
                arrayList.add(this.f57425a);
                C1122c.m6688D(arrayList);
                this.f57426b.m77734i(arrayList);
            }
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r12, C4609l c4609l) {
            ArrayList<Album> arrayList = new ArrayList<>();
            arrayList.add(this.f57425a);
            C1122c.m6688D(arrayList);
            this.f57426b.m77734i(arrayList);
        }
    }

    /* renamed from: r7.e$c */
    public static class c extends AbstractC13926c<Void> {

        /* renamed from: a */
        public Media f57427a;

        /* renamed from: b */
        public C12947g f57428b;

        public c(Media media, C12947g c12947g) {
            this.f57427a = media;
            this.f57428b = c12947g;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            String description;
            Integer code = -1;
            if (error == null) {
                description = "error is null";
            } else {
                code = error.getCode();
                description = error.getDescription();
            }
            C1120a.m6676e("AlbumClientSyncHandler", "media.delete onFailure: " + code + ", info: " + description);
            if (404 == code.intValue()) {
                ArrayList<Media> arrayList = new ArrayList<>();
                arrayList.add(this.f57427a);
                C1122c.m6703I(arrayList);
                this.f57428b.m77822j(arrayList);
            }
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r12, C4609l c4609l) {
            ArrayList<Media> arrayList = new ArrayList<>();
            arrayList.add(this.f57427a);
            C1122c.m6703I(arrayList);
            this.f57428b.m77822j(arrayList);
        }
    }

    /* renamed from: r7.e$d */
    public class d extends AbstractC12367d {

        /* renamed from: a */
        public CountDownLatch f57429a;

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                } catch (Exception e10) {
                    if (C12472e.this.f57424s == null) {
                        C12472e.this.f57424s = e10;
                    }
                    C1120a.m6676e("AlbumClientSyncHandler", "GetGeneralMediasTask Exception: " + e10.toString());
                }
                if (C12472e.this.f57424s != null) {
                    return;
                }
                C12472e.this.m74837T();
            } finally {
                C1120a.m6677i("AlbumClientSyncHandler", "GetGeneralMediasTask finish");
                this.f57429a.countDown();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }

        public d(CountDownLatch countDownLatch) {
            this.f57429a = countDownLatch;
        }
    }

    /* renamed from: r7.e$e */
    public class e extends AbstractC12367d {

        /* renamed from: a */
        public CountDownLatch f57431a;

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                } catch (Exception e10) {
                    if (C12472e.this.f57424s == null) {
                        C12472e.this.f57424s = e10;
                    }
                    C1120a.m6676e("AlbumClientSyncHandler", "GetShareMediasTask Exception: " + e10.toString());
                }
                if (C12472e.this.f57424s != null) {
                    return;
                }
                C12472e.this.m74840W();
                C12472e.this.m74841X();
                C12472e.this.f57412g.m74788s(true);
                C11737b.m70035b().m70040f();
            } finally {
                C1120a.m6677i("AlbumClientSyncHandler", "GetShareMediasTask finish");
                this.f57431a.countDown();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }

        public e(CountDownLatch countDownLatch) {
            this.f57431a = countDownLatch;
        }
    }

    /* renamed from: r7.e$f */
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:122:0x033d  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0351  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x0379  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x038f A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:136:0x0394  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 940
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p604r7.C12472e.f.handleMessage(android.os.Message):void");
        }
    }

    public C12472e(SyncTaskObserver syncTaskObserver) {
        HandlerThread handlerThread = new HandlerThread("AlbumClientSyncHandler");
        handlerThread.start();
        this.f57406a = new f(handlerThread.getLooper());
        this.f57412g = C12470c.m74770d();
        this.f57413h = syncTaskObserver;
        this.f57416k = C0213f.m1377a();
        this.f57418m = new C12941a();
        this.f57419n = new C12947g();
    }

    /* renamed from: u */
    public static /* synthetic */ int m74815u(C12472e c12472e) {
        int i10 = c12472e.f57420o;
        c12472e.f57420o = i10 + 1;
        return i10;
    }

    /* renamed from: A */
    public final void m74818A() throws C9721b {
        m74825H("checkClearVersion");
        String strM74772b = this.f57412g.m74772b();
        String strM74775f = this.f57412g.m74775f();
        long jM1689g = C0241z.m1689g(strM74772b, -1L);
        long jM1689g2 = C0241z.m1689g(strM74775f, -1L);
        if (jM1689g == -1 || jM1689g2 == -1 || jM1689g >= jM1689g2) {
            return;
        }
        C1120a.m6678w("AlbumClientSyncHandler", "disable expired, changeStartCursor:" + jM1689g + ", suspendCursor:" + jM1689g2);
        this.f57412g.m74771a();
        C11824a.m70444a();
        C1122c.m6697G(C1122c.m6778f0());
        this.f57417l.m15209C(this.f57409d, this.f57415j, 0, "success");
        m74852i0();
    }

    /* renamed from: B */
    public final void m74819B(Media media) {
        if (media.getAlbumType() == 1 || TextUtils.isEmpty(media.getFileName())) {
            return;
        }
        String upperCase = media.getFileName().toUpperCase(Locale.ENGLISH);
        if (f57404t.matcher(upperCase).find()) {
            media.setHwBurstType(1);
        } else if (f57405u.matcher(upperCase).find()) {
            media.setHwBurstType(2);
        } else {
            media.setHwBurstType(0);
        }
    }

    /* renamed from: C */
    public final void m74820C(Media media) {
        if (media.getAlbumType() == 0) {
            return;
        }
        Map<String, String> properties = media.getProperties();
        if (properties.containsKey("batchCtime")) {
            media.setBatchV1Time(C0241z.m1689g(properties.get("batchCtime"), 0L));
        }
        if (properties.containsKey("batchId")) {
            media.setBatchV1Id(C0241z.m1689g(properties.get("batchId"), 0L));
        }
    }

    /* renamed from: D */
    public final void m74821D(Media media) {
        if (media == null || media.getCreator() == null || TextUtils.isEmpty(media.getCreator().getUserId())) {
            return;
        }
        String userId = media.getCreator().getUserId();
        String str = this.f57423r.get(userId);
        if (!TextUtils.isEmpty(str)) {
            media.getCreator().setDisplayName(str);
            return;
        }
        m74836S(userId);
        String str2 = this.f57423r.get(userId);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        media.getCreator().setDisplayName(str2);
    }

    /* renamed from: E */
    public final boolean m74822E(Album album) throws Exception {
        List<Permission> permissions = album.getPermissions();
        if (permissions != null) {
            Iterator<Permission> it = permissions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Permission next = it.next();
                if (next.getUserId() != null && next.getUserId().equals(C13452e.m80781L().m80971t0()) && next.getStatus() != null) {
                    if (next.getStatus().intValue() != 1) {
                        return false;
                    }
                }
            }
        }
        if ("2.0".equals(album.getAlbumVersion())) {
            return true;
        }
        if (!C13129a.m78964e(album, this.f57409d)) {
            return false;
        }
        this.f57422q.put(album.getId(), Long.valueOf(album.getFlversion()));
        return true;
    }

    /* renamed from: F */
    public final boolean m74823F(int i10) {
        return C13452e.m80781L().m80842P0() && C10028c.m62182c0().m62221H1() && (!C11829c.m70532M0() || C10028c.m62182c0().m62413x()) && !this.f57408c.get() && i10 <= 3;
    }

    /* renamed from: G */
    public final void m74824G(int i10) {
        if (i10 == 401 || i10 == 402) {
            m74854k0(true);
        }
    }

    /* renamed from: H */
    public final void m74825H(String str) throws C9721b {
        this.f57415j = str;
        C1120a.m6677i("AlbumClientSyncHandler", "sync task, cmd: " + str);
        if (this.f57408c.get()) {
            C1120a.m6676e("AlbumClientSyncHandler", "cancel sync task, cmd: " + str);
            throw new C9721b(1, "cancel sync task");
        }
    }

    /* renamed from: I */
    public final void m74826I() throws Exception {
        ArrayList<Album> arrayListM77751z = this.f57418m.m77751z();
        if (arrayListM77751z.isEmpty()) {
            return;
        }
        C1120a.m6677i("AlbumClientSyncHandler", "dealBatchDeletedAlbums size " + arrayListM77751z.size());
        CloudPhotoBatch cloudPhotoBatchM83551h = this.f57410e.m83551h();
        cloudPhotoBatchM83551h.setAlbumClient(true);
        int size = arrayListM77751z.size();
        int i10 = 0;
        for (int i11 = 0; i11 < arrayListM77751z.size(); i11++) {
            Album album = arrayListM77751z.get(i11);
            Albums.Delete deleteMode = this.f57410e.m83547d().delete(album.getId()).addHeader("x-hw-lock", (Object) C12088a.m72266c().m72270e(C12088a.c.ALBUM_CLIENT_SYNC, true).getSessionId()).setDeleteMode(true);
            deleteMode.setAlbumClientHeader(this.f57409d);
            deleteMode.queue(cloudPhotoBatchM83551h, new b(album, this.f57418m));
            i10++;
            if ((i10 % C1136q.d.m7148l() == 0 || size == i10) && cloudPhotoBatchM83551h.size() > 0) {
                m74825H("dealBatchDeletedAlbums");
                cloudPhotoBatchM83551h.execute();
                cloudPhotoBatchM83551h = this.f57410e.m83551h();
                cloudPhotoBatchM83551h.setAlbumClient(true);
            }
        }
    }

    /* renamed from: J */
    public final void m74827J() throws Exception {
        int i10 = 0;
        ArrayList<Media> arrayListM77792E = this.f57419n.m77792E(0, RippleView.SINGLE_RIPPLE_TIME);
        int i11 = 0;
        while (!arrayListM77792E.isEmpty()) {
            C1120a.m6677i("AlbumClientSyncHandler", "dealBatchDeletedFiles size " + arrayListM77792E.size());
            HashMap map = new HashMap();
            ArrayList<Media> arrayList = new ArrayList<>();
            m74853j0(arrayListM77792E, map, arrayList);
            C1120a.m6677i("AlbumClientSyncHandler", "deleteListV2 size " + arrayList.size());
            CloudPhotoBatch cloudPhotoBatchM83551h = this.f57410e.m83551h();
            cloudPhotoBatchM83551h.setAlbumClient(true);
            int size = arrayList.size();
            int i12 = i10;
            int i13 = i12;
            while (i12 < arrayList.size()) {
                Media media = arrayList.get(i12);
                String id2 = media.getId();
                if (TextUtils.isEmpty(id2)) {
                    ArrayList<Media> arrayList2 = new ArrayList<>();
                    arrayList2.add(media);
                    this.f57419n.m77822j(arrayList2);
                    size--;
                } else {
                    Medias.Delete deleteAddHeader = this.f57410e.m83556m().delete(id2).addHeader("x-hw-media-owner-Id", (Object) media.getMediaOwnerId()).addHeader("x-hw-lock", (Object) C12088a.m72266c().m72270e(C12088a.c.ALBUM_CLIENT_SYNC, true).getSessionId());
                    deleteAddHeader.setAlbumClientHeader(this.f57409d);
                    deleteAddHeader.queue(cloudPhotoBatchM83551h, new c(media, this.f57419n));
                    i13++;
                }
                if ((i13 % C1136q.d.m7148l() == 0 || size == i13) && cloudPhotoBatchM83551h.size() > 0) {
                    m74825H("dealBatchDeletedFiles");
                    cloudPhotoBatchM83551h.execute();
                    cloudPhotoBatchM83551h = this.f57410e.m83551h();
                    cloudPhotoBatchM83551h.setAlbumClient(true);
                }
                i12++;
            }
            m74828K(map);
            i11 += 2000;
            arrayListM77792E = this.f57419n.m77792E(i11, RippleView.SINGLE_RIPPLE_TIME);
            i10 = 0;
        }
    }

    /* renamed from: K */
    public final void m74828K(Map<String, List<Media>> map) throws Exception {
        C1120a.m6677i("AlbumClientSyncHandler", "dealBatchDeletedFilesV1 album size " + map.keySet().size());
        for (Map.Entry<String, List<Media>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Media> value = entry.getValue();
            if (value != null && !value.isEmpty()) {
                C1120a.m6677i("AlbumClientSyncHandler", "dealBatchDeletedFilesV1 media size " + value.size());
                ArrayList arrayList = new ArrayList();
                String mediaOwnerId = "";
                for (Media media : value) {
                    if (media != null) {
                        FileData fileData = new FileData();
                        fileData.setHash(media.getHashId());
                        arrayList.add(fileData);
                        mediaOwnerId = media.getMediaOwnerId();
                    }
                }
                if (!arrayList.isEmpty()) {
                    m74825H("dealBatchDeletedFilesV1");
                    Iterator it = C1122c.m6820p2(arrayList, 100).iterator();
                    while (it.hasNext()) {
                        C12731f0 c12731f0 = new C12731f0(C0213f.m1377a(), this.f57409d, key, mediaOwnerId, (List) it.next());
                        c12731f0.m80106e();
                        FileDeleteResponse fileDeleteResponseM80113o = c12731f0.m80113o(FileDeleteResponse.class);
                        if (fileDeleteResponseM80113o.getCode() != 0) {
                            C1120a.m6676e("AlbumClientSyncHandler", "dealBatchDeletedFilesV1 " + fileDeleteResponseM80113o.getCode() + ", info " + fileDeleteResponseM80113o.getInfo());
                        } else {
                            String[] successList = fileDeleteResponseM80113o.getSuccessList();
                            if (successList != null) {
                                C1120a.m6677i("AlbumClientSyncHandler", "dealBatchDeletedFilesV1 success size " + successList.length);
                                for (String str : successList) {
                                    this.f57419n.m77827o(key, str);
                                }
                            }
                        }
                    }
                    C1122c.m6703I(value);
                }
            }
        }
    }

    /* renamed from: L */
    public final void m74829L() throws Exception {
        if (TextUtils.isEmpty(this.f57412g.m74772b())) {
            m74847d0();
            m74834Q();
            m74839V();
            C12470c c12470c = this.f57412g;
            c12470c.m74783n(c12470c.m74778i());
            C11737b.m70035b().m70038d();
        }
        if (TextUtils.isEmpty(this.f57412g.m74773c())) {
            C12470c c12470c2 = this.f57412g;
            c12470c2.m74784o(c12470c2.m74772b());
        }
        m74832O();
    }

    /* renamed from: M */
    public void m74830M() {
        C1120a.m6677i("AlbumClientSyncHandler", "endSync");
        this.f57408c.set(true);
    }

    /* renamed from: N */
    public final void m74831N() throws C9721b, IOException {
        m74825H("getAbout");
        About aboutM598c = C0073k.m595d().m598c(this.f57409d, true, null);
        C1120a.m6675d("AlbumClientSyncHandler", "About: " + aboutM598c.toString());
        this.f57412g.m74789t(aboutM598c.getStatus().getSuspendCursor());
        this.f57417l.m15209C(this.f57409d, this.f57415j, 0, "success");
    }

    /* renamed from: O */
    public final void m74832O() throws Exception {
        String strM74846c0 = m74846c0();
        if (this.f57412g.m74772b().equals(strM74846c0)) {
            C1120a.m6677i("AlbumClientSyncHandler", "start cursor equals");
            return;
        }
        C1120a.m6677i("AlbumClientSyncHandler", "localStartCursor " + this.f57412g.m74772b());
        m74835R();
        C11737b.m70035b().m70037c();
        m74844a0();
        m74838U();
        if (this.f57421p) {
            C11737b.m70035b().m70039e();
        }
        this.f57412g.m74783n(strM74846c0);
    }

    /* renamed from: P */
    public final ArrayList<Album> m74833P(String str) throws Exception {
        ArrayList<Album> arrayList = new ArrayList<>();
        Albums.List includeDeleted = this.f57410e.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,owner(userId),albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions(userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege),privilege,properties,resource,shareType,source,type,recycled)").setIncludeDeleted(Boolean.TRUE);
        includeDeleted.setAlbumClientHeader(this.f57409d);
        String nextCursor = null;
        String nextCursor2 = null;
        do {
            m74825H(str);
            AlbumsList albumsListExecute = includeDeleted.setCursor(nextCursor2).execute();
            List<Album> albums = albumsListExecute.getAlbums();
            if (albums != null) {
                C1120a.m6677i("AlbumClientSyncHandler", str + " albums size: " + albums.size());
                for (Album album : albums) {
                    if (album != null && album.getOwner() != null) {
                        album.setAlbumOwnerId(album.getOwner().getUserId());
                        m74861z(album);
                        arrayList.add(album);
                    }
                }
            }
            nextCursor2 = albumsListExecute.getNextCursor();
        } while (!TextUtils.isEmpty(nextCursor2));
        Albums.List queryParam = this.f57410e.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,owner(userId),albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions(userId,displayName,status,role,userAccount,id,remark,kinship,properties,source,privilege),privilege,properties,resource,shareType,source,type,recycled)").setQueryParam("albumType = 1 and sharedWithMe = true");
        queryParam.setAlbumClientHeader(this.f57409d);
        do {
            m74825H(str);
            AlbumsList albumsListExecute2 = queryParam.setCursor(nextCursor).execute();
            List<Album> albums2 = albumsListExecute2.getAlbums();
            if (albums2 != null) {
                C1120a.m6677i("AlbumClientSyncHandler", str + " otherAlbums size: " + albums2.size());
                for (Album album2 : albums2) {
                    if (album2 != null && album2.getOwner() != null) {
                        album2.setAlbumOwnerId(album2.getOwner().getUserId());
                        if (m74822E(album2)) {
                            m74861z(album2);
                            arrayList.add(album2);
                        }
                    }
                }
            }
            nextCursor = albumsListExecute2.getNextCursor();
        } while (!TextUtils.isEmpty(nextCursor));
        this.f57417l.m15209C(this.f57409d, str, 0, "success");
        return arrayList;
    }

    /* renamed from: Q */
    public final void m74834Q() throws Exception {
        if (this.f57412g.m74779j()) {
            C1120a.m6677i("AlbumClientSyncHandler", "already getAllAlbumsForSyncAll");
            return;
        }
        this.f57418m.m77738m();
        this.f57418m.m77735j(m74833P("getAllAlbumsForSyncAll"));
        this.f57412g.m74782m(true);
    }

    /* renamed from: R */
    public final void m74835R() throws Exception {
        ArrayList<Album> arrayListM74833P = m74833P("getAllAlbumsForSyncChanges");
        ArrayList<Album> arrayListM77750y = this.f57418m.m77750y(false);
        if (arrayListM77750y.isEmpty()) {
            C1120a.m6677i("AlbumClientSyncHandler", "localAlbumList empty");
            this.f57418m.m77735j(arrayListM74833P);
            return;
        }
        C1120a.m6677i("AlbumClientSyncHandler", "cloudAlbumList size: " + arrayListM74833P.size() + ", localAlbumList size: " + arrayListM77750y.size());
        ArrayList<Album> arrayList = new ArrayList<>();
        ArrayList<Album> arrayList2 = new ArrayList<>();
        Iterator<Album> it = arrayListM74833P.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            Album albumM77726A = this.f57418m.m77726A(next.getId(), false);
            if (albumM77726A == null) {
                arrayList.add(next);
            } else {
                m74850g0(next, arrayListM77750y);
                if (!C12471d.m74794a(albumM77726A.getOpType())) {
                    next.setDefaultAlbum(albumM77726A.isDefaultAlbum());
                    next.setTopAlbum(albumM77726A.isTopAlbum());
                    next.setNextCursor(albumM77726A.getNextCursor());
                    next.setFlversion(albumM77726A.getFlversion());
                    arrayList2.add(next);
                }
            }
        }
        C1120a.m6677i("AlbumClientSyncHandler", "insertAlbumList size: " + arrayList.size() + ", updateAlbumList size: " + arrayList2.size() + ", deleteAlbumList size: " + arrayListM77750y.size());
        this.f57418m.m77735j(arrayList);
        this.f57418m.m77736k(arrayList2);
        C1122c.m6688D(arrayListM77750y);
        this.f57418m.m77734i(arrayListM77750y);
    }

    /* renamed from: S */
    public final void m74836S(String str) {
        try {
            UsersListRequest usersListRequest = new UsersListRequest();
            usersListRequest.setQueryParam("userId in (" + str + ")");
            Users.List list = this.f57411f.m676c().list(usersListRequest);
            list.setHeader("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
            list.setHeader("x-hw-3rdapp-packagename", "com.huawei.hidisk");
            list.setHeader("x-hw-3rdapp-version", "16.0.0.300");
            list.setHeader("x-hw-trace-id", this.f57409d);
            list.setFields2("userList(displayName,userId)");
            UserList userListExecute = list.execute();
            C1120a.m6675d("AlbumClientSyncHandler", "userList: " + userListExecute.toString());
            List<User> userList = userListExecute.getUserList();
            if (userList == null) {
                return;
            }
            for (int i10 = 0; i10 < userList.size(); i10++) {
                User user = userList.get(i10);
                if (!TextUtils.isEmpty(user.getUserId()) && !TextUtils.isEmpty(user.getDisplayName())) {
                    this.f57423r.put(user.getUserId(), user.getDisplayName());
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("AlbumClientSyncHandler", "get displayName " + e10.toString());
        }
    }

    /* renamed from: T */
    public final void m74837T() throws C9721b, IOException {
        String strM74776g = this.f57412g.m74776g();
        if ("COMPLETE".equals(strM74776g)) {
            C1120a.m6677i("AlbumClientSyncHandler", "already getGeneralMedias");
            return;
        }
        Medias.List pageSize = this.f57410e.m83556m().list("0").setQueryParam("(albumType = 0)").setOrderBy("createdTime desc").setFields2("nextCursor,media(albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,id,mediaOwnerId,creator(userId,displayName),pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,hashId,sha256)").setPageSize(100);
        pageSize.setAlbumClientHeader(this.f57409d);
        int i10 = 0;
        do {
            m74825H("getGeneralMedias");
            ArrayList<Media> arrayList = new ArrayList<>();
            MediaList mediaListExecute = pageSize.setCursor(strM74776g).execute();
            List<Media> media = mediaListExecute.getMedia();
            if (media != null) {
                C1120a.m6677i("AlbumClientSyncHandler", "getGeneralMedias size: " + media.size());
                for (Media media2 : media) {
                    if (media2 != null) {
                        media2.setAlbumType(0);
                        media2.setAlbumVersion("2.0");
                        m74819B(media2);
                        arrayList.add(media2);
                    }
                }
            }
            this.f57419n.m77824l(arrayList);
            strM74776g = mediaListExecute.getNextCursor();
            if (TextUtils.isEmpty(strM74776g)) {
                this.f57412g.m74790u("COMPLETE");
            } else {
                this.f57412g.m74790u(strM74776g);
                if (i10 % 3 == 0) {
                    C11737b.m70035b().m70039e();
                }
                i10++;
            }
            this.f57417l.m15209C(this.f57409d, "getGeneralMedias", 0, "success");
        } while (!TextUtils.isEmpty(strM74776g));
    }

    /* renamed from: U */
    public final void m74838U() throws C9721b, IOException {
        String strM74773c = this.f57412g.m74773c();
        Changes.List kinds = this.f57410e.m83546c().list(strM74773c).setFields2("newStartCursor,nextCursor,changes(changeType,deleted,albumId,mediaId,media(albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,id,mediaOwnerId,creator(userId,displayName),pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,hashId,sha256))").setKinds(ReportRisksCallable.RISK_INFO_CREATE_KIND);
        kinds.setAlbumClientHeader(this.f57409d);
        while (true) {
            m74825H("getMediaChanges");
            ChangeList changeListExecute = kinds.setCursor(strM74773c).execute();
            List<Change> changes = changeListExecute.getChanges();
            if (changes != null) {
                C1120a.m6677i("AlbumClientSyncHandler", "getMediaChanges size: " + changes.size());
                if (!changes.isEmpty()) {
                    this.f57421p = true;
                }
                m74859x(changes);
            }
            String nextCursor = changeListExecute.getNextCursor();
            if (!TextUtils.isEmpty(nextCursor)) {
                this.f57412g.m74784o(nextCursor);
            } else if (!TextUtils.isEmpty(changeListExecute.getNewStartCursor())) {
                this.f57412g.m74784o(changeListExecute.getNewStartCursor());
            }
            this.f57417l.m15209C(this.f57409d, this.f57415j, 0, "success");
            if (TextUtils.isEmpty(nextCursor)) {
                return;
            } else {
                strM74773c = nextCursor;
            }
        }
    }

    /* renamed from: V */
    public final void m74839V() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        C12515a.m75110o().m75175e(new d(countDownLatch), true);
        C12515a.m75110o().m75175e(new e(countDownLatch), true);
        countDownLatch.await();
        if (this.f57424s != null) {
            throw this.f57424s;
        }
    }

    /* renamed from: W */
    public final void m74840W() throws C9721b, IOException {
        String strM74777h = this.f57412g.m74777h();
        if ("COMPLETE".equals(strM74777h)) {
            C1120a.m6677i("AlbumClientSyncHandler", "already getMyShareMedias");
            return;
        }
        Medias.List pageSize = this.f57410e.m83556m().list("0").setQueryParam("(albumType = 1)").setOrderBy("createdTime desc").setFields2("nextCursor,media(albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,id,mediaOwnerId,creator(userId,displayName),pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,hashId,sha256)").setPageSize(100);
        pageSize.setAlbumClientHeader(this.f57409d);
        int i10 = 0;
        do {
            m74825H("getMyShareMedias");
            ArrayList<Media> arrayList = new ArrayList<>();
            MediaList mediaListExecute = pageSize.setCursor(strM74777h).execute();
            List<Media> media = mediaListExecute.getMedia();
            if (media != null) {
                C1120a.m6677i("AlbumClientSyncHandler", "getMyShareMedias size: " + media.size());
                for (Media media2 : media) {
                    if (media2 != null) {
                        media2.setAlbumType(1);
                        media2.setAlbumVersion("2.0");
                        m74820C(media2);
                        arrayList.add(media2);
                    }
                }
            }
            this.f57419n.m77824l(arrayList);
            strM74777h = mediaListExecute.getNextCursor();
            if (TextUtils.isEmpty(strM74777h)) {
                this.f57412g.m74791v("COMPLETE");
            } else {
                this.f57412g.m74791v(strM74777h);
                if (i10 % 3 == 0) {
                    C11737b.m70035b().m70039e();
                }
                i10++;
            }
            this.f57417l.m15209C(this.f57409d, "getMyShareMedias", 0, "success");
        } while (!TextUtils.isEmpty(strM74777h));
    }

    /* renamed from: X */
    public final void m74841X() throws Exception {
        m74825H("getOtherShareMedias");
        ArrayList<Album> arrayListM77727B = this.f57418m.m77727B(1, false);
        if (arrayListM77727B.isEmpty()) {
            return;
        }
        Iterator<Album> it = arrayListM77727B.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            if (!next.getAlbumOwnerId().equals(C13452e.m80781L().m80971t0())) {
                C1120a.m6675d("AlbumClientSyncHandler", "getOtherShareMedias albumId " + next.getId() + ", nextCursor " + next.getNextCursor());
                if (!"COMPLETE".equals(next.getNextCursor())) {
                    if ("1.0".equals(next.getAlbumVersion())) {
                        m74842Y(next, false);
                    } else {
                        m74843Z(next, false);
                    }
                }
            }
        }
    }

    /* renamed from: Y */
    public final void m74842Y(Album album, boolean z10) throws Exception {
        boolean zIsHasMore;
        int iM1686d = C0241z.m1686d(album.getNextCursor(), 0);
        do {
            m74825H("getOthersMediasForV1");
            ArrayList<Media> arrayList = new ArrayList<>();
            C12735h0 c12735h0 = new C12735h0(C0213f.m1377a(), this.f57409d, album.getAlbumOwnerId(), album.getId(), album.getResource(), iM1686d);
            c12735h0.m80106e();
            FileQueryResponse fileQueryResponseM80113o = c12735h0.m80113o(FileQueryResponse.class);
            if (fileQueryResponseM80113o.getCode() != 0) {
                C1120a.m6676e("AlbumClientSyncHandler", "getOthersMediasForV1 " + fileQueryResponseM80113o.getCode() + ", info " + fileQueryResponseM80113o.getInfo());
                return;
            }
            FileData[] fileList = fileQueryResponseM80113o.getFileList();
            if (fileList != null) {
                C1120a.m6677i("AlbumClientSyncHandler", "V1 other medias size: " + fileList.length);
                if (z10 && fileList.length != 0) {
                    this.f57421p = true;
                }
                for (FileData fileData : fileList) {
                    if (fileData != null) {
                        JsonObject expand = fileData.getExpand();
                        if (expand != null) {
                            fileData.setExpandString(expand.toString());
                        }
                        Media media = new Media();
                        media.setAlbumId(fileData.getAlbumId());
                        media.setCreatedTime(new C4644l(fileData.getCreateTime()));
                        media.setEditedTime(media.getCreatedTime());
                        media.setFileName(fileData.getFileName());
                        media.setFileType(Integer.valueOf(fileData.getFileType()));
                        media.setId(fileData.getFileId());
                        media.setMediaOwnerId(album.getAlbumOwnerId());
                        media.setSize(Long.valueOf(fileData.getSize()));
                        media.setSource(fileData.getSource());
                        media.setAlbumVersion("1.0");
                        media.setAlbumType(1);
                        media.setHashId(fileData.getHash());
                        media.setVideoThumbId(fileData.getVideoThumbId());
                        media.setThumbFileId(fileData.getThumbFileId());
                        media.setLcdFileId(fileData.getLcdFileId());
                        C13130b.m78985n(media, fileData.getExpandString());
                        m74820C(media);
                        m74821D(media);
                        arrayList.add(media);
                    }
                }
            }
            this.f57419n.m77824l(arrayList);
            zIsHasMore = fileQueryResponseM80113o.isHasMore();
            if (zIsHasMore) {
                iM1686d += 50;
                this.f57418m.m77731F(String.valueOf(iM1686d), album.getId());
            } else {
                this.f57418m.m77731F("COMPLETE", album.getId());
            }
            this.f57417l.m15209C(this.f57409d, "getOthersMediasForV1", 0, "success");
        } while (zIsHasMore);
    }

    /* renamed from: Z */
    public final void m74843Z(Album album, boolean z10) throws C9721b, IOException, SQLException {
        String nextCursor = album.getNextCursor();
        Medias.List pageSize = this.f57410e.m83556m().list("0").setOrderBy("createdTime desc").setFields2("nextCursor,media(albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,id,mediaOwnerId,creator(userId,displayName),pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,hashId,sha256)").setQueryParam("albumId = '" + album.getId() + "'").setPageSize(100);
        pageSize.setAlbumClientHeader(this.f57409d);
        pageSize.addHeader("x-hw-album-owner-Id", (Object) album.getAlbumOwnerId());
        do {
            m74825H("getOthersMediasForV2");
            ArrayList<Media> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(nextCursor)) {
                pageSize.setCursor(nextCursor);
            }
            MediaList mediaListExecute = pageSize.execute();
            List<Media> media = mediaListExecute.getMedia();
            if (media != null) {
                C1120a.m6677i("AlbumClientSyncHandler", "other medias size: " + media.size());
                if (z10 && !media.isEmpty()) {
                    this.f57421p = true;
                }
                for (Media media2 : media) {
                    if (media2 != null) {
                        media2.setAlbumType(1);
                        media2.setAlbumVersion("2.0");
                        m74820C(media2);
                        arrayList.add(media2);
                    }
                }
            }
            this.f57419n.m77824l(arrayList);
            nextCursor = mediaListExecute.getNextCursor();
            if (TextUtils.isEmpty(nextCursor)) {
                this.f57418m.m77731F("COMPLETE", album.getId());
            } else {
                this.f57418m.m77731F(nextCursor, album.getId());
            }
            this.f57417l.m15209C(this.f57409d, "getOthersMediasForV2", 0, "success");
        } while (!TextUtils.isEmpty(nextCursor));
    }

    /* renamed from: a0 */
    public final void m74844a0() throws Exception {
        m74825H("getShareMediaChanges");
        ArrayList<Album> arrayListM77727B = this.f57418m.m77727B(1, false);
        if (arrayListM77727B.isEmpty()) {
            return;
        }
        Iterator<Album> it = arrayListM77727B.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            if (!next.getAlbumOwnerId().equals(C13452e.m80781L().m80971t0())) {
                C1120a.m6675d("AlbumClientSyncHandler", "getShareMediaChanges albumId " + next.getId() + ", albumVersion " + next.getAlbumVersion() + ", nextCursor " + next.getNextCursor() + ", flversion " + next.getFlversion());
                if ("2.0".equals(next.getAlbumVersion())) {
                    if (!"COMPLETE".equals(next.getNextCursor())) {
                        m74843Z(next, true);
                    }
                } else if ("COMPLETE".equals(next.getNextCursor())) {
                    Long l10 = this.f57422q.get(next.getId());
                    if (l10 == null) {
                        C1120a.m6676e("AlbumClientSyncHandler", "cloud flversion null");
                    } else if (l10.longValue() == next.getFlversion()) {
                        C1120a.m6677i("AlbumClientSyncHandler", "flversion equals");
                    } else {
                        m74845b0(next);
                    }
                } else {
                    m74842Y(next, true);
                }
            }
        }
    }

    /* renamed from: b0 */
    public final void m74845b0(Album album) throws Exception {
        ShareAlbumData shareAlbumData = new ShareAlbumData();
        shareAlbumData.setOwnerId(album.getAlbumOwnerId());
        shareAlbumData.setShareId(album.getId());
        shareAlbumData.setFlversion(album.getFlversion());
        shareAlbumData.setResource(album.getResource());
        String incCursor = null;
        do {
            m74825H("getShareMediaChangesForV1");
            C12733g0 c12733g0 = new C12733g0(C0213f.m1377a(), this.f57409d, shareAlbumData, incCursor);
            c12733g0.m80106e();
            FileQueryResponse fileQueryResponseM80113o = c12733g0.m80113o(FileQueryResponse.class);
            if (fileQueryResponseM80113o.getCode() != 0) {
                C1120a.m6676e("AlbumClientSyncHandler", "getShareMediaChangesForV1 " + fileQueryResponseM80113o.getCode() + ", info " + fileQueryResponseM80113o.getInfo());
                return;
            }
            FileData[] fileList = fileQueryResponseM80113o.getFileList();
            if (fileList != null) {
                C1120a.m6677i("AlbumClientSyncHandler", "V1 other changes size: " + fileList.length);
                if (fileList.length != 0) {
                    this.f57421p = true;
                }
                for (FileData fileData : fileList) {
                    if (fileData != null) {
                        JsonObject expand = fileData.getExpand();
                        if (expand != null) {
                            fileData.setExpandString(expand.toString());
                        }
                        Media media = new Media();
                        media.setAlbumId(fileData.getAlbumId());
                        media.setCreatedTime(new C4644l(fileData.getCreateTime()));
                        media.setEditedTime(media.getCreatedTime());
                        media.setFileName(fileData.getFileName());
                        media.setFileType(Integer.valueOf(fileData.getFileType()));
                        media.setId(fileData.getFileId());
                        media.setMediaOwnerId(album.getAlbumOwnerId());
                        media.setSize(Long.valueOf(fileData.getSize()));
                        media.setSource(fileData.getSource());
                        media.setAlbumVersion("1.0");
                        media.setAlbumType(1);
                        media.setHashId(fileData.getHash());
                        media.setVideoThumbId(fileData.getVideoThumbId());
                        media.setThumbFileId(fileData.getThumbFileId());
                        media.setLcdFileId(fileData.getLcdFileId());
                        C13130b.m78985n(media, fileData.getExpandString());
                        m74820C(media);
                        m74821D(media);
                        m74860y(media, fileData.getOtype(), fileData.getOversion());
                    }
                }
            }
            incCursor = fileQueryResponseM80113o.getIncCursor();
            this.f57417l.m15209C(this.f57409d, this.f57415j, 0, "success");
        } while (!TextUtils.isEmpty(incCursor));
    }

    /* renamed from: c0 */
    public final String m74846c0() throws C9721b, IOException {
        m74825H("getStartCursorForSyncChange");
        Changes.GetStartCursor fields2 = this.f57410e.m83546c().getStartCursor().setFields2("startCursor");
        fields2.setAlbumClientHeader(this.f57409d);
        try {
            Cursor cursorExecute = fields2.execute();
            C1120a.m6677i("AlbumClientSyncHandler", "getStartCursorForSyncChange: " + cursorExecute.toString());
            this.f57417l.m15209C(this.f57409d, this.f57415j, 0, "success");
            return cursorExecute.getStartCursor();
        } catch (C4616s e10) {
            C1120a.m6676e("AlbumClientSyncHandler", "getStartCursorForSyncChange: " + e10.toString());
            if (e10.m28322f() != 503) {
                throw e10;
            }
            C1120a.m6677i("AlbumClientSyncHandler", "flow control");
            throw new C9721b(7, "flow control");
        }
    }

    /* renamed from: d0 */
    public final void m74847d0() throws C9721b, IOException {
        m74825H("getTempStartCursorForSyncAll");
        if (!TextUtils.isEmpty(this.f57412g.m74778i())) {
            C1120a.m6677i("AlbumClientSyncHandler", "already getTempStartCursorForSyncAll");
            return;
        }
        Changes.GetStartCursor fields2 = this.f57410e.m83546c().getStartCursor().setFields2("startCursor");
        fields2.setAlbumClientHeader(this.f57409d);
        try {
            Cursor cursorExecute = fields2.execute();
            C1120a.m6677i("AlbumClientSyncHandler", "getTempStartCursorForSyncAll: " + cursorExecute.toString());
            this.f57412g.m74792w(cursorExecute.getStartCursor());
            this.f57417l.m15209C(this.f57409d, this.f57415j, 0, "success");
        } catch (C4616s e10) {
            C1120a.m6676e("AlbumClientSyncHandler", "getTempStartCursorForSyncAll: " + e10.toString());
            if (e10.m28322f() != 503) {
                throw e10;
            }
            C1120a.m6677i("AlbumClientSyncHandler", "flow control");
            throw new C9721b(7, "flow control");
        }
    }

    /* renamed from: e0 */
    public boolean m74848e0() {
        return !TextUtils.isEmpty(this.f57412g.m74772b());
    }

    /* renamed from: f0 */
    public boolean m74849f0() {
        return this.f57407b;
    }

    /* renamed from: g0 */
    public final void m74850g0(Album album, ArrayList<Album> arrayList) {
        String id2 = album.getId();
        if (TextUtils.isEmpty(id2) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            if (id2.equals(it.next().getId())) {
                it.remove();
                return;
            }
        }
    }

    /* renamed from: h0 */
    public final void m74851h0() {
        C1120a.m6677i("AlbumClientSyncHandler", "restartSync");
        SystemClock.sleep(this.f57420o * 5000);
        Message messageObtainMessage = this.f57406a.obtainMessage();
        messageObtainMessage.what = 1000;
        messageObtainMessage.arg1 = this.f57414i;
        this.f57406a.sendMessage(messageObtainMessage);
    }

    /* renamed from: i0 */
    public final void m74852i0() throws C9721b {
        C1120a.m6677i("AlbumClientSyncHandler", "restartSyncAlbumClient");
        throw new C9721b(7, "disable expired");
    }

    /* renamed from: j0 */
    public final void m74853j0(ArrayList<Media> arrayList, Map<String, List<Media>> map, ArrayList<Media> arrayList2) throws C9721b {
        m74825H("splitDeleteList");
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            Media next = it.next();
            if (next != null) {
                if ("2.0".equals(next.getAlbumVersion())) {
                    arrayList2.add(next);
                } else {
                    List<Media> arrayList3 = map.get(next.getAlbumId());
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    arrayList3.add(next);
                    map.put(next.getAlbumId(), arrayList3);
                }
            }
        }
    }

    /* renamed from: k0 */
    public void m74854k0(boolean z10) {
        C1120a.m6677i("AlbumClientSyncHandler", "Deal stInvalid!");
        if (z10) {
            try {
                C13195l.m79272J().m79290C("com.huawei.hidisk.cloudAlbum", "AlbumClient", "");
                return;
            } catch (C13194k e10) {
                C1120a.m6676e("AlbumClientSyncHandler", "HmsException: " + e10.getMessage());
                return;
            } catch (C13199p e11) {
                C1120a.m6676e("AlbumClientSyncHandler", "hmsSTInvalidException: " + e11.getMessage());
            }
        }
        if (!C13452e.m80781L().m80842P0()) {
            C1120a.m6678w("AlbumClientSyncHandler", "not login, ignore auth fail.");
            return;
        }
        C1120a.m6677i("AlbumClientSyncHandler", "auth fail, sendBroadCast");
        C13108a.m78878b(this.f57416k).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: l0 */
    public void m74855l0(int i10) {
        C1120a.m6677i("AlbumClientSyncHandler", "startSync");
        this.f57407b = true;
        this.f57408c.set(false);
        this.f57414i = i10;
        Message messageObtainMessage = this.f57406a.obtainMessage();
        messageObtainMessage.what = 1000;
        messageObtainMessage.arg1 = i10;
        this.f57406a.sendMessage(messageObtainMessage);
    }

    /* renamed from: m0 */
    public final void m74856m0() throws Exception {
        C1120a.m6677i("AlbumClientSyncHandler", "syncCloudAlbum, traceId: " + this.f57409d);
        this.f57417l.m15209C(this.f57409d, "startsync", 0, String.valueOf(this.f57414i));
        if (this.f57410e == null || this.f57411f == null) {
            C1120a.m6676e("AlbumClientSyncHandler", "init drive null");
            throw new C9721b(3, "init drive null");
        }
        m74831N();
        m74818A();
        m74829L();
        C12515a.m75110o().m75175e(new C12474g(), true);
        C12515a.m75110o().m75175e(new ThumbnailPreloadTask(), true);
        m74858o0();
    }

    /* renamed from: n0 */
    public final void m74857n0(int i10) {
        C1120a.m6677i("AlbumClientSyncHandler", "syncComplete code: " + i10);
        this.f57409d = null;
        this.f57424s = null;
        this.f57407b = false;
        this.f57420o = 0;
        this.f57421p = false;
        this.f57422q.clear();
        this.f57423r.clear();
        this.f57413h.mo15028a();
    }

    /* renamed from: o0 */
    public final void m74858o0() throws Exception {
        m74825H("uploadSync");
        m74827J();
        m74826I();
        C0069g.m479y().m511r();
        C0069g.m479y().m486G();
    }

    /* renamed from: x */
    public final void m74859x(List<Change> list) throws C9721b {
        m74825H("analysisMediaChange");
        ArrayList<Media> arrayList = new ArrayList<>();
        ArrayList<Media> arrayList2 = new ArrayList<>();
        ArrayList<Media> arrayList3 = new ArrayList<>();
        for (Change change : list) {
            if (change != null) {
                if (change.getDeleted() != null && change.getDeleted().booleanValue()) {
                    Media media = new Media();
                    media.setId(change.getMediaId());
                    arrayList3.add(media);
                } else if (change.getMedia() != null) {
                    Media media2 = change.getMedia();
                    Album albumM77726A = this.f57418m.m77726A(media2.getAlbumId(), false);
                    if (albumM77726A == null) {
                        C1120a.m6678w("AlbumClientSyncHandler", "album not found");
                    } else {
                        Media mediaM77802O = this.f57419n.m77802O(media2.getId());
                        if (mediaM77802O == null) {
                            media2.setAlbumType(albumM77726A.getType().intValue());
                            media2.setAlbumVersion(albumM77726A.getAlbumVersion());
                            m74820C(media2);
                            m74819B(media2);
                            arrayList.add(media2);
                        } else if (!C12471d.m74794a(mediaM77802O.getOpType())) {
                            media2.setLocalId(mediaM77802O.getLocalId());
                            media2.setLocalThumbPath(mediaM77802O.getLocalThumbPath());
                            media2.setLocalBigThumbPath(mediaM77802O.getLocalBigThumbPath());
                            media2.setLocalRealPath(mediaM77802O.getLocalRealPath());
                            media2.setAlbumType(albumM77726A.getType().intValue());
                            media2.setAlbumVersion(albumM77726A.getAlbumVersion());
                            m74820C(media2);
                            m74819B(media2);
                            arrayList2.add(media2);
                        }
                    }
                }
            }
        }
        C1120a.m6677i("AlbumClientSyncHandler", "insertList size: " + arrayList.size() + ", updateList size: " + arrayList2.size() + ", deleteList size: " + arrayList3.size());
        this.f57419n.m77824l(arrayList);
        this.f57419n.m77825m(arrayList2);
        C1122c.m6703I(arrayList3);
        this.f57419n.m77823k(arrayList3);
    }

    /* renamed from: y */
    public final void m74860y(Media media, String str, long j10) throws SQLException {
        ArrayList<Media> arrayList = new ArrayList<>();
        arrayList.add(media);
        if ("2".equals(str)) {
            C1122c.m6703I(arrayList);
            this.f57419n.m77823k(arrayList);
        } else if ("0".equals(str) || "1".equals(str)) {
            Media mediaM77802O = this.f57419n.m77802O(media.getId());
            if (mediaM77802O == null) {
                this.f57419n.m77824l(arrayList);
            } else if (!C12471d.m74794a(mediaM77802O.getOpType())) {
                media.setLocalId(mediaM77802O.getLocalId());
                media.setLocalThumbPath(mediaM77802O.getLocalThumbPath());
                media.setLocalBigThumbPath(mediaM77802O.getLocalBigThumbPath());
                media.setLocalRealPath(mediaM77802O.getLocalRealPath());
                this.f57419n.m77825m(arrayList);
            }
        }
        this.f57418m.m77730E(j10, media.getAlbumId());
    }

    /* renamed from: z */
    public final void m74861z(Album album) {
        List<Permission> permissions = album.getPermissions();
        if (permissions == null || permissions.isEmpty()) {
            return;
        }
        for (Permission permission : permissions) {
            if (permission != null && TextUtils.isEmpty(permission.getDisplayName()) && !TextUtils.isEmpty(permission.getUserId())) {
                String userId = permission.getUserId();
                String str = this.f57423r.get(userId);
                if (TextUtils.isEmpty(str)) {
                    m74836S(userId);
                    String str2 = this.f57423r.get(userId);
                    if (!TextUtils.isEmpty(str2)) {
                        permission.setDisplayName(str2);
                    }
                } else {
                    permission.setDisplayName(str);
                }
            }
        }
    }
}
