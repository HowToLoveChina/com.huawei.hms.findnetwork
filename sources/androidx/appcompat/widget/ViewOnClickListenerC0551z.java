package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.content.ContextCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import p380j0.AbstractC10638c;

/* renamed from: androidx.appcompat.widget.z */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0551z extends AbstractC10638c implements View.OnClickListener {

    /* renamed from: l */
    public final SearchView f2445l;

    /* renamed from: m */
    public final SearchableInfo f2446m;

    /* renamed from: n */
    public final Context f2447n;

    /* renamed from: o */
    public final WeakHashMap<String, Drawable.ConstantState> f2448o;

    /* renamed from: p */
    public final int f2449p;

    /* renamed from: q */
    public boolean f2450q;

    /* renamed from: r */
    public int f2451r;

    /* renamed from: s */
    public ColorStateList f2452s;

    /* renamed from: t */
    public int f2453t;

    /* renamed from: u */
    public int f2454u;

    /* renamed from: v */
    public int f2455v;

    /* renamed from: w */
    public int f2456w;

    /* renamed from: x */
    public int f2457x;

    /* renamed from: y */
    public int f2458y;

    /* renamed from: androidx.appcompat.widget.z$a */
    public static final class a {

        /* renamed from: a */
        public final TextView f2459a;

        /* renamed from: b */
        public final TextView f2460b;

        /* renamed from: c */
        public final ImageView f2461c;

        /* renamed from: d */
        public final ImageView f2462d;

        /* renamed from: e */
        public final ImageView f2463e;

        public a(View view) {
            this.f2459a = (TextView) view.findViewById(R.id.text1);
            this.f2460b = (TextView) view.findViewById(R.id.text2);
            this.f2461c = (ImageView) view.findViewById(R.id.icon1);
            this.f2462d = (ImageView) view.findViewById(R.id.icon2);
            this.f2463e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public ViewOnClickListenerC0551z(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2450q = false;
        this.f2451r = 1;
        this.f2453t = -1;
        this.f2454u = -1;
        this.f2455v = -1;
        this.f2456w = -1;
        this.f2457x = -1;
        this.f2458y = -1;
        this.f2445l = searchView;
        this.f2446m = searchableInfo;
        this.f2449p = searchView.getSuggestionCommitIconResId();
        this.f2447n = context;
        this.f2448o = weakHashMap;
    }

    /* renamed from: o */
    public static String m3189o(Cursor cursor, String str) {
        return m3190w(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: w */
    public static String m3190w(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    /* renamed from: A */
    public final void m3191A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2448o.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: B */
    public final void m3192B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // p380j0.AbstractC10636a, p380j0.C10637b.a
    /* renamed from: a */
    public void mo3193a(Cursor cursor) {
        if (this.f2450q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo3193a(cursor);
            if (cursor != null) {
                this.f2453t = cursor.getColumnIndex("suggest_text_1");
                this.f2454u = cursor.getColumnIndex("suggest_text_2");
                this.f2455v = cursor.getColumnIndex("suggest_text_2_url");
                this.f2456w = cursor.getColumnIndex("suggest_icon_1");
                this.f2457x = cursor.getColumnIndex("suggest_icon_2");
                this.f2458y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    @Override // p380j0.AbstractC10636a, p380j0.C10637b.a
    /* renamed from: c */
    public CharSequence mo3194c(Cursor cursor) {
        String strM3189o;
        String strM3189o2;
        if (cursor == null) {
            return null;
        }
        String strM3189o3 = m3189o(cursor, "suggest_intent_query");
        if (strM3189o3 != null) {
            return strM3189o3;
        }
        if (this.f2446m.shouldRewriteQueryFromData() && (strM3189o2 = m3189o(cursor, "suggest_intent_data")) != null) {
            return strM3189o2;
        }
        if (!this.f2446m.shouldRewriteQueryFromText() || (strM3189o = m3189o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strM3189o;
    }

    @Override // p380j0.C10637b.a
    /* renamed from: d */
    public Cursor mo3195d(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f2445l.getVisibility() == 0 && this.f2445l.getWindowVisibility() == 0) {
            try {
                Cursor cursorM3208v = m3208v(this.f2446m, string, 50);
                if (cursorM3208v != null) {
                    cursorM3208v.getCount();
                    return cursorM3208v;
                }
            } catch (RuntimeException e10) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            }
        }
        return null;
    }

    @Override // p380j0.AbstractC10636a
    /* renamed from: e */
    public void mo3196e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i10 = this.f2458y;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        if (aVar.f2459a != null) {
            m3211z(aVar.f2459a, m3190w(cursor, this.f2453t));
        }
        if (aVar.f2460b != null) {
            String strM3190w = m3190w(cursor, this.f2455v);
            CharSequence charSequenceM3199l = strM3190w != null ? m3199l(strM3190w) : m3190w(cursor, this.f2454u);
            if (TextUtils.isEmpty(charSequenceM3199l)) {
                TextView textView = aVar.f2459a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f2459a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f2459a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f2459a.setMaxLines(1);
                }
            }
            m3211z(aVar.f2460b, charSequenceM3199l);
        }
        ImageView imageView = aVar.f2461c;
        if (imageView != null) {
            m3210y(imageView, m3206t(cursor), 4);
        }
        ImageView imageView2 = aVar.f2462d;
        if (imageView2 != null) {
            m3210y(imageView2, m3207u(cursor), 8);
        }
        int i12 = this.f2451r;
        if (i12 != 2 && (i12 != 1 || (i11 & 1) == 0)) {
            aVar.f2463e.setVisibility(8);
            return;
        }
        aVar.f2463e.setVisibility(0);
        aVar.f2463e.setTag(aVar.f2459a.getText());
        aVar.f2463e.setOnClickListener(this);
    }

    @Override // p380j0.AbstractC10636a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View viewMo65136g = this.mo65136g(this.f2447n, this.mo65134b(), viewGroup);
            if (viewMo65136g != null) {
                ((a) viewMo65136g.getTag()).f2459a.setText(e10.toString());
            }
            return viewMo65136g;
        }
    }

    @Override // p380j0.AbstractC10636a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View viewMo3197h = this.mo3197h(this.f2447n, this.mo65134b(), viewGroup);
            if (viewMo3197h != null) {
                ((a) viewMo3197h.getTag()).f2459a.setText(e10.toString());
            }
            return viewMo3197h;
        }
    }

    @Override // p380j0.AbstractC10638c, p380j0.AbstractC10636a
    /* renamed from: h */
    public View mo3197h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewMo3197h = super.mo3197h(context, cursor, viewGroup);
        viewMo3197h.setTag(new a(viewMo3197h));
        ((ImageView) viewMo3197h.findViewById(R$id.edit_query)).setImageResource(this.f2449p);
        return viewMo3197h;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    /* renamed from: k */
    public final Drawable m3198k(String str) {
        Drawable.ConstantState constantState = this.f2448o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: l */
    public final CharSequence m3199l(CharSequence charSequence) {
        if (this.f2452s == null) {
            TypedValue typedValue = new TypedValue();
            this.f2447n.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f2452s = this.f2447n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2452s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: m */
    public final Drawable m3200m(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f2447n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("SuggestionsAdapter", e10.toString());
            return null;
        }
    }

    /* renamed from: n */
    public final Drawable m3201n(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f2448o.containsKey(strFlattenToShortString)) {
            Drawable drawableM3200m = m3200m(componentName);
            this.f2448o.put(strFlattenToShortString, drawableM3200m != null ? drawableM3200m.getConstantState() : null);
            return drawableM3200m;
        }
        Drawable.ConstantState constantState = this.f2448o.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f2447n.getResources());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m3192B(mo65134b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m3192B(mo65134b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2445l.m2787U((CharSequence) tag);
        }
    }

    /* renamed from: p */
    public final Drawable m3202p() throws PackageManager.NameNotFoundException {
        Drawable drawableM3201n = m3201n(this.f2446m.getSearchActivity());
        return drawableM3201n != null ? drawableM3201n : this.f2447n.getPackageManager().getDefaultActivityIcon();
    }

    /* renamed from: q */
    public final Drawable m3203q(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m3204r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f2447n.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e10) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e10);
                }
            }
        } catch (FileNotFoundException e11) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
        return null;
    }

    /* renamed from: r */
    public Drawable m3204r(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f2447n.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* renamed from: s */
    public final Drawable m3205s(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i10 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2447n.getPackageName() + "/" + i10;
            Drawable drawableM3198k = m3198k(str2);
            if (drawableM3198k != null) {
                return drawableM3198k;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f2447n, i10);
            m3191A(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableM3198k2 = m3198k(str);
            if (drawableM3198k2 != null) {
                return drawableM3198k2;
            }
            Drawable drawableM3203q = m3203q(Uri.parse(str));
            m3191A(str, drawableM3203q);
            return drawableM3203q;
        }
    }

    /* renamed from: t */
    public final Drawable m3206t(Cursor cursor) throws NumberFormatException, IOException {
        int i10 = this.f2456w;
        if (i10 == -1) {
            return null;
        }
        Drawable drawableM3205s = m3205s(cursor.getString(i10));
        return drawableM3205s != null ? drawableM3205s : m3202p();
    }

    /* renamed from: u */
    public final Drawable m3207u(Cursor cursor) {
        int i10 = this.f2457x;
        if (i10 == -1) {
            return null;
        }
        return m3205s(cursor.getString(i10));
    }

    /* renamed from: v */
    public Cursor m3208v(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f2447n.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    /* renamed from: x */
    public void m3209x(int i10) {
        this.f2451r = i10;
    }

    /* renamed from: y */
    public final void m3210y(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: z */
    public final void m3211z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
