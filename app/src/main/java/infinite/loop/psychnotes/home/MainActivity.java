package infinite.loop.psychnotes.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.andtinder.view.CardContainer;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import infinite.loop.psychnotes.R;
import infinite.loop.psychnotes.common.PsychActivity;
import infinite.loop.psychnotes.common.model.PsychNote;
import infinite.loop.psychnotes.common.mvp.MainCardsPresenter;
import infinite.loop.psychnotes.common.mvp.MainCardsView;

public class MainActivity extends PsychActivity implements MainCardsView {


    @Bind(R.id.id_cards)
    CardContainer mCardContainer;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.id_progress)
    GoogleProgressBar mProgressBar;

    MainCardsPresenter mMainCardsPresenter;
    CustomCardsAdapter mCustomCardsAdapter;


    //*********************************************************************
    // Life cycles
    //*********************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        initialiseCards();

        mMainCardsPresenter = new MainCardsPresenter();
        mMainCardsPresenter.setView(this);
    }


    //*********************************************************************
    // View related
    //*********************************************************************

    private void initialiseCards() {
        mCustomCardsAdapter = new CustomCardsAdapter(this);
        mCardContainer.setAdapter(mCustomCardsAdapter);
    }

    //*********************************************************************
    // Menu related
    //*********************************************************************

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /**
         * TODO: Commented for Alpha Release
         */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_restart:
                mCustomCardsAdapter.clearCards();
                mMainCardsPresenter.setView(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //*********************************************************************
    // Interface implementations
    //*********************************************************************

    @Override
    public void addToCards(PsychNote note) {
        mCustomCardsAdapter.addNotes(note);
        mCardContainer.setAdapter(mCustomCardsAdapter);
    }

    @Override
    public void showLoading() {
        mCardContainer.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mCardContainer.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideError() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showSuccess(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }


    //*********************************************************************
    // End of class
    //*********************************************************************

}
