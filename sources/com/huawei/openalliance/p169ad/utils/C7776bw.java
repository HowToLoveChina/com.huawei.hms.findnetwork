package com.huawei.openalliance.p169ad.utils;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterfaceC8249xq;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import java.security.MessageDigest;

/* renamed from: com.huawei.openalliance.ad.utils.bw */
/* loaded from: classes2.dex */
public class C7776bw {

    /* renamed from: a */
    private static String f35954a = null;

    /* renamed from: b */
    private static String f35955b = "";

    /* renamed from: a */
    public static String m47835a(final Context context) {
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        try {
            if (!context.bindService(intent, new ServiceConnection() { // from class: com.huawei.openalliance.ad.utils.bw.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AbstractC7185ho.m43820b("OIdentifierManager", "HeyTap IdentifyService connected");
                    try {
                        String strM47839b = C7776bw.m47839b(context, iBinder);
                        if (strM47839b == null || strM47839b.length() == 0) {
                            AbstractC7185ho.m43823c("OIdentifierManager", "HeyTap OUID get failed");
                        } else {
                            String unused = C7776bw.f35955b = strM47839b;
                        }
                        try {
                            context.unbindService(this);
                        } catch (Throwable th2) {
                            AbstractC7185ho.m43824c("OIdentifierManager", "HeyTap IdentifyService, unbind service error: %s", th2.getClass().getSimpleName());
                        }
                    } catch (Throwable th3) {
                        try {
                            AbstractC7185ho.m43824c("OIdentifierManager", "HeyTap IdentifyService, bind service error: %s", th3.getClass().getSimpleName());
                            try {
                                context.unbindService(this);
                            } catch (Throwable th4) {
                                AbstractC7185ho.m43824c("OIdentifierManager", "HeyTap IdentifyService, unbind service error: %s", th4.getClass().getSimpleName());
                            }
                        } catch (Throwable th5) {
                            try {
                                context.unbindService(this);
                            } catch (Throwable th6) {
                                AbstractC7185ho.m43824c("OIdentifierManager", "HeyTap IdentifyService, unbind service error: %s", th6.getClass().getSimpleName());
                            }
                            throw th5;
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    AbstractC7185ho.m43820b("OIdentifierManager", "HeyTap IdentifyService disconnected");
                }
            }, 1)) {
                AbstractC7185ho.m43823c("OIdentifierManager", "HeyTap IdentifyService bind failed");
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("OIdentifierManager", "get oaid error: %s", th2.getClass().getSimpleName());
        }
        return f35955b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    /* renamed from: b */
    public static String m47839b(Context context, IBinder iBinder) {
        String packageName = context.getPackageName();
        if (f35954a == null) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
                StringBuilder sb2 = new StringBuilder();
                for (byte b10 : bArrDigest) {
                    sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
                }
                String string = sb2.toString();
                f35954a = string;
                return m47837a(iBinder, packageName, string);
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("OIdentifierManager", "realGetOUID ex: %s", th2.getClass().getSimpleName());
            }
        }
        return m47837a(iBinder, packageName, f35954a);
    }

    /* renamed from: a */
    private static String m47837a(IBinder iBinder, String str, String str2) {
        try {
            InterfaceC8249xq interfaceC8249xq = (InterfaceC8249xq) InterfaceC8249xq.a.class.getDeclaredMethod(VideoPlayFlag.PLAY_IN_ALL, IBinder.class).invoke(null, iBinder);
            if (interfaceC8249xq == null) {
                AbstractC7185ho.m43823c("OIdentifierManager", "IOpenID is null");
            }
            return interfaceC8249xq.mo51542a(str, str2, "OUID");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("OIdentifierManager", "getSerId error: %s", th2.getClass().getSimpleName());
            return null;
        }
    }
}
