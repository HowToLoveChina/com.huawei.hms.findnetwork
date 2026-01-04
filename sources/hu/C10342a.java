package hu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.secure.android.common.intent.SafeIntent;
import p787xt.C13865a;

/* renamed from: hu.a */
/* loaded from: classes5.dex */
public class C10342a {
    /* renamed from: a */
    public static boolean m63675a(Intent intent) {
        boolean zM53582g = true;
        if (intent == null) {
            C13865a.m83189c("IntentUtils", "intent is null");
        } else if (intent instanceof SafeIntent) {
            C13865a.m83193g("IntentUtils", "safe intent");
            zM53582g = ((SafeIntent) intent).m53582g();
        } else {
            try {
                intent.getStringExtra("ANYTHING");
                zM53582g = false;
            } catch (Throwable unused) {
            }
        }
        if (zM53582g) {
            C13865a.m83189c("IntentUtils", "hasIntentBomb");
        }
        return zM53582g;
    }

    /* renamed from: b */
    public static boolean m63676b(Context context, Intent intent) {
        return m63677c(context, intent, null);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static boolean m63677c(Context context, Intent intent, Bundle bundle) {
        try {
            context.startActivity(intent, bundle);
            return true;
        } catch (ActivityNotFoundException e10) {
            C13865a.m83190d("IntentUtils", "safeStartActivity: ActivityNotFoundException ", e10);
            return false;
        } catch (Exception unused) {
            C13865a.m83189c("IntentUtils", "safeStartActivityForResult: Exception");
            return false;
        } catch (Throwable unused2) {
            C13865a.m83189c("IntentUtils", "safeStartActivityForResult: throwable");
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m63678d(Activity activity, Intent intent, int i10) {
        try {
            activity.startActivityForResult(intent, i10);
            return true;
        } catch (ActivityNotFoundException e10) {
            C13865a.m83190d("IntentUtils", "safeStartActivityForResult: ActivityNotFoundException ", e10);
            return false;
        } catch (Exception e11) {
            C13865a.m83190d("IntentUtils", "safeStartActivityForResult: Exception ", e11);
            return false;
        } catch (Throwable th2) {
            C13865a.m83190d("IntentUtils", "safeStartActivityForResult: throwable ", th2);
            return false;
        }
    }
}
