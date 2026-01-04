package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.FlatBufferBuilder;
import com.huawei.openalliance.p169ad.beans.server.AdContentReq;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.openalliance.ad.dw */
/* loaded from: classes8.dex */
public class C7079dw {
    /* renamed from: a */
    public static byte[] m42738a(AdContentReq adContentReq) {
        String str;
        if (adContentReq == null) {
            str = "toFlatBufferBytes adContentReq is null";
        } else {
            try {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
                flatBufferBuilder.finish(C8192vn.m50754a(flatBufferBuilder, C7078dv.m42727a(adContentReq.m40755F()), -1111L, C7078dv.m42728a(adContentReq.m40792f(), flatBufferBuilder), 0, Constants.FB_NUMBER_DEF, Constants.FB_NUMBER_DEF, C8192vn.m50755a(flatBufferBuilder, C7078dv.m42730a(adContentReq.m40803k(), flatBufferBuilder)), 0, C7078dv.m42728a(adContentReq.m40795g(), flatBufferBuilder), 0, C7078dv.m42719a(adContentReq.m40798h(), flatBufferBuilder), C7078dv.m42721a(adContentReq.m40801i(), flatBufferBuilder), C7078dv.m42724a(adContentReq.m40802j(), flatBufferBuilder), C8192vn.m50758b(flatBufferBuilder, C7087ec.m42873a(adContentReq.m40804l(), flatBufferBuilder)), C8192vn.m50760c(flatBufferBuilder, C7087ec.m42873a(adContentReq.m40805m(), flatBufferBuilder)), C7078dv.m42728a(adContentReq.m40806n(), flatBufferBuilder), adContentReq.m40808p(), C8192vn.m50762d(flatBufferBuilder, C7087ec.m42873a(adContentReq.m40809q(), flatBufferBuilder)), C7078dv.m42728a(adContentReq.m40810r(), flatBufferBuilder), adContentReq.m40807o(), adContentReq.m40784d(), C7078dv.m42727a(adContentReq.m40811s()), C7078dv.m42727a(adContentReq.m40812t()), C7078dv.m42727a(adContentReq.m40813u()), C7078dv.m42727a(adContentReq.m40814v()), C7078dv.m42725a(adContentReq.m40815w(), flatBufferBuilder), C7078dv.m42723a(adContentReq.m40816x(), flatBufferBuilder), C7078dv.m42726a(adContentReq.m40817y(), flatBufferBuilder), C7078dv.m42717a(adContentReq.m40818z(), flatBufferBuilder), C7078dv.m42727a(adContentReq.m40750A()), C7078dv.m42728a(adContentReq.m40751B(), flatBufferBuilder), C7078dv.m42728a(adContentReq.m40752C(), flatBufferBuilder), C7078dv.m42728a(adContentReq.m40753D(), flatBufferBuilder), adContentReq.m40788e(), 0, 0, 0, 0, 0, C8192vn.m50764e(flatBufferBuilder, C7087ec.m42873a(adContentReq.m40764O(), flatBufferBuilder)), C8192vn.m50766f(flatBufferBuilder, C7078dv.m42731a(adContentReq.m40754E(), flatBufferBuilder)), C7078dv.m42728a(adContentReq.m40756G(), flatBufferBuilder), C8192vn.m50768g(flatBufferBuilder, C7078dv.m42733b(adContentReq.m40757H(), flatBufferBuilder)), C8192vn.m50770h(flatBufferBuilder, C7087ec.m42873a(adContentReq.m40758I(), flatBufferBuilder)), C8192vn.m50772i(flatBufferBuilder, C7087ec.m42873a(adContentReq.m40759J(), flatBufferBuilder)), C7078dv.m42727a(adContentReq.m40760K()), C7078dv.m42727a(adContentReq.m40761L()), C7078dv.m42727a(adContentReq.m40762M()), C8192vn.m50774j(flatBufferBuilder, adContentReq.m40763N())));
                return flatBufferBuilder.sizedByteArray();
            } catch (Throwable th2) {
                str = "toFlatBuffersBytes error:" + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43823c("AdReqFbSerializeUtil", str);
        return null;
    }
}
