package com.huawei.location.activity;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6800f;
import p531or.C11991a;

/* renamed from: com.huawei.location.activity.c */
/* loaded from: classes8.dex */
public final class C6736c implements InterfaceC6800f {

    /* renamed from: a */
    public final /* synthetic */ String f31190a;

    /* renamed from: b */
    public final /* synthetic */ String f31191b;

    /* renamed from: c */
    public final /* synthetic */ C6735b f31192c;

    public C6736c(C6735b c6735b, String str, String str2) {
        this.f31192c = c6735b;
        this.f31190a = str;
        this.f31191b = str2;
    }

    @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6800f
    /* renamed from: a */
    public final boolean mo38290a(com.huawei.location.lite.common.util.filedownload.DownLoadFileBean downLoadFileBean) {
        C1016d.m6186f("ModelFileManager", "is Support DownloadFile");
        String strM59624b = this.f31192c.f31188b.m59624b(this.f31190a);
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        if (C6735b.m38286i(this.f31192c, C11991a.m72145a(), this.f31191b)) {
            this.f31192c.getClass();
            C1016d.m6186f("ModelFileManager", "versionNumFromServer is: " + version + ", versionNumSp is: " + strM59624b);
            if (TextUtils.isEmpty(version) || TextUtils.isEmpty(strM59624b) || version.compareTo(strM59624b) <= 0) {
                return false;
            }
        }
        return true;
    }
}
