package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.data.n */
/* loaded from: classes.dex */
public class C1573n extends AbstractC1571l<InputStream> {

    /* renamed from: d */
    public static final UriMatcher f6966d;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f6966d = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public C1573n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: a */
    public Class<InputStream> mo9017a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.AbstractC1571l
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void mo9018c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.AbstractC1571l
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public InputStream mo9019f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamM9052i = m9052i(uri, contentResolver);
        if (inputStreamM9052i != null) {
            return inputStreamM9052i;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    /* renamed from: i */
    public final InputStream m9052i(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = f6966d.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return m9053j(contentResolver, uri);
            }
            if (iMatch != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return m9053j(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* renamed from: j */
    public final InputStream m9053j(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
