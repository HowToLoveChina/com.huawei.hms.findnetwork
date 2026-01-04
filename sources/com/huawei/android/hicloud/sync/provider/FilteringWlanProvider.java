package com.huawei.android.hicloud.sync.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.service.aidl.CloudSync;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import hu.C10343b;
import java.util.HashSet;
import java.util.List;
import je.C10781c0;
import p015ak.C0214f0;
import p371ik.C10527a;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class FilteringWlanProvider extends ContentProvider {
    /* renamed from: a */
    public final boolean m17789a(Context context, List<String> list) {
        List<String> listM65632b = C10781c0.m65632b(context);
        if (listM65632b.size() != list.size()) {
            return false;
        }
        return new HashSet(list).containsAll(listM65632b);
    }

    /* renamed from: b */
    public final void m17790b(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b == null || !sharedPreferencesM1382b.getBoolean("wlan", false)) {
            C11839m.m70689w("FilteringWlanProvider", "startSyncWlan: wlan sync switch is not open.");
            return;
        }
        C11839m.m70688i("FilteringWlanProvider", "startSyncWlan: sync wlan.");
        CloudSync.getInstance().doAutoSyncWlan(SyncType.WlanSyncType.COMMON_SYNC);
        C2986o.m17946c(context, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C11839m.m70688i("FilteringWlanProvider", "call: method = " + str);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_succeed", false);
        if (bundle == null || TextUtils.isEmpty(str)) {
            C11839m.m70689w("FilteringWlanProvider", "call: input Bundle or method is null.");
            return bundle2;
        }
        if (!str.equals("setVehicleSSID")) {
            C11839m.m70689w("FilteringWlanProvider", "call: invalid method.");
            return bundle2;
        }
        String strM63694p = new C10343b(bundle).m63694p("vehicle_ssid");
        List<String> listM64626d = C10527a.m64626d(strM63694p, String.class);
        if (listM64626d.isEmpty() || listM64626d.size() > 100) {
            C11839m.m70689w("FilteringWlanProvider", "call: invalid ssid list size.");
            return bundle2;
        }
        Context context = getContext();
        if (context == null) {
            C11839m.m70689w("FilteringWlanProvider", "call: context is null.");
            return bundle2;
        }
        if (m17789a(context, listM64626d)) {
            bundle2.putBoolean("is_succeed", true);
            C11839m.m70688i("FilteringWlanProvider", "call: vehicle ssid equals cache.");
            return bundle2;
        }
        boolean zM65633c = C10781c0.m65633c(context, strM63694p);
        bundle2.putBoolean("is_succeed", zM65633c);
        if (zM65633c) {
            m17790b(context);
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C11839m.m70688i("FilteringWlanProvider", "delete");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        C11839m.m70688i("FilteringWlanProvider", "getType");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C11839m.m70688i("FilteringWlanProvider", "insert");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C11839m.m70688i("FilteringWlanProvider", "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C11839m.m70688i("FilteringWlanProvider", "query");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C11839m.m70688i("FilteringWlanProvider", SyncProtocol.Constant.UPDATE);
        return 0;
    }
}
