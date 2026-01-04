package com.huawei.hianalytics;

import android.app.usage.UsageEvents;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hianalytics.c0 */
/* loaded from: classes5.dex */
public class C4733c0 {

    /* renamed from: a */
    public String f21665a = "";

    /* renamed from: a */
    public Map<String, C4800q> m28779a(UsageEvents usageEvents) {
        HashMap map = new HashMap();
        while (usageEvents.hasNextEvent()) {
            UsageEvents.Event event = new UsageEvents.Event();
            if (usageEvents.getNextEvent(event)) {
                String packageName = event.getPackageName();
                C4800q c4800q = (C4800q) map.get(packageName);
                if (c4800q == null) {
                    c4800q = new C4800q();
                    c4800q.f21903a = packageName;
                    map.put(packageName, c4800q);
                }
                if (event.getEventType() == 1) {
                    if (!TextUtils.equals(packageName, this.f21665a)) {
                        c4800q.f21901a++;
                    }
                    this.f21665a = packageName;
                }
                int eventType = event.getEventType();
                if (eventType == 1) {
                    if (c4800q.f21902a == 0) {
                        c4800q.f21902a = event.getTimeStamp();
                        c4800q.f21904b = event.getTimeStamp();
                    }
                    c4800q.f21906d = eventType;
                    c4800q.f21907e = event.getTimeStamp();
                } else if (eventType == 2) {
                    c4800q.f21904b = event.getTimeStamp();
                }
                if (c4800q.f21906d == 1 && eventType == 2) {
                    long timeStamp = event.getTimeStamp() - c4800q.f21907e;
                    if (timeStamp > 0) {
                        c4800q.f21905c += timeStamp;
                    }
                }
            } else {
                HiLog.m28807d("UM", "get next event failed");
            }
        }
        return map;
    }
}
