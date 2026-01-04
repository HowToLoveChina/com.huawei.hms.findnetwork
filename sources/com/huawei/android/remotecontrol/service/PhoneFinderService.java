package com.huawei.android.remotecontrol.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.activity.SafeService;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.LinkedHashMap;
import p575qe.C12347f;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* loaded from: classes4.dex */
public class PhoneFinderService extends SafeService {
    /* renamed from: a */
    public final void m26536a(String str) {
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            applicationContext = C12347f.m74285n().m74301m();
        }
        Context context = applicationContext;
        if (TextUtils.isEmpty(str)) {
            C13981a.m83989i("PhoneFinderService", "closePhoneFinder fail: userId empty");
            new C12797b().m76784j(context, "PhoneFinderService", "001_3011", "closePhoneFinder fail: userId empty", null, "01060", null, "inActive", true);
            return;
        }
        if (!C1175a.m7389k(context)) {
            C13981a.m83989i("PhoneFinderService", "closePhoneFinder, closed");
            new C12797b().m76784j(context, "PhoneFinderService", "001_3011", "closePhoneFinder:closed", null, "01060", null, "inActive", true);
            return;
        }
        String userID = AbstractC12139d.m72766e(context).getUserID();
        boolean zIsEmpty = TextUtils.isEmpty(userID);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("LogoutUserId", str);
        linkedHashMap.put("TaUserId", userID);
        if (str.equals(userID)) {
            C13981a.m83989i("PhoneFinderService", "HMS not match, not closePhoneFinder");
            new C12797b().m76785k(context, "PhoneFinderService", "001_3011", "HMS version not match, not closePhoneFinder", null, "01060", null, "inActive", true, linkedHashMap);
            return;
        }
        String str2 = "closePhoneFinder fail: userId not match,isTaUserIdEmpty:" + zIsEmpty;
        C13981a.m83989i("PhoneFinderService", str2);
        new C12797b().m76785k(context, "PhoneFinderService", "001_3011", str2, null, "01060", null, "inActive", true, linkedHashMap);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C13981a.m83989i("PhoneFinderService", "onBind");
        return null;
    }

    @Override // com.huawei.secure.android.common.activity.SafeService, android.app.Service
    public void onCreate() {
        super.onCreate();
        C13981a.m83989i("PhoneFinderService", "onCreate");
    }

    @Override // com.huawei.secure.android.common.activity.SafeService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C13981a.m83989i("PhoneFinderService", "onDestroy");
    }

    @Override // com.huawei.secure.android.common.activity.SafeService, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        C13981a.m83989i("PhoneFinderService", "onStartCommand");
        SafeIntent safeIntent = new SafeIntent(intent);
        if ("com.huawei.android.remotecontrol.action.CLOSE_PHONE_FINDER".equals(safeIntent.getAction())) {
            try {
                m26536a(safeIntent.getStringExtra(JsbMapKeyNames.H5_USER_ID));
            } catch (Throwable th2) {
                C13981a.m83989i("PhoneFinderService", "onStartCommand intent error:" + th2.getMessage());
            }
            stopSelf();
        }
        new C12797b().m76784j(getApplicationContext(), "PhoneFinderService", "001_3011", "start PhoneFinderService", null, "01060", null, "inActive", true);
        return 2;
    }
}
