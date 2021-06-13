package com.vineyard.fragments;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceFragmentCompat;

import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.vineyard.BuildConfig;
import com.vineyard.R;

import com.vineyard.constant.Constants;
import com.vineyard.helper.ThemeHelper;

import static com.vineyard.constant.Constants.APP_PACKAGE_NAME;
import static com.vineyard.constant.Constants.GOOGLE_PLAY_MARKET_ANDROID;
import static com.vineyard.constant.Constants.GOOGLE_PLAY_MARKET_WEB;

public class SettingsFragment extends PreferenceFragmentCompat {

    private Intent intent;
    public static BottomSheetDialogFragment myBottomSheet;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(getResources().getColor(R.color.windowBackground));
        setDivider(new ColorDrawable(getResources().getColor(R.color.textColorSecondary)));
        setDividerHeight(1);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preferencess, rootKey);

        getActivity().setTitle(R.string.menu_settings);

        androidx.preference.ListPreference themePreference = findPreference("theme");
        if (themePreference != null) {
            themePreference.setOnPreferenceChangeListener(
                    (preference, newValue) -> {
                        String themeOption = (String) newValue;
                        ThemeHelper.applyTheme(themeOption);
                        return true;
                    });
        }

        findPreference("rate").setOnPreferenceClickListener(preference -> {
            rate(getActivity());
            return true;
        });

        findPreference("share").setOnPreferenceClickListener(preference -> {
            share(getActivity());
            return true;
        });

        findPreference("email").setOnPreferenceClickListener(preference -> {
            email(getActivity());
            return true;
        });

        findPreference("license").setOnPreferenceClickListener(preference -> {
            license(getActivity());
            return true;
        });

        findPreference("description").setOnPreferenceClickListener(preference -> {
            information(getActivity());
            return true;
        });

        findPreference("version").setSummary("v" + BuildConfig.VERSION_NAME);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.menu_settings);
    }

    private void rate(FragmentActivity activity) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(GOOGLE_PLAY_MARKET_ANDROID + APP_PACKAGE_NAME)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(GOOGLE_PLAY_MARKET_WEB + APP_PACKAGE_NAME + "&hl")));
        }
    }

    private void share(FragmentActivity activity) {
        intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, Constants.SHARE_CONTENT);
        intent.setType("text/plain");
        startActivity(intent);
    }

    private void email(FragmentActivity activity) {
        String to = Constants.EMAIL;// Адресат повідомлення
        String subject = getString(R.string.message_subject); // Тема повідомлення
        String body = getString(R.string.message_text); // Текст повідомлення

        intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        String[] toArr = new String[]{to};
        intent.putExtra(Intent.EXTRA_EMAIL, toArr);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(intent);
    }

    private void information(FragmentActivity activity) {
        FragmentManager fm = getChildFragmentManager();
        myBottomSheet = SettingsFragmentBottomSheetDialog.newInstance("Modal Bottom Sheet");
        myBottomSheet.show(fm, myBottomSheet.getTag());
    }

    public void license(Context context) {
        intent = new Intent(getContext(), OssLicensesMenuActivity.class);
        String title = getString(R.string.title_licenses);
        intent.putExtra("title", title);
        // startActivity(intent);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
    }
}