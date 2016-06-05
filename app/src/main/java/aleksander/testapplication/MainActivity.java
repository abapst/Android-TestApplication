package aleksander.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    // Menu labels
    String[] menuLabels = new String[]{
            "Accelerometer Test"
    };

    // Menu images
    Integer[] menuImages = {
            R.drawable.ball_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomList adapter =
                new CustomList(MainActivity.this, menuLabels, menuImages);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView l, View v, int position, long id) {

                String item = (String) mListView.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(), item + " selected", Toast.LENGTH_SHORT).show();

                switch(position) {
                    case 0: Intent newActivity = new Intent(MainActivity.this, BallActivity.class);
                        startActivity(newActivity);
                        break;
                }
            }
        });

    }
}
