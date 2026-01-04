package com.huawei.android.remotecontrol.lockscreen;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.remotecontrol.p093ui.LockCallActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.List;
import p394jf.C10814b;
import p520of.C11860j;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class LockReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static LockReceiver f19848a;

    /* renamed from: b */
    public static String f19849b;

    /* renamed from: c */
    public static String f19850c;

    /* renamed from: d */
    public static String f19851d;

    /* renamed from: a */
    public static synchronized LockReceiver m26251a(String str, String str2, String str3) {
        try {
            f19849b = str;
            f19850c = str2;
            f19851d = str3;
            if (f19848a == null) {
                f19848a = new LockReceiver();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f19848a;
    }

    /* renamed from: b */
    public void m26252b(Context context) throws SecurityException {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = runningTasks.get(0).topActivity;
            if ("com.android.incallui.InCallActivity".equals(componentName.getClassName()) || "com.huawei.android.remotecontrol.alarm.AlarmActivity".equals(componentName.getClassName())) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) LockCallActivity.class);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("hw_frp_token", C11860j.m71009N());
        intent.putExtra("message", f19849b);
        intent.putExtra("email", f19851d);
        intent.putExtra("phoneNum", f19850c);
        context.startActivity(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws SecurityException {
        String action = new HiCloudSafeIntent(intent).getAction();
        C13981a.m83989i("LockReceiver", "startLockCallActivity action=" + action);
        if ("android.intent.action.SCREEN_ON".equals(action) || "android.intent.action.PHONE_STATE".equals(action) || "com.huawei.android.remotecontrol.ACTION_START_LOCKACTIVITY".equals(action)) {
            m26252b(context);
        } else if (("android.intent.action.USER_PRESENT".equals(action) || "com.huawei.android.remotecontrol.UNREGISTER_ACTION_SCREEN_ON".equals(action)) && f19848a != null) {
            C10814b.m65858a().m65861d(context);
        }
    }
}
