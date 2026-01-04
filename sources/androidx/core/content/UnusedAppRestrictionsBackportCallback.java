package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
public class UnusedAppRestrictionsBackportCallback {
    private IUnusedAppRestrictionsBackportCallback mCallback;

    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        this.mCallback = iUnusedAppRestrictionsBackportCallback;
    }

    public void onResult(boolean z10, boolean z11) throws RemoteException {
        this.mCallback.onIsPermissionRevocationEnabledForAppResult(z10, z11);
    }
}
