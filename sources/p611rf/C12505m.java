package p611rf;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.http.C4347e;
import eg.AbstractC9478g;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p520of.C11860j;
import p575qe.C12347f;
import p576qf.InterfaceC12348a;
import p616rk.C12515a;
import p709vj.C13452e;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12797b;

/* renamed from: rf.m */
/* loaded from: classes4.dex */
public class C12505m {

    /* renamed from: a */
    public int f57606a;

    /* renamed from: b */
    public String f57607b;

    /* renamed from: c */
    public Handler.Callback f57608c;

    /* renamed from: rf.m$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f57609a;

        public a(Context context) {
            this.f57609a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("UpdateDeviceTicket", "send request");
            String strM75085g = C12505m.m75085g();
            C12505m c12505m = C12505m.this;
            b bVar = c12505m.new b(this.f57609a, c12505m.f57606a);
            RequestModeConfig.getInstance().setMode(3083, false);
            C4346d.m26226e(3083, strM75085g, bVar, this.f57609a, C12505m.this.f57607b);
        }
    }

    /* renamed from: rf.m$b */
    public class b implements Handler.Callback {

        /* renamed from: a */
        public final Context f57611a;

        /* renamed from: b */
        public final int f57612b;

        public b(Context context, int i10) {
            this.f57611a = context;
            this.f57612b = i10;
        }

        /* renamed from: c */
        public final /* synthetic */ void m75091c(boolean z10) {
            m75094f(z10);
            if (z10) {
                return;
            }
            C13981a.m83989i("UpdateDeviceTicket", "repeat update DT");
            AbstractC12139d.m72772k(this.f57611a, new InterfaceC12348a() { // from class: rf.o
                @Override // p576qf.InterfaceC12348a
                public final void onResult(boolean z11) {
                    this.f57615a.m75094f(z11);
                }
            });
        }

