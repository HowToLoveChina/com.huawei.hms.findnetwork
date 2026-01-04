package p384j4;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import p384j4.AbstractC10702a;

/* renamed from: j4.g */
/* loaded from: classes.dex */
public abstract class AbstractC10708g {
    /* renamed from: a */
    public static <RESULT> Future<RESULT> m65387a(Callable<RESULT> callable) {
        if (callable == null) {
            return null;
        }
        return AbstractC10702a.m65322a(callable, AbstractC10702a.b.SYNC_CALL);
    }
}
