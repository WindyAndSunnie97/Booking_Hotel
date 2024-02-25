package popular;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anh3.R;

import java.util.List;

import book.BookAdapter;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private Context mContext;
    private List<Popular> mListPopular;

    public PopularAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<Popular> list) {
        this.mListPopular = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.category, parent, false );
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        Popular popular = mListPopular.get( position );
        if(popular == null) {
            return;
        }
        holder.tvNamePopular.setText( popular.getNamePopular() );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( mContext, RecyclerView.HORIZONTAL, false );
        holder.rcvBook.setLayoutManager( linearLayoutManager );

        BookAdapter bookAdapter = new BookAdapter();
        bookAdapter.setData( popular.getBooks() );
        holder.rcvBook.setAdapter( bookAdapter );
    }

    @Override
    public int getItemCount() {
        if ( mListPopular!=null){
            return mListPopular.size();
        }

        return 0;
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNamePopular;
        private RecyclerView rcvBook;


        public PopularViewHolder(@NonNull View itemView) {
            super( itemView );

            tvNamePopular = itemView.findViewById( R.id.tv_name_popular );
            rcvBook = itemView.findViewById( R.id.rcv_book );
        }
    }
   }
