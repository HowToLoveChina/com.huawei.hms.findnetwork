package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.beans.metadata.CheckResult;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.openalliance.p169ad.inter.HiAdSplash;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7841t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* renamed from: com.huawei.openalliance.ad.or */
/* loaded from: classes8.dex */
public class C7557or implements InterfaceC7614qp {

    /* renamed from: a */
    protected int f35160a;

    /* renamed from: b */
    protected boolean f35161b;

    /* renamed from: c */
    protected InterfaceC7135fs f35162c;

    /* renamed from: d */
    protected Context f35163d;

    /* renamed from: e */
    private InterfaceC7136ft f35164e;

    /* renamed from: f */
    private InterfaceC7140fx f35165f;

    /* renamed from: g */
    private InterfaceC7146gc f35166g;

    /* renamed from: h */
    private InterfaceC7002cs f35167h;

    /* renamed from: i */
    private Integer f35168i;

    /* renamed from: com.huawei.openalliance.ad.or$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35169a;

        public AnonymousClass1(ContentRecord contentRecord) {
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7022dk c7022dkM41937a = C7019dh.m41937a(C7557or.this.f35163d, Constants.NORMAL_CACHE);
            Context context = C7557or.this.f35163d;
            String strM47696b = C7752az.m47696b(context, C7780c.m47855a(context, contentRecord));
            String strM41970e = c7022dkM41937a.m41970e(strM47696b);
            String strM41968c = c7022dkM41937a.m41968c(strM41970e);
            if (!AbstractC7731ae.m47458b(strM41968c)) {
                C7022dk c7022dkM41937a2 = C7019dh.m41937a(C7557or.this.f35163d, Constants.TPLATE_CACHE);
                strM41970e = c7022dkM41937a2.m41970e(strM47696b);
                strM41968c = c7022dkM41937a2.m41968c(strM41970e);
            }
            if (AbstractC7731ae.m47458b(strM41968c)) {
                c7022dkM41937a.m41975h(strM41970e);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.or$2 */
    public class AnonymousClass2 implements Callable<CheckResult> {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35171a;

        /* renamed from: b */
        final /* synthetic */ String f35172b;

        /* renamed from: c */
        final /* synthetic */ String f35173c;

