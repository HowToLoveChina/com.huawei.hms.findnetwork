package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.os.PowerManager;
import android.util.SparseArray;

@Deprecated
/* loaded from: classes.dex */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static final SparseArray<PowerManager.WakeLock> f4102a = new SparseArray<>();

    /* renamed from: b */
    public static int f4103b = 1;
}
