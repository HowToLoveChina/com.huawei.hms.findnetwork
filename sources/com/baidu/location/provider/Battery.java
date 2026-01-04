package com.baidu.location.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.location.p065a.C1534f;

/* loaded from: classes.dex */
public class Battery {

    /* renamed from: d */
    private static Battery f6686d;

    /* renamed from: a */
    private boolean f6687a = false;

    /* renamed from: b */
    private String f6688b = null;

    /* renamed from: c */
    private ScanBroadCast f6689c = null;

    /* renamed from: e */
    private int f6690e = -1;

    /* renamed from: f */
    private Context f6691f;

    public class ScanBroadCast extends BroadcastReceiver {
        public ScanBroadCast() {
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #0 {Exception -> 0x0075, blocks: (B:3:0x0005, B:5:0x000d, B:8:0x0030, B:16:0x0047, B:24:0x0060, B:25:0x0067, B:26:0x006d, B:17:0x004d, B:18:0x0051, B:19:0x0055, B:9:0x0039), top: B:30:0x0005 }] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r6, android.content.Intent r7) {
            /*
                r5 = this;
                java.lang.String r6 = r7.getAction()
                r0 = 0
                java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L75
                if (r6 == 0) goto L7a
                com.baidu.location.provider.Battery r6 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                r1 = 0
                com.baidu.location.provider.Battery.m8743a(r6, r1)     // Catch: java.lang.Exception -> L75
                java.lang.String r6 = "status"
                int r6 = r7.getIntExtra(r6, r1)     // Catch: java.lang.Exception -> L75
                java.lang.String r2 = "plugged"
                int r1 = r7.getIntExtra(r2, r1)     // Catch: java.lang.Exception -> L75
                java.lang.String r2 = "level"
                r3 = -1
                int r2 = r7.getIntExtra(r2, r3)     // Catch: java.lang.Exception -> L75
                java.lang.String r4 = "scale"
                int r7 = r7.getIntExtra(r4, r3)     // Catch: java.lang.Exception -> L75
                if (r2 <= 0) goto L39
                if (r7 <= 0) goto L39
                com.baidu.location.provider.Battery r3 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                int r2 = r2 * 100
                int r2 = r2 / r7
                com.baidu.location.provider.Battery.m8740a(r3, r2)     // Catch: java.lang.Exception -> L75
                goto L3e
            L39:
                com.baidu.location.provider.Battery r7 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                com.baidu.location.provider.Battery.m8740a(r7, r3)     // Catch: java.lang.Exception -> L75
            L3e:
                r7 = 2
                if (r6 == r7) goto L55
                r2 = 3
                if (r6 == r2) goto L4d
                r2 = 4
                if (r6 == r2) goto L4d
                com.baidu.location.provider.Battery r6 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                com.baidu.location.provider.Battery.m8742a(r6, r0)     // Catch: java.lang.Exception -> L75
                goto L5a
            L4d:
                com.baidu.location.provider.Battery r6 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                java.lang.String r2 = "3"
            L51:
                com.baidu.location.provider.Battery.m8742a(r6, r2)     // Catch: java.lang.Exception -> L75
                goto L5a
            L55:
                com.baidu.location.provider.Battery r6 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                java.lang.String r2 = "4"
                goto L51
            L5a:
                r6 = 1
                if (r1 == r6) goto L6d
                if (r1 == r7) goto L60
                goto L7a
            L60:
                com.baidu.location.provider.Battery r7 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                java.lang.String r1 = "5"
                com.baidu.location.provider.Battery.m8742a(r7, r1)     // Catch: java.lang.Exception -> L75
            L67:
                com.baidu.location.provider.Battery r7 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                com.baidu.location.provider.Battery.m8743a(r7, r6)     // Catch: java.lang.Exception -> L75
                goto L7a
            L6d:
                com.baidu.location.provider.Battery r7 = com.baidu.location.provider.Battery.this     // Catch: java.lang.Exception -> L75
                java.lang.String r1 = "6"
                com.baidu.location.provider.Battery.m8742a(r7, r1)     // Catch: java.lang.Exception -> L75
                goto L67
            L75:
                com.baidu.location.provider.Battery r5 = com.baidu.location.provider.Battery.this
                com.baidu.location.provider.Battery.m8742a(r5, r0)
            L7a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.Battery.ScanBroadCast.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    private Battery() {
    }

    /* renamed from: b */
    public void m8745b() {
        ScanBroadCast scanBroadCast = this.f6689c;
        if (scanBroadCast != null) {
            try {
                this.f6691f.unregisterReceiver(scanBroadCast);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        this.f6689c = null;
    }

    /* renamed from: c */
    public String m8746c() {
        return this.f6688b;
    }

    /* renamed from: d */
    public boolean m8747d() {
        return this.f6687a;
    }

    /* renamed from: e */
    public int m8748e() {
        return this.f6690e;
    }

    /* renamed from: a */
    public static synchronized Battery m8741a() {
        try {
            if (f6686d == null) {
                f6686d = new Battery();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f6686d;
    }

    /* renamed from: a */
    public void m8744a(Context context) {
        this.f6691f = context;
        ScanBroadCast scanBroadCast = new ScanBroadCast();
        this.f6689c = scanBroadCast;
        context.registerReceiver(scanBroadCast, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        C1534f.m8725c("battery inited");
    }
}
