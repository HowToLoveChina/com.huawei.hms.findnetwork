package im;

import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.base.slice.FileLengthGetter;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.Slices;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Resource;
import fk.C9720a;
import fk.C9721b;
import hm.C10321z;
import im.AbstractC10554e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import km.C11063a;
import p429kk.C11058a;
import p455ll.C11308a;
import p455ll.C11310c;
import p456lm.AbstractC11314a;
import p456lm.C11315b;
import p514o9.C11839m;
import p618rm.C12590s0;
import p618rm.C12592t;
import p652t9.EnumC12999a;
import p709vj.C13452e;

/* renamed from: im.h */
/* loaded from: classes6.dex */
public abstract class AbstractC10558h extends AbstractC10554e {

    /* renamed from: I */
    public File f50775I;

    /* renamed from: im.h$a */
    public class a extends AbstractC11314a {

        /* renamed from: e */
        public Slice<File> f50776e;

        /* renamed from: f */
        public C11310c f50777f;

        /* renamed from: g */
        public CountDownLatch f50778g;

        /* renamed from: h */
        public List<Long> f50779h;

        /* renamed from: i */
        public List<Long> f50780i;

        public a(Slice<File> slice, C11310c c11310c, List<Long> list, List<Long> list2, CountDownLatch countDownLatch) {
            super(c11310c.m67926k(), 0);
            this.f50776e = slice;
            this.f50777f = c11310c;
            this.f50779h = list;
            this.f50780i = list2;
            this.f50778g = countDownLatch;
        }

