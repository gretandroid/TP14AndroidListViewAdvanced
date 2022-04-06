package education.cccp.mobile;

import static android.R.drawable.star_off;
import static android.R.drawable.star_on;
import static education.cccp.mobile.R.id.iconOneStarId;
import static education.cccp.mobile.R.id.iconTwoStarId;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        setListAdapter(new CustomAdapter(this,
                row,
                rowLabelId,
                metasyntactics)
        );
    }

    class CustomAdapter extends ArrayAdapter<String> {
        public CustomAdapter(@NonNull Context context,
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
            Log.d(
                    CustomAdapter.class.getSimpleName(),
                    "position : " + position
            );
            starOne(view);
            starTwo(view);
            starThree(view);
            starFour(view);
            starFive(view);
            return view;
        }

        private void starOne(View view) {
            ImageView iconOneStar = view.findViewById(iconOneStarId);
            iconOneStar.setTag(star_off);
            iconOneStar.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if ((int) view.getTag() == star_off) {
                                ((ImageView) view).setImageResource(star_on);
                                view.setTag(star_on);
                            } else {
                                ((ImageView) view).setImageResource(star_off);
                                view.setTag(star_off);
                            }
                        }
                    }
            );
        }

        private void starTwo(View view) {
            ImageView iconTwoStar = view.findViewById(iconTwoStarId);
            iconTwoStar.setTag(star_off);
            iconTwoStar.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ImageView starTwoImageView = (ImageView) ((View) view
                                    .getParent())
                                    .findViewById(iconOneStarId);
                            ImageView starOneImageView = (ImageView) view;
                            ImageView iconOneStar = ((View) view.getParent())
                                    .findViewById(iconOneStarId);
                            iconOneStar.setTag(star_off);
                            if ((int) view.getTag() == star_off) {
                                starOneImageView.setImageResource(star_on);
                                starTwoImageView.setImageResource(star_on);
                                starTwoImageView.setTag(star_on);
                                view.setTag(star_on);
                            } else {
                                starOneImageView.setImageResource(star_off);
                                starTwoImageView.setImageResource(star_off);
                                starTwoImageView.setTag(star_off);
                                starOneImageView.setTag(star_off);
                            }
                        }
                    }
            );
        }

        private void starThree(View view) {

        }

        private void starFour(View view) {

        }

        private void starFive(View view) {

        }
    }
}