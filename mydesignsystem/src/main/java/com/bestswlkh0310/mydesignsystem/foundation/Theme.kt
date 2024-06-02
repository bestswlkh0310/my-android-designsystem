package com.bestswlkh0310.mydesignsystem.foundation

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.bestswlkh0310.mydesignsystem.foundation.color.LocalGrowColorScheme
import com.bestswlkh0310.mydesignsystem.foundation.color.darkColorScheme
import com.bestswlkh0310.mydesignsystem.foundation.color.lightColorScheme
import com.bestswlkh0310.mydesignsystem.foundation.typography.LocalGrowTypography

@Composable
fun GrowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when (darkTheme) {
        true -> darkColorScheme()
        false -> lightColorScheme()
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    CompositionLocalProvider(
        LocalGrowColorScheme provides colorScheme,
        LocalGrowTypography provides GrowTheme.typography,
        content = content
    )
}