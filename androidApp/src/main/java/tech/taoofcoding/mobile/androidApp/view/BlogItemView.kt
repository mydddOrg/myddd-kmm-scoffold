package tech.taoofcoding.mobile.androidApp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.taoofcoding.mobile.shared.entity.BlogDTO

@Composable
fun BlogItemView(blogDTO: BlogDTO) {
    Column {
        Column(
            Modifier
                .padding(10.dp)
                .clickable { Unit }) {
            Text(
                text = blogDTO.title,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = blogDTO.brief,
                style = MaterialTheme.typography.caption
            )
            Text(text = blogDTO.date)
        }
        Divider()
    }

}