package com.bayuirfan.uinsukaui_javaver.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bayuirfan.uinsukaui_javaver.data.model.News;
import com.bayuirfan.uinsukaui_javaver.databinding.ItemNewsBinding;
import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {
    private final Context context;
    private final List<News> list;

    public NewsAdapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsVH(ItemNewsBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsVH holder, int position) {
        News item = list.get(position);
        Glide.with(context)
                .load(item.getImage())
                .into(holder.binding.imgHeadline);

        holder.binding.txtHeadline.setText(item.getHeadline());
        holder.binding.txtDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NewsVH extends RecyclerView.ViewHolder {
        private final ItemNewsBinding binding;
        public NewsVH(ItemNewsBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }
}
