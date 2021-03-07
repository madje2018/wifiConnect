package com.example.wificonnect;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wificonnect.Accesspoint;
import com.example.wificonnect.R;

import java.util.List;

public class WifiAdapter extends BaseAdapter {

    private List<Accesspoint>listAccespoint;
    private LayoutInflater layoutInflater;

    public WifiAdapter(Context context, List<Accesspoint> objects) {

        listAccespoint = objects;
        layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return listAccespoint.size();
    }

    public Object getItem(int position) {
        return listAccespoint.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    private class ViewWifiHolder {
        TextView tvApName;
        TextView tvAdresseMac;
        TextView ForceSignal;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewWifiHolder viewWifiHolder;

        if(convertView==null){
            viewWifiHolder = new ViewWifiHolder();

            convertView = layoutInflater.inflate(R.layout.list_wifi, null);

            viewWifiHolder.tvApName = (TextView) convertView.findViewById(R.id.wifiName);
            viewWifiHolder.tvAdresseMac = (TextView) convertView.findViewById(R.id.wifiMac);
            viewWifiHolder.ForceSignal = (TextView) convertView.findViewById(R.id.ForceSignal);

            convertView.setTag(viewWifiHolder);
        }else {
            viewWifiHolder = (ViewWifiHolder)convertView.getTag();
        }

        //  affectation de valeurs
        viewWifiHolder.tvApName.setText(listAccespoint.get(position).getNomAP());
        viewWifiHolder.tvAdresseMac.setText(listAccespoint.get(position).getAdresseMac());

        // modification de la couleur en fonction de la force du signal
        if(listAccespoint.get(position).getForceSignal() <= -80) {
            viewWifiHolder.ForceSignal.setBackgroundColor(Color.GREEN);
        } else if(listAccespoint.get(position).getForceSignal() <= -50) {
            viewWifiHolder.ForceSignal.setBackgroundColor(Color.YELLOW);
        } else {
            viewWifiHolder.ForceSignal.setBackgroundColor(Color.RED);
        }

        return convertView;
    }
}
