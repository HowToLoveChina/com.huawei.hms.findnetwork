package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes8.dex */
public class PackageManagerHelper {

    /* renamed from: a */
    private final PackageManager f30200a;

    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED,
        SPOOF
    }

    public PackageManagerHelper(Context context) {
        this.f30200a = context.getPackageManager();
    }

    /* renamed from: a */
    private byte[] m37066a(String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.f30200a.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return signatureArr[0].toByteArray();
            }
        } catch (AndroidException e10) {
            HMSLog.m36986e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e10.getMessage());
        } catch (RuntimeException e11) {
            HMSLog.m36987e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e11);
        }
        HMSLog.m36986e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public String getApplicationName(String str) throws PackageManager.NameNotFoundException {
        try {
            return this.f30200a.getApplicationLabel(this.f30200a.getApplicationInfo(str, 128)).toString();
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m36986e("PackageManagerHelper", "Failed to get application name for " + str);
            return null;
        }
    }

    public long getPackageFirstInstallTime(String str) {
        try {
            PackageInfo packageInfo = this.f30200a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
        } catch (AndroidException | RuntimeException unused) {
        }
        return 0L;
    }

    public String getPackageSignature(String str) {
        byte[] bArrM37066a = m37066a(str);
        if (bArrM37066a == null || bArrM37066a.length == 0) {
            return null;
        }
        return HEX.encodeHexString(SHA256.digest(bArrM37066a), true);
    }

    public String getPackageSigningCertificate(String str) {
        try {
            PackageInfo packageInfo = this.f30200a.getPackageInfo(str, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            if (Objects.isNull(packageInfo, packageInfo.signingInfo)) {
                HMSLog.m36986e("PackageManagerHelper", "packageInfo or packageInfo.signingInfo is null");
                return null;
            }
            Signature[] apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners();
            if (!Objects.isNull(apkContentsSigners, apkContentsSigners[0])) {
                return HEX.encodeHexString(SHA256.digest(apkContentsSigners[0].toByteArray()), true);
            }
            HMSLog.m36986e("PackageManagerHelper", "get V3 signature is null");
            return null;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m36986e("PackageManagerHelper", "getPackageSignatureV3 has exception");
            return null;
        }
    }

    public PackageStates getPackageStates(String str) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m36986e("PackageManagerHelper", "servicePackageName is empty.");
            return PackageStates.NOT_INSTALLED;
        }
        try {
            return this.f30200a.getApplicationInfo(str, 128).enabled ? PackageStates.ENABLED : PackageStates.DISABLED;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m36986e("PackageManagerHelper", "in getPackageStates, getApplicationInfo threw an exception");
            return PackageStates.NOT_INSTALLED;
        }
    }

    public int getPackageVersionCode(String str) {
        try {
            PackageInfo packageInfo = this.f30200a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (AndroidException e10) {
            HMSLog.m36986e("PackageManagerHelper", "get PackageVersionCode failed " + e10);
            return 0;
        } catch (RuntimeException e11) {
            HMSLog.m36987e("PackageManagerHelper", "get PackageVersionCode failed", e11);
            return 0;
        }
    }

    public String getPackageVersionName(String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = this.f30200a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                String str2 = packageInfo.versionName;
                if (str2 != null) {
                    return str2;
                }
            }
            return "";
        } catch (AndroidException unused) {
            return "";
        } catch (RuntimeException e10) {
            HMSLog.m36987e("PackageManagerHelper", "get getPackageVersionName failed", e10);
            return "";
        }
    }

    public boolean hasProvider(String str, String str2) throws PackageManager.NameNotFoundException {
        ProviderInfo[] providerInfoArr;
        try {
            PackageInfo packageInfo = this.f30200a.getPackageInfo(str, 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (str2.equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (AndroidException | RuntimeException unused) {
        }
        return false;
    }

    public boolean isPackageFreshInstall(String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = this.f30200a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime == packageInfo.lastUpdateTime;
            }
            return false;
        } catch (AndroidException | RuntimeException unused) {
            return false;
        }
    }

    public boolean verifyPackageArchive(String str, String str2, String str3) throws IOException {
        PackageInfo packageArchiveInfo;
        InputStream inputStream = null;
        try {
            packageArchiveInfo = this.f30200a.getPackageArchiveInfo(str, 64);
        } catch (Exception e10) {
            HMSLog.m36986e("PackageManagerHelper", "getPackageArchiveInfo Exception. " + e10.getMessage());
            packageArchiveInfo = null;
        }
        if (packageArchiveInfo != null && packageArchiveInfo.signatures.length > 0) {
            try {
                if (!str2.equals(packageArchiveInfo.packageName)) {
                    return false;
                }
                inputStream = IOUtils.toInputStream(packageArchiveInfo.signatures[0].toByteArray());
                return str3.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(inputStream).getEncoded()), true));
            } catch (IOException | CertificateException e11) {
                HMSLog.m36986e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e11.getMessage());
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        return false;
    }
}
