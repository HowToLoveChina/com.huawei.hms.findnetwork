package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@DataKeep
/* loaded from: classes8.dex */
public class LandpageWebBlackList implements Serializable {
    private static final String ALLOW = "-1";
    private static final String REJECT = "-2";
    private static final String TAG = "LandpageWebBlackList";
    private static final long serialVersionUID = -1613710950822978060L;
    private String type = "-1";
    private Set<String> packageList = null;

    /* renamed from: a */
    public void m40227a(String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (REJECT.equals(str)) {
                this.type = REJECT;
                return;
            }
            if ("-1".equals(str)) {
                this.type = "-1";
                return;
            }
            if (this.packageList == null) {
                this.packageList = new HashSet();
            }
            this.packageList.clear();
            String[] strArrSplit = str.split(",");
            int length = strArrSplit.length;
            if (length > 0) {
                for (int i10 = 0; i10 < length; i10++) {
                    if (!TextUtils.isEmpty(strArrSplit[i10])) {
                        this.packageList.add(strArrSplit[i10]);
                    }
                }
            }
            if (this.packageList.size() > 0) {
                this.type = null;
            }
        } catch (RuntimeException unused) {
            str2 = "fromString RuntimeException";
            AbstractC7185ho.m43823c(TAG, str2);
        } catch (Exception unused2) {
            str2 = "fromString Exception";
            AbstractC7185ho.m43823c(TAG, str2);
        }
    }

    /* renamed from: b */
    public boolean m40228b(String str) {
        if (TextUtils.isEmpty(str) || "-1".equals(this.type)) {
            return false;
        }
        if (REJECT.equals(this.type)) {
            return true;
        }
        Set<String> set = this.packageList;
        if (set == null) {
            return false;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
