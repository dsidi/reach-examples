package com.yourorg

import edu.arizona.sista.reach.ReachSystem
import edu.arizona.sista.reach.mentions.BioMention
import scala.collection.JavaConverters._
import java.util.{List => JList}

/**
  * Created by dsidi on 1/1/16.
  */
class SimpleREACH extends ReachSystem {
  def extractFrom(text: String): JList[BioMention] = {
    extractFrom(text, "py4J", "").asJava
  }
}
