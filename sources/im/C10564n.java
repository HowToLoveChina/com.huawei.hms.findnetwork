package im;

import android.text.TextUtils;
import cm.C1457c;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.CompressionPolicyUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Cipher;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Resource;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionRefresh;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import fk.C9720a;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import jm.C10899b;
import jm.C10900c;
import mk.C11476b;
import p012ab.C0087b;
import p283fa.C9679b;
import p365ic.C10466a;
import p371ik.C10527a;
import p455ll.C11308a;
import p455ll.C11309b;
import p455ll.C11310c;
import p455ll.C11311d;
import p495nm.C11728i;
import p495nm.C11729j;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p682ul.C13216j;
import p711vl.C13467g;
import p744wl.C13617a;
import p815ym.AbstractC14026a;
import p818yp.C14034a;
import pl.C12166h;
import pl.C12167i;

/* renamed from: im.n */
/* loaded from: classes6.dex */
public class C10564n extends AbstractC10558h {

    /* renamed from: J */
    public C11309b f50806J;

    /* renamed from: K */
    public C11311d f50807K;

    /* renamed from: L */
    public C12167i f50808L;

    /* renamed from: M */
    public String f50809M;

    /* renamed from: N */
    public Map<String, String> f50810N;

    /* renamed from: O */
    public byte[] f50811O;

    /* renamed from: P */
    public byte[] f50812P;

    /* renamed from: Q */
    public boolean f50813Q;

    /* renamed from: R */
    public final C4879a f50814R;

    /* renamed from: S */
    public C10899b f50815S;

    /* renamed from: T */
    public final C11728i f50816T;

    /* renamed from: U */
    public C10900c f50817U;

    public C10564n(String str, int i10, String str2, C10321z c10321z, String str3, String str4, C4879a c4879a, File file, Map<String, String> map, boolean z10, C11728i c11728i, String str5) {
        super(str, str2, c10321z, c4879a.m29728n0(), "File", CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, file, str5);
        this.f50809M = str3;
        this.f50810N = map;
        this.f50744k = str4;
        this.f50742i = i10;
        this.f50814R = c4879a;
        this.f50813Q = z10;
        String strM81942x = C13617a.m81942x(str4, str, 0, i10);
        C13216j.c cVar = C13216j.c.SNAPSHOT;
        this.f50806J = new C11309b(C13216j.m79427l(cVar, strM81942x));
        this.f50807K = new C11311d(C13216j.m79427l(cVar, strM81942x));
        this.f50808L = new C12167i(str4, str, 0, i10);
        this.f50816T = c11728i;
    }

