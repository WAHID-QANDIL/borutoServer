package com.wahid

import com.wahid.di.koinModule
import com.wahid.modle.ApiResponse
import com.wahid.modle.Hero
import com.wahid.repository.HeroRepository
import com.wahid.repository.NEXT_PAGE_NUMBER
import com.wahid.repository.PREVIOUS_PAGE_NUMBER
import com.wahid.routes.BASE_URL
import com.wahid.routes.HEROES_URL
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import org.junit.Test
import org.koin.dsl.koinApplication
import kotlin.test.assertEquals

class ApplicationTest  {


    private val heroRepository: HeroRepository by lazy {
        koinApplication {
            modules(koinModule)
        }.koin.get<HeroRepository>()
    }

    @Test
    fun `access root endpoint, assert correct information`() {
        testApplication {
            application {
                module()
            }
            val response = client.get(BASE_URL)

            assertEquals(HttpStatusCode.OK, response.status)
            assertEquals("Welcome to Boruto API!", response.bodyAsText())
        }
    }

    @Test
    fun `access all end points, assert correct information`() {
        testApplication {
            application {
                module()
            }

            val pagesRange = 1..5
            val pages = buildList<List<Hero>> {
                heroRepository.heroes.values.forEach { add(it) }
            }

            pagesRange.forEach { page ->
                val response = client.get("$HEROES_URL?page=$page")
                assertEquals<HttpStatusCode>(
                    expected = HttpStatusCode.OK,
                    actual = response.status
                )
                //Calculate the prevPage number and nextPage number
                fun calculatePageNumber(pageNumber: Int):Map<String,Int?>
                {
                    var prevPage:Int? = pageNumber
                    var nextPage:Int? = pageNumber

                    if (pageNumber in 1 .. 4){
                        nextPage = nextPage?.plus(1)
                    }
                    if (pageNumber in 2..5){
                        prevPage = prevPage?.minus(1)
                    }

                    if (pageNumber == 1)
                        prevPage = null

                    if (pageNumber == 5)
                    {
                        nextPage = null
                    }


                    return mapOf(PREVIOUS_PAGE_NUMBER to prevPage, NEXT_PAGE_NUMBER to nextPage)
                }

                val expectedResponse = ApiResponse(
                    success = true,
                    message = HttpStatusCode.OK.toString(),
                    heroes = pages[page -1],
                    nextPage = calculatePageNumber(page)[NEXT_PAGE_NUMBER] ,
                    prevPage = calculatePageNumber(page)[PREVIOUS_PAGE_NUMBER]
                )


                val actual = Json.decodeFromString<ApiResponse>(response.bodyAsText())

                assertEquals<ApiResponse>(
                    expected = expectedResponse,
                    actual = actual
                )


            }


        }


    }


}