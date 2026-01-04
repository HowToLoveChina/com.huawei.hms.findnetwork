package com.huawei.hms.network.embedded;

import com.huawei.hms.network.netdiag.qoe.QoeMetrics;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.t5 */
/* loaded from: classes8.dex */
public class C6099t5 extends QoeMetrics {

    /* renamed from: a */
    public String f28392a;

    /* renamed from: b */
    public Map<String, Integer> f28393b;

    /* renamed from: c */
    public boolean f28394c;

    public C6099t5(Map<String, Integer> map) {
        String str;
        this.f28394c = false;
        this.f28393b = map;
        this.f28394c = map.get("status").intValue() == 1;
        if (map.containsKey("channelIndex0")) {
            str = "0";
        } else {
            if (!map.containsKey("channelIndex2")) {
                this.f28394c = false;
                return;
            }
            str = "2";
        }
        this.f28392a = str;
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getChannelIndex() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28171e + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getChannelNum() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28170d).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getDlBandwidth() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28177k + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getDlRate() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28179m + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getDlRtt() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28175i + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getNetQoeLevel() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28181o + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getUlBandwidth() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28176j + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getUlPkgLossRate() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28180n + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getUlRate() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28178l + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public int getUlRtt() {
        Map<String, Integer> map = this.f28393b;
        if (map == null || !this.f28394c) {
            return Integer.MAX_VALUE;
        }
        return map.get(C6086s5.f28174h + this.f28392a).intValue();
    }

    @Override // com.huawei.hms.network.netdiag.qoe.QoeMetrics
    public boolean isSuccess() {
        return this.f28394c;
    }
}
