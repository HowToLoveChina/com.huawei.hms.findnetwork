package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p186b.p189c.AsyncTaskC8797b;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8800c;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8801d;
import com.huawei.updatesdk.p191b.p195b.C8807a;
import com.huawei.updatesdk.p191b.p198e.AbstractC8822a;
import com.huawei.updatesdk.p191b.p198e.C8826e;
import com.huawei.updatesdk.p191b.p200g.C8831b;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import com.huawei.updatesdk.p191b.p201h.C8835c;
import com.huawei.updatesdk.p191b.p201h.C8836d;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.C8845d;
import com.huawei.updatesdk.service.appmgr.bean.C8846e;
import com.huawei.updatesdk.service.appmgr.bean.Param;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.updatesdk.service.otaupdate.e */
/* loaded from: classes9.dex */
public class AsyncTaskC8870e extends AsyncTask<Void, Void, C8801d> {

    /* renamed from: b */
    private final Context f45245b;

    /* renamed from: c */
    private final CheckUpdateCallBack f45246c;

    /* renamed from: d */
    private final UpdateParams f45247d;

    /* renamed from: e */
    private Toast f45248e;

    /* renamed from: g */
    private AsyncTaskC8797b f45250g;

    /* renamed from: a */
    private final List<String> f45244a = new ArrayList();

    /* renamed from: f */
    private boolean f45249f = false;

    /* renamed from: h */
    private boolean f45251h = false;

    public AsyncTaskC8870e(Context context, UpdateParams updateParams, CheckUpdateCallBack checkUpdateCallBack) {
        this.f45247d = updateParams;
        this.f45245b = context;
        this.f45246c = checkUpdateCallBack;
        C8871f.m56464e().m56468b(updateParams.getServiceZone());
    }

