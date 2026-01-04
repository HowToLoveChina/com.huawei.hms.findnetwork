package ss;

import as.C1016d;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6799e;
import java.io.File;

/* renamed from: ss.a */
/* loaded from: classes8.dex */
public final class C12848a implements InterfaceC6799e {

    /* renamed from: a */
    public final /* synthetic */ C12850c f58588a;

    public C12848a(C12850c c12850c) {
        this.f58588a = c12850c;
    }

    @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
    public final void onFail(int i10, String str) {
        if (i10 == 10005) {
            this.f58588a.f58590a.m59626d("libSdm_last_time", System.currentTimeMillis());
        }
        C1016d.m6183c("SdmFileManager", "download error errorCode:" + i10 + " errorDesc:" + str);
    }

    @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6799e
    public final void onSuccess(DownLoadFileBean downLoadFileBean, File file) {
        if (downLoadFileBean == null) {
            return;
        }
        C12850c.m77158e(this.f58588a, file, downLoadFileBean.getFileAccessInfo().getFileSha256(), downLoadFileBean.getFileAccessInfo().getVersion());
    }
}
