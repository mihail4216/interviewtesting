package com.misendem.interviewproject.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    companion object {

    }
    /**
     * Возвращает айди лейаута фрагмента
     */
    @LayoutRes
    protected abstract fun layoutRes(): Int

    /**
     * Вызывается при прикреплении фрагмента к активити
     */
    protected fun onAttachFragment(){}

    /**
     * Вызывается после создания вью
     */
    protected abstract fun onViewCreated()

    /**
     * Объект биндинга фрагмента
     */
    protected lateinit var binding: T

    override fun onAttach(context: Context) {
        onAttachFragment()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            layoutRes(),
            container,
            false
        )
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreated()
    }

}