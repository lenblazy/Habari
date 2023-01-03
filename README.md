# Habari
An Android Application that can be used to as a news application. The data is made freely available through the [NewsAPI](https://newsapi.org/)

## Use cases
- View News Headlines
- Search News Topics
- Read full news articles
- Save News articles to read offline
- Delete News articles previouslt saved

## How it's built
- MVVM Architecture
- Retrofit(Remote data source)
- Room(Local data source)
- [GSON](https://github.com/google/gson)
- Dagger Hilt(Dependency Injection)
- RecyclerView with DiffUtil
- [Secrets Gradle Plugin](https://developers.google.com/maps/documentation/places/android-sdk/secrets-gradle-plugin)
- [Kotlin Coroutines/Flow](https://github.com/Kotlin/kotlinx.coroutines)
- Kotlin Flows
- Kotlin Jetpack Libraries
- Secure keys securely
- Unit Testing
  - [JUnit](https://developer.android.com/training/testing/local-tests)
  - [Truth](https://truth.dev/)
  - [Mockito](https://developer.android.com/training/testing/local-tests)
  - [MockWebserver](https://github.com/square/okhttp/tree/master/mockwebserver)

## Boiler-plate code
- API Resource class [here](https://github.com/lenblazy/Habari/blob/main/app/src/main/java/com/lenibonje/habari/data/util/Resource.kt)
