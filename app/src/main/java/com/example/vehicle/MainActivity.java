package com.example.vehicle;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.vehicle.domain.hmidata.DatabaseHelper;
import com.example.vehicle.presentation.view.TwoTabFragment;


public class MainActivity extends AppCompatActivity {
    private ImageButton fan;
    private ImageButton leftSeat;
    private ImageButton rightSeat;
    private ImageButton ac,defrost,rearDefrost;

    Dialog usermode;
    DatabaseHelper myDb;
    public int clickCount=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usermode = new Dialog(this);

        myDb=new DatabaseHelper(this);

        setContentView(R.layout.activity_main);
        ac=findViewById(R.id.imageButton4);
        SeekBar colorSeekBar;
        colorSeekBar=findViewById(R.id.customSeekBar);
        colorSeekBar.setVisibility(View.GONE);
        TextView ac_temp;
        ac_temp= findViewById(R.id.actemp);
        ac_temp.setVisibility(View.GONE);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ac_temp;
                ac_temp= findViewById(R.id.actemp);
                SeekBar colorSeekBar;
                colorSeekBar=findViewById(R.id.customSeekBar);
                colorSeekBar.setVisibility(View.VISIBLE);

                ac_temp.setVisibility(View.GONE);

                colorSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        //ac_temp.setText(String.format("%d°C",progress));
                        int val = (progress * (seekBar.getWidth() - 5 * seekBar.getThumbOffset())) / seekBar.getMax();
                        ac_temp.setText(String.format("%d°C",progress));
                        ac_temp.setX(seekBar.getX()-100 + val + seekBar.getThumbOffset() / 2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        ac_temp.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        ac_temp.setVisibility(View.GONE);
                        colorSeekBar.setVisibility(View.GONE);
                    }


                });
            }
        });

        fan=(ImageButton)findViewById(R.id.imageButton6);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //BottomSheetDialog bottomSheet = new BottomSheetDialog();
                //bottomSheet.show(getSupportFragmentManager(),
                //       "ModalBottomSheet");
                fan.animate().rotation(fan.getRotation()+360).start();

                FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new TwoTabFragment());
                ft.commit();

            }
        });

        leftSeat=(ImageButton)findViewById(R.id.imageButton5);
        leftSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton image = (ImageButton) v.findViewById(R.id.imageButton5);
                if(clickCount==1){
                    image.setImageResource(R.drawable.leftlow);
                    Toast.makeText(getApplicationContext(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==2){
                    image.setImageResource(R.drawable.leftmed);
                    Toast.makeText(getApplicationContext(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==3){
                    image.setImageResource(R.drawable.lefthigh);
                    Toast.makeText(getApplicationContext(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==4){
                    image.setImageResource(R.drawable.leftseat);
                    Toast.makeText(getApplicationContext()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    clickCount=1;
                }

            }
        });

        rightSeat=(ImageButton)findViewById(R.id.imageButton7);
        rightSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton image = (ImageButton) v.findViewById(R.id.imageButton7);
                if(clickCount==1){
                    image.setImageResource(R.drawable.rightlow);
                    Toast.makeText(getApplicationContext(),"Low Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==2){
                    image.setImageResource(R.drawable.rightmed);
                    Toast.makeText(getApplicationContext(),"Medium Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==3){
                    image.setImageResource(R.drawable.righthigh);
                    Toast.makeText(getApplicationContext(),"High Heat Mode On",Toast.LENGTH_SHORT).show();
                    clickCount++;
                }else if(clickCount==4){
                    image.setImageResource(R.drawable.rightseat);
                    Toast.makeText(getApplicationContext()," Heat Mode Off",Toast.LENGTH_SHORT).show();
                    clickCount=1;
                }

            }
        });

        //defrost mode
        defrost=(ImageButton)findViewById(R.id.imageButton8);
        defrost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Defrost On",Toast.LENGTH_SHORT).show();
            }
        });

        //rear defrost mode
        rearDefrost=(ImageButton)findViewById(R.id.imageButton9);
        rearDefrost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Rear Defrost On",Toast.LENGTH_SHORT).show();

                for (int i = 0; i < 5; i++) { new Handler().postDelayed(new Runnable() {
                    @Override public void run()
                {Toast toast= Toast.makeText(getApplicationContext(),
                        "Rear Defrosting.....", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show(); } }, i * 1000);}

            }
        });
    }
    public void popup(View view){
        ImageButton dog,camp,user;
        usermode.setContentView(R.layout.custommode);
        dog=(ImageButton) usermode.findViewById(R.id.dog);
        camp=(ImageButton) usermode.findViewById(R.id.camp);
        user=(ImageButton) usermode.findViewById(R.id.user);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dog.setBackgroundColor(getResources().getColor(R.color.Blue));
                Toast.makeText(getApplicationContext(),"Dog Mode is activated",Toast.LENGTH_SHORT).show();
                usermode.dismiss();
            }

        });

        camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camp.setBackgroundColor(getResources().getColor(R.color.Blue));
                Toast.makeText(getApplicationContext(),"Camp Mode is activated",Toast.LENGTH_SHORT).show();
                usermode.dismiss();
            }

        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setBackgroundColor(getResources().getColor(R.color.Blue));
                Toast.makeText(getApplicationContext(),"User Mode is activated",Toast.LENGTH_SHORT).show();
                usermode.dismiss();
            }

        });
        Window window = usermode.getWindow();
        window.setGravity(Gravity.TOP | Gravity.RIGHT);

        usermode.show();
        usermode.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);

    }


}