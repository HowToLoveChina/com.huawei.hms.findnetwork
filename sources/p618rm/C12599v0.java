package p618rm;

import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import java.util.function.ToLongFunction;

/* renamed from: rm.v0 */
/* loaded from: classes6.dex */
public final /* synthetic */ class C12599v0 implements ToLongFunction {
    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((CBSBackupRecord) obj).getEndTime();
    }
}
