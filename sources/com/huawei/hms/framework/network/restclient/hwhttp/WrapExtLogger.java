package com.huawei.hms.framework.network.restclient.hwhttp;

import com.huawei.hms.framework.common.ExtLogger;
import com.huawei.hms.network.api.advance.WrapperLogger;

/* loaded from: classes8.dex */
public class WrapExtLogger extends WrapperLogger {
    private final ExtLogger extLogger;

    public WrapExtLogger(ExtLogger extLogger) {
        this.extLogger = extLogger;
    }

    @Override // com.huawei.hms.network.api.advance.WrapperLogger
    /* renamed from: d */
    public void mo32409d(String str, String str2) {
        this.extLogger.mo32129d(str, str2);
    }

    @Override // com.huawei.hms.network.api.advance.WrapperLogger
    /* renamed from: e */
    public void mo32410e(String str, String str2) {
        this.extLogger.mo32130e(str, str2);
    }

    @Override // com.huawei.hms.network.api.advance.WrapperLogger
    /* renamed from: i */
    public void mo32412i(String str, String str2) {
        this.extLogger.mo32132i(str, str2);
    }

    @Override // com.huawei.hms.network.api.advance.WrapperLogger
    /* renamed from: v */
    public void mo32413v(String str, String str2) {
        this.extLogger.mo32133v(str, str2);
    }

    @Override // com.huawei.hms.network.api.advance.WrapperLogger
    /* renamed from: w */
    public void mo32414w(String str, String str2) {
        this.extLogger.mo32134w(str, str2);
    }

    @Override // com.huawei.hms.network.api.advance.WrapperLogger
    /* renamed from: e */
    public void mo32411e(String str, String str2, Throwable th2) {
        this.extLogger.mo32131e(str, str2, th2);
    }

    @Override // com.huawei.hms.network.api.advance.WrapperLogger
    /* renamed from: w */
    public void mo32415w(String str, String str2, Throwable th2) {
        this.extLogger.mo32135w(str, str2, th2);
    }
}
