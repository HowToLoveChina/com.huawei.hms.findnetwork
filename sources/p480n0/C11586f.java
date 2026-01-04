package p480n0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.emoji2.text.C0688e;
import p243e0.C9373h;

/* renamed from: n0.f */
/* loaded from: classes.dex */
public final class C11586f {

    /* renamed from: a */
    public final b f53751a;

    /* renamed from: n0.f$a */
    public static class a extends b {

        /* renamed from: a */
        public final TextView f53752a;

        /* renamed from: b */
        public final C11584d f53753b;

        /* renamed from: c */
        public boolean f53754c = true;

        public a(TextView textView) {
            this.f53752a = textView;
            this.f53753b = new C11584d(textView);
        }

        @Override // p480n0.C11586f.b
        /* renamed from: a */
        public InputFilter[] mo69162a(InputFilter[] inputFilterArr) {
            return !this.f53754c ? m69169h(inputFilterArr) : m69167f(inputFilterArr);
        }

        @Override // p480n0.C11586f.b
        /* renamed from: b */
        public boolean mo69163b() {
            return this.f53754c;
        }

        @Override // p480n0.C11586f.b
        /* renamed from: c */
        public void mo69164c(boolean z10) {
            if (z10) {
                m69173l();
            }
        }

        @Override // p480n0.C11586f.b
        /* renamed from: d */
        public void mo69165d(boolean z10) {
            this.f53754c = z10;
            m69173l();
            m69172k();
        }

        @Override // p480n0.C11586f.b
        /* renamed from: e */
        public TransformationMethod mo69166e(TransformationMethod transformationMethod) {
            return this.f53754c ? m69174m(transformationMethod) : m69171j(transformationMethod);
        }

        /* renamed from: f */
        public final InputFilter[] m69167f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f53753b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f53753b;
            return inputFilterArr2;
        }

        /* renamed from: g */
        public final SparseArray<InputFilter> m69168g(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof C11584d) {
                    sparseArray.put(i10, inputFilter);
                }
            }
            return sparseArray;
        }

        /* renamed from: h */
        public final InputFilter[] m69169h(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArrayM69168g = m69168g(inputFilterArr);
            if (sparseArrayM69168g.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayM69168g.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArrayM69168g.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        /* renamed from: i */
        public void m69170i(boolean z10) {
            this.f53754c = z10;
        }

        /* renamed from: j */
        public final TransformationMethod m69171j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof C11588h ? ((C11588h) transformationMethod).m69180a() : transformationMethod;
        }

        /* renamed from: k */
        public final void m69172k() {
            this.f53752a.setFilters(mo69162a(this.f53752a.getFilters()));
        }

        /* renamed from: l */
        public void m69173l() {
            this.f53752a.setTransformationMethod(mo69166e(this.f53752a.getTransformationMethod()));
        }

        /* renamed from: m */
        public final TransformationMethod m69174m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof C11588h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new C11588h(transformationMethod);
        }
    }

    /* renamed from: n0.f$b */
    public static class b {
        /* renamed from: a */
        public InputFilter[] mo69162a(InputFilter[] inputFilterArr) {
            throw null;
        }

        /* renamed from: b */
        public boolean mo69163b() {
            throw null;
        }

        /* renamed from: c */
        public void mo69164c(boolean z10) {
            throw null;
        }

        /* renamed from: d */
        public void mo69165d(boolean z10) {
            throw null;
        }

        /* renamed from: e */
        public TransformationMethod mo69166e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    /* renamed from: n0.f$c */
    public static class c extends b {

        /* renamed from: a */
        public final a f53755a;

        public c(TextView textView) {
            this.f53755a = new a(textView);
        }

        @Override // p480n0.C11586f.b
        /* renamed from: a */
        public InputFilter[] mo69162a(InputFilter[] inputFilterArr) {
            return m69175f() ? inputFilterArr : this.f53755a.mo69162a(inputFilterArr);
        }

        @Override // p480n0.C11586f.b
        /* renamed from: b */
        public boolean mo69163b() {
            return this.f53755a.mo69163b();
        }

        @Override // p480n0.C11586f.b
        /* renamed from: c */
        public void mo69164c(boolean z10) {
            if (m69175f()) {
                return;
            }
            this.f53755a.mo69164c(z10);
        }

        @Override // p480n0.C11586f.b
        /* renamed from: d */
        public void mo69165d(boolean z10) {
            if (m69175f()) {
                this.f53755a.m69170i(z10);
            } else {
                this.f53755a.mo69165d(z10);
            }
        }

        @Override // p480n0.C11586f.b
        /* renamed from: e */
        public TransformationMethod mo69166e(TransformationMethod transformationMethod) {
            return m69175f() ? transformationMethod : this.f53755a.mo69166e(transformationMethod);
        }

        /* renamed from: f */
        public final boolean m69175f() {
            return !C0688e.m4225h();
        }
    }

    public C11586f(TextView textView, boolean z10) {
        C9373h.m58746g(textView, "textView cannot be null");
        if (z10) {
            this.f53751a = new a(textView);
        } else {
            this.f53751a = new c(textView);
        }
    }

    /* renamed from: a */
    public InputFilter[] m69157a(InputFilter[] inputFilterArr) {
        return this.f53751a.mo69162a(inputFilterArr);
    }

    /* renamed from: b */
    public boolean m69158b() {
        return this.f53751a.mo69163b();
    }

    /* renamed from: c */
    public void m69159c(boolean z10) {
        this.f53751a.mo69164c(z10);
    }

    /* renamed from: d */
    public void m69160d(boolean z10) {
        this.f53751a.mo69165d(z10);
    }

    /* renamed from: e */
    public TransformationMethod m69161e(TransformationMethod transformationMethod) {
        return this.f53751a.mo69166e(transformationMethod);
    }
}
