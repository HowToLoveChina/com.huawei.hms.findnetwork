package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.InterfaceC1605c;

/* renamed from: com.bumptech.glide.manager.f */
/* loaded from: classes.dex */
public class C1608f implements InterfaceC1606d {
    @Override // com.bumptech.glide.manager.InterfaceC1606d
    /* renamed from: a */
    public InterfaceC1605c mo9188a(Context context, InterfaceC1605c.a aVar) {
        boolean z10 = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z10 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z10 ? new C1607e(context, aVar) : new C1617o();
    }
}
