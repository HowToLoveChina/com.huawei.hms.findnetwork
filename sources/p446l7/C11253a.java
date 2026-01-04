package p446l7;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.request.agreement.request.QueryAgreementRsp;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import com.huawei.hwcloudjs.p165g.C6664a;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p681uj.C13192i;
import p709vj.C13452e;
import p746wn.C13622a;
import p846zj.C14306d;
import p861do.C9281a;

/* renamed from: l7.a */
/* loaded from: classes2.dex */
public class C11253a extends AbstractC12367d {

    /* renamed from: f */
    public static final Object f52836f = new Object();

    /* renamed from: a */
    public Handler f52837a;

    /* renamed from: b */
    public Context f52838b;

    /* renamed from: c */
    public boolean f52839c;

    /* renamed from: d */
    public String f52840d;

    /* renamed from: e */
    public C11060c f52841e;

    public C11253a(Context context, Handler handler) {
        this.f52839c = false;
        this.f52840d = null;
        this.f52841e = null;
        this.f52837a = handler;
        this.f52838b = context;
        String strM66627b = C11058a.m66627b("07009");
        this.f52840d = strM66627b;
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "termProcess", C13452e.m80781L().m80971t0());
        this.f52841e = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }

    /* renamed from: c */
    public final long m67582c(Object obj) {
        ArrayList<SignInfo> signInfo = ((QueryAgreementRsp) obj).getSignInfo();
        long signTime = 0;
        if (signInfo != null) {
            Iterator<SignInfo> it = signInfo.iterator();
            while (it.hasNext()) {
                SignInfo next = it.next();
                if (next != null && signTime < next.getSignTime()) {
                    signTime = next.getSignTime();
                }
            }
        }
        return signTime;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        if (this.f52838b == null) {
            C11839m.m70688i("QueryAgreementServiceTask", "mContext is null");
            Message messageObtain = Message.obtain();
            messageObtain.what = 31001;
            this.f52837a.sendMessage(messageObtain);
            return;
        }
        C14306d.m85214o();
        boolean zM70534N0 = C11829c.m70534N0(this.f52838b.getApplicationContext(), C13452e.m80781L().m80942m());
        boolean zBooleanValue = C13452e.m80781L().m80803F0().booleanValue();
        HashMap map = new HashMap();
        map.put("agreement_type", zM70534N0 ? C6664a.f30905c : "tms");
        map.put("is_china_region", String.valueOf(zBooleanValue));
        C13622a.m81969o(this.f52838b, this.f52841e, map);
        C11839m.m70688i("QueryAgreementServiceTask", "QueryAgreementServiceTask isSupportUnifyAgreement=" + zM70534N0 + ", isChinaRegion=" + zBooleanValue);
        if (zM70534N0 && zBooleanValue) {
            m67583d();
        } else {
            m67584e();
        }
    }

    /* renamed from: d */
    public final void m67583d() {
        ContentResolver contentResolver = C0213f.m1377a().getContentResolver();
        Uri uri = Uri.parse("content://com.huawei.hwid.api.provider/agree_state");
        if (!C0209d.m1227Y1(C0213f.m1377a(), uri)) {
            C11839m.m70687e("QueryAgreementServiceTask", "is not Target App or System App");
            Message messageObtain = Message.obtain();
            messageObtain.what = 31001;
            this.f52837a.sendMessage(messageObtain);
            return;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uri, null, null, null, null);
                long jCurrentTimeMillis = System.currentTimeMillis();
                C10028c c10028cM62183d0 = C10028c.m62183d0(this.f52838b);
                if (!this.f52839c) {
                    c10028cM62183d0.m62197C2("hms_agr_query_time", jCurrentTimeMillis);
                }
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 31001;
                    this.f52837a.sendMessage(messageObtain2);
                    C11839m.m70687e("QueryAgreementServiceTask", "queryAgreementFromHms failed : no cursor");
                    HashMap map = new HashMap();
                    map.put("agreement_type", C6664a.f30905c);
                    map.put("query_agreement_status", "Failed");
                    map.put("query_agreement_fail_reason", "hms_no_cursor");
                    C13622a.m81969o(this.f52838b, this.f52841e, map);
                } else {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("agree_state"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("agree_update_uri"));
                    HashMap map2 = new HashMap();
                    map2.put("agreement_type", C6664a.f30905c);
                    map2.put("query_agreement_status", "Success");
                    map2.put("query_hms_state", string);
                    map2.put("query_hms_uri", string2);
                    C13622a.m81969o(this.f52838b, this.f52841e, map2);
                    Message messageObtain3 = Message.obtain();
                    messageObtain3.what = 31002;
                    messageObtain3.arg1 = Integer.parseInt(string);
                    messageObtain3.obj = string2;
                    this.f52837a.sendMessage(messageObtain3);
                }
                if (cursorQuery == null || cursorQuery.isClosed()) {
                    return;
                }
            } catch (Exception e10) {
                Message messageObtain4 = Message.obtain();
                messageObtain4.what = 31001;
                this.f52837a.sendMessage(messageObtain4);
                C11839m.m70687e("QueryAgreementServiceTask", "queryAgreementFromHms exception:" + e10.toString());
                HashMap map3 = new HashMap();
                map3.put("agreement_type", C6664a.f30905c);
                map3.put("query_agreement_status", "Failed");
                map3.put("query_agreement_fail_reason", e10.toString());
                C13622a.m81969o(this.f52838b, this.f52841e, map3);
                if (0 == 0 || cursorQuery.isClosed()) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (0 != 0 && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: e */
    public final void m67584e() {
        Message messageObtain = Message.obtain(this.f52837a);
        int iM79259d = C13192i.m79258g().m79259d();
        if (iM79259d != 0) {
            C11839m.m70686d("QueryAgreementServiceTask", "retCode:" + iM79259d);
            messageObtain.what = 31001;
            messageObtain.obj = Integer.valueOf(iM79259d);
            this.f52837a.sendMessage(messageObtain);
            return;
        }
        synchronized (f52836f) {
            try {
                C9281a c9281a = new C9281a();
                try {
                    messageObtain.what = 31000;
                    messageObtain.obj = c9281a.m58352g(C11829c.m70533N());
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    C10028c c10028cM62183d0 = C10028c.m62183d0(this.f52838b);
                    if (!this.f52839c) {
                        c10028cM62183d0.m62197C2("agr_query_time", jCurrentTimeMillis);
                    }
                    c10028cM62183d0.m62197C2("agr_sign_time", m67582c(messageObtain.obj));
                    c10028cM62183d0.m62232J3("agr_sign_local_version", "hwclouddrive 16.0.0.300");
                    C11839m.m70686d("QueryAgreementServiceTask", "query date:" + jCurrentTimeMillis);
                    HashMap map = new HashMap();
                    map.put("agreement_type", "tms");
                    map.put("query_agreement_status", "Success");
                    map.put("query_tms_response", messageObtain.obj.toString());
                    C13622a.m81969o(this.f52838b, this.f52841e, map);
                } catch (C9721b e10) {
                    C11839m.m70687e("QueryAgreementServiceTask", "QueryAgreementServiceTask failed, " + e10.getMessage());
                    messageObtain.what = 31001;
                    HashMap map2 = new HashMap();
                    map2.put("agreement_type", "tms");
                    map2.put("query_agreement_status", "Failed");
                    map2.put("query_agreement_fail_reason", e10.toString());
                    C13622a.m81969o(this.f52838b, this.f52841e, map2);
                }
                this.f52837a.sendMessage(messageObtain);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }

    public C11253a(Context context, Handler handler, boolean z10) {
        this.f52840d = null;
        this.f52841e = null;
        this.f52837a = handler;
        this.f52838b = context;
        this.f52839c = z10;
        String strM66627b = C11058a.m66627b("07009");
        this.f52840d = strM66627b;
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "termProcessFromAgrLog", C13452e.m80781L().m80971t0());
        this.f52841e = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }
}
