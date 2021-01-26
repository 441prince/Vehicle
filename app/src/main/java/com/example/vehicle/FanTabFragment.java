package com.example.vehicle;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class FanTabFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fan_tab_fragment, container, false);
        return view;
    }

    // fan speed increasing and decreasing on "+" and "-" icon click and uploading it to database
    Button increase,decrease;
    ImageView fan;
    TextView fanSpeed;
    DatabaseHelper myDb;
    ImageButton airUp;
    int count=0;
    String value;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myDb=new DatabaseHelper(requireContext());

        increase=(Button) view.findViewById(R.id.increase);
        decrease=(Button) view.findViewById(R.id.decrease);
        fanSpeed=(TextView) view.findViewById(R.id.fanSpeed);
        fan=(ImageView)view.findViewById(R.id.imageView6) ;
        airUp=(ImageButton)view.findViewById(R.id.imageView);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<7){
                    count++;}

                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.dashfanon);
                value=Integer.toString(count);
                fanSpeed.setText( value);

            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>0){
                    count--;}
                else if(count<1) {
                    ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                    image.setImageResource(R.drawable.dashfannew);
                    Toast.makeText(requireActivity(),"Fan Turned Off",Toast.LENGTH_SHORT).show();
                }
                value=Integer.toString(count);
                fanSpeed.setText( value);

            }
        });

        airUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) view.findViewById(R.id.imageView5);
                image.setImageResource(R.drawable.dashfanon);
            }
        });

        AddData();

        Cursor cursor= myDb.getData();
        if (cursor.getCount()==0){
            Toast.makeText(requireContext(),"No data",Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){

                fanSpeed.setText(cursor.getString(1));


            }
        }

    }

    public  void AddData() {
        fan.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(fanSpeed.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(requireActivity(),"Fan speed saved",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(requireActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}