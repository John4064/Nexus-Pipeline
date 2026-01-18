package com.code_catalyst.scraper.logic

import com.code_catalyst.scraper.constants.Constants
import jakarta.annotation.PostConstruct
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.io.IOException
import kotlin.system.exitProcess

@Service
class uggscrape {
    //Todo: Set default format of loggerfactory in app
    val logger: Logger = LoggerFactory.getLogger(uggscrape::class.java)
    val agents: ArrayList<String> = Constants.userAgents;
    val baseUrl: String ="";

    @Async
    @PostConstruct
    @Throws(IOException::class)
    fun init() {
        //Todo: Setup Jsoup for op.gg
        logger.info("Initializing U.GG Data")
        grabTier()
    }

    fun grabTier(){

//        val url = "https://medium.com/codex/run-shell-commands-from-a-kotlin-script-or-application-with-ease-e5764a6c7cff"
//        val doc = Ksoup.connect(url).get()
        val url = "https://u.gg/lol/adc-tier-list"
        val doc: Document = Jsoup.connect(url)
            .userAgent("Mozilla")
            .timeout(5000)
            .cookie("someCookie", "someValue")
            .userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36")
            .referrer("http://google.com")
            .header("someHeader", "blabla")
            .get()
        val test=doc.getElementsByClass("rt-tbody")
        println(test)//Body

        val bodies = doc.body()
//        println(bodies.children())
        val table: Elements = doc.getElementsByTag("rt-tbody");
        println(table)
        println(table.text())

        //css-f65xnu egex0vq1
//        val sections: Elements = doc.getElementsByTag("main")
//        val table = sections.select("table")[0]
//        println(table.select("tr").size);
//        val rows =  table.select("tr");
//        rows.forEach{ row ->
//            val cols=row.select("td")
//            cols.forEach{
////                if(it.select("abc")!=null){
////                    print("TRIGGERED")
////                }
//                print(it.text())
//                print(".")
//            }
//            println()
//        }
//        firstSection!!.children().forEach{ tr -> println(tr) }
    }
}