        /* JADX WARN: Code restructure failed: missing block: B:267:0x01d8, code lost:
        
            if (r19 == null) goto L328;
         */
        /* JADX WARN: Code restructure failed: missing block: B:268:0x01da, code lost:
        
            r9 = r19.getUrl();
            im.AbstractC10558h.this.m64717l(r9);
            im.AbstractC10558h.this.m64715j();
            r10 = new java.util.ArrayList();
         */
        /* JADX WARN: Code restructure failed: missing block: B:269:0x01ed, code lost:
        
            r11 = r8.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:271:0x01f9, code lost:
        
            if (r11.hasNext() == false) goto L393;
         */
        /* JADX WARN: Code restructure failed: missing block: B:272:0x01fb, code lost:
        
            r12 = r11.next();
            r13 = r12.getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:273:0x020b, code lost:
        
            if (r13.exists() == false) goto L391;
         */
        /* JADX WARN: Code restructure failed: missing block: B:275:0x0215, code lost:
        
            if (r13.length() <= 0) goto L392;
         */
        /* JADX WARN: Code restructure failed: missing block: B:276:0x0217, code lost:
        
            r10.add(new com.huawei.hms.network.file.upload.api.FileEntity(com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, r12.getObject().getName(), r12.getObject(), r12.getOffset(), r12.getLength()));
         */
        /* JADX WARN: Code restructure failed: missing block: B:277:0x023e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:280:0x0261, code lost:
        
            throw new fk.C9721b(com.huawei.hicloud.notification.constants.FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "create file entity file not found, file = " + r13.getName());
         */
        /* JADX WARN: Code restructure failed: missing block: B:281:0x0262, code lost:
        
            r14 = ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) ((com.huawei.hms.network.file.upload.api.PutRequest.Builder) com.huawei.hms.network.file.upload.api.UploadManager.newPutRequestBuilder().config(im.AbstractC10558h.this.m64710e())).url(r9)).backupUrls(java.util.Collections.singletonList(r9))).headers(r19.getHeaders())).reportInfos(r1.m64774e(im.AbstractC10558h.this.f50745l.m67883a()))).fileParams((java.util.List<com.huawei.hms.network.file.upload.api.FileEntity>) r10).build();
            r15 = new java.util.concurrent.CountDownLatch(1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:282:0x02b2, code lost:
        
            r20 = "slice file task error. objectId = ";
            r21 = " ,path: ";
         */
        /* JADX WARN: Code restructure failed: missing block: B:283:0x02bf, code lost:
        
            r13 = new im.AbstractC10554e.b(r1.f50777f, r20, r15, r17);
            r9 = p767x9.C13735d.m82531s();
            r10 = im.AbstractC10558h.this;
            r7 = r10.m64733A(r7, r10.f50736E);
         */
        /* JADX WARN: Code restructure failed: missing block: B:284:0x02d6, code lost:
        
            if (im.AbstractC10558h.this.f50736E.get() == false) goto L293;
         */
        /* JADX WARN: Code restructure failed: missing block: B:285:0x02d8, code lost:
        
            r10 = r1.f50780i;
         */
        /* JADX WARN: Code restructure failed: missing block: B:287:0x02db, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:288:0x02dc, code lost:
        
            r2 = r0;
            r7 = r8;
            r6 = r21;
            r1 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:289:0x02e2, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:290:0x02e3, code lost:
        
            r2 = r0;
            r7 = r8;
            r6 = r21;
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:291:0x02e9, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:292:0x02ea, code lost:
        
            r2 = r0;
            r7 = r8;
            r10 = r20;
            r6 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:293:0x02f2, code lost:
        
            r10 = r1.f50779h;
         */
        /* JADX WARN: Code restructure failed: missing block: B:294:0x02f4, code lost:
        
            r9.m82543m(r7, r14, r10, r13);
            p514o9.C11839m.m70688i("CloudBackupV3AssetUploader", "slice file task await start. objectId = " + r1.f50777f.m67928q());
            im.AbstractC10558h.this.m64718m(r15);
            p514o9.C11839m.m70688i("CloudBackupV3AssetUploader", "slice file task await end. objectId = " + r1.f50777f.m67928q());
         */
        /* JADX WARN: Code restructure failed: missing block: B:295:0x0330, code lost:
        
            r1.f50778g.countDown();
         */
        /* JADX WARN: Code restructure failed: missing block: B:296:0x0339, code lost:
        
            if (im.AbstractC10558h.this.f50755v == null) goto L416;
         */
        /* JADX WARN: Code restructure failed: missing block: B:297:0x033b, code lost:
        
            r1 = r8.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:299:0x0347, code lost:
        
            if (r1.hasNext() == false) goto L394;
         */
        /* JADX WARN: Code restructure failed: missing block: B:300:0x0349, code lost:
        
            r2 = r1.next().getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:301:0x0359, code lost:
        
            if (r2.exists() == false) goto L303;
         */
        /* JADX WARN: Code restructure failed: missing block: B:302:0x035b, code lost:
        
            r3 = new java.lang.StringBuilder();
            r3.append("encrypt file exits, delete = ");
            r3.append(r2.delete());
            r6 = r21;
            r3.append(r6);
            r3.append(hk.C10279b.m63452a(r2));
            p514o9.C11839m.m70686d("CloudBackupV3AssetUploader", r3.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:303:0x037e, code lost:
        
            r6 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:304:0x0380, code lost:
        
            r21 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:305:0x0383, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:306:0x0384, code lost:
        
            r6 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:307:0x0386, code lost:
        
            r2 = r0;
            r6 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:308:0x0389, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:309:0x038a, code lost:
        
            r6 = r21;
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:310:0x038c, code lost:
        
            r2 = r0;
            r7 = r8;
            r6 = r6;
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:311:0x0390, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:312:0x0391, code lost:
        
            r6 = r21;
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:313:0x0393, code lost:
        
            r2 = r0;
            r7 = r8;
            r10 = r20;
            r6 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:321:0x03d0, code lost:
        
            throw new fk.C9721b(com.huawei.hicloud.notification.constants.FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create FileEntity trigger illegalArgumentException: " + r0.getMessage() + " assetId = " + r1.f50777f.m67926k());
         */
        /* JADX WARN: Code restructure failed: missing block: B:322:0x03d1, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:324:0x03d3, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:325:0x03d4, code lost:
        
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:326:0x03d5, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:327:0x03d6, code lost:
        
            r20 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:329:0x03f6, code lost:
        
            throw new fk.C9721b(3911, "refresh url error. objectId = " + r1.f50777f.m67928q(), "Upload");
         */
        /* JADX WARN: Code restructure failed: missing block: B:341:0x044a, code lost:
        
            r1 = r7.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:342:0x0452, code lost:
        
            r2 = r1.hasNext();
            r1 = r1;
            r6 = r6;
            r7 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:343:0x0456, code lost:
        
            if (r2 != false) goto L344;
         */
        /* JADX WARN: Code restructure failed: missing block: B:344:0x0458, code lost:
        
            r2 = (java.io.File) ((com.huawei.hicloud.base.slice.SliceItem) r1.next()).getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:345:0x0468, code lost:
        
            if (r2.exists() != false) goto L401;
         */
        /* JADX WARN: Code restructure failed: missing block: B:346:0x046a, code lost:
        
            r3 = new java.lang.StringBuilder();
            r3.append("encrypt file exits, delete = ");
            r7 = r2.delete();
            r3.append(r7);
            r3.append(r6);
            r3.append(hk.C10279b.m63452a(r2));
            p514o9.C11839m.m70686d("CloudBackupV3AssetUploader", r3.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:365:0x051a, code lost:
        
            r1 = r7.getSliceItems().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:368:0x0528, code lost:
        
            r3 = r1.next().getObject();
         */
        /* JADX WARN: Code restructure failed: missing block: B:369:0x0538, code lost:
        
            if (r3.exists() != false) goto L405;
         */
        /* JADX WARN: Code restructure failed: missing block: B:370:0x053a, code lost:
        
            p514o9.C11839m.m70686d("CloudBackupV3AssetUploader", "encrypt file exits, delete = " + r3.delete() + r6 + hk.C10279b.m63452a(r3));
         */
        /* JADX WARN: Code restructure failed: missing block: B:416:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:417:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:418:?, code lost:
        
            throw r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:419:?, code lost:
        
            throw r2;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:340:0x0448 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:344:0x0458  */
        /* JADX WARN: Removed duplicated region for block: B:354:0x04c9 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:358:0x04d9  */
        /* JADX WARN: Removed duplicated region for block: B:364:0x0518 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:371:0x055b A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r1v13, types: [com.huawei.hicloud.cloudbackup.v3.server.model.Cipher] */
        /* JADX WARN: Type inference failed for: r1v15, types: [java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r1v8, types: [com.huawei.hicloud.cloudbackup.v3.server.model.Cipher] */
        /* JADX WARN: Type inference failed for: r20v8, types: [com.huawei.hicloud.cloudbackup.v3.server.model.RevisionRefresh] */
        /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r6v0 */
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
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v40 */
        /* JADX WARN: Type inference failed for: r6v41 */
        /* JADX WARN: Type inference failed for: r6v44 */
        /* JADX WARN: Type inference failed for: r6v45 */
        /* JADX WARN: Type inference failed for: r6v46 */
        /* JADX WARN: Type inference failed for: r6v47 */
        /* JADX WARN: Type inference failed for: r6v48 */
        /* JADX WARN: Type inference failed for: r6v49 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v12, types: [com.huawei.hicloud.base.slice.Slice] */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v32 */
        /* JADX WARN: Type inference failed for: r7v33 */
        /* JADX WARN: Type inference failed for: r7v7, types: [com.huawei.hicloud.base.slice.Slice] */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9 */
        /* JADX WARN: Type inference failed for: r9v7, types: [im.e, im.h] */
        @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1372
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: im.AbstractC10558h.a.call():void");
        }

