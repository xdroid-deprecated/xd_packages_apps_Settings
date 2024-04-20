package xyz.xd.ui.frameworks.preferences;

import android.content.Context;
import android.os.SystemProperties;
import androidx.annotation.VisibleForTesting;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class XDBuildMaintainer extends BasePreferenceController {

    @VisibleForTesting

    public XDBuildMaintainer(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    // xdOSS Build Status
    /* This code was taken from BootleggersROM
       https://github.com/BootleggersROM/packages_apps_BootlegDumpster
    */
    @Override
    public CharSequence getSummary() {

        String xdMaintainer = SystemProperties.get("ro.xdroid.maintainer", "Unmaintained");
        String xdBuildStatusSummary;

        if(xdMaintainer.equalsIgnoreCase("Unmaintained") || xdMaintainer.equalsIgnoreCase(null)){
            xdBuildStatusSummary = mContext.getString(R.string.xd_build_unmaintained_summary);
        } else {
            xdBuildStatusSummary = mContext.getString(R.string.xd_build_maintained_summary, xdMaintainer);
        }
	    return xdBuildStatusSummary;
    }
}