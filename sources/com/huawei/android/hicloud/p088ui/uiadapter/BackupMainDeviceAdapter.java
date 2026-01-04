package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.C4867a;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0234s;
import p336he.C10153d;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupMainDeviceAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public LayoutInflater f18499d;

    /* renamed from: e */
    public final Context f18500e;

    /* renamed from: f */
    public final LinkedList<C4867a> f18501f = new LinkedList<>();

    /* renamed from: g */
    public int f18502g = 0;

    /* renamed from: h */
    public View f18503h;

    /* renamed from: i */
    public final View.OnClickListener f18504i;

    /* renamed from: j */
    public boolean f18505j;

    public static class LayoutManager extends LinearLayoutManager {
        public LayoutManager(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupMainDeviceAdapter$a */
    public class ViewTreeObserverOnGlobalLayoutListenerC4019a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public final /* synthetic */ View f18506a;

        public ViewTreeObserverOnGlobalLayoutListenerC4019a(View view) {
            this.f18506a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams = this.f18506a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
                this.f18506a.setLayoutParams(layoutParams);
            }
            this.f18506a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupMainDeviceAdapter$b */
    public static class C4020b extends RecyclerView.AbstractC0833c0 {
        public C4020b(View view) {
            super(view);
            this.f4327a.setTag(this);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupMainDeviceAdapter$c */
    public static class C4021c implements RecyclerView.InterfaceC0849s {
        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
        public void onRequestDisallowInterceptTouchEvent(boolean z10) {
            C11839m.m70686d("BackupMainDeviceAdapter", "<onRequestDisallowInterceptTouchEvent> disallowIntercept: " + z10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0849s
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            C11839m.m70686d("BackupMainDeviceAdapter", "<onTouchEvent> rv: " + recyclerView + ", e: " + motionEvent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupMainDeviceAdapter$d */
    public static class C4022d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public final View f18508u;

        public C4022d(View view) {
            super(view);
            this.f18508u = view;
            view.setTag(this);
        }

        /* renamed from: P */
        public View m24752P() {
            return this.f18508u;
        }
    }

    public BackupMainDeviceAdapter(Context context, View.OnClickListener onClickListener) {
        this.f18500e = context;
        this.f18504i = onClickListener;
        this.f18499d = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: D */
    public void m24741D(List<C4867a> list) {
        Iterator<C4867a> it = list.iterator();
        while (it.hasNext()) {
            m24743F(it.next());
        }
    }

    /* renamed from: E */
    public void m24742E(View view) {
        this.f18503h = view;
    }

    /* renamed from: F */
    public void m24743F(C4867a c4867a) {
        this.f18501f.add(c4867a);
        if (c4867a.getType() == 1) {
            this.f18502g++;
        }
    }

    /* renamed from: G */
    public void m24744G() {
        this.f18501f.clear();
        this.f18502g = 0;
    }

    /* renamed from: H */
    public int m24745H() {
        return this.f18502g;
    }

    /* renamed from: I */
    public Object m24746I(int i10) {
        if (this.f18503h != null) {
            i10--;
        }
        if (i10 < 0 || i10 >= this.f18501f.size()) {
            return null;
        }
        return this.f18501f.get(i10);
    }

    /* renamed from: J */
    public final void m24747J(Context context, TextView textView) {
        if (C0234s.m1643u()) {
            textView.setPadding(0, 0, 0, (int) C11842p.m70844o(context, 2));
        }
    }

    /* renamed from: K */
    public void m24748K() {
        C4867a c4867aPeekLast = this.f18501f.peekLast();
        if (c4867aPeekLast == null || c4867aPeekLast.getType() == 1) {
            return;
        }
        this.f18501f.removeLast();
    }

    /* renamed from: L */
    public final void m24749L(TextView textView, TextView textView2, C4867a c4867a) {
        UserBackupInfo.UserDeviceInfo userDeviceInfoM29221p = c4867a.m29221p();
        if (userDeviceInfoM29221p == null) {
            m24751N(textView, textView2, c4867a);
            return;
        }
        if (!userDeviceInfoM29221p.isTempBackUp() || userDeviceInfoM29221p.getExtraDeviceInfos() == null || userDeviceInfoM29221p.getExtraDeviceInfos().size() <= 0) {
            m24751N(textView, textView2, c4867a);
            return;
        }
        ExtraDeviceInfo extraDeviceInfo = userDeviceInfoM29221p.getExtraDeviceInfos().get(0);
        if (extraDeviceInfo == null || extraDeviceInfo.getOccupySpaceType().intValue() == 1) {
            m24751N(textView, textView2, c4867a);
            return;
        }
        long lastbackupTime = userDeviceInfoM29221p.getLastbackupTime();
        if (lastbackupTime != 0) {
            String strM63240d = C10153d.m63240d(this.f18500e, lastbackupTime);
            if (TextUtils.isEmpty(strM63240d)) {
                textView.setVisibility(8);
            } else {
                textView.setText(strM63240d);
                textView.setVisibility(0);
            }
        }
        int expiratoryInDays = extraDeviceInfo.getExpiratoryInDays();
        if (expiratoryInDays == 0) {
            expiratoryInDays++;
        }
        textView2.setText(this.f18500e.getResources().getQuantityString(R$plurals.temp_backup_will_delete, expiratoryInDays, Integer.valueOf(expiratoryInDays)));
        textView2.setVisibility(0);
    }

    /* renamed from: M */
    public void m24750M() {
        LinkedList linkedList = new LinkedList(this.f18501f.subList(0, Math.min(this.f18501f.size(), 5)));
        m24744G();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m24743F((C4867a) it.next());
        }
        if (this.f18501f.size() == 5) {
            this.f18501f.add(new C4867a(2));
        }
    }

    /* renamed from: N */
    public final void m24751N(TextView textView, TextView textView2, C4867a c4867a) {
        textView2.setVisibility(8);
        long jM29219f = c4867a.m29219f();
        if (jM29219f <= 0) {
            textView.setVisibility(8);
            return;
        }
        String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this.f18500e, jM29219f));
        textView.setVisibility(0);
        textView.setText(strM1157C0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f18503h == null ? this.f18501f.size() : this.f18501f.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return (this.f18503h == null || i10 != 0) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        int i11 = i10;
        C11839m.m70686d("BackupMainDeviceAdapter", "<onBindViewHolder> position: " + i11);
        if (abstractC0833c0 instanceof C4022d) {
            if (this.f18503h != null) {
                i11--;
            }
            C4867a c4867a = this.f18501f.get(i11);
            View viewM24752P = ((C4022d) abstractC0833c0).m24752P();
            viewM24752P.setOnClickListener(this.f18504i);
            RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(viewM24752P, R$id.device_content);
            if (this.f18505j) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                layoutParams.gravity = 17;
                relativeLayout.setLayoutParams(layoutParams);
            }
            TextView textView = (TextView) C12809f.m76831d(viewM24752P, R$id.show_more);
            m24747J(this.f18500e, textView);
            TextView textView2 = (TextView) C12809f.m76831d(viewM24752P, R$id.backup_detail_title);
            TextView textView3 = (TextView) C12809f.m76831d(viewM24752P, R$id.gallery_value);
            TextView textView4 = (TextView) C12809f.m76831d(viewM24752P, R$id.gallery_reminder);
            View viewM76831d = C12809f.m76831d(viewM24752P, R$id.backup_item_divider);
            ImageView imageView = (ImageView) C12809f.m76831d(viewM24752P, R$id.backup_detail_icon);
            HwColumnLinearLayout hwColumnLinearLayout = (HwColumnLinearLayout) C12809f.m76831d(viewM24752P, R$id.cloud_backup_device_loading_layout);
            if (c4867a.getType() == 1) {
                relativeLayout.setVisibility(0);
                textView.setVisibility(8);
                hwColumnLinearLayout.setVisibility(8);
            } else if (c4867a.getType() == 2) {
                relativeLayout.setVisibility(8);
                textView.setVisibility(0);
                hwColumnLinearLayout.setVisibility(8);
                textView.setText(R$string.cloud_backup_show_more_device);
            } else if (c4867a.getType() == 3) {
                relativeLayout.setVisibility(8);
                textView.setVisibility(0);
                hwColumnLinearLayout.setVisibility(8);
                textView.setText(R$string.cloud_backup_show_less_device);
            } else if (c4867a.getType() == 4) {
                relativeLayout.setVisibility(8);
                textView.setVisibility(8);
                hwColumnLinearLayout.setVisibility(0);
            }
            String string = this.f18500e.getString(R$string.setting_other);
            String str = "\u202a" + c4867a.getDeviceName() + "\u202c";
            if (TextUtils.isEmpty(str)) {
                c4867a.setDeviceName(string);
            } else {
                string = str;
            }
            if (c4867a.isCurrent()) {
                Context context = this.f18500e;
                textView2.setText(context.getString(R$string.about_recover_tip, string, context.getString(R$string.current_device_new), ""));
            } else {
                textView2.setText(string);
            }
            m24749L(textView3, textView4, c4867a);
            if (i11 == this.f18501f.size() - 1) {
                viewM76831d.setVisibility(8);
            } else {
                viewM76831d.setVisibility(0);
            }
            textView2.setContentDescription(((Object) textView2.getText()) + ".");
            textView3.setContentDescription(textView3.getText());
            C11839m.m70688i("BackupMainDeviceAdapter", "item.getTerminalType : " + c4867a.getTerminalType());
            imageView.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(c4867a.getTerminalType(), c4867a.getDeviceCategory()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C11839m.m70686d("BackupMainDeviceAdapter", "<onCreateViewHolder> viewType: " + i10);
        if (i10 == 1) {
            return new C4020b(this.f18503h);
        }
        View viewM76832e = C12809f.m76832e(this.f18499d, R$layout.backup_device_item);
        viewM76832e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4019a(viewM76832e));
        return new C4022d(viewM76832e);
    }
}
