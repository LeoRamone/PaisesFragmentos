package com.leonardo_soares_santos.paisesfragmentos.Activitys;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.leonardo_soares_santos.paisesfragmentos.R;

import java.lang.reflect.Field;

public class Util {
    public static Drawable getDrawable(Context context, String nome){

        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(nome);
            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
