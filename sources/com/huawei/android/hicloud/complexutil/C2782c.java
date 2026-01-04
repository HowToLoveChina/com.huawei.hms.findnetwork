package com.huawei.android.hicloud.complexutil;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.C1461a;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.NewBusinessModelConfigBean;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p020ap.C1006a;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9284c;
import p292fn.C9733f;
import p371ik.C10527a;
import p399jk.AbstractC10896a;
import p426kd.C11032f;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;
import tc.C13007b;

/* renamed from: com.huawei.android.hicloud.complexutil.c */
/* loaded from: classes3.dex */
public class C2782c {

    /* renamed from: com.huawei.android.hicloud.complexutil.c$a */
    public class a extends Handler {

        /* renamed from: a */
        public final /* synthetic */ boolean[] f12087a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f12088b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, boolean[] zArr, CountDownLatch countDownLatch) {
            super(looper);
            this.f12087a = zArr;
            this.f12088b = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                if (message.what != 0) {
                    this.f12087a[0] = false;
                    C11839m.m70688i("DatabaseListUtil", "databaseList await fail");
                    this.f12088b.countDown();
                } else {
                    this.f12087a[0] = true;
                    C11839m.m70688i("DatabaseListUtil", "databaseList await suc");
                    this.f12088b.countDown();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.c$b */
    public class b extends TypeToken<List<String>> {
    }

    /* renamed from: com.huawei.android.hicloud.complexutil.c$c */
    public class c extends TypeToken<List<String>> {
    }

    /* renamed from: a */
    public static void m16063a(Context context, int i10) {
        if (C1006a.m5936k().m5973t()) {
            C11839m.m70689w("DatabaseListUtil", "closeCloudPhotoForNN inRetentionPeriod not close");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", false);
        bundle.putBoolean("ShareAlbum", false);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58396U(context, bundle, i10);
        }
    }

    /* renamed from: b */
    public static void m16064b(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        List<String> listMo17096K = ((InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class)).mo17096K(context);
        if (listMo17096K == null || listMo17096K.size() <= 0) {
            C11839m.m70688i("DatabaseListUtil", "all switch closed");
            return;
        }
        list.retainAll(listMo17096K);
        if (list.size() == 0) {
            return;
        }
        C11839m.m70688i("DatabaseListUtil", "closeDataListSwitch: " + list.toString());
        for (String str : list) {
            if (TextUtils.equals(str, "atlas") && C1006a.m5936k().m5975v(context)) {
                m16063a(context, 24);
            } else {
                if (C1006a.m5936k().m5973t() && StringUtil.equals(str, NotifyUtil.HI_NOTE_SYNC_TYPE) && C1008c.m6035v().m6108z(context, str) == 1) {
                    C11839m.m70689w("DatabaseListUtil", "inRetentionPeriod & h5 open closeSwitch hinote return");
                    return;
                }
                ((InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class)).mo17115b0(str, 0, "businessChange");
            }
        }
    }

    /* renamed from: c */
    public static void m16065c(Context context) {
        if (C13452e.m80781L().m80791C0()) {
            m16064b(context, m16068f(context));
        }
    }

    /* renamed from: d */
    public static List<String> m16066d(Context context) {
        try {
            String strM78294x = C13007b.m78205Y(context).m78294x();
            if (TextUtils.isEmpty(strM78294x) || m16070h(context)) {
                C12515a.m75110o().m75172d(new C11032f(context, null, true));
                strM78294x = C13007b.m78205Y(context).m78294x();
            }
            List<String> list = (List) new Gson().fromJson(strM78294x, new b().getType());
            if (list != null) {
                if (list.size() > 0) {
                    return list;
                }
            }
        } catch (Exception e10) {
            C1461a.m8358e("DatabaseListUtil", "getSyncDataBaseListFromSp error:" + e10.getMessage());
        }
        return new ArrayList();
    }

    /* renamed from: e */
    public static boolean m16067e(Context context, CountDownLatch countDownLatch) throws InterruptedException {
        try {
            boolean[] zArr = {false};
            C12515a.m75110o().m75172d(new C11032f(context, new a(Looper.getMainLooper(), zArr, countDownLatch), true));
            if (countDownLatch != null) {
                try {
                    countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    AbstractC10896a.m65886e("DatabaseListUtil", "databaseList await InterruptedException");
                }
            }
            return zArr[0];
        } catch (Exception e10) {
            AbstractC10896a.m65886e("DatabaseListUtil", "databaseList await error " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: f */
    public static List<String> m16068f(Context context) {
        try {
            String strM78210C = C13007b.m78205Y(context).m78210C();
            if (TextUtils.isEmpty(strM78210C) || m16070h(context)) {
                C12515a.m75110o().m75172d(new C11032f(context, null, true));
                strM78210C = C13007b.m78205Y(context).m78210C();
            }
            List<String> list = (List) new Gson().fromJson(strM78210C, new c().getType());
            if (list != null) {
                if (list.size() > 0) {
                    return list;
                }
            }
        } catch (Exception e10) {
            C1461a.m8358e("DatabaseListUtil", "getSyncFullDataListFromSp error:" + e10.getMessage());
        }
        return new ArrayList();
    }

    /* renamed from: g */
    public static long m16069g() {
        String newBusinessModelConfig = HiCloudSysParamMapCache.getNewBusinessModelConfig();
        if (newBusinessModelConfig == null || TextUtils.isEmpty(newBusinessModelConfig)) {
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p == null) {
                C11839m.m70689w("DatabaseListUtil", "getValidPeriod, sysParamMap is null");
                return 1800000L;
            }
            newBusinessModelConfig = hiCloudSysParamMapM60757p.getNewBusinessModelConfig();
        }
        if (newBusinessModelConfig == null || TextUtils.isEmpty(newBusinessModelConfig)) {
            C11839m.m70689w("DatabaseListUtil", "getValidPeriod, config is null");
            return 1800000L;
        }
        NewBusinessModelConfigBean newBusinessModelConfigBean = (NewBusinessModelConfigBean) C10527a.m64629g(newBusinessModelConfig, NewBusinessModelConfigBean.class);
        if (newBusinessModelConfigBean == null) {
            C11839m.m70689w("DatabaseListUtil", "getValidPeriod, configBean is null");
            return 1800000L;
        }
        long jIntValue = newBusinessModelConfigBean.getDatabaseListSla().intValue();
        if (jIntValue != 0) {
            return jIntValue * 60000;
        }
        C11839m.m70689w("DatabaseListUtil", "getValidPeriod, databaseListSla is null");
        return 1800000L;
    }

    /* renamed from: h */
    public static boolean m16070h(Context context) {
        if (System.currentTimeMillis() - C13007b.m78205Y(context).m78214E() < m16069g()) {
            return false;
        }
        C11839m.m70689w("DatabaseListUtil", "upper database sla, need refresh sp");
        return true;
    }
}
