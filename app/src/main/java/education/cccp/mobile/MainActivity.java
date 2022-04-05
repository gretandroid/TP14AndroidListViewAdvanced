package education.cccp.mobile;

import static android.R.drawable.checkbox_off_background;
import static android.R.drawable.checkbox_on_background;

import static education.cccp.mobile.R.id.iconId;
import static education.cccp.mobile.R.id.rowLabelId;
import static education.cccp.mobile.R.layout.activity_main;
import static education.cccp.mobile.R.layout.row;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainActivity extends ListActivity {

    private String[] metasyntactics = {
            "foo", "bar", "baz", "qux",
            "quux", "corge", "grault", "garply",
            "waldo", "fred", "plugh", "xyzzy", "thud"
    };


    Integer currentRowIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        setListAdapter(new CustomAdadpter(this,
                row,
                rowLabelId,
                metasyntactics)
        );
    }

    public void onClickIconOneStarRateEvent(View view) {
        Log.d(MainActivity.class.getSimpleName(), "onClickIconOneStarRateEvent");
        ((ImageView) findViewById(R.id.iconOneStarId))
                .setImageResource(android.R.drawable.star_on);
        Log.d(MainActivity.class.getSimpleName(), "onClickIconOneStarRateEvent position actuel : " + currentRowIndex);
    }

    public void onClickIconTwoStarRateEvent(View view) {
        Log.d(MainActivity.class.getSimpleName(), "onClickIconTwoStarRateEvent");

    }

    public void onClickIconThreeStarRateEvent(View view) {
        Log.d(MainActivity.class.getSimpleName(), "onClickIconThreeStarRateEvent");
    }

    public void onClickIconFourStarRateEvent(View view) {
        Log.d(MainActivity.class.getSimpleName(), "onClickIconFourStarRateEvent");
    }

    public void onClickIconFiveStarRateEvent(View view) {
        Log.d(MainActivity.class.getSimpleName(), "onClickIconFiveStarRateEvent");
    }

    class CustomAdadpter extends ArrayAdapter<String> {

        public CustomAdadpter(@NonNull Context context,
                              int resource,
                              int textViewResourceId,
                              @NonNull String[] objects) {
            super(context,
                    resource,
                    textViewResourceId,
                    objects);
        }

        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            View view = super.getView(position,
                    convertView,
                    parent);
            ImageView icon = view.findViewById(iconId);
            if (metasyntactics[position].length() > 4) {
                icon.setImageResource(checkbox_on_background);
            } else icon.setImageResource(checkbox_off_background);
            Log.d(
                    CustomAdadpter.class.getSimpleName(),
                    "position : " + position
            );
            currentRowIndex = position;

            return view;
        }
    }
}