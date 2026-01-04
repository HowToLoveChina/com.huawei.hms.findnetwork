package p511o6;

import android.content.Intent;
import p015ak.C0213f;
import p031b7.C1120a;
import p664u0.C13108a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p701v6.AbstractC13354a;
import p709vj.C13452e;

/* renamed from: o6.a */
/* loaded from: classes2.dex */
public class C11819a {
    /* renamed from: a */
    public static void m70393a(boolean z10) {
        if (z10) {
            try {
                C13195l.m79272J().m79290C("com.huawei.hidisk.cloudAlbum", "CallBack", "");
                return;
            } catch (C13194k e10) {
                C1120a.m6676e("CallBackMsgHandle", "HmsException: " + e10.getMessage());
                return;
            } catch (C13199p e11) {
                C1120a.m6676e("CallBackMsgHandle", "hmsSTInvalidException: " + e11.getMessage());
            }
        }
        if (!C13452e.m80781L().m80842P0()) {
            C1120a.m6678w("CallBackMsgHandle", "not login, ignore auth fail.");
            return;
        }
        C1120a.m6677i("CallBackMsgHandle", "auth fail, sendBroadCast");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: b */
    public static <T> T m70394b(AbstractC13354a<T> abstractC13354a, Class<T> cls) {
        try {
            C13195l.m79272J().m79325o0(abstractC13354a.m80108g());
            C1120a.m6677i("CallBackMsgHandle", " [AT OPERATION] At invalid, retry");
            return abstractC13354a.m80113o(cls);
        } catch (C13199p e10) {
            C1120a.m6676e("CallBackMsgHandle", "sessionFailedHandle HmsSTInvalidException: " + e10.getMessage());
            m70393a(false);
            return null;
        } catch (Exception e11) {
            C1120a.m6676e("CallBackMsgHandle", "sessionFailedHandle request task error: " + e11.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static String m70395c(AbstractC13354a abstractC13354a) {
        try {
            C13195l.m79272J().m79325o0(abstractC13354a.m80108g());
            C1120a.m6677i("CallBackMsgHandle", " [AT OPERATION] At invaild, retry");
            return abstractC13354a.mo76565p();
        } catch (C13199p e10) {
            C1120a.m6676e("CallBackMsgHandle", "HmsSTInvalidException: " + e10.getMessage());
            m70393a(false);
            return null;
        } catch (Exception e11) {
            C1120a.m6676e("CallBackMsgHandle", "sessionFailedHandle request task error: " + e11.getMessage());
            return null;
        }
    }
}
