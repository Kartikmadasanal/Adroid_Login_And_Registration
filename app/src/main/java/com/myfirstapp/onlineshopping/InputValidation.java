package com.myfirstapp.onlineshopping;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {
    private final Context context;


    InputValidation(Context context) {
        this.context = context;
    }


    boolean isInputEditTextFilled(EditText editText, TextInputLayout textInputLayout, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(editText);
            return true;
        } else {
            textInputLayout.setErrorEnabled(false);
        }

        return false;
    }


    boolean isInputEditTextEmail(EditText editText, TextInputLayout textInputLayout, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(editText);
            return true;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return false;
    }

    boolean isInputEditTextMatches(EditText editText1, EditText editText2, TextInputLayout textInputLayout, String message) {
        String value1 = editText1.getText().toString().trim();
        String value2 = editText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            textInputLayout.setError(message);
            hideKeyboardFrom(editText2);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }


    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}