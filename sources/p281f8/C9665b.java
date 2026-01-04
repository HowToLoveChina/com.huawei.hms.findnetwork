package p281f8;

import android.content.Context;
import android.content.Intent;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1136q;
import p664u0.C13108a;

/* renamed from: f8.b */
/* loaded from: classes2.dex */
public class C9665b {
    /* renamed from: a */
    public static void m60344a(int i10) {
        C1120a.m6677i("BroadcastDispatcher", "notifyGalleryAccountStateChanged accountState: " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.ACCOUNT_STATE_CHANGED");
        intent.putExtra("AccountState", i10);
        m60350g(intent);
    }

    /* renamed from: b */
    public static void m60345b() {
        C1120a.m6677i("BroadcastDispatcher", "notifyGallerySpaceSizeChanged");
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.SPACE_DELETED_CHANGED");
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: c */
    public static void m60346c() {
        C1120a.m6677i("BroadcastDispatcher", "notifyGalleryStartReDownload ");
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.POWER_START_RE_DOWNLOAD");
        m60350g(intent);
    }

    /* renamed from: d */
    public static void m60347d(int i10, int i11) {
        C1120a.m6677i("BroadcastDispatcher", "notifyGalleryStartSync module: " + i10 + ", syncType: " + i11);
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.CAN_START_SYNC");
        intent.putExtra("Module", i10);
        intent.putExtra("SyncType", i11);
        m60350g(intent);
    }

    /* renamed from: e */
    public static void m60348e(int i10, int i11, String str) {
        C1120a.m6677i("BroadcastDispatcher", "notifyGalleryStartSync module: " + i10 + ", syncType: " + i11 + ", prepareTraceId: " + str);
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.CAN_START_SYNC");
        intent.putExtra("Module", i10);
        intent.putExtra("SyncType", i11);
        intent.putExtra("prepareTraceId", str);
        m60350g(intent);
    }

    /* renamed from: f */
    public static void m60349f(Context context, int i10) {
        C1120a.m6677i("BroadcastDispatcher", "notifyGallerySwitchChanged switchState: " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.CLOUD_ALBUM_SWITCH_CHANGED");
        intent.putExtra("SwitchState", i10);
        if (i10 == 1) {
            intent.putExtra("DefaultAutoUploadMaxNum", C1136q.b.m7068j(context));
            intent.putExtra("DefaultAutoDownloadMaxNumLong", C1136q.b.m7071k(context));
            intent.putExtra("DefaultAutoDownloadMaxNum", C1136q.b.m7062h(context));
            intent.putExtra("DefaultAutoDownloadMaxNumLimit", C1136q.b.m7037Y(context));
        }
        m60350g(intent);
    }

    /* renamed from: g */
    public static void m60350g(Intent intent) {
        if (intent == null) {
            C1120a.m6676e("BroadcastDispatcher", "sendBroadCastToGallery3D intent is null");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1120a.m6676e("BroadcastDispatcher", "sendBroadCastToGallery3D context is null");
        } else {
            contextM1377a.sendBroadcast(intent, "com.huawei.cg.permission.BROADCAST");
        }
    }
}