        /* renamed from: d */
        public final void m75092d(String str) {
            int iM26233d = C4347e.m26233d(str);
            C13981a.m83989i("UpdateDeviceTicket", "onUpdateResult resultCode:" + iM26233d);
            if (iM26233d == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has("deviceTicket")) {
                        C13981a.m83989i("UpdateDeviceTicket", "deviceTicket is null");
                        return;
                    }
                    String str2 = (String) jSONObject.get("deviceTicket");
                    if (TextUtils.isEmpty(str2)) {
                        C13981a.m83989i("UpdateDeviceTicket", "deviceTicket is empty");
                        return;
                    }
                    if (str2.equals(AbstractC12139d.m72766e(this.f57611a).getDeviceTicket())) {
                        C13981a.m83989i("UpdateDeviceTicket", "deviceTicket equal, return");
                    } else {
                        if (C12505m.m75086i(this.f57611a)) {
                            C13981a.m83989i("UpdateDeviceTicket", "no need to update DT");
                            return;
                        }
                        AbstractC12139d.m72766e(this.f57611a).setDeviceTicket(str2);
                        C11860j.m71000I0(AbstractC12139d.m72766e(this.f57611a).getDeviceID(), "update device ticket");
                        AbstractC12139d.m72772k(this.f57611a, new InterfaceC12348a() { // from class: rf.n
                            @Override // p576qf.InterfaceC12348a
                            public final void onResult(boolean z10) {
                                this.f57614a.m75091c(z10);
                            }
                        });
                    }
                } catch (Exception e10) {
                    C13981a.m83988e("UpdateDeviceTicket", "onUpdateResult exception: " + e10.getMessage());
                }
            }
        }

        /* renamed from: e */
        public final void m75093e(String str) {
            int iM26233d = C4347e.m26233d(str);
            C13981a.m83989i("UpdateDeviceTicket", "onUpdateResultForActive resultCode:" + iM26233d);
            if (iM26233d == 0) {
                try {
                    if (C12505m.m75086i(this.f57611a)) {
                        C13981a.m83989i("UpdateDeviceTicket", "no need to update DT");
                        C12505m.this.m75088h("");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has("deviceTicket")) {
                        C13981a.m83989i("UpdateDeviceTicket", "deviceTicket is null");
                        C12505m.this.m75088h("");
                        return;
                    }
                    String str2 = (String) jSONObject.get("deviceTicket");
                    if (TextUtils.isEmpty(str2)) {
                        C13981a.m83989i("UpdateDeviceTicket", "deviceTicket is empty");
                        C12505m.this.m75088h(AbstractC12139d.m72766e(this.f57611a).getDeviceTicket());
                    } else {
                        String deviceTicket = AbstractC12139d.m72766e(this.f57611a).getDeviceTicket();
                        if (!str2.equals(deviceTicket)) {
                            C12505m.this.m75088h(str2);
                        } else {
                            C13981a.m83989i("UpdateDeviceTicket", "deviceTicket equal, return");
                            C12505m.this.m75088h(deviceTicket);
                        }
                    }
                } catch (Exception e10) {
                    C13981a.m83988e("UpdateDeviceTicket", "onUpdateResult exception: " + e10.getMessage());
                }
            }
        }

        /* renamed from: f */
        public final void m75094f(boolean z10) {
            new C12797b().m76782h(this.f57611a, "UpdateDeviceTicket", "001_3010", 0, z10 ? "update device ticket write ta success" : "update device ticket write ta error", null, "01051", null, "update dt", true);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            C13981a.m83989i("UpdateDeviceTicket", "handle response");
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            if (iM1685c == 200) {
                String string = message.getData().getString("response_info");
                if (this.f57612b == 0) {
                    m75092d(string);
                    return false;
                }
                m75093e(string);
                return false;
            }
            C13981a.m83988e("UpdateDeviceTicket", "handleResponse:result= " + iM1685c);
            C12505m.this.m75088h("");
            return false;
        }
    }

    public C12505m() {
        this.f57608c = null;
    }

    /* renamed from: g */
    public static String m75085g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "v11");
            return jSONObject.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("UpdateDeviceTicket", "encaseUpdateInfo failed! JSONException");
            return null;
        }
    }

    /* renamed from: i */
    public static boolean m75086i(Context context) {
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83988e("UpdateDeviceTicket", "cloud not login");
            return true;
        }
        if (!C1175a.m7389k(context)) {
            C13981a.m83988e("UpdateDeviceTicket", "phoneFinderSwitch off");
            return true;
        }
        String userID = AbstractC12139d.m72766e(context).getUserID();
        if (TextUtils.isEmpty(userID)) {
            C13981a.m83988e("UpdateDeviceTicket", "uid null");
            return true;
        }
        if (userID.equals(C13452e.m80781L().m80971t0())) {
            return false;
        }
        C13981a.m83988e("UpdateDeviceTicket", "uid not match");
        return true;
    }

    /* renamed from: f */
    public void m75087f() {
        C13981a.m83989i("UpdateDeviceTicket", "update DT:" + this.f57606a);
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (contextM74301m == null) {
            C13981a.m83988e("UpdateDeviceTicket", "context null");
            m75088h("");
        } else if (!m75086i(contextM74301m)) {
            C12515a.m75110o().m75172d(new a(contextM74301m));
        } else {
            C13981a.m83989i("UpdateDeviceTicket", "no need to update DT");
            m75088h("");
        }
    }

    /* renamed from: h */
    public final void m75088h(String str) {
        if (this.f57608c == null) {
            C13981a.m83988e("UpdateDeviceTicket", "mCallback is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ticket", str);
        bundle.putString("resp_ticket", "");
        Message message = new Message();
        message.setData(bundle);
        this.f57608c.handleMessage(message);
    }

    public C12505m(String str) {
        this.f57606a = 0;
        this.f57607b = str;
        this.f57608c = null;
    }

    public C12505m(int i10, String str, Handler.Callback callback) {
        this.f57606a = i10;
        this.f57607b = str;
        this.f57608c = callback;
    }
}
