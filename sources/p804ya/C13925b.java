package p804ya;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.asset.C2797a;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.request.AlbumAssets;
import com.huawei.cloud.base.http.C4616s;
import fk.C9721b;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import p015ak.C0213f;
import p031b7.C1120a;
import p283fa.C9678a;
import p332ha.C10130a;
import p332ha.C10134e;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p733w9.C13576a;
import p746wn.C13622a;
import p818yp.C14034a;

/* renamed from: ya.b */
/* loaded from: classes3.dex */
public class C13925b implements AssetMetadataTransport {

    /* renamed from: a */
    public File f62394a;

    /* renamed from: b */
    public Album f62395b;

    /* renamed from: c */
    public C2797a f62396c;

    /* renamed from: e */
    public String f62398e;

    /* renamed from: f */
    public C2798b.a f62399f;

    /* renamed from: g */
    public String f62400g;

    /* renamed from: h */
    public String f62401h;

    /* renamed from: i */
    public String f62402i;

    /* renamed from: k */
    public String f62404k;

    /* renamed from: l */
    public boolean f62405l;

    /* renamed from: m */
    public int f62406m;

    /* renamed from: n */
    public String f62407n;

    /* renamed from: p */
    public String f62409p;

    /* renamed from: d */
    public C13924a f62397d = C9678a.m60442e().m60445d();

    /* renamed from: j */
    public Context f62403j = C0213f.m1377a();

    /* renamed from: o */
    public SQLiteDatabase f62408o = C10130a.m63054c();

    public C13925b(String str, Album album, File file, String str2) {
        this.f62395b = album;
        this.f62394a = file;
        this.f62402i = str;
        this.f62404k = album.getAlbumOwnerId();
        this.f62409p = str2;
    }

    /* renamed from: a */
    public final void m83563a() throws C9721b {
        this.f62398e = C2798b.m16329j(this.f62394a);
        this.f62399f = C2798b.m16331l(this.f62394a);
        this.f62400g = C2798b.m16337r(this.f62398e);
        this.f62401h = this.f62395b.getId() + "_" + this.f62394a.getName() + "_" + this.f62399f.m16340a() + "_1";
    }

    /* renamed from: b */
    public final void m83564b() throws C9721b {
        if (m83568f()) {
            throw new C9721b(1001, "user cancel.");
        }
    }

    /* renamed from: c */
    public final void m83565c() throws C9721b, SQLException {
        new C10134e.b(this.f62401h).m63171s().m63147a(this.f62408o);
    }

    /* renamed from: d */
    public final Asset m83566d() throws C9721b {
        C1120a.m6675d("CloudPhotoBabyUploader", "createFromCloud begin");
        try {
            Asset asset = new Asset();
            Resource resource = new Resource();
            resource.setHash(this.f62400g);
            resource.setLength(Long.valueOf(this.f62394a.length()));
            resource.setSha256(this.f62399f.m16340a());
            C2797a c2797a = new C2797a(this);
            this.f62396c = c2797a;
            c2797a.m16304a0(this.f62401h);
            asset.setCipher(this.f62396c.m16299U(this.f62398e, m83569g()));
            asset.setMimeType(C14034a.m84171h(this.f62394a).m73356b());
            asset.setResource(resource);
            AlbumAssets.Create createAddHeader = this.f62397d.m83545b().create(this.f62395b.getId(), "id,state,resource,versionId", "baby", asset).addHeader("x-hw-lock", (Object) this.f62409p).addHeader("x-hw-album-owner-Id", (Object) this.f62404k);
            createAddHeader.setAlbumClientHeader(this.f62402i);
            return createAddHeader.execute();
        } catch (C4616s e10) {
            C1120a.m6676e("CloudPhotoBabyUploader", "create HttpResponseException." + e10.toString());
            throw new C9721b(4312, e10.m28322f(), e10.toString(), "albums.assets.create", C1160a.m7253d(e10));
        } catch (IOException e11) {
            C1120a.m6676e("CloudPhotoBabyUploader", "create IOException." + e11.toString());
            throw new C9721b(4313, e11.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0148  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m83567e(p429kk.C11060c r12) throws fk.C9721b, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p804ya.C13925b.m83567e(kk.c):void");
    }

    /* renamed from: f */
    public boolean m83568f() {
        return this.f62405l;
    }

    /* renamed from: g */
    public final boolean m83569g() {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0) || TextUtils.isEmpty(this.f62404k)) {
            return true;
        }
        return strM80971t0.equals(this.f62404k);
    }

    /* renamed from: h */
    public void m83570h(HashMap<String, String> map) {
        StringBuilder sb2;
        C1120a.m6677i("CloudPhotoBabyUploader", "upload begin");
        C1120a.m6675d("CloudPhotoBabyUploader", "upload begin: " + this.f62394a.getName());
        C13576a c13576aM81565a = C13576a.m81565a();
        C11060c c11060cM66626a = C11058a.m66626a(this.f62402i, "upload", C13452e.m80781L().m80971t0());
        try {
            try {
                m83564b();
                m83563a();
                if (c13576aM81565a.m81566b(this.f62401h)) {
                    m83567e(c11060cM66626a);
                } else {
                    C1120a.m6678w("CloudPhotoBabyUploader", "file already in upload, wait for result. " + this.f62401h);
                    c13576aM81565a.m81570f(this.f62401h);
                    m83567e(c11060cM66626a);
                }
                c13576aM81565a.m81568d(this.f62401h);
            } catch (Exception e10) {
                C1120a.m6676e("CloudPhotoBabyUploader", "upload Exception " + e10.getMessage());
                c13576aM81565a.m81568d(this.f62401h);
                if (this.f62405l) {
                    sb2 = new StringBuilder();
                }
            }
            if (this.f62405l) {
                sb2 = new StringBuilder();
                sb2.append("001_");
                sb2.append(this.f62406m);
                sb2.append(":1");
                c11060cM66626a.m66665u(sb2.toString());
                c11060cM66626a.m66635A(this.f62407n);
            }
            C13622a.m81969o(this.f62403j, c11060cM66626a, map);
        } catch (Throwable th2) {
            c13576aM81565a.m81568d(this.f62401h);
            if (this.f62405l) {
                c11060cM66626a.m66665u("001_" + this.f62406m + ":1");
                c11060cM66626a.m66635A(this.f62407n);
            }
            C13622a.m81969o(this.f62403j, c11060cM66626a, map);
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Asset onCreateUploadUrl(String str, String str2, String str3, Asset asset, AssetMetadataTransport.C2796a c2796a) throws C9721b, IOException {
        AlbumAssets.Revisions.Update updateAddHeader = this.f62397d.m83545b().revisions().update(str, str2, str3, "resource(objects(id,uploadUrl,accelerateUploadUrl))", asset).addHeader("x-hw-lock", (Object) this.f62409p).addHeader("x-hw-album-owner-Id", (Object) this.f62404k);
        updateAddHeader.setAlbumClientHeader(this.f62402i);
        return updateAddHeader.execute();
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset) throws IOException {
        return null;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public void onUploadCompleted(String str, String str2, String str3, Asset asset, boolean z10) throws C9721b, IOException {
        AlbumAssets.Revisions.Update updateAddHeader = this.f62397d.m83545b().revisions().update(str, str2, str3, "id", asset).addHeader("x-hw-lock", (Object) this.f62409p).addHeader("x-hw-album-owner-Id", (Object) this.f62404k);
        updateAddHeader.setAlbumClientHeader(this.f62402i);
        updateAddHeader.execute();
    }
}
