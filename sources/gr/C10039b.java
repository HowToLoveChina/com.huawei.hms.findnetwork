package gr;

import as.C1016d;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import p234dr.C9295a;

/* renamed from: gr.b */
/* loaded from: classes8.dex */
public final class C10039b extends AbstractC10038a {

    /* renamed from: f */
    public final TreeMap f49006f;

    /* renamed from: g */
    public String f49007g;

    /* renamed from: h */
    public String f49008h;

    public C10039b(String str, String str2) {
        super(str, str2);
        this.f49006f = new TreeMap();
        this.f49007g = "";
        this.f49008h = "";
        m62436f("Charset", Constants.UTF_8).m62436f("Content-Type", RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED).m62436f("Connection", "close");
    }

    @Override // gr.AbstractC10038a
    /* renamed from: b */
    public final InputStream mo62432b() {
        return new ByteArrayInputStream(AbstractC10038a.m62430j(this.f49006f).getBytes(StandardCharsets.UTF_8));
    }

    @Override // gr.AbstractC10038a
    /* renamed from: e */
    public final boolean mo62435e() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        if (!super.mo62435e()) {
            return false;
        }
        String str = "";
        if (this.f49007g.isEmpty()) {
            C1016d.m6181a("QueryRequest", "no need authorization");
        } else if (this.f49008h.isEmpty()) {
            C1016d.m6183c("QueryRequest", "appId empty, can not gen authorization");
        } else {
            Locale locale = Locale.ENGLISH;
            String strM58593a = C9295a.m58593a(this.f49007g.getBytes(StandardCharsets.UTF_8), m62433c() + "&" + m62431a() + "&" + m62438h() + "&" + AbstractC10038a.m62430j(this.f49006f) + "&appID=" + this.f49008h);
            if (strM58593a == null) {
                C1016d.m6183c("QueryRequest", "HMAC-SHA256 failed");
            } else {
                str = strM58593a;
            }
            str = MessageFormat.format("HMAC-SHA256 appID={0}, signature=\"{1}\"", this.f49008h, str);
        }
        if (str.isEmpty()) {
            return true;
        }
        m62436f(FeedbackWebConstants.AUTHORIZATION, str);
        return true;
    }

    /* renamed from: m */
    public final C10039b m62441m(String str, String str2) {
        return m62442n(AbstractC10038a.m62429i(str), AbstractC10038a.m62429i(str2));
    }

    /* renamed from: n */
    public final C10039b m62442n(String str, String str2) {
        if (!str.isEmpty() && !str2.isEmpty()) {
            this.f49006f.put(str, str2);
        }
        return this;
    }

    /* renamed from: o */
    public final C10039b m62443o(String str) {
        this.f49007g = str;
        this.f49008h = "1063";
        return this;
    }

    /* renamed from: p */
    public final C10039b m62444p(TreeMap treeMap) {
        for (Map.Entry entry : treeMap.entrySet()) {
            m62442n(AbstractC10038a.m62429i((String) entry.getKey()), AbstractC10038a.m62429i((String) entry.getValue()));
        }
        return this;
    }
}
