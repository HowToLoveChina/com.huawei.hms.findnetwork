package com.huawei.openalliance.p169ad;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.CachedContent;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.dc */
/* loaded from: classes8.dex */
public abstract class AbstractC7014dc {

    /* renamed from: a */
    private static C7305h f32166a;

    /* renamed from: b */
    private static C7301d f32167b;

    /* renamed from: c */
    private static IAd f32168c;

    /* renamed from: d */
    private static List<String> f32169d;

    /* renamed from: e */
    private static Map<String, List<CachedContent>> f32170e;

    /* renamed from: f */
    private static final byte[] f32171f = new byte[0];

    /* renamed from: g */
    private static ContentRecord f32172g;

    /* renamed from: h */
    private static ContentRecord f32173h;

    /* renamed from: i */
    private static Drawable f32174i;

    /* renamed from: j */
    private static Bitmap f32175j;

    /* renamed from: k */
    private static ContentRecord f32176k;

    /* renamed from: l */
    private static C7302e f32177l;

    /* renamed from: m */
    private static ContentRecord f32178m;

    /* renamed from: n */
    private static int f32179n;

    /* renamed from: o */
    private static C7301d f32180o;

    /* renamed from: p */
    private static int f32181p;

    /* renamed from: a */
    public static C7301d m41864a() {
        C7301d c7301d;
        synchronized (f32171f) {
            c7301d = f32180o;
        }
        return c7301d;
    }

    /* renamed from: b */
    public static C7305h m41875b() {
        C7305h c7305h;
        synchronized (f32171f) {
            c7305h = f32166a;
        }
        return c7305h;
    }

    /* renamed from: c */
    public static C7301d m41879c() {
        C7301d c7301d;
        synchronized (f32171f) {
            c7301d = f32167b;
        }
        return c7301d;
    }

    /* renamed from: d */
    public static IAd m41881d() {
        IAd iAd;
        synchronized (f32171f) {
            iAd = f32168c;
        }
        return iAd;
    }

    /* renamed from: e */
    public static List<String> m41882e() {
        List<String> list;
        synchronized (f32171f) {
            list = f32169d;
        }
        return list;
    }

    /* renamed from: f */
    public static Map<String, List<CachedContent>> m41883f() {
        Map<String, List<CachedContent>> map;
        synchronized (f32171f) {
            map = f32170e;
        }
        return map;
    }

    /* renamed from: g */
    public static ContentRecord m41884g() {
        ContentRecord contentRecord;
        synchronized (f32171f) {
            contentRecord = f32172g;
        }
        return contentRecord;
    }

    /* renamed from: h */
    public static ContentRecord m41885h() {
        ContentRecord contentRecord;
        synchronized (f32171f) {
            contentRecord = f32173h;
        }
        return contentRecord;
    }

    /* renamed from: i */
    public static Drawable m41886i() {
        Drawable drawable;
        synchronized (f32171f) {
            drawable = f32174i;
        }
        return drawable;
    }

    /* renamed from: j */
    public static Bitmap m41887j() {
        Bitmap bitmap;
        synchronized (f32171f) {
            bitmap = f32175j;
        }
        return bitmap;
    }

    /* renamed from: k */
    public static ContentRecord m41888k() {
        ContentRecord contentRecord;
        synchronized (f32171f) {
            contentRecord = f32176k;
        }
        return contentRecord;
    }

    /* renamed from: l */
    public static C7302e m41889l() {
        C7302e c7302e;
        synchronized (f32171f) {
            c7302e = f32177l;
        }
        return c7302e;
    }

    /* renamed from: m */
    public static ContentRecord m41890m() {
        ContentRecord contentRecord;
        synchronized (f32171f) {
            contentRecord = f32178m;
        }
        return contentRecord;
    }

    /* renamed from: n */
    public static int m41891n() {
        int i10;
        synchronized (f32171f) {
            i10 = f32179n;
        }
        return i10;
    }

    /* renamed from: o */
    public static void m41892o() {
        synchronized (f32171f) {
            f32179n = 0;
        }
    }

    /* renamed from: p */
    public static int m41893p() {
        return f32181p;
    }

    /* renamed from: a */
    public static void m41865a(int i10) {
        synchronized (f32171f) {
            f32179n = i10;
        }
    }

    /* renamed from: b */
    public static void m41876b(int i10) {
        f32181p = i10;
    }

    /* renamed from: c */
    public static void m41880c(ContentRecord contentRecord) {
        synchronized (f32171f) {
            try {
                if (contentRecord == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set icon ad null");
                    f32176k = null;
                } else {
                    f32176k = contentRecord;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41866a(Bitmap bitmap) {
        synchronized (f32171f) {
            try {
                if (bitmap == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set bitmap ad null");
                    f32175j = null;
                } else {
                    f32175j = bitmap;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public static void m41877b(ContentRecord contentRecord) {
        synchronized (f32171f) {
            try {
                if (contentRecord == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set spare splash ad null");
                    f32173h = null;
                } else {
                    f32173h = contentRecord;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41867a(Drawable drawable) {
        synchronized (f32171f) {
            try {
                if (drawable == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set drawable ad null");
                    f32174i = null;
                } else {
                    f32174i = drawable;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public static void m41878b(C7301d c7301d) {
        synchronized (f32171f) {
            try {
                if (c7301d == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set interstitial ad null");
                    f32167b = null;
                } else {
                    f32167b = c7301d;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41868a(ContentRecord contentRecord) {
        synchronized (f32171f) {
            try {
                if (contentRecord == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set normal splash ad null");
                    f32172g = null;
                } else {
                    f32172g = contentRecord;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41869a(IAd iAd) {
        synchronized (f32171f) {
            try {
                if (iAd == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set linkedSplashAd ad null");
                    f32168c = null;
                } else {
                    f32168c = iAd;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41870a(C7301d c7301d) {
        synchronized (f32171f) {
            try {
                if (c7301d == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "interstitial is null.");
                    f32180o = null;
                } else {
                    f32180o = c7301d;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41871a(C7302e c7302e) {
        synchronized (f32171f) {
            try {
                if (c7302e == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set native ad null");
                    f32177l = null;
                } else {
                    f32177l = c7302e;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41872a(C7305h c7305h) {
        synchronized (f32171f) {
            try {
                if (c7305h == null) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set reward ad null");
                    f32166a = null;
                } else {
                    f32166a = c7305h;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41873a(List<String> list) {
        synchronized (f32171f) {
            try {
                if (AbstractC7760bg.m47767a(list)) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set kit cached contentIds null");
                    f32169d = null;
                } else {
                    f32169d = list;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m41874a(Map<String, List<CachedContent>> map) {
        synchronized (f32171f) {
            try {
                if (C7765bl.m47802a(map)) {
                    AbstractC7185ho.m43817a("GlobalDataShare", "set kit cached templateIds null");
                    f32170e = null;
                } else {
                    f32170e = map;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
