package ae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.List;
import p514o9.C11839m;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: ae.b */
/* loaded from: classes3.dex */
public class C0105b extends RecyclerView.AbstractC0838h<a> {

    /* renamed from: f */
    public static final String f352f = "b";

    /* renamed from: d */
    public Context f353d;

    /* renamed from: e */
    public List<BackupOptionItem> f354e;

    /* renamed from: ae.b$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f355u;

        public a(View view) {
            super(view);
            this.f355u = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
        }
    }

    public C0105b(Context context, List<BackupOptionItem> list) {
        this.f353d = context;
        this.f354e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void mo723s(a aVar, int i10) {
        BackupOptionItem backupOptionItem;
        List<BackupOptionItem> list = this.f354e;
        if (list == null || i10 >= list.size() || (backupOptionItem = this.f354e.get(i10)) == null) {
            return;
        }
        String appId = backupOptionItem.getAppId();
        String parent = backupOptionItem.getParent();
        C11839m.m70686d(f352f, "position=" + i10 + ", parent=" + parent + ", appId=" + appId);
        if ("virtualApp".equals(parent)) {
            aVar.f355u.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId, null));
        } else if (C14333b.m85483r().containsKey(appId)) {
            aVar.f355u.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId));
        } else {
            aVar.f355u.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(appId));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public a mo724u(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(this.f353d).inflate(R$layout.backup_option_third_icon_list_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<BackupOptionItem> list = this.f354e;
        if (list == null) {
            return 0;
        }
        return Math.min(3, list.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return i10;
    }
}
