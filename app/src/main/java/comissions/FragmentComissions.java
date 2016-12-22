package comissions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.R;

import java.util.zip.Inflater;

/**
 * Created by SourabhSadhu on 22-12-2016.
 */

public class FragmentComissions extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment_reversal,container,false);
    }
}
