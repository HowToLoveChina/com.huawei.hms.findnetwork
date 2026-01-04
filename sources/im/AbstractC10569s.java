package im;

import android.text.TextUtils;
import cm.C1457c;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.slice.LengthGetter;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.base.slice.Slices;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Cipher;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.File;
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
import hm.C10321z;
import im.AbstractC10554e;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import km.C11063a;
import mk.C11476b;
import p012ab.C0087b;
import p283fa.C9679b;
import p365ic.C10466a;
import p455ll.C11308a;
import p455ll.C11309b;
import p455ll.C11310c;
import p455ll.C11311d;
import p456lm.AbstractC11314a;
import p456lm.C11315b;
import p514o9.C11839m;
import p618rm.C12590s0;
import p652t9.EnumC12999a;
import p682ul.C13216j;
import p711vl.C13467g;
import p744wl.C13617a;
import pl.C12166h;
import pl.C12167i;

/* renamed from: im.s */
/* loaded from: classes6.dex */
public abstract class AbstractC10569s extends AbstractC10554e {

    /* renamed from: I */
    public long f50824I;

    /* renamed from: J */
    public String f50825J;

    /* renamed from: K */
    public long f50826K;

    /* renamed from: L */
    public byte[] f50827L;

    /* renamed from: M */
    public byte[] f50828M;

    /* renamed from: N */
    public C11309b f50829N;

    /* renamed from: O */
    public C11311d f50830O;

    /* renamed from: P */
    public C12167i f50831P;

    /* renamed from: Q */
    public String f50832Q;

    /* renamed from: R */
    public Map<String, String> f50833R;

    /* renamed from: S */
    public boolean f50834S;

    /* renamed from: im.s$a */
    public class a extends AbstractC11314a {

        /* renamed from: e */
        public Slice<InterfaceC10549b0> f50835e;

        /* renamed from: f */
        public C11310c f50836f;

        /* renamed from: g */
        public CountDownLatch f50837g;

        /* renamed from: h */
        public List<Long> f50838h;

        /* renamed from: i */
        public List<Long> f50839i;

