package com.huawei.openalliance.p169ad.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterfaceC7152gi;
import com.huawei.openalliance.p169ad.InterfaceC7153gj;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.openalliance.ad.utils.aq */
/* loaded from: classes2.dex */
public class C7743aq {
    /* renamed from: a */
    public static Pair<String, Boolean> m47598a(Context context) {
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        long jMo43441cl = interfaceC7146gcM43316b.mo43441cl();
        long jMo43040R = interfaceC7146gcM43316b.mo43040R() * 60000;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jMo43441cl >= jMo43040R) {
            AbstractC7185ho.m43818a("HonorIdentifierManager", "HnOaIdService getOaidAndTrackLimit cache lastReqHonorOaidTime: %s, reqOaidTimeInterval: %s", Long.valueOf(jMo43441cl), Long.valueOf(jMo43040R));
            interfaceC7146gcM43316b.mo43479o(jCurrentTimeMillis);
            return m47599a(context, false);
        }
        Pair<String, Boolean> pairM47965ah = C7787cg.m47900a(context).m47965ah();
        if (AbstractC7185ho.m43819a() && pairM47965ah != null) {
            AbstractC7185ho.m43818a("HonorIdentifierManager", "HnOaIdService getOaidAndTrackLimit cache oaid: %s, oaidLimitState: %s", pairM47965ah.first, pairM47965ah.second);
        }
        return pairM47965ah;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m47601b(final IBinder iBinder, final boolean z10, final C7787cg c7787cg) {
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.utils.aq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InterfaceC7153gj interfaceC7153gjM43573a = InterfaceC7153gj.a.m43573a(iBinder);
                    if (interfaceC7153gjM43573a == null) {
                        return;
                    }
                    interfaceC7153gjM43573a.mo43571a(new InterfaceC7152gi.a() { // from class: com.huawei.openalliance.ad.utils.aq.2.1
                        @Override // com.huawei.openalliance.p169ad.InterfaceC7152gi
                        /* renamed from: a */
                        public void mo43566a(int i10, long j10, boolean z11, float f10, double d10, String str) {
                        }

                        @Override // com.huawei.openalliance.p169ad.InterfaceC7152gi
                        /* renamed from: a */
                        public void mo43567a(int i10, Bundle bundle) {
                            if (bundle == null) {
                                AbstractC7185ho.m43826d("HonorIdentifierManager", "param err");
                                return;
                            }
                            String string = bundle.getString("oa_id_flag");
                            boolean z11 = TextUtils.isEmpty(string) || Constants.NIL_UUID.equals(string);
                            c7787cg.m47954a(string, Boolean.valueOf(z11), z10);
                            AbstractC7185ho.m43818a("HonorIdentifierManager", "OAIDCallBack handleResult success oaid: %s, oaidLimitState: %s", string, Boolean.valueOf(z11));
                        }
                    });
                } catch (Throwable th2) {
                    AbstractC7185ho.m43827d("HonorIdentifierManager", "HnOaIdService get oaid error: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    /* renamed from: a */
    public static Pair<String, Boolean> m47599a(final Context context, final boolean z10) {
        try {
            AbstractC7185ho.m43817a("HonorIdentifierManager", "requestHonorOaid start");
            PackageManager packageManager = context.getPackageManager();
            final C7787cg c7787cgM47900a = C7787cg.m47900a(context);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (!packageManager.queryIntentServices(intent, 0).isEmpty()) {
                context.bindService(intent, new ServiceConnection() { // from class: com.huawei.openalliance.ad.utils.aq.1
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Context context2;
                        AbstractC7185ho.m43817a("HonorIdentifierManager", "HnOaIdService IdentifyService connected");
                        try {
                            try {
                                try {
                                    C7743aq.m47601b(iBinder, z10, c7787cgM47900a);
                                    context2 = context;
                                } catch (Throwable unused) {
                                    AbstractC7185ho.m43826d("HonorIdentifierManager", "HnOaIdService IdentifyService, bind service error");
                                    context2 = context;
                                }
                                context2.unbindService(this);
                            } catch (Throwable unused2) {
                                AbstractC7185ho.m43826d("HonorIdentifierManager", "HnOaIdService IdentifyService, unbind service error");
                            }
                        } catch (Throwable th2) {
                            try {
                                context.unbindService(this);
                            } catch (Throwable unused3) {
                                AbstractC7185ho.m43826d("HonorIdentifierManager", "HnOaIdService IdentifyService, unbind service error");
                            }
                            throw th2;
                        }
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        AbstractC7185ho.m43817a("HonorIdentifierManager", "HnOaIdService IdentifyService disconnected");
                    }
                }, 1);
            }
            return c7787cgM47900a.m47965ah();
        } catch (Exception unused) {
            AbstractC7185ho.m43826d("HonorIdentifierManager", "HnOaIdService IdentifyService getPackageInfo exception.");
            return null;
        }
    }
}
