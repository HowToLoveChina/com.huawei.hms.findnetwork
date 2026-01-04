package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8787a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p178a.p183d.p185j.C8792a;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p195b.C8807a;
import com.huawei.updatesdk.p191b.p200g.C8831b;
import com.huawei.updatesdk.p191b.p200g.C8832c;
import com.huawei.updatesdk.p191b.p201h.C8835c;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.AppInfoAdapter;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import java.util.List;

/* renamed from: com.huawei.updatesdk.service.otaupdate.g */
/* loaded from: classes9.dex */
public final class C8872g {
    /* renamed from: a */
    public static void m56472a() {
        C8774a.m56009b("UpdateSDKImpl", "UpdateSDK releaseCallBack");
        C8869d.m56446a().m56449a((CheckUpdateCallBack) null);
        List<AsyncTask> listM56299a = C8831b.m56299a();
        if (listM56299a == null || listM56299a.isEmpty()) {
            return;
        }
        for (AsyncTask asyncTask : listM56299a) {
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            C8774a.m56009b("UpdateSDKImpl", "cancel task");
        }
        listM56299a.clear();
    }

    /* renamed from: b */
    public static void m56485b(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        m56481a(context, updateParams, checkUpdateCallBack, false);
    }

    /* renamed from: a */
    private static void m56473a(Context context) {
        C8793a.m56131a(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UpdateSDK version is: ");
        sb2.append("5.0.1.300");
        sb2.append(" ,flavor: ");
        sb2.append("envrelease");
        sb2.append(" ,pkgName: ");
        sb2.append(context.getPackageName());
        C8774a.m56009b("UpdateSDKImpl", sb2.toString());
        Log.i("updatesdk", sb2.toString());
        if (C8789c.m56102e() == 3) {
            C8787a.m56075b(context);
        }
    }

    /* renamed from: a */
    public static void m56474a(Context context, ApkUpgradeInfo apkUpgradeInfo, AppInfoAdapter appInfoAdapter) {
        if (appInfoAdapter != null && !TextUtils.isEmpty(appInfoAdapter.getAppStorePkgName())) {
            C8871f.m56464e().m56470c(appInfoAdapter.getAppStorePkgName());
        }
        m56476a(context, apkUpgradeInfo, appInfoAdapter != null && appInfoAdapter.isMustBtnOne(), m56484a(appInfoAdapter));
    }

    /* renamed from: a */
    public static void m56475a(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z10) {
        m56476a(context, apkUpgradeInfo, z10, false);
    }

    /* renamed from: a */
    private static void m56476a(Context context, ApkUpgradeInfo apkUpgradeInfo, boolean z10, boolean z11) {
        StringBuilder sb2;
        String str;
        if (context == null || apkUpgradeInfo == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AppUpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("app_update_parm", apkUpgradeInfo);
        bundle.putBoolean("app_must_btn", z10);
        bundle.putBoolean("is_apptouch", z11);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "go AppUpdateActivity error: ";
            sb2.append(str);
            sb2.append(e.getMessage());
            C8774a.m56008a("UpdateSDKImpl", sb2.toString());
        } catch (SecurityException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "go AppUpdateActivity security error: ";
            sb2.append(str);
            sb2.append(e.getMessage());
            C8774a.m56008a("UpdateSDKImpl", sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m56477a(Context context, CheckUpdateCallBack checkUpdateCallBack, AppInfoAdapter appInfoAdapter) {
        if (context == null) {
            return;
        }
        UpdateParams.Builder builder = new UpdateParams.Builder();
        if (appInfoAdapter != null) {
            if (!TextUtils.isEmpty(appInfoAdapter.getServiceZone())) {
                builder.setServiceZone(appInfoAdapter.getServiceZone());
            }
            C8871f.m56464e().m56470c(appInfoAdapter.getAppStorePkgName());
            builder.setTargetPkgName(appInfoAdapter.getTargetPkgName()).setPackageList(appInfoAdapter.getPackageList()).setMustBtnOne(appInfoAdapter.isMustBtnOne()).setIsShowImmediate(appInfoAdapter.isShowImmediate()).setMinIntervalDay(appInfoAdapter.getMinIntervalDay());
        }
        UpdateParams updateParamsBuild = builder.build();
        updateParamsBuild.resetParamList();
        m56481a(context, updateParamsBuild, checkUpdateCallBack, m56484a(appInfoAdapter));
    }

    /* renamed from: a */
    public static void m56478a(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z10, int i10, boolean z11) {
        if (C8792a.m56130d(context)) {
            m56473a(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jM56214b = C8807a.m56209d().m56214b();
            if (i10 != 0 && Math.abs(jCurrentTimeMillis - jM56214b) < i10 * 86400000) {
                C8774a.m56009b("UpdateSDKImpl", "Interval check time is limited and do not check app update.");
                return;
            }
            C8807a.m56209d().m56212a(jCurrentTimeMillis);
            AsyncTaskC8870e asyncTaskC8870e = new AsyncTaskC8870e(context, new UpdateParams.Builder().setIsShowImmediate(z10).setMustBtnOne(z11).setMinIntervalDay(i10).build(), checkUpdateCallBack);
            asyncTaskC8870e.m56463b(true);
            asyncTaskC8870e.executeOnExecutor(C8832c.f45173b, new Void[0]);
        }
    }

    /* renamed from: a */
    public static void m56479a(Context context, CheckUpdateCallBack checkUpdateCallBack, boolean z10, boolean z11) {
        if (context == null) {
            return;
        }
        if (C8792a.m56130d(context)) {
            m56473a(context);
            new AsyncTaskC8870e(context, new UpdateParams.Builder().setIsShowImmediate(z10).setMustBtnOne(z11).build(), checkUpdateCallBack).executeOnExecutor(C8832c.f45173b, new Void[0]);
            return;
        }
        if (checkUpdateCallBack != null) {
            Intent intent = new Intent();
            intent.putExtra("status", 2);
            checkUpdateCallBack.onUpdateInfo(intent);
        }
        Toast.makeText(context, C8835c.m56335c(context, "upsdk_no_available_network_prompt_toast"), 0).show();
    }

    /* renamed from: a */
    public static void m56480a(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        if (context == null || updateParams == null || checkUpdateCallBack == null) {
            return;
        }
        updateParams.resetParamList();
        m56485b(context, updateParams, checkUpdateCallBack);
    }

    /* renamed from: a */
    private static void m56481a(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack, boolean z10) {
        if (context == null || updateParams == null || checkUpdateCallBack == null) {
            return;
        }
        m56473a(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM56214b = C8807a.m56209d().m56214b();
        if (updateParams.getMinIntervalDay() != 0 && Math.abs(jCurrentTimeMillis - jM56214b) < updateParams.getMinIntervalDay() * 86400000) {
            C8774a.m56009b("UpdateSDKImpl", "Interval check time is limited and do not check app update.");
            return;
        }
        if (!C8792a.m56130d(context)) {
            Intent intent = new Intent();
            intent.putExtra("status", 2);
            checkUpdateCallBack.onUpdateInfo(intent);
        } else {
            C8807a.m56209d().m56212a(jCurrentTimeMillis);
            AsyncTaskC8870e asyncTaskC8870e = new AsyncTaskC8870e(context, updateParams, checkUpdateCallBack);
            asyncTaskC8870e.m56462a(z10);
            asyncTaskC8870e.executeOnExecutor(C8832c.f45173b, new Void[0]);
        }
    }

    /* renamed from: a */
    public static void m56482a(Context context, String str, CheckUpdateCallBack checkUpdateCallBack) {
        if (context == null || TextUtils.isEmpty(str) || checkUpdateCallBack == null) {
            if (checkUpdateCallBack != null) {
                Intent intent = new Intent();
                intent.putExtra("status", 1);
                checkUpdateCallBack.onUpdateInfo(intent);
                return;
            }
            return;
        }
        if (C8792a.m56130d(context)) {
            m56473a(context);
            new AsyncTaskC8870e(context, new UpdateParams.Builder().setMustBtnOne(false).setTargetPkgName(str).build(), checkUpdateCallBack).executeOnExecutor(C8832c.f45173b, new Void[0]);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("status", 2);
            checkUpdateCallBack.onUpdateInfo(intent2);
        }
    }

    /* renamed from: a */
    public static void m56483a(String str) {
        C8871f.m56464e().m56468b(str);
    }

    /* renamed from: a */
    private static boolean m56484a(AppInfoAdapter appInfoAdapter) {
        return (appInfoAdapter == null || TextUtils.isEmpty(appInfoAdapter.getAppStorePkgName()) || !TextUtils.equals(appInfoAdapter.getBusiness(), "AppTouch")) ? false : true;
    }
}