        public a(Slice<InterfaceC10549b0> slice, C11310c c11310c, List<Long> list, CountDownLatch countDownLatch, List<Long> list2) {
            super(c11310c.m67926k(), 0);
            this.f50835e = slice;
            this.f50836f = c11310c;
            this.f50838h = list;
            this.f50839i = list2;
            this.f50837g = countDownLatch;
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x037a, code lost:
        
            r2 = r0;
            r7 = r8;
            r6 = r6;
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x037e, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x037f, code lost:
        
            r6 = r21;
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0381, code lost:
        
            r2 = r0;
            r7 = r8;
            r10 = r20;
            r6 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x03be, code lost:
        
            throw new fk.C9721b(com.huawei.hicloud.notification.constants.FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create FileEntity trigger illegalArgumentException: " + r0.getMessage() + " assetId = " + r1.f50836f.m67926k());
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x03bf, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x03c1, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x03c2, code lost:
        
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x03c3, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x03c4, code lost:
        
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x03e4, code lost:
        
            throw new fk.C9721b(3911, "refresh url error. objectId = " + r1.f50836f.m67928q(), "Upload");
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x0438, code lost:
        
            r1 = r7.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x0440, code lost:
        
            r2 = r1.hasNext();
            r1 = r1;
            r6 = r6;
            r7 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x0444, code lost:
        
            if (r2 != false) goto L134;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x0446, code lost:
        
            r2 = (java.io.File) ((com.huawei.hicloud.base.slice.SliceItem) r1.next()).getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x0456, code lost:
        
            if (r2.exists() != false) goto L192;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x0458, code lost:
        
            r3 = new java.lang.StringBuilder();
            r3.append("encrypt file exits, delete = ");
            r7 = r2.delete();
            r3.append(r7);
            r3.append(r6);
            r3.append(hk.C10279b.m63452a(r2));
            p514o9.C11839m.m70686d("CloudBackupV3StreamAssetUploader", r3.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0508, code lost:
        
            r1 = r7.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x0516, code lost:
        
            r3 = r1.next().getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0526, code lost:
        
            if (r3.exists() != false) goto L197;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0528, code lost:
        
            p514o9.C11839m.m70686d("CloudBackupV3StreamAssetUploader", "encrypt file exits, delete = " + r3.delete() + r6 + hk.C10279b.m63452a(r3));
         */
        /* JADX WARN: Code restructure failed: missing block: B:207:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:208:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:?, code lost:
        
            throw r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:210:?, code lost:
        
            throw r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x01d8, code lost:
        
            if (r19 == null) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x01da, code lost:
        
            r9 = r19.getUrl();
            r1.f50840j.m64717l(r9);
            r1.f50840j.m64715j();
            r10 = new java.util.ArrayList();
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x01ed, code lost:
        
            r11 = r8.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x01f9, code lost:
        
            if (r11.hasNext() == false) goto L183;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x01fb, code lost:
        
            r12 = r11.next();
            r13 = r12.getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x020b, code lost:
        
            if (r13.exists() == false) goto L184;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0215, code lost:
        
            if (r13.length() <= 0) goto L182;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0217, code lost:
        
            r10.add(new com.huawei.hms.network.file.upload.api.FileEntity(com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, r12.getObject().getName(), r12.getObject(), r12.getOffset(), r12.getLength()));
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x023e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0261, code lost:
        
            throw new fk.C9721b(com.huawei.hicloud.notification.constants.FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "create file entity file not found, file = " + r13.getName());
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0262, code lost:
        
            r14 = ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) com.huawei.hms.network.file.upload.api.UploadManager.newPutRequestBuilder().config(r1.f50840j.m64710e())).url(r9)).backupUrls(java.util.Collections.singletonList(r9))).headers(r19.getHeaders())).fileParams((java.util.List<com.huawei.hms.network.file.upload.api.FileEntity>) r10).build();
            r15 = new java.util.concurrent.CountDownLatch(1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x02a0, code lost:
        
            r20 = "slice file task error. objectId = ";
            r21 = " ,path: ";
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x02ad, code lost:
        
            r13 = new im.AbstractC10554e.b(r1.f50836f, r20, r15, r17);
            r9 = p767x9.C13735d.m82531s();
            r10 = r1.f50840j;
            r7 = r10.m64733A(r7, r10.f50736E);
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x02c4, code lost:
        
            if (r1.f50840j.f50736E.get() == false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x02c6, code lost:
        
            r10 = r1.f50839i;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x02c9, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x02ca, code lost:
        
            r2 = r0;
            r7 = r8;
            r6 = r21;
            r1 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x02d0, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x02d1, code lost:
        
            r2 = r0;
            r7 = r8;
            r6 = r21;
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x02d7, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x02d8, code lost:
        
            r2 = r0;
            r7 = r8;
            r10 = r20;
            r6 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x02e0, code lost:
        
            r10 = r1.f50838h;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x02e2, code lost:
        
            r9.m82543m(r7, r14, r10, r13);
            p514o9.C11839m.m70688i("CloudBackupV3StreamAssetUploader", "slice file task await start. objectId = " + r1.f50836f.m67928q());
            r1.f50840j.m64718m(r15);
            p514o9.C11839m.m70688i("CloudBackupV3StreamAssetUploader", "slice file task await end. objectId = " + r1.f50836f.m67928q());
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x031e, code lost:
        
            r1.f50837g.countDown();
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0327, code lost:
        
            if (r1.f50840j.f50755v == null) goto L207;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0329, code lost:
        
            r1 = r8.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0335, code lost:
        
            if (r1.hasNext() == false) goto L185;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0337, code lost:
        
            r2 = r1.next().getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0347, code lost:
        
            if (r2.exists() == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0349, code lost:
        
            r3 = new java.lang.StringBuilder();
            r3.append("encrypt file exits, delete = ");
            r3.append(r2.delete());
            r6 = r21;
            r3.append(r6);
            r3.append(hk.C10279b.m63452a(r2));
            p514o9.C11839m.m70686d("CloudBackupV3StreamAssetUploader", r3.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x036c, code lost:
        
            r6 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x036e, code lost:
        
            r21 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0371, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0372, code lost:
        
            r6 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0374, code lost:
        
            r2 = r0;
            r6 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0377, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0378, code lost:
        
            r6 = r21;
            r20 = r20;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:130:0x0436 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:134:0x0446  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x04b7 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:148:0x04c7  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x0506 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0549 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r1v13, types: [com.huawei.hicloud.cloudbackup.v3.server.model.Cipher] */
        /* JADX WARN: Type inference failed for: r1v15, types: [java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r1v8, types: [com.huawei.hicloud.cloudbackup.v3.server.model.Cipher] */
        /* JADX WARN: Type inference failed for: r20v8, types: [com.huawei.hicloud.cloudbackup.v3.server.model.RevisionRefresh] */
        /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v12 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v24 */
        /* JADX WARN: Type inference failed for: r6v25 */
        /* JADX WARN: Type inference failed for: r6v26 */
        /* JADX WARN: Type inference failed for: r6v39 */
        /* JADX WARN: Type inference failed for: r6v40 */
        /* JADX WARN: Type inference failed for: r6v41 */
        /* JADX WARN: Type inference failed for: r6v44 */
        /* JADX WARN: Type inference failed for: r6v45 */
        /* JADX WARN: Type inference failed for: r6v46 */
        /* JADX WARN: Type inference failed for: r6v47 */
        /* JADX WARN: Type inference failed for: r6v48 */
        /* JADX WARN: Type inference failed for: r6v49 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r7v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v12, types: [com.huawei.hicloud.base.slice.Slice] */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v32 */
        /* JADX WARN: Type inference failed for: r7v33 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7, types: [com.huawei.hicloud.base.slice.Slice] */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9 */
        /* JADX WARN: Type inference failed for: r9v7, types: [im.e, im.s] */
        @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1354
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: im.AbstractC10569s.a.call():void");
        }
    }

    /* renamed from: im.s$b */
    public class b implements LengthGetter<InterfaceC10549b0> {
        public b() {
        }

        @Override // com.huawei.hicloud.base.slice.LengthGetter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public long getLength(int i10, InterfaceC10549b0 interfaceC10549b0) {
            return AbstractC10569s.this.f50824I;
        }
    }

