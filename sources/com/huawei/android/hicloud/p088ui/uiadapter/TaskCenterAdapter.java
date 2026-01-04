package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.uiextend.bean.TaskCenterItem;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import java.util.ArrayList;
import java.util.List;
import p778xk.C13823d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TaskCenterAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public IRecyclerViewOnListener f18935d;

    /* renamed from: e */
    public Context f18936e;

    /* renamed from: f */
    public List<TaskCenterItem> f18937f;

    /* renamed from: g */
    public int f18938g;

    public interface IRecyclerViewOnListener {
        void onItemClick(int i10, TaskCenterItem taskCenterItem);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.TaskCenterAdapter$a */
    public static class C4080a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f18939u;

        /* renamed from: v */
        public TextView f18940v;

        /* renamed from: w */
        public TextView f18941w;

        /* renamed from: x */
        public TextView f18942x;

        /* renamed from: y */
        public Button f18943y;

        /* renamed from: z */
        public View f18944z;

        public C4080a(View view) {
            super(view);
            this.f18939u = (ImageView) C12809f.m76831d(view, R$id.item_icon);
            this.f18940v = (TextView) C12809f.m76831d(view, R$id.item_title);
            this.f18941w = (TextView) C12809f.m76831d(view, R$id.item_fragment_num);
            this.f18942x = (TextView) C12809f.m76831d(view, R$id.item_description);
            this.f18943y = (Button) C12809f.m76831d(view, R$id.item_button);
            this.f18944z = C12809f.m76831d(view, R$id.line_view);
        }
    }

    public TaskCenterAdapter(Context context) {
        this.f18936e = context;
    }

    /* renamed from: E */
    public List<TaskCenterItem> m25295E() {
        List<TaskCenterItem> list = this.f18937f;
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: F */
    public final /* synthetic */ void m25296F(int i10, TaskCenterItem taskCenterItem, View view) {
        IRecyclerViewOnListener iRecyclerViewOnListener = this.f18935d;
        if (iRecyclerViewOnListener != null) {
            iRecyclerViewOnListener.onItemClick(i10, taskCenterItem);
        }
    }

    /* renamed from: G */
    public void m25297G(int i10) {
        this.f18938g = i10;
    }

    /* renamed from: H */
    public void m25298H(List<TaskCenterItem> list) {
        if (list == null) {
            return;
        }
        this.f18937f = list;
    }

    /* renamed from: I */
    public void m25299I(IRecyclerViewOnListener iRecyclerViewOnListener) {
        this.f18935d = iRecyclerViewOnListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<TaskCenterItem> list = this.f18937f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, final int i10) {
        final TaskCenterItem taskCenterItem = m25295E().get(i10);
        C4080a c4080a = (C4080a) abstractC0833c0;
        c4080a.f18940v.setText(taskCenterItem.getTitle());
        c4080a.f18941w.setText(this.f18936e.getString(R$string.task_center_fragment, Integer.valueOf(taskCenterItem.getFragmentNumber())));
        if (TextUtils.isEmpty(taskCenterItem.getDescription())) {
            c4080a.f18942x.setVisibility(8);
        } else {
            c4080a.f18942x.setVisibility(0);
            c4080a.f18942x.setText(taskCenterItem.getDescription());
        }
        Drawable drawableM82907C = C13823d.m82904y().m82907C(taskCenterItem.getImageUrl());
        if (drawableM82907C != null) {
            c4080a.f18939u.setBackground(drawableM82907C);
        }
        c4080a.f18943y.setText(taskCenterItem.getButtonText());
        c4080a.f18943y.setOnClickListener(new View.OnClickListener() { // from class: ae.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f493a.m25296F(i10, taskCenterItem, view);
            }
        });
        if (i10 == mo721e() - 1 || this.f18938g > 1) {
            c4080a.f18944z.setVisibility(8);
        } else {
            c4080a.f18944z.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new C4080a(LayoutInflater.from(this.f18936e).inflate(R$layout.task_center_item, viewGroup, false));
    }
}
