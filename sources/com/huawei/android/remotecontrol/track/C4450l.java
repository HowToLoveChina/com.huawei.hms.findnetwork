package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.content.SharedPreferences;
import bf.C1175a;
import p013ah.C0198c;
import p015ak.C0214f0;
import p015ak.C0224k0;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.track.l */
/* loaded from: classes4.dex */
public class C4450l {
    /* renamed from: a */
    public static void m27005a(Context context) {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.remove("track_last_mark_time");
        editorEdit.remove("track_last_mark_map_type");
        editorEdit.remove("track_last_mark_longtitude");
        editorEdit.remove("track_last_mark_latitude");
        editorEdit.remove("track_last_mark_longtitude_WGS");
        editorEdit.remove("track_last_mark_latitude_WGS");
        editorEdit.remove("track_last_mark_floor");
        editorEdit.remove("track_last_mark_floor_acc");
        editorEdit.remove("track_last_mark_location_time");
        editorEdit.remove("track_last_mark_location_router");
        editorEdit.commit();
    }

    /* renamed from: b */
    public static long m27006b(Context context) {
        return C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).getLong("track_imme_mark_time", 0L);
    }

    /* renamed from: c */
    public static long m27007c(Context context) {
        return C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).getLong("track_conf_trackmindistance", 100L);
    }

    /* renamed from: d */
    public static String m27008d(Context context) {
        return C0198c.m1097a(context, C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).getString("track_conf_sessionID", ""));
    }

    /* renamed from: e */
    public static long m27009e(Context context) {
        return C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).getLong("track_conf_trackperiod", 1800000L);
    }

    /* renamed from: f */
    public static boolean m27010f(Context context) {
        return C1175a.m7389k(context);
    }

    /* renamed from: g */
    public static boolean m27011g(Context context) {
        return C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).getBoolean("track_conf_isworking", false);
    }

    /* renamed from: h */
    public static void m27012h(Context context) {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.remove("track_imme_mark_time");
        editorEdit.commit();
    }

    /* renamed from: i */
    public static void m27013i(Context context, int i10) {
        if (i10 <= 0) {
            return;
        }
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.putLong("track_conf_trackmindistance", i10);
        editorEdit.commit();
    }

    /* renamed from: j */
    public static void m27014j(Context context, String str) {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.putString("track_conf_sessionID", C0198c.m1098b(context, str));
        editorEdit.commit();
    }

    /* renamed from: k */
    public static void m27015k(Context context, boolean z10) {
        try {
            C13981a.m83989i("TrackSpConfig", "SystemProperties set begin,isTrackWorking:" + z10);
            if (z10) {
                C0224k0.a.m1576e("persist.radio.findmyphone", "1");
            } else {
                C0224k0.a.m1576e("persist.radio.findmyphone", "0");
            }
            C13981a.m83989i("TrackSpConfig", "SystemProperties set begin,SystemProperties.get:" + C0224k0.a.m1572a("persist.radio.findmyphone"));
        } catch (RuntimeException unused) {
            C13981a.m83988e("TrackSpConfig", "SystemProperties set RuntimeException");
        } catch (Exception unused2) {
            C13981a.m83988e("TrackSpConfig", "SystemProperties set exception");
        }
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.putBoolean("track_conf_isworking", z10);
        editorEdit.commit();
    }

    /* renamed from: l */
    public static void m27016l(Context context, long j10) {
        if (j10 <= 0) {
            C13981a.m83988e("TrackSpConfig", "setTrackperiod fail, trackperiod < 0");
            return;
        }
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.putLong("track_conf_trackperiod", j10 * 60000);
        editorEdit.commit();
    }

    /* renamed from: m */
    public static LocateTrackEvent m27017m(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0);
        String string = sharedPreferencesM1382b.getString("track_last_mark_map_type", null);
        if (string == null) {
            return null;
        }
        LocateTrackEvent locateTrackEvent = new LocateTrackEvent();
        locateTrackEvent.setTrackMaptype(C0198c.m1097a(context, string));
        locateTrackEvent.setTrackLatitude(C0198c.m1097a(context, sharedPreferencesM1382b.getString("track_last_mark_latitude", null)));
        locateTrackEvent.setTrackLongtitude(C0198c.m1097a(context, sharedPreferencesM1382b.getString("track_last_mark_longtitude", null)));
        locateTrackEvent.setTrackLatitudeWGS(C0198c.m1097a(context, sharedPreferencesM1382b.getString("track_last_mark_latitude_WGS", null)));
        locateTrackEvent.setFloor(C0198c.m1097a(context, sharedPreferencesM1382b.getString("track_last_mark_floor", null)));
        locateTrackEvent.setFloorAcc(C0198c.m1097a(context, sharedPreferencesM1382b.getString("track_last_mark_floor_acc", null)));
        locateTrackEvent.setLocationRouter(sharedPreferencesM1382b.getInt("track_last_mark_location_time", 0));
        locateTrackEvent.setLocationTime(sharedPreferencesM1382b.getInt("track_last_mark_location_router", 0));
        locateTrackEvent.setLocCpTransId(sharedPreferencesM1382b.getString("track_last_mark_loc_cp_trans_id", null));
        locateTrackEvent.setLocSessionId(sharedPreferencesM1382b.getString("track_last_mark_loc_session_id", null));
        locateTrackEvent.setLocFenceTime(sharedPreferencesM1382b.getString("track_last_mark_loc_fence_time", null));
        locateTrackEvent.setTrackLongtitudeWGS(C0198c.m1097a(context, sharedPreferencesM1382b.getString("track_last_mark_longtitude_WGS", null)));
        locateTrackEvent.setTrackUTC(sharedPreferencesM1382b.getLong("track_last_mark_time", 0L));
        return locateTrackEvent;
    }

    /* renamed from: n */
    public static void m27018n(Context context) {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.putLong("track_imme_mark_time", C4452n.m27024d());
        editorEdit.commit();
    }

    /* renamed from: o */
    public static void m27019o(Context context, LocateTrackEvent locateTrackEvent) {
        if (locateTrackEvent == null) {
            C13981a.m83988e("TrackSpConfig", "updateTrackMarkConf fail, locateTrackEvent = null");
            return;
        }
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.putLong("track_last_mark_time", locateTrackEvent.getTrackUTC());
        editorEdit.putString("track_last_mark_map_type", C0198c.m1098b(context, locateTrackEvent.getTrackMaptype()));
        editorEdit.putString("track_last_mark_floor", C0198c.m1098b(context, locateTrackEvent.getFloor()));
        editorEdit.putString("track_last_mark_floor_acc", locateTrackEvent.getFloorAcc());
        editorEdit.putInt("track_last_mark_location_router", locateTrackEvent.getLocationRouter());
        editorEdit.putInt("track_last_mark_location_time", locateTrackEvent.getLocationTime());
        editorEdit.putString("track_last_mark_loc_cp_trans_id", locateTrackEvent.getLocCpTransId());
        editorEdit.putString("track_last_mark_loc_session_id", locateTrackEvent.getLocSessionId());
        editorEdit.putString("track_last_mark_loc_fence_time", locateTrackEvent.getLocFenceTime());
        editorEdit.putString("track_last_mark_longtitude", C0198c.m1098b(context, locateTrackEvent.getTrackLongtitude()));
        editorEdit.putString("track_last_mark_latitude", C0198c.m1098b(context, locateTrackEvent.getTrackLatitude()));
        editorEdit.putString("track_last_mark_longtitude_WGS", C0198c.m1098b(context, locateTrackEvent.getTrackLongtitudeWGS()));
        editorEdit.putString("track_last_mark_latitude_WGS", C0198c.m1098b(context, locateTrackEvent.getTrackLatitudeWGS()));
        editorEdit.commit();
    }

    /* renamed from: p */
    public static void m27020p(Context context) {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.trackconf", 0).edit();
        editorEdit.putLong("track_task_mark_time", C4452n.m27024d());
        editorEdit.commit();
    }
}
