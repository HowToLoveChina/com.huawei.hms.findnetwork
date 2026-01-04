package p842zf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.tag.bean.TagLocalFindResult;
import org.json.JSONObject;
import p015ak.C0226l0;
import p521og.C11881n;
import p664u0.C13108a;
import p809yg.C13981a;

/* renamed from: zf.f */
/* loaded from: classes4.dex */
public class C14298f {

    /* renamed from: a */
    public String f63545a;

    public C14298f(String str) {
        this.f63545a = str;
    }

    /* renamed from: f */
    public static /* synthetic */ void m85158f(Context context, Intent intent) {
        C13108a.m78878b(context).m78882e(intent);
    }

    /* renamed from: b */
    public TagLocalFindResult m85159b(String str) {
        TagLocalFindResult tagLocalFindResult = null;
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("TagLocalFindReporter", "encaseTagLocalFindResult data is empty");
            return null;
        }
        if (!m85162e()) {
            C13981a.m83988e("TagLocalFindReporter", "encaseTagLocalFindResult unsupported operation type");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iM71364n = C11881n.m71364n(jSONObject, "result");
            TagLocalFindResult tagLocalFindResult2 = new TagLocalFindResult(C11881n.m71362l(jSONObject, "perDeviceId"), this.f63545a, String.valueOf(iM71364n), iM71364n == 0 ? "success" : "fail");
            try {
                tagLocalFindResult2.setCurrentTime(System.currentTimeMillis());
                tagLocalFindResult2.setExecuteTime(C11881n.m71365o(jSONObject, "reportTime"));
                return tagLocalFindResult2;
            } catch (Exception e10) {
                e = e10;
                tagLocalFindResult = tagLocalFindResult2;
                C13981a.m83988e("TagLocalFindReporter", "encaseTagLocalFindResult Exception:" + e.getMessage());
                return tagLocalFindResult;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* renamed from: c */
    public String m85160c() {
        return this.f63545a;
    }

    /* renamed from: d */
    public boolean m85161d() {
        return "startTagSound".equals(this.f63545a) || "stopTagSound".equals(this.f63545a);
    }

    /* renamed from: e */
    public boolean m85162e() {
        return "tagLocate".equals(this.f63545a) || "tagListLocate".equals(this.f63545a) || "startTagSound".equals(this.f63545a) || "stopTagSound".equals(this.f63545a) || "queryTagDisconnectLocation".equals(this.f63545a) || "startNavigation".equals(this.f63545a) || "startBluetoothNavigation".equals(this.f63545a);
    }

    /* renamed from: g */
    public void m85163g(final Context context, TagLocalFindResult tagLocalFindResult, String str) {
        C13981a.m83989i("TagLocalFindReporter", "notifyTagLocalFindResult");
        if (context == null || tagLocalFindResult == null || TextUtils.isEmpty(str)) {
            C13981a.m83988e("TagLocalFindReporter", "notifyTagLocalFindResult params is null");
            return;
        }
        if (!m85162e()) {
            C13981a.m83988e("TagLocalFindReporter", "notifyTagLocalFindResult unsupported operation type");
            return;
        }
        final Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.remotecontrol.intent.TAG_LOCAL_COMMAND_RESULT");
        intent.putExtra("arg", str);
        intent.putExtra("operation", tagLocalFindResult.getOperation());
        intent.putExtra("exeResult", tagLocalFindResult.getExeResult());
        intent.putExtra("executeTime", tagLocalFindResult.getExecuteTime());
        intent.putExtra("tagSn", tagLocalFindResult.getTagSn());
        C0226l0.m1584d(new Runnable() { // from class: zf.e
            @Override // java.lang.Runnable
            public final void run() {
                C14298f.m85158f(context, intent);
            }
        });
    }

    /* renamed from: h */
    public void m85164h(String str) {
        this.f63545a = str;
    }

    public C14298f() {
    }
}
