package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.remotecontrol.http.C4347e;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0219i;
import p774xg.C13811a;
import p774xg.C13812b;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: com.huawei.android.remotecontrol.track.b */
/* loaded from: classes4.dex */
public class C4440b {

    /* renamed from: b */
    public static String f20363b;

    /* renamed from: a */
    public static ArrayList<LocateTrackObject> f20362a = new ArrayList<>();

    /* renamed from: c */
    public static int f20364c = -1;

    /* renamed from: b */
    public static void m26932b(LocateTrackObject locateTrackObject) {
        if (locateTrackObject != null) {
            f20362a.add(locateTrackObject);
        }
    }

    /* renamed from: c */
    public static void m26933c(Context context) {
        if (f20363b == null) {
            f20363b = C13811a.m82806c(context);
        }
        C13981a.m83987d("LocateTrackFactory", "track locateConf is:" + f20363b);
    }

    /* renamed from: d */
    public static void m26934d(Context context) {
        if (f20364c == -1) {
            f20364c = C13811a.m82819p(context);
        }
        C13981a.m83987d("LocateTrackFactory", "track cacheHighAccuracyConfirm is:" + f20364c);
    }

    /* renamed from: e */
    public static LocateTrackObject m26935e(int i10, Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        LocateTrackObject googleLocateTrack;
        C13981a.m83989i("LocateTrackFactory", "LocateTrackTask run getLocateTrack,siteId:" + i10);
        m26934d(context);
        m26933c(context);
        C13811a.m82786D(context);
        C13811a.m82788F(context);
        C13811a.m82787E(context, true, "track_locate");
        boolean zM82847r = C13812b.m82847r(context, "network");
        boolean zM82846q = C13812b.m82846q(context);
        if (AbstractC12139d.m72769h(context)) {
            m26938h(context);
        }
        C13811a.m82812i(true);
        C13811a.m82813j(context, false);
        C13811a.m82803U(context);
        if (!AbstractC12139d.m72769h(context)) {
            C13981a.m83989i("LocateTrackFactory", "LocateTrackTask run -> G_Locate.");
            googleLocateTrack = new GoogleLocateTrack(context);
        } else if (zM82847r || zM82846q) {
            C13981a.m83989i("LocateTrackFactory", "isRebootLocked:" + C4347e.m26239j(context));
            C13981a.m83989i("LocateTrackFactory", "isNetWorkConnected:" + C0209d.m1333z1(context));
            if (C0219i.m1463a() < 16 && C0209d.m1333z1(context) && C4347e.m26239j(context)) {
                C13981a.m83989i("LocateTrackFactory", "hasNetWorkCapacity is true,System reboot unpresent -> bd loc.");
                googleLocateTrack = new BaiduLocateTrack(context);
            } else {
                C13981a.m83989i("LocateTrackFactory", "hasNetWorkCapacity is true,LocateTrackTask run -> G_Locate.");
                googleLocateTrack = new GoogleLocateTrack(context);
            }
        } else {
            C13981a.m83989i("LocateTrackFactory", "hasNetWorkCapacity is false,LocateTrackTask run -> bd loc.");
            googleLocateTrack = new BaiduLocateTrack(context);
        }
        m26932b(googleLocateTrack);
        return googleLocateTrack;
    }

    /* renamed from: f */
    public static boolean m26936f() {
        return f20362a.size() != 0;
    }

    /* renamed from: g */
    public static /* synthetic */ void m26937g(Context context) {
        if (C13812b.m82847r(context, "network")) {
            return;
        }
        C13981a.m83989i("LocateTrackFactory", "lbs provider off -> bd loc.");
        BaiduLocateTrack baiduLocateTrack = new BaiduLocateTrack(context);
        baiduLocateTrack.mo26868f();
        m26932b(baiduLocateTrack);
    }

    /* renamed from: h */
    public static void m26938h(final Context context) {
        new Handler().postDelayed(new Runnable() { // from class: com.huawei.android.remotecontrol.track.a
            @Override // java.lang.Runnable
            public final void run() {
                C4440b.m26937g(context);
            }
        }, 3000L);
    }

    /* renamed from: i */
    public static void m26939i(Context context, LocateTrackObject locateTrackObject) {
        if (locateTrackObject == null || f20362a.size() <= 0) {
            return;
        }
        f20362a.remove(locateTrackObject);
        if (f20362a.size() == 0) {
            m26940j(context);
            m26941k(context);
        }
    }

    /* renamed from: j */
    public static void m26940j(Context context) {
        C13981a.m83987d("LocateTrackFactory", "track locateConf is:" + f20363b);
        C13811a.m82792J(context, f20363b, true);
        f20363b = null;
        if (C4450l.m27011g(context)) {
            return;
        }
        C13811a.m82796N(context, true);
    }

    /* renamed from: k */
    public static void m26941k(Context context) {
        C13981a.m83987d("LocateTrackFactory", "track resetHighAccuracyConfirm is:" + f20364c);
        C13811a.m82794L(context, f20364c);
        f20364c = -1;
        if (C4450l.m27011g(context)) {
            return;
        }
        C13811a.m82793K(context);
    }
}
