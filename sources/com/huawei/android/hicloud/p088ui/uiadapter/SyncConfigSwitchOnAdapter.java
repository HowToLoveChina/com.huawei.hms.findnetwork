package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.android.hicloud.p088ui.uiextend.AccountLogoutItemView;
import com.huawei.android.hicloud.p088ui.uilistener.LogoutItemCheckedChangeListener;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11829c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SyncConfigSwitchOnAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<SyncConfigService> f18901a = new ArrayList();

    /* renamed from: b */
    public LayoutInflater f18902b;

    /* renamed from: c */
    public SparseBooleanArray f18903c;

    /* renamed from: d */
    public Context f18904d;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncConfigSwitchOnAdapter$b */
    public class C4072b implements LogoutItemCheckedChangeListener {
        public C4072b() {
        }

        @Override // com.huawei.android.hicloud.p088ui.uilistener.LogoutItemCheckedChangeListener
        /* renamed from: a */
        public void mo25261a(AccountLogoutItemView accountLogoutItemView, int i10, boolean z10) {
            SyncConfigSwitchOnAdapter.this.f18903c.put(i10, z10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncConfigSwitchOnAdapter$c */
    public class ViewOnClickListenerC4073c implements View.OnClickListener {

        /* renamed from: a */
        public int f18906a;

        /* renamed from: b */
        public AccountLogoutItemView f18907b;

        public ViewOnClickListenerC4073c(int i10, AccountLogoutItemView accountLogoutItemView) {
            this.f18906a = i10;
            this.f18907b = accountLogoutItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18907b.setChecked(!r2.isChecked());
            SyncConfigSwitchOnAdapter.this.f18903c.put(this.f18906a, this.f18907b.isChecked());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SyncConfigSwitchOnAdapter$d */
    public static class C4074d {

        /* renamed from: a */
        public AccountLogoutItemView f18909a;

        public C4074d() {
        }

        /* renamed from: b */
        public AccountLogoutItemView m25263b() {
            return this.f18909a;
        }

        /* renamed from: c */
        public void m25264c(AccountLogoutItemView accountLogoutItemView) {
            this.f18909a = accountLogoutItemView;
        }
    }

    public SyncConfigSwitchOnAdapter(Context context) {
        this.f18904d = context;
        this.f18902b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SyncConfigService getItem(int i10) {
        return this.f18901a.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18901a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewM76832e;
        C4074d c4074d;
        Context context;
        SparseBooleanArray sparseBooleanArray;
        Drawable bitmapDrawable = null;
        byte b10 = 0;
        byte b11 = 0;
        if (view == null) {
            c4074d = new C4074d();
            viewM76832e = C12809f.m76832e(this.f18902b, R$layout.account_logout_sync_config_item);
            c4074d.m25264c((AccountLogoutItemView) C12809f.m76831d(viewM76832e, R$id.sync_config_list_item));
            viewM76832e.setTag(c4074d);
        } else {
            viewM76832e = view;
            c4074d = (C4074d) view.getTag();
        }
        c4074d.f18909a.setOnClickListener(new ViewOnClickListenerC4073c(i10, c4074d.m25263b()));
        c4074d.f18909a.setItemOnCheckedChangeListener(i10, new C4072b());
        AccountLogoutItemView accountLogoutItemViewM25263b = c4074d.m25263b();
        if (accountLogoutItemViewM25263b != null && (sparseBooleanArray = this.f18903c) != null) {
            accountLogoutItemViewM25263b.setChecked(sparseBooleanArray.get(i10));
        }
        SyncConfigService item = getItem(i10);
        c4074d.f18909a.setTitleText(NotifyUtil.getStringFromSyncConfig(item.getName()));
        if (NotifyUtil.HI_NOTE_SYNC_TYPE.equals(item.getId()) && C0209d.m1293p1() && (context = this.f18904d) != null) {
            bitmapDrawable = ResourcesCompat.getDrawable(context.getResources(), R$drawable.hinote_sync_icon, this.f18904d.getTheme());
        } else {
            Bitmap bitmapM70501B = C11829c.m70501B(item.getIconPath());
            if (bitmapM70501B != null) {
                bitmapDrawable = new BitmapDrawable((Resources) null, bitmapM70501B);
            }
        }
        c4074d.f18909a.setIconView(bitmapDrawable);
        if (i10 == this.f18901a.size() - 1) {
            c4074d.f18909a.setDividerViewType(false);
        } else {
            c4074d.f18909a.setDividerViewType(true);
        }
        return viewM76832e;
    }
}
