package com.huawei.phoneservice.feedback.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ProblemSuggestPhotoAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<MediaItem> f39483a = new ArrayList();

    /* renamed from: b */
    public Context f39484b;

    /* renamed from: c */
    public InterfaceC8460b f39485c;

    /* renamed from: com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter$a */
    public class ViewOnClickListenerC8459a implements View.OnClickListener {

        /* renamed from: a */
        public int f39486a;

        public ViewOnClickListenerC8459a(int i10) {
            this.f39486a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view) || ProblemSuggestPhotoAdapter.this.f39485c == null) {
                return;
            }
            int id2 = view.getId();
            if (id2 == R$id.feedback_sdk_iv_pic) {
                ProblemSuggestPhotoAdapter.this.f39485c.mo52609a(this.f39486a);
            } else if (id2 == R$id.feedback_sdk_iv_add) {
                ProblemSuggestPhotoAdapter.this.f39485c.mo52611f();
            } else if (id2 == R$id.feedback_sdk_iv_del) {
                ProblemSuggestPhotoAdapter.this.f39485c.mo52610b(this.f39486a);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter$b */
    public interface InterfaceC8460b {
        /* renamed from: a */
        void mo52609a(int i10);

        /* renamed from: b */
        void mo52610b(int i10);

        /* renamed from: f */
        void mo52611f();
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter$c */
    public static class C8461c {

        /* renamed from: a */
        public ImageView f39488a;

        /* renamed from: b */
        public ImageView f39489b;

        /* renamed from: c */
        public ImageView f39490c;
    }

    public ProblemSuggestPhotoAdapter(Context context) {
        this.f39484b = context;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MediaItem getItem(int i10) {
        List<MediaItem> list = this.f39483a;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f39483a.get(i10);
    }

    /* renamed from: c */
    public void m52607c(InterfaceC8460b interfaceC8460b) {
        this.f39485c = interfaceC8460b;
    }

    /* renamed from: d */
    public void m52608d(List<MediaItem> list) {
        this.f39483a = list;
        if (list == null) {
            this.f39483a = new ArrayList();
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f39483a.size() >= SdkProblemManager.getMaxFileCount() ? SdkProblemManager.getMaxFileCount() : this.f39483a.size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        C8461c c8461c;
        if (view == null) {
            c8461c = new C8461c();
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.feedback_sdk_problem_item_image, viewGroup, false);
            c8461c.f39488a = (ImageView) viewInflate.findViewById(R$id.feedback_sdk_iv_pic);
            c8461c.f39489b = (ImageView) viewInflate.findViewById(R$id.feedback_sdk_iv_del);
            c8461c.f39490c = (ImageView) viewInflate.findViewById(R$id.feedback_sdk_iv_add);
            viewInflate.setTag(c8461c);
        } else {
            viewInflate = view;
            c8461c = (C8461c) view.getTag();
        }
        if (i10 != getCount() - 1 || this.f39483a.size() >= SdkProblemManager.getMaxFileCount()) {
            c8461c.f39488a.setVisibility(0);
            c8461c.f39490c.setVisibility(8);
            c8461c.f39489b.setVisibility(0);
            ViewOnClickListenerC8459a viewOnClickListenerC8459a = new ViewOnClickListenerC8459a(i10);
            c8461c.f39489b.setOnClickListener(viewOnClickListenerC8459a);
            c8461c.f39488a.setOnClickListener(viewOnClickListenerC8459a);
            MediaItem item = getItem(i10);
            if (this.f39484b != null && item != null && item.getFilePath() != null && c8461c.f39488a != null) {
                ComponentCallbacks2C1546b.m8904t(this.f39484b.getApplicationContext()).m8985s(item.getFilePath()).m8965n(c8461c.f39488a);
            }
        } else {
            c8461c.f39488a.setVisibility(8);
            c8461c.f39490c.setVisibility(0);
            c8461c.f39489b.setVisibility(8);
            c8461c.f39490c.setOnClickListener(new ViewOnClickListenerC8459a(i10));
        }
        return viewInflate;
    }
}
