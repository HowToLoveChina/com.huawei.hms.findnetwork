package p217d5;

import android.os.Handler;
import android.os.Message;

/* renamed from: d5.a */
/* loaded from: classes.dex */
public class C9040a {
    /* renamed from: a */
    public static boolean m57001a(Handler.Callback callback, int i10) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain((Handler) null, i10));
    }

    /* renamed from: b */
    public static boolean m57002b(Handler.Callback callback, int i10, int i11, int i12, Object obj) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain(null, i10, i11, i12, obj));
    }
}
