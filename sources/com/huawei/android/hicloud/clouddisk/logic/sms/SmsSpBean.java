package com.huawei.android.hicloud.clouddisk.logic.sms;

import p514o9.C11839m;

/* loaded from: classes2.dex */
public class SmsSpBean implements Comparable<SmsSpBean> {
    private static final String TAG = "SmsSpBean";

    /* renamed from: id */
    private String f11830id;
    private String msg;

    public SmsSpBean() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmsSpBean smsSpBean = (SmsSpBean) obj;
        String str = this.f11830id;
        if (str == null) {
            if (smsSpBean.f11830id != null) {
                return false;
            }
        } else if (!str.equals(smsSpBean.f11830id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return this.f11830id;
    }

    public String getSmsStr() {
        return this.msg;
    }

    public int hashCode() {
        String str = this.f11830id;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setId(String str) {
        this.f11830id = str;
    }

    public void setSmsStr(String str) {
        this.msg = str;
    }

    public SmsSpBean(String str, String str2) {
        this.f11830id = str;
        this.msg = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(SmsSpBean smsSpBean) throws NumberFormatException {
        try {
            Long lValueOf = Long.valueOf(this.f11830id);
            Long lValueOf2 = Long.valueOf(smsSpBean.f11830id);
            if (lValueOf == null || lValueOf2 == null) {
                return -1;
            }
            return lValueOf2.compareTo(lValueOf);
        } catch (NumberFormatException e10) {
            C11839m.m70687e(TAG, "SmsSpBean compareTo " + e10.toString());
            return -1;
        }
    }
}
