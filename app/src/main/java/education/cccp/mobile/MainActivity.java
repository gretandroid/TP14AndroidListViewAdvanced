package education.cccp.mobile;

import static android.R.drawable.checkbox_off_background;
import static android.R.drawable.checkbox_on_background;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MainActivity extends ListActivity {

    String[] items = {"foo", "bar", "baz", "qux",
            "quux", "corge", "grault", "garply",
            "waldo", "fred", "plugh", "xyzzy", "thud"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class CustomAdadpter extends ArrayAdapter<String> {

        public CustomAdadpter(@NonNull Context context,
                              int resource,
                              int textViewResourceId,
                              @NonNull List<String> objects) {
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
            ImageView icon = view.findViewById(R.id.iconId);
            if (items[position].length() > 4)
                icon.setImageResource(checkbox_on_background);
            else icon.setImageResource(checkbox_off_background);

            return view;
        }
    }
}