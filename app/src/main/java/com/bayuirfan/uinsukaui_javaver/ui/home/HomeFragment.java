package com.bayuirfan.uinsukaui_javaver.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bayuirfan.uinsukaui_javaver.R;
import com.bayuirfan.uinsukaui_javaver.databinding.FragmentHomeBinding;
import com.bumptech.glide.Glide;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        HomeViewModel mViewModel = new ViewModelProvider(HomeFragment.this).get(HomeViewModel.class);

        Glide.with(this)
                .load("https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/03/a0003572/img/basic/a0003572_main.jpg?20200427164901&q=80&rw=750&rh=536")
                .into(binding.imgProfile);

        binding.rvNews.setAdapter(new NewsAdapter(getContext(), mViewModel.get()));
        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.divider_transparent_10);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }

        if (binding.rvNews.getItemDecorationCount() == 0) {
            binding.rvNews.addItemDecoration(dividerItemDecoration);
        }

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}