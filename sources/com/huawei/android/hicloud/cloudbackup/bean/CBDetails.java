package com.huawei.android.hicloud.cloudbackup.bean;

import android.graphics.Bitmap;
import java.text.Collator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class CBDetails implements Comparable<CBDetails> {
    private String appId;
    private CharSequence appName;
    private Bitmap bitmap;
    private String count;
    private boolean isChecked;
    private long size;

    public CBDetails() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CBDetails cBDetails = (CBDetails) obj;
        String str = this.appId;
        if (str == null) {
            if (cBDetails.appId != null) {
                return false;
            }
        } else if (!str.equals(cBDetails.appId)) {
            return false;
        }
        CharSequence charSequence = this.appName;
        if (charSequence == null) {
            if (cBDetails.appName != null) {
                return false;
            }
        } else if (!charSequence.toString().equals(cBDetails.appName.toString())) {
            return false;
        }
        return this.size == cBDetails.size;
    }

    public String getAppId() {
        return this.appId;
    }

    public CharSequence getAppName() {
        return this.appName;
    }

    public String getBackupAppId() {
        return this.appId;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getCount() {
        return this.count;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        String str = this.appId;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        CharSequence charSequence = this.appName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        long j10 = this.size;
        return iHashCode2 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppName(CharSequence charSequence) {
        this.appName = charSequence;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public CBDetails(String str, boolean z10) {
        this.appId = str;
        this.isChecked = z10;
    }

    @Override // java.lang.Comparable
    public int compareTo(CBDetails cBDetails) {
        long j10 = this.size;
        long j11 = cBDetails.size;
        if (j10 < j11) {
            return 1;
        }
        if (j10 > j11) {
            return -1;
        }
        CharSequence charSequence = cBDetails.appName;
        CharSequence charSequence2 = this.appName;
        if (charSequence == null) {
            return -1;
        }
        if (charSequence2 == null) {
            return 1;
        }
        return Collator.getInstance(Locale.CHINESE).compare(charSequence2.toString(), charSequence.toString());
    }
}
