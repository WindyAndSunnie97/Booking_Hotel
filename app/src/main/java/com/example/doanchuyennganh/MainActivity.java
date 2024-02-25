package com.example.doanchuyennganh;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import book.Book;
import me.relex.circleindicator.CircleIndicator;
import popular.Popular;
import popular.PopularAdapter;

public class MainActivity extends AppCompatActivity {



    // Creating Object of ViewPagerAdapter
private ViewPager mViewPager;
private CircleIndicator mCircleIndicator;
private List<Photo> mListPhoto;

private Handler mHandler = new Handler();
private Runnable mRunnable = new Runnable() {
    @Override
    public void run() {
        if (mViewPager.getCurrentItem() == mListPhoto.size() - 1) {
            mViewPager.setCurrentItem( 0 );
        } else {
            mViewPager.setCurrentItem( mViewPager.getCurrentItem() + 1 );
        }

    }
};

    private RecyclerView l4;
    private UserAdapter mUserAdapter;

    private RecyclerView rcvpopular;
    private PopularAdapter popularAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mViewPager = findViewById( R.id.view_pager );
        mCircleIndicator = findViewById( R.id.circle_indicator );

        mListPhoto = getListPhoto();


        PhotoViewPagerAdapter adapter = new PhotoViewPagerAdapter( mListPhoto );
        mViewPager.setAdapter( adapter );

        mCircleIndicator.setViewPager( mViewPager );

        mHandler.postDelayed( mRunnable, 3000 );
        mViewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            mHandler.removeCallbacks( mRunnable );
                mHandler.postDelayed( mRunnable, 3000 );
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        } );

        rcvpopular = findViewById( R.id.rcv_popular );
        popularAdapter = new PopularAdapter( this );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this, RecyclerView.VERTICAL, false );
        rcvpopular.setLayoutManager( linearLayoutManager );

        popularAdapter.setData( getListPopular() );
        rcvpopular.setAdapter( popularAdapter );
        rcvpopular.setFocusable( false );
        rcvpopular.setNestedScrollingEnabled( false );

        l4 = findViewById( R.id.l4 );
        mUserAdapter = new UserAdapter( this );

        GridLayoutManager gridLayoutManager = new GridLayoutManager( this, 2 );
        l4.setLayoutManager( gridLayoutManager );

        mUserAdapter.setData( getListUser() );

        l4.setAdapter( mUserAdapter );
        l4.setFocusable( false );
        l4.setNestedScrollingEnabled( false );
    }

    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add( new Photo( R.drawable.login ) );
        list.add( new Photo( R.drawable.login ) );
        list.add( new Photo( R.drawable.login ) );
        list.add( new Photo( R.drawable.login ) );
        return list;
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add( new User( R.drawable.login, "User name 1", 50 ) );
        list.add( new User( R.drawable.login, "User name 2", 50 ) );
        list.add( new User( R.drawable.login, "User name 3", 50 ) );
        list.add( new User( R.drawable.login, "User name 4", 50 ) );


        list.add( new User( R.drawable.login, "User name 6", 50 ) );
        list.add( new User( R.drawable.login, "User name 7", 50 ) );
        list.add( new User( R.drawable.login, "User name 8", 50 ) );
        list.add( new User( R.drawable.login, "User name 9", 50 ) );

        list.add( new User( R.drawable.login, "User name 10", 50 ) );
        list.add( new User( R.drawable.login, "User name 11", 50 ) );
        list.add( new User( R.drawable.login, "User name 12", 50 ) );
        list.add( new User( R.drawable.login, "User name 13", 50 ) );




        return list;
    }

    private List<Popular> getListPopular() {
        List<Popular> listPopular = new ArrayList<>();

        List<Book> listBook = new ArrayList<>();
        listBook.add( new Book( R.drawable.login, "hotel" ) );
        listBook.add( new Book( R.drawable.login, "hostel" ) );
        listBook.add( new Book( R.drawable.lo1, "villa" ) );
        listBook.add( new Book( R.drawable.lo1, "house" ) );
        listBook.add( new Book( R.drawable.login, "hotel" ) );
        listBook.add( new Book( R.drawable.lo1, "home" ) );
        listBook.add( new Book( R.drawable.login, "hotel" ) );
        listBook.add( new Book( R.drawable.lo1, "home" ) );

        listPopular.add( new Popular( "Popular", listBook ) );

        return listPopular;
    }

}