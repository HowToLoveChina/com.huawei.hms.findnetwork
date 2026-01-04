package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.ConfigMapDefValues;
import com.huawei.openalliance.p169ad.constant.ConfigMapKeys;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.SpKeys;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7754ba;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7790cj;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.er */
/* loaded from: classes8.dex */
public abstract class AbstractC7102er extends AbstractC7101eq implements InterfaceC7134fr {
    public AbstractC7102er(Context context) {
        super(context);
    }

    /* renamed from: b */
    private int m43021b(String str, int i10) {
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                if (map == null) {
                    return i10;
                }
                return AbstractC7806cz.m48145a(map.get(str), i10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: A */
    public int mo43023A() {
        int iIntValue;
        synchronized (this.f32716f) {
            synchronized (this.f32716f) {
                try {
                    Map<String, String> map = this.f32724n;
                    Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.TEST_CFG_REF_INTERVAL_KEY)) : null;
                    iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 10 : numM48178h.intValue();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: B */
    public boolean mo43024B() {
        synchronized (this.f32716f) {
            try {
                if (!C7765bl.m47802a(this.f32724n)) {
                    String str = this.f32724n.get(ConfigMapKeys.CLCT_DYNCDATA);
                    if (TextUtils.equals(str, "1")) {
                        return true;
                    }
                    if (TextUtils.equals(str, "0")) {
                        return false;
                    }
                }
                return C6982bz.m41148a(this.f32723m).mo41175d();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: C */
    public boolean mo43025C() {
        synchronized (this.f32716f) {
            try {
                if (!C7765bl.m47802a(this.f32724n)) {
                    String str = this.f32724n.get(ConfigMapKeys.CLCT_STATDATA);
                    if (TextUtils.equals(str, "1")) {
                        return true;
                    }
                    if (TextUtils.equals(str, "0")) {
                        return false;
                    }
                }
                return C6982bz.m41148a(this.f32723m).mo41175d();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: D */
    public int mo43026D() {
        int iIntValue;
        Long lM48180i;
        synchronized (this.f32716f) {
            try {
                Long lValueOf = 600000L;
                if (!C7765bl.m47802a(this.f32724n) && this.f32724n.get(ConfigMapKeys.CACHE_REFRESH_INTVL) != null && (lM48180i = AbstractC7806cz.m48180i(this.f32724n.get(ConfigMapKeys.CACHE_REFRESH_INTVL))) != null && lM48180i.longValue() > 0) {
                    lValueOf = Long.valueOf(lM48180i.longValue() * 1000);
                }
                iIntValue = lValueOf.intValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: E */
    public boolean mo43027E() {
        boolean z10;
        synchronized (this.f32716f) {
            try {
                z10 = !TextUtils.equals(C7765bl.m47802a(this.f32724n) ? "1" : this.f32724n.get(ConfigMapKeys.RPT_REPEATED_EVT), "0");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: F */
    public int mo43028F() {
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.SPLASH_INTERACT_CFG)) : null;
                if (numM48178h != null && numM48178h.intValue() >= 0) {
                    if (numM48178h.intValue() <= 4) {
                        return numM48178h.intValue();
                    }
                    return 0;
                }
                return 0;
            } finally {
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: G */
    public String mo43029G() {
        String strM48168c;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                strM48168c = map != null ? AbstractC7806cz.m48168c(map.get(ConfigMapKeys.CLICK_DESC)) : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strM48168c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: H */
    public int mo43030H() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.CLICK_EXTRA_AREA)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() < 0 || numM48178h.intValue() > 24) ? 3 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: I */
    public String mo43031I() {
        String strM48168c;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                strM48168c = map != null ? AbstractC7806cz.m48168c(map.get(ConfigMapKeys.SWIPE_DESC)) : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strM48168c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: J */
    public int mo43032J() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.SWIPE_DP)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 100 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: K */
    public String mo43033K() {
        String strM48168c;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                strM48168c = map != null ? AbstractC7806cz.m48168c(map.get(ConfigMapKeys.TWIST_DESC)) : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strM48168c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: L */
    public int mo43034L() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.TWIST_DEGREE)) : null;
                iIntValue = 35;
                if (numM48178h != null && numM48178h.intValue() >= 35) {
                    iIntValue = numM48178h.intValue();
                }
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: M */
    public int mo43035M() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.TWIST_ACCELERATION)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() < 10) ? 15 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: N */
    public int mo43036N() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.PRO_HEIGHT)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() < 40 || numM48178h.intValue() > 70) ? 56 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: O */
    public int mo43037O() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.PRO_TEXT_SIZE)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() < 12 || numM48178h.intValue() > 18) ? 16 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: P */
    public int mo43038P() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.PRO_RADIUS)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 36 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: Q */
    public int mo43039Q() {
        int iIntValue;
        Integer numM48178h;
        synchronized (this.f32716f) {
            try {
                iIntValue = (C7765bl.m47802a(this.f32724n) || this.f32724n.get(ConfigMapKeys.INSAPPS_FILTER_SWITCH) == null || (numM48178h = AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.INSAPPS_FILTER_SWITCH))) == null || numM48178h.intValue() < 0) ? 0 : numM48178h.intValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: R */
    public int mo43040R() {
        int iIntValue;
        synchronized (this.f32716f) {
            synchronized (this.f32716f) {
                try {
                    Map<String, String> map = this.f32724n;
                    Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get("reqQaidInterval")) : null;
                    iIntValue = (numM48178h == null || numM48178h.intValue() < 0) ? 30 : numM48178h.intValue();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: S */
    public int mo43041S() {
        int iIntValue;
        synchronized (this.f32716f) {
            synchronized (this.f32716f) {
                try {
                    Map<String, String> map = this.f32724n;
                    Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get("reqQaidInterval")) : null;
                    iIntValue = (numM48178h == null || numM48178h.intValue() < 0) ? 30 : numM48178h.intValue();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: T */
    public int mo43042T() {
        return m43021b(ConfigMapKeys.CLCT_NETWORK_KIT, 0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: U */
    public boolean mo43043U() {
        return m43020a(ConfigMapKeys.DL_CONFIRM_CLICKABLE, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: V */
    public boolean mo43044V() {
        synchronized (this.f32716f) {
            try {
                if (C7765bl.m47802a(this.f32724n)) {
                    return true;
                }
                if (TextUtils.equals(this.f32724n.get(ConfigMapKeys.DIALOG_DISMISS_ON_BACK), "1")) {
                    return true;
                }
                return !TextUtils.equals(r3, "0");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: W */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo43045W() {
        /*
            r2 = this;
            byte[] r0 = r2.f32716f
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.String> r1 = r2.f32724n     // Catch: java.lang.Throwable -> L1a
            boolean r1 = com.huawei.openalliance.p169ad.utils.C7765bl.m47802a(r1)     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L1c
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.f32724n     // Catch: java.lang.Throwable -> L1a
            java.lang.String r1 = "showEndMasking"
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L1a
            java.lang.Integer r2 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48178h(r2)     // Catch: java.lang.Throwable -> L1a
            goto L1d
        L1a:
            r2 = move-exception
            goto L2a
        L1c:
            r2 = 0
        L1d:
            if (r2 == 0) goto L27
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L1a
            r1 = 1
            if (r1 != r2) goto L27
            goto L28
        L27:
            r1 = 0
        L28:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            return r1
        L2a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.AbstractC7102er.mo43045W():boolean");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: X */
    public boolean mo43046X() {
        boolean z10;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.ENABLE_CLOSE_DIALOG)) : null;
                z10 = true;
                if (numM48178h != null && 1 != numM48178h.intValue()) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: Y */
    public boolean mo43047Y() {
        boolean z10;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.PRELOAD_DETAIL)) : null;
                z10 = true;
                if (numM48178h != null && 1 != numM48178h.intValue()) {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: Z */
    public int mo43048Z() {
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.CLCT_PRE_REQ)) : null;
                if (numM48178h == null) {
                    return 0;
                }
                return numM48178h.intValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: a */
    public int mo43049a(Context context) {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                boolean zM47595q = AbstractC7741ao.m47595q(context);
                iIntValue = zM47595q ? 98 : 64;
                int i10 = zM47595q ? 119 : 85;
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.PRO_BOTTOM_MARGIN)) : null;
                if (numM48178h != null && numM48178h.intValue() >= 40 && numM48178h.intValue() <= i10) {
                    iIntValue = numM48178h.intValue();
                }
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: aa */
    public String mo43053aa() {
        synchronized (this.f32716f) {
            try {
                String str = !C7765bl.m47802a(this.f32724n) ? this.f32724n.get(ConfigMapKeys.EMULATOR_FILE) : null;
                return !TextUtils.isEmpty(str) ? str : "";
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ab */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo43054ab() {
        /*
            r2 = this;
            byte[] r0 = r2.f32716f
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.f32724n     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L16
            java.lang.String r1 = "clctCtx"
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> L14
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L14
            java.lang.Integer r2 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48178h(r2)     // Catch: java.lang.Throwable -> L14
            goto L17
        L14:
            r2 = move-exception
            goto L24
        L16:
            r2 = 0
        L17:
            if (r2 == 0) goto L21
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L14
            r1 = 1
            if (r2 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return r1
        L24:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.AbstractC7102er.mo43054ab():boolean");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ac */
    public int mo43055ac() {
        int iIntValue;
        synchronized (this.f32716f) {
            synchronized (this.f32716f) {
                try {
                    Map<String, String> map = this.f32724n;
                    Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.CLCT_CTX_INTVL)) : null;
                    iIntValue = (numM48178h == null || numM48178h.intValue() < 0) ? 60 : numM48178h.intValue();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ad */
    public int mo43056ad() {
        int iIntValue;
        synchronized (this.f32716f) {
            synchronized (this.f32716f) {
                try {
                    Map<String, String> map = this.f32724n;
                    Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.CLCT_CTX_SIZE)) : null;
                    iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 200 : numM48178h.intValue();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ae */
    public Map<String, String> mo43057ae() {
        Map<String, String> map;
        synchronized (this.f32716f) {
            synchronized (this.f32716f) {
                try {
                    Map<String, String> map2 = this.f32724n;
                    map = map2 != null ? (Map) AbstractC7758be.m47739b(map2.get(ConfigMapKeys.CLCT_CTX_MAP), Map.class, new Class[0]) : null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return map;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: af */
    public boolean mo43058af() {
        return m43020a(ConfigMapKeys.REPORT_AD_REQ_GRPID, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ag */
    public boolean mo43059ag() {
        return m43020a(ConfigMapKeys.REPORT_OTHER_ID_WITH_GRPID, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ah */
    public long mo43060ah() {
        long jLongValue;
        synchronized (this.f32716f) {
            try {
                jLongValue = (C7765bl.m47802a(this.f32724n) ? 20L : Long.valueOf(AbstractC7806cz.m48146a(this.f32724n.get(ConfigMapKeys.DELETE_INVALID_CONTENTS_DELAY), 20L))).longValue() * 1000;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jLongValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ai */
    public int mo43061ai() {
        int i10;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                i10 = 0;
                int iM48145a = (map == null || TextUtils.isEmpty(map.get(ConfigMapKeys.IPC_FLAG))) ? 0 : AbstractC7806cz.m48145a(this.f32724n.get(ConfigMapKeys.IPC_FLAG), 0);
                if (iM48145a == 0 || iM48145a == 1) {
                    i10 = iM48145a;
                }
            } finally {
            }
        }
        return i10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: aj */
    public boolean mo43062aj() {
        return TextUtils.equals(mo43070b(ConfigMapKeys.SET_SURFACE_FIRST, "1"), "1");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ak */
    public long mo43063ak() {
        long jM43022b = m43022b(ConfigMapKeys.PLAY_END_DCT_TO, 5L);
        return (jM43022b >= 0 ? jM43022b : 5L) * 1000;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: al */
    public int mo43064al() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                Integer numM48178h = map != null ? AbstractC7806cz.m48178h(map.get(ConfigMapKeys.SYNC_APP_DATA_INTV)) : null;
                iIntValue = numM48178h == null ? 45 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: am */
    public String mo43065am() {
        String str;
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                str = map != null ? map.get(ConfigMapKeys.LANDING_TITLE_INVISIBLE_STR) : null;
                if (TextUtils.isEmpty(str)) {
                    str = Constants.LRM_STR;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: an */
    public Map<String, String> mo43066an() {
        Map<String, String> map;
        synchronized (this.f32716f) {
            try {
                String packageName = this.f32723m.getPackageName();
                Map<String, String> map2 = this.f32724n;
                Map map3 = map2 != null ? (Map) AbstractC7758be.m47739b(map2.get(ConfigMapKeys.THIRD_SHARE_APP_ID), Map.class, new Class[0]) : null;
                return (map3 == null || !map3.containsKey(packageName) || (map = (Map) AbstractC7758be.m47739b((String) map3.get(packageName), Map.class, new Class[0])) == null) ? new HashMap() : map;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ao */
    public int mo43067ao() {
        return m43021b(ConfigMapKeys.PARTNER_RULE, ConfigMapDefValues.DEF_PARTNER_RULE.intValue());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: ap */
    public String mo43068ap() {
        return mo43070b(ConfigMapKeys.PARTNER_LIST, "");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: aq */
    public int[] mo43069aq() {
        String strMo43070b = mo43070b(ConfigMapKeys.CLICK_VALID_INTVL, "");
        if (AbstractC7806cz.m48165b(strMo43070b)) {
            return Constants.CLICK_DEF_INTVL;
        }
        String[] strArrSplit = strMo43070b.split("-");
        if (strArrSplit.length != 2) {
            return Constants.CLICK_DEF_INTVL;
        }
        int[] iArr = new int[2];
        try {
            iArr[0] = Integer.parseInt(strArrSplit[0].trim());
            int i10 = Integer.parseInt(strArrSplit[1].trim());
            iArr[1] = i10;
            return iArr[0] >= i10 ? Constants.CLICK_DEF_INTVL : iArr;
        } catch (Throwable unused) {
            return Constants.CLICK_DEF_INTVL;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: f */
    public long mo43072f() {
        return m43021b(ConfigMapKeys.PKG_ADD_LISTEN_TIME, 5) * 60000;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: g */
    public int mo43073g() {
        return m43021b(ConfigMapKeys.UNINSTALLED_APP_CACHE_QUERY_INTERVAL, 60);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: h */
    public int mo43074h() {
        return m43021b(ConfigMapKeys.VIDEO_PLAY_TIMEOUT, 5000);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: i */
    public boolean mo43075i() {
        return m43020a(ConfigMapKeys.ALLOW_RPT_CTX_TAG, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: j */
    public boolean mo43076j() {
        return m43020a(ConfigMapKeys.ALLOW_RPT_AUD, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: k */
    public int mo43077k() {
        return m43021b(ConfigMapKeys.ALLOW_TAG_AUD_MODE, 0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: l */
    public boolean mo43078l() {
        return m43020a(ConfigMapKeys.HUAWEI_USER_RECOMMEND_ENABLED, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: m */
    public List<String> mo43079m() {
        return C7790cj.m48043a(mo43070b(ConfigMapKeys.ALLOW_CACHE_TRADE_MODE, ""));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: n */
    public int mo43080n() {
        return C7790cj.m48051b(mo43070b(ConfigMapKeys.LOCAL_RECALL_MAX_ADS, ""));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: o */
    public int mo43081o() {
        return AbstractC7754ba.m47702a(mo43070b("Intv_query_insapp", ""));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: p */
    public List<String> mo43082p() {
        synchronized (this.f32716f) {
            try {
                if (!C7765bl.m47802a(this.f32724n)) {
                    String str = this.f32724n.get(ConfigMapKeys.EVENT_BLACK_LIST);
                    if (!AbstractC7806cz.m48165b(str)) {
                        return Arrays.asList(str.trim().split(","));
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: q */
    public long mo43083q() {
        long jLongValue;
        synchronized (this.f32716f) {
            try {
                jLongValue = (C7765bl.m47802a(this.f32724n) ? 150L : Long.valueOf(AbstractC7806cz.m48146a(this.f32724n.get(ConfigMapKeys.REWARD_MAX_DATA), 150L))).longValue() * 1048576;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jLongValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: r */
    public int mo43084r() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.WEBVIEW_PRELOAD_MAXNUM)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 20 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: s */
    public int mo43085s() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.MAX_UPLOAD_EVENT_COUNT_HISUGGESTION)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 80 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: t */
    public int mo43086t() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.WEBVIEW_PRELOAD_NETWORK)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 0 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: u */
    public String mo43087u() {
        String strM48168c;
        synchronized (this.f32716f) {
            try {
                strM48168c = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48168c(this.f32724n.get(ConfigMapKeys.WEBVIEW_PRELOAD_CLICK_ACTION)) : null;
                if (AbstractC7806cz.m48165b(strM48168c)) {
                    strM48168c = Constants.WEBVIEW_PRELOAD_CLICK_ACTION;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strM48168c;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: v */
    public boolean mo43088v() {
        synchronized (this.f32716f) {
            try {
                if (!C7765bl.m47802a(this.f32724n)) {
                    String str = this.f32724n.get(ConfigMapKeys.DEVICE_CONNECT_LIST_COLLECT_SWITCH);
                    if (TextUtils.equals(str, "1")) {
                        return true;
                    }
                    if (TextUtils.equals(str, "0")) {
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: w */
    public boolean mo43089w() {
        synchronized (this.f32716f) {
            try {
                if (!C7765bl.m47802a(this.f32724n)) {
                    String str = this.f32724n.get(ConfigMapKeys.ADDRESS_CONNECT_LIST_COLLECT_SWITCH);
                    if (TextUtils.equals(str, "1")) {
                        return true;
                    }
                    if (TextUtils.equals(str, "0")) {
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: x */
    public int mo43090x() {
        int iIntValue;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.DEVICE_CONNECT_LIST_COLLECT_INTERVAL)) : null;
                iIntValue = (numM48178h == null || numM48178h.intValue() <= 0) ? 60 : numM48178h.intValue();
            } finally {
            }
        }
        return iIntValue;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: y */
    public int mo43091y() {
        int iMax;
        synchronized (this.f32716f) {
            try {
                Integer numM48178h = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48178h(this.f32724n.get(ConfigMapKeys.DEVICE_CONNECT_LIST_MAX_SIZE)) : null;
                iMax = numM48178h == null ? 20 : Math.max(0, Math.min(numM48178h.intValue(), 50));
            } finally {
            }
        }
        return iMax;
    }

    /* renamed from: z */
    public long m43092z() {
        Long lM48180i;
        long jLongValue;
        synchronized (this.f32716f) {
            try {
                synchronized (this.f32716f) {
                    lM48180i = !C7765bl.m47802a(this.f32724n) ? AbstractC7806cz.m48180i(this.f32724n.get(ConfigMapKeys.OAID_REPORT_TIME_INTERVAL)) : null;
                }
                jLongValue = (lM48180i == null || lM48180i.longValue() <= 0) ? ConfigMapDefValues.DEFAULT_OAID_EVENT_INTENVAL : lM48180i.longValue();
            } catch (Throwable th2) {
                throw th2;
            } finally {
            }
        }
        return jLongValue;
    }

    /* renamed from: b */
    private long m43022b(String str, long j10) {
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                if (map == null) {
                    return j10;
                }
                return AbstractC7806cz.m48146a(map.get(str), j10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: a */
    public boolean mo43050a(long j10) {
        if (j10 <= 0) {
            return true;
        }
        return m43092z() * 60000 <= System.currentTimeMillis() - j10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: a */
    public boolean mo43051a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, String> map = this.f32724n;
        List list = (List) AbstractC7758be.m47739b(map != null ? map.get(ConfigMapKeys.NEED_ADD_FLAGS_APPS) : null, List.class, String.class);
        return list == null ? WhiteListPkgList.isPkgNeedAddFlags(str) : list.contains(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: b */
    public String mo43070b(String str, String str2) {
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                if (map == null) {
                    return str2;
                }
                String str3 = map.get(str);
                if (!AbstractC7806cz.m48165b(str3)) {
                    str2 = str3;
                }
                return str2;
            } finally {
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: a */
    public boolean mo43052a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.f32716f) {
            try {
                long j10 = this.f32711a.getLong(SpKeys.LAST_CALL_METHOD_TIME_PREFIX + str, 0L);
                AbstractC7185ho.m43818a("ConfigMapSpHandler", "methodName is %s ,lastCallTime is %s", str, Long.valueOf(j10));
                if (j10 <= 0) {
                    return false;
                }
                Map<String, String> map = this.f32724n;
                if (map != null) {
                    i10 = AbstractC7806cz.m48145a(map.get(ConfigMapKeys.INTERVAL_PREFIX + str), i10);
                }
                AbstractC7185ho.m43818a("ConfigMapSpHandler", "intvConfig is %s", Integer.valueOf(i10));
                return AbstractC7741ao.m47566c() < j10 + ((long) (i10 * 60000));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7134fr
    /* renamed from: b */
    public boolean mo43071b(String str) {
        return mo43052a(str, 30);
    }

    /* renamed from: a */
    private boolean m43020a(String str, boolean z10) {
        synchronized (this.f32716f) {
            try {
                Map<String, String> map = this.f32724n;
                if (map == null) {
                    return z10;
                }
                String str2 = map.get(str);
                if (!AbstractC7806cz.m48165b(str2)) {
                    z10 = "1".equals(str2);
                }
                return z10;
            } finally {
            }
        }
    }
}
