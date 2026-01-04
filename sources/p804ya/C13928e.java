package p804ya;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.connect.progress.Retry;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.asset.AssetUploaderProgressListener;
import com.huawei.android.hicloud.drive.asset.C2797a;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Attachment;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cipher;
import com.huawei.android.hicloud.drive.cloudphoto.model.CompressInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaAssetAttribute;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.model.RevisionCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.SliceObject;
import com.huawei.android.hicloud.drive.cloudphoto.request.Assets;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p260ek.C9499a;
import p283fa.C9678a;
import p332ha.C10130a;
import p332ha.C10131b;
import p332ha.C10134e;
import p429kk.C11058a;
import p429kk.C11060c;
import p546p6.C12088a;
import p546p6.C12106s;
import p547p7.C12113a;
import p547p7.C12115c;
import p649t6.C12946f;
import p709vj.C13452e;
import p712vm.C13468a;
import p733w9.C13576a;
import p746wn.C13622a;
import p783xp.C13843a;

/* renamed from: ya.e */
/* loaded from: classes3.dex */
public class C13928e implements AssetMetadataTransport {

    /* renamed from: A */
    public boolean f62424A;

    /* renamed from: B */
    public boolean f62425B;

    /* renamed from: a */
    public File f62427a;

    /* renamed from: b */
    public File f62428b;

    /* renamed from: c */
    public File f62429c;

    /* renamed from: d */
    public Media f62430d;

    /* renamed from: e */
    public C2797a f62431e;

    /* renamed from: f */
    public C2797a f62432f;

    /* renamed from: g */
    public CloudPhotoMediaUploaderProgressListener f62433g;

    /* renamed from: j */
    public HashMap<String, CompressInfo> f62436j;

    /* renamed from: k */
    public String f62437k;

    /* renamed from: l */
    public C2798b.a f62438l;

    /* renamed from: m */
    public String f62439m;

    /* renamed from: n */
    public String f62440n;

    /* renamed from: o */
    public String f62441o;

    /* renamed from: p */
    public String f62442p;

    /* renamed from: q */
    public String f62443q;

    /* renamed from: r */
    public String f62444r;

    /* renamed from: s */
    public String f62445s;

    /* renamed from: t */
    public String f62446t;

    /* renamed from: v */
    public String f62448v;

    /* renamed from: w */
    public boolean f62449w;

    /* renamed from: x */
    public boolean f62450x;

    /* renamed from: y */
    public int f62451y;

    /* renamed from: z */
    public String f62452z;

    /* renamed from: C */
    public boolean f62426C = false;

    /* renamed from: h */
    public C13924a f62434h = C9678a.m60442e().m60445d();

    /* renamed from: u */
    public Context f62447u = C0213f.m1377a();

    /* renamed from: i */
    public SQLiteDatabase f62435i = C10130a.m63054c();

    /* renamed from: ya.e$a */
    public class a implements AssetUploaderProgressListener {
        public a() {
        }

        @Override // com.huawei.android.hicloud.drive.asset.AssetUploaderProgressListener
        /* renamed from: a */
        public void mo16255a(C2797a c2797a) {
            if (C13928e.this.f62433g != null) {
                C13928e.this.f62433g.progressChanged(C13928e.this);
            }
        }
    }

    /* renamed from: ya.e$b */
    public class b implements AssetUploaderProgressListener {
        public b() {
        }

        @Override // com.huawei.android.hicloud.drive.asset.AssetUploaderProgressListener
        /* renamed from: a */
        public void mo16255a(C2797a c2797a) {
            if (C13928e.this.f62433g != null) {
                C13928e.this.f62433g.progressChanged(C13928e.this);
            }
        }
    }

    /* renamed from: ya.e$c */
    public class c implements AssetUploaderProgressListener {
        public c() {
        }

        @Override // com.huawei.android.hicloud.drive.asset.AssetUploaderProgressListener
        /* renamed from: a */
        public void mo16255a(C2797a c2797a) {
            if (C13928e.this.f62433g != null) {
                C13928e.this.f62433g.progressChanged(C13928e.this);
            }
        }
    }

    /* renamed from: ya.e$d */
    public class d implements AssetUploaderProgressListener {
        public d() {
        }

        @Override // com.huawei.android.hicloud.drive.asset.AssetUploaderProgressListener
        /* renamed from: a */
        public void mo16255a(C2797a c2797a) {
            if (C13928e.this.f62433g != null) {
                C13928e.this.f62433g.progressChanged(C13928e.this);
            }
        }
    }

    public C13928e(String str, Media media, File file, File file2, File file3, HashMap<String, CompressInfo> map) {
        this.f62430d = media;
        this.f62427a = file;
        this.f62428b = file2;
        this.f62429c = file3;
        this.f62446t = str;
        this.f62436j = map;
    }

    /* renamed from: C */
    private boolean m83596C(C9721b c9721b, Retry retry) {
        return 1001 == c9721b.m60659c() || m83605B(c9721b) || "31084039".equals(c9721b.m60660d()) || "31004908".equals(c9721b.m60660d()) || "31084913".equals(c9721b.m60660d()) || m83604A() || !retry.m16233b(false) || 401 == c9721b.m60663g() || c9721b.m60659c() == 6005;
    }

