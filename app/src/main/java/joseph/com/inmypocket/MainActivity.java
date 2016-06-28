package joseph.com.inmypocket;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText lenText;
    Button startButton;
    Button stopButton;

    public static Boolean running = true;
    final int vibrateLength =  1000;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lenText = (EditText)findViewById(R.id.lenText);
        startButton = (Button)findViewById(R.id.startButton);
        stopButton = (Button)findViewById(R.id.stopButton);




        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                timer = new Timer(getApplicationContext());

                timer.running = true;

                if (!lenText.getText().toString().equals("")) {
                    timer.setTimer(vibrateLength, vibrateLength/1000 + Integer.parseInt(lenText.getText().toString()));
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter number of seconds.", Toast.LENGTH_SHORT).show();
                }
/*
                if (!running) running = true;

                ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

                final Runnable runner = new Runnable() {
                    public void run(){
                        if (running) v.vibrate(vibrateLength);
                    }
                };



                if (!lenText.getText().toString().equals("")) {
       //             exec = Executors.newScheduledThreadPool(1);
                    exec.scheduleAtFixedRate(runner, 0, vibrateLength/1000 + Integer.parseInt(lenText.getText().toString()), TimeUnit.SECONDS);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter number of seconds.", Toast.LENGTH_SHORT).show();
                }
*/
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    v.cancel();
                timer.running = false;
          //      exec.shutdown();

            }
        });
    }
}
