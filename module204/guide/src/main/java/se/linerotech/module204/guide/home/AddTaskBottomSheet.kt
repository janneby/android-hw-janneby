package se.linerotech.module204.guide.home

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import se.linerotech.module204.guide.R

class AddTaskBottomSheet(private val onItemAdded: (String) -> Unit) : BottomSheetDialogFragment() {
    private var editText: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_task_bottom_sheet, container, false)
        editText = view.findViewById(R.id.editTextTaskCreation)

        editText?.requestFocus()
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        editText?.setOnEditorActionListener { textView, i, keyEvent ->
            val text = textView.text.toString().trim()
            if (text.isNotEmpty()) onItemAdded(text)
            dismiss()
            true
        }

        return view
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        editText?.text?.clear()
    }

    companion object {
        const val TAG = "AddTaskBottomSheet"
    }
}
