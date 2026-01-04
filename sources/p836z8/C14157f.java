package p836z8;

import android.text.TextUtils;
import com.huawei.hicloud.notification.manager.HiCloudParamMetaManager;
import com.huawei.hicloud.notification.p106db.bean.ParamMetaDbBean;
import com.huawei.hicloud.notification.p106db.operator.HiCloudParamMetaConfigOperator;
import com.huawei.hicloud.request.appmashup.bean.C4984c;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import fo.C9737a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import p264eo.InterfaceC9529b;
import p292fn.C9733f;
import p514o9.C11839m;
import p673u9.C13138c;
import p815ym.AbstractC14026a;

/* renamed from: z8.f */
/* loaded from: classes3.dex */
public class C14157f {

    /* renamed from: a */
    public final Map<String, C4987f> f63309a;

    /* renamed from: z8.f$b */
    public static class b {

        /* renamed from: a */
        public static final C14157f f63310a = new C14157f();
    }

    /* renamed from: g */
    public static C14157f m84942g() {
        return b.f63310a;
    }

    /* renamed from: p */
    public static /* synthetic */ String m84943p(ParamMetaDbBean paramMetaDbBean) {
        return paramMetaDbBean.getProvider() + "_" + paramMetaDbBean.getEndpoint();
    }

    /* renamed from: q */
    public static /* synthetic */ C4984c m84944q(String str, ParamMetaDbBean paramMetaDbBean) {
        C4984c c4984c = new C4984c();
        ArrayList arrayList = new ArrayList();
        arrayList.add(paramMetaDbBean.getName());
        c4984c.m30021h(arrayList);
        c4984c.m30022i(paramMetaDbBean.getProvider());
        c4984c.m30020g(paramMetaDbBean.getEndpoint());
        c4984c.m30019f(paramMetaDbBean.getAuthType());
        c4984c.m30023j(str);
        return c4984c;
    }

    /* renamed from: r */
    public static /* synthetic */ C4984c m84945r(C4984c c4984c, C4984c c4984c2) {
        c4984c.m30016c().addAll(c4984c2.m30016c());
        return c4984c;
    }

    /* renamed from: e */
    public void m84946e() throws Throwable {
        C11839m.m70688i("ParamsValueManager", "clearConfigAndDB");
        this.f63309a.clear();
        new C13138c().m79021a();
    }

