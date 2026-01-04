package p478mj;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.util.ArrayMap;
import com.huawei.common.service.IDecision;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p015ak.C0209d;
import p514o9.C11839m;

/* renamed from: mj.b */
/* loaded from: classes5.dex */
public final class C11474b {

    /* renamed from: f */
    public static final String f53370f = "b";

    /* renamed from: a */
    public Handler f53371a;

    /* renamed from: b */
    public IDecision f53372b;

    /* renamed from: c */
    public String f53373c;

    /* renamed from: d */
    public ServiceConnection f53374d;

    /* renamed from: e */
    public ConcurrentHashMap<String, AbstractBinderC11473a> f53375e;

    /* renamed from: mj.b$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f53376a;

        /* renamed from: b */
        public final /* synthetic */ AbstractBinderC11473a f53377b;

        public a(String str, AbstractBinderC11473a abstractBinderC11473a) {
            this.f53376a = str;
            this.f53377b = abstractBinderC11473a;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractBinderC11473a abstractBinderC11473a = (AbstractBinderC11473a) C11474b.this.f53375e.remove(this.f53376a);
            if (abstractBinderC11473a != null) {
                this.f53377b.m68605g();
                try {
                    abstractBinderC11473a.m68606h();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: mj.b$b */
    public class b extends AbstractBinderC11473a {

        /* renamed from: b */
        public final /* synthetic */ String f53379b;

        public b(String str) {
            this.f53379b = str;
        }

        @Override // p478mj.AbstractBinderC11473a, com.huawei.common.service.IDecisionCallback
        public void onResult(Map map) {
            if (this.f53379b != null) {
                C11474b.this.f53375e.remove(this.f53379b);
            }
            AbstractBinderC11473a abstractBinderC11473a = this.f53369a;
            if (abstractBinderC11473a != null) {
                try {
                    abstractBinderC11473a.onResult(map);
                } catch (Exception e10) {
                    C11839m.m70688i(C11474b.f53370f, e10.toString());
                }
            }
        }
    }

    /* renamed from: mj.b$c */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C11839m.m70688i(C11474b.f53370f, "service connected.");
            C11474b.this.f53372b = IDecision.Stub.asInterface(iBinder);
            HashMap map = new HashMap();
            map.put("feature_id", C11474b.this.f53373c);
            map.put("type", "dlg");
            map.put("op", "gogo");
            C11474b.this.m68615h("com.huawei.tips.intent.action.UE_DATA_USER_OPERATION", map);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C11474b.this.f53372b = null;
            C11839m.m70688i(C11474b.f53370f, "service disconnect.");
        }
    }

    public C11474b() {
        this.f53371a = null;
        this.f53372b = null;
        this.f53373c = "SF-10044873_f001";
        this.f53374d = new c();
        this.f53375e = new ConcurrentHashMap<>();
    }

    /* renamed from: e */
    public void m68612e(Context context) {
        if (context == null || this.f53372b != null) {
            C11839m.m70688i(f53370f, "service already binded");
            return;
        }
        if (this.f53371a == null) {
            this.f53371a = new Handler(context.getMainLooper());
        }
        Intent intent = new Intent("com.huawei.recsys.decision.action.BIND_DECISION_SERVICE");
        C0209d.m1302r2(intent, AiCoreSdkConstant.DECISION_PKG_NAME);
        try {
            boolean zBindService = context.bindService(intent, this.f53374d, 1);
            C11839m.m70688i(f53370f, "bindService  ret " + zBindService);
        } catch (Exception e10) {
            C11839m.m70687e(f53370f, e10.getMessage());
        }
    }

    /* renamed from: f */
    public boolean m68613f(String str, String str2, Map<String, Object> map, AbstractBinderC11473a abstractBinderC11473a) {
        return m68614g(str, str2, map, abstractBinderC11473a, -1L);
    }

    /* renamed from: g */
    public boolean m68614g(String str, String str2, Map<String, Object> map, AbstractBinderC11473a abstractBinderC11473a, long j10) {
        if (this.f53372b != null) {
            ArrayMap arrayMap = new ArrayMap();
            if (map != null) {
                arrayMap.putAll(map);
            }
            arrayMap.put("id", str2 != null ? str2 : "");
            if (str != null && !str.equals(str2)) {
                arrayMap.put(Constants.AUTOCONTENT_CATEGORY, str);
            }
            String string = abstractBinderC11473a != null ? abstractBinderC11473a.toString() : null;
            AbstractBinderC11473a abstractBinderC11473aM68616i = m68616i(string);
            abstractBinderC11473aM68616i.m68607i(abstractBinderC11473a);
            if (abstractBinderC11473a != null && j10 > 0) {
                this.f53375e.put(string, abstractBinderC11473a);
                this.f53371a.postDelayed(new a(string, abstractBinderC11473aM68616i), j10);
            }
            try {
                this.f53372b.executeEvent(arrayMap, abstractBinderC11473aM68616i);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: h */
    public boolean m68615h(String str, Map<String, Object> map) {
        return m68613f(str, null, map, null);
    }

    /* renamed from: i */
    public final AbstractBinderC11473a m68616i(String str) {
        return new b(str);
    }

    /* renamed from: j */
    public void m68617j(Context context) {
        if (context != null) {
            try {
                C11839m.m70688i(f53370f, "unbindService");
                context.unbindService(this.f53374d);
            } catch (Exception e10) {
                C11839m.m70687e(f53370f, e10.getMessage());
            }
            this.f53372b = null;
        }
    }

    public C11474b(String str) {
        this.f53371a = null;
        this.f53372b = null;
        this.f53373c = "SF-10044873_f001";
        this.f53374d = new c();
        this.f53375e = new ConcurrentHashMap<>();
        this.f53373c = str;
    }
}
