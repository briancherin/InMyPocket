package joseph.com.inmypocket;

import android.content.Context;
import android.os.Vibrator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Brian on 6/28/2016.
 */
public class Timer {

    public Boolean running = true;

    Context mContext;
    public Timer (Context mContext){
        if (mContext!=null) {
            this.mContext = mContext;
        }
    }

    ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

    public void setTimer (final int vibrateLength, int threadLength) {

        final Vibrator v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);

        final Runnable runner = new Runnable() {
            public void run() {
                if (running) v.vibrate(vibrateLength);
            }
        };

        if(running) exec.scheduleAtFixedRate(runner, 0, threadLength, TimeUnit.SECONDS);

    }

    public void stopTimer () {
        exec.shutdown();
    }

}
