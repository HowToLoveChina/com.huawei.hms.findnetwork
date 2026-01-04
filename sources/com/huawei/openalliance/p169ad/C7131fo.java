package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.constant.TagConstants;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.fo */
/* loaded from: classes8.dex */
public class C7131fo implements InterfaceC7151gh {

    /* renamed from: b */
    private static InterfaceC7151gh f32922b;

    /* renamed from: c */
    private static final byte[] f32923c = new byte[0];

    /* renamed from: a */
    private final SharedPreferences f32924a;

    /* renamed from: d */
    private final byte[] f32925d = new byte[0];

    /* renamed from: e */
    private Map<String, String> f32926e;

    private C7131fo(Context context) {
        try {
            this.f32924a = context.getApplicationContext().getSharedPreferences("hiad_user_tags_sp", 0);
        } catch (Throwable th2) {
            try {
                AbstractC7185ho.m43824c("UserTagSpHandler", "get SharedPreference exception: %s", th2.getClass().getSimpleName());
            } finally {
                this.f32924a = null;
            }
        }
    }

    /* renamed from: b */
    private static InterfaceC7151gh m43548b(Context context) {
        InterfaceC7151gh interfaceC7151gh;
        synchronized (f32923c) {
            try {
                if (f32922b == null) {
                    f32922b = new C7131fo(context);
                }
                interfaceC7151gh = f32922b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC7151gh;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: a */
    public long mo43549a() {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return 0L;
                }
                return sharedPreferences.getLong("last_query_tag_time", 0L);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: c */
    public int mo43558c(String str) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return -1;
                }
                return sharedPreferences.getInt(str + TagConstants.TRIGGER_MODE_SUFFIX, -1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: d */
    public long mo43559d(String str) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return 0L;
                }
                return sharedPreferences.getLong(str + TagConstants.UPDATE_TIME_SUFFIX, 0L);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: e */
    public long mo43560e(String str) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return 0L;
                }
                return sharedPreferences.getLong(str + TagConstants.SYNC_TIME_SUFFIX, 0L);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC7151gh m43547a(Context context) {
        return m43548b(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: b */
    public String mo43556b(String str) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return "";
                }
                return sharedPreferences.getString(str + TagConstants.TAG_VALUE_SUFFIX, "");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: a */
    public void mo43550a(long j10) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putLong("last_query_tag_time", j10).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: b */
    public Map<String, String> mo43557b() {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return null;
                }
                Map<String, String> map = this.f32926e;
                if (map != null) {
                    return map;
                }
                String string = sharedPreferences.getString("user_tag", "");
                if (AbstractC7806cz.m48165b(string)) {
                    return null;
                }
                Map<String, String> map2 = (Map) AbstractC7758be.m47739b(string, Map.class, new Class[0]);
                this.f32926e = map2;
                return map2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: a */
    public void mo43551a(String str) {
        synchronized (this.f32925d) {
            try {
                if (this.f32924a == null) {
                    return;
                }
                this.f32926e = (Map) AbstractC7758be.m47739b(str, Map.class, new Class[0]);
                this.f32924a.edit().putString("user_tag", str).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: a */
    public void mo43552a(String str, int i10) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putInt(str + TagConstants.TRIGGER_MODE_SUFFIX, i10).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: a */
    public void mo43553a(String str, long j10) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putLong(str + TagConstants.UPDATE_TIME_SUFFIX, j10).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: a */
    public void mo43554a(String str, String str2) {
        synchronized (this.f32925d) {
            try {
                SharedPreferences sharedPreferences = this.f32924a;
                if (sharedPreferences == null) {
                    return;
                }
                sharedPreferences.edit().putString(str + TagConstants.TAG_VALUE_SUFFIX, str2).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7151gh
    /* renamed from: a */
    public void mo43555a(List<String> list, long j10) {
        synchronized (this.f32925d) {
            try {
                if (this.f32924a != null && !AbstractC7760bg.m47767a(list)) {
                    SharedPreferences.Editor editorEdit = this.f32924a.edit();
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        editorEdit.putLong(it.next() + TagConstants.SYNC_TIME_SUFFIX, j10);
                    }
                    editorEdit.commit();
                }
            } finally {
            }
        }
    }
}
