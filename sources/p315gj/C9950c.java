package p315gj;

import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.cloud.pay.model.GetPortraitReq;
import com.huawei.cloud.pay.model.Request;
import com.huawei.cloud.pay.model.Response;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9720a;
import fk.C9721b;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p259ej.C9498c;
import p429kk.C11060c;
import p664u0.C13108a;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import ro.C12612a;
import tm.C13040c;

/* renamed from: gj.c */
/* loaded from: classes5.dex */
public class C9950c {

    /* renamed from: a */
    public static final Gson f48723a = new Gson();

    /* renamed from: gj.c$b */
    public static class b extends TypeToken<PortraitAndGrade> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: gj.c$c */
    public static class c {

        /* renamed from: a */
        public static C9950c f48724a = new C9950c();
    }

    /* renamed from: gj.c$d */
    public static class d extends TypeToken<Response> {
        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: c */
    public static C9950c m61724c() {
        return c.f48724a;
    }

    /* renamed from: a */
    public final String m61725a(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder(str);
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                sb2.append(" ");
                sb2.append(obj == null ? "" : obj.toString());
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public final <T> T m61726b(String str, Type type) throws C9721b {
        try {
            return (T) f48723a.fromJson(str, type);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10);
        }
    }

    /* renamed from: d */
    public PortraitAndGrade m61727d(C11060c c11060c) throws C9721b {
        C1442a.m8290i("PortraitService", "getPortraitAll");
        PortraitAndGrade portraitAndGrade = new PortraitAndGrade();
        ArrayList arrayList = new ArrayList();
        PortraitAndGrade.UserTagList userTagList = new PortraitAndGrade.UserTagList();
        userTagList.setUserTags(arrayList);
        portraitAndGrade.setUserTagList(userTagList);
        String nextCursor = "";
        boolean z10 = false;
        while (true) {
            GetPortraitReq getPortraitReq = new GetPortraitReq("portrait", z10, 10, nextCursor);
            m61734k(c11060c, getPortraitReq);
            C1442a.m8290i("PortraitService", "start invoke portrait");
            String strM61731h = m61731h(getPortraitReq.getCmd(), getPortraitReq, c11060c, "GET");
            C1442a.m8288d("PortraitService", "getPortrait response : " + strM61731h);
            try {
                PortraitAndGrade portraitAndGrade2 = (PortraitAndGrade) m61726b(strM61731h, new b().getType());
                PortraitAndGrade.GradeRights gradeRights = portraitAndGrade2.getGradeRights();
                if (gradeRights != null) {
                    portraitAndGrade.setGradeRights(gradeRights);
                }
                PortraitAndGrade.UserTagList userTagList2 = portraitAndGrade2.getUserTagList();
                if (userTagList2 == null) {
                    C1442a.m8289e("PortraitService", "getPortrait userTagList is null");
                    return portraitAndGrade;
                }
                List<PortraitAndGrade.UserTag> userTags = userTagList2.getUserTags();
                if (userTags == null) {
                    C1442a.m8289e("PortraitService", "getPortrait userTags is null");
                    return portraitAndGrade;
                }
                arrayList.addAll(userTags);
                nextCursor = portraitAndGrade2.getUserTagList().getNextCursor();
                if (TextUtils.isEmpty(nextCursor)) {
                    return portraitAndGrade;
                }
                z10 = true;
            } catch (JsonSyntaxException e10) {
                C1442a.m8289e("PortraitService", "getPortrait json error is: " + e10.getMessage());
                throw e10;
            }
        }
    }

    /* renamed from: e */
    public final String m61728e(String str) throws C9721b {
        return m61729f(str, null);
    }

    /* renamed from: f */
    public final String m61729f(String str, String str2) throws C9721b {
        String str3 = C13040c.m78609F().m78646f0() + m61730g(str);
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        return str3 + str2;
    }

    /* renamed from: g */
    public final String m61730g(String str) {
        return "/HiCloudUserInformationService/v1/" + str;
    }

