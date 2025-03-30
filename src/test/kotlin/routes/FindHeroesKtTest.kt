package routes

import com.wahid.module
import com.wahid.repository.HeroRepository
import com.wahid.repository.HeroRepositoryImpl
import io.ktor.client.request.*
import io.ktor.server.testing.*
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.Test

class FindHeroesKtTest {
    val heroesRepository: HeroRepository by inject<HeroRepository>(HeroRepositoryImpl::class.java)

    @Test
    fun testGetBorutoHeroesSearch() = testApplication {
        application {
            module()
        }

        client.get("/ boruto/heroes/search").apply {

        }
    }
}