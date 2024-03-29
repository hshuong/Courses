package codelab.compose.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import codelab.compose.courses.data.DataSource
import codelab.compose.courses.model.Topic
import codelab.compose.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
                        topicList = DataSource.topics,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
                }
            }
        }
    }
}

@Composable
fun TopicCard(
    topic:Topic,
    modifier: Modifier = Modifier) {

    Card (modifier = modifier){
        Row {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceName),
                modifier = Modifier
                    .size(68.dp),
//                modifier = modifier
//                    .height(68.dp)
//                    .width(68.dp).aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Column(
                horizontalAlignment = Alignment.Start,
                ) {
                Text(
                    text = LocalContext.current.getString(topic.stringResourceName),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                            bottom= dimensionResource(R.dimen.padding_small))
                )
                Row (
                    verticalAlignment = Alignment.Top
                ){
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.padding_medium))
                    )
                    Text(
                        text = topic.number.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TopicCardPreview(){
    TopicCard(topic = Topic(R.string.photography, 58, R.drawable.photography ))
}

@Composable
fun TopicGrid(topicList: List<Topic>, modifier: Modifier = Modifier) {
    //LazyColumn(modifier = modifier) {
    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ){
        items(topicList) {
            TopicCard(
                topic = it,
                //modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TopicGridPreview(){
    CoursesTheme {
        TopicGrid(topicList = DataSource.topics)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CoursesTheme {
//        Greeting("Android")
//    }
//}