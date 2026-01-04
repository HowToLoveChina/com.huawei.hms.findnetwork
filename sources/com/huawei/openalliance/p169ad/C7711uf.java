package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hms.network.embedded.C5914f2;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

/* renamed from: com.huawei.openalliance.ad.uf */
/* loaded from: classes8.dex */
public class C7711uf implements InterfaceC7701tw {

    /* renamed from: a */
    private static final Integer f35767a = 100;

    /* renamed from: b */
    private Boolean f35768b = Boolean.TRUE;

    /* renamed from: a */
    private static String m47366a(C7706ua c7706ua) {
        return String.format("#%s# %s", C7709ud.m47363a(c7706ua.m47345b(), 30), C7709ud.m47363a(c7706ua.m47346c(), 110));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m47372b(Activity activity, C7706ua c7706ua, IWBAPI iwbapi) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        m47371a(c7706ua, weiboMultiMessage);
        m47369a(BitmapFactory.decodeStream(new ByteArrayInputStream(C7709ud.m47365a(activity, c7706ua, FeedbackConst.Mail.LOG_MAX_LENGTH))), weiboMultiMessage);
        m47370a(c7706ua, BitmapFactory.decodeStream(new ByteArrayInputStream(C7709ud.m47365a(activity, c7706ua, C5914f2.f26733f))), weiboMultiMessage);
        iwbapi.shareMessage(activity, weiboMultiMessage, true);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public void mo47333a(Activity activity, C7706ua c7706ua, C7708uc c7708uc) {
        AbstractC7185ho.m43820b("WeiBoShare", "start WeiBo share");
        IWBAPI iwbapiCreateWBAPI = WBAPIFactory.createWBAPI(activity);
        iwbapiCreateWBAPI.setLoggerEnable(true);
        AuthInfo authInfo = new AuthInfo(activity, c7708uc.m47353a(), "", "");
        if (!this.f35768b.booleanValue()) {
            m47372b(activity, c7706ua, iwbapiCreateWBAPI);
        } else {
            m47368a(activity, c7706ua, iwbapiCreateWBAPI, authInfo);
            this.f35768b = Boolean.FALSE;
        }
    }

    /* renamed from: a */
    private static void m47368a(final Activity activity, final C7706ua c7706ua, final IWBAPI iwbapi, AuthInfo authInfo) {
        iwbapi.registerApp(activity, authInfo, new SdkListener() { // from class: com.huawei.openalliance.ad.uf.1
            public void onInitFailure(Exception exc) {
            }

            public void onInitSuccess() {
                C7711uf.m47372b(activity, c7706ua, iwbapi);
            }
        });
    }

    /* renamed from: a */
    private static void m47369a(Bitmap bitmap, WeiboMultiMessage weiboMultiMessage) {
        ImageObject imageObject = new ImageObject();
        imageObject.setImageData(bitmap);
        weiboMultiMessage.imageObject = imageObject;
    }

    /* renamed from: a */
    private static void m47370a(C7706ua c7706ua, Bitmap bitmap, WeiboMultiMessage weiboMultiMessage) {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.actionUrl = c7706ua.m47347d();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.defaultText = "分享网页";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, f35767a.intValue(), byteArrayOutputStream);
            webpageObject.thumbData = byteArrayOutputStream.toByteArray();
        } finally {
            try {
                weiboMultiMessage.mediaObject = webpageObject;
            } finally {
            }
        }
        weiboMultiMessage.mediaObject = webpageObject;
    }

    /* renamed from: a */
    private static void m47371a(C7706ua c7706ua, WeiboMultiMessage weiboMultiMessage) {
        TextObject textObject = new TextObject();
        textObject.text = m47366a(c7706ua);
        weiboMultiMessage.textObject = textObject;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public boolean mo47334a() {
        return C7709ud.m47364a("com.sina.weibo.sdk.auth.AuthInfo");
    }
}
