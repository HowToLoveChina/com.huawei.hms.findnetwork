package com.huawei.location.activity;

import android.content.Context;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.util.filedownload.C6795a;
import com.huawei.location.lite.common.util.filedownload.DownloadFileParam;
import es.C9544i;
import es.C9545j;
import es.C9549n;
import java.io.File;
import p237du.AbstractC9308a;
import p346hs.C10337b;
import p531or.C11991a;
import p622rr.C12619b;
import p749wq.InterfaceC13625a;

/* renamed from: com.huawei.location.activity.b */
/* loaded from: classes8.dex */
public final class C6735b {

    /* renamed from: d */
    public static boolean f31186d = false;

    /* renamed from: a */
    public int f31187a = 0;

    /* renamed from: b */
    public C9549n f31188b;

    /* renamed from: c */
    public InterfaceC13625a f31189c;

    /* renamed from: a */
    public static void m38281a() {
        throw new C12619b(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE, ActivityErrorCode.getErrorCodeMessage(ActivityErrorCode.ACTIVITY_IDENTIFICATION_NOT_AVAILABLE) + ":end request.");
    }

    /* renamed from: e */
    public static void m38283e(C6735b c6735b, String str) {
        c6735b.getClass();
        if (str.equals("activity.7z") && m38285h(C11991a.m72145a(), str)) {
            C1016d.m6186f("ModelFileManager", "so file is exists");
            c6735b.m38287b();
        } else if (str.equals("Ml_Location.net") && m38285h(C11991a.m72145a(), "Ml_Location.net")) {
            C1016d.m6186f("ModelFileManager", "model file is exists");
            c6735b.m38288d();
        } else {
            C1016d.m6183c("ModelFileManager", "model or so file is not exists");
            m38281a();
            throw null;
        }
    }

    /* renamed from: f */
    public static void m38284f(C6735b c6735b, String str, File file, String str2, String str3) {
        c6735b.getClass();
        boolean zM58613e = AbstractC9308a.m58613e(file, str2);
        StringBuilder sb2 = new StringBuilder();
        String str4 = C6737d.f31193a;
        String strM38291a = C6738e.m38291a(sb2, str4, str);
        if (!str.equals("activity.7z")) {
            if (!zM58613e) {
                C1016d.m6183c("ModelFileManager", "model file is not integrity");
                c6735b.f31188b.m59627e("spModelVersionNum", "-1");
                c6735b.f31188b.m59626d("spModelLastTime", System.currentTimeMillis() - 604800000);
                m38281a();
                throw null;
            }
            C1016d.m6186f("ModelFileManager", "file is integrity");
            C1016d.m6186f("ModelFileManager", "save file success");
            c6735b.f31188b.m59627e("spModelVersionNum", str3);
            c6735b.f31188b.m59626d("spModelLastTime", System.currentTimeMillis());
            c6735b.m38288d();
            return;
        }
        if (!zM58613e) {
            C1016d.m6183c("ModelFileManager", "so file is not integrity");
            c6735b.f31188b.m59627e("spSoVersionNum", "-1");
            c6735b.f31188b.m59626d("spSoLastTime", System.currentTimeMillis() - 604800000);
            m38281a();
            throw null;
        }
        if (!new C10337b().mo63648a(strM38291a, str4)) {
            C1016d.m6186f("ModelFileManager", "unzip file fail!");
            m38281a();
            throw null;
        }
        c6735b.f31188b.m59627e("spSoVersionNum", str3);
        c6735b.f31188b.m59626d("spSoLastTime", System.currentTimeMillis());
        C1016d.m6186f("ModelFileManager", "unzip file success!");
        new File(strM38291a).delete();
        c6735b.m38287b();
    }

