package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@DataKeep
/* loaded from: classes8.dex */
public class LandpageAppWhiteList implements Serializable {
    private static final String ALLOW = "-1";
    private static final String REJECT = "-2";
    private static final String TAG = "LandpageAppWhiteList";
    private static final long serialVersionUID = -1613710950822978059L;
    private String type = "-1";
    private Set<String> packageList = null;
    private Map<String, Boolean> promptMap = new HashMap();

    /* renamed from: a */
    public void m40222a(String str) {
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
    public boolean m40225b(String str) {
        if ("-1".equals(this.type)) {
            return true;
        }
        if (REJECT.equals(this.type)) {
            return false;
        }
        Set<String> set = this.packageList;
        return set == null || set.contains(str);
    }

    /* renamed from: c */
    public Boolean m40226c(String str) {
        return this.promptMap.get(str);
    }

    /* renamed from: a */
    public void m40223a(String str, boolean z10) {
        this.promptMap.put(str, Boolean.valueOf(z10));
    }

    /* renamed from: a */
    public void m40224a(Map<String, Boolean> map) {
        if (map != null) {
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                this.promptMap.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
