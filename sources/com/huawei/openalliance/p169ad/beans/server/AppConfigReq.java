package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6935g;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.Device;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.SlotTemplate;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AppConfigReq extends ReqBean {
    private App app;
    private Device device;

    @InterfaceC6929a
    private String gaid;
    private List<SlotTemplate> jsSlotTemplate;

    @InterfaceC6929a
    private String oaid;
    private String routerCountry;
    private String sdkVerCode;

    @InterfaceC6929a
    private String serverStore;

    @InterfaceC6935g
    private String sha256;
    private List<SlotTemplate> slotTemplate;
    private String slotid;
    private String templateEnginVer;

    @InterfaceC6929a
    private String udid;
    private String version = Constants.INTER_VERSION;
    private String sdkversion = Config.SDK_VERSION;

    public AppConfigReq() {
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39254a() {
        return "query";
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: b */
    public String mo39256b() {
        return Constants.SDK_SERVER_REQ_URI;
    }

    /* renamed from: c */
    public void m40869c(String str) {
        this.udid = str;
    }

    /* renamed from: d */
    public void m40870d(String str) {
        this.routerCountry = str;
    }

    /* renamed from: e */
    public void m40871e(String str) {
        this.sdkVerCode = str;
    }

    /* renamed from: f */
    public void m40872f(String str) {
        this.gaid = str;
    }

    /* renamed from: g */
    public void m40873g(String str) {
        this.sha256 = str;
    }

    /* renamed from: h */
    public void m40874h(String str) {
        this.templateEnginVer = str;
    }

    public AppConfigReq(String str) {
        this.slotid = str;
    }

    /* renamed from: a */
    public void m40863a(App app) {
        this.app = app;
    }

    /* renamed from: b */
    public void m40867b(String str) {
        this.oaid = str;
    }

    /* renamed from: a */
    public void m40864a(Device device) {
        this.device = device;
    }

    /* renamed from: b */
    public void m40868b(List<SlotTemplate> list) {
        this.jsSlotTemplate = list;
    }

    /* renamed from: a */
    public void m40865a(String str) {
        this.serverStore = str;
    }

    /* renamed from: a */
    public void m40866a(List<SlotTemplate> list) {
        this.slotTemplate = list;
    }
}
