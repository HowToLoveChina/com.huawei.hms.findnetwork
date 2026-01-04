package p509o4;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.ServiceDiscovery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p484n4.C11632a;
import p484n4.InterfaceC11633b;

/* renamed from: o4.c */
/* loaded from: classes.dex */
public class C11816c {

    /* renamed from: a */
    public final Context f54715a;

    /* renamed from: o4.c$b */
    public static class b implements Serializable, Comparator<Map.Entry<String, Integer>> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    public C11816c(Context context) {
        this.f54715a = context;
    }

    /* renamed from: a */
    public List<C11632a> m70382a() throws PackageManager.NameNotFoundException, ClassNotFoundException {
        Log.i("AGC_Registrar", "getServices");
        List<String> listM70384c = m70384c();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listM70384c.iterator();
        while (it.hasNext()) {
            InterfaceC11633b interfaceC11633bM70383b = m70383b(it.next());
            if (interfaceC11633bM70383b != null) {
                interfaceC11633bM70383b.m69500a(this.f54715a);
                List<C11632a> listM69501b = interfaceC11633bM70383b.m69501b(this.f54715a);
                if (listM69501b != null) {
                    arrayList.addAll(listM69501b);
                }
            }
        }
        Log.i("AGC_Registrar", "services:" + arrayList.size());
        return arrayList;
    }

    /* renamed from: b */
    public final <T extends InterfaceC11633b> T m70383b(String str) throws ClassNotFoundException {
        StringBuilder sb2;
        String string;
        try {
            Class<?> cls = Class.forName(str);
            if (InterfaceC11633b.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("AGC_Registrar", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e10) {
            string = "Can not found service class, " + e10.getMessage();
            Log.e("AGC_Registrar", string);
            return null;
        } catch (IllegalAccessException e11) {
            e = e11;
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            sb2.append(e.getLocalizedMessage());
            string = sb2.toString();
            Log.e("AGC_Registrar", string);
            return null;
        } catch (InstantiationException e12) {
            e = e12;
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            sb2.append(e.getLocalizedMessage());
            string = sb2.toString();
            Log.e("AGC_Registrar", string);
            return null;
        }
    }

    /* renamed from: c */
    public final List<String> m70384c() throws PackageManager.NameNotFoundException {
        StringBuilder sb2;
        ArrayList arrayList = new ArrayList();
        Bundle bundleM70385d = m70385d();
        if (bundleM70385d == null) {
            return arrayList;
        }
        HashMap map = new HashMap(10);
        for (String message : bundleM70385d.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(bundleM70385d.getString(message))) {
                String[] strArrSplit = message.split(":");
                if (strArrSplit.length == 2) {
                    try {
                        map.put(strArrSplit[0], Integer.valueOf(strArrSplit[1]));
                    } catch (NumberFormatException e10) {
                        sb2 = new StringBuilder();
                        sb2.append("registrar configuration format error:");
                        message = e10.getMessage();
                    }
                } else if (strArrSplit.length == 1) {
                    map.put(strArrSplit[0], 1000);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("registrar configuration error, ");
                    sb2.append(message);
                    Log.e("AGC_Registrar", sb2.toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(map.entrySet());
        Collections.sort(arrayList2, new b());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    /* renamed from: d */
    public final Bundle m70385d() throws PackageManager.NameNotFoundException {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f54715a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f54715a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("AGC_Registrar", "get ServiceDiscovery exception." + e10.getLocalizedMessage());
        }
        if (serviceInfo != null) {
            return serviceInfo.metaData;
        }
        Log.e("AGC_Registrar", "Can not found ServiceDiscovery service.");
        return null;
    }
}
