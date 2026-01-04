package p547p7;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Attachment;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.hicloud.drive.cloudphoto.request.Losts;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.android.p069cg.manager.CloudAlbumReFoundManager;
import com.huawei.cloud.base.http.C4616s;
import fk.C9721b;
import hk.C10278a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1131l;
import p031b7.C1136q;
import p283fa.C9678a;
import p546p6.C12109v;
import p581qk.AbstractC12367d;
import p649t6.C12951k;
import p804ya.C13924a;
import p804ya.C13929f;

/* renamed from: p7.d */
/* loaded from: classes2.dex */
public class C12116d extends AbstractC12367d {

    /* renamed from: a */
    public final AtomicBoolean f56186a = new AtomicBoolean(false);

    /* renamed from: b */
    public final HashMap<String, Album> f56187b = new HashMap<>();

    /* renamed from: c */
    public final HashMap<String, Album> f56188c = new HashMap<>();

    /* renamed from: d */
    public C13924a f56189d;

    /* renamed from: e */
    public String f56190e;

    /* renamed from: f */
    public CommonOpsReport f56191f;

    /* renamed from: g */
    public C12951k f56192g;

    /* renamed from: c */
    public final boolean m72587c(Attachment attachment) {
        if (attachment == null) {
            C1120a.m6678w("AlbumLostRefundTask", "checkAttachmentLostStatus attachment is null");
            return true;
        }
        C1120a.m6677i("AlbumLostRefundTask", "checkAttachmentLostStatus ");
        Asset asset = attachment.getAsset();
        if (asset == null) {
            C1120a.m6678w("AlbumLostRefundTask", "checkAttachmentLostStatus assetThumbnail is null");
            return true;
        }
        if (asset.getStatus() == null) {
            C1120a.m6678w("AlbumLostRefundTask", "checkAttachmentLostStatus getStatus is null");
            return true;
        }
        if (asset.getStatus().intValue() != 2) {
            return false;
        }
        C1120a.m6678w("AlbumLostRefundTask", "checkAttachmentLostStatus is LOST_STATUS");
        return true;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        String string = "";
        try {
            try {
                try {
                    C1120a.m6677i("AlbumLostRefundTask", "start getLostMedias");
                    this.f56190e = C1122c.m6755Z0("04021");
                    this.f56191f = new CommonOpsReport(C0213f.m1377a());
                    this.f56189d = C9678a.m60442e().m60445d();
                    this.f56191f.m15209C(this.f56190e, "album_re_found_task_add", 0, "success");
                } catch (C9721b e10) {
                    this.f56191f.m15213G(this.f56190e, e10.m60658b(), "101_" + e10.m60662f() + ":1", e10.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("AlbumRefundTask CException: ");
                    sb2.append(e10);
                    string = sb2.toString();
                    C1120a.m6676e("AlbumLostRefundTask", string);
                }
            } catch (Exception e11) {
                this.f56191f.m15209C(this.f56190e, "refund", 2, e11.toString());
                string = "AlbumRefundTask Exception: " + e11;
                C1120a.m6676e("AlbumLostRefundTask", string);
            }
            if (this.f56189d != null) {
                this.f56192g = new C12951k();
                m72600q();
                ArrayList<C12117e> arrayListM77869o = this.f56192g.m77869o();
                this.f56191f.m15209C(this.f56190e, "refund", 0, "albumRefundBeans size = " + arrayListM77869o.size());
                if (arrayListM77869o.isEmpty()) {
                    C1120a.m6677i("AlbumLostRefundTask", "albumRefundBeans is empty");
                } else if (C12109v.m72524c().m72527d() == null) {
                    C1120a.m6676e("AlbumLostRefundTask", "lock is null");
                } else {
                    C1120a.m6677i("AlbumLostRefundTask", "albumRefundBeans size: " + arrayListM77869o.size());
                    m72604u(arrayListM77869o);
                }
                C1136q.m6956N(System.currentTimeMillis());
                C1136q.d.m7126C(null);
                this.f56192g.m77864j();
                return;
            }
            C1120a.m6676e("AlbumLostRefundTask", "cloudPhoto is null");
        } finally {
            C1120a.m6677i("AlbumLostRefundTask", "AlbumRefundTask finish");
            C12109v.m72524c().m72531h();
            CloudAlbumReFoundManager.m14515b().m14524j("");
        }
    }

    /* renamed from: d */
    public final void m72588d(ArrayList<C12117e> arrayList, Change change) throws Throwable {
        m72591g("checkLocalFileExist");
        Media media = change.getMedia();
        if (media == null) {
            C1120a.m6678w("AlbumLostRefundTask", "checkLocalFileExist media is null");
        } else if (media.getRecycled() != null && media.getRecycled().booleanValue()) {
            C1120a.m6678w("AlbumLostRefundTask", "checkLocalFileExist getRecycled is true");
        } else {
            m72594k(arrayList, media);
            m72595l(arrayList, media);
        }
    }

    /* renamed from: e */
    public final C12117e m72589e(Album album, Media media, int i10, boolean z10) {
        String strM6865i = C1124e.m6865i(C0213f.m1377a(), media, album, i10, z10);
        C1120a.m6675d("AlbumLostRefundTask", "isExternalRootPathExist originalPath = " + strM6865i + "; isInternal = " + z10);
        if (!C1122c.m6837u1(strM6865i)) {
            return null;
        }
        boolean zM72590f = m72590f(media, strM6865i);
        C1120a.m6677i("AlbumLostRefundTask", "originalPath file exists, isMatchSha256 = " + zM72590f);
        if (zM72590f) {
            return m72593j(album, media, strM6865i);
        }
        return null;
    }

    /* renamed from: f */
    public final boolean m72590f(Media media, String str) {
        C1120a.m6675d("AlbumLostRefundTask", "checkOriginalFileSha256 path = " + str);
        try {
            if (!TextUtils.isEmpty(media.getSha256())) {
                if (!media.getSha256().equalsIgnoreCase(C2798b.m16328i(C10278a.m63442h(str)))) {
                    return false;
                }
                C1120a.m6675d("AlbumLostRefundTask", "checkOriginalFileSha256 success");
                return true;
            }
            if (TextUtils.isEmpty(media.getHashId()) || !media.getHashId().equalsIgnoreCase(C1131l.m6920b(C10278a.m63442h(str)))) {
                return false;
            }
            C1120a.m6675d("AlbumLostRefundTask", "checkOriginalFileMD5 success");
            return true;
        } catch (C9721b e10) {
            C1120a.m6676e("AlbumLostRefundTask", "checkOriginalFileSha256. " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: g */
    public final void m72591g(String str) throws C9721b {
        if (this.f56186a.get()) {
            this.f56191f.m15209C(this.f56190e, str, 1, "Canceled");
            C1120a.m6676e("AlbumLostRefundTask", "cancel sync task cmd :" + str);
            throw new C9721b(1, "Canceled", "Canceled");
        }
    }

    /* renamed from: h */
    public final C12117e m72592h(Album album, Media media) {
        String strM6865i = C1124e.m6865i(C0213f.m1377a(), media, album, 1, true);
        String strM6865i2 = C1124e.m6865i(C0213f.m1377a(), media, album, 2, true);
        C1120a.m6675d("AlbumLostRefundTask", "isExternalRootPathExist lcdPath = " + strM6865i);
        C1120a.m6675d("AlbumLostRefundTask", "isExternalRootPathExist smallPath = " + strM6865i2);
        if (!C1122c.m6837u1(strM6865i) || !C1122c.m6837u1(strM6865i2)) {
            C1120a.m6678w("AlbumLostRefundTask", "checkThumbnailPathData file not exists ");
            return null;
        }
        C1120a.m6677i("AlbumLostRefundTask", "checkThumbnailPathData file exists ");
        C12117e c12117eM72593j = m72593j(album, media, null);
        c12117eM72593j.m72624t(strM6865i).m72629y(strM6865i2);
        return c12117eM72593j;
    }

    /* renamed from: j */
    public final C12117e m72593j(Album album, Media media, String str) {
        return new C12117e().m72626v(media.getId()).m72616l(album.getId()).m72620p(media.getHashId()).m72618n(media.getFileName()).m72625u(album.getLocalPath()).m72619o(media.getFileType()).m72627w(str);
    }

    /* renamed from: k */
    public final void m72594k(ArrayList<C12117e> arrayList, Media media) throws Throwable {
        if (media.getStatus().intValue() == 2) {
            Album albumM72597n = m72597n(media.getId());
            if (albumM72597n == null) {
                C1120a.m6678w("AlbumLostRefundTask", "dealLostContent album is null");
                return;
            }
            if (albumM72597n.getType().intValue() == 1) {
                C1120a.m6678w("AlbumLostRefundTask", "dealLostContent album is share");
                return;
            }
            List<Attachment> attachments = media.getAttachments();
            if (attachments == null || attachments.size() == 0) {
                C1120a.m6676e("AlbumLostRefundTask", "attachments is null");
                return;
            }
            Attachment attachmentM72599p = m72599p("content", attachments);
            if (m72587c(attachmentM72599p)) {
                String strM72598o = m72598o(attachmentM72599p);
                if (TextUtils.isEmpty(strM72598o)) {
                    C1120a.m6676e("AlbumLostRefundTask", "assetId is null");
                    return;
                }
                C12117e c12117eM72602s = m72602s(albumM72597n, media, 0);
                if (c12117eM72602s != null) {
                    c12117eM72602s.m72622r(false).m72617m(strM72598o).m72628x(media.getSha256());
                    arrayList.add(c12117eM72602s);
                    C1120a.m6677i("AlbumLostRefundTask", "getOriginalPathData file exists");
                    return;
                } else {
                    C12117e c12117eM72601r = m72601r(media, albumM72597n);
                    if (c12117eM72601r != null) {
                        c12117eM72601r.m72622r(false).m72617m(strM72598o).m72628x(media.getSha256());
                        arrayList.add(c12117eM72601r);
                        C1120a.m6677i("AlbumLostRefundTask", "getMediaStoreData file exists");
                        return;
                    }
                    return;
                }
            }
            C1120a.m6677i("AlbumLostRefundTask", "content has been fixed");
            if (C12109v.m72524c().m72527d() == null) {
                C1120a.m6676e("AlbumLostRefundTask", "lock is null");
                return;
            }
            try {
                Media media2 = new Media();
                media2.setStatus(Asset.FIX);
                Medias.Update updateAddHeader = this.f56189d.m83556m().update(media.getId(), media2).addHeader("x-hw-lock", (Object) C12109v.m72524c().m72527d().getSessionId());
                updateAddHeader.setAlbumClientHeader(this.f56190e);
                updateAddHeader.execute();
                C1120a.m6677i("AlbumLostRefundTask", "media has been fixed");
            } catch (IOException e10) {
                C1120a.m6676e("AlbumLostRefundTask", "update media status IOException: " + e10);
            } catch (Exception e11) {
                C1120a.m6676e("AlbumLostRefundTask", "update media status Exception: " + e11);
            }
        }
    }

    /* renamed from: l */
    public final void m72595l(ArrayList<C12117e> arrayList, Media media) {
        boolean z10;
        C12117e c12117eM72601r;
        C12117e c12117eM72602s;
        List<Attachment> attachments = media.getAttachments();
        if (attachments == null || attachments.size() == 0) {
            C1120a.m6676e("AlbumLostRefundTask", "attachments is null");
            return;
        }
        Attachment attachmentM72599p = m72599p("thumbnail", attachments);
        Attachment attachmentM72599p2 = m72599p("smallthumbnail", attachments);
        Attachment attachmentM72599p3 = m72599p("largethumbnail", attachments);
        if (!m72587c(attachmentM72599p)) {
            C1120a.m6677i("AlbumLostRefundTask", "thumbnail not lost");
            return;
        }
        if (attachmentM72599p == null && !m72587c(attachmentM72599p2) && !m72587c(attachmentM72599p3)) {
            C1120a.m6677i("AlbumLostRefundTask", "largeThumbnail and smallThumbnail not lost");
            return;
        }
        Album albumM72597n = m72597n(media.getId());
        if (albumM72597n == null) {
            C1120a.m6678w("AlbumLostRefundTask", "dealLostThumbnail album is null");
            return;
        }
        if (albumM72597n.getType().intValue() == 1) {
            C1120a.m6678w("AlbumLostRefundTask", "dealLostThumbnail album is share");
            return;
        }
        C12117e c12117eM72603t = m72603t(albumM72597n, media);
        if (c12117eM72603t != null) {
            c12117eM72603t.m72622r(true).m72617m(m72598o(attachmentM72599p));
            arrayList.add(c12117eM72603t);
            C1120a.m6677i("AlbumLostRefundTask", "thumbnail exists on the local");
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && (c12117eM72602s = m72602s(albumM72597n, media, 0)) != null) {
            c12117eM72602s.m72622r(true).m72623s(true).m72628x(media.getSha256()).m72617m(m72598o(attachmentM72599p));
            arrayList.add(c12117eM72602s);
            C1120a.m6677i("AlbumLostRefundTask", "thumbnail use local original path");
        } else {
            if (z10 || (c12117eM72601r = m72601r(media, albumM72597n)) == null) {
                return;
            }
            c12117eM72601r.m72622r(true).m72623s(true).m72628x(media.getSha256()).m72617m(m72598o(attachmentM72599p));
            arrayList.add(c12117eM72601r);
            C1120a.m6677i("AlbumLostRefundTask", "thumbnail use media store original path");
        }
    }

    /* renamed from: m */
    public void m72596m() {
        C1120a.m6676e("AlbumLostRefundTask", "endRefund");
        this.f56186a.set(true);
        cancel();
    }

    /* renamed from: n */
    public final Album m72597n(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6678w("AlbumLostRefundTask", "getAlbum mediaId is null");
            return null;
        }
        Album album = this.f56187b.get(str);
        if (album != null) {
            C1120a.m6677i("AlbumLostRefundTask", "getAlbum albumCache exists");
            return album;
        }
        try {
            Medias.Get fields2 = this.f56189d.m83556m().get(str).setFields2("albumId");
            fields2.setAlbumClientHeader(this.f56190e);
            Media mediaExecute = fields2.execute();
            if (mediaExecute != null && !TextUtils.isEmpty(mediaExecute.getAlbumId())) {
                String albumId = mediaExecute.getAlbumId();
                C1120a.m6675d("AlbumLostRefundTask", "getAlbum albumId = " + albumId);
                Album album2 = this.f56188c.get(albumId);
                if (album2 != null) {
                    C1120a.m6677i("AlbumLostRefundTask", "getAlbum doubleAlbumCache exists");
                    return album2;
                }
                Albums.Get get = this.f56189d.m83547d().get(albumId, "id,albumName,localPath,type");
                get.setAlbumClientHeader(this.f56190e);
                Album albumExecute = get.execute();
                if (albumExecute != null) {
                    C1120a.m6677i("AlbumLostRefundTask", "getAlbum success");
                    this.f56187b.put(str, albumExecute);
                    this.f56188c.put(albumId, albumExecute);
                    return albumExecute;
                }
            }
        } catch (IOException e10) {
            C1120a.m6676e("AlbumLostRefundTask", "getAlbum Exception: " + e10.toString());
        }
        return null;
    }

    /* renamed from: o */
    public final String m72598o(Attachment attachment) {
        if (attachment == null) {
            C1120a.m6678w("AlbumLostRefundTask", "getAssetId attachment is null");
            return "";
        }
        Asset asset = attachment.getAsset();
        return asset != null ? asset.getId() : "";
    }

    /* renamed from: p */
    public final Attachment m72599p(String str, List<Attachment> list) {
        for (Attachment attachment : list) {
            if (attachment.getUsage().equalsIgnoreCase(str)) {
                return attachment;
            }
        }
        return null;
    }

    /* renamed from: q */
    public final void m72600q() throws Throwable {
        String strM7146j = C1136q.d.m7146j();
        if ("COMPLETE".equals(strM7146j)) {
            C1120a.m6677i("AlbumLostRefundTask", "already getLostMedias");
            return;
        }
        Losts.List fields2 = this.f56189d.m83555l().list().setFields2("nextCursor,changes(changeType,media(albumId,recycled,status,attachments(usage,asset(id,status)),fileName,fileType,id,hashId,sha256))");
        fields2.setAlbumClientHeader(this.f56190e);
        do {
            try {
                m72591g("getLostMedias");
                ArrayList<C12117e> arrayList = new ArrayList<>();
                ChangeList changeListExecute = fields2.setCursor(strM7146j).execute();
                List<Change> changes = changeListExecute.getChanges();
                if (changes != null) {
                    C1120a.m6677i("AlbumLostRefundTask", "getLostMedias changes size: " + changes.size());
                    for (Change change : changes) {
                        if (change != null) {
                            m72588d(arrayList, change);
                        }
                    }
                }
                this.f56191f.m15209C(this.f56190e, "losts.list", 0, "size =" + arrayList.size());
                this.f56192g.m77863i(arrayList);
                strM7146j = changeListExecute.getNextCursor();
                C1120a.m6677i("AlbumLostRefundTask", "getLostMedias nextCursor " + strM7146j);
                if (TextUtils.isEmpty(strM7146j)) {
                    this.f56191f.m15209C(this.f56190e, "losts.list", 0, "COMPLETE");
                    C1136q.d.m7126C("COMPLETE");
                } else {
                    C1136q.d.m7126C(strM7146j);
                }
            } catch (IOException e10) {
                C1120a.m6676e("AlbumLostRefundTask", "getLostMedias runTask IOException: " + e10);
                if (!(e10 instanceof C4616s)) {
                    throw new C9721b(2, C1122c.m6845x0(e10), e10.toString(), "losts.list");
                }
                C4616s c4616s = (C4616s) e10;
                int iM6802l0 = C1122c.m6802l0(c4616s);
                if ((c4616s.m28322f() == 410 && iM6802l0 == 4100) || (c4616s.m28322f() == 400 && iM6802l0 == 4002)) {
                    C1120a.m6678w("AlbumLostRefundTask", "getLostMedias cursor invalid, clear db");
                    C1136q.m6956N(System.currentTimeMillis());
                    C1136q.d.m7126C(null);
                    this.f56192g.m77864j();
                }
                throw new C9721b(2, c4616s.m28322f(), e10.toString(), "losts.list", String.valueOf(iM6802l0));
            }
        } while (!TextUtils.isEmpty(strM7146j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3 A[PHI: r0
  0x00a3: PHI (r0v8 android.database.Cursor) = (r0v7 android.database.Cursor), (r0v10 android.database.Cursor) binds: [B:30:0x00c3, B:23:0x00a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p547p7.C12117e m72601r(com.huawei.android.hicloud.drive.cloudphoto.model.Media r12, com.huawei.android.hicloud.drive.cloudphoto.model.Album r13) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = "getMediaStoreData"
            java.lang.String r1 = "AlbumLostRefundTask"
            p031b7.C1120a.m6677i(r1, r0)
            java.lang.String r0 = r12.getFileName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r0 == 0) goto L18
            java.lang.String r11 = "fileName is null"
            p031b7.C1120a.m6678w(r1, r11)
            return r2
        L18:
            java.lang.String r0 = "external"
            android.net.Uri r4 = android.provider.MediaStore.Files.getContentUri(r0)
            java.lang.String r0 = "_id"
            java.lang.String r9 = "_display_name"
            java.lang.String r10 = "_data"
            java.lang.String[] r5 = new java.lang.String[]{r0, r9, r10}
            java.lang.String r6 = "_display_name = ?"
            java.lang.String r0 = r12.getFileName()
            java.lang.String[] r7 = new java.lang.String[]{r0}
            android.content.Context r0 = p015ak.C0213f.m1377a()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            android.content.ContentResolver r3 = r0.getContentResolver()     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            if (r0 == 0) goto L9c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r3.<init>()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.lang.String r4 = "getMediaStoreData cursor count = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            int r4 = r0.getCount()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r3.append(r4)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            p031b7.C1120a.m6677i(r1, r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
        L59:
            boolean r3 = r0.moveToNext()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            if (r3 == 0) goto La1
            int r3 = r0.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            int r4 = r0.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.lang.String r4 = r0.getString(r4)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            boolean r5 = r11.m72590f(r12, r4)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            if (r5 == 0) goto L87
            java.lang.String r3 = "getMediaStoreData isMatch is true "
            p031b7.C1120a.m6677i(r1, r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            p7.e r11 = r11.m72593j(r13, r12, r4)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r0.close()
            return r11
        L82:
            r11 = move-exception
            r2 = r0
            goto Lc7
        L85:
            r11 = move-exception
            goto Lab
        L87:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r4.<init>()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.lang.String r5 = "fileName = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            r4.append(r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            p031b7.C1120a.m6675d(r1, r3)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
            goto L59
        L9c:
            java.lang.String r11 = "getMediaStoreData cursor is null"
            p031b7.C1120a.m6678w(r1, r11)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L85
        La1:
            if (r0 == 0) goto Lc6
        La3:
            r0.close()
            goto Lc6
        La7:
            r11 = move-exception
            goto Lc7
        La9:
            r11 = move-exception
            r0 = r2
        Lab:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r12.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r13 = "getMediaStoreData error. "
            r12.append(r13)     // Catch: java.lang.Throwable -> L82
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> L82
            r12.append(r11)     // Catch: java.lang.Throwable -> L82
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> L82
            p031b7.C1120a.m6676e(r1, r11)     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto Lc6
            goto La3
        Lc6:
            return r2
        Lc7:
            if (r2 == 0) goto Lcc
            r2.close()
        Lcc:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p547p7.C12116d.m72601r(com.huawei.android.hicloud.drive.cloudphoto.model.Media, com.huawei.android.hicloud.drive.cloudphoto.model.Album):p7.e");
    }

    /* renamed from: s */
    public final C12117e m72602s(Album album, Media media, int i10) {
        C12117e c12117eM72589e = m72589e(album, media, i10, true);
        if (c12117eM72589e != null) {
            return c12117eM72589e;
        }
        C12117e c12117eM72589e2 = m72589e(album, media, i10, false);
        if (c12117eM72589e2 != null) {
            return c12117eM72589e2;
        }
        return null;
    }

    /* renamed from: t */
    public final C12117e m72603t(Album album, Media media) {
        C12117e c12117eM72592h = m72592h(album, media);
        if (c12117eM72592h != null) {
            return c12117eM72592h;
        }
        return null;
    }

    /* renamed from: u */
    public final void m72604u(ArrayList<C12117e> arrayList) throws C9721b, SQLException {
        Iterator<C12117e> it = arrayList.iterator();
        while (it.hasNext()) {
            C12117e next = it.next();
            m72591g("refundUpload");
            try {
                if (next.m72614j()) {
                    new C13929f(this.f56190e, next.m72610f(), next.m72605a(), next.m72612h(), next.m72607c(), next.m72613i(), next.m72609e(), next.m72611g(), next.m72615k(), next.m72606b().intValue()).m83662x();
                } else {
                    new C13929f(this.f56190e, next.m72610f(), next.m72605a(), next.m72612h(), next.m72607c(), next.m72611g()).m83662x();
                }
                this.f56192g.m77865k(next.m72608d());
            } catch (C9721b e10) {
                C1120a.m6676e("AlbumLostRefundTask", "CloudPhotoRefundUploader CException: " + e10);
                if ((e10.m60663g() == 403 && "31084037".equals(e10.m60660d())) || ((e10.m60663g() == 409 && "31004091".equals(e10.m60660d())) || ((e10.m60663g() == 409 && "31094091".equals(e10.m60660d())) || 1001 == e10.m60659c()))) {
                    C1120a.m6676e("AlbumLostRefundTask", "lock expire or cancel");
                    throw e10;
                }
                this.f56192g.m77865k(next.m72608d());
            } catch (Exception e11) {
                C1120a.m6676e("AlbumLostRefundTask", "CloudPhotoRefundUploader Exception: " + e11);
                this.f56192g.m77865k(next.m72608d());
            }
        }
    }
}
