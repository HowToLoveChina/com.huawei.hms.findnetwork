package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.huawei.hiar.ARImageMetadata;
import p243e0.C9373h;

/* loaded from: classes.dex */
public class ShareCompat$IntentBuilder {

    /* renamed from: a */
    public final Context f3384a;

    /* renamed from: b */
    public final Intent f3385b;

    public ShareCompat$IntentBuilder(Context context) {
        Activity activity;
        this.f3384a = (Context) C9373h.m58745f(context);
        Intent action = new Intent().setAction("android.intent.action.SEND");
        this.f3385b = action;
        action.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
        action.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
        action.addFlags(ARImageMetadata.LENS_APERTURE);
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity != null) {
            ComponentName componentName = activity.getComponentName();
            this.f3385b.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f3385b.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
        }
    }
}
