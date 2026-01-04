package kr;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p531or.C11991a;
import p852zq.AbstractC14365f;

/* renamed from: kr.a */
/* loaded from: classes8.dex */
public final class C11144a {

    /* renamed from: a */
    public LocationManager f52484a;

    public C11144a() {
        Object systemService = C11991a.m72145a().getSystemService(JsbMapKeyNames.H5_LOC);
        if (systemService instanceof LocationManager) {
            this.f52484a = (LocationManager) systemService;
        }
    }

    /* renamed from: a */
    public final synchronized void m67050a(RequestLocationUpdatesRequest requestLocationUpdatesRequest, AbstractC14365f abstractC14365f) {
        String str;
        String str2;
        if (requestLocationUpdatesRequest == null || abstractC14365f == null) {
            C1016d.m6183c("NativeNetworkProvider", "requestLocationFromNative, illegal argument");
            return;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequest.getLocationRequest();
        if (locationRequest == null) {
            C1016d.m6183c("NativeNetworkProvider", "requestLocationFromNative, illegal argument");
            return;
        }
        int priority = locationRequest.getPriority();
        String str3 = (priority == 100 || priority == 102 || priority == 104 || priority == 300 || priority == 400) ? "network" : "";
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        long jMin = Math.min(locationRequest.getInterval(), Long.MAX_VALUE);
        float fMin = Math.min(locationRequest.getSmallestDisplacement(), Float.MAX_VALUE);
        try {
            try {
                try {
                    try {
                        try {
                            m67053d(abstractC14365f, locationRequest, str3, jMin, fMin);
                        } catch (ClassNotFoundException unused) {
                            C1016d.m6183c("NativeNetworkProvider", "requestLocationByNative ClassNotFoundException");
                            m67051b(str3, jMin, fMin, abstractC14365f);
                        } catch (SecurityException unused2) {
                            str = "NativeNetworkProvider";
                            str2 = "requestLocationByNative SecurityException";
                            C1016d.m6183c(str, str2);
                        }
                    } catch (NoSuchMethodException unused3) {
                        C1016d.m6183c("NativeNetworkProvider", "requestLocationByNative NoSuchMethodException");
                        m67051b(str3, jMin, fMin, abstractC14365f);
                    } catch (Exception unused4) {
                        str = "NativeNetworkProvider";
                        str2 = "requestLocationByNative other exception";
                        C1016d.m6183c(str, str2);
                    }
                } catch (InvocationTargetException unused5) {
                    C1016d.m6183c("NativeNetworkProvider", "requestLocationByNative InvocationTargetException");
                    m67051b(str3, jMin, fMin, abstractC14365f);
                }
            } catch (InstantiationException unused6) {
                C1016d.m6183c("NativeNetworkProvider", "requestLocationByNative InstantiationException");
                m67051b(str3, jMin, fMin, abstractC14365f);
            }
        } catch (IllegalAccessException unused7) {
            C1016d.m6183c("NativeNetworkProvider", "requestLocationByNative IllegalAccessException");
            m67051b(str3, jMin, fMin, abstractC14365f);
        }
    }

    /* renamed from: b */
    public final void m67051b(String str, long j10, float f10, AbstractC14365f abstractC14365f) {
        String str2;
        C1016d.m6186f("NativeNetworkProvider", "requestLocationByAPI: provider: " + str + ", minTime: " + j10 + ", minDistance: " + f10);
        try {
            this.f52484a.requestLocationUpdates(str, j10, f10, abstractC14365f, Looper.getMainLooper());
        } catch (IllegalArgumentException unused) {
            str2 = "deratedRequest IllegalArgumentException";
            C1016d.m6183c("LocationManagerAdapter", str2);
        } catch (SecurityException unused2) {
            str2 = "deratedRequest SecurityException";
            C1016d.m6183c("LocationManagerAdapter", str2);
        } catch (Exception unused3) {
            str2 = "deratedRequest other exception";
            C1016d.m6183c("LocationManagerAdapter", str2);
        }
    }

    /* renamed from: c */
    public final synchronized void m67052c(AbstractC14365f abstractC14365f) {
        String str;
        String str2;
        try {
            this.f52484a.removeUpdates(abstractC14365f);
        } catch (IllegalArgumentException unused) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, IllegalArgumentException";
            C1016d.m6183c(str, str2);
        } catch (SecurityException unused2) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, SecurityException";
            C1016d.m6183c(str, str2);
        } catch (Exception unused3) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, other exception";
            C1016d.m6183c(str, str2);
        }
    }

    /* renamed from: d */
    public final void m67053d(AbstractC14365f abstractC14365f, LocationRequest locationRequest, String str, long j10, float f10) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C1016d.m6186f("NativeNetworkProvider", "requestLocationByNative begin: " + locationRequest.toString());
        Class<?> cls = Class.forName("android.location.LocationRequest");
        Object objNewInstance = cls.newInstance();
        Class cls2 = Long.TYPE;
        Method method = cls.getMethod("createFromDeprecatedProvider", String.class, cls2, Float.TYPE, Boolean.TYPE);
        Method method2 = cls.getMethod("setFastestInterval", cls2);
        Method method3 = cls.getMethod("setExpireAt", cls2);
        Class cls3 = Integer.TYPE;
        LocationManager.class.getMethod("requestLocationUpdates", cls, LocationListener.class, Looper.class).invoke(this.f52484a, cls.getMethod("setQuality", cls3).invoke(cls.getMethod("setProvider", String.class).invoke(method2.invoke(cls.getMethod("setNumUpdates", cls3).invoke(method3.invoke(method.invoke(objNewInstance, str, Long.valueOf(j10), Float.valueOf(f10), Boolean.FALSE), Long.valueOf(locationRequest.getExpirationTime())), Integer.valueOf(locationRequest.getNumUpdates())), Long.valueOf(locationRequest.getFastestInterval())), str), Integer.valueOf(locationRequest.getPriority())), abstractC14365f, Looper.getMainLooper());
    }
}
