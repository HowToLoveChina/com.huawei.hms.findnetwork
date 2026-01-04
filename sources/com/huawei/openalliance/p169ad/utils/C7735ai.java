package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.constant.Action;
import com.huawei.openalliance.p169ad.inter.C7307e;

/* renamed from: com.huawei.openalliance.ad.utils.ai */
/* loaded from: classes2.dex */
public class C7735ai {

    /* renamed from: a */
    private static boolean f35810a = false;

    /* renamed from: a */
    public static Pair<String, Integer> m47487a(Context context) {
        m47491e(context);
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        String strM47928I = c7787cgM47900a.m47928I();
        int iM47940S = c7787cgM47900a.m47940S();
        AbstractC7185ho.m43818a("GroupIdUtils", "get groupId: %s", AbstractC7819dl.m48375a(strM47928I));
        AbstractC7185ho.m43821b("GroupIdUtils", "get grpIdStatusCode: %s", Integer.valueOf(iM47940S));
        return new Pair<>(strM47928I, Integer.valueOf(iM47940S));
    }

    /* renamed from: b */
    public static void m47488b(final Context context) {
        AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ai.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ai.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C7735ai.m47493g(context);
                    }
                });
            }
        }, 1000L);
    }

    /* renamed from: c */
    public static void m47489c(final Context context) {
        if (f35810a) {
            Log.d("GroupIdUtils", "hasInit true");
            return;
        }
        Log.i("GroupIdUtils", "init");
        f35810a = true;
        if (m47492f(context)) {
            Log.d("GroupIdUtils", "update groupId too quick");
        } else {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ai.3
                @Override // java.lang.Runnable
                public void run() {
                    C7735ai.m47493g(context);
                }
            });
        }
        m47495i(context);
    }

    /* renamed from: e */
    private static void m47491e(final Context context) {
        if (m47492f(context)) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ai.1
            @Override // java.lang.Runnable
            public void run() {
                C7735ai.m47493g(context);
            }
        });
    }

    /* renamed from: f */
    private static boolean m47492f(Context context) {
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        long jMo43435cf = interfaceC7146gcM43316b.mo43435cf();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jMo43435cf < 43200000) {
            AbstractC7185ho.m43817a("GroupIdUtils", "update groupId too quick");
            return true;
        }
        interfaceC7146gcM43316b.mo43475m(jCurrentTimeMillis);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m47493g(Context context) {
        Pair<String, Integer> pairM47494h = m47494h(context);
        AbstractC7185ho.m43818a("GroupIdUtils", "update groupId: %s", AbstractC7819dl.m48375a((String) pairM47494h.first));
        AbstractC7185ho.m43821b("GroupIdUtils", "update grpIdStatusCode: %s", pairM47494h.second);
        C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        c7787cgM47900a.m47967b(((Integer) pairM47494h.second).intValue());
        c7787cgM47900a.m47919D((String) pairM47494h.first);
    }

    /* renamed from: h */
    private static Pair<String, Integer> m47494h(Context context) {
        String string = "";
        if (context == null) {
            return new Pair<>("", 1);
        }
        if (C6982bz.m41148a(context).mo41175d()) {
            return new Pair<>("", 12);
        }
        Uri uri = Uri.parse("content://com.huawei.hms.ads.brain.open/groupid/query");
        int i10 = 11;
        if (!AbstractC7741ao.m47563b(context, uri)) {
            AbstractC7185ho.m43820b("GroupIdUtils", "target provider not exists");
            return new Pair<>("", 11);
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("group_id"));
                i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("code"));
            }
        } finally {
            try {
                return new Pair<>(string, Integer.valueOf(i10));
            } finally {
            }
        }
        return new Pair<>(string, Integer.valueOf(i10));
    }

    /* renamed from: i */
    private static void m47495i(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Action.ACTION_HW_ACCOUNT_LOGIN);
            intentFilter.addAction(Action.ACTION_HW_ACCOUNT_LOGOUT);
            AbstractC7185ho.m43820b("GroupIdUtils", "register hw account receiver");
            AbstractC7741ao.m47537a(context, new C7307e(), intentFilter, "com.huawei.hms.permission.INNER_BROADCAST", null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("GroupIdUtils", "register hw account receiver ex: %s", th2.getClass().getSimpleName());
        }
    }
}
