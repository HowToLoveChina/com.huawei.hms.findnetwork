package vc;

import com.huawei.android.hicloud.connect.progress.ICallback;

/* renamed from: vc.h */
/* loaded from: classes3.dex */
public class C13404h implements ICallback {

    /* renamed from: a */
    public boolean f60476a;

    /* renamed from: b */
    public int f60477b;

    /* renamed from: b */
    public int m80589b() {
        return this.f60477b;
    }

    /* renamed from: c */
    public boolean m80590c() {
        return this.f60476a;
    }

    /* renamed from: d */
    public boolean mo80533d() {
        return true;
    }

    /* renamed from: e */
    public void m80591e(boolean z10, int i10) {
        this.f60476a = z10;
        this.f60477b = i10;
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICallback
    public void onProgress(long j10, long j11) {
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICallback
    public boolean onStop() {
        return this.f60476a;
    }
}
