package duongkhatoan25d.gmail.com.example.emojimodifile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WinActivity extends AppCompatActivity {
    Button btWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        btWin = findViewById(R.id.btWin);
        btWin.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            startActivity(myIntent);
        });
    }
}
