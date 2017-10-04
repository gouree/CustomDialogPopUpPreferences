package com.example.gouree.customdialogpopuppreferences;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by omsai on 04/10/2017.
 */

public class DisplayDialog extends DialogFragment
{

    LayoutInflater inflater;
    View view;
    EditText name,dob,phone;
    TextView txt;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        inflater = getActivity().getLayoutInflater();
        view =inflater.inflate(R.layout.display_screen,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setView(view).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                name=(EditText)view.findViewById(R.id.name_display);
                phone=(EditText)view.findViewById(R.id.phone_display);
                dob=(EditText)view.findViewById(R.id.dob_display);

                String name_str= name.getText().toString();
                String phone_str= phone.getText().toString();
                String dob_str= dob.getText().toString();



                SharedPreferences preferences = DisplayDialog.super.getContext().getSharedPreferences("MYPREFS",MODE_PRIVATE);



                SharedPreferences.Editor editor = preferences.edit();
                // editor.putString(name_str + "data" , name_str +"\n" +age_str +"\n" +pno_str +"\n"+city_str);
                editor.putString(name_str + "data" , "\n\t\tNAME -->"+name_str +"\n\t\tPHONE-->" +phone_str +"\n\t\tDOB -->" +dob_str );

                editor.commit();
                Toast.makeText(getActivity(), "Welcome " +name.getText().toString()+
                        "\n Phone Number = "+phone.getText().toString(), Toast.LENGTH_LONG).show();



                SharedPreferences preferences3 = DisplayDialog.super.getContext().getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String user_details =preferences.getString("data","user name is incorrect");


                SharedPreferences.Editor editor2 =preferences.edit();
                editor.putString("display",user_details);
                editor.commit();




                SharedPreferences preferences2 =DisplayDialog.super.getContext().getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String display = preferences.getString("display","");
                txt =(TextView)view.findViewById(R.id.textView_main);

                txt.setText(display);



            }
        }) .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();

    }

}
