package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7789ci;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.ib */
/* loaded from: classes8.dex */
public class C7208ib {

    /* renamed from: a */
    private final InterfaceC7207ia f33168a;

    /* renamed from: b */
    private final C7209ic f33169b;

    /* renamed from: c */
    private final Context f33170c;

    public C7208ib(Context context, InterfaceC7207ia interfaceC7207ia, C7209ic c7209ic) {
        this.f33168a = interfaceC7207ia;
        this.f33169b = c7209ic;
        this.f33170c = context;
    }

    /* renamed from: b */
    private String m43906b(VideoInfo videoInfo) {
        C7209ic c7209ic = this.f33169b;
        if (c7209ic == null || !c7209ic.m43915b()) {
            return videoInfo.m44586g();
        }
        try {
            return m43907c(videoInfo);
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("CreativeHttpProxy", "Url encode failed,use origin url");
            return videoInfo.m44586g();
        }
    }

    /* renamed from: c */
    private String m43907c(VideoInfo videoInfo) throws UnsupportedEncodingException {
        String strEncode = URLEncoder.encode(videoInfo.m44586g(), Constants.UTF_8);
        int i10 = !videoInfo.isCheckSha256() ? 1 : 0;
        return String.format(Locale.ENGLISH, "http://%s:%s/%s?nonsense=%s&sha256=%s&checkFlag=%s", this.f33170c.getString(C6849R.string.player_local_host), Integer.valueOf(this.f33169b.m43911a()), strEncode, URLEncoder.encode(C7789ci.m48041a(8), Constants.UTF_8), URLEncoder.encode(videoInfo.getSha256(), Constants.UTF_8), URLEncoder.encode(AbstractC7806cz.m48153a(Integer.valueOf(i10)), Constants.UTF_8));
    }

    /* renamed from: a */
    public String m43908a(VideoInfo videoInfo) {
        String strMo43902a = this.f33168a.mo43902a(videoInfo.m44586g());
        return AbstractC7806cz.m48165b(strMo43902a) ^ true ? strMo43902a : m43906b(videoInfo);
    }
}
