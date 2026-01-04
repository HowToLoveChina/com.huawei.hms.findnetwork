package com.huawei.android.hicloud.cloudspace.manager;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p514o9.C11839m;
import p572qb.C12330v;
import p732w8.AsyncTaskC13564o;
import p732w8.AsyncTaskC13566q;
import p732w8.AsyncTaskC13569t;

/* loaded from: classes2.dex */
public class StructureNumRequestor {

    /* renamed from: a */
    public C12330v f11850a;

    /* renamed from: b */
    public Context f11851b;

    /* renamed from: q */
    public CountDownLatch f11866q;

    /* renamed from: c */
    public int f11852c = -1;

    /* renamed from: d */
    public int f11853d = -1;

    /* renamed from: e */
    public int f11854e = -1;

    /* renamed from: f */
    public int f11855f = -1;

    /* renamed from: g */
    public int f11856g = -1;

    /* renamed from: h */
    public int f11857h = -1;

    /* renamed from: i */
    public int f11858i = -1;

    /* renamed from: j */
    public int f11859j = -1;

    /* renamed from: k */
    public int f11860k = -1;

    /* renamed from: l */
    public int f11861l = -1;

    /* renamed from: m */
    public int f11862m = -1;

    /* renamed from: n */
    public int f11863n = -1;

    /* renamed from: o */
    public int f11864o = -1;

    /* renamed from: p */
    public int f11865p = -1;

    /* renamed from: r */
    public CloudStorageTaskCallback f11867r = new C2742a();

    /* renamed from: com.huawei.android.hicloud.cloudspace.manager.StructureNumRequestor$a */
    public class C2742a implements CloudStorageTaskCallback {
        public C2742a() {
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback
        /* renamed from: a */
        public void mo15484a(String str, Object obj, int i10) {
            if ("record_num".equals(str)) {
                Integer num = (Integer) obj;
                if (num != null) {
                    StructureNumRequestor.this.f11852c = num.intValue();
                }
                StructureNumRequestor.this.f11850a.m74150f("record_num", true);
                C11839m.m70688i("StructureNumRequestor", "TASK_NAME_RECORD_NUM");
            } else if ("sms_num".equals(str)) {
                Integer num2 = (Integer) obj;
                if (num2 != null) {
                    StructureNumRequestor.this.f11864o = num2.intValue();
                }
                StructureNumRequestor.this.f11850a.m74150f("sms_num", true);
                C11839m.m70688i("StructureNumRequestor", "TASK_NAME_SMS_NUM");
            } else if ("calllog_num".equals(str)) {
                Integer num3 = (Integer) obj;
                if (num3 != null) {
                    StructureNumRequestor.this.f11865p = num3.intValue();
                }
                StructureNumRequestor.this.f11850a.m74150f("calllog_num", true);
                C11839m.m70688i("StructureNumRequestor", "TASK_NAME_CALLLOG_NUM");
            } else if ("pim_num".equals(str)) {
                StructureNumRequestor.this.f11850a.m74150f("pim_num", true);
                C11839m.m70688i("StructureNumRequestor", "TASK_NAME_PIM_NUM");
                if (obj == null) {
                    return;
                }
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj;
                StructureNumRequestor structureNumRequestor = StructureNumRequestor.this;
                structureNumRequestor.m15518m(structureNumRequestor.m15513h(concurrentHashMap));
                C11839m.m70688i("StructureNumRequestor", "TASK_NAME_PIM_NUM finish, data=" + concurrentHashMap.toString());
            } else if ("sms_calllog_num".equals(str)) {
                StructureNumRequestor.this.f11850a.m74150f("sms_calllog_num", true);
                C11839m.m70688i("StructureNumRequestor", "TASK_NAME_SMS_CALLLOG_NUM");
                if (obj == null) {
                    return;
                }
                HashMap map = (HashMap) obj;
                Integer num4 = (Integer) map.get(NavigationUtils.SMS_SCHEMA_PREF);
                if (num4 != null) {
                    StructureNumRequestor.this.f11864o = num4.intValue();
                }
                Integer num5 = (Integer) map.get("callLog");
                if (num5 != null) {
                    StructureNumRequestor.this.f11865p = num5.intValue();
                }
                C11839m.m70688i("StructureNumRequestor", "TASK_NAME_SMS_CALLLOG_NUM finish, data=" + map.toString());
            }
            StructureNumRequestor.this.m15514i();
        }
    }

    public StructureNumRequestor(Context context) {
        this.f11851b = context;
        m15516k();
    }

