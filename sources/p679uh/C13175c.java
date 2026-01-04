package p679uh;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: uh.c */
/* loaded from: classes4.dex */
public class C13175c {

    /* renamed from: a */
    public static ConnectivityManager f59699a;

    /* renamed from: a */
    public static int m79218a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static NetworkInfo m79219b(Context context) {
        ConnectivityManager connectivityManagerM79220c = m79220c(context);
        if (connectivityManagerM79220c != null) {
            return connectivityManagerM79220c.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: c */
    public static ConnectivityManager m79220c(Context context) {
        if (f59699a == null) {
            f59699a = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return f59699a;
    }

    /* renamed from: d */
    public static int m79221d(Context context) {
        return m79218a(m79219b(context));
    }

    /* renamed from: e */
    public static boolean m79222e(Context context) {
        ConnectivityManager connectivityManagerM79220c;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManagerM79220c = m79220c(context)) == null || (activeNetworkInfo = connectivityManagerM79220c.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }
}
