package com.huawei.android.remotecontrol.bluetooth.ancillarydevice;

import af.C0188a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.bluetooth.HwFindDevice;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager;
import com.huawei.android.remotecontrol.bluetooth.locate.LocateHistoryDbHelper;
import com.huawei.android.remotecontrol.config.BtwlDevcieInfo;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.comm.request.bean.PairedDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.intent.SafeIntent;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p227dg.C9120m0;
import p520of.C11860j;
import p521og.C11881n;
import p575qe.C12347f;
import p616rk.C12515a;
import p664u0.C13108a;
import p677ue.C13168a;
import p681uj.C13195l;
import p738we.InterfaceC13595b;
import p809yg.C13981a;
import sg.C12797b;
import ve.C13409a;
import ve.C13411c;
import ve.C13429u;
import ve.C13431w;
import ve.C13432x;

/* loaded from: classes4.dex */
public class AncillaryDeviceManager {

    /* renamed from: l */
    public static final AncillaryDeviceManager f19753l = new AncillaryDeviceManager();

    /* renamed from: m */
    public static final ReentrantLock f19754m = new ReentrantLock();

    /* renamed from: i */
    public C13429u f19763i;

    /* renamed from: k */
    public ActiveAncillaryDeviceBroadcastReceiver f19765k;

    /* renamed from: a */
    public boolean f19755a = false;

    /* renamed from: b */
    public Gson f19756b = new Gson();

    /* renamed from: c */
    public Context f19757c = C12347f.m74285n().m74301m();

    /* renamed from: d */
    public C4334b f19758d = new C4334b(3080);

    /* renamed from: e */
    public C4334b f19759e = new C4334b(3081);

    /* renamed from: f */
    public C4334b f19760f = new C4334b(3082);

    /* renamed from: g */
    public volatile List<AncillaryDeviceInfo> f19761g = new ArrayList();

    /* renamed from: h */
    public volatile List<AncillaryDeviceInfo> f19762h = new ArrayList();

    /* renamed from: j */
    public boolean f19764j = false;

    public class ActiveAncillaryDeviceBroadcastReceiver extends BroadcastReceiver {

        /* renamed from: com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager$ActiveAncillaryDeviceBroadcastReceiver$a */
        public class C4332a extends AbstractC9478g {
            public C4332a() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                C11860j.m71087v();
            }
        }

        public ActiveAncillaryDeviceBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!new SafeIntent(intent).getAction().equals("com.huawei.hidisk.phone.finder.ANCILLARY_DEVICE_ACTION") || AncillaryDeviceManager.this.m26085E()) {
                return;
            }
            C12515a.m75110o().m75172d(new C4332a());
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager$b */
    public class C4334b implements Handler.Callback {

        /* renamed from: a */
        public int f19768a;

        /* renamed from: b */
        public int f19769b;

        /* renamed from: c */
        public Optional<InterfaceC13595b> f19770c;

        public /* synthetic */ C4334b(AncillaryDeviceManager ancillaryDeviceManager, int i10, C4333a c4333a) {
            this(i10);
        }

        /* renamed from: h */
        public final LinkedHashMap<String, String> m26125h(String str) throws JSONException {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("deviceActiveInfo");
                String strM71362l = C11881n.m71362l(jSONObject, "perDeviceType");
                linkedHashMap.put("ModelID", C11881n.m71362l(new JSONObject(C11881n.m71362l(jSONObject, "perDeviceTypeInfo")), "ModelID"));
                linkedHashMap.put("perDeviceType", strM71362l);
            } catch (JSONException e10) {
                C13981a.m83988e("AncillaryDeviceManager", "parse json exception:" + e10.getMessage());
            }
            return linkedHashMap;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            m26127j(message);
            return true;
        }

        /* renamed from: i */
        public final void m26126i(Message message) throws JSONException {
            String str;
            C13981a.m83989i("AncillaryDeviceManager", "HttpCallback->handleMessage->handleActiveAncDeviceInfo");
            this.f19769b = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("AncillaryDeviceManager", "Active Ancillary Device info result:" + this.f19769b);
            String string = message.getData().getString("requestInfo");
            LinkedHashMap<String, String> linkedHashMapM26125h = m26125h(string);
            C12797b c12797b = new C12797b();
            if (200 == this.f19769b) {
                final int iM26233d = C4347e.m26233d(message.getData().getString("response_info"));
                C13981a.m83990w("AncillaryDeviceManager", "handleActiveAncDeviceInfo: handleMsg active anc device info resultCode=" + iM26233d);
                try {
                    JSONObject jSONObject = new JSONObject(C11881n.m71362l(new JSONObject(string), "deviceActiveInfo"));
                    final String strM71362l = C11881n.m71362l(jSONObject, "deviceID");
                    if (iM26233d == 0) {
                        if (AncillaryDeviceDBHelper.m26045e(AncillaryDeviceManager.this.f19757c).m26047B(AncillaryDeviceManager.this.f19757c, strM71362l, "1") < 0) {
                            C13981a.m83988e("AncillaryDeviceManager", "setDeviceActiveFlag update DB error");
                        }
                        if (C13168a.m79183l(C11881n.m71362l(jSONObject, "perDeviceType"))) {
                            C13981a.m83989i("AncillaryDeviceManager", "finder tag activate success");
                            c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "0", "handleActiveAncDeviceInfo callback success", null, "01021", null, "active_tag", true, linkedHashMapM26125h);
                            this.f19770c.ifPresent(new Consumer() { // from class: ve.m
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    ((InterfaceC13595b) obj).onTagBindResult(strM71362l, 0);
                                }
                            });
                            return;
                        } else {
                            AncillaryDeviceManager.this.m26096T(C13168a.m79178e(AncillaryDeviceManager.this.m26109x("1", "1")));
                            C13981a.m83989i("AncillaryDeviceManager", "handleActiveAncDeviceInfo,AppEventLogParam report success");
                            c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "0", "handleActiveAncDeviceInfo callback success", null, "01021", null, "active_ancDevice", true, linkedHashMapM26125h);
                            return;
                        }
                    }
                    if (iM26233d == 401) {
                        C13195l.m79272J().m79325o0(message.getData().getString("access_token"));
                        if (AncillaryDeviceManager.this.f19764j) {
                            C13981a.m83988e("AncillaryDeviceManager", "AT fail: retry active anc device fail");
                            this.f19770c.ifPresent(new Consumer() { // from class: ve.n
                                @Override // java.util.function.Consumer
                                public final void accept(Object obj) {
                                    ((InterfaceC13595b) obj).onTagBindResult(strM71362l, 2);
                                }
                            });
                        } else {
                            new C13409a(string, AncillaryDeviceManager.this.f19759e).mo26440c(AncillaryDeviceManager.this.f19757c);
                            AncillaryDeviceManager.this.f19764j = true;
                        }
                        C13981a.m83989i("AncillaryDeviceManager", "handleActiveAncDeviceInfo,AppEventLogParam report fail");
                        c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3004", "handleActiveAncDeviceInfo callback fail,resultCode:" + iM26233d, null, "01021", null, "active_ancDevice", true, linkedHashMapM26125h);
                        return;
                    }
                    if (iM26233d != 3101 && iM26233d != 3104 && iM26233d != 3106 && iM26233d != 3107 && iM26233d != 3108 && iM26233d != 3112) {
                        this.f19770c.ifPresent(new Consumer() { // from class: ve.p
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                ((InterfaceC13595b) obj).onTagBindResult(strM71362l, 2);
                            }
                        });
                        C13981a.m83988e("AncillaryDeviceManager", "handleMsg active anc device info fail,error code:" + iM26233d);
                        c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3004", "handleActiveAncDeviceInfo callback fail,resultCode:" + iM26233d, null, "01021", null, "active_ancDevice", true, linkedHashMapM26125h);
                        return;
                    }
                    C13981a.m83989i("AncillaryDeviceManager", "tag bind fail: " + iM26233d);
                    this.f19770c.ifPresent(new Consumer() { // from class: ve.o
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((InterfaceC13595b) obj).onTagBindResult(strM71362l, iM26233d);
                        }
                    });
                    str = string;
                    try {
                        c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3004", "handleActiveAncDeviceInfo callback fail,resultCode:" + iM26233d, null, "01021", null, "active_ancDevice", true, linkedHashMapM26125h);
                        if (iM26233d == 3112) {
                            C13981a.m83989i("AncillaryDeviceManager", "tag bind fail,not in white list，remove:" + AncillaryDeviceDBHelper.m26045e(AncillaryDeviceManager.this.f19757c).m26050c(strM71362l));
                            return;
                        }
                        return;
                    } catch (JSONException e10) {
                        e = e10;
                        C13981a.m83988e("AncillaryDeviceManager", "update activation anc deviceId json exception:" + e.getMessage());
                        this.f19770c.ifPresent(new Consumer() { // from class: ve.q
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                ((InterfaceC13595b) obj).onTagBindResult(null, 2);
                            }
                        });
                        C13981a.m83988e("AncillaryDeviceManager", "handleMsg active anc device info error=" + this.f19769b);
                        c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3003", "handleActiveAncDeviceInfo callback error,result:" + this.f19769b, null, "01021", null, "active_ancDevice", true, linkedHashMapM26125h);
                        this.f19770c.ifPresent(new Consumer() { // from class: ve.r
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                ((InterfaceC13595b) obj).onTagBindResult(null, 1);
                            }
                        });
                        new C13409a(str, AncillaryDeviceManager.this.f19759e).m26439b(AncillaryDeviceManager.this.f19757c);
                    }
                } catch (JSONException e11) {
                    e = e11;
                    str = string;
                }
            } else {
                str = string;
            }
            C13981a.m83988e("AncillaryDeviceManager", "handleMsg active anc device info error=" + this.f19769b);
            c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3003", "handleActiveAncDeviceInfo callback error,result:" + this.f19769b, null, "01021", null, "active_ancDevice", true, linkedHashMapM26125h);
            this.f19770c.ifPresent(new Consumer() { // from class: ve.r
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((InterfaceC13595b) obj).onTagBindResult(null, 1);
                }
            });
            new C13409a(str, AncillaryDeviceManager.this.f19759e).m26439b(AncillaryDeviceManager.this.f19757c);
        }

        /* renamed from: j */
        public void m26127j(Message message) throws JSONException {
            C13981a.m83989i("AncillaryDeviceManager", "HttpCallback->handleMessage");
            switch (this.f19768a) {
                case 3080:
                    m26128k(message);
                    break;
                case 3081:
                    m26126i(message);
                    break;
                case 3082:
                    m26129l(message);
                    break;
            }
        }

        /* renamed from: k */
        public final void m26128k(Message message) {
            C13981a.m83989i("AncillaryDeviceManager", "HttpCallback->handleMessage->handleQueryAncDeviceInfo");
            this.f19769b = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("AncillaryDeviceManager", "Query Ancillary Device info result:" + this.f19769b);
            C12797b c12797b = new C12797b();
            if (200 != this.f19769b) {
                C13981a.m83988e("AncillaryDeviceManager", "handleMsg query activation info error=" + this.f19769b);
                AncillaryDeviceManager.this.f19763i.m26439b(AncillaryDeviceManager.this.f19757c);
                c12797b.m76784j(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3003", "handleQueryAncDeviceInfo callback error,result:" + this.f19769b, null, "01020", null, "query_ancDeviceInfo", true);
                return;
            }
            String string = message.getData().getString("response_info");
            int iM26233d = C4347e.m26233d(string);
            if (iM26233d == 0) {
                m26130t(string);
                C13981a.m83989i("AncillaryDeviceManager", "handleQueryAncDeviceInfo,AppEventLogParam report success");
                c12797b.m76784j(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "0", "handleQueryAncDeviceInfo callback success", null, "01020", null, "query_ancDeviceInfo", true);
                return;
            }
            AncillaryDeviceManager.this.f19762h.clear();
            C13981a.m83989i("AncillaryDeviceManager", "handleQueryAncDeviceInfo,AppEventLogParam report fail");
            c12797b.m76784j(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3004", "handleQueryAncDeviceInfo callback fail,resultCode:" + iM26233d, null, "01020", null, "query_ancDeviceInfo", true);
            this.f19770c.ifPresent(new Consumer() { // from class: ve.s
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((InterfaceC13595b) obj).onTagBindResult(null, 2);
                }
            });
        }

        /* renamed from: l */
        public final void m26129l(Message message) throws JSONException {
            JSONObject jSONObject;
            C13981a.m83989i("AncillaryDeviceManager", "HttpCallback->handleMessage->handleUpdateDeviceInfo");
            this.f19769b = C0241z.m1685c(message.getData().getString("result"));
            C13981a.m83989i("AncillaryDeviceManager", "Query Update Device info result:" + this.f19769b);
            String string = message.getData().getString("requestInfo");
            LinkedHashMap<String, String> linkedHashMapM26125h = m26125h(string);
            C12797b c12797b = new C12797b();
            if (200 != this.f19769b) {
                C13981a.m83988e("AncillaryDeviceManager", "handleMsg update anc device info error=" + this.f19769b);
                c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3003", "handleUpdateDeviceInfo callback error", null, "01022", null, "update_ancDevice", true, linkedHashMapM26125h);
                new C13432x(string, AncillaryDeviceManager.this.f19760f).m26439b(AncillaryDeviceManager.this.f19757c);
                return;
            }
            int iM26233d = C4347e.m26233d(message.getData().getString("response_info"));
            C13981a.m83989i("AncillaryDeviceManager", "handleMsg Update anc device info resultCode=" + iM26233d);
            if (iM26233d != 0) {
                C13981a.m83988e("AncillaryDeviceManager", "handleMsg update anc device info fail");
                c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3004", "handleUpdateDeviceInfo callback fail", null, "01022", null, "update_ancDevice", true, linkedHashMapM26125h);
                return;
            }
            try {
                jSONObject = new JSONObject(C11881n.m71362l(new JSONObject(string), "deviceActiveInfo"));
                AncillaryDeviceDBHelper.m26045e(AncillaryDeviceManager.this.f19757c).m26048D(AncillaryDeviceManager.this.f19757c, C11881n.m71362l(jSONObject, "deviceID"), "1", null, null);
            } catch (JSONException e10) {
                C13981a.m83988e("AncillaryDeviceManager", "handleMsg update anc device info exception:" + e10.getMessage());
            }
            if (C13168a.m79183l(C11881n.m71362l(jSONObject, "perDeviceType"))) {
                c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "0", "handleUpdateDeviceInfo callback success", null, "01022", null, "update_tag", true, linkedHashMapM26125h);
                return;
            }
            AncillaryDeviceManager.this.m26096T(C13168a.m79178e(AncillaryDeviceManager.this.m26109x("1", "1")));
            C13981a.m83989i("AncillaryDeviceManager", "handleUpdateDeviceInfo,AppEventLogParam report success");
            c12797b.m76785k(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "0", "handleUpdateDeviceInfo callback success", null, "01022", null, "update_ancDevice", true, linkedHashMapM26125h);
        }

        /* renamed from: t */
        public final void m26130t(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C13981a.m83987d("AncillaryDeviceManager", "handleQueryAncDeviceSuccess--responseInfo=" + str);
                if (!jSONObject.has("perDeviceList")) {
                    C13981a.m83988e("AncillaryDeviceManager", "json has no params");
                    return;
                }
                JSONArray jSONArray = (JSONArray) jSONObject.get("perDeviceList");
                C13981a.m83987d("AncillaryDeviceManager", "handleQueryAncDeviceSuccess--jsonArray=" + jSONArray);
                if (jSONArray == null || jSONArray.length() == 0) {
                    AncillaryDeviceManager.this.f19761g = new ArrayList();
                } else {
                    AncillaryDeviceManager.this.f19761g = m26131u(jSONArray);
                }
                AncillaryDeviceManager.this.m26099W();
            } catch (JSONException unused) {
                C13981a.m83988e("AncillaryDeviceManager", "handle QueryAncDevice JSONException");
            }
        }

        /* renamed from: u */
        public final List<AncillaryDeviceInfo> m26131u(JSONArray jSONArray) throws JSONException {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    ancillaryDeviceInfo.setPerDeviceType(C11881n.m71362l(jSONObject, "perDeviceType"));
                    ancillaryDeviceInfo.setDeviceID(C11881n.m71362l(jSONObject, "deviceID"));
                    ancillaryDeviceInfo.setDeviceName(C11881n.m71362l(jSONObject, "deviceName"));
                    JSONArray jSONArray2 = new JSONArray();
                    if (jSONObject.has("capability")) {
                        jSONArray2 = jSONObject.getJSONArray("capability");
                    }
                    ancillaryDeviceInfo.setFindCapability(jSONArray2);
                    JSONObject jSONObject2 = jSONObject.has("perDeviceTypeInfo") ? new JSONObject(jSONObject.getString("perDeviceTypeInfo")) : null;
                    if (jSONObject2 != null) {
                        ancillaryDeviceInfo.setDeviceType(C11881n.m71362l(jSONObject2, "DeviceType"));
                        ancillaryDeviceInfo.setModelId(C11881n.m71362l(jSONObject2, "ModelID"));
                        ancillaryDeviceInfo.setSubModelId(C11881n.m71362l(jSONObject2, "SubmodelID"));
                        ancillaryDeviceInfo.setSubDeviceType(C11881n.m71362l(jSONObject2, "SubDeviceType"));
                    }
                    JSONObject jSONObject3 = jSONObject.has("extInfo") ? new JSONObject(jSONObject.getString("extInfo")) : null;
                    if (jSONObject3 != null) {
                        ancillaryDeviceInfo.setConnectivity(C11881n.m71362l(jSONObject3, "Connectivity"));
                        ancillaryDeviceInfo.setIrk(C11881n.m71362l(jSONObject3, "IRK"));
                        ancillaryDeviceInfo.setDeviceBtMac(C11881n.m71362l(jSONObject3, "DeviceBtMac"));
                        ancillaryDeviceInfo.setHbkp(C11881n.m71362l(jSONObject3, "HBPK"));
                    }
                    if (jSONObject.has("componentType")) {
                        ancillaryDeviceInfo.setComponentType(jSONObject.getInt("componentType"));
                    }
                    if (jSONObject.has(VastAttribute.SEQUENCE)) {
                        ancillaryDeviceInfo.setSequence(jSONObject.getInt(VastAttribute.SEQUENCE));
                    }
                    if (jSONObject.has("deviceSn")) {
                        ancillaryDeviceInfo.setDeviceSn(jSONObject.getString("deviceSn"));
                    }
                    if (jSONObject.has("deviceList")) {
                        ancillaryDeviceInfo.setDeviceList(new JSONArray(jSONObject.getString("deviceList")));
                    }
                    if (jSONObject.has("parentSn")) {
                        ancillaryDeviceInfo.setParentSn(jSONObject.getString("parentSn"));
                    }
                    arrayList.add(ancillaryDeviceInfo);
                } catch (JSONException unused) {
                    C13981a.m83988e("AncillaryDeviceManager", "handle MSG_QUERY_DEVICE_ACTIVE JSONException");
                }
            }
            return arrayList;
        }

        /* renamed from: v */
        public void m26132v(Optional<InterfaceC13595b> optional) {
            this.f19770c = optional;
        }

        public C4334b(int i10) {
            this.f19768a = i10;
            this.f19770c = Optional.empty();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceManager$c */
    public class C4335c implements Handler.Callback {

        /* renamed from: a */
        public int f19772a;

        /* renamed from: b */
        public Consumer<JSONArray> f19773b;

        public C4335c(Consumer<JSONArray> consumer) {
            this.f19773b = consumer;
        }

        /* renamed from: a */
        public final void m26133a(Message message) throws JSONException {
            C13981a.m83987d("AncillaryDeviceManager", "HttpCallback->handleMessage->handleQueryAncDeviceInfo");
            this.f19772a = C0241z.m1685c(message.getData().getString("result"));
            C12797b c12797b = new C12797b();
            if (200 == this.f19772a) {
                String string = message.getData().getString("response_info");
                if (C4347e.m26233d(string) != 0) {
                    C13981a.m83989i("AncillaryDeviceManager", "handleQueryAncDeviceInfo,AppEventLogParam report fail");
                    return;
                }
                m26134b(string);
                C13981a.m83989i("AncillaryDeviceManager", "handleQueryAncDeviceInfo,AppEventLogParam report success");
                c12797b.m76784j(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "0", "handleQueryAncDeviceInfo callback success", null, "01020", null, "query_ancDeviceInfo", true);
                return;
            }
            C13981a.m83988e("AncillaryDeviceManager", "handleMsg query activation info error=" + this.f19772a);
            AncillaryDeviceManager.this.f19763i.m26439b(AncillaryDeviceManager.this.f19757c);
            c12797b.m76784j(AncillaryDeviceManager.this.f19757c, "AncillaryDeviceManager", "001_3003", "handleQueryAncDeviceInfo callback error,result:" + this.f19772a, null, "01020", null, "query_ancDeviceInfo", true);
        }

        /* renamed from: b */
        public final void m26134b(String str) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C13981a.m83987d("AncillaryDeviceManager", "handleQueryAncDeviceSuccess--responseInfo=" + str);
                if (jSONObject.has("perDeviceList")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("perDeviceList");
                    C13981a.m83987d("AncillaryDeviceManager", "handleQueryAncDeviceSuccess--jsonArray=" + jSONArray);
                    this.f19773b.accept(jSONArray);
                }
            } catch (JSONException unused) {
                C13981a.m83988e("AncillaryDeviceManager", "handle QueryAncDevice JSONException");
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            m26133a(message);
            return true;
        }
    }

    /* renamed from: G */
    public static /* synthetic */ void m26060G(AncillaryDeviceInfo ancillaryDeviceInfo, InterfaceC13595b interfaceC13595b) {
        interfaceC13595b.onTagBindResult(ancillaryDeviceInfo.getDeviceID(), 2);
    }

    /* renamed from: K */
    public static /* synthetic */ void m26061K(Exception exc) {
        C13981a.m83989i("AncillaryDeviceManager", "query paired devices fail. " + exc.getMessage());
    }

    /* renamed from: L */
    public static /* synthetic */ void m26062L(AncillaryDeviceInfo ancillaryDeviceInfo, InterfaceC13595b interfaceC13595b) {
        interfaceC13595b.onTagBindResult(ancillaryDeviceInfo.getDeviceID(), 2);
    }

    /* renamed from: M */
    public static /* synthetic */ void m26063M(AncillaryDeviceInfo ancillaryDeviceInfo, InterfaceC13595b interfaceC13595b) {
        interfaceC13595b.onTagBindResult(ancillaryDeviceInfo.getDeviceID(), 0);
    }

    /* renamed from: y */
    public static AncillaryDeviceManager m26080y() {
        return f19753l;
    }

    /* renamed from: A */
    public void m26081A() {
        List<AncillaryDeviceInfo> listM26109x = m26109x("0", "3");
        C13981a.m83989i("AncillaryDeviceManager", "initBindGoodsList, deviceList size: " + listM26109x.size());
        for (int i10 = 0; i10 < listM26109x.size(); i10++) {
            JSONArray deviceList = listM26109x.get(i10).getDeviceList();
            if (deviceList != null) {
                C13981a.m83989i("AncillaryDeviceManager", "initBindGoodsList, deviceList not null");
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < deviceList.length(); i11++) {
                    try {
                        jSONArray.put(new JSONObject(deviceList.getString(i11).replaceAll("nameValuePairs=\\{", "\"").replaceAll("\\}\\}", "\\\"}").replaceAll("=", "\":\"").replaceAll(", ", "\",\"")));
                    } catch (JSONException unused) {
                        C13981a.m83988e("AncillaryDeviceManager", "initBindGoodsList JSONException");
                        return;
                    }
                }
                listM26109x.get(i10).setDeviceList(jSONArray);
            }
            new C13411c(this.f19757c, listM26109x.get(i10), this.f19759e).m80713e();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("deviceId", listM26109x.get(i10).getDeviceID());
                jSONObject.put("productId", listM26109x.get(i10).getModelId());
                jSONObject.put("componentType", listM26109x.get(i10).getComponentType());
                jSONObject.put("deviceList", C9120m0.m57353S(listM26109x.get(i10).getDeviceList().toString()));
                C9120m0.m57389g1(this.f19757c, "mecloud_findmyphone_portal_active_device", "", jSONObject, 0);
            } catch (JSONException unused2) {
                C13981a.m83988e("AncillaryDeviceManager", "initBindGoodsList JSONException");
            }
        }
    }

    /* renamed from: B */
    public void m26082B() {
        try {
            FindNetwork.getFindNetworkEngine(this.f19757c).queryPairedDevices().addOnSuccessListener(new InterfaceC8939g() { // from class: ve.e
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f60506a.m26089J((FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: ve.f
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    AncillaryDeviceManager.m26061K(exc);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("AncillaryDeviceManager", "initBindTagList :" + e10.getMessage());
        }
    }

    /* renamed from: C */
    public final boolean m26083C(AncillaryDeviceInfo ancillaryDeviceInfo) {
        return m26084D(ancillaryDeviceInfo, true);
    }

    /* renamed from: D */
    public final boolean m26084D(AncillaryDeviceInfo ancillaryDeviceInfo, boolean z10) {
        if (AncillaryDeviceDBHelper.m26045e(this.f19757c).m26057x(ancillaryDeviceInfo.getDeviceID())) {
            return true;
        }
        if (AncillaryDeviceDBHelper.m26045e(this.f19757c).m26055v(this.f19757c, ancillaryDeviceInfo.getDeviceID(), ancillaryDeviceInfo.getPerDeviceType(), z10 ? "0" : "1", this.f19756b.toJson(ancillaryDeviceInfo), ancillaryDeviceInfo.getSubDeviceType()) >= 0) {
            return true;
        }
        C13981a.m83988e("AncillaryDeviceManager", "activeAncDevice update DB error");
        return false;
    }

    /* renamed from: E */
    public boolean m26085E() {
        return this.f19755a;
    }

    /* renamed from: F */
    public final boolean m26086F(AncillaryDeviceInfo ancillaryDeviceInfo) {
        if (ancillaryDeviceInfo == null) {
            return false;
        }
        C13981a.m83989i("AncillaryDeviceManager", "new device modelId: " + ancillaryDeviceInfo.getModelId());
        List<BtwlDevcieInfo> btwl = ParamConfig.getInstance().getBtwl();
        if (btwl == null || btwl.isEmpty()) {
            btwl = C0188a.m1070g(this.f19757c);
        }
        C13981a.m83989i("AncillaryDeviceManager", "white list:" + btwl.size());
        for (BtwlDevcieInfo btwlDevcieInfo : btwl) {
            String btwlDeviceType = btwlDevcieInfo.getBtwlDeviceType();
            String btwlModelID = btwlDevcieInfo.getBtwlModelID();
            if (btwlDeviceType.equals(ancillaryDeviceInfo.getDeviceType()) && btwlModelID.equals(ancillaryDeviceInfo.getModelId())) {
                return true;
            }
        }
        C13981a.m83988e("AncillaryDeviceManager", "bluetooth device is not in white list");
        return false;
    }

    /* renamed from: H */
    public final /* synthetic */ void m26087H(AncillaryDeviceInfo ancillaryDeviceInfo) {
        new C13411c(this.f19757c, ancillaryDeviceInfo, this.f19759e).m80713e();
    }

    /* renamed from: I */
    public final /* synthetic */ void m26088I(HashMap map, JSONArray jSONArray) throws JSONException {
        try {
            if (jSONArray.length() != 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    String strOptString = jSONObject.optString("deviceID");
                    String strOptString2 = jSONObject.optString("deviceName");
                    String strOptString3 = jSONObject.optString("goodsType");
                    String strOptString4 = jSONObject.optString("ModelID");
                    String strOptString5 = jSONObject.optString("SubmodelID");
                    AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
                    ancillaryDeviceInfo.setDeviceID(strOptString);
                    ancillaryDeviceInfo.setDeviceName(strOptString2);
                    ancillaryDeviceInfo.setGoodsType(strOptString3);
                    ancillaryDeviceInfo.setDeviceType("3");
                    ancillaryDeviceInfo.setSubDeviceType("1");
                    ancillaryDeviceInfo.setModelId(strOptString4);
                    ancillaryDeviceInfo.setSubModelId(strOptString5);
                    m26101Y(ancillaryDeviceInfo, false);
                    map.remove(strOptString);
                }
            }
            map.values().forEach(new Consumer() { // from class: ve.j
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f60511a.m26087H((AncillaryDeviceInfo) obj);
                }
            });
        } catch (JSONException e10) {
            C13981a.m83988e("AncillaryDeviceManager", "queryAncillaryDevice error: " + e10.getMessage());
        }
    }

    /* renamed from: J */
    public final /* synthetic */ void m26089J(FindNetworkResult findNetworkResult) {
        C13981a.m83989i("AncillaryDeviceManager", "query paired devices success.");
        if (findNetworkResult != null) {
            List<PairedDeviceInfo> list = (List) findNetworkResult.getData();
            if (list == null) {
                C13981a.m83989i("AncillaryDeviceManager", "initBindTagList data get empty");
                return;
            }
            if (!C0209d.m1333z1(this.f19757c)) {
                C13981a.m83988e("AncillaryDeviceManager", "initBindTagList no network");
                new C12797b().m76784j(this.f19757c, "AncillaryDeviceManager", "0", "initBindTagList no network", null, "01021", null, "query_ancDeviceInfo", true);
                return;
            }
            final HashMap map = new HashMap();
            for (PairedDeviceInfo pairedDeviceInfo : list) {
                AncillaryDeviceInfo ancillaryDeviceInfo = new AncillaryDeviceInfo();
                ancillaryDeviceInfo.setDeviceID(pairedDeviceInfo.getSn());
                ancillaryDeviceInfo.setDeviceName(pairedDeviceInfo.getDeviceName());
                ancillaryDeviceInfo.setGoodsType(pairedDeviceInfo.getGoodsType());
                ancillaryDeviceInfo.setPerDeviceType("3");
                ancillaryDeviceInfo.setSubDeviceType("1");
                ancillaryDeviceInfo.setModelId(pairedDeviceInfo.getProductId());
                ancillaryDeviceInfo.setSubModelId(pairedDeviceInfo.getSubProductId());
                ancillaryDeviceInfo.setComponentType(pairedDeviceInfo.getComponentType());
                ancillaryDeviceInfo.setSequence(pairedDeviceInfo.getSequence());
                ancillaryDeviceInfo.setDeviceSn(pairedDeviceInfo.getDeviceSn());
                map.put(ancillaryDeviceInfo.getDeviceID(), ancillaryDeviceInfo);
                m26084D(ancillaryDeviceInfo, false);
            }
            this.f19763i = new C13429u(this.f19757c, "3", new C4335c(new Consumer() { // from class: ve.g
                @Override // java.util.function.Consumer
                public final void accept(Object obj) throws JSONException {
                    this.f60507a.m26088I(map, (JSONArray) obj);
                }
            }));
            if (C0209d.m1333z1(this.f19757c)) {
                this.f19763i.m80720g();
            } else {
                this.f19763i.m26439b(this.f19757c);
            }
        }
    }

    /* renamed from: N */
    public final void m26090N(final AncillaryDeviceInfo ancillaryDeviceInfo) {
        if (AncillaryDeviceDBHelper.m26045e(this.f19757c).m26057x(ancillaryDeviceInfo.getDeviceID())) {
            AncillaryDeviceDBHelper.m26045e(this.f19757c).m26047B(this.f19757c, ancillaryDeviceInfo.getDeviceID(), "1");
        } else if (AncillaryDeviceDBHelper.m26045e(this.f19757c).m26055v(this.f19757c, ancillaryDeviceInfo.getDeviceID(), ancillaryDeviceInfo.getPerDeviceType(), "1", this.f19756b.toJson(ancillaryDeviceInfo), ancillaryDeviceInfo.getSubDeviceType()) < 0) {
            C13981a.m83988e("AncillaryDeviceManager", "activeAncDevice insert DB error");
            ancillaryDeviceInfo.getCallback().ifPresent(new Consumer() { // from class: ve.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AncillaryDeviceManager.m26062L(ancillaryDeviceInfo, (InterfaceC13595b) obj);
                }
            });
            return;
        }
        ancillaryDeviceInfo.getCallback().ifPresent(new Consumer() { // from class: ve.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AncillaryDeviceManager.m26063M(ancillaryDeviceInfo, (InterfaceC13595b) obj);
            }
        });
        m26103r(ancillaryDeviceInfo);
    }

    /* renamed from: O */
    public final void m26091O(AncillaryDeviceInfo ancillaryDeviceInfo) {
        C13981a.m83989i("AncillaryDeviceManager", "ancillary device is already active, not need active again");
        if (AncillaryDeviceDBHelper.m26045e(this.f19757c).m26057x(ancillaryDeviceInfo.getDeviceID())) {
            AncillaryDeviceDBHelper.m26045e(this.f19757c).m26047B(this.f19757c, ancillaryDeviceInfo.getDeviceID(), "1");
        } else if (AncillaryDeviceDBHelper.m26045e(this.f19757c).m26055v(this.f19757c, ancillaryDeviceInfo.getDeviceID(), ancillaryDeviceInfo.getPerDeviceType(), "1", this.f19756b.toJson(ancillaryDeviceInfo), ancillaryDeviceInfo.getSubDeviceType()) < 0) {
            C13981a.m83988e("AncillaryDeviceManager", "activeAncDevice insert DB error");
            return;
        } else {
            C13981a.m83989i("AncillaryDeviceManager", "ancillary device is already active, insert DB");
            m26096T(C13168a.m79178e(m26109x("1", "1")));
        }
        m26103r(ancillaryDeviceInfo);
    }

    /* renamed from: P */
    public void m26092P() {
        if (this.f19765k == null) {
            this.f19765k = new ActiveAncillaryDeviceBroadcastReceiver();
            C13108a.m78878b(C12347f.m74285n().m74301m()).m78880c(this.f19765k, new IntentFilter("com.huawei.hidisk.phone.finder.ANCILLARY_DEVICE_ACTION"));
            C13981a.m83989i("AncillaryDeviceManager", "activeAncillaryDeviceBroadcastReceiver registerActionReceiver");
        }
    }

    /* renamed from: Q */
    public final void m26093Q() {
        List<AncillaryDeviceInfo> listM26109x = m26109x("0", "0");
        if (listM26109x.isEmpty()) {
            return;
        }
        C13981a.m83989i("AncillaryDeviceManager", "device is not active in DB, try active again");
        Iterator<AncillaryDeviceInfo> it = listM26109x.iterator();
        while (it.hasNext()) {
            new C13411c(this.f19757c, it.next(), this.f19759e).m80713e();
        }
    }

    /* renamed from: R */
    public void m26094R() {
        m26093Q();
        m26095S();
    }

    /* renamed from: S */
    public final void m26095S() {
        List<AncillaryDeviceInfo> listM26110z = m26110z("0");
        if (listM26110z.isEmpty()) {
            return;
        }
        C13981a.m83989i("AncillaryDeviceManager", "device is not update in DB, try report again");
        Iterator<AncillaryDeviceInfo> it = listM26110z.iterator();
        while (it.hasNext()) {
            new C13431w(this.f19757c, it.next(), this.f19760f).m80727e();
        }
    }

    /* renamed from: T */
    public void m26096T(ArrayList<HwFindDevice> arrayList) {
        if (arrayList == null) {
            C13981a.m83988e("AncillaryDeviceManager", "send find device list is null");
            return;
        }
        C13981a.m83989i("AncillaryDeviceManager", "send find device list:" + arrayList.size());
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("findDeviceList", arrayList);
        new C13168a("sendFindDevList", bundle).m79190g();
    }

    /* renamed from: U */
    public void m26097U(boolean z10) {
        this.f19755a = z10;
    }

    /* renamed from: V */
    public void m26098V() {
        if (this.f19765k != null) {
            C13108a.m78878b(C12347f.m74285n().m74301m()).m78883f(this.f19765k);
            C13981a.m83989i("AncillaryDeviceManager", "activeAncillaryDeviceBroadcastReceiver unregisterActionReceiver");
        }
    }

    /* renamed from: W */
    public final void m26099W() {
        ReentrantLock reentrantLock = f19754m;
        reentrantLock.lock();
        try {
            if (this.f19762h != null && !this.f19762h.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<AncillaryDeviceInfo> it = this.f19761g.iterator();
                while (it.hasNext()) {
                    int iIndexOf = this.f19762h.indexOf(it.next());
                    if (iIndexOf >= 0) {
                        arrayList.add(this.f19762h.get(iIndexOf));
                        this.f19762h.remove(iIndexOf);
                    }
                }
                this.f19762h.forEach(new Consumer() { // from class: ve.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f60509a.m26102q((AncillaryDeviceInfo) obj);
                    }
                });
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    AncillaryDeviceInfo ancillaryDeviceInfo = (AncillaryDeviceInfo) it2.next();
                    if (C13168a.m79183l(ancillaryDeviceInfo.getPerDeviceType())) {
                        m26090N(ancillaryDeviceInfo);
                    } else {
                        m26091O(ancillaryDeviceInfo);
                    }
                }
                this.f19762h.clear();
                f19754m.unlock();
                return;
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            f19754m.unlock();
            throw th2;
        }
    }

    /* renamed from: X */
    public void m26100X(AncillaryDeviceInfo ancillaryDeviceInfo) {
        m26101Y(ancillaryDeviceInfo, true);
    }

    /* renamed from: Y */
    public void m26101Y(AncillaryDeviceInfo ancillaryDeviceInfo, boolean z10) {
        if (ancillaryDeviceInfo == null || TextUtils.isEmpty(ancillaryDeviceInfo.getDeviceName())) {
            C13981a.m83989i("AncillaryDeviceManager", "updateDeviceInfo deviceName is null");
        } else {
            AncillaryDeviceDBHelper.m26045e(this.f19757c).m26048D(this.f19757c, ancillaryDeviceInfo.getDeviceID(), z10 ? "0" : "1", this.f19756b.toJson(ancillaryDeviceInfo), ancillaryDeviceInfo.getSubDeviceType());
            new C13431w(this.f19757c, ancillaryDeviceInfo, this.f19760f).m80727e();
        }
    }

    /* renamed from: q */
    public void m26102q(AncillaryDeviceInfo ancillaryDeviceInfo) {
        if (C13168a.m79183l(ancillaryDeviceInfo.getPerDeviceType())) {
            this.f19759e.m26132v(ancillaryDeviceInfo.getCallback());
        }
        new C13411c(this.f19757c, ancillaryDeviceInfo, this.f19759e).m80713e();
    }

    /* renamed from: r */
    public final void m26103r(AncillaryDeviceInfo ancillaryDeviceInfo) {
        if (ancillaryDeviceInfo == null) {
            C13981a.m83990w("AncillaryDeviceManager", "checkDeviceInfo, deviceInfo is empty");
            return;
        }
        String deviceID = ancillaryDeviceInfo.getDeviceID();
        String deviceName = ancillaryDeviceInfo.getDeviceName();
        if (deviceID == null || deviceName == null) {
            C13981a.m83990w("AncillaryDeviceManager", "checkDeviceInfo, deviceId or name is empty");
            return;
        }
        if (this.f19761g.isEmpty()) {
            C13981a.m83990w("AncillaryDeviceManager", "checkDeviceInfo, anc device list is empty");
            return;
        }
        for (AncillaryDeviceInfo ancillaryDeviceInfo2 : this.f19761g) {
            if (deviceID.equals(ancillaryDeviceInfo2.getDeviceID()) && (!deviceName.equals(ancillaryDeviceInfo2.getDeviceName()) || C13168a.m79183l(ancillaryDeviceInfo.getPerDeviceType()))) {
                m26100X(ancillaryDeviceInfo);
            }
        }
    }

    /* renamed from: s */
    public final void m26104s() {
        C13981a.m83989i("AncillaryDeviceManager", "checkNetWorkState");
        if (C0209d.m1333z1(this.f19757c)) {
            C13429u c13429u = new C13429u(this.f19757c, null, this.f19758d);
            this.f19763i = c13429u;
            c13429u.m80720g();
            return;
        }
        C13981a.m83989i("AncillaryDeviceManager", "NetWork is disconnected, query device in DB");
        f19754m.lock();
        try {
            for (AncillaryDeviceInfo ancillaryDeviceInfo : this.f19762h) {
                if (AncillaryDeviceDBHelper.m26045e(this.f19757c).m26057x(ancillaryDeviceInfo.getDeviceID())) {
                    C13981a.m83988e("AncillaryDeviceManager", "device is already exist in DB");
                } else {
                    m26102q(ancillaryDeviceInfo);
                }
            }
            this.f19762h.clear();
            f19754m.unlock();
        } catch (Throwable th2) {
            f19754m.unlock();
            throw th2;
        }
    }

    /* renamed from: t */
    public void m26105t(Context context) {
        LocateHistoryDbHelper.m26135e(context).m26137b(context);
        AncillaryDeviceDBHelper.m26045e(context).m26049b(context);
        m26096T(new ArrayList<>());
        C13981a.m83989i("AncillaryDeviceManager", "clear Ancillary DB");
    }

    /* renamed from: u */
    public void m26106u(AncillaryDeviceInfo ancillaryDeviceInfo) {
        if (!m26086F(ancillaryDeviceInfo)) {
            C13981a.m83988e("AncillaryDeviceManager", "new bluetooth device is not in white list");
            return;
        }
        ReentrantLock reentrantLock = f19754m;
        reentrantLock.lock();
        try {
            if (this.f19762h == null) {
                this.f19762h = new ArrayList();
            }
            this.f19762h.add(ancillaryDeviceInfo);
            reentrantLock.unlock();
            if (m26083C(ancillaryDeviceInfo)) {
                m26104s();
            }
        } catch (Throwable th2) {
            f19754m.unlock();
            throw th2;
        }
    }

    /* renamed from: v */
    public void m26107v(List<AncillaryDeviceInfo> list) {
        C13981a.m83989i("AncillaryDeviceManager", "createBindDeviceList");
        if (list == null || list.isEmpty()) {
            C13981a.m83988e("AncillaryDeviceManager", "device list is from ALS or HEALTH empty");
            return;
        }
        f19754m.lock();
        try {
            for (AncillaryDeviceInfo ancillaryDeviceInfo : list) {
                if (m26086F(ancillaryDeviceInfo)) {
                    this.f19762h.add(ancillaryDeviceInfo);
                    if (!m26083C(ancillaryDeviceInfo)) {
                        return;
                    }
                }
            }
            if (this.f19762h != null && !this.f19762h.isEmpty()) {
                m26097U(true);
                m26098V();
                f19754m.unlock();
                m26104s();
                return;
            }
            C13981a.m83988e("AncillaryDeviceManager", "device list in white list is empty");
            m26097U(false);
        } finally {
            f19754m.unlock();
        }
    }

    /* renamed from: w */
    public void m26108w(final AncillaryDeviceInfo ancillaryDeviceInfo) {
        C13981a.m83989i("AncillaryDeviceManager", "createBindTagList");
        if (C13168a.m79183l(ancillaryDeviceInfo.getPerDeviceType())) {
            ReentrantLock reentrantLock = f19754m;
            reentrantLock.lock();
            try {
                if (this.f19762h == null) {
                    this.f19762h = new ArrayList();
                }
                this.f19762h.add(ancillaryDeviceInfo);
                reentrantLock.unlock();
                if (!m26083C(ancillaryDeviceInfo)) {
                    ancillaryDeviceInfo.getCallback().ifPresent(new Consumer() { // from class: ve.i
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            AncillaryDeviceManager.m26060G(ancillaryDeviceInfo, (InterfaceC13595b) obj);
                        }
                    });
                } else {
                    if (!C0209d.m1333z1(this.f19757c)) {
                        m26102q(ancillaryDeviceInfo);
                        return;
                    }
                    this.f19763i = new C13429u(this.f19757c, ancillaryDeviceInfo.getPerDeviceType(), this.f19758d);
                    this.f19758d.m26132v(ancillaryDeviceInfo.getCallback());
                    this.f19763i.m80720g();
                }
            } catch (Throwable th2) {
                f19754m.unlock();
                throw th2;
            }
        }
    }

    /* renamed from: x */
    public List<AncillaryDeviceInfo> m26109x(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> it = AncillaryDeviceDBHelper.m26045e(this.f19757c).m26056w(this.f19757c, str, str2).iterator();
            while (it.hasNext()) {
                arrayList.add((AncillaryDeviceInfo) this.f19756b.fromJson(it.next(), AncillaryDeviceInfo.class));
            }
        } catch (JsonSyntaxException e10) {
            C13981a.m83988e("AncillaryDeviceManager", "getActiveDeviceListFromDB, e:" + e10.getMessage());
        }
        return arrayList;
    }

    /* renamed from: z */
    public List<AncillaryDeviceInfo> m26110z(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> it = AncillaryDeviceDBHelper.m26045e(this.f19757c).m26046A(this.f19757c, str).iterator();
            while (it.hasNext()) {
                arrayList.add((AncillaryDeviceInfo) this.f19756b.fromJson(it.next(), AncillaryDeviceInfo.class));
            }
        } catch (JsonSyntaxException e10) {
            C13981a.m83988e("AncillaryDeviceManager", "getUpdateDeviceListFromDB, exception:" + e10.getMessage());
        }
        return arrayList;
    }
}
