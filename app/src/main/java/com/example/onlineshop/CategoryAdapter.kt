import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.Category
import com.example.onlineshop.R


class CategoryAdapter(
    private val list: List<Category>,
    private val onClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon = view.findViewById<ImageView>(R.id.category_image)
        val title = view.findViewById<TextView>(R.id.category_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = list[position]
        holder.icon.setImageResource(category.icon)
        holder.title.text = category.name

        holder.itemView.setOnClickListener {
            onClick(category)
        }
    }

    override fun getItemCount(): Int = list.size
}
