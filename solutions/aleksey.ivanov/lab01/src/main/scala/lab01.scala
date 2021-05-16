
import java.io._

object ReadData
{
  def main(args: Array[String]): Unit =
  {

    val MyID: Int = 172
    val pathWork = "C:\\Users\\nakay\\IdeaProjects\\lab01\\source\\"

    var list1: List[Int] = List()
    var list2: List[Int] = List()
    var list3: List[Int] = List()
    var list4: List[Int] = List()
    var list5: List[Int] = List()
    var mark: Int = 0
    var ID: Int = 0
    var result : String = "{\n   \"hist_film\": ["

    //заполнение списков идентификаторами данными из файла
    val dataFile = io.Source.fromFile(pathWork + "u.data")
    dataFile.getLines.filter(f => f.trim.nonEmpty).foreach(line =>
    {
      ID = line.split("\\t")(1).toInt
      mark = line.split("\\t")(2).toInt

      mark match
      {
        case 1 => list1 = list1 :+ ID
        case 2 => list2 = list2 :+ ID
        case 3 => list3 = list3 :+ ID
        case 4 => list4 = list4 :+ ID
        case 5 => list5 = list5 :+ ID
      }
    }
    )
    dataFile.close()

    //накопление результат
    result = result + "\n      " + list1.count(x => x == MyID).toString + ","
    result = result + "\n      " + list2.count(x => x == MyID).toString + ","
    result = result + "\n      " + list3.count(x => x == MyID).toString + ","
    result = result + "\n      " + list4.count(x => x == MyID).toString + ","
    result = result + "\n      " + list5.count(x => x == MyID).toString
    result = result + "\n   ],\n  \"hist_all\": ["
    result = result + "\n      " + list1.count(x => x > 0).toString + ","
    result = result + "\n      " + list2.count(x => x > 0).toString + ","
    result = result + "\n      " + list3.count(x => x > 0).toString + ","
    result = result + "\n      " + list4.count(x => x > 0).toString + ","
    result = result + "\n      " + list5.count(x => x > 0).toString
    result = result + "\n   ]\n}"

    //сохранение результата
    val rfile = new File(pathWork + "lab01.json")

    if (rfile.exists())
      rfile.delete()

    val writer = new PrintWriter(rfile)
    writer.write(result)
    writer.close()
  }
}
