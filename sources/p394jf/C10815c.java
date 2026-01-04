package p394jf;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.hihonor.android.app.HwSdLockManager;
import com.huawei.android.remotecontrol.lockscreen.DeviceAdministratorReceiver;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0224k0;
import p809yg.C13981a;

/* renamed from: jf.c */
/* loaded from: classes4.dex */
public class C10815c {
    /* renamed from: a */
    public static int m65862a(String str, String str2, String str3, Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int sDLockPassword;
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        ComponentName componentName = new ComponentName(context, (Class<?>) DeviceAdministratorReceiver.class);
        int iM1558m = C0224k0.m1558m(context);
        if (!AbstractC10816d.m65866b(devicePolicyManager, componentName) && !AbstractC10816d.m65868d(devicePolicyManager, componentName)) {
            m65864c(devicePolicyManager, componentName);
            return 1;
        }
        AbstractC10816d.m65869e(context, true);
        if (!AbstractC10816d.m65867c(devicePolicyManager, componentName, str, iM1558m, context)) {
            AbstractC10816d.m65869e(context, false);
            m65864c(devicePolicyManager, componentName);
            return 1;
        }
        AbstractC10816d.m65870f(context, str3);
        C10818f.m65874a().m65879f(context, true);
        AbstractC10816d.m65865a(context);
        m65864c(devicePolicyManager, componentName);
        if (TextUtils.isEmpty(str2)) {
            return 2;
        }
        if (C0209d.m1277l1()) {
            HwSdLockManager hwSdLockManager = new HwSdLockManager(context);
            int sDLockState = hwSdLockManager.getSDLockState();
            if (sDLockState != 671 && sDLockState != 639) {
                return 2;
            }
            sDLockPassword = hwSdLockManager.setSDLockPassword(str2);
        } else {
            com.huawei.android.app.HwSdLockManager hwSdLockManager2 = new com.huawei.android.app.HwSdLockManager(context);
            int sDLockState2 = hwSdLockManager2.getSDLockState();
            if (sDLockState2 != 671 && sDLockState2 != 639) {
                return 2;
            }
            sDLockPassword = hwSdLockManager2.setSDLockPassword(str2);
        }
        return 200 == sDLockPassword ? 0 : 2;
    }

    /* renamed from: b */
    public static void m65863b(Context context) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        ComponentName componentName = new ComponentName(context, (Class<?>) DeviceAdministratorReceiver.class);
        if (AbstractC10816d.m65866b(devicePolicyManager, componentName) || AbstractC10816d.m65868d(devicePolicyManager, componentName)) {
            AbstractC10816d.m65869e(context, true);
            devicePolicyManager.lockNow();
        }
        m65864c(devicePolicyManager, componentName);
        C10818f.m65874a().m65879f(context, true);
    }

    /* renamed from: c */
    public static void m65864c(DevicePolicyManager devicePolicyManager, ComponentName componentName) {
        try {
            devicePolicyManager.removeActiveAdmin(componentName);
        } catch (Exception e10) {
            C13981a.m83988e("LockScreen", "removeActiveAdmin: " + e10.getMessage());
        }
    }
}