    public AbstractC10569s(String str, String str2, C10321z c10321z, C1457c c1457c, String str3, String str4, int i10, String str5, String str6, Map<String, String> map, boolean z10, String str7) {
        super(str, str2, c10321z, c1457c, str3, str4, str7);
        this.f50832Q = str5;
        this.f50833R = map;
        this.f50744k = str6;
        this.f50742i = i10;
        this.f50834S = z10;
        String strM81942x = C13617a.m81942x(str6, str, 0, i10);
        C13216j.c cVar = C13216j.c.SNAPSHOT;
        this.f50829N = new C11309b(C13216j.m79427l(cVar, strM81942x));
        this.f50830O = new C11311d(C13216j.m79427l(cVar, strM81942x));
        this.f50831P = new C12167i(str6, str, 0, i10);
    }

    /* renamed from: b0 */
    public static /* synthetic */ void m64811b0(String[] strArr, FileInputStream fileInputStream) {
        try {
            strArr[0] = C10466a.m64332w(fileInputStream);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3StreamAssetUploader", "hmacFile error: " + e10.toString());
        }
    }

    /* renamed from: c0 */
    public static /* synthetic */ void m64812c0(Md5AndHash[] md5AndHashArr, FileInputStream fileInputStream) {
        try {
            md5AndHashArr[0] = C11476b.m68624f(fileInputStream, "");
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3StreamAssetUploader", "hmacFile error: " + e10.toString());
        }
    }

