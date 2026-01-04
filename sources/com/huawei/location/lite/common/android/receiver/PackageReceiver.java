package com.huawei.location.lite.common.android.receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeString;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import p531or.C11991a;
import pr.InterfaceC12209b;

/* loaded from: classes8.dex */
public class PackageReceiver extends SafeBroadcastReceiver {

    /* renamed from: e */
    public static final byte[] f31331e = new byte[0];

    /* renamed from: f */
    public static volatile PackageReceiver f31332f;

    /* renamed from: c */
    public AtomicBoolean f31333c = new AtomicBoolean(false);

    /* renamed from: d */
    public List<InterfaceC12209b> f31334d = new CopyOnWriteArrayList();

    /* renamed from: g */
    public static PackageReceiver m38376g() {
        if (f31332f == null) {
            synchronized (f31331e) {
                try {
                    if (f31332f == null) {
                        f31332f = new PackageReceiver();
                    }
                } finally {
                }
            }
        }
        return f31332f;
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    /* renamed from: d */
    public void mo38377d(Intent intent) {
        if (intent == null) {
            C1016d.m6183c("PackageReceiver", "PackageReceiver receive null intent");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String dataString = safeIntent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            dataString = "";
        }
        String strReplace = SafeString.replace(dataString, "package:", "");
        if ("android.intent.action.PACKAGE_REMOVED".equals(safeIntent.getAction())) {
            C1016d.m6181a("PackageReceiver", "package_remove:" + strReplace);
            for (InterfaceC12209b interfaceC12209b : this.f31334d) {
                if (interfaceC12209b != null) {
                    interfaceC12209b.mo59557a(strReplace);
                }
            }
            return;
        }
        if ("android.intent.action.PACKAGE_ADDED".equals(safeIntent.getAction())) {
            C1016d.m6181a("PackageReceiver", "package_add:" + strReplace);
            for (InterfaceC12209b interfaceC12209b2 : this.f31334d) {
                if (interfaceC12209b2 != null) {
                    interfaceC12209b2.mo59558b(strReplace);
                }
            }
            return;
        }
        if (!"android.intent.action.PACKAGE_REPLACED".equals(safeIntent.getAction())) {
            C1016d.m6181a("PackageReceiver", "action ===:" + safeIntent.getAction());
            return;
        }
        C1016d.m6181a("PackageReceiver", "package_replace:" + strReplace);
        for (InterfaceC12209b interfaceC12209b3 : this.f31334d) {
            if (interfaceC12209b3 != null) {
                interfaceC12209b3.mo59559c(strReplace);
            }
        }
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    /* renamed from: e */
    public String mo38378e() {
        return "Loc_Package_Listener";
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    /* renamed from: f */
    public int mo38379f() {
        return 0;
    }

    /* renamed from: h */
    public final IntentFilter m38380h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    /* renamed from: i */
    public void m38381i(InterfaceC12209b interfaceC12209b) {
        if (interfaceC12209b != null) {
            this.f31334d.add(interfaceC12209b);
        }
        if (this.f31333c.get()) {
            return;
        }
        C11991a.m72145a().registerReceiver(m38376g(), m38380h());
        this.f31333c.set(true);
    }
}
