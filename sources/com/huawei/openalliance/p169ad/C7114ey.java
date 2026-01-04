package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* renamed from: com.huawei.openalliance.ad.ey */
/* loaded from: classes8.dex */
public class C7114ey implements InterfaceC7139fw {

    /* renamed from: c */
    private static InterfaceC7139fw f32756c;

    /* renamed from: d */
    private static final byte[] f32757d = new byte[0];

    /* renamed from: a */
    private Context f32758a;

    /* renamed from: b */
    private final SharedPreferences f32759b;

    /* renamed from: e */
    private final byte[] f32760e = new byte[0];

    private C7114ey(Context context) {
        this.f32758a = context.getApplicationContext();
        try {
            this.f32759b = context.getSharedPreferences("HiAd_InsAppsSharedPreferences", 0);
        } catch (Throwable th2) {
            try {
                AbstractC7185ho.m43824c("InsAppsSpHandler", "get SharedPreference exception: %s", th2.getClass().getSimpleName());
            } finally {
                this.f32759b = null;
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC7139fw m43174a(Context context) {
        return m43175b(context);
    }

    /* renamed from: b */
    private static InterfaceC7139fw m43175b(Context context) {
        InterfaceC7139fw interfaceC7139fw;
        synchronized (f32757d) {
            try {
                if (f32756c == null) {
                    f32756c = new C7114ey(context);
                }
                interfaceC7139fw = f32756c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7139fw;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: c */
    public int mo43182c() {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return 200;
                }
                return sharedPreferences.getInt(Constants.INS_APPS_RETURN_CODE, -1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: d */
    public long mo43184d() {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return 0L;
                }
                return sharedPreferences.getLong(Constants.LABEL_GEN_TIME, 0L);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: a */
    public String mo43176a() {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return "";
                }
                return sharedPreferences.getString(Constants.INS_APPS_ENCODED, "");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: b */
    public String mo43180b() {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return AbstractC7806cz.m48153a((Object) 1);
                }
                return sharedPreferences.getString(Constants.ENCODING_MODE, AbstractC7806cz.m48153a((Object) 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: c */
    public void mo43183c(String str) {
        synchronized (this.f32760e) {
            try {
                if (this.f32759b == null) {
                    return;
                }
                if (AbstractC7806cz.m48165b(str)) {
                    return;
                }
                this.f32759b.edit().remove(str).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: d */
    public boolean mo43185d(String str) {
        SharedPreferences sharedPreferences;
        synchronized (this.f32760e) {
            try {
                if (!AbstractC7806cz.m48165b(str) && (sharedPreferences = this.f32759b) != null) {
                    return sharedPreferences.contains(str);
                }
                return false;
            } finally {
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: a */
    public void mo43177a(int i10) {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putInt(Constants.INS_APPS_RETURN_CODE, i10).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: b */
    public void mo43181b(String str) {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putString(Constants.ENCODING_MODE, str).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: a */
    public void mo43178a(long j10) {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putLong(Constants.LABEL_GEN_TIME, j10).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7139fw
    /* renamed from: a */
    public void mo43179a(String str) {
        synchronized (this.f32760e) {
            try {
                SharedPreferences sharedPreferences = this.f32759b;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putString(Constants.INS_APPS_ENCODED, str).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
