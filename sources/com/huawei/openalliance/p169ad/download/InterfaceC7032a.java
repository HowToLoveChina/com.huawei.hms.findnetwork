package com.huawei.openalliance.p169ad.download;

import com.huawei.openalliance.p169ad.download.DownloadTask;

/* renamed from: com.huawei.openalliance.ad.download.a */
/* loaded from: classes2.dex */
public interface InterfaceC7032a<T extends DownloadTask> {
    /* renamed from: a */
    void mo42099a(T t10);

    /* renamed from: a */
    void mo42100a(T t10, boolean z10);

    /* renamed from: b */
    void mo42101b(T t10);

    /* renamed from: b */
    void mo42102b(T t10, boolean z10);

    /* renamed from: c */
    void mo42103c(T t10, boolean z10);

    void onDownloadFail(T t10);

    void onDownloadProgress(T t10);

    void onDownloadStart(T t10);

    void onDownloadSuccess(T t10);

    void onDownloadWaiting(T t10);
}
