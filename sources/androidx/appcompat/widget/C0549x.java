package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;
import p272f.C9581a;

/* renamed from: androidx.appcompat.widget.x */
/* loaded from: classes.dex */
public class C0549x extends Resources {

    /* renamed from: a */
    public final Resources f2436a;

    public C0549x(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2436a = resources;
    }

    /* renamed from: a */
    public final Drawable m3181a(int i10) throws Resources.NotFoundException {
        return super.getDrawable(i10);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i10) throws Resources.NotFoundException {
        return this.f2436a.getAnimation(i10);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i10) throws Resources.NotFoundException {
        return this.f2436a.getBoolean(i10);
    }

    @Override // android.content.res.Resources
    public int getColor(int i10) throws Resources.NotFoundException {
        return this.f2436a.getColor(i10);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i10) throws Resources.NotFoundException {
        return this.f2436a.getColorStateList(i10);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f2436a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i10) throws Resources.NotFoundException {
        return this.f2436a.getDimension(i10);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i10) throws Resources.NotFoundException {
        return this.f2436a.getDimensionPixelOffset(i10);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i10) throws Resources.NotFoundException {
        return this.f2436a.getDimensionPixelSize(i10);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f2436a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawable(this.f2436a, i10, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i10, int i11) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawableForDensity(this.f2436a, i10, i11, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i10, int i11, int i12) {
        return this.f2436a.getFraction(i10, i11, i12);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f2436a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i10) throws Resources.NotFoundException {
        return this.f2436a.getIntArray(i10);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i10) throws Resources.NotFoundException {
        return this.f2436a.getInteger(i10);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i10) throws Resources.NotFoundException {
        return this.f2436a.getLayout(i10);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i10) throws Resources.NotFoundException {
        return this.f2436a.getMovie(i10);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i10, int i11, Object... objArr) throws Resources.NotFoundException {
        return this.f2436a.getQuantityString(i10, i11, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i10, int i11) throws Resources.NotFoundException {
        return this.f2436a.getQuantityText(i10, i11);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i10) throws Resources.NotFoundException {
        return this.f2436a.getResourceEntryName(i10);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i10) throws Resources.NotFoundException {
        return this.f2436a.getResourceName(i10);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i10) throws Resources.NotFoundException {
        return this.f2436a.getResourcePackageName(i10);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i10) throws Resources.NotFoundException {
        return this.f2436a.getResourceTypeName(i10);
    }

    @Override // android.content.res.Resources
    public String getString(int i10) throws Resources.NotFoundException {
        return this.f2436a.getString(i10);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i10) throws Resources.NotFoundException {
        return this.f2436a.getStringArray(i10);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i10) throws Resources.NotFoundException {
        return this.f2436a.getText(i10);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i10) throws Resources.NotFoundException {
        return this.f2436a.getTextArray(i10);
    }

    @Override // android.content.res.Resources
    public void getValue(int i10, TypedValue typedValue, boolean z10) throws Resources.NotFoundException {
        this.f2436a.getValue(i10, typedValue, z10);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i10, int i11, TypedValue typedValue, boolean z10) throws Resources.NotFoundException {
        C9581a.m59780a(this.f2436a, i10, i11, typedValue, z10);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i10) throws Resources.NotFoundException {
        return this.f2436a.getXml(i10);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2436a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i10) throws Resources.NotFoundException {
        return this.f2436a.obtainTypedArray(i10);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i10) throws Resources.NotFoundException {
        return this.f2436a.openRawResource(i10);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i10) throws Resources.NotFoundException {
        return this.f2436a.openRawResourceFd(i10);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f2436a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f2436a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f2436a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i10, int i11, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.f2436a, i10, i11, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i10, int i11) throws Resources.NotFoundException {
        return this.f2436a.getQuantityString(i10, i11);
    }

    @Override // android.content.res.Resources
    public String getString(int i10, Object... objArr) throws Resources.NotFoundException {
        return this.f2436a.getString(i10, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i10, CharSequence charSequence) {
        return this.f2436a.getText(i10, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z10) throws Resources.NotFoundException {
        this.f2436a.getValue(str, typedValue, z10);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i10, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f2436a.openRawResource(i10, typedValue);
    }
}
