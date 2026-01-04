package com.huawei.hianalytics.framework.data;

import com.huawei.hianalytics.framework.C4757d;
import com.huawei.hianalytics.framework.InterfaceC4756c;
import com.huawei.hianalytics.framework.data.IAesKeyGetter;
import com.huawei.hianalytics.framework.data.WorkKeyHandler;
import gu.C10048b;

/* loaded from: classes5.dex */
public class WorkKeyHandler {

    /* renamed from: d */
    public static final WorkKeyHandler f21749d = new WorkKeyHandler();

    /* renamed from: e */
    public static IAesKeyGetter f21750e;

    /* renamed from: a */
    public final WorkKeyBean f21751a = new WorkKeyBean();

    /* renamed from: b */
    public String f21752b;

    /* renamed from: c */
    public String f21753c;

    public static class WorkKeyBean {
        public static final int SOURCE_QOES = 1;
        public static final int SOURCE_SDK = 0;
        public String encrypted;
        public String pubKeyVer;
        public String workKey;
        public long uploadTime = 0;
        public long keyTtlTime = 0;
        public int source = 0;

        public String getEncrypted() {
            return this.encrypted;
        }

        public long getKeyTtlTime() {
            return this.keyTtlTime;
        }

        public String getPubKeyVer() {
            return this.pubKeyVer;
        }

        public int getSource() {
            return this.source;
        }

        public long getUploadTime() {
            return this.uploadTime;
        }

        public String getWorkKey() {
            return this.workKey;
        }

        public void setEncrypted(String str) {
            this.encrypted = str;
        }

        public void setKeyTtlTime(long j10) {
            this.keyTtlTime = j10;
        }

        public void setPubKeyVer(String str) {
            this.pubKeyVer = str;
        }

        public void setSource(int i10) {
            this.source = i10;
        }

        public void setUploadTime(long j10) {
            this.uploadTime = j10;
        }

        public void setWorkKey(String str) {
            this.workKey = str;
        }
    }

    public static WorkKeyHandler getHandler() {
        return f21749d;
    }

    public static void setAesKeyGetter(IAesKeyGetter iAesKeyGetter) {
        f21750e = iAesKeyGetter;
    }

    /* renamed from: b */
    public final void m28852b() {
        IAesKeyGetter iAesKeyGetter = f21750e;
        if (iAesKeyGetter == null) {
            return;
        }
        iAesKeyGetter.requestAesKey(this.f21752b, new IAesKeyGetter.Callback() { // from class: rj.a
            @Override // com.huawei.hianalytics.framework.data.IAesKeyGetter.Callback
            public final void onResult(WorkKeyHandler.WorkKeyBean workKeyBean) {
                this.f57619a.m28849a(workKeyBean);
            }
        });
    }

    public String getEncrypted() {
        return this.f21751a.encrypted;
    }

    public long getKeyTtl() {
        return this.f21751a.keyTtlTime;
    }

    public String getPubKeyVer() {
        return this.f21751a.pubKeyVer;
    }

    public long getUploadTime() {
        return this.f21751a.uploadTime;
    }

