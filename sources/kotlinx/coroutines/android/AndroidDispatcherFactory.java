package kotlinx.coroutines.android;

import android.os.Looper;
import cx.C8959a;
import cx.C8961c;
import java.util.List;
import kotlinx.coroutines.internal.InterfaceC11096m;
import p040bx.AbstractC1301c1;

/* loaded from: classes9.dex */
public final class AndroidDispatcherFactory implements InterfaceC11096m {
    @Override // kotlinx.coroutines.internal.InterfaceC11096m
    public AbstractC1301c1 createDispatcher(List<? extends InterfaceC11096m> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C8959a(C8961c.m56714a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // kotlinx.coroutines.internal.InterfaceC11096m
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.InterfaceC11096m
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}
