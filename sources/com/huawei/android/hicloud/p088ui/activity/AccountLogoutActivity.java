package com.huawei.android.hicloud.p088ui.activity;

import ae.C0123f1;
import android.accounts.OperationCanceledException;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.activity.AccountExitDialog;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.ExitSyncInfo;
import com.huawei.hicloud.base.bean.ExiterSyncData;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p020ap.C1008c;
import p223db.C9062b;
import p429kk.C11058a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12598v;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12808e;
import vn.C13471c;

/* loaded from: classes3.dex */
public class AccountLogoutActivity extends AuthCallbackActivity {

    /* renamed from: l */
    public C10028c f13478l;

    /* renamed from: m */
    public boolean f13479m;

    /* renamed from: n */
    public boolean f13480n;

    /* renamed from: o */
    public boolean f13481o;

    /* renamed from: p */
    public boolean f13482p;

    /* renamed from: q */
    public boolean f13483q;

    /* renamed from: r */
    public boolean f13484r;

    /* renamed from: s */
    public AccountExitDialog f13485s = null;

    /* renamed from: t */
    public List<ExiterSyncData> f13486t = new ArrayList();

    /* renamed from: u */
    public List<SyncConfigService> f13487u;

    /* renamed from: v */
    public List<SyncConfigService> f13488v;

    /* renamed from: w */
    public C0123f1 f13489w;

    /* renamed from: x */
    public List<ExitSyncInfo> f13490x;

    /* renamed from: com.huawei.android.hicloud.ui.activity.AccountLogoutActivity$a */
    public class C3115a implements AccountExitDialog.AccountExitDialogClickCallback {
        public C3115a() {
        }

        @Override // com.huawei.android.hicloud.ui.activity.AccountExitDialog.AccountExitDialogClickCallback
        /* renamed from: a */
        public void mo18525a() {
            AccountLogoutActivity.this.m18538m1(true);
            AccountLogoutActivity.this.m18539n1("retrain");
            C12598v.m76039g(CloudBackupConstant.REPORT_TYPE_LOGOUT);
            AccountLogoutActivity.this.f13485s.dismiss();
        }

        @Override // com.huawei.android.hicloud.ui.activity.AccountExitDialog.AccountExitDialogClickCallback
        /* renamed from: b */
        public void mo18526b() {
            AccountLogoutActivity.this.m18538m1(false);
            AccountLogoutActivity.this.m18539n1("delete");
            C12598v.m76039g(CloudBackupConstant.REPORT_TYPE_LOGOUT);
            AccountLogoutActivity.this.f13485s.dismiss();
        }

