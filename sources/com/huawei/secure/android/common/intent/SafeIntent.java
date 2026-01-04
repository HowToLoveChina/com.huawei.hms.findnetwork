package com.huawei.secure.android.common.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import p787xt.C13865a;

/* loaded from: classes5.dex */
public class SafeIntent extends Intent {

    /* renamed from: a */
    public static final String f40665a = "SafeIntent";

    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    /* renamed from: c */
    public String m53579c() {
        try {
            String action = super.getAction();
            return action == null ? "" : action;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: d */
    public <T extends Parcelable> T m53580d(String str, Class<T> cls) {
        try {
            Parcelable parcelableExtra = super.getParcelableExtra(str);
            if (cls.isInstance(parcelableExtra)) {
                return cls.cast(parcelableExtra);
            }
            return null;
        } catch (Throwable th2) {
            C13865a.m83191e(f40665a, "getParcelable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    /* renamed from: f */
    public String m53581f(String str) {
        try {
            String stringExtra = super.getStringExtra(str);
            return stringExtra == null ? "" : stringExtra;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: g */
    public boolean m53582g() {
        boolean z10;
        try {
            super.getStringExtra("ANYTHING");
            z10 = false;
        } catch (Throwable unused) {
            z10 = true;
        }
        if (z10) {
            C13865a.m83189c(f40665a, "hasIntentBomb");
        }
        return z10;
    }

    @Override // android.content.Intent
    public String getAction() {
        try {
            return super.getAction();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Throwable unused) {
            return new boolean[0];
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z10) {
        try {
            return super.getBooleanExtra(str, z10);
        } catch (Throwable unused) {
            return z10;
        }
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b10) {
        try {
            return super.getByteExtra(str, b10);
        } catch (Throwable unused) {
            return b10;
        }
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Throwable unused) {
            return new char[0];
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c10) {
        try {
            return super.getCharExtra(str, c10);
        } catch (Throwable unused) {
            return c10;
        }
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Throwable unused) {
            return new CharSequence[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public Uri getData() {
        try {
            return super.getData();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Throwable unused) {
            return new double[0];
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d10) {
        try {
            return super.getDoubleExtra(str, d10);
        } catch (Throwable unused) {
            return d10;
        }
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Throwable unused) {
            return new float[0];
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f10) {
        try {
            return super.getFloatExtra(str, f10);
        } catch (Throwable unused) {
            return f10;
        }
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    @Override // android.content.Intent
    public int getIntExtra(String str, int i10) {
        try {
            return super.getIntExtra(str, i10);
        } catch (Throwable unused) {
            return i10;
        }
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Throwable unused) {
            return new long[0];
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j10) {
        try {
            return super.getLongExtra(str, j10);
        } catch (Throwable unused) {
            return j10;
        }
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Throwable unused) {
            return new Parcelable[0];
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return (T) super.getParcelableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public String getScheme() {
        try {
            return super.getScheme();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Throwable unused) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s10) {
        try {
            return super.getShortExtra(str, s10);
        } catch (Throwable unused) {
            return s10;
        }
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Throwable unused) {
            return new String[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Parcelable parcelable) {
        try {
            return super.putExtra(str, parcelable);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtras(Intent intent) {
        try {
            return super.putExtras(intent);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putParcelableArrayListExtra(String str, ArrayList<? extends Parcelable> arrayList) {
        try {
            return super.putParcelableArrayListExtra(str, arrayList);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public void removeExtra(String str) {
        try {
            super.removeExtra(str);
        } catch (Throwable th2) {
            C13865a.m83191e(f40665a, "removeExtra: " + th2.getMessage(), true);
        }
    }

    @Override // android.content.Intent
    public Intent setAction(String str) {
        try {
            return super.setAction(str);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent setPackage(String str) {
        try {
            return super.setPackage(str);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public void setSelector(Intent intent) {
        try {
            super.setSelector(intent);
        } catch (Throwable th2) {
            C13865a.m83191e(f40665a, "setSelector: " + th2.getMessage(), true);
        }
    }

    @Override // android.content.Intent
    @Deprecated
    public String toURI() {
        try {
            return super.toURI();
        } catch (Throwable th2) {
            C13865a.m83191e(f40665a, "toURI: exception " + th2.getMessage(), true);
            return "";
        }
    }

    @Override // android.content.Intent
    public String toUri(int i10) {
        try {
            return super.toUri(i10);
        } catch (Throwable th2) {
            C13865a.m83191e(f40665a, "toUri: " + th2.getMessage(), true);
            return "";
        }
    }

    @Override // android.content.Intent
    public <T extends Serializable> T getSerializableExtra(String str, Class<T> cls) {
        try {
            Serializable serializableExtra = super.getSerializableExtra(str);
            if (cls.isInstance(serializableExtra)) {
                return cls.cast(serializableExtra);
            }
            return null;
        } catch (Throwable th2) {
            C13865a.m83191e(f40665a, "getSerializable exception: " + th2.getMessage(), true);
            return null;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Parcelable[] parcelableArr) {
        try {
            return super.putExtra(str, parcelableArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Serializable serializable) {
        try {
            return super.putExtra(str, serializable);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, int i10) {
        try {
            return super.putExtra(str, i10);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, String str2) {
        try {
            return super.putExtra(str, str2);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, String[] strArr) {
        try {
            return super.putExtra(str, strArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, CharSequence charSequence) {
        try {
            return super.putExtra(str, charSequence);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, CharSequence[] charSequenceArr) {
        try {
            return super.putExtra(str, charSequenceArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Bundle bundle) {
        try {
            return super.putExtra(str, bundle);
        } catch (Throwable unused) {
            return this;
        }
    }
}
