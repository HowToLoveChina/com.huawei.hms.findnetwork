package cn.com.miaozhen.mobile.tracking.viewability.origin.p059e;

import cn.com.miaozhen.mobile.tracking.viewability.origin.C1499d;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import ijiami_release01.NCall;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.e.i */
/* loaded from: classes.dex */
public class C1508i implements Serializable {

    /* renamed from: e */
    private C1509j f6454e;

    /* renamed from: g */
    private int f6456g;

    /* renamed from: i */
    private float f6458i;

    /* renamed from: j */
    private int f6459j;

    /* renamed from: h */
    private boolean f6457h = false;

    /* renamed from: a */
    private long f6450a = 0;

    /* renamed from: b */
    private long f6451b = 0;

    /* renamed from: f */
    private List<C1509j> f6455f = new ArrayList();

    /* renamed from: c */
    private C1509j f6452c = null;

    /* renamed from: d */
    private C1509j f6453d = null;

    public C1508i(int i10, int i11, float f10) {
        this.f6459j = i10;
        this.f6456g = i11;
        this.f6458i = f10;
    }

    /* renamed from: a */
    public long m8567a() {
        return NCall.m64615IJ(new Object[]{212, this});
    }

    /* renamed from: b */
    public long m8569b() {
        return NCall.m64615IJ(new Object[]{214, this});
    }

    public String toString() {
        return (String) NCall.m64616IL(new Object[]{216, this});
    }

    /* renamed from: a */
    public List<HashMap<String, Object>> m8568a(C1499d c1499d) {
        return (List) NCall.m64616IL(new Object[]{213, this, c1499d});
    }

    /* renamed from: b */
    public void m8570b(C1509j c1509j) {
        NCall.m64618IV(new Object[]{Integer.valueOf(PlayerConstants.EventCode.VIDEO_MATCH_PRELOAD), this, c1509j});
    }

    /* renamed from: a */
    private boolean m8566a(C1509j c1509j) {
        return NCall.m64619IZ(new Object[]{211, this, c1509j});
    }
}
