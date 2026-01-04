package com.huawei.location.lite.common.util.filedownload;

import android.os.Parcelable;
import as.C1016d;
import com.huawei.location.lite.common.chain.AbstractC6777a;
import com.huawei.location.lite.common.chain.C6782f;
import com.huawei.location.lite.common.chain.Data;
import com.huawei.location.lite.common.chain.InterfaceC6778b;

/* renamed from: com.huawei.location.lite.common.util.filedownload.b */
/* loaded from: classes8.dex */
public class C6796b implements InterfaceC6778b {

    /* renamed from: a */
    public C6782f f31391a;

    /* renamed from: b */
    public InterfaceC6778b.a f31392b;

    /* renamed from: c */
    public DownloadFileParam f31393c;

    @Override // com.huawei.location.lite.common.chain.InterfaceC6778b
    /* renamed from: a */
    public void mo38411a(InterfaceC6778b.a aVar) {
        this.f31392b = aVar;
        C6782f c6782fMo38412a = aVar.mo38412a();
        this.f31391a = c6782fMo38412a;
        Parcelable parcelableM38398c = c6782fMo38412a.m38425a().m38398c("download_file_param");
        if (parcelableM38398c instanceof DownloadFileParam) {
            this.f31393c = (DownloadFileParam) parcelableM38398c;
        } else {
            m38477b(10000, "param error");
        }
    }

    /* renamed from: b */
    public void m38477b(int i10, String str) {
        C1016d.m6183c("DownloadBaseTask", "download  failed:" + i10 + "desc:" + str);
        this.f31391a.m38435k(AbstractC6777a.m38408b(new Data.C6776a().m38404e("download_result_code_key", i10).m38406g("download_result_desc_key", str).m38400a()), this.f31392b);
    }
}
