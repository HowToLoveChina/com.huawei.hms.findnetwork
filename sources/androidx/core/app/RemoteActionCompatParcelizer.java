package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
import p025b1.AbstractC1096a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC1096a abstractC1096a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f3378a = (IconCompat) abstractC1096a.m6531v(remoteActionCompat.f3378a, 1);
        remoteActionCompat.f3379b = abstractC1096a.m6521l(remoteActionCompat.f3379b, 2);
        remoteActionCompat.f3380c = abstractC1096a.m6521l(remoteActionCompat.f3380c, 3);
        remoteActionCompat.f3381d = (PendingIntent) abstractC1096a.m6527r(remoteActionCompat.f3381d, 4);
        remoteActionCompat.f3382e = abstractC1096a.m6517h(remoteActionCompat.f3382e, 5);
        remoteActionCompat.f3383f = abstractC1096a.m6517h(remoteActionCompat.f3383f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC1096a abstractC1096a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC1096a.m6533x(false, false);
        abstractC1096a.m6508M(remoteActionCompat.f3378a, 1);
        abstractC1096a.m6499D(remoteActionCompat.f3379b, 2);
        abstractC1096a.m6499D(remoteActionCompat.f3380c, 3);
        abstractC1096a.m6503H(remoteActionCompat.f3381d, 4);
        abstractC1096a.m6535z(remoteActionCompat.f3382e, 5);
        abstractC1096a.m6535z(remoteActionCompat.f3383f, 6);
    }
}
