package ss;

import as.C1016d;
import com.huawei.location.lite.common.util.filedownload.DownLoadFileBean;
import com.huawei.location.lite.common.util.filedownload.InterfaceC6800f;
import java.io.File;
import rs.C12621a;

/* renamed from: ss.b */
/* loaded from: classes8.dex */
public final class C12849b implements InterfaceC6800f {

    /* renamed from: a */
    public final /* synthetic */ C12850c f58589a;

    public C12849b(C12850c c12850c) {
        this.f58589a = c12850c;
    }

    @Override // com.huawei.location.lite.common.util.filedownload.InterfaceC6800f
    /* renamed from: a */
    public final boolean mo38290a(DownLoadFileBean downLoadFileBean) {
        String version = downLoadFileBean.getFileAccessInfo().getVersion();
        this.f58589a.getClass();
        File file = new File(C12621a.f58056b);
        C1016d.m6186f("SdmFileManager", "the file isFileExist is " + file.exists());
        if (file.exists()) {
            String str = this.f58589a.f58591b;
            C1016d.m6186f("SdmFileManager", "versionNumFromServer is: " + version + ", versionNumSp is: " + str);
            if (version.compareTo(str) <= 0) {
                return false;
            }
        }
        return true;
    }
}