    /* renamed from: a */
    private C8801d m56452a(Context context, List<String> list) {
        C8845d c8845dM56374a;
        String string;
        if (C8836d.m56342a(this.f45247d.getParamList())) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(C8834b.m56325e(context, it.next()));
            }
            c8845dM56374a = C8845d.m56374a(arrayList);
        } else {
            c8845dM56374a = new C8845d(this.f45247d.getParamList());
        }
        AbstractC8822a abstractC8822aM56286a = C8826e.m56286a(this.f45251h);
        String strMo56278b = abstractC8822aM56286a.mo56278b();
        c8845dM56374a.m56381e(abstractC8822aM56286a.mo56273a(context, strMo56278b));
        c8845dM56374a.m56377b(0);
        c8845dM56374a.m56380d(C8789c.m56098b(context, strMo56278b));
        try {
            Context contextCreatePackageContext = this.f45245b.createPackageContext(abstractC8822aM56286a.mo56278b(), 3);
            string = contextCreatePackageContext.getResources().getString(contextCreatePackageContext.getResources().getIdentifier("wd_cno", ExtractOWiFiHelper.STING_NODE, abstractC8822aM56286a.mo56278b()));
        } catch (Throwable th2) {
            C8777a.m56028b("UpdateSDKCheckTask", "get cno error: " + th2.getMessage());
            string = "";
        }
        c8845dM56374a.m56382e(string);
        if (isCancelled()) {
            C8774a.m56010c("UpdateSDKCheckTask", "UpdateSDK task is canceled and return empty upgradeInfo");
            return null;
        }
        AsyncTaskC8797b asyncTaskC8797b = new AsyncTaskC8797b(c8845dM56374a, null);
        this.f45250g = asyncTaskC8797b;
        return asyncTaskC8797b.m56163c();
    }

    /* renamed from: b */
    private void m56457b() {
        if (!C8836d.m56342a(this.f45247d.getParamList())) {
            Iterator<Param> it = this.f45247d.getParamList().iterator();
            while (it.hasNext()) {
                this.f45244a.add(it.next().getPackageName());
            }
            return;
        }
        if (!C8836d.m56342a(this.f45247d.getPackageList())) {
            this.f45244a.addAll(this.f45247d.getPackageList());
            return;
        }
        String targetPkgName = this.f45247d.getTargetPkgName();
        if (TextUtils.isEmpty(targetPkgName)) {
            targetPkgName = this.f45245b.getPackageName();
        }
        if (TextUtils.isEmpty(targetPkgName)) {
            return;
        }
        this.f45244a.add(targetPkgName);
    }

    /* renamed from: c */
    private boolean m56459c() {
        return !this.f45249f && TextUtils.isEmpty(this.f45247d.getTargetPkgName()) && C8836d.m56342a(this.f45247d.getPackageList()) && C8836d.m56342a(this.f45247d.getParamList());
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        AsyncTaskC8797b asyncTaskC8797b = this.f45250g;
        if (asyncTaskC8797b != null) {
            asyncTaskC8797b.m56162b();
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() throws Resources.NotFoundException {
        super.onPreExecute();
        if (m56459c()) {
            Context context = this.f45245b;
            Toast toastMakeText = Toast.makeText(context, C8835c.m56335c(context, "upsdk_checking_update_prompt"), 1);
            this.f45248e = toastMakeText;
            toastMakeText.show();
        }
    }

    /* renamed from: b */
    private void m56458b(C8801d c8801d) {
        if (this.f45246c != null) {
            Intent intent = new Intent();
            intent.putExtra("status", 6);
            if (c8801d.m56175a() != null) {
                intent.putExtra(UpdateKey.FAIL_CODE, c8801d.m56175a().ordinal());
            }
            intent.putExtra(UpdateKey.FAIL_REASON, c8801d.m56181c());
            intent.putExtra(UpdateKey.RESPONSE_CODE, c8801d.m56179b());
            this.f45246c.onUpdateInfo(intent);
            this.f45246c.onUpdateStoreError(c8801d.m56182d());
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C8801d doInBackground(Void... voidArr) {
        C8777a.m56026a("UpdateSDKCheckTask", "CheckOtaAndUpdataTask doInBackground");
        C8831b.m56300a(this);
        m56457b();
        C8774a.m56009b("UpdateSDKCheckTask", "start check update and packageNames are: " + this.f45244a.toString());
        AbstractC8822a abstractC8822aM56286a = C8826e.m56286a(this.f45251h);
        abstractC8822aM56286a.mo56277a(this.f45244a);
        C8807a.m56209d().m56216c();
        C8800c.m56167c(abstractC8822aM56286a.m56279b(this.f45245b));
        C8807a.m56209d().m56217c(C8871f.m56464e().m56465a());
        return m56452a(this.f45245b, this.f45244a);
    }

    /* renamed from: a */
    private void m56453a() {
        Toast toast = this.f45248e;
        if (toast != null) {
            toast.cancel();
        }
    }

    /* renamed from: b */
    public void m56463b(boolean z10) {
        this.f45249f = z10;
    }

    /* renamed from: a */
    private void m56454a(Context context, ApkUpgradeInfo apkUpgradeInfo) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AppUpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("app_update_parm", apkUpgradeInfo);
        bundle.putBoolean("app_must_btn", this.f45247d.isMustBtnOne());
        bundle.putBoolean("is_apptouch", this.f45251h);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e10) {
            C8777a.m56028b("UpdateSDKCheckTask", "go AppUpdateActivity error: " + e10.getMessage());
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(C8801d c8801d) {
        ArrayList<ApkUpgradeInfo> arrayList;
        C8831b.m56299a().remove(this);
        m56453a();
        if (this.f45246c == null) {
            C8774a.m56010c("UpdateSDKCheckTask", "UpdateSDK callback is null");
        }
        if (c8801d == null) {
            if (this.f45246c != null) {
                Intent intent = new Intent();
                intent.putExtra("status", 3);
                this.f45246c.onUpdateInfo(intent);
                return;
            }
            return;
        }
        int iM56179b = c8801d.m56179b();
        if (c8801d.m56183e()) {
            C8846e c8846e = (C8846e) c8801d;
            arrayList = c8846e.list;
            if (!C8836d.m56342a(c8846e.notRcmList)) {
                ApkUpgradeInfo apkUpgradeInfo = c8846e.notRcmList.get(0);
                C8774a.m56008a("UpdateSDKCheckTask", "Updateinfo is not recommend, reason: " + apkUpgradeInfo.getNotRcmReason_() + " ,is same signature: " + apkUpgradeInfo.getSameS_());
            }
            m56456a((List<ApkUpgradeInfo>) arrayList);
            if (C8836d.m56342a(arrayList) && this.f45246c != null) {
                C8774a.m56009b("UpdateSDKCheckTask", "no upgrade info");
                Intent intent2 = new Intent();
                intent2.putExtra("status", 3);
                intent2.putExtra(UpdateKey.RESPONSE_CODE, iM56179b);
                this.f45246c.onUpdateInfo(intent2);
            }
        } else {
            m56458b(c8801d);
            C8774a.m56008a("UpdateSDKCheckTask", "get app update msg failed,responseCode is " + c8801d.m56182d() + ",failreason: " + c8801d.m56181c() + ",response: " + c8801d);
            arrayList = null;
        }
        if (C8836d.m56342a(arrayList)) {
            if (m56459c()) {
                C8774a.m56009b("UpdateSDKCheckTask", "show no upgrade info toast.");
                Context context = this.f45245b;
                Toast.makeText(context, C8835c.m56335c(context, "upsdk_update_check_no_new_version"), 0).show();
                return;
            } else {
                C8774a.m56009b("UpdateSDKCheckTask", "no upgrade info: " + this.f45244a.toString());
                return;
            }
        }
        ApkUpgradeInfo apkUpgradeInfo2 = arrayList.get(0);
        C8869d.m56446a().m56449a(this.f45246c);
        if (this.f45246c != null) {
            Intent intent3 = new Intent();
            intent3.putExtra(UpdateKey.INFO, (Serializable) apkUpgradeInfo2);
            intent3.putParcelableArrayListExtra(UpdateKey.INFO_LIST, arrayList);
            intent3.putExtra("status", 7);
            intent3.putExtra(UpdateKey.RESPONSE_CODE, iM56179b);
            this.f45246c.onUpdateInfo(intent3);
        }
        m56455a(arrayList);
        if (this.f45247d.isShowImmediate()) {
            m56454a(this.f45245b, apkUpgradeInfo2);
        }
    }

    /* renamed from: a */
    private void m56455a(ArrayList<ApkUpgradeInfo> arrayList) {
        Iterator<ApkUpgradeInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            ApkUpgradeInfo next = it.next();
            C8774a.m56009b("UpdateSDKCheckTask", "ApkUpgradeInfo, version=" + next.getVersion_() + ", versionCode=" + next.getVersionCode_() + ", detailId=" + next.getDetailId_() + ", devType=" + next.getDevType_() + ", packageName=" + next.getPackage_() + ", oldVersionCode=" + next.getOldVersionCode_());
        }
    }

    /* renamed from: a */
    private void m56456a(List<ApkUpgradeInfo> list) {
        if (C8836d.m56342a(list)) {
            return;
        }
        for (ApkUpgradeInfo apkUpgradeInfo : list) {
            if (apkUpgradeInfo != null && !TextUtils.isEmpty(apkUpgradeInfo.getFullDownUrl_())) {
                if (apkUpgradeInfo.getDiffSize_() > 0) {
                    apkUpgradeInfo.setDiffDownUrl_(apkUpgradeInfo.getDownurl_());
                }
                apkUpgradeInfo.setDownurl_(apkUpgradeInfo.getFullDownUrl_());
            }
        }
    }

    /* renamed from: a */
    public void m56462a(boolean z10) {
        this.f45251h = z10;
    }
}
