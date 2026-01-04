package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AdSource implements Serializable {
    private static final long serialVersionUID = 30457300;
    private int displayPosition;
    private String dspLogo;
    private String dspName;

    /* renamed from: a */
    public static AdSource m39547a(List<AdSource> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return null;
        }
        for (AdSource adSource : list) {
            if (m39548a(adSource)) {
                return adSource;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static AdSource m39549b(List<AdSource> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return null;
        }
        for (AdSource adSource : list) {
            if (m39550b(adSource)) {
                return adSource;
            }
        }
        return null;
    }

    /* renamed from: c */
    public int m39556c() {
        return this.displayPosition;
    }

    /* renamed from: a */
    public String m39551a() {
        return this.dspName;
    }

    /* renamed from: b */
    public String m39554b() {
        return this.dspLogo;
    }

    /* renamed from: a */
    public void m39552a(int i10) {
        this.displayPosition = i10;
    }

    /* renamed from: b */
    public void m39555b(String str) {
        this.dspLogo = str;
    }

    /* renamed from: b */
    private static boolean m39550b(AdSource adSource) {
        return adSource != null && adSource.m39556c() == 2;
    }

    /* renamed from: a */
    public void m39553a(String str) {
        this.dspName = str;
    }

    /* renamed from: a */
    private static boolean m39548a(AdSource adSource) {
        return adSource != null && adSource.m39556c() == 1;
    }
}
