package com.helder.mysoothe

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.helder.mysoothe.ui.theme.MySootheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                        MyAppPortraitOrientation()
                    } else {
                        MyAppLandscapeOrientation()
                    }
                }
            }
        }
    }
}

@Composable
fun MyAppPortraitOrientation() {
    Scaffold(
        topBar = {},
        bottomBar = {
            BottomAppBar {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NavigationBarContent()
                }
            }
        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            TextField(
                value = "",
                onValueChange = {},
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                        Text(
                            text = "Search",
                            modifier = Modifier.padding(
                                start = 8.dp,
                                top = 0.dp,
                                end = 0.dp,
                                bottom = 0.dp
                            )
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            CategoryList()
            FavoriteCollections()
        }
    }
}

@Composable
fun MyAppLandscapeOrientation() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(16.dp)
        ) {
            NavigationBarContent()
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            TextField(
                value = "",
                onValueChange = {},
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                        Text(
                            text = "Search",
                            modifier = Modifier.padding(
                                start = 8.dp,
                                top = 0.dp,
                                end = 0.dp,
                                bottom = 0.dp
                            )
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            CategoryList()
            FavoriteCollections()
        }
    }
}

@Composable
fun NavigationBarContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(
            horizontal = 0.dp, vertical = 4.dp
        )
    ) {
        Icon(
            imageVector = Icons.Default.Spa,
            contentDescription = stringResource(R.string.home_icon),
            modifier = Modifier.padding(
                start = 0.dp,
                top = 0.dp,
                end = 0.dp,
                bottom = 4.dp
            )
        )
        Text(
            text = stringResource(R.string.home),
            style = MaterialTheme.typography.bodySmall
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(
                horizontal = 0.dp, vertical = 4.dp
    )
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = stringResource(R.string.home_icon),
            modifier = Modifier.padding(
                start = 0.dp,
                top = 0.dp,
                end = 0.dp,
                bottom = 4.dp
            )
        )
        Text(
            text = stringResource(R.string.profile),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun BodyAlignmentCategory(resource: Int, category: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = resource),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
                .clip(CircleShape)
        )
        Text(text = category)
    }
}

@Composable
fun CategoryList() {
    Column {
        Text(
            text = stringResource(R.string.categories_title),
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 16.dp
            )
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
        ) {
            BodyAlignmentCategory(
                resource = R.drawable.ab1_inversions,
                stringResource(R.string.inversions)
            )
            BodyAlignmentCategory(
                resource = R.drawable.ab2_quick_yoga,
                stringResource(R.string.quick_yoga)
            )
            BodyAlignmentCategory(
                resource = R.drawable.ab3_stretching,
                stringResource(R.string.stretching)
            )
            BodyAlignmentCategory(
                resource = R.drawable.ab4_tabata,
                stringResource(R.string.tabata)
            )
            BodyAlignmentCategory(
                resource = R.drawable.ab5_hiit,
                stringResource(R.string.hiit)
            )
            BodyAlignmentCategory(
                resource = R.drawable.ab6_pre_natal_yoga,
                stringResource(R.string.pre_natal_yoga)
            )
        }
    }
}

@Composable
fun FavoriteCollections() {
    Column {
        Text(
            text = stringResource(R.string.favorite_collections_title),
            modifier = Modifier.padding(
                start = 12.dp,
                top = 32.dp,
                end = 0.dp,
                bottom = 16.dp
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            Column {
                ExerciseCollection(
                    resource = R.drawable.fc1_short_mantras,
                    title = stringResource(R.string.short_mantras)
                )
                ExerciseCollection(
                    resource = R.drawable.fc2_nature_meditations,
                    title = stringResource(R.string.nature_meditations)
                )
            }
            Column {
                ExerciseCollection(
                    resource = R.drawable.fc3_stress_and_anxiety,
                    title = stringResource(R.string.stress_and_anxiety)
                )
                ExerciseCollection(
                    resource = R.drawable.fc4_self_massage,
                    title = stringResource(R.string.self_and_massage)
                )

            }
            Column {
                ExerciseCollection(
                    resource = R.drawable.fc5_overwhelmed,
                    title = stringResource(R.string.overwhelmed)
                )
                ExerciseCollection(
                    resource = R.drawable.fc6_nightly_wind_down,
                    title = stringResource(R.string.nightly_wind_down)
                )
            }
        }
    }
}

@Composable
fun ExerciseCollection(resource: Int, title: String) {
    Card(
        modifier = Modifier
            .size(width = 280.dp, height = 80.dp)
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = resource),
                contentDescription = "",
                modifier = Modifier.width(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                modifier = Modifier.padding(
                    start = 12.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = 0.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MySootheTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyAppPortraitOrientation()
        }
    }
}