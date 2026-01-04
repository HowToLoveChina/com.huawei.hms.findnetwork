package ht;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.huawei.ohos.localability.base.BundleInfo;
import com.huawei.ohos.localability.base.C6846d;
import com.huawei.ohos.localability.base.HapModuleInfo;
import com.huawei.ohos.localability.base.IInstallerCallback;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.json.JSONException;

/* renamed from: ht.a */
/* loaded from: classes8.dex */
public class C10338a {

    /* renamed from: a */
    public static final C10338a f50021a = new C10338a();

    /* renamed from: c */
    public static void m63657c(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.w("BundleMgrProxy", "safeCloseStream failure");
            }
        }
    }

    /* renamed from: a */
    public final String m63658a(File file, Context context) throws IOException {
        String canonicalPath;
        IOException e10;
        if (file == null || !file.exists()) {
            Log.e("BundleMgrProxy", "BundleMgrProxy::getFormattedPath file is null or empty");
            return "";
        }
        try {
            canonicalPath = file.getCanonicalPath();
            if (context == null) {
                return canonicalPath;
            }
            try {
                File filesDir = context.getFilesDir();
                if (filesDir == null) {
                    Log.e("BundleMgrProxy", "getFilesDir failed");
                    return "";
                }
                String canonicalPath2 = filesDir.getCanonicalPath();
                Log.d("BundleMgrProxy", "BundleMgrProxy::getFormattedPath appPath = " + canonicalPath2);
                if (canonicalPath.startsWith(canonicalPath2)) {
                    return canonicalPath;
                }
                return canonicalPath2 + canonicalPath;
            } catch (IOException e11) {
                e10 = e11;
                Log.e("BundleMgrProxy", "BundleMgrProxy::getFormattedPath exception: " + e10.getMessage());
                return canonicalPath;
            }
        } catch (IOException e12) {
            canonicalPath = "";
            e10 = e12;
        }
    }

    /* renamed from: b */
    public final void m63659b(IBinder iBinder) {
        Log.i("BundleMgrProxy", "closeInstallFactory begin");
        if (iBinder == null) {
            Log.e("BundleMgrProxy", "closeInstallFactory: installer is null");
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken("OHOS.Appexecfwk.IBundleInstaller");
                parcelObtain.writeInt(0);
                if (!iBinder.transact(5, parcelObtain, parcelObtain2, 0)) {
                    Log.e("BundleMgrProxy", "closeInstallFactory: transact error");
                    return;
                }
            } catch (RemoteException e10) {
                Log.e("BundleMgrProxy", "closeInstallFactory: transact accur exception:" + e10);
            }
            Log.i("BundleMgrProxy", "closeInstallFactory end");
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x026e A[SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m63660d(android.content.Context r11, java.util.ArrayList<java.lang.String> r12, com.huawei.ohos.localability.base.InstallParam r13, com.huawei.ohos.localability.base.IInstallerCallback r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ht.C10338a.m63660d(android.content.Context, java.util.ArrayList, com.huawei.ohos.localability.base.InstallParam, com.huawei.ohos.localability.base.IInstallerCallback):boolean");
    }

    /* renamed from: e */
    public final boolean m63661e(IBinder iBinder, IInstallerCallback iInstallerCallback) {
        if (iBinder == null) {
            Log.e("BundleMgrProxy", "install: installerFactory is null");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("OHOS.Appexecfwk.IInstallFactory");
            parcelObtain.writeStrongBinder(iInstallerCallback == null ? null : iInstallerCallback.asBinder());
            if (iBinder.transact(1, parcelObtain, parcelObtain2, 0)) {
                return parcelObtain2.readBoolean();
            }
            Log.e("BundleMgrProxy", "install: transact error");
            return false;
        } catch (RemoteException e10) {
            Log.e("BundleMgrProxy", "install: transact accur exception:" + e10);
            return false;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: f */
    public final boolean m63662f(File file) {
        String str;
        if (file.exists()) {
            if (file.isFile() && file.canRead() && file.length() > 0) {
                String name = file.getName();
                if (name.endsWith(".hap") || name.endsWith(".hsp")) {
                    return true;
                }
            }
            str = "file is invalid";
        } else {
            str = "file is not exist";
        }
        Log.w("BundleMgrProxy", str);
        return false;
    }

    /* renamed from: g */
    public List<BundleInfo> m63663g() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList arrayList;
        int i10;
        int i11;
        IBinder iBinderM63672a = C10340c.m63672a();
        if (iBinderM63672a == null) {
            Log.w("BundleMgrProxy", "getBundleInfos failed, bundleMgr is null");
            return Collections.EMPTY_LIST;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
                iBinderM63672a.transact(85, parcelObtain, parcelObtain2, 0);
                i11 = parcelObtain2.readInt();
            } catch (RemoteException | JSONException unused) {
                arrayList = null;
            }
            if (i11 != 0) {
                Log.e("BundleMgrProxy", "getBundleInfos failed, error code is: " + i11);
                return Collections.EMPTY_LIST;
            }
            int i12 = parcelObtain2.readInt();
            if (i12 <= 0) {
                Log.e("BundleMgrProxy", "getBundleInfos failed, size is invalid");
                return Collections.EMPTY_LIST;
            }
            arrayList = new ArrayList(i12);
            for (i10 = 0; i10 < i12; i10++) {
                try {
                    if (parcelObtain2.readBoolean()) {
                        try {
                            arrayList.add(new BundleInfo(C6846d.CREATOR.createFromParcel(parcelObtain2)));
                        } catch (NullPointerException unused2) {
                            Log.e("BundleMgrProxy", "Init Object NullPointerException occur.");
                            return arrayList;
                        }
                    } else {
                        Log.e("BundleMgrProxy", "getBundleInfos failed, i is " + i10);
                    }
                } catch (RemoteException | JSONException unused3) {
                    Log.e("BundleMgrProxy", "getBundleInfos RemoteException occur");
                    return arrayList;
                }
            }
            return arrayList;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: h */
    public Optional<BundleInfo> m63664h(String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strM63674c = C10340c.m63674c();
        if ("".equals(strM63674c) || strM63674c == null || strM63674c.equals("1.0")) {
            Log.e("BundleMgrProxy", "getBundleInfo failed, bundleMgrVersion is too lower");
            return Optional.empty();
        }
        if (str == null || str.isEmpty()) {
            Log.e("BundleMgrProxy", "getBundleInfo failed, bundleName is null of empty");
            return Optional.empty();
        }
        IBinder iBinderM63672a = C10340c.m63672a();
        if (iBinderM63672a == null) {
            Log.e("BundleMgrProxy", " getBmsProxy return null");
            return Optional.empty();
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        parcelObtain.writeString(str);
        parcelObtain.writeInt(i10);
        try {
            iBinderM63672a.transact(84, parcelObtain, parcelObtain2, 0);
            int i11 = parcelObtain2.readInt();
            if (i11 == 0) {
                return parcelObtain2.readBoolean() ? Optional.of(new BundleInfo(C6846d.CREATOR.createFromParcel(parcelObtain2))) : Optional.empty();
            }
            Log.e("BundleMgrProxy", "GetBundleInfo from code error" + i11);
            return Optional.empty();
        } catch (RemoteException | JSONException e10) {
            Log.e("BundleMgrProxy", "getBmsProxy transact accur exception:" + e10);
            return Optional.empty();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: i */
    public final IBinder m63665i() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinderM63672a = C10340c.m63672a();
        if (iBinderM63672a == null) {
            Log.w("BundleMgrProxy", "getBundleInstaller bundleMgr is null");
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        try {
            if (!iBinderM63672a.transact(14, parcelObtain, parcelObtain2, 0)) {
                Log.e("BundleMgrProxy", "getBundleInstaller: transact error");
                return null;
            }
            int i10 = parcelObtain2.readInt();
            if (i10 == 0) {
                return parcelObtain2.readStrongBinder();
            }
            if (i10 == 8519811) {
                Log.e("BundleMgrProxy", "getBundleInstaller permission denied");
                return null;
            }
            Log.e("BundleMgrProxy", "getBundleInstaller failed, result is" + i10);
            return null;
        } catch (RemoteException e10) {
            Log.e("BundleMgrProxy", "getBundleInstaller transact accur exception:" + e10);
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: j */
    public C10339b m63666j() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strM63669m = m63669m("hw_sc.build.os.devicetype");
        int iIntValue = 0;
        if (strM63669m != null && strM63669m.isEmpty()) {
            Log.e("BundleMgrProxy", "get device type failed by the key hw_sc.build.os.devicetype, and get it again by the old key ro.build.characteristic instead.");
            strM63669m = m63669m("ro.build.characteristics");
            strM63669m.hashCode();
            switch (strM63669m) {
                case "watch":
                    strM63669m = "wearable";
                    break;
                case "fitnessWatch":
                    strM63669m = "liteWearable";
                    break;
                case "default":
                    strM63669m = "phone";
                    break;
            }
        }
        String strM63669m2 = m63669m(SystemProperties.HW_SC_BUILD_OS_API_VERSION);
        if (strM63669m2 != null && strM63669m2.isEmpty()) {
            Log.e("BundleMgrProxy", "get api version failed by the key hw_sc.build.os.apiversion, and get it again by the old key ro.build.ohos.apiversion instead.");
            strM63669m2 = m63669m("ro.build.ohos.apiversion");
        }
        if (strM63669m2 != null && !"".equals(strM63669m2)) {
            iIntValue = Integer.valueOf(strM63669m2).intValue();
        }
        return new C10339b(strM63669m, iIntValue);
    }

    /* renamed from: k */
    public Pair<Integer, Integer> m63667k(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Pair<Integer, Integer> pair;
        if (str == null || str.isEmpty()) {
            Log.e("BundleMgrProxy", "getSdkVersionInfo failed, bundleName is null of empty");
            return new Pair<>(0, 0);
        }
        IBinder iBinderM63672a = C10340c.m63672a();
        if (iBinderM63672a == null) {
            Log.w("BundleMgrProxy", "getSdkVersionInfo failed, bundleMgr is null");
            return new Pair<>(0, 0);
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(0);
            if (iBinderM63672a.transact(12, parcelObtain, parcelObtain2, 0)) {
                int i10 = parcelObtain2.readInt();
                if (i10 != 0) {
                    Log.w("BundleMgrProxy", "getSdkVersionInfo false, errCode = " + i10);
                    pair = new Pair<>(0, 0);
                } else {
                    if (parcelObtain2.readBoolean()) {
                        BundleInfo bundleInfoCreateFromParcel = BundleInfo.CREATOR.createFromParcel(parcelObtain2);
                        return new Pair<>(Integer.valueOf(bundleInfoCreateFromParcel.m38545e()), Integer.valueOf(bundleInfoCreateFromParcel.m38544d()));
                    }
                    pair = new Pair<>(0, 0);
                }
            } else {
                Log.w("BundleMgrProxy", "getSdkVersionInfo failed, transact error");
                pair = new Pair<>(0, 0);
            }
            return pair;
        } catch (RemoteException unused) {
            Log.e("BundleMgrProxy", "RemoteException");
            return new Pair<>(0, 0);
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: l */
    public List<String> m63668l() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<HapModuleInfo> listM38543c;
        ArrayList arrayList = new ArrayList();
        List<BundleInfo> listM63663g = f50021a.m63663g();
        if (listM63663g == null) {
            Log.w("BundleMgrProxy", "getServiceBundleNames getBundleInfos return null:");
            return arrayList;
        }
        for (BundleInfo bundleInfo : listM63663g) {
            if (bundleInfo != null) {
                boolean zM38549i = bundleInfo.m38549i();
                Log.d("BundleMgrProxy", "getServiceBundleNames bundleName:" + bundleInfo.m38546f() + ", isEntryInstallationFree:" + zM38549i);
                if (!zM38549i) {
                    String strM38542a = bundleInfo.m38542a();
                    Log.d("BundleMgrProxy", "getServiceBundleNames entryModuleName:" + strM38542a);
                    if (strM38542a != null && !strM38542a.isEmpty() && (listM38543c = bundleInfo.m38543c()) != null) {
                        for (HapModuleInfo hapModuleInfo : listM38543c) {
                            if (hapModuleInfo != null && strM38542a.equals(hapModuleInfo.m38571a())) {
                                break;
                            }
                        }
                    }
                }
                arrayList.add(bundleInfo.m38546f());
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    public final String m63669m(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            Log.w("BundleMgrProxy", "getSystemProperty error");
            return null;
        }
    }

    /* renamed from: n */
    public boolean m63670n(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (str == null || str.isEmpty()) {
            Log.e("BundleMgrProxy", "isHarmonyApp failed, bundleName is null of empty");
            return false;
        }
        IBinder iBinderM63672a = C10340c.m63672a();
        if (iBinderM63672a == null) {
            Log.w("BundleMgrProxy", "isHarmonyApp failed, bundleMgr is null");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(0);
            if (!iBinderM63672a.transact(12, parcelObtain, parcelObtain2, 0)) {
                Log.w("BundleMgrProxy", "isHarmonyApp failed, transact error");
                return false;
            }
            int i10 = parcelObtain2.readInt();
            if (i10 == 0) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return true;
            }
            Log.w("BundleMgrProxy", "isHarmonyApp false, errCode = " + i10);
            return false;
        } catch (RemoteException unused) {
            Log.e("BundleMgrProxy", "RemoteException");
            return false;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
