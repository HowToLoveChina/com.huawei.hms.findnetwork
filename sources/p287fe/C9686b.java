package p287fe;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.webview.SafeWebView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import mu.C11524a;
import org.json.JSONException;
import org.json.JSONObject;
import p514o9.C11829c;
import p514o9.C11839m;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: fe.b */
/* loaded from: classes3.dex */
public class C9686b extends C11524a {

    /* renamed from: c */
    public final String[] f47909c;

    /* renamed from: d */
    public final String f47910d;

    /* renamed from: e */
    public final String f47911e;

    public C9686b(SafeWebView safeWebView, String[] strArr, String str, String str2) {
        super(safeWebView);
        this.f47909c = strArr;
        this.f47911e = str2;
        this.f47910d = str;
    }

    /* renamed from: e */
    public static void m60516e(LinkedHashMap linkedHashMap) {
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy != null) {
            linkedHashMap.put("needBackupSize", String.valueOf(spaceProxy.getNeedBackupSize()));
            linkedHashMap.put("availableSize", String.valueOf(spaceProxy.getAvailableSize()));
            linkedHashMap.put("usedSize", String.valueOf(spaceProxy.getUsedSize()));
            linkedHashMap.put("userTags", spaceProxy.getUserTagList("webAddCommonData").toString());
            linkedHashMap.put("gradeCode", spaceProxy.getCurrentGradeCode("webAddCommonData"));
        }
    }

    @JavascriptInterface
    public void reportBI(String str, String str2, String str3) {
        C11839m.m70688i("BaseWebViewInterface", "reportBI start, eventType is :" + str + ", eventKey is :" + str2);
        try {
            if (!C11829c.m70583i(m68794b(), this.f47909c, "reportBI")) {
                C11839m.m70687e("BaseWebViewInterface", "reportBI, url is invalid");
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                C11839m.m70687e("BaseWebViewInterface", "eventKey null");
                return;
            }
            if (!TextUtils.equals("CKC", str) && !TextUtils.equals("PVC", str)) {
                C11839m.m70687e("BaseWebViewInterface", "eventType wrong");
                return;
            }
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            if (!TextUtils.isEmpty(str3)) {
                JSONObject jSONObject = new JSONObject(str3);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    linkedHashMapM79499C.put(next, jSONObject.getString(next));
                }
            }
            m60516e(linkedHashMapM79499C);
            C13227f.m79492i1().m79591l0(str2, linkedHashMapM79499C);
            UBAAnalyze.m29958S(str, str2, this.f47910d, this.f47911e, linkedHashMapM79499C);
        } catch (JSONException e10) {
            C11839m.m70687e("BaseWebViewInterface", "reportBI exception " + e10.getMessage());
        }
    }
}
