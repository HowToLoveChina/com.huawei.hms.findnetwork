package p854zs;

import android.location.Location;
import android.os.Bundle;
import as.C1016d;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.resp.C6804Vw;
import com.huawei.riemann.location.common.utils.Constant;
import es.C9536a;
import es.C9542g;
import es.C9545j;
import hu.C10343b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mr.C11506a;
import p531or.C11991a;

/* renamed from: zs.b */
/* loaded from: classes8.dex */
public final class C14373b {

    /* renamed from: a */
    public ReportBuilder f63737a;

    /* renamed from: zs.b$a */
    public static class a {

        /* renamed from: a */
        public ReportBuilder f63738a;

        public a() {
            ReportBuilder reportBuilder = new ReportBuilder();
            this.f63738a = reportBuilder;
            reportBuilder.setAppID(C11506a.m68682e().m68686d());
        }

        /* renamed from: a */
        public final a m85575a(String str) {
            this.f63738a.setTransactionID(str);
            return this;
        }

        /* renamed from: b */
        public final void m85576b() {
            this.f63738a.setWLANScan();
        }

        /* renamed from: c */
        public final void m85577c(String str) {
            this.f63738a.setExt(str);
        }

        /* renamed from: d */
        public final a m85578d(String str) {
            this.f63738a.setApiName(str);
            return this;
        }

        /* renamed from: e */
        public final C14373b m85579e() {
            return new C14373b(this.f63738a);
        }

        /* renamed from: f */
        public final void m85580f(LocationRequest locationRequest, boolean z10) {
            HashMap map = new HashMap();
            if (locationRequest != null) {
                map.put("priority", Integer.valueOf(locationRequest.getPriority()));
                map.put("interval", Long.valueOf(locationRequest.getInterval()));
                map.put("fastestInterval", Long.valueOf(locationRequest.getFastestInterval()));
                map.put("expirationTime", Long.valueOf(locationRequest.getExpirationTime()));
                map.put("numUpdates", Integer.valueOf(locationRequest.getNumUpdates()));
                map.put("smallestDisplacement", Float.valueOf(locationRequest.getSmallestDisplacement()));
                map.put("needAddress", Boolean.valueOf(locationRequest.getNeedAddress()));
                map.put("maxWaitTime", Long.valueOf(locationRequest.getMaxWaitTime()));
                if (z10) {
                    map.put("isDuplicate", 1);
                }
                Map<String, String> extras = locationRequest.getExtras();
                if (extras != null && extras.containsKey(LocationRequestHelper.CP_TRANS_ID)) {
                    map.put(LocationRequestHelper.CP_TRANS_ID, extras.get(LocationRequestHelper.CP_TRANS_ID));
                }
            }
            try {
                this.f63738a.setExt(C9542g.m59588a().toJson(map));
            } catch (Exception unused) {
                C1016d.m6183c("LocationClientReport", "GsonUtil.getInstance().toJson(map) exception");
            }
        }

        /* renamed from: g */
        public final void m85581g(LocationBaseRequest locationBaseRequest) {
            if (locationBaseRequest != null) {
                this.f63738a.setTransactionID(locationBaseRequest.getTid());
                this.f63738a.setLocationEnable(C9545j.m59603d(C11991a.m72145a()));
                this.f63738a.setPackage(locationBaseRequest.getPackageName());
                this.f63738a.setCpAppVersion(String.valueOf(C9536a.m59551k(locationBaseRequest.getPackageName())));
            }
        }

        /* renamed from: h */
        public final void m85582h(C6804Vw c6804Vw) {
            ArrayList arrayListM38487a = c6804Vw.m38487a();
            if (arrayListM38487a.size() == 0) {
                this.f63738a.setExt("");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = arrayListM38487a.iterator();
            while (it.hasNext()) {
                Location location = (Location) it.next();
                HashMap map = new HashMap();
                map.put("provider", location.getProvider());
                map.put("accuracy", Float.valueOf(location.getAccuracy()));
                map.put("locationTime", Long.valueOf(location.getTime()));
                map.put("locationType", Integer.valueOf((location.getExtras() != null && (new C10343b(location.getExtras()).m63686h(Constant.LOCATION_SOURCE_TYPE) & 8) == 8) ? 1 : 0));
                Bundle extras = location.getExtras();
                C10343b c10343b = new C10343b(extras);
                if (extras != null) {
                    if (c10343b.m63679a("session_id")) {
                        map.put("session_id", c10343b.m63694p("session_id"));
                    }
                    if (c10343b.m63679a("vendorType")) {
                        map.put("vendorType", Integer.valueOf(c10343b.m63686h("vendorType")));
                    }
                    if (c10343b.m63679a("locateType")) {
                        map.put("locateType", c10343b.m63694p("locateType"));
                    }
                    if (c10343b.m63679a("isCache")) {
                        map.put("isCache", Boolean.valueOf(c10343b.m63681c("isCache")));
                    }
                }
                arrayList.add(map);
            }
            try {
                this.f63738a.setExt(C9542g.m59588a().toJson(arrayList));
            } catch (Exception unused) {
                C1016d.m6183c("LocationClientReport", "GsonUtil.getInstance().toJson(list) exception");
            }
        }
    }

    public C14373b(ReportBuilder reportBuilder) {
        this.f63737a = reportBuilder;
    }

    /* renamed from: a */
    public final void m85573a(String str) {
        this.f63737a.setResult(str);
        this.f63737a.setCostTime();
        C6791a.m38458h().m38467l(this.f63737a);
        C6791a.m38458h().m38468m(this.f63737a);
        this.f63737a.setCallTime();
    }

    /* renamed from: b */
    public final void m85574b(String str) {
        this.f63737a.setErrorCode(str);
        this.f63737a.setCostTime();
        C6791a.m38458h().m38467l(this.f63737a);
        C6791a.m38458h().m38468m(this.f63737a);
    }
}
