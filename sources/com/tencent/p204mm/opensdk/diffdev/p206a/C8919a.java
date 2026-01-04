package com.tencent.p204mm.opensdk.diffdev.p206a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.p204mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.p204mm.opensdk.diffdev.OAuthListener;
import com.tencent.p204mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
/* loaded from: classes9.dex */
public final class C8919a implements IDiffDevOAuth {

    /* renamed from: d */
    private AsyncTaskC8922d f45400d;
    private Handler handler = null;

    /* renamed from: c */
    private List<OAuthListener> f45399c = new ArrayList();

    /* renamed from: e */
    private OAuthListener f45401e = new C8920b(this);

    /* renamed from: c */
    public static /* synthetic */ AsyncTaskC8922d m56628c(C8919a c8919a) {
        c8919a.f45400d = null;
        return null;
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.IDiffDevOAuth
    public final void addListener(OAuthListener oAuthListener) {
        if (this.f45399c.contains(oAuthListener)) {
            return;
        }
        this.f45399c.add(oAuthListener);
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.m56640i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.m56638d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.f45400d != null) {
            Log.m56638d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        AsyncTaskC8922d asyncTaskC8922d = new AsyncTaskC8922d(str, str2, str3, str4, str5, this.f45401e);
        this.f45400d = asyncTaskC8922d;
        asyncTaskC8922d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.IDiffDevOAuth
    public final void detach() {
        Log.m56640i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f45399c.clear();
        stopAuth();
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeAllListeners() {
        this.f45399c.clear();
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeListener(OAuthListener oAuthListener) {
        this.f45399c.remove(oAuthListener);
    }

    @Override // com.tencent.p204mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean stopAuth() {
        boolean zM56629a;
        Log.m56640i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            AsyncTaskC8922d asyncTaskC8922d = this.f45400d;
            zM56629a = asyncTaskC8922d == null ? true : asyncTaskC8922d.m56629a();
        } catch (Exception e10) {
            Log.m56642w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e10.getMessage());
            zM56629a = false;
        }
        this.f45400d = null;
        return zM56629a;
    }
}
