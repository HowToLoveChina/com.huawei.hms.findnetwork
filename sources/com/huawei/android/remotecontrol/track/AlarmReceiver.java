package com.huawei.android.remotecontrol.track;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class AlarmReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public static void m26864a(Context context) {
        C13981a.m83989i("AlarmReceiver", "alarm cancel");
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 1073741824));
    }

    /* renamed from: b */
    public static void m26865b(Context context, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        long jCurrentTimeMillis = System.currentTimeMillis() + j10;
        C13981a.m83987d("AlarmReceiver", "alarm trigger at " + jCurrentTimeMillis);
        alarmManager.setExactAndAllowWhileIdle(0, jCurrentTimeMillis, PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 1073741824));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C13981a.m83989i("AlarmReceiver", "alarm receiver start task");
        LocateTrackEventManager.m26909a().m26912d(context, false);
    }
}
