package com.code_catalyst.scraper.logic

import com.code_catalyst.scraper.constants.Constants
import jakarta.annotation.PostConstruct
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.io.IOException
import kotlin.system.exitProcess
import okhttp3.*
import Mos


@Service
class opscrape {
    //Todo: Set default format of loggerfactory in app
    val logger: Logger = LoggerFactory.getLogger(opscrape::class.java)
    val agents: ArrayList<String> = Constants.userAgents;
    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().build()
    private val gistJsonAdapter = moshi.adapter(Gist::class.java)

    @Async
    @PostConstruct
    @Throws(IOException::class)
    fun init() {
        //Todo: Setup Jsoup for op.gg
        logger.info("Initializing OP.GG Data")
        grabTier()
    }

    fun grabTier(){

        val request = Request.Builder()
            .url("https://www.op.gg/_next/data/92TuoJsGVvehR5ixQsRo6/en_US/summoners/na/Tidal-RCS.json?region=na&summoner=Tidal-RCS")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            for ((name, value) in response.headers) {
                println("$name: $value")
            }

            println(response.body!!.string())
        }



//        val url = "https://medium.com/codex/run-shell-commands-from-a-kotlin-script-or-application-with-ease-e5764a6c7cff"

//        val url = "https://www.op.gg/champions?position=adc"
//        val doc = Jsoup.connect(url)
//            .userAgent("Mozilla")
//            .timeout(5000)
//            .cookie("someCookie", "someValue")
//            .userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36")
//            .referrer("http://google.com")
//            .header("someHeader", "blabla")
//            .get()







//        firstSection!!.children().forEach{ tr -> println(tr) }
        exitProcess(0);

    }
}