    /* renamed from: d0 */
    private void m64813d0(List<Slice<InterfaceC10549b0>> list) throws C9721b {
        int i10;
        int size = this.f50754u.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        List<Long> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        List<Long> listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
        int i11 = 0;
        while (i11 < size) {
            try {
                m64715j();
                C11310c c11310c = this.f50754u.get(i11);
                if (c11310c.m67930s() == 1) {
                    this.f50753t.put(c11310c.m67928q(), Long.valueOf(c11310c.m67927p()));
                    m64740J(AbstractC10554e.c.MEDIA_IN_PROGRESS);
                    countDownLatch.countDown();
                    i10 = size;
                } else {
                    long jM75856h0 = C12590s0.m75856h0() + 629145600;
                    Long localLeftSpace = ICBUtil.getLocalLeftSpace();
                    boolean z10 = localLeftSpace == null || localLeftSpace.longValue() < jM75856h0;
                    i10 = size;
                    a aVar = new a(list.get(i11), c11310c, listSynchronizedList, countDownLatch, listSynchronizedList2);
                    C11315b.m67979c().m67981b(this, z10);
                    C11315b.m67979c().m67980a(c11310c.m67926k(), aVar);
                }
                i11++;
                size = i10;
            } catch (Throwable th2) {
                C11315b.m67979c().m67984f(this.f50745l.m67883a());
                m64742u(EnumC12999a.CLOUD_BACKUP, listSynchronizedList);
                m64742u(EnumC12999a.CLOUD_BACKUP_QUIC, listSynchronizedList2);
                m64743v(this.f50754u);
                throw th2;
            }
        }
        C11839m.m70688i("CloudBackupV3StreamAssetUploader", "syncLock await begin, file = " + this.f50825J);
        m64715j();
        m64718m(countDownLatch);
        C11839m.m70688i("CloudBackupV3StreamAssetUploader", "syncLock await end, file = " + this.f50825J);
        C11315b.m67979c().m67984f(this.f50745l.m67883a());
        m64742u(EnumC12999a.CLOUD_BACKUP, listSynchronizedList);
        m64742u(EnumC12999a.CLOUD_BACKUP_QUIC, listSynchronizedList2);
        m64743v(this.f50754u);
    }

    /* renamed from: g0 */
    private void m64814g0(String str, String str2, String str3, String str4, Md5AndHash md5AndHash) throws C9721b {
        C12166h c12166h = new C12166h();
        c12166h.m73130A(str);
        c12166h.m73148q(this.f50741h);
        c12166h.m73157z(str4);
        c12166h.m73149r(str2);
        c12166h.m73133D(str3);
        c12166h.m73131B(md5AndHash.getMD5());
        c12166h.m73132C(md5AndHash.getHash());
        c12166h.m73150s(new Gson().toJson(this.f50755v.copyCipherAndClearUid()));
        this.f50831P.m73163f(c12166h);
    }

    @Override // im.AbstractC10554e
    /* renamed from: H */
    public void mo64738H(int i10) throws C9721b {
        m64715j();
        this.f50829N.update(this.f50745l.m67892j(), 1);
        this.f50745l.m67881E(1);
    }

    @Override // im.AbstractC10554e
    /* renamed from: I */
    public void mo64739I(String str, String str2) throws C9721b {
        this.f50830O.m67943f(str, str2, 1);
    }

    /* renamed from: O */
    public FileCreate m64815O(String str, String str2, Md5AndHash md5AndHash, int i10) throws C9721b {
        FileCreate fileCreate = new FileCreate();
        String strMo64806X = mo64806X();
        if (TextUtils.isEmpty(strMo64806X)) {
            strMo64806X = FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM;
        }
        fileCreate.setBackupDeviceId(this.f50832Q).setAppPackageName(this.f50741h).setLocalPath(str).setHash(str2).setSha256(md5AndHash.getHash()).setFileSize(Long.valueOf(this.f50824I)).setMimeType(strMo64806X).setCreateTime(new C4644l(System.currentTimeMillis())).setProperties(this.f50833R).setFrequency(C13467g.m81086c().m81091f()).setIncType(i10).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION);
        if (SplitAppUtil.isSplitApp(this.f50743j)) {
            fileCreate.setSplitApkType(this.f50743j);
        }
        if (fileCreate.getFileSize().longValue() > 0) {
            return fileCreate;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file is exist:, file name: " + this.f50825J + ", file length: " + fileCreate.getFileSize());
    }

