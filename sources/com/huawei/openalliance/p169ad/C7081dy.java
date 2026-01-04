package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.dy */
/* loaded from: classes8.dex */
public class C7081dy {
    /* renamed from: a */
    public static AdContentRsp m42806a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            AbstractC7185ho.m43823c("AdRspFbSerializeUtil", "data is empty");
            return null;
        }
        try {
            C8210we c8210weM51015a = C8210we.m51015a(ByteBuffer.wrap(bArr));
            if (c8210weM51015a == null) {
                AbstractC7185ho.m43823c("AdRspFbSerializeUtil", "from flat buffer, rsp is null.");
                return null;
            }
            AbstractC7185ho.m43820b("AdRspFbSerializeUtil", "parse adContentRsp from fb.");
            AdContentRsp adContentRsp = new AdContentRsp();
            adContentRsp.m40820a(C7080dx.m42739a(c8210weM51015a.m51017a(), -1));
            adContentRsp.m40823a(c8210weM51015a.m51025b());
            adContentRsp.m40824a(C7080dx.m42783a(c8210weM51015a.m51026c()));
            adContentRsp.m40829b(C7080dx.m42782a(c8210weM51015a.m51027d()));
            adContentRsp.m40833c(C7080dx.m42782a(c8210weM51015a.m51029f()));
            adContentRsp.m40837d(C7080dx.m42797a(c8210weM51015a.m51028e()));
            adContentRsp.m40828b(c8210weM51015a.m51030g());
            adContentRsp.m40827b(C7080dx.m42739a(c8210weM51015a.m51032i(), 800));
            adContentRsp.m40841e(C7080dx.m42785a(c8210weM51015a.m51031h()));
            adContentRsp.m40831c(C7080dx.m42803b(c8210weM51015a.m51033j()));
            adContentRsp.m40835d(C7080dx.m42803b(c8210weM51015a.m51034k()));
            adContentRsp.m40839e(C7080dx.m42803b(c8210weM51015a.m51035l()));
            adContentRsp.m40846g(c8210weM51015a.m51036m());
            adContentRsp.m40836d(c8210weM51015a.m51037n());
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("AdRspFbSerializeUtil", "parse adContentRsp from fb end.");
                AbstractC7185ho.m43818a("AdRspFbSerializeUtil", "rsp: %s", AbstractC7758be.m47742b(adContentRsp));
            }
            return adContentRsp;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AdRspFbSerializeUtil", "get rsp from flat buffer ex: %s", th2.getClass().getSimpleName());
            return null;
        }
    }
}
