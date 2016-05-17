package com.mobilleon.smspro.activity;

import com.actionbarsherlock.app.SherlockActivity;
import com.mobilleon.smspro.root.R;
import com.mobilleon.smspro.utilities.Constants;
import com.mobilleon.smspro.utilities.SpanUtility;
import com.mobilleon.smspro.utilities.NetworkUtility.CONNECTION;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


/**
 * @author Atul Kaushik (atul.kaushik@gmail.com)
 *
 */
public class SpanningActivity extends SherlockActivity {

    private CountDownTimer mSpanTimer;
    private CountDownTimer mAppQuitTimer;
    private CountDownTimer mAppWaitTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.span);

        getSpanTimer(3500, 1000);
        mSpanTimer.start();
    }

    private void getSpanTimer(long millisInFuture, long countDownInterval) {
        mSpanTimer = new CountDownTimer(millisInFuture, countDownInterval) {
            @Override
            public void onFinish() {
                getApplicationState();
            }

            private void getApplicationState() {
                new SpanUtility(SpanningActivity.this, appStateHandler).execute();
            }
            
            @Override
            public void onTick(long millisUntilFinished) {
            }
        };
    }
    
    private void navigateToNextScreen() {
        Intent intent = new Intent(this, SMSProActivity.class);
        startActivity(intent);
        finish();
    }

    private Handler appStateHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            processResult((CONNECTION) msg.obj);
        }
    };

private void getAppQuitTimer(long millisInFuture, long countDownInterval) {
    mAppQuitTimer = new CountDownTimer(millisInFuture, countDownInterval) {

        @Override
        public void onFinish() {

            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }
    };
    
}

private void getAppWaitTimer(long millisInFuture, long countDownInterval) {
    mAppWaitTimer = new CountDownTimer(millisInFuture, countDownInterval) {

        @Override
        public void onFinish() {

            navigateToNextScreen();
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }
    };
    
}
    private void processResult(CONNECTION connection) {

        switch (connection) {
        case QUIT:
            Toast.makeText(getApplicationContext(), "INTERNET CONNECTION NOT AVAILABLE.  QUITTING.", Toast.LENGTH_LONG)
                    .show();
            getAppQuitTimer(5000, 1000);
            mAppQuitTimer.start();
            Constants.INTERNET_CONNECTION = CONNECTION.QUIT;
            
            break;
        case PROCEED:
            navigateToNextScreen();
            Constants.INTERNET_CONNECTION = CONNECTION.PROCEED;
            
            break;
        case PROCEED_WITHOUT_INTERNET:
            
            Toast.makeText(getApplicationContext(), "INTERNET CONNECTION NOT AVAILABLE.  PROCEEDING WITHOUT INTERNET.", Toast.LENGTH_SHORT)
            .show();
            getAppWaitTimer(3000, 1000);
            mAppWaitTimer.start();
            Constants.INTERNET_CONNECTION = CONNECTION.PROCEED_WITHOUT_INTERNET;
            
            break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK)
            mSpanTimer.cancel();
        return super.onKeyDown(keyCode, event);
    }
}
