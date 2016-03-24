package gj.udacity.project1.popularmovies.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import gj.udacity.project1.popularmovies.Fragments.FavoriteMovieDetailFragment;
import gj.udacity.project1.popularmovies.Fragments.MovieDetailFragment;
import gj.udacity.project1.popularmovies.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String type = getIntent().getExtras().getString("Type");

        if(type.equals(getString(R.string.favorite))){
            long id = getIntent().getExtras().getInt("ID");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detailFragment, FavoriteMovieDetailFragment.newInstance(id))
                    .commit();
        }
        else {
            int position = getIntent().getExtras().getInt("Position");

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detailFragment, MovieDetailFragment.newInstance(position))
                    .commit();
        }
    }

    /*
    private Intent createShareForecastIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mForecast + FORECAST_SHARE_HASHTAG);
        return shareIntent;
    } */

}
