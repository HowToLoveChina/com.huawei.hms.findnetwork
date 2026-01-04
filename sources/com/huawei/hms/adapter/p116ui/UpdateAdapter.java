package com.huawei.hms.adapter.p116ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.UpdateAdapterMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.p149ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    private WeakReference<Activity> f23140a;

    /* renamed from: b */
    private Context f23141b;

    /* renamed from: c */
    private int f23142c;

    /* renamed from: d */
    private UpdateBean f23143d;

    /* renamed from: e */
    private boolean f23144e = false;

    /* renamed from: a */
    private static Object m30219a(String str, String str2, Object[] objArr) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m36986e("UpdateAdapter", "className is empty.");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            HMSLog.m36986e("UpdateAdapter", "methodName is empty.");
            return null;
        }
        if (objArr == null) {
            HMSLog.m36986e("UpdateAdapter", "args is null.");
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj instanceof Activity) {
                clsArr[i10] = Activity.class;
            } else if (obj instanceof Context) {
                clsArr[i10] = Context.class;
            } else if (obj instanceof UpdateBean) {
                clsArr[i10] = UpdateBean.class;
            } else if (obj instanceof Integer) {
                clsArr[i10] = Integer.TYPE;
            } else if (obj instanceof Boolean) {
                clsArr[i10] = Boolean.TYPE;
            } else {
                HMSLog.m36986e("UpdateAdapter", "not set args[" + i10 + "] type");
            }
        }
        Class<?> cls = Class.forName(str);
        return cls.getMethod(str2, clsArr).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), objArr);
    }

    /* renamed from: b */
    private Activity m30224b() {
        WeakReference<Activity> weakReference = this.f23140a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: c */
    private void m30225c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        m30220a();
    }

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        try {
            return m30219a(str, str2, objArr);
        } catch (Throwable th2) {
            HMSLog.m36986e("UpdateAdapter", "invoke " + str + "." + str2 + " fail. " + th2.getMessage());
            return null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m36988i("UpdateAdapter", "activity == null");
            m30225c();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m36988i("UpdateAdapter", "activity is finishing");
            m30225c();
            return;
        }
        this.f23141b = activity.getApplicationContext();
        this.f23140a = new WeakReference<>(activity);
        UpdateAdapterMgr.INST.onActivityCreate(m30224b());
        Intent intent = activity.getIntent();
        if (intent == null) {
            m30225c();
            return;
        }
        try {
            this.f23142c = intent.getIntExtra(CommonCode.MapKey.UPDATE_VERSION, 0);
        } catch (Throwable th2) {
            HMSLog.m36986e("UpdateAdapter", "get update_version:" + th2.getMessage());
        }
        if (this.f23142c == 0) {
            m30225c();
            return;
        }
        if (intent.hasExtra("installHMS")) {
            this.f23144e = true;
        }
        if (m30223a(intent, activity)) {
            return;
        }
        try {
            if (AvailableUtil.isInstallerLibExist(this.f23141b)) {
                UpdateBean updateBean = (UpdateBean) m30219a("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{activity, Integer.valueOf(this.f23142c), Boolean.valueOf(this.f23144e)});
                this.f23143d = updateBean;
                m30219a("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{activity, updateBean, 1001});
                this.f23143d = null;
            }
        } catch (Throwable th3) {
            HMSLog.m36986e("UpdateAdapter", "InstallerAdapter.startUpdateHms is failed. message：" + th3.getMessage());
            m30225c();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m36988i("UpdateAdapter", "onBridgeActivityDestroy");
        UpdateAdapterMgr.INST.onActivityDestroy(m30224b());
        this.f23140a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        if (i10 != getRequestCode()) {
            this.f23143d = null;
            return false;
        }
        HMSLog.m36988i("UpdateAdapter", "onBridgeActivityResult " + i11);
        if (AvailableUtil.isInstallerLibExist(this.f23141b) && i11 == 1214) {
            HMSLog.m36988i("UpdateAdapter", "Enter update escape route");
            Activity activityM30224b = m30224b();
            if (activityM30224b == null) {
                HMSLog.m36986e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.f23143d = null;
                return true;
            }
            invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{activityM30224b, 1001, this.f23143d});
            this.f23143d = null;
        }
        if (i11 == -1) {
            if (intent != null) {
                try {
                    if (intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0) == 1) {
                        HMSLog.m36988i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                        SystemManager.getInstance().notifyUpdateResult(0);
                        this.f23143d = null;
                        m30220a();
                        return true;
                    }
                } catch (Throwable unused) {
                    HMSLog.m36989w("UpdateAdapter", "get kit_update_result failed, throwable occur.");
                }
                m30221a(intent);
            }
        } else if (i11 == 0) {
            HMSLog.m36988i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.f23143d = null;
            Activity activityM30224b2 = m30224b();
            if (activityM30224b2 == null) {
                return true;
            }
            String hMSPackageName = HMSPackageManager.getInstance(activityM30224b2.getApplicationContext()).getHMSPackageName();
            if (TextUtils.isEmpty(hMSPackageName)) {
                hMSPackageName = "com.huawei.hwid";
            }
            if (this.f23144e || m30222a(activityM30224b2, hMSPackageName, this.f23142c)) {
                HMSLog.m36988i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                SystemManager.getInstance().notifyUpdateResult(0);
            }
        } else if (i11 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        m30220a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m36988i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.m36988i("UpdateAdapter", "On key up when resolve conn error");
    }

    /* renamed from: a */
    private boolean m30223a(Intent intent, Activity activity) {
        if (!intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            return false;
        }
        HMSLog.m36988i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        if (TextUtils.isEmpty(hMSPackageName)) {
            HMSLog.m36989w("UpdateAdapter", "hmsPackageName is empty, update invalid.");
            m30225c();
            return true;
        }
        ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        Intent intent2 = new Intent();
        intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
        intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
        intent2.setComponent(componentName);
        activity.startActivityForResult(intent2, 1001);
        return true;
    }

    /* renamed from: a */
    private void m30221a(Intent intent) {
        int intExtra = -1;
        try {
            intExtra = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        } catch (Throwable unused) {
            HMSLog.m36989w("UpdateAdapter", "get extra_result failed, throwable occur.");
        }
        if (intExtra == 0) {
            HMSLog.m36988i("UpdateAdapter", "Error resolved successfully!");
            SystemManager.getInstance().notifyUpdateResult(0);
        } else if (intExtra == 13) {
            HMSLog.m36988i("UpdateAdapter", "Resolve error process canceled by user!");
            SystemManager.getInstance().notifyUpdateResult(13);
        } else if (intExtra == 8) {
            HMSLog.m36988i("UpdateAdapter", "Internal error occurred, recommended retry.");
            SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            HMSLog.m36988i("UpdateAdapter", "Other error codes.");
            SystemManager.getInstance().notifyUpdateResult(intExtra);
        }
    }

    /* renamed from: a */
    private void m30220a() {
        Activity activityM30224b = m30224b();
        if (activityM30224b == null || activityM30224b.isFinishing()) {
            return;
        }
        activityM30224b.finish();
    }

    /* renamed from: a */
    private boolean m30222a(Context context, String str, int i10) {
        if (context != null && !TextUtils.isEmpty(str) && i10 != 0) {
            PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
            return PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) || packageManagerHelper.getPackageVersionCode(str) < i10;
        }
        HMSLog.m36989w("UpdateAdapter", "Please check your params, one of params is invalid.");
        return false;
    }
}
