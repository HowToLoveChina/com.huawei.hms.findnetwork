package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import as.C1016d;
import com.huawei.hms.network.embedded.C5843a0;
import com.huawei.location.lite.common.chain.C6780d;
import com.huawei.location.lite.common.chain.C6782f;
import com.huawei.location.lite.common.chain.C6783g;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.InterfaceC6781e;
import java.io.File;

/* renamed from: com.huawei.location.lite.common.util.filedownload.a */
/* loaded from: classes8.dex */
public class C6795a implements InterfaceC6781e {

    /* renamed from: a */
    public DownloadFileParam f31388a;

    /* renamed from: b */
    public InterfaceC6800f f31389b;

    /* renamed from: c */
    public InterfaceC6799e f31390c;

    public C6795a(DownloadFileParam downloadFileParam) {
        this.f31388a = downloadFileParam;
    }

    @Override // com.huawei.location.lite.common.chain.InterfaceC6781e
    /* renamed from: a */
    public void mo38415a(Data data) {
        InterfaceC6799e interfaceC6799e = this.f31390c;
        if (interfaceC6799e != null) {
            interfaceC6799e.onFail(data.m38396a("download_result_code_key", 0), data.m38399d("download_result_desc_key"));
        }
    }

    @Override // com.huawei.location.lite.common.chain.InterfaceC6781e
    /* renamed from: b */
    public void mo38416b(Data data) {
        String str;
        C1016d.m6186f("DownLoadFileManager", "download file Success.");
        if (this.f31390c == null) {
            str = "iDownloadResult is empty.please setting";
        } else {
            Parcelable parcelableM38398c = data.m38398c("download_entity");
            if (parcelableM38398c instanceof DownLoadFileBean) {
                DownLoadFileBean downLoadFileBean = (DownLoadFileBean) parcelableM38398c;
                if (data.m38397b().get("download_file") instanceof File) {
                    this.f31390c.onSuccess(downLoadFileBean, (File) data.m38397b().get("download_file"));
                    return;
                }
                return;
            }
            str = "return data exception";
        }
        C1016d.m6183c("DownLoadFileManager", str);
    }

    /* renamed from: c */
    public void m38476c(InterfaceC6799e interfaceC6799e) {
        this.f31390c = interfaceC6799e;
        C6782f c6782f = new C6782f();
        c6782f.m38434j(C5843a0.f26297c);
        c6782f.m38432h(new Data.C6776a().m38405f("download_file_param", this.f31388a).m38400a());
        c6782f.m38436l(this);
        C6780d.b bVar = new C6780d.b();
        bVar.m38422c(new C6798d());
        C6797c c6797c = new C6797c();
        c6797c.m38483h(this.f31389b);
        bVar.m38422c(c6797c);
        try {
            bVar.m38424e(c6782f).m38423d().m38419e();
        } catch (C6783g unused) {
            C1016d.m6183c("DownLoadFileManager", "download file timeout");
        }
    }

    public C6795a(DownloadFileParam downloadFileParam, InterfaceC6800f interfaceC6800f) {
        this(downloadFileParam);
        this.f31389b = interfaceC6800f;
    }
}
