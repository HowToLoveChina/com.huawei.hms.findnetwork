package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8786h;
import com.huawei.updatesdk.p177a.p178a.p183d.C8779a;
import com.huawei.updatesdk.p177a.p178a.p183d.C8783e;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.AbstractC8799b;
import com.huawei.updatesdk.p191b.p192a.p193a.C8803b;
import com.huawei.updatesdk.p191b.p192a.p194b.C8805b;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import java.util.List;
import java.util.Locale;

/* loaded from: classes9.dex */
public class Param extends AbstractC8799b {

    @SDKNetTransmission
    private String distRule;
    private String fSha2_;
    private int isPre_;
    private List<String> keySets_;
    private int maple_;
    private String oldVersion_;
    private String package_;

    @SDKNetTransmission
    private int pkgMode;
    private String sSha2_;

    @SDKNetTransmission
    private long shellApkVer;
    private int targetSdkVersion_;
    private int versionCode_;

    public Param() {
    }

    private long getShellApkVer(PackageInfo packageInfo) {
        return packageInfo.baseRevisionCode;
    }

    private void prepare(PackageInfo packageInfo) {
        this.package_ = packageInfo.packageName;
        this.versionCode_ = packageInfo.versionCode;
        String str = packageInfo.versionName;
        if (str == null) {
            str = "null";
        }
        this.oldVersion_ = str;
        this.targetSdkVersion_ = packageInfo.applicationInfo.targetSdkVersion;
        this.isPre_ = C8834b.m56312a(packageInfo);
        this.maple_ = C8834b.m56318b(this.package_);
        this.keySets_ = C8805b.m56201a().m56204a(packageInfo);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length > 0) {
            setApkSignature(signatureArr[0].toCharsString());
        }
        this.fSha2_ = C8803b.m56190a().m56191a(packageInfo);
        this.shellApkVer = getShellApkVer(packageInfo);
        this.pkgMode = C8783e.m56054d(this.package_) ? 2 : 0;
        this.distRule = C8834b.m56320b(C8793a.m56132c().m56133a(), this.package_);
    }

    public String getPackageName() {
        return this.package_;
    }

    public void setApkFileSha256(String str) {
        this.fSha2_ = str;
    }

    public void setApkSignature(String str) {
        String strM56066b = AbstractC8786h.m56066b(C8779a.m56032a(AbstractC8786h.m56067c(str)));
        if (TextUtils.isEmpty(strM56066b)) {
            return;
        }
        this.sSha2_ = strM56066b.toLowerCase(Locale.getDefault());
    }

    public void setMapleState(int i10) {
        this.maple_ = i10;
    }

    public void setPackageName(Context context, String str) {
        C8793a.m56131a(context);
        this.package_ = str;
        prepare(C8834b.m56325e(C8793a.m56132c().m56133a(), this.package_));
    }

    public void setTargetSdkVersion(int i10) {
        this.targetSdkVersion_ = i10;
    }

    public void setVersionCode(int i10) {
        this.versionCode_ = i10;
    }

    public void setVersionName(String str) {
        this.oldVersion_ = str;
    }

    public Param(PackageInfo packageInfo) {
        prepare(packageInfo);
    }
}
