package ae;

import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import java.util.function.ToLongFunction;

/* renamed from: ae.t1 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C0169t1 implements ToLongFunction {
    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((CloudRestoreItem) obj).getBytesDownloaded();
    }
}
