package com.example.usama.contactlist;

import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Usama on 9/30/2017.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    class ViewHolder {
        TextView tvName, tvNum, tvGen;
    }

    private static final String TAG = "MTAG";

    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView (int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        Log.d(TAG, "convertview: " + convertView);
        View view = convertView;
        ViewHolder vh;
        final Contact c = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.contact_list, parent, false);

            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            TextView tvNum = (TextView) view.findViewById(R.id.tvNum);
            TextView tvGen = (TextView) view.findViewById(R.id.tvGen);

            vh = new ViewHolder();
            vh.tvName = tvName;
            vh.tvNum = tvNum;
            vh.tvGen = tvGen;
            view.setTag(vh);
        }

        Button b = (Button) view.findViewById(R.id.callBtn);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
             public void onClick(View v) {

                 Intent callIntent = new Intent(Intent.ACTION_CALL);
                 callIntent.setData(Uri.parse("tel:" +c.getNumber()));
                     if(ContextCompat.checkSelfPermission(getContext(),
                             Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED)
                     {
                         ActivityCompat.requestPermissions((MainActivity)getContext(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                     }
                     if(ContextCompat.checkSelfPermission(getContext(),
                             Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                     {
                         getContext().startActivity(callIntent);
                     }
             }
             });

        vh = (ViewHolder) view.getTag();
        vh.tvName.setText(c.getName());
        vh.tvNum.setText(c.getNumber());
        vh.tvGen.setText(c.getGender());

        return view;
    }
}
