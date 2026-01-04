package im;

import cm.C1457c;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileAttachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Resource;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionFinish;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import fk.C9721b;
import hk.C10279b;
import hm.C10321z;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mk.C11476b;
import p455ll.C11308a;
import p455ll.C11309b;
import p455ll.C11310c;
import p455ll.C11311d;
import p514o9.C11839m;
import p682ul.C13216j;
import p818yp.C14034a;

/* renamed from: im.k */
/* loaded from: classes6.dex */
public class C10561k extends AbstractC10558h {

    /* renamed from: J */
    public C11309b f50787J;

    /* renamed from: K */
    public C11311d f50788K;

    /* renamed from: L */
    public String f50789L;

    /* renamed from: M */
    public String f50790M;

    /* renamed from: N */
    public Map<String, String> f50791N;

    /* renamed from: O */
    public String f50792O;

    /* renamed from: P */
    public String f50793P;

    /* renamed from: Q */
    public String f50794Q;

    /* renamed from: R */
    public String f50795R;

    /* renamed from: S */
    public String f50796S;

    /* renamed from: T */
    public String f50797T;

    public C10561k(String str, String str2, C10321z c10321z, C1457c c1457c, File file, String str3, String str4, Map<String, String> map, String str5) {
        super(str, str2, c10321z, c1457c, "App", str4, file, str5);
        m64781b0(str);
        this.f50789L = str3;
        this.f50790M = str4;
        this.f50791N = map;
        C13216j.c cVar = C13216j.c.STATUS;
        this.f50787J = new C11309b(C13216j.m79427l(cVar, null));
        this.f50788K = new C11311d(C13216j.m79427l(cVar, null));
    }

    @Override // im.AbstractC10554e
    /* renamed from: H */
    public void mo64738H(int i10) throws C9721b {
        m64715j();
        this.f50787J.update(this.f50745l.m67892j(), i10);
        this.f50745l.m67881E(i10);
    }

    @Override // im.AbstractC10554e
    /* renamed from: I */
    public void mo64739I(String str, String str2) throws C9721b {
        this.f50788K.m67943f(str, str2, 1);
    }

    @Override // im.AbstractC10558h
    /* renamed from: L */
    public Slice<File> mo64762L(String str, Slice<File> slice) {
        return slice;
    }

