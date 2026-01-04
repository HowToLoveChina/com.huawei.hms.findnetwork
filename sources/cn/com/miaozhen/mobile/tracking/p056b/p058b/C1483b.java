package cn.com.miaozhen.mobile.tracking.p056b.p058b;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import cn.com.miaozhen.mobile.tracking.viewability.origin.MzCallBack;
import ijiami_release01.NCall;

/* renamed from: cn.com.miaozhen.mobile.tracking.b.b.b */
/* loaded from: classes.dex */
public class C1483b {

    /* renamed from: a */
    private Context f6350a;

    /* renamed from: b */
    private MzCallBack f6351b;

    /* renamed from: c */
    private String f6352c;

    /* renamed from: d */
    private int f6353d = 100;

    /* renamed from: e */
    private int f6354e;

    /* renamed from: f */
    private WebView f6355f;

    public C1483b(Context context) {
        this.f6350a = context;
    }

    /* renamed from: a */
    public String m8402a() {
        return (String) NCall.m64616IL(new Object[]{62, this});
    }

    /* renamed from: b */
    public MzCallBack m8407b() {
        return (MzCallBack) NCall.m64616IL(new Object[]{67, this});
    }

    /* renamed from: c */
    public int m8409c() {
        return NCall.m64614II(new Object[]{69, this});
    }

    /* renamed from: d */
    public int m8410d() {
        return NCall.m64614II(new Object[]{70, this});
    }

    /* renamed from: e */
    public WebView m8411e() {
        return (WebView) NCall.m64616IL(new Object[]{71, this});
    }

    @JavascriptInterface
    public void mz_push(String str) {
        NCall.m64618IV(new Object[]{72, this, str});
    }

    /* renamed from: a */
    public void m8403a(int i10) {
        NCall.m64618IV(new Object[]{63, this, Integer.valueOf(i10)});
    }

    /* renamed from: b */
    public void m8408b(int i10) {
        NCall.m64618IV(new Object[]{68, this, Integer.valueOf(i10)});
    }

    /* renamed from: a */
    public void m8404a(WebView webView) {
        NCall.m64618IV(new Object[]{64, this, webView});
    }

    /* renamed from: a */
    public void m8405a(MzCallBack mzCallBack) {
        NCall.m64618IV(new Object[]{65, this, mzCallBack});
    }

    /* renamed from: a */
    public void m8406a(String str) {
        NCall.m64618IV(new Object[]{66, this, str});
    }
}
