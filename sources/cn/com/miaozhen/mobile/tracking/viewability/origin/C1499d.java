package cn.com.miaozhen.mobile.tracking.viewability.origin;

import cn.com.miaozhen.mobile.tracking.p055a.C1465b;
import cn.com.miaozhen.mobile.tracking.viewability.origin.p059e.C1509j;
import cn.com.miaozhen.mobile.tracking.viewability.origin.p059e.EnumC1503d;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import ijiami_release01.NCall;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.d */
/* loaded from: classes.dex */
public class C1499d implements Serializable {

    /* renamed from: a */
    private HashMap<String, String> f6384a;

    /* renamed from: b */
    private String f6385b;

    /* renamed from: c */
    private String f6386c;

    /* renamed from: d */
    private boolean f6387d;

    /* renamed from: e */
    private int f6388e;

    /* renamed from: f */
    private int f6389f;

    /* renamed from: g */
    private int f6390g;

    /* renamed from: h */
    private float f6391h;

    /* renamed from: i */
    private int f6392i;

    /* renamed from: j */
    private List<EnumC1503d> f6393j;

    /* renamed from: a */
    public String m8507a() {
        return (String) NCall.m64616IL(new Object[]{242, this});
    }

    /* renamed from: b */
    public String m8513b() {
        return (String) NCall.m64616IL(new Object[]{248, this});
    }

    /* renamed from: c */
    public int m8516c() {
        return NCall.m64614II(new Object[]{251, this});
    }

    /* renamed from: d */
    public float m8518d() {
        return NCall.m64613IF(new Object[]{253, this});
    }

    /* renamed from: e */
    public int m8520e() {
        return NCall.m64614II(new Object[]{Integer.valueOf(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), this});
    }

    /* renamed from: f */
    public List<EnumC1503d> m8522f() {
        return (List) NCall.m64616IL(new Object[]{257, this});
    }

    /* renamed from: g */
    public int m8524g() {
        return NCall.m64614II(new Object[]{259, this});
    }

    /* renamed from: h */
    public int m8526h() {
        return NCall.m64614II(new Object[]{261, this});
    }

    /* renamed from: i */
    public boolean m8527i() {
        return NCall.m64619IZ(new Object[]{262, this});
    }

    /* renamed from: j */
    public boolean m8528j() {
        return NCall.m64619IZ(new Object[]{263, this});
    }

    /* renamed from: a */
    public String m8508a(String str) {
        return (String) NCall.m64616IL(new Object[]{243, this, str});
    }

    /* renamed from: b */
    public void m8514b(int i10) {
        NCall.m64618IV(new Object[]{249, this, Integer.valueOf(i10)});
    }

    /* renamed from: c */
    public void m8517c(String str) {
        NCall.m64618IV(new Object[]{252, this, str});
    }

    /* renamed from: d */
    public void m8519d(String str) {
        NCall.m64618IV(new Object[]{Integer.valueOf(Constant.ERROR_ROAD_AREA_INVALID), this, str});
    }

    /* renamed from: e */
    public void m8521e(String str) {
        NCall.m64618IV(new Object[]{256, this, str});
    }

    /* renamed from: f */
    public void m8523f(String str) {
        NCall.m64618IV(new Object[]{258, this, str});
    }

    /* renamed from: g */
    public void m8525g(String str) {
        NCall.m64618IV(new Object[]{260, this, str});
    }

    /* renamed from: a */
    private String m8506a(String str, String str2) {
        return (String) NCall.m64616IL(new Object[]{241, this, str, str2});
    }

    /* renamed from: b */
    public void m8515b(String str) {
        NCall.m64618IV(new Object[]{Integer.valueOf(HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), this, str});
    }

    /* renamed from: a */
    public HashMap<String, Object> m8509a(C1509j c1509j) {
        return (HashMap) NCall.m64616IL(new Object[]{Integer.valueOf(Constant.ERROR_GNSS_STATUS_INVALID), this, c1509j});
    }

    /* renamed from: a */
    public void m8510a(int i10) {
        NCall.m64618IV(new Object[]{245, this, Integer.valueOf(i10)});
    }

    /* renamed from: a */
    public void m8511a(HashMap<String, C1465b> map) {
        NCall.m64618IV(new Object[]{246, this, map});
    }

    /* renamed from: a */
    public void m8512a(boolean z10) {
        NCall.m64618IV(new Object[]{247, this, Boolean.valueOf(z10)});
    }
}
