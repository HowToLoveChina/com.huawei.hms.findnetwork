package p380j0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: j0.c */
/* loaded from: classes.dex */
public abstract class AbstractC10638c extends AbstractC10636a {

    /* renamed from: i */
    public int f51110i;

    /* renamed from: j */
    public int f51111j;

    /* renamed from: k */
    public LayoutInflater f51112k;

    @Deprecated
    public AbstractC10638c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f51111j = i10;
        this.f51110i = i10;
        this.f51112k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // p380j0.AbstractC10636a
    /* renamed from: g */
    public View mo65136g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f51112k.inflate(this.f51111j, viewGroup, false);
    }

    @Override // p380j0.AbstractC10636a
    /* renamed from: h */
    public View mo3197h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f51112k.inflate(this.f51110i, viewGroup, false);
    }
}
