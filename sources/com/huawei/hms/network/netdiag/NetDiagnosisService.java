package com.huawei.hms.network.netdiag;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.network.embedded.AbstractC6046p4;
import com.huawei.hms.network.embedded.AbstractC6137w4;
import com.huawei.hms.network.embedded.AbstractC6176z4;
import com.huawei.hms.network.embedded.C6033o4;
import com.huawei.hms.network.embedded.C6099t5;
import com.huawei.hms.network.embedded.C6151x5;
import com.huawei.hms.network.embedded.InterfaceC6163y4;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.inner.api.NetDiagnosisNetworkService;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.netdiag.qoe.QoeMetrics;
import java.util.Map;

/* loaded from: classes8.dex */
public class NetDiagnosisService extends NetDiagnosisNetworkService {
    public static final String TAG = "NetDiagnosisService";

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public boolean checkConnectivity() {
        return AbstractC6046p4.m34963f().mo34970a();
    }

    @Override // com.huawei.hms.network.inner.api.InterceptorNetworkService
    public Interceptor getInterceptor() {
        return new C6033o4();
    }

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public String getNetworkMetrics() {
        return AbstractC6046p4.m34963f().mo34971b();
    }

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public QoeMetrics getQoeMetrics(boolean z10) {
        return AbstractC6046p4.m34963f().mo34966a(z10);
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getServiceName() {
        return "netdiag";
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getServiceType() {
        return NetDiagnosisService.class.getName();
    }

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public Map<String, Integer> getSignalMetrics() {
        return AbstractC6046p4.m34963f().mo34974c();
    }

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public Map<String, String> getSyncNetDiagnosisInfo(long j10, long j11, boolean z10, boolean z11) {
        AbstractC6176z4 abstractC6176z4Mo34967a = AbstractC6046p4.m34963f().mo34967a(j10, j11);
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        if (abstractC6176z4Mo34967a == null) {
            return linkedHashMapPack.getAll();
        }
        linkedHashMapPack.putIfNotDefault("network_changed", abstractC6176z4Mo34967a.mo33795h(), 0L).putIfNotDefault(C6151x5.f28929e, abstractC6176z4Mo34967a.mo33780a(), 0L).put("mobile_signal_strength", abstractC6176z4Mo34967a.mo33789c().getMobileSignalStrength()).put("wifi_signal_strength", abstractC6176z4Mo34967a.mo33789c().getWifiSignalStrength()).put(C6151x5.f28941q, abstractC6176z4Mo34967a.mo33789c().getLteCqi()).put(C6151x5.f28938n, abstractC6176z4Mo34967a.mo33789c().getLteRsrp()).put(C6151x5.f28937m, abstractC6176z4Mo34967a.mo33789c().getLteRsrq()).put(C6151x5.f28940p, abstractC6176z4Mo34967a.mo33789c().getLteRssi()).put(C6151x5.f28939o, abstractC6176z4Mo34967a.mo33789c().getLteRssnr());
        if (z10) {
            linkedHashMapPack.put(C6151x5.f28926b, abstractC6176z4Mo34967a.mo33794g().mo34222c()).put(C6151x5.f28927c, abstractC6176z4Mo34967a.mo33794g().mo34219b());
            AbstractC6137w4 abstractC6137w4Mo33786b = abstractC6176z4Mo34967a.mo33786b();
            InterfaceC6163y4 interfaceC6163y4Mo35557b = abstractC6137w4Mo33786b.mo35557b(0);
            InterfaceC6163y4 interfaceC6163y4Mo35557b2 = abstractC6137w4Mo33786b.mo35557b(1);
            if (interfaceC6163y4Mo35557b != null && interfaceC6163y4Mo35557b.mo35778c() != 0) {
                linkedHashMapPack.put(C6151x5.f28930f, interfaceC6163y4Mo35557b.mo35776b());
                linkedHashMapPack.put(C6151x5.f28931g, interfaceC6163y4Mo35557b.mo35778c());
                linkedHashMapPack.put(C6151x5.f28932h, interfaceC6163y4Mo35557b.mo35780e());
            }
            if (interfaceC6163y4Mo35557b2 != null && interfaceC6163y4Mo35557b2.mo35778c() != 0) {
                linkedHashMapPack.put(C6151x5.f28933i, interfaceC6163y4Mo35557b2.mo35776b());
                linkedHashMapPack.put(C6151x5.f28934j, interfaceC6163y4Mo35557b2.mo35778c());
                linkedHashMapPack.put(C6151x5.f28935k, interfaceC6163y4Mo35557b2.mo35780e());
            }
        }
        if (z11) {
            Logger.m32136d(TAG, "enable report qoe");
            C6099t5 c6099t5Mo34966a = AbstractC6046p4.m34963f().mo34966a(true);
            if (c6099t5Mo34966a == null || !c6099t5Mo34966a.isSuccess()) {
                return linkedHashMapPack.getAll();
            }
            linkedHashMapPack.put(C6151x5.f28950z, c6099t5Mo34966a.getChannelNum()).put(C6151x5.f28949y, c6099t5Mo34966a.getChannelIndex()).put(C6151x5.f28948x, c6099t5Mo34966a.getDlRate()).put(C6151x5.f28947w, c6099t5Mo34966a.getUlRate()).put(C6151x5.f28946v, c6099t5Mo34966a.getDlBandwidth()).put(C6151x5.f28945u, c6099t5Mo34966a.getUlBandwidth()).put(C6151x5.f28944t, c6099t5Mo34966a.getDlRtt()).put(C6151x5.f28943s, c6099t5Mo34966a.getUlRtt()).put(C6151x5.f28942r, c6099t5Mo34966a.getUlPkgLossRate());
        }
        return linkedHashMapPack.getAll();
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public String getVersion() {
        return "8.0.1.309";
    }

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public Map<String, String> getWebsocketNetworkData(long j10, long j11) {
        AbstractC6176z4 abstractC6176z4Mo34967a = AbstractC6046p4.m34963f().mo34967a(j10, j11);
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        if (abstractC6176z4Mo34967a == null) {
            return linkedHashMapPack.getAll();
        }
        linkedHashMapPack.put("network_changed", abstractC6176z4Mo34967a.mo33795h()).put("mobile_signal_strength", abstractC6176z4Mo34967a.mo33789c().getMobileSignalStrength()).put("wifi_signal_strength", abstractC6176z4Mo34967a.mo33789c().getWifiSignalStrength());
        return linkedHashMapPack.getAll();
    }

    @Override // com.huawei.hms.network.inner.api.InterceptorNetworkService
    public boolean isNetworkInterceptor() {
        return true;
    }

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public boolean networkUnavailable(long j10, long j11) {
        return AbstractC6046p4.m34963f().mo34973b(j10, j11);
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onCreate(Context context, Bundle bundle) {
        AbstractC6046p4.m34963f().mo34968a(context);
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void onDestroy(Context context) {
    }

    @Override // com.huawei.hms.network.inner.api.NetDiagnosisNetworkService
    public void requestThirdMetrics(String str) {
        AbstractC6046p4.m34963f().mo34964a(str);
    }

    @Override // com.huawei.hms.network.inner.api.NetworkService
    public void serviceOptions(Map<String, String> map) {
        String str = map.get(PolicyNetworkService.GlobalConstants.ENABLE_DETECT_WITH_HTTP);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC6046p4.m34963f().mo34972b(Boolean.parseBoolean(str));
    }
}
