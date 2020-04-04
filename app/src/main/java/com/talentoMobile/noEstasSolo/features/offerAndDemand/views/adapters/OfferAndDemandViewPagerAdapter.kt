import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.talentoMobile.noEstasSolo.features.offerAndDemand.views.NeededFragment
import com.talentoMobile.noEstasSolo.features.offerAndDemand.views.OfferFragment

class OfferAndDemandViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private var fragments: ArrayList<Fragment> = arrayListOf(
        NeededFragment(),
        OfferFragment()
    )

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NeededFragment()
            1 -> OfferFragment()
            else -> Fragment()
        }
    }

    override fun getItemCount(): Int {
        return fragments.size
    }
}