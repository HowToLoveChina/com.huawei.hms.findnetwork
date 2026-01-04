package com.huawei.openalliance.p169ad.download.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.inter.data.PermissionEntity;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.download.app.g */
/* loaded from: classes2.dex */
class C7048g extends BaseAdapter {

    /* renamed from: a */
    private Context f32421a;

    /* renamed from: b */
    private List<PermissionEntity> f32422b;

    /* renamed from: c */
    private LayoutInflater f32423c;

    /* renamed from: com.huawei.openalliance.ad.download.app.g$a */
    public static class a {

        /* renamed from: a */
        TextView f32424a;

        public a(View view) {
            this.f32424a = (TextView) view.findViewById(C6849R.id.hiad_permissions_dialog_child_tv);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.g$b */
    public static class b {

        /* renamed from: a */
        TextView f32425a;

        public b(View view) {
            this.f32425a = (TextView) view.findViewById(C6849R.id.hiad_permissions_dialog_parent_tv);
        }
    }

    public C7048g(Context context, List<PermissionEntity> list) {
        this.f32421a = context;
        this.f32422b = list;
        this.f32423c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (AbstractC7760bg.m47767a(this.f32422b)) {
            return 0;
        }
        return this.f32422b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (AbstractC7760bg.m47767a(this.f32422b)) {
            return null;
        }
        return this.f32422b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        if (AbstractC7760bg.m47767a(this.f32422b)) {
            return 0L;
        }
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        if (AbstractC7760bg.m47767a(this.f32422b) || this.f32422b.get(i10) == null) {
            return 0;
        }
        return this.f32422b.get(i10).getType();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[PHI: r5 r7 r8
  0x003f: PHI (r5v10 android.widget.TextView) = (r5v4 android.widget.TextView), (r5v14 android.widget.TextView) binds: [B:25:0x006b, B:14:0x003c] A[DONT_GENERATE, DONT_INLINE]
  0x003f: PHI (r7v6 android.view.View) = (r7v1 android.view.View), (r7v7 android.view.View) binds: [B:25:0x006b, B:14:0x003c] A[DONT_GENERATE, DONT_INLINE]
  0x003f: PHI (r8v5 java.lang.String) = (r8v2 java.lang.String), (r8v7 java.lang.String) binds: [B:25:0x006b, B:14:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            java.util.List<com.huawei.openalliance.ad.inter.data.PermissionEntity> r0 = r5.f32422b
            java.lang.Object r0 = r0.get(r6)
            com.huawei.openalliance.ad.inter.data.PermissionEntity r0 = (com.huawei.openalliance.p169ad.inter.data.PermissionEntity) r0
            int r1 = r5.getItemViewType(r6)
            r2 = 0
            java.lang.String r3 = ""
            if (r1 == 0) goto L44
            r4 = 1
            if (r1 == r4) goto L15
            goto L6e
        L15:
            if (r7 != 0) goto L28
            android.view.LayoutInflater r5 = r5.f32423c
            int r7 = com.huawei.openalliance.p169ad.C6849R.layout.hiad_permission_dialog_child_item
            android.view.View r7 = r5.inflate(r7, r8, r2)
            com.huawei.openalliance.ad.download.app.g$a r5 = new com.huawei.openalliance.ad.download.app.g$a
            r5.<init>(r7)
            r7.setTag(r5)
            goto L2e
        L28:
            java.lang.Object r5 = r7.getTag()
            com.huawei.openalliance.ad.download.app.g$a r5 = (com.huawei.openalliance.p169ad.download.app.C7048g.a) r5
        L2e:
            if (r0 == 0) goto L35
            java.lang.String r8 = r0.getName()
            goto L36
        L35:
            r8 = r3
        L36:
            android.widget.TextView r5 = r5.f32424a
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L3f
            goto L40
        L3f:
            r3 = r8
        L40:
            r5.setText(r3)
            goto L6e
        L44:
            if (r7 != 0) goto L57
            android.view.LayoutInflater r5 = r5.f32423c
            int r7 = com.huawei.openalliance.p169ad.C6849R.layout.hiad_permission_dialog_parent_item
            android.view.View r7 = r5.inflate(r7, r8, r2)
            com.huawei.openalliance.ad.download.app.g$b r5 = new com.huawei.openalliance.ad.download.app.g$b
            r5.<init>(r7)
            r7.setTag(r5)
            goto L5d
        L57:
            java.lang.Object r5 = r7.getTag()
            com.huawei.openalliance.ad.download.app.g$b r5 = (com.huawei.openalliance.p169ad.download.app.C7048g.b) r5
        L5d:
            if (r0 == 0) goto L64
            java.lang.String r8 = r0.getName()
            goto L65
        L64:
            r8 = r3
        L65:
            android.widget.TextView r5 = r5.f32425a
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L3f
            goto L40
        L6e:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r5 = java.lang.Long.valueOf(r0)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6}
            java.lang.String r6 = "AppPermissionsDialog"
            java.lang.String r8 = "getView, time:%d, position:%d"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r6, r8, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.download.app.C7048g.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return false;
    }
}
