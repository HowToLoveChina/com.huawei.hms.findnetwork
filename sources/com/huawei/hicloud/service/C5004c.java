package com.huawei.hicloud.service;

import android.content.Context;
import android.os.Build;
import cn.C1461a;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.bean.App;
import com.huawei.hicloud.bean.Client;
import com.huawei.hicloud.bean.Device;
import com.huawei.hicloud.bean.GetLatestConfigReq;
import com.huawei.hicloud.bean.GetLatestConfigResp;
import com.huawei.hicloud.bean.Keys;
import com.huawei.hms.network.conf.api.ConfigService;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import fk.C9721b;
import java.util.HashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0234s;
import p015ak.C0239x;
import p429kk.C11058a;
import p429kk.C11060c;
import p527on.C11976a;
import p618rm.C12540b1;
import p709vj.C13452e;
import p710vk.C13459c;
import tm.C13040c;
import tn.InterfaceC13043a;

/* renamed from: com.huawei.hicloud.service.c */
/* loaded from: classes.dex */
public class C5004c {

    /* renamed from: com.huawei.hicloud.service.c$a */
    public static class a {

        /* renamed from: a */
        public static C5004c f22860a = new C5004c();
    }

    /* renamed from: c */
    public static C5004c m30030c() {
        return a.f22860a;
    }

    /* renamed from: a */
    public GetLatestConfigResp m30031a(Keys[] keysArr) throws C9721b {
        String strM66627b = C11058a.m66627b("07010");
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "batchGetLatestConfig", C13452e.m80781L().m80971t0());
        try {
            String str = C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
            C1461a.m8357d(ConfigService.TAG, " getLatestConfig, url is " + str);
            GetLatestConfigReq getLatestConfigReq = new GetLatestConfigReq();
            getLatestConfigReq.setClient(m30032b());
            getLatestConfigReq.setKeys(keysArr);
            String str2 = (String) C11976a.m72086g(str, new C13459c("", getLatestConfigReq.toString(), strM66627b, keysArr, false), c11060cM66626a);
            C1461a.m8357d(ConfigService.TAG, "batchGetLatestConfig resp : " + str2);
            m30037h(c11060cM66626a);
            return (GetLatestConfigResp) C12540b1.m75483a(str2, GetLatestConfigResp.class);
        } catch (JsonSyntaxException e10) {
            C1461a.m8358e(ConfigService.TAG, "getLatestConfig json err : " + e10.getMessage());
            throw new C9721b(5004, "json exception");
        } catch (C9721b e11) {
            C1461a.m8358e(ConfigService.TAG, "getLatestConfig err : " + e11.getMessage());
            m30036g(c11060cM66626a, keysArr.toString(), e11);
            throw e11;
        }
    }

    /* renamed from: b */
    public Client m30032b() {
        Device deviceM30035f = m30035f();
        App appM30034e = m30034e();
        Client client = new Client();
        client.setDevice(deviceM30035f);
        client.setApp(appM30034e);
        return client;
    }

    /* renamed from: d */
    public String m30033d() {
        return C13452e.m80781L().m80942m();
    }

    /* renamed from: e */
    public final App m30034e() {
        App app = new App();
        app.setId("10055832");
        app.setVersion("16.0.0.300");
        app.setUserID(C13452e.m80781L().m80971t0());
        return app;
    }

    /* renamed from: f */
    public final Device m30035f() {
        Device device = new Device();
        device.setModel(Build.MODEL);
        device.setEmuiVersion(String.valueOf(C0219i.m1463a()));
        device.setRomVersion(C0209d.m1315v());
        device.setOsVersion(Build.VERSION.RELEASE);
        device.setHomeCountry(m30033d());
        device.setRegisterCountry(C13452e.m80781L().m80942m());
        device.setLang(C0234s.m1627e());
        if (C0209d.m1170F1()) {
            device.setDeviceType("2");
        } else {
            device.setDeviceType("1");
        }
        device.setPlatform("1");
        String strM80970t = C13452e.m80781L().m80970t();
        strM80970t.hashCode();
        if (strM80970t.equals("0")) {
            device.setImei(C13452e.m80781L().m80954p());
        } else if (strM80970t.equals("9")) {
            device.setUdid(C13452e.m80781L().m80954p());
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            device.setDeliveryPlace(null);
            device.setPlmn(null);
            device.setOaid(null);
            device.setSn(null);
            int iM1272k0 = C0209d.m1272k0(contextM1377a);
            int iM1268j0 = C0209d.m1268j0(contextM1377a);
            device.setScreenWidth(iM1272k0);
            device.setScreenHeight(iM1268j0);
            device.setNetwork(C0209d.m1228Z(C0209d.m1225Y(contextM1377a)));
        }
        device.setAndroidApiLevel(Build.VERSION.SDK_INT);
        return device;
    }

    /* renamed from: g */
    public final void m30036g(C11060c c11060c, String str, C9721b c9721b) {
        c11060c.m66665u(String.valueOf(c9721b.m60659c()));
        HashMap map = new HashMap();
        map.put("config_point", str);
        map.put(TrackConstants$Events.EXCEPTION, c9721b.toString());
        C0239x.m1671c().m1672a(map);
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: h */
    public final void m30037h(C11060c c11060c) {
        c11060c.m66665u("0");
        HashMap map = new HashMap();
        C0239x.m1671c().m1672a(map);
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(C0213f.m1377a(), c11060c, map);
        }
    }
}
