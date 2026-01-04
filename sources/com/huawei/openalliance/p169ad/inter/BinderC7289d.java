package com.huawei.openalliance.p169ad.inter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.InterfaceC5107b;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.BinderC6976bt;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7154gk;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.GlobalUtilKeys;
import com.huawei.openalliance.p169ad.constant.GlobalUtilMethods;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7780c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* renamed from: com.huawei.openalliance.ad.inter.d */
/* loaded from: classes2.dex */
public class BinderC7289d extends IGlobalUtil.AbstractBinderC5101a {

    /* renamed from: a */
    private static final byte[] f33538a = new byte[0];

    /* renamed from: b */
    private static BinderC7289d f33539b;

    /* renamed from: c */
    private List<IPPSUiEngineCallback> f33540c = new ArrayList();

    /* renamed from: d */
    private Context f33541d;

    private BinderC7289d(Context context) {
        this.f33541d = context;
    }

    /* renamed from: a */
    private Bundle m44235a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String strM43588d = new C7154gk(bundle).m43588d(GlobalUtilKeys.ORI_URL);
        if (TextUtils.isEmpty(strM43588d)) {
            return null;
        }
        AbstractC7185ho.m43821b("GlobalUtil", "get local path, oriUrl: %s", AbstractC7806cz.m48176g(strM43588d));
        Future<String> futureM44242b = m44242b(strM43588d, Constants.TPLATE_CACHE);
        Future<String> futureM44242b2 = m44242b(strM43588d, Constants.NORMAL_CACHE);
        Bundle bundle2 = new Bundle();
        String strM44239a = m44239a(futureM44242b);
        if (!TextUtils.isEmpty(strM44239a)) {
            AbstractC7185ho.m43821b("GlobalUtil", "got tplateLocalPath: %s", AbstractC7806cz.m48176g(strM44239a));
            bundle2.putString(GlobalUtilKeys.LOCAL_PATH, strM44239a);
            return bundle2;
        }
        String strM44239a2 = m44239a(futureM44242b2);
        if (TextUtils.isEmpty(strM44239a2)) {
            return null;
        }
        AbstractC7185ho.m43821b("GlobalUtil", "got normalLocalPath: %s", AbstractC7806cz.m48176g(strM44239a2));
        bundle2.putString(GlobalUtilKeys.LOCAL_PATH, strM44239a2);
        return bundle2;
    }

    /* renamed from: b */
    private static BinderC7289d m44241b(Context context) {
        BinderC7289d binderC7289d;
        synchronized (f33538a) {
            try {
                if (f33539b == null) {
                    f33539b = new BinderC7289d(context);
                }
                binderC7289d = f33539b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return binderC7289d;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AbstractC7185ho.m43821b("GlobalUtil", "call method: %s", str);
        str.hashCode();
        if (str.equals(GlobalUtilMethods.QUERY_LOCAL_PATH)) {
            return m44235a(bundle);
        }
        AbstractC7185ho.m43820b("GlobalUtil", "call method fall to default.");
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        String strM41968c;
        try {
            strM41968c = C7019dh.m41937a(this.f33541d, Constants.TPLATE_CACHE).m41968c(C7022dk.m41953d(str));
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("GlobalUtil", "getFilePath err: %s", th2.getClass().getSimpleName());
        }
        if (AbstractC7731ae.m47462c(this.f33541d, strM41968c, Constants.TPLATE_CACHE)) {
            AbstractC7185ho.m43820b("GlobalUtil", "getFilePath from cache");
            m44240a(iPPSUiEngineCallback, strM41968c);
            return;
        }
        try {
            Pair<String, String> pairM47852a = C7780c.m47852a(this.f33541d, str, Constants.TPLATE_CACHE);
            if (pairM47852a != null && !TextUtils.isEmpty((CharSequence) pairM47852a.first) && !TextUtils.isEmpty((CharSequence) pairM47852a.second)) {
                AbstractC7185ho.m43820b("GlobalUtil", "getFilePath from kit");
                m44240a(iPPSUiEngineCallback, (String) pairM47852a.first);
                return;
            }
        } catch (Throwable th3) {
            AbstractC7185ho.m43821b("GlobalUtil", "get path err: %s", th3.getClass().getSimpleName());
        }
        iPPSUiEngineCallback.onCallResult(ParamConstants.Cmd.GET_FILE_PATH, null);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirect(String str) {
        return m44238a(str, Constants.TPLATE_CACHE);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirectByCacheType(String str, int i10) {
        return m44238a(str, 3 != i10 ? Constants.NORMAL_CACHE : Constants.TPLATE_CACHE);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public InterfaceC5107b getMultiMediaPlayingManager() {
        BinderC6976bt.m41068a(this.f33541d).m41072a(HiAd.m44014a(this.f33541d).mo44049c());
        return BinderC6976bt.m41068a(this.f33541d);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
        try {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view == null) {
                AbstractC7185ho.m43823c("GlobalUtil", "remote view is null.");
                return false;
            }
            Activity activityM48320d = AbstractC7811dd.m48320d((View) view.getParent());
            if (activityM48320d != null) {
                return AbstractC7811dd.m48309b(activityM48320d);
            }
            AbstractC7185ho.m43823c("GlobalUtil", "activity is null.");
            return false;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("GlobalUtil", "is freedom window ex: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        AbstractC7185ho.m43820b("GlobalUtil", "registerActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.f33540c.add(iPPSUiEngineCallback);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        AbstractC7185ho.m43820b("GlobalUtil", "unregisterActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.f33540c.remove(iPPSUiEngineCallback);
        }
    }

    /* renamed from: a */
    public static BinderC7289d m44236a(Context context) {
        return m44241b(context);
    }

    /* renamed from: b */
    private Future<String> m44242b(final String str, final String str2) {
        return AbstractC7810dc.m48271a(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.d.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String call() {
                return BinderC7289d.this.m44238a(str, str2);
            }
        });
    }

    /* renamed from: b */
    public void m44243b() {
        for (IPPSUiEngineCallback iPPSUiEngineCallback : this.f33540c) {
            if (iPPSUiEngineCallback != null) {
                try {
                    iPPSUiEngineCallback.onCallResult("onActivityStartFinish", null);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43821b("GlobalUtil", "onCallResult err: %s", th2.getClass().getSimpleName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m44238a(String str, String str2) {
        try {
            String strM41968c = C7019dh.m41937a(this.f33541d, str2).m41968c(C7022dk.m41953d(str));
            if (AbstractC7731ae.m47462c(this.f33541d, strM41968c, str2)) {
                return strM41968c;
            }
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("GlobalUtil", "getFilePath err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    private static String m44239a(Future<String> future) {
        try {
            return future.get();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("GlobalUtil", "get localPath ex: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    private void m44240a(IPPSUiEngineCallback iPPSUiEngineCallback, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("filePath", str);
        iPPSUiEngineCallback.onCallResult(ParamConstants.Cmd.GET_FILE_PATH, bundle);
    }
}
