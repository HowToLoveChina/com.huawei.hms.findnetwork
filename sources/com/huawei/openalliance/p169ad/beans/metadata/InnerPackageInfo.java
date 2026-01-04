package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class InnerPackageInfo {
    private String packageName;
    private String versionName;

    public boolean equals(Object obj) {
        if (obj instanceof InnerPackageInfo) {
            return !TextUtils.isEmpty(this.packageName) && this.packageName.equals(((InnerPackageInfo) obj).packageName);
        }
        return false;
    }

    public int hashCode() {
        String str = this.packageName;
        if (str != null) {
            return str.hashCode();
        }
        return -1;
    }
}
