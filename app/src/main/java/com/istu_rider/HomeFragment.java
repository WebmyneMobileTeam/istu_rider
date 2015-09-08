package com.istu_rider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment{

    private ListView listData;
    CustomAdapter adp;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View convertView = inflater.inflate(R.layout.fragment_homme, container, false);

        listData = (ListView)convertView.findViewById(R.id.listData);

        adp = new CustomAdapter(getActivity());
        listData.setAdapter(adp);

        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),OrderDetails.class);
                startActivity(i);
            }
        });

        return convertView;
    }
    private class CustomAdapter extends BaseAdapter {

        private Context _ctx;

        public CustomAdapter(Context _ctx) {
            this._ctx = _ctx;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = (LayoutInflater)_ctx.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.ri_home, null);
            View  viewLine = (View)convertView.findViewById(R.id.viewLine);
            viewLine.setBackgroundColor(Color.parseColor("#009688"));


            return convertView;
        }
    }






//end of main class
}
