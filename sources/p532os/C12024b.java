package p532os;

import android.content.Context;
import android.content.Intent;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;

/* renamed from: os.b */
/* loaded from: classes8.dex */
public final class C12024b extends SafeBroadcastReceiver {

    /* renamed from: k */
    public final /* synthetic */ C12023a f55791k;

    public C12024b(C12023a c12023a) {
        this.f55791k = c12023a;
    }

    @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
    public final void onReceiveMsg(Context context, Intent intent) {
        if (this.f55791k.f55790e) {
            return;
        }
        C12023a.m72148c(this.f55791k, intent);
    }
}
