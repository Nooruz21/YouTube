package com.example.sixthmsecondhmyoutubeapp.youtube.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sixthmsecondhmyoutubeapp.R
import com.example.sixthmsecondhmyoutubeapp.databinding.FragmentSplashScreenBinding
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseFragment
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding, SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentSplashScreenBinding {
        return FragmentSplashScreenBinding.inflate(inflater, container, false)
    }


    override fun initView() {
        viewModel.getPlaylist()
        viewModel.playlist.observe(viewLifecycleOwner) {
            viewModel.progress.value = it.status == Resource.Status.LOADING
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { it1 -> viewModel.setPlaylist(it1) }
                }
                Resource.Status.ERROR -> {

                }
                else -> {

                }
            }
        }

        viewModel.setPlaylist.observe(viewLifecycleOwner) {
            if (it.status == Resource.Status.SUCCESS && it.data == true) {
                Handler(Looper.getMainLooper()).postDelayed({
                    findNavController().navigate(R.id.action_splashScreenFragment_to_playlistFragment)
                }, 1000)
            }
        }
    }

    override fun initListener() {

    }


}