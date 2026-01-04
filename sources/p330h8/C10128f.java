package p330h8;

import com.huawei.hicloud.notification.p106db.bean.ParamMetaDbBean;
import com.huawei.hicloud.notification.p106db.operator.HiCloudParamMetaConfigOperator;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import p015ak.C0241z;
import p316gk.InterfaceC9958h;
import p514o9.C11839m;
import p836z8.C14157f;

/* renamed from: h8.f */
/* loaded from: classes2.dex */
public class C10128f {

    /* renamed from: a */
    public Map<String, Supplier> f49376a = new HashMap();

    /* renamed from: j */
    public static /* synthetic */ Object m63042j(String str) {
        return str;
    }

    /* renamed from: k */
    public static /* synthetic */ Object m63043k(String str) {
        return Integer.valueOf(C0241z.m1685c(str));
    }

    /* renamed from: l */
    public static /* synthetic */ Object m63044l(String str) {
        return Long.valueOf(C0241z.m1688f(str));
    }

    /* renamed from: m */
    public static /* synthetic */ Object m63045m(String str) {
        return C0241z.m1683a(str, Double.valueOf(0.0d));
    }

    /* renamed from: f */
    public final void m63046f(List<String> list, List<String> list2) throws Throwable {
        this.f49376a.clear();
        HiCloudParamMetaConfigOperator hiCloudParamMetaConfigOperator = new HiCloudParamMetaConfigOperator();
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(list, list2, "ParamMetaSatisfy");
        if (listM84949i != null) {
            for (C4987f c4987f : listM84949i) {
                if (c4987f != null) {
                    String strM30026b = c4987f.m30026b();
                    final String strM30027c = c4987f.m30027c();
                    int iQueryParamMetaTypeByKey = hiCloudParamMetaConfigOperator.queryParamMetaTypeByKey(strM30026b);
                    if (1 == iQueryParamMetaTypeByKey) {
                        this.f49376a.put(strM30026b, new Supplier() { // from class: h8.b
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return C10128f.m63042j(strM30027c);
                            }
                        });
                    } else if (2 == iQueryParamMetaTypeByKey) {
                        this.f49376a.put(strM30026b, new Supplier() { // from class: h8.c
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return C10128f.m63043k(strM30027c);
                            }
                        });
                    } else if (3 == iQueryParamMetaTypeByKey) {
                        this.f49376a.put(strM30026b, new Supplier() { // from class: h8.d
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return C10128f.m63044l(strM30027c);
                            }
                        });
                    } else if (4 == iQueryParamMetaTypeByKey) {
                        this.f49376a.put(strM30026b, new Supplier() { // from class: h8.e
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return C10128f.m63045m(strM30027c);
                            }
                        });
                    }
                }
            }
        }
        C11839m.m70688i("DoParamMetaSatisfy", "calculateValueMap value size = " + this.f49376a.size());
    }

    /* renamed from: g */
    public final List<InterfaceC9958h> m63047g() throws Throwable {
        ArrayList arrayList = new ArrayList();
        List<ParamMetaDbBean> listQueryParamMetaNameTypeList = new HiCloudParamMetaConfigOperator().queryParamMetaNameTypeList();
        if (listQueryParamMetaNameTypeList != null) {
            for (ParamMetaDbBean paramMetaDbBean : listQueryParamMetaNameTypeList) {
                if (paramMetaDbBean != null) {
                    if (1 == paramMetaDbBean.getType()) {
                        arrayList.add(InterfaceC9958h.m61774d(paramMetaDbBean.getName()));
                    } else if (2 == paramMetaDbBean.getType()) {
                        arrayList.add(InterfaceC9958h.m61771a(paramMetaDbBean.getName()));
                    } else if (3 == paramMetaDbBean.getType()) {
                        arrayList.add(InterfaceC9958h.m61773c(paramMetaDbBean.getName()));
                    } else if (4 == paramMetaDbBean.getType()) {
                        arrayList.add(InterfaceC9958h.m61776g(paramMetaDbBean.getName()));
                    }
                }
            }
        }
        C11839m.m70686d("DoParamMetaSatisfy", "terms size = " + arrayList.size());
        return arrayList;
    }

    /* renamed from: h */
    public final Object m63048h(String str) {
        return this.f49376a.get(str).get();
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0238  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m63049i(java.util.List<java.lang.String> r19, java.util.List<java.lang.String> r20, java.lang.String r21, int r22, java.util.LinkedHashMap<java.lang.String, java.lang.String> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p330h8.C10128f.m63049i(java.util.List, java.util.List, java.lang.String, int, java.util.LinkedHashMap):boolean");
    }

    /* renamed from: n */
    public final void m63050n(List<String> list, List<String> list2, Collection<String> collection) {
        if (collection == null) {
            C11839m.m70689w("DoParamMetaSatisfy", "triggerParam is empty");
            return;
        }
        C11839m.m70686d("DoParamMetaSatisfy", "before merge, params = " + list.toString() + ", realTimeParams = " + list2.toString() + ", triggerParams = " + collection.toString());
        for (String str : collection) {
            if (!list.contains(str) && !list2.contains(str)) {
                list.add(str);
            }
        }
        C11839m.m70688i("DoParamMetaSatisfy", "after merge, params size = " + list.size() + ", realTimeParams = " + list2.size());
    }

    /* renamed from: o */
    public final boolean m63051o(Collection<String> collection, LinkedHashMap<String, String> linkedHashMap) {
        if (collection == null) {
            return true;
        }
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        StringBuilder sb2 = new StringBuilder("{");
        try {
            for (String str : collection) {
                if (this.f49376a.get(str) == null) {
                    C11839m.m70689w("DoParamMetaSatisfy", "trigger value not exsits, tirgger param = " + str);
                    sb2.append("param = ");
                    sb2.append(str);
                    sb2.append(", not exsits");
                    sb2.append(";");
                    sb2.append("}");
                    linkedHashMap.put("trigger_calculate_info", sb2.toString());
                    return false;
                }
                if (this.f49376a.get(str) != null) {
                    C11839m.m70686d("DoParamMetaSatisfy", "param = " + str + ", value = " + this.f49376a.get(str).get());
                    sb2.append("param = ");
                    sb2.append(str);
                    sb2.append(", value = ");
                    sb2.append(this.f49376a.get(str).get());
                    sb2.append(";");
                }
            }
            return true;
        } finally {
            sb2.append("}");
            linkedHashMap.put("trigger_calculate_info", sb2.toString());
        }
    }
}
