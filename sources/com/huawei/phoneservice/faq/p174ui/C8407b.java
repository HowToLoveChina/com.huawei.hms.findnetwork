package com.huawei.phoneservice.faq.p174ui;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.huawei.phoneservice.faq.AbstractC8274a;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.adapter.SearchAssociativeAdapter;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.response.C8351k;
import com.huawei.phoneservice.faq.response.C8352l;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faqcommon.utils.SdkFaqCommonManager;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.ui.b */
/* loaded from: classes4.dex */
public class C8407b extends AbstractC8274a {

    /* renamed from: j0 */
    public static final String f39194j0 = "com.huawei.phoneservice.faq.ui.b";

    /* renamed from: e0 */
    public ListView f39195e0;

    /* renamed from: f0 */
    public SearchAssociativeAdapter f39196f0;

    /* renamed from: g0 */
    public c f39197g0;

    /* renamed from: h0 */
    public boolean f39198h0;

    /* renamed from: i0 */
    public AdapterView.OnItemClickListener f39199i0 = new a();

    /* renamed from: com.huawei.phoneservice.faq.ui.b$a */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            C8351k c8351k;
            if (!NoDoubleClickUtil.isDoubleClick(view) && adapterView.getId() == R$id.associative_search_content && i10 < adapterView.getAdapter().getCount() && (c8351k = (C8351k) adapterView.getAdapter().getItem(i10)) != null) {
                C8407b.this.f39197g0.mo52077b(c8351k.m52012a(), "completeSearch");
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.b$b */
    public class b extends FaqCallback<C8352l> {
        public b(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, C8352l c8352l) {
            SearchAssociativeAdapter searchAssociativeAdapter;
            List<C8351k> listM52013a;
            if (th2 != null || c8352l == null) {
                return;
            }
            if (c8352l.m52013a() == null || c8352l.m52013a().size() <= 0) {
                searchAssociativeAdapter = C8407b.this.f39196f0;
                listM52013a = null;
            } else {
                searchAssociativeAdapter = C8407b.this.f39196f0;
                listM52013a = c8352l.m52013a();
            }
            searchAssociativeAdapter.m51742a(listM52013a);
            C8407b.this.f39196f0.notifyDataSetChanged();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.b$c */
    public interface c {
        /* renamed from: b */
        void mo52077b(String str, String str2);
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: C1 */
    public int mo51685C1() {
        return R$layout.faq_search_associative_layout;
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: D1 */
    public void mo51686D1(View view) {
        this.f39195e0 = (ListView) view.findViewById(R$id.associative_search_content);
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: F1 */
    public void mo51688F1() {
        SearchAssociativeAdapter searchAssociativeAdapter = new SearchAssociativeAdapter(m51687E1());
        this.f39196f0 = searchAssociativeAdapter;
        this.f39195e0.setAdapter((ListAdapter) searchAssociativeAdapter);
    }

    @Override // com.huawei.phoneservice.faq.AbstractC8274a
    /* renamed from: G1 */
    public void mo51689G1() {
        this.f39195e0.setOnItemClickListener(this.f39199i0);
    }

    /* renamed from: I1 */
    public void m52334I1(c cVar) {
        this.f39197g0 = cVar;
    }

    /* renamed from: J1 */
    public void m52335J1(String str) {
        String str2;
        if (m51687E1() == null) {
            FaqLogger.m51840e(f39194j0, "Activity is null");
            return;
        }
        if (FaqConstants.CHANNEL_HICARE.equals(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL))) {
            str2 = FaqConstants.APP_HICARE;
        } else {
            str2 = "App_" + SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL);
        }
        SdkFaqCommonManager.INSTANCE.searchComplete(m51687E1(), str, str2, SdkFaqManager.getSdk().getSdk("country"), SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_LANGUAGE), new b(C8352l.class, m51687E1()));
    }

    /* renamed from: K1 */
    public void m52336K1(boolean z10) {
        this.f39198h0 = z10;
    }

    /* renamed from: M1 */
    public void m52337M1() {
        SearchAssociativeAdapter searchAssociativeAdapter = this.f39196f0;
        if (searchAssociativeAdapter != null) {
            searchAssociativeAdapter.m51742a(null);
            this.f39196f0.notifyDataSetChanged();
        }
    }

    /* renamed from: N1 */
    public boolean m52338N1() {
        return this.f39198h0;
    }
}