    /* renamed from: h */
    public static boolean m38285h(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            C1016d.m6183c("ModelFileManager", "file is empty");
            return false;
        }
        C1016d.m6181a("ModelFileManager", "judgement the file exists");
        if (str.equals("activity.7z")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C6737d.f31194b);
            file = new File(C6738e.m38291a(sb2, File.separator, "libml.so"));
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(C9545j.m59600a(context));
            file = new File(C6738e.m38291a(sb3, File.separator, str));
        }
        C1016d.m6186f("ModelFileManager", "file is not empty");
        return file.exists();
    }

    /* renamed from: i */
    public static /* synthetic */ boolean m38286i(C6735b c6735b, Context context, String str) {
        c6735b.getClass();
        return m38285h(context, str);
    }

    /* renamed from: b */
    public final void m38287b() {
        if (this.f31187a >= 3) {
            C1016d.m6183c("ModelFileManager", "maxTryTime failed, LoadSo is false");
            m38281a();
            throw null;
        }
        if (!f31186d) {
            f31186d = C9544i.m59599h("libml.so", C6737d.f31194b);
            C1016d.m6186f("ModelFileManager", "loadLocalSo result:" + f31186d);
        }
        if (!f31186d) {
            C1016d.m6183c("ModelFileManager", "hasLoadSo is false");
            this.f31187a++;
            m38287b();
            return;
        }
        C1016d.m6186f("ModelFileManager", "hasLoadSo is true prepareLoadModelFile:");
        C9549n c9549n = new C9549n("spModelFileName");
        this.f31188b = c9549n;
        long jM59623a = c9549n.m59623a("spModelLastTime");
        C1016d.m6186f("ModelFileManager", "sp--lastTimeMillis:" + jM59623a);
        if (System.currentTimeMillis() - jM59623a < 604800000 && m38285h(C11991a.m72145a(), "Ml_Location.net")) {
            C1016d.m6186f("ModelFileManager", "model file is exists and is not need update");
            m38288d();
            return;
        }
        C1016d.m6186f("ModelFileManager", "model file is not exists or determine whether the model file needs to be updated ");
        DownloadFileParam downloadFileParam = new DownloadFileParam();
        downloadFileParam.setFileName("Ml_Location.net");
        downloadFileParam.setSaveFilePath(C6737d.f31193a);
        downloadFileParam.setServiceType("activitityRecognition");
        downloadFileParam.setSubType(HiAnalyticsConstant.KeyAndValue.NUMBER_01);
        new C6795a(downloadFileParam, new C6736c(this, "spModelVersionNum", "Ml_Location.net")).m38476c(new C6734a(this, "Ml_Location.net", "spModelLastTime"));
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* renamed from: d */
    public final void m38288d() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.huawei.location.activity.C6737d.f31193a
            java.lang.String r2 = "Ml_Location.net"
            java.lang.String r0 = com.huawei.location.activity.C6738e.m38291a(r0, r1, r2)
            android.content.Context r1 = p531or.C11991a.m72145a()     // Catch: java.lang.Throwable -> L62
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L62
            int r0 = com.huawei.location.activity.util.JniUtils.loadModelByAssets(r1, r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = "ModelFileManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            if (r0 != 0) goto L36
            java.lang.String r3 = "Load ModelFile success resultCode:"
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            as.C1016d.m6186f(r1, r0)
            wq.a r4 = r4.f31189c
            if (r4 == 0) goto L35
            r4.modelFileLoadSuccess()
        L35:
            return
        L36:
            java.lang.String r3 = "Load ModelFile fail resultCode:"
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            as.C1016d.m6186f(r1, r0)
            es.n r0 = r4.f31188b
            java.lang.String r1 = "spModelVersionNum"
            java.lang.String r2 = "-1"
            r0.m59627e(r1, r2)
            es.n r4 = r4.f31188b
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 604800000(0x240c8400, double:2.988109026E-315)
            long r0 = r0 - r2
            java.lang.String r2 = "spModelLastTime"
            r4.m59626d(r2, r0)
            m38281a()
            r4 = 0
            throw r4
        L62:
            rr.b r4 = new rr.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 10301(0x283d, float:1.4435E-41)
            java.lang.String r2 = com.huawei.location.base.activity.constant.ActivityErrorCode.getErrorCodeMessage(r1)
            r0.append(r2)
            java.lang.String r2 = ":end request."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r4.<init>(r1, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.C6735b.m38288d():void");
    }

    /* renamed from: g */
    public final void m38289g(InterfaceC13625a interfaceC13625a) {
        this.f31189c = interfaceC13625a;
        C9549n c9549n = new C9549n("spSoFileName");
        this.f31188b = c9549n;
        long jM59623a = c9549n.m59623a("spSoLastTime");
        C1016d.m6186f("ModelFileManager", "sp--lastTimeMillis:" + jM59623a);
        if (System.currentTimeMillis() - jM59623a < 604800000 && m38285h(C11991a.m72145a(), "activity.7z")) {
            C1016d.m6186f("ModelFileManager", "so file is exists and is not need update");
            m38287b();
            return;
        }
        C1016d.m6186f("ModelFileManager", "so file is not exists or determine whether the model file needs to be updated ");
        DownloadFileParam downloadFileParam = new DownloadFileParam();
        downloadFileParam.setFileName("activity.7z");
        downloadFileParam.setSaveFilePath(C6737d.f31193a);
        downloadFileParam.setServiceType("activityRecognitionSo");
        downloadFileParam.setSubType("mlso");
        new C6795a(downloadFileParam, new C6736c(this, "spSoVersionNum", "activity.7z")).m38476c(new C6734a(this, "activity.7z", "spSoLastTime"));
    }
}
