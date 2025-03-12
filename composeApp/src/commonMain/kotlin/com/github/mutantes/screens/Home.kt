import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import todoapp.composeapp.generated.resources.Res
import todoapp.composeapp.generated.resources.rocket_logo

@Composable
fun Home () {
    Column(modifier = Modifier
        .background(Color.Black)
        .fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.rocket_logo),
            contentDescription = null
        )
    }
}