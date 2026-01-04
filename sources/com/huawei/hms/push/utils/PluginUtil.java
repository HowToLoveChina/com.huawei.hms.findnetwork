package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.C6290i;
import com.huawei.hms.push.C6293l;
import com.huawei.hms.push.C6294m;
import com.huawei.hms.push.C6299r;
import com.huawei.hms.push.C6301t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class PluginUtil {
    private PluginUtil() {
    }

    /* renamed from: a */
    private static void m36615a(Context context, String str, String str2, String str3) {
        HMSLog.m36988i("PluginUtil", "onNotification");
        if (!C6290i.m36530a(context)) {
            HMSLog.m36988i("PluginUtil", context.getPackageName() + " disable display notification.");
            C6293l.m36536a(context, str, null, "103");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        Charset charset = C6294m.f29674a;
        intent.putExtra("selfshow_info", str3.getBytes(charset));
        intent.putExtra("selfshow_token", str2.getBytes(charset));
        intent.setPackage(context.getPackageName());
        C6301t.m36601a(context, intent);
        HMSLog.m36988i("PluginUtil", "invokeSelfShow done");
    }

    public static void onAppOpened(Context context, String str, String str2, Bundle bundle) {
        C6293l.m36536a(context, str, str2, "appHasOpenedId");
        C6293l.m36535a(context, bundle, "hmsStatistics");
    }

    public static boolean onDataMessage(Context context, String str, String str2, boolean z10) {
        HMSLog.m36988i("PluginUtil", "onDataMessage");
        if (TextUtils.isEmpty(str2)) {
            HMSLog.m36988i("PluginUtil", "Empty message received");
            return true;
        }
        if (z10) {
            m36614a(context, str);
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_id", str);
        bundle.putByteArray(RemoteMessageConst.MSGBODY, str2.getBytes(C6294m.f29674a));
        bundle.putString(RemoteMessageConst.MSGTYPE, "received_message");
        return new C6299r().m36598a(context, bundle, intent);
    }

    public static boolean onDeletedMessages(Context context) {
        HMSLog.m36988i("PluginUtil", "onDeletedMessages");
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        bundle.putString(RemoteMessageConst.MSGTYPE, "server_deleted_message");
        return new C6299r().m36598a(context, bundle, intent);
    }

    public static void onMessage(Context context, String[] strArr) {
        HMSLog.m36988i("PluginUtil", "onMessage");
        if (context == null || strArr == null || strArr.length < 5) {
            return;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        if (m36617a(context, strArr)) {
            m36615a(context, strArr[0], strArr[3], strArr[4]);
        } else {
            onDataMessage(context, strArr[0], strArr[4], true);
        }
    }

    public static boolean onNewToken(Context context, String str, String str2, ErrorEnum errorEnum) {
        HMSLog.m36988i("PluginUtil", "onNewToken called.");
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt(VastAttribute.ERROR, errorEnum.getInternalCode());
        bundle.putString(RemoteMessageConst.MSGTYPE, "new_token");
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, str);
        if (TextUtils.equals(str2, context.getPackageName())) {
            bundle.putString("subjectId", null);
        } else {
            bundle.putString("subjectId", str2);
        }
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        return new C6299r().m36598a(context, bundle, intent);
    }

    public static void onNotificationArrived(Context context, String str, String str2) {
        C6293l.m36536a(context, str, str2, "100");
    }

    public static void onNotificationClicked(Context context, String str, String str2) {
        C6293l.m36536a(context, str, str2, "1");
        onAppOpened(context, str, str2, null);
    }

    public static boolean onOldDataMessage(Context context, String str, String str2) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        return onDataMessage(context, str, m36613a(str2), true);
    }

    public static void saveNotifySwitch(Context context, boolean z10) {
        new PushPreferences(context, "push_notify_flag").saveBoolean("notify_msg_enable", z10);
    }

    /* renamed from: a */
    private static String m36613a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", str);
            jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException unused) {
            HMSLog.m36986e("PluginUtil", "rebuild message failed");
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m36616a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            HMSLog.m36989w("PluginUtil", "get running app processes null!");
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                int i10 = runningAppProcessInfo.importance;
                return (i10 == 100 || i10 == 200) ? false : true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m36617a(Context context, String[] strArr) {
        if (TextUtils.equals(strArr[1], "0")) {
            return m36616a(context) || TextUtils.equals(strArr[2], "1");
        }
        return false;
    }

    /* renamed from: a */
    private static void m36614a(Context context, String str) {
        C6293l.m36536a(context, str, null, "102");
    }
}
