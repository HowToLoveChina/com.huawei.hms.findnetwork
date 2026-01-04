package com.huawei.fastengine.fastview;

import android.content.Context;
import android.os.Build;
import com.huawei.fastengine.fastview.util.ThreadUtil;
import com.huawei.fastsdk.HASDKManager;
import com.huawei.fastsdk.HASDKUtils;
import java.util.LinkedHashMap;

/* loaded from: classes5.dex */
public class QuickCardAnalytic {
    public static void reportBindData(final Context context, final long j10, final long j11, final int i10, final String str) {
        ThreadUtil.INST.excute(new Runnable() { // from class: com.huawei.fastengine.fastview.QuickCardAnalytic.2
            @Override // java.lang.Runnable
            public void run() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("TYPE", "bindData");
                linkedHashMap.put("STARTTS", HASDKUtils.formatTime(j10));
                linkedHashMap.put("ENDTS", HASDKUtils.formatTime(j11));
                linkedHashMap.put("ERRORCODE", String.valueOf(i10));
                linkedHashMap.put("DESCRIPTION", HASDKUtils.buildMSG(i10));
                linkedHashMap.put("quickCardUri", str);
                linkedHashMap.put("deviceModel", Build.MODEL);
                linkedHashMap.put("EngineVer", "1078");
                HASDKManager.onEvent(context, HASDKUtils.EventID.BIND_DATA, linkedHashMap);
            }
        });
    }

    public static void reportRenderCard(final Context context, final long j10, final long j11, final int i10, final String str) {
        ThreadUtil.INST.excute(new Runnable() { // from class: com.huawei.fastengine.fastview.QuickCardAnalytic.3
            @Override // java.lang.Runnable
            public void run() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("TYPE", "renderQuickCard");
                linkedHashMap.put("STARTTS", HASDKUtils.formatTime(j10));
                linkedHashMap.put("ENDTS", HASDKUtils.formatTime(j11));
                linkedHashMap.put("ERRORCODE", String.valueOf(i10));
                linkedHashMap.put("DESCRIPTION", HASDKUtils.buildMSG(i10));
                linkedHashMap.put("quickCardUri", str);
                linkedHashMap.put("deviceModel", Build.MODEL);
                linkedHashMap.put("EngineVer", "1078");
                HASDKManager.onEvent(context, HASDKUtils.EventID.RENDER_QUICK_CARD, linkedHashMap);
            }
        });
    }

    public static void reportSDKInit(final Context context, final long j10, final long j11, final int i10, final String str) {
        ThreadUtil.INST.excute(new Runnable() { // from class: com.huawei.fastengine.fastview.QuickCardAnalytic.1
            @Override // java.lang.Runnable
            public void run() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("TYPE", "initialize");
                linkedHashMap.put("STARTTS", HASDKUtils.formatTime(j10));
                linkedHashMap.put("ENDTS", HASDKUtils.formatTime(j11));
                linkedHashMap.put("ERRORCODE", String.valueOf(i10));
                linkedHashMap.put("DESCRIPTION", str);
                linkedHashMap.put("deviceModel", Build.MODEL);
                linkedHashMap.put("EngineVer", "1078");
                HASDKManager.onEvent(context, HASDKUtils.EventID.INITIALIZE, linkedHashMap);
            }
        });
    }
}
