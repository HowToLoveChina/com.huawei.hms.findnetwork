package p804ya;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.asset.C2797a;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cipher;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaAssetAttribute;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.model.RevisionCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.request.Assets;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1128i;
import p031b7.C1141v;
import p031b7.InterfaceC1126g;
import p283fa.C9678a;
import p332ha.C10130a;
import p332ha.C10131b;
import p332ha.C10134e;
import p429kk.C11058a;
import p429kk.C11060c;
import p546p6.C12109v;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;

/* renamed from: ya.f */
/* loaded from: classes3.dex */
public class C13929f implements AssetMetadataTransport {

    /* renamed from: a */
    public final String f62457a;

    /* renamed from: b */
    public final String f62458b;

    /* renamed from: c */
    public final String f62459c;

    /* renamed from: d */
    public final String f62460d;

    /* renamed from: e */
    public final SQLiteDatabase f62461e;

    /* renamed from: f */
    public final String f62462f;

    /* renamed from: g */
    public final boolean f62463g;

    /* renamed from: h */
    public File f62464h;

    /* renamed from: i */
    public boolean f62465i;

    /* renamed from: j */
    public int f62466j;

    /* renamed from: k */
    public File f62467k;

    /* renamed from: l */
    public File f62468l;

    /* renamed from: m */
    public C2797a f62469m;

    /* renamed from: n */
    public C2797a f62470n;

    /* renamed from: o */
    public C13924a f62471o;

    /* renamed from: p */
    public String f62472p;

    /* renamed from: q */
    public C2798b.a f62473q;

    /* renamed from: r */
    public String f62474r;

    /* renamed from: s */
    public String f62475s;

    /* renamed from: t */
    public String f62476t;

    /* renamed from: u */
    public String f62477u;

    /* renamed from: v */
    public String f62478v;

    /* renamed from: w */
    public String f62479w;

    /* renamed from: x */
    public boolean f62480x;

    /* renamed from: y */
    public int f62481y;

    /* renamed from: z */
    public String f62482z;

    public C13929f(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f62462f = str;
        this.f62457a = str2;
        this.f62458b = str3;
        this.f62459c = str4;
        this.f62460d = str5;
        this.f62464h = C10278a.m63442h(str6);
        this.f62461e = C10130a.m63054c();
        this.f62463g = true;
    }

