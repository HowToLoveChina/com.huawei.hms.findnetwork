package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import p694v.C13310l;

/* renamed from: androidx.core.app.b */
/* loaded from: classes.dex */
public class C0610b {

    /* renamed from: a */
    public static final Object f3395a = new Object();

    /* renamed from: b */
    public static final Object f3396b = new Object();

    /* renamed from: a */
    public static Bundle m3850a(NotificationCompat.C0604a c0604a) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatM3829d = c0604a.m3829d();
        bundle.putInt("icon", iconCompatM3829d != null ? iconCompatM3829d.m3913l() : 0);
        bundle.putCharSequence("title", c0604a.m3833h());
        bundle.putParcelable("actionIntent", c0604a.m3826a());
        Bundle bundle2 = c0604a.m3828c() != null ? new Bundle(c0604a.m3828c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", c0604a.m3827b());
        bundle.putBundle(JsbMapKeyNames.H5_EXTRAS, bundle2);
        bundle.putParcelableArray("remoteInputs", m3852c(c0604a.m3830e()));
        bundle.putBoolean("showsUserInterface", c0604a.m3832g());
        bundle.putInt("semanticAction", c0604a.m3831f());
        return bundle;
    }

    /* renamed from: b */
    public static Bundle m3851b(C13310l c13310l) {
        new Bundle();
        throw null;
    }

    /* renamed from: c */
    public static Bundle[] m3852c(C13310l[] c13310lArr) {
        if (c13310lArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c13310lArr.length];
        for (int i10 = 0; i10 < c13310lArr.length; i10++) {
            C13310l c13310l = c13310lArr[i10];
            bundleArr[i10] = m3851b(null);
        }
        return bundleArr;
    }
}
