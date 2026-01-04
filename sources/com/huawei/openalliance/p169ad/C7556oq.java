package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.AbstractC7842u;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.oq */
/* loaded from: classes8.dex */
public class C7556oq {

    /* renamed from: c */
    private static C7556oq f35146c;

    /* renamed from: e */
    private int f35148e = 0;

    /* renamed from: f */
    private int f35149f = 0;

    /* renamed from: g */
    private int f35150g = 0;

    /* renamed from: h */
    private int f35151h = 0;

    /* renamed from: i */
    private int f35152i = 0;

    /* renamed from: j */
    private int f35153j = 0;

    /* renamed from: k */
    private int f35154k = 0;

    /* renamed from: l */
    private final int f35155l = 100;

    /* renamed from: m */
    private final int f35156m;

    /* renamed from: n */
    private final InterfaceC7146gc f35157n;

    /* renamed from: a */
    private static final byte[] f35144a = new byte[0];

    /* renamed from: b */
    private static final byte[] f35145b = new byte[0];

    /* renamed from: d */
    private static Map<String, String[]> f35147d = new ConcurrentHashMap();

    private C7556oq(Context context) {
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        this.f35157n = interfaceC7146gcM43316b;
        this.f35156m = interfaceC7146gcM43316b.mo43056ad();
    }

