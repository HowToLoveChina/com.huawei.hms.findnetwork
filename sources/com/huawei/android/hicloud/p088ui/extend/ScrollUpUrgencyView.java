package com.huawei.android.hicloud.p088ui.extend;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class ScrollUpUrgencyView<T> extends ListView implements AutoScrollUrgencyData<T> {

    /* renamed from: a */
    public List<T> f17955a;

    /* renamed from: b */
    public int f17956b;

    /* renamed from: c */
    public int f17957c;

    /* renamed from: d */
    public int f17958d;

    /* renamed from: e */
    public int f17959e;

    /* renamed from: f */
    public ScrollUpUrgencyView<T>.C3937b f17960f;

    /* renamed from: g */
    public OnItemClickListener f17961g;

    /* renamed from: h */
    public long f17962h;

    /* renamed from: i */
    public Context f17963i;

    /* renamed from: j */
    public Handler f17964j;

    /* renamed from: k */
    public Runnable f17965k;

    public interface OnItemClickListener {
        void onItemClick(int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.extend.ScrollUpUrgencyView$a */
    public class RunnableC3936a implements Runnable {
        public RunnableC3936a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScrollUpUrgencyView.this.f17963i != null) {
                Activity activity = (Activity) ScrollUpUrgencyView.this.f17963i;
                if (activity.isDestroyed() || activity.isFinishing()) {
                    return;
                }
                ScrollUpUrgencyView.this.m24012m();
                ScrollUpUrgencyView.this.f17964j.postDelayed(this, ScrollUpUrgencyView.this.f17962h);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.extend.ScrollUpUrgencyView$b */
    public class C3937b extends BaseAdapter {

        /* renamed from: com.huawei.android.hicloud.ui.extend.ScrollUpUrgencyView$b$a */
        public class a implements View.OnClickListener {

            /* renamed from: a */
            public final /* synthetic */ int f17968a;

            public a(int i10) {
                this.f17968a = i10;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScrollUpUrgencyView.this.f17961g.onItemClick(this.f17968a % ScrollUpUrgencyView.this.f17956b);
            }
        }

        public C3937b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ScrollUpUrgencyView.this.f17955a == null ? 0 : ScrollUpUrgencyView.this.f17955a.size();
            if (size > 1) {
                return Integer.MAX_VALUE;
            }
            return size;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ScrollUpUrgencyView.this.f17955a.get(i10 % ScrollUpUrgencyView.this.f17956b);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10 % ScrollUpUrgencyView.this.f17956b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            View viewInflate;
            C3938c c3938c;
            if (view == null) {
                c3938c = new C3938c(null);
                viewInflate = LayoutInflater.from(ScrollUpUrgencyView.this.f17963i).inflate(R$layout.hicloud_urgency_scroll_layout, (ViewGroup) null);
                c3938c.f17970a = (TextView) C12809f.m76831d(viewInflate, R$id.hicloud_urgency_content);
                viewInflate.setTag(c3938c);
            } else {
                viewInflate = view;
                c3938c = (C3938c) view.getTag();
            }
            Object obj = ScrollUpUrgencyView.this.f17955a.get(i10 % ScrollUpUrgencyView.this.f17956b);
            if (!TextUtils.isEmpty(ScrollUpUrgencyView.this.mo23935a(obj))) {
                c3938c.f17970a.setText(ScrollUpUrgencyView.this.mo23935a(obj));
                viewInflate.setOnClickListener(new a(i10));
            }
            return viewInflate;
        }

        public /* synthetic */ C3937b(ScrollUpUrgencyView scrollUpUrgencyView, RunnableC3936a runnableC3936a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.extend.ScrollUpUrgencyView$c */
    public static class C3938c {

        /* renamed from: a */
        public TextView f17970a;

        public C3938c() {
        }

        public /* synthetic */ C3938c(RunnableC3936a runnableC3936a) {
            this();
        }
    }

    public ScrollUpUrgencyView(Context context) {
        this(context, null);
    }

    public abstract int getUrgencyViewHeight();

    /* renamed from: i */
    public final void m24008i() {
        setEnabled(false);
        setDivider(null);
        setDividerHeight(0);
        setFastScrollEnabled(false);
    }

    /* renamed from: j */
    public void m24009j() {
        Context context = this.f17963i;
        if (context != null) {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            setSelection(this.f17957c);
        }
    }

    /* renamed from: k */
    public void m24010k() {
        this.f17964j.postDelayed(this.f17965k, 1000L);
    }

    /* renamed from: l */
    public void m24011l() {
        this.f17964j.removeCallbacks(this.f17965k);
    }

    /* renamed from: m */
    public final void m24012m() {
        if (this.f17957c == -1) {
            this.f17958d = 0;
        } else {
            this.f17958d = this.f17959e;
        }
        smoothScrollBy(this.f17958d, 1000);
        setSelection(this.f17957c);
        this.f17957c++;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setData(List<T> list) {
        List<T> list2 = this.f17955a;
        if (list2 == null || this.f17960f == null) {
            return;
        }
        list2.clear();
        this.f17955a.addAll(list);
        this.f17956b = this.f17955a.size();
        setAdapter((ListAdapter) this.f17960f);
        this.f17960f.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f17961g = onItemClickListener;
    }

    public void setTimer(long j10) {
        this.f17962h = j10;
    }

    public ScrollUpUrgencyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollUpUrgencyView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17955a = new ArrayList();
        this.f17957c = -1;
        this.f17960f = new C3937b(this, null);
        this.f17962h = 5000L;
        this.f17964j = new Handler();
        this.f17965k = new RunnableC3936a();
        this.f17963i = context;
        this.f17959e = C11842p.m70840n(context, getUrgencyViewHeight());
        m24008i();
    }
}
