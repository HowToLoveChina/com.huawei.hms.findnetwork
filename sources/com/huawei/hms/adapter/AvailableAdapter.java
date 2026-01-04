package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p116ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.p116ui.UpdateAdapter;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.availableupdate.UpdateAdapterMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: classes8.dex */
public class AvailableAdapter {

    /* renamed from: a */
    private final int f23075a;

    /* renamed from: b */
    private AvailableCallBack f23076b;

    /* renamed from: d */
    private SystemObserver f23078d = new C5051a();

    /* renamed from: c */
    private boolean f23077c = false;

    public interface AvailableCallBack {
        void onComplete(int i10);
    }

    /* renamed from: com.huawei.hms.adapter.AvailableAdapter$a */
    public class C5051a implements SystemObserver {
        public C5051a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i10) {
            AvailableCallBack availableCallBackM30145a = AvailableAdapter.this.m30145a();
            if (availableCallBackM30145a == null) {
                HMSLog.m36986e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            availableCallBackM30145a.onComplete(i10);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i10) {
            AvailableCallBack availableCallBackM30145a = AvailableAdapter.this.m30145a();
            if (availableCallBackM30145a == null) {
                HMSLog.m36986e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            availableCallBackM30145a.onComplete(i10);
            return true;
        }
    }

    public AvailableAdapter(int i10) {
        this.f23075a = i10;
    }

    /* renamed from: b */
    private void m30149b(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public int checkHuaweiMobileServicesForUpdate(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int iM30144a = m30144a(context);
        if (iM30144a != 0 || !HMSPackageManager.getInstance(context).isApkNeedUpdate(this.f23075a)) {
            return iM30144a;
        }
        HMSLog.m36988i("AvailableAdapter", "The current version does not meet the target version requirements");
        return 2;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int iM30144a = m30144a(context);
        if (iM30144a != 0 || !HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.f23075a)) {
            return iM30144a;
        }
        HMSLog.m36988i("AvailableAdapter", "The current version does not meet the minimum version requirements");
        return 2;
    }

    public boolean isUserNoticeError(int i10) {
        return i10 == 29;
    }

    public boolean isUserResolvableError(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public void setCalledBySolutionInstallHms(boolean z10) {
        this.f23077c = z10;
    }

    public void startNotice(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        if (UIUtil.isBackground(activity)) {
            HMSLog.m36988i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
        } else {
            HMSLog.m36988i("AvailableAdapter", "startNotice");
            this.f23076b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f23078d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()));
        }
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        m30149b(activity);
        if (UIUtil.isBackground(activity)) {
            HMSLog.m36988i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
            return;
        }
        boolean zM30148a = m30148a(activity);
        if (!AvailableUtil.isInstallerLibExist(activity) && !zM30148a) {
            m30147a(activity, availableCallBack);
            return;
        }
        if (UpdateAdapterMgr.INST.needStartUpdateActivity()) {
            HMSLog.m36988i("AvailableAdapter", "startResolution");
            this.f23076b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f23078d);
            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
            intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, this.f23075a);
            if (this.f23077c) {
                intentStartBridgeActivity.putExtra("installHMS", "installHMS");
            }
            intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, zM30148a);
            activity.startActivity(intentStartBridgeActivity);
        }
    }

    /* renamed from: a */
    private int m30144a(Context context) {
        if (HMSPackageManager.getInstance(context).isUseOldCertificate()) {
            HMSLog.m36986e("AvailableAdapter", "The CP uses the old certificate to terminate the connection.");
            return 13;
        }
        PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
            HMSLog.m36988i("AvailableAdapter", "HMS is not installed");
            return 1;
        }
        if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
            HMSLog.m36988i("AvailableAdapter", "HMS is spoofed");
            return 29;
        }
        if (!PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
            return 0;
        }
        HMSLog.m36988i("AvailableAdapter", "HMS is disabled");
        return 3;
    }

    /* renamed from: a */
    private void m30147a(Activity activity, AvailableCallBack availableCallBack) {
        HMSLog.m36988i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (NotInstalledHmsAdapter.getShowLock()) {
            this.f23076b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f23078d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsAdapter.class.getName()));
            return;
        }
        availableCallBack.onComplete(31);
    }

    /* renamed from: a */
    private boolean m30148a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).isUpdateHmsForThirdPartyDevice() || HMSPackageManager.getInstance(activity).getHmsVersionCode() < 40000000) {
            return false;
        }
        HMSLog.m36988i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AvailableCallBack m30145a() {
        return this.f23076b;
    }
}
