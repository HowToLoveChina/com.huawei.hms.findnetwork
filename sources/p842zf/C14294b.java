package p842zf;

import android.content.Context;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.alarm.C4328a;
import com.huawei.android.remotecontrol.alarm.C4329b;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.PhoneFinderServer;
import com.huawei.android.remotecontrol.tag.bean.TagBindResponse;
import eg.AbstractC9478g;
import fk.C9721b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0226l0;
import p772xe.C13779d;
import p809yg.C13981a;

/* renamed from: zf.b */
/* loaded from: classes4.dex */
public class C14294b extends AbstractC9478g {

    /* renamed from: a */
    public Context f63537a;

    /* renamed from: b */
    public String f63538b;

    /* renamed from: c */
    public String f63539c;

    public C14294b(Context context, String str, String str2) {
        this.f63537a = context;
        this.f63538b = str;
        this.f63539c = str2;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws JSONException, C9721b {
        final AbstractC1177c c13779d;
        C13981a.m83989i("PairedTagLocalCmdTask", "PairedTagLocalCmdTask started, operation :" + this.f63539c);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("perDeviceId", this.f63538b);
            jSONObject.put("perDeviceType", "3");
            TagBindResponse tagBindResponseM26193c = new PhoneFinderServer(this.f63537a).m26193c(jSONObject.toString());
            if (tagBindResponseM26193c == null) {
                C13981a.m83988e("PairedTagLocalCmdTask", "checkTagBindStatus response is null");
                return;
            }
            C13981a.m83989i("PairedTagLocalCmdTask", "checkTagBindStatus bindStatus:" + tagBindResponseM26193c.getBindStatus());
            if (tagBindResponseM26193c.getBindStatus() != 1) {
                C13981a.m83988e("PairedTagLocalCmdTask", "the tag does not bind with the user account");
                return;
            }
            PushCmdParser pushCmdParser = new PushCmdParser(this.f63538b, this.f63539c);
            if ("tagLocate".equals(this.f63539c) || "tagListLocate".equals(this.f63539c)) {
                c13779d = new C13779d(pushCmdParser, this.f63537a, this.f63539c);
            } else if ("startTagSound".equals(this.f63539c)) {
                c13779d = new C4328a(pushCmdParser, this.f63537a);
            } else {
                if (!"stopTagSound".equals(this.f63539c)) {
                    C13981a.m83988e("PairedTagLocalCmdTask", "unknown operation:" + this.f63539c);
                    return;
                }
                c13779d = new C4329b(pushCmdParser, this.f63537a);
            }
            C0226l0.m1584d(new Runnable() { // from class: zf.a
                @Override // java.lang.Runnable
                public final void run() {
                    c13779d.mo7440z();
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("PairedTagLocalCmdTask", "checkTagBindStatus Exception:" + e10.getMessage());
        }
    }
}
