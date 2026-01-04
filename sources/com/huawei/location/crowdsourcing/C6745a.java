package com.huawei.location.crowdsourcing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import as.C1016d;
import br.InterfaceC1273a;
import com.huawei.location.activity.C6738e;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.location.crowdsourcing.a */
/* loaded from: classes8.dex */
public final class C6745a implements InterfaceC1273a {

    /* renamed from: g */
    public static int f31262g;

    /* renamed from: a */
    public final b f31263a;

    /* renamed from: b */
    public final C6746b f31264b;

    /* renamed from: c */
    public int f31265c;

    /* renamed from: d */
    public final File f31266d;

    /* renamed from: e */
    public byte[] f31267e;

    /* renamed from: f */
    public a f31268f;

    /* renamed from: com.huawei.location.crowdsourcing.a$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (action == null) {
                C1016d.m6183c("Recorder", "get null action");
                return;
            }
            if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                C1016d.m6183c("Recorder", "receive unknown action,action:".concat(action));
                return;
            }
            C1016d.m6186f("Recorder", "onReceive action=".concat(action));
            NetworkInfo networkInfo = (NetworkInfo) safeIntent.getParcelableExtra("networkInfo");
            if (networkInfo == null) {
                C1016d.m6183c("Recorder", "no EXTRA_NETWORK_INFO");
            } else if (networkInfo.isConnected() && networkInfo.getType() == 1) {
                C6745a.this.f31263a.obtainMessage(0).sendToTarget();
            }
        }

        public /* synthetic */ a(C6745a c6745a, int i10) {
            this();
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.a$b */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) throws IOException {
            if (message.what == 0) {
                C6745a.m38322g(C6745a.this);
                return;
            }
            C1016d.m6183c("Recorder", "unknown msg:" + message.what);
        }
    }

    public C6745a(Looper looper, String str) {
        this.f31263a = new b(looper);
        this.f31264b = new C6746b(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        this.f31266d = new File(C6738e.m38291a(sb2, File.separator, "crowdsourcing_record"));
    }

    /* renamed from: g */
    public static void m38322g(C6745a c6745a) throws IOException {
        c6745a.getClass();
        C1016d.m6186f("Recorder", "wifi connected, try upload");
        c6745a.m38324c();
    }

    @Override // br.InterfaceC1273a
    /* renamed from: a */
    public final void mo7544a() {
        C1016d.m6190j("Recorder", "Stop");
        a aVar = this.f31268f;
        if (aVar != null) {
            C6747c.m38332b().unregisterReceiver(aVar);
        }
        this.f31264b.getClass();
        C1016d.m6190j("Uploader", "Stop");
    }

    /* renamed from: b */
    public final boolean m38323b() {
        String str;
        File file = this.f31266d;
        if (file.exists()) {
            if (file.isFile()) {
                if (!file.canWrite()) {
                    str = "file can not write";
                    C1016d.m6183c("FileUtil", str);
                    C1016d.m6183c("Recorder", "regularize file failed");
                    return false;
                }
            } else if (!file.delete()) {
                str = "file delete failed";
                C1016d.m6183c("FileUtil", str);
                C1016d.m6183c("Recorder", "regularize file failed");
                return false;
            }
        }
        if (!this.f31264b.m38329d()) {
            C1016d.m6183c("Recorder", "uploader init failed");
            return false;
        }
        a aVar = new a(this, 0);
        this.f31268f = aVar;
        C6747c.m38332b().registerReceiver(aVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        C1016d.m6186f("Recorder", "wifi connect register success");
        return true;
    }

    /* renamed from: c */
    public final void m38324c() throws IOException {
        if (!this.f31266d.exists()) {
            C1016d.m6186f("Recorder", "file not exists, not upload");
            return;
        }
        try {
            if (!this.f31264b.m38330e(this.f31266d.getCanonicalPath())) {
                C1016d.m6186f("Recorder", "not upload file");
            } else if (!this.f31266d.delete()) {
                C1016d.m6183c("Recorder", "upload file success but delete file failed");
            } else {
                C1016d.m6186f("Recorder", "upload file success and delete file success");
                this.f31265c = 0;
            }
        } catch (IOException unused) {
            C1016d.m6183c("Recorder", "get path failed");
        }
    }

    /* renamed from: e */
    public final void m38325e() {
        File file = this.f31266d;
        if (file == null || !file.delete()) {
            return;
        }
        C1016d.m6190j("Recorder", "clear file success");
        this.f31265c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x015e  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m38326f(android.location.Location r7, java.util.List<android.net.wifi.ScanResult> r8, java.util.List<cr.C8944a> r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.C6745a.m38326f(android.location.Location, java.util.List, java.util.List):void");
    }
}