    /* renamed from: P */
    public final C11308a m64816P(String str, String str2, Md5AndHash md5AndHash) throws C9721b {
        String str3;
        Md5AndHash md5AndHash2;
        int i10;
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
        File fileM63546I = this.f50739f.m63546I(this.f50740g, this.f50832Q, this.f50744k, m64815O(str3, str2, md5AndHash2, i10), this.f50834S, 0);
        List<Attachment> attachments = fileM63546I.getAttachments();
        if (attachments.isEmpty()) {
            throw new C9721b(3911, "attachment is empty", "Backup.device.file.create");
        }
        Attachment attachment = attachments.get(0);
        if (attachment == null) {
            throw new C9721b(3911, "attachment is empty", "Backup.device.file.create");
        }
        int i11 = attachment.getState().intValue() == 0 ? 2 : fileM63546I.isMdr() ? 1 : 0;
        m64814g0(fileM63546I.getId(), attachment.getAssetId(), attachment.getVersionId(), str2, md5AndHash);
        C11308a c11308a = new C11308a();
        c11308a.m67908z(mo64804S()).m67878B(this.f50824I).m67905w(md5AndHash.getMD5()).m67906x(md5AndHash.getHash()).m67907y(str2).m67881E(i11).m67877A(this.f50747n).m67879C(fileM63546I.getId()).m67899q(attachment.getAssetId()).m67882F(attachment.getVersionId()).m67880D(attachment.getSliceSize()).m67900r(new C4644l(System.currentTimeMillis()).toString()).m67901s(String.valueOf(this.f50826K));
        this.f50829N.m67914f(c11308a);
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
            this.f50830O.m67938a(this.f50754u);
        }
        return c11308a;
    }

