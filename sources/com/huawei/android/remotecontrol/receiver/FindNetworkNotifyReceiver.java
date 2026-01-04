package com.huawei.android.remotecontrol.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import bf.C1175a;
import com.huawei.android.remotecontrol.service.FinderTagService;
import com.huawei.hms.network.embedded.C6010m7;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p227dg.C9097b;
import p227dg.C9120m0;
import p521og.C11872e;
import p709vj.C13452e;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class FindNetworkNotifyReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public final String m26462a(String str) throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String string = jSONObject.getString("mFid");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("mFid", C9120m0.m57351R(string));
                    jSONArray.put(i10, jSONObject);
                }
            }
            return jSONArray.toString();
        } catch (JSONException e10) {
            C13981a.m83988e("FindNetworkNotifyReceiver", "anonymousTrackingNotify JSONException: " + e10.getMessage());
            return "";
        } catch (Exception e11) {
            C13981a.m83988e("FindNetworkNotifyReceiver", "anonymousTrackingNotify Exception: " + e11.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public final void m26463b(Context context, boolean z10, String str) throws JSONException {
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83990w("FindNetworkNotifyReceiver", "connectStatesNotify, cloud not login");
            return;
        }
        if (!C1175a.m7389k(context)) {
            C13981a.m83990w("FindNetworkNotifyReceiver", "connectStatesNotify, Client Switch off");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("FindNetworkNotifyReceiver", "connectStatesNotify data is empty");
            return;
        }
        C13981a.m83987d("FindNetworkNotifyReceiver", "connectStatesNotify data : " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("mFid");
            if (TextUtils.isEmpty(string)) {
                C13981a.m83988e("FindNetworkNotifyReceiver", "connectStatesNotify fid is empty");
            } else {
                FinderTagService.m26531c(context, string, z10, jSONObject.optString("mStandbyDevice", C6010m7.f27500n), jSONObject.getString("mProductId"));
            }
        } catch (JSONException e10) {
            C13981a.m83988e("FindNetworkNotifyReceiver", "json parse error : " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public final boolean m26464c(String str) {
        return "com.huawei.hms.findnetwork.FOUND_NOTIFICATION".equals(str);
    }

    /* renamed from: d */
    public final void m26465d(Context context, String str) throws JSONException {
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83990w("FindNetworkNotifyReceiver", "trackingNotify, cloud not login");
            return;
        }
        if (!C1175a.m7389k(context)) {
            C13981a.m83990w("FindNetworkNotifyReceiver", "trackingNotify, Client Switch off");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("FindNetworkNotifyReceiver", "trackingNotify data is empty");
            return;
        }
        C13981a.m83987d("FindNetworkNotifyReceiver", "trackingNotify data : " + str);
        try {
            SparseArray sparseArray = new SparseArray();
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String string = jSONObject.getString("mProductId");
                if (TextUtils.isEmpty(string)) {
                    C13981a.m83988e("FindNetworkNotifyReceiver", "trackingNotify prodId is empty");
                    return;
                }
                int iM57301k = C9097b.m57301k(string);
                List arrayList = (List) sparseArray.get(iM57301k);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    sparseArray.put(iM57301k, arrayList);
                }
                arrayList.add(jSONObject);
            }
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                int iKeyAt = sparseArray.keyAt(i11);
                C13981a.m83989i("FindNetworkNotifyReceiver", "trackingNotify tabLocation : " + iKeyAt + " , number ：" + ((List) sparseArray.valueAt(i11)).size());
                C11872e.m71165c(context, iKeyAt);
            }
        } catch (JSONException e10) {
            C13981a.m83988e("FindNetworkNotifyReceiver", "json parse error : " + e10.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011b  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r23, android.content.Intent r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.receiver.FindNetworkNotifyReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
