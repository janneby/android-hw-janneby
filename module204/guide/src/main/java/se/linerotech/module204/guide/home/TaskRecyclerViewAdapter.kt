package se.linerotech.module204.guide.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import se.linerotech.module204.guide.databinding.RecyclerCellTaskBinding

class TaskRecyclerViewAdapter(
    private val onTaskCheckedListener: (Task) -> Unit,
    private val onTaskDeletedListener: (Task) -> Unit,
) : RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Task>() {
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.create(parent, onTaskCheckedListener, onTaskDeletedListener)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class TaskViewHolder(
        private val binding: RecyclerCellTaskBinding,
        private val onTaskCheckedListener: (Task) -> Unit,
        private val onTaskDeletedListener: (Task) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.textViewTaskName.text = task.name
            binding.checkBoxTaskDone.isChecked = task.isCompleted
            binding.checkBoxTaskDone.setOnClickListener {
                onTaskCheckedListener(task)
            }
            binding.imageButtonDelete.setOnClickListener {
                onTaskDeletedListener(task)
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onTaskCheckedListener: (Task) -> Unit,
                onTaskDeletedListener: (Task) -> Unit
            ): TaskViewHolder {
                val binding = RecyclerCellTaskBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return TaskViewHolder(binding, onTaskCheckedListener, onTaskDeletedListener)
            }
        }
    }
}
