import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.example.justicequest.databinding.FragmentJusticeQuestContactHelpBinding

class JusticeQuestContactHelp : Fragment() {
    private lateinit var binding: FragmentJusticeQuestContactHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Corrected inflation using View Binding
        binding = FragmentJusticeQuestContactHelpBinding.inflate(inflater, container, false)

        // CardView OnClickListeners
        binding.cardChildline.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:1098".toUri()
            startActivity(intent)
        }

        binding.cardNCPCR.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = "https://ncpcr.gov.in".toUri()
            startActivity(urlIntent)
        }

        binding.cardWomenChild.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:181".toUri()
            startActivity(intent)
        }

        binding.cardPolice.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:100".toUri()
            startActivity(intent)
        }

        binding.cardPosco.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = "https://ncpcr.gov.in".toUri()
            startActivity(urlIntent)
        }

        binding.cardCCP.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = "https://centreforchildprotection.org/".toUri()
            startActivity(urlIntent)
        }

        binding.cardResources.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = "https://www.childlineindia.org".toUri()
            startActivity(urlIntent)
        }

        binding.cardBooklet.setOnClickListener {
            downloadPdf(
                "https://nhrc.nic.in/sites/default/files/ChildrenRights.pdf",  // <<--- Change this to your actual PDF link
                "NHRC Children Rights.pdf"                // <<--- File name to save as
            )
        }

        return binding.root // Return root view using ViewBinding
    }

    private fun downloadPdf(url: String, fileName: String) {
        val request = DownloadManager.Request(url.toUri())
            .setTitle(fileName)
            .setDescription("Downloading PDF...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)

        val downloadManager = requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadManager.enqueue(request)
    }
}
