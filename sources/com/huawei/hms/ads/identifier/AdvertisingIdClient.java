package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService;
import java.io.IOException;

@Keep
/* loaded from: classes8.dex */
public class AdvertisingIdClient {
    private static final String NIL_UUID = "00000000-0000-0000-0000-000000000000";
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";
    private static final String TAG = "AdvertisingIdClient";

    /* renamed from: com.huawei.hms.ads.identifier.AdvertisingIdClient$1 */
    public static class RunnableC50661 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f23177a;

        public RunnableC50661(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(context);
            } catch (Throwable th2) {
                Log.w(AdvertisingIdClient.TAG, "update Id err: " + th2.getClass().getSimpleName());
            }
        }
    }

    @Keep
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z10) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z10;
        }

        @Keep
        public String getId() {
            return this.advertisingId;
        }

        @Keep
        public boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) throws IOException {
        try {
        } catch (Throwable th2) {
            Log.w(TAG, "get Id err: " + th2.getClass().getSimpleName());
        }
        if (!TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "pps_oaid_c"))) {
            Info infoM30251a = C5069c.m30251a(context);
            return infoM30251a != null ? infoM30251a : requestAdvertisingIdInfo(context);
        }
        String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
        String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            updateAdvertisingIdInfo(context);
            return new Info(string, Boolean.valueOf(string2).booleanValue());
        }
        return requestAdvertisingIdInfo(context);
    }

    private static Info getIdInfoViaAIDL(Context context) throws PackageManager.NameNotFoundException, IOException {
        try {
            context.getPackageManager().getPackageInfo(C5072f.m30263a(context), 128);
            ServiceConnectionC5067a serviceConnectionC5067a = new ServiceConnectionC5067a();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            String strM30263a = C5072f.m30263a(context);
            if (!isHmsValid(context, strM30263a)) {
                return new Info("00000000-0000-0000-0000-000000000000", true);
            }
            intent.setPackage(strM30263a);
            try {
                if (!context.bindService(intent, serviceConnectionC5067a, 1)) {
                    throw new IOException("bind failed");
                }
                try {
                    OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(serviceConnectionC5067a.m30248a());
                    return new Info(openDeviceIdentifierServiceAsInterface.getOaid(), openDeviceIdentifierServiceAsInterface.isOaidTrackLimited());
                } catch (RemoteException unused) {
                    throw new IOException("bind hms service RemoteException");
                } catch (InterruptedException unused2) {
                    throw new IOException("bind hms service InterruptedException");
                }
            } finally {
                try {
                    context.unbindService(serviceConnectionC5067a);
                } catch (Throwable th2) {
                    Log.w(TAG, "unbind " + th2.getClass().getSimpleName());
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Service not found");
        } catch (Exception unused4) {
            throw new IOException("Service not found: Exception");
        }
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(C5072f.m30263a(context), 128);
            new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(C5072f.m30263a(context));
            return !r1.queryIntentServices(r2, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    private static boolean isHmsValid(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || !C5072f.m30264a(context, str)) {
            return false;
        }
        boolean zM30249a = C5068b.m30249a(str, C5072f.m30266c(context, str));
        Log.i(TAG, "isHmsValid: " + zM30249a);
        return zM30249a;
    }

    public static Info requestAdvertisingIdInfo(Context context) throws IOException {
        if (C5069c.m30256d(context)) {
            Log.i(TAG, "requestAdvertisingIdInfo via provider");
            return C5069c.m30255c(context);
        }
        Log.i(TAG, "requestAdvertisingIdInfo via aidl");
        return getIdInfoViaAIDL(context);
    }

    private static void updateAdvertisingIdInfo(Context context) {
        AbstractC5076j.f23213a.execute(new Runnable() { // from class: com.huawei.hms.ads.identifier.AdvertisingIdClient.1

            /* renamed from: a */
            final /* synthetic */ Context f23177a;

            public RunnableC50661(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdvertisingIdClient.requestAdvertisingIdInfo(context);
                } catch (Throwable th2) {
                    Log.w(AdvertisingIdClient.TAG, "update Id err: " + th2.getClass().getSimpleName());
                }
            }
        });
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z10) throws AdIdVerifyException {
        Info infoRequestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
        if (TextUtils.equals(str, infoRequestAdvertisingIdInfo.getId())) {
            if (z10 == infoRequestAdvertisingIdInfo.isLimitAdTrackingEnabled()) {
                return true;
            }
        }
        return false;
    }
}
