package p666u2;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* renamed from: u2.f */
/* loaded from: classes.dex */
public class C13115f extends Property<ImageView, Matrix> {

    /* renamed from: a */
    public final Matrix f59606a;

    public C13115f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f59606a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.f59606a.set(imageView.getImageMatrix());
        return this.f59606a;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
