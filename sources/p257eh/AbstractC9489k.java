package p257eh;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import hu.C10343b;

/* renamed from: eh.k */
/* loaded from: classes4.dex */
public abstract class AbstractC9489k {
    /* renamed from: a */
    public static boolean m59348a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("sdk_install_issupport") || new C10343b(bundle).m63686h("sdk_install_issupport") != 1) ? false : true;
    }
}
