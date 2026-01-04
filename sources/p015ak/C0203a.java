package p015ak;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import p399jk.AbstractC10896a;

/* renamed from: ak.a */
/* loaded from: classes6.dex */
public class C0203a {
    /* renamed from: a */
    public static boolean m1124a(String str, Context context) throws SecurityException {
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            AbstractC10896a.m65886e("BaseActivityStackUtil", "ActivityManager is null");
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(10);
        if (runningTasks == null || runningTasks.isEmpty()) {
            AbstractC10896a.m65886e("BaseActivityStackUtil", "runningTask is null or empty");
            return false;
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            if (runningTaskInfo != null && (componentName = runningTaskInfo.baseActivity) != null) {
                String className = componentName.getClassName();
                if (!TextUtils.isEmpty(className) && className.equals(str)) {
                    AbstractC10896a.m65885d("BaseActivityStackUtil", "activity is in running stack top 10");
                    return true;
                }
            }
        }
        AbstractC10896a.m65885d("BaseActivityStackUtil", "activity not running in stack top 10");
        return false;
    }
}
