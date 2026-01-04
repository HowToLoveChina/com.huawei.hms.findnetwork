package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uilistener.OnDataRange;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordOperation;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ne.C11667a;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupRecordsAdapter extends BaseAdapter implements OnDataRange {

    /* renamed from: a */
    public Context f18557a;

    /* renamed from: d */
    public LayoutInflater f18560d;

    /* renamed from: e */
    public String f18561e;

    /* renamed from: c */
    public boolean f18559c = false;

    /* renamed from: b */
    public List<CBSSyncRecordOperation> f18558b = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupRecordsAdapter$b */
    public static class C4030b {

        /* renamed from: a */
        public View f18562a;

        /* renamed from: b */
        public NotchFitRelativeLayout f18563b;

        /* renamed from: c */
        public TextView f18564c;

        /* renamed from: d */
        public NotchFitLinearLayout f18565d;

        /* renamed from: e */
        public ImageView f18566e;

        /* renamed from: f */
        public TextView f18567f;

        /* renamed from: g */
        public NotchFitLinearLayout f18568g;

        /* renamed from: h */
        public TextView f18569h;

        public C4030b() {
        }
    }

    public BackupRecordsAdapter(Context context) {
        this.f18557a = context;
        this.f18560d = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // com.huawei.android.hicloud.p088ui.uilistener.OnDataRange
    /* renamed from: a */
    public boolean mo24801a() {
        return this.f18559c;
    }

    /* renamed from: b */
    public void m24802b(List<CBSSyncRecordOperation> list, boolean z10) {
        List<CBSSyncRecordOperation> list2 = this.f18558b;
        if (list2 != null) {
            list2.clear();
            this.f18558b.addAll(list);
            this.f18559c = z10;
            notifyDataSetChanged();
        }
    }

    /* renamed from: c */
    public void m24803c(List<CBSSyncRecordOperation> list, boolean z10) {
        List<CBSSyncRecordOperation> list2 = this.f18558b;
        if (list2 != null) {
            list2.addAll(list);
            this.f18559c = z10;
            notifyDataSetChanged();
        }
    }

    /* renamed from: d */
    public void m24804d() {
        List<CBSSyncRecordOperation> list = this.f18558b;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public CBSSyncRecordOperation getItem(int i10) {
        return this.f18558b.get(i10);
    }

    /* renamed from: f */
    public final void m24806f(C4030b c4030b, String str) {
        if (TextUtils.equals(str, "us3")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_add);
            return;
        }
        if (TextUtils.equals(str, "us4")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_edit);
        } else if (TextUtils.equals(str, "us5")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_delete);
        } else {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_operate);
        }
    }

    /* renamed from: g */
    public final void m24807g(C4030b c4030b, String str) {
        if (TextUtils.equals(str, "us3") || TextUtils.equals(str, "us8")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_add);
            return;
        }
        if (TextUtils.equals(str, "us4") || TextUtils.equals(str, "us6") || TextUtils.equals(str, "us9")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_edit);
        } else if (TextUtils.equals(str, "us5") || TextUtils.equals(str, "us7") || TextUtils.equals(str, "us10")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_delete);
        } else {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_operate);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18558b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return super.getItemViewType(i10);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        C4030b c4030b;
        if (view == null) {
            c4030b = new C4030b();
            viewM76832e = C12809f.m76832e(this.f18560d, R$layout.backup_record_item);
            c4030b.f18562a = C12809f.m76831d(viewM76832e, R$id.backup_record_interval);
            c4030b.f18563b = (NotchFitRelativeLayout) C12809f.m76831d(viewM76832e, R$id.backup_record_time_group);
            c4030b.f18564c = (TextView) C12809f.m76831d(viewM76832e, R$id.backup_record_time);
            c4030b.f18565d = (NotchFitLinearLayout) C12809f.m76831d(viewM76832e, R$id.backup_record_detail_frame);
            c4030b.f18566e = (ImageView) C12809f.m76831d(viewM76832e, R$id.backup_record_icon);
            c4030b.f18567f = (TextView) C12809f.m76831d(viewM76832e, R$id.backup_record_type);
            c4030b.f18569h = (TextView) C12809f.m76831d(viewM76832e, R$id.backup_record_item_time);
            c4030b.f18568g = (NotchFitLinearLayout) C12809f.m76831d(viewM76832e, R$id.backup_record_divider);
            viewM76832e.setTag(c4030b);
        } else {
            viewM76832e = view;
            c4030b = (C4030b) view.getTag();
        }
        CBSSyncRecordOperation item = getItem(i10);
        String opTimeTag = item.getOpTimeTag();
        String strM69664f = C11667a.m69664f(this.f18557a, C11667a.m69660b(opTimeTag, C1529a.f6579e));
        String strM69669k = C11667a.m69669k(this.f18557a, new Date(item.getOperateTime()), this.f18561e);
        String opType = item.getOpType();
        String devDisplayName = item.getDevDisplayName();
        String opDesc = item.getOpDesc();
        int dataType = item.getDataType();
        if (TextUtils.isEmpty(devDisplayName)) {
            devDisplayName = item.getAliasName();
        }
        m24812l(c4030b, opType, dataType);
        int i11 = i10 > 0 ? i10 - 1 : 0;
        if (i10 == 0) {
            c4030b.f18563b.setVisibility(0);
            c4030b.f18564c.setText(strM69664f);
            c4030b.f18568g.setVisibility(8);
            c4030b.f18562a.setVisibility(8);
        } else if (i11 >= 0) {
            if (TextUtils.equals(opTimeTag, getItem(i11).getOpTimeTag())) {
                c4030b.f18562a.setVisibility(8);
                c4030b.f18563b.setVisibility(8);
                c4030b.f18564c.setText("");
                c4030b.f18568g.setVisibility(0);
            } else {
                c4030b.f18562a.setVisibility(8);
                c4030b.f18563b.setVisibility(0);
                c4030b.f18564c.setText(strM69664f);
                c4030b.f18568g.setVisibility(8);
            }
        }
        c4030b.f18567f.setText(opDesc);
        String string = this.f18557a.getString(R$string.connect_string_dot, devDisplayName, strM69669k);
        if (!TextUtils.isEmpty(devDisplayName)) {
            strM69669k = string;
        }
        c4030b.f18569h.setText(strM69669k);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c4030b.f18568g);
        arrayList.add(c4030b.f18563b);
        arrayList.add(c4030b.f18565d);
        C12806c.m76817h(this.f18557a, arrayList);
        viewM76832e.setAccessibilityDelegate(C2783d.m16078D0());
        return viewM76832e;
    }

    /* renamed from: h */
    public final void m24808h(C4030b c4030b, String str) {
        if (TextUtils.equals(str, "us3")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_add);
            return;
        }
        if (TextUtils.equals(str, "us4") || TextUtils.equals(str, "us7")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_edit);
            return;
        }
        if (TextUtils.equals(str, "us5") || TextUtils.equals(str, "us6") || TextUtils.equals(str, "us8")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_delete);
            return;
        }
        if (TextUtils.equals(str, "ur9")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_stop);
        } else if (TextUtils.equals(str, "ur10")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_revoke);
        } else {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_operate);
        }
    }

    /* renamed from: i */
    public void m24809i(boolean z10) {
        this.f18559c = z10;
    }

    /* renamed from: j */
    public final void m24810j(C4030b c4030b, String str) {
        if (TextUtils.equals(str, "us3")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_add);
            return;
        }
        if (TextUtils.equals(str, "us4")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_edit);
        } else if (TextUtils.equals(str, "us5")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_delete);
        } else {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_operate);
        }
    }

    /* renamed from: k */
    public final void m24811k(C4030b c4030b, String str) {
        if (TextUtils.equals(str, VideoPlayFlag.PLAY_IN_ALL)) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_add);
            return;
        }
        if (TextUtils.equals(str, "e")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_edit);
            return;
        }
        if (TextUtils.equals(str, "d")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_delete);
            return;
        }
        if (TextUtils.equals(str, "p")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_stop);
        } else if (TextUtils.equals(str, "r")) {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_revoke);
        } else {
            c4030b.f18566e.setImageResource(R$drawable.backup_record_operate);
        }
    }

    /* renamed from: l */
    public final void m24812l(C4030b c4030b, String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strSubstring = str.substring(2, 3);
        if (TextUtils.equals(strSubstring, VideoPlayFlag.PLAY_IN_ALL) || TextUtils.equals(strSubstring, "e") || TextUtils.equals(strSubstring, "d") || TextUtils.equals(strSubstring, "p") || TextUtils.equals(strSubstring, "r") || TextUtils.equals(strSubstring, "g")) {
            m24811k(c4030b, strSubstring);
            return;
        }
        if (i10 == 0) {
            m24808h(c4030b, str);
            return;
        }
        if (i10 == 1) {
            m24807g(c4030b, str);
        } else if (i10 == 2) {
            m24806f(c4030b, str);
        } else if (i10 == 4) {
            m24810j(c4030b, str);
        }
    }

    /* renamed from: m */
    public void m24813m(String str) {
        this.f18561e = str;
    }
}
