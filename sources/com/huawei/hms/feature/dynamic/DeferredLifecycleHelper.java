package com.huawei.hms.feature.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes8.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    public static final int STATUS_ONCREATED = 1;
    public static final int STATUS_ONCREATEVIEW = 2;
    public static final int STATUS_ONINFLATE = 0;
    public static final int STATUS_ONRESUME = 5;
    public static final int STATUS_ONSTART = 4;

    /* renamed from: e */
    public static final String f24594e = "DeferredLifecycleHelper";

    /* renamed from: a */
    public T f24595a;

    /* renamed from: b */
    public Bundle f24596b;

    /* renamed from: c */
    public LinkedList<InterfaceC5311g> f24597c;

    /* renamed from: d */
    public OnDelegateCreatedListener<T> f24598d = new C5305a();

    /* renamed from: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper$a */
    public class C5305a implements OnDelegateCreatedListener<T> {
        public C5305a() {
        }

        @Override // com.huawei.hms.feature.dynamic.OnDelegateCreatedListener
        public void onDelegateCreated(T t10) {
            DeferredLifecycleHelper.this.f24595a = t10;
            Iterator it = DeferredLifecycleHelper.this.f24597c.iterator();
            while (it.hasNext()) {
                ((InterfaceC5311g) it.next()).mo31852a(DeferredLifecycleHelper.this.f24595a);
            }
            DeferredLifecycleHelper.this.f24597c.clear();
            DeferredLifecycleHelper.this.f24596b = null;
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper$b */
    public class C5306b implements InterfaceC5311g {

        /* renamed from: a */
        public final /* synthetic */ Activity f24600a;

        /* renamed from: b */
        public final /* synthetic */ Bundle f24601b;

        /* renamed from: c */
        public final /* synthetic */ Bundle f24602c;

        public C5306b(Activity activity, Bundle bundle, Bundle bundle2) {
            this.f24600a = activity;
            this.f24601b = bundle;
            this.f24602c = bundle2;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public int mo31851a() {
            return 0;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public void mo31852a(LifecycleDelegate lifecycleDelegate) {
            DeferredLifecycleHelper.this.f24595a.onInflate(this.f24600a, this.f24601b, this.f24602c);
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper$c */
    public class C5307c implements InterfaceC5311g {

        /* renamed from: a */
        public final /* synthetic */ Bundle f24604a;

        public C5307c(Bundle bundle) {
            this.f24604a = bundle;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public int mo31851a() {
            return 1;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public void mo31852a(LifecycleDelegate lifecycleDelegate) {
            Log.d(DeferredLifecycleHelper.f24594e, "IDelegateLifeCycleCall onCreate:");
            lifecycleDelegate.onCreate(this.f24604a);
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper$d */
    public class C5308d implements InterfaceC5311g {

        /* renamed from: a */
        public final /* synthetic */ FrameLayout f24606a;

        /* renamed from: b */
        public final /* synthetic */ LayoutInflater f24607b;

        /* renamed from: c */
        public final /* synthetic */ ViewGroup f24608c;

        /* renamed from: d */
        public final /* synthetic */ Bundle f24609d;

        public C5308d(FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f24606a = frameLayout;
            this.f24607b = layoutInflater;
            this.f24608c = viewGroup;
            this.f24609d = bundle;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public int mo31851a() {
            return 2;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public void mo31852a(LifecycleDelegate lifecycleDelegate) {
            this.f24606a.removeAllViews();
            this.f24606a.addView(DeferredLifecycleHelper.this.f24595a.onCreateView(this.f24607b, this.f24608c, this.f24609d));
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper$e */
    public class C5309e implements InterfaceC5311g {
        public C5309e() {
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public int mo31851a() {
            return 4;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public void mo31852a(LifecycleDelegate lifecycleDelegate) {
            Log.d(DeferredLifecycleHelper.f24594e, "IDelegateLifeCycleCall onStart:");
            lifecycleDelegate.onStart();
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper$f */
    public class C5310f implements InterfaceC5311g {
        public C5310f() {
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public int mo31851a() {
            return 5;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.InterfaceC5311g
        /* renamed from: a */
        public void mo31852a(LifecycleDelegate lifecycleDelegate) {
            Log.d(DeferredLifecycleHelper.f24594e, "IDelegateLifeCycleCall onResume:");
            lifecycleDelegate.onResume();
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DeferredLifecycleHelper$g */
    public interface InterfaceC5311g {
        /* renamed from: a */
        int mo31851a();

        /* renamed from: a */
        void mo31852a(LifecycleDelegate lifecycleDelegate);
    }

    public abstract void createDelegate(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    public T getDelegate() {
        return this.f24595a;
    }

    public void onCreate(Bundle bundle) {
        m31849a(bundle, new C5307c(bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m31849a(bundle, new C5308d(frameLayout, layoutInflater, viewGroup, bundle));
        return frameLayout;
    }

    public void onDestroy() {
        T t10 = this.f24595a;
        if (t10 != null) {
            t10.onDestroy();
        } else {
            m31848a(0);
        }
    }

    public void onDestroyView() {
        T t10 = this.f24595a;
        if (t10 != null) {
            t10.onDestroyView();
        } else {
            m31848a(1);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        m31849a(bundle2, new C5306b(activity, bundle, bundle2));
    }

    public void onLowMemory() {
        T t10 = this.f24595a;
        if (t10 != null) {
            t10.onLowMemory();
        }
    }

    public void onPause() {
        T t10 = this.f24595a;
        if (t10 != null) {
            t10.onPause();
        } else {
            m31848a(5);
        }
    }

    public void onResume() {
        m31849a((Bundle) null, new C5310f());
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t10 = this.f24595a;
        if (t10 != null) {
            t10.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f24596b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        m31849a((Bundle) null, new C5309e());
    }

    public void onStop() {
        T t10 = this.f24595a;
        if (t10 != null) {
            t10.onStop();
        } else {
            m31848a(4);
        }
    }

    /* renamed from: a */
    private void m31848a(int i10) {
        while (!this.f24597c.isEmpty() && this.f24597c.getLast().mo31851a() >= i10) {
            this.f24597c.removeLast();
        }
    }

    /* renamed from: a */
    private void m31849a(Bundle bundle, InterfaceC5311g interfaceC5311g) {
        T t10 = this.f24595a;
        if (t10 != null) {
            interfaceC5311g.mo31852a(t10);
            return;
        }
        if (this.f24597c == null) {
            this.f24597c = new LinkedList<>();
        }
        this.f24597c.add(interfaceC5311g);
        if (bundle != null) {
            Bundle bundle2 = this.f24596b;
            if (bundle2 == null) {
                Object objClone = bundle.clone();
                if (objClone != null && (objClone instanceof Bundle)) {
                    this.f24596b = (Bundle) objClone;
                }
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.f24598d);
    }
}
