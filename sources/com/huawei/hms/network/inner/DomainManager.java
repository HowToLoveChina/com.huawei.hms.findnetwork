package com.huawei.hms.network.inner;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;

/* loaded from: classes8.dex */
public class DomainManager {

    /* renamed from: a */
    public static final String f29541a = "DomainManager";

    /* renamed from: b */
    public static volatile DomainManager f29542b;

    public static DomainManager getInstance() {
        if (f29542b == null) {
            synchronized (DomainManager.class) {
                try {
                    if (f29542b == null) {
                        f29542b = new DomainManager();
                    }
                } finally {
                }
            }
        }
        return f29542b;
    }

    public boolean isExcludePrefetch(String str) {
        return !isHwPhoneAndInChina() || isHaDomain(str);
    }

    public boolean isHaDomain(String str) {
        if (str == null) {
            return false;
        }
        if ((!str.contains("metrics") || !str.contains("dbankcloud")) && (!str.contains("metrics") || !str.contains("hicloud"))) {
            return false;
        }
        Logger.m32143v(f29541a, "ha domain");
        return true;
    }

    public boolean isHwPhoneAndInChina() {
        if (!EmuiUtil.isHuaweiDevice() || !GrsApp.getInstance().getIssueCountryCode(ContextHolder.getAppContext()).equals("CN")) {
            return false;
        }
        Logger.m32143v(f29541a, "huawei device and in china");
        return true;
    }
}
