package com.huawei.location.activity;

import as.C1016d;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6799e;
import java.io.File;

/* renamed from: com.huawei.location.activity.a */
/* loaded from: classes8.dex */
public final class C6734a implements InterfaceC6799e {

    /* renamed from: a */
    public final /* synthetic */ String f31183a;

    /* renamed from: b */
    public final /* synthetic */ String f31184b;

    /* renamed from: c */
    public final /* synthetic */ C6735b f31185c;

    public C6734a(C6735b c6735b, String str, String str2) {
        this.f31185c = c6735b;
        this.f31183a = str;
        this.f31184b = str2;
    }

    @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
    public final void onFail(int i10, String str) {
        C1016d.m6183c("ModelFileManager", "download error errorCode:" + i10 + " errorDesc:" + str);
        if (i10 == 10005) {
            C1016d.m6186f("ModelFileManager", "download fail update the request time");
            this.f31185c.f31188b.m59626d(this.f31184b, System.currentTimeMillis());
        }
        C6735b.m38283e(this.f31185c, this.f31183a);
    }

    @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
    public final void onSuccess(com.huawei.location.lite.common.util.filedownload.DownLoadFileBean downLoadFileBean, File file) {
        C1016d.m6186f("ModelFileManager", "download success:");
        if (downLoadFileBean == null || file == null) {
            C1016d.m6183c("ModelFileManager", "file or downLoadFileBean is null");
            C6735b.m38283e(this.f31185c, this.f31183a);
        } else {
            C1016d.m6186f("ModelFileManager", "file and downLoadFileBean is not null begin downLoadSuccessDeal");
            C6735b.m38284f(this.f31185c, this.f31183a, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
        }
    }
}
