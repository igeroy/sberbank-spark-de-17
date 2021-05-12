import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.lang3.StringUtils

import scala.io.Source


object Lab01 {
  def main(args: Array[String]) = {
    val histResults = new HistResults();
    val objectMapper = new ObjectMapper();

    if (args.length > 0 && !StringUtils.isEmpty(args(0))) {
      val source = Source.fromFile(args(0))
      source.getLines().map(oi => (oi.split("\\t")(1).toInt, oi.split("\\t")(2).toInt))
        .seq.foreach(a => {
        if (a._1 == 195)
          histResults.getHistFilm()(a._2 - 1) += 1
        histResults.getHistAll()(a._2 - 1) += 1
      })
      source.close()
    }

    print(objectMapper.writeValueAsString(histResults));
  }
}
