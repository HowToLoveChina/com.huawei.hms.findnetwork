package il;

import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import java.util.function.Predicate;

/* renamed from: il.j */
/* loaded from: classes6.dex */
public final /* synthetic */ class C10537j implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((Bak) obj).isTempBackup();
    }
}