    /* renamed from: h */
    public final String m61731h(String str, Request request, C11060c c11060c, String str2) throws C9721b {
        int i10;
        String str3;
        String str4;
        String strM61728e = m61728e(str);
        char c10 = 1;
        int i11 = 1;
        while (true) {
            try {
                try {
                    String strM79344y = C13195l.m79272J().m79344y("Portrait", str);
                    if (strM79344y.isEmpty()) {
                        throw new C9721b(6, "client accessToken is null");
                    }
                    if ("GET".equals(str2)) {
                        strM61728e = strM61728e + Constants.QUESTION_STR + request;
                    }
                    String str5 = strM61728e;
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    objArr[c10] = "x-hw-trace-id = ";
                    objArr[2] = c11060c.m66661q();
                    C1442a.m8290i("PortraitService", m61725a(str5, objArr));
                    C1442a.m8288d("PortraitService", m61725a(str, request));
                    try {
                        i10 = 3;
                        str3 = str5;
                        try {
                            try {
                                str4 = (String) C12612a.m76107g(str3, new C9498c(strM79344y, str, request.toString(), c11060c.m66661q(), str2), c11060c);
                            } catch (C9721b e10) {
                                e = e10;
                                C1442a.m8289e("PortraitService", "invoke exception: " + m61725a(str, e));
                                if (e.m60663g() == 401) {
                                    int i12 = i11 + 1;
                                    if (i11 < i10) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(" [AT OPERATION] ");
                                        Object[] objArr2 = new Object[i10];
                                        objArr2[0] = str;
                                        objArr2[1] = Integer.valueOf(e.m60659c());
                                        objArr2[2] = e.getMessage();
                                        sb2.append(m61725a(str3, objArr2));
                                        C1442a.m8291w("PortraitService", sb2.toString());
                                        C13195l.m79272J().m79325o0(strM79344y);
                                        i11 = i12;
                                        strM61728e = str3;
                                        c10 = 1;
                                    } else {
                                        i11 = i12;
                                    }
                                }
                                m61732i(e);
                                str4 = null;
                                if (str4 == null) {
                                    break;
                                }
                                break;
                                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null");
                            }
                        } catch (C9721b e11) {
                            e = e11;
                        }
                    } catch (C9721b e12) {
                        e = e12;
                        i10 = 3;
                        str3 = str5;
                    }
                    if (str4 == null || str4.isEmpty()) {
                        break;
                        break;
                    }
                    Response response = (Response) m61726b(str4, new d().getType());
                    int resultCode = response.getResultCode();
                    if (resultCode == 0) {
                        return str4;
                    }
                    if (resultCode != i10) {
                        break;
                    }
                    int i13 = i11 + 1;
                    if (i11 >= i10) {
                        break;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" [AT OPERATION] ");
                    Object[] objArr3 = new Object[i10];
                    objArr3[0] = str;
                    objArr3[1] = Integer.valueOf(resultCode);
                    objArr3[2] = response.getResultDesc();
                    sb3.append(m61725a(str3, objArr3));
                    C1442a.m8291w("PortraitService", sb3.toString());
                    C13195l.m79272J().m79325o0(strM79344y);
                    i11 = i13;
                    strM61728e = str3;
                    c10 = 1;
                } catch (C13199p e13) {
                    C1442a.m8289e("PortraitService", "ST auth failed e: " + e13.getMessage());
                    m61733j();
                    throw new C9721b(6, e13.getMessage());
                } catch (Exception e14) {
                    C1442a.m8289e("PortraitService", m61725a(str, e14));
                    throw new C9721b(4001, e14.getMessage(), e14);
                }
            } catch (C9721b e15) {
                C1442a.m8289e("PortraitService", m61725a(str, e15));
                throw e15;
            }
        }
        C1442a.m8288d("PortraitService", "PortraitService invoke 30005 exception: " + str4);
        throw new C9721b(PayStatusCodes.PAY_STATE_NET_ERROR, str4);
    }

    /* renamed from: i */
    public final void m61732i(C9721b c9721b) throws C9721b {
        if (!m61735l(c9721b)) {
            throw new C9721b(1, c9721b.getMessage());
        }
        throw c9721b;
    }

    /* renamed from: j */
    public final void m61733j() {
        C1442a.m8291w("PortraitService", "sendAuthFail campaign server auth failed.");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: k */
    public final void m61734k(C11060c c11060c, Request request) throws C9721b {
        C9720a.m60657f(c11060c, "stat is null.");
        C9720a.m60657f(request, "request is null.");
        C9720a.m60653b(c11060c.m66661q(), "x-hw-trace-id is null.");
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C9720a.m60653b(strM80971t0, "userid is null.");
        c11060c.m66644J(strM80971t0);
        c11060c.m66664t(request.getCmd());
    }

    /* renamed from: l */
    public final boolean m61735l(C9721b c9721b) {
        return c9721b.m60659c() == 9002 || c9721b.m60659c() == 9005 || c9721b.m60659c() == 9003 || c9721b.m60659c() == 9001 || c9721b.m60659c() == 9100;
    }
}
