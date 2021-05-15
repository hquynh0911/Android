package vn.edu.hust.soict.android.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //store
    private int mScore1;
    private int mScore2;
    private TextView score1;
    private TextView score2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle("Day Mode");
        }
        else menu.findItem(R.id.night_mode).setTitle("Night Mode");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode =MaterialC.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            recreate();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1 = findViewById(R.id.score_1);
        score2 = findViewById(R.id.score_2);
    }

    public void decreaseScore1(View view) {
        mScore1 --;
        if(mScore1 < 0) mScore1=0;
        score1.setText(String.valueOf(mScore1));
    }
    public void decreaseScore2(View view) {
        mScore2 --;
        if(mScore2 < 0) mScore2=0;
        score2.setText(String.valueOf(mScore2));
    }
    public void increaseScore1(View view) {
        mScore1 ++;
        score1.setText(String.valueOf(mScore1));
    }
    public void increaseScore2(View view) {
        mScore2 ++;
        score2.setText(String.valueOf(mScore2));
    }
}