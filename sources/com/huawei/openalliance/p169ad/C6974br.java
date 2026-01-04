package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a;
import com.huawei.hms.ads.template.downloadbuttonstyle.C5097b;
import com.huawei.hms.ads.template.downloadbuttonstyle.C5098c;
import com.huawei.hms.ads.template.downloadbuttonstyle.C5099d;
import com.huawei.hms.ads.template.downloadbuttonstyle.C5100e;
import com.huawei.hms.ads.template.downloadbuttonstyle.RemoteButtonStyleAttr;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;

/* renamed from: com.huawei.openalliance.ad.br */
/* loaded from: classes8.dex */
public class C6974br {
    /* renamed from: a */
    public static RemoteButtonStyleAttr m41065a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            C7154gk c7154gk = new C7154gk(bundle);
            RemoteButtonStyleAttr remoteButtonStyleAttr = (RemoteButtonStyleAttr) AbstractC7758be.m47739b(c7154gk.m43588d(ParamConstants.BtnParams.BUTTON_STYLE_JSON), RemoteButtonStyleAttr.class, new Class[0]);
            if (remoteButtonStyleAttr != null) {
                IObjectWrapper iObjectWrapperM43589e = c7154gk.m43589e(ParamConstants.BtnParams.NORMAL_BG_DRAWABLE);
                if (iObjectWrapperM43589e != null) {
                    remoteButtonStyleAttr.m30407a((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e));
                }
                IObjectWrapper iObjectWrapperM43589e2 = c7154gk.m43589e(ParamConstants.BtnParams.PROCESS_BG_DRAWABLE);
                if (iObjectWrapperM43589e2 != null) {
                    remoteButtonStyleAttr.m30411b((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e2));
                }
                IObjectWrapper iObjectWrapperM43589e3 = c7154gk.m43589e(ParamConstants.BtnParams.INSTALL_BG_DRAWABLE);
                if (iObjectWrapperM43589e3 != null) {
                    remoteButtonStyleAttr.m30414c((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e3));
                }
                IObjectWrapper binder = bundle.getBinder(ParamConstants.BtnParams.CANCEL_BG_DRAWABLE);
                if (binder != null) {
                    remoteButtonStyleAttr.m30423f((Drawable) ObjectWrapper.unwrap(binder));
                }
                IObjectWrapper iObjectWrapperM43589e4 = c7154gk.m43589e(ParamConstants.BtnParams.DOWN_CANCEL_BTN);
                if (iObjectWrapperM43589e4 != null) {
                    remoteButtonStyleAttr.m30417d((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e4));
                }
                IObjectWrapper iObjectWrapperM43589e5 = c7154gk.m43589e(ParamConstants.BtnParams.NORMAL_BG_DRAWABLE_DARK);
                if (iObjectWrapperM43589e5 != null) {
                    remoteButtonStyleAttr.m30420e((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e5));
                }
                IObjectWrapper iObjectWrapperM43589e6 = c7154gk.m43589e(ParamConstants.BtnParams.PROCESS_BG_DRAWABLE_DARK);
                if (iObjectWrapperM43589e6 != null) {
                    remoteButtonStyleAttr.m30428h((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e6));
                }
                IObjectWrapper iObjectWrapperM43589e7 = c7154gk.m43589e(ParamConstants.BtnParams.INSTALL_BG_DRAWABLE_DARK);
                if (iObjectWrapperM43589e7 != null) {
                    remoteButtonStyleAttr.m30430i((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e7));
                }
                IObjectWrapper iObjectWrapperM43589e8 = c7154gk.m43589e(ParamConstants.BtnParams.DOWN_CANCEL_BTN_DARK);
                if (iObjectWrapperM43589e8 != null) {
                    remoteButtonStyleAttr.m30432j((Drawable) ObjectWrapper.unwrap(iObjectWrapperM43589e8));
                }
                IObjectWrapper binder2 = bundle.getBinder(ParamConstants.BtnParams.CANCEL_BG_DRAWABLE_DARK);
                if (binder2 != null) {
                    remoteButtonStyleAttr.m30426g((Drawable) ObjectWrapper.unwrap(binder2));
                }
                remoteButtonStyleAttr.m30408a(c7154gk.m43588d("download_text"));
                remoteButtonStyleAttr.m30412b(c7154gk.m43588d("installed_text"));
                remoteButtonStyleAttr.m30421e(c7154gk.m43588d(ParamConstants.BtnParams.WEB_PAGE_BUTTON_TEXT));
                remoteButtonStyleAttr.m30409a(c7154gk.m43581a(ParamConstants.BtnParams.APP_RELATED, false));
                remoteButtonStyleAttr.m30415c(c7154gk.m43588d(ParamConstants.BtnParams.PRIOR_BEFORE_DOWNLOAD_BUTTON_TEXT));
                remoteButtonStyleAttr.m30424f(c7154gk.m43588d(ParamConstants.BtnParams.PRIOR_WEB_PAGE_BUTTON_TEXT));
                remoteButtonStyleAttr.m30418d(c7154gk.m43588d(ParamConstants.BtnParams.PRIOR_PROMT_DOWNLOAD_BUTTON_TEXT));
            }
            return remoteButtonStyleAttr;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("UiEngineProxyUtils", "getAttrs err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: b */
    public static AbstractC5096a m41067b(Context context, AppDownloadButton appDownloadButton, int i10, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        AbstractC7185ho.m43818a("UiEngineProxyUtils", "btnStyle: %s", Integer.valueOf(i10));
        AbstractC5096a c5100e = i10 != 1 ? i10 != 2 ? (i10 == 3 || i10 == 4) ? new C5100e(context, appDownloadButton, remoteButtonStyleAttr) : new C5097b(context, appDownloadButton) : new C5098c(context, appDownloadButton) : new C5099d(context, appDownloadButton);
        c5100e.m30451a(context);
        return c5100e;
    }

    /* renamed from: a */
    public static AbstractC5096a m41066a(Context context, AppDownloadButton appDownloadButton, int i10, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        AbstractC7185ho.m43818a("UiEngineProxyUtils", "updateBtnStyle: %s", Integer.valueOf(i10));
        AbstractC5096a c5097b = i10 != 4 ? new C5097b(context, appDownloadButton) : new C5100e(context, appDownloadButton, remoteButtonStyleAttr);
        c5097b.mo30450a();
        return c5097b;
    }
}