    /* renamed from: c */
    private void m83639c() throws Throwable {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strM16328i = C2798b.m16328i(this.f62464h);
            C1120a.m6677i("CloudPhotoRefundUploader", "checkHash getFileSHA256Str time = " + (System.currentTimeMillis() - jCurrentTimeMillis) + "; fileSize =" + this.f62464h.length());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkHash  newSha256 = ");
            sb2.append(strM16328i);
            C1120a.m6675d("CloudPhotoRefundUploader", sb2.toString());
            C1120a.m6675d("CloudPhotoRefundUploader", "checkHash contentHash = " + this.f62473q.m16340a());
            if (strM16328i == null || !strM16328i.equalsIgnoreCase(this.f62473q.m16340a())) {
                C1120a.m6676e("CloudPhotoRefundUploader", "hash changed after upload content");
                m83649g(this.f62475s);
                throw new C9721b(4311, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "hash changed after upload content", "checkHash");
            }
        } catch (Exception e10) {
            C1120a.m6676e("CloudPhotoRefundUploader", "calc hash error " + e10);
            m83649g(this.f62475s);
            throw new C9721b(4311, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "calc hash error " + e10, "checkHash");
        }
    }

    /* renamed from: e */
    private void m83640e() throws C9721b {
        if (m83657s()) {
            throw new C9721b(1001, "user cancel.");
        }
    }

    /* renamed from: o */
    private Asset m83641o(String str, String str2, String str3) throws C9721b {
        C1120a.m6677i("CloudPhotoRefundUploader", "queryAsset begin");
        try {
            Assets.Revisions.Get mode = this.f62471o.m83549f().revisions().get(str, str2, str3, "id,version,versionId,resource,state").setMode("upload");
            mode.setAlbumClientHeader(this.f62462f);
            return mode.execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoRefundUploader", "queryAsset HttpResponseException." + e10);
            return null;
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoRefundUploader", "update IOException." + e11);
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* renamed from: p */
    private String m83642p() throws C9721b {
        Lock lockM72527d = C12109v.m72524c().m72527d();
        if (lockM72527d != null) {
            return lockM72527d.getSessionId();
        }
        throw new C9721b(1001, "lock is null");
    }

    /* renamed from: q */
    private InterfaceC1126g m83643q(int i10) {
        if (i10 == 1) {
            return new C1128i();
        }
        if (i10 != 4) {
            return null;
        }
        return new C1141v();
    }

    /* renamed from: r */
    private boolean m83644r() {
        File file = this.f62467k;
        return file != null && this.f62468l != null && file.exists() && this.f62468l.exists();
    }

    /* renamed from: a */
    public final void m83645a() throws C9721b {
        this.f62472p = C2798b.m16329j(this.f62464h);
        this.f62473q = C2798b.m16331l(this.f62464h);
        this.f62474r = C2798b.m16337r(this.f62472p);
        this.f62475s = this.f62457a + "_" + this.f62473q.m16340a() + "_refund_content_1";
        if (!TextUtils.isEmpty(this.f62459c)) {
            if (!this.f62459c.equalsIgnoreCase(this.f62473q.m16340a())) {
                throw new C9721b(4311, "content sha256 not equal");
            }
        } else {
            if (TextUtils.isEmpty(this.f62460d)) {
                throw new C9721b(4311, "content hash is null");
            }
            if (!this.f62460d.equalsIgnoreCase(this.f62473q.m16341b())) {
                throw new C9721b(4311, "content hashId not equal");
            }
        }
    }

    /* renamed from: b */
    public final void m83646b() throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f62467k);
        arrayList.add(this.f62468l);
        this.f62476t = C2798b.m16330k(arrayList);
        this.f62477u = C2798b.m16336q(arrayList);
        this.f62478v = C2798b.m16337r(this.f62476t);
        this.f62479w = this.f62457a + "_" + this.f62477u + "_refund_thumbnail_1";
    }

    /* renamed from: d */
    public final boolean m83647d() throws Throwable {
        C1120a.m6675d("CloudPhotoRefundUploader", "checkOriginalFileSha256");
        try {
            C2798b.a aVarM16331l = C2798b.m16331l(this.f62464h);
            if (!TextUtils.isEmpty(this.f62459c)) {
                if (!this.f62459c.equalsIgnoreCase(aVarM16331l.m16340a())) {
                    return false;
                }
                C1120a.m6675d("CloudPhotoRefundUploader", "checkOriginalFileSha256 success");
                return true;
            }
            if (TextUtils.isEmpty(this.f62460d) || !this.f62460d.equalsIgnoreCase(aVarM16331l.m16341b())) {
                return false;
            }
            C1120a.m6675d("CloudPhotoRefundUploader", "checkOriginalFileMD5 success");
            return true;
        } catch (C9721b e10) {
            C1120a.m6676e("CloudPhotoRefundUploader", "checkOriginalFileSha256 fail. " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: f */
    public final void m83648f(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
        }
    }

    /* renamed from: g */
    public final void m83649g(String str) throws C9721b, SQLException {
        new C10131b.b().m63099P(str).m63090G().m63055a(this.f62461e);
        new C10134e.b(str).m63171s().m63147a(this.f62461e);
    }

    /* renamed from: h */
    public final void m83650h() throws C9721b {
        C1120a.m6677i("CloudPhotoRefundUploader", "contentRefund begin");
        C1120a.m6675d("CloudPhotoRefundUploader", "contentRefund begin: " + C10279b.m63452a(this.f62464h));
        m83640e();
        m83645a();
        C11060c c11060cM66626a = C11058a.m66626a(this.f62462f, "contentRefund", C13452e.m80781L().m80971t0());
        try {
            m83651i(c11060cM66626a);
        } finally {
            if (this.f62480x) {
                c11060cM66626a.m66665u("001_" + this.f62481y + ":1");
                c11060cM66626a.m66635A(this.f62482z);
            }
            C1120a.m6677i("CloudPhotoRefundUploader", "contentRefund end code: " + c11060cM66626a.m66647c());
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }

    /* renamed from: i */
    public final void m83651i(C11060c c11060c) throws C9721b, SQLException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            m83640e();
            Asset assetM83653k = m83653k();
            c11060c.m66667w(C13843a.m83101w(this.f62471o.getRootUrl()));
            if (assetM83653k == null) {
                m83640e();
                assetM83653k = m83652j();
                m83659u(assetM83653k, this.f62475s);
            }
            m83640e();
            m83663y(c11060c, assetM83653k);
            m83649g(this.f62475s);
            C1120a.m6677i("CloudPhotoRefundUploader", "contentUploader end");
            c11060c.m66665u("0:1");
            c11060c.m66635A("OK");
            c11060c.m66638D("mediaId=" + this.f62457a + ", hash=" + this.f62473q.m16340a() + ", assetId=" + this.f62458b + ", isContent=" + this.f62463g + ", useOriginalPath=" + this.f62465i);
            c11060c.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (C9721b e10) {
            C1120a.m6676e("CloudPhotoRefundUploader", "contentUploader CException" + e10);
            c11060c.m66665u("101_" + e10.m60662f() + ":1");
            c11060c.m66635A(e10.m60658b() + "=>" + e10.getMessage());
            c11060c.m66638D("mediaId=" + this.f62457a + ", hash=" + this.f62473q.m16340a() + ", assetId=" + this.f62458b + ", isContent=" + this.f62463g + ", useOriginalPath=" + this.f62465i);
            throw e10;
        }
    }

    /* renamed from: j */
    public final Asset m83652j() throws C9721b {
        C1120a.m6675d("CloudPhotoRefundUploader", "createContentFromCloud begin");
        try {
            RevisionCreateRequest revisionCreateRequest = new RevisionCreateRequest();
            Resource resource = new Resource();
            resource.setLength(Long.valueOf(this.f62464h.length()));
            resource.setHash(this.f62474r);
            resource.setSha256(this.f62473q.m16340a());
            C2797a c2797a = new C2797a(this);
            this.f62470n = c2797a;
            c2797a.m16304a0(this.f62475s);
            Cipher cipherM16299U = this.f62470n.m16299U(this.f62472p, true);
            revisionCreateRequest.setResource(resource);
            revisionCreateRequest.setCipher(cipherM16299U);
            Assets.Revisions.Create createAddHeader = this.f62471o.m83549f().revisions().create(this.f62457a, this.f62458b, "cipher,id,versionId,resource,state", revisionCreateRequest).setUsage("content").addHeader("x-hw-lock", (Object) m83642p());
            createAddHeader.setAlbumClientHeader(this.f62462f);
            return createAddHeader.execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoRefundUploader", "createContentFromCloud HttpResponseException." + e10);
            throw new C9721b(4312, e10.m28322f(), e10.toString(), "assets.revisions.create", C1160a.m7253d(e10));
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoRefundUploader", "createContentFromCloud IOException." + e11);
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* renamed from: k */
    public final Asset m83653k() throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoRefundUploader", "createContentFromLocal begin");
        C10131b.b bVar = new C10131b.b();
        bVar.m63099P(this.f62475s).m63090G().m63056b(this.f62461e);
        String strM63091H = bVar.m63091H();
        String strM63095L = bVar.m63095L();
        if (m83658t(strM63091H, strM63095L)) {
            m83649g(this.f62475s);
            return null;
        }
        Asset assetM83641o = m83641o(this.f62457a, strM63091H, strM63095L);
        if (assetM83641o == null) {
            m83649g(this.f62475s);
            return null;
        }
        C2797a c2797a = new C2797a(this);
        this.f62470n = c2797a;
        c2797a.m16304a0(this.f62475s);
        assetM83641o.setCipher(this.f62470n.m16299U(this.f62472p, true));
        return assetM83641o;
    }

    /* renamed from: l */
    public final Asset m83654l() throws Throwable {
        C1120a.m6675d("CloudPhotoRefundUploader", "createThumbnailFromCloud begin");
        try {
            RevisionCreateRequest revisionCreateRequest = new RevisionCreateRequest();
            Resource resource = new Resource();
            resource.setLength(Long.valueOf(this.f62467k.length() + this.f62468l.length()));
            MediaAssetAttribute mediaAssetAttribute = new MediaAssetAttribute();
            MediaAssetAttribute.SmallLargePair smallLargePair = new MediaAssetAttribute.SmallLargePair();
            smallLargePair.setSmall(Long.valueOf(this.f62467k.length()));
            smallLargePair.setLarge(Long.valueOf(this.f62468l.length()));
            mediaAssetAttribute.set("length", (Object) smallLargePair);
            MediaAssetAttribute.SmallLargeStrPair smallLargeStrPair = new MediaAssetAttribute.SmallLargeStrPair();
            C2798b.a aVarM16331l = C2798b.m16331l(this.f62467k);
            C2798b.a aVarM16331l2 = C2798b.m16331l(this.f62468l);
            smallLargeStrPair.setSmall(aVarM16331l.m16340a());
            smallLargeStrPair.setLarge(aVarM16331l2.m16340a());
            mediaAssetAttribute.set("sha256", (Object) smallLargeStrPair);
            resource.setHash(this.f62478v);
            resource.setSha256(this.f62477u);
            resource.setAttributes(mediaAssetAttribute);
            C2797a c2797a = new C2797a(this);
            this.f62469m = c2797a;
            c2797a.m16304a0(this.f62479w);
            Cipher cipherM16299U = this.f62469m.m16299U(this.f62476t, true);
            revisionCreateRequest.setResource(resource);
            revisionCreateRequest.setCipher(cipherM16299U);
            if (TextUtils.isEmpty(this.f62458b)) {
                Assets.Create createAddHeader = this.f62471o.m83549f().create(this.f62457a, "cipher,id,versionId,resource,state", revisionCreateRequest).setUsage("thumbnail").addHeader("x-hw-lock", (Object) m83642p());
                createAddHeader.setAlbumClientHeader(this.f62462f);
                return createAddHeader.execute();
            }
            Assets.Revisions.Create createAddHeader2 = this.f62471o.m83549f().revisions().create(this.f62457a, this.f62458b, "cipher,id,versionId,resource,state", revisionCreateRequest).setUsage("thumbnail").addHeader("x-hw-lock", (Object) m83642p());
            createAddHeader2.setAlbumClientHeader(this.f62462f);
            return createAddHeader2.execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoRefundUploader", "createThumbnailFromCloud HttpResponseException." + e10);
            throw new C9721b(4312, e10.m28322f(), e10.toString(), "assets.revisions.create", C1160a.m7253d(e10));
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoRefundUploader", "createThumbnailFromCloud IOException." + e11);
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* renamed from: m */
    public final Asset m83655m() throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoRefundUploader", "createThumbnailFromLocal begin");
        C10131b.b bVar = new C10131b.b();
        bVar.m63099P(this.f62479w).m63090G().m63056b(this.f62461e);
        String strM63091H = bVar.m63091H();
        String strM63095L = bVar.m63095L();
        if (m83658t(strM63091H, strM63095L)) {
            m83649g(this.f62479w);
            return null;
        }
        Asset assetM83641o = m83641o(this.f62457a, strM63091H, strM63095L);
        if (assetM83641o == null) {
            m83649g(this.f62479w);
            return null;
        }
        C2797a c2797a = new C2797a(this);
        this.f62469m = c2797a;
        c2797a.m16304a0(this.f62479w);
        assetM83641o.setCipher(this.f62469m.m16299U(this.f62476t, true));
        return assetM83641o;
    }

    /* renamed from: n */
    public final void m83656n(InterfaceC1126g interfaceC1126g) throws IOException {
        C1120a.m6677i("CloudPhotoRefundUploader", "generateThumbnail start");
        String strM6710K0 = C1122c.m6710K0();
        File fileM63442h = C10278a.m63442h(strM6710K0);
        if (!fileM63442h.exists()) {
            C1120a.m6675d("CloudPhotoRefundUploader", "mkdirs refundParent:" + fileM63442h.mkdirs());
        }
        m83648f(fileM63442h);
        File fileM63442h2 = C10278a.m63442h(strM6710K0 + "largeThumbnail.jpg");
        this.f62468l = fileM63442h2;
        fileM63442h2.createNewFile();
        interfaceC1126g.mo6901a().mo6907b(this.f62468l, this.f62464h, 100, new FailRet());
        File fileM63442h3 = C10278a.m63442h(strM6710K0 + "smallThumbnail.jpg");
        this.f62467k = fileM63442h3;
        fileM63442h3.createNewFile();
        interfaceC1126g.mo6901a().mo6909e(this.f62467k, this.f62464h, 100, new FailRet());
        C1120a.m6677i("CloudPhotoRefundUploader", "generateThumbnail end");
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Asset onCreateUploadUrl(String str, String str2, String str3, Asset asset, AssetMetadataTransport.C2796a c2796a) throws C9721b, IOException {
        Assets.Revisions.Update updateAddHeader = this.f62471o.m83549f().revisions().update(str, str2, str3, "resource(objects(id,uploadUrl,accelerateUploadUrl))", asset).addHeader("x-hw-lock", (Object) m83642p());
        updateAddHeader.setAlbumClientHeader(this.f62462f);
        return updateAddHeader.execute();
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset) {
        return null;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public void onUploadCompleted(String str, String str2, String str3, Asset asset, boolean z10) throws Throwable {
        if (z10) {
            m83639c();
        }
        asset.setStatus(Asset.FIX);
        Assets.Revisions.Update updateAddHeader = this.f62471o.m83549f().revisions().update(str, str2, str3, "id", asset).addHeader("x-hw-lock", (Object) m83642p());
        updateAddHeader.setAlbumClientHeader(this.f62462f);
        updateAddHeader.execute();
    }

    /* renamed from: s */
    public boolean m83657s() {
        return this.f62480x;
    }

    /* renamed from: t */
    public final boolean m83658t(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* renamed from: u */
    public final void m83659u(Asset asset, String str) throws C9721b, SQLException {
        new C10131b.b().m63099P(str).m63101R(asset.getResource().getSha256()).m63100Q(this.f62457a).m63104U(asset.getVersionId()).m63096M(asset.getId()).m63090G().m63057c(this.f62461e);
    }

    /* renamed from: v */
    public final void m83660v() throws C9721b, SQLException {
        C1120a.m6677i("CloudPhotoRefundUploader", "thumbnailUpload begin");
        C1120a.m6675d("CloudPhotoRefundUploader", "thumbnailUpload begin: " + C10279b.m63452a(this.f62467k));
        C1120a.m6675d("CloudPhotoRefundUploader", "thumbnailUpload begin: " + C10279b.m63452a(this.f62468l));
        m83640e();
        m83646b();
        if (this.f62465i) {
            m83649g(this.f62479w);
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.f62462f, "thumbnailRefund", C13452e.m80781L().m80971t0());
        try {
            m83661w(c11060cM66626a);
        } finally {
            if (this.f62480x) {
                c11060cM66626a.m66665u("001_" + this.f62481y + ":1");
                c11060cM66626a.m66635A(this.f62482z);
            }
            C1120a.m6677i("CloudPhotoRefundUploader", "thumbnailUpload end code: " + c11060cM66626a.m66647c());
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }

    /* renamed from: w */
    public final void m83661w(C11060c c11060c) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            m83640e();
            Asset assetM83655m = m83655m();
            c11060c.m66667w(C13843a.m83101w(this.f62471o.getRootUrl()));
            if (assetM83655m == null) {
                m83640e();
                assetM83655m = m83654l();
                m83659u(assetM83655m, this.f62479w);
            }
            m83640e();
            m83664z(c11060c, assetM83655m);
            m83649g(this.f62479w);
            C1120a.m6677i("CloudPhotoRefundUploader", "thumbnailUploader end");
            c11060c.m66665u("0:1");
            c11060c.m66635A("OK");
            c11060c.m66638D("mediaId=" + this.f62457a + ", hash=" + this.f62477u + ", assetId=" + assetM83655m.getId() + ", isContent=" + this.f62463g + ", useOriginalPath=" + this.f62465i);
            c11060c.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (C9721b e10) {
            C1120a.m6676e("CloudPhotoRefundUploader", "thumbnailUploader CException" + e10);
            c11060c.m66665u("101_" + e10.m60662f() + ":1");
            c11060c.m66635A(e10.m60658b() + "=>" + e10.getMessage());
            c11060c.m66638D("mediaId=" + this.f62457a + ", hash=" + this.f62477u + ", assetId=" + this.f62458b + ", isContent=" + this.f62463g + ", useOriginalPath=" + this.f62465i);
            throw e10;
        }
    }

    /* renamed from: x */
    public void m83662x() throws C9721b, IOException, SQLException {
        File file;
        C1120a.m6677i("CloudPhotoRefundUploader", "refund upload: " + this.f62457a + ", " + this.f62458b + ", " + this.f62463g + ", " + this.f62465i);
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        this.f62471o = c13924aM60445d;
        if (c13924aM60445d == null) {
            throw new C9721b(4311, "drive is null");
        }
        if (this.f62463g) {
            File file2 = this.f62464h;
            if (file2 == null || !file2.exists()) {
                return;
            }
            m83650h();
            return;
        }
        if (this.f62465i && (file = this.f62464h) != null && file.exists() && m83647d()) {
            C1120a.m6677i("CloudPhotoRefundUploader", "create thumbnail from original file, type " + this.f62466j);
            InterfaceC1126g interfaceC1126gM83643q = m83643q(this.f62466j);
            if (interfaceC1126gM83643q != null) {
                m83656n(interfaceC1126gM83643q);
            }
        }
        if (m83644r()) {
            m83660v();
        }
        if (this.f62465i) {
            m83648f(C10278a.m63442h(C1122c.m6710K0()));
        }
    }

    /* renamed from: y */
    public final void m83663y(C11060c c11060c, Asset asset) throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoRefundUploader", "uploadContent begin");
        this.f62470n.m16307d0(this.f62464h);
        this.f62470n.m16305b0(this.f62457a);
        this.f62470n.m16303Z(asset);
        this.f62470n.m16309f0(c11060c);
        this.f62470n.m16306c0(true);
        this.f62470n.m16314l0(false);
    }

    /* renamed from: z */
    public final void m83664z(C11060c c11060c, Asset asset) throws C9721b, SQLException {
        C1120a.m6675d("CloudPhotoRefundUploader", "uploadThumbnail begin");
        Thumbnail[] thumbnailArr = {new Thumbnail("small", this.f62467k), new Thumbnail("large", this.f62468l)};
        this.f62469m.m16305b0(this.f62457a);
        this.f62469m.m16303Z(asset);
        this.f62469m.m16310g0(thumbnailArr);
        this.f62469m.m16309f0(c11060c);
        this.f62469m.m16314l0(false);
    }

    public C13929f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z10, int i10) {
        this.f62462f = str;
        this.f62457a = str2;
        this.f62458b = str3;
        this.f62459c = str4;
        this.f62460d = str5;
        this.f62465i = z10;
        if (z10) {
            this.f62464h = C10278a.m63442h(str8);
        } else {
            this.f62467k = C10278a.m63442h(str6);
            this.f62468l = C10278a.m63442h(str7);
        }
        this.f62466j = i10;
        this.f62461e = C10130a.m63054c();
        this.f62463g = false;
    }
}
