package com.huawei.hms.locationSdk;

import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.locationSdk.v0 */
/* loaded from: classes8.dex */
public class C5762v0 {

    /* renamed from: b */
    private HWLocation f25584b;

    /* renamed from: d */
    private int f25586d;

    /* renamed from: e */
    private boolean f25587e;

    /* renamed from: a */
    private final AtomicBoolean f25583a = new AtomicBoolean(false);

    /* renamed from: c */
    private List<String> f25585c = new ArrayList();

    /* renamed from: a */
    private int m33179a(String str, Map<String, Object> map) {
        Object objRemove = map.remove(str);
        if (objRemove != null && (objRemove instanceof Integer)) {
            return ((Integer) objRemove).intValue();
        }
        return -1;
    }

    /* renamed from: c */
    private String m33181c(HWLocation hWLocation) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("_");
        sb2.append(hWLocation.getTime());
        sb2.append("_");
        sb2.append(hWLocation.getBearing());
        sb2.append("_");
        sb2.append(hWLocation.getSpeed());
        sb2.append("_");
        sb2.append(hWLocation.getAccuracy());
        Map<String, Object> extraInfo = hWLocation.getExtraInfo();
        if (extraInfo == null) {
            return sb2.toString();
        }
        int iM33179a = m33179a("loc_arStatus", extraInfo);
        if (iM33179a != -1) {
            int iM33179a2 = m33179a("loc_arAcc", extraInfo);
            sb2.append("_");
            sb2.append(iM33179a);
            sb2.append("_");
            sb2.append(iM33179a2);
        }
        hWLocation.setExtraInfo(extraInfo);
        return sb2.toString();
    }

    /* renamed from: b */
    public synchronized void m33185b(HWLocation hWLocation) {
        if (!this.f25583a.get()) {
            HMSLocationLog.m36663w("LocationInfoCollector", "", "onLocationChange is not start");
            return;
        }
        if (hWLocation == null) {
            HMSLocationLog.m36660e("LocationInfoCollector", "", "HWLocation is null");
            return;
        }
        if (m33180a(hWLocation)) {
            this.f25584b = hWLocation;
            String strM33181c = m33181c(hWLocation);
            if (this.f25587e) {
                HMSLocationLog.m36662i("LocationInfoCollector", "", "onLocationChange:" + strM33181c);
            } else {
                HMSLocationLog.m36662i("LocationInfoCollector", "", "onLocationChange");
            }
            int size = this.f25585c.size();
            int i10 = this.f25586d;
            if (size == i10) {
                this.f25585c.remove(i10 - 1);
            }
            this.f25585c.add(strM33181c);
        }
    }

    /* renamed from: a */
    public String m33182a() {
        if (!this.f25583a.get() || this.f25585c.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f25585c.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(",");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        this.f25585c.clear();
        return sb2.toString();
    }

    /* renamed from: b */
    public synchronized void m33184b() {
        HMSLocationLog.m36662i("LocationInfoCollector", "", "stop");
        this.f25585c.clear();
        this.f25584b = null;
        this.f25583a.set(false);
    }

    /* renamed from: a */
    private boolean m33180a(HWLocation hWLocation) {
        if (hWLocation == null) {
            return false;
        }
        try {
            HWLocation hWLocation2 = this.f25584b;
            if (hWLocation2 == null) {
                return true;
            }
            if (TextUtils.equals(hWLocation2.getProvider(), "gps") || !TextUtils.equals(hWLocation.getProvider(), "gps")) {
                return hWLocation.getTime() - this.f25584b.getTime() >= 500;
            }
            return true;
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationInfoCollector", "", "needCache error");
            return false;
        }
    }

    /* renamed from: a */
    public synchronized boolean m33183a(int i10, Looper looper, boolean z10) {
        if (this.f25583a.get()) {
            return true;
        }
        this.f25587e = z10;
        HMSLocationLog.m36662i("LocationInfoCollector", "", "start");
        this.f25583a.set(true);
        this.f25586d = i10;
        return true;
    }
}