    /* renamed from: h */
    public final Map<String, Integer> m15513h(ConcurrentHashMap<String, Integer> concurrentHashMap) {
        if (concurrentHashMap == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, Integer> entry : concurrentHashMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /* renamed from: i */
    public final void m15514i() {
        if (this.f11850a.m74146b()) {
            synchronized (this) {
                notifyAll();
                C11839m.m70688i("StructureNumRequestor", "StructureNumRequestor.this.notify");
            }
        }
    }

    /* renamed from: j */
    public final String m15515j() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("record_num", this.f11852c);
            jSONObject.put("notepad_num", this.f11853d);
            jSONObject.put("recycle_notepad_num", this.f11854e);
            jSONObject.put("calendar_num", this.f11855f);
            jSONObject.put("calendarArc_num", this.f11856g);
            jSONObject.put("contact_num", this.f11857h);
            jSONObject.put("recycle_contact_num", this.f11858i);
            jSONObject.put("wlan_num", this.f11859j);
            jSONObject.put("browser_num", this.f11860k);
            jSONObject.put("sms_num", this.f11864o);
            jSONObject.put("calllog_num", this.f11865p);
            jSONObject.put("bookmark_num", this.f11861l);
            jSONObject.put("history_num", this.f11862m);
            jSONObject.put("info_flow_num", this.f11863n);
            return jSONObject.toString();
        } catch (JSONException e10) {
            C11839m.m70687e("StructureNumRequestor", "getResult JSONException:" + e10.toString());
            return "";
        }
    }

    /* renamed from: k */
    public final void m15516k() {
        this.f11850a = new C12330v();
        C12330v.a aVar = new C12330v.a("record_num");
        C12330v.a aVar2 = new C12330v.a("pim_num");
        C12330v.a aVar3 = new C12330v.a("sms_calllog_num");
        this.f11850a.m74145a(aVar);
        this.f11850a.m74145a(aVar2);
        this.f11850a.m74145a(aVar3);
    }

    /* renamed from: l */
    public String m15517l() {
        this.f11850a.m74147c();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        this.f11866q = countDownLatch;
        AsyncTaskC13569t asyncTaskC13569tM81552b = AsyncTaskC13569t.m81552b(this.f11851b, null, this.f11867r, countDownLatch);
        AsyncTask.Status status = AsyncTask.Status.RUNNING;
        if (!status.equals(asyncTaskC13569tM81552b.getStatus())) {
            asyncTaskC13569tM81552b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        AsyncTaskC13564o asyncTaskC13564oM81527f = AsyncTaskC13564o.m81527f(this.f11851b, null, this.f11867r, this.f11866q);
        if (!status.equals(asyncTaskC13564oM81527f.getStatus())) {
            asyncTaskC13564oM81527f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        AsyncTaskC13566q asyncTaskC13566qM81541b = AsyncTaskC13566q.m81541b(this.f11851b, null, this.f11867r, this.f11866q);
        if (!status.equals(asyncTaskC13566qM81541b.getStatus())) {
            asyncTaskC13566qM81541b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        try {
            if (this.f11866q.await(20000L, TimeUnit.MILLISECONDS)) {
                C11839m.m70688i("StructureNumRequestor", "StructureNumRequestor request all task success");
            } else {
                C11839m.m70688i("StructureNumRequestor", "StructureNumRequestor request timeout");
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("StructureNumRequestor", "StructureNumRequestor request exception:" + e10.toString());
        }
        C11839m.m70688i("StructureNumRequestor", "getResult");
        return m15515j();
    }

    /* renamed from: m */
    public final void m15518m(Map<String, Integer> map) {
        if (map.containsKey("notepad")) {
            this.f11853d = map.get("notepad").intValue();
        }
        if (map.containsKey("recycleNotepad")) {
            this.f11854e = map.get("recycleNotepad").intValue();
        } else {
            this.f11854e = 0;
        }
        if (map.containsKey(HNConstants.DataType.CONTACT)) {
            this.f11857h = map.get(HNConstants.DataType.CONTACT).intValue();
        }
        if (map.containsKey("recycleContact")) {
            this.f11858i = map.get("recycleContact").intValue();
        }
        if (map.containsKey("calendar")) {
            this.f11855f = map.get("calendar").intValue();
        }
        if (map.containsKey("calendarEventArc")) {
            this.f11856g = map.get("calendarEventArc").intValue();
        }
        if (map.containsKey("wlan")) {
            this.f11859j = map.get("wlan").intValue();
        }
        if (map.containsKey("browser")) {
            this.f11860k = map.get("browser").intValue();
        }
        if (map.containsKey("bookmark")) {
            this.f11861l = map.get("bookmark").intValue();
        }
        if (map.containsKey("browserhistory")) {
            this.f11862m = map.get("browserhistory").intValue();
        }
        if (map.containsKey("infoflow")) {
            this.f11863n = map.get("infoflow").intValue();
        }
    }
}
