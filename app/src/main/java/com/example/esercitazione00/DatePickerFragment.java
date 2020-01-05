/*Luca Danilo Melis 65468*/

package com.example.esercitazione00;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    private Calendar date;

    private DatePickerFragmentListener listener;

    public Dialog onCreateDialog(Bundle saveInstanceState){
        super.onCreateDialog(saveInstanceState);

        if(date == null){
            date = Calendar.getInstance();
            date.set(Calendar.YEAR,1998);
            date.set(Calendar.MONTH,Calendar.OCTOBER);
            date.set(Calendar.DAY_OF_MONTH,21);
        }
        final DatePicker datePicker = new DatePicker(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(datePicker);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                date.set(Calendar.YEAR, datePicker.getYear());
                date.set(Calendar.MONTH, datePicker.getMonth());
                date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

                if (listener != null){
                    listener.onDatePickerFragmentOkButton(DatePickerFragment.this, date);
                }
            }
        });

        builder.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(listener != null){
                    listener.onDatePickerFragmentCancelButton(DatePickerFragment.this);
                }
            }
        });

        return builder.create();
    }

    public Calendar getDate(){
        return date;
    }

    public void setDate(Calendar date ){
        this.date = date;
    }

    public void setOnDatePickerFragmentChanged(DatePickerFragmentListener l){
        this.listener = l;
    }
    public interface DatePickerFragmentListener{
        public void onDatePickerFragmentOkButton(DialogFragment dialog, Calendar date);
        public void onDatePickerFragmentCancelButton(DialogFragment dialog);
    }
}