    public String getWorkKey() {
        return this.f21751a.workKey;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0091 A[Catch: all -> 0x004f, TryCatch #0 {all -> 0x004f, blocks: (B:3:0x0001, B:5:0x001f, B:10:0x002f, B:12:0x0039, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:22:0x0066, B:26:0x0072, B:28:0x0094, B:30:0x009d, B:27:0x0091, B:31:0x00a1, B:36:0x00b2, B:39:0x00ba), top: B:44:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d A[Catch: all -> 0x004f, TryCatch #0 {all -> 0x004f, blocks: (B:3:0x0001, B:5:0x001f, B:10:0x002f, B:12:0x0039, B:16:0x0054, B:18:0x005a, B:20:0x0060, B:22:0x0066, B:26:0x0072, B:28:0x0094, B:30:0x009d, B:27:0x0091, B:31:0x00a1, B:36:0x00b2, B:39:0x00ba), top: B:44:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void refreshKey(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            long r0 = r11.getUploadTime()     // Catch: java.lang.Throwable -> L4f
            com.huawei.hianalytics.framework.d r2 = com.huawei.hianalytics.framework.C4757d.f21744e     // Catch: java.lang.Throwable -> L4f
            com.huawei.hianalytics.framework.config.IMandatoryParameters r2 = r2.f21745a     // Catch: java.lang.Throwable -> L4f
            android.util.Pair r12 = r2.getRsaPublicKeyFromNetWork(r12, r13)     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r13 = r12.first     // Catch: java.lang.Throwable -> L4f
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L4f
            r11.f21752b = r13     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r12 = r12.second     // Catch: java.lang.Throwable -> L4f
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L4f
            r11.f21753c = r12     // Catch: java.lang.Throwable -> L4f
            boolean r12 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> L4f
            if (r12 != 0) goto Lba
            java.lang.String r12 = r11.f21753c     // Catch: java.lang.Throwable -> L4f
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L4f
            if (r12 == 0) goto L29
            goto Lba
        L29:
            r12 = 0
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 != 0) goto La1
            java.lang.String r0 = ""
            java.lang.String r1 = ""
            java.lang.String r2 = ""
            com.huawei.hianalytics.framework.data.IAesKeyGetter r3 = com.huawei.hianalytics.framework.data.WorkKeyHandler.f21750e     // Catch: java.lang.Throwable -> L4f
            if (r3 == 0) goto L52
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r12 = r3.getWorkKeyBeanFromDisk()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r12.workKey     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = r12.encrypted     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = r12.pubKeyVer     // Catch: java.lang.Throwable -> L4f
            long r3 = r12.uploadTime     // Catch: java.lang.Throwable -> L4f
            long r5 = r12.keyTtlTime     // Catch: java.lang.Throwable -> L4f
            int r12 = r12.getSource()     // Catch: java.lang.Throwable -> L4f
            r9 = r3
            r3 = r12
            r12 = r9
            goto L54
        L4f:
            r12 = move-exception
            goto Lc3
        L52:
            r3 = 0
            r5 = r12
        L54:
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L4f
            if (r4 != 0) goto L91
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L4f
            if (r4 != 0) goto L91
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L4f
            if (r4 != 0) goto L91
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L4f
            int r4 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r4 >= 0) goto L91
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 >= 0) goto L91
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r4 = r11.f21751a     // Catch: java.lang.Throwable -> L4f
            r4.setEncrypted(r1)     // Catch: java.lang.Throwable -> L4f
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r1 = r11.f21751a     // Catch: java.lang.Throwable -> L4f
            r1.setWorkKey(r0)     // Catch: java.lang.Throwable -> L4f
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r0 = r11.f21751a     // Catch: java.lang.Throwable -> L4f
            r0.setUploadTime(r12)     // Catch: java.lang.Throwable -> L4f
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r12 = r11.f21751a     // Catch: java.lang.Throwable -> L4f
            r12.setKeyTtlTime(r5)     // Catch: java.lang.Throwable -> L4f
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r12 = r11.f21751a     // Catch: java.lang.Throwable -> L4f
            r12.setPubKeyVer(r2)     // Catch: java.lang.Throwable -> L4f
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r12 = r11.f21751a     // Catch: java.lang.Throwable -> L4f
            r12.setSource(r3)     // Catch: java.lang.Throwable -> L4f
            goto L94
        L91:
            r11.m28851a()     // Catch: java.lang.Throwable -> L4f
        L94:
            com.huawei.hianalytics.framework.data.WorkKeyHandler$WorkKeyBean r12 = r11.f21751a     // Catch: java.lang.Throwable -> L4f
            int r12 = r12.getSource()     // Catch: java.lang.Throwable -> L4f
            r13 = 1
            if (r12 == r13) goto Lb8
            r11.m28852b()     // Catch: java.lang.Throwable -> L4f
            goto Lb8
        La1:
            long r12 = r11.getKeyTtl()     // Catch: java.lang.Throwable -> L4f
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L4f
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto Lb2
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 >= 0) goto Lb2
            goto Lb8
        Lb2:
            r11.m28851a()     // Catch: java.lang.Throwable -> L4f
            r11.m28852b()     // Catch: java.lang.Throwable -> L4f
        Lb8:
            monitor-exit(r11)
            return
        Lba:
            java.lang.String r12 = "WorkKeyHandler"
            java.lang.String r13 = "get rsa pubkey config error"
            com.huawei.hianalytics.core.log.HiLog.m28811sw(r12, r13)     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r11)
            return
        Lc3:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.framework.data.WorkKeyHandler.refreshKey(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28849a(WorkKeyBean workKeyBean) {
        if (workKeyBean == null) {
            return;
        }
        this.f21751a.setPubKeyVer(workKeyBean.pubKeyVer);
        this.f21751a.setWorkKey(workKeyBean.workKey);
        this.f21751a.setEncrypted(workKeyBean.encrypted);
        this.f21751a.setKeyTtlTime(workKeyBean.keyTtlTime);
        this.f21751a.setUploadTime(workKeyBean.uploadTime);
        this.f21751a.setSource(workKeyBean.source);
    }

    /* renamed from: a */
    public final void m28851a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM62473e = C10048b.m62473e(16);
        String strRsaEncrypt = C4757d.f21744e.f21745a.rsaEncrypt(this.f21752b, this.f21753c, strM62473e);
        String str = this.f21753c;
        long j10 = InterfaceC4756c.f21743a + jCurrentTimeMillis;
        this.f21751a.setEncrypted(strRsaEncrypt);
        this.f21751a.setWorkKey(strM62473e);
        this.f21751a.setUploadTime(jCurrentTimeMillis);
        this.f21751a.setKeyTtlTime(j10);
        this.f21751a.setPubKeyVer(str);
        this.f21751a.setSource(0);
        IAesKeyGetter iAesKeyGetter = f21750e;
        if (iAesKeyGetter != null) {
            iAesKeyGetter.saveWorkKeyBeanToDisk(this.f21751a);
        }
    }
}
