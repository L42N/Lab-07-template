object csv_persistence {
  def getLecturers(path: String): List[Lecturer] = {
    val rows = file2Rows(path)
    rows.map((rest) => {
      Lecturer(rest("id"), rest("name"), rest("age"), rest("module"),
        rest("status"), rest("wage"), rest("gender"))
    })
  }

  private def file2Rows(path: String): List[Map[String, String]] = {
    var ddbb: List[Map[String, String]] = Nil
    import scala.io.Source
    Source.fromFile(path).getLines().foreach(line => {
      val words = line.split(",")
      ddbb = Map(
        "id" -> words(0),
        "name" -> words(1),
        "age" -> words(2),
        "module" -> words(3),
        "status" -> words(4),
        "wage" -> words(5),
        "gender" -> words(6)) :: ddbb
    })
    ddbb
  }

}