    /* renamed from: e0 */
    private Cipher m64790e0(String str) throws BadPaddingException, IllegalBlockSizeException, C9721b {
        UserKeyObject userKeyObjectM680c = C10028c.m62182c0().m62329g0() ? new C0087b(C9679b.m60452d().m60455e()).m680c(this.f50746m, 19, UserKeyBaseReq.KEY_TYPE_AES_128) : UserKeyUtils.getInstance().getSyncUser(19, this.f50746m);
        byte[] userKey = userKeyObjectM680c.getUserKey();
        this.f50811O = C11476b.m68628j(str.substring(0, str.length() / 2));
        this.f50812P = C11476b.m68628j(str.substring(str.length() / 2));
        String strM64318i = C10466a.m64318i(C11476b.m68619a(this.f50811O), userKey, C10466a.m64328s());
        ArrayList arrayList = new ArrayList();
        Cipher.KeyChain keyChain = new Cipher.KeyChain();
        keyChain.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL).setEkey(strM64318i).setId(userKeyObjectM680c.getUserKeyGuid()).setType(1);
        arrayList.add(keyChain);
        Cipher cipher = new Cipher();
        cipher.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL).setDataType(19).setIv(C11476b.m68619a(this.f50812P)).setKeyChains(arrayList);
        return cipher;
    }

    @Override // im.AbstractC10554e
    /* renamed from: H */
    public void mo64738H(int i10) throws C9721b {
        m64715j();
        this.f50806J.update(this.f50745l.m67892j(), 1);
        this.f50745l.m67881E(1);
    }

    @Override // im.AbstractC10554e
    /* renamed from: I */
    public void mo64739I(String str, String str2) throws C9721b {
        this.f50807K.m67943f(str, str2, 1);
    }

    @Override // im.AbstractC10558h
    /* renamed from: L */
    public Slice<File> mo64762L(String str, Slice<File> slice) throws Exception {
        C11839m.m70686d("CloudBackupV3FileUploader", "encrypt file slice start. objectId = " + str);
        ArrayList arrayList = new ArrayList();
        long length = 0;
        for (SliceItem<File> sliceItem : slice.getSliceItems()) {
            File fileM63441g = C10278a.m63441g(this.f50749p, str);
            try {
                C10466a.m64321l(sliceItem.getObject(), sliceItem.getOffset(), sliceItem.getLength(), fileM63441g, this.f50811O, this.f50812P);
                SliceItem sliceItem2 = new SliceItem(fileM63441g, sliceItem.getIndex(), 0L, fileM63441g.length());
                length += sliceItem2.getLength();
                arrayList.add(sliceItem2);
            } catch (Exception e10) {
                m64794b0(e10);
                throw e10;
            }
        }
        C11839m.m70686d("CloudBackupV3FileUploader", "encrypt file slice end. objectId = " + str);
        return new Slice<>(arrayList, length);
    }

    @Override // im.AbstractC10558h
    /* renamed from: N */
    public long mo64764N(List<Slice<File>> list) {
        Iterator<Slice<File>> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += ((it.next().getLength() / 16) * 16) + 16;
        }
        return length;
    }

    @Override // im.AbstractC10558h
    /* renamed from: P */
    public File mo64766P() {
        if (!m64802k0()) {
            C11839m.m70688i("CloudBackupV3FileUploader", "get normal file:" + this.f50775I.getName());
            return this.f50775I;
        }
        C11839m.m70688i("CloudBackupV3FileUploader", "get compressed file from sparseHandler:" + this.f50775I.getName() + ",fileSize:" + this.f50815S.m65917m().length());
        return this.f50815S.m65917m();
    }

    @Override // im.AbstractC10558h
    /* renamed from: R */
    public C11308a mo64768R(File file) throws C9721b, NoSuchAlgorithmException, InvalidKeyException {
        C11839m.m70688i("CloudBackupV3FileUploader", "file upload prepare start." + file.getName());
        if (!file.exists() || file.length() <= 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, file.getName() + " file is exist:" + file.exists() + ", file length: " + file.length());
        }
        String strM64331v = C10466a.m64331v(file);
        this.f50755v = m64790e0(strM64331v);
        String strM64330u = C10466a.m64330u(strM64331v);
        Md5AndHash md5AndHashM75989n = C12594t1.m75989n(file, file, this.f50741h);
        m64793Z(file, md5AndHashM75989n);
        if (m64797f0() && m64798g0(file)) {
            C11839m.m70688i("CloudBackupV3FileUploader", "hasCompressedFile and need normalUpload:" + file.getName());
            m64791X(this.f50806J.m67912d(C10279b.m63452a(file)));
            m64796d0();
        }
        String strM63452a = C10279b.m63452a(file);
        String strM75665a = C12583q.m75665a(strM63452a, 0, this.f50742i);
        C11308a c11308aM67912d = this.f50806J.m67912d(strM63452a);
        if (c11308aM67912d != null) {
            if (!TextUtils.isEmpty(c11308aM67912d.m67886d()) && !m64797f0()) {
                C11839m.m70688i("CloudBackupV3FileUploader", "already file.create,no compressed file.");
                m64792Y(file);
            }
            String strM67886d = c11308aM67912d.m67886d();
            C11839m.m70686d("CloudBackupV3FileUploader", "compressedFileInfo:" + strM67886d);
            if (((C11729j) C10527a.m64629g(strM67886d, C11729j.class)) != null && m64798g0(file)) {
                C11839m.m70688i("CloudBackupV3FileUploader", "already file.create by compress encoding,need normal upload.");
                m64791X(c11308aM67912d);
            }
        } else if (m64797f0()) {
            C11839m.m70688i("CloudBackupV3FileUploader", "hasCompressedFile but no data in t_asset_status.");
            m64796d0();
        }
        if (this.f50817U != null && !m64798g0(file)) {
            this.f50817U.mo65909e();
        }
        if (c11308aM67912d == null) {
            c11308aM67912d = m64795c0(file, strM75665a, strM64330u, md5AndHashM75989n);
        } else {
            List<C11310c> listM67942e = this.f50807K.m67942e(c11308aM67912d.m67883a());
            if (listM67942e.isEmpty() || this.f50813Q) {
                this.f50806J.m67909a(strM63452a);
                c11308aM67912d = m64795c0(file, strM75665a, strM64330u, md5AndHashM75989n);
            } else if (md5AndHashM75989n.getHash().equals(c11308aM67912d.m67890h()) && strM64330u.equals(c11308aM67912d.m67891i()) && m64734B(c11308aM67912d)) {
                this.f50754u.addAll(listM67942e);
            } else {
                C11839m.m70688i("CloudBackupV3FileUploader", "file content changed." + file.getName());
                m64743v(listM67942e);
                this.f50807K.m67939b(c11308aM67912d.m67883a());
                this.f50806J.m67909a(strM63452a);
                c11308aM67912d = m64795c0(file, strM75665a, strM64330u, md5AndHashM75989n);
            }
        }
        if (c11308aM67912d.m67897o() != 0) {
            Iterator<C11310c> it = this.f50754u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().m67930s() != 1) {
                    this.f50806J.update(c11308aM67912d.m67892j(), 0);
                    c11308aM67912d.m67881E(0);
                    break;
                }
            }
        }
        Collections.sort(this.f50754u);
        C11839m.m70688i("CloudBackupV3FileUploader", "file upload prepare end." + file.getName());
        return c11308aM67912d;
    }

    @Override // im.AbstractC10558h
    /* renamed from: W */
    public List<Slice<File>> mo64773W() throws C9721b {
        m64715j();
        List<Slice<File>> listM64765O = m64765O();
        if (this.f50754u.size() != listM64765O.size()) {
            C11839m.m70687e("CloudBackupV3FileUploader", "client slices do not match server while compressed upload.");
            mo64709d();
        }
        C9720a.m60652a(this.f50754u.size() == listM64765O.size(), "slices do not match server,serverSliceSize:" + this.f50754u.size() + ",clientSliceSize:" + listM64765O.size());
        return listM64765O;
    }

    /* renamed from: X */
    public void m64791X(C11308a c11308a) throws C9721b {
        if (c11308a == null) {
            C11839m.m70688i("CloudBackupV3FileUploader", "v3Asset is null.");
            return;
        }
        C11839m.m70686d("CloudBackupV3FileUploader", "v3Asset.getId is:" + c11308a.m67892j() + ",assetId:" + c11308a.m67883a());
        this.f50806J.m67909a(c11308a.m67892j());
        this.f50807K.m67939b(c11308a.m67883a());
    }

    /* renamed from: Y */
    public final void m64792Y(File file) {
        C11728i c11728i = this.f50816T;
        if (c11728i == null || file == null) {
            return;
        }
        c11728i.m69974a(file.getPath());
    }

    /* renamed from: Z */
    public final void m64793Z(File file, Md5AndHash md5AndHash) {
        if (file == null || md5AndHash == null) {
            C11839m.m70687e("CloudBackupV3FileUploader", "file or md5AndHash is null");
            return;
        }
        this.f50815S = new C10899b(this.f50741h, file);
        C11728i c11728i = this.f50816T;
        if (c11728i == null) {
            C11839m.m70688i("CloudBackupV3FileUploader", "mCompressParams is null,no need to compress." + file.getName());
            m64796d0();
            return;
        }
        if (!c11728i.m69978e()) {
            C11839m.m70688i("CloudBackupV3FileUploader", "server or feature gray switch not support encoding sparse.");
            m64796d0();
            return;
        }
        if (this.f50816T.m69975b() == null) {
            C11839m.m70688i("CloudBackupV3FileUploader", "no compression policy:" + this.f50741h);
            m64796d0();
            return;
        }
        String strM70648l = C11835i.m70648l(this.f50775I);
        long length = file.length();
        if (CompressionPolicyUtil.getEncodingConfig(this.f50816T.m69975b(), strM70648l, length) == null) {
            C11839m.m70688i("CloudBackupV3FileUploader", "encoding policy not match:" + this.f50741h + ",file:" + file.getName() + ",fileSize:" + length);
            m64796d0();
            return;
        }
        if (AbstractC14026a.m84159a(this.f50816T.m69975b().getProcessStep())) {
            C11839m.m70688i("CloudBackupV3FileUploader", "processStep is empty:" + this.f50741h);
            m64796d0();
            return;
        }
        C10900c c10900c = new C10900c(this.f50816T.m69975b(), this.f50741h, file, md5AndHash.getHash());
        this.f50817U = c10900c;
        c10900c.m65915k(this.f50746m);
        this.f50817U.m65912h(this.f50816T);
        C10899b c10899b = new C10899b(this.f50816T.m69975b(), this.f50741h, file, md5AndHash.getHash());
        this.f50815S = c10899b;
        c10899b.m65912h(this.f50816T);
        this.f50817U.m65913i(this.f50815S);
    }

    /* renamed from: a0 */
    public FileCreate mo64787a0(String str, String str2, Md5AndHash md5AndHash, int i10) throws C9721b {
        FileCreate fileCreate = new FileCreate();
        String strM84169f = C14034a.m84169f(this.f50775I);
        if (TextUtils.isEmpty(strM84169f)) {
            strM84169f = FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM;
        }
        fileCreate.setBackupDeviceId(this.f50809M).setAppPackageName(this.f50741h).setLocalPath(str).setHash(str2).setSha256(md5AndHash.getHash()).setFileSize(Long.valueOf(this.f50775I.length())).setMimeType(strM84169f).setCreateTime(new C4644l(System.currentTimeMillis())).setProperties(this.f50810N).setFrequency(C13467g.m81086c().m81091f()).setIncType(i10).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION);
        if (m64802k0()) {
            C11839m.m70688i("CloudBackupV3FileUploader", "build file.create param,need backup spare file:" + this.f50775I.getName());
            fileCreate.setCompressedSize(Long.valueOf(this.f50815S.m65917m().length()));
            fileCreate.setEncoding("sparse");
            fileCreate.setCipher(this.f50755v);
        }
        if (SplitAppUtil.isSplitApp(this.f50743j)) {
            fileCreate.setSplitApkType(this.f50743j);
        }
        if (fileCreate.getFileSize().longValue() > 0) {
            return fileCreate;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file is exist:" + this.f50775I.exists() + ", file name: " + this.f50775I.getName() + ", file length: " + fileCreate.getFileSize());
    }

    /* renamed from: b0 */
    public final void m64794b0(Exception exc) throws C9721b {
        ICBUtil.checkDataLocalLimitSpace("encrypt file slice local size not enough left space: ");
        String message = exc.getMessage();
        if (message == null || !message.contains("ENOSPC")) {
            return;
        }
        long jM75856h0 = C12590s0.m75856h0();
        if (jM75856h0 <= 0) {
            jM75856h0 = 100000000;
        }
        C12590s0.m75777N2(jM75856h0);
        throw new C9721b(1007, "write error:" + exc.getMessage(), "encrypt");
    }

    /* renamed from: c0 */
    public final C11308a m64795c0(File file, String str, String str2, Md5AndHash md5AndHash) throws C9721b {
        String str3;
        Md5AndHash md5AndHash2;
        int i10;
        C11839m.m70688i("CloudBackupV3FileUploader", "file.create start:" + file.getName());
        C1457c c1457c = this.f50740g;
        if (c1457c == null || !c1457c.m8338l()) {
            str3 = str;
            md5AndHash2 = md5AndHash;
            i10 = 1;
        } else {
            str3 = str;
            md5AndHash2 = md5AndHash;
            i10 = 0;
        }
        com.huawei.hicloud.cloudbackup.p104v3.server.model.File fileM63546I = this.f50739f.m63546I(this.f50740g, this.f50809M, this.f50744k, mo64787a0(str3, str2, md5AndHash2, i10), this.f50813Q, 0);
        List<Attachment> attachments = fileM63546I.getAttachments();
        if (attachments.isEmpty()) {
            throw new C9721b(3911, "attachment is empty", "Backup.device.file.create");
        }
        Attachment attachment = attachments.get(0);
        if (attachment == null) {
            throw new C9721b(3911, "attachment is empty", "Backup.device.file.create");
        }
        int i11 = attachment.getState().intValue() == 0 ? 2 : fileM63546I.isMdr() ? 1 : 0;
        m64803m0(fileM63546I.getId(), attachment.getAssetId(), attachment.getVersionId(), str2, md5AndHash);
        C11308a c11308a = new C11308a();
        c11308a.m67908z(C10279b.m63452a(file)).m67878B(file.length()).m67905w(md5AndHash.getMD5()).m67906x(md5AndHash.getHash()).m67907y(str2).m67881E(i11).m67877A(this.f50747n).m67879C(fileM63546I.getId()).m67899q(attachment.getAssetId()).m67882F(attachment.getVersionId()).m67880D(attachment.getSliceSize()).m67900r(new C4644l(System.currentTimeMillis()).toString()).m67901s(String.valueOf(file.lastModified()));
        if (m64802k0()) {
            C11729j c11729j = new C11729j();
            File fileM65917m = this.f50815S.m65917m();
            Md5AndHash md5AndHashM68622d = C11476b.m68622d(this.f50815S.m65917m());
            c11729j.m69986d(fileM65917m.length());
            c11729j.m69989g(String.valueOf(fileM65917m.lastModified()));
            c11729j.m69988f(md5AndHashM68622d.getHash());
            c11729j.m69987e("sparse");
            c11308a.m67902t(C10527a.m64633k(c11729j));
        }
        this.f50806J.m67914f(c11308a);
        if (attachment.getState().intValue() != 0) {
            List<Resource.SliceObject> objects = attachment.getObjects();
            if (objects == null || objects.isEmpty()) {
                throw new C9721b(3911, "objects is empty", "Backup.device.file.create");
            }
            int i12 = i11 != 1 ? 0 : 1;
            for (Resource.SliceObject sliceObject : objects) {
                C11310c c11310c = new C11310c();
                c11310c.m67936y(attachment.getAssetId()).m67916B(sliceObject.getId()).m67915A(sliceObject.getNumber().intValue()).m67918D(i12).m67917C(sliceObject.getStart().longValue()).m67937z(sliceObject.getLength().longValue());
                this.f50754u.add(c11310c);
            }
            this.f50807K.m67938a(this.f50754u);
        }
        return c11308a;
    }

    @Override // im.AbstractC10548b
    /* renamed from: d */
    public void mo64709d() throws C9721b {
        C11308a c11308a = this.f50745l;
        if (c11308a == null) {
            C11839m.m70688i("CloudBackupV3FileUploader", "status is null.");
        } else {
            this.f50806J.m67909a(c11308a.m67892j());
            this.f50807K.m67939b(this.f50745l.m67883a());
        }
    }

    /* renamed from: d0 */
    public final void m64796d0() {
        if (this.f50815S == null) {
            this.f50815S = new C10899b(this.f50741h, this.f50775I);
        }
        File fileM65917m = this.f50815S.m65917m();
        if (fileM65917m == null || !fileM65917m.exists()) {
            return;
        }
        boolean zDelete = fileM65917m.delete();
        C11839m.m70688i("CloudBackupV3FileUploader", "delete compressed file:" + zDelete);
        if (zDelete) {
            this.f50815S.m65918n(null);
        }
    }

    @Override // im.AbstractC10548b
    /* renamed from: f */
    public void mo64711f() {
        super.mo64711f();
    }

    /* renamed from: f0 */
    public final boolean m64797f0() {
        C10899b c10899b = this.f50815S;
        boolean z10 = (c10899b == null || c10899b.m65917m() == null || !C11835i.m70650n(this.f50815S.m65917m())) ? false : true;
        C11839m.m70688i("CloudBackupV3FileUploader", this.f50775I.getName() + " hasCompressedFile:" + z10);
        return z10;
    }

    /* renamed from: g0 */
    public final boolean m64798g0(File file) {
        C11728i c11728i = this.f50816T;
        if (c11728i == null || file == null) {
            return false;
        }
        return c11728i.m69977d(file.getPath());
    }

    /* renamed from: h0 */
    public final boolean m64799h0(C11729j c11729j) throws C9721b {
        boolean zEquals;
        if (!m64802k0()) {
            zEquals = C11476b.m68622d(this.f50775I).getHash().equals(this.f50745l.m67890h());
        } else {
            if (c11729j == null) {
                C11839m.m70687e("CloudBackupV3FileUploader", "compressedFileInfo is null.");
                return true;
            }
            zEquals = C11476b.m68622d(this.f50815S.m65917m()).getHash().equals(c11729j.m69984b());
        }
        return !zEquals;
    }

    /* renamed from: i0 */
    public final boolean m64800i0(C11729j c11729j) {
        if (!m64802k0()) {
            return this.f50775I.length() != this.f50745l.m67894l();
        }
        if (c11729j != null) {
            return this.f50815S.m65917m().length() != c11729j.m69983a();
        }
        C11839m.m70687e("CloudBackupV3FileUploader", "compressedFileInfo is null.");
        return true;
    }

    /* renamed from: j0 */
    public final boolean m64801j0(C11729j c11729j) {
        if (!m64802k0()) {
            return !String.valueOf(this.f50775I.lastModified()).equals(this.f50745l.m67885c());
        }
        if (c11729j != null) {
            return !String.valueOf(this.f50815S.m65917m().lastModified()).equals(c11729j.m69985c());
        }
        C11839m.m70687e("CloudBackupV3FileUploader", "compressedFileInfo is null.");
        return true;
    }

    /* renamed from: k0 */
    public final boolean m64802k0() {
        if (!m64798g0(this.f50775I)) {
            return m64797f0();
        }
        C11839m.m70688i("CloudBackupV3FileUploader", "force normal upload:" + this.f50775I.getName());
        return false;
    }

    /* renamed from: l0 */
    public void mo64788l0() throws C9721b {
        RevisionRefresh revisionRefresh = new RevisionRefresh();
        revisionRefresh.setCipher(this.f50755v);
        Resource resource = m64736F("id,state,resource(id,state)", this.f50747n, this.f50745l.m67895m(), this.f50745l.m67883a(), this.f50745l.m67898p(), null, revisionRefresh).getResource();
        if (resource == null) {
            throw new C9721b(3911, "asset resource is empty", "Backup.asset.revisions.refresh");
        }
        if (resource.getState().intValue() == 0) {
            return;
        }
        mo64709d();
        throw new C9721b(3911, "resource is invalid", "Backup.asset.revisions.refresh");
    }

    /* renamed from: m0 */
    public final void m64803m0(String str, String str2, String str3, String str4, Md5AndHash md5AndHash) throws C9721b {
        C12166h c12166h = new C12166h();
        c12166h.m73130A(str);
        c12166h.m73148q(this.f50741h);
        c12166h.m73157z(str4);
        c12166h.m73149r(str2);
        c12166h.m73133D(str3);
        c12166h.m73131B(md5AndHash.getMD5());
        c12166h.m73132C(md5AndHash.getHash());
        c12166h.m73150s(new Gson().toJson(this.f50755v.copyCipherAndClearUid()));
        this.f50808L.m73163f(c12166h);
    }

    @Override // im.AbstractC10554e
    /* renamed from: w */
    public void mo64744w() throws C9721b {
        List<C11310c> listM67942e = this.f50807K.m67942e(this.f50745l.m67883a());
        boolean zM64799h0 = false;
        if (!listM67942e.isEmpty()) {
            Iterator<C11310c> it = listM67942e.iterator();
            while (it.hasNext()) {
                if (it.next().m67930s() != 1) {
                    this.f50806J.update(this.f50745l.m67892j(), 0);
                    throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "params invalid, not all slice upload success.");
                }
            }
        }
        String strM67886d = this.f50745l.m67886d();
        C11839m.m70686d("CloudBackupV3FileUploader", "compressedFileInfo:" + strM67886d);
        C11729j c11729j = (C11729j) C10527a.m64629g(strM67886d, C11729j.class);
        boolean zM64801j0 = m64801j0(c11729j);
        boolean zM64800i0 = m64800i0(c11729j);
        C11839m.m70686d("CloudBackupV3FileUploader", "check file hash: " + this.f50775I.getName() + " , modifyTimeChanged: " + zM64801j0 + ", lengthChanged: " + zM64800i0);
        if (zM64801j0 || zM64800i0) {
            String strM63452a = C10279b.m63452a(this.f50775I);
            try {
                zM64799h0 = m64799h0(c11729j);
                C11839m.m70688i("CloudBackupV3FileUploader", "check file changed, file: " + strM63452a + " , modifyTimeChanged: " + zM64801j0 + ", lengthChanged: " + zM64800i0 + ", hashChanged: " + zM64799h0 + ", isRetry: " + this.f50758y);
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3FileUploader", "check file hash error, " + e10.toString());
            }
            boolean z10 = this.f50758y;
            if (!z10 && zM64799h0) {
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "hash check invalid, file changed, file: " + strM63452a + " , modifyTimeChanged: " + zM64801j0 + ", lengthChanged: " + zM64800i0);
            }
            if (z10 && zM64799h0) {
                this.f50732A = true;
            }
        }
        int iM67897o = this.f50745l.m67897o();
        if (iM67897o == 0) {
            mo64788l0();
            this.f50806J.update(this.f50745l.m67892j(), 1);
        } else if (iM67897o == 1 || iM67897o == 2) {
            mo64788l0();
        }
        if (m64797f0()) {
            C11839m.m70688i("CloudBackupV3FileUploader", "sparse file upload end,delete sparse file:" + this.f50815S.m65917m().delete());
        }
        C11728i c11728i = this.f50816T;
        if (c11728i == null || !c11728i.m69977d(this.f50775I.getPath())) {
            return;
        }
        C11839m.m70686d("CloudBackupV3FileUploader", "remove file from force normal upload list:" + this.f50775I.getPath());
        this.f50816T.m69979f(this.f50775I.getPath());
    }
}
