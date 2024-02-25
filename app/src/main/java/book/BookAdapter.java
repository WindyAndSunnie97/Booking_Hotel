package book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anh3.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> mbooks;

    public void setData(List<Book> list) {
        this.mbooks = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_book, parent, false );
        return new BookViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        Book book = mbooks.get( position );
        if (book == null) {
            return;
        }

        holder.imgbook.setImageResource( book.getResourceID() );
        holder.tvTitle.setText( book.getTitle() );
    }

    @Override
    public int getItemCount() {
        if (mbooks != null){
            return mbooks.size();
        }

        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgbook;
        private TextView tvTitle;

        public BookViewHolder(@NonNull View itemView) {
            super( itemView );

            imgbook = itemView.findViewById( R.id.img_book );
            tvTitle = itemView.findViewById( R.id.tv_title );
        }
    }
}
