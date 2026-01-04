package p572qb;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1006a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p664u0.C13108a;

/* renamed from: qb.w */
/* loaded from: classes3.dex */
public class C12331w extends AbstractC12367d {

    /* renamed from: d */
    public static final Uri f57086d = Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI);

    /* renamed from: a */
    public boolean f57087a;

    /* renamed from: b */
    public boolean f57088b;

    /* renamed from: c */
    public int f57089c;

    public C12331w(boolean z10, boolean z11, int i10) {
        this.f57087a = z10;
        this.f57088b = z11;
        this.f57089c = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        Context contextM1377a = C0213f.m1377a();
        boolean zM5975v = C1006a.m5936k().m5975v(contextM1377a);
        boolean zM5976w = C1006a.m5936k().m5976w(contextM1377a);
        C11839m.m70688i("NotifyGalleryUpgradeSpaceTask", "isInheritSwitchOn is: " + zM5976w);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", zM5976w);
        if (!zM5975v) {
            C1006a.m5936k().m5958d();
            if (zM5976w && this.f57088b) {
                C11839m.m70688i("NotifyGalleryUpgradeSpaceTask", "notify open album sync switch");
                C1006a.m5936k().m5943G(contextM1377a, bundle, this.f57089c);
            }
            C11839m.m70688i("NotifyGalleryUpgradeSpaceTask", "album sync switch is close, needLocalBroadcast: " + this.f57087a);
            if (this.f57087a) {
                Intent intent = new Intent();
                intent.setAction("com.huawei.hicloud.intent.action.ACTION_OPEN_ALBUM_SWITCH");
                C13108a.m78878b(contextM1377a).m78881d(intent);
                return;
            }
            return;
        }
        C11839m.m70689w("NotifyGalleryUpgradeSpaceTask", "album sync switch is open.");
        try {
            Thread.sleep(10000L);
        } catch (Exception e10) {
            C11839m.m70687e("NotifyGalleryUpgradeSpaceTask", "tryToSleep exception: " + e10);
        }
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                Uri uri = f57086d;
                if (!C0209d.m1227Y1(contextM1377a, uri)) {
                    C11839m.m70687e("NotifyGalleryUpgradeSpaceTask", "notifyGalleryOfPackageChange, TargetApp is not SystemApp");
                    return;
                }
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contextM1377a.getContentResolver().acquireUnstableContentProviderClient(uri);
                try {
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        contentProviderClientAcquireUnstableContentProviderClient.call("notifyGalleryChange", null, null);
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    } else {
                        C11839m.m70689w("NotifyGalleryUpgradeSpaceTask", "cpClient is null");
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    C11839m.m70687e("NotifyGalleryUpgradeSpaceTask", "notifyGalleryOfPackageChange exception=" + e.toString());
                    if (contentProviderClient != null) {
                        contentProviderClient.release();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    if (contentProviderClient != null) {
                        contentProviderClient.release();
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.FAMILY_SHARE;
    }
}
