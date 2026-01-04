package p252e9;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import p015ak.C0209d;
import p015ak.C0213f;
import p313g9.C9895a;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: e9.g */
/* loaded from: classes3.dex */
public class C9430g {

    /* renamed from: e */
    public static final Object f47117e = new Object();

    /* renamed from: a */
    public final c f47118a;

    /* renamed from: b */
    public C9895a f47119b;

    /* renamed from: c */
    public C9895a f47120c;

    /* renamed from: d */
    public long f47121d;

    /* renamed from: e9.g$b */
    public static class b {

        /* renamed from: a */
        public static final C9430g f47122a = new C9430g();
    }

    /* renamed from: e9.g$c */
    public static class c extends Handler {
        public c() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 100) {
                new HiCloudNotificationManager(C0213f.m1377a()).sendCloudAlbumReleaseSpace((String) message.obj);
                C9430g.m59138a().m59143f(C0213f.m1377a());
            } else {
                if (i10 != 102) {
                    C9430g.m59138a().m59143f(C0213f.m1377a());
                    return;
                }
                C9430g.m59138a().m59142e(((Long) message.obj).longValue());
                C9430g.m59138a().m59144g(C0213f.m1377a());
                C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent(RecommendCardConstants.ACTION_ALBUM_CHECK_SIZE_FINISH));
            }
        }
    }

    /* renamed from: a */
    public static C9430g m59138a() {
        return b.f47122a;
    }

    /* renamed from: b */
    public long m59139b() {
        return this.f47121d;
    }

    /* renamed from: c */
    public void m59140c(Context context) {
        if (context == null) {
            C11839m.m70689w("CommonObserverManager", "registerCheckAlbumSpaceSizeObserver: context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70689w("CommonObserverManager", "registerCallLogChangeObserver: contentResolver is null");
            return;
        }
        try {
            synchronized (f47117e) {
                try {
                    if (!C0209d.m1227Y1(context, Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI))) {
                        C11839m.m70687e("CommonObserverManager", "is not Target App or System App");
                        return;
                    }
                    if (this.f47119b == null) {
                        this.f47119b = new C9895a(context, this.f47118a);
                        contentResolver.registerContentObserver(Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI), true, this.f47119b);
                    }
                } finally {
                }
            }
        } catch (Exception unused) {
            C11839m.m70689w("CommonObserverManager", "registerCheckAlbumSpaceSizeObserver exception.");
        }
    }

    /* renamed from: d */
    public void m59141d(Context context) {
        if (context == null) {
            C11839m.m70689w("CommonObserverManager", "registerCheckAlbumSpaceSizeObserver: context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70689w("CommonObserverManager", "registerCallLogChangeObserver: contentResolver is null");
            return;
        }
        try {
            synchronized (f47117e) {
                try {
                    if (!C0209d.m1227Y1(context, Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI))) {
                        C11839m.m70687e("CommonObserverManager", "is not Target App or System App");
                        return;
                    }
                    if (this.f47120c == null) {
                        this.f47120c = new C9895a(context, this.f47118a, true);
                        contentResolver.registerContentObserver(Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI), true, this.f47120c);
                    }
                } finally {
                }
            }
        } catch (Exception unused) {
            C11839m.m70689w("CommonObserverManager", "registerCheckAlbumSpaceSizeObserver exception.");
        }
    }

    /* renamed from: e */
    public void m59142e(long j10) {
        this.f47121d = j10;
    }

    /* renamed from: f */
    public void m59143f(Context context) {
        if (context == null) {
            C11839m.m70689w("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver: context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70689w("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver: contentResolver is null");
            return;
        }
        C11839m.m70688i("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver");
        try {
            synchronized (f47117e) {
                try {
                    C9895a c9895a = this.f47119b;
                    if (c9895a != null) {
                        contentResolver.unregisterContentObserver(c9895a);
                        this.f47119b = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception unused) {
            C11839m.m70689w("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver exception.");
        }
    }

    /* renamed from: g */
    public void m59144g(Context context) {
        if (context == null) {
            C11839m.m70689w("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver: context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70689w("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver: contentResolver is null");
            return;
        }
        C11839m.m70688i("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver");
        try {
            synchronized (f47117e) {
                try {
                    C9895a c9895a = this.f47120c;
                    if (c9895a != null) {
                        contentResolver.unregisterContentObserver(c9895a);
                        this.f47120c = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception unused) {
            C11839m.m70689w("CommonObserverManager", "unRegisterCheckAlbumSpaceSizeObserver exception.");
        }
    }

    public C9430g() {
        this.f47118a = new c();
    }
}
