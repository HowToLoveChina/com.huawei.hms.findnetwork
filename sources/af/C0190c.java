package af;

import com.huawei.android.remotecontrol.http.PhoneFinderServer;
import com.huawei.android.remotecontrol.sharing.bean.SystemConfig;
import com.huawei.android.remotecontrol.sharing.bean.SystemConfigResponse;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p575qe.C12347f;
import p616rk.C12515a;
import p809yg.C13981a;

/* renamed from: af.c */
/* loaded from: classes4.dex */
public class C0190c {

    /* renamed from: af.c$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ boolean f752a;

        /* renamed from: b */
        public final /* synthetic */ int f753b;

        /* renamed from: c */
        public final /* synthetic */ Consumer f754c;

        public a(boolean z10, int i10, Consumer consumer) {
            this.f752a = z10;
            this.f753b = i10;
            this.f754c = consumer;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            try {
                C13981a.m83989i("GetParam", "doGetSystemConfig");
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (this.f752a) {
                    jSONArray.put("releaseTee");
                }
                jSONArray.put("trackTeeTime");
                jSONArray.put("teeDeviceTypeWhite");
                jSONObject.put("params", jSONArray);
                jSONObject.put("sceneId", this.f753b);
                SystemConfigResponse systemConfigResponseM26201l = new PhoneFinderServer(C12347f.m74285n().m74301m()).m26201l(jSONObject.toString());
                if (systemConfigResponseM26201l != null && systemConfigResponseM26201l.getParams() != null) {
                    C0190c.m1076c(this.f752a, systemConfigResponseM26201l.getParams(), this.f754c);
                    return;
                }
                C13981a.m83989i("GetParam", "get system config response is null or params is null");
            } catch (C9721b e10) {
                C13981a.m83988e("GetParam", "GetSystemConfig error: " + e10.getMessage());
            } catch (JSONException e11) {
                C13981a.m83988e("GetParam", "GetSystemConfig jsonBody error " + e11.getMessage());
            }
        }
    }

    /* renamed from: b */
    public static void m1075b(int i10, boolean z10, Consumer<Boolean> consumer) {
        C12515a.m75110o().m75175e(new a(z10, i10, consumer), false);
    }

    /* renamed from: c */
    public static void m1076c(boolean z10, SystemConfig systemConfig, Consumer<Boolean> consumer) {
        boolean zIsTeeDeviceTypeWhite = systemConfig.isTeeDeviceTypeWhite();
        boolean z11 = false;
        boolean zIsReleaseTee = z10 ? systemConfig.isReleaseTee() : false;
        if (consumer != null) {
            if (!z10) {
                z11 = zIsTeeDeviceTypeWhite;
            } else if (zIsTeeDeviceTypeWhite && zIsReleaseTee) {
                z11 = true;
            }
            consumer.accept(Boolean.valueOf(z11));
        }
        C13981a.m83989i("GetParam", "update offline locate config, isInDeviceWhite:" + zIsTeeDeviceTypeWhite + ",isReleaseTee:" + zIsReleaseTee);
    }
}
