package p394jf;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0224k0;
import p809yg.C13981a;

/* renamed from: jf.d */
/* loaded from: classes4.dex */
public abstract class AbstractC10816d {
    /* renamed from: a */
    public static void m65865a(Context context) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("com.huawei.android.widget.LockPatternUtilsEx");
            cls.getMethod("clearVisitorLock", new Class[0]).invoke(cls.getConstructor(Context.class).newInstance(context), new Object[0]);
        } catch (ClassNotFoundException e10) {
            C13981a.m83988e("LockScreenUtils", "ClassNotFoundException " + e10.getMessage());
        } catch (IllegalAccessException e11) {
            C13981a.m83988e("LockScreenUtils", "IllegalAccessException" + e11.getMessage());
        } catch (IllegalArgumentException e12) {
            C13981a.m83988e("LockScreenUtils", "IllegalArgumentException" + e12.getMessage());
        } catch (InstantiationException e13) {
            C13981a.m83988e("LockScreenUtils", "InstantiationException" + e13.getMessage());
        } catch (NoSuchMethodException e14) {
            C13981a.m83988e("LockScreenUtils", "NoSuchMethodException" + e14.getMessage());
        } catch (InvocationTargetException e15) {
            C13981a.m83988e("LockScreenUtils", "InvocationTargetException" + e15.getMessage());
        }
        Settings.Secure.putInt(context.getContentResolver(), "privacy_mode_on", 0);
        Settings.Secure.putInt(context.getContentResolver(), "privacy_mode_state", 0);
    }

    /* renamed from: b */
    public static boolean m65866b(DevicePolicyManager devicePolicyManager, ComponentName componentName) {
        return devicePolicyManager.isAdminActive(componentName);
    }

    /* renamed from: c */
    public static boolean m65867c(DevicePolicyManager devicePolicyManager, ComponentName componentName, String str, int i10, Context context) {
        boolean zM65872h;
        C13981a.m83989i("LockScreenUtils", "start lockScreen:" + i10);
        if (i10 != 0 || TextUtils.isEmpty(str)) {
            zM65872h = true;
        } else {
            C13981a.m83989i("LockScreenUtils", "resetPassword");
            zM65872h = Build.VERSION.SDK_INT == 29 ? m65872h(context, str) : m65871g(context, str);
        }
        devicePolicyManager.lockNow();
        return zM65872h;
    }

    /* renamed from: d */
    public static boolean m65868d(DevicePolicyManager devicePolicyManager, ComponentName componentName) {
        try {
            C0224k0.m1540J(devicePolicyManager, componentName, false);
            return true;
        } catch (Exception e10) {
            C13981a.m83988e("LockScreenUtils", "setActiveAdmin Exception" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: e */
    public static void m65869e(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), "device_remote_lock", z10 ? 1 : 0);
        C13981a.m83989i("LockScreenUtils", "setDeviceRemoteLocked:" + (z10 ? 1 : 0));
    }

    /* renamed from: f */
    public static void m65870f(Context context, String str) {
        if (str == null) {
            str = "";
        }
        Settings.Global.putString(context.getContentResolver(), "device_remote_lock_info", str);
        C13981a.m83989i("LockScreenUtils", "setDeviceRemoteLockedInfo is empty?:" + TextUtils.isEmpty(str));
    }

    /* renamed from: g */
    public static boolean m65871g(Context context, String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            C13981a.m83989i("LockScreenUtils", "set lock screen >= R");
            Class<?> cls = Class.forName("com.android.internal.widget.LockscreenCredential");
            Object objInvoke = cls.getMethod("createPin", CharSequence.class).invoke(cls, str);
            Object objInvoke2 = cls.getMethod("createNone", new Class[0]).invoke(cls, new Object[0]);
            Class<?> cls2 = Class.forName("com.android.internal.widget.LockPatternUtils");
            boolean zBooleanValue = ((Boolean) cls2.getMethod("setLockCredential", cls, cls, Integer.TYPE).invoke(cls2.getConstructor(Context.class).newInstance(context), objInvoke, objInvoke2, Integer.valueOf(C0224k0.m1536F()))).booleanValue();
            C13981a.m83989i("LockScreenUtils", "set lock screen result:" + zBooleanValue);
            return zBooleanValue;
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            Throwable targetException2 = e10;
            if (targetException != null) {
                targetException2 = e10.getTargetException();
            }
            C13981a.m83988e("LockScreenUtils", "set lock screen InvocationTargetException:" + targetException2.getMessage());
            return false;
        } catch (Exception e11) {
            C13981a.m83988e("LockScreenUtils", "set lock screen exception:" + e11.getMessage());
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m65872h(Context context, String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            C13981a.m83989i("LockScreenUtils", "set lock screen");
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(context);
            Class<?> cls2 = Integer.TYPE;
            boolean zBooleanValue = ((Boolean) cls.getMethod("saveLockPassword", String.class, String.class, cls2, cls2).invoke(objNewInstance, str, null, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), Integer.valueOf(C0224k0.m1536F()))).booleanValue();
            C13981a.m83989i("LockScreenUtils", "Q set lock screen result:" + zBooleanValue);
            return zBooleanValue;
        } catch (InvocationTargetException e10) {
            C13981a.m83988e("LockScreenUtils", "Q set lock screen InvocationTargetException:" + (e10.getTargetException() == null ? e10.getMessage() : e10.getTargetException().getMessage()));
            return false;
        } catch (Exception e11) {
            C13981a.m83988e("LockScreenUtils", "Q set lock screen exception:" + e11.getMessage());
            return false;
        }
    }
}
