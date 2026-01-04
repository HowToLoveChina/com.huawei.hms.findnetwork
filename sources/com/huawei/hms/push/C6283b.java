package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.push.b */
/* loaded from: classes8.dex */
public class C6283b {
    /* renamed from: a */
    public static List<SubscribedItem> m36504a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                int i10 = jSONObject.getInt(next);
                SubscribedItem subscribedItem = new SubscribedItem();
                subscribedItem.setEntityId(next);
                subscribedItem.setResultCode(i10);
                arrayList.add(subscribedItem);
            }
            return arrayList;
        } catch (JSONException unused) {
            HMSLog.m36986e("PushBaseUtils", "trans subscribedItem list occurs exception");
            return Collections.emptyList();
        }
    }
}
