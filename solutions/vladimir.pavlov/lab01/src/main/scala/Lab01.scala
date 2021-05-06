import com.fasterxml.jackson.databind.ObjectMapper

import scala.io.Source


object Lab01 {
  def main(args: Array[String]) = {
    val histResults = new HistResults();
    val objectMapper = new ObjectMapper();

    val source = Source.fromInputStream(getClass.getResourceAsStream("u.data"))
    source.getLines().map(oi => (oi.split("\\t")(1).toInt, oi.split("\\t")(2).toInt))
      .seq.foreach(a => {
      if (a._1 == 195)
        histResults.getHistFilm()(a._2 - 1) += 1
      histResults.getHistAll()(a._2 - 1) += 1
    })
    source.close()

    print(objectMapper.writeValueAsString(histResults));
  }
}
