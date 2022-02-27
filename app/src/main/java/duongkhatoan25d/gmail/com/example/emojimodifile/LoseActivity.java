package duongkhatoan25d.gmail.com.example.emojimodifile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoseActivity extends AppCompatActivity {
    Button btLose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        btLose = findViewById(R.id.btLose);
        btLose.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            startActivity(myIntent);
        });
    }


}
