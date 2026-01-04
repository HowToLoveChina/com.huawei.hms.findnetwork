package com.huawei.hms.network.embedded;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import com.huawei.hms.framework.common.ReflectionUtils;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.a2 */
/* loaded from: classes8.dex */
public class C5845a2 extends PackageManager {

    /* renamed from: b */
    public static final String f26329b = "NetworkKitPackageManager";

    /* renamed from: c */
    public static final String f26330c = "versionCode";

    /* renamed from: d */
    public static final String f26331d = "not supported";

    /* renamed from: a */
    public Context f26332a;

    public C5845a2(Context context) {
        this.f26332a = context;
    }

    @Override // android.content.pm.PackageManager
    public void addPackageToPreferred(String str) {
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermission(PermissionInfo permissionInfo) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermissionAsync(PermissionInfo permissionInfo) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public void addPreferredActivity(IntentFilter intentFilter, int i10, ComponentName[] componentNameArr, ComponentName componentName) {
    }

    @Override // android.content.pm.PackageManager
    public boolean canRequestPackageInstalls() {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public String[] canonicalToCurrentPackageNames(String[] strArr) {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public int checkPermission(String str, String str2) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(int i10, int i11) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public void clearInstantAppCookie() {
    }

    @Override // android.content.pm.PackageManager
    public void clearPackagePreferredActivities(String str) {
    }

    @Override // android.content.pm.PackageManager
    public String[] currentToCanonicalPackageNames(String[] strArr) {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public void extendVerificationTimeout(int i10, int i11, long j10) {
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getActivityInfo(ComponentName componentName, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionGroupInfo> getAllPermissionGroups(int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getApplicationEnabledSetting(String str) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ApplicationInfo getApplicationInfo(String str, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ChangedPackages getChangedPackages(int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getComponentEnabledSetting(ComponentName componentName) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDefaultActivityIcon() {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDrawable(String str, int i10, ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<ApplicationInfo> getInstalledApplications(int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getInstalledPackages(int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public String getInstallerPackageName(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public byte[] getInstantAppCookie() {
        return new byte[0];
    }

    @Override // android.content.pm.PackageManager
    public int getInstantAppCookieMaxBytes() {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Intent getLaunchIntentForPackage(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Intent getLeanbackLaunchIntentForPackage(String str) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public String getNameForUid(int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str) throws PackageManager.NameNotFoundException {
        return new int[0];
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(VersionedPackage versionedPackage, int i10) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = this.f26332a.getApplicationInfo();
        int iIntValue = ((Integer) ReflectionUtils.getFieldObj(applicationInfo.getClass(), "versionCode")).intValue();
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.applicationInfo = applicationInfo;
        packageInfo.versionName = f26331d;
        packageInfo.activities = null;
        packageInfo.packageName = this.f26332a.getPackageName();
        packageInfo.versionCode = iIntValue;
        return packageInfo;
    }

    @Override // android.content.pm.PackageManager
    public PackageInstaller getPackageInstaller() {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getPackageUid(String str, int i10) throws PackageManager.NameNotFoundException {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public String[] getPackagesForUid(int i10) {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPackagesHoldingPermissions(String[] strArr, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public PermissionGroupInfo getPermissionGroupInfo(String str, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public PermissionInfo getPermissionInfo(String str, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPreferredPackages(int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo getProviderInfo(ComponentName componentName, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getReceiverInfo(ComponentName componentName, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForActivity(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ServiceInfo getServiceInfo(ComponentName componentName, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<SharedLibraryInfo> getSharedLibraries(int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public FeatureInfo[] getSystemAvailableFeatures() {
        return new FeatureInfo[0];
    }

    @Override // android.content.pm.PackageManager
    public String[] getSystemSharedLibraryNames() {
        return new String[0];
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getText(String str, int i10, ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedDrawableForDensity(Drawable drawable, UserHandle userHandle, Rect rect, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedIcon(Drawable drawable, UserHandle userHandle) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getUserBadgedLabel(CharSequence charSequence, UserHandle userHandle) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public XmlResourceParser getXml(String str, int i10, ApplicationInfo applicationInfo) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp() {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isPermissionRevokedByPolicy(String str, String str2) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isSafeMode() {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<ProviderInfo> queryContentProviders(String str, int i10, int i11) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<InstrumentationInfo> queryInstrumentation(String str, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivities(Intent intent, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentContentProviders(Intent intent, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentServices(Intent intent, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionInfo> queryPermissionsByGroup(String str, int i10) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public void removePackageFromPreferred(String str) {
    }

    @Override // android.content.pm.PackageManager
    public void removePermission(String str) {
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveActivity(Intent intent, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo resolveContentProvider(String str, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveService(Intent intent, int i10) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationCategoryHint(String str, int i10) {
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationEnabledSetting(String str, int i10, int i11) {
    }

    @Override // android.content.pm.PackageManager
    public void setComponentEnabledSetting(ComponentName componentName, int i10, int i11) {
    }

    @Override // android.content.pm.PackageManager
    public void setInstallerPackageName(String str, String str2) {
    }

    @Override // android.content.pm.PackageManager
    public void updateInstantAppCookie(byte[] bArr) {
    }

    @Override // android.content.pm.PackageManager
    public void verifyPendingInstall(int i10, int i11) {
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(String str, String str2) {
        return 0;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(Intent intent) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(Intent intent) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(Intent intent) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(String str) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(String str) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(String str) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str, int i10) throws PackageManager.NameNotFoundException {
        return new int[0];
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(String str, int i10) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = this.f26332a.getApplicationInfo();
        int iIntValue = ((Integer) ReflectionUtils.getFieldObj(applicationInfo, "versionCode")).intValue();
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.applicationInfo = applicationInfo;
        packageInfo.versionName = f26331d;
        packageInfo.activities = null;
        packageInfo.packageName = this.f26332a.getPackageName();
        packageInfo.versionCode = iIntValue;
        return packageInfo;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(String str) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str, int i10) {
        return false;
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp(String str) {
        return false;
    }
}
