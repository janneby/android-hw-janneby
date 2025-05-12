package se.linerotech.module204.guide.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import se.linerotech.module204.guide.R

class AddTaskBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_task_bottom_sheet, container, false)
    }

    companion object {
        const val TAG = "AddTaskBottomSheet"
    }
}