    @Override // im.AbstractC10558h
    /* renamed from: N */
    public long mo64764N(List<Slice<File>> list) {
        Iterator<Slice<File>> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().getLength();
        }
        return length;
    }

    @Override // im.AbstractC10558h
    /* renamed from: R */
    public C11308a mo64768R(File file) throws C9721b {
        C11839m.m70688i("CloudBackupV3AttachUploader", "file upload prepare start." + file.getName());
        String strM63452a = C10279b.m63452a(file);
        Md5AndHash md5AndHashM68622d = C11476b.m68622d(file);
        C11308a c11308aM67912d = this.f50787J.m67912d(strM63452a);
        if (c11308aM67912d == null) {
            c11308aM67912d = m64778Y(file, md5AndHashM68622d);
        } else if (this.f50789L.equals(c11308aM67912d.m67895m())) {
            List<C11310c> listM67942e = this.f50788K.m67942e(c11308aM67912d.m67883a());
            if (listM67942e.isEmpty()) {
                c11308aM67912d = m64778Y(file, md5AndHashM68622d);
            } else if (md5AndHashM68622d.getHash().equals(c11308aM67912d.m67890h()) && m64734B(c11308aM67912d)) {
                this.f50754u.addAll(listM67942e);
            } else {
                this.f50788K.m67939b(c11308aM67912d.m67883a());
                c11308aM67912d = c11308aM67912d.m67897o() == 2 ? m64779Z(file, md5AndHashM68622d, c11308aM67912d.m67883a()) : m64778Y(file, md5AndHashM68622d);
            }
        } else {
            this.f50788K.m67939b(c11308aM67912d.m67883a());
            this.f50787J.m67909a(strM63452a);
            c11308aM67912d = m64778Y(file, md5AndHashM68622d);
        }
        Collections.sort(this.f50754u);
        C11839m.m70688i("CloudBackupV3AttachUploader", "file upload prepare end." + file.getName());
        return c11308aM67912d;
    }

    /* renamed from: X */
    public final C11308a m64777X(Asset asset, File file, Md5AndHash md5AndHash) throws C9721b {
        Resource resource = asset.getResource();
        if (resource == null) {
            throw new C9721b(3911, "resource is empty", "Backup.asset.create");
        }
        int i10 = resource.getState().intValue() == 0 ? 1 : 0;
        if (asset.getState().intValue() == 0) {
            i10 = 2;
        }
        C11308a c11308a = new C11308a();
        c11308a.m67908z(C10279b.m63452a(file)).m67878B(file.length()).m67905w(md5AndHash.getMD5()).m67906x(md5AndHash.getHash()).m67881E(i10).m67877A(this.f50747n).m67879C(this.f50789L).m67899q(asset.getId()).m67882F(asset.getVersionId()).m67880D(asset.getResource().getSliceSize()).m67900r(new C4644l(System.currentTimeMillis()).toString());
        this.f50787J.m67914f(c11308a);
        if (resource.getState().intValue() != 0) {
            List<Resource.SliceObject> objects = resource.getObjects();
            if (objects == null || objects.isEmpty()) {
                throw new C9721b(3911, "objects is empty", "Backup.asset.create");
            }
            for (Resource.SliceObject sliceObject : asset.getResource().getObjects()) {
                C11310c c11310c = new C11310c();
                c11310c.m67936y(asset.getId()).m67916B(sliceObject.getId()).m67915A(sliceObject.getNumber().intValue()).m67918D(0).m67917C(sliceObject.getStart().longValue()).m67937z(sliceObject.getLength().longValue());
                this.f50754u.add(c11310c);
            }
            this.f50788K.m67938a(this.f50754u);
        }
        return c11308a;
    }

    /* renamed from: Y */
    public final C11308a m64778Y(File file, Md5AndHash md5AndHash) throws C9721b {
        RevisionCreate.ResourceCreate resourceCreate = new RevisionCreate.ResourceCreate();
        resourceCreate.setHash(md5AndHash.getHash()).setSha256(md5AndHash.getHash()).setLength(Long.valueOf(file.length()));
        RevisionCreate revisionCreate = new RevisionCreate();
        revisionCreate.setResource(resourceCreate).setMimeType(C14034a.m84169f(file)).setProperties(this.f50791N);
        FileAttachment fileAttachment = new FileAttachment();
        if ("apk".equals(this.f50790M) || "icon".equals(this.f50790M)) {
            fileAttachment.setPackageName((String) C4627a0.m28391d(this.f50792O)).setPackageVersion((String) C4627a0.m28391d(this.f50793P)).setPackageOriginHashType((String) C4627a0.m28391d(this.f50794Q)).setPackageOriginLength((String) C4627a0.m28391d(this.f50797T)).setPackageSsha2(this.f50795R).setPackageOriginHash((String) C4627a0.m28391d(this.f50796S));
        }
        return m64777X(this.f50739f.m63544G(this.f50740g, this.f50790M, this.f50747n, this.f50789L, revisionCreate, fileAttachment, this.f50741h, this.f50742i, this.f50744k, 0), file, md5AndHash);
    }

    /* renamed from: Z */
    public final C11308a m64779Z(File file, Md5AndHash md5AndHash, String str) throws C9721b {
        RevisionCreate.ResourceCreate resourceCreate = new RevisionCreate.ResourceCreate();
        resourceCreate.setHash(md5AndHash.getHash()).setSha256(md5AndHash.getHash()).setLength(Long.valueOf(file.length()));
        RevisionCreate revisionCreate = new RevisionCreate();
        revisionCreate.setResource(resourceCreate).setMimeType(C14034a.m84169f(file)).setProperties(this.f50791N);
        FileAttachment fileAttachment = new FileAttachment();
        if ("apk".equals(this.f50790M) || "icon".equals(this.f50790M)) {
            fileAttachment.setPackageName((String) C4627a0.m28391d(this.f50792O)).setPackageVersion((String) C4627a0.m28391d(this.f50793P)).setPackageOriginHashType((String) C4627a0.m28391d(this.f50794Q)).setPackageOriginLength((String) C4627a0.m28391d(this.f50797T)).setPackageOriginHash((String) C4627a0.m28391d(this.f50796S));
        }
        try {
            return m64777X(this.f50739f.m63545H(this.f50740g, this.f50790M, this.f50747n, this.f50789L, str, revisionCreate, fileAttachment, this.f50741h, this.f50742i, this.f50744k, 0), file, md5AndHash);
        } catch (C9721b e10) {
            if (e10.m60659c() == 3922) {
                mo64709d();
            }
            throw e10;
        }
    }

    /* renamed from: a0 */
    public final void m64780a0(String str, String str2, RevisionFinish revisionFinish) throws C9721b {
        try {
            if (this.f50739f.m63551N(this.f50740g, this.f50747n, this.f50790M, this.f50789L, str, str2, revisionFinish, this.f50741h, this.f50742i, this.f50744k, 0).getState().intValue() == 0) {
                return;
            }
            this.f50787J.update(this.f50745l.m67892j(), 0);
            this.f50745l.m67881E(0);
            throw new C9721b(3911, "resource is empty", "Backup.asset.revisions.finish");
        } catch (C9721b e10) {
            if (e10.m60659c() == 3922) {
                mo64709d();
            }
            throw e10;
        }
    }

    /* renamed from: b0 */
    public C10561k m64781b0(String str) {
        this.f50792O = str;
        return this;
    }

    /* renamed from: c0 */
    public C10561k m64782c0(String str) {
        this.f50796S = str;
        return this;
    }

    @Override // im.AbstractC10548b
    /* renamed from: d */
    public void mo64709d() throws C9721b {
        C11308a c11308a = this.f50745l;
        if (c11308a == null) {
            return;
        }
        this.f50787J.m67909a(c11308a.m67892j());
        this.f50788K.m67939b(this.f50745l.m67883a());
    }

    /* renamed from: d0 */
    public C10561k m64783d0(String str) {
        this.f50794Q = str;
        return this;
    }

    /* renamed from: e0 */
    public C10561k m64784e0(String str) {
        this.f50797T = str;
        return this;
    }

    @Override // im.AbstractC10548b
    /* renamed from: f */
    public void mo64711f() {
        super.mo64711f();
    }

    /* renamed from: f0 */
    public C10561k m64785f0(String str) {
        this.f50795R = str;
        return this;
    }

    /* renamed from: g0 */
    public C10561k m64786g0(String str) {
        this.f50793P = str;
        return this;
    }

    @Override // im.AbstractC10554e
    /* renamed from: w */
    public void mo64744w() throws C9721b {
        List<C11310c> listM67942e = this.f50788K.m67942e(this.f50745l.m67883a());
        if (!listM67942e.isEmpty()) {
            Iterator<C11310c> it = listM67942e.iterator();
            while (it.hasNext()) {
                if (it.next().m67930s() != 1) {
                    this.f50787J.update(this.f50745l.m67892j(), 0);
                    throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "params invalid, not all slice upload success.");
                }
            }
        }
        int iM67897o = this.f50745l.m67897o();
        if (iM67897o == 0) {
            this.f50787J.update(this.f50745l.m67892j(), 1);
            m64780a0(this.f50745l.m67883a(), this.f50745l.m67898p(), new RevisionFinish().setUpdateTime(new C4644l(System.currentTimeMillis())));
            this.f50787J.update(this.f50745l.m67892j(), 2);
            this.f50745l.m67881E(2);
            return;
        }
        if (iM67897o != 1) {
            return;
        }
        m64780a0(this.f50745l.m67883a(), this.f50745l.m67898p(), new RevisionFinish().setUpdateTime(new C4644l(System.currentTimeMillis())));
        this.f50787J.update(this.f50745l.m67892j(), 2);
        this.f50745l.m67881E(2);
    }
}