        @Override // com.huawei.android.hicloud.ui.activity.AccountExitDialog.AccountExitDialogClickCallback
        public void onCancel() {
            AccountLogoutActivity.this.m18531f1();
            AccountLogoutActivity.this.m18539n1("cancle");
            AccountLogoutActivity.this.f13485s.dismiss();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AccountLogoutActivity$b */
    public class C3116b implements AccountExitDialog.DialogHeightChangeCallBack {
        public C3116b() {
        }

        @Override // com.huawei.android.hicloud.ui.activity.AccountExitDialog.DialogHeightChangeCallBack
        /* renamed from: a */
        public void mo18527a(int i10) {
            Window window = AccountLogoutActivity.this.f13485s.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = i10;
                window.setAttributes(attributes);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AccountLogoutActivity$c */
    public static class DialogInterfaceOnCancelListenerC3117c implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        finish();
    }

    /* renamed from: f1 */
    public void m18531f1() {
        setResult(0);
        AccountExitDialog accountExitDialog = this.f13485s;
        if (accountExitDialog != null) {
            accountExitDialog.dismiss();
        }
        finish();
    }

    /* renamed from: g1 */
    public final void m18532g1() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        if (this.f13478l == null) {
            m18534i1();
        }
        if (this.f13479m) {
            arrayList.add(m18543r1());
        }
        if (this.f13480n) {
            arrayList.add(m18541p1());
        }
        if (this.f13481o) {
            arrayList.add(m18542q1());
        }
        if (this.f13482p) {
            arrayList.add(m18545t1());
        }
        if (this.f13483q) {
            arrayList.add(m18548w1());
        }
        if (this.f13484r) {
            m18546u1(arrayList);
        }
        this.f13490x = new ArrayList(arrayList);
    }

    /* renamed from: h1 */
    public final void m18533h1() {
        if (this.f13478l == null) {
            m18534i1();
        }
        this.f13486t = new ArrayList();
        for (SyncConfigService syncConfigService : this.f13488v) {
            if (syncConfigService.isForceDelete()) {
                ExiterSyncData exiterSyncData = new ExiterSyncData();
                exiterSyncData.setRetainState(false);
                exiterSyncData.setSyncType(syncConfigService.getId());
                this.f13486t.add(exiterSyncData);
                C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "deleteData: syncType = " + exiterSyncData.getSyncType() + ", retainState = " + exiterSyncData.isRetainState());
            }
        }
        Iterator<ExiterSyncData> it = this.f13486t.iterator();
        while (it.hasNext()) {
            if (!it.next().isRetainState()) {
                C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "setExiterSyncDataLists list");
                C9062b.m57146k().m57162r(true, this.f13486t);
                m18537l1();
                return;
            }
        }
        C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "setExiterSyncDataLists null");
        C9062b.m57146k().m57162r(false, null);
        m18537l1();
    }

    /* renamed from: i1 */
    public final void m18534i1() {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        this.f13478l = c10028cM62183d0;
        boolean z10 = false;
        this.f13479m = c10028cM62183d0.m62388s("addressbook") && !C0209d.m1293p1();
        this.f13480n = this.f13478l.m62388s("browser") && !C0209d.m1293p1();
        this.f13481o = this.f13478l.m62388s("calendar");
        if (this.f13478l.m62388s("notepad") && C0209d.m1215U1(this)) {
            z10 = true;
        }
        this.f13482p = z10;
        this.f13483q = this.f13478l.m62388s("wlan");
        m18535j1();
    }

    /* renamed from: j1 */
    public final void m18535j1() {
        this.f13487u = new ArrayList();
        this.f13488v = new ArrayList();
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this);
        if (shownSyncServiceItems.size() <= 0) {
            C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "configServices.size = 0");
            this.f13484r = false;
            return;
        }
        C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "configServices.size = " + shownSyncServiceItems.size());
        for (SyncConfigService syncConfigService : shownSyncServiceItems) {
            if (syncConfigService.isForceDelete() || !this.f13478l.m62388s(syncConfigService.getId())) {
                this.f13488v.add(syncConfigService);
                C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "configService:" + syncConfigService.getId() + " switch_status: false");
            } else {
                C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "configService:" + syncConfigService.getId() + " switch_status: true");
                this.f13487u.add(syncConfigService);
            }
        }
        this.f13484r = this.f13487u.size() > 0;
    }

    /* renamed from: k1 */
    public final boolean m18536k1() {
        return this.f13479m || this.f13480n || this.f13481o || this.f13482p || this.f13483q || this.f13484r;
    }

    /* renamed from: l1 */
    public void m18537l1() {
        setResult(-1);
        AccountExitDialog accountExitDialog = this.f13485s;
        if (accountExitDialog != null) {
            accountExitDialog.dismiss();
        }
        finish();
    }

    /* renamed from: m1 */
    public final void m18538m1(boolean z10) {
        if (this.f13478l == null) {
            m18534i1();
        }
        this.f13486t = new ArrayList();
        m18547v1(z10);
        if (this.f13484r) {
            for (SyncConfigService syncConfigService : this.f13487u) {
                ExiterSyncData exiterSyncData = new ExiterSyncData();
                exiterSyncData.setRetainState(z10);
                exiterSyncData.setSyncType(syncConfigService.getId());
                this.f13486t.add(exiterSyncData);
                C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "deleteData: syncType = " + exiterSyncData.getSyncType() + ", retainState = " + exiterSyncData.isRetainState());
            }
        }
        if (z10) {
            C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "setExiterSyncDataLists null");
            C9062b.m57146k().m57162r(false, null);
        } else {
            C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "setExiterSyncDataLists list");
            C9062b.m57146k().m57162r(true, this.f13486t);
        }
        m18537l1();
    }

    /* renamed from: n1 */
    public final void m18539n1(String str) {
        String strM66627b = C11058a.m66627b("03001");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("logoutAction", str);
        List<ExitSyncInfo> list = this.f13490x;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (ExitSyncInfo exitSyncInfo : this.f13490x) {
                if (exitSyncInfo != null) {
                    arrayList.add(exitSyncInfo.getSyncType());
                }
            }
            linkedHashMap.put("logoutItems", arrayList.toString());
        }
        C1008c.m6035v().m6055T(this, "", 0, "", "03001", "click_account_logout_dialog", strM66627b, linkedHashMap);
        C13227f.m79492i1().m79567R("click_account_logout_dialog", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "click_account_logout_dialog", linkedHashMap);
    }

    /* renamed from: o1 */
    public final void m18540o1() {
        C13471c.m81134g(C13452e.m80781L().m80971t0(), C13452e.m80781L().m80954p());
        C13471c.m81135h(C13452e.m80781L().m80987x0());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, IllegalArgumentException {
        super.onConfigurationChanged(configuration);
        m18549x1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        m18540o1();
        m18534i1();
        if (m18536k1()) {
            m18532g1();
            m18544s1();
            m18549x1();
        } else {
            C11839m.m70688i(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "Do not show exit dialog");
            m18533h1();
            C12598v.m76039g(CloudBackupConstant.REPORT_TYPE_LOGOUT);
            m18537l1();
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AccountExitDialog accountExitDialog = this.f13485s;
        if (accountExitDialog != null) {
            accountExitDialog.dismiss();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "24", super.mo18593F0());
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "24");
    }

    /* renamed from: p1 */
    public final ExitSyncInfo m18541p1() {
        ExitSyncInfo exitSyncInfo = new ExitSyncInfo();
        exitSyncInfo.setSyncType("browser");
        exitSyncInfo.setIconText(getString(R$string.browser));
        if (C0209d.m1293p1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_hicloud_browser_list_new_ink));
        } else if (C0209d.m1269j1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_hicloud_browser_list_new_honor));
        } else {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_hicloud_browser_list_new));
        }
        return exitSyncInfo;
    }

    /* renamed from: q1 */
    public final ExitSyncInfo m18542q1() {
        ExitSyncInfo exitSyncInfo = new ExitSyncInfo();
        exitSyncInfo.setSyncType("calendar");
        exitSyncInfo.setIconText(getString(R$string.calendar_sync_item));
        if (C0209d.m1293p1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.icon_calendar_ink));
        } else if (C0209d.m1269j1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.icon_calendar_honor));
        } else {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.icon_calendar));
        }
        return exitSyncInfo;
    }

    /* renamed from: r1 */
    public final ExitSyncInfo m18543r1() {
        ExitSyncInfo exitSyncInfo = new ExitSyncInfo();
        exitSyncInfo.setSyncType("addressbook");
        exitSyncInfo.setIconText(getString(R$string.contact));
        if (C0209d.m1269j1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_contacts_honor));
        } else {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_contacts));
        }
        return exitSyncInfo;
    }

    /* renamed from: s1 */
    public final void m18544s1() {
        List<ExitSyncInfo> list = this.f13490x;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f13489w = new C0123f1(this, this.f13490x);
    }

    /* renamed from: t1 */
    public final ExitSyncInfo m18545t1() {
        ExitSyncInfo exitSyncInfo = new ExitSyncInfo();
        exitSyncInfo.setSyncType("notepad");
        exitSyncInfo.setIconText(getString(R$string.notepad_app_name));
        if (C0209d.m1293p1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_memorandum_ink));
        } else if (C0209d.m1269j1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_memorandum_honor));
        } else {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_memorandum));
        }
        return exitSyncInfo;
    }

    /* renamed from: u1 */
    public final void m18546u1(List<ExitSyncInfo> list) throws Resources.NotFoundException {
        Drawable bitmapDrawable;
        List<SyncConfigService> list2 = this.f13487u;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (SyncConfigService syncConfigService : this.f13487u) {
            String id2 = syncConfigService.getId();
            if (!TextUtils.isEmpty(id2)) {
                ExitSyncInfo exitSyncInfo = new ExitSyncInfo();
                exitSyncInfo.setSyncType(id2);
                String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(syncConfigService.getName());
                if (!TextUtils.isEmpty(stringFromSyncConfig)) {
                    exitSyncInfo.setIconText(stringFromSyncConfig);
                    if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(syncConfigService.getId()) && C0209d.m1293p1()) {
                        bitmapDrawable = ResourcesCompat.getDrawable(getResources(), R$drawable.hinote_sync_icon, getTheme());
                    } else {
                        Bitmap bitmapM70501B = C11829c.m70501B(syncConfigService.getIconPath());
                        bitmapDrawable = bitmapM70501B != null ? new BitmapDrawable((Resources) null, bitmapM70501B) : null;
                    }
                    if (bitmapDrawable != null) {
                        exitSyncInfo.setIconDrawable(bitmapDrawable);
                        list.add(exitSyncInfo);
                    }
                }
            }
        }
    }

    /* renamed from: v1 */
    public final void m18547v1(boolean z10) {
        if (this.f13486t != null) {
            if (this.f13479m) {
                ExiterSyncData exiterSyncData = new ExiterSyncData();
                exiterSyncData.setSyncType("addressbook");
                exiterSyncData.setRetainState(z10);
                this.f13486t.add(exiterSyncData);
                C11839m.m70686d(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "deleteData: syncType = " + exiterSyncData.getSyncType() + ", retainState = " + exiterSyncData.isRetainState());
            }
            if (this.f13480n) {
                ExiterSyncData exiterSyncData2 = new ExiterSyncData();
                exiterSyncData2.setSyncType("browser");
                exiterSyncData2.setRetainState(z10);
                this.f13486t.add(exiterSyncData2);
                C11839m.m70686d(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "deleteData: syncType = " + exiterSyncData2.getSyncType() + ", retainState = " + exiterSyncData2.isRetainState());
            }
            if (this.f13481o) {
                ExiterSyncData exiterSyncData3 = new ExiterSyncData();
                exiterSyncData3.setSyncType("calendar");
                exiterSyncData3.setRetainState(z10);
                this.f13486t.add(exiterSyncData3);
                C11839m.m70686d(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "deleteData: syncType = " + exiterSyncData3.getSyncType() + ", retainState = " + exiterSyncData3.isRetainState());
            }
            if (this.f13482p) {
                ExiterSyncData exiterSyncData4 = new ExiterSyncData();
                exiterSyncData4.setSyncType("notepad");
                exiterSyncData4.setRetainState(z10);
                this.f13486t.add(exiterSyncData4);
                C11839m.m70686d(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "deleteData: syncType = " + exiterSyncData4.getSyncType() + ", retainState = " + exiterSyncData4.isRetainState());
            }
            if (this.f13483q) {
                ExiterSyncData exiterSyncData5 = new ExiterSyncData();
                exiterSyncData5.setSyncType("wlan");
                exiterSyncData5.setRetainState(z10);
                this.f13486t.add(exiterSyncData5);
                C11839m.m70686d(NotifyConstants.ActivityName.ACCOUNT_LOGOUT_ACTIVITY, "deleteData: syncType = " + exiterSyncData5.getSyncType() + ", retainState = " + exiterSyncData5.isRetainState());
            }
        }
    }

    /* renamed from: w1 */
    public final ExitSyncInfo m18548w1() {
        ExitSyncInfo exitSyncInfo = new ExitSyncInfo();
        exitSyncInfo.setSyncType("wlan");
        if (C0209d.m1262h2()) {
            exitSyncInfo.setIconText(getString(R$string.wlan_sync));
        } else {
            exitSyncInfo.setIconText(getString(R$string.wifi_sync));
        }
        if (C0209d.m1293p1()) {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_wifi_ink));
        } else {
            exitSyncInfo.setIconDrawable(getDrawable(R$drawable.ic_wifi));
        }
        return exitSyncInfo;
    }

    /* renamed from: x1 */
    public void m18549x1() throws IllegalAccessException, IllegalArgumentException {
        AccountExitDialog accountExitDialog = this.f13485s;
        if (accountExitDialog != null) {
            accountExitDialog.dismiss();
            this.f13485s = null;
        }
        AccountExitDialog accountExitDialog2 = new AccountExitDialog(this, this.f13489w, new C3115a(), new C3116b());
        this.f13485s = accountExitDialog2;
        Window window = accountExitDialog2.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = C11842p.m70840n(this, 12);
            attributes.y = C11842p.m70840n(this, 12);
            attributes.width = (C11842p.m70771U0() || C11842p.m70747M0(this)) ? -2 : C11842p.m70758Q(this);
            attributes.height = -2;
            attributes.gravity = 80;
            window.setAttributes(attributes);
            if (C11842p.m70771U0() || C11842p.m70747M0(this)) {
                window.setGravity(1);
            } else {
                window.setGravity(81);
            }
        }
        this.f13485s.setOnCancelListener(new DialogInterfaceOnCancelListenerC3117c());
        this.f13485s.setCancelable(false);
        C11829c.m70594l1(this, this.f13485s);
        this.f13485s.show();
    }
}
