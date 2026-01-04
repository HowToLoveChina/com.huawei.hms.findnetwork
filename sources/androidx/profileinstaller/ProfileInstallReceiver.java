package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.C0819c;
import java.io.IOException;
import p695v0.ExecutorC13317e;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    /* renamed from: androidx.profileinstaller.ProfileInstallReceiver$a */
    public class C0814a implements C0819c.c {
        public C0814a() {
        }

        @Override // androidx.profileinstaller.C0819c.c
        /* renamed from: a */
        public void mo5051a(int i10, Object obj) {
            C0819c.f4269b.mo5051a(i10, obj);
        }

        @Override // androidx.profileinstaller.C0819c.c
        /* renamed from: b */
        public void mo5052b(int i10, Object obj) {
            C0819c.f4269b.mo5052b(i10, obj);
            ProfileInstallReceiver.this.setResultCode(i10);
        }
    }

    /* renamed from: a */
    public static void m5050a(C0819c.c cVar) {
        Process.sendSignal(Process.myPid(), 10);
        cVar.mo5052b(12, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException, IOException {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            C0819c.m5091k(context, new ExecutorC13317e(), new C0814a(), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    C0819c.m5092l(context, new ExecutorC13317e(), new C0814a());
                    return;
                } else {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        C0819c.m5083c(context, new ExecutorC13317e(), new C0814a());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            m5050a(new C0814a());
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        C0814a c0814a = new C0814a();
        if ("DROP_SHADER_CACHE".equals(string2)) {
            C0817a.m5064b(context, c0814a);
        } else {
            c0814a.mo5052b(16, null);
        }
    }
}
