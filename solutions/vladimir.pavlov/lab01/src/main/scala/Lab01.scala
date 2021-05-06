import scala.io.Source
import com.fasterxml.jackson.databind.ObjectMapper


object Lab01 {
  def main(args: Array[String]) = {
    val histResults = new HistResults();
    val objectMapper = new ObjectMapper();

    Source.fromInputStream(getClass.getResourceAsStream("u.data"))
      .getLines().map(oi => oi.split("\\t")(2).toInt)
      .seq.foreach(a => histResults.getHistAll()(a - 1) += 1)

    Source.fromInputStream(getClass.getResourceAsStream("u.data"))
      .getLines().filter(oi => oi.split("\\t")(1).toInt == 195)
      .map(oi => oi.split("\\t")(2).toInt)
      .seq.foreach(a => histResults.getHistFilm()(a - 1) += 1)

    print(objectMapper.writeValueAsString(histResults));
  }
}
