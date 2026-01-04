package ae;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.clouddisk.model.DuplicateFileCard;
import com.huawei.android.hicloud.drive.clouddisk.model.DuplicateFileCategory;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiextend.RoundRectImageView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.C11444a;
import me.C11445b;
import p514o9.C11829c;
import p514o9.C11839m;
import p607ra.RunnableC12484f;
import p734wa.C13578b;
import p771xd.HandlerC13773q;
import sk.C12809f;

/* renamed from: ae.c1 */
/* loaded from: classes3.dex */
public class C0111c1 extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public Context f365d;

    /* renamed from: e */
    public List<Object> f366e;

    /* renamed from: f */
    public volatile Set<FileModel> f367f;

    /* renamed from: g */
    public AutoSizeButton f368g;

    /* renamed from: h */
    public View.OnClickListener f369h;

    /* renamed from: i */
    public C13578b f370i = C13578b.m81574f();

    /* renamed from: j */
    public float f371j;

    /* renamed from: k */
    public long f372k;

    /* renamed from: ae.c1$a */
    public class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public RoundRectImageView f373u;

        /* renamed from: v */
        public TextView f374v;

        /* renamed from: w */
        public TextView f375w;

        /* renamed from: x */
        public View f376x;

        public a(View view) {
            super(view);
            this.f373u = (RoundRectImageView) C12809f.m76831d(view, R$id.file_icon);
            this.f374v = (TextView) C12809f.m76831d(view, R$id.file_count);
            this.f375w = (TextView) C12809f.m76831d(view, R$id.file_size);
            this.f376x = C12809f.m76831d(view, R$id.middle_divider);
        }
    }

    /* renamed from: ae.c1$b */
    public class b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public View f379u;

        /* renamed from: v */
        public ImageView f380v;

        /* renamed from: w */
        public TextView f381w;

        /* renamed from: x */
        public TextView f382x;

        /* renamed from: y */
        public CheckBox f383y;

        /* renamed from: z */
        public View f384z;

        public b(View view) {
            super(view);
            this.f379u = C12809f.m76831d(view, R$id.category);
            this.f380v = (ImageView) C12809f.m76831d(view, R$id.category_icon);
            this.f381w = (TextView) C12809f.m76831d(view, R$id.category_name);
            this.f382x = (TextView) C12809f.m76831d(view, R$id.category_size);
            this.f383y = (CheckBox) C12809f.m76831d(view, R$id.category_checked);
            this.f384z = C12809f.m76831d(view, R$id.category_divider);
        }
    }

    /* renamed from: ae.c1$c */
    public class c extends RecyclerView.AbstractC0833c0 {
        public c(View view) {
            super(view);
        }
    }

    /* renamed from: ae.c1$d */
    public class d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public TextView f386A;

        /* renamed from: B */
        public TextView f387B;

        /* renamed from: C */
        public CheckBox f388C;

        /* renamed from: D */
        public View f389D;

        /* renamed from: E */
        public View f390E;

        /* renamed from: u */
        public FileModel f392u;

        /* renamed from: v */
        public View f393v;

        /* renamed from: w */
        public RoundRectImageView f394w;

        /* renamed from: x */
        public ImageView f395x;

        /* renamed from: y */
        public View f396y;

        /* renamed from: z */
        public TextView f397z;

        public d(View view) {
            super(view);
            this.f393v = C12809f.m76831d(view, R$id.duplicate_file_item);
            this.f397z = (TextView) C12809f.m76831d(view, R$id.file_name);
            this.f396y = C12809f.m76831d(view, R$id.file_info);
            this.f387B = (TextView) C12809f.m76831d(view, R$id.file_sub_info);
            this.f386A = (TextView) C12809f.m76831d(view, R$id.file_size);
            this.f389D = C12809f.m76831d(view, R$id.middle_divider);
            this.f390E = C12809f.m76831d(view, R$id.foot_divider);
            this.f388C = (CheckBox) C12809f.m76831d(view, R$id.duplicate_file_chk);
            this.f394w = (RoundRectImageView) C12809f.m76831d(view, R$id.file_icon);
            this.f395x = (ImageView) C12809f.m76831d(view, R$id.file_icon_video);
            this.f388C.setOnClickListener(new View.OnClickListener() { // from class: ae.d1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f423a.m751Q(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Q */
        public /* synthetic */ void m751Q(View view) {
            C0111c1.this.m738P(this.f392u, this.f388C.isChecked());
        }
    }

    /* renamed from: ae.c1$e */
    public class e extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f398u;

        public e(View view) {
            super(view);
            this.f398u = (TextView) C12809f.m76831d(view, R$id.duplicate_file_total_size);
        }
    }

    /* renamed from: ae.c1$f */
    public class f extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public View f400A;

        /* renamed from: u */
        public FileModel f402u;

        /* renamed from: v */
        public View f403v;

        /* renamed from: w */
        public TextView f404w;

        /* renamed from: x */
        public TextView f405x;

        /* renamed from: y */
        public CheckBox f406y;

        /* renamed from: z */
        public View f407z;

        public f(View view) {
            super(view);
            this.f403v = C12809f.m76831d(view, R$id.duplicate_file_item);
            this.f404w = (TextView) C12809f.m76831d(view, R$id.file_name);
            this.f405x = (TextView) C12809f.m76831d(view, R$id.file_sub_info);
            this.f407z = C12809f.m76831d(view, R$id.middle_divider);
            this.f400A = C12809f.m76831d(view, R$id.foot_divider);
            CheckBox checkBox = (CheckBox) C12809f.m76831d(view, R$id.duplicate_file_chk);
            this.f406y = checkBox;
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: ae.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f439a.m753Q(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Q */
        public /* synthetic */ void m753Q(View view) {
            C0111c1.this.m738P(this.f402u, this.f406y.isChecked());
        }
    }

    public C0111c1(Context context, List<Object> list, Set<FileModel> set) {
        this.f365d = context;
        this.f366e = list;
        this.f367f = set;
    }

    /* renamed from: G */
    public void m729G(DuplicateFileCategory duplicateFileCategory, b bVar) {
        if (!duplicateFileCategory.equals(bVar.f379u.getTag())) {
            C11839m.m70688i("DuplicateFileCategoryAdapter", "duplicate file checkedOrUncheckedCategoryFiles categoryHolder and category not match");
            return;
        }
        boolean zIsChecked = bVar.f383y.isChecked();
        duplicateFileCategory.setChecked(zIsChecked);
        if (zIsChecked) {
            duplicateFileCategory.setExpand(true);
        }
        m743U(duplicateFileCategory, bVar);
        List<Object> cardAndFileList = duplicateFileCategory.getCardAndFileList();
        if (cardAndFileList == null) {
            C11839m.m70689w("DuplicateFileCategoryAdapter", "duplicate file checkedOrUncheckedCategoryFiles cardAndFileList is null.");
            return;
        }
        C11839m.m70688i("DuplicateFileCategoryAdapter", "duplicate file checkedOrUncheckedCategoryFiles checked: " + zIsChecked);
        for (Object obj : cardAndFileList) {
            if (obj instanceof FileModel) {
                FileModel fileModel = (FileModel) obj;
                if (zIsChecked && fileModel.isFirst() && !fileModel.isChecked()) {
                    fileModel.setChecked(false);
                    this.f367f.remove(fileModel);
                } else {
                    m747Y(fileModel, zIsChecked);
                }
            }
        }
        duplicateFileCategory.updateSelectedFiles(zIsChecked);
        m5213j();
        m748Z();
    }

    /* renamed from: H */
    public final boolean m730H(int i10) {
        return i10 >= 0 && i10 < mo721e();
    }

    /* renamed from: I */
    public void m731I(DuplicateFileCategory duplicateFileCategory, b bVar) {
        if (!duplicateFileCategory.equals(bVar.f379u.getTag())) {
            C11839m.m70688i("DuplicateFileCategoryAdapter", "duplicate file expandOrShrinkCategoryFiles categoryHolder and category not match");
            return;
        }
        boolean z10 = !duplicateFileCategory.isExpand();
        C11839m.m70688i("DuplicateFileCategoryAdapter", "duplicate file expandOrShrinkCategoryFiles expand: " + z10);
        duplicateFileCategory.setExpand(z10);
        m743U(duplicateFileCategory, bVar);
        m5213j();
    }

    /* renamed from: J */
    public Object m732J(int i10) {
        if (this.f366e != null && m730H(i10)) {
            return this.f366e.get(i10);
        }
        return null;
    }

    /* renamed from: K */
    public final long m733K() {
        Iterator<FileModel> it = this.f367f.iterator();
        long fileSize = 0;
        while (it.hasNext()) {
            fileSize += it.next().getFileSize();
        }
        return fileSize;
    }

    /* renamed from: L */
    public final /* synthetic */ void m734L(DuplicateFileCategory duplicateFileCategory, b bVar, View view) {
        if (duplicateFileCategory.equals(bVar.f379u.getTag())) {
            m729G(duplicateFileCategory, bVar);
        }
    }

    /* renamed from: M */
    public final /* synthetic */ void m735M(DuplicateFileCategory duplicateFileCategory, b bVar, View view) {
        m731I(duplicateFileCategory, bVar);
    }

    /* renamed from: N */
    public final boolean m736N(int i10) {
        int i11 = i10 + 1;
        if (!m730H(i11)) {
            return false;
        }
        Object obj = this.f366e.get(i11);
        if (obj instanceof DuplicateFileCard) {
            return true;
        }
        if (obj instanceof FileModel) {
            return ((FileModel) obj).isFirst();
        }
        return false;
    }

    /* renamed from: O */
    public final void m737O(RoundRectImageView roundRectImageView, ImageView imageView, FileModel fileModel) {
        if (fileModel == null) {
            C11839m.m70688i("DuplicateFileCategoryAdapter", "duplicate file procThumbnail fileModel is null.");
            return;
        }
        if (roundRectImageView == null) {
            C11839m.m70688i("DuplicateFileCategoryAdapter", "duplicate file procThumbnail param is null.");
            return;
        }
        int fileCategory = fileModel.getFileCategory();
        if (C11445b.m68564a(fileCategory)) {
            m744V(roundRectImageView, imageView, fileModel, fileCategory);
        } else {
            RoundRectImageView.setNoBorderScaleDefault(roundRectImageView, this.f365d.getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
        }
    }

    /* renamed from: P */
    public final void m738P(FileModel fileModel, boolean z10) {
        if (fileModel == null) {
            C11839m.m70689w("DuplicateFileCategoryAdapter", "duplicate file selectorUnselectFile fileModel is null.");
            return;
        }
        m747Y(fileModel, z10);
        m748Z();
        m746X(fileModel, z10);
    }

    /* renamed from: Q */
    public void m739Q(List<Object> list) {
        this.f366e = list;
    }

    /* renamed from: R */
    public void m740R(AutoSizeButton autoSizeButton) {
        this.f368g = autoSizeButton;
    }

    /* renamed from: S */
    public void m741S(View.OnClickListener onClickListener) {
        this.f369h = onClickListener;
    }

    /* renamed from: T */
    public void m742T(float f10) {
        this.f371j = f10;
    }

    /* renamed from: U */
    public final void m743U(DuplicateFileCategory duplicateFileCategory, b bVar) {
        if (!duplicateFileCategory.equals(bVar.f379u.getTag())) {
            C11839m.m70688i("DuplicateFileCategoryAdapter", "duplicate file setIconUpOrDown categoryHolder and category not match");
            return;
        }
        boolean zIsExpand = duplicateFileCategory.isExpand();
        ImageView imageView = bVar.f380v;
        if (imageView != null) {
            imageView.setImageResource(zIsExpand ? R$drawable.up_arrow : R$drawable.down_arrow);
        }
        View view = bVar.f384z;
        if (view != null) {
            view.setVisibility((zIsExpand || duplicateFileCategory.isLastCategory()) ? 8 : 0);
        }
    }

    /* renamed from: V */
    public final void m744V(RoundRectImageView roundRectImageView, ImageView imageView, FileModel fileModel, int i10) {
        String fileId = fileModel.getFileId();
        BitmapDrawable bitmapDrawableM81578d = this.f370i.m81578d(fileId);
        Bitmap bitmap = bitmapDrawableM81578d != null ? bitmapDrawableM81578d.getBitmap() : C11444a.m68559c(fileModel.getThumbnailPath());
        roundRectImageView.setTag(fileId);
        C12809f.m76843p(imageView, false);
        if (bitmap == null || bitmap.isRecycled()) {
            String fileName = fileModel.getFileName();
            RoundRectImageView.setNoBorderScaleDefault(roundRectImageView, this.f365d.getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
            C11829c.m70601o(new RunnableC12484f(fileModel, new HandlerC13773q(roundRectImageView, fileId, fileName, imageView, i10), 1));
        } else {
            RoundRectImageView.setBorderImageViewByBitmap(roundRectImageView, bitmap);
            if (i10 == 2) {
                C12809f.m76843p(imageView, true);
            }
        }
    }

    /* renamed from: W */
    public void m745W(long j10) {
        this.f372k = j10;
    }

    /* renamed from: X */
    public final void m746X(FileModel fileModel, boolean z10) {
        DuplicateFileCategory duplicateFileCategory = fileModel.getDuplicateFileCategory();
        boolean zUpdateCheckStatus = duplicateFileCategory.updateCheckStatus(fileModel, z10);
        if (duplicateFileCategory.getChecked() != zUpdateCheckStatus) {
            duplicateFileCategory.setChecked(zUpdateCheckStatus);
            m5213j();
        }
    }

    /* renamed from: Y */
    public final void m747Y(FileModel fileModel, boolean z10) {
        fileModel.setChecked(z10);
        if (z10) {
            this.f367f.add(fileModel);
        } else {
            this.f367f.remove(fileModel);
        }
    }

    /* renamed from: Z */
    public final void m748Z() {
        if (this.f368g != null) {
            boolean z10 = this.f367f.size() > 0;
            this.f368g.setEnabled(z10);
            this.f368g.setText(this.f365d.getString(R$string.delete_has_choose_size, C11829c.m70551W(m733K())));
            if (z10) {
                this.f368g.setTextColor(this.f365d.getColor(R$color.delete_btn_color));
            } else {
                this.f368g.setTextColor(this.f365d.getColor(R$color.delete_btn_disable_color));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<Object> list = this.f366e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        if (this.f366e == null || !m730H(i10)) {
            return 0;
        }
        if (i10 == 1 && this.f372k > 0) {
            return 1;
        }
        Object obj = this.f366e.get(i10);
        if (obj instanceof DuplicateFileCategory) {
            return 2;
        }
        if ((obj instanceof DuplicateFileCard) && ((DuplicateFileCard) obj).isVisible()) {
            return 4;
        }
        if (obj instanceof FileModel) {
            FileModel fileModel = (FileModel) obj;
            if (fileModel.isVisible()) {
                return fileModel.noThumbnail() ? 5 : 3;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (abstractC0833c0 instanceof e) {
            ((e) abstractC0833c0).f398u.setText(this.f365d.getString(R$string.file_content_same, C11829c.m70551W(this.f372k)));
            return;
        }
        if (abstractC0833c0 instanceof b) {
            Object objM732J = m732J(i10);
            if (objM732J instanceof DuplicateFileCategory) {
                final DuplicateFileCategory duplicateFileCategory = (DuplicateFileCategory) objM732J;
                final b bVar = (b) abstractC0833c0;
                bVar.f379u.setTag(duplicateFileCategory);
                int fileCategory = duplicateFileCategory.getFileCategory();
                if (fileCategory == 0) {
                    bVar.f381w.setText(R$string.image);
                } else if (fileCategory == 1) {
                    bVar.f381w.setText(R$string.audio);
                } else if (fileCategory == 2) {
                    bVar.f381w.setText(R$string.video);
                } else if (fileCategory == 3) {
                    bVar.f381w.setText(R$string.document);
                } else if (fileCategory == 4) {
                    bVar.f381w.setText(R$string.compress_pkg);
                } else if (fileCategory == 6) {
                    bVar.f381w.setText(R$string.other);
                }
                m743U(duplicateFileCategory, bVar);
                bVar.f382x.setText(C11829c.m70551W(duplicateFileCategory.getCategorySize()));
                bVar.f383y.setEnabled(duplicateFileCategory.existFiles());
                bVar.f383y.setChecked(duplicateFileCategory.getChecked());
                bVar.f383y.setOnClickListener(new View.OnClickListener() { // from class: ae.a1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f348a.m734L(duplicateFileCategory, bVar, view);
                    }
                });
                bVar.f379u.setOnClickListener(new View.OnClickListener() { // from class: ae.b1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f358a.m735M(duplicateFileCategory, bVar, view);
                    }
                });
                return;
            }
            return;
        }
        int i11 = 0;
        if (abstractC0833c0 instanceof d) {
            Object objM732J2 = m732J(i10);
            if (objM732J2 instanceof FileModel) {
                FileModel fileModel = (FileModel) objM732J2;
                d dVar = (d) abstractC0833c0;
                dVar.f395x.setVisibility(8);
                if (fileModel.isVisible()) {
                    dVar.f392u = fileModel;
                    dVar.f397z.setText(fileModel.getFileName());
                    dVar.f387B.setText(fileModel.getFileParentName());
                    dVar.f393v.setTag(fileModel);
                    dVar.f393v.setOnClickListener(this.f369h);
                    dVar.f388C.setChecked(fileModel.isChecked());
                    dVar.f386A.setText(C11829c.m70551W(fileModel.getFileSize()));
                    dVar.f387B.setText(fileModel.getCloudPath());
                    dVar.f390E.setVisibility(8);
                    dVar.f393v.setBackgroundColor(this.f365d.getColor(R$color.hicloud_card_bg));
                    if (fileModel.isFirst()) {
                        dVar.f393v.setBackgroundResource(R$drawable.first_card_view_item_bg);
                    }
                    if (fileModel.isLast()) {
                        dVar.f393v.setBackgroundResource(R$drawable.last_card_view_item_bg);
                        if (m736N(i10)) {
                            dVar.f390E.setVisibility(0);
                        }
                        i11 = 8;
                    }
                    dVar.f389D.setVisibility(i11);
                    m737O(dVar.f394w, dVar.f395x, fileModel);
                    return;
                }
                return;
            }
            return;
        }
        if (abstractC0833c0 instanceof a) {
            Object objM732J3 = m732J(i10);
            if (objM732J3 instanceof DuplicateFileCard) {
                DuplicateFileCard duplicateFileCard = (DuplicateFileCard) objM732J3;
                a aVar = (a) abstractC0833c0;
                int count = duplicateFileCard.getCount();
                aVar.f374v.setText(this.f365d.getResources().getQuantityString(R$plurals.backup_app_data_count, count, Integer.valueOf(count)));
                aVar.f375w.setText(C11829c.m70551W(duplicateFileCard.getCardSize()));
                if (duplicateFileCard.getFileCategory().getFileCategory() == 6) {
                    RoundRectImageView.setNoBorderScaleDefault(aVar.f373u, this.f365d.getDrawable(R$drawable.duplicate_file_default_icon));
                    return;
                } else {
                    m737O(aVar.f373u, null, duplicateFileCard.getFistFile());
                    return;
                }
            }
            return;
        }
        if (abstractC0833c0 instanceof f) {
            Object objM732J4 = m732J(i10);
            if (objM732J4 instanceof FileModel) {
                FileModel fileModel2 = (FileModel) objM732J4;
                f fVar = (f) abstractC0833c0;
                fVar.f402u = fileModel2;
                fVar.f404w.setText(fileModel2.getFileName());
                fVar.f405x.setText(fileModel2.getFileParentName());
                fVar.f403v.setTag(fileModel2);
                fVar.f403v.setOnClickListener(this.f369h);
                fVar.f406y.setChecked(fileModel2.isChecked());
                fVar.f405x.setText(fileModel2.getCloudPath());
                fVar.f400A.setVisibility(8);
                fVar.f403v.setBackgroundColor(this.f365d.getColor(R$color.hicloud_card_bg));
                if (fileModel2.isLast()) {
                    fVar.f403v.setBackgroundResource(R$drawable.last_card_view_item_bg);
                    if (m736N(i10)) {
                        fVar.f400A.setVisibility(0);
                    }
                    i11 = 8;
                }
                fVar.f407z.setVisibility(i11);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        if (i10 == 1) {
            return new e(LayoutInflater.from(this.f365d).inflate(R$layout.duplicate_file_header, viewGroup, false));
        }
        if (i10 == 2) {
            return new b(LayoutInflater.from(this.f365d).inflate(this.f371j >= 1.45f ? R$layout.duplicate_file_category_item_big_font : R$layout.duplicate_file_category_item, viewGroup, false));
        }
        if (i10 == 3) {
            return new d(LayoutInflater.from(this.f365d).inflate(this.f371j >= 1.45f ? R$layout.duplicate_file_item_big_font : R$layout.duplicate_file_item, viewGroup, false));
        }
        if (i10 == 4) {
            return new a(LayoutInflater.from(this.f365d).inflate(this.f371j >= 1.45f ? R$layout.duplicate_file_card_item_big_font : R$layout.duplicate_file_card_item, viewGroup, false));
        }
        if (i10 == 5) {
            return new f(LayoutInflater.from(this.f365d).inflate(this.f371j >= 1.45f ? R$layout.duplicate_file_no_thumbnail_item_big_font : R$layout.duplicate_file_no_thumbnail_item, viewGroup, false));
        }
        return new c(LayoutInflater.from(this.f365d).inflate(R$layout.duplicate_file_empty_layout, viewGroup, false));
    }
}
