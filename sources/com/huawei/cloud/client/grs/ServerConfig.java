package com.huawei.cloud.client.grs;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes.dex */
public class ServerConfig extends C11707b {

    /* renamed from: a */
    @InterfaceC4648p("driver_server")
    private DriverServer f21351a;

    public static final class DriverServer extends C11707b {

        /* renamed from: a */
        @InterfaceC4648p("base_url")
        List<String> f21352a;

        public List<String> getBaseUrl() {
            return this.f21352a;
        }

        public void setBaseUrl(List<String> list) {
            this.f21352a = list;
        }
    }

    public DriverServer getDriverServer() {
        return this.f21351a;
    }

    public void setDriverServer(DriverServer driverServer) {
        this.f21351a = driverServer;
    }
}
