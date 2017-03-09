package com.testproject.wellthyuserviewer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * Created by prachi on 09/03/17.
 */
public final class Common {

    private Common() {

    }

    public static AlertDialog createAlertDialog(Context context, String title) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        return builder.create();

    }

}