    /* renamed from: Q */
    public Slice<java.io.File> m64817Q(String str, Slice<InterfaceC10549b0> slice) throws Exception {
        C11839m.m70686d("CloudBackupV3StreamAssetUploader", "encrypt file slice start. objectId = " + str);
        ArrayList arrayList = new ArrayList();
        long length = 0;
        for (final SliceItem<InterfaceC10549b0> sliceItem : slice.getSliceItems()) {
            final java.io.File fileM63441g = C10278a.m63441g(this.f50749p, str);
            try {
                sliceItem.getObject().mo64722b(new Consumer() { // from class: im.p
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) throws IOException {
                        this.f50819a.m64823a0(sliceItem, fileM63441g, (FileInputStream) obj);
                    }
                }, this.f50826K, this.f50824I);
                SliceItem sliceItem2 = new SliceItem(fileM63441g, sliceItem.getIndex(), 0L, fileM63441g.length());
                length += sliceItem2.getLength();
                arrayList.add(sliceItem2);
            } catch (Exception e10) {
                ICBUtil.checkDataLocalLimitSpace("encrypt file slice local size not enough left space: ");
                throw e10;
            }
        }
        C11839m.m70686d("CloudBackupV3StreamAssetUploader", "encrypt file slice end. objectId = " + str);
        return new Slice<>(arrayList, length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Type inference failed for: r0v25, types: [rm.t] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v7, types: [rm.t] */
    /* JADX WARN: Type inference failed for: r1v4, types: [rm.t] */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p455ll.C11308a m64818R(int r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: im.AbstractC10569s.m64818R(int):ll.a");
    }

    /* renamed from: S */
    public abstract String mo64804S();

    /* renamed from: T */
    public Cipher m64819T(String str) throws BadPaddingException, IllegalBlockSizeException, C9721b {
        UserKeyObject userKeyObjectM680c = C10028c.m62182c0().m62329g0() ? new C0087b(C9679b.m60452d().m60455e()).m680c(this.f50746m, 19, UserKeyBaseReq.KEY_TYPE_AES_128) : UserKeyUtils.getInstance().getSyncUser(19, this.f50746m);
        byte[] userKey = userKeyObjectM680c.getUserKey();
        this.f50827L = C11476b.m68628j(str.substring(0, str.length() / 2));
        this.f50828M = C11476b.m68628j(str.substring(str.length() / 2));
        String strM64318i = C10466a.m64318i(C11476b.m68619a(this.f50827L), userKey, C10466a.m64328s());
        ArrayList arrayList = new ArrayList();
        Cipher.KeyChain keyChain = new Cipher.KeyChain();
        keyChain.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL).setEkey(strM64318i).setId(userKeyObjectM680c.getUserKeyGuid()).setType(1);
        arrayList.add(keyChain);
        Cipher cipher = new Cipher();
        cipher.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL).setDataType(19).setIv(C11476b.m68619a(this.f50828M)).setKeyChains(arrayList);
        return cipher;
    }

    /* renamed from: U */
    public abstract InterfaceC10549b0 mo64805U();

    /* renamed from: V */
    public final void m64820V(final String[] strArr) throws C9721b {
        InterfaceC10549b0 interfaceC10549b0Mo64805U = mo64805U();
        if (interfaceC10549b0Mo64805U == null) {
            throw new C9721b(4004, "hmacFile fail: supplier is null.");
        }
        interfaceC10549b0Mo64805U.mo64722b(new Consumer() { // from class: im.q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AbstractC10569s.m64811b0(strArr, (FileInputStream) obj);
            }
        }, this.f50826K, this.f50824I);
        if (TextUtils.isEmpty(strArr[0])) {
            throw new C9721b(4004, "hmacFile fail.");
        }
    }

    /* renamed from: W */
    public final void m64821W(final Md5AndHash[] md5AndHashArr) throws C9721b {
        InterfaceC10549b0 interfaceC10549b0Mo64805U = mo64805U();
        if (interfaceC10549b0Mo64805U == null) {
            throw new C9721b(404, "getMd5AndHash fail: supplier is null.");
        }
        interfaceC10549b0Mo64805U.mo64722b(new Consumer() { // from class: im.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AbstractC10569s.m64812c0(md5AndHashArr, (FileInputStream) obj);
            }
        }, this.f50826K, this.f50824I);
        if (md5AndHashArr[0] == null) {
            throw new C9721b(404, "getMd5AndHash fail.");
        }
    }

    /* renamed from: X */
    public abstract String mo64806X();

    /* renamed from: Y */
    public abstract String mo64807Y(String str);

    /* renamed from: Z */
    public long m64822Z(List<Slice<InterfaceC10549b0>> list) {
        Iterator<Slice<InterfaceC10549b0>> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += ((it.next().getLength() / 16) * 16) + 16;
        }
        return length;
    }

    /* renamed from: a0 */
    public final /* synthetic */ void m64823a0(SliceItem sliceItem, java.io.File file, FileInputStream fileInputStream) throws IOException {
        try {
            C10466a.m64322m(fileInputStream, sliceItem.getOffset(), sliceItem.getLength(), file, this.f50827L, this.f50828M);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3StreamAssetUploader", "encryptSliceFileStream error: " + e10.toString());
        }
    }

    @Override // im.AbstractC10548b
    /* renamed from: d */
    public void mo64709d() throws C9721b {
        C11308a c11308a = this.f50745l;
        if (c11308a == null) {
            return;
        }
        this.f50829N.m67909a(c11308a.m67892j());
        this.f50830O.m67939b(this.f50745l.m67883a());
    }

    /* renamed from: e0 */
    public C11308a m64824e0() throws C9721b, NoSuchAlgorithmException, InvalidKeyException {
        C11839m.m70688i("CloudBackupV3StreamAssetUploader", "file upload prepare start." + this.f50825J);
        if (this.f50824I <= 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, this.f50825J + ", file length: " + this.f50824I);
        }
        String[] strArr = {null};
        m64820V(strArr);
        this.f50755v = m64819T(strArr[0]);
        String strM64330u = C10466a.m64330u(strArr[0]);
        Md5AndHash[] md5AndHashArr = {null};
        m64821W(md5AndHashArr);
        String strMo64804S = mo64804S();
        String strMo64807Y = mo64807Y(strMo64804S);
        C11308a c11308aM67912d = this.f50829N.m67912d(strMo64804S);
        if (c11308aM67912d == null) {
            c11308aM67912d = m64816P(strMo64807Y, strM64330u, md5AndHashArr[0]);
        } else {
            List<C11310c> listM67942e = this.f50830O.m67942e(c11308aM67912d.m67883a());
            if (listM67942e.isEmpty()) {
                this.f50829N.m67909a(strMo64804S);
                c11308aM67912d = m64816P(strMo64807Y, strM64330u, md5AndHashArr[0]);
            } else if (md5AndHashArr[0].getHash().equals(c11308aM67912d.m67890h()) && strM64330u.equals(c11308aM67912d.m67891i()) && m64734B(c11308aM67912d)) {
                this.f50754u.addAll(listM67942e);
            } else {
                C11839m.m70688i("CloudBackupV3StreamAssetUploader", "file content changed." + this.f50825J);
                m64743v(listM67942e);
                this.f50830O.m67939b(c11308aM67912d.m67883a());
                this.f50829N.m67909a(strMo64804S);
                c11308aM67912d = m64816P(strMo64807Y, strM64330u, md5AndHashArr[0]);
            }
        }
        if (c11308aM67912d.m67897o() != 0) {
            Iterator<C11310c> it = this.f50754u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().m67930s() != 1) {
                    this.f50829N.update(c11308aM67912d.m67892j(), 0);
                    c11308aM67912d.m67881E(0);
                    break;
                }
            }
        }
        Collections.sort(this.f50754u);
        C11839m.m70688i("CloudBackupV3StreamAssetUploader", "file upload prepare end." + this.f50825J);
        return c11308aM67912d;
    }

    /* renamed from: f0 */
    public void m64825f0() throws C9721b {
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

    /* renamed from: h0 */
    public AbstractC10569s m64826h0(InterfaceC10570t interfaceC10570t) {
        this.f50733B = interfaceC10570t;
        return this;
    }

    /* renamed from: i0 */
    public AbstractC10569s m64827i0(boolean z10) {
        this.f50757x = z10;
        return this;
    }

    /* renamed from: j0 */
    public final List<Slice<InterfaceC10549b0>> m64828j0() throws C9721b {
        m64715j();
        ArrayList arrayList = new ArrayList(Collections.singleton(mo64805U()));
        Slices slices = new Slices();
        C11063a c11063a = new C11063a(arrayList, new b());
        while (c11063a.m66676a()) {
            slices.increase(c11063a.m66677b(this.f50745l.m67896n()));
        }
        List<Slice<InterfaceC10549b0>> slices2 = slices.getSlices();
        C9720a.m60652a(this.f50754u.size() == slices2.size(), "slices do not match server.");
        return slices2;
    }

    /* renamed from: k0 */
    public final boolean m64829k0() {
        InterfaceC10549b0 interfaceC10549b0Mo64805U = mo64805U();
        if (interfaceC10549b0Mo64805U == null) {
            C11839m.m70687e("CloudBackupV3StreamAssetUploader", "uploadFinishCheckChange supplier is null");
            return true;
        }
        try {
            return interfaceC10549b0Mo64805U.mo64721a(this.f50826K, this.f50824I, this.f50745l.m67890h());
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3StreamAssetUploader", "uploadFinishCheckChange " + e10.getMessage());
            return true;
        }
    }

    @Override // im.AbstractC10554e
    /* renamed from: w */
    public void mo64744w() throws C9721b {
        List<C11310c> listM67942e = this.f50830O.m67942e(this.f50745l.m67883a());
        if (!listM67942e.isEmpty()) {
            Iterator<C11310c> it = listM67942e.iterator();
            while (it.hasNext()) {
                if (it.next().m67930s() != 1) {
                    this.f50829N.update(this.f50745l.m67892j(), 0);
                    throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "params invalid, not all slice upload success.");
                }
            }
        }
        boolean zM64829k0 = m64829k0();
        C11839m.m70686d("CloudBackupV3StreamAssetUploader", "check file hash: " + this.f50825J + " change " + zM64829k0);
        if (zM64829k0) {
            if (!this.f50758y) {
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "hash check invalid, file changed, file: " + mo64804S());
            }
            this.f50732A = true;
        }
        int iM67897o = this.f50745l.m67897o();
        if (iM67897o == 0) {
            m64825f0();
            this.f50829N.update(this.f50745l.m67892j(), 1);
        } else if (iM67897o == 1 || iM67897o == 2) {
            m64825f0();
        }
    }
}