    /* renamed from: D */
    private boolean m83597D() {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0) || TextUtils.isEmpty(this.f62448v)) {
            return true;
        }
        return strM80971t0.equals(this.f62448v);
    }

    /* renamed from: b */
    private void m83599b() throws C9721b {
        this.f62437k = C2798b.m16329j(this.f62427a);
        this.f62438l = C2798b.m16331l(this.f62427a);
        this.f62439m = C2798b.m16337r(this.f62437k);
        String str = this.f62430d.getAlbumId() + "_" + this.f62430d.getFileName() + "_" + this.f62438l.m16340a() + "_1";
        this.f62445s = str;
        this.f62440n = str;
        if (m83636x()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f62428b);
            arrayList.add(this.f62429c);
            this.f62441o = C2798b.m16330k(arrayList);
            this.f62442p = C2798b.m16336q(arrayList);
            this.f62443q = C2798b.m16337r(this.f62441o);
            this.f62444r = this.f62442p + "_" + this.f62445s;
        }
    }

    /* renamed from: g */
    private void m83600g() throws C9721b {
        if (m83604A()) {
            throw new C9721b(1001, "user cancel.");
        }
        CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener = this.f62433g;
        if (cloudPhotoMediaUploaderProgressListener != null) {
            cloudPhotoMediaUploaderProgressListener.progressChanged(this);
        }
        if (m83604A()) {
            throw new C9721b(1001, "user cancel.");
        }
    }

    /* renamed from: h */
    private void m83601h() throws C9721b, SQLException {
        C10131b.b bVar = new C10131b.b();
        bVar.m63099P(this.f62440n).m63090G().m63055a(this.f62435i);
        bVar.m63099P(this.f62444r).m63090G().m63055a(this.f62435i);
        new C10134e.b(this.f62440n).m63171s().m63147a(this.f62435i);
        new C10134e.b(this.f62444r).m63171s().m63147a(this.f62435i);
    }

    /* renamed from: q */
    private Attachment m83602q(String str, List<Attachment> list) {
        for (Attachment attachment : list) {
            if (attachment.getUsage().equals(str)) {
                return attachment;
            }
        }
        return null;
    }

    /* renamed from: r */
    private String m83603r() throws C9721b {
        Lock lockM72269d = this.f62424A ? C12088a.m72266c().m72269d(true) : C12106s.m72509c().m72512d(true);
        if (lockM72269d != null) {
            return lockM72269d.getSessionId();
        }
        throw new C9721b(4311, "lockToken has released");
    }

    /* renamed from: A */
    public boolean m83604A() {
        return this.f62449w;
    }

    /* renamed from: B */
    public final boolean m83605B(C9721b c9721b) {
        return c9721b != null && c9721b.m60659c() == 4311 && c9721b.m60663g() == 1011;
    }

    /* renamed from: E */
    public final boolean m83606E(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3);
    }

    /* renamed from: F */
    public final Media m83607F(HashMap<String, String> map) throws Throwable {
        String str;
        Media mediaM83638z;
        StringBuilder sb2;
        C13576a c13576aM81565a = C13576a.m81565a();
        String str2 = ",traceId:";
        C11060c c11060cM66626a = C11058a.m66626a(this.f62446t, "upload", C13452e.m80781L().m80971t0());
        try {
            if (c13576aM81565a.m81566b(this.f62444r)) {
                mediaM83638z = m83638z(c11060cM66626a, map);
                map.put(C5927g2.QUIC, this.f62450x ? "1" : "0");
                map.put("uploadEndTime", String.valueOf(System.currentTimeMillis()));
                c13576aM81565a.m81568d(this.f62444r);
                CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener = this.f62433g;
                if (cloudPhotoMediaUploaderProgressListener != null) {
                    cloudPhotoMediaUploaderProgressListener.progressChanged(this);
                }
                if (this.f62449w) {
                    c11060cM66626a.m66665u("001_" + this.f62451y + ":1");
                    c11060cM66626a.m66635A(this.f62452z);
                }
                String strM66647c = c11060cM66626a.m66647c();
                C1120a.m6677i("CloudPhotoMediaUploader", "upload end code: " + strM66647c);
                if (!TextUtils.isEmpty(strM66647c) && !this.f62424A && strM66647c.contains(String.valueOf(4311)) && !C12106s.m72509c().m72515g()) {
                    c11060cM66626a.m66664t("upload_cancel");
                }
                sb2 = new StringBuilder();
            } else {
                str = str2;
                try {
                    StringBuilder sb3 = new StringBuilder();
                    str2 = str;
                    sb3.append("file already in upload, wait for result.");
                    sb3.append(this.f62444r);
                    C1120a.m6678w("CloudPhotoMediaUploader", sb3.toString());
                    c13576aM81565a.m81570f(this.f62444r);
                    mediaM83638z = m83638z(c11060cM66626a, map);
                    map.put(C5927g2.QUIC, this.f62450x ? "1" : "0");
                    map.put("uploadEndTime", String.valueOf(System.currentTimeMillis()));
                    c13576aM81565a.m81568d(this.f62444r);
                    CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener2 = this.f62433g;
                    if (cloudPhotoMediaUploaderProgressListener2 != null) {
                        cloudPhotoMediaUploaderProgressListener2.progressChanged(this);
                    }
                    if (this.f62449w) {
                        c11060cM66626a.m66665u("001_" + this.f62451y + ":1");
                        c11060cM66626a.m66635A(this.f62452z);
                    }
                    String strM66647c2 = c11060cM66626a.m66647c();
                    C1120a.m6677i("CloudPhotoMediaUploader", "upload end code: " + strM66647c2);
                    if (!TextUtils.isEmpty(strM66647c2) && !this.f62424A && strM66647c2.contains(String.valueOf(4311)) && !C12106s.m72509c().m72515g()) {
                        c11060cM66626a.m66664t("upload_cancel");
                    }
                    sb2 = new StringBuilder();
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    map.put(C5927g2.QUIC, this.f62450x ? "1" : "0");
                    map.put("uploadEndTime", String.valueOf(System.currentTimeMillis()));
                    c13576aM81565a.m81568d(this.f62444r);
                    CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener3 = this.f62433g;
                    if (cloudPhotoMediaUploaderProgressListener3 != null) {
                        cloudPhotoMediaUploaderProgressListener3.progressChanged(this);
                    }
                    if (this.f62449w) {
                        c11060cM66626a.m66665u("001_" + this.f62451y + ":1");
                        c11060cM66626a.m66635A(this.f62452z);
                    }
                    String strM66647c3 = c11060cM66626a.m66647c();
                    C1120a.m6677i("CloudPhotoMediaUploader", "upload end code: " + strM66647c3);
                    if (!TextUtils.isEmpty(strM66647c3) && !this.f62424A && strM66647c3.contains(String.valueOf(4311)) && !C12106s.m72509c().m72515g()) {
                        c11060cM66626a.m66664t("upload_cancel");
                    }
                    C1120a.m6677i("CloudPhotoMediaUploader", "upload rate,single file :,uploadStartTime:" + map.get("uploadStartTime") + ",uploadEndTime:" + map.get("uploadEndTime") + str + this.f62446t);
                    C13622a.m81969o(this.f62447u, c11060cM66626a, map);
                    throw th3;
                }
            }
            sb2.append("upload rate,single file :,uploadStartTime:");
            sb2.append(map.get("uploadStartTime"));
            sb2.append(",uploadEndTime:");
            sb2.append(map.get("uploadEndTime"));
            sb2.append(str2);
            sb2.append(this.f62446t);
            C1120a.m6677i("CloudPhotoMediaUploader", sb2.toString());
            C13622a.m81969o(this.f62447u, c11060cM66626a, map);
            return mediaM83638z;
        } catch (Throwable th4) {
            th = th4;
            str = str2;
        }
    }

    /* renamed from: G */
    public final void m83608G(Media media) {
        Asset asset;
        Asset asset2;
        try {
            C11060c c11060cM66626a = C11058a.m66626a(this.f62446t, "reportStartUpload", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0:1");
            c11060cM66626a.m66635A("OK");
            c11060cM66626a.m66638D("file = " + this.f62427a.getName() + " id = " + media.getId());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("id=");
            sb2.append(media.getId());
            StringBuilder sb3 = new StringBuilder(sb2.toString());
            Attachment attachmentM83602q = m83602q("content", media.getAttachments());
            Attachment attachmentM83602q2 = m83602q("thumbnail", media.getAttachments());
            if (attachmentM83602q != null && (asset2 = attachmentM83602q.getAsset()) != null) {
                sb3.append(",content:assetId=");
                sb3.append(asset2.getId());
                sb3.append(",versionId=");
                sb3.append(asset2.getVersionId());
                Resource resource = asset2.getResource();
                if (resource != null) {
                    sb3.append(",resourceId=");
                    sb3.append(resource.getId());
                    List<SliceObject> objects = resource.getObjects();
                    if (objects != null && objects.size() != 0) {
                        SliceObject sliceObject = objects.get(0);
                        sb3.append(",objectId=");
                        sb3.append(sliceObject.getId());
                    }
                }
            }
            if (attachmentM83602q2 != null && (asset = attachmentM83602q2.getAsset()) != null) {
                sb3.append(",thumbnail:assetId=");
                sb3.append(asset.getId());
                sb3.append(",versionId=");
                sb3.append(asset.getVersionId());
                Resource resource2 = asset.getResource();
                if (resource2 != null) {
                    sb3.append(",resourceId=");
                    sb3.append(resource2.getId());
                    List<SliceObject> objects2 = resource2.getObjects();
                    if (objects2 != null && objects2.size() != 0) {
                        SliceObject sliceObject2 = objects2.get(0);
                        sb3.append(",objectId=");
                        sb3.append(sliceObject2.getId());
                    }
                }
            }
            HashMap map = new HashMap();
            map.put("fileUnique", sb3.toString());
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "reportStartUpload error:" + e10);
        }
    }

    /* renamed from: H */
    public final void m83609H(Media media) throws C9721b, SQLException {
        Attachment attachmentM83602q = m83602q("content", media.getAttachments());
        C10131b.b bVar = new C10131b.b();
        bVar.m63099P(this.f62440n).m63101R(attachmentM83602q.getAsset().getResource().getSha256()).m63102S(attachmentM83602q.getAsset().getResource().getLength().longValue()).m63104U(attachmentM83602q.getAsset().getVersionId()).m63103T(attachmentM83602q.getAsset().getResource().getSliceSize().longValue()).m63096M(attachmentM83602q.getAsset().getId()).m63100Q(media.getId()).m63097N(media.getUploadType()).m63098O(String.valueOf(this.f62450x)).m63090G().m63057c(this.f62435i);
        Attachment attachmentM83602q2 = m83602q("thumbnail", media.getAttachments());
        if (attachmentM83602q2 == null || !m83636x()) {
            return;
        }
        bVar.m63099P(this.f62444r).m63101R(attachmentM83602q2.getAsset().getResource().getSha256()).m63102S(attachmentM83602q2.getAsset().getResource().getLength().longValue()).m63104U(attachmentM83602q2.getAsset().getVersionId()).m63103T(attachmentM83602q2.getAsset().getResource().getSliceSize().longValue()).m63096M(attachmentM83602q2.getAsset().getId()).m63100Q(media.getId()).m63097N(media.getUploadType()).m63098O(String.valueOf(this.f62450x)).m63090G().m63057c(this.f62435i);
    }

    /* renamed from: I */
    public void m83610I(boolean z10) {
        this.f62424A = z10;
    }

    /* renamed from: J */
    public final void m83611J(C11060c c11060c, String str) {
        if ("31084039".equals(str) || "31084932".equals(str)) {
            if (this.f62430d.getAlbumId().startsWith("default-album-")) {
                c11060c.m66664t("General.Media.create.metadata");
            } else {
                c11060c.m66664t("Share.Media.create.metadata");
            }
        }
    }

    /* renamed from: K */
    public void m83612K(boolean z10) {
        this.f62425B = z10;
    }

    /* renamed from: L */
    public void m83613L(String str) {
        this.f62448v = str;
    }

    /* renamed from: M */
    public void m83614M(CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener) {
        this.f62433g = cloudPhotoMediaUploaderProgressListener;
    }

    /* renamed from: N */
    public Media m83615N(HashMap<String, String> map) throws Throwable {
        C1120a.m6677i("CloudPhotoMediaUploader", "upload begin:" + C1122c.m6818p0(this.f62427a.getName()) + ", size:" + this.f62427a.length());
        m83600g();
        m83599b();
        if (!this.f62425B || C12115c.m72560h().m72569j()) {
            C1120a.m6678w("CloudPhotoMediaUploader", "not general or not hide");
            return m83607F(map);
        }
        C12946f c12946f = new C12946f();
        ArrayList<C12113a> arrayListM77785r = c12946f.m77785r(this.f62430d.getAlbumId(), this.f62430d.getFileName(), this.f62438l.m16341b(), this.f62438l.m16340a());
        if (arrayListM77785r.isEmpty()) {
            C1120a.m6678w("CloudPhotoMediaUploader", "hide bean is empty");
            return m83607F(map);
        }
        String strM72551d = arrayListM77785r.get(0).m72551d();
        Media mediaM83631s = m83631s(strM72551d);
        if (mediaM83631s == null) {
            C1120a.m6678w("CloudPhotoMediaUploader", "cloudMedia not exist");
            c12946f.m77779l(strM72551d);
            return m83607F(map);
        }
        if (mediaM83631s.getRecycled() == null || mediaM83631s.getRecycled().booleanValue()) {
            C1120a.m6678w("CloudPhotoMediaUploader", "cloudMedia recycled");
            return m83607F(map);
        }
        if (TextUtils.isEmpty(mediaM83631s.getAlbumId()) || !mediaM83631s.getAlbumId().equals(this.f62430d.getAlbumId())) {
            C1120a.m6678w("CloudPhotoMediaUploader", "album changed");
            return m83607F(map);
        }
        if (TextUtils.isEmpty(mediaM83631s.getFileName()) || !mediaM83631s.getFileName().equals(this.f62430d.getFileName())) {
            C1120a.m6678w("CloudPhotoMediaUploader", "fileName changed");
            return m83607F(map);
        }
        String strM83630p = m83630p(mediaM83631s);
        if (!TextUtils.isEmpty(strM83630p)) {
            return m83623i(map, strM72551d, c12946f, strM83630p, mediaM83631s);
        }
        C1120a.m6676e("CloudPhotoMediaUploader", "assetId is null");
        throw new C9721b(4312, "medias get assetId is null", "getAssetId");
    }

    /* renamed from: O */
    public final void m83616O(C11060c c11060c, Asset asset, String str) throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoMediaUploader", "uploadContent begin");
        this.f62432f.m16307d0(this.f62427a);
        this.f62432f.m16305b0(str);
        this.f62432f.m16303Z(asset);
        this.f62432f.m16309f0(c11060c);
        this.f62432f.m16306c0(true);
        this.f62432f.m16314l0(false);
    }

    /* renamed from: P */
    public final void m83617P(C11060c c11060c, boolean z10) throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoMediaUploader", "uploadContent begin");
        Attachment attachmentM83602q = m83602q("content", this.f62430d.getAttachments());
        CompressInfo compressInfo = this.f62436j.get("content");
        C1120a.m6675d("CloudPhotoMediaUploader", "uploadContent compressInfo: " + compressInfo);
        if (compressInfo == null) {
            this.f62432f.m16307d0(this.f62427a);
        } else {
            this.f62432f.m16307d0(compressInfo.getCompressFile());
        }
        this.f62432f.m16305b0(this.f62430d.getId());
        this.f62432f.m16303Z(attachmentM83602q.getAsset());
        this.f62432f.m16309f0(c11060c);
        this.f62432f.m16311h0(this.f62450x);
        this.f62432f.m16306c0(true);
        this.f62432f.m16314l0(z10);
    }

    /* renamed from: Q */
    public final void m83618Q(C11060c c11060c, boolean z10) throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoMediaUploader", "uploadThumbnail begin");
        Attachment attachmentM83602q = m83602q("thumbnail", this.f62430d.getAttachments());
        Thumbnail[] thumbnailArr = {new Thumbnail("small", this.f62428b), new Thumbnail("large", this.f62429c)};
        this.f62431e.m16305b0(this.f62430d.getId());
        this.f62431e.m16303Z(attachmentM83602q.getAsset());
        this.f62431e.m16310g0(thumbnailArr);
        this.f62431e.m16309f0(c11060c);
        this.f62431e.m16311h0(this.f62450x);
        this.f62431e.m16314l0(z10);
    }

    /* renamed from: c */
    public void m83619c(int i10, String str) {
        C1120a.m6677i("CloudPhotoMediaUploader", "file upload cancel: " + str);
        this.f62449w = true;
        this.f62451y = i10;
        this.f62452z = str;
        C2797a c2797a = this.f62432f;
        if (c2797a != null) {
            c2797a.m16287F();
        }
        C2797a c2797a2 = this.f62431e;
        if (c2797a2 != null) {
            c2797a2.m16287F();
        }
    }

    /* renamed from: d */
    public final void m83620d(C4616s c4616s) {
        JSONArray jSONArrayM59433a;
        try {
            if (TextUtils.isEmpty(c4616s.m28319c())) {
                return;
            }
            String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
            if (TextUtils.isEmpty(strM59436d) || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.optJSONObject(0) == null || !"albumId".equals(C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), "errorParam"))) {
                return;
            }
            SyncSessionManager.m15153t().m15177a("cloudphoto.file.batchcreate", this.f62446t, this.f62430d.getAlbumId());
        } catch (Exception e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "checkAlbumIdInvalid error : " + e10);
        }
    }

    /* renamed from: e */
    public final void m83621e(String str, C4616s c4616s) {
        if ("31004908".equals(str)) {
            int iM6848y0 = C1122c.m6848y0(c4616s);
            if (iM6848y0 == 0 || iM6848y0 == 1) {
                C1122c.m6829s();
            }
        }
    }

    /* renamed from: f */
    public final void m83622f() throws Throwable {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strM16328i = C2798b.m16328i(this.f62427a);
            C1120a.m6677i("CloudPhotoMediaUploader", "checkHash getFileSHA256Str time = " + (System.currentTimeMillis() - jCurrentTimeMillis) + "; fileSize =" + this.f62427a.length());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkHash  newSha256 = ");
            sb2.append(strM16328i);
            C1120a.m6675d("CloudPhotoMediaUploader", sb2.toString());
            C1120a.m6675d("CloudPhotoMediaUploader", "checkHash contentHash = " + this.f62438l.m16340a());
            if (strM16328i == null || !strM16328i.equalsIgnoreCase(this.f62438l.m16340a())) {
                C1120a.m6676e("CloudPhotoMediaUploader", "hash changed after upload content");
                m83601h();
                throw new C9721b(4311, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "hash changed after upload content", "checkHash");
            }
        } catch (Exception e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "calc hash error " + e10);
            m83601h();
            throw new C9721b(4311, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "calc hash error " + e10, "checkHash");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c4 A[DONT_GENERATE, PHI: r0
  0x00c4: PHI (r0v10 com.huawei.android.hicloud.drive.cloudphoto.model.Media) = 
  (r0v8 com.huawei.android.hicloud.drive.cloudphoto.model.Media)
  (r0v11 com.huawei.android.hicloud.drive.cloudphoto.model.Media)
 binds: [B:39:0x0158, B:19:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.android.hicloud.drive.cloudphoto.model.Media m83623i(java.util.HashMap<java.lang.String, java.lang.String> r18, java.lang.String r19, p649t6.C12946f r20, java.lang.String r21, com.huawei.android.hicloud.drive.cloudphoto.model.Media r22) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p804ya.C13928e.m83623i(java.util.HashMap, java.lang.String, t6.f, java.lang.String, com.huawei.android.hicloud.drive.cloudphoto.model.Media):com.huawei.android.hicloud.drive.cloudphoto.model.Media");
    }

    /* renamed from: j */
    public final Media m83624j() throws C9721b {
        C1120a.m6675d("CloudPhotoMediaUploader", "createComplete begin");
        try {
            Media media = new Media();
            media.setId(this.f62430d.getId());
            Medias.Update fields2 = this.f62434h.m83556m().update(this.f62430d.getId(), media).setMode(Constants.NORMAL_CACHE).addHeader("x-hw-lock", (Object) m83603r()).addHeader("x-hw-media-owner-Id", (Object) this.f62448v).addHeader("x-hw-trace-id", (Object) this.f62446t).setFields2("albumId,appSettings,createdTime,editedTime,description,deviceId,favorite,fileName,fileType,hash,hashId,id,mediaOwnerId,creator(userId,displayName),recycled,sha256,size,source,version,pictureMetadata,videoMetadata,properties,recycledTime,scaDetail");
            if (this.f62424A) {
                fields2.setAlbumClientHeader(this.f62446t);
            }
            return fields2.execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "create HttpResponseException." + e10.toString());
            throw new C9721b(4312, e10.m28322f(), e10.toString(), "medias.update", C1160a.m7253d(e10));
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoMediaUploader", "update IOException." + e11.toString());
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* renamed from: k */
    public final Asset m83625k(String str, String str2) throws C9721b {
        C1120a.m6675d("CloudPhotoMediaUploader", "createContentFromCloud begin");
        try {
            RevisionCreateRequest revisionCreateRequest = new RevisionCreateRequest();
            Resource resource = new Resource();
            resource.setLength(Long.valueOf(this.f62427a.length()));
            resource.setHash(this.f62439m);
            resource.setSha256(this.f62438l.m16340a());
            C2797a c2797a = new C2797a(this);
            this.f62432f = c2797a;
            c2797a.m16304a0(this.f62440n);
            this.f62432f.m16308e0(new b());
            Cipher cipherM16299U = this.f62432f.m16299U(this.f62437k, m83597D());
            revisionCreateRequest.setResource(resource);
            revisionCreateRequest.setCipher(cipherM16299U);
            return this.f62434h.m83549f().revisions().create(str, str2, "cipher,id,versionId,resource,state", revisionCreateRequest).setUsage("content").addHeader("x-hw-lock", (Object) m83603r()).addHeader("x-hw-trace-id", (Object) this.f62446t).execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "createContentFromCloud HttpResponseException." + e10);
            throw new C9721b(4312, e10.m28322f(), e10.toString(), "Assets.revisions.create", C1160a.m7253d(e10));
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoMediaUploader", "createContentFromCloud IOException." + e11);
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* renamed from: l */
    public final Asset m83626l(String str) throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoMediaUploader", "createContentFromLocal begin");
        C10131b.b bVar = new C10131b.b();
        bVar.m63099P(this.f62440n).m63090G().m63056b(this.f62435i);
        String strM63091H = bVar.m63091H();
        String strM63095L = bVar.m63095L();
        if (m83606E(str, strM63091H, strM63095L)) {
            m83601h();
            return null;
        }
        Asset assetM83629o = m83629o(str, strM63091H, strM63095L);
        if (assetM83629o == null) {
            m83601h();
            return null;
        }
        C2797a c2797a = new C2797a(this);
        this.f62432f = c2797a;
        c2797a.m16304a0(this.f62440n);
        this.f62432f.m16308e0(new a());
        assetM83629o.setCipher(this.f62432f.m16299U(this.f62437k, m83597D()));
        return assetM83629o;
    }

    /* renamed from: m */
    public final Media m83627m(C11060c c11060c) throws Throwable {
        C1120a.m6675d("CloudPhotoMediaUploader", "createFromCloud begin");
        try {
            ArrayList arrayList = new ArrayList();
            Attachment attachment = new Attachment();
            Asset asset = new Asset();
            Resource resource = new Resource();
            resource.setLength(Long.valueOf(this.f62427a.length()));
            File file = this.f62427a;
            if (this.f62439m == null) {
                this.f62437k = C2798b.m16329j(file);
                this.f62438l = C2798b.m16331l(file);
                this.f62439m = C2798b.m16337r(this.f62437k);
            }
            resource.setHash(this.f62439m);
            resource.setSha256(this.f62438l.m16340a());
            C2797a c2797a = new C2797a(this);
            this.f62432f = c2797a;
            c2797a.m16304a0(this.f62440n);
            this.f62432f.m16308e0(new c());
            asset.setCipher(this.f62432f.m16299U(this.f62437k, m83597D()));
            CompressInfo compressInfo = this.f62436j.get("content");
            if (compressInfo != null) {
                resource.setEncoding(compressInfo.getEncoding());
                resource.setType(compressInfo.getType());
                resource.setCompressedSize(compressInfo.getCompressedSize());
            }
            MediaAssetAttribute mediaAssetAttribute = new MediaAssetAttribute();
            mediaAssetAttribute.setPictureMetaData(this.f62430d.getPictureMetaData());
            mediaAssetAttribute.setVideoMetaData(this.f62430d.getVideoMetaData());
            this.f62430d.setPictureMetaData(null);
            this.f62430d.setVideoMetaData(null);
            asset.setAttributes(mediaAssetAttribute);
            asset.setResource(resource);
            attachment.setAsset(asset);
            attachment.setUsage("content");
            arrayList.add(attachment);
            if (m83636x()) {
                Attachment attachment2 = new Attachment();
                Asset asset2 = new Asset();
                Resource resource2 = new Resource();
                attachment2.setUsage("thumbnail");
                resource2.setLength(Long.valueOf(this.f62428b.length() + this.f62429c.length()));
                MediaAssetAttribute mediaAssetAttribute2 = new MediaAssetAttribute();
                MediaAssetAttribute.SmallLargePair smallLargePair = new MediaAssetAttribute.SmallLargePair();
                smallLargePair.setSmall(Long.valueOf(this.f62428b.length()));
                smallLargePair.setLarge(Long.valueOf(this.f62429c.length()));
                mediaAssetAttribute2.set("length", (Object) smallLargePair);
                MediaAssetAttribute.SmallLargeStrPair smallLargeStrPair = new MediaAssetAttribute.SmallLargeStrPair();
                C2798b.a aVarM16331l = C2798b.m16331l(this.f62428b);
                C2798b.a aVarM16331l2 = C2798b.m16331l(this.f62429c);
                smallLargeStrPair.setSmall(aVarM16331l.m16340a());
                smallLargeStrPair.setLarge(aVarM16331l2.m16340a());
                mediaAssetAttribute2.set("sha256", (Object) smallLargeStrPair);
                if (this.f62443q == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(this.f62428b);
                    arrayList2.add(this.f62429c);
                    this.f62441o = C2798b.m16330k(arrayList2);
                    this.f62442p = C2798b.m16336q(arrayList2);
                    this.f62443q = C2798b.m16337r(this.f62441o);
                }
                resource2.setHash(this.f62443q);
                resource2.setSha256(this.f62442p);
                resource2.setAttributes(mediaAssetAttribute2);
                C2797a c2797a2 = new C2797a(this);
                this.f62431e = c2797a2;
                c2797a2.m16304a0(this.f62444r);
                asset2.setCipher(this.f62431e.m16299U(this.f62441o, m83597D()));
                asset2.setAttributes(mediaAssetAttribute2);
                asset2.setResource(resource2);
                attachment2.setAsset(asset2);
                arrayList.add(attachment2);
            }
            this.f62430d.setId(null);
            this.f62430d.setUploadType(null);
            this.f62430d.setAttachments(arrayList);
            Medias.Create createAddHeader = this.f62434h.m83556m().create(this.f62430d).setFields2("id,createdTime,uploadType,attachments").setMode("temp").setAutoRename(Boolean.FALSE).addHeader("x-hw-lock", (Object) m83603r()).addHeader("x-hw-album-owner-Id", (Object) this.f62448v).addHeader("x-hw-trace-id", (Object) this.f62446t);
            if (this.f62424A) {
                createAddHeader.setAlbumClientHeader(this.f62446t);
                createAddHeader.addHeader("x-hw-options", (Object) "privilege");
            }
            if (!this.f62430d.getAlbumId().startsWith("default-album-")) {
                createAddHeader.setRiskToken();
            }
            Media mediaExecute = createAddHeader.execute();
            C4609l lastResponseHeaders = createAddHeader.getLastResponseHeaders();
            if (lastResponseHeaders != null) {
                String strM28237v = lastResponseHeaders.m28237v("x-hw-quicswitch");
                C1120a.m6677i("CloudPhotoMediaUploader", "parseAssetAttachments isUseQuic = " + strM28237v);
                boolean z10 = true;
                if (C0241z.m1685c(strM28237v) != 1) {
                    z10 = false;
                }
                this.f62450x = z10;
            } else {
                C1120a.m6678w("CloudPhotoMediaUploader", "parseAssetAttachments lastHeaders is null");
            }
            this.f62430d.setAttachments(mediaExecute.getAttachments());
            this.f62430d.setUploadType(mediaExecute.getUploadType());
            this.f62430d.setId(mediaExecute.getId());
            return mediaExecute;
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "create HttpResponseException." + e10.toString());
            String strM7253d = C1160a.m7253d(e10);
            m83611J(c11060c, strM7253d);
            m83621e(strM7253d, e10);
            m83620d(e10);
            throw new C9721b(4312, e10.m28322f(), e10.toString(), "medias.create", strM7253d);
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoMediaUploader", "create IOException." + e11.toString());
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* renamed from: n */
    public final Media m83628n() throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoMediaUploader", "createFromLocal begin");
        C10131b.b bVar = new C10131b.b();
        bVar.m63099P(this.f62440n).m63090G().m63056b(this.f62435i);
        String strM63094K = bVar.m63094K();
        String strM63091H = bVar.m63091H();
        String strM63095L = bVar.m63095L();
        String strM63092I = bVar.m63092I();
        this.f62450x = Boolean.parseBoolean(bVar.m63093J());
        C1120a.m6677i("CloudPhotoMediaUploader", "assertStatusBuilder isUseQuic = " + this.f62450x);
        if (m83606E(strM63094K, strM63091H, strM63095L)) {
            return null;
        }
        Asset assetM83629o = m83629o(strM63094K, strM63091H, strM63095L);
        if (assetM83629o == null) {
            m83601h();
            return null;
        }
        C2797a c2797a = new C2797a(this);
        this.f62432f = c2797a;
        c2797a.m16304a0(this.f62440n);
        this.f62432f.m16308e0(new d());
        assetM83629o.setCipher(this.f62432f.m16299U(this.f62437k, m83597D()));
        ArrayList arrayList = new ArrayList();
        this.f62430d.setAttachments(arrayList);
        Attachment attachment = new Attachment();
        attachment.setUsage("content");
        attachment.setAsset(assetM83629o);
        arrayList.add(attachment);
        if (m83636x()) {
            C10131b.b bVar2 = new C10131b.b();
            bVar2.m63099P(this.f62444r).m63090G().m63056b(this.f62435i);
            String strM63094K2 = bVar2.m63094K();
            String strM63091H2 = bVar2.m63091H();
            String strM63095L2 = bVar2.m63095L();
            if (m83606E(strM63094K2, strM63091H2, strM63095L2)) {
                return null;
            }
            if (!strM63094K2.equals(strM63094K)) {
                m83601h();
                return null;
            }
            Asset assetM83629o2 = m83629o(strM63094K2, strM63091H2, strM63095L2);
            if (assetM83629o2 == null) {
                m83601h();
                return null;
            }
            C2797a c2797a2 = new C2797a(this);
            this.f62431e = c2797a2;
            c2797a2.m16304a0(this.f62444r);
            assetM83629o2.setCipher(this.f62431e.m16299U(this.f62441o, m83597D()));
            Attachment attachment2 = new Attachment();
            attachment2.setUsage("thumbnail");
            attachment2.setAsset(assetM83629o2);
            arrayList.add(attachment2);
        }
        this.f62430d.setId(strM63094K);
        this.f62430d.setUploadType(strM63092I);
        return this.f62430d;
    }

    /* renamed from: o */
    public final Asset m83629o(String str, String str2, String str3) throws C9721b {
        C1120a.m6677i("CloudPhotoMediaUploader", "queryAsset begin");
        try {
            Assets.Revisions.Get getAddHeader = this.f62434h.m83549f().revisions().get(str, str2, str3, "id,version,versionId,resource,state").setMode("upload").addHeader("x-hw-media-owner-Id", (Object) this.f62448v).addHeader("x-hw-trace-id", (Object) this.f62446t);
            if (this.f62424A) {
                getAddHeader.setAlbumClientHeader(this.f62446t);
            }
            return getAddHeader.execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "queryAsset HttpResponseException." + e10.toString());
            return null;
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoMediaUploader", "update IOException." + e11.toString());
            throw new C9721b(4313, e11.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Asset onCreateUploadUrl(String str, String str2, String str3, Asset asset, AssetMetadataTransport.C2796a c2796a) throws C9721b, IOException {
        Assets.Revisions.Update updateAddHeader = this.f62434h.m83549f().revisions().update(str, str2, str3, "resource(objects(id,uploadUrl,accelerateUploadUrl))", asset).addHeader("x-hw-lock", (Object) m83603r()).addHeader("x-hw-media-owner-Id", (Object) this.f62448v).addHeader("x-hw-trace-id", (Object) this.f62446t);
        if (this.f62424A) {
            updateAddHeader.setAlbumClientHeader(this.f62446t);
        }
        return updateAddHeader.execute();
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset) throws IOException {
        return null;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public void onUploadCompleted(String str, String str2, String str3, Asset asset, boolean z10) throws Throwable {
        if (z10) {
            m83622f();
        }
        if (this.f62426C) {
            C1120a.m6675d("CloudPhotoMediaUploader", "onUploadCompleted, isContentUpload=" + this.f62426C);
            asset.setStatus(Asset.FIX);
        }
        Assets.Revisions.Update updateAddHeader = this.f62434h.m83549f().revisions().update(str, str2, str3, "id", asset).addHeader("x-hw-lock", (Object) m83603r()).addHeader("x-hw-media-owner-Id", (Object) this.f62448v).addHeader("x-hw-trace-id", (Object) this.f62446t);
        if (this.f62424A) {
            updateAddHeader.setAlbumClientHeader(this.f62446t);
        }
        updateAddHeader.execute();
    }

    /* renamed from: p */
    public final String m83630p(Media media) {
        Asset asset;
        List<Attachment> attachments = media.getAttachments();
        if (attachments == null || attachments.size() == 0) {
            C1120a.m6676e("CloudPhotoMediaUploader", "attachments is null");
            return null;
        }
        for (Attachment attachment : attachments) {
            if (attachment.getUsage().equalsIgnoreCase("content") && (asset = attachment.getAsset()) != null) {
                return asset.getId();
            }
        }
        return null;
    }

    /* renamed from: s */
    public final Media m83631s(String str) throws C9721b {
        try {
            return this.f62434h.m83556m().get(str).setFields2("albumId,fileName,recycled,editedTime,id,attachments").addHeader("x-hw-trace-id", (Object) this.f62446t).execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "getMedia HttpResponseException." + e10);
            String strM7253d = C1160a.m7253d(e10);
            if ("31084041".equals(strM7253d)) {
                return null;
            }
            throw new C9721b(4312, e10.m28322f(), e10.toString(), "medias.get", strM7253d);
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoMediaUploader", "getMedia IOException." + e11);
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* renamed from: t */
    public long m83632t() {
        C2797a c2797a = this.f62432f;
        if (c2797a != null) {
            return c2797a.m16293M();
        }
        return 0L;
    }

    /* renamed from: u */
    public long m83633u() {
        C2797a c2797a = this.f62432f;
        if (c2797a != null) {
            return c2797a.m16295Q();
        }
        return 0L;
    }

    /* renamed from: v */
    public long m83634v() {
        C2797a c2797a = this.f62432f;
        if (c2797a != null) {
            return c2797a.m16297S();
        }
        return 0L;
    }

    /* renamed from: w */
    public long m83635w() {
        C2797a c2797a = this.f62432f;
        if (c2797a != null) {
            return c2797a.m16298T();
        }
        return 0L;
    }

    /* renamed from: x */
    public final boolean m83636x() {
        return (this.f62428b == null || this.f62429c == null) ? false : true;
    }

    /* renamed from: y */
    public final Media m83637y(C11060c c11060c, String str, C12946f c12946f, String str2, Media media) throws C9721b, SQLException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            m83600g();
            Asset assetM83626l = m83626l(str);
            c11060c.m66667w(C13843a.m83101w(this.f62434h.getRootUrl()));
            if (assetM83626l == null) {
                m83600g();
                assetM83626l = m83625k(str, str2);
                new C10131b.b().m63099P(this.f62440n).m63101R(assetM83626l.getResource().getSha256()).m63100Q(str).m63104U(assetM83626l.getVersionId()).m63096M(assetM83626l.getId()).m63090G().m63057c(this.f62435i);
            }
            m83600g();
            m83616O(c11060c, assetM83626l, str);
            m83601h();
            c12946f.m77779l(str);
            C1120a.m6677i("CloudPhotoMediaUploader", "contentUploader end");
            c11060c.m66665u("0:1");
            c11060c.m66635A("OK");
            c11060c.m66638D("mediaId=" + str + ", hash=" + this.f62438l.m16340a() + ", assetId=" + str2);
            c11060c.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            return media;
        } catch (C9721b e10) {
            C1120a.m6676e("CloudPhotoMediaUploader", "contentUploader CException" + e10);
            c11060c.m66665u("101_" + e10.m60662f() + ":1");
            c11060c.m66635A(e10.m60658b() + "=>" + e10.getMessage());
            c11060c.m66638D("mediaId=" + str + ", hash=" + this.f62438l.m16340a() + ", assetId=" + str2);
            throw e10;
        }
    }

    /* renamed from: z */
    public final Media m83638z(C11060c c11060c, HashMap<String, String> map) throws Throwable {
        C9721b c9721b;
        boolean z10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z11 = true;
        Retry retry = new Retry(1);
        while (true) {
            try {
                m83600g();
                Media mediaM83628n = m83628n();
                c11060c.m66667w(C13843a.m83101w(this.f62434h.getRootUrl()));
                if (mediaM83628n == null) {
                    mediaM83628n = m83627m(c11060c);
                    m83609H(mediaM83628n);
                    m83608G(mediaM83628n);
                }
                z10 = (TextUtils.isEmpty(mediaM83628n.getUploadType()) || !mediaM83628n.getUploadType().equals("exist")) ? false : z11;
                if (m83636x()) {
                    m83600g();
                    m83618Q(c11060c, z10);
                }
                m83600g();
            } catch (C9721b e10) {
                e = e10;
            }
            try {
                map.put("uploadStartTime", String.valueOf(System.currentTimeMillis()));
                m83617P(c11060c, z10);
                if (z10) {
                    c11060c.m66669y("1");
                    C1120a.m6677i("CloudPhotoMediaUploader", "file upload by fast");
                }
                m83600g();
                Media mediaM83624j = m83624j();
                m83601h();
                C1120a.m6677i("CloudPhotoMediaUploader", "file upload end");
                c11060c.m66665u("0:1");
                c11060c.m66635A("OK");
                c11060c.m66638D("file = " + this.f62427a.getName() + " fid = " + this.f62430d.getHashId() + " length = " + this.f62430d.getSize() + " id = " + this.f62430d.getId());
                c11060c.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return mediaM83624j;
            } catch (C9721b e11) {
                e = e11;
                C1120a.m6676e("CloudPhotoMediaUploader", "upload CException " + e);
                if ((e.m60663g() == 403 && "31084037".equals(e.m60660d())) || ((e.m60663g() == 409 && "31004091".equals(e.m60660d())) || (e.m60663g() == 409 && "31094091".equals(e.m60660d())))) {
                    c9721b = new C9721b(4314, 34, e.getMessage(), e.m60658b(), e.m60660d());
                } else {
                    if (e.m60663g() == 400 && "31004002".equals(e.m60660d())) {
                        this.f62428b = null;
                        this.f62429c = null;
                    } else if ("31084913".equals(e.m60660d()) || e.m60659c() == 6005) {
                        m83601h();
                    } else if (e.m60659c() == 4313 || e.m60659c() == 4307) {
                        C13468a c13468aM81100c = C13468a.m81100c();
                        boolean zM81101b = c13468aM81100c.m81101b();
                        String str = c11060c.m66648d() + c13468aM81100c.toString() + e.toString();
                        if (!zM81101b) {
                            c9721b = new C9721b(PlayerConstants.ErrorCode.DEFAULT_ERROR, str);
                        }
                    }
                    c9721b = e;
                }
                retry.m16238g(c9721b.m60659c());
                if (m83596C(c9721b, retry)) {
                    c11060c.m66665u("117_" + e.m60662f() + ":1");
                    c11060c.m66635A(e.m60658b() + "=>" + e.getMessage());
                    c11060c.m66638D("file = " + this.f62427a.getName() + " fid = " + this.f62430d.getHashId() + " length = " + this.f62430d.getSize() + " id = " + this.f62430d.getId());
                    throw c9721b;
                }
                z11 = true;
            }
            z11 = true;
        }
    }
}
