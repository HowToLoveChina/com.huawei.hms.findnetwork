package com.huawei.hms.framework.network.restclient.dnkeeper;

import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import java.util.HashMap;

/* loaded from: classes8.dex */
public interface DNSBatchCallback {
    void onResult(HashMap<String, DnsResult> map);
}