    /* renamed from: f */
    public final List<C4984c> m84947f(List<String> list, final String str) throws Throwable {
        List<ParamMetaDbBean> listQueryParamMetaDbBeanList = new HiCloudParamMetaConfigOperator().queryParamMetaDbBeanList();
        ArrayList arrayList = new ArrayList();
        if (listQueryParamMetaDbBeanList == null || listQueryParamMetaDbBeanList.isEmpty()) {
            return null;
        }
        boolean zM60720O = C9733f.m60705z().m60720O("dataDictLayoutService");
        for (ParamMetaDbBean paramMetaDbBean : listQueryParamMetaDbBeanList) {
            if (!HiCloudParamMetaManager.LOACL_CLIENT.equals(paramMetaDbBean.getProvider()) && zM60720O) {
                paramMetaDbBean.setProvider("layoutServer");
                paramMetaDbBean.setEndpoint("/layoutserver/aggregation/v1/getParams");
                paramMetaDbBean.setAuthType(1);
            }
            if (list.contains(paramMetaDbBean.getName())) {
                arrayList.add(paramMetaDbBean);
                list.remove(paramMetaDbBean.getName());
            }
        }
        return (List) ((Map) arrayList.parallelStream().collect(Collectors.toMap(new Function() { // from class: z8.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C14157f.m84943p((ParamMetaDbBean) obj);
            }
        }, new Function() { // from class: z8.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C14157f.m84944q(str, (ParamMetaDbBean) obj);
            }
        }, new BinaryOperator() { // from class: z8.e
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return C14157f.m84945r((C4984c) obj, (C4984c) obj2);
            }
        }))).values().parallelStream().collect(Collectors.toList());
    }

    /* renamed from: h */
    public String m84948h(String str, String str2, String str3) {
        List<C4987f> listM84950j = m84942g().m84950j(Collections.singletonList(str), null, str2, str3);
        if (AbstractC14026a.m84159a(listM84950j)) {
            C11839m.m70689w("ParamsValueManager", "getParam, values is empty");
            return "";
        }
        C4987f c4987f = listM84950j.get(0);
        if (c4987f == null) {
            C11839m.m70689w("ParamsValueManager", "getParam, paramsValue is empty");
            return "";
        }
        if (!TextUtils.equals(str, c4987f.m30026b())) {
            C11839m.m70689w("ParamsValueManager", "getParam, key not equals");
            return "";
        }
        String strM30027c = c4987f.m30027c();
        C11839m.m70686d("ParamsValueManager", "getParam, key: " + str + ", value: " + strM30027c);
        return strM30027c;
    }

    /* renamed from: i */
    public synchronized List<C4987f> m84949i(List<String> list, List<String> list2, String str) {
        return m84950j(list, list2, str, "");
    }

    /* renamed from: j */
    public synchronized List<C4987f> m84950j(List<String> list, List<String> list2, String str, String str2) {
        try {
            C11839m.m70688i("ParamsValueManager", "getParams, cmd = " + str);
            boolean z10 = list == null || list.isEmpty();
            if ((list2 == null || list2.isEmpty()) && z10) {
                C11839m.m70689w("ParamsValueManager", "paramKeyList and realTimeKeyList is null or empty");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<String> arrayList2 = new ArrayList<>();
            if (list != null && list.size() > 0) {
                arrayList2 = m84953m(list, arrayList);
            }
            if (list2 != null) {
                arrayList2.addAll(list2);
            }
            m84955o(arrayList2, arrayList, str, str2);
            C11839m.m70688i("ParamsValueManager", "getParams, cmd:" + str + ", paramsValueList size:" + arrayList.size());
            C11839m.m70686d("ParamsValueManager", arrayList.toString());
            return arrayList;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: k */
    public final C4987f m84951k(String str) {
        C4987f c4987f = this.f63309a.get(str);
        if (c4987f == null || Long.parseLong(c4987f.m30025a()) <= System.currentTimeMillis()) {
            return null;
        }
        return c4987f;
    }

    /* renamed from: l */
    public final C4987f m84952l(String str) {
        C4987f c4987f;
        List<C4987f> listM79023c = new C13138c().m79023c(str);
        if (listM79023c == null || listM79023c.size() <= 0 || (c4987f = listM79023c.get(0)) == null || Long.parseLong(c4987f.m30025a()) <= System.currentTimeMillis()) {
            return null;
        }
        return c4987f;
    }

    /* renamed from: m */
    public final List<String> m84953m(List<String> list, List<C4987f> list2) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            C4987f c4987fM84951k = m84951k(str);
            if (c4987fM84951k != null) {
                list2.add(c4987fM84951k);
            } else {
                C4987f c4987fM84952l = m84952l(str);
                if (c4987fM84952l != null) {
                    list2.add(c4987fM84952l);
                } else {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    public void m84954n(List<String> list, List<C4987f> list2, String str) {
        m84955o(list, list2, str, "");
    }

    /* renamed from: o */
    public void m84955o(List<String> list, final List<C4987f> list2, String str, String str2) throws InterruptedException {
        List<C4984c> listM84947f;
        if (list == null || list.size() == 0 || (listM84947f = m84947f(list, str2)) == null || listM84947f.size() == 0) {
            return;
        }
        int size = listM84947f.size();
        C11839m.m70688i("ParamsValueManager", "getValueFromServer count = " + size);
        final CountDownLatch countDownLatch = new CountDownLatch(size);
        m84959v(listM84947f, new InterfaceC9529b() { // from class: z8.b
            @Override // p264eo.InterfaceC9529b
            /* renamed from: a */
            public final void mo59522a(List list3) {
                this.f63305a.m84956s(countDownLatch, list2, list3);
            }
        }, str, countDownLatch);
        try {
            countDownLatch.await(30L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            C11839m.m70687e("ParamsValueManager", "getParamsValue from server time out");
        }
    }

    /* renamed from: s */
    public final /* synthetic */ void m84956s(CountDownLatch countDownLatch, List list, List list2) {
        C11839m.m70688i("ParamsValueManager", "getValueFromServer callback success count = " + countDownLatch.getCount());
        if (list2 != null) {
            m84962y(list2);
            list.addAll(list2);
        }
        C11839m.m70688i("ParamsValueManager", "getValueFromServer before countDown count = " + countDownLatch.getCount());
        countDownLatch.countDown();
    }

    /* renamed from: t */
    public void m84957t() throws Throwable {
        C11839m.m70688i("ParamsValueManager", "notifyParamsValueExpires");
        this.f63309a.clear();
        new C13138c().m79025e();
    }

    /* renamed from: u */
    public void m84958u(String str) throws Throwable {
        C11839m.m70688i("ParamsValueManager", "notifyParamsValueExpires for:" + str);
        this.f63309a.remove(str);
        new C13138c().m79026f(str);
    }

    /* renamed from: v */
    public final void m84959v(List<C4984c> list, InterfaceC9529b interfaceC9529b, String str, CountDownLatch countDownLatch) {
        Iterator<C4984c> it = list.iterator();
        while (it.hasNext()) {
            C9737a.m60788a().m60789b(it.next(), interfaceC9529b, str, countDownLatch);
        }
    }

    /* renamed from: w */
    public final void m84960w(List<C4987f> list) {
        for (C4987f c4987f : list) {
            this.f63309a.put(c4987f.m30026b(), c4987f);
        }
    }

    /* renamed from: x */
    public final void m84961x(List<C4987f> list) {
        new C13138c().m79024d(list);
    }

    /* renamed from: y */
    public void m84962y(List<C4987f> list) {
        C11839m.m70688i("ParamsValueManager", "updateParamValue");
        if (list == null || list.size() <= 0) {
            return;
        }
        C11839m.m70688i("ParamsValueManager", "updateParamValue start");
        C11839m.m70686d("ParamsValueManager", list.toString());
        for (C4987f c4987f : list) {
            try {
                c4987f.m30028d(String.valueOf((Long.parseLong(c4987f.m30025a()) * 1000) + System.currentTimeMillis()));
            } catch (Exception e10) {
                C11839m.m70687e("ParamsValueManager", "updateParamValue occur error : " + e10.getMessage());
            }
        }
        m84960w(list);
        m84961x(list);
        C11839m.m70688i("ParamsValueManager", "updateParamValue end");
    }

    public C14157f() {
        this.f63309a = new ConcurrentHashMap();
    }
}
