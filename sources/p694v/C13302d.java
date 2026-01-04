package p694v;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* renamed from: v.d */
/* loaded from: classes.dex */
public final class C13302d {

    /* renamed from: v.d$a */
    public static class a {
        /* renamed from: a */
        public static Intent m79776a(Activity activity) {
            return activity.getParentActivityIntent();
        }

        /* renamed from: b */
        public static boolean m79777b(Activity activity, Intent intent) {
            return activity.navigateUpTo(intent);
        }

        /* renamed from: c */
        public static boolean m79778c(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }
    }

    /* renamed from: a */
    public static Intent m79770a(Activity activity) {
        Intent intentM79776a = a.m79776a(activity);
        if (intentM79776a != null) {
            return intentM79776a;
        }
        String strM79772c = m79772c(activity);
        if (strM79772c == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, strM79772c);
        try {
            return m79773d(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strM79772c + "' in manifest");
            return null;
        }
    }

    /* renamed from: b */
    public static Intent m79771b(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strM79773d = m79773d(context, componentName);
        if (strM79773d == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strM79773d);
        return m79773d(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    /* renamed from: c */
    public static String m79772c(Activity activity) {
        try {
            return m79773d(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    /* renamed from: d */
    public static String m79773d(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, 269222528);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    /* renamed from: e */
    public static void m79774e(Activity activity, Intent intent) {
        a.m79777b(activity, intent);
    }

    /* renamed from: f */
    public static boolean m79775f(Activity activity, Intent intent) {
        return a.m79778c(activity, intent);
    }
}
