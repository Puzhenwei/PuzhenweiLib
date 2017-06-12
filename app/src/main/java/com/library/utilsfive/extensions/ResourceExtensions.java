package com.library.utilsfive.extensions;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import static com.library.utilsfive.ContextHelper.getContext;

/**
 * Created by Jan Rabe on 27/10/15.
 */
final public class ResourceExtensions {

    private ResourceExtensions() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static String getString(@StringRes final int id) {
        return getContext().getString(id);
    }

    public static int dimension(@DimenRes final int resId) {
        return (int) getResources().getDimension(resId);
    }

    public static int color(@ColorRes final int color) {
        return ContextCompat.getColor(getContext(), color);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    public static Drawable drawable(@DrawableRes final int drawable, int sdkInt) {
        if (sdkInt >= 21) {
            return getResources().getDrawable(drawable, getContext().getTheme());
        } else {
            return getResources().getDrawable(drawable);
        }
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static Configuration configuration() {
        return getResources().getConfiguration();
    }

    /**
     * Returns drawable resource id by name.
     *
     * @param drawable The name of the desired resource.
     * @return The associated resource identifier.  Returns 0 if no such
     * resource was found.  (0 is not a valid resource ID.)
     */
    @DrawableRes
    public static int getDrawableIdByName(@NonNull final String drawable) {
        return getContext().getResources().getIdentifier(drawable, "drawable", getContext().getPackageName());
    }

    @Nullable
    public static Drawable getDrawableByName(@NonNull final Context context, @NonNull final String drawable) {
        return ContextCompat.getDrawable(context, context.getResources().getIdentifier(drawable, "drawable", context.getPackageName()));
    }

}
