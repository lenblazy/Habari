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
- Dagger Hilt(Dependency Injection)
- RecyclerView with DiffUtil
- Kotlin Coroutines(Background processing)
- Kotlin Flows
- Kotlin Jetpack Libraries
- Secure keys securely
- Unit Testing
  - [JUnit](https://developer.android.com/training/testing/local-tests)
  - [Truth](https://truth.dev/)
  - [Mockito](https://developer.android.com/training/testing/local-tests)
  - [MockWebserver](https://github.com/square/okhttp/tree/master/mockwebserver)
