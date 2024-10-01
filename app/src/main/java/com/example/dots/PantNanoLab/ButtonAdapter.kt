import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dots.R

data class ButtonData(val iconResId: Int, val text: String)

class ButtonAdapter
    (
    private val buttonList: List<ButtonData>,
    private val onClick: (ButtonData) -> Unit
    ) : RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>()
{

    inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.icon)
        val text: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nanolab_button, parent, false)
        return ButtonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val buttonData = buttonList[position]
        holder.icon.setImageResource(buttonData.iconResId)
        holder.text.text = buttonData.text

        //Configurar el click en el elemento
        holder.itemView.setOnClickListener{
            onClick(buttonData)
        }
    }
    //Te da cuandos items hay
    override fun getItemCount(): Int {
        return buttonList.size
    }

}
