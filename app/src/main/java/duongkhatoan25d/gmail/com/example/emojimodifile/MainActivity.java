package duongkhatoan25d.gmail.com.example.emojimodifile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.GridView;

import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    TextView image;
    int heart = 3;
    int[] emoji = { 0x1F600, 0x1F603, 0x1F604, 0x1F601, 0x1F605, 0x1F988,
            0x1F606, 0x1F923, 0x1F602, 0x1F970, 0x1F60D, 0x1F972,
            0x1F911, 0x1F912, 0x1F913, 0x1F92A, 0x1F917, 0x1F914,
            0x1F910, 0x1F636, 0x1F644, 0x1F62C, 0x1F614, 0x1F62A};

    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid);
        image = findViewById(R.id.image);

        newGame(grid, image);

        grid.setOnItemClickListener((adapterView, view, i, l) -> {
            TextView click = (TextView) view;
            if(image.getText().hashCode() == click.getText().hashCode()){
                //Win view
                Intent win = new Intent(view.getContext(), WinActivity.class);
                startActivity(win);
            }else{
                heart--;
                if(heart<0){
                    //Lose view
                    Intent lose = new Intent(view.getContext(), LoseActivity.class);
                    startActivity(lose);

                }else{
                    Toast.makeText(getApplicationContext(), "Còn lại "+ heart +" mạng.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void newGame(GridView grid, TextView image){
        List<String> data = new ArrayList();
        shuffleArray(emoji);


        for (int a =0 ; a<20; a++){
            data.add(new String(Character.toChars(emoji[a])));
        }

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),R.layout.items, data);
        grid.setAdapter(myAdapter);

        Random random = new Random();
        image.setText(data.get(random.nextInt(20)));
    }

}