package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import p464m.C11385c;

/* loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    private final Context mContext;
    C11385c<Integer> mResultFuture;
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService = null;
    private boolean mHasBoundService = false;

    /* renamed from: androidx.core.content.UnusedAppRestrictionsBackportServiceConnection$1 */
    public class BinderC06161 extends IUnusedAppRestrictionsBackportCallback.AbstractBinderC0612a {
        public BinderC06161() {
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
        public void onIsPermissionRevocationEnabledForAppResult(boolean z10, boolean z11) throws RemoteException {
            if (!z10) {
                UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.mo68264p(0);
                Log.e(PackageManagerCompat.LOG_TAG, "Unable to retrieve the permission revocation setting from the backport");
            } else if (z11) {
                UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.mo68264p(3);
            } else {
                UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.mo68264p(2);
            }
        }
    }

    public UnusedAppRestrictionsBackportServiceConnection(Context context) {
        this.mContext = context;
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new IUnusedAppRestrictionsBackportCallback.AbstractBinderC0612a() { // from class: androidx.core.content.UnusedAppRestrictionsBackportServiceConnection.1
            public BinderC06161() {
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean z10, boolean z11) throws RemoteException {
                if (!z10) {
                    UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.mo68264p(0);
                    Log.e(PackageManagerCompat.LOG_TAG, "Unable to retrieve the permission revocation setting from the backport");
                } else if (z11) {
                    UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.mo68264p(3);
                } else {
                    UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.mo68264p(2);
                }
            }
        };
    }

    public void connectAndFetchResult(C11385c<Integer> c11385c) {
        if (this.mHasBoundService) {
            throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
        }
        this.mHasBoundService = true;
        this.mResultFuture = c11385c;
        this.mContext.bindService(new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager())), this, 1);
    }

    public void disconnectFromService() {
        if (!this.mHasBoundService) {
            throw new IllegalStateException("bindService must be called before unbind");
        }
        this.mHasBoundService = false;
        this.mContext.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService iUnusedAppRestrictionsBackportServiceAsInterface = IUnusedAppRestrictionsBackportService.AbstractBinderC0613a.asInterface(iBinder);
        this.mUnusedAppRestrictionsService = iUnusedAppRestrictionsBackportServiceAsInterface;
        try {
            iUnusedAppRestrictionsBackportServiceAsInterface.isPermissionRevocationEnabledForApp(getBackportCallback());
        } catch (RemoteException unused) {
            this.mResultFuture.mo68264p(0);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.mUnusedAppRestrictionsService = null;
    }
}
