package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.oo */
/* loaded from: classes8.dex */
public class C7547oo implements InterfaceC7613qo {

    /* renamed from: a */
    private InterfaceC7140fx f35102a;

    /* renamed from: b */
    private ContentRecord f35103b;

    /* renamed from: c */
    private InterfaceC7146gc f35104c;

    public C7547oo(Context context, INativeAd iNativeAd) {
        this.f35102a = C7118fb.m43196a(context);
        this.f35104c = C7124fh.m43316b(context);
        this.f35102a = C7118fb.m43196a(context);
        if (iNativeAd instanceof C7302e) {
            this.f35103b = C7570pd.m46698a((C7302e) iNativeAd);
        }
    }

    /* renamed from: b */
    private C7653sb m46364b(ImageInfo imageInfo, long j10) {
        if (imageInfo == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(imageInfo.getUrl());
        c7653sb.m47184c(imageInfo.getSha256());
        c7653sb.m47181b(imageInfo.isCheckSha256());
        c7653sb.m47171a(Long.valueOf(j10));
        InterfaceC7146gc interfaceC7146gc = this.f35104c;
        c7653sb.m47183c(interfaceC7146gc == null ? Constants.IMG_SIZE_UPPER_LIMIT_KB : interfaceC7146gc.mo43019e());
        c7653sb.m47169a(this.f35103b);
        c7653sb.m47185c(true);
        return c7653sb;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7613qo
    /* renamed from: a */
    public String mo46365a(ImageInfo imageInfo, long j10) {
        C7653sb c7653sbM46364b = m46364b(imageInfo, j10);
        if (c7653sbM46364b != null) {
            C7654sc c7654scMo43274a = this.f35102a.mo43274a(c7653sbM46364b);
            if (c7654scMo43274a != null) {
                return c7654scMo43274a.m47207a();
            }
            AbstractC7185ho.m43823c("BannerAdProcessor", "downloadBannerImg sourceResult is null");
        }
        return null;
    }
}