        public AnonymousClass2(ContentRecord contentRecord, String str, String str2) {
            contentRecord = contentRecord;
            str = str;
            str = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public CheckResult call() {
            return C7557or.this.m46422b(contentRecord, str, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.or$3 */
    public class AnonymousClass3 implements Callable<CheckResult> {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35175a;

        /* renamed from: b */
        final /* synthetic */ String f35176b;

        /* renamed from: c */
        final /* synthetic */ String f35177c;

        public AnonymousClass3(ContentRecord contentRecord, String str, String str2) {
            contentRecord = contentRecord;
            str = str;
            str = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public CheckResult call() {
            return C7557or.this.m46410a(contentRecord, str, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.or$4 */
    public class AnonymousClass4 implements Callable<CheckResult> {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35179a;

        /* renamed from: b */
        final /* synthetic */ boolean f35180b;

        public AnonymousClass4(ContentRecord contentRecord, boolean z10) {
            contentRecord = contentRecord;
            z = z10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public CheckResult call() {
            return C7557or.this.m46423b(contentRecord, z);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.or$5 */
    public class AnonymousClass5 implements Callable<CheckResult> {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35182a;

        public AnonymousClass5(ContentRecord contentRecord) {
            contentRecord = contentRecord;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public CheckResult call() {
            Context context = C7557or.this.f35163d;
            ContentRecord contentRecord = contentRecord;
            return new CheckResult(C7780c.m47864a(context, contentRecord, C7780c.m47855a(context, contentRecord)), contentRecord.m41619z(), "", contentRecord.m41423U());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.or$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Future f35184a;

        /* renamed from: b */
        final /* synthetic */ ContentRecord f35185b;

        public AnonymousClass6(Future future, ContentRecord contentRecord) {
            future = future;
            contentRecord = contentRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CheckResult checkResult = (CheckResult) future.get();
                if (checkResult == null || !checkResult.m39880a()) {
                    C7557or.this.m46442a(contentRecord, 1);
                } else {
                    C7557or.this.m46442a(contentRecord, 3);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("ContentProcessor", "check exist in kit: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.or$7 */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ContentRecord f35187a;

        /* renamed from: b */
        final /* synthetic */ int f35188b;

        public AnonymousClass7(ContentRecord contentRecord, int i10) {
            contentRecord = contentRecord;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7557or.this.f35167h.mo39123d(contentRecord, i);
        }
    }

    public C7557or(Context context, boolean z10, int i10) {
        AbstractC7185ho.m43821b("ContentProcessor", "ContentProcessor - isPreContent: %s", Boolean.valueOf(z10));
        this.f35163d = context.getApplicationContext();
        this.f35161b = z10;
        this.f35165f = C7118fb.m43196a(context);
        this.f35166g = C7124fh.m43316b(context);
        this.f35162c = C7103es.m43094a(context);
        this.f35167h = new C6922c(context);
        this.f35160a = i10;
        this.f35164e = C7105eu.m43130a(context);
    }

    /* renamed from: a */
    public CheckResult m46410a(ContentRecord contentRecord, String str, String str2) {
        String strM46430c = m46430c(str2, Constants.TPLATE_CACHE);
        String strM41423U = contentRecord.m41423U();
        if (AbstractC7806cz.m48165b(strM46430c)) {
            AbstractC7185ho.m43821b("ContentProcessor", "checkFileExistInTplate filePath is blank %s.", str);
            return new CheckResult(false, "filePath is blank", strM46430c);
        }
        if (AbstractC7731ae.m47462c(this.f35163d, strM46430c, Constants.TPLATE_CACHE)) {
            AbstractC7185ho.m43821b("ContentProcessor", "tplate localFilePath is %s", AbstractC7819dl.m48375a(strM46430c));
            return new CheckResult(true, str2, strM46430c, strM41423U);
        }
        AbstractC7185ho.m43821b("ContentProcessor", "checkFileExistInTplate is FilePath is invalid : %s.", str);
        AbstractC7731ae.m47441a(this.f35163d, str2, Constants.TPLATE_CACHE);
        return new CheckResult(false, str2, strM46430c);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0014  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Boolean m46429c(java.lang.String r1) {
        /*
            r0 = this;
            com.huawei.openalliance.ad.ft r0 = r0.f35164e
            java.util.List r0 = r0.mo43133a(r1)
            boolean r1 = com.huawei.openalliance.p169ad.utils.AbstractC7760bg.m47767a(r0)
            if (r1 != 0) goto L14
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7557or.m46429c(java.lang.String):java.lang.Boolean");
    }

    /* renamed from: d */
    private void m46432d(ContentRecord contentRecord) {
        if (2 == contentRecord.m41392E()) {
            String strM41619z = contentRecord.m41619z();
            if (AbstractC7806cz.m48165b(strM41619z)) {
                return;
            }
            C7752az.m47691a(this.f35163d, strM41619z, null, null);
        }
    }

    /* renamed from: e */
    private boolean m46433e(ContentRecord contentRecord) {
        return AbstractC7807d.m48228c(this.f35163d, contentRecord.m41585m()) ? m46434f(contentRecord) : m46435g(contentRecord);
    }

    /* renamed from: f */
    private boolean m46434f(ContentRecord contentRecord) {
        return m46423b(contentRecord, false).m39880a();
    }

    /* renamed from: g */
    private boolean m46435g(ContentRecord contentRecord) {
        CheckResult checkResultM46411a = m46411a(contentRecord, false);
        return checkResultM46411a != null && checkResultM46411a.m39880a();
    }

    /* renamed from: h */
    private CheckResult m46436h(ContentRecord contentRecord) {
        return m46411a(contentRecord, true);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: b */
    public CheckResult mo46447b(ContentRecord contentRecord) {
        return AbstractC7807d.m48228c(this.f35163d, contentRecord.m41585m()) ? m46423b(contentRecord, true) : m46436h(contentRecord);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0080 A[Catch: all -> 0x007d, TryCatch #2 {all -> 0x007d, blocks: (B:75:0x006e, B:77:0x0074, B:81:0x0083, B:83:0x0089, B:87:0x0092, B:80:0x0080), top: B:96:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.p169ad.beans.metadata.CheckResult m46411a(com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r11, boolean r12) {
        /*
            r10 = this;
            java.lang.String r0 = "ContentProcessor"
            com.huawei.openalliance.ad.or$4 r1 = new com.huawei.openalliance.ad.or$4
            r1.<init>()
            java.util.concurrent.Future r1 = com.huawei.openalliance.p169ad.utils.AbstractC7810dc.m48271a(r1)
            com.huawei.openalliance.ad.or$5 r2 = new com.huawei.openalliance.ad.or$5
            r2.<init>()
            java.util.concurrent.Future r2 = com.huawei.openalliance.p169ad.utils.AbstractC7810dc.m48271a(r2)
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L3f
            com.huawei.openalliance.ad.beans.metadata.CheckResult r1 = (com.huawei.openalliance.p169ad.beans.metadata.CheckResult) r1     // Catch: java.lang.Throwable -> L3f
            java.lang.String r6 = "exist in sdk: %s, is spare: %s"
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2e
            boolean r8 = r1.m39880a()     // Catch: java.lang.Throwable -> L2c
            if (r8 == 0) goto L2e
            r8 = r4
            goto L2f
        L2c:
            r6 = move-exception
            goto L43
        L2e:
            r8 = r5
        L2f:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L2c
            r7[r5] = r8     // Catch: java.lang.Throwable -> L2c
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r12)     // Catch: java.lang.Throwable -> L2c
            r7[r4] = r8     // Catch: java.lang.Throwable -> L2c
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r0, r6, r7)     // Catch: java.lang.Throwable -> L2c
            goto L54
        L3f:
            r1 = move-exception
            r9 = r6
            r6 = r1
            r1 = r9
        L43:
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getSimpleName()
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r7 = "exist in sdk: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r7, r6)
        L54:
            if (r1 == 0) goto L66
            boolean r6 = r1.m39880a()
            if (r6 != 0) goto L5d
            goto L66
        L5d:
            com.huawei.openalliance.ad.or$6 r12 = new com.huawei.openalliance.ad.or$6
            r12.<init>()
            com.huawei.openalliance.p169ad.utils.AbstractC7834m.m48486f(r12)
            goto Lb5
        L66:
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> La3
            com.huawei.openalliance.ad.beans.metadata.CheckResult r2 = (com.huawei.openalliance.p169ad.beans.metadata.CheckResult) r2     // Catch: java.lang.Throwable -> La3
            if (r2 == 0) goto L80
            boolean r1 = r2.m39880a()     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L80
            com.huawei.openalliance.ad.fs r1 = r10.f35162c     // Catch: java.lang.Throwable -> L7d
            r1.mo43107a(r11)     // Catch: java.lang.Throwable -> L7d
            r10.m46442a(r11, r3)     // Catch: java.lang.Throwable -> L7d
            goto L83
        L7d:
            r10 = move-exception
            r1 = r2
            goto La4
        L80:
            r10.m46442a(r11, r5)     // Catch: java.lang.Throwable -> L7d
        L83:
            java.lang.String r10 = "exist in kit: %s, is spare: %s"
            java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L7d
            if (r2 == 0) goto L91
            boolean r1 = r2.m39880a()     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L91
            r1 = r4
            goto L92
        L91:
            r1 = r5
        L92:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L7d
            r11[r5] = r1     // Catch: java.lang.Throwable -> L7d
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch: java.lang.Throwable -> L7d
            r11[r4] = r12     // Catch: java.lang.Throwable -> L7d
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r0, r10, r11)     // Catch: java.lang.Throwable -> L7d
            r1 = r2
            goto Lb5
        La3:
            r10 = move-exception
        La4:
            java.lang.Class r10 = r10.getClass()
            java.lang.String r10 = r10.getSimpleName()
            java.lang.Object[] r10 = new java.lang.Object[]{r10}
            java.lang.String r11 = "exist in kit: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43824c(r0, r11, r10)
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7557or.m46411a(com.huawei.openalliance.ad.db.bean.ContentRecord, boolean):com.huawei.openalliance.ad.beans.metadata.CheckResult");
    }

    /* renamed from: b */
    private CheckResult m46421b(ContentRecord contentRecord, String str) {
        Object obj;
        String strM41585m = contentRecord.m41585m();
        String strM41619z = contentRecord.m41619z();
        Future futureM48271a = AbstractC7810dc.m48271a(new Callable<CheckResult>() { // from class: com.huawei.openalliance.ad.or.2

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35171a;

            /* renamed from: b */
            final /* synthetic */ String f35172b;

            /* renamed from: c */
            final /* synthetic */ String f35173c;

            public AnonymousClass2(ContentRecord contentRecord2, String str2, String strM41619z2) {
                contentRecord = contentRecord2;
                str = str2;
                str = strM41619z2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public CheckResult call() {
                return C7557or.this.m46422b(contentRecord, str, str);
            }
        });
        Future futureM48271a2 = AbstractC7810dc.m48271a(new Callable<CheckResult>() { // from class: com.huawei.openalliance.ad.or.3

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35175a;

            /* renamed from: b */
            final /* synthetic */ String f35176b;

            /* renamed from: c */
            final /* synthetic */ String f35177c;

            public AnonymousClass3(ContentRecord contentRecord2, String str2, String strM41619z2) {
                contentRecord = contentRecord2;
                str = str2;
                str = strM41619z2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public CheckResult call() {
                return C7557or.this.m46410a(contentRecord, str, str);
            }
        });
        CheckResult checkResult = null;
        try {
            if (!((CheckResult) futureM48271a.get()).m39880a() && !((CheckResult) futureM48271a2.get()).m39880a()) {
                AbstractC7185ho.m43823c("ContentProcessor", "normalPathFuture and tplatePathFuture is invalid");
                m46427b(str2, strM41585m);
                obj = futureM48271a.get();
            } else if (((CheckResult) futureM48271a.get()).m39880a()) {
                AbstractC7185ho.m43823c("ContentProcessor", "normalPathFuture is Valid");
                obj = futureM48271a.get();
            } else {
                if (!((CheckResult) futureM48271a2.get()).m39880a()) {
                    return null;
                }
                AbstractC7185ho.m43823c("ContentProcessor", "tplatePathFuture is Valid");
                obj = futureM48271a2.get();
            }
            checkResult = (CheckResult) obj;
            return checkResult;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ContentProcessor", "normalPathFuture or tplatePathFuture res err: %s", th2.getClass().getSimpleName());
            return checkResult;
        }
    }

    /* renamed from: c */
    private String m46430c(String str, String str2) {
        return C7022dk.m41954i(str) ? C7019dh.m41937a(this.f35163d, str2).m41968c(str) : str;
    }

    /* renamed from: b */
    public CheckResult m46422b(ContentRecord contentRecord, String str, String str2) {
        String strM46430c = m46430c(str2, Constants.NORMAL_CACHE);
        String strM41423U = contentRecord.m41423U();
        if (AbstractC7806cz.m48165b(strM46430c)) {
            AbstractC7185ho.m43821b("ContentProcessor", "checkFileExistInNormal filePath is blank %s.", str);
            return new CheckResult(false, "filePath is blank", strM46430c);
        }
        if (AbstractC7731ae.m47462c(this.f35163d, strM46430c, Constants.NORMAL_CACHE)) {
            AbstractC7185ho.m43821b("ContentProcessor", "normal localFilePath is %s", AbstractC7819dl.m48375a(strM46430c));
            return new CheckResult(true, str2, strM46430c, strM41423U);
        }
        AbstractC7185ho.m43821b("ContentProcessor", "checkFileExistInNormal is FilePath is invalid : %s.", str);
        AbstractC7731ae.m47440a(this.f35163d, str2);
        return new CheckResult(false, str2, strM46430c);
    }

    /* renamed from: c */
    private void m46431c(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.or.1

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35169a;

            public AnonymousClass1(ContentRecord contentRecord2) {
                contentRecord = contentRecord2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7022dk c7022dkM41937a = C7019dh.m41937a(C7557or.this.f35163d, Constants.NORMAL_CACHE);
                Context context = C7557or.this.f35163d;
                String strM47696b = C7752az.m47696b(context, C7780c.m47855a(context, contentRecord));
                String strM41970e = c7022dkM41937a.m41970e(strM47696b);
                String strM41968c = c7022dkM41937a.m41968c(strM41970e);
                if (!AbstractC7731ae.m47458b(strM41968c)) {
                    C7022dk c7022dkM41937a2 = C7019dh.m41937a(C7557or.this.f35163d, Constants.TPLATE_CACHE);
                    strM41970e = c7022dkM41937a2.m41970e(strM47696b);
                    strM41968c = c7022dkM41937a2.m41968c(strM41970e);
                }
                if (AbstractC7731ae.m47458b(strM41968c)) {
                    c7022dkM41937a.m41975h(strM41970e);
                }
            }
        });
    }

    /* renamed from: b */
    public CheckResult m46423b(ContentRecord contentRecord, boolean z10) {
        String strM39882c;
        String strM41588n = contentRecord.m41588n();
        ContentRecord contentRecordM46417a = m46417a(strM41588n, contentRecord.m41585m());
        if (contentRecordM46417a == null) {
            return new CheckResult(false, "cachedContentRecord is null", "");
        }
        String strM41423U = contentRecordM46417a.m41423U();
        CheckResult checkResultM46421b = m46421b(contentRecordM46417a, strM41588n);
        String strM41619z = contentRecordM46417a.m41619z();
        if (checkResultM46421b != null && !checkResultM46421b.m39880a()) {
            return checkResultM46421b;
        }
        if (checkResultM46421b == null || !checkResultM46421b.m39880a()) {
            strM39882c = null;
        } else {
            strM41619z = checkResultM46421b.m39881b();
            strM39882c = checkResultM46421b.m39882c();
        }
        if (z10) {
            return checkResultM46421b != null ? checkResultM46421b : new CheckResult(true, strM41619z, strM39882c, strM41423U);
        }
        if (this.f35168i != null && !this.f35161b) {
            int iM41609u = contentRecordM46417a.m41609u();
            int iM41606t = contentRecordM46417a.m41606t();
            boolean z11 = this.f35168i.intValue() != 0 || (contentRecordM46417a.m41392E() != 12 && iM41606t > iM41609u);
            if ((this.f35168i.intValue() == 1 && contentRecordM46417a.m41392E() != 12 && iM41606t > iM41609u) || !z11) {
                AbstractC7185ho.m43821b("ContentProcessor", "delete content %s because of media mismatch screen orientation.", strM41588n);
                AbstractC7731ae.m47440a(this.f35163d, strM41619z);
                this.f35162c.mo43122c(strM41588n);
                return new CheckResult(false, "media mismatch screen orientation", strM39882c);
            }
        }
        contentRecord.m41575j(strM39882c);
        contentRecord.m41599q(strM41423U);
        return new CheckResult(true, strM41619z, strM39882c, strM41423U);
    }

    /* renamed from: b */
    private C7653sb m46425b(ImageInfo imageInfo, ContentRecord contentRecord, long j10) {
        if (imageInfo == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47169a(contentRecord);
        c7653sb.m47187d(imageInfo.m40180c());
        c7653sb.m47184c(imageInfo.m40174a());
        c7653sb.m47181b(imageInfo.m40187g() == 0);
        c7653sb.m47185c(true);
        c7653sb.m47173a(true);
        c7653sb.m47171a(Long.valueOf(j10));
        boolean zEquals = MetaCreativeType.GIF.equals(imageInfo.m40177b());
        InterfaceC7146gc interfaceC7146gc = this.f35166g;
        c7653sb.m47183c(zEquals ? interfaceC7146gc.mo43018d() : interfaceC7146gc.mo43019e());
        return c7653sb;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public ContentRecord mo46437a(ContentRecord contentRecord, int i10, long j10) {
        return null;
    }

    /* renamed from: b */
    private String m46426b(String str) {
        Context context = this.f35163d;
        String str2 = Constants.NORMAL_CACHE;
        String strM41968c = C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41968c(str);
        if (!AbstractC7806cz.m48165b(strM41968c) && !AbstractC7731ae.m47464d(new File(strM41968c))) {
            String strM41968c2 = C7019dh.m41937a(this.f35163d, Constants.TPLATE_CACHE).m41968c(str);
            if (!AbstractC7806cz.m48165b(strM41968c2) && AbstractC7731ae.m47464d(new File(strM41968c2))) {
                str2 = Constants.TPLATE_CACHE;
            }
        }
        AbstractC7185ho.m43821b("ContentProcessor", "realCacheType is %s", str2);
        return str2;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public ContentRecord mo46438a(ContentRecord contentRecord, int i10, long j10, byte[] bArr, int i11) {
        AbstractC7185ho.m43820b("ContentProcessor", "downloadOneContent start");
        if (contentRecord == null) {
            AbstractC7185ho.m43823c("ContentProcessor", "downloadOneContent, contentRecord in null");
            return null;
        }
        if (9 != contentRecord.m41392E() && 12 != contentRecord.m41392E() && this.f35161b && AbstractC7558os.m46462a(contentRecord.m41427W()) && !C7775bv.m47829c(this.f35163d)) {
            AbstractC7185ho.m43820b("ContentProcessor", "downloadOneContent, pre content only download in wifi");
            C6923d.m39138b(this.f35163d, contentRecord);
            return null;
        }
        if (!m46428b(contentRecord.m41392E()) && contentRecord.m41573j() == 1) {
            AbstractC7185ho.m43821b("ContentProcessor", "downloadOneContent - content creativeType %d not supported", Integer.valueOf(contentRecord.m41392E()));
            return null;
        }
        contentRecord.m41857a(bArr);
        ContentRecord contentRecordM46415a = m46415a(contentRecord, j10, i11);
        Object[] objArr = new Object[1];
        objArr[0] = contentRecordM46415a != null ? contentRecordM46415a.m41588n() : null;
        AbstractC7185ho.m43821b("ContentProcessor", "downloadOneContent, showContentId:%s", objArr);
        return contentRecordM46415a;
    }

    /* renamed from: a */
    private ContentRecord m46415a(ContentRecord contentRecord, long j10, int i10) {
        String strM41588n = contentRecord.m41588n();
        boolean zM46433e = m46433e(contentRecord);
        AbstractC7185ho.m43821b("ContentProcessor", "downContent: %s isExist: %s isPreContent: %s", strM41588n, Boolean.valueOf(zM46433e), Boolean.valueOf(this.f35161b));
        AbstractC7185ho.m43818a("ContentProcessor", "path: %s", contentRecord.m41619z());
        if (zM46433e && !this.f35161b) {
            m46419a(contentRecord, strM41588n);
            m46432d(contentRecord);
        } else {
            if (!zM46433e) {
                int i11 = this.f35160a;
                if (1 == i11 || 18 == i11) {
                    contentRecord.m41599q(AbstractC7807d.m48205a(i10));
                    return m46416a(contentRecord, j10, strM41588n);
                }
                this.f35162c.mo43107a(contentRecord);
                return contentRecord;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("updateTime");
            if (TextUtils.isEmpty(contentRecord.m41585m())) {
                this.f35162c.mo43109a(contentRecord, arrayList, strM41588n);
            } else {
                this.f35162c.mo43108a(contentRecord, arrayList);
            }
            m46445a(strM41588n, contentRecord.m41493ao(), Constants.NORMAL_CACHE);
            m46445a(strM41588n, contentRecord.m41493ao(), Constants.AR_CACHE);
            m46445a(strM41588n, contentRecord.m41493ao(), Constants.TPLATE_CACHE);
        }
        m46431c(contentRecord);
        return contentRecord;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: b */
    public void mo46448b() {
        List<ContentRecord> listMo43105a = this.f35162c.mo43105a(this.f35160a);
        if (AbstractC7760bg.m47767a(listMo43105a)) {
            return;
        }
        for (ContentRecord contentRecord : listMo43105a) {
            if (contentRecord != null) {
                m46433e(contentRecord);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x005b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.p169ad.p171db.bean.ContentRecord m46416a(com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r5, long r6, java.lang.String r8) {
        /*
            r4 = this;
            com.huawei.openalliance.ad.beans.metadata.VideoInfo r0 = r5.m41419S()
            java.lang.String r1 = "ContentProcessor"
            r2 = 0
            if (r0 != 0) goto L15
            com.huawei.openalliance.ad.beans.metadata.ImageInfo r0 = r5.m41417R()
            if (r0 != 0) goto L15
            java.lang.String r4 = "no material"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r1, r4)
            return r2
        L15:
            int r0 = r5.m41392E()
            r3 = 9
            if (r0 == r3) goto L2b
            r3 = 12
            if (r0 != r3) goto L22
            goto L2b
        L22:
            com.huawei.openalliance.ad.beans.metadata.ImageInfo r0 = r5.m41417R()
            com.huawei.openalliance.ad.sb r6 = r4.m46425b(r0, r5, r6)
            goto L45
        L2b:
            com.huawei.openalliance.ad.beans.metadata.VideoInfo r0 = r5.m41419S()
            boolean r3 = r4.m46420a(r0)
            if (r3 == 0) goto L3a
            com.huawei.openalliance.ad.sb r6 = r4.m46418a(r0, r5, r6)
            goto L45
        L3a:
            android.content.Context r6 = r4.f35163d
            com.huawei.openalliance.p169ad.analysis.C6923d.m39131a(r6, r5)
            java.lang.String r6 = "video content can only download in wifi"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r6)
            r6 = r2
        L45:
            if (r6 == 0) goto L5b
            r6.m47169a(r5)
            com.huawei.openalliance.ad.fx r7 = r4.f35165f
            com.huawei.openalliance.ad.sc r6 = r7.mo43274a(r6)
            if (r6 == 0) goto L5b
            java.lang.String r7 = r6.m47207a()
            java.lang.String r6 = r6.m47210b()
            goto L5d
        L5b:
            r6 = r2
            r7 = r6
        L5d:
            boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48165b(r7)
            if (r0 != 0) goto L7c
            r5.m41571i(r7)
            r5.m41575j(r6)
            com.huawei.openalliance.ad.fs r6 = r4.f35162c
            java.lang.String r7 = r5.m41591o()
            long r6 = r6.mo43123d(r7)
            r5.m41534c(r6)
            com.huawei.openalliance.ad.fs r4 = r4.f35162c
            r4.mo43107a(r5)
            goto L7e
        L7c:
            r5 = r2
            r8 = r5
        L7e:
            java.lang.String r4 = "downloadAndSaveContent, contentId: %s. "
            java.lang.Object[] r6 = new java.lang.Object[]{r8}
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r1, r4, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7557or.m46416a(com.huawei.openalliance.ad.db.bean.ContentRecord, long, java.lang.String):com.huawei.openalliance.ad.db.bean.ContentRecord");
    }

    /* renamed from: b */
    private void m46427b(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        InterfaceC7135fs interfaceC7135fs = this.f35162c;
        if (zIsEmpty) {
            interfaceC7135fs.mo43122c(str);
        } else {
            interfaceC7135fs.mo43119b(str, str2);
        }
    }

    /* renamed from: a */
    private ContentRecord m46417a(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        InterfaceC7135fs interfaceC7135fs = this.f35162c;
        return zIsEmpty ? interfaceC7135fs.mo43098a(str) : interfaceC7135fs.mo43100a(str, str2);
    }

    /* renamed from: b */
    private boolean m46428b(int i10) {
        int i11 = this.f35160a;
        if (1 == i11 || 18 == i11) {
            return 2 == i10 || 4 == i10 || 9 == i10 || 12 == i10;
        }
        return false;
    }

    /* renamed from: a */
    private C7653sb m46418a(VideoInfo videoInfo, ContentRecord contentRecord, long j10) {
        if (videoInfo == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47169a(contentRecord);
        c7653sb.m47187d(videoInfo.m40471a());
        c7653sb.m47184c(videoInfo.m40493g());
        c7653sb.m47181b(videoInfo.m40496i() == 0);
        c7653sb.m47185c(true);
        c7653sb.m47173a(true);
        c7653sb.m47171a(Long.valueOf(j10));
        c7653sb.m47167a(209715200L);
        return c7653sb;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public void mo46439a() {
        Iterator<ContentRecord> it = this.f35162c.mo43120c().iterator();
        while (it.hasNext()) {
            mo46441a(it.next());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public void mo46440a(ImageInfo imageInfo, ContentRecord contentRecord, long j10) {
        C7653sb c7653sbM46425b = m46425b(imageInfo, contentRecord, j10);
        if (c7653sbM46425b != null) {
            c7653sbM46425b.m47169a(contentRecord);
            C7654sc c7654scMo43274a = this.f35165f.mo43274a(c7653sbM46425b);
            Object[] objArr = new Object[1];
            objArr[0] = c7654scMo43274a != null ? AbstractC7819dl.m48375a(c7654scMo43274a.m47210b()) : null;
            AbstractC7185ho.m43821b("ContentProcessor", "downloadSplashIcon result= %s", objArr);
        }
    }

    /* renamed from: a */
    public void mo46441a(ContentRecord contentRecord) {
        if (contentRecord == null) {
            AbstractC7185ho.m43826d("ContentProcessor", "fail to delete content, content is null");
            return;
        }
        String strM41619z = contentRecord.m41619z();
        int i10 = this.f35160a;
        if ((1 == i10 || 18 == i10) && !AbstractC7806cz.m48165b(strM41619z)) {
            String strSubstring = strM41619z.substring(strM41619z.lastIndexOf("/") + 1);
            if (m46429c(strSubstring).booleanValue()) {
                AbstractC7731ae.m47441a(this.f35163d, strM41619z, m46426b(strM41619z));
            } else {
                this.f35164e.mo43140b(contentRecord.m41588n(), strSubstring);
            }
        }
        this.f35162c.mo43119b(contentRecord.m41588n(), contentRecord.m41585m());
    }

    /* renamed from: a */
    public void m46442a(ContentRecord contentRecord, int i10) {
        AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.or.7

            /* renamed from: a */
            final /* synthetic */ ContentRecord f35187a;

            /* renamed from: b */
            final /* synthetic */ int f35188b;

            public AnonymousClass7(ContentRecord contentRecord2, int i102) {
                contentRecord = contentRecord2;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7557or.this.f35167h.mo39123d(contentRecord, i);
            }
        });
    }

    /* renamed from: a */
    private void m46419a(ContentRecord contentRecord, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("_id");
        arrayList.add(ContentRecord.DISPLAY_COUNT);
        arrayList.add(ContentRecord.DISPLAY_DATE);
        arrayList.add(ContentRecord.SPLASH_MEDIA_PATH);
        arrayList.add(ContentRecord.LAST_SHOW_TIME);
        arrayList.add(ContentRecord.FC_CTRL_DATE);
        int i10 = this.f35160a;
        if (1 == i10 || 18 == i10) {
            AbstractC7185ho.m43817a("ContentProcessor", "ad type is splash");
        }
        this.f35162c.mo43117b(contentRecord, arrayList);
        m46445a(str, contentRecord.m41493ao(), Constants.NORMAL_CACHE);
        m46445a(str, contentRecord.m41493ao(), Constants.AR_CACHE);
        m46445a(str, contentRecord.m41493ao(), Constants.TPLATE_CACHE);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public void mo46443a(Integer num) {
        this.f35168i = num;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7614qp
    /* renamed from: a */
    public void mo46444a(String str) {
        List<ContentRecord> listMo43113b = this.f35162c.mo43113b(str);
        if (AbstractC7760bg.m47767a(listMo43113b)) {
            return;
        }
        Iterator<ContentRecord> it = listMo43113b.iterator();
        while (it.hasNext()) {
            mo46441a(it.next());
        }
    }

    /* renamed from: a */
    public void m46445a(String str, String str2, String str3) {
        C7841t.m48503a(this.f35163d, str, str2, str3);
    }

    /* renamed from: a */
    public boolean m46446a(int i10) {
        Integer allowMobileTraffic = HiAdSplash.getInstance(this.f35163d).getAllowMobileTraffic();
        if (allowMobileTraffic != null) {
            if (1 == allowMobileTraffic.intValue()) {
                return true;
            }
            if (allowMobileTraffic.intValue() == 0) {
                return C7775bv.m47829c(this.f35163d);
            }
        }
        if (i10 == 1) {
            return true;
        }
        return i10 == 0 && C7775bv.m47829c(this.f35163d);
    }

    /* renamed from: a */
    private boolean m46420a(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return false;
        }
        return m46446a(videoInfo.m40499l());
    }
}
