package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.p088ui.uiextend.RoundRectImageView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.C11444a;
import me.C11445b;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p607ra.RunnableC12484f;
import p734wa.C13578b;
import p771xd.HandlerC13773q;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BigFileListViewAdapter extends BaseAdapter {

    /* renamed from: e */
    public Context f18604e;

    /* renamed from: f */
    public LayoutInflater f18605f;

    /* renamed from: h */
    public CheckBoxCallback f18607h;

    /* renamed from: i */
    public float f18608i;

    /* renamed from: b */
    public long f18601b = 0;

    /* renamed from: c */
    public long f18602c = 0;

    /* renamed from: a */
    public CopyOnWriteArrayList<FileModel> f18600a = new CopyOnWriteArrayList<>();

    /* renamed from: d */
    public HashSet<String> f18603d = new HashSet<>();

    /* renamed from: g */
    public C13578b f18606g = C13578b.m81574f();

    public interface CheckBoxCallback {
        /* renamed from: a */
        void mo19675a();
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BigFileListViewAdapter$b */
    public class ViewOnClickListenerC4035b implements View.OnClickListener {

        /* renamed from: a */
        public FileModel f18609a;

        /* renamed from: b */
        public CheckBox f18610b;

        public ViewOnClickListenerC4035b(FileModel fileModel, CheckBox checkBox) {
            this.f18609a = fileModel;
            this.f18610b = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18609a.setChecked(this.f18610b.isChecked());
            BigFileListViewAdapter.this.m24843c(this.f18609a);
            if (BigFileListViewAdapter.this.f18607h != null) {
                BigFileListViewAdapter.this.f18607h.mo19675a();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BigFileListViewAdapter$c */
    public class C4036c {

        /* renamed from: a */
        public RoundRectImageView f18612a;

        /* renamed from: b */
        public ImageView f18613b;

        /* renamed from: c */
        public View f18614c;

        /* renamed from: d */
        public TextView f18615d;

        /* renamed from: e */
        public TextView f18616e;

        /* renamed from: f */
        public TextView f18617f;

        /* renamed from: g */
        public CheckBox f18618g;

        /* renamed from: h */
        public View f18619h;

        public C4036c() {
        }
    }

    public BigFileListViewAdapter(Context context, CheckBoxCallback checkBoxCallback) {
        this.f18607h = checkBoxCallback;
        this.f18604e = context;
        this.f18605f = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18608i = C0209d.m1195O(this.f18604e);
    }

    /* renamed from: b */
    public void m24842b() {
        this.f18603d.clear();
        this.f18602c = 0L;
    }

    /* renamed from: c */
    public void m24843c(FileModel fileModel) {
        if (fileModel == null) {
            return;
        }
        if (fileModel.isChecked()) {
            this.f18602c += fileModel.getFileSize();
            this.f18603d.add(fileModel.getFileId());
        } else {
            this.f18602c -= fileModel.getFileSize();
            this.f18603d.remove(fileModel.getFileId());
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public FileModel getItem(int i10) {
        if (i10 < 0 || i10 >= this.f18600a.size()) {
            return null;
        }
        return this.f18600a.get(i10);
    }

    /* renamed from: e */
    public int m24845e() {
        return this.f18603d.size();
    }

    /* renamed from: f */
    public ArrayList<FileModel> m24846f() {
        ArrayList<FileModel> arrayList = new ArrayList<>();
        Iterator<FileModel> it = this.f18600a.iterator();
        while (it.hasNext()) {
            FileModel next = it.next();
            if (next.isChecked()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    public long m24847g() {
        return this.f18602c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18600a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        C4036c c4036c;
        FileModel item = getItem(i10);
        if (item == null) {
            C11839m.m70688i("BigFileListViewAdapter", "getView item is null.");
            return view;
        }
        if (view == null) {
            c4036c = new C4036c();
            viewM76832e = this.f18608i >= 1.45f ? C12809f.m76832e(this.f18605f, R$layout.big_file_list_item_3_dot_2) : C12809f.m76832e(this.f18605f, R$layout.big_file_list_item);
            c4036c.f18615d = (TextView) C12809f.m76831d(viewM76832e, R$id.file_name);
            c4036c.f18614c = C12809f.m76831d(viewM76832e, R$id.file_info);
            c4036c.f18617f = (TextView) C12809f.m76831d(viewM76832e, R$id.file_sub_info);
            c4036c.f18616e = (TextView) C12809f.m76831d(viewM76832e, R$id.file_size);
            c4036c.f18619h = C12809f.m76831d(viewM76832e, R$id.cloud_disk_divider);
            CheckBox checkBox = (CheckBox) C12809f.m76831d(viewM76832e, R$id.big_file_chk);
            c4036c.f18618g = checkBox;
            checkBox.setChecked(false);
            c4036c.f18612a = (RoundRectImageView) C12809f.m76831d(viewM76832e, R$id.file_icon);
            c4036c.f18613b = (ImageView) C12809f.m76831d(viewM76832e, R$id.file_icon_video);
            c4036c.f18614c.setTag(item);
            viewM76832e.setTag(c4036c);
        } else {
            C4036c c4036c2 = (C4036c) view.getTag();
            c4036c2.f18612a.setTag(null);
            viewM76832e = view;
            c4036c = c4036c2;
        }
        m24852l(c4036c, item);
        m24854n(c4036c, item);
        m24853m(c4036c, item);
        m24855o(c4036c, item);
        m24850j(c4036c, item);
        m24851k(c4036c, i10);
        return viewM76832e;
    }

    /* renamed from: h */
    public boolean m24848h() {
        return this.f18603d.size() != 0 && this.f18600a.size() == this.f18603d.size();
    }

    /* renamed from: i */
    public boolean m24849i() {
        return this.f18603d.size() != 0;
    }

    /* renamed from: j */
    public final void m24850j(C4036c c4036c, FileModel fileModel) {
        CheckBox checkBox;
        if (c4036c == null || (checkBox = c4036c.f18618g) == null) {
            C11839m.m70688i("BigFileListViewAdapter", "procCheckBox param is null.");
        } else {
            checkBox.setOnClickListener(new ViewOnClickListenerC4035b(fileModel, checkBox));
            c4036c.f18618g.setChecked(fileModel.isChecked());
        }
    }

    /* renamed from: k */
    public final void m24851k(C4036c c4036c, int i10) {
        if (c4036c == null || c4036c.f18619h == null) {
            C11839m.m70688i("BigFileListViewAdapter", "procDivider param is null.");
        } else if (i10 < this.f18600a.size() - 1) {
            c4036c.f18619h.setVisibility(0);
        } else {
            c4036c.f18619h.setVisibility(8);
        }
    }

    /* renamed from: l */
    public final void m24852l(C4036c c4036c, FileModel fileModel) {
        TextView textView;
        if (c4036c == null || (textView = c4036c.f18615d) == null) {
            C11839m.m70688i("BigFileListViewAdapter", "procFileName param is null.");
        } else {
            textView.setText(fileModel.getFileName());
        }
    }

    /* renamed from: m */
    public final void m24853m(C4036c c4036c, FileModel fileModel) {
        TextView textView;
        if (c4036c == null || (textView = c4036c.f18616e) == null) {
            C11839m.m70688i("BigFileListViewAdapter", "procFileSize param is null.");
        } else {
            textView.setText(C11829c.m70551W(fileModel.getFileSize()));
        }
    }

    /* renamed from: n */
    public final void m24854n(C4036c c4036c, FileModel fileModel) {
        if (c4036c == null || c4036c.f18617f == null) {
            C11839m.m70688i("BigFileListViewAdapter", "procSubInfo param is null.");
        } else if (TextUtils.isEmpty(fileModel.getCloudPath())) {
            c4036c.f18617f.setText(this.f18604e.getResources().getString(R$string.hidisk_my_drive));
        } else {
            c4036c.f18617f.setText(fileModel.getCloudPath());
        }
    }

    /* renamed from: o */
    public final void m24855o(C4036c c4036c, FileModel fileModel) {
        if (c4036c == null || c4036c.f18612a == null || c4036c.f18613b == null) {
            C11839m.m70688i("BigFileListViewAdapter", "procThumbnail param is null.");
            return;
        }
        int fileCategory = fileModel.getFileCategory();
        if (fileCategory == 2) {
            c4036c.f18613b.setVisibility(0);
        } else {
            c4036c.f18613b.setVisibility(8);
        }
        if (C11445b.m68564a(fileCategory)) {
            m24857q(c4036c, fileModel, fileCategory);
        } else {
            RoundRectImageView.setNoBorderScaleDefault(c4036c.f18612a, this.f18604e.getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
        }
    }

    /* renamed from: p */
    public void m24856p(boolean z10) {
        this.f18602c = 0L;
        this.f18603d.clear();
        Iterator<FileModel> it = this.f18600a.iterator();
        while (it.hasNext()) {
            FileModel next = it.next();
            next.setChecked(z10);
            if (z10) {
                this.f18602c += next.getFileSize();
                this.f18603d.add(next.getFileId());
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: q */
    public final void m24857q(C4036c c4036c, FileModel fileModel, int i10) {
        String fileId = fileModel.getFileId();
        BitmapDrawable bitmapDrawableM81578d = this.f18606g.m81578d(fileId);
        Bitmap bitmap = bitmapDrawableM81578d != null ? bitmapDrawableM81578d.getBitmap() : C11444a.m68559c(fileModel.getThumbnailPath());
        c4036c.f18612a.setTag(fileId);
        if (bitmap == null || bitmap.isRecycled()) {
            c4036c.f18613b.setVisibility(8);
            String fileName = fileModel.getFileName();
            RoundRectImageView.setNoBorderScaleDefault(c4036c.f18612a, this.f18604e.getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
            C11829c.m70601o(new RunnableC12484f(fileModel, new HandlerC13773q(c4036c.f18612a, fileId, fileName, c4036c.f18613b, i10), 0));
            return;
        }
        RoundRectImageView.setBorderImageViewByBitmap(c4036c.f18612a, bitmap);
        if (i10 == 2) {
            c4036c.f18613b.setVisibility(0);
        } else {
            c4036c.f18613b.setVisibility(8);
        }
    }

    /* renamed from: r */
    public void m24858r(CopyOnWriteArrayList<FileModel> copyOnWriteArrayList) {
        this.f18600a.clear();
        m24842b();
        this.f18600a.addAll(copyOnWriteArrayList);
    }

    /* renamed from: s */
    public void m24859s(long j10) {
        this.f18601b = j10;
    }
}
