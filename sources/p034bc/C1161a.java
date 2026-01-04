package p034bc;

import android.content.Intent;
import android.util.SparseArray;
import com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultHandler;
import com.huawei.android.hicloud.oobe.p086ui.manager.IActivityResultObservable;
import p015ak.C0219i;
import p514o9.C11839m;

/* renamed from: bc.a */
/* loaded from: classes3.dex */
public class C1161a<T extends IActivityResultObservable> {

    /* renamed from: a */
    public SparseArray<IActivityResultHandler> f5460a = new SparseArray<>();

    /* renamed from: a */
    public void m7254a(T t10, int i10, int i11, Intent intent) {
        C11839m.m70686d("ActivityResultObserver", "handleResult resultCode " + i10 + ", resultCode " + i11);
        synchronized (C1161a.class) {
            try {
                IActivityResultHandler iActivityResultHandler = this.f5460a.get(i10);
                if (iActivityResultHandler == null) {
                    C11839m.m70687e("ActivityResultObserver", "cannot find result handler, requestCode:" + i10);
                    t10.mo17028f0(i10, i11, intent);
                    return;
                }
                if (i10 == 10014 && i11 == 0 && C0219i.m1465c()) {
                    iActivityResultHandler.mo17026b(t10, i11, intent);
                    return;
                }
                if (i10 == 10014 && i11 == 4) {
                    iActivityResultHandler.mo17026b(t10, i11, intent);
                } else if (i11 == -1) {
                    iActivityResultHandler.mo17025a(t10, intent);
                } else if (i11 == 0) {
                    iActivityResultHandler.mo17027c(t10, intent);
                } else {
                    iActivityResultHandler.mo17026b(t10, i11, intent);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m7255b(int i10, IActivityResultHandler iActivityResultHandler) {
        synchronized (C1161a.class) {
            this.f5460a.put(i10, iActivityResultHandler);
        }
    }

    /* renamed from: c */
    public void m7256c() {
        synchronized (C1161a.class) {
            this.f5460a.clear();
        }
    }
}