        /* renamed from: e */
        public final Map<String, String> m64774e(String str) {
            HashMap map = new HashMap();
            map.put("trace_id", AbstractC10558h.this.f50746m);
            map.put("assetId", str);
            map.put("objectId", this.f50777f.m67928q());
            return map;
        }
    }

    public AbstractC10558h(String str, String str2, C10321z c10321z, C1457c c1457c, String str3, String str4, File file, String str5) {
        super(str, str2, c10321z, c1457c, str3, str4, str5);
        this.f50775I = file;
    }

    /* renamed from: L */
    public abstract Slice<File> mo64762L(String str, Slice<File> slice) throws C9721b;

    /* renamed from: M */
    public C11308a m64763M(int i10) throws Throwable {
        boolean z10;
        Throwable th2;
        Resource resource;
        boolean z11;
        C11839m.m70688i("CloudBackupV3AssetUploader", "file upload start. file = " + this.f50775I.getName());
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f50752s = false;
        this.f50751r = 0L;
        this.f50758y = i10 > 0;
        this.f50759z = i10;
        String strM75957h = null;
        try {
            try {
                this.f50729c = C11058a.m66626a(this.f50746m, "upload", C13452e.m80781L().m80971t0());
                m64740J(AbstractC10554e.c.INITIATION_STARTED);
                m64715j();
                this.f50745l = mo64768R(this.f50775I);
                m64715j();
                Resource resourceM64741K = m64741K();
                try {
                    if (this.f50745l.m67897o() == 0) {
                        m64715j();
                        List<Slice<File>> listMo64773W = mo64773W();
                        this.f50750q = mo64764N(listMo64773W);
                        m64740J(AbstractC10554e.c.INITIATION_COMPLETE);
                        z11 = C12592t.m75950g().m75961l() && !this.f50756w;
                        if (z11) {
                            try {
                                strM75957h = C12592t.m75950g().m75957h();
                                C12592t.m75950g().m75963o(strM75957h);
                                this.f50752s = true;
                            } catch (C9721b e10) {
                                e = e10;
                                C11839m.m70687e("CloudBackupV3AssetUploader", "file upload error. file = " + this.f50775I.getName() + " " + e.toString());
                                m64712g(e);
                                throw e;
                            }
                        }
                        C11839m.m70688i("CloudBackupV3AssetUploader", "file operator start, file = " + this.f50775I.getName());
                        m64767Q(listMo64773W);
                        C11839m.m70688i("CloudBackupV3AssetUploader", "file operator end, file = " + this.f50775I.getName());
                    } else {
                        this.f50756w = true;
                        this.f50750q = this.f50775I.length();
                        C11839m.m70688i("CloudBackupV3AssetUploader", "file already upload. file = " + this.f50775I.getName());
                        z11 = false;
                    }
                    C11839m.m70688i("CloudBackupV3AssetUploader", "file status update. file = " + this.f50775I.getName());
                    m64715j();
                    mo64744w();
                    m64740J(AbstractC10554e.c.MEDIA_COMPLETE);
                    if (this.f50752s && z11) {
                        C11839m.m70686d("CloudBackupV3AssetUploader", "file upload end. sliceTotalLength = " + this.f50750q + ", uploadSliceTotalLength = " + this.f50751r);
                        C12592t.m75950g().m75962n(strM75957h, this.f50751r);
                        this.f50752s = false;
                        this.f50751r = 0L;
                    }
                    m64737G(true, jCurrentTimeMillis, resourceM64741K, this.f50775I.getName(), this.f50775I.length(), i10);
                    C11839m.m70688i("CloudBackupV3AssetUploader", "file upload end. file = " + this.f50775I.getName());
                    return this.f50745l;
                } catch (C9721b e11) {
                    e = e11;
                } catch (Throwable th3) {
                    th = th3;
                    z10 = false;
                    th2 = th;
                    resource = resourceM64741K;
                    if (this.f50752s) {
                        C11839m.m70686d("CloudBackupV3AssetUploader", "file upload end. sliceTotalLength = " + this.f50750q + ", uploadSliceTotalLength = " + this.f50751r);
                        C12592t.m75950g().m75962n(null, this.f50751r);
                        this.f50752s = false;
                        this.f50751r = 0L;
                    }
                    m64737G(false, jCurrentTimeMillis, resource, this.f50775I.getName(), this.f50775I.length(), i10);
                    throw th2;
                }
            } catch (C9721b e12) {
                e = e12;
            } catch (Throwable th4) {
                z10 = false;
                th2 = th4;
                resource = null;
                if (this.f50752s && z10) {
                    C11839m.m70686d("CloudBackupV3AssetUploader", "file upload end. sliceTotalLength = " + this.f50750q + ", uploadSliceTotalLength = " + this.f50751r);
                    C12592t.m75950g().m75962n(null, this.f50751r);
                    this.f50752s = false;
                    this.f50751r = 0L;
                }
                m64737G(false, jCurrentTimeMillis, resource, this.f50775I.getName(), this.f50775I.length(), i10);
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: N */
    public abstract long mo64764N(List<Slice<File>> list);

    /* renamed from: O */
    public List<Slice<File>> m64765O() throws C9721b {
        ArrayList arrayList = new ArrayList(Collections.singleton(mo64766P()));
        Slices slices = new Slices();
        C11063a c11063a = new C11063a(arrayList, new FileLengthGetter());
        while (c11063a.m66676a()) {
            slices.increase(c11063a.m66677b(this.f50745l.m67896n()));
        }
        return slices.getSlices();
    }

    /* renamed from: P */
    public File mo64766P() throws C9721b {
        return this.f50775I;
    }

    /* renamed from: Q */
    public final void m64767Q(List<Slice<File>> list) throws C9721b {
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
                    a aVar = new a(list.get(i11), c11310c, listSynchronizedList, listSynchronizedList2, countDownLatch);
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
        C11839m.m70688i("CloudBackupV3AssetUploader", "syncLock await begin, file = " + this.f50775I.getName());
        m64715j();
        m64718m(countDownLatch);
        C11839m.m70688i("CloudBackupV3AssetUploader", "syncLock await end, file = " + this.f50775I.getName());
        C11315b.m67979c().m67984f(this.f50745l.m67883a());
        m64742u(EnumC12999a.CLOUD_BACKUP, listSynchronizedList);
        m64742u(EnumC12999a.CLOUD_BACKUP_QUIC, listSynchronizedList2);
        m64743v(this.f50754u);
    }

    /* renamed from: R */
    public abstract C11308a mo64768R(File file) throws C9721b;

    /* renamed from: S */
    public AbstractC10558h m64769S(String str) {
        this.f50744k = str;
        return this;
    }

    /* renamed from: T */
    public AbstractC10558h m64770T(InterfaceC10570t interfaceC10570t) {
        this.f50733B = interfaceC10570t;
        return this;
    }

    /* renamed from: U */
    public AbstractC10558h m64771U(int i10) {
        this.f50742i = i10;
        return this;
    }

    /* renamed from: V */
    public AbstractC10558h m64772V(boolean z10) {
        this.f50757x = z10;
        return this;
    }

    /* renamed from: W */
    public List<Slice<File>> mo64773W() throws C9721b {
        m64715j();
        List<Slice<File>> listM64765O = m64765O();
        C9720a.m60652a(this.f50754u.size() == listM64765O.size(), "slices do not match server,serverSliceSize:" + this.f50754u.size() + ",clientSliceSize:" + listM64765O.size());
        return listM64765O;
    }
}
