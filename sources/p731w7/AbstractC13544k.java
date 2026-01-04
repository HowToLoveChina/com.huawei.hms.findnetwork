package p731w7;

import com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

/* renamed from: w7.k */
/* loaded from: classes2.dex */
public abstract class AbstractC13544k<T> extends AbstractC13540g<T> {

    /* renamed from: l */
    public int f60931l;

    /* renamed from: m */
    public WeakReference<OnResponseListener<T>> f60932m;

    /* renamed from: n */
    public BlockingQueue<?> f60933n;

    @Override // p731w7.AbstractC13540g
    /* renamed from: E */
    public void mo81462E(int i10, OnResponseListener<T> onResponseListener) {
        this.f60931l = i10;
        this.f60932m = new WeakReference<>(onResponseListener);
    }

    @Override // p731w7.AbstractC13540g
    /* renamed from: F */
    public OnResponseListener<T> mo81463F() {
        WeakReference<OnResponseListener<T>> weakReference = this.f60932m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // p731w7.AbstractC13540g
    /* renamed from: G */
    public int mo81464G() {
        return this.f60931l;
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.able.Queueable
    /* renamed from: a */
    public boolean mo15141a() {
        BlockingQueue<?> blockingQueue = this.f60933n;
        return blockingQueue != null && blockingQueue.contains(this);
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.able.Queueable
    /* renamed from: b */
    public void mo15142b(BlockingQueue<?> blockingQueue) {
        this.f60933n = blockingQueue;
    }

    @Override // p731w7.AbstractC13539f, p731w7.AbstractC13534a
    /* renamed from: e */
    public void mo81428e() {
        BlockingQueue<?> blockingQueue = this.f60933n;
        if (blockingQueue != null) {
            blockingQueue.remove(this);
        }
        super.mo81428e();
    }
}