    /* renamed from: c */
    private static C7556oq m46407c(Context context) {
        C7556oq c7556oq;
        synchronized (f35144a) {
            try {
                if (f35146c == null) {
                    f35146c = new C7556oq(context);
                }
                c7556oq = f35146c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7556oq;
    }

    /* renamed from: a */
    public static C7556oq m46397a(Context context) {
        return m46407c(context);
    }

    /* renamed from: b */
    public void m46409b(final Context context) {
        AbstractC7834m.m48490j(new Runnable() { // from class: com.huawei.openalliance.ad.oq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!C7556oq.this.f35157n.mo43054ab()) {
                        C7556oq.f35147d.clear();
                        AbstractC7185ho.m43820b("CCP", "disabled");
                        return;
                    }
                    int iMo43055ac = C7556oq.this.f35157n.mo43055ac() * 1000;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - C7556oq.this.f35157n.mo43432cc() <= iMo43055ac && iMo43055ac != 0) {
                        AbstractC7185ho.m43821b("CCP", "check failed in %s", Integer.valueOf(iMo43055ac));
                        return;
                    }
                    AbstractC7185ho.m43820b("CCP", "check pass");
                    C7556oq.this.f35157n.mo43473l(jCurrentTimeMillis);
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        C7556oq.this.m46399a((Activity) context2);
                    } else {
                        AbstractC7185ho.m43820b("CCP", "not target");
                    }
                } catch (Throwable th2) {
                    AbstractC7185ho.m43827d("CCP", "process error: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    /* renamed from: b */
    private String[] m46406b(Activity activity) {
        this.f35148e = 0;
        String[] strArr = new String[0];
        List<String> listM46398a = m46398a(activity.getWindow().getDecorView(), this.f35153j);
        if (!AbstractC7760bg.m47767a(listM46398a)) {
            return (String[]) listM46398a.toArray(new String[listM46398a.size()]);
        }
        AbstractC7185ho.m43817a("CCP", "get contentAuto is null");
        return strArr;
    }

    /* renamed from: a */
    public String m46408a() {
        if (this.f35157n.mo43054ab()) {
            AbstractC7185ho.m43817a("CCP", "get AutoContentBundle");
            return AbstractC7758be.m47742b(f35147d);
        }
        AbstractC7185ho.m43817a("CCP", "get AutoContentBundle off");
        f35147d.clear();
        return null;
    }

    /* renamed from: a */
    private List<String> m46398a(View view, int i10) {
        if (view == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            if (i10 + 1 >= 100) {
                AbstractC7185ho.m43817a("CCP", "autoContentRurDepth outer round 100");
                return arrayList;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (!(childAt instanceof PPSNativeView)) {
                    if ((childAt instanceof TextView) && childAt.isShown()) {
                        synchronized (f35145b) {
                            try {
                                String string = ((TextView) childAt).getText().toString();
                                int i12 = this.f35148e;
                                if (i12 >= this.f35156m || i12 + string.length() <= this.f35156m) {
                                    int i13 = this.f35148e;
                                    if (i13 < this.f35156m) {
                                        this.f35148e = i13 + string.length();
                                        if (!TextUtils.isEmpty(string)) {
                                            arrayList.add(string);
                                        }
                                    }
                                } else {
                                    this.f35148e += string.length();
                                    int length = (string.length() - this.f35148e) + this.f35156m;
                                    if (length > string.length()) {
                                        length = string.length();
                                    }
                                    string = string.substring(0, length);
                                    if (!TextUtils.isEmpty(string)) {
                                        arrayList.add(string);
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    int i14 = this.f35148e;
                    int i15 = this.f35156m;
                    if (i14 >= i15) {
                        AbstractC7185ho.m43818a("CCP", "autoContentSize maxSize %s", Integer.valueOf(i15));
                        return arrayList;
                    }
                    arrayList.addAll(m46398a(childAt, this.f35153j));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46399a(Activity activity) {
        String simpleName = activity.getClass().getSimpleName();
        AbstractC7185ho.m43818a("CCP", "getActivityInfo-name: %s", activity.getClass().getSimpleName());
        if (!AbstractC7806cz.m48165b(simpleName)) {
            f35147d.clear();
            f35147d.put("activityName", new String[]{simpleName});
        }
        Map<Integer, String> mapM48506a = AbstractC7842u.m48506a(activity, this.f35157n.mo43057ae());
        if (!C7765bl.m47802a(mapM48506a)) {
            m46400a(activity, mapM48506a);
            return;
        }
        AbstractC7185ho.m43820b("CCP", "auto process");
        String[] strArrM46406b = m46406b(activity);
        if (strArrM46406b == null || strArrM46406b.length <= 0) {
            return;
        }
        f35147d.put(Constants.AUTOCONTENT_CONTENT_AUTO, strArrM46406b);
    }

    /* renamed from: a */
    private void m46400a(Activity activity, Map<Integer, String> map) {
        HashMap map2 = new HashMap();
        this.f35149f = 0;
        this.f35151h = 0;
        this.f35152i = 0;
        this.f35150g = 0;
        this.f35154k = 0;
        m46401a(activity.getWindow().getDecorView(), map, map2, this.f35153j);
        if (C7765bl.m47802a(map2)) {
            AbstractC7185ho.m43817a("CCP", "no get cfg, getAutoContent");
            String[] strArrM46406b = m46406b(activity);
            if (strArrM46406b == null || strArrM46406b.length <= 0) {
                return;
            }
            f35147d.put(Constants.AUTOCONTENT_CONTENT_AUTO, strArrM46406b);
            return;
        }
        m46404a(map2, "title", f35147d);
        if (!m46404a(map2, "content", f35147d)) {
            AbstractC7185ho.m43817a("CCP", "no get cfg content, getAutoContent");
            String[] strArrM46406b2 = m46406b(activity);
            if (strArrM46406b2 != null && strArrM46406b2.length > 0) {
                f35147d.put(Constants.AUTOCONTENT_CONTENT_AUTO, strArrM46406b2);
            }
        }
        m46404a(map2, Constants.AUTOCONTENT_CATEGORY, f35147d);
        m46404a(map2, Constants.AUTOCONTENT_SUBCATEGORY, f35147d);
    }

    /* renamed from: a */
    private void m46401a(View view, Map<Integer, String> map, Map<String, List<String>> map2, int i10) {
        String str;
        this.f35154k++;
        if (view instanceof ViewGroup) {
            int i11 = i10 + 1;
            if (i11 < 100) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                    View childAt = viewGroup.getChildAt(i12);
                    if (childAt instanceof TextView) {
                        m46403a(map, map2, childAt);
                    }
                    if (this.f35154k >= 100) {
                        str = "clctCfgContentRur outer round " + this.f35154k;
                    } else {
                        m46401a(childAt, map, map2, i11);
                    }
                }
                return;
            }
            str = "clctCfgContentDepth outer round 100";
            AbstractC7185ho.m43817a("CCP", str);
        }
    }

    /* renamed from: a */
    private void m46403a(Map<Integer, String> map, Map<String, List<String>> map2, View view) {
        int length;
        int i10;
        int i11;
        int id2 = view.getId();
        if (!map.containsKey(Integer.valueOf(id2))) {
            AbstractC7185ho.m43820b("CCP", "invalid id");
            return;
        }
        TextView textView = (TextView) view;
        String string = textView.getText() != null ? textView.getText().toString() : "";
        length = string.length();
        String str = map.get(Integer.valueOf(id2));
        List<String> arrayList = new ArrayList<>();
        if (map2.containsKey(str)) {
            arrayList = map2.get(str);
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        String str2 = str != null ? str : "";
        switch (str2) {
            case "category":
                i10 = this.f35151h;
                i11 = length + i10;
                this.f35151h = i11;
                break;
            case "title":
                i10 = this.f35150g;
                i11 = length + i10;
                this.f35150g = i11;
                break;
            case "content":
                i10 = this.f35149f;
                i11 = length + i10;
                this.f35149f = i11;
                break;
            case "subcategory":
                i10 = this.f35152i;
                i11 = length + i10;
                this.f35152i = i11;
                break;
            default:
                i10 = 0;
                i11 = 0;
                break;
        }
        int i12 = this.f35156m;
        if (i10 < i12) {
            if (i11 >= i12) {
                int length2 = (string.length() + this.f35156m) - i11;
                if (!TextUtils.isEmpty(string.substring(0, length2))) {
                    arrayList.add(string.substring(0, length2));
                }
            } else if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
        }
        map2.put(str2, arrayList);
    }

    /* renamed from: a */
    private boolean m46404a(Map<String, List<String>> map, String str, Map<String, String[]> map2) {
        if (!map.containsKey(str)) {
            return false;
        }
        List<String> list = map.get(str);
        if (AbstractC7760bg.m47767a(list)) {
            AbstractC7185ho.m43818a("CCP", "get %s is null ", str);
            return false;
        }
        map2.put(str, (String[]) list.toArray(new String[list.size()]));
        return true;
    }
}
