package com.wafflestudio.waffleseminar2024.main.profile

import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.wafflestudio.waffleseminar2024.R
import com.wafflestudio.waffleseminar2024.databinding.ActivityUserInformationBinding
import com.wafflestudio.waffleseminar2024.main.TabLayoutViewAdapter

class ProfileTabViewHolder(val activity: AppCompatActivity, parent: ViewGroup) : TabLayoutViewAdapter.TabViewHolder(ActivityUserInformationBinding.inflate(activity.layoutInflater, parent, false)) {

    private val binding = super.viewBinding as ActivityUserInformationBinding

    override fun bind() {
        addToolbarOption()
        addWorkspaceUrl()
        addGithubLink()
    }

    private fun addToolbarOption() {
        val toolbar = binding.toolbarUserInformation
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.title = "프로필"
        activity.supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_new_24)
    }

    private fun addWorkspaceUrl() {
        val slackWorkspaceValueView = binding.slackWorkspaceValue
        val workspaceUrl = activity.intent.getStringExtra("WORKSPACE_URL")
        slackWorkspaceValueView.text = workspaceUrl
    }

    private fun addGithubLink() {
        val textView = binding.githubValue
        val text = "hjlim7831"
        val spannableString = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: android.view.View) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hjlim7831"))
                activity.startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        spannableString.setSpan(clickableSpan, 0, text.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